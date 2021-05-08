package com.tjabane.alarm.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import com.tjabane.alarm.R
import com.tjabane.alarm.models.Alarm

class AlarmAdapter(val cxt: Context, val resources: Int, val alarms: List<Alarm> ): ArrayAdapter<Alarm>(cxt, resources, alarms ) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val layoutInflater: LayoutInflater = LayoutInflater.from(cxt)
        val view: View = layoutInflater.inflate(resources, null)

        val timeTextView:TextView = view.findViewById(R.id.time)
        val dayTextView:TextView = view.findViewById(R.id.day)
        val currentAlarm: Alarm = alarms[position]

        timeTextView.text = currentAlarm.Time
        dayTextView.text = currentAlarm.Day
        return view
    }
}