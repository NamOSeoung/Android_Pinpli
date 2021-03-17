package com.pinpli.common.util

import android.content.Context
import android.content.SharedPreferences

//내장 DB 공통 사용 클래스
class MySharedPreferences(context: Context) {

    var FREFS_FILENAME  = "prefs"

    var prefs: SharedPreferences = context.getSharedPreferences(FREFS_FILENAME,0)

    fun setValue(key:String, value: String) {
        prefs.edit().putString(key,value).apply()
    }

    fun getValue(key: String) : String? {
        return prefs.getString(key,"")
    }
}