import listas.*
import aritmetica.*
import arvores.*

fun main() {
    // Testando funções de Listas
    println("Testando funções de Listas:")
    println("Último elemento de listOf(1, 1, 2, 3, 5, 8): " + last(listOf(1, 1, 2, 3, 5, 8))) // 8
    println("Penúltimo elemento de listOf(1, 1, 2, 3, 5, 8): " + penultimate(listOf(1, 1, 2, 3, 5, 8))) // 5
    println("A lista listOf(1, 2, 3, 2, 1) é palíndroma?: " + isPalindrome(listOf(1, 2, 3, 2, 1))) // true
    println("Codificação Run-Length de \"aaaabccaadeeee\": " + encode("aaaabccaadeeee".toList())) // [(4, a), (1, b), (2, c), (2, a), (1, d), (4, e)]
    println("Decodificação Run-Length de [(4, a), (1, b), (2, c), (2, a), (1, d), (4, e)]: " + decode(listOf(Pair(4, 'a'), Pair(1, 'b'), Pair(2, 'c'), Pair(2, 'a'), Pair(1, 'd'), Pair(4, 'e')))) // [a, a, a, a, b, c, c, a, a, d, e, e, e, e]

    // Testando funções de Aritmética
    println("\nTestando funções de Aritmética:")
    println("O número 7 é primo?: " + 7.isPrime()) // true
    println("O MDC de 36 e 63 é: " + gcd(36, 63)) // 9
    println("Lista de primos no intervalo 7..31: " + listPrimesInRange(7..31)) // [7, 11, 13, 17, 19, 23, 29, 31]

    // Testando funções de Árvores
    println("\nTestando funções de Árvores:")
    val tree = Node('a', Node('b', Node('d'), Node('e')), Node('c', End, Node('f', Node('g'), End)))
    println("Contagem de folhas na árvore: " + tree.leafCount()) // 3
    println("Valores das folhas na árvore: " + tree.leafValues()) // [d, e, g]
    println("Árvore convertida para string: " + tree.convertToString()) // a(b(d,e),c(,f(g,)))
    println("Convertendo string 'a(b(d,e),c(,f(g,)))' para árvore: " + convertToTree("a(b(d,e),c(,f(g,)))")) // T(a T(b T(d) T(e)) T(c . T(f T(g) .)))

    // Teste de adição de nós
    val tree2 = addNode(End, 5)
        .let { addNode(it, 3) }
        .let { addNode(it, 8) }
        .let { addNode(it, 1) }
    println("Árvore binária de busca após adições: $tree2") // Deve criar uma árvore binária com os valores 5, 3, 8, 1
}
