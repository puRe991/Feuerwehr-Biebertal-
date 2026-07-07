# Directus produktiv auf eigenem VPS betreiben

Diese Anleitung richtet das echte, dauerhaft erreichbare Backend ein, gegen das
die Website ihre Meldungen und Einsatzberichte laedt. Ohne dieses Setup laeuft
die Seite ausschliesslich mit den Beispieldaten aus `src/data/*`.

## Voraussetzungen

- Ein VPS (z. B. Hetzner, IONOS) mit Docker und Docker Compose installiert
- Eine Domain bzw. Subdomain fuer das CMS, z. B. `cms.feuerwehr-biebertal.de`
- DNS A-Record dieser Subdomain zeigt auf die IP-Adresse des Servers

## 1. Dateien auf den Server bringen

Den kompletten `deploy/`-Ordner auf den Server kopieren, z. B. nach
`/opt/feuerwehr-cms/`:

```bash
scp -r deploy/ user@server:/opt/feuerwehr-cms
ssh user@server
cd /opt/feuerwehr-cms
```

## 2. Secrets konfigurieren

```bash
cp env.production.example .env
openssl rand -hex 32   # einmal fuer DIRECTUS_KEY ausfuehren
openssl rand -hex 32   # einmal fuer DIRECTUS_SECRET ausfuehren
```

`.env` mit einem Editor oeffnen und alle Werte eintragen:
`CMS_DOMAIN`, `SITE_DOMAIN`, `DIRECTUS_KEY`, `DIRECTUS_SECRET`, `ADMIN_EMAIL`,
`ADMIN_PASSWORD`, `DB_PASSWORD`. Die Datei bleibt nur auf dem Server, nie ins
Git-Repository committen.

## 3. Starten

```bash
docker compose -f docker-compose.prod.yml up -d
```

Caddy holt beim ersten Start automatisch ein Let's-Encrypt-Zertifikat fuer
`CMS_DOMAIN` (DNS muss dafuer bereits propagiert sein). Nach ein bis zwei
Minuten ist Directus unter `https://<CMS_DOMAIN>` erreichbar.

## 4. Erstes Login und Absicherung

1. Unter `https://<CMS_DOMAIN>/admin` mit `ADMIN_EMAIL` / `ADMIN_PASSWORD`
   einloggen.
2. Sofort ein neues, starkes Passwort fuer den Admin-Account setzen.
3. Weitere Redakteurs-Accounts mit eingeschraenkten Rollen anlegen, statt den
   Admin-Zugang zu teilen.

## 5. Collections anlegen

Die Felder sind im Haupt-`README.md` unter "Directus CMS konfigurieren"
dokumentiert. Zwei Collections anlegen:

- `news` (Felder: `slug`, `titel`/`title`, `kategorie`/`category`,
  `datum`/`date`, `teaser`, `status`)
- `einsatzberichte` (Felder: `slug`, `datum`/`date`, `einsatzart`/
  `incident_type`, `ortsteil`/`district`, `kurzbeschreibung`/`summary`,
  `einheiten`/`units`, `datenschutzHinweis`/`privacy_notice`, `status`)

## 6. Oeffentlichen Lesezugriff einrichten

In Directus unter **Settings → Roles & Permissions → Public**:

- Fuer `news` und `einsatzberichte`: Read-Recht erteilen, aber mit Filter
  `status = published` einschraenken, damit unveroeffentlichte Entwuerfe nie
  oeffentlich abrufbar sind.
- Keine Schreib-, Lösch- oder Admin-Rechte fuer die Public-Rolle vergeben.
- Einsatzberichte duerfen laut interner Vorgabe ohnehin erst nach Freigabe auf
  `published` gesetzt werden.

## 7. Website mit dem produktiven Backend verbinden

Im Build-Environment der Website (bzw. in deren `.env`):

```
PUBLIC_DIRECTUS_URL=https://cms.feuerwehr-biebertal.de
```

`PUBLIC_CMS_ADMIN_URL` optional setzen, falls der Redakteurs-Login unter einer
anderen Adresse liegen soll. Danach einen neuen Build ausloesen, damit die
Seite echte Inhalte statt der Fallback-Daten laedt.

## 8. Backups

`backup-directus.sh` sichert Datenbank und Uploads als Zeitstempel-Archive.
Fuer taegliche automatische Backups per Cron:

```bash
crontab -e
# Taeglich um 3 Uhr:
0 3 * * * cd /opt/feuerwehr-cms && ./backup-directus.sh >> backup.log 2>&1
```

Backups regelmaessig extern sichern (z. B. per `rsync` auf einen anderen
Host), nicht nur lokal auf demselben Server.

## 9. Updates

```bash
docker compose -f docker-compose.prod.yml pull
docker compose -f docker-compose.prod.yml up -d
```

Vor groesseren Directus-Versionssprüngen die Release Notes pruefen und vorher
ein Backup ziehen.
