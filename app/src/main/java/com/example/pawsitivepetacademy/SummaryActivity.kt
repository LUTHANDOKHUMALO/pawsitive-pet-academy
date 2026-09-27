package com.example.pawsitivepetacademy

import android.os.Bundle
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

@Suppress("UNCHECKED_CAST", "DEPRECATION")
class SummaryActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_summary)

        NavHelper.setup(this, R.id.nav_fees)

        val selectedCourses = intent.getSerializableExtra("SELECTED_COURSES") as? ArrayList<Course> ?: ArrayList()
        val subtotal = intent.getDoubleExtra("SUBTOTAL", 0.0)
        val vat = intent.getDoubleExtra("VAT", 0.0)
        val discount = intent.getDoubleExtra("DISCOUNT", 0.0)
        val total = intent.getDoubleExtra("TOTAL", 0.0)

        val courseContainer = findViewById<LinearLayout>(R.id.summary_course_container)
        for (course in selectedCourses) {
            val row = TextView(this)
            row.text = "${course.name} - R%.2f".format(course.price)
            row.setPadding(0, 4, 0, 4)
            courseContainer.addView(row)
        }

        findViewById<TextView>(R.id.tv_summary_subtotal).text = "Subtotal: R%.2f".format(subtotal)
        findViewById<TextView>(R.id.tv_summary_vat).text = "VAT (15%%): R%.2f".format(vat)
        findViewById<TextView>(R.id.tv_summary_discount).text = "Discount: -R%.2f".format(discount)
        findViewById<TextView>(R.id.tv_summary_total).text = "Total: R%.2f".format(total)
    }
}
