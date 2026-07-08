package de.feuerwehrbiebertal.app.ui.components

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.unit.dp

private val WarnRot = Color(0xFFD71920)
private val WarnGelbGruen = Color(0xFFC4D82E)

/**
 * Diagonales Warnstreifen-Muster (rot/leuchtgelb-grün), wie es als
 * Heckmarkierung auf Feuerwehr- und Rettungsfahrzeugen verwendet wird.
 */
@Composable
fun HazardStripe(modifier: Modifier = Modifier, heightDp: Int = 6) {
    Canvas(
        modifier = modifier
            .fillMaxWidth()
            .height(heightDp.dp)
    ) {
        val skew = size.height * 1.6f
        val stripeWidth = size.height * 1.4f
        var x = -skew
        var isRed = true

        drawRect(color = WarnGelbGruen)

        while (x < size.width + skew) {
            if (isRed) {
                val path = Path().apply {
                    moveTo(x, 0f)
                    lineTo(x + stripeWidth, 0f)
                    lineTo(x + stripeWidth - skew, size.height)
                    lineTo(x - skew, size.height)
                    close()
                }
                drawPath(path, color = WarnRot)
            }
            x += stripeWidth
            isRed = !isRed
        }
    }
}
