package com.example.campsitecommander

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
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

class AddGear : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CampsitecommanderTheme {
                Surface(modifier = Modifier.fillMaxSize()) {
                    Column(modifier = Modifier.padding(16.dp)) {

                        //Declare variables  to hold user input
                        var name by remember { mutableStateOf("") }
                        var category by remember { mutableStateOf("") }
                        var qty by remember { mutableStateOf("") }
                        var comment by remember { mutableStateOf("") }

                        Text("Add to Gear")
                        Spacer(Modifier.height(10.dp))

                        //Text for user to enter data
                        OutlinedTextField(
                            value = name,
                            onValueChange = {name = it},
                             label = {Text("Name")}

                        )
                        Spacer(Modifier.height(10.dp))
                        OutlinedTextField(
                            value = category,
                            onValueChange = {category = it},
                            label = {Text("category")}

                        )
                        Spacer(Modifier.height(8.dp))
                        OutlinedTextField(
                            value = qty,
                            onValueChange = {qty = it},
                            label = {Text("Quantity")}
                        )
                        Spacer(Modifier.height(8.dp))

                        OutlinedTextField(
                            value = comment,
                            onValueChange = {comment = it},
                            label = {Text("Comment")}
                        )
                        Spacer(Modifier.height(16.dp))

                        //Save Button "Adds" data to arrays
                        Button(
                            onClick = {
                                if (name != "" && category != "" && qty != ""){
                                    //Adding new item to each array using + operator
                                    MainActivity.items = MainActivity.items + name
                                    MainActivity.categories = MainActivity.categories + category
                                    MainActivity.quantities = MainActivity.quantities + qty.toInt()
                                    MainActivity.comments = MainActivity.comments + comment
                                    MainActivity.count = MainActivity.count + 1
                                    finish()
                                }
                            }, modifier = Modifier.padding(16.dp)
                        )
                                {
                            Text("Save")
                        }
                        Spacer(Modifier.height(8.dp))

                        //Cancel button
                        Button(
                            onClick = {
                                finish()
                            },
                            modifier = Modifier.padding(16.dp)) {
                            Text("Cancel")
                        }

                    }
                }
            }
        }
    }
}