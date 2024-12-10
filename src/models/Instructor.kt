package models

class Instructor(override val id: String, override val name: String, override val email: String) : User() {
    val courses: MutableList<Course> = mutableListOf()

    fun gradeStudent(course: Course, student: Student, grade: Double) {
        println("$name ставить оцінку $grade студенту ${student.name} по курсу ${course.name}")
        course.assignGrade(student, grade)
    }
}
