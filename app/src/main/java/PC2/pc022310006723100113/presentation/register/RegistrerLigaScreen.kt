package PC2.pc022310006723100113.presentation.register

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RegistrerLigaScreen(
    onBackClick: () -> Unit = {}, // Callback para regresar
    onSaveClick: (String, String, String, String) -> Unit = { _, _, _, _ -> } // Callback para guardar (nombre, anio, titulos, url)
) {
    // Estados para los campos del formulario
    var nombreEquipo by remember { mutableStateOf("") }
    var anioFundacion by remember { mutableStateOf("") }
    var numTitulos by remember { mutableStateOf("") }
    var urlImagen by remember { mutableStateOf("") }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Registro Liga 1") },
                navigationIcon = {
                    IconButton(onClick = { onBackClick() }) {
                        Icon(
                            imageVector = Icons.Default.ArrowBack,
                            contentDescription = "Regresar"
                        )
                    }
                }
            )
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top
        ) {
            Text(
                text = "Registro Liga 1",
                style = MaterialTheme.typography.headlineMedium,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(bottom = 16.dp)
            )

            // Campo: Nombre del equipo
            OutlinedTextField(
                value = nombreEquipo,
                onValueChange = { nombreEquipo = it },
                label = { Text("Nombre del equipo") },
                modifier = Modifier.fillMaxWidth(),
                singleLine = true
            )

            Spacer(modifier = Modifier.height(16.dp))

            // Campo: Año de fundación
            OutlinedTextField(
                value = anioFundacion,
                onValueChange = { anioFundacion = it },
                label = { Text("Año de fundación") },
                modifier = Modifier.fillMaxWidth(),
                singleLine = true,
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
            )

            Spacer(modifier = Modifier.height(16.dp))

            // Campo: Número de títulos ganados
            OutlinedTextField(
                value = numTitulos,
                onValueChange = { numTitulos = it },
                label = { Text("Número de títulos ganados") },
                modifier = Modifier.fillMaxWidth(),
                singleLine = true,
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
            )

            Spacer(modifier = Modifier.height(16.dp))

            // Campo: URL de la imagen
            OutlinedTextField(
                value = urlImagen,
                onValueChange = { urlImagen = it },
                label = { Text("URL de la imagen del equipo") },
                modifier = Modifier.fillMaxWidth(),
                singleLine = true,
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Uri)
            )

            Spacer(modifier = Modifier.height(32.dp))

            // Botón de Guardar
            Button(
                onClick = {
                    if (nombreEquipo.isNotEmpty() && anioFundacion.isNotEmpty() && numTitulos.isNotEmpty()) {
                        onSaveClick(nombreEquipo, anioFundacion, numTitulos, urlImagen)
                    }
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp),
                enabled = nombreEquipo.isNotEmpty() && anioFundacion.isNotEmpty() && numTitulos.isNotEmpty() // Deshabilitar si campos obligatorios están vacíos
            ) {
                Text(text = "Registrar Equipo")
            }
        }
    }
}
