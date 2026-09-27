package com.example.pawsitivepetacademy

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class CourseDetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_course_detail)

        NavHelper.setup(this, R.id.nav_courses)

        val courseId = intent.getIntExtra("COURSE_ID", -1)
        val course = CourseRepository.getCourseById(courseId)

        if (course != null) {
            findViewById<TextView>(R.id.tv_detail_name).text = course.name
            findViewById<TextView>(R.id.tv_detail_description).text = course.description
            findViewById<TextView>(R.id.tv_detail_price).text = "R%.2f".format(course.price)
        }

        findViewById<Button>(R.id.btn_enroll).setOnClickListener {
            startActivity(Intent(this, FeesCalculatorActivity::class.java))
        }
    }
}
