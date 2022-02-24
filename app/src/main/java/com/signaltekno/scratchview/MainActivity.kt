package com.signaltekno.scratchview

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.tooling.preview.Preview
import com.signaltekno.scratchview.ui.theme.ScratchViewTheme

@ExperimentalComposeUiApi
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ScratchViewTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    ScratchScreen()
                }
            }
        }
    }
}

@ExperimentalComposeUiApi
@Composable
fun ScratchScreen() {
    val overlayImage = ImageBitmap.imageResource(id = R.drawable.scratch)
    val baseImage = ImageBitmap.imageResource(id = R.drawable.rose)
    var currentPath by remember { mutableStateOf(DragablePath(path= Path()))}
    var movedOffset by remember {
        mutableStateOf<Offset?>(null)
    }

    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center){
        ScratchImage(
            overlayImage = overlayImage,
            baseImage = baseImage,
            moveOffset = movedOffset,
            onMovedOffset = { x, y ->
                 movedOffset = Offset(x, y)
            },
            currentPath = currentPath.path,
            currentPathThickness = currentPath.width,
            modifier = Modifier.align(Alignment.Center)
        )
    }
}