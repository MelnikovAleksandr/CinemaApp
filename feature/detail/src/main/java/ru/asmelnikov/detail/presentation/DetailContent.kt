package ru.asmelnikov.detail.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import ru.asmelnikov.components.views.LoadingPage
import ru.asmelnikov.detail.data.model.detail.Genre
import ru.asmelnikov.detail.domain.model.CastUI
import ru.asmelnikov.detail.domain.model.MovieDetailUI
import ru.asmelnikov.detail.presentation.components.CastList
import ru.asmelnikov.detail.presentation.components.GenreList
import ru.asmelnikov.detail.presentation.components.WatchButton

@Composable
fun DetailContent(
    movie: MovieDetailUI?,
    isLoading: Boolean,
    cast: List<CastUI>,
    onBackClick: () -> Unit,
    onSaveWatchlistClick: () -> Unit,
    onWatchClick: () -> Unit
) {
    val screenHeight = LocalConfiguration.current.screenHeightDp / 2
    val gradient = Brush.verticalGradient(
        colors = listOf(
            Color(0xFF000000),
            Color(0xB3000000),
            Color(0x4D000000),
            Color(0x12000000),
            Color(0x4D000000),
            Color(0xB3000000),
            Color(0xFF000000)
        )
    )
    if (isLoading)
        LoadingPage()
    else {
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .background(MaterialTheme.colorScheme.background)
        ) {
            item {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(screenHeight.dp),
                ) {
                    AsyncImage(
                        modifier = Modifier.fillMaxSize(),
                        model = "https://image.tmdb.org/t/p/w780/${movie?.backDropPath}",
                        contentDescription = "Image Photo",
                        contentScale = ContentScale.Crop
                    )
                    Box(
                        modifier = Modifier
                            .fillMaxSize()
                            .background(brush = gradient),
                    ) {
                        IconButton(
                            onClick = onBackClick
                        ) {
                            Icon(
                                imageVector = Icons.Filled.ArrowBack,
                                contentDescription = "Back Icon",
                                tint = Color.White
                            )
                        }
                        IconButton(
                            modifier = Modifier.align(Alignment.BottomEnd),
                            onClick = { onSaveWatchlistClick() }
                        ) {
                            Icon(
                                imageVector = Icons.Filled.Favorite,
                                contentDescription = "Save Icon",
                                tint = Color.Red
                            )
                        }
                    }
                    WatchButton(onWatchClick = onWatchClick)
                }
            }
            item {
                Column(modifier = Modifier.padding(horizontal = 10.dp)) {
                    Spacer(modifier = Modifier.height(20.dp))
                    movie?.title?.let {
                        Text(
                            text = it,
                            fontSize = 25.sp,
                            color = MaterialTheme.colorScheme.onBackground,
                            fontWeight = FontWeight.SemiBold
                        )
                    }
                    Spacer(modifier = Modifier.height(15.dp))
                    Box(
                        modifier = Modifier
                            .clip(RoundedCornerShape(99.dp))
                            .background(Color(0xFF3F55C6))
                    ) {
                        movie?.status?.let {
                            Text(
                                text = it,
                                color = Color.White,
                                fontSize = 14.sp,
                                modifier = Modifier.padding(vertical = 5.dp, horizontal = 15.dp)
                            )
                        }
                    }
                    Spacer(modifier = Modifier.height(10.dp))

                    movie?.genres?.let { GenreList(genres = it) }
                    Spacer(modifier = Modifier.height(15.dp))
                    movie?.overview?.let {
                        Text(
                            text = it,
                            fontSize = 14.sp,
                            color = MaterialTheme.colorScheme.onBackground,
                        )
                    }
                    Spacer(modifier = Modifier.height(30.dp))
                    Text(
                        text = "Cast",
                        color = MaterialTheme.colorScheme.onBackground,
                        fontWeight = FontWeight.Bold,
                        fontSize = 20.sp
                    )
                    Spacer(modifier = Modifier.height(10.dp))
                    CastList(cast = cast)
                }
            }
        }
    }
}