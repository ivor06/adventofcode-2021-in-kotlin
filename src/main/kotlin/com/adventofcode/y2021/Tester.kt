package com.adventofcode.y2021

fun main() {
    day1()
}
fun day1() {
    val testInput1 = Utils.readInput("main/resources/y2021/Day01_1")
    val testInput2 = Utils.readInput("main/resources/y2021/Day01_2")

    /* part1 */
    check(Day1.part1(testInput1) == 7)
    check(Day1.part1(testInput2) == 1696)

    /* part2 */
    check(Day1.part2(testInput1) == 5)
    check(Day1.part2(testInput2) == 1737)
}