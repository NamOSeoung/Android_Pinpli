package com.pinpli.activity.splash

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import com.pinpli.R
import com.pinpli.activity.base.BasicActivity
import com.pinpli.activity.root.RootActivity
import kotlinx.android.synthetic.main.activity_splash.*

class SplashActivity : BasicActivity() {
    private var handler = Handler()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        init()

        handler.postDelayed({
            val intent = Intent(baseContext, RootActivity::class.java)
            startActivity(intent)
            overridePendingTransition(0, 0) //Intent 애니메이션 제 (꼭 startActivity(intents) 뒤에 넣어줘야)
            finish()
        }, 200)
    }

    private fun init() {
        getStandardSize(this)
        splashImage.margin(top = constraintVerticalRatio(designSize = 105F))
        splashImage.width(aspectRatio(360F))
        splashImage.height(aspectRatio(designSize = 360F))
    }
}