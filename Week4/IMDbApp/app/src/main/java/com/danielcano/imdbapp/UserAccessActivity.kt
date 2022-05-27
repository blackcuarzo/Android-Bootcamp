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

        supportFragmentManager
            .beginTransaction()
            .add(R.id.fragmentContainer,LoginFragment(::onRegistrationListener))
            .commit()
    }

    override fun navigateToRegistration() {
        supportFragmentManager
            .beginTransaction()
            .add(R.id.fragmentContainer,RegistrationFragment())
            .commit()
    }

    private fun onRegistrationListener (view: View){
        supportFragmentManager
            .beginTransaction()
            .add(R.id.fragmentContainer,RegistrationFragment())
            .commit()
    }
}