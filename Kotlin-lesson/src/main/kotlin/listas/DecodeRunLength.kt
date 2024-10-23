package listas

fun <T> decode(list: List<Pair<Int, T>>): List<T> {
    return list.flatMap { pair -> List(pair.first) { pair.second } }
}
