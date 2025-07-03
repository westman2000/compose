package com.example.xr.ui

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.scaleIn
import androidx.compose.animation.slideIn
import androidx.compose.animation.slideOut
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.getValue
import androidx.compose.runtime.movableContentOf
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.PopupProperties
import androidx.xr.compose.spatial.Orbiter
import androidx.xr.compose.spatial.OrbiterEdge
import androidx.xr.compose.spatial.SpatialDialog
import androidx.xr.compose.spatial.SpatialElevationLevel
import androidx.xr.compose.spatial.SpatialPopup
import kotlinx.coroutines.launch
import java.util.UUID


@Composable
fun spatialPopup_performanceWithManyPopups_handlesEfficiently(modifier: Modifier = Modifier) {
    val popupCount = 100 // 50 popups to test performance
    val popups = remember {  mutableStateListOf<Int>() }

    Column {
        Button(
            onClick = {
                popups.addAll(0 until popupCount)
            },
            modifier = Modifier.testTag("addPopups")
        ) {
            Text("Add $popupCount Popups")
        }

        popups.forEach { index ->

            println("index: $index")

            SpatialPopup(
                offset = IntOffset(index * 10, index * 10),
            ) {
                Text("Popup $index", modifier = Modifier.testTag("popup_$index"))
            }
        }
    }
}

@Composable
fun spatialPopup_multipleWithDifferentProperties_maintainIndependence(modifier: Modifier = Modifier) {

    data class PopupConfig(
        val tag: String,
        val alignment: Alignment,
        val offset: IntOffset,
        val elevation: Dp
    )

    val popupConfigs = listOf(
        PopupConfig("Popup1", Alignment.TopStart, IntOffset(0, 0), 10.dp),
        PopupConfig("Popup2", Alignment.TopEnd, IntOffset(10, 10), 20.dp),
        PopupConfig("Popup3", Alignment.BottomStart, IntOffset(-10, -10), 30.dp),
        PopupConfig("Popup4", Alignment.BottomEnd, IntOffset(20, -20), 40.dp),
    )

    Box(modifier = Modifier.fillMaxSize()) {
        popupConfigs.forEach { config ->
            var dismissed by remember { mutableStateOf(false) }

            if (!dismissed) {
                SpatialPopup(
                    alignment = config.alignment,
                    offset = config.offset,
                    onDismissRequest = { dismissed = true }
                ) {
                    Card(
                        modifier = Modifier
                            .size(100.dp)
                            .testTag(config.tag)
                    ) {
                        Column(
                            modifier = Modifier
                                .fillMaxSize()
                                .padding(8.dp)
                        ) {
                            Text(config.tag)
                            Text("Level: ${config.elevation}")
                            Button(
                                onClick = { dismissed = true },
                                modifier = Modifier.testTag("dismiss_${config.tag}")
                            ) {
                                Text("X")
                            }
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun spatialPopup_withAnimatedVisibility_transitionsCorrectly(modifier: Modifier = Modifier) {
    var visible by remember { mutableStateOf(false) }

    Column {
        Button(
            onClick = { visible = !visible },
            modifier = Modifier.testTag("toggleVisibility")
        ) {
            Text(if (visible) "Hide" else "Show")
        }

        AnimatedVisibility(
            visible = visible,
            enter = scaleIn(),
            exit = fadeOut()
        ) {
            SpatialPopup(
                offset = IntOffset(200, 200),
                alignment = Alignment.Center,
            ) {
                Card(
                    modifier = Modifier
                        .size(200.dp)
                        .testTag("animatedPopup")
                ) {
                    Box(modifier = Modifier.fillMaxSize()) {
                        Text(
                            "Animated Popup",
                            modifier = Modifier.align(Alignment.Center)
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun spatialPopup_withOrbiter_positionsCorrectly(modifier: Modifier = Modifier) {
    Box(modifier = Modifier.fillMaxSize()) {
        // Orbiter at the top
        Orbiter(
            position = OrbiterEdge.Top,
            offset = 0.dp,
        ) {
            Text("Top Orbiter")
        }

        // Popup that should not interfere with orbiter
        SpatialPopup(
            alignment = Alignment.Center,
        ) {
            Box(
                modifier = Modifier
                    .size(150.dp)
                    .background(Color.Blue)
                    .testTag("centerPopup")
            ) {
                Text(
                    "Center Popup",
                    color = Color.White,
                    modifier = Modifier.align(Alignment.Center)
                )
            }
        }
    }
}

@Composable
fun spatialPopup_withLazyList_scrollsIndependently(modifier: Modifier = Modifier) {
    val items = List(50) { "Item $it" }

    Box {
        // Main content with lazy list
        LazyColumn(
            modifier = Modifier
//                .weight(1f)
                .testTag("mainList")
        ) {
            items(items) { item ->
                Text(
                    item,
                    modifier = Modifier.padding(16.dp)
                )
            }
        }

        // Popup with its own lazy list
        SpatialPopup(
            offset = IntOffset(70, 70),
        ) {
            LazyColumn(
                modifier = Modifier
                    .size(200.dp, 300.dp)
                    .background(Color.LightGray)
                    .testTag("popupList")
            ) {
                items(items) { item ->
                    Text(
                        "Popup $item",
                        modifier = Modifier.padding(8.dp)
                    )
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun spatialPopup_withModalBottomSheet_interactsCorrectly(modifier: Modifier = Modifier) {
    val scope = rememberCoroutineScope()
    val sheetState = rememberModalBottomSheetState()
    var showBottomSheet by remember { mutableStateOf(false) }
    var popupText by remember { mutableStateOf("Initial Text") }

    Scaffold {
        Column(modifier = Modifier.padding(it)) {
            // Popup that can be updated from bottom sheet
            SpatialPopup(
                alignment = Alignment.TopStart,
            ) {
                Card {
                    Column(modifier = Modifier.padding(16.dp)) {
                        Text(popupText)
                        Button(
                            onClick = { showBottomSheet = true },
                            modifier = Modifier.testTag("showSheet")
                        ) {
                            Text("Edit in Sheet")
                        }
                    }
                }
            }

            if (showBottomSheet) {
                ModalBottomSheet(
                    onDismissRequest = { showBottomSheet = false },
                    sheetState = sheetState
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(16.dp)
                    ) {
                        TextField(
                            value = popupText,
                            onValueChange = { popupText = it },
                            label = { Text("Edit Popup Text") },
                            modifier = Modifier.testTag("textField")
                        )
                        Button(
                            onClick = {
                                scope.launch {
                                    sheetState.hide()
                                    showBottomSheet = false
                                }
                            },
                            modifier = Modifier.testTag("applyChanges")
                        ) {
                            Text("Apply")
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun spatialPopup_complexContent_rendersCorrectly(modifier: Modifier = Modifier) {
    SpatialPopup {
        Column(modifier = Modifier.padding(16.dp)) {
            Text("Complex Popup Title")
            Spacer(modifier = Modifier.size(8.dp))
            Row {
                Button(onClick = {}) {
                    Text("Action 1")
                }
                Spacer(modifier = Modifier.size(8.dp))
                Button(onClick = {}) {
                    Text("Action 2")
                }
            }
            Spacer(modifier = Modifier.size(8.dp))
            Text("Additional content with multiple lines\nthat should render correctly")
        }
    }
}

@Composable
fun spatialPopup_nestedPopups_bothExist(modifier: Modifier = Modifier) {
    SpatialPopup {
        Column {
            Text("Outer Popup")
            SpatialPopup {
                Text("Inner Popup")
            }
        }
    }
}

@Composable
fun spatialDialog_withMovableContent_movesContentWithoutRecomposition(modifier: Modifier = Modifier) {
    var showInDialog by remember { mutableStateOf(true) }

    val movableContent = remember {
        movableContentOf {
            val compositionId = remember { UUID.randomUUID().toString() }
            Column { Text("Movable Content $compositionId") }
        }
    }

    Column {
        Button(
            onClick = { showInDialog = !showInDialog },
            modifier = Modifier.testTag("toggleButton"),
        ) {
            Text(if (showInDialog) "Move to Panel" else "Move to Dialog")
        }

        Box {
            if (showInDialog) {
                SpatialDialog(onDismissRequest = { showInDialog = false }) {
                    movableContent()
                }
            } else {
                movableContent()
            }
        }
    }
}
@Composable
fun spatialPopup_withMovableContent_movesContentWithoutRecomposition(modifier: Modifier = Modifier) {
    var showInPopup by remember { mutableStateOf(true) }

    val movableContent = remember {
        movableContentOf {
            val compositionId = remember { UUID.randomUUID().toString() }
            println("compositionId: $compositionId")
            Text("Movable Content $compositionId")
        }
    }

    Column {
        Button(
            onClick = { showInPopup = !showInPopup },
            modifier = Modifier.testTag("toggleButton"),
        ) {
            Text(if (showInPopup) "Move to Panel" else "Move to Popup")
        }

        Box {
            if (showInPopup) {
                SpatialPopup {
                    movableContent()
                }
            } else {
                movableContent()
            }
        }
    }
}

@Composable
fun SpatialPopup_allAlignmentOptions_positionCorrectly(modifier: Modifier = Modifier) {
    Box(modifier = Modifier.size(300.dp)) {
        // Test all alignments in one composition
        SpatialPopup(alignment = Alignment.TopStart) {
            Text("TopStart", modifier = Modifier.testTag("popup_TopStart"))
        }
        SpatialPopup(alignment = Alignment.TopCenter) {
            Text("TopCenter", modifier = Modifier.testTag("popup_TopCenter"))
        }
        SpatialPopup(alignment = Alignment.TopEnd) {
            Text("TopEnd", modifier = Modifier.testTag("popup_TopEnd"))
        }
        SpatialPopup(alignment = Alignment.CenterStart) {
            Text("CenterStart", modifier = Modifier.testTag("popup_CenterStart"))
        }
        SpatialPopup(alignment = Alignment.Center) {
            Text("Center", modifier = Modifier.testTag("popup_Center"))
        }
        SpatialPopup(alignment = Alignment.CenterEnd) {
            Text("CenterEnd", modifier = Modifier.testTag("popup_CenterEnd"))
        }
        SpatialPopup(alignment = Alignment.BottomStart) {
            Text("BottomStart", modifier = Modifier.testTag("popup_BottomStart"))
        }
        SpatialPopup(alignment = Alignment.BottomCenter) {
            Text("BottomCenter", modifier = Modifier.testTag("popup_BottomCenter"))
        }
        SpatialPopup(alignment = Alignment.BottomEnd) {
            Text("BottomEnd", modifier = Modifier.testTag("popup_BottomEnd"))
        }
    }
}

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