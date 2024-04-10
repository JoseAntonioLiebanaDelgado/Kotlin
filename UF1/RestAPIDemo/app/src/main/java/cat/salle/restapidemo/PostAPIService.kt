package cat.salle.restapidemo

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface PostAPIService {
    @GET("comments")
    //fun getPostsFromUser(@Query("userId")userId: Int): Call<List<Comment>>
    //fun getPostsFromUser(@Query("postId")postId: Int): Call<List<Comment>>
    fun getPostsFromUser(@Query("name")name: String): Call<List<Comment>>

}