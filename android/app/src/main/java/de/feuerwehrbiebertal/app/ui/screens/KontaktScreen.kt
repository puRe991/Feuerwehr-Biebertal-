package de.feuerwehrbiebertal.app.ui.screens

import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Link
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material3.Card
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import de.feuerwehrbiebertal.app.data.ALLGEMEINE_ADRESSE
import de.feuerwehrbiebertal.app.data.ALLGEMEINE_TELEFONNUMMER
import de.feuerwehrbiebertal.app.data.FACEBOOK_URL
import de.feuerwehrbiebertal.app.data.INSTAGRAM_URL
import de.feuerwehrbiebertal.app.data.WHATSAPP_CHANNEL_URL
import de.feuerwehrbiebertal.app.data.ansprechpartner
import de.feuerwehrbiebertal.app.ui.components.AppHeader

@Composable
fun KontaktScreen() {
    val context = LocalContext.current

    Scaffold(
        topBar = { AppHeader(title = "Kontakt", subtitle = "Gemeindeverwaltung und Ansprechpartner") }
    ) { padding ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding),
            contentPadding = PaddingValues(16.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            item {
                Card(modifier = Modifier.fillMaxWidth()) {
                    Column(modifier = Modifier.padding(16.dp)) {
                        Text(text = "Gemeindevorstand Biebertal", style = MaterialTheme.typography.titleLarge)

                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.spacedBy(8.dp),
                            modifier = Modifier.padding(top = 12.dp)
                        ) {
                            Icon(Icons.Filled.LocationOn, contentDescription = null, tint = MaterialTheme.colorScheme.primary)
                            Text(text = ALLGEMEINE_ADRESSE, style = MaterialTheme.typography.bodyLarge)
                        }

                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.spacedBy(8.dp),
                            modifier = Modifier
                                .padding(top = 8.dp)
                                .clickable {
                                    val intent = Intent(Intent.ACTION_DIAL).apply {
                                        data = Uri.parse("tel:${ALLGEMEINE_TELEFONNUMMER.replace(" ", "")}")
                                    }
                                    context.startActivity(intent)
                                }
                        ) {
                            Icon(Icons.Filled.Phone, contentDescription = null, tint = MaterialTheme.colorScheme.primary)
                            Text(text = ALLGEMEINE_TELEFONNUMMER, style = MaterialTheme.typography.bodyLarge)
                        }
                    }
                }
            }

            item {
                Card(modifier = Modifier.fillMaxWidth()) {
                    Column(modifier = Modifier.padding(vertical = 4.dp)) {
                        Text(
                            text = "Folgen & Fotos",
                            style = MaterialTheme.typography.titleLarge,
                            modifier = Modifier.padding(horizontal = 16.dp, vertical = 12.dp)
                        )
                        SocialLinkRow(
                            label = "WhatsApp-Kanal abonnieren",
                            url = WHATSAPP_CHANNEL_URL,
                            context = context
                        )
                        HorizontalDivider()
                        SocialLinkRow(
                            label = "Facebook: Fotos & Aktuelles",
                            url = FACEBOOK_URL,
                            context = context
                        )
                        HorizontalDivider()
                        SocialLinkRow(
                            label = "Instagram: Fotos & Aktuelles",
                            url = INSTAGRAM_URL,
                            context = context
                        )
                    }
                }
            }

            item {
                Text(
                    text = "Ansprechpartner",
                    style = MaterialTheme.typography.headlineMedium,
                    modifier = Modifier.padding(top = 8.dp)
                )
            }
            items(ansprechpartner, key = { it.kontakt + it.bereich + it.name }) { person ->
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clickable {
                            val intent = Intent(Intent.ACTION_SENDTO).apply {
                                data = Uri.parse("mailto:${person.kontakt}")
                            }
                            context.startActivity(intent)
                        }
                ) {
                    Column(modifier = Modifier.padding(16.dp)) {
                        Text(text = person.bereich, style = MaterialTheme.typography.labelLarge)
                        Text(
                            text = person.name,
                            style = MaterialTheme.typography.titleLarge,
                            modifier = Modifier.padding(top = 4.dp)
                        )
                        Text(text = person.funktion, style = MaterialTheme.typography.bodyMedium)

                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.spacedBy(8.dp),
                            modifier = Modifier.padding(top = 8.dp)
                        ) {
                            Icon(
                                Icons.Filled.Email,
                                contentDescription = null,
                                tint = MaterialTheme.colorScheme.primary
                            )
                            Text(text = person.kontakt, style = MaterialTheme.typography.bodyLarge)
                        }
                    }
                }
            }
        }
    }
}

@Composable
private fun SocialLinkRow(label: String, url: String, context: android.content.Context) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { context.startActivity(Intent(Intent.ACTION_VIEW, Uri.parse(url))) }
            .padding(horizontal = 16.dp, vertical = 14.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        Icon(Icons.Filled.Link, contentDescription = null, tint = MaterialTheme.colorScheme.primary)
        Text(text = label, style = MaterialTheme.typography.bodyLarge)
    }
}
