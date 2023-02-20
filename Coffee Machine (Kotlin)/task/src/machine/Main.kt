package machine

import kotlin.system.exitProcess

var w = 400.0
var m = 540.0
var b = 120.0
var d = 550.0
var cups = 9


class CoffeeMachine {
    fun buyEspresso() {
        if (w <= 250.0) {
            println("Sorry, not enough water!")
            return
        }
        if (b <= 16.0) {
            println("Sorry, not enough coffee beans!")
            return
        }
        if (cups <= 1) {
            println("Sorry, not enough cups!")
            return
        } else {
            println("I have enough resources, making you a coffee!")
            w -= 250.0
            b -= 16.0
            m -= 0.0
            d += 4.0
            cups -= 1
        }
    }

    fun buyLatte() {
        if (w <= 350.0) {
            println("Sorry, not enough water!")
            return
        }
        if (b <= 20.0) {
            println("Sorry, not enough coffee beans!")
            return
        }
        if (m <= 75) {
            println("(Sorry, not enough milk!")
            return
        }
        if (cups <= 1) {
            println("Sorry, not enough cups!")
            return
        } else {
            println("I have enough resources, making you a coffee!")
            w -= 350.0
            b -= 20.0
            m -= 75.0
            d += 7.0
            cups -= 1
        }
    }

    fun buyCappuccino() {
        if (w <= 200.0) {
            println("Sorry, not enough water!")
            return
        }
        if (b <= 12.0) {
            println("Sorry, not enough coffee beans!")
            return
        }
        if (m <= 100) {
            println("(Sorry, not enough milk!")
            return
        }
        if (cups <= 1) {
            println("Sorry, not enough cups!")
            return
        } else {
            println("I have enough resources, making you a coffee!")
            w -= 200.0
            b -= 12.0
            m -= 100.0
            d += 6.0
            cups -= 1
        }
    }

    fun getStatus() {
        println("The coffee machine has:")
        println("${w.toInt()} ml of water")
        println("${m.toInt()} ml of milk")
        println("${b.toInt()} g of coffee beans")
        println("${cups.toInt()} disposable cups")
        println("$" + "${d.toInt()} of money")
    }

    fun getDrink() {
        println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu:")
        when (readln()) {
            "1" -> buyEspresso()
            "2" -> buyLatte()
            "3" -> buyCappuccino()
            "back" -> return 
        }
    }

    fun take() {
        println("I gave you $${d.toInt()}")
        d = 0.0
    }

    fun fillMachine() {
        println("Write how many ml of water you want to add:")
        w += readln().toDouble()
        println("Write how many ml of milk you want to add:")
        m += readln().toDouble()
        println("Write how many grams of coffee beans you want to add:")
        b += readln().toDouble()
        println("Write how many disposable cups you want to add:")
        cups += readln().toInt()
    }
}
fun main() {
    while (true) {
        println("Write action (buy, fill, take, remaining, exit):")
        when (readln()) {
            "buy" -> CoffeeMachine().getDrink()
            "fill" -> CoffeeMachine().fillMachine()
            "take" -> CoffeeMachine().take()
            "remaining" -> CoffeeMachine().getStatus()
            "exit" -> exitProcess(0)
        }

    }
}
