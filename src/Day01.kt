fun main() {
    fun part1(input: List<String>): Int {
        val result = 1

        for (i in 1..input.lastIndex)
            if (input[i] > input[i - 1])
                result.inc()

        return result
    }

    fun part2(input: List<String>): Int {
        var firstNumber = input[0]
        var result = 0

        for (i in 3..input.lastIndex) {
            if (input[i] > firstNumber)
                result++
            firstNumber = input[i - 2]
        }

        return result
    }

    // test if implementation meets criteria from the description, like:
    val testInput = readInput("Day01_test")
    check(part1(testInput) == 1)

    val input = readInput("Day01")
    println(part1(input))
    println(part2(input))
}
