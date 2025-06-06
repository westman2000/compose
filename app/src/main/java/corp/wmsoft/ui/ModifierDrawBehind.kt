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

package corp.wmsoft.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Paint
import androidx.compose.ui.graphics.drawscope.drawIntoCanvas
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

// Наш кастомный модификатор для рисования скругленной рамки
fun Modifier.roundedBorder(
    color: Color,
    strokeWidth: Dp,
    cornerRadius: Dp
) = this.drawBehind {
    val strokeWidthPx = strokeWidth.toPx()
    val cornerRadiusPx = cornerRadius.toPx()

    // Создаем Paint для отрисовки рамки
    val paint = Paint().apply {
        this.color = color
        this.strokeWidth = strokeWidthPx
        style = androidx.compose.ui.graphics.PaintingStyle.Stroke // Только контур
    }

    // Рисуем скругленный прямоугольник
    drawIntoCanvas { canvas ->
        canvas.drawRoundRect(
            left = strokeWidthPx / 2, // Сдвиг для центрирования рамки
            top = strokeWidthPx / 2,
            right = size.width - strokeWidthPx / 2,
            bottom = size.height - strokeWidthPx / 2,
            radiusX = cornerRadiusPx,
            radiusY = cornerRadiusPx,
            paint = paint
        )
    }
}

@Preview(showBackground = true)
@Composable
fun CustomBorderModifierPreview() {
    Box(modifier = Modifier.size(150.dp, 100.dp)) {
        Text(
            text = "Текст с кастомной рамкой",
            modifier = Modifier
                .background(Color.Blue)
//                .padding(4.dp)
                .roundedBorder(color = Color.Red, strokeWidth = 4.dp, cornerRadius = 10.dp) // Применяем наш модификатор
                .padding(8.dp)
                .size(150.dp, 100.dp) // Устанавливаем размер, чтобы рамка была видна
        )
    }
}