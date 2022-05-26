package com.danielcano.imdbapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.method.LinkMovementMethod
import android.widget.Button
import android.widget.TextView
import com.danielcano.imdbapp.access.LoginFragment

class UserAccessActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_access)

        supportFragmentManager
            .beginTransaction()
            .add(R.id.fragmentContainer,LoginFragment())
            .commit()
    }
}