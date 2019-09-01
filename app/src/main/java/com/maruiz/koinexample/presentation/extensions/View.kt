package com.maruiz.koinexample.presentation.extensions

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.annotation.LayoutRes
import coil.Coil
import coil.api.load
import kotlin.time.ExperimentalTime
import kotlin.time.MonoClock

fun ViewGroup.inflate(@LayoutRes layoutRes: Int): View =
    LayoutInflater.from(context).inflate(layoutRes, this, false)

@UseExperimental(ExperimentalTime::class)
fun ImageView.loadImage(url: String) {
    val TAG = "ImageLoading"
    totalMark
    val mark = MonoClock.markNow()
    Coil.load(context, url) {
        target { drawable ->
            this@loadImage.setImageDrawable(drawable)
            Log.d(TAG, "Elapsed time: ${mark.elapsedNow()} $url")
            Log.d(TAG, "Total time: ${totalMark.elapsedNow()}, $url")
        }
    }
}

@UseExperimental(ExperimentalTime::class)
private val totalMark by lazy { MonoClock.markNow() }