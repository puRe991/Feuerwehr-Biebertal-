package de.feuerwehrbiebertal.app.data

data class Fahrzeug(
    val slug: String,
    val kurzname: String,
    val standort: String,
    val typ: String,
    val einsatzzweck: String,
    val besonderheiten: List<String>,
    val bildAlt: String
)

// Fahrzeugtypen und Zuordnung zu Schutzbereichen laut feuerwehr-biebertal.de.
// Die Feuerwehr Biebertal betreibt insgesamt 16 Fahrzeuge und Anhänger an den
// Standorten Frankenbach, Krumbach und Rodheim.
val fahrzeuge = listOf(
    Fahrzeug(
        slug = "elw-1",
        kurzname = "ELW 1",
        standort = "Gemeindeweit",
        typ = "Einsatzleitwagen",
        einsatzzweck = "Führungsunterstützung für die Einsatzleitung bei größeren Lagen",
        besonderheiten = listOf("Funk- und Kartenausstattung", "Führungsstelle vor Ort"),
        bildAlt = "Einsatzleitwagen der Feuerwehr Biebertal"
    ),
    Fahrzeug(
        slug = "hlf-20",
        kurzname = "HLF 20",
        standort = "Schutzbereich Mitte",
        typ = "Hilfeleistungslöschgruppenfahrzeug",
        einsatzzweck = "Brandbekämpfung und technische Hilfeleistung",
        besonderheiten = listOf("Wasserführend", "Technische Hilfeleistung", "Atemschutz"),
        bildAlt = "Hilfeleistungslöschgruppenfahrzeug der Feuerwehr Biebertal"
    ),
    Fahrzeug(
        slug = "stlf-20",
        kurzname = "StLF 20",
        standort = "Schutzbereich Nord",
        typ = "Staffellöschfahrzeug",
        einsatzzweck = "Brandbekämpfung mit Staffelbesatzung",
        besonderheiten = listOf("Wasserführend", "Kompakte Staffelbesatzung"),
        bildAlt = "Staffellöschfahrzeug der Feuerwehr Biebertal"
    ),
    Fahrzeug(
        slug = "mlf",
        kurzname = "MLF",
        standort = "Schutzbereich Mitte",
        typ = "Mittleres Löschfahrzeug",
        einsatzzweck = "Brandbekämpfung und Unterstützung im Schutzbereich",
        besonderheiten = listOf("Löschwasser", "Atemschutz", "Flexible Beladung"),
        bildAlt = "Mittleres Löschfahrzeug der Feuerwehr Biebertal"
    ),
    Fahrzeug(
        slug = "tsf-w",
        kurzname = "TSF-W",
        standort = "Schutzbereich West",
        typ = "Tragkraftspritzenfahrzeug-Wasser",
        einsatzzweck = "Erstmaßnahmen bei Bränden und kleineren Hilfeleistungen",
        besonderheiten = listOf("Kompakt", "Wasserführend", "Ortsnah einsetzbar"),
        bildAlt = "Tragkraftspritzenfahrzeug der Feuerwehr Biebertal"
    ),
    Fahrzeug(
        slug = "lf-10-kats",
        kurzname = "LF 10 KatS",
        standort = "Schutzbereich Nord",
        typ = "Löschfahrzeug Katastrophenschutz",
        einsatzzweck = "Brandbekämpfung im Rahmen des Katastrophenschutzes",
        besonderheiten = listOf("Landeszuweisung Katastrophenschutz", "Wasserführend"),
        bildAlt = "Löschfahrzeug im Katastrophenschutz der Feuerwehr Biebertal"
    ),
    Fahrzeug(
        slug = "gw-l2",
        kurzname = "GW-L2",
        standort = "Gemeindeweit",
        typ = "Gerätewagen-Logistik",
        einsatzzweck = "Materialtransport und Versorgung bei größeren und länger andauernden Einsätzen",
        besonderheiten = listOf("Logistik", "Nachschub", "Ausbildung"),
        bildAlt = "Gerätewagen-Logistik der Feuerwehr Biebertal"
    ),
    Fahrzeug(
        slug = "gw-l-kats",
        kurzname = "GW-L KatS",
        standort = "Schutzbereich Nord",
        typ = "Gerätewagen-Logistik Katastrophenschutz",
        einsatzzweck = "Landesweiter Katastrophenschutz mit Modulen für Waldbrand- und Hochwassereinsätze",
        besonderheiten = listOf("Seit 2024 im Dienst", "Waldbrandmodul", "Hochwassermodul", "Landesförderung Hessen"),
        bildAlt = "Gerätewagen-Logistik für den Katastrophenschutz der Feuerwehr Biebertal"
    ),
    Fahrzeug(
        slug = "anhaenger-th",
        kurzname = "Anhänger TH",
        standort = "Schutzbereich West",
        typ = "Anhänger Technische Hilfeleistung",
        einsatzzweck = "Zusatzbeladung für technische Hilfeleistung",
        besonderheiten = listOf("Ergänzt TSF-W", "Technische Hilfeleistung"),
        bildAlt = "Anhänger für technische Hilfeleistung der Feuerwehr Biebertal"
    ),
    Fahrzeug(
        slug = "anhaenger-logistik",
        kurzname = "Anhänger Logistik",
        standort = "Schutzbereich West",
        typ = "Anhänger Logistik",
        einsatzzweck = "Materialtransport für den Schutzbereich West",
        besonderheiten = listOf("Logistik", "Ausbildung", "Jugendarbeit"),
        bildAlt = "Logistikanhänger der Feuerwehr Biebertal"
    ),
    Fahrzeug(
        slug = "drohne",
        kurzname = "DJI Drohne",
        standort = "Gemeindeweit",
        typ = "Unbemanntes Luftfahrzeug (UAV)",
        einsatzzweck = "Lageerkundung, Personensuche und Unterstützung der Einsatzleitung aus der Luft",
        besonderheiten = listOf("Erste drohnengestützte Feuerwehr im Landkreis Gießen", "Wärmebildkamera", "Lautsprecher", "Dauerleihgabe des Jagdvereins Biebertal"),
        bildAlt = "Einsatzdrohne der Feuerwehr Biebertal"
    )
)
