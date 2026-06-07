export type Schutzbereich = {
  slug: string;
  name: string;
  ortsteile: string[];
  feuerwehrhaus: string;
  beschreibung: string;
  ansprechpartner: string;
  fahrzeuge: string[];
  uebungszeiten: string;
};

export const schutzbereiche: Schutzbereich[] = [
  {
    slug: 'mitte',
    name: 'Mitte',
    ortsteile: ['Fellingshausen', 'Rodheim-Bieber', 'Vetzberg'],
    feuerwehrhaus: 'Feuerwehrhaus Schutzbereich Mitte',
    beschreibung: 'Mitte verbindet die zentralen Ortsteile und ist häufig schnell an den wichtigsten Verkehrswegen und Einrichtungen der Gemeinde. Hier trainieren Ehrenamtliche für Brände, technische Hilfe und Einsätze im Alltag.',
    ansprechpartner: 'Ansprechperson wird ergänzt',
    fahrzeuge: ['HLF 20', 'MTF', 'Anhänger Logistik'],
    uebungszeiten: 'Übungszeiten werden nach Freigabe ergänzt'
  },
  {
    slug: 'nord',
    name: 'Nord',
    ortsteile: ['Frankenbach', 'Krumbach'],
    feuerwehrhaus: 'Feuerwehrhaus Schutzbereich Nord',
    beschreibung: 'Nord sichert die nördlichen Ortsteile und bringt Ortskenntnis, kurze Wege und ein eingespieltes Team zusammen. Bei größeren Lagen arbeitet der Schutzbereich eng mit Mitte und West.',
    ansprechpartner: 'Ansprechperson wird ergänzt',
    fahrzeuge: ['TSF-W', 'MTF'],
    uebungszeiten: 'Übungszeiten werden nach Freigabe ergänzt'
  },
  {
    slug: 'west',
    name: 'West',
    ortsteile: ['Königsberg'],
    feuerwehrhaus: 'Feuerwehrhaus Schutzbereich West',
    beschreibung: 'West steht für Königsberg bereit und stärkt die Feuerwehr Biebertal mit guter Ortskenntnis und flexibler Unterstützung. Auch hier zählt: freiwillig helfen, regelmäßig üben, gemeinsam handeln.',
    ansprechpartner: 'Ansprechperson wird ergänzt',
    fahrzeuge: ['MLF', 'MTF'],
    uebungszeiten: 'Übungszeiten werden nach Freigabe ergänzt'
  }
];
