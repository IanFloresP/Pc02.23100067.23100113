package PC2.pc022310006723100113.dummy

import androidx.compose.runtime.Composable
import PC2.pc022310006723100113.presentation.register.RegistrerLigaScreen

@Composable
fun DummyScreen() {
    // Implementación dummy para probar la pantalla
    RegistrerLigaScreen(
        onBackClick = { 
            // Acción simulada para el botón atrás
            println("Dummy: Regresar presionado") 
        },
        onSaveClick = { nombre, anio, titulos, url ->
            // Acción simulada para guardar
            println("Dummy: Guardar -> Nombre: $nombre, Año: $anio, Títulos: $titulos, URL: $url")
        }
    )
}