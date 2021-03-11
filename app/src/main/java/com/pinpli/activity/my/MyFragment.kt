package com.pinpli.activity.my

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.pinpli.R
import com.pinpli.viewmodel.my.MyViewModel

class MyFragment : Fragment() {

    private lateinit var myViewModel: MyViewModel

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        myViewModel =
                ViewModelProvider(this).get(MyViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_my, container, false)

        return root
    }
}