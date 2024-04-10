package com.example.newsletter_ja

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity


class ConfirmationActivity : AppCompatActivity() {

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_confirmation)

        val name = intent.getStringExtra("EXTRA_NAME") ?: ""
        val email = intent.getStringExtra("EXTRA_EMAIL") ?: ""
        val isSubscribed = intent.getBooleanExtra("EXTRA_IS_SUBSCRIBED", false)

        val confirmationMessageTextView = findViewById<TextView>(R.id.textViewConfirmationMessage)

        val confirmationMessage = if (isSubscribed) {
            "$name, thank you for joining our mailing list. You will get our monthly newsletter at $email!"
        } else {
            "$name, thank you for joining our mailing list."
        }
        confirmationMessageTextView.text = confirmationMessage
    }
}
