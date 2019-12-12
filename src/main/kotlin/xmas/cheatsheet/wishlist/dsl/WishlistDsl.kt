package xmas.cheatsheet.wishlist.dsl

fun main() {
    println("Classic Wish List")

    val wishList = WishList(
        "Dear Santa...",
        Address("A Name", "A Street", 1, "A City")
    )
    wishList.wishes.add(Wish("A new iPhone", "iPhone X"))
    wishList.wishes.add(Wish("A new Mac", "MacBook Pro"))

    sendToSanta(wishList)

    println ("DSL Wish List")

    val fancyWishList = wishList {
        title = "Dear Santa..."
        address {
            name = "A Name"
            street = "A Street"
            number = 1
            city = "A City"
        }
        wish {
            title = +"A new iPhone"
            description = "iPhone X"
        }
        wish {
            title = "A Mac"
            description = "MacBook Pro"
        }
    }

    sendToSanta(fancyWishList)
}

data class WishList(
    var title: String = "",
    var address: Address = Address(),
    val wishes: MutableList<Wish> = mutableListOf()
)

data class Address(var name: String = "", var street: String = "", var number: Int = 0, var city: String = "")

data class Wish(var title: String = "", var description: String = "")

fun sendToSanta(wishList: WishList) {
    println(wishList.title)
    println(wishList.address)
    wishList.wishes.forEach { println(it) }
}

// DSL Implementation
fun wishList(action: WishList.() -> Unit) = WishList().apply(action)

fun WishList.address(action: Address.() -> Unit) {
    address = Address().apply(action)
}

fun WishList.wish(action: Wish.() -> Unit) {
    wishes.add(Wish().apply(action))
}

operator fun String.unaryPlus() = "$this (optional)"