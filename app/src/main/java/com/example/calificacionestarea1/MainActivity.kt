package com.example.calificacionestarea1

import android.os.Bundle
import android.text.TextUtils
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.calificacionestarea1.ui.theme.CalificacionesTarea1Theme

import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.text.style.TextAlign

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CalificacionesTarea1Theme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    GradesScreen()
                }
            }
        }
    }
}

fun getQuote(average: Double): String {
    if (average < 7.0) {
        return "El alumno repetirá el semestre. 🙁"
    } else if (average < 8.5) {
        return "Has perdido 5% de beca. 👎🏽"
    } else {
        return "¡Felicidades, eres un estudiante de honor! 🎉"
    }
    return ""
}

@Composable
fun GradesScreen() {
    var englishGrade: Double by remember { mutableStateOf(0.0) }
    var mathGrade: Double by remember { mutableStateOf(0.0) }
    var chemistryGrade: Double by remember { mutableStateOf(0.0) }

    val average: Double = (englishGrade + mathGrade + chemistryGrade) / 3
    val averageString: String = String.format("%1f", average)

    Column (
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "Mis calificaciones",
            fontSize = 30.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.align(Alignment.CenterHorizontally)
        )

        Spacer(modifier = Modifier.height(10.dp))

        OutlinedTextField(
            value = englishGrade.toString(),
            onValueChange = {englishGrade = it.toDouble()},
            label = {
                Text(text = "Inglés")
            },
            placeholder = {
                Text(text = "Ingresa tu calificación de inglés")
            },
            leadingIcon = {
                Icon(imageVector = Icons.Default.Star, contentDescription = "Icon")
            },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 30.dp)
        )

        OutlinedTextField(
            value = mathGrade.toString(),
            onValueChange = {mathGrade = it.toDouble()},
            label = {
                Text(text = "Matemáticas")
            },
            placeholder = {
                Text(text = "Ingresa tu calificación de matemáticas")
            },
            leadingIcon = {
                Icon(imageVector = Icons.Default.Star, contentDescription = "Icon")
            },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 30.dp)
        )

        OutlinedTextField(
            value = chemistryGrade.toString(),
            onValueChange = {chemistryGrade = it.toDouble()},
            label = {
                Text(text = "Química")
            },
            placeholder = {
                Text(text = "Ingresa tu calificación de química")
            },
            leadingIcon = {
                Icon(imageVector = Icons.Default.Star, contentDescription = "Icon")
            },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 30.dp)
        )

        Spacer(modifier = Modifier.height(15.dp))

        Text(
            text = "Promedio: " + averageString,
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.align(Alignment.CenterHorizontally)
        )

        Spacer(modifier = Modifier.height(15.dp))

        Text(
            text = getQuote(average = average),
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center,
            modifier = Modifier.align(Alignment.CenterHorizontally)
        )

    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    CalificacionesTarea1Theme {
        GradesScreen()
    }
}