package com.bwzz.applockdemo;

import android.app.Activity;
import android.content.Intent;

public class Lock {
    private static boolean enable = true;
    private static boolean locked = true;
    private static long sleepTime = 0;
    private static long duration = 2000;
    private static final int REQ_APPLOCK = 2;
    public static final int RESULT_EXIT = 1;

    /*
     * Enable or disable the lock
     */
    public static void setEnable(boolean aenable) {
        enable = aenable;
    }

    /*
     * Unlock if the correct password was entered
     */
    public static void unlock() {
        locked = false;
        sleepTime = System.currentTimeMillis();
    }

    /*
     * Set status locked when showing the Guard
     */
    public static void lock() {
        if (enable) {
            locked = true;
        }
    }

    /*
     * Call this in onResume of any Activity that should be locked
     */
    public static void onResume(Activity act) {
        if (enable) {
            if (locked || System.currentTimeMillis() - sleepTime > duration) {
                Intent i = new Intent(act, Guard.class);
                act.startActivityForResult(i, REQ_APPLOCK);
            }
        }
    }

    /*
     * Call this in onPause of any Activity that should be locked
     */
    public static void onPause(Activity act) {
        sleepTime = System.currentTimeMillis();
    }

    /*
     * Call this in onActivityResult of any Activity that should be locked
     */
    public static boolean testResult(Activity act, int requestCode,
            int resultCode, Intent data) {
        if (!enable) {
            return false;
        } else if (resultCode == RESULT_EXIT) {
            exit(act, data);
            return true;
        }
        return false;
    }

    public static void startActivity(Activity act, Intent intent) {
        act.startActivityForResult(intent, REQ_APPLOCK);
    }

    public static void exit(Activity act, Intent data) {
        if (enable) {
            act.setResult(RESULT_EXIT);
            act.finish();
        }
    }
}
