package com.example.lonelymountainnav.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class FormViewModel: ViewModel() {
    private var _name: MutableLiveData<List<Name>> = MutableLiveData()
    val name: LiveData<List<Name>> get() = _name
    private val nameList: MutableList<Name> = mutableListOf()

    private var _email: MutableLiveData<List<Email>> = MutableLiveData()
    val email: LiveData<List<Email>> get() = _email
    private val emailList: MutableList<Email> = mutableListOf()

    private var _password: MutableLiveData<List<Password>> = MutableLiveData()
    val password: LiveData<List<Password>> get() = _password
    private val passwordList: MutableList<Password> = mutableListOf()


    fun addName(name: Name) {
        nameList.add(name)

        _name.value = nameList
    }

    fun addEmail(email: Email){
        emailList.add(email)

        _email.value = emailList
    }

    fun addPassword(password: Password){
        passwordList.add(password)

        _password.value = passwordList
    }
}

data class Name(
    val firstName: String,
    val lastName: String,
)

data class Email(
    val email: String,
)

data class Password(
    val password: String,
)