package com.jorfald.login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_user.*

class UserActivity : AppCompatActivity() {

    lateinit var usernameText: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user)

        usernameText = username_text

        val username = intent.getStringExtra(MainActivity.USERNAME_KEY)
        val age = intent.getIntExtra(MainActivity.AGE_KEY, 0)
        val isCool = intent.getBooleanExtra(MainActivity.COOL_KEY, false)

        var text = "Hi $username. You are $age years old."
        if (isCool) {
            text += "\nAND YOU ARE COOL..."
        }

        usernameText.text = text

        usernameText.setOnClickListener {
            val intent: Intent = Intent(this, DetailsActivity::class.java)
            startActivity(intent)
        }
    }
}