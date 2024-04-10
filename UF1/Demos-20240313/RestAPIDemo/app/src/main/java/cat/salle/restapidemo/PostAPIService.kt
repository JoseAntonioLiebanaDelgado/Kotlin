package cat.salle.restapidemo

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface PostAPIService {
    @GET("posts")
    fun getPostsFromUser(@Query("userId")userId: Int): Call<List<Post>>
}