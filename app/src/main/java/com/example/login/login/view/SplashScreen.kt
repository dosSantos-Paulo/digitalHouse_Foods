package com.example.login.login.view

import android.animation.ObjectAnimator
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.ImageView
import com.example.login.R

class SplashScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

        animation()

        Handler(Looper.getMainLooper()).postDelayed({
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }, 3000)
    }

    fun animation() {
        val image = findViewById<ImageView>(R.id.img_splash)
        image.animate().apply {
            duration = 2500
            scaleX(1.05f)
            scaleY(1.05f)
        }.withEndAction{
            image.animate().apply {
                duration = 500
                alpha(0f)
            }
        }

    }
}