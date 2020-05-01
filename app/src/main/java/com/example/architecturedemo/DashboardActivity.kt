package com.example.architecturedemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.architecturedemo.utils.showLightStatusBar
import dagger.android.support.DaggerAppCompatActivity

class DashboardActivity : DaggerAppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)
        showLightStatusBar()
    }
}
