package com.androidai.framework.scomposecomponent

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.androidai.framework.scomposecomponent.multicolorprogress.linear.InfiniteMultiColorLinearProgressIndicator
import com.androidai.framework.scomposecomponent.multicolorprogress.linear.MultiColorLinearProgressIndicator
import com.androidai.framework.scomposecomponent.ui.theme.SMultiColorProgressLibraryTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState : Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            SMultiColorProgressLibraryTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Column {
                        Box(modifier = Modifier.padding(vertical = 94.dp)) {
                            MultiColorLinearProgressIndicator(
                                progress = 0.8f, modifier = Modifier.fillMaxWidth(),
                                thickness = 2.dp, backgroundColor = Color.Blue.copy(alpha = 0.4f),
                                colors = listOf(Color.Red, Color.Green))
                        }

                        Box(modifier = Modifier.padding(vertical = 94.dp)) {
                            InfiniteMultiColorLinearProgressIndicator(
                                 modifier = Modifier.fillMaxWidth(),
                                thickness = 2.dp,
                                colors = listOf(Color.Red, Color.Green))
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun Greeting(name : String, modifier : Modifier = Modifier) {
    Text(
        text = "Hello $name!", modifier = modifier)
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    SMultiColorProgressLibraryTheme {
        Greeting("Android")
    }
}