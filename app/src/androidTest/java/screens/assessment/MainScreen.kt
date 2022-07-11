package screens.assessment

import androidx.test.espresso.Espresso.*
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.espresso.assertion.ViewAssertions.*
import com.abnamro.apps.referenceandroid.R

class MainScreen {
    private val screenHeaderId: Int = R.id.toolbar
    private val screenId: Int = R.id.fragment
    private val screenFabId: Int = R.id.fab
    private val snackbarId: Int = com.google.android.material.R.id.snackbar_text
    private val actions: screens.Actions = screens.Actions()

    /**
     * The below function is used to check if the header of the screen is displayed
     * We can use the espresso .isDisplayed() function for that
     */
    fun checkScreenHeader(){
        onView(withId(screenHeaderId)).check(matches(isDisplayed()))
    }

    /**
     * The below function is used to make sure that the text that appears
     * on the screen matches the one that we are expecting
     * and meets the business criteria
     * @param screenText = the text that we are expecting
     */
    fun checkText(screenText: String){
        actions.waitForElement(screenId)
        onView(withParent(withId(screenId))).check(matches(withText(screenText)))
    }

    /**
     * The below function is used to click on FAB
     */
    fun clickOnFloatingActionButton(){
        actions.waitForElement(screenFabId)
        onView(withId(screenFabId)).perform(click())
    }

    /**
     * The below function is tho check on the text that will be displayed
     * in the pop-up message after tapping on the FAB and to make sure that
     * it matches our the one we are expecting and the business criteria
     * @param fabMessage = the text that we are expecting
     */
    fun checkFabMessage(fabMessage: String){
        actions.waitForElement(screenFabId)
        onView(withId(snackbarId)).check(matches(withText(fabMessage)))
    }

    /**
     * The below function is for clicking on kebab menu that is in the toolbar
     * and then click on settings
     */
    fun clickOnSettings(){
        actions.waitForElement(screenHeaderId)
        onView(isRoot()).perform(pressMenuKey())
        onView(isRoot()).perform(click())
    }
}