package com.pinpli.activity.root

import android.content.Intent
import android.content.pm.PackageManager
import android.os.Build
import android.os.Bundle
import android.util.Base64
import android.util.Log
import android.util.TypedValue
import com.kakao.sdk.auth.model.OAuthToken
import com.kakao.sdk.user.UserApiClient
import com.pinpli.R
import com.pinpli.activity.base.BasicActivity
import kotlinx.android.synthetic.main.activity_root.*
import java.security.MessageDigest
import android.content.Context

class RootActivity : BasicActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_root)

        init()
    }

    fun getKeyhash() {
        try {
            val info = packageManager.getPackageInfo(packageName, PackageManager.GET_SIGNING_CERTIFICATES)
            val signatures = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.P) {
                info.signingInfo.apkContentsSigners
            } else {
                TODO("VERSION.SDK_INT < P")
            }
            val md = MessageDigest.getInstance("SHA")
            for (signature in signatures) {
                val md: MessageDigest
                md = MessageDigest.getInstance("SHA")
                md.update(signature.toByteArray())
                val key = String(Base64.encode(md.digest(), 0))
                Log.d("Hash key:", "!!!!!!!$key!!!!!!")
            }
        } catch(e: Exception) {
            Log.e("name not found", e.toString())
        }
    }
    private fun init() {
        getStandardSize(this)
        headerLogo.run {
            this.height(aspectRatio(170F))
            this.width(aspectRatio(360F))
            this.margin(top = constraintVerticalRatio(designSize = 90F))
        }

        tourBtn.run {
            //(폰트 고정 사이즈 * textview의 고정 넓이) * 비율로 계산된 값
            this.setTextSize(TypedValue.COMPLEX_UNIT_DIP,aspectRatio(16F))
            this.height(aspectRatio(56F))
            this.width(aspectRatio(designSize = 317F))
            this.margin(top = constraintVerticalRatio(designSize = 73F))
        }

        loginGL.run {
            this.setTextSize(TypedValue.COMPLEX_UNIT_DIP,aspectRatio(16F))
            this.height(aspectRatio(21F))
            this.width(aspectRatio(86F))
            this.margin(top = constraintVerticalRatio(designSize = 37F))
        }

        leftLine.run {
            this.width(aspectRatio(141F))
            this.margin(top = constraintVerticalRatio(designSize = 48F))
        }

        rightLine.run{
            this.width(aspectRatio(141F))
            this.margin(top = constraintVerticalRatio(designSize = 48F))
        }

        kakaoBtn.run {
            this.width(aspectRatio(38F))
            this.height(aspectRatio(40F))
            this.margin(top = constraintVerticalRatio(designSize = 35F),left = constraintHorizontalRatio(designSize = 118F))
        }

        appleBtn.run {
            this.width(aspectRatio(38F))
            this.height(aspectRatio(40F))
            this.margin(top = constraintVerticalRatio(designSize = 35F),right = constraintHorizontalRatio(designSize = 118F))
        }

        tourBtn.setOnClickListener {
            Log.e("버튼 클릭 확인","버튼 클릭했다잉")
            val intent = Intent(baseContext, NavigationRootActivity::class.java)
            startActivity(intent)
            overridePendingTransition(0, 0) //Intent 애니메이션 제 (꼭 startActivity(intents) 뒤에 넣어줘야)
            finish()
        }

        kakaoBtn.setOnClickListener {
            // 로그인 공통 callback 구성
            val callback: (OAuthToken?, Throwable?) -> Unit = { token, error ->
                if (error != null) {
                    Log.e("Error", "로그인 실패", error)
                }
                else if (token != null) {
                    Log.i("Success", "로그인 성공 ${token.accessToken}")
                }
            }

            // 카카오톡이 설치되어 있으면 카카오톡으로 로그인, 아니면 카카오계정으로 로그인
            if (UserApiClient.instance.isKakaoTalkLoginAvailable(this)) {
                UserApiClient.instance.loginWithKakaoTalk(this, callback = callback)
            } else {
                UserApiClient.instance.loginWithKakaoAccount(this, callback = callback)
            }
        }
    }
}