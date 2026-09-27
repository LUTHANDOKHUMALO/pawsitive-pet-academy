package com.example.pawsitivepetacademy

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        NavHelper.setup(this, R.id.nav_home)

        findViewById<Button>(R.id.btn_view_courses).setOnClickListener {
            startActivity(Intent(this, CoursesListActivity::class.java))
        }
    }
}
