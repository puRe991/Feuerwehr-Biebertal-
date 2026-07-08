package de.feuerwehrbiebertal.app.ui.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import de.feuerwehrbiebertal.app.R
import de.feuerwehrbiebertal.app.data.UEBER_UNS_TEXT
import de.feuerwehrbiebertal.app.data.kennzahlen
import de.feuerwehrbiebertal.app.data.meilensteine
import de.feuerwehrbiebertal.app.data.news
import de.feuerwehrbiebertal.app.ui.components.AppHeader
import de.feuerwehrbiebertal.app.ui.components.NewsKategorieChip
import de.feuerwehrbiebertal.app.ui.components.NotrufCard
import de.feuerwehrbiebertal.app.ui.components.StatTile

@Composable
fun HomeScreen(onNewsClick: (String) -> Unit, onAlleMeldungenClick: () -> Unit) {
    Scaffold(
        topBar = { AppHeader(title = "Feuerwehr Biebertal", subtitle = "Ehrenamtlich im Einsatz für unsere Gemeinde") }
    ) { padding ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding),
            contentPadding = PaddingValues(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            item { NotrufCard() }

            item {
                LazyRow(horizontalArrangement = Arrangement.spacedBy(12.dp)) {
                    items(kennzahlen) { StatTile(it) }
                }
            }

            item {
                Card(modifier = Modifier.fillMaxWidth()) {
                    Row(
                        modifier = Modifier.padding(16.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Icon(
                            painter = painterResource(id = R.drawable.ic_drone),
                            contentDescription = null,
                            modifier = Modifier.size(32.dp),
                            tint = MaterialTheme.colorScheme.primary
                        )
                        Column(modifier = Modifier.padding(start = 12.dp)) {
                            Text(text = "Erste Drohnen-Feuerwehr im Landkreis Gießen", style = MaterialTheme.typography.titleMedium)
                            Text(
                                text = "Unsere DJI-Drohne mit Wärmebildkamera unterstützt bei Lageerkundung und Personensuche.",
                                style = MaterialTheme.typography.bodyMedium,
                                modifier = Modifier.padding(top = 4.dp)
                            )
                        }
                    }
                }
            }

            item {
                Text(text = "Über uns", style = MaterialTheme.typography.titleLarge)
                Text(
                    text = UEBER_UNS_TEXT,
                    style = MaterialTheme.typography.bodyLarge,
                    modifier = Modifier.padding(top = 8.dp)
                )
            }

            item {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(text = "Aktuelle Meldungen", style = MaterialTheme.typography.titleLarge)
                    TextButton(onClick = onAlleMeldungenClick) { Text("Alle anzeigen") }
                }
            }

            items(news.take(3), key = { it.slug }) { item ->
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clickable { onNewsClick(item.slug) }
                ) {
                    Column(modifier = Modifier.padding(16.dp)) {
                        NewsKategorieChip(item.kategorie)
                        Text(
                            text = item.titel,
                            style = MaterialTheme.typography.titleMedium,
                            modifier = Modifier.padding(top = 8.dp)
                        )
                        Text(text = item.datum, style = MaterialTheme.typography.bodyMedium)
                    }
                }
            }

            item {
                Text(
                    text = "Meilensteine",
                    style = MaterialTheme.typography.titleLarge,
                    modifier = Modifier.padding(top = 8.dp)
                )
            }

            items(meilensteine) { meilenstein ->
                Row(modifier = Modifier.fillMaxWidth()) {
                    Text(
                        text = meilenstein.jahr,
                        style = MaterialTheme.typography.titleMedium,
                        color = MaterialTheme.colorScheme.primary,
                        modifier = Modifier.padding(end = 12.dp)
                    )
                    Text(text = meilenstein.text, style = MaterialTheme.typography.bodyLarge)
                }
            }
        }
    }
}
