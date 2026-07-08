package de.feuerwehrbiebertal.app.data

data class Einsatzbericht(
    val slug: String,
    val datum: String,
    val einsatzart: String,
    val ortsteil: String,
    val kurzbeschreibung: String,
    val einheiten: List<String>,
    val datenschutzHinweis: String
)

// Die Feuerwehr Biebertal veröffentlicht selbst keine Einsatzberichte, solange keine interne
// Freigabe vorliegt. Die folgenden Einträge fassen ausschließlich bereits öffentlich in der
// Lokalpresse berichtete Einsätze zusammen – bewusst ohne Namen, Kennzeichen oder sonstige
// personenbezogene Angaben zu Beteiligten.
val einsatzberichte = listOf(
    Einsatzbericht(
        slug = "verkehrsunfall-l3047-2026",
        datum = "2026-05-03",
        einsatzart = "Schwerer Verkehrsunfall mit Personenschaden",
        ortsteil = "Fellingshausen",
        kurzbeschreibung = "Auf der L3047 zwischen Fellingshausen und Krofdorf-Gleiberg kollidierten am frühen Abend mehrere Fahrzeuge; ein Motorradfahrer verunglückte tödlich. Die Schutzbereiche Nord und Mitte waren mit rund 40 Einsatzkräften und 8 Fahrzeugen im Einsatz, unterstützt von Rettungsdienst, Notarzt und dem Rettungshubschrauber Christoph Gießen. Die Landstraße war für die Unfallaufnahme mehrere Stunden vollständig gesperrt.",
        einheiten = listOf("Schutzbereich Nord", "Schutzbereich Mitte", "Rettungsdienst", "Notarzt", "Rettungshubschrauber Christoph Gießen"),
        datenschutzHinweis = "Zusammengefasst nach der öffentlichen Berichterstattung der Vogelsberger Zeitung vom 3. Mai 2026. Namen und weitere personenbezogene Angaben zu Beteiligten werden hier bewusst nicht genannt."
    ),
    Einsatzbericht(
        slug = "grossbrand-frankenbach-2022",
        datum = "2022-04-10",
        einsatzart = "Großbrand (Gebäudebrand)",
        ortsteil = "Frankenbach",
        kurzbeschreibung = "In der Kirchstraße brannte ein Gehöft vollständig aus. Das Feuer ging vermutlich von einer Holzheizung im rückwärtigen Stallgebäude aus und griff auf den Dachstuhl des angrenzenden Wohnhauses über. Rund 80 Einsatzkräfte aus allen drei Schutzbereichen sowie Nachbarwehren und der Berufsfeuerwehr Gießen waren bis in den späten Abend im Einsatz. Verletzt wurde niemand, vier Bewohner mussten vorübergehend anderweitig untergebracht werden. Der Sachschaden wurde auf rund 120.000 Euro geschätzt.",
        einheiten = listOf("Schutzbereich Mitte", "Schutzbereich Nord", "Schutzbereich West", "Feuerwehr Wettenberg", "Berufsfeuerwehr Gießen", "Drehleitern Buseck und Heuchelheim", "DRK-Versorgungseinheit"),
        datenschutzHinweis = "Zusammengefasst nach der öffentlichen Berichterstattung des Gießener Anzeigers vom 11. April 2022. Namen und weitere personenbezogene Angaben zu Beteiligten werden hier bewusst nicht genannt."
    )
)
