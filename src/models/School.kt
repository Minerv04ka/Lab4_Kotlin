package models

import factory.UserFactory

class School {
    private val students: MutableList<User> = mutableListOf()
    private val instructors: MutableList<User> = mutableListOf()
    private val courses: MutableList<Course> = mutableListOf()

    fun addStudent(factory: UserFactory, id: String, name: String, email: String): User {
        val student = factory.createUser(id, name, email)
        students.add(student)
        return student
    }

    fun addInstructor(factory: UserFactory, id: String, name: String, email: String): User {
        val instructor = factory.createUser(id, name, email)
        instructors.add(instructor)
        return instructor
    }

    fun addCourse(course: Course) {
        courses.add(course)
    }

    fun assignStudentToCourse(student: Student, course: Course) {
        course.addStudent(student)
    }

    fun assignInstructorToCourse(instructor: Instructor, course: Course) {
        instructor.courses.add(course)
    }
}
