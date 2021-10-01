package com.tm78775.userproject.ui

import android.animation.Animator
import android.animation.AnimatorListenerAdapter
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

fun View.fadeOut(animationTime: Long) {
    if(this.alpha == 0f || this.visibility == View.INVISIBLE || this.visibility == View.GONE)
        return

    this.animate()
        .alpha(0f)
        .setDuration(animationTime)
        .setListener(object : AnimatorListenerAdapter() {
            override fun onAnimationEnd(animation: Animator?) {
                super.onAnimationEnd(animation)
                visibility = View.INVISIBLE
            }
        })
}