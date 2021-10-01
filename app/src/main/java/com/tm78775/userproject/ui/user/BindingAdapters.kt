package com.tm78775.userproject.ui.user

import android.view.View
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CircleCrop

object BindingAdapters {
    @JvmStatic
    @BindingAdapter("profileImage")
    fun ImageView.loadProfileImage(url: String) {
        Glide.with(context)
            .load(url)
            .transform(CircleCrop())
            .into(this)
    }

}