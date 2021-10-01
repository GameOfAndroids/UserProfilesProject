package com.tm78775.userproject.ui

import androidx.recyclerview.widget.RecyclerView
import android.view.View

import android.graphics.Rect

/**
 * This class will apply appropriate spacing inside the recyclerview for our list of users.
 */
class RecyclerViewSpacingDecoration(
    private val verticalSpacing: Int = 0,
    private val horizontalSpacing: Int = 0
) : RecyclerView.ItemDecoration() {

    override fun getItemOffsets(
        outRect: Rect,
        view: View,
        parent: RecyclerView,
        state: RecyclerView.State
    ) {
        outRect.apply {
            if(horizontalSpacing > 0){
                horizontalSpacing / 2
            } else {
                0
            }.also { horizontalPadding ->
                left = horizontalPadding
                right = horizontalPadding
            }


            if (verticalSpacing > 0) {
                verticalSpacing / 2
            } else {
                0
            }.also { verticalPadding ->
                top = verticalPadding
                bottom = verticalPadding
            }
        }
    }

}