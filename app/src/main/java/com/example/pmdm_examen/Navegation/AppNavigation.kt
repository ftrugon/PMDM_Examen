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

    NavHost(
        navController = navControlador,
        startDestination = AppScreen.FirstScreen.route)
    {
        composable(AppScreen.FirstScreen.route){
            FirstScreen(navControlador)
        }

        composable(AppScreen.SecondScreen.route + "/{nombre}",
            arguments = listOf(navArgument(name = "nombre"){type = NavType.StringType})
        ){
            val nombre = it.arguments?.getString("nombre")?: ""

            SecondScreen(navControlador,nombre)
        }
    }
}