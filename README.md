# Samsung Routine Media Toggle

An Android app designed to be used as a custom action in **Samsung Modes and Routines**. It toggles media play/pause and provides strong haptic feedback.

## Features

- **Consolidated Execution**: The media toggle and haptic feedback are handled directly within the main entry point for simplicity.
- **Strong Haptic Feedback**: Delivers a powerful vibration burst using the `USAGE_ALARM` profile, ensuring you feel the toggle even through a case.
- **Stealth Theme**: Uses a transparent theme to minimize visual impact during execution.
- **Direct Boot Support**: Configured to work even after a reboot before the device is first unlocked.
- **Fast Execution**: Toggles and exits quickly.

## Setup Instructions

### 1. Installation
- Build and install the APK to your Samsung device.

### 2. Add to Samsung Routines
1. Open **Settings > Modes and Routines**.
2. Create or edit a routine.
3. In the **"Then" (Actions)** section, tap **App Actions**.
4. Search for **"Samsung Routine Media Toggle"**.
5. Select the available media toggle action.

## Development
- **Language**: Java
- **Min SDK**: 26 (Android 8.0)
- **Target SDK**: 34 (Android 14)

---
*Created with assistance from Android Studio Gemini.*
