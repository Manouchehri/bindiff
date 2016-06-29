package com.google.security.zynamics.zylib.gui.license;

import java.net.*;
import java.util.*;
import com.google.security.zynamics.zylib.gui.*;
import com.google.security.zynamics.zylib.gui.ProgressDialogs.*;
import java.io.*;
import java.awt.*;

public class UpdateCheckHelper
{
    public static String UPDATE_CHECK_BASE_URL;
    
    public static void checkForUpdatesWithUi(final Window window, final String s, final String s2) {
        checkForUpdatesWithUi(window, s, s2, "stable");
    }
    
    public static void checkForUpdatesWithUi(final Window window, final String s, final String s2, final String s3) {
        URL url;
        try {
            url = new URL(String.format("%s/%s/%s", UpdateCheckHelper.UPDATE_CHECK_BASE_URL, s.toLowerCase(), s3.toLowerCase()));
        }
        catch (MalformedURLException ex) {
            throw new RuntimeException("Malformed URL template", ex);
        }
        final ArrayList<String> list = new ArrayList<String>();
        final UpdateCheckHelper$1 updateCheckHelper$1 = new UpdateCheckHelper$1(list, url);
        CEndlessProgressDialog.show(window, System.getProperty(CMessageBox.DEFAULT_WINDOW_TITLE_PROPERTY), "Checking for updates...", updateCheckHelper$1);
        if (updateCheckHelper$1.getException() instanceof FileNotFoundException) {
            CMessageBox.showWarning(window, "Could not check for updates. The update site is unavailable.");
            return;
        }
        if (list.isEmpty()) {
            CMessageBox.showWarning(window, "Could not check for updates. The update site returned no data.");
            return;
        }
        if (list.size() < 2 || !((String)list.get(1)).matches("\\d{4}-\\d\\d-\\d\\d")) {
            CMessageBox.showWarning(window, "Could not check for updates. Could not parse the response.");
            return;
        }
        final String s4 = list.get(0);
        final int versionCompare = versionCompare(s2, s4);
        if (versionCompare < 0) {
            CMessageBox.showInformation(window, String.format("A newer version (%s) is available.", s4));
            return;
        }
        if (versionCompare >= 0) {
            CMessageBox.showInformation(window, String.format("Your version of zynamics %s is up to date.", s));
        }
    }
    
    public static int versionCompare(final String s, final String s2) {
        final String[] split = s.trim().split("\\.|-|\\s+");
        final String[] split2 = s2.trim().split("\\.|-|\\s+");
        int compareToIgnoreCase = 0;
        for (int n = 0; compareToIgnoreCase == 0 && n < Math.min(split.length, split2.length); ++n) {
            try {
                compareToIgnoreCase = Integer.parseInt(split[n]) - Integer.parseInt(split2[n]);
            }
            catch (NumberFormatException ex) {
                compareToIgnoreCase = split[n].compareToIgnoreCase(split2[n]);
            }
        }
        return (compareToIgnoreCase < -1) ? -1 : ((compareToIgnoreCase > 1) ? 1 : compareToIgnoreCase);
    }
    
    static {
        UpdateCheckHelper.UPDATE_CHECK_BASE_URL = "http://www.zynamics.com/updates";
    }
}
