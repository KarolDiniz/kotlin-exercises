package arvores

fun <T> Tree<T>.convertToString(): String = when (this) {
    is End -> ""
    is Node -> "${value}${if (left != End || right != End) "(${left.convertToString()},${right.convertToString()})" else ""}"
}
