package com.mirobotic.myspotify

import android.app.Activity
import android.os.Build
import android.os.Bundle
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AlertDialog

class MainActivity : Activity() {

    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val intent = packageManager.getLaunchIntentForPackage("com.spotify.music")

        if (intent != null) {
            startActivity(intent)
            this.finishAndRemoveTask()
        }

        val alertDialog = AlertDialog.Builder(this@MainActivity)
        alertDialog.setTitle("Spotify app is not installed")
        alertDialog.setMessage("Please install radio spotify app and try again")
        alertDialog.setPositiveButton("Exit") { _, _ ->
            finishAndRemoveTask()
        }

        alertDialog.setCancelable(false)
        alertDialog.show()
    }
}