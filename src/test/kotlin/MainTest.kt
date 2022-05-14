
import org.junit.*
import org.junit.Assert.*
import org.junit.runner.RunWith
import org.junit.runners.Parameterized
import java.io.ByteArrayOutputStream
import java.io.PrintStream

import kotlin.math.sign


@RunWith(Parameterized::class)
class MainTest(private val array: Array<Double>) {
    companion object {
        @JvmStatic
        @Parameterized.Parameters
        fun monthNumbers(): Collection<Array<Array<Double>>> {
            return listOf(
                arrayOf(arrayOf(1.0, 2.0, 3.0)),
                arrayOf(arrayOf(-1.3, -1.5, -2.0)),
                arrayOf(arrayOf(-2.0, -3.0, 4.0, 5.6)),
                arrayOf(arrayOf(-0.5, 5.6, -0.7)),
                arrayOf(arrayOf(4.0, -1.0, 3.0, -7.7)),
                arrayOf(arrayOf(0.0, -0.7)),
                arrayOf(arrayOf(3.0, -1.0, 0.0, -2.0))
            )
        }

        private val console: PrintStream = System.out
        private var bytesOutput: ByteArrayOutputStream = ByteArrayOutputStream()
        private val printStreamNew: PrintStream = PrintStream(bytesOutput)

        @BeforeClass
        @JvmStatic
        fun setUp() {
            System.setOut(printStreamNew)
        }

        @AfterClass
        @JvmStatic
        fun tearDown() {
            System.setOut(console)
        }
    }

    @Before
    fun prepareTest() {
        bytesOutput.reset()
    }

    @After
    fun cleanupTest() {
        bytesOutput.reset()
    }

    @Test
    fun testArray() {
        main(array)
        val resultArray = (bytesOutput.toString(Charsets.UTF_8).trim()).split(" ")
        val size = resultArray.size
        var index = 0

        while ((index < size) && ((resultArray[index].toDouble()).sign < 0.0)){
            index++
        }

        while ((index < size) && ((resultArray[index].toDouble()).sign > -1.0)){
            index++
        }

        assertEquals("Wrong structure: fail at index ${index - 1}", size, index)
    }
}
