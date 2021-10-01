package com.tm78775.userproject.ui.user

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.tm78775.userproject.data.model.User
import com.tm78775.userproject.data.model.UserResponse
import com.tm78775.userproject.data.repository.UserRepository
import com.tm78775.userproject.data.service.UserPagingSource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class UserViewModel @Inject constructor(
    private val repository: UserRepository
) : ViewModel() {

    // Get a User flow.
    fun getUsers(): Flow<PagingData<User>> {
        return repository
            .getUsers()
            .cachedIn(viewModelScope)
    }

    // Used for when the user taps on a user to inspect.
    private val _selectedUser = MutableLiveData<User>()
    val selectedUser: LiveData<User> = _selectedUser

    /**
     * Call this when a user has been tapped on.
     * @param user
     */
    fun onUserTapped(user: User) {
        _selectedUser.value = user
    }

}