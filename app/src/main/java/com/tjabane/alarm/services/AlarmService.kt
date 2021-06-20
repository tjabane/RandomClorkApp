package com.tjabane.alarm.services

import android.app.PendingIntent
import android.app.Service
import android.content.Context
import android.content.Intent
import android.media.MediaPlayer
import android.os.IBinder
import android.os.Vibrator
import androidx.core.app.NotificationCompat
import com.tjabane.alarm.R
import java.lang.String


class AlarmService: Service() {
    private val TITLE = "TITLE"
    val CHANNEL_ID = "ALARM_SERVICE_CHANNEL"
    private var mediaPlayer: MediaPlayer? = null
    private var vibrator: Vibrator? = null

    override fun onCreate() {
        super.onCreate()
        vibrator = getSystemService(Context.VIBRATOR_SERVICE) as Vibrator
        mediaPlayer = MediaPlayer.create(this, R.raw.alarm);
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        return super.onStartCommand(intent, flags, startId)
        val notificationIntent = Intent(this, RingActivity::class.java)
        val pendingIntent = PendingIntent.getActivity(this, 0, notificationIntent, 0)
        val alarmTitle = String.format("%s Alarm", intent!!.getStringExtra(TITLE))
        val notification = NotificationCompat.Builder(this, CHANNEL_ID)
                                            .setContentTitle(alarmTitle).setContentText("Ring Ring .. Ring Ring")
                                            .setSmallIcon(R.drawable.ic_alarm_black_24dp)
                                            .setContentIntent(pendingIntent)
                                            .build()
        mediaPlayer?.start();
        val pattern = longArrayOf(0, 100, 1000)
        vibrator?.vibrate(pattern, 0)
        startForeground(1, notification)
        return START_STICKY;
    }

    override fun onDestroy() {
        super.onDestroy()
        mediaPlayer?.stop();
        vibrator?.cancel();
    }

    override fun onBind(intent: Intent?): IBinder? {
        return null;
    }
}