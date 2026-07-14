# SamsungRoutineMediaToggle

An "invisible" Android app designed to be used as a custom action in **Samsung Modes and Routines**. It toggles media play/pause and provides strong haptic feedback without waking the screen or showing any UI.

## Features

- **Silent Execution**: Uses a 100% transparent "Stealth Theme" and background receivers to ensure the screen stays off when triggered.
- **Strong Haptic Feedback**: Delivers a powerful 400ms vibration burst using the `USAGE_ALARM` profile, ensuring you feel the toggle even through a case.
- **Samsung Routines Integration**: Surfaced as a native "App Action" (Shortcut) for easy integration into your automation.
- **Direct Boot Support**: Works even after a reboot before the device is first unlocked.
- **Lightweight & Fast**: Launches, toggles, and exits in less than a second.

## Setup Instructions

### 1. Installation
- Build and install the APK to your Samsung device.

### 2. Add to Samsung Routines
1. Open **Settings > Modes and Routines**.
2. Create or edit a routine.
3. In the **"Then" (Actions)** section, tap **App Actions**.
4. Search for **"Samsung Routine Media Toggle"** (the app's name).
5. Select the **"Toggle Media"** action.

### 3. Recommended Settings for 100% Silent Execution
To prevent Samsung's "Routine started" notification from waking your screen:
1. Go to **Settings > Modes and Routines**.
2. Tap the **three-dot menu** (top right) > **Settings**.
3. Tap **Notifications > Notification categories**.
4. Find **Running routines**, set it to **Silent**, and turn off **Show as pop-up**.

## Development
- **Language**: Java
- **Min SDK**: 26 (Android 8.0)
- **Target SDK**: 34 (Android 14)

---
*Created with assistance from Android Studio Gemini.*
