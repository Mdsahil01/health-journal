package com.example.health_journal

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.health_journal.ui.theme.HealthjournalTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            HealthjournalTheme {
                    home()
                }
            }
        }
    }


@Composable
fun home() {

    Column {
        Text(
            text = "Welcome to Health Journal"
        )
        val symptoms = mutableListOf<String>()
        var symptom by remember { mutableStateOf("")  }
            TextField(
            value = symptom,
            onValueChange = { symptom = it } ,
//          label =   { Text(text = "Enter Symptom") },
             placeholder = {Text(text = "Enter Symptom")}
            )
        Button(
            onClick = {
                symptoms.add(symptom)
                symptom = "Added"
            }
        ) {
            Text(text="Add Symptom")
        }
    }
}

@Preview(showSystemUi = true, showBackground = true)
@Composable
fun homePreview() {
    HealthjournalTheme {
        home()
    }
}







