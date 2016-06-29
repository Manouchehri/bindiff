package com.google.security.zynamics.bindiff.log;

import java.util.logging.*;
import java.util.*;

public class LogFormatter extends SimpleFormatter
{
    private static boolean verboseLogging;
    
    public static void setVerboseLogging(final boolean verboseLogging) {
        LogFormatter.verboseLogging = verboseLogging;
    }
    
    @Override
    public String format(final LogRecord logRecord) {
        String format = "";
        if (LogFormatter.verboseLogging) {
            final GregorianCalendar gregorianCalendar = new GregorianCalendar();
            gregorianCalendar.setTimeInMillis(logRecord.getMillis());
            format = String.format("<%s> %s (Thread ID %d) \n", String.format("%4d.%02d.%02d %02d:%02d:%02d.%03d %s", gregorianCalendar.get(1), gregorianCalendar.get(2), gregorianCalendar.get(5), gregorianCalendar.get(10), gregorianCalendar.get(12), gregorianCalendar.get(13), gregorianCalendar.get(14), (gregorianCalendar.get(9) == 0) ? "am" : "pm"), logRecord.getLevel().toString(), logRecord.getThreadID());
        }
        return String.format("%s%s\n", format, logRecord.getMessage());
    }
    
    static {
        LogFormatter.verboseLogging = false;
    }
}
