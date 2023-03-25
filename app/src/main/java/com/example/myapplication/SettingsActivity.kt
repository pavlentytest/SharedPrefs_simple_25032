package com.example.myapplication

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.preference.PreferenceFragmentCompat
import androidx.preference.PreferenceManager

class SettingsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.settings_activity)
        if (savedInstanceState == null) {
            supportFragmentManager
                .beginTransaction()
                .replace(R.id.settings, SettingsFragment())
                .commit()
        }
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
      /*  val shared = PreferenceManager.getDefaultSharedPreferences(this)
        val map = shared.all
        map.forEach{
            entry ->
            Log.d("RRR","${entry.key} - ${entry.value}")
        }*/
        val shared = getSharedPreferences("ttt.txt", Context.MODE_PRIVATE)
        with(shared.edit()) {
            putString("val","Test!!!")
            apply()
        }
        Log.d("RRR","val: " + shared.getString("val","").toString())
    }

    class SettingsFragment : PreferenceFragmentCompat() {
        override fun onCreatePreferences(savedInstanceState: Bundle?, rootKey: String?) {
            setPreferencesFromResource(R.xml.root_preferences, rootKey)
        }
    }
}