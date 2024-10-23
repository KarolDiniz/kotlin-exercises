package listas


fun <T> penultimate(list: List<T>): T? {
    return if (list.size < 2) null else list[list.size - 2]
}
