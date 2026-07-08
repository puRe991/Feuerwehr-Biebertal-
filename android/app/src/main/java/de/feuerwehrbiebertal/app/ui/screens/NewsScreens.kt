package de.feuerwehrbiebertal.app.ui.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
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
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import de.feuerwehrbiebertal.app.data.news
import de.feuerwehrbiebertal.app.ui.components.AppHeader
import de.feuerwehrbiebertal.app.ui.components.DetailTopBar
import de.feuerwehrbiebertal.app.ui.components.NewsKategorieChip

@Composable
fun NewsListScreen(onNewsClick: (String) -> Unit) {
    Scaffold(
        topBar = { AppHeader(title = "Meldungen", subtitle = "Aktuelles aus der Feuerwehr Biebertal") }
    ) { padding ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding),
            contentPadding = androidx.compose.foundation.layout.PaddingValues(16.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            items(news, key = { it.slug }) { item ->
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clickable { onNewsClick(item.slug) }
                ) {
                    Column(modifier = Modifier.padding(16.dp)) {
                        NewsKategorieChip(item.kategorie)
                        Text(
                            text = item.titel,
                            style = MaterialTheme.typography.titleLarge,
                            modifier = Modifier.padding(top = 8.dp, bottom = 4.dp)
                        )
                        Text(text = item.datum, style = MaterialTheme.typography.bodyMedium)
                        Text(
                            text = item.teaser,
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
fun NewsDetailScreen(slug: String, onBack: () -> Unit) {
    val item = news.find { it.slug == slug }

    Scaffold(
        topBar = { DetailTopBar(title = item?.titel ?: "Meldung", onBack = onBack) }
    ) { padding ->
        if (item == null) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(padding)
                    .padding(16.dp)
            ) {
                Text(
                    text = "Diese Meldung wurde nicht gefunden.",
                    textAlign = TextAlign.Center
                )
            }
            return@Scaffold
        }

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .padding(16.dp)
        ) {
            NewsKategorieChip(item.kategorie)
            Text(
                text = item.titel,
                style = MaterialTheme.typography.headlineMedium,
                modifier = Modifier.padding(top = 12.dp, bottom = 4.dp)
            )
            Text(text = item.datum, style = MaterialTheme.typography.bodyMedium)
            Text(
                text = item.teaser,
                style = MaterialTheme.typography.bodyLarge,
                modifier = Modifier.padding(top = 16.dp)
            )
        }
    }
}
