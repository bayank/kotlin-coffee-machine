fun createSeating(rows: Int, seats: Int): Array<Array<Char>> {
    val cinema = Array(rows) { Array(seats) { 'S' } }
    return cinema
}

fun printSeating(cinema: Array<Array<Char>>) {
    println("Cinema:")
    print("  ")
    for (seatNum in 1..cinema[0].size) {
        print("$seatNum ")
    }
    println()
    for (rowNum in cinema.indices) {
        print("${rowNum + 1} ")
        for (seat in cinema[rowNum]) {
            print("$seat ")
        }
        println()
    }
}

fun buyTicket(cinema: Array<Array<Char>>) {
    var isValidSeat = false

    while (!isValidSeat) {
        print("Enter a row number:\n")
        val row = readLine()!!.toInt()
        print("Enter a seat number in that row:\n")
        val seat = readLine()!!.toInt()

        if (row < 1 || row > cinema.size || seat < 1 || seat > cinema[0].size) {
            println("Wrong input!")
            println()
        } else if (cinema[row - 1][seat - 1] == 'B') {
            println("That ticket has already been purchased!")
            println()
        } else {
            isValidSeat = true
            val ticketPrice = calculateTicketPrice(cinema, row)
            println("Ticket price: $$ticketPrice")
            cinema[row - 1][seat - 1] = 'B'
        }
    }
}

fun calculateTicketPrice(cinema: Array<Array<Char>>, row: Int): Int {
    val rows = cinema.size
    val seats = if (rows > 0) cinema[0].size else 0 // Assuming all rows have the same number of seats

    val totalSeats = rows * seats
    return if (totalSeats <= 60 || row <= rows / 2) 10 else 8
}

fun countSeats(cinema: Array<Array<Char>>): Int {
    var takenSeatsCount = 0

    for (row in cinema.indices) {
        for (seat in cinema[row].indices) {
            if (cinema[row][seat] == 'B') {
                takenSeatsCount++
            }
        }
    }
    return takenSeatsCount
}

fun calcPercent(cinema: Array<Array<Char>>): String {
    var seats = 0
    for (row in cinema.indices) {
        seats += cinema[row].size
    }
    val takenSeats = countSeats(cinema)
    val percentage: Float = (takenSeats.toFloat() / seats.toFloat()) * 100
    val formatPercentage = "%.2f".format(percentage)
    return formatPercentage
}

fun calcIncome(cinema: Array<Array<Char>>): Int {
    var sum = 0

    for (row in cinema.indices) {
        for (seat in cinema[row].indices) {
            if (cinema[row][seat] == 'B') {
                sum += calculateTicketPrice(cinema, row + 1)
            }
        }
    }
    return sum
}

fun sellout(cinema: Array<Array<Char>>): Int {
    var sum = 0

    for (row in cinema.indices) {
        for (seat in cinema[row].indices) {
                sum += calculateTicketPrice(cinema, row + 1)
            }
        }
        return sum
}

fun printStats(cinema: Array<Array<Char>>) {
//    Number of purchased tickets: 1
//    Percentage: 2.78%
//    Current income: $10
//    Total income: $360
    val takenSeats = countSeats(cinema)
    val percent = calcPercent(cinema)
    val income = calcIncome(cinema)
    val fullhouse = sellout(cinema)
    println("Number of purchased tickets: $takenSeats")
    println("Percentage: $percent%")
    println("Current income: $$income")
    println("Total income: $$fullhouse")
}

fun cinemaMenu() {
    print("Enter the number of rows:\n")
    val rows = readLine()!!.toInt()
    print("Enter the number of seats in each row:\n")
    val seats = readLine()!!.toInt()

    val cinema = createSeating(rows, seats)

    while (true) {
        println("\n1. Show the seats")
        println("2. Buy a ticket")
        println("3. Statistics")
        println("0. Exit")
        print("> ")
        val choice = readLine()!!.toInt()
        println()

        when (choice) {
            1 -> printSeating(cinema)
            2 -> buyTicket(cinema)
            3 -> printStats(cinema)
            0 -> break
            else -> println("Invalid choice! Please try again.")
        }
    }
}

fun main() {
    cinemaMenu()
}
