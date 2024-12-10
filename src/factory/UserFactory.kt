package factory

import models.Instructor
import models.Student
import models.User

abstract class UserFactory {
    abstract fun createUser(id: String, name: String, email: String): User
}

class StudentFactory : UserFactory() {
    override fun createUser(id: String, name: String, email: String): User {
        return Student(id, name, email)
    }
}

class InstructorFactory : UserFactory() {
    override fun createUser(id: String, name: String, email: String): User {
        return Instructor(id, name, email)
    }
}
