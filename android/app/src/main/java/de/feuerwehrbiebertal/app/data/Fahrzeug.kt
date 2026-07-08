package de.feuerwehrbiebertal.app.data

data class Fahrzeug(
    val slug: String,
    val funk: String,
    val standort: String,
    val typ: String,
    val einsatzzweck: String,
    val besatzung: String,
    val besonderheiten: List<String>,
    val bildAlt: String
)

val fahrzeuge = listOf(
    Fahrzeug(
        slug = "hlf-20-mitte",
        funk = "Florian Biebertal 1/46",
        standort = "Schutzbereich Mitte",
        typ = "Hilfeleistungslöschgruppenfahrzeug",
        einsatzzweck = "Brandbekämpfung und technische Hilfeleistung",
        besatzung = "Gruppe 1/8",
        besonderheiten = listOf("Wasserführend", "Technische Hilfeleistung", "Atemschutz"),
        bildAlt = "Hilfeleistungslöschgruppenfahrzeug der Feuerwehr Biebertal"
    ),
    Fahrzeug(
        slug = "tsf-w-nord",
        funk = "Florian Biebertal 2/48",
        standort = "Schutzbereich Nord",
        typ = "Tragkraftspritzenfahrzeug-Wasser",
        einsatzzweck = "Erstmaßnahmen bei Bränden und kleineren Hilfeleistungen",
        besatzung = "Staffel 1/5",
        besonderheiten = listOf("Kompakt", "Wasserführend", "Ortsnah einsetzbar"),
        bildAlt = "Tragkraftspritzenfahrzeug der Feuerwehr Biebertal"
    ),
    Fahrzeug(
        slug = "mlf-west",
        funk = "Florian Biebertal 3/40",
        standort = "Schutzbereich West",
        typ = "Mittleres Löschfahrzeug",
        einsatzzweck = "Brandbekämpfung und Unterstützung im Schutzbereich",
        besatzung = "Staffel 1/5",
        besonderheiten = listOf("Löschwasser", "Atemschutz", "Flexible Beladung"),
        bildAlt = "Mittleres Löschfahrzeug der Feuerwehr Biebertal"
    ),
    Fahrzeug(
        slug = "mtf-gemeinde",
        funk = "Florian Biebertal 1/19",
        standort = "Gemeindegebiet",
        typ = "Mannschaftstransportfahrzeug",
        einsatzzweck = "Transport von Einsatzkräften, Jugendfeuerwehr und Material",
        besatzung = "Trupp bis Gruppe",
        besonderheiten = listOf("Ausbildung", "Logistik", "Jugendarbeit"),
        bildAlt = "Mannschaftstransportfahrzeug der Feuerwehr Biebertal"
    )
)
