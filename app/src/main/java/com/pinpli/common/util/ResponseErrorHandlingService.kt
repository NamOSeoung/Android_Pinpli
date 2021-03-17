package com.pinpli.common.util

import android.util.Log
import com.google.gson.Gson
import com.pinpli.model.error.ErrorRPModel
import okhttp3.ResponseBody
import org.json.JSONObject

//Pinpli API 서버 통신 후 에러 파싱해주기 위한 공통 서비스
class ResponseErrorHandlingService {

    fun responseErrorHandling(responseBody: ResponseBody): ErrorRPModel? {
        return try {

            var gson = Gson()
            val jsonObject = JSONObject(responseBody.string())

            return gson.fromJson(jsonObject.toString(), ErrorRPModel::class.java)
        } catch (e: Exception) {
            Log.e("에러 핸들링 오류 : ", e.message)
            return null
        }
    }
}