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

class MainActivity : ComponentActivity() {
    companion object{
    val items = arrayOf("Tent", "Marshmallows", "Flashlight")
    val categories  = arrayOf("Shelter", "Food", "Safety")
    val quantities = intArrayOf(1, 3, 2)
    val comments = arrayOf("4-person waterproof", "For S'mores", "Check batteries AA")
    var count = 3
}
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CampsitecommanderTheme {
                var Category by remember { mutableStateOf("") }
                var Quantity by remember { mutableStateOf("") }
                var Comments by remember { mutableStateOf("") }

                var total by remember { mutableStateOf(0) }
                for (i in 0 until count ){
                    total = 0
                }
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(24.dp),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text("Campsite Commander")
                    Spacer(modifier = Modifier.height(24.dp))

                    Button({ startActivity(Intent(this@MainActivity, SplashScreen::class.java))},
                        Modifier.fillMaxSize()) {
                        Text("Add gear")
                    }
                    Button({ startActivity(Intent(this@MainActivity, DetailedView::class.java))},
                        Modifier.fillMaxSize()) {
                        Text("Detailed View")
                    }
                    Button({finish()},
                        Modifier.fillMaxSize()){
                        Text("Exit")
                    }
                }

            }
        }
    }
}
