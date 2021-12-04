package com.adventofcode.y2021

fun main() {
    day1()
    day2()
    day3()
    day4()
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

fun day2() {
    val testInput1 = Utils.readInput("main/resources/y2021/Day02_1")
    val testInput2 = Utils.readInput("main/resources/y2021/Day02_2")

    /* part1 */
    check(Day2.part1(testInput1) == 150)
    check(Day2.part1(testInput2) == 2036120)

    /* part2 */
    check(Day2.part2(testInput1) == 900)
    check(Day2.part2(testInput2) == 2015547716)
}

fun day3() {
    val testInput1 = Utils.readInput("main/resources/y2021/Day03_1")
    val testInput2 = Utils.readInput("main/resources/y2021/Day03_2")

    /* part1 */
    check(Day3.part1(testInput1) == 198)
    check(Day3.part1(testInput2) == 3969000)

    /* part2 */
    check(Day3.part2(testInput1) == 230)
    check(Day3.part2(testInput2) == 4267809)
}

fun day4() {
    val testInput1 = Utils.readInput("main/resources/y2021/Day04_1")
    val testInput2 = Utils.readInput("main/resources/y2021/Day04_2")

    /* part1 */
    check(Day4.part1(testInput1) == 4512)
    check(Day4.part1(testInput2) == 10374)

    /* part2 */
    check(Day4.part2(testInput1) == 1924)
    check(Day4.part2(testInput2) == 24742)
}