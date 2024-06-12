package ru.asmelnikov.detail.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ru.asmelnikov.detail.data.model.detail.Genre

@Composable
fun GenreList(genres: List<Genre>) {
    LazyRow {
        items(genres.size) { index ->
            Box(
                modifier = Modifier
                    .clip(RoundedCornerShape(99.dp))
                    .background(MaterialTheme.colorScheme.tertiary)
            ) {
                Text(
                    text = genres[index].name,
                    color = Color.White,
                    fontSize = 14.sp,
                    modifier = Modifier.padding(vertical = 5.dp, horizontal = 15.dp)
                )
            }
            Spacer(modifier = Modifier.width(5.dp))

        }
    }
}