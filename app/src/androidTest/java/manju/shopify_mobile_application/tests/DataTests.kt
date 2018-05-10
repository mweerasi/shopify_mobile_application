package manju.shopify_mobile_application.tests

import android.support.test.InstrumentationRegistry
import android.support.test.espresso.action.ViewActions.click
import android.support.test.espresso.assertion.ViewAssertions.matches
import android.support.test.espresso.matcher.ViewMatchers.withText
import android.support.test.runner.AndroidJUnit4
import android.support.test.rule.ActivityTestRule
import android.support.test.uiautomator.UiDevice
import manju.shopify_mobile_application.MainActivity
import manju.shopify_mobile_application.helpers.Helper.launchApp
import org.junit.Test
import org.junit.runner.RunWith
import manju.shopify_mobile_application.page_objects.MainScreen
import manju.shopify_mobile_application.test.BuildConfig
import org.junit.Before
import org.junit.BeforeClass
import org.junit.Rule

@RunWith(AndroidJUnit4::class)
class DataTests {

    @get:Rule
    @JvmField
    var activityRule: ActivityTestRule<MainActivity> = ActivityTestRule(MainActivity::class.java, false, true)


    @Before
    fun prepareTest() {

    }

    @Test
    fun provinceSummaryVisible() {
        mainScreen.orderSummary().perform(click())
        mainScreen.provinceSummary().
                check(matches(withText("Alabama")))
    }

    companion object {
        private val mainScreen = MainScreen()
        private val device = UiDevice.getInstance(InstrumentationRegistry.getInstrumentation())

        @BeforeClass
        @JvmStatic
        fun setup(){
            launchApp(device, BuildConfig.APPLICATION_ID)
        }
    }
}