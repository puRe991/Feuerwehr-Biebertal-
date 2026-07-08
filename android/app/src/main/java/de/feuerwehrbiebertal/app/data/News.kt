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
    val teaser: String,
    val externerLink: String? = null
)

val news = listOf(
    NewsItem(
        slug = "tag-der-offenen-tuer-krumbach",
        titel = "Tag der offenen Tür in Krumbach",
        kategorie = NewsKategorie.VERANSTALTUNG,
        datum = "2026-06-04",
        teaser = "Der Feuerwehrverein Krumbach lädt zum Tag der offenen Tür ein: Fahrzeuge anschauen, Technik erleben und die Feuerwehr Biebertal hautnah kennenlernen."
    ),
    NewsItem(
        slug = "whatsapp-kanal",
        titel = "Neuer WhatsApp-Kanal der Feuerwehr Biebertal",
        kategorie = NewsKategorie.HINWEIS,
        datum = "2026-05-01",
        teaser = "Ab sofort informiert die Feuerwehr Biebertal auch über einen eigenen WhatsApp-Kanal zu Einsätzen und Sicherheitstipps. Jetzt abonnieren und nichts mehr verpassen.",
        externerLink = WHATSAPP_CHANNEL_URL
    ),
    NewsItem(
        slug = "mitglied-werden",
        titel = "Dein Platz bei der Feuerwehr",
        kategorie = NewsKategorie.HINWEIS,
        datum = "2026-01-10",
        teaser = "Mitmachen können alle zwischen 6 und 65 Jahren – vom Spaß an der Mini- und Jugendfeuerwehr bis zum aktiven Einsatzdienst. Du willst helfen, hast aber keine Vorerfahrung? Genau so starten viele."
    ),
    NewsItem(
        slug = "jugendfeuerwehr-info",
        titel = "Feuerwehr für Kinder und Jugendliche",
        kategorie = NewsKategorie.VERANSTALTUNG,
        datum = "2026-02-15",
        teaser = "Technik entdecken, Teamgeist erleben und Verantwortung lernen – in Mini- und Jugendfeuerwehr sind aktuell 82 Kinder und Jugendliche aktiv."
    ),
    NewsItem(
        slug = "gw-l-kats",
        titel = "Neuer Gerätewagen-Logistik für den Katastrophenschutz",
        kategorie = NewsKategorie.PRESSE,
        datum = "2025-11-20",
        teaser = "Seit 2024 verstärkt ein vom Land Hessen geförderter GW-L KatS mit Waldbrand- und Hochwassermodul die Ausstattung der Feuerwehr Biebertal."
    ),
    NewsItem(
        slug = "drohne-im-einsatz",
        titel = "Erste drohnengestützte Feuerwehr im Landkreis Gießen",
        kategorie = NewsKategorie.PRESSE,
        datum = "2025-08-12",
        teaser = "Mit einer DJI-Drohne samt Wärmebildkamera unterstützt die Feuerwehr Biebertal als erste Wehr im Landkreis Lageerkundung und Personensuche aus der Luft."
    ),
    NewsItem(
        slug = "datenschutz-einsatzberichte",
        titel = "So berichten wir über Einsätze",
        kategorie = NewsKategorie.PRESSE,
        datum = "2026-03-01",
        teaser = "Wir informieren erst nach Freigabe und ohne Daten, die Betroffene, Angehörige oder Einsatzkräfte gefährden können."
    )
)
