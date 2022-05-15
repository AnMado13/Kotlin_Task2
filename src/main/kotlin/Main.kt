import kotlin.math.sign

fun main(arg: String){

    val array = arg.trim().split(" ")
    val arraySize = array.size

    val arrayModified = DoubleArray(arraySize)

    var indexBegin = 0
    var indexEnd = arraySize - 1

    for (element in array){
        val number = element.toDouble()
        if (number.sign < 0.0) {
            arrayModified[indexBegin] = number
            indexBegin += 1
        } else {
            arrayModified[indexEnd] = number
            indexEnd -= 1
        }
    }

    arrayModified.forEach { print("$it ") }


}