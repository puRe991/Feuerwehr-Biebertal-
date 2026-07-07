#!/usr/bin/env bash
set -euo pipefail

# Sichert die Directus-Datenbank und Uploads als Zeitstempel-Archiv.
# Aufruf im deploy/-Ordner: ./backup-directus.sh
# Fuer automatische Backups per Cronjob eintragen, z. B. taeglich um 3 Uhr:
#   0 3 * * * cd /pfad/zu/deploy && ./backup-directus.sh >> backup.log 2>&1

cd "$(dirname "$0")"

if [ -f .env ]; then
  set -a
  source .env
  set +a
fi

: "${DB_DATABASE:?DB_DATABASE fehlt in .env}"
: "${DB_USER:?DB_USER fehlt in .env}"

TIMESTAMP="$(date +%Y%m%d-%H%M%S)"
BACKUP_DIR="${BACKUP_DIR:-./backups}"
mkdir -p "$BACKUP_DIR"

COMPOSE_PROJECT="$(basename "$(pwd)")"

docker compose -f docker-compose.prod.yml exec -T postgres \
  pg_dump -U "$DB_USER" "$DB_DATABASE" | gzip > "$BACKUP_DIR/db-$TIMESTAMP.sql.gz"

docker run --rm \
  -v "${COMPOSE_PROJECT}_directus_uploads:/uploads:ro" \
  -v "$(pwd)/$BACKUP_DIR:/backup" \
  alpine tar czf "/backup/uploads-$TIMESTAMP.tar.gz" -C /uploads .

echo "Backup geschrieben: $BACKUP_DIR/db-$TIMESTAMP.sql.gz und uploads-$TIMESTAMP.tar.gz"
