package models

import observer.Observable
import observer.Observer

open class Course(val courseId: String, val name: String, val credits: Int) : Observable {
    override val observers: MutableList<Observer> = mutableListOf()
    val students: MutableList<Student> = mutableListOf()
    val grades: MutableMap<Student, Double> = mutableMapOf()

    fun addStudent(student: Student) {
        students.add(student)
        println("Студент ${student.name} доданий до курсу $name.")
    }

    open fun assignGrade(student: Student, grade: Double) {
        grades[student] = grade
        notifyObservers("Оцінка $grade призначена студенту ${student.name} на курсі $name.")
    }

    override fun addObserver(observer: Observer) {
        observers.add(observer)
    }

    override fun removeObserver(observer: Observer) {
        observers.remove(observer)
    }

    override fun notifyObservers(event: String) {
        for (observer in observers) {
            observer.update(event)
        }
    }

    override fun getAverageGrade(): Double {
        TODO("Not yet implemented")
    }
}
