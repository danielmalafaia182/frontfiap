package br.com.fiap.locamail.login

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class LoginScreenViewModel: ViewModel() {

    private val _email = MutableLiveData<String>()
    val email: LiveData<String> = _email

    fun onEmailChange(inputedEmail: String){
        _email.value = inputedEmail
    }
}