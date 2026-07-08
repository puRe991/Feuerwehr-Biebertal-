package de.feuerwehrbiebertal.app.data

data class Schutzbereich(
    val slug: String,
    val name: String,
    val ortsteile: List<String>,
    val feuerwehrhaus: String,
    val beschreibung: String,
    val ansprechpartner: String,
    val fahrzeuge: List<String>,
    val uebungszeiten: String
)

val schutzbereiche = listOf(
    Schutzbereich(
        slug = "mitte",
        name = "Mitte",
        ortsteile = listOf("Fellingshausen", "Rodheim-Bieber", "Vetzberg"),
        feuerwehrhaus = "Feuerwehrhaus Schutzbereich Mitte",
        beschreibung = "Mitte verbindet die zentralen Ortsteile und ist häufig schnell an den wichtigsten Verkehrswegen und Einrichtungen der Gemeinde. Hier trainieren Ehrenamtliche für Brände, technische Hilfe und Einsätze im Alltag.",
        ansprechpartner = "Kontakt über die Gemeindebrandinspektion",
        fahrzeuge = listOf("HLF 20", "MTF", "Anhänger Logistik"),
        uebungszeiten = "Termine auf Anfrage über die Kontaktseite"
    ),
    Schutzbereich(
        slug = "nord",
        name = "Nord",
        ortsteile = listOf("Frankenbach", "Krumbach"),
        feuerwehrhaus = "Feuerwehrhaus Schutzbereich Nord",
        beschreibung = "Nord sichert die nördlichen Ortsteile und bringt Ortskenntnis, kurze Wege und ein eingespieltes Team zusammen. Bei größeren Lagen arbeitet der Schutzbereich eng mit Mitte und West.",
        ansprechpartner = "Kontakt über die Gemeindebrandinspektion",
        fahrzeuge = listOf("TSF-W", "MTF"),
        uebungszeiten = "Termine auf Anfrage über die Kontaktseite"
    ),
    Schutzbereich(
        slug = "west",
        name = "West",
        ortsteile = listOf("Königsberg"),
        feuerwehrhaus = "Feuerwehrhaus Schutzbereich West",
        beschreibung = "West steht für Königsberg bereit und stärkt die Feuerwehr Biebertal mit guter Ortskenntnis und flexibler Unterstützung. Auch hier zählt: freiwillig helfen, regelmäßig üben, gemeinsam handeln.",
        ansprechpartner = "Kontakt über die Gemeindebrandinspektion",
        fahrzeuge = listOf("MLF", "MTF"),
        uebungszeiten = "Termine auf Anfrage über die Kontaktseite"
    )
)
