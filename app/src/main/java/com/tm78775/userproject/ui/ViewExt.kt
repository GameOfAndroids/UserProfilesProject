package com.tm78775.userproject.ui

import android.view.View

fun View.fadeIn(animationTime: Long) {
    if(this.visibility == View.VISIBLE)
        return

    alpha = 0f
    visibility = View.VISIBLE

    animate().alpha(1f)
        .setDuration(animationTime)
        .setListener(null)
}