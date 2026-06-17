package com.example.health_journal

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Info
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.motionEventSpy
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
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

    var symptom by remember { mutableStateOf("") }
    var savedSymptom by remember { mutableStateOf("") }
    val symptoms = remember { mutableStateListOf<String>() }
    val context = LocalContext.current
    var errorMessage by remember {
        mutableStateOf("")
    }
    var showInfo by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(35.dp),
        horizontalAlignment =
            Alignment.CenterHorizontally

    ) {

            Image(
                painter = painterResource(
                    R.drawable.health_journal_logo),
                contentDescription = "Health journal Logo",
                modifier = Modifier.size(120.dp)

            )

          Row(
              verticalAlignment = Alignment.CenterVertically,
              horizontalArrangement = Arrangement.Center,
              modifier = Modifier.fillMaxWidth()
          ) {
          Text(
              text = "Health Journal"
          )
          IconButton(
              onClick = {
                  showInfo = !showInfo
              }
          )

          {
              Icon(
                  imageVector = Icons.Default.Info,
                  contentDescription = "Info"
              )
          }

         }
        if (showInfo) {
            Text(
                text = "Health Journal v0.2\nTrack your symptoms daily."
            )
        }


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



        OutlinedTextField(
            value = symptom,
            onValueChange = { symptom = it },
            label = { Text(text = "Enter Symptom") },
            modifier = Modifier.fillMaxWidth()

            )

        if (errorMessage.isNotEmpty()) {
            Text(
                text = errorMessage,
                color = Color.Red
            )
        }
        Button(
            modifier = Modifier.fillMaxWidth(),
            onClick = {
                if (symptom.isBlank()) {
                    errorMessage = "Please enter a symptom"
                } else {
                    symptoms.add(symptom)
                    savedSymptom = symptom
                    symptom = ""
                    errorMessage = ""
                }
            }
        ) {
            Text(text = "Add Symptom")
        }


        OutlinedButton(
            onClick = {
                symptoms.clear()
            }
        ) {
            Text(text = "Clear All Symtoms")
        }
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
                Text(text = "🩺 ")

                Text(
                    text = "Last Saved Symptom: $savedSymptom"
                )


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







