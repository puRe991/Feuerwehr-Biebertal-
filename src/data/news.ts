export type NewsItem = { slug: string; titel: string; kategorie: 'Veranstaltung' | 'Presse' | 'Hinweis'; datum: string; teaser: string; };
export const news: NewsItem[] = [
  { slug: 'mitglied-werden', titel: 'Dein Platz bei der Feuerwehr', kategorie: 'Hinweis', datum: '2026-01-10', teaser: 'Du willst helfen, hast aber keine Vorerfahrung? Genau so starten viele. Wir zeigen dir den Einstieg Schritt für Schritt.' },
  { slug: 'jugendfeuerwehr-info', titel: 'Feuerwehr für Kinder und Jugendliche', kategorie: 'Veranstaltung', datum: '2026-02-15', teaser: 'Technik entdecken, Teamgeist erleben und Verantwortung lernen – altersgerecht in Kinder- und Jugendfeuerwehr.' },
  { slug: 'datenschutz-einsatzberichte', titel: 'So berichten wir über Einsätze', kategorie: 'Presse', datum: '2026-03-01', teaser: 'Wir informieren erst nach Freigabe und ohne Daten, die Betroffene, Angehörige oder Einsatzkräfte gefährden können.' }
];
