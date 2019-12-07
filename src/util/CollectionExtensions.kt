package util

import java.lang.IllegalArgumentException

fun <T: Collection<String>> T.asInts() = this.map { it.toInt() }
fun <T: Collection<String>> T.asFloats() = this.map { it.toFloat() }

fun <T> List<T>.permutations(): Set<List<T>> = when {
    isEmpty() -> emptySet()
    size == 1 -> setOf(listOf(get(0)))
    else -> {
        val element = get(0)
        drop(1).permutations()
            .flatMap { sublist -> (0..sublist.size).map { i -> sublist.plusAt(i, element) } }
            .toSet()
    }
}

internal fun <T> List<T>.plusAt(index: Int, element: T): List<T> = when {
    index !in 0..size -> throw IllegalArgumentException("Index: $index Size: $size")
    index == 0 -> listOf(element) + this
    index == size -> this + element
    else -> dropLast(size - index) + element + drop(index)
}