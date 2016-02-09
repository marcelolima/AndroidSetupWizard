package com.androidlogin;

import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;
import android.support.test.uiautomator.By;
import android.support.test.uiautomator.UiDevice;
import android.support.test.uiautomator.Until;

import junit.framework.Assert;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;


/**
 * Created by marcelolima on 11/18/15.
 */
@RunWith(AndroidJUnit4.class)
public class AndroidLoginTest {
    private static final long HOMESCREEN_TIMEOUT_MS = 1*60*60*1000; // 1 hour
    private final UiDevice uiDevice = UiDevice.getInstance(InstrumentationRegistry.getInstrumentation());

    @Before
    public void setUp() throws Exception {
        ScreenContainer screenContainer = new ScreenContainer(uiDevice);
        UiWatcherRegister.registerWatchers(uiDevice, screenContainer);
    }

    @Test
    public void androidLogin() throws Exception {
        Assert.assertTrue(uiDevice.wait(Until.hasObject(By.desc("Apps")), HOMESCREEN_TIMEOUT_MS));
    }

    @After
    public void tearDown() throws Exception {
        // Click on Got it in the Welcome Popup at homescreen.
        uiDevice.wait(Until.hasObject(By.res("com.google.android.googlequicksearchbox:id/cling_dismiss_longpress_info")), 10000);
        uiDevice.findObject(By.res("com.google.android.googlequicksearchbox:id/cling_dismiss_longpress_info")).click();
    }
}
