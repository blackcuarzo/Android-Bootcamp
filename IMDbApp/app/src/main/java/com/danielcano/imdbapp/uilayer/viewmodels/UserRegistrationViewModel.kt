package com.danielcano.imdbapp.uilayer.viewmodels

import android.util.Log
import android.util.Patterns
import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.danielcano.imdbapp.App
import com.danielcano.imdbapp.datalayer.databases.User
import com.danielcano.imdbapp.datalayer.repositories.UserRepositoryImpl
import com.danielcano.imdbapp.domainlayer.usecases.UserValidationUseCaseImpl
import kotlinx.coroutines.launch

class UserRegistrationViewModel : ViewModel() {
    private var userValidationUseCase: UserValidationUseCaseImpl =
        UserValidationUseCaseImpl(UserRepositoryImpl())
    private var _registrationStatus = MutableLiveData<Boolean>()
    val registrationStatus: LiveData<Boolean> = _registrationStatus

    init {
        _registrationStatus.value = false
    }

    fun registerUser(name: String, email: String, pass: String){
        when {
            name.isEmpty() -> showErrorMessage("Por favor introducir el Nombre")
            email.isEmpty() -> showErrorMessage("Por favor introducir Email")
            pass.isEmpty() -> showErrorMessage("Por favor introducir contraseña")
            pass.length < 8 -> showErrorMessage("La contraseña debe tener por lo menos 8 caracteres")
            !Patterns.EMAIL_ADDRESS.matcher(email).matches() -> showErrorMessage("Email no válido")
            else -> {
                viewModelScope.launch {
                    try {
                        if(userValidationUseCase.userExists(email)){
                            showErrorMessage("Un usuario con ese correo electrónico ya existe")
                        }else{
                            userValidationUseCase.registerUser(
                                User(
                                    name = name,
                                    email = email,
                                    password = pass
                                )
                            )
                            if (userValidationUseCase.validateUser(userMail = email, userPass = pass) ) {
                                _registrationStatus.value = true
                            }
                            else{showErrorMessage("Hubo un problema al intentar registrar")}
                        }
                    } catch (e: Exception) {
                        Log.e("error de userValidationUseCase", e.toString())
                    }
                }
//                viewModelScope.launch {
//                    try {
//                        if (userValidationUseCase.validateUser(userMail = name, userPass = pass)) {
//                            _registrationStatus.value = true
//                        }
//                    } catch (e: Exception) {
//                        Log.e("error de userValidationUseCase", e.toString())
//                    }
//                }
            }
        }
    }
    private fun showErrorMessage(message:String){
        val toast = Toast.makeText(
            App.getContext(),
            message,
            Toast.LENGTH_SHORT
        )
        toast.show()
    }
}