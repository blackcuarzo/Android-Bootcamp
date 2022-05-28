package com.danielcano.imdbapp

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.danielcano.imdbapp.access.LoginFragment
import com.danielcano.imdbapp.access.RegistrationFragment

class UserAccessActivity : AppCompatActivity(), AccessNavigator {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_access)


    }

    override fun navigateToRegistration() {

    }

    private fun onRegistrationListener (view: View){

    }
}