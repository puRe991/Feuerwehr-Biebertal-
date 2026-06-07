export type NewsItem = { slug: string; titel: string; kategorie: 'Veranstaltung' | 'Presse' | 'Hinweis'; datum: string; teaser: string; };
export const news: NewsItem[] = [
  { slug: 'mitglied-werden', titel: 'Mitmachen bei der Feuerwehr Biebertal', kategorie: 'Hinweis', datum: '2026-01-10', teaser: 'Du brauchst kein Vorwissen. Interesse, Teamgeist und Verlässlichkeit reichen für den Einstieg.' },
  { slug: 'jugendfeuerwehr-info', titel: 'Kinder- und Jugendfeuerwehr kennenlernen', kategorie: 'Veranstaltung', datum: '2026-02-15', teaser: 'Für Kinder und Jugendliche bietet die Feuerwehr altersgerechte Technik, Gemeinschaft und Verantwortung.' },
  { slug: 'datenschutz-einsatzberichte', titel: 'So veröffentlichen wir Einsatzberichte', kategorie: 'Presse', datum: '2026-03-01', teaser: 'Einsatzberichte erscheinen nur nach Freigabe, ohne personenbezogene oder taktisch sensible Details.' }
];
