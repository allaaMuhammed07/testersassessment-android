package tests

import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.LargeTest
import com.abnamro.apps.referenceandroid.MainActivity
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import screens.assessment.MainScreen

@RunWith(AndroidJUnit4::class)
@LargeTest
class MainScreenTest {
    private val mainScreen: MainScreen = MainScreen()

    @get:Rule
    var activityScenarioRule: ActivityScenarioRule<MainActivity> =
        ActivityScenarioRule(MainActivity::class.java)


    @Test
    fun checkTheScreen(){
        mainScreen.checkTheScreenHeader()
    }
}