package PC2.pc022310006723100113.presentation.listado

import PC2.pc022310006723100113.ui.theme.BlueJJ
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController


@Composable
fun ListadoScreen(navController: NavHostController) {


    Spacer(modifier = Modifier.height(16.dp))

    Text(
        text = "Equipos",
        style = MaterialTheme.typography.headlineLarge,
        fontWeight = FontWeight.Bold,
        color = BlueJJ,
        modifier = Modifier.fillMaxWidth(),
        textAlign = TextAlign.Center
    )


}