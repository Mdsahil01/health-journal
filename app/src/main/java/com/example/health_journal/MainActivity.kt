package com.example.health_journal

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
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

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(25.dp)

    ) {
        Text(
            text = "Welcome to Health Journal",
            modifier = Modifier
                .fillMaxWidth()
                .background(
                    Color(0xFFE3F2FD),
                    RoundedCornerShape(8.dp)
                )
                .padding(16.dp)

        )

        var symptom by remember { mutableStateOf("") }
        var savedSymptom by remember { mutableStateOf("") }
        val symptoms = remember { mutableStateListOf<String>() }


        OutlinedTextField(
            value = symptom,
            onValueChange = { symptom = it },
            label = { Text(text = "Enter Symptom") },
            modifier = Modifier.fillMaxWidth()

            )
        Button(
            modifier = Modifier.fillMaxWidth(),
            onClick = {
                if (symptom.isNotEmpty()) {
                    symptoms.add(symptom)
                    savedSymptom = symptom
                    symptom = ""
                }
            }
        ) {
            Text(text = "Add Symptom")
        }
        Text(
            text = "Last Saved Symptom: $savedSymptom"
        )
        Box(
            modifier = Modifier.fillMaxWidth()
                .border(1.dp,Color.Gray,
            RoundedCornerShape(12.dp))
                .background(
                    Color(0xFFF5F5F5),
                    RoundedCornerShape(12.dp)
                )
                .padding(12.dp),
            contentAlignment = Alignment.CenterStart
        ){
            Column() {
                Text("Symptoms:")

                for (item in symptoms){
                    Text("\u2022 $item")
            }

            }

        }
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.End
        ) {
            Text(text = "Total Symptoms: ${symptoms.size}")

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







