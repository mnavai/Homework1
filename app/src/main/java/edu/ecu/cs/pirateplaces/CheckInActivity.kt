package edu.ecu.cs.pirateplaces

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.content.Context
import android.content.Intent



const val EXTRA_CHECK_IN = "edu.ecu.cs.pirateplaces.checkin"
private const val EXTRA_PLACE = "edu.ecu.cs.pirateplaces.current_place"

private lateinit var placeTextView: TextView
private lateinit var statusTextView: TextView
private lateinit var checkinButton: Button


private var defaultStatus = "Not Checked in!"

class CheckInActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_check_in)
    }

    companion object {

        fun newIntent(packageContext: Context, isCheckedIn: Int): Intent {
        return Intent(packageContext, CheckInActivity::class.java).apply {

            }
        }
   }
}