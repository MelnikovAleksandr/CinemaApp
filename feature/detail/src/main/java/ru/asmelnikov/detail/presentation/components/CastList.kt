package ru.asmelnikov.detail.presentation.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import ru.asmelnikov.detail.domain.model.CastUI
import ru.asmelnikov.util.Constants.IMAGE_BASE_URL

@Composable
fun CastList(cast: List<CastUI>) {
    LazyRow() {
        items(cast.size) { index ->
            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                AsyncImage(
                    modifier = Modifier
                        .size(80.dp)
                        .clip(CircleShape),
                    contentScale = ContentScale.Crop,
                    model = (IMAGE_BASE_URL + "/w300" + cast[index].profilePath),
                    contentDescription = "Cast Profile Image"
                )
                cast[index].name?.let {
                    Text(
                        text = it,
                        color = MaterialTheme.colorScheme.onBackground.copy(alpha = 0.8f),
                        fontSize = 16.sp,
                        modifier = Modifier.padding(vertical = 2.dp, horizontal = 10.dp)
                    )
                }
                cast[index].character?.let {
                    Text(
                        text = it,
                        color = MaterialTheme.colorScheme.onBackground.copy(alpha = 0.5f),
                        fontSize = 14.sp,
                        modifier = Modifier.padding(vertical = 2.dp, horizontal = 10.dp)
                    )
                }
            }
            Spacer(modifier = Modifier.width(5.dp))
        }
    }
}