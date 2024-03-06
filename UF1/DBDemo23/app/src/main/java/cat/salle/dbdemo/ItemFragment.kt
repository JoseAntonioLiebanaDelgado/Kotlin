package cat.salle.dbdemo

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import cat.salle.dbdemo.placeholder.PlaceholderContent
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.launch

/**
 * A fragment representing a list of Items.
 */
class ItemFragment : Fragment() {

    private var columnCount = 1
    private lateinit var db: AppDatabase
    private var myItemRecyclerViewAdapter: MyItemRecyclerViewAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        arguments?.let {
            columnCount = it.getInt(ARG_COLUMN_COUNT)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_item_list, container, false)
        db = AppDatabase.getInstance(requireContext())!!

        // Set up the RecyclerView
        if (view is RecyclerView) {
            with(view) {
                layoutManager = when {
                    columnCount <= 1 -> LinearLayoutManager(context)
                    else -> GridLayoutManager(context, columnCount)
                }
            }
        }

        // Load data in a coroutine
        loadTvShows(view as RecyclerView)

        return view
    }

    private fun loadTvShows(recyclerView: RecyclerView) = GlobalScope.launch {
        db.UserDAO().deleteAllUsers()
        db.TvShowDAO().deleteAllShows()
        db.UserDAO().insert(User(null, "XX", "YYYYY"))
        db.TvShowDAO().insert(TvShow(null, "Rick & Morty", "Cartoon", 7, "23-07-2014"))
        db.TvShowDAO().insert(TvShow(null, "Dexter", "Thriller", 3, "01-03-2005"))
        db.TvShowDAO().insert(TvShow(null, "Naruto", "Anime", 16, "08-09-2003"))
        val users = db.UserDAO().loadAllUsers()
        val shows = db.TvShowDAO().loadAllShows().toMutableList()
        val animes = db.TvShowDAO().loadAllAnimes("Anime")

        MainScope().launch {
            myItemRecyclerViewAdapter = MyItemRecyclerViewAdapter(shows)
            recyclerView.adapter = myItemRecyclerViewAdapter
        }
    }

    companion object {

        // TODO: Customize parameter argument names
        const val ARG_COLUMN_COUNT = "column-count"

        // TODO: Customize parameter initialization
        @JvmStatic
        fun newInstance(columnCount: Int) =
            ItemFragment().apply {
                arguments = Bundle().apply {
                    putInt(ARG_COLUMN_COUNT, columnCount)
                }
            }
    }
}