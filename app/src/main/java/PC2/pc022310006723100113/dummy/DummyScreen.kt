package PC2.pc022310006723100113.dummy

import androidx.compose.runtime.Composable
import androidx.navigation.compose.rememberNavController
import PC2.pc022310006723100113.presentation.register.RegistrerLigaScreen

@Composable
fun DummyScreen() {
    val navController = rememberNavController()
    // Implementación dummy para probar la pantalla
    RegistrerLigaScreen(
        navController = navController
    )
}
