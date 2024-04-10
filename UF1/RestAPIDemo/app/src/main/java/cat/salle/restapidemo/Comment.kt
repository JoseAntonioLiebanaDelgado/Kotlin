package cat.salle.restapidemo

import com.google.gson.annotations.SerializedName

data class Comment (@SerializedName("postId") var postId:Int,
                    @SerializedName("id") var id: Int,
                    @SerializedName("name") var name: String,
                    @SerializedName("email") var email: String,
                    @SerializedName("body") var body: String)