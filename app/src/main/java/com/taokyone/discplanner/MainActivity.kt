package com.taokyone.discplanner

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.taokyone.discplanner.ui.theme.DiscplannerTheme
import java.lang.Math.cos
import java.lang.Math.sin

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DiscplannerTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Greeting("Discplanner")
                    CanvasSample()
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "$name")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    DiscplannerTheme {
        Greeting("Android")
    }
}

@Composable
private fun CanvasSample() {
    Canvas(
        modifier = Modifier
            .fillMaxWidth()
            .aspectRatio(1f).background(Color.Yellow)
    ) {
        val center = size.width / 2
        val outerRadius = center * .9f
        val innerRadius = outerRadius * .1f


        for (i in 0..360 step 90) {
            val xStart = center + (innerRadius * cos(i * DEG_TO_RAD)).toFloat()
            val yStart = center + (innerRadius * sin(i * DEG_TO_RAD)).toFloat()

            val xEnd = center + (outerRadius * cos(i * DEG_TO_RAD)).toFloat()
            val yEnd = center + (outerRadius * sin(i * DEG_TO_RAD)).toFloat()

            drawLine(
                Color.Black,
                start = Offset(xStart, yStart),
                end = Offset(xEnd, yEnd),
                strokeWidth = 10.dp.toPx(),
                cap = StrokeCap.Butt,
            )
            Color.White
        }
    }
}

const val DEG_TO_RAD = Math.PI / 180f