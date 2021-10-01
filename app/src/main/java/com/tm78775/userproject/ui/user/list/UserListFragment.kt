package com.tm78775.userproject.ui.user.list

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.snackbar.Snackbar
import com.tm78775.userproject.R
import com.tm78775.userproject.data.model.User
import com.tm78775.userproject.databinding.UserListFragmentBinding
import com.tm78775.userproject.ui.user.UserViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

@AndroidEntryPoint
class UserListFragment : Fragment() {

    private val viewModel by activityViewModels<UserViewModel>()
    private lateinit var binding: UserListFragmentBinding
    private lateinit var userListAdapter: UserListAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        userListAdapter = UserListAdapter(
            viewLifecycleOwner,
            ::onUserTapped
        )

        return UserListFragmentBinding.inflate(
            inflater,
            container,
            false
        ).apply {
            binding = this
            lifecycleOwner = viewLifecycleOwner
            viewmodel = viewModel

            recyclerView.apply {
                itemAnimator = DefaultItemAnimator()
                layoutManager = LinearLayoutManager(
                    inflater.context,
                    RecyclerView.VERTICAL,
                    false
                )
                adapter = userListAdapter
                addItemDecoration(
                    UserSpacingDecorator(
                        12,
                        24
                    )
                )
            }
        }.root
    }

    private fun onUserTapped(user: User) {
        viewModel.onUserTapped(user)
        UserListFragmentDirections
            .actionMainFragmentToUserDetailsFragment()
            .also { direction ->
                findNavController().navigate(direction)
            }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewLifecycleOwner.lifecycleScope.launch {
            viewModel.getUsers().collect { users ->
                userListAdapter.submitData(viewLifecycleOwner.lifecycle, users)
            }
        }
    }

}