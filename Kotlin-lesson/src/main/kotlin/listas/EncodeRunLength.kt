package listas

fun <T> encode(list: List<T>): List<Pair<Int, T>> {
    return list.fold(mutableListOf<Pair<Int, T>>()) { acc, item ->
        if (acc.isNotEmpty() && acc.last().second == item) {
            acc[acc.size - 1] = acc.last().copy(first = acc.last().first + 1)
        } else {
            acc.add(Pair(1, item))
        }
        acc
    }
}
