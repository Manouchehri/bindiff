/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.bindiff.log;

import java.util.GregorianCalendar;
import java.util.logging.Level;
import java.util.logging.LogRecord;
import java.util.logging.SimpleFormatter;

public class LogFormatter
extends SimpleFormatter {
    private static boolean verboseLogging = false;

    public static void setVerboseLogging(boolean bl2) {
        verboseLogging = bl2;
    }

    @Override
    public String format(LogRecord logRecord) {
        String string = "";
        if (!verboseLogging) return String.format("%s%s\n", string, logRecord.getMessage());
        GregorianCalendar gregorianCalendar = new GregorianCalendar();
        gregorianCalendar.setTimeInMillis(logRecord.getMillis());
        Object[] arrobject = new Object[8];
        arrobject[0] = gregorianCalendar.get(1);
        arrobject[1] = gregorianCalendar.get(2);
        arrobject[2] = gregorianCalendar.get(5);
        arrobject[3] = gregorianCalendar.get(10);
        arrobject[4] = gregorianCalendar.get(12);
        arrobject[5] = gregorianCalendar.get(13);
        arrobject[6] = gregorianCalendar.get(14);
        arrobject[7] = gregorianCalendar.get(9) == 0 ? "am" : "pm";
        String string2 = String.format("%4d.%02d.%02d %02d:%02d:%02d.%03d %s", arrobject);
        string = String.format("<%s> %s (Thread ID %d) \n", string2, logRecord.getLevel().toString(), logRecord.getThreadID());
        return String.format("%s%s\n", string, logRecord.getMessage());
    }
}

