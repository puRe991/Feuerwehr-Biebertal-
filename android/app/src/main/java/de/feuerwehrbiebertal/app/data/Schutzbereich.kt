package de.feuerwehrbiebertal.app.data

data class Feuerwehrhaus(
    val ortsteil: String,
    val adresse: String
)

data class Schutzbereich(
    val slug: String,
    val name: String,
    val ortsteile: List<String>,
    val feuerwehrhaeuser: List<Feuerwehrhaus>,
    val beschreibung: String,
    val leiter: String,
    val stellvertreter: List<String>,
    val fahrzeuge: List<String>,
    val uebungszeiten: String
)

val schutzbereiche = listOf(
    Schutzbereich(
        slug = "mitte",
        name = "Mitte",
        ortsteile = listOf("Bieber", "Fellingshausen", "Rodheim", "Vetzberg"),
        feuerwehrhaeuser = listOf(
            Feuerwehrhaus("Fellingshausen", "Fellingshäuser Str. 68, 35444 Biebertal")
        ),
        beschreibung = "Schutzbereich Mitte verbindet die zentralen Ortsteile Bieber, Fellingshausen, Rodheim und Vetzberg. Hier trainieren Einsatz-, Jugend- und Kinderfeuerwehr für Brände, technische Hilfeleistung und Einsätze im Alltag – mit kurzen Wegen zu den wichtigsten Verkehrsachsen der Gemeinde.",
        leiter = "Marco Seitz",
        stellvertreter = listOf("Conrad Bender", "Stefan Holler"),
        fahrzeuge = listOf("HLF 20", "MLF", "GW-L2"),
        uebungszeiten = "Termine auf Anfrage über die Kontaktseite"
    ),
    Schutzbereich(
        slug = "nord",
        name = "Nord",
        ortsteile = listOf("Frankenbach", "Krumbach"),
        feuerwehrhaeuser = listOf(
            Feuerwehrhaus("Frankenbach", "Erdaer Str. 23, 35444 Biebertal"),
            Feuerwehrhaus("Krumbach", "Zum Wilsberg 5a, 35444 Biebertal")
        ),
        beschreibung = "Schutzbereich Nord sichert Frankenbach und Krumbach. Die Wehr Frankenbach ist eine der traditionsreichsten in Biebertal – 2023 feierte sie ihr 90-jähriges Bestehen als freiwillige Feuerwehr, gemeinsam mit Jugend- und Minifeuerwehr.",
        leiter = "Pascal Wahl",
        stellvertreter = listOf("Lukas Gerlach", "David Schad"),
        fahrzeuge = listOf("StLF 20", "LF 10 KatS", "GW-L KatS"),
        uebungszeiten = "Termine auf Anfrage über die Kontaktseite"
    ),
    Schutzbereich(
        slug = "west",
        name = "West",
        ortsteile = listOf("Königsberg"),
        feuerwehrhaeuser = listOf(
            Feuerwehrhaus("Königsberg", "Am Eckartsrot 3, 35444 Biebertal")
        ),
        beschreibung = "Schutzbereich West steht für Königsberg bereit und stärkt die Feuerwehr Biebertal mit guter Ortskenntnis und flexibler Unterstützung. Auch hier zählt: freiwillig helfen, regelmäßig üben, gemeinsam handeln.",
        leiter = "Matthias Justus",
        stellvertreter = listOf("Daniel Weil"),
        fahrzeuge = listOf("TSF-W", "Anhänger TH", "Anhänger Logistik"),
        uebungszeiten = "Termine auf Anfrage über die Kontaktseite"
    )
)
