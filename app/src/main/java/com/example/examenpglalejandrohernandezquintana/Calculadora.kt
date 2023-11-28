package com.example.examenpglalejandrohernandezquintana

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.core.text.isDigitsOnly


@Composable
fun Calculadora(){
    var numero1 by remember{ mutableStateOf("")}
    var numero2 by remember{ mutableStateOf("")}
    var resultado by remember{ mutableStateOf(0)}
    Column(modifier = Modifier.fillMaxSize()) {
        Row(modifier = Modifier
            .fillMaxWidth()
            .weight(2f)) {
            TextField(
                value = numero1,
                onValueChange = {
                    numero1 = it
                },
                label = { Text("Ingrese un número") },
                keyboardOptions = KeyboardOptions.Default.copy(
                    keyboardType = KeyboardType.Number
                ),
                isError = !numero1.isDigitsOnly(),
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(2f)
            )
            TextField(
                value = numero2,
                onValueChange = {
                    numero2 = it
                },
                label = { Text("Ingrese un número") },
                keyboardOptions = KeyboardOptions.Default.copy(
                    keyboardType = KeyboardType.Number
                ),
                isError = !numero2.isDigitsOnly(),
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(2f)
            )
            }
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(6f)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.calculator),
                    contentDescription = null
                )

                Text(text = resultado.toString())
            }
            Row(modifier = Modifier
                .fillMaxWidth()
                .weight(3f)) {
                Button(onClick = { resultado = (numero1.toInt() + numero2.toInt() )},colors = ButtonDefaults.buttonColors(
                    Color.Green) ) {
                    Text(text = "+")
                }
                Button(onClick = { resultado = (numero1.toInt() - numero2.toInt() )},colors = ButtonDefaults.buttonColors(
                    Color.Green) ) {
                    Text(text = "-")
                }
                Button(onClick = { resultado = (numero1.toInt() * numero2.toInt() )},colors = ButtonDefaults.buttonColors(
                    Color.Green) ) {
                    Text(text = "*")
                }
            }
        }
    }


