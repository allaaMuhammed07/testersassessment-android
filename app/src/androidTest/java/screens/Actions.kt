package screens

import android.view.View
import androidx.test.espresso.PerformException
import androidx.test.espresso.UiController
import androidx.test.espresso.ViewAction
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.util.HumanReadables
import androidx.test.espresso.util.TreeIterables
import org.hamcrest.Matcher
import java.util.concurrent.TimeoutException

class Actions {
    /**
     * The below is a customised function to wait for an element in the
     * view to be displayed
     * @param elementId = the id of the element that we want to wait for
     * @param timeout = an optional parameter presents the wait time
     */
    fun waitForElement(elementId: Int, timeout: Long = 180000): ViewAction? {
        return object : ViewAction {
            override fun getConstraints(): Matcher<View> {
                return ViewMatchers.isRoot()
            }

            override fun getDescription(): String {
                return ("wait for a specific view with id <" + elementId + "> during "
                        + timeout + " millis.")
            }

            override fun perform(uiController: UiController, rootView: View?) {// rootView
                uiController.loopMainThreadUntilIdle()
                val startTime = System.currentTimeMillis()
                val endTime = startTime + timeout
                val viewMatcher: Matcher<View> = ViewMatchers.withId(elementId)
                do {
                    for (child in TreeIterables.breadthFirstViewTraversal(rootView)) {
                        // found view with required ID
                        if (viewMatcher.matches(child)) {
                            return
                        }
                    }
                    uiController.loopMainThreadForAtLeast(50)
                } while (System.currentTimeMillis() < endTime)
                throw PerformException.Builder()
                    .withActionDescription(this.description)
                    .withViewDescription(HumanReadables.describe(rootView))
                    .withCause(TimeoutException())
                    .build()
            }
        }
    }
}