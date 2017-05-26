
sealed class Dot(var inversion: Boolean, var previous: LogElement?) : LogElement{

    class In(inversion: Boolean, previous: Out?): Dot(inversion, previous) {
        override fun calculateValue(): Boolean {
            if (this.previous != null) {
                return previous!!.calculateValue().xor(inversion)
            }
            else {
                throw IllegalArgumentException("К логическому элементу не подведено соединение")
            }
        }
    }

    class Out(inversion: Boolean, previous: LogElement): Dot(inversion,previous) {
        override fun calculateValue(): Boolean {
            return this.previous!!.calculateValue().xor(inversion)
        }
    }

}