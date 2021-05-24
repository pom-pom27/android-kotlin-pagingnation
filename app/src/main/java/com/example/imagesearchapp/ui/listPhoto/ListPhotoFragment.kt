package com.example.imagesearchapp.ui.listPhoto

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.imagesearchapp.R
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ListPhotoFragment : Fragment(R.layout.fragment_list_photo) {

    private val viewModel by viewModels<ListPhotoViewModel>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //to observe to the photos livedata
        //this function trigger whenever the value changes
        viewModel.photos.observe(viewLifecycleOwner) {

        }
    }
}