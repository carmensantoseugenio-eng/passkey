package sn.mahir.passkey;

import android.app.ForegroundServiceStartNotAllowedException;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/** Restarts the service after boot and after an app update. */
public class BootReceiver extends BroadcastReceiver {
    @Override public void onReceive(Context c, Intent i) {
        // Android 15 also sends BOOT_COMPLETED when a stopped app (just installed,
        // or force stopped) is opened. That one may not start the service; the
        // app being opened starts it.
        try { KeyService.start(c); } catch (ForegroundServiceStartNotAllowedException e) { }
    }
}
