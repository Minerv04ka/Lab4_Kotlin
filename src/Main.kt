import factory.StudentFactory
import factory.InstructorFactory
import models.School
import models.Course
import proxy.CourseProxy
import observer.SchoolAdmin

fun main() {
    val school = School()

    val admin = SchoolAdmin()

    // Фабрики
    val studentFactory = StudentFactory()
    val instructorFactory = InstructorFactory()

    // Студенти
    val student1 = school.addStudent(studentFactory, "s1", "Олександр", "alex@example.com") as models.Student
    val student2 = school.addStudent(studentFactory, "s2", "Марія", "maria@example.com") as models.Student

    // Викладач
    val instructor = school.addInstructor(instructorFactory, "i1", "Іван Іванович", "ivan@example.com") as models.Instructor

    // Курс з Proxy
    val course = CourseProxy(Course("c1", "Математика", 4))
    course.addObserver(admin)
    school.addCourse(course)

    // Призначення
    school.assignStudentToCourse(student1, course)
    school.assignStudentToCourse(student2, course)
    school.assignInstructorToCourse(instructor, course)

    // Викладач ставить оцінки
    instructor.gradeStudent(course, student1, 95.0)
    instructor.gradeStudent(course, student2, 89.0)
}
