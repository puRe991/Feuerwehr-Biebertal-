package de.feuerwehrbiebertal.app.ui.components

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

private val WarnRot = Color(0xFFD71920)
private val WarnGelbGruen = Color(0xFFC4D82E)

/**
 * Zweireihiges Battenburg-Muster, wie es auf Feuerwehrfahrzeugen als Warnmarkierung
 * verwendet wird: rot/leuchtgelb-grüne Quadrate, in der zweiten Reihe um ein
 * halbes Feld versetzt.
 */
@Composable
fun BattenburgStripe(modifier: Modifier = Modifier, squareDp: Int = 10) {
    Canvas(
        modifier = modifier
            .fillMaxWidth()
            .height((squareDp * 2).dp)
    ) {
        val square = squareDp.dp.toPx()
        val rowHeight = size.height / 2f
        val columns = (size.width / square).toInt() + 2

        for (row in 0..1) {
            val offset = if (row == 0) 0f else square / 2f
            for (col in -1 until columns) {
                val isRed = (col % 2 == 0) == (row == 0)
                val x = col * square + offset
                drawRect(
                    color = if (isRed) WarnRot else WarnGelbGruen,
                    topLeft = Offset(x, row * rowHeight),
                    size = Size(square, rowHeight)
                )
            }
        }
    }
}
