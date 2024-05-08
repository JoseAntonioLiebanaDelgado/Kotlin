package com.lasalle.newsletter

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

const val NEWSLETTER = "newsletter"

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val tvName: EditText = findViewById(R.id.et_name)
        val tvEmail: EditText = findViewById(R.id.et_email)
        val btSignup: Button = findViewById(R.id.bt_signup)
        val checkSubscribe: CheckBox = findViewById(R.id.cb_subs)
        val tvHelp: TextView = findViewById(R.id.tv_help)

        btSignup.setOnClickListener {
            val intent = Intent(this, SecondActivity::class.java)
            if (tvName.text.toString().isNotEmpty() && tvEmail.text.toString().isNotEmpty()) {
                val newsletter = Newsletter(tvName.text.toString(), tvEmail.text.toString(), checkSubscribe.isChecked)
                intent.putExtra(NEWSLETTER, newsletter)
                startActivity(intent)
            } else {
                Toast.makeText(this, getString(R.string.error), Toast.LENGTH_SHORT).show()
            }
        }

        tvHelp.setOnClickListener {
            val webpage: Uri = Uri.parse("https://newsletterguide.org")
            val intent = Intent(Intent.ACTION_VIEW, webpage)
            startActivity(intent)
        }
    }
}
