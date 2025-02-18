package com.example.ejemplo1

import android.os.Bundle

import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.ejemplo1.ui.theme.Ejemplo1Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Ejemplo1Theme {

            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        fontSize = 100.sp,
        lineHeight = 116.sp,
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Ejemplo1Theme {
        setContent()
    }
}
@Composable
fun SimpleButton(){
    Button(
        onClick = {

        },
        colors = ButtonDefaults.buttonColors(Color.DarkGray)
    )
    {
        Text(text = "Button with gray background",color = Color.White)
    }
}

@Composable
fun setContent(){
    SimpleButton()
}


@Composable
fun Content3(){
    Text(
        text="Text con 75% height",
        color = Color.White,
        modifier = Modifier
            .padding(32.dp)
            .background(Color.Cyan)
            .size(width=250.dp,height=100.dp)
    )
}
@Composable
fun Content4(){
    Text(
        text="Text con 75% height",
        color = Color.White,
        modifier = Modifier
            .background(Color.Green)
            .fillMaxHeight(.75f)
    )
}
@Composable
fun Content5(){
    Text(
        text="Text con 75% height",
        color = Color.White,
        modifier = Modifier
            .background(Color.Green)
            .fillMaxHeight(.75f)
    )
}

@Composable
fun ButtonWithIcon(){
    Button(onClick = {

    })
    {

    }
}