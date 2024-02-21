package com.example.exerciciconstraint

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.Switch
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var button1 = findViewById<Button>(R.id.button2)
        var button2 = findViewById<Button>(R.id.button3)
        var button3 = findViewById<Button>(R.id.button4)
        var switch = findViewById<Switch>(R.id.switch1)

        switch.setOnClickListener {
            button1.isActivated = switch.isChecked
            button2.isActivated = switch.isChecked
            button3.isActivated = switch.isChecked

            if (switch.isChecked){
                Toast.makeText(this, "Switch ON", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "Switch OFF", Toast.LENGTH_SHORT).show()
            }
        }
        button1.setOnClickListener{
            Log.i("Button2", "Action Button2")
            if (!switch.isChecked) {
                Toast.makeText(this, "Hellooooo", Toast.LENGTH_SHORT).show()
            }
        }
    }
}