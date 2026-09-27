package com.example.pawsitivepetacademy

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import java.util.ArrayList

class FeesCalculatorActivity : AppCompatActivity() {

    companion object {
        private const val VAT_RATE = 0.15          // 15% VAT
        private const val DISCOUNT_THRESHOLD = 1500.0  // subtotal above this qualifies for a discount
        private const val DISCOUNT_RATE = 0.10     // 10% discount when threshold is met
    }

    // Array holding a checkbox for each course, matching CourseRepository.courses by index
    private val checkBoxes = mutableListOf<CheckBox>()
    private var lastTotal = 0.0
    private var lastSubtotal = 0.0
    private var lastVat = 0.0
    private var lastDiscount = 0.0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fees_calculator)

        NavHelper.setup(this, R.id.nav_fees)

        val checkboxContainer = findViewById<LinearLayout>(R.id.checkbox_container)
        val btnCalculate = findViewById<Button>(R.id.btn_calculate)
        val btnViewSummary = findViewById<Button>(R.id.btn_view_summary)

        // Build one checkbox per course in the array, generated dynamically
        for (course in CourseRepository.courses) {
            val checkBox = CheckBox(this)
            checkBox.text = "${course.name} - R%.2f".format(course.price)
            checkBox.tag = course.id
            checkboxContainer.addView(checkBox)
            checkBoxes.add(checkBox)
        }

        btnCalculate.setOnClickListener {
            calculateFees()
            btnViewSummary.isEnabled = true
        }

        btnViewSummary.setOnClickListener {
            val selectedCourses = getSelectedCourses()
            if (selectedCourses.isEmpty()) {
                Toast.makeText(this, "Please select at least one course", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            val intent = Intent(this, SummaryActivity::class.java)
            intent.putExtra("SELECTED_COURSES", ArrayList(selectedCourses) as java.io.Serializable)
            intent.putExtra("SUBTOTAL", lastSubtotal)
            intent.putExtra("VAT", lastVat)
            intent.putExtra("DISCOUNT", lastDiscount)
            intent.putExtra("TOTAL", lastTotal)
            startActivity(intent)
        }
    }

    private fun getSelectedCourses(): List<Course> {
        val selected = mutableListOf<Course>()
        for (checkBox in checkBoxes) {
            if (checkBox.isChecked) {
                val courseId = checkBox.tag as Int
                CourseRepository.getCourseById(courseId)?.let { selected.add(it) }
            }
        }
        return selected
    }

    private fun calculateFees() {
        val selectedCourses = getSelectedCourses()

        if (selectedCourses.isEmpty()) {
            Toast.makeText(this, "Please select at least one course", Toast.LENGTH_SHORT).show()
            return
        }

        // Subtotal = sum of selected course prices
        val subtotal = selectedCourses.sumOf { it.price }

        // VAT calculated on the subtotal
        val vat = subtotal * VAT_RATE

        // Discount applies only if subtotal crosses the threshold (e.g. booking 2+ higher-value courses)
        val discount = if (subtotal >= DISCOUNT_THRESHOLD) subtotal * DISCOUNT_RATE else 0.0

        // Total = subtotal + VAT - discount
        val total = subtotal + vat - discount

        lastSubtotal = subtotal
        lastVat = vat
        lastDiscount = discount
        lastTotal = total

        findViewById<TextView>(R.id.tv_subtotal).text = "Subtotal: R%.2f".format(subtotal)
        findViewById<TextView>(R.id.tv_vat).text = "VAT (15%%): R%.2f".format(vat)
        findViewById<TextView>(R.id.tv_discount).text = "Discount: -R%.2f".format(discount)
        findViewById<TextView>(R.id.tv_total).text = "Total: R%.2f".format(total)
    }
}
