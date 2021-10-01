package com.tm78775.userproject.ui

import android.app.Activity

interface OnBackPressedFragment {

    /**
     * This will be invoked when the user taps the back button.
     * @return Return true if the event has been handled. Return false if
     * the hosting [Activity] should handle it.
     */
    fun onBackPressed(): Boolean
}