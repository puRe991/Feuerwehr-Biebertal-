export type Fahrzeug = {
  slug: string;
  funk: string;
  standort: string;
  typ: string;
  einsatzzweck: string;
  besatzung: string;
  besonderheiten: string[];
  bildAlt: string;
};

export const fahrzeuge: Fahrzeug[] = [
  { slug: 'hlf-20-mitte', funk: 'Florian Biebertal 1/46', standort: 'Schutzbereich Mitte', typ: 'Hilfeleistungslöschgruppenfahrzeug', einsatzzweck: 'Brandbekämpfung und technische Hilfeleistung', besatzung: 'Gruppe 1/8', besonderheiten: ['Wasserführend', 'Technische Hilfeleistung', 'Atemschutz'], bildAlt: 'Platzhalter für ein Hilfeleistungslöschgruppenfahrzeug' },
  { slug: 'tsf-w-nord', funk: 'Florian Biebertal 2/48', standort: 'Schutzbereich Nord', typ: 'Tragkraftspritzenfahrzeug-Wasser', einsatzzweck: 'Erstmaßnahmen bei Bränden und kleineren Hilfeleistungen', besatzung: 'Staffel 1/5', besonderheiten: ['Kompakt', 'Wasserführend', 'Ortsnah einsetzbar'], bildAlt: 'Platzhalter für ein Tragkraftspritzenfahrzeug' },
  { slug: 'mlf-west', funk: 'Florian Biebertal 3/40', standort: 'Schutzbereich West', typ: 'Mittleres Löschfahrzeug', einsatzzweck: 'Brandbekämpfung und Unterstützung im Schutzbereich', besatzung: 'Staffel 1/5', besonderheiten: ['Löschwasser', 'Atemschutz', 'Flexible Beladung'], bildAlt: 'Platzhalter für ein mittleres Löschfahrzeug' },
  { slug: 'mtf-gemeinde', funk: 'Florian Biebertal 1/19', standort: 'Gemeindegebiet', typ: 'Mannschaftstransportfahrzeug', einsatzzweck: 'Transport von Einsatzkräften, Jugendfeuerwehr und Material', besatzung: 'Trupp bis Gruppe', besonderheiten: ['Ausbildung', 'Logistik', 'Jugendarbeit'], bildAlt: 'Platzhalter für ein Mannschaftstransportfahrzeug' }
];
