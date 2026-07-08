package de.feuerwehrbiebertal.app.ui.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import de.feuerwehrbiebertal.app.data.fahrzeuge
import de.feuerwehrbiebertal.app.data.schutzbereiche
import de.feuerwehrbiebertal.app.ui.components.AppHeader
import de.feuerwehrbiebertal.app.ui.components.DetailTopBar
import de.feuerwehrbiebertal.app.ui.components.TagChip

@Composable
fun FahrzeugeScreen(onFahrzeugClick: (String) -> Unit, onSchutzbereichClick: (String) -> Unit) {
    Scaffold(
        topBar = { AppHeader(title = "Fahrzeuge & Schutzbereiche", subtitle = "16 Fahrzeuge in drei Schutzbereichen") }
    ) { padding ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding),
            contentPadding = PaddingValues(16.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            item {
                Text(text = "Fahrzeuge", style = MaterialTheme.typography.headlineMedium)
            }
            items(fahrzeuge, key = { it.slug }) { fahrzeug ->
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clickable { onFahrzeugClick(fahrzeug.slug) }
                ) {
                    Column(modifier = Modifier.padding(16.dp)) {
                        Text(text = fahrzeug.kurzname, style = MaterialTheme.typography.titleLarge)
                        Text(text = fahrzeug.typ, style = MaterialTheme.typography.bodyMedium)
                        Text(
                            text = fahrzeug.standort,
                            style = MaterialTheme.typography.bodyMedium,
                            modifier = Modifier.padding(top = 4.dp)
                        )
                    }
                }
            }

            item {
                Text(
                    text = "Schutzbereiche",
                    style = MaterialTheme.typography.headlineMedium,
                    modifier = Modifier.padding(top = 16.dp)
                )
            }
            items(schutzbereiche, key = { it.slug }) { bereich ->
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clickable { onSchutzbereichClick(bereich.slug) }
                ) {
                    Column(modifier = Modifier.padding(16.dp)) {
                        Text(text = "Schutzbereich ${bereich.name}", style = MaterialTheme.typography.titleLarge)
                        Text(
                            text = bereich.ortsteile.joinToString(", "),
                            style = MaterialTheme.typography.bodyMedium,
                            modifier = Modifier.padding(top = 4.dp)
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun FahrzeugDetailScreen(slug: String, onBack: () -> Unit) {
    val fahrzeug = fahrzeuge.find { it.slug == slug }

    Scaffold(
        topBar = { DetailTopBar(title = fahrzeug?.kurzname ?: "Fahrzeug", onBack = onBack) }
    ) { padding ->
        if (fahrzeug == null) {
            Box(
                modifier = Modifier.fillMaxSize().padding(padding).padding(16.dp),
                contentAlignment = Alignment.Center
            ) {
                Text(text = "Dieses Fahrzeug wurde nicht gefunden.", textAlign = TextAlign.Center)
            }
            return@Scaffold
        }

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .padding(16.dp)
        ) {
            Text(text = fahrzeug.typ, style = MaterialTheme.typography.headlineMedium)
            Text(
                text = fahrzeug.kurzname,
                style = MaterialTheme.typography.titleMedium,
                modifier = Modifier.padding(top = 4.dp, bottom = 16.dp)
            )
            InfoRow(label = "Standort", value = fahrzeug.standort)
            InfoRow(label = "Einsatzzweck", value = fahrzeug.einsatzzweck)

            Text(
                text = "Besonderheiten",
                style = MaterialTheme.typography.titleMedium,
                modifier = Modifier.padding(top = 16.dp, bottom = 8.dp)
            )
            Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
                fahrzeug.besonderheiten.forEach { TagChip(it) }
            }
        }
    }
}

@Composable
fun SchutzbereichDetailScreen(slug: String, onBack: () -> Unit) {
    val bereich = schutzbereiche.find { it.slug == slug }

    Scaffold(
        topBar = { DetailTopBar(title = bereich?.let { "Schutzbereich ${it.name}" } ?: "Schutzbereich", onBack = onBack) }
    ) { padding ->
        if (bereich == null) {
            Box(
                modifier = Modifier.fillMaxSize().padding(padding).padding(16.dp),
                contentAlignment = Alignment.Center
            ) {
                Text(text = "Dieser Schutzbereich wurde nicht gefunden.", textAlign = TextAlign.Center)
            }
            return@Scaffold
        }

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .padding(16.dp)
        ) {
            Text(text = "Schutzbereich ${bereich.name}", style = MaterialTheme.typography.headlineMedium)
            Text(
                text = bereich.beschreibung,
                style = MaterialTheme.typography.bodyLarge,
                modifier = Modifier.padding(top = 16.dp, bottom = 16.dp)
            )
            InfoRow(label = "Ortsteile", value = bereich.ortsteile.joinToString(", "))
            InfoRow(
                label = if (bereich.feuerwehrhaeuser.size > 1) "Feuerwehrhäuser" else "Feuerwehrhaus",
                value = bereich.feuerwehrhaeuser.joinToString("\n") { "${it.ortsteil}: ${it.adresse}" }
            )
            InfoRow(label = "Fahrzeuge", value = bereich.fahrzeuge.joinToString(", "))
            InfoRow(label = "Übungszeiten", value = bereich.uebungszeiten)
            InfoRow(label = "Schutzbereichsleiter", value = bereich.leiter)
            InfoRow(
                label = if (bereich.stellvertreter.size > 1) "Stellvertreter" else "Stellvertreter",
                value = bereich.stellvertreter.joinToString(", ")
            )
        }
    }
}

@Composable
private fun InfoRow(label: String, value: String) {
    Column(modifier = Modifier.padding(bottom = 12.dp)) {
        Text(text = label, style = MaterialTheme.typography.labelLarge)
        Text(text = value, style = MaterialTheme.typography.bodyLarge)
    }
}
