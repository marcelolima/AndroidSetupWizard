# AndroidLogin
App for doing the Android Presetup steps after the device is flashed or reset.

About
=====
This project provides a structure for an app that passses through all setup wizard screens, from the Change Language Activity until the Homescreen Activity.

In a nutshell
=============
It's an Instrumented Test Case that execute a UiAutomator.UiDevice.wait method until the homescreen activity appears, with a long timeout. While the homescreen doesn't appear, each UiWatcher registered will handle one possible screen in the process.

Source Code
===========
Each possible screen in the Android Setup Wizard is described by one Screen object instance in the ScreenContainer class.
For each screen, it's necessary to provide an unique identifier among the possible screens (for example, the title of the screen) and the identifier of the 'Next' button. Also, it's possible to provide intermediary steps in the screen before pressing the Next button (for example, checking/unchecking a specific checkbox), by overwriting the method 'intermediarySteps' in the Screen object.





