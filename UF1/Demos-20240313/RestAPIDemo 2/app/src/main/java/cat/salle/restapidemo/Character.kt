package cat.salle.restapidemo

import com.google.gson.annotations.SerializedName

class Character (@SerializedName("info") var info: Info,
                 @SerializedName("results") var results: List<Result>) {
}