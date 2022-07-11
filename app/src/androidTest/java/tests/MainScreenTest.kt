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
    private val expectedMainScreenMessage: String = "Hello World!"
    private val expectedSnackbarMessage: String = "Replace with your own action"

    @get:Rule
    var activityScenarioRule: ActivityScenarioRule<MainActivity> =
        ActivityScenarioRule(MainActivity::class.java)

    /**
     * The below test is to check that the app is launched successfully
     * and user taps the floating action button (FAB)
     */
    @Test
    fun checkTheScreen(){
        mainScreen.checkScreenHeader()
        mainScreen.clickOnFloatingActionButton()
    }

    /**
     * The below test is to check that the text that will appear on the screen is the same
     * as expected
     */
    @Test
    fun checkOnTheScreenText()
    {
        mainScreen.checkText(expectedMainScreenMessage)
    }

    /**
     * The below test is to check that the message that will appear on the screen is the same
     * as expected
     */
    @Test
    fun checkMessageAfterClickingFab(){
        mainScreen.checkScreenHeader()
        mainScreen.clickOnFloatingActionButton()
        mainScreen.checkFabMessage(expectedSnackbarMessage)
    }

    /**
     * The below test is to click on the kebab menu in the app and then click on settings
     */
    @Test
    fun clickOnMenuAndSettings(){
        mainScreen.checkScreenHeader()
        mainScreen.clickOnSettings()
    }
}