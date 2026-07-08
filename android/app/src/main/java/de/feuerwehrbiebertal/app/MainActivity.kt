package de.feuerwehrbiebertal.app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import de.feuerwehrbiebertal.app.ui.FeuerwehrBiebertalApp
import de.feuerwehrbiebertal.app.ui.theme.FeuerwehrBiebertalTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            FeuerwehrBiebertalTheme {
                FeuerwehrBiebertalApp()
            }
        }
    }
}
