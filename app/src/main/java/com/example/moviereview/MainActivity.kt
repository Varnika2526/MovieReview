package com.example.moviereview

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.wear.tiles.material.Text
import com.example.moviereview.data.Movie
import com.example.moviereview.data.MovieReview
import com.example.moviereview.ui.theme.MovieReviewTheme




class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MovieReviewTheme {
                // A surface container using the 'background' color from the theme
                MovieReviewApp()


            }
        }
    }
}
@Composable
fun MovieReviewApp() {
    Scaffold(
        topBar = {
            MovieReviewTopAppBar()
        }
    ) {
        LazyColumn(modifier = Modifier.background(MaterialTheme.colors.background)) {
            items(MovieReview) {
                MovieItem(movie = it)
            }
        }
    }
}

@Composable
fun MovieItem(movie: Movie, modifier:Modifier = Modifier)
{
    var expanded by remember { mutableStateOf(false) }
    Card(
        elevation = 4.dp,
        modifier = Modifier.padding(8.dp)
    ) {
        Column(
            modifier = androidx.compose.ui.Modifier
                .animateContentSize(
                    animationSpec = spring(
                        dampingRatio = Spring.DampingRatioMediumBouncy,
                        stiffness = Spring.StiffnessLow
                    )
                )
        ) {
            Row(
                modifier = androidx.compose.ui.Modifier
                    .fillMaxWidth()
                    .padding(8.dp)
            ) {
                MovieIcon(movie.imageResourceId)
                MovieInformation(movie.name, movie.year)
                Spacer(Modifier.weight(1f))


                MovieItemButton(
                    expanded = expanded,
                    onClick = { expanded = !expanded },
                )
            }

        }

    }
}


@Composable
private fun MovieItemButton(
    expanded: Boolean,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {


}


@Composable
fun MovieReviewTopAppBar(modifier: Modifier = Modifier) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .background(color = MaterialTheme.colors.primary),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            modifier = modifier
                .size(64.dp)
                .padding(8.dp),
            painter = painterResource(R.drawable.icon),
            /*
             * Content Description is not needed here - image is decorative, and setting a null
             * content description allows accessibility services to skip this element during
             * navigation.
             */
            contentDescription = null
        )
        Text(
            text = stringResource(R.string.app_name),
            style = MaterialTheme.typography.h1
        )
    }
}
@Composable
fun MovieIcon(@DrawableRes MovieIcon: Int, modifier: Modifier = Modifier) {
    Image(
        modifier = modifier
            .size(120.dp)
            .padding(8.dp)
            .clip(RoundedCornerShape(50)),
        contentScale = ContentScale.Crop,
        painter = painterResource(MovieIcon),
        contentDescription = null
    )
}


@Composable
fun MovieInformation(@StringRes name: Int,year: Int, modifier: Modifier = Modifier) {
    Column {
        Text(
            text = stringResource(name),
            style = MaterialTheme.typography.h2,
            modifier = modifier.padding(top = 8.dp)
        )
        Text(
            text = stringResource(R.string.release_year, year),
            style = MaterialTheme.typography.body1)

    }
}
@Composable
fun movieDescription(@StringRes movieDescription: Int, modifier: Modifier = Modifier) {
    Column(
        modifier = modifier.padding(
            start = 16.dp,
            top = 8.dp,
            bottom = 16.dp,
            end = 16.dp
        )
    ) {
        Text(
            text = stringResource(R.string.about),
            style = MaterialTheme.typography.h3
        )

        Text(
            text = stringResource(movieDescription),
            style = MaterialTheme.typography.body1
        )
    }
}

@Preview
@Composable
fun MovieReviewPreview() {
    MovieReviewTheme(darkTheme = false) {
        MovieReviewApp()
    }
}


@Preview
@Composable
fun MovieReviewDarkThemePreview() {
    MovieReviewTheme(darkTheme = true) {
        MovieReviewApp()
    }
}