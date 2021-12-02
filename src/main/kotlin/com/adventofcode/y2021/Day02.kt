package com.adventofcode.y2021

object Day2 {
    fun part1(input: List<String>): Int {
        var depth = 0
        var length = 0
        for (command in input) {
            val lst = command.split(" ")
            val value: Int = lst[1].toInt()
            when (lst[0]) {
                "forward" -> length += value
                "down" -> depth += value
                "up" -> depth -= value
            }
        }

        return depth * length
    }

    fun part2(input: List<String>): Int {
        var depth = 0
        var length = 0
        var aim = 0
        for (command in input) {
            val lst = command.split(" ")
            val value: Int = lst[1].toInt()
            when (lst[0]) {
                "forward" -> {
                    length += value
                    depth += aim * value
                }
                "down" -> aim += value
                "up" -> aim -= value
            }
        }

        return depth * length
    }
}
