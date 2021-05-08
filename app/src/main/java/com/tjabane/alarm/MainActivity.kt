package com.tjabane.alarm

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ListView
import android.widget.TimePicker
import androidx.appcompat.app.AppCompatActivity
import com.tjabane.alarm.adapter.AlarmAdapter
import com.tjabane.alarm.models.Alarm
import java.time.DayOfWeek
import java.time.LocalTime
import java.time.format.DateTimeFormatter
import kotlin.random.Random


class MainActivity : AppCompatActivity() {

    private var TimeFormat = DateTimeFormatter.ofPattern("HH:mm")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        populateAlarms()
        configEvents()
    }

    private fun populateAlarms() {
        val alarmList: ListView = findViewById(R.id.alarmsList)
        val alarms = getAlarmList()
        alarmList.adapter = AlarmAdapter(this, R.layout.row, alarms)
    }

    private fun configEvents() {
        val generateBtn: Button = findViewById(R.id.generateBtn)
        generateBtn.setOnClickListener {
            populateAlarms()
        }
    }

    private fun getAlarmList(): List<Alarm> {
        val alarms = mutableListOf<Alarm>()
        alarms.add(Alarm(getRandomNightTime(), DayOfWeek.MONDAY, true))
        alarms.add(Alarm(getRandomNightTime(), DayOfWeek.TUESDAY, true))
        alarms.add(Alarm(getRandomNightTime(), DayOfWeek.WEDNESDAY, true))
        alarms.add(Alarm(getRandomNightTime(), DayOfWeek.THURSDAY, true))
        alarms.add(Alarm(getRandomNightTime(), DayOfWeek.FRIDAY, true))
        return alarms
    }

    private fun getRandomNightTime(): LocalTime {
        val hour = Random.nextInt(8)
        val minutes = getRandomMinutes()
        val timeString = "0$hour:$minutes"
        return LocalTime.parse(timeString, TimeFormat);
    }

    private fun getRandomMinutes(): String {
        val minutes = Random.nextInt(60)
        if(minutes < 10)
            return "0$minutes"
        return minutes.toString()
    }
}