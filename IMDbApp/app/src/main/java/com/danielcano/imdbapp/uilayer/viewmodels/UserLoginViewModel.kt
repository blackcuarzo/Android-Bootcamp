package com.danielcano.imdbapp.uilayer.viewmodels

import android.util.Log
import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.danielcano.imdbapp.App
import com.danielcano.imdbapp.datalayer.repositories.UserRepositoryImpl
import com.danielcano.imdbapp.domainlayer.usecases.UserValidationUseCaseImpl
import kotlinx.coroutines.launch

class UserLoginViewModel : ViewModel() {
    private var userValidationUseCase: UserValidationUseCaseImpl =
        UserValidationUseCaseImpl(UserRepositoryImpl())
    private var _loginStatus = MutableLiveData<Boolean>()
    val loginStatus: LiveData<Boolean> = _loginStatus

    init {
        _loginStatus.value = false
    }

    fun loginUser(userName: String, userPass: String) {
        try {
            viewModelScope.launch {
                if (userValidationUseCase.validateUser(userMail = userName, userPass = userPass)) {
                    _loginStatus.value = true
                } else {
                    val toast = Toast.makeText(
                        App.getContext(),
                        "Not valid User or credentials",
                        Toast.LENGTH_SHORT
                    )
                    toast.show()
                }
            }
        } catch (e: Exception) {
            Log.e("error de userValidationUseCase", e.toString())
        }
    }
}