package com.example.pmdm_examen

import androidx.core.util.toRange

object Utils {


    // para chechear si el registro que vamos a insertar es valido
    fun checkRegistro(toCheckRegistro: Registro):Boolean{

        // he dehado las variables asi para debugear
        val checkedName = checkName(toCheckRegistro.nombre)
        val checkedApel = checkApellidos(toCheckRegistro.apellido)
        val checkedDni = checkDni(toCheckRegistro.dni)
        val checkedMail = checkMail(toCheckRegistro.mail)

        if (checkedName && checkedApel && checkedDni && checkedMail){
            return true
        }else return false
    }


    private fun checkName(nombre:String):Boolean{

        if (nombre.isBlank() || nombre.isEmpty()) {
            return false
        }else return true

    }

    private fun checkApellidos(apellido:String):Boolean{

        if (apellido.isBlank() || apellido.isEmpty()) {
            return false
        }else return true
    }

    private fun checkDni(dni:String):Boolean{

        val letras = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"

        if (dni.isBlank() || dni.isEmpty() || dni.length != 9) {
            return false
        }

        if (dni.last().uppercase() !in letras){
            return false
        }


        // Creo que es una forma un poco mala pero convierto el numero del dni a un entero y so da error hay algo que no es un numero
        try {
            dni.dropLast(1).toInt()
        }catch (e:Exception){
            return false
        }

        return true

    }

    private fun checkMail(mail:String):Boolean{

        if (mail.contains("@") && mail.contains(".") && mail.isNotEmpty()){
            return true
        }else return false
    }

}