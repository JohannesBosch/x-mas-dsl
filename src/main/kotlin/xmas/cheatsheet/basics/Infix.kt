package xmas.cheatsheet.basics

fun main() {
    val result = 5 add 5
    print(result)
}

// They must be member functions or extension functions
// They must have a single parameter
// The parameter must not accept variable number of arguments and must have no default value

infix fun Int.add(value: Int) = this + value