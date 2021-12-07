package com.adventofcode.y2021

import kotlin.collections.ArrayDeque
import kotlin.collections.ArrayList
import kotlin.collections.HashMap

object Day6 {
    fun part1(input: List<String>): Long {
        val queue: ArrayDeque<Long> = parseInput(input)
        println("queue: $queue")

        return countFish(queue, 80)
    }

    fun part2(input: List<String>): Long {
        val queue: ArrayDeque<Long> = parseInput(input)

        return countFish(queue, 255)
    }
}

private fun countFish(queue: ArrayDeque<Long>, days: Int): Long {
    for (i in 0..days) {
        val tmp: Long = queue.removeFirst()
        queue.add(tmp)
        queue[6] += queue[8]
        println(queue)
    }
    println("queue.sum(): ${queue.sum()}")
    return queue.sum()
}

private fun parseInput(input: List<String>): ArrayDeque<Long> {
    val lst: ArrayList<Long> = ArrayList()

    input[0].split(",")
    .asSequence().map { it.toLong() }
    .toCollection(lst)

    val map: HashMap<Long, Long> = HashMap()

    for (item in lst)
        map.merge(item, 1, Long::plus)

    val queue: ArrayDeque<Long> = ArrayDeque()

    for (i in 0..8L)
        queue.add(map.getOrDefault(i, 0L))

    return queue
}
