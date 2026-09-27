package com.example.pawsitivepetacademy

import android.app.Activity
import android.content.Intent
import com.google.android.material.bottomnavigation.BottomNavigationView

/**
 * Wires up the shared bottom navigation bar for any activity that includes
 * component_bottom_nav.xml. Call this from onCreate() after setContentView().
 *
 * @param activity the calling activity
 * @param currentItemId the R.id of the tab that should show as selected
 */
object NavHelper {

    fun setup(activity: Activity, currentItemId: Int) {
        val bottomNav = activity.findViewById<BottomNavigationView>(R.id.bottom_navigation) ?: return
        bottomNav.selectedItemId = currentItemId

        bottomNav.setOnItemSelectedListener { item ->
            if (item.itemId == currentItemId) {
                true
            } else {
                val target: Class<*> = when (item.itemId) {
                    R.id.nav_home -> MainActivity::class.java
                    R.id.nav_courses -> CoursesListActivity::class.java
                    R.id.nav_fees -> FeesCalculatorActivity::class.java
                    R.id.nav_profile -> ProfileActivity::class.java
                    else -> MainActivity::class.java
                }
                activity.startActivity(Intent(activity, target))
                activity.overridePendingTransition(0, 0)
                activity.finish()
                true
            }
        }
    }
}
