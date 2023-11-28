package com.example.examenpglalejandrohernandezquintana

import android.app.Activity
import android.content.pm.ActivityInfo
import android.graphics.Color.RED
import android.graphics.Paint.Align
import android.widget.RadioGroup
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.selection.selectableGroup
import androidx.compose.material3.Checkbox
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Camaleon(){
    var Fondo by remember { mutableStateOf(Color.Black)}
    var Texto by remember{ mutableStateOf(Color.Yellow)}
    var Titulo by remember { mutableStateOf("CAMALEON")}
    var muestra by remember { mutableStateOf(true)}
    val activity = LocalContext.current as Activity
    //if(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT == 1){
     //   Titulo = "CAMALEON GIRADO"
    //}
    Column(modifier = Modifier.fillMaxSize()) {
        Box(modifier= Modifier
            .background(color = Fondo)
            .fillMaxWidth()
            .weight(5f)){
            if(muestra){
                Text(text = Titulo, textAlign = TextAlign.Center, color = Texto, fontSize = 20.sp)
            }

        }

        Column(modifier= Modifier
            .selectableGroup()
            .background(color = Color(android.graphics.Color.RED))
            .fillMaxWidth()
            .weight(4f)){
            var seleccionado by remember{ mutableStateOf("fondoN")}
            miRadioBoton(texto = "Fondo Negro",seleccionado == "fondoN") { seleccionado = "fondoN"; Fondo = Color.Black }
            miRadioBoton(texto = "Fondo Verde",seleccionado == "fondoV") { seleccionado = "fondoV"; Fondo = Color.Green }
            miRadioBoton(texto = "Fondo Rojo",seleccionado == "fondoR" ) { seleccionado = "fondoR"; Fondo =Color.Red }

        }
        Column(modifier= Modifier
            .selectableGroup()
            .background(color = Color(android.graphics.Color.GREEN))
            .fillMaxWidth()
            .weight(4f)){
            var seleccionado by remember{ mutableStateOf("textoAm")}
            miRadioBoton(texto = "Texto Azul",seleccionado == "textoA") { seleccionado = "textoA"; Texto = Color.Blue }
            miRadioBoton(texto = "Texto Amarillo",seleccionado == "textoAm") { seleccionado = "textoAm"; Texto = Color.Yellow }
            miRadioBoton(texto = "Texto Gris",seleccionado == "textoG" ) { seleccionado = "textoG"; Texto =Color.Gray }

        }
        Box(modifier = Modifier.fillMaxWidth().weight(10f).background(color = Color.Blue)){
            Checkbox(checked = muestra, onCheckedChange =  { isChecked ->
                muestra = isChecked
            })
        }
    }
}

@Composable
fun miRadioBoton(texto : String, seleccionado : Boolean,
                 accion : () -> Unit){

    Row(verticalAlignment = Alignment.CenterVertically){
        RadioButton(selected = seleccionado, onClick = accion)
        Text(texto)
    }
}



