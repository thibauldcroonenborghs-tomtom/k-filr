// Copyright 2000-2021 JetBrains s.r.o. and contributors. Use of this source code is governed by the Apache 2.0 license that can be found in the LICENSE file.
import androidx.compose.desktop.DesktopMaterialTheme
import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import java.io.File

@Composable
fun CommandPanel(
    //modifier: Modifier,
    txt: String
) {
    Text(txt)
}


@Composable
fun FileDisplay(
    //modifier: Modifier,
    files: List<DisplayItem>
){
    LazyColumn {
        items(files) { file ->
            Text(file.name)
        }
    }
}

@Composable
@Preview
fun App() {
    var text by remember { mutableStateOf("Hello, World!") }

    DesktopMaterialTheme {
//        Button(onClick = {
//            text = "Hello, Desktop!"
//        }) {
//            Text(text)
//        }
        Column {
            Scaffold (
                topBar =
                    {
                        TopAppBar (modifier = Modifier.padding(bottom = 16.dp)){
                            Text("Top App Bar")
                        }
                    }
            ) {
                //TODO: add padding to split screen
                Row (modifier = Modifier.fillMaxWidth()) {
                    Box (modifier = Modifier.fillMaxWidth(0.45f).padding(horizontal = 10.dp)){ FileDisplay(listOf(DisplayItem(Type.FILE, "testFile"), DisplayItem(Type.DIRECTORY, "testDirectory")))}
                    Spacer(
                        modifier = Modifier
                            .fillMaxHeight()
                            .width(20.dp)
                    )
                    Spacer(
                        modifier = Modifier
                            .fillMaxHeight()
                            .width(10.dp)
                            .padding(horizontal = 4.dp)
                            .background(Color.Black)
                    )
                    Spacer(
                        modifier = Modifier
                            .fillMaxHeight()
                            .width(20.dp)
                    )
                    Box(modifier = Modifier.fillMaxWidth(0.45f)){FileDisplay(listOf(DisplayItem(Type.FILE, "testFile"), DisplayItem(Type.DIRECTORY, "testDirectory")))}
                }
            }
        }
    }
}

fun main() = application {
    Window(title = "k-filr",onCloseRequest = ::exitApplication) {
        App()
        //TODO: add method to enum to get Type from directory or File itself
        //File("/Users/croonenb/Desktop/tmp").walk().map { DisplayItem(Type.) }
    }
}
