package week1

import util.Day
import util.IntCode
import util.asInts
import util.csv

// Answer #1: 14155342
// Answer #2: 8684145

fun main() {
    Day(n = 5) {
        answer { IntCode(lines.first().csv.asInts(), input = listOf(1)).run() }
        answer { IntCode(lines.first().csv.asInts(), input = listOf(5)).run() }
    }
}

