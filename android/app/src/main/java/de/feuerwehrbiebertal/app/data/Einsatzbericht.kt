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

// Einsatzberichte dürfen erst nach interner Freigabe veröffentlicht werden, siehe README.
val einsatzberichte = emptyList<Einsatzbericht>()
