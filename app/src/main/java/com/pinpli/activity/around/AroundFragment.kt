package com.pinpli.activity.around

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.pinpli.R
import com.pinpli.activity.my.SettingsActivity
import com.pinpli.viewmodel.around.AroundViewModel

class AroundFragment : Fragment() {

    private lateinit var aroundViewModel: AroundViewModel

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        aroundViewModel =
                ViewModelProvider(this).get(AroundViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_around, container, false)
        var moveBtn: Button = root.findViewById(R.id.moveBtn)

        moveBtn.setOnClickListener {
            Log.e("MoveBtn","클릭")
            val intent = Intent(context, SettingsActivity::class.java)
            startActivity(intent)
            activity?.overridePendingTransition(R.anim.anim_slide_in_right, R.anim.anim_slide_out_left);
//            finish()
        }
        return root

    }
}