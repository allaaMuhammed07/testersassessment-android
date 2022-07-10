package screens.assessment

import androidx.test.espresso.Espresso.*
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.matcher.ViewMatchers.*
import com.abnamro.apps.referenceandroid.R

class MainScreen {
    private val screenHeaderId: Int = R.id.toolbar
    private val screenFabId: Int = R.id.fab
    private val actions: screens.Actions = screens.Actions()

    fun checkTheScreenHeader(){
        actions.waitForElement(screenHeaderId)
        onView(withId(screenHeaderId)).perform(click())
    }
}