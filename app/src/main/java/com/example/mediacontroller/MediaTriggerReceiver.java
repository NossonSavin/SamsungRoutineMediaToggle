package com.example.mediacontroller;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.media.AudioManager;
import android.os.Build;
import android.os.VibrationAttributes;
import android.os.VibrationEffect;
import android.os.Vibrator;
import android.os.VibratorManager;
import android.util.Log;
import android.view.KeyEvent;

public class MediaTriggerReceiver extends BroadcastReceiver {
    private static final String TAG = "MediaController";

    @Override
    public void onReceive(Context context, Intent intent) {
        Log.d(TAG, "Receiver: Triggering media toggle and haptics");

        // 1. Trigger the Play/Pause toggle
        AudioManager audioManager = (AudioManager) context.getSystemService(Context.AUDIO_SERVICE);
        if (audioManager != null) {
            KeyEvent keyDown = new KeyEvent(KeyEvent.ACTION_DOWN, KeyEvent.KEYCODE_MEDIA_PLAY_PAUSE);
            audioManager.dispatchMediaKeyEvent(keyDown);
            KeyEvent keyUp = new KeyEvent(KeyEvent.ACTION_UP, KeyEvent.KEYCODE_MEDIA_PLAY_PAUSE);
            audioManager.dispatchMediaKeyEvent(keyUp);
        }

        // 2. Trigger Maximum Haptic Feedback
        triggerMaxHapticFeedback(context.getApplicationContext());
    }

    private void triggerMaxHapticFeedback(Context context) {
        Vibrator vibrator;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
            VibratorManager vibratorManager = (VibratorManager) context.getSystemService(Context.VIBRATOR_MANAGER_SERVICE);
            vibrator = vibratorManager != null ? vibratorManager.getDefaultVibrator() : null;
        } else {
            vibrator = (Vibrator) context.getSystemService(Context.VIBRATOR_SERVICE);
        }

        if (vibrator != null && vibrator.hasVibrator()) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                // Maximum Intensity: 400ms burst at 255 amplitude
                VibrationEffect effect = VibrationEffect.createOneShot(400, 255);
                
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
                    vibrator.vibrate(effect, VibrationAttributes.createForUsage(VibrationAttributes.USAGE_ALARM));
                } else {
                    vibrator.vibrate(effect);
                }
            } else {
                vibrator.vibrate(400);
            }
        }
    }
}
