package com.example.lonelymountainnav.adapters

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.lonelymountainnav.databinding.ItemUserBinding
import com.example.lonelymountainnav.dataclasses.User

class UserAdapter(
    private val userList: List<User>
): RecyclerView.Adapter<UserAdapter.UserViewHolder>(){


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemUserBinding.inflate(inflater, parent, false)
        return UserViewHolder(binding)
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        holder.bind(userList[position])
    }

    override fun getItemCount(): Int {
        return userList.size
    }

    class UserViewHolder(private val binding: ItemUserBinding):
        RecyclerView.ViewHolder(binding.root){

            @SuppressLint("SetTextI18n")
            fun bind(user: User){
                with(binding){
                    nameTv.text = "Name: ${user.name}"
                    emailTv.text = "Email: ${user.email}"
                    passwordTv.text = "Password: ${user.password}"
                }
            }
    }
}