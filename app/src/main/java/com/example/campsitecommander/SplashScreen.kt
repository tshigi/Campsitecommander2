package com.example.campsitecommander

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.campsitecommander.ui.theme.CampsitecommanderTheme

class SplashScreen : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CampsitecommanderTheme {
                var name by remember { mutableStateOf("") }
                var category by remember { mutableStateOf("") }
                var qty by remember { mutableStateOf("") }
                var comments by remember { mutableStateOf("") }

                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(16.dp)
                ) {
                    Spacer(modifier = Modifier.height(16.dp))
                    OutlinedTextField(
                        value = name,
                        onValueChange = {name = it},
                        label = {Text("Item name")}
                    )
                    OutlinedTextField(
                        value = category,
                        onValueChange = {category = it},
                        label = {Text("category")}
                    )
                    OutlinedTextField(
                        value = qty,
                        onValueChange = {qty = it},
                        label = {Text("quantity")}
                    )
                    OutlinedTextField(
                        value = comments,
                        onValueChange = {comments = it},
                        label = {Text("comments")}
                    )
                    Button(
                        onClick = {
                            val q = qty.toIntOrNull()
                            if (q!= null && q > 0){

                            }
                            name.isNotEmpty() &&
                                    category.isNotEmpty() &&
                                    qty.isNotEmpty() &&
                                    comments.isNotEmpty()

                            name = ""
                            category = ""
                            qty = ""
                            comments = ""

                        },
                        Modifier.fillMaxSize()
                    ) {

                        Text("Add")
                    }
                    Button({finish()},
                        Modifier.fillMaxSize()){
                        Text("Back to maain screen")
                    }

                }

            }
        }
    }
}

