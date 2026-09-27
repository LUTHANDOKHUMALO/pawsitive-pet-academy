package com.example.pawsitivepetacademy

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class CourseAdapter(
    private val courses: Array<Course>,
    private val onViewDetails: (Course) -> Unit
) : RecyclerView.Adapter<CourseAdapter.CourseViewHolder>() {

    class CourseViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val name: TextView = view.findViewById(R.id.tv_course_name)
        val description: TextView = view.findViewById(R.id.tv_course_description)
        val price: TextView = view.findViewById(R.id.tv_course_price)
        val viewDetailsBtn: Button = view.findViewById(R.id.btn_view_details)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CourseViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_course, parent, false)
        return CourseViewHolder(view)
    }

    override fun onBindViewHolder(holder: CourseViewHolder, position: Int) {
        val course = courses[position]
        holder.name.text = course.name
        holder.description.text = course.description
        holder.price.text = "R%.2f".format(course.price)
        holder.viewDetailsBtn.setOnClickListener { onViewDetails(course) }
    }

    override fun getItemCount(): Int = courses.size
}
