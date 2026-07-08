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
import de.feuerwehrbiebertal.app.data.einsatzberichte
import de.feuerwehrbiebertal.app.ui.components.DetailTopBar
import de.feuerwehrbiebertal.app.ui.components.TagChip

@Composable
fun EinsatzberichteListScreen(onItemClick: (String) -> Unit) {
    Scaffold { padding ->
        if (einsatzberichte.isEmpty()) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(padding)
                    .padding(24.dp),
                contentAlignment = Alignment.Center
            ) {
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Text(
                        text = "Aktuell keine veröffentlichten Einsatzberichte",
                        style = MaterialTheme.typography.titleMedium,
                        textAlign = TextAlign.Center
                    )
                    Text(
                        text = "Einsatzberichte erscheinen hier erst nach interner Freigabe und ohne personenbezogene oder taktisch sensible Details.",
                        style = MaterialTheme.typography.bodyMedium,
                        textAlign = TextAlign.Center,
                        modifier = Modifier.padding(top = 8.dp)
                    )
                }
            }
            return@Scaffold
        }

        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding),
            contentPadding = PaddingValues(16.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            item {
                Text(
                    text = "Einsatzberichte",
                    style = MaterialTheme.typography.headlineMedium,
                    modifier = Modifier.padding(bottom = 8.dp)
                )
            }
            items(einsatzberichte, key = { it.slug }) { bericht ->
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clickable { onItemClick(bericht.slug) }
                ) {
                    Column(modifier = Modifier.padding(16.dp)) {
                        Text(text = bericht.einsatzart, style = MaterialTheme.typography.titleLarge)
                        Text(text = "${bericht.datum} · ${bericht.ortsteil}", style = MaterialTheme.typography.bodyMedium)
                        Text(
                            text = bericht.kurzbeschreibung,
                            style = MaterialTheme.typography.bodyLarge,
                            modifier = Modifier.padding(top = 8.dp)
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun EinsatzberichtDetailScreen(slug: String, onBack: () -> Unit) {
    val bericht = einsatzberichte.find { it.slug == slug }

    Scaffold(
        topBar = { DetailTopBar(title = bericht?.einsatzart ?: "Einsatzbericht", onBack = onBack) }
    ) { padding ->
        if (bericht == null) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(padding)
                    .padding(16.dp),
                contentAlignment = Alignment.Center
            ) {
                Text(text = "Dieser Einsatzbericht wurde nicht gefunden.", textAlign = TextAlign.Center)
            }
            return@Scaffold
        }

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .padding(16.dp)
        ) {
            Text(text = bericht.einsatzart, style = MaterialTheme.typography.headlineMedium)
            Text(
                text = "${bericht.datum} · ${bericht.ortsteil}",
                style = MaterialTheme.typography.bodyMedium,
                modifier = Modifier.padding(top = 4.dp, bottom = 16.dp)
            )
            Text(text = bericht.kurzbeschreibung, style = MaterialTheme.typography.bodyLarge)

            if (bericht.einheiten.isNotEmpty()) {
                Text(
                    text = "Eingesetzte Einheiten",
                    style = MaterialTheme.typography.titleMedium,
                    modifier = Modifier.padding(top = 20.dp, bottom = 8.dp)
                )
                Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
                    bericht.einheiten.forEach { TagChip(it) }
                }
            }

            Text(
                text = bericht.datenschutzHinweis,
                style = MaterialTheme.typography.bodyMedium,
                modifier = Modifier.padding(top = 20.dp)
            )
        }
    }
}
