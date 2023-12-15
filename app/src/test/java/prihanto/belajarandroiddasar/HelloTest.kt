package prihanto.belajarandroiddasar

import org.junit.Assert
import org.junit.Test

class HelloTest {
    @Test

    fun testSayHello(){
        val result = Hello.sayHello("Pri")

        Assert.assertEquals("Hello Pri", result)
    }
}