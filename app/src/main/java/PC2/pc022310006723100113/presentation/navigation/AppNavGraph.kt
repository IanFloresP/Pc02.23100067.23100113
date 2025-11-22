package PC2.pc022310006723100113.presentation.navigation

import PC2.pc022310006723100113.presentation.listado.ListadoScreen
import PC2.pc022310006723100113.presentation.register.RegistrerLigaScreen
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController


@Composable
fun AppNavGraph(){

    val navController = rememberNavController()

    NavHost(navController = navController,
        startDestination = "ListadoScreen"){   // Ruta Principal

        
        composable("RegistroScreen"){
            // Nombre corregido para que coincida con el de tu archivo
            RegistrerLigaScreen(navController)
        }
        

        composable("ListadoScreen"){
            ListadoScreen(navController)
        }


    }


}
