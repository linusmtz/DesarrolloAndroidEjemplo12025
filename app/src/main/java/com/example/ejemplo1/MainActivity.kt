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
                Content()
            }
        }
    }
}

@Composable
fun Content() {
    var x by remember { mutableStateOf("")}
    var y by remember {mutableStateOf("")}
    var res by remember {mutableStateOf("") }

    Column(
        modifier =Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement= Arrangement.Center,
        horizontalAlignment =Alignment.CenterHorizontally
    ) {
        Image(
            painter= painterResource(id = R.drawable.gato),
            contentDescription="Gato",
            modifier = Modifier
                .size(360.dp)
        )
        TextField(
            value =x,
            onValueChange={input ->
                    x =input
            },
            label ={Text("Valor 1") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            modifier= Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(16.dp))

        TextField(
            value =y,
            onValueChange ={input ->
                    y= input
            },
            label ={Text("Valor 2")},
            keyboardOptions =KeyboardOptions(keyboardType = KeyboardType.Number),
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(32.dp))

        Button(
            onClick={
                if(x.isNotEmpty() && y.isNotEmpty()){
                    val sum = x.toInt()+y.toInt()
                    res = "Resultado es: $sum"
                }
            },
            colors= ButtonDefaults.buttonColors(containerColor= Color.Blue),
            modifier =Modifier.fillMaxWidth()
        ) {
            Text(text="Calcular",color = Color.White)
        }
        Spacer(modifier =Modifier.height(16.dp))

        res?.let{
            Text(text= it, fontSize =24.sp)
        }
    }
}
