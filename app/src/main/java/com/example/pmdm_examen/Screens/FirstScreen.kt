package com.example.pmdm_examen.Screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
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

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FirstScreen(navController:NavController) {

    Column(
        modifier = Modifier.fillMaxSize()
            .background(Color.Cyan),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        var nombre by remember { mutableStateOf("") }
        val apellido = remember { mutableStateOf("") }
        val dni = remember { mutableStateOf("") }
        val mail = remember { mutableStateOf("") }



        Button(
            onClick = {}
        ){
            Text(nombre)
        }

        TextField(
            value = nombre,
            onValueChange = {
                if (it.length <= 30){
                    nombre = it
                }
            },
            placeholder = { Text(text = "Escribe un mensaje...") },
            modifier = Modifier.fillMaxWidth().padding(horizontal = 20.dp)
            //    .weight(10f)
            //    .padding(top = 8.dp, bottom = 8.dp)
            ,
            singleLine = true,
            colors = TextFieldDefaults.colors(
                cursorColor = Color.Gray,
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent
            )
        )


        Button(
            onClick = {navController.navigate(route = AppScreen.SecondScreen.route + "/$nombre")}
        ){
            Text("Cambiar a pantalla 2")
        }
    }


}