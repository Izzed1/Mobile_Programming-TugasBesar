package com.izzed.ndelokmovie15.ui.splash

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatDelegate
import com.izzed.ndelokmovie15.R
import com.izzed.ndelokmovie15.ui.home.HomeActivity

class SplashActivity : AppCompatActivity() {
    private val splashTimeOut: Long= 3000

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)

        Handler().postDelayed({
            val splash = Intent(this@SplashActivity, HomeActivity::class.java)
            startActivity(splash)
            finish()
        }, splashTimeOut)
    }
}