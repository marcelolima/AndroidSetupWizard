package com.androidlogin;

import android.support.test.uiautomator.UiDevice;
import android.support.test.uiautomator.UiWatcher;

/**
 * Register the UiWatchers using the Screens described on ScreenContainer.
 *
 * Created by marcelolima on 1/24/16.
 */
public class UiWatcherRegister {

    /**
     * Take each screen from screenContainer and register it as a UiWatcher.
     * The UiWatcher will return true only if:
     *  1. The current screen on the device matches the current screen in the for loop
     *  2. The intermediary steps method finished successfully (returns true)
     *  3. The button for going to the next screen is found and pressed successfully (returns true)
     *
     * @param uiDevice UiDevice instance
     * @param screenContainer screenContainer with the implemented screens.
     */
    public static void registerWatchers(UiDevice uiDevice, ScreenContainer screenContainer) {

        for (final Screen screen : screenContainer.getScreenList()) {
            UiWatcher uiWatcher = new UiWatcher() {
                @Override
                public boolean checkForCondition() {
                    return (screen.isThisScreen() && screen.intermediarySteps() && screen.nextScreen());
                }
            };

            uiDevice.registerWatcher(screen.getName(), uiWatcher);
        }
    }
}
