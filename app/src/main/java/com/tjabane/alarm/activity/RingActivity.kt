package com.tjabane.alarm.activity

import android.R
import android.animation.ObjectAnimator
import android.animation.ValueAnimator
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.tjabane.alarm.services.AlarmService
import java.util.*


class RingActivity: AppCompatActivity() {
    var dismiss: Button? = null
    var snooze: Button? = null
    var clock: ImageView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ring);

        dismiss?.setOnClickListener {
            val intentService = Intent(applicationContext, AlarmService::class.java)
            getApplicationContext().stopService(intentService);
            finish()
        }

        snooze?.setOnClickListener{
            val calendar = Calendar.getInstance()
            calendar.timeInMillis = System.currentTimeMillis()
            calendar.add(Calendar.MINUTE, 10);
        }

    }

    private fun animateClock() {
        val rotateAnimation = ObjectAnimator.ofFloat(clock, "rotation", 0f, 20f, 0f, -20f, 0f)
        rotateAnimation.repeatCount = ValueAnimator.INFINITE
        rotateAnimation.duration = 800
        rotateAnimation.start()
    }


}