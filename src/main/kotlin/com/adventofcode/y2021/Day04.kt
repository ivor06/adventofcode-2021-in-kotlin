package com.adventofcode.y2021

import kotlin.collections.ArrayList
import kotlin.collections.HashMap
import kotlin.collections.HashSet

typealias BingoBoard = List<List<Int>>

object Day4 {
    fun part1(input: List<String>): Int {
        val length = input[2].split(" ").count()
        val matrices: ArrayList<HashSet<Int>> = ArrayList()
        val lines: HashMap<HashSet<Int>, Int> = HashMap()
        var matrixNumber = 0
        val verticalLines: ArrayList<HashSet<Int>> = ArrayList(length)

        for (i in 2 until input.size) {
            if (input[i].isEmpty()) {
                for (verticalLine in verticalLines)
                    lines[verticalLine] = matrixNumber

                verticalLines.clear()

                matrixNumber++

                continue
            }

            val line = input[i].trim().split("\\s+".toRegex())
                .map { it.toInt() }

            if (matrices.size < matrixNumber + 1)
                matrices.add(HashSet())

            matrices[matrixNumber].addAll(line)

            for (j in 0 until length - 1) {
                if (verticalLines.size < j + 1)
                    verticalLines.add(HashSet())

                verticalLines[j].add(line[j])
            }

            lines[line.toHashSet()] = matrixNumber
        }

        val numbers: List<Int> = input.first().split(",")
            .map { it.toInt() }
        var sumSoFar = 0
        val numbersSoFar: HashSet<Int> = HashSet()

        for (num in numbers) {
            sumSoFar += num
            numbersSoFar.add(num)

            for ((line, matrixNum) in lines) {
                line.remove(num)

                if (line.isEmpty()) {
                    matrices[matrixNum].removeAll(numbersSoFar)

                    return num * matrices[matrixNum].sum()
                }
            }
        }

        return 0
    }

    /* https://github.com/tginsberg/advent-2021-kotlin/blob/master/src/main/kotlin/com/ginsberg/advent2021/Day04.kt */
    fun part2(input: List<String>): Int {
        val draws: List<Int> = input.first().split(",").map { it.toInt() }
        val boards: Set<BingoBoard> = parseInput(input)

        val drawn = draws.toMutableSet()
        return draws.reversed().firstNotNullOf { draw ->
            drawn -= draw
            boards.firstOrNull { !it.isWinner(drawn) }?.let { winner ->
                draw * (winner.sumUnmarked(drawn) - draw)
            }
        }
    }

    private fun BingoBoard.isWinner(draws: Set<Int>) =
        this.any { row -> row.all { it in draws } } ||
                (0..4).any { col -> this.all { row -> row[col] in draws } }

    private fun BingoBoard.sumUnmarked(draws: Set<Int>): Int =
        this.sumOf { row ->
            row.filterNot { it in draws }.sum()
        }

    private fun parseInput(input: List<String>): Set<BingoBoard> =
        input
            .asSequence()
            .drop(1)
            .filter { it.isNotEmpty() }
            .chunked(5)
            .map { parseSingleBoard(it) }
            .toSet()

    private fun parseSingleBoard(input: List<String>): BingoBoard =
        input.map { row ->
            row.split(" ").filter { it.isNotEmpty() }.map { it.toInt() }
        }
}
