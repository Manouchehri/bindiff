package com.google.security.zynamics.zylib.gui.license;

import com.google.security.zynamics.zylib.date.*;
import java.util.*;

public class CLicenseFileHelpers
{
    static int calculateRemainingDays(final CLicenseFile cLicenseFile) {
        return (int)Math.max(Math.ceil((DateHelpers.getDate(cLicenseFile.getValue("SupportExpiryDate"), "YYYY-MM-DD").getTime() - Calendar.getInstance().getTimeInMillis()) / 86400000L), 0.0);
    }
    
    public static boolean isExpired(final CLicenseFile cLicenseFile) {
        return DateHelpers.getCurrentDate().getTime() > DateHelpers.getDate(cLicenseFile.getValue("SupportExpiryDate"), "YYYY-MM-DD").getTime();
    }
    
    public static boolean isExpiring(final CLicenseFile cLicenseFile, final int n) {
        return !isExpired(cLicenseFile) && calculateRemainingDays(cLicenseFile) <= n;
    }
}
