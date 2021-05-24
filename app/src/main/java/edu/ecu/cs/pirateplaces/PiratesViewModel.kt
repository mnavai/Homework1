package edu.ecu.cs.pirateplaces
import android.util.Log
import androidx.lifecycle.ViewModel



private const val TAG = "PiratesViewModel"

class PiratesViewModel : ViewModel() {


    private val placesAndPeople = listOf (PlacesVisitors(R.string.place_duke, R.string.place_duke_visitors),
        PlacesVisitors(R.string.place_ecu, R.string.place_ecu_visitors),
        PlacesVisitors(R.string.place_ncsu, R.string.place_ncsu_visitors)
    )
    var currentIndex = 0

    val currentPlace: Int
        get() = placesAndPeople[currentIndex].placeId

    val currentVisitors: Int
        get() = placesAndPeople[currentIndex].visitorId

    fun moveToNext() {
        currentIndex = (currentIndex + 1) % placesAndPeople.size
    }
}