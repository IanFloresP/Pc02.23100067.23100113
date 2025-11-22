package PC2.pc022310006723100113

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import PC2.pc022310006723100113.dummy.DummyScreen
import PC2.pc022310006723100113.ui.theme.Pc022310006723100113Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Pc022310006723100113Theme {
                DummyScreen()
            }
        }
    }
}
