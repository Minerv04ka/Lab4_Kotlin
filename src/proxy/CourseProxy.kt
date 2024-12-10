package proxy

import models.Course
import models.Student

class CourseProxy(private val realCourse: Course) : Course(realCourse.courseId, realCourse.name, realCourse.credits) {
    override fun assignGrade(student: Student, grade: Double) {
        println("Proxy: Перевірка доступу перед додаванням оцінки.")
        super.assignGrade(student, grade)
        notifyObservers("Оцінка додана студенту ${student.name} для курсу ${realCourse.name}.")
    }

    fun getAverageGrade(): Double {
        println("Proxy: Контроль доступу до середньої оцінки.")
        return super.getAverageGrade()
    }
}
