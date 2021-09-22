package com.leovieira.final_overview

fun main() {

    println(runOperation(2F, 4F, ::multiply))
    println(runOperation(2, 4, ::sum))


}

fun runOperation(num1: Int, num2: Int, operation: (Int, Int) -> Int): Int {
    return operation(num1, num2)
}

fun <T: Number> runOperation(num1: T, num2: T, operation: (T, T) -> T): T {
    return operation(num1, num2)
}

fun sum(num1: Int, num2: Int): Int {
    return num1 + num2
}

fun multiply(num1: Float, num2: Float): Float {
    return num1 * num2
}