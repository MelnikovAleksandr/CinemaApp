package ru.asmelnikov.home.presentation.components

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage

@Composable
fun ProfileImage(image: String) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp)
    ) {
        AsyncImage(
            model = image,
            contentDescription = "Profile Image",
            modifier = Modifier
                .size(50.dp)
                .clip(RoundedCornerShape(99.dp))
                .align(Alignment.BottomEnd)
                .border(
                    width = 2.dp,
                    shape = RoundedCornerShape(99.dp),
                    brush = Brush.horizontalGradient(
                        colors = listOf(
                            Color(0xFFFF00A1),
                            Color(0xFFF0004C)
                        )
                    )
                ),
            contentScale = ContentScale.Crop
        )
    }
}
