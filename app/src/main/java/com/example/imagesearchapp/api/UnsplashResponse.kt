package com.example.imagesearchapp.api

import com.example.imagesearchapp.data.UnsplashPhoto

// untuk menampung hasil dari response json dan akan di convert gson
data class UnsplashResponse(val result: List<UnsplashPhoto>)