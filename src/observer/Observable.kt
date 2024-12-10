package observer

interface Observable {
    val observers: MutableList<Observer>
    fun addObserver(observer: Observer)
    fun removeObserver(observer: Observer)
    fun notifyObservers(event: String)
    abstract fun getAverageGrade(): Double
}
