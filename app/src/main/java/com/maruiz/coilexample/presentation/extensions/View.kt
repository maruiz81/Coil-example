package com.maruiz.coilexample.presentation.extensions

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.annotation.LayoutRes
import coil.load
import kotlin.time.ExperimentalTime
import kotlin.time.TimeMark
import kotlin.time.TimeSource

fun ViewGroup.inflate(@LayoutRes layoutRes: Int): View =
    LayoutInflater.from(context).inflate(layoutRes, this, false)

@OptIn(ExperimentalTime::class)
fun ImageView.loadImage(url: String, totalMark: TimeMark) {
    val tag = "ImageLoading"
    val mark = TimeSource.Monotonic.markNow()
    this.load(url) {
        target { drawable ->
            this@loadImage.setImageDrawable(drawable)
            Log.d(tag, "Elapsed time: ${mark.elapsedNow()} $url")
            Log.d(tag, "Total time: ${totalMark.elapsedNow()}, $url")
        }
    }
}