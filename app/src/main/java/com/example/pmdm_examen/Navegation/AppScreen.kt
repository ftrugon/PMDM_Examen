package com.example.pmdm_examen.Navegation

sealed class AppScreen(val route:String) {

    object FirstScreen:AppScreen("FirstScreen")
    object SecondScreen:AppScreen("SecondScreen")

}