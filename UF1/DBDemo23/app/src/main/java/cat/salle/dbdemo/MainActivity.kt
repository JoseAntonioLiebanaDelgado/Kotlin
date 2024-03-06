package cat.salle.dbdemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import cat.salle.dbdemo.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        if (savedInstanceState == null) {
            // Create a new instance of the fragment
            val fragment = ItemFragment.newInstance(1) // Adjust the column count if necessary

            // Begin a transaction to add or replace the fragment in the container
            supportFragmentManager.beginTransaction().apply {
                replace(R.id.fragment_shows, fragment) // Use add if you're adding for the first time
                commit()
            }
        }

        binding.buttonAdd.setOnClickListener{

        }
    }
}