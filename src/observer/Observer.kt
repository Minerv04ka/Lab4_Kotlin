package observer

interface Observer {
    fun update(event: String)
}

class SchoolAdmin : Observer {
    override fun update(event: String) {
        println("Адміністрація школи отримала оновлення: $event")
    }
}
