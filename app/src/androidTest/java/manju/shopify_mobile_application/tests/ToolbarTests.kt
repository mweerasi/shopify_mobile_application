package manju.shopify_mobile_application.tests

import android.support.test.espresso.action.ViewActions.click
import android.support.test.espresso.assertion.ViewAssertions.matches
import android.support.test.espresso.matcher.ViewMatchers.withText
import android.support.test.runner.AndroidJUnit4
import manju.shopify_mobile_application.R
import org.junit.Test
import org.junit.runner.RunWith
import manju.shopify_mobile_application.page_objects.MainScreen

@RunWith(AndroidJUnit4::class)
class ToolbarTests {

    @Test
    fun toolbarTextTest() {
        mainScreen.toolbar()
                .check(matches(withText(R.string.title_activity_main)))
        mainScreen.orderSummary().perform(click())
        mainScreen.toolbar().
                check(matches(withText(R.string.title_activity_province)))
    }

    companion object {
        private val mainScreen = MainScreen()
    }
}