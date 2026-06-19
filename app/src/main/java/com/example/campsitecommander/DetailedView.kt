package com.example.campsitecommander

import android.os.Bundle
import android.view.accessibility.AccessibilityNodeInfo
import androidx.activity.ComponentActivity
import com.example.campsitecommander.MainActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
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
                Surface(modifier = Modifier.fillMaxSize()) {
                    Column(modifier = Modifier.padding(16.dp)) {

                        Text("Packing List")
                        Spacer(modifier = Modifier.height(8.dp))

                        //Calculating total using for loop
                        var total = 0
                        for (i in MainActivity.quantities.indices){
                            total = total + MainActivity.quantities[i]
                        }
                        Text("Total items:" + total)
                        Spacer(Modifier.height(10.dp))

                        //Show all items using LazyColumn and Loop
                        LazyColumn(modifier = Modifier.weight(1f)) {
                            items(count = MainActivity.quantities.size) { i ->
                                Column(modifier = Modifier.padding(8.dp)) {
                                    Text("Item: " + MainActivity.items[i]) //shows item
                                    Text("Category" + MainActivity.categories[i]) // show category
                                    Text("Qty" + MainActivity.quantities[i]) // show quantity
                                    Text("Note"  + MainActivity.comments[i]) //show comment
                                    Spacer(Modifier.height(8.dp))
                                }
                            }
                        }
                        //Back button to return to main screen
                        Button(
                            onClick = {
                                finish()
                            },
                            modifier = Modifier.padding(16.dp)) {
                            Text("Back")
                        }

                    }
                }

            }
        }
    }
}


