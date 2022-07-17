package com.nativemobilebits.stateinjetpackcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.nativemobilebits.stateinjetpackcompose.ui.theme.StateInJetpackComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MainScreen()
        }
    }
}

@Composable
fun MainScreen() {
    val textFieldState = remember {
        mutableStateOf<String>("")
    }
    GreetUser(currentValue = textFieldState.value,
        textFieldValueUpdated = { textFieldState.value = it })
}

@Composable
fun GreetUser(currentValue: String, textFieldValueUpdated: (String) -> Unit) {
    Surface(color = Color.White, modifier = Modifier.fillMaxSize()) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(20.dp)
        ) {
            Text(text = "Welcome User")
            OutlinedTextField(
                value = currentValue,
                onValueChange = textFieldValueUpdated,
                label = { Text(text = "Enter your name") }
            )
        }

    }
}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MainScreen()
}