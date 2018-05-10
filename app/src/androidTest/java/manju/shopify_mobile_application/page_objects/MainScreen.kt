package manju.shopify_mobile_application.page_objects

import android.support.test.espresso.ViewInteraction

import manju.shopify_mobile_application.R

import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.matcher.ViewMatchers.withId

class MainScreen {
    fun toolbar(): ViewInteraction{
        return onView(withId(R.id.toolbar))
    }

    fun orderSummary(): ViewInteraction {
        return onView(withId(R.id.list_view))
    }

    fun provinceSummary(): ViewInteraction {
        return onView(withId(R.id.orders_list))
    }
}
