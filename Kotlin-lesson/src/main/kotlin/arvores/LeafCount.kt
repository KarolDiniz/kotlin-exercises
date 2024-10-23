package arvores

fun <T> Tree<T>.leafCount(): Int = when (this) {
    is End -> 0
    is Node -> if (left is End && right is End) 1 else left.leafCount() + right.leafCount()
}
