package com.example.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity

class MainActivity : ComponentActivity(), Orientation.Listener {
    private lateinit var mOrientation: Orientation
    private lateinit var mAttitudeIndicator: AttitudeIndicator

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main)

        mOrientation = Orientation(this)
        mAttitudeIndicator = findViewById(R.id.attitude_indicator)
    }

    override fun onStart() {
        super.onStart()
        mOrientation.startListening(this)
    }

    override fun onStop() {
        super.onStop()
        mOrientation.stopListening()
    }

    override fun onOrientationChanged(pitch: Float, roll: Float) {
        mAttitudeIndicator.setAttitude(pitch, roll)
    }
}