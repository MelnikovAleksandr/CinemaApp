package ru.inspirationpoint.search.data.mapper

import ru.inspirationpoint.search.data.model.SearchResult
import ru.inspirationpoint.search.domain.model.SearchUI

fun SearchResult.toSearchUI(): SearchUI {
    return SearchUI(
        id = id.toString(),
        title = title,
        image = posterPath,
        releaseDate = releaseDate,
        overview = overview
    )
}