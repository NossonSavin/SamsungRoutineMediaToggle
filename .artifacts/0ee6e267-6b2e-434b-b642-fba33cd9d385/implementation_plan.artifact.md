# Maximum Intensity Haptic Feedback

The previous "triple-pulse" attempt was still perceived as weak. This plan switches to a high-priority "Alarm" style vibration with a longer duration to maximize the physical output of the device's motor.

## User Review Required

> [!WARNING]
> I am switching the vibration type to `USAGE_ALARM`. This is the strongest vibration class in Android, typically used for waking people up. It is significantly more powerful than standard "touch" feedback.

## Proposed Changes

### [Component Name] Haptic Power Boost

#### [MODIFY] [MainActivity.java](file:///C:/Users/Home/Desktop/play/app/src/main/java/com/example/mediacontroller/MainActivity.java)
- **Use `USAGE_ALARM`**: Change the vibration attributes to use the Alarm usage class. This bypasses most "subtle" haptic engines and forces the motor to run at its highest power profile.
- **Continuous Pulse**: Instead of pulses/gaps, I will use a single, long **400ms** burst at absolute maximum amplitude (255).
- **Remove View Haptics**: Remove `performHapticFeedback` as it is designed for "subtle" UI feedback and may interfere with the raw vibrator request.
- **Extend Exit Delay**: Increase the `finish()` delay to **1000ms** (1 second) to ensure the 400ms vibration and the media key event are both fully processed by the system before the app process is terminated.

## Verification Plan

### Automated Tests
- Build and run.

### Manual Verification
- Trigger the app. The vibration should now feel like a "strong buzz" rather than a "tap".
