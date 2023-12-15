package prihanto.belajarandroiddasar

import android.app.Application
import android.content.Context
import androidx.test.core.app.ActivityScenario
import androidx.test.core.app.ApplicationProvider
import androidx.test.espresso.Espresso
import androidx.test.espresso.Espresso.*
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.assertion.ViewAssertions.*
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class MainActivityTest {
//    lateinit var mainActivityScenario: ActivityScenario<MainActivity>
//
//    @Before
//    fun setUp(){
//        mainActivityScenario = ActivityScenario.launch(MainActivity::class.java)
//    }
//
//
//
//    @After
//    fun tearDown(){
//        mainActivityScenario.close()
//    }
    @get:Rule
    var mainActivityScenarioRule = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun testSayHello(){
        val context = ApplicationProvider.getApplicationContext<Context>() // untuk mendapatkan nilai bahasa yang digunakan (IDN / ENG ?)
        var name = "Prihanto"
        // menulis otomatis di nameEditText
//        Espresso.onView(ViewMatchers.withId(R.id.nameEditText))
//            .perform(ViewActions.typeText("Prihanto"))

        onView(withId(R.id.nameEditText))
            .perform(typeText(name))

        Espresso.pressBack()

        onView(withId(R.id.sayHelloButton))
            .perform(click())

        onView(withId(R.id.sayHelloTextView))
            .check(matches(withText(context.getString(R.string.sayHelloTextView, name))))


//        Thread.sleep(2000)
    }
}