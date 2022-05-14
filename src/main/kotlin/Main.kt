import kotlin.math.sign

fun main(array: Array<Double>){

    val arraySize = array.size

    val arrayModified = DoubleArray(arraySize)

    var indexBegin = 0
    var indexEnd = arraySize - 1

    for (number in array){
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