package com.pabloat.contador

import android.graphics.Paint
import android.os.Bundle
import android.text.Layout
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.combinedClickable
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.pabloat.contador.ui.theme.ContadorTheme
import kotlin.random.Random

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val cont = mutableStateOf(0)
        val tamanioNum = mutableStateOf(20)
        val colores = mutableListOf<Color>(Color.Red, Color.Black,Color.Blue, Color.Green)


        setContent {
            ContadorTheme {
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize(),
                    color = Color.White
                )
                {

                    InvisibleClickableBox(cont,tamanioNum,colores)
                }
            }

        }
    }
}




@OptIn(ExperimentalFoundationApi::class)
@Composable
fun InvisibleClickableBox(cont: MutableState<Int>,tamanioNum: MutableState<Int>, colores: List<Color>) {
    Box(

        modifier = Modifier
            .fillMaxSize()
            .combinedClickable (
                onClick = {incrementarContador(cont); cambiarFuente(cont, tamanioNum)},
                onLongClick = {decrementarContador(cont)}
            )
            .background(Color(Random.nextInt(256), Random.nextInt(256), Random.nextInt(256))),
        contentAlignment = Alignment.Center



    ){

        Text(
            text = cont.value.toString(),
            fontWeight = FontWeight.Bold,
            fontSize = tamanioNum.value.sp
        )
    }
}

fun cambiarFuente(cont: MutableState<Int>,tamanioNum: MutableState<Int>) {

    if (cont.value % 3 == 0 && cont.value < 100) {
        tamanioNum.value = tamanioNum.value + 5
    }

}
fun incrementarContador(contador: MutableState<Int>){
    contador.value++
}

fun decrementarContador(contador: MutableState<Int>){
    contador.value--
}


