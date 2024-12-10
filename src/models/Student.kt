package models

class Student(override val id: String, override val name: String, override val email: String) : User() {
    val courses: MutableList<Course> = mutableListOf()

    fun getGrades(): Map<String, Double?> {
        return courses.associate { it.name to it.grades[this] }
    }

    fun getAverageGrade(): Double {
        val grades = courses.mapNotNull { it.grades[this] }
        return if (grades.isNotEmpty()) grades.average() else 0.0
    }
}
