package com.example.moviereview.data

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.example.moviereview.R

data class Movie(
    @DrawableRes val imageResourceId: Int,
    @StringRes val name: Int,
    val year :Int,
    @StringRes val movieDescription:Int,

)

val MovieReview = listOf(
    Movie(R.drawable.star_wars, R.string.Movie_name_1,2015, R.string.Movie_description_1),
    Movie(R.drawable.endgame,R.string.Movie_name_2,2019,R.string.Movie_description_2),
    Movie(R.drawable.spiderman_nwh,R.string.Movie_name_3,2021,R.string.Movie_description_3),
    Movie(R.drawable.avatar,R.string.Movie_name_4,2009,R.string.Movie_description_4),
    Movie(R.drawable.black_panther,R.string.Movie_name_5,2018,R.string.Movie_description_5),
    Movie(R.drawable.infinity_war,R.string.Movie_name_6,2018,R.string.Movie_description_6),
    Movie(R.drawable.top_gun,R.string.Movie_name_7,2022,R.string.Movie_description_7),
    Movie(R.drawable.titanic,R.string.Movie_name_8,1997,R.string.Movie_description_8),
    Movie(R.drawable.jurassic_world,R.string.Movie_name_9,2015,R.string.Movie_description_9),
)