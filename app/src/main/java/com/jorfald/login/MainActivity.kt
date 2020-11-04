package com.jorfald.login

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    companion object {
        const val USERNAME_KEY = "USERNAME2"
        const val AGE_KEY = "AGE"
        const val COOL_KEY = "ARE_COOL"
    }

    lateinit var usernameInput: EditText
    lateinit var passwordInput: EditText
    lateinit var errorText: TextView
    lateinit var loginButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        usernameInput = username_input
        passwordInput = password_input
        errorText = error_text
        errorText.isVisible = false

        loginButton = login_button

        loginButton.setOnClickListener {

            if (verifyInput(usernameInput.text.toString(), passwordInput.text.toString())) {
                errorText.isVisible = false


                val intent: Intent = Intent(this, UserActivity::class.java)

                intent.putExtra(USERNAME_KEY, usernameInput.text.toString())
                intent.putExtra(AGE_KEY, 12)
                intent.putExtra(COOL_KEY, true)

                startActivity(intent)


            } else {
                errorText.isVisible = true
                errorText.setTextColor(resources.getColor(R.color.red))
                errorText.text = "Feil brukernavn eller passord"
            }
        }
    }

    fun verifyInput(username: String, password: String): Boolean {
        return username == "teacher" && password == "1234"
    }
}