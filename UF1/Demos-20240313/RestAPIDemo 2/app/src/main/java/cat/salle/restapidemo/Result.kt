package cat.salle.restapidemo

import com.google.gson.annotations.SerializedName

class Result (@SerializedName("id") var id:Int,
              @SerializedName("name") var name: String,
              @SerializedName("image") var image: String) {
}