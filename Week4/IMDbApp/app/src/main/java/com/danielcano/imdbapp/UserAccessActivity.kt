package com.danielcano.imdbapp

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.danielcano.imdbapp.access.LoginFragment

class UserAccessActivity : AppCompatActivity(), AccessNavigator {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_access)

        //Starting proposal
        supportFragmentManager
            .beginTransaction()
            .add(R.id.fragmentContainer,LoginFragment{
                val searchIntent = Intent(this, SearchActivity::class.java)
                startActivity(searchIntent)
            })
            .commit()
        //Better with a function
        supportFragmentManager
            .beginTransaction()
            .add(R.id.fragmentContainer,LoginFragment(onRegistrationListener1()))
            .commit()

        //Second way to do it
        supportFragmentManager
            .beginTransaction()
            .add(R.id.fragmentContainer,LoginFragment(::onRegistrationListener2))
            .commit()
    }

    override fun navigateToRegister() {
        val searchIntent = Intent(this, SearchActivity::class.java)
        startActivity(searchIntent)
    }

    private fun onRegistrationListener1():(view: View)->Unit = {
        val searchIntent = Intent(this, SearchActivity::class.java)
        startActivity(searchIntent)
    }

    private fun onRegistrationListener2 (view: View){
        val searchIntent = Intent(this, SearchActivity::class.java)
        startActivity(searchIntent)
    }
}