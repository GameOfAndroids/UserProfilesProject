package com.tm78775.userproject.ui.user.detail

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.tm78775.userproject.databinding.UserDetailsFragmentBinding
import com.tm78775.userproject.ui.OnBackPressedFragment
import com.tm78775.userproject.ui.user.UserViewModel
import com.tm78775.userproject.ui.fadeIn
import com.tm78775.userproject.ui.fadeOut
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@AndroidEntryPoint
class UserDetailsFragment : Fragment(), OnBackPressedFragment {

    private val viewModel: UserViewModel by activityViewModels()
    private lateinit var binding: UserDetailsFragmentBinding
    private var popping = false

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
            binding = this
            userDetailImageView.fadeIn(800)
            nameTextView.fadeIn(1400)
            linearLayout.fadeIn(2000)
        }.root
    }

    override fun onBackPressed(): Boolean {
        if(popping) return true
        popping = true
        lifecycleScope.launch {
            binding.linearLayout.fadeOut(400)
            binding.nameTextView.fadeOut(800)
            binding.userDetailImageView.fadeOut(1200)
            delay(800)
            findNavController().popBackStack()
        }

        return true
    }
}