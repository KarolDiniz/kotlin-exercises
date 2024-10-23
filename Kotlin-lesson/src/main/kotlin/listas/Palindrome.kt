package listas

fun <T> isPalindrome(list: List<T>): Boolean {
    return list == list.reversed()
}
