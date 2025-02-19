package com.example.ejemplo1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.ejemplo1.ui.theme.Ejemplo1Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Ejemplo1Theme {
                CalculatorScreen()
            }
        }
    }
}

@Composable
fun CalculatorScreen() {

    var number1 by remember { mutableStateOf("") }
    var number2 by remember { mutableStateOf("") }
    var result by remember { mutableStateOf<String?>(null) }

    val numericRegex = Regex("^\\d*\$")

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = R.drawable.gato), 
            contentDescription = "Gato",
            modifier = Modifier
                .size(360.dp)

        )
        TextField(
            value = number1,
            onValueChange = { input ->
                if (input.matches(numericRegex)) {
                    number1 = input
                }
            },
            label = { Text("Valor 1") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(8.dp))


        TextField(
            value = number2,
            onValueChange = { input ->
                if (input.matches(numericRegex)) {
                    number2 = input
                }
            },
            label = { Text("Valor 2") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(16.dp))


        Button(
            onClick = {
                if (number1.isNotEmpty() && number2.isNotEmpty()) {
                    val sum = number1.toInt() + number2.toInt()
                    result = "Resultado: $sum"
                } else {
                    result = "Ingrese ambos valores"
                }
            },
            colors = ButtonDefaults.buttonColors(containerColor = Color.Blue),
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(text = "Calcular", color = Color.White)
        }

        Spacer(modifier = Modifier.height(16.dp))


        result?.let {
            Text(text = it, fontSize = 24.sp)
        }
    }
}
