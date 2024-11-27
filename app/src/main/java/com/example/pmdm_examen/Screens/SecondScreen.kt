package com.example.pmdm_examen.Screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.pmdm_examen.Navegation.AppScreen
import com.example.pmdm_examen.Registro
import kotlinx.serialization.json.Json


@Composable
fun SecondScreen(navController: NavController, registro:String){

    //Decodifico el json que le he pasado antes
    val registroDecoded = Json.decodeFromString<Registro>(registro)

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        BoxContent(registroDecoded.nombre)
        BoxContent(registroDecoded.apellido)
        BoxContent(registroDecoded.dni)
        BoxContent(registroDecoded.mail)
        Button(
            onClick = {navController.popBackStack()}
        ){
            Text("Volver a la zona de registro")
        }
    }

}


@Composable
fun BoxContent(thingToShow:String){
    Box(
        modifier = Modifier.fillMaxWidth().padding(horizontal = 40.dp).background(Color.Gray).clickable {  },
        contentAlignment = Alignment.CenterStart){
        Text(thingToShow, modifier = Modifier.padding(20.dp), color = Color.White)
    }
}