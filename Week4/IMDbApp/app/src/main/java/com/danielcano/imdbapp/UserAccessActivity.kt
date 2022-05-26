package com.danielcano.imdbapp

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.danielcano.imdbapp.access.LoginFragment

class UserAccessActivity : AppCompatActivity(), AccessNavigator {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_access)

        supportFragmentManager
            .beginTransaction()
            .add(R.id.fragmentContainer,LoginFragment())
            .commit()
    }

    override fun navigateToRegister() {
        val searchIntent = Intent(this, SearchActivity::class.java)
        startActivity(searchIntent)
    }
}