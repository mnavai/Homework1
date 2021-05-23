package edu.ecu.cs.pirateplaces

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

private const val TAG = "PiratePlacesActivity"

class PiratePlacesActivity : AppCompatActivity() {

    private lateinit var nextButton: Button
    private lateinit var  prevButton: Button
    private lateinit var placeTextView: TextView
    private lateinit var visitorTextView: TextView



    private val placesAndPeople = listOf (PlacesVisitors(R.string.place_duke, R.string.place_duke_visitors),
        PlacesVisitors(R.string.place_ecu, R.string.place_ecu_visitors),
        PlacesVisitors(R.string.place_ncsu, R.string.place_ncsu_visitors)
       )

    private var endOfTheList = placesAndPeople.size - 1
    private var beginningOfTheList = 0
    private var currentIndex = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(TAG, "onCreate(Bundle?) called")
        setContentView(R.layout.activity_pirate_places)

        nextButton = findViewById(R.id.next_button)
        prevButton = findViewById(R.id.prev_button)
        placeTextView = findViewById(R.id.place_textview)
        visitorTextView = findViewById(R.id.visitor_textview)


        nextButton.setOnClickListener {

            currentIndex += 1

           if ( currentIndex > endOfTheList) {

                Toast.makeText(this, "you are at the end of the list", Toast.LENGTH_SHORT).show()

            }

            else {

               advanceList()
           }

        }

        prevButton.setOnClickListener {

            currentIndex -= 1

            if (currentIndex < beginningOfTheList)
            {

                Toast.makeText(this, "you are at the end of the list", Toast.LENGTH_SHORT).show()
            //    onBackPressed()

            }

            else
            {

            updateTextView()
            //updateUI()

            }

        }

    }

        private fun advanceList() {
            currentIndex = (currentIndex + 1) % placesAndPeople.size
            updateTextView()
//            updateUI()

        }

        private fun updateTextView() {

            val placeTextResId = placesAndPeople[currentIndex].placeId
            val visitorTextResId = placesAndPeople[currentIndex].visitorId
            placeTextView.setText(placeTextResId)
            visitorTextView.setText(visitorTextResId)


        }

//        override fun onBackPressed() {
//
//        }




}

