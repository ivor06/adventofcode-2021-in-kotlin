package com.adventofcode.y2021

object Day1 {
    fun part1(input: List<String>): Int {
        return input.asSequence().map { it.toInt() }
            .zipWithNext()
            .map { it.second - it.first }
            .count { it > 0 }
    }

    fun part2(input: List<String>): Int {
        return input.asSequence().map { it.toInt() }
            .windowed(3, 1)
            .zipWithNext()
            .map {it.second.sum() - it.first.sum()}
            .count{ it > 0 }
    }
}
