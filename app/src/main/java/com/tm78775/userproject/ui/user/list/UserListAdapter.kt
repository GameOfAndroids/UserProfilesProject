package com.tm78775.userproject.ui.user.list

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.LifecycleOwner
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CircleCrop
import com.tm78775.userproject.data.model.User
import com.tm78775.userproject.databinding.ItemUserBinding

class UserListAdapter(
    private val parentLifecycleOwner: LifecycleOwner,
    private val onUserTapped: (User) -> Unit
) : PagingDataAdapter<User, UserListAdapter.UserVH>(UserDiff()) {

    override fun onBindViewHolder(holder: UserVH, position: Int) {
        getItem(position)?.also {
            holder.onBind(it)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserVH {
        return ItemUserBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        ).apply {
            lifecycleOwner = parentLifecycleOwner
        }.let {
            UserVH(it)
        }
    }

    inner class UserVH(
        private val binding: ItemUserBinding
    ) : RecyclerView.ViewHolder(binding.root), View.OnClickListener {

        init {
            binding.root.setOnClickListener(this)
        }

        fun onBind(user: User) {
            binding.user = user
            Glide.with(binding.imageView)
                .load(user.picture.medium)
                .transform(CircleCrop())
                .into(binding.imageView)
        }

        override fun onClick(v: View?) {
            binding.user?.let {
                onUserTapped(it)
            }
        }
    }
}