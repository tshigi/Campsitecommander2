package com.example.campsitecommander

import android.content.Intent
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
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.campsitecommander.ui.theme.CampsitecommanderTheme
import java.nio.file.WatchEvent

class MainActivity : ComponentActivity() {
    companion object{
    var items = arrayOf("Tent", "Marshmallows", "Flashlight")
    var categories  = arrayOf("Shelter", "Food", "Safety")
    var quantities = intArrayOf(1, 3, 2)
    var comments = arrayOf("4-person waterproof", "For S'mores", "Check batteries AA")
    var count = 3
}
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CampsitecommanderTheme {
                Surface(modifier = Modifier.fillMaxSize()) {
                    Column(modifier = Modifier.padding(16.dp)) {

                        Text("Campsite Commander")
                        Spacer(Modifier.height(20.dp))

                        //Calculate total items using a for loop
                        var total = 0
                        for (i in 0 until count) {
                            total = total +  quantities[i]
                        }
                        Text("Total items:" + total)
                        Spacer(Modifier.height(20.dp))

                        //Adding a button to go to AddGear screen
                        Button(
                            onClick ={
                                val intent = Intent(this@MainActivity, AddGear::class.java)
                                startActivity(intent)
                            },
                            modifier = Modifier.padding(16.dp)) {
                            Text("Add to Gear")
                        }
                        Spacer(Modifier.height(10.dp))

                        //Adding a button to go to detailed screen
                        Button(
                            onClick = {
                                val intent = Intent(this@MainActivity, DetailedView::class.java)
                                startActivity(intent)
                            },
                            modifier = Modifier.padding(16.dp)) {
                            Text("View Details")
                        }
                    }

                }
                    }
                }

            }
        }

