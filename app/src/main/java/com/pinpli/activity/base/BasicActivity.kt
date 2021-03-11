package com.pinpli.activity.base

import android.app.Activity
import android.content.Context
import android.graphics.Point
import android.util.TypedValue
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity


open class BasicActivity : AppCompatActivity() {

    var deviceWidth = 0f
    var devideHeight = 0f
    var desithGuideDeviceWidth = 360
    var desighGuideDeviceHeight = 640

    fun getStandardSize(activity: Activity) {
        val screenSize = getScreenSize(activity)
        val density = activity.resources.displayMetrics.density

        deviceWidth = (screenSize.x / density)
        devideHeight = (screenSize.y / density)
    }

    fun getScreenSize(activity: Activity): Point {
        val display = activity.windowManager.defaultDisplay
        val size = Point()
        display.getSize(size)

        return size
    }

    fun View.height(height: Float? = null) {
        layoutParams<ViewGroup.LayoutParams> {
            height?.run { layoutParams.height = dpToPx(this) }
        }
    }

    fun View.width(width: Float? = null) {
        layoutParams<ViewGroup.LayoutParams> {
            width?.run { layoutParams.width = dpToPx(this) }
        }
    }

    fun View.margin(left: Float? = null, top: Float? = null, right: Float? = null, bottom: Float? = null) {
        layoutParams<ViewGroup.MarginLayoutParams> {
            left?.run { leftMargin = dpToPx(this) }
            top?.run { topMargin = dpToPx(this) }
            right?.run { rightMargin = dpToPx(this) }
            bottom?.run { bottomMargin = dpToPx(this) }
        }
    }

    fun View.dpToPx(dp: Float): Int = context.dpToPx(dp)
    fun Context.dpToPx(dp: Float): Int = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, resources.displayMetrics).toInt()

    //디바이스 크기에 따른 비율
    fun aspectRatio(designSize: Float): Float {
        var ratio:Float
        var designRatio = (designSize/desithGuideDeviceWidth)
        ratio = deviceWidth * designRatio
        return ratio
    }

    //가로 관계 비율(수평)
    fun constraintHorizontalRatio(designSize:Float):Float {
        var ratio:Float
        var designRatio = (designSize/desithGuideDeviceWidth)
        ratio = deviceWidth * designRatio
        return ratio
    }

    //세로 관계 비율(수직)
    fun constraintVerticalRatio(designSize:Float):Float {
        var ratio: Float
        var designRatio = (designSize/desighGuideDeviceHeight)
        ratio = devideHeight * designRatio
        return ratio
    }

    inline fun <reified T : ViewGroup.LayoutParams> View.layoutParams(block: T.() -> Unit) {
        if (layoutParams is T) block(layoutParams as T)
    }

}