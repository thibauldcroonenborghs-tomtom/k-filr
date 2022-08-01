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
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application

@Composable
fun CommandPanel(
    //modifier: Modifier,
    txt: String
) {
    Text(txt)
}


@Composable
fun FileDisplay(
    modifier: Modifier,
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
//        Box {
//            CommandPanel(modifier = Modifier
//                .fillMaxWidth()
//                .background(MaterialTheme.colors.surface)
//                .background(Color.White)
//                .padding(start = 16.dp, end = 16.dp),
//                txt = "Command panel"
//            )
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
                //next: split screen
                Row (modifier = Modifier.fillMaxWidth()) {
                    Box (modifier = Modifier.fillMaxWidth(0.5f)){ FileDisplay(Modifier.fillMaxWidth(0.5f), listOf(DisplayItem(Type.FILE, "testFile"), DisplayItem(Type.DIRECTORY, "testDirectory")))}
//                    Divider(
//                        color = Color.Black,
//                        thickness = 1.dp,
//                        modifier = Modifier.shadow(elevation = 2.dp)
//                    )
                    Box(modifier = Modifier.fillMaxWidth(0.5f)){FileDisplay(Modifier.fillMaxWidth(0.5f), listOf(DisplayItem(Type.FILE, "testFile"), DisplayItem(Type.DIRECTORY, "testDirectory")))}
                }
            }
        }
//        Box {
//            Column (Modifier.fillMaxHeight()){
//                Text("From files")
//            }
//            Column (Modifier.fillMaxHeight()){
//                Text("To files")
//            }
//        }
    }
}

fun main() = application {
    Window(title = "k-filr",onCloseRequest = ::exitApplication) {
        App()
    }
}
