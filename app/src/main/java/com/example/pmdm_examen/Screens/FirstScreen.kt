package com.example.pmdm_examen.Screens

import android.health.connect.datatypes.units.Length
import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.pmdm_examen.Navegation.AppScreen
import com.example.pmdm_examen.Registro
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonNull

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FirstScreen(navController:NavController) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Cyan),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        var nombre by remember { mutableStateOf("") }
        var apellido by remember { mutableStateOf("") }
        var dni by remember { mutableStateOf("") }
        var mail by remember { mutableStateOf("") }


        CampoTexto("Nombre",nombre,20) {
            nombre = it
        }

        CampoTexto("Apellido",apellido,20) {
            apellido = it
        }

        CampoTexto("Dni",dni,9) {
            dni = it
        }

        CampoTexto("Mail",mail,20) {
            mail = it
        }




        Button(
            onClick = {

                val contacto = Registro(nombre, apellido, dni, mail)

                val contactoToString = Json.encodeToString(contacto)

                navController.navigate(route = AppScreen.SecondScreen.route + "/$contactoToString")
            }
        ){
            Text("Cambiar a pantalla 2")
        }
    }
}


@Composable
fun CampoTexto(nombreCampo:String,valorCampo:String,maxLength: Int,onValueChange:(String)->Unit){


    TextField(
        label = { Text(nombreCampo) },
        value = valorCampo,
        onValueChange = {
            if (it.length <= maxLength){
                onValueChange(it)
            }
        },
        placeholder = { Text(text = "Escribe aqui tu $nombreCampo") },
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 20.dp)
        //    .padding(top = 8.dp, bottom = 8.dp)
        ,
        singleLine = true,

    )
}

