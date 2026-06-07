export type Einsatzbericht = { slug: string; datum: string; einsatzart: string; ortsteil: string; kurzbeschreibung: string; einheiten: string[]; datenschutzHinweis: string; };
export const einsatzberichte: Einsatzbericht[] = [
  { slug: 'beispiel-freigabeprozess', datum: '2026-01-01', einsatzart: 'Beispiel für einen freigegebenen Bericht', ortsteil: 'Ortsteil nach Freigabe', kurzbeschreibung: 'Diese Karte zeigt die spätere Struktur. Reale Einsatzberichte erscheinen erst nach Prüfung und enthalten nur die Informationen, die sicher veröffentlicht werden können.', einheiten: ['Schutzbereich nach Freigabe'], datenschutzHinweis: 'Keine Namen, keine Kennzeichen, keine Live-Informationen und keine taktisch sensiblen Details.' }
];
