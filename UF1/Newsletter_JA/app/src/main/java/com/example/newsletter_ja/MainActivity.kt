package com.example.newsletter_ja

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val nameEditText = findViewById<EditText>(R.id.editTextName)
        val emailEditText = findViewById<EditText>(R.id.editTextEmail)
        val subscribeCheckBox = findViewById<CheckBox>(R.id.checkBoxSubscribe)
        val signUpButton = findViewById<Button>(R.id.buttonSignUp)

        signUpButton.setOnClickListener {
            val name = nameEditText.text.toString().trim()
            val email = emailEditText.text.toString().trim()
            val isSubscribed = subscribeCheckBox.isChecked

            if (name.isNotEmpty() && email.isNotEmpty()) {
                val intent = Intent(this, ConfirmationActivity::class.java).apply {
                    putExtra("EXTRA_NAME", name)
                    putExtra("EXTRA_EMAIL", email)
                    putExtra("EXTRA_IS_SUBSCRIBED", isSubscribed)
                }
                startActivity(intent)
            } else {
                Toast.makeText(this, "Name and email are requiered", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
