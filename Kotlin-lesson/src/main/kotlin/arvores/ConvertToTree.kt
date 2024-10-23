package arvores

fun convertToTree(str: String): Tree<Char> {
    fun parseNode(index: Int): Pair<Tree<Char>, Int> {
        if (str[index] == '.') return End to index + 1
        val value = str[index]
        if (index + 1 >= str.length || str[index + 1] != '(') return Node(value) to index + 1
        val (left, nextIndex1) = parseNode(index + 2)
        val (right, nextIndex2) = parseNode(nextIndex1 + 1)
        return Node(value, left, right) to nextIndex2
    }
    return parseNode(0).first
}
