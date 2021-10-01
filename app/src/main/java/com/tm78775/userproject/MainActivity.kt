package com.tm78775.userproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.tm78775.userproject.databinding.MainActivityBinding
import com.tm78775.userproject.ui.OnBackPressedFragment
import com.tm78775.userproject.ui.user.list.UserListFragment
import dagger.hilt.android.AndroidEntryPoint

/**
 * In a real world implementation, I'd have a base activity that all activities derive from,
 * hence the "open" class, the protected [getOnBackPressedDelegate] method, and the
 * [onBackPressed] override. This is a technique I use to pass the onBackPressed event to the
 * currently visible [Fragment]. If the fragment expects to receive onBackPressed, then it
 * implements the [OnBackPressedFragment] interface.
 */
@AndroidEntryPoint
open class MainActivity : AppCompatActivity() {

    private lateinit var binding: MainActivityBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(
            this,
            R.layout.main_activity
        )
    }

    override fun onBackPressed() {
        getOnBackPressedDelegate()?.let {
            if(!it.onBackPressed())
                super.onBackPressed()
        } ?: super.onBackPressed()
    }

    protected fun getOnBackPressedDelegate(): OnBackPressedFragment? {
        supportFragmentManager
            .fragments
            .firstOrNull()
            ?.childFragmentManager
            ?.fragments
            ?.firstOrNull()
            ?.let {
                if(it is OnBackPressedFragment)
                    return it
            }

        return null
    }

}