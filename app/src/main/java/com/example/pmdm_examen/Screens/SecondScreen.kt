package com.example.pmdm_examen.Screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.example.pmdm_examen.Navegation.AppScreen
import com.example.pmdm_examen.Registro
import kotlinx.serialization.json.Json


@Composable
fun SecondScreen(navController: NavController, registro:String){


    val registroDecoded = Json.decodeFromString<Registro>(registro)

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(registroDecoded.nombre)
        Text(registroDecoded.apellido)
        Text(registroDecoded.dni)
        Text(registroDecoded.mail)
        Button(
            onClick = {navController.popBackStack()}
        ){
            Text("Cambiar a pantalla 2")
        }
    }


}