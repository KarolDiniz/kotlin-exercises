package aritmetica

fun listPrimesInRange(range: IntRange): List<Int> {
    return range.filter { it.isPrime() }
}
