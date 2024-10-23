package arvores

fun <T> Tree<T>.leafValues(): List<T> = when (this) {
    is End -> emptyList()
    is Node -> if (left is End && right is End) listOf(value) else left.leafValues() + right.leafValues()
}
