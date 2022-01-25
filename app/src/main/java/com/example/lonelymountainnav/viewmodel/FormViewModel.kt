package com.example.lonelymountainnav.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.lonelymountainnav.data.User

class FormViewModel: ViewModel() {
    private var _firstName: MutableLiveData<String> = MutableLiveData()
    val firstName: LiveData<String> get() = _firstName

    private var _lastName: MutableLiveData<String> = MutableLiveData()
    val lastName: LiveData<String> get() = _lastName

    private var _email: MutableLiveData<String> = MutableLiveData()
    val email: LiveData<String> get() = _email

    private var _password: MutableLiveData<String> = MutableLiveData()
    val password: LiveData<String> get() = _password

    private var _users: MutableLiveData<List<User>> = MutableLiveData()
    val users: LiveData<List<User>> get() = _users
    private val userList: MutableList<User> = mutableListOf()


    fun addFirstName(firstName: String) {

        _firstName.value = firstName
    }

    fun addLastName(lastName: String){

        _lastName.value = lastName
    }

    fun addEmail(email: String){

        _email.value = email
    }

    fun addPassword(password: String){

        _password.value = password
    }

    fun addUser(user: User) {
        userList.add(user)

        _users.value = userList
    }
}
