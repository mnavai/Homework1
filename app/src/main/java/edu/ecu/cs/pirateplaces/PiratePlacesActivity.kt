package edu.ecu.cs.pirateplaces

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders


private const val TAG = "PiratePlacesActivity"
private const val KEY_INDEX = "index"

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


    private val piratesViewModel: PiratesViewModel by lazy {
        ViewModelProviders.of(this).get(PiratesViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(TAG, "onCreate(Bundle?) called")
        setContentView(R.layout.activity_pirate_places)

        var currentIndex = savedInstanceState?.getInt(KEY_INDEX, 0) ?: 0
        piratesViewModel.currentIndex = currentIndex

        nextButton = findViewById(R.id.next_button)
        prevButton = findViewById(R.id.prev_button)
        placeTextView = findViewById(R.id.place_textview)
        visitorTextView = findViewById(R.id.visitor_textview)


        nextButton.setOnClickListener {

            currentIndex += 1

           if ( currentIndex > endOfTheList) {

                Toast.makeText(this, "you are at the end of the list!", Toast.LENGTH_SHORT).show()

            }

            else {

               advanceList()
           }

        }

        prevButton.setOnClickListener {

            currentIndex -= 1

            if (currentIndex < beginningOfTheList)
            {

                Toast.makeText(this, "you are at the beginning of the list!", Toast.LENGTH_SHORT).show()
            //    onBackPressed()

            }

            else
            {

            goBackList()
            //updateUI()

            }

        }

        placeTextView.setOnClickListener() {

            val currentPlace = placesAndPeople[currentIndex].placeId
            val intent = CheckInActivity.newIntent(this@PiratePlacesActivity, currentPlace)
            startActivity(intent)

        }

    }
    override fun onStart() {
        super.onStart()
        Log.d(TAG, "onStart() called")    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG, "onResume() called")    }

    override fun onPause() {
        super.onPause()
        Log.d(TAG, "onPause() called")    }

    override fun onSaveInstanceState(savedInstanceState: Bundle) {
        super.onSaveInstanceState(savedInstanceState)
        Log.i(TAG, "onSaveInstanceState")
        savedInstanceState.putInt(KEY_INDEX,  piratesViewModel.currentIndex)
    }

    override fun onStop() {
        super.onStop()
        Log.d(TAG, "onStop() called")    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "onDestroy() called")    }

    private fun advanceList() {

            currentIndex += 1
            val placeTextResId = placesAndPeople[currentIndex].placeId
            val visitorTextResId = placesAndPeople[currentIndex].visitorId
            placeTextView.setText(placeTextResId)
            visitorTextView.setText(visitorTextResId)

//          updateUI()

        }


    private fun goBackList() {

        currentIndex -= 1
        val placeTextResId = placesAndPeople[currentIndex].placeId
        val visitorTextResId = placesAndPeople[currentIndex].visitorId
        placeTextView.setText(placeTextResId)
        visitorTextView.setText(visitorTextResId)

//          updateUI()

    }


        private fun updateTextView() {



        }


}

