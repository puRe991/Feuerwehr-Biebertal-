import { mkdir } from 'node:fs/promises';
import net from 'node:net';
import path from 'node:path';
import { spawn } from 'node:child_process';

const root = process.cwd();
const host = '127.0.0.1';
const port = 8055;
const dataDir = path.join(root, '.directus');
const databaseDir = path.join(dataDir, 'database');
const uploadsDir = path.join(dataDir, 'uploads');
const databaseFile = path.join(databaseDir, 'data.db');

const env = {
  ...process.env,
  HOST: '0.0.0.0',
  PORT: String(port),
  PUBLIC_URL: `http://localhost:${port}`,
  SECRET: process.env.DIRECTUS_LOCAL_SECRET || 'local-debug-secret-change-before-production',
  ADMIN_EMAIL: process.env.DIRECTUS_LOCAL_ADMIN_EMAIL || 'admin@example.org',
  ADMIN_PASSWORD: process.env.DIRECTUS_LOCAL_ADMIN_PASSWORD || 'admin123456',
  DB_CLIENT: 'sqlite3',
  DB_FILENAME: databaseFile,
  STORAGE_LOCATIONS: 'local',
  STORAGE_LOCAL_DRIVER: 'local',
  STORAGE_LOCAL_ROOT: uploadsDir,
  WEBSOCKETS_ENABLED: 'true',
};

const npxBin = process.platform === 'win32' ? 'npx.cmd' : 'npx';
const directusArgs = ['--yes', 'directus@11'];

const isPortOpen = () =>
  new Promise((resolve) => {
    const socket = net.createConnection({ host, port });
    socket.once('connect', () => {
      socket.destroy();
      resolve(true);
    });
    socket.once('error', () => resolve(false));
    socket.setTimeout(750, () => {
      socket.destroy();
      resolve(false);
    });
  });

const run = (args, { allowFailure = false } = {}) =>
  new Promise((resolve, reject) => {
    const child = spawn(npxBin, [...directusArgs, ...args], {
      cwd: root,
      env,
      stdio: 'inherit',
    });

    child.once('error', reject);
    child.once('exit', (code) => {
      if (code === 0 || allowFailure) resolve(code ?? 0);
      else reject(new Error(`Directus command failed with exit code ${code}.`));
    });
  });

if (process.argv.includes('--check')) {
  console.log('Local Directus dev runner is configured.');
  console.log(`URL: http://localhost:${port}`);
  console.log(`Database: ${databaseFile}`);
  process.exit(0);
}

await mkdir(databaseDir, { recursive: true });
await mkdir(uploadsDir, { recursive: true });

if (await isPortOpen()) {
  console.log(`Directus scheint bereits unter http://localhost:${port} zu laufen.`);
  process.exit(0);
}

console.log('Starte lokales Directus CMS ohne Docker...');
console.log(`Login nach dem Start: http://localhost:${port}`);
console.log(`Debug-Zugang: ${env.ADMIN_EMAIL} / ${env.ADMIN_PASSWORD}`);
console.log('Hinweis: Beim ersten Start lädt npx Directus aus der npm Registry.');

await run(['bootstrap'], { allowFailure: true });
await run(['start']);
