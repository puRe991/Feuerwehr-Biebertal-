export type Einsatzbericht = { slug: string; datum: string; einsatzart: string; ortsteil: string; kurzbeschreibung: string; einheiten: string[]; datenschutzHinweis: string; };
export const einsatzberichte: Einsatzbericht[] = [
  { slug: 'platzhalter-freigabeprozess', datum: '2026-01-01', einsatzart: 'Beispielstruktur', ortsteil: 'grober Ortsteil', kurzbeschreibung: 'Platzhalter zur Darstellung der Struktur. Reale Berichte werden erst nach interner Freigabe veröffentlicht.', einheiten: ['Schutzbereich nach Freigabe'], datenschutzHinweis: 'Keine personenbezogenen Daten, keine Kennzeichen, keine Live-Informationen.' }
];
