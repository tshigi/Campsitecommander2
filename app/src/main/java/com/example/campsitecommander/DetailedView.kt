package com.example.campsitecommander

import android.os.Bundle
import androidx.activity.ComponentActivity
import com.example.campsitecommander.MainActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.campsitecommander.ui.theme.CampsitecommanderTheme

class DetailedView : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CampsitecommanderTheme {

                Column(Modifier.fillMaxSize().padding(16.dp)) {
                    Text("Packing List")
                    Spacer(modifier = Modifier.height(8.dp))

                    LazyColumn(
                        modifier = Modifier.weight(1f)
                    ) {
                        items(count = MainActivity.count){ i ->
                                Column(Modifier.padding(8.dp)){
                                }
                            }

                        }


                    }
                    Button({ finish()},
                        Modifier.fillMaxSize()){
                        Text("Back to main screen")
                    }
                }
            }
        }
    }

