import java.io.FileReader
import kotlin.math.sign

fun main(args: Array<String>){
    val fileReader = FileReader("./input/Input.doc")
    val array = fileReader.readLines()
    val arraySize = array.size

    var arrayModified = DoubleArray(arraySize)

    var indexBegin = 0
    var indexEnd = arraySize - 1

    for (line in array){
        var number = line.toDouble()
        if (number.sign < 0.0) {
            arrayModified[indexBegin] = number
            indexBegin += 1
        } else {
            arrayModified[indexEnd] = number
            indexEnd -= 1
        }
    }



}