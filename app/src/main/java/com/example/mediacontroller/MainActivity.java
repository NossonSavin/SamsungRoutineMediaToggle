package com.example.mediacontroller;

import android.app.Activity;
import android.content.Context;
import android.media.AudioManager;
import android.os.Build;
import android.os.Bundle;
import android.os.VibrationAttributes;
import android.os.VibrationEffect;
import android.os.Vibrator;
import android.os.VibratorManager;
import android.util.Log;
import android.view.KeyEvent;

public class MainActivity extends Activity {
    private static final String TAG = "MediaController";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // 1. Trigger the Play/Pause toggle
        AudioManager audioManager = (AudioManager) getSystemService(Context.AUDIO_SERVICE);
        if (audioManager != null) {
            KeyEvent keyDown = new KeyEvent(KeyEvent.ACTION_DOWN, KeyEvent.KEYCODE_MEDIA_PLAY_PAUSE);
            audioManager.dispatchMediaKeyEvent(keyDown);
            KeyEvent keyUp = new KeyEvent(KeyEvent.ACTION_UP, KeyEvent.KEYCODE_MEDIA_PLAY_PAUSE);
            audioManager.dispatchMediaKeyEvent(keyUp);
        }

        // 2. Trigger Maximum Haptic Feedback
        triggerMaxHapticFeedback(getApplicationContext());

        // 3. Wait 1000ms (1 second) to ensure the motor reaches full speed and finishes
        new android.os.Handler(android.os.Looper.getMainLooper()).postDelayed(new Runnable() {
            @Override
            public void run() {
                finish();
            }
        }, 100);
    }


    private static void triggerMaxHapticFeedback(Context context) {
        Vibrator vibrator;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
            VibratorManager vibratorManager = (VibratorManager) context.getSystemService(Context.VIBRATOR_MANAGER_SERVICE);
            vibrator = vibratorManager != null ? vibratorManager.getDefaultVibrator() : null;
        } else {
            vibrator = (Vibrator) context.getSystemService(Context.VIBRATOR_SERVICE);
        }

        if (vibrator != null && vibrator.hasVibrator()) {
            Log.d(TAG, "Triggering max intensity haptic");
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                // A single, long 400ms burst at maximum amplitude (255)
                VibrationEffect effect = VibrationEffect.createOneShot(200, 255);
                
                // Using USAGE_ALARM forces the device's strongest vibration profile
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
                    vibrator.vibrate(effect, VibrationAttributes.createForUsage(VibrationAttributes.USAGE_ALARM));
                } else {
                    // Fallback for older versions - usage alarm is still supported via older APIs if needed, 
                    // but simple vibrate(effect) is usually high power on these devices.
                    vibrator.vibrate(effect);
                }
            } else {
                vibrator.vibrate(200);
            }
        }
    }
}

