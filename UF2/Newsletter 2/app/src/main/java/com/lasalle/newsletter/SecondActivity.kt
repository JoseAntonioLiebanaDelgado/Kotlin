package com.lasalle.newsletter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        val newsletter = intent.getSerializableExtra(NEWSLETTER) as Newsletter

        supportFragmentManager.beginTransaction().add(R.id.fcv_second, FragmentExam.newInstance(newsletter)).commit()
    }
}