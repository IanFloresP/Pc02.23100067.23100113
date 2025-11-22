package PC2.pc022310006723100113.presentation.register

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp

import androidx.navigation.NavHostController

import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage



@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RegistrerLigaScreen(
    navController: NavHostController,
    onBackClick: () -> Unit = {}, // Callback para regresar
    onSaveClick: (String, String, String, String) -> Unit = { _, _, _, _ -> } // Callback para guardar
) {
    // Colores de la Liga 1 (Aproximados)
    val Liga1Red = Color(0xFFE30613)
    val Liga1Black = Color(0xFF1D1D1B)
    val Liga1Gray = Color(0xFFF5F5F5)

    // Estados para los campos del formulario
    var nombreEquipo by remember { mutableStateOf("") }
    var anioFundacion by remember { mutableStateOf("") }
    var numTitulos by remember { mutableStateOf("") }
    var urlImagen by remember { mutableStateOf("") }

    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = { 
                    Text(
                        "LIGA 1", 
                        color = Color.White, 
                        fontWeight = FontWeight.Bold 
                    ) 
                },
                navigationIcon = {
                    IconButton(onClick = { onBackClick() }) {
                        Icon(
                            imageVector = Icons.Default.ArrowBack,
                            contentDescription = "Regresar",
                            tint = Color.White
                        )
                    }
                },
                actions = {
                    // Logo de la Liga 1 usando AsyncImage
                    Box(
                        modifier = Modifier
                            .padding(end = 16.dp)
                            .size(40.dp) // Tamaño del contenedor
                            .clip(CircleShape) // Forma circular
                            .background(Color.White) // Fondo blanco para resaltar el logo
                            .padding(4.dp), // Pequeño margen interno
                        contentAlignment = Alignment.Center
                    ) {
                        AsyncImage(
                            model = "https://img.asmedia.epimg.net/resizer/v2/2FYPGIFMD5O6FE77GTZDEZXN3Q.jpg?auth=a3090dac864f8043ec7f11c6eb129993e7a509bc4e8202eac99544e6f7dc0720&width=1472&height=828&smart=true",
                            contentDescription = "Logo Liga 1",
                            modifier = Modifier.fillMaxSize(),
                            contentScale = ContentScale.Crop // Ajustado a Crop para que llene el círculo si es rectangular
                        )
                    }
                },
                colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                    containerColor = Liga1Red
                )
            )
        },
        containerColor = Liga1Gray
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(24.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top
        ) {
            
            Text(
                text = "Registro Liga 1",
                style = MaterialTheme.typography.headlineMedium.copy(
                    fontWeight = FontWeight.ExtraBold,
                    fontSize = 28.sp
                ),
                color = Liga1Black,
                modifier = Modifier.padding(bottom = 24.dp)
            )

            // Campo: Nombre del equipo
            OutlinedTextField(
                value = nombreEquipo,
                onValueChange = { nombreEquipo = it },
                label = { Text("Nombre del equipo") },
                modifier = Modifier.fillMaxWidth(),
                singleLine = true,
                colors = OutlinedTextFieldDefaults.colors(
                    focusedBorderColor = Liga1Red,
                    focusedLabelColor = Liga1Red,
                    cursorColor = Liga1Red
                ),
                shape = RoundedCornerShape(8.dp)
            )

            Spacer(modifier = Modifier.height(16.dp))

            // Campo: Año de fundación
            OutlinedTextField(
                value = anioFundacion,
                onValueChange = { anioFundacion = it },
                label = { Text("Año de fundación") },
                modifier = Modifier.fillMaxWidth(),
                singleLine = true,
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                colors = OutlinedTextFieldDefaults.colors(
                    focusedBorderColor = Liga1Red,
                    focusedLabelColor = Liga1Red,
                    cursorColor = Liga1Red
                ),
                shape = RoundedCornerShape(8.dp)
            )

            Spacer(modifier = Modifier.height(16.dp))

            // Campo: Número de títulos ganados
            OutlinedTextField(
                value = numTitulos,
                onValueChange = { numTitulos = it },
                label = { Text("Número de títulos ganados") },
                modifier = Modifier.fillMaxWidth(),
                singleLine = true,
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                colors = OutlinedTextFieldDefaults.colors(
                    focusedBorderColor = Liga1Red,
                    focusedLabelColor = Liga1Red,
                    cursorColor = Liga1Red
                ),
                shape = RoundedCornerShape(8.dp)
            )

            Spacer(modifier = Modifier.height(16.dp))

            // Campo: URL de la imagen
            OutlinedTextField(
                value = urlImagen,
                onValueChange = { urlImagen = it },
                label = { Text("URL de la imagen del equipo") },
                modifier = Modifier.fillMaxWidth(),
                singleLine = true,
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Uri),
                colors = OutlinedTextFieldDefaults.colors(
                    focusedBorderColor = Liga1Red,
                    focusedLabelColor = Liga1Red,
                    cursorColor = Liga1Red
                ),
                shape = RoundedCornerShape(8.dp)
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
                    .height(56.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Liga1Black,
                    contentColor = Color.White
                ),
                shape = RoundedCornerShape(12.dp),
                enabled = nombreEquipo.isNotEmpty() && anioFundacion.isNotEmpty() && numTitulos.isNotEmpty()
            ) {
                Text(
                    text = "Registrar Equipo",
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold
                )
            }
        }
    }
}
