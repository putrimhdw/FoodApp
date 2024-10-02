package com.caca.foodapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.caca.foodapp.databinding.ActivityAboutBinding

class AboutActivity : AppCompatActivity() {

    private lateinit var activityAboutBinding: ActivityAboutBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        activityAboutBinding = ActivityAboutBinding.inflate(layoutInflater)

        setContentView(activityAboutBinding.root)

        val actionBar = supportActionBar
        actionBar?.setDisplayHomeAsUpEnabled(true)

    }

    override fun onSupportNavigateUp(): Boolean {
        finish()
        return super.onSupportNavigateUp()
    }


}