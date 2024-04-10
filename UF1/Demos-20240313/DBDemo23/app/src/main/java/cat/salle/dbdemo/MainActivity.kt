package cat.salle.dbdemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    private lateinit var db: AppDatabase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        GlobalScope.launch {
            db = AppDatabase.getInstance(applicationContext)!!

            db.UserDAO().insert(User(null, "XX", "YYYYY"))

            val users = db.UserDAO().loadAllUsers()

            users.forEach {
                Log.i("-->", it.toString())
            }
        }
    }
}