package com.signaltekno.scratchview

import androidx.compose.ui.graphics.Path

data class DragablePath(
    val path: Path,
    val width: Float = 50f
)
