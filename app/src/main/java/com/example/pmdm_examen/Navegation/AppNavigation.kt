package com.example.pmdm_examen.Navegation

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.pmdm_examen.Screens.FirstScreen
import com.example.pmdm_examen.Screens.SecondScreen

@RequiresApi(Build.VERSION_CODES.TIRAMISU)
@Composable
fun AppNavigation(modifier: Modifier){

    val navControlador = rememberNavController()

    //Veia mas comodo usar un navController

    NavHost(
        navController = navControlador,
        startDestination = AppScreen.FirstScreen.route)
    {
        composable(AppScreen.FirstScreen.route){
            FirstScreen(navControlador)
        }

        composable(AppScreen.SecondScreen.route + "/{registro}",
            arguments = listOf(navArgument(name = "registro"){type = NavType.StringType}) // <- Esto es asi porque voy a usar Json para codificar una clase a string
        ){
            val nombre = it.arguments?.getString("registro")?: ""

            SecondScreen(navControlador,nombre)
        }
    }
}