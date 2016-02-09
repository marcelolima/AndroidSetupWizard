package com.androidlogin;

import android.support.test.uiautomator.By;
import android.support.test.uiautomator.UiDevice;
import android.support.test.uiautomator.UiObject2;
import android.support.test.uiautomator.UiObjectNotFoundException;
import android.support.test.uiautomator.UiScrollable;
import android.support.test.uiautomator.UiSelector;
import android.support.test.uiautomator.Until;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;


/**
 * Container for all handled screens.
 *
 * Created by marcelolima on 1/23/16.
 */
public class ScreenContainer {
    private List<Screen> screenList = new ArrayList<>();


    /**
     * Class constructor
     *
     * @param uiDevice UiDevice instance
     */
    public ScreenContainer(final UiDevice uiDevice) {
        screenList.add(new Screen("Language Screen", By.res("com.google.android.setupwizard:id/language_picker"), By.res("com.google.android.setupwizard:id/start"), uiDevice) {
            @Override
            public boolean intermediarySteps() {
                uiDevice.findObject(By.res("com.google.android.setupwizard:id/language_picker")).click();

                // scroll until english - US appears
                try {
                    uiDevice.wait(Until.hasObject(By.res("android:id/select_dialog_listview")), 5000);
                    new UiScrollable(new UiSelector().resourceId("android:id/select_dialog_listview")).scrollTextIntoView("English (United States)");
                } catch (UiObjectNotFoundException e) {
                    uiDevice.pressBack();
                    return true;
                }

                uiDevice.findObject(By.text("English (United States)")).click();

                return uiDevice.wait(Until.hasObject(By.res("com.google.android.setupwizard:id/start")), 5000);
            }
        });
    }

    /**
     * Getter for screenList.
     *
     * @return screen list
     */
    public List<Screen> getScreenList() {
        return screenList;
    }
}
