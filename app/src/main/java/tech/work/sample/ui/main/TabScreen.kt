package tech.work.sample.ui.main

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import tech.work.sample.domain.entity.Movie

@Composable
fun TabScreen(
    text: String,
    movieItems: List<Movie>,
    modifier: Modifier = Modifier,
) {
    LazyColumn {
        itemsIndexed(
            items = movieItems,
            key = { _, item -> item.id },
        ) { index, movieItem ->
            MovieRowItem(
                item = movieItem
            )

            if (index < movieItems.lastIndex) {
                Divider(
                    modifier = Modifier.padding(horizontal = 8.dp),
                )
            }
        }
    }
    Box(
        modifier = Modifier
            .fillMaxSize(),
        contentAlignment = Alignment.Center,
    ) {
        Text(
            text = text,
            style = MaterialTheme.typography.body1,
        )
    }
}