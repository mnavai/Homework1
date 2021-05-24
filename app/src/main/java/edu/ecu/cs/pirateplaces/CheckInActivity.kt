package edu.ecu.cs.pirateplaces

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.content.Context
import android.content.Intent
import android.util.Log
import android.widget.Toast



const val EXTRA_CHECK_IN = "edu.ecu.cs.pirateplaces.checkin"
private const val EXTRA_PLACE = "edu.ecu.cs.pirateplaces.current_place"


class CheckInActivity : AppCompatActivity() {


    private lateinit var placeTextView: TextView
    private lateinit var statusTextView: TextView
    private lateinit var checkinButton: Button


    private var currentIndex = 0
    private var defaultStatus = "Not Checked in!"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_check_in)

        checkinButton = findViewById(R.id.checkin_button)
        statusTextView = findViewById(R.id.checkinstatus)

        checkinButton.setOnClickListener() {


            val newText: String = "Checked in!"
            statusTextView.text = newText
            Toast.makeText(this, "You are now checked in", Toast.LENGTH_SHORT).show()
            currentIndex += 1

        }

        currentIndex += 1


    }

    companion object {

        fun newIntent(packageContext: Context, isCheckedIn: Int): Intent {
            return Intent(packageContext, CheckInActivity::class.java).apply {

            }
        }
    }

}

