package cat.salle.restapidemo

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface PostAPIService {

    @GET("character")
    fun getCharacters(): Call<Character>
/*
    @GET("comments")
    fun getCommentsFromPost(@Query("postId")postId: Int): Call<List<Comment>>

    @GET("comments")
    fun getCommentsWithPostIdAndId(@Query("postId")postId: Int, @Query("id")id: Int): Call<List<Comment>>
*/
}