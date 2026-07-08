package de.feuerwehrbiebertal.app.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import de.feuerwehrbiebertal.app.data.Kennzahl

@Composable
fun StatTile(kennzahl: Kennzahl) {
    Card(modifier = Modifier.width(140.dp)) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(
                text = kennzahl.wert,
                style = MaterialTheme.typography.headlineMedium.copy(fontWeight = FontWeight.Bold),
                color = MaterialTheme.colorScheme.primary
            )
            Text(
                text = kennzahl.label,
                style = MaterialTheme.typography.bodyMedium,
                modifier = Modifier.padding(top = 4.dp)
            )
        }
    }
}
