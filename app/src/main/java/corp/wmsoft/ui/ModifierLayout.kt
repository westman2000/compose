/*
 * Copyright 2025 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
@file:Suppress("SpellCheckingInspection")

package com.example.composelearning.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.layout
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

// Наш кастомный модификатор для сдвига
fun Modifier.offsetCustom(x: Dp, y: Dp) = layout { measurable, constraints ->
    // 1. Измеряем дочерний элемент с учетом родительских ограничений
    val placeable = measurable.measure(constraints)

    // 2. Определяем размер нашего модификатора. В данном случае,
    // он будет равен размеру дочернего элемента
    val width = placeable.width
    val height = placeable.height

    // 3. Располагаем наш модификатор и затем размещаем дочерний элемент
    // внутри него со сдвигом.
    layout(width, height) {
        placeable.placeRelative(x.roundToPx(), y.roundToPx())
    }
}

@Preview(showBackground = true)
@Composable
fun CustomOffsetModifierPreview() {
    Box(modifier = Modifier.size(200.dp).background(Color.LightGray)) {
        Text(
            text = "Сдвинутый текст",
            modifier = Modifier
                .offsetCustom(x = 50.dp, y = 30.dp) // Применяем наш кастомный модификатор
                .background(Color.Blue.copy(alpha = 0.5f))
                .padding(8.dp)
        )
    }
}