/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.zylib.gui.license;

import com.google.security.zynamics.zylib.gui.CMessageBox;
import com.google.security.zynamics.zylib.gui.ProgressDialogs.CEndlessProgressDialog;
import com.google.security.zynamics.zylib.gui.license.UpdateCheckHelper$1;
import java.awt.Window;
import java.io.FileNotFoundException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class UpdateCheckHelper {
    public static String UPDATE_CHECK_BASE_URL = "http://www.zynamics.com/updates";

    private UpdateCheckHelper() {
    }

    public static void checkForUpdatesWithUi(Window window, String string, String string2) {
        UpdateCheckHelper.checkForUpdatesWithUi(window, string, string2, "stable");
    }

    public static void checkForUpdatesWithUi(Window window, String string, String string2, String string3) {
        URL uRL;
        try {
            uRL = new URL(String.format("%s/%s/%s", UPDATE_CHECK_BASE_URL, string.toLowerCase(), string3.toLowerCase()));
        }
        catch (MalformedURLException var5_5) {
            throw new RuntimeException("Malformed URL template", var5_5);
        }
        ArrayList arrayList = new ArrayList();
        UpdateCheckHelper$1 updateCheckHelper$1 = new UpdateCheckHelper$1(arrayList, uRL);
        CEndlessProgressDialog.show(window, System.getProperty(CMessageBox.DEFAULT_WINDOW_TITLE_PROPERTY), "Checking for updates...", updateCheckHelper$1);
        Exception exception = updateCheckHelper$1.getException();
        if (exception instanceof FileNotFoundException) {
            CMessageBox.showWarning(window, "Could not check for updates. The update site is unavailable.");
            return;
        }
        if (arrayList.isEmpty()) {
            CMessageBox.showWarning(window, "Could not check for updates. The update site returned no data.");
            return;
        }
        if (arrayList.size() < 2 || !((String)arrayList.get(1)).matches("\\d{4}-\\d\\d-\\d\\d")) {
            CMessageBox.showWarning(window, "Could not check for updates. Could not parse the response.");
            return;
        }
        String string4 = (String)arrayList.get(0);
        int n2 = UpdateCheckHelper.versionCompare(string2, string4);
        if (n2 < 0) {
            CMessageBox.showInformation(window, String.format("A newer version (%s) is available.", string4));
            return;
        }
        if (n2 < 0) return;
        CMessageBox.showInformation(window, String.format("Your version of zynamics %s is up to date.", string));
    }

    public static int versionCompare(String string, String string2) {
        String[] arrstring = string.trim().split("\\.|-|\\s+");
        String[] arrstring2 = string2.trim().split("\\.|-|\\s+");
        int n2 = 0;
        for (int i2 = 0; n2 == 0 && i2 < Math.min(arrstring.length, arrstring2.length); ++i2) {
            try {
                n2 = Integer.parseInt(arrstring[i2]) - Integer.parseInt(arrstring2[i2]);
                continue;
            }
            catch (NumberFormatException var6_6) {
                n2 = arrstring[i2].compareToIgnoreCase(arrstring2[i2]);
            }
        }
        if (n2 < -1) {
            return -1;
        }
        if (n2 > 1) {
            return 1;
        }
        int n3 = n2;
        return n3;
    }
}

