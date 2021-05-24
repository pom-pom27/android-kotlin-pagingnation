package com.example.imagesearchapp.data

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class UnsplashPhoto(
    val id: String,
    val description: String?,
    val urls: UnsplashPhotoUrl,
    val user: UnsplashPhotoUser
) : Parcelable {
    @Parcelize
    data class UnsplashPhotoUrl(
        val raw: String,
        val full: String,
        val regular: String,
        val small: String,
        val thumb: String,
    ) : Parcelable

    @Parcelize
    data class UnsplashPhotoUser(val name: String, val username: String) : Parcelable {
        val attributionUrl get() = "https://unsplash.com/$username?utm_source=ImageSearchApp&utm_medium=referral"
    }

}