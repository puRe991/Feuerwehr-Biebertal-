package de.feuerwehrbiebertal.app.data

data class Ansprechpartner(
    val bereich: String,
    val name: String,
    val funktion: String,
    val kontakt: String
)

val ansprechpartner = listOf(
    Ansprechpartner(
        bereich = "Allgemein",
        name = "Marcel Hänsel",
        funktion = "Gemeindebrandinspektor",
        kontakt = "kontakt@feuerwehr-biebertal.de"
    ),
    Ansprechpartner(
        bereich = "Mitmachen",
        name = "Wird ergänzt",
        funktion = "Ansprechperson für neue Mitglieder",
        kontakt = "kontakt@feuerwehr-biebertal.de"
    ),
    Ansprechpartner(
        bereich = "Jugendfeuerwehr",
        name = "Christian Peschke",
        funktion = "Gemeindekinder- und Jugendfeuerwehrwart",
        kontakt = "jugend@feuerwehr-biebertal.de"
    )
)
