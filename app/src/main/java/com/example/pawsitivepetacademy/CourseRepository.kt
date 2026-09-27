package com.example.pawsitivepetacademy

object CourseRepository {

    // Array of courses used across Courses List, Course Detail and Fees Calculator
    val courses: Array<Course> = arrayOf(
        Course(1, "Puppy Obedience Basics", "Foundational commands and house manners for puppies aged 8-16 weeks.", 850.0),
        Course(2, "Advanced Agility Training", "Weave poles, jumps and tunnels for dogs ready to compete or just have fun.", 1200.0),
        Course(3, "Cat Behaviour Essentials", "Understand and correct common feline behaviour issues.", 700.0),
        Course(4, "Puppy Socialization", "Safe, structured group sessions to build confidence around people and other dogs.", 650.0),
        Course(5, "Basic Grooming Certificate", "Hands-on grooming skills including bathing, brushing and nail care.", 950.0),
        Course(6, "Canine First Aid", "Essential emergency care skills every pet owner should know.", 500.0)
    )

    fun getCourseById(id: Int): Course? = courses.find { it.id == id }
}
