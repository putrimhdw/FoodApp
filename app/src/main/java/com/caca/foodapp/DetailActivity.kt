package com.caca.foodapp

import android.content.Intent
import android.os.Build
import android.os.Bundle
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.caca.foodapp.databinding.ActivityDetailBinding

class DetailActivity : AppCompatActivity() {

    private lateinit var activityDetailBinding: ActivityDetailBinding

    @RequiresApi(Build.VERSION_CODES.TIRAMISU)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        activityDetailBinding = ActivityDetailBinding.inflate(layoutInflater)

        setContentView(activityDetailBinding.root)

        val food = if (Build.VERSION.SDK_INT >= 33) {
            intent.getParcelableExtra(EXTRA_FOOD, Food::class.java)
        } else {
            @Suppress("DEPRECATION")
            intent.getParcelableExtra(EXTRA_FOOD)
        }

        food?.let {
            Glide.with(this)
                .load(it.image)
                .into(activityDetailBinding.detailImage)

            val calorie =  "${it.calorie} kcal"

            activityDetailBinding.detailCategory.text = it.category
            activityDetailBinding.detailFoodName.text = it.name
            activityDetailBinding.detailFoodCalorie.text = calorie
            activityDetailBinding.detailFoodDescription.text = it.description
        }


        val actionBar = supportActionBar
        actionBar?.setDisplayHomeAsUpEnabled(true)

        activityDetailBinding.actionShare.setOnClickListener {
            val sendIntent: Intent = Intent().apply {
                action = Intent.ACTION_SEND
                putExtra(Intent.EXTRA_TEXT, activityDetailBinding.detailFoodName.text)
                type = "text/plain"
            }
            startActivity(sendIntent)
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        finish()
        return super.onSupportNavigateUp()
    }

    companion object {
        const val EXTRA_FOOD = "extra_food"
    }
}