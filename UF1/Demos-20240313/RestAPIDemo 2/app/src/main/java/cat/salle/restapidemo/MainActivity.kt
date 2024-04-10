package cat.salle.restapidemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Adapter
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.Spinner
import android.widget.TextView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var character: Character? = null
        val spinner = findViewById<Spinner>(R.id.spinner)
        val imageView = findViewById<ImageView>(R.id.imageView)
        val names = mutableListOf<String>()

        GlobalScope.launch {
            val call2 = getRetrofit().create(PostAPIService::class.java)
                .getCharacters().execute()

            character = call2.body() as Character

            character?.results?.forEach {
                Log.i("----->", "${it.name} - ${it.image}")
                names.add(it.name)
            }

            MainScope().launch {
                val adapter = ArrayAdapter<String>(this@MainActivity, android.R.layout.simple_spinner_item, names)
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
                spinner.adapter = adapter
            }
        }

        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                Glide.with(this@MainActivity)
                    .load(character!!.results[p2].image)
                    .into(imageView)
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
                TODO("Not yet implemented")
            }
        }
    }

    private fun getRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://rickandmortyapi.com/api/")
            .addConverterFactory(GsonConverterFactory.create()) .build()
    }
}