package xmas.cheatsheet.basics

//A higher-order function is a function that takes functions as parameters, or returns a function.
fun higherOrderFunction(doSomething: (a: Int, b: Int) -> Int): Unit {
    val a: Int = 5
    val b: Int = 5

    println(doSomething(a, b).toString())
}

fun main() {

    // Lambda expression
    higherOrderFunction({ a, b -> a + b })

    // Lambda expression assigned to a variable
    val doSomething: (Int, Int) -> Int = { a, b -> a + b }

    higherOrderFunction(doSomething)

    // Anonymous function assigned to a variable
    val doSomethingIf: (Int, Int) -> Int = fun(a: Int, b: Int): Int {
        if (a > 0 && b > 0) {
            return a + b
        }
        return 0
    }

    higherOrderFunction(doSomethingIf)

    // Execute a function type
    println(doSomethingIf.invoke(5, 5))
    println(doSomethingIf(5, 5))
}

typealias MyFunctionType = (Int, Int) -> Int