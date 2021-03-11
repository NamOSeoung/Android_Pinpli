package com.pinpli.activity.review

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.pinpli.R
import com.pinpli.viewmodel.review.ReviewViewModel

class ReviewFragment : Fragment() {

    private lateinit var reviewViewModel: ReviewViewModel

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        reviewViewModel =
                ViewModelProvider(this).get(ReviewViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_review, container, false)

        return root
    }
}