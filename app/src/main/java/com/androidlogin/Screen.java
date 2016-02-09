package com.androidlogin;

import android.support.test.uiautomator.BySelector;
import android.support.test.uiautomator.UiDevice;
import android.support.test.uiautomator.UiObject2;
import android.support.test.uiautomator.Until;

/**
 * Describes one possible screen on Android Presetup screens. It will be used later to
 * generate the UiWatchers that will skip the correspondent screen when it appears.
 *
 * Created by marcelolima on 1/23/16.
 */
public class Screen {
    private BySelector screenIdentifierSelector;
    private BySelector nextButtonSelector;
    private String name;
    private UiDevice uiDevice;


    /**
     * Class Constructor
     *
     * @param screenIdentifierSelector BySelector for some widget present only in this screen
     * @param nextButtonSelector BySelector the next page button (Skip, Next, Continue, etc)
     */
    public Screen(String name, BySelector screenIdentifierSelector, BySelector nextButtonSelector, UiDevice uiDevice) {
        this.name = name;
        this.screenIdentifierSelector = screenIdentifierSelector;
        this.nextButtonSelector = nextButtonSelector;
        this.uiDevice = uiDevice;
    }


    /**
     * Check if the current screen matches with the screenIdentifierSelector
     *
     * @return true if the screen contains the identifier, false otherwise
     */
    public boolean isThisScreen() {
        return uiDevice.hasObject(screenIdentifierSelector);
    }


    /**
     * Press the next button identified by nextButtonSelector
     *
     * @return true if button was pressed, false if not.
     */
    public boolean nextScreen() {
        UiObject2 nextButton = uiDevice.findObject(nextButtonSelector);

        if (nextButton == null)
            return false;

        nextButton.clickAndWait(Until.newWindow(), 5000);

        return true;
    }


    /**
     * If exists, overwrite here the intermediary steps between the screen identification and the next button press.
     * Eg: unchecking a checkbox, scrolling a text, etc
     *
     * @return true if success, false otherwise.
     */
    public boolean intermediarySteps() {
        return true;
    }


    /**
     * Getter for screen name identifier.
     *
     * @return name
     */
    public String getName() {
        return name;
    }
}
