package com.example.composesubmission.model

import android.graphics.Bitmap
import android.net.Uri

class ItemList(
    val id : Int = 0,
    val image: Int = 0,
    val title: String = "Title",
    val description: String = "Description",
    val synopsis: String = "synopsis",
    val genres: String = "Genres",
    val isFavorite: Boolean = false
)

class ItemListURI(
    val id : Int = 0,
    val image: Uri? = null,
    val bitmap: Bitmap? = null,
    val title: String = "Title",
    val description: String = "Description",
    val synopsis: String = "synopsis",
    val genres: String = "Genres",
    val isFavorite: Boolean = false
)