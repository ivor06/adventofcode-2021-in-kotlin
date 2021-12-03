package com.adventofcode.y2021

object Day3 {
    fun part1(input: List<String>): Int {
        val length = input[0].length
        val freq = IntArray(length)

        for (word: String in input) {
            val lst = word.toCharArray()
            var index = 0

            for (symbol: Char in lst)
                freq[index++] += if (symbol == '1') 1 else -1
        }

        val sb : StringBuilder = StringBuilder(length)

        for (value in freq)
            sb.append(if (value > 0) 1 else 0)

        val gamma = sb.toString().toInt(2)
        val epsilon = invertBits(gamma)

        return gamma * epsilon
    }

    fun part2(input: List<String>): Int {
        val indices = input[0].indices

        val oxygenRating = indices
            .asSequence()
            .runningFold(input) { remaining, pos ->
                val (zeros, ones) = remaining.countBitsAt(pos)
                remaining.filter { it[pos] == (if (ones >= zeros) '1' else '0') }
            }
            .first { it.size == 1 }
            .single()
            .toInt(2)

        val co2Rating = indices
            .asSequence()
            .runningFold(input) { remaining, pos ->
                val (zeros, ones) = remaining.countBitsAt(pos)
                remaining.filter { it[pos] == (if (ones < zeros) '1' else '0') }
            }
            .first { it.size == 1 }
            .single()
            .toInt(2)

        return oxygenRating * co2Rating
    }

    private fun invertBits(n: Int): Int {
        val x: Int = kotlin.math.log2(n.toDouble()).toInt()
        var m = 1 shl x
        m = m or m - 1

        return n xor m
    }

    private fun List<String>.countBitsAt(pos: Int): Pair<Int, Int> =
        with(asSequence().map { it[pos] }) { count { it == '0' } to count { it == '1' } }
}
