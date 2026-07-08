package de.feuerwehrbiebertal.app.ui.components

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp
import de.feuerwehrbiebertal.app.data.NewsKategorie
import de.feuerwehrbiebertal.app.ui.theme.BrandBlue
import de.feuerwehrbiebertal.app.ui.theme.BrandGold
import de.feuerwehrbiebertal.app.ui.theme.BrandRed

@Composable
fun NewsKategorieChip(kategorie: NewsKategorie) {
    val color = when (kategorie) {
        NewsKategorie.VERANSTALTUNG -> BrandGold
        NewsKategorie.PRESSE -> BrandBlue
        NewsKategorie.HINWEIS -> BrandRed
    }
    Surface(
        color = color.copy(alpha = 0.15f),
        contentColor = color,
        shape = RoundedCornerShape(50)
    ) {
        Text(
            text = kategorie.label,
            style = MaterialTheme.typography.labelLarge,
            modifier = androidx.compose.ui.Modifier.padding(horizontal = 12.dp, vertical = 4.dp)
        )
    }
}

@Composable
fun TagChip(text: String) {
    Surface(
        color = MaterialTheme.colorScheme.surfaceVariant,
        shape = RoundedCornerShape(50)
    ) {
        Text(
            text = text,
            style = MaterialTheme.typography.labelLarge,
            modifier = androidx.compose.ui.Modifier.padding(horizontal = 12.dp, vertical = 4.dp)
        )
    }
}
