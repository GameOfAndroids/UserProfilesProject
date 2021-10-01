package com.tm78775.userproject.ui.user.detail

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import com.tm78775.userproject.R
import com.tm78775.userproject.databinding.UserDetailsFragmentBinding
import com.tm78775.userproject.ui.user.UserViewModel
import com.tm78775.userproject.ui.user.fadeIn
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class UserDetailsFragment : Fragment() {

    private val viewModel: UserViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return UserDetailsFragmentBinding.inflate(
            inflater,
            container,
            false
        ).apply {
            lifecycleOwner = viewLifecycleOwner
            viewmodel = viewModel
            userDetailImageView.fadeIn(800)
            nameTextView.fadeIn(1200)
            linearLayout.fadeIn(1600)
        }.root
    }

}