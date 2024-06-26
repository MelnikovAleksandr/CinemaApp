package ru.inspirationpoint.search.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.paging.compose.collectAsLazyPagingItems
import ru.inspirationpoint.search.presentation.components.SearchBar
import ru.inspirationpoint.search.presentation.components.SearchList

@Composable
fun SearchScreen(onNavigateDetailScreen: (String) -> Unit) {
    val viewModel: SearchViewModel = hiltViewModel()
    val pagingItem = viewModel.searchedMovieList.collectAsLazyPagingItems()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
    ) {
        SearchBar(onSearch = viewModel::onSearchEvent)
        SearchList(
            pagingItem = pagingItem,
            onNavigateDetailScreen = onNavigateDetailScreen
        )
    }
}