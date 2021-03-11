package com.pinpli.activity.place

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.pinpli.R
import com.pinpli.viewmodel.place.PlaveViewModel

class PlaceFragment : Fragment() {

    private lateinit var placeViewModel: PlaveViewModel

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        placeViewModel =
                ViewModelProvider(this).get(PlaveViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_place, container, false)

        return root
    }
}