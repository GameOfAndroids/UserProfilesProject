package com.tm78775.userproject.ui.user.list

import androidx.recyclerview.widget.DiffUtil
import com.tm78775.userproject.data.model.User

class UserDiff : DiffUtil.ItemCallback<User>() {

    override fun areItemsTheSame(oldItem: User, newItem: User): Boolean {
        return oldItem.id.value == newItem.id.value
    }

    override fun areContentsTheSame(oldItem: User, newItem: User): Boolean {
        // todo: in a real live application, check for changes in the object that should invoke UI refresh.
        return true
    }
}