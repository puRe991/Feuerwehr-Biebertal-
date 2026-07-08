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
        kontakt = "info@feuerwehr-biebertal.de"
    ),
    Ansprechpartner(
        bereich = "Allgemein",
        name = "Daniel Weil",
        funktion = "Stellvertretender Gemeindebrandinspektor",
        kontakt = "info@feuerwehr-biebertal.de"
    ),
    Ansprechpartner(
        bereich = "Jugend- und Kinderfeuerwehr",
        name = "Christian Peschke",
        funktion = "Gemeindekinder- und Jugendfeuerwehrwart",
        kontakt = "info@feuerwehr-biebertal.de"
    ),
    Ansprechpartner(
        bereich = "Schutzbereich Mitte",
        name = "Marco Seitz",
        funktion = "Schutzbereichsleiter Mitte",
        kontakt = "info@feuerwehr-biebertal.de"
    ),
    Ansprechpartner(
        bereich = "Schutzbereich Nord",
        name = "Pascal Wahl",
        funktion = "Schutzbereichsleiter Nord",
        kontakt = "info@feuerwehr-biebertal.de"
    ),
    Ansprechpartner(
        bereich = "Schutzbereich West",
        name = "Matthias Justus",
        funktion = "Schutzbereichsleiter West",
        kontakt = "info@feuerwehr-biebertal.de"
    ),
    Ansprechpartner(
        bereich = "Gemeindeverwaltung",
        name = "Gemeindevorstand Biebertal",
        funktion = "Trägerin der Feuerwehr Biebertal",
        kontakt = "info@biebertal.de"
    )
)

const val ALLGEMEINE_TELEFONNUMMER = "+49 6409 690"
const val ALLGEMEINE_ADRESSE = "Mühlbergstraße 9, 35444 Biebertal"
