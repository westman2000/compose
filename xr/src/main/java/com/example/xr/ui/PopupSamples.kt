package com.example.xr.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import androidx.xr.compose.spatial.SpatialPopup


@Composable
fun PopupSample(modifier: Modifier = Modifier) {

    var showPopup by remember { mutableStateOf(false) }
    var layoutDirection by remember { mutableStateOf(LayoutDirection.Ltr) }

    CompositionLocalProvider(LocalLayoutDirection provides layoutDirection) {
        Surface(modifier.fillMaxSize()) {
            val parentSize = 300.dp
            val popupSize = 100.dp
            val popupOffset = 110.dp

            Box(
                modifier = Modifier.size(parentSize).background(color = Color.Gray)/*, contentAlignment = Alignment.Center*/
            ) {
                val valueInPx = with(LocalDensity.current) { popupOffset.toPx().toInt() }
                Box(
                    Modifier.size(10.dp).background(color = Color.Black)
                ) {
                    // center
                }
                if (showPopup) {
                    SpatialPopup(offset = IntOffset(valueInPx, 0)) {
                        Box(
                            modifier = Modifier
                                .size(popupSize)
                                .background(color = Color.Yellow)
                                .testTag("box_popup_quadrant_I")
                        ) {
                            Text("q_I",
                                modifier = Modifier.testTag("popup_quadrant_I")
                                    .align(Alignment.CenterStart)
                            )
                        }
                    }
                    SpatialPopup(offset = IntOffset(0, 0)) {
                        Box(
                            modifier = Modifier
                                .size(popupSize)
                                .background(color = Color.Green)
                                .testTag("box_popup_quadrant_II")
                        ) {
                            Text("q_II",
                                modifier = Modifier.testTag("popup_quadrant_II")
                                    .align(Alignment.CenterStart)
                            )
                        }
                    }
                    SpatialPopup(offset = IntOffset(0, valueInPx)) {
                        Box(
                            modifier = Modifier
                                .size(popupSize)
                                .background(color = Color.Red)
                                .testTag("box_popup_quadrant_III")
                        ) {
                            Text("q_III",
                                modifier = Modifier.testTag("popup_quadrant_III")
                                    .align(Alignment.CenterStart)
                            )
                        }

                    }
                    SpatialPopup(offset = IntOffset(valueInPx, valueInPx)) {
                        Box(
                            modifier = Modifier
                                .size(popupSize)
                                .background(color = Color.Blue)
                                .testTag("box_popup_quadrant_IV")
                        ) {
                            Text("q_IV",
                                modifier = Modifier.testTag("popup_quadrant_IV")
                                    .align(Alignment.CenterStart)
                            )
                        }

                    }
                }
                Button(
                    modifier = Modifier.align(Alignment.BottomCenter),
                    onClick = {
                        // Меняем направление при клике
                        layoutDirection = if (layoutDirection == LayoutDirection.Ltr) {
                            LayoutDirection.Rtl
                        } else {
                            LayoutDirection.Ltr
                        }
                    }) {
                    Text("Toggle Layout Direction")
                }
                Button(modifier = Modifier.align(Alignment.BottomStart), onClick = { showPopup = !showPopup }) {
                    Text(if (showPopup) "Hide popup" else "Show popup")
                }
            }
        }
    }
}

@Composable
fun PopupSampleLtrAndRtl(modifier: Modifier = Modifier) {

    Surface(modifier.fillMaxSize()) {
        val parentSize = 300.dp
        val subParentSize = 140.dp
        val popupSize = 100.dp
        val popupOffset = 20.dp

        CompositionLocalProvider(LocalLayoutDirection provides LayoutDirection.Rtl) {
            Box(
                modifier = Modifier
                    .size(parentSize)
//                    .background(color = Color.Gray)
                    .testTag("parent_box_popup_Rtl")
            ) {
                val valueInPx = with(LocalDensity.current) { popupOffset.toPx().toInt() }
                Box(
                    modifier = Modifier
                        .size(subParentSize)
                        .background(color = Color.Black)
                        .testTag("sub_box_popup_Rtl")
                ) {
                    SpatialPopup(offset = IntOffset(valueInPx, valueInPx)) {
                        Box(
                            modifier = Modifier
                                .size(popupSize)
                                .background(color = Color.Blue)
                                .testTag("box_popup_Rtl")
                        ) {
                            Text("Rtl",
                                modifier = Modifier.testTag("popup_text_Rtl")
                                    .align(Alignment.CenterStart)
                            )
                        }

                    }
                }
            }
        }

        CompositionLocalProvider(LocalLayoutDirection provides LayoutDirection.Ltr) {
            Box(
                modifier = Modifier
                    .size(parentSize)
//                    .background(color = Color.Gray)
                    .testTag("parent_box_popup_Ltr")
            ) {
                val valueInPx = with(LocalDensity.current) { popupOffset.toPx().toInt() }
                Box(
                    modifier = Modifier
                        .size(subParentSize)
                        .background(color = Color.Black)
                        .testTag("sub_box_popup_Ltr")
                ) {
                    SpatialPopup(offset = IntOffset(valueInPx, valueInPx)) {
                        Box(
                            modifier = Modifier
                                .size(popupSize)
                                .background(color = Color.Blue)
                                .testTag("box_popup_Ltr")
                        ) {
                            Text("Ltr",
                                modifier = Modifier.testTag("popup_text_Ltr")
                                    .align(Alignment.CenterStart)
                            )
                        }

                    }
                }
            }
        }
    }
}

@Composable
fun PopupSampleLTR(modifier: Modifier = Modifier) {
    CompositionLocalProvider(LocalLayoutDirection provides LayoutDirection.Ltr) {
        Surface(modifier.fillMaxSize()) {
            val parentSize = 300.dp
            val popupSize = 100.dp
            val popupOffset = 110.dp

            Box(
                modifier = Modifier.size(parentSize).background(color = Color.Gray)/*, contentAlignment = Alignment.Center*/
            ) {
                val valueInPx = with(LocalDensity.current) { popupOffset.toPx().toInt() }

                Box(
                    Modifier.size(10.dp).background(color = Color.Black)
                ) {
                    // center
                }

                SpatialPopup(offset = IntOffset(valueInPx, 0)) {
                    Box(
                        modifier = Modifier
                            .size(popupSize)
                            .background(color = Color.Yellow)
                            .testTag("box_popup_quadrant_I")
                    ) {
                        Text("q_I",
                            modifier = Modifier.testTag("popup_quadrant_I")
                                .align(Alignment.CenterStart)
                        )
                    }
                }
                SpatialPopup(offset = IntOffset(0, 0)) {
                    Box(
                        modifier = Modifier
                            .size(popupSize)
                            .background(color = Color.Green)
                            .testTag("box_popup_quadrant_II")
                    ) {
                        Text("q_II",
                            modifier = Modifier.testTag("popup_quadrant_II")
                                .align(Alignment.CenterStart)
                        )
                    }
                }
                SpatialPopup(offset = IntOffset(0, valueInPx)) {
                    Box(
                        modifier = Modifier
                            .size(popupSize)
                            .background(color = Color.Red)
                            .testTag("box_popup_quadrant_III")
                    ) {
                        Text("q_III",
                            modifier = Modifier.testTag("popup_quadrant_III")
                                .align(Alignment.CenterStart)
                        )
                    }

                }
                SpatialPopup(offset = IntOffset(valueInPx, valueInPx)) {
                    Box(
                        modifier = Modifier
                            .size(popupSize)
                            .background(color = Color.Blue)
                            .testTag("box_popup_quadrant_IV")
                    ) {
                        Text("q_IV",
                            modifier = Modifier.testTag("popup_quadrant_IV")
                                .align(Alignment.CenterStart)
                        )
                    }

                }
            }
        }
    }
}

@Composable
fun PopupSample2(modifier: Modifier = Modifier) {
    var showPopup by remember { mutableStateOf(false) }
    val testOffset = IntOffset(30, 30)

    // State для текущего направления
    var layoutDirection by remember { mutableStateOf(LayoutDirection.Ltr) }

    CompositionLocalProvider(LocalLayoutDirection provides layoutDirection) {
        Surface(modifier.fillMaxSize()) {
            Box(
                modifier = modifier.fillMaxSize(), contentAlignment = Alignment.Center
            ) {
                Column {

                    Button(onClick = { showPopup = true }) {
                        Text("Show popup")
                    }

                    Box(
                        modifier = Modifier
                            .size(300.dp)
                            .background(color = Color.DarkGray)
                    ) {
                        if (showPopup) {
                            SpatialPopup(
//                    alignment = Alignment.Center
                                offset = testOffset
                            ) {
                                Box(
                                    modifier = Modifier
                                        .size(150.dp)
                                        .background(color = Color.Gray)
                                ) {
                                    Column {
                                        Text("Disposable Popup")
                                        Button(onClick = { showPopup = false }) {
                                            Text("Close")
                                        }
                                    }
                                }
                            }
                        }
                    }

                    Button(onClick = {
                        // Меняем направление при клике
                        layoutDirection = if (layoutDirection == LayoutDirection.Ltr) {
                            LayoutDirection.Rtl
                        } else {
                            LayoutDirection.Ltr
                        }
                    }) {
                        Text("Toggle Layout Direction")
                    }
                }
            }
        }
    }
}