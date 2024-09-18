package com.example.simplecounter

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    private var taps = 0 // Keep track of the number of taps
    private var incrementValue = 1 // Start with incrementing by 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val textView = findViewById<TextView>(R.id.textView)
        val addButton = findViewById<Button>(R.id.button2)
        val upgradeButton = findViewById<Button>(R.id.upgradeBtn)

        // Handle clicks for the add button
        addButton.setOnClickListener {
            taps += incrementValue
            textView.text = "$taps"

            // Show upgrade button when taps reach 100
            if (taps >= 100) {
                upgradeButton.visibility = View.VISIBLE
            }

            // Display a Toast when the button is clicked
            Toast.makeText(this, "Clicked Add Button!", Toast.LENGTH_SHORT).show()
        }

        // Handle clicks for the upgrade button
        upgradeButton.setOnClickListener {
            incrementValue = 2 // Change the increment to 2
            addButton.text = "Add 2" // Change button text to reflect the upgrade
            upgradeButton.visibility = View.GONE // Hide the upgrade button after it's clicked
        }

        // Handle window insets for layout adjustment
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}
