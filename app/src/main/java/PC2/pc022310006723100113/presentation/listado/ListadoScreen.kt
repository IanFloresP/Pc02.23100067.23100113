package PC2.pc022310006723100113.presentation.listado

import PC2.pc022310006723100113.model.Equipo
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import coil.compose.AsyncImagePainter
import coil.compose.SubcomposeAsyncImage
import coil.compose.SubcomposeAsyncImageContent
import java.util.UUID

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ListadoScreen(
    navController: NavHostController,
    viewModel: ListadoViewModel = viewModel()
) {
    val equipos by viewModel.equipos.collectAsState()
    val Liga1Red = Color(0xFFE30613)

    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = { Text("Equipos Liga 1", fontWeight = FontWeight.Bold, color = Color.White) },
                colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                    containerColor = Liga1Red
                )
            )
        },
        floatingActionButton = {
            ExtendedFloatingActionButton(
                text = { Text("Nuevo Registro") },
                icon = { Icon(Icons.Default.Add, contentDescription = "Registrar") },
                onClick = { navController.navigate("RegistroScreen") },
                containerColor = Liga1Red,
                contentColor = Color.White
            )
        }
    ) { paddingValues ->
        if (equipos.isEmpty()) {
            Box(
                modifier = Modifier.fillMaxSize().padding(paddingValues),
                contentAlignment = Alignment.Center
            ) {
                Text("No hay equipos registrados.", style = MaterialTheme.typography.bodyLarge)
            }
        } else {
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues)
                    .padding(horizontal = 16.dp),
                verticalArrangement = Arrangement.spacedBy(12.dp),
                contentPadding = PaddingValues(vertical = 16.dp)
            ) {
                items(equipos, key = { it.id ?: UUID.randomUUID().toString() }) { equipo ->
                    EquipoCard(equipo = equipo)
                }
            }
        }
    }
}

@Composable
fun EquipoCard(equipo: Equipo) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(16.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        Row(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            // Logo del equipo con SubcomposeAsyncImage
            SubcomposeAsyncImage(
                model = equipo.imagenUrl,
                contentDescription = "Logo de ${equipo.nombre}",
                modifier = Modifier
                    .size(60.dp)
                    .clip(CircleShape)
                    .background(Color.White),
                contentScale = ContentScale.Fit,
            ) { 
                val state = painter.state
                if (state is AsyncImagePainter.State.Loading || state is AsyncImagePainter.State.Error) {
                    // En caso de carga o error, mostramos el Box con N/A
                    Box(modifier = Modifier.fillMaxSize().background(Color.LightGray), contentAlignment = Alignment.Center) {
                        Text("N/A", color = Color.White, fontWeight = FontWeight.Bold)
                    }
                } else {
                    // Si la imagen carga bien, la mostramos
                    SubcomposeAsyncImageContent()
                }
            }

            Spacer(modifier = Modifier.width(16.dp))

            // Nombre y fundación
            Column(
                modifier = Modifier.weight(1f)
            ) {
                Text(
                    text = equipo.nombre,
                    style = MaterialTheme.typography.titleLarge,
                    fontWeight = FontWeight.Bold,
                    color = Color(0xFF1D1D1B)
                )
                Text(
                    text = "Fundado en ${equipo.fundacion}",
                    style = MaterialTheme.typography.bodyMedium,
                    color = Color.Gray
                )
            }

            // Títulos
            Box(
                modifier = Modifier
                    .size(50.dp)
                    .clip(CircleShape)
                    .background(Color(0xFFE30613).copy(alpha = 0.1f)),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = equipo.titulos.toString(),
                    style = MaterialTheme.typography.headlineSmall,
                    fontWeight = FontWeight.ExtraBold,
                    color = Color(0xFFE30613)
                )
            }
        }
    }
}
