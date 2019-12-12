package xmas.cheatsheet.wishlist.classic

fun main() {
    val wishList: WishList = WishList(
        "Dear Santa...",
        Address("A Name", "A Street", 1, "A City"),
        mutableListOf(
            Wish("A new iPhone", "iPhone X"),
            Wish("A new Mac", "MacBook Pro")
        )
    )
    sendToSanta(wishList)
}

data class WishList(val title: String, val address: Address, val wishes: MutableList<Wish>)

data class Address(val name: String, val street: String, val number: Int, val city: String)

data class Wish(val title: String, val description: String)

fun sendToSanta(wishList: WishList) {
    println(wishList.title)
    println(wishList.address)
    wishList.wishes.forEach { wish ->
        println(wish)
    }
}