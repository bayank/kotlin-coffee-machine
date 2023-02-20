fun main() {
    val color = readln()
    println(Rainbow.valueOf(color.uppercase()).ordinal+1)
}

enum class Rainbow(val color: String) {
    RED("Red"),
    ORANGE("Orange"),
    YELLOW("Yellow"),
    GREEN("Green"),
    BLUE("Blue"),
    INDIGO("Indigo"),
    VIOLET("Violet");
}