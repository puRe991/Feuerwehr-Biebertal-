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
    beschreibung: 'Der Schutzbereich Mitte bündelt die Einheiten in den zentralen Ortsteilen und stellt einen wichtigen Teil der kommunalen Gefahrenabwehr.',
    ansprechpartner: 'Ansprechpartner wird ergänzt',
    fahrzeuge: ['HLF 20', 'MTF', 'Anhänger Logistik'],
    uebungszeiten: 'Übungszeiten werden ergänzt'
  },
  {
    slug: 'nord',
    name: 'Nord',
    ortsteile: ['Frankenbach', 'Krumbach'],
    feuerwehrhaus: 'Feuerwehrhaus Schutzbereich Nord',
    beschreibung: 'Der Schutzbereich Nord sichert die nördlichen Ortsteile und arbeitet eng mit den weiteren Schutzbereichen zusammen.',
    ansprechpartner: 'Ansprechpartner wird ergänzt',
    fahrzeuge: ['TSF-W', 'MTF'],
    uebungszeiten: 'Übungszeiten werden ergänzt'
  },
  {
    slug: 'west',
    name: 'West',
    ortsteile: ['Königsberg'],
    feuerwehrhaus: 'Feuerwehrhaus Schutzbereich West',
    beschreibung: 'Der Schutzbereich West ist für Königsberg zuständig und ergänzt die Einsatzstruktur in Biebertal.',
    ansprechpartner: 'Ansprechpartner wird ergänzt',
    fahrzeuge: ['MLF', 'MTF'],
    uebungszeiten: 'Übungszeiten werden ergänzt'
  }
];
