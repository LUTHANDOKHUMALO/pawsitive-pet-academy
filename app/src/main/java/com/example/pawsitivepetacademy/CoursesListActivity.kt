package com.example.pawsitivepetacademy

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class CoursesListActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_courses_list)

        NavHelper.setup(this, R.id.nav_courses)

        val recyclerView = findViewById<RecyclerView>(R.id.rv_courses)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = CourseAdapter(CourseRepository.courses) { course ->
            val intent = Intent(this, CourseDetailActivity::class.java)
            intent.putExtra("COURSE_ID", course.id)
            startActivity(intent)
        }
    }
}
