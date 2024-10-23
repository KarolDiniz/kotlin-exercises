package arvores

sealed interface Tree<out T>
data class Node<out T>(val value: T, val left: Tree<T> = End, val right: Tree<T> = End) : Tree<T>
object End : Tree<Nothing>

fun <T : Comparable<T>> addNode(tree: Tree<T>, value: T): Tree<T> = when (tree) {
    is End -> Node(value)
    is Node -> if (value < tree.value) {
        tree.copy(left = addNode(tree.left, value))
    } else {
        tree.copy(right = addNode(tree.right, value))
    }
}
