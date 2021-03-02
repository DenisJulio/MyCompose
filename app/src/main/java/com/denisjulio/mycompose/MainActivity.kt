package com.denisjulio.mycompose

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.Divider
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.layout
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.denisjulio.mycompose.ui.theme.MyComposeTheme

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Myapp {
                MyScreenContent()
            }
        }
    }
}

@Composable
fun Counter(count: Int, updateCount: (Int) -> Unit) {
    Button(
        onClick = { updateCount(count+1) },
        modifier = Modifier.padding(24.dp)
    ) {
        Text(text = "I've been clicked $count times")
    }
}

@Composable
fun Myapp(content: @Composable () -> Unit) {
    MyComposeTheme {
        Surface(color = Color.Yellow) {
            content()
        }
    }
}

@Composable
fun MyScreenContent(names: List<String> = listOf("Android", "Denis")) {
    val counterState = remember { mutableStateOf(0)}
    Column(modifier = Modifier.fillMaxHeight()) {
        Column(modifier = Modifier.weight(1f)) {
            for (name in names) {
                Greeting(name = name)
                Divider(color = Color.Black)
            }
        }
        Counter(
            count = counterState.value,
            updateCount = {
                counterState.value = it
            }
        )
    }
}

@Composable
fun MyTestScreen() {
    Column {
        val names = listOf(
        "Denis", "Darlen", "Sophia", "Maria", "Jose"
        )
        for (name in names) {
            Greeting(name = name)
            if (names.indexOf(name) != names.lastIndex)
                Divider(color = Color.Black)
        }
    }
}

@Composable
fun Greeting(name: String) {
    Text (
        text = "Hello $name!",
        modifier = Modifier.padding(24.dp)
    )
}

@Preview
@Composable
fun DefaultPreview() {
    Myapp {
        MyScreenContent()
    }
}

@Preview
@Composable
fun MyPreview() {
    Myapp {
        MyTestScreen()
    }
}