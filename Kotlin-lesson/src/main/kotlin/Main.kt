import listas.*
import aritmetica.*
import arvores.*

fun main() {
    while (true) {
        println(
            """
            | Escolha uma função para testar:
            | 1 - Último elemento de uma lista
            | 2 - Penúltimo elemento de uma lista
            | 3 - Verificar se uma lista é palíndroma
            | 4 - Codificar uma string com Run-Length
            | 5 - Decodificar uma lista com Run-Length
            | 6 - Verificar se um número é primo
            | 7 - Calcular o MDC (Maior Divisor Comum)
            | 8 - Listar números primos em um intervalo
            | 9 - Adicionar nós em uma árvore binária de busca
            | 10 - Contar folhas em uma árvore
            | 11 - Listar valores das folhas de uma árvore
            | 12 - Converter árvore para string
            | 13 - Converter string para árvore
            | 0 - Sair
            """.trimMargin()
        )

        print("Escolha uma opção: ")
        when (readLine()?.toIntOrNull()) {
            1 -> {
                print("Digite os elementos da lista (separados por vírgula): ")
                val list = readLine()?.split(",")?.map { it.trim() }
                println("Último elemento: ${last(list ?: emptyList())}")
            }
            2 -> {
                print("Digite os elementos da lista (separados por vírgula): ")
                val list = readLine()?.split(",")?.map { it.trim() }
                println("Penúltimo elemento: ${penultimate(list ?: emptyList())}")
            }
            3 -> {
                print("Digite os elementos da lista (separados por vírgula): ")
                val list = readLine()?.split(",")?.map { it.trim() }
                println("A lista é palíndroma?: ${isPalindrome(list ?: emptyList())}")
            }
            4 -> {
                print("Digite uma string: ")
                val str = readLine()?.toList() ?: emptyList()
                println("Codificação Run-Length: ${encode(str)}")
            }
            5 -> {
                print("Digite a codificação Run-Length (formato: quantidade,caractere): ")
                val encoded = readLine()?.split(",")?.map {
                    val (count, char) = it.trim().split(" ")
                    Pair(count.toInt(), char.single())
                } ?: emptyList()
                println("Decodificação Run-Length: ${decode(encoded)}")
            }
            6 -> {
                print("Digite um número: ")
                val num = readLine()?.toIntOrNull() ?: 0
                println("O número $num é primo?: ${num.isPrime()}")
            }
            7 -> {
                print("Digite dois números separados por espaço: ")
                val (a, b) = readLine()?.split(" ")?.map { it.toIntOrNull() ?: 0 } ?: listOf(0, 0)
                println("MDC de $a e $b: ${gcd(a, b)}")
            }
            8 -> {
                print("Digite o intervalo (formato: inicio fim): ")
                val (start, end) = readLine()?.split(" ")?.map { it.toIntOrNull() ?: 0 } ?: listOf(0, 0)
                println("Números primos no intervalo $start..$end: ${listPrimesInRange(start..end)}")
            }
            9 -> {
                var tree: Tree<Int> = End
                while (true) {
                    print("Digite um número para adicionar na árvore (ou 'fim' para parar): ")
                    val input = readLine()
                    if (input == "fim") break
                    val num = input?.toIntOrNull() ?: continue
                    tree = addNode(tree, num)
                    println("Árvore atual: $tree")
                }
            }
            10 -> {
                val tree = Node('a', Node('b', Node('d'), Node('e')), Node('c', End, Node('f', Node('g'), End)))
                println("Contagem de folhas na árvore: ${tree.leafCount()}")
            }
            11 -> {
                val tree = Node('a', Node('b', Node('d'), Node('e')), Node('c', End, Node('f', Node('g'), End)))
                println("Valores das folhas na árvore: ${tree.leafValues()}")
            }
            12 -> {
                val tree = Node('a', Node('b', Node('d'), Node('e')), Node('c', End, Node('f', Node('g'), End)))
                println("Árvore convertida para string: ${tree.convertToString()}")
            }
            13 -> {
                print("Digite a representação de uma árvore em string: ")
                val str = readLine() ?: ""
                println("Árvore convertida da string: ${convertToTree(str)}")
            }
            0 -> {
                println("Saindo...")
                return
            }
            else -> {
                println("Opção inválida. Tente novamente.")
            }
        }
    }
}
