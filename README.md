# Feuerwehr Biebertal – Website 2026

Modernes, statisches Astro-Projekt für die Freiwillige Feuerwehr Biebertal. Der Fokus liegt auf schneller Auslieferung, mobiler Nutzbarkeit, Barrierearmut, Datenschutz und einfacher Pflege über strukturierte Daten.

## Technik

- Astro mit TypeScript
- Tailwind CSS
- Statischer Build ohne Tracking-Skripte
- Systemschriften statt extern geladener Fonts
- Beispielinhalte in `src/data/*`

## Entwicklung

```bash
npm install
npm run dev
npm run build
```

## Inhalte pflegen

Beispieldaten liegen in:

- `src/data/schutzbereiche.ts`
- `src/data/fahrzeuge.ts`
- `src/data/news.ts`
- `src/data/einsatzberichte.ts`
- `src/data/ansprechpartner.ts`

Große Inhaltsbereiche liegen als Astro-Seiten in `src/pages`. Für ein späteres Headless CMS können die Datenmodule durch Markdown/MDX, Directus oder Strapi ersetzt werden.

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
