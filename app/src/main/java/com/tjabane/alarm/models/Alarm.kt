package com.tjabane.alarm.models

import java.time.DayOfWeek
import java.time.LocalTime
import java.time.format.DateTimeFormatter
import java.time.format.TextStyle
import java.util.Locale

class Alarm(private val time: LocalTime,private val dayOfWeek: DayOfWeek, val switch: Boolean) {
    private var TimeFormat = DateTimeFormatter.ofPattern("HH:mm")

    val Time:String get() =  TimeFormat.format(time)
    val Day:String get() = dayOfWeek.getDisplayName(TextStyle.SHORT, Locale.US)
}