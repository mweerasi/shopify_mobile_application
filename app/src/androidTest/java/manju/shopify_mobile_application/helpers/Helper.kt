package manju.shopify_mobile_application.helpers

import android.content.Intent
import android.support.test.InstrumentationRegistry
import android.support.test.uiautomator.By
import android.support.test.uiautomator.UiDevice
import android.support.test.uiautomator.Until


import manju.shopify_mobile_application.helpers.Constants.TIMEOUT_MS
import org.hamcrest.core.IsNull.notNullValue
import org.junit.Assert.assertThat

object Helper {
    /**
     * launchApp navigates the screen back to the app.
     * @param device
     * @param packageName
     */
    fun launchApp(device: UiDevice, packageName: String) {
        device.pressHome()

        // Wait for launcher
        val launcherPackage = device.launcherPackageName
        assertThat(launcherPackage, notNullValue())
        device.wait(Until.hasObject(By.pkg(launcherPackage).depth(0)), 30000)

        // Launch the app
        val context = InstrumentationRegistry.getContext()
        val intent = context.packageManager
                .getLaunchIntentForPackage(packageName)

        // Clear out any previous instances
        //intent!!.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK)
        context.startActivity(intent)

        // Wait for the app to appear
        device.wait(Until.hasObject(By.pkg(packageName).depth(0)), TIMEOUT_MS.toLong())
    }
}
