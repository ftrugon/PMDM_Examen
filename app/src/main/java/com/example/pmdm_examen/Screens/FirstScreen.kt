package com.example.pmdm_examen.Screens

import android.health.connect.datatypes.units.Length
import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
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
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.navigation.NavController
import com.example.pmdm_examen.Navegation.AppScreen
import com.example.pmdm_examen.Registro
import com.example.pmdm_examen.Utils
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonNull

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FirstScreen(navController:NavController) {

    // variables para mostrar los errores en la pestaña emergente
    var showError by remember { mutableStateOf(false) }
    val fails by remember { mutableStateOf(mutableListOf<String>()) }


    Column(
        modifier = Modifier
            .fillMaxSize(),
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

        var canRegister by remember { mutableStateOf(false) }



        Button(
            onClick = {
                // creo el registro
                val newRegistro = Registro(nombre, apellido, dni, mail)
                // compruebo el registro

                val checkedPair = Utils.checkRegistro(newRegistro)

                canRegister = checkedPair.first
                fails.addAll(checkedPair.second)

                if (canRegister){
                    // combierto el registro en una cadena
                    //La clase Json es una dependencia
                    val newRegistroString = Json.encodeToString(newRegistro)

                    navController.navigate(route = AppScreen.SecondScreen.route + "/$newRegistroString")
                }else{

                    showError = true

                }
            }
        ){
            Text("Registrarte")
        }
    }

    // comprueba si tiene que mostrar la pestaña emergente
    if(showError){
        DialogIcon(fails) {
            showError = false
            fails.clear()
        }
    }


}




// funciona para mostrar los fallos
@Composable
fun DialogIcon(fails:MutableList<String>, onDismiss: () -> Unit){

    Dialog(onDismiss) {
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp)
                .padding(16.dp),
            shape = RoundedCornerShape(0.dp),
        ) {

            Text("Los siguientes campos dan fallo: ")

            LazyColumn(modifier = Modifier.fillMaxSize()) {

                itemsIndexed(fails){ index, campoFallante->
                    Box(modifier = Modifier.fillMaxWidth()){
                        Text("${index +1}: $campoFallante")
                    }
                }
            }

            Text("Comprueba que esten bien escritos o no sean una cadena vacia ")

        }

    }
}



//funcion de los campos de texto
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

