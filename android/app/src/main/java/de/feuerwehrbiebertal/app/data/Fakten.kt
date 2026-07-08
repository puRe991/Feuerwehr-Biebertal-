package de.feuerwehrbiebertal.app.data

data class Kennzahl(val wert: String, val label: String)

val kennzahlen = listOf(
    Kennzahl("181", "Aktive Einsatzkräfte"),
    Kennzahl("82", "Jugend- und Kinderfeuerwehr"),
    Kennzahl("7", "Ortsteile mit eigenem Feuerwehrhaus"),
    Kennzahl("16", "Fahrzeuge und Anhänger")
)

data class Meilenstein(val jahr: String, val text: String)

val meilensteine = listOf(
    Meilenstein("1933", "Die freiwillige Feuerwehr in Frankenbach wird gegründet – eine der ältesten Wehren im heutigen Biebertal."),
    Meilenstein("1979", "Frankenbach wird im Zuge der hessischen Gebietsreform Teil der neu gebildeten Gemeinde Biebertal."),
    Meilenstein("1995", "Gründung der Jugendfeuerwehr in Frankenbach – Startschuss für die heutige Nachwuchsarbeit."),
    Meilenstein("2008", "Die erste Minifeuerwehr in Biebertal nimmt ihre Arbeit auf."),
    Meilenstein("2019", "Auszeichnung als \"Feuerwehr des Monats\" in Hessen für das Modell \"Einsatzleiter vom Dienst\"."),
    Meilenstein("2023", "Die Wehr Frankenbach feiert ihr 90-jähriges Bestehen gemeinsam mit Jugend- und Minifeuerwehr."),
    Meilenstein("2024", "Ein landesgeförderter Gerätewagen-Logistik für den Katastrophenschutz (GW-L KatS) verstärkt die Ausstattung."),
    Meilenstein("2025", "Als erste Feuerwehr im Landkreis Gießen setzt Biebertal eine Drohne mit Wärmebildkamera im Einsatz ein.")
)

const val UEBER_UNS_TEXT = "Die Feuerwehr Biebertal ist eine gemeindliche Einrichtung der Gemeinde Biebertal und arbeitet vollständig ehrenamtlich – ohne hauptamtliches Personal. Rund um die Uhr, an 365 Tagen im Jahr, stehen die Einsatzkräfte für die Sicherheit der Bürgerinnen und Bürger bereit.\n\nOrganisiert ist die Wehr in drei Schutzbereiche mit jeweils eigener Führung: Mitte (Bieber, Fellingshausen, Rodheim, Vetzberg), Nord (Frankenbach, Krumbach) und West (Königsberg). Jeder der sieben Ortsteile verfügt über ein eigenes Feuerwehrhaus sowie eigene Einsatz-, Jugend- und Kinderfeuerwehrabteilungen, unterstützt von sieben Feuerwehrvereinen.\n\nMitmachen können alle zwischen 6 und 65 Jahren – von der Minifeuerwehr über die Jugendfeuerwehr bis zur aktiven Einsatzabteilung und der Alters- und Ehrenabteilung."
