package de.feuerwehrbiebertal.app.data

enum class NewsKategorie(val label: String) {
    VERANSTALTUNG("Veranstaltung"),
    PRESSE("Presse"),
    HINWEIS("Hinweis")
}

data class NewsItem(
    val slug: String,
    val titel: String,
    val kategorie: NewsKategorie,
    val datum: String,
    val teaser: String
)

val news = listOf(
    NewsItem(
        slug = "mitglied-werden",
        titel = "Dein Platz bei der Feuerwehr",
        kategorie = NewsKategorie.HINWEIS,
        datum = "2026-01-10",
        teaser = "Du willst helfen, hast aber keine Vorerfahrung? Genau so starten viele. Wir zeigen dir den Einstieg Schritt für Schritt."
    ),
    NewsItem(
        slug = "jugendfeuerwehr-info",
        titel = "Feuerwehr für Kinder und Jugendliche",
        kategorie = NewsKategorie.VERANSTALTUNG,
        datum = "2026-02-15",
        teaser = "Technik entdecken, Teamgeist erleben und Verantwortung lernen – altersgerecht in Kinder- und Jugendfeuerwehr."
    ),
    NewsItem(
        slug = "datenschutz-einsatzberichte",
        titel = "So berichten wir über Einsätze",
        kategorie = NewsKategorie.PRESSE,
        datum = "2026-03-01",
        teaser = "Wir informieren erst nach Freigabe und ohne Daten, die Betroffene, Angehörige oder Einsatzkräfte gefährden können."
    )
)
