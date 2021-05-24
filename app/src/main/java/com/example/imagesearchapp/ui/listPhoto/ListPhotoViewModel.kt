package com.example.imagesearchapp.ui.listPhoto

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.switchMap
import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import com.example.imagesearchapp.data.UnsplashRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel

class ListPhotoViewModel @Inject constructor(private val unsplashRepository: UnsplashRepository) :
    ViewModel() {


    //contain current query on type string
    private val currentQuery = MutableLiveData(DEFAULT_QUERY)

    //contain the result of the getResult
    //switchMap to swap the old query to the latest user query
    //and we cache it in otherwise u get chas on rotating the screen bcs we cant load from the same data twice
    val photos = currentQuery.switchMap { newQuery ->
        unsplashRepository.getSearchResult(newQuery).cachedIn(viewModelScope)
    }


    //change the value from outside
    fun searchPhotos(query: String) {
        currentQuery.value = query
    }


    //add default value so when u open the first time its display list of cats
    companion object {
        private const val DEFAULT_QUERY = "cats"
    }

}