# Feuerwehr Biebertal – Website 2026

Modernes, statisches Astro-Projekt für die Freiwillige Feuerwehr Biebertal. Der Fokus liegt auf schneller Auslieferung, mobiler Nutzbarkeit, Barrierearmut, Datenschutz und einfacher Pflege über strukturierte Daten.

## Technik

- Astro mit TypeScript
- Tailwind CSS
- Statischer Build ohne Tracking-Skripte
- Systemschriften statt extern geladener Fonts
- Directus als optionales Headless CMS für Meldungen und Einsatzberichte
- Beispielinhalte in `src/data/*` als robuste Fallbacks

## Entwicklung

```bash
npm install
npm run dev
npm run build
```

Lokales CMS zum Debuggen ohne Docker starten:

```bash
npm run cms:dev
```

Alternativ mit Docker starten, falls Docker Desktop installiert ist:

```bash
npm run cms:dev:docker
```

Der lokale Directus-Login ist danach unter `http://localhost:8055` erreichbar. Die vorkonfigurierten Debug-Zugangsdaten sind `admin@example.org` / `admin123456`. Diese Zugangsdaten sind nur für lokale Entwicklung gedacht und dürfen nicht produktiv verwendet werden.

## Directus CMS konfigurieren

Die Website liest beim Build Meldungen und Einsatzberichte aus Directus. Wenn Directus nicht konfiguriert ist, nicht erreichbar ist oder keine gültigen Datensätze liefert, nutzt der Build automatisch die lokalen Fallback-Daten aus `src/data/*`.

1. `.env.example` nach `.env` kopieren.
2. `PUBLIC_DIRECTUS_URL` auf die öffentliche Directus-URL setzen, z. B. `https://cms.example.org`. Im lokalen Dev-Modus nutzt die Website ohne gesetzte URL automatisch `http://localhost:8055`.
3. Optional `PUBLIC_CMS_ADMIN_URL` setzen, wenn der sichtbare CMS-Login auf eine separate Admin-Adresse zeigen soll. Wenn leer, nutzt die Website `PUBLIC_DIRECTUS_URL`.
4. Optional `DIRECTUS_TOKEN` setzen, wenn die Collections nicht öffentlich lesbar sind. Dieses Token darf nicht mit `PUBLIC_` beginnen.
5. Optional `ENABLE_DIRECTUS=false` setzen, um für lokale Tests ausschließlich Fallback-Daten zu verwenden.

Für lokales Debugging kann Directus mit `npm run cms:dev` ohne Docker unter `http://localhost:8055` laufen; dann funktionieren `/admin/` und `/admin/login/` auch ohne lokale `.env` als Weiterleitung zum lokalen CMS. Wenn `localhost:8055` die Verbindung ablehnt, läuft der separate Directus-Prozess noch nicht. Der Docker-Befehl `npm run cms:dev:docker` ist nur eine Alternative für Systeme mit installiertem Docker Desktop. Der öffentliche Website-Build enthält keinen eigenen Admin-Login. Navigationslinks zum CMS erscheinen nur, wenn eine gültige CMS-URL konfiguriert ist. `/admin/login/` dient als abgesicherte Weiterleitungs- und Hinweisseite für Redakteurinnen und Redakteure.

Erwartete Collections und Felder:

### Collection `news`

| Feld | Pflicht | Hinweis |
| --- | --- | --- |
| `slug` | ja | URL-tauglicher eindeutiger Bezeichner |
| `titel` oder `title` | ja | Überschrift |
| `kategorie` oder `category` | ja | `Veranstaltung`, `Presse` oder `Hinweis` |
| `datum` oder `date` | ja | Datum oder ISO-Zeitstempel |
| `teaser` | ja | Kurztext für Karten |
| `status` | empfohlen | Nur `published` wird geladen |

### Collection `einsatzberichte`

| Feld | Pflicht | Hinweis |
| --- | --- | --- |
| `slug` | ja | URL-tauglicher eindeutiger Bezeichner |
| `datum` oder `date` | ja | Datum oder ISO-Zeitstempel |
| `einsatzart` oder `incident_type` | ja | Öffentliche Einsatzart |
| `ortsteil` oder `district` | ja | Freigegebener Ortsbezug |
| `kurzbeschreibung` oder `summary` | ja | Datenschutzgeprüfte Zusammenfassung |
| `einheiten` oder `units` | nein | Array oder kommagetrennte Liste |
| `datenschutzHinweis` oder `privacy_notice` | ja | Hinweistext zur Veröffentlichung |
| `status` | empfohlen | Nur `published` wird geladen |

Wichtig: Einsatzberichte dürfen erst nach interner Freigabe veröffentlicht werden. Directus-Rollen sollten Schreibrechte eng begrenzen und öffentliche API-Zugriffe nur auf freigegebene Felder erlauben.

## Produktives Backend betreiben

Für den dauerhaften Betrieb auf einem eigenen VPS (Postgres statt SQLite, automatisches HTTPS, Backups) siehe [`deploy/DEPLOYMENT.md`](deploy/DEPLOYMENT.md). Die lokalen `cms:dev`-Befehle oben dienen ausschließlich der Entwicklung und sind nicht für den produktiven Einsatz gedacht.

## Inhalte pflegen

Primäre CMS-Inhalte liegen in Directus. Lokale Fallbacks und strukturierte Beispieldaten liegen in:

- `src/data/schutzbereiche.ts`
- `src/data/fahrzeuge.ts`
- `src/data/news.ts`
- `src/data/einsatzberichte.ts`
- `src/data/ansprechpartner.ts`

Große Inhaltsbereiche liegen weiterhin als Astro-Seiten in `src/pages`.

## Vor Veröffentlichung ersetzen oder prüfen

- Reale Fahrzeugbilder und technische Daten
- Offizielle Ansprechpartner und Funktionsbezeichnungen
- Impressum mit offiziellen Pflichtangaben
- Datenschutzerklärung juristisch prüfen
- Alt-Texte für alle realen Bilder
- Übungszeiten und Treffpunkte der Schutzbereiche
- Externe Links zu Instagram, Facebook und WhatsApp-Kanal

## Einsatzberichte

Einsatzberichte dürfen nicht live erscheinen. Veröffentlichungen müssen intern freigegeben werden und dürfen keine personenbezogenen Daten, Kennzeichen, taktisch sensiblen Details oder Rückschlüsse auf Betroffene enthalten.
