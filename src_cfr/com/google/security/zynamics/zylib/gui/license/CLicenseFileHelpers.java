/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.zylib.gui.license;

import com.google.security.zynamics.zylib.date.DateHelpers;
import com.google.security.zynamics.zylib.gui.license.CLicenseFile;
import java.util.Calendar;
import java.util.Date;

public class CLicenseFileHelpers {
    private CLicenseFileHelpers() {
    }

    static int calculateRemainingDays(CLicenseFile cLicenseFile) {
        String string = cLicenseFile.getValue("SupportExpiryDate");
        long l2 = Calendar.getInstance().getTimeInMillis();
        long l3 = DateHelpers.getDate(string, "YYYY-MM-DD").getTime();
        return (int)Math.max(Math.ceil((l3 - l2) / 86400000), 0.0);
    }

    public static boolean isExpired(CLicenseFile cLicenseFile) {
        String string = cLicenseFile.getValue("SupportExpiryDate");
        Date date = DateHelpers.getCurrentDate();
        Date date2 = DateHelpers.getDate(string, "YYYY-MM-DD");
        if (date.getTime() <= date2.getTime()) return false;
        return true;
    }

    public static boolean isExpiring(CLicenseFile cLicenseFile, int n2) {
        if (CLicenseFileHelpers.isExpired(cLicenseFile)) return false;
        if (CLicenseFileHelpers.calculateRemainingDays(cLicenseFile) > n2) return false;
        return true;
    }
}

