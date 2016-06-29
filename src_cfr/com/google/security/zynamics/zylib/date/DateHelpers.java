/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.zylib.date;

import com.google.common.base.Preconditions;
import java.text.DateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;

public class DateHelpers {
    public static String formatDate(Date date) {
        Preconditions.checkNotNull(date, "Error: Date argument can't be null.");
        return DateFormat.getDateInstance().format(date);
    }

    public static String formatDate(Date date, int n2, Locale locale) {
        Preconditions.checkNotNull(date, "Error: Date argument can't be null.");
        Preconditions.checkNotNull(locale, "Error: Locale argument can't be null.");
        return String.format("%s %s", DateFormat.getDateInstance(n2, locale).format(date), DateFormat.getTimeInstance(n2, locale).format(date));
    }

    public static String formatDateTime(Date date) {
        Preconditions.checkNotNull(date, "Error: Date argument can't be null.");
        return DateFormat.getDateTimeInstance().format(date);
    }

    public static String formatTime(Date date) {
        Preconditions.checkNotNull(date, "Error: Date argument can't be null.");
        return DateFormat.getTimeInstance().format(date);
    }

    public static Date getCurrentDate() {
        return Calendar.getInstance().getTime();
    }

    public static String getCurrentDateString() {
        return DateHelpers.formatDateTime(Calendar.getInstance().getTime());
    }

    public static Date getDate(String string, String string2) {
        int n2;
        int n3;
        Preconditions.checkArgument(string.length() == string2.length(), "Date string format exception. Format string must have the same length as the date string.");
        String string3 = "";
        String string4 = "";
        String string5 = "";
        for (n3 = 0; n3 < string2.length(); ++n3) {
            char c2;
            String string6;
            n2 = string2.charAt(n3);
            if (n2 == 68) {
                string6 = String.valueOf(string3);
                c2 = string.charAt(n3);
                string3 = new StringBuilder(1 + String.valueOf(string6).length()).append(string6).append(c2).toString();
                continue;
            }
            if (n2 == 77) {
                string6 = String.valueOf(string4);
                c2 = string.charAt(n3);
                string4 = new StringBuilder(1 + String.valueOf(string6).length()).append(string6).append(c2).toString();
                continue;
            }
            if (n2 != 89) continue;
            string6 = String.valueOf(string5);
            c2 = string.charAt(n3);
            string5 = new StringBuilder(1 + String.valueOf(string6).length()).append(string6).append(c2).toString();
        }
        Preconditions.checkArgument(string3.length() == 2, "Date string format exception. Date string's day field must have two chars.");
        Preconditions.checkArgument(string4.length() == 2, "Date string format exception. Date string's month field must have two chars.");
        Preconditions.checkArgument(string5.length() == 4, "Date string format exception. Date string's years field must have four chars.");
        n3 = Integer.parseInt(string3);
        n2 = Integer.parseInt(string4) - 1;
        int n4 = Integer.parseInt(string5);
        GregorianCalendar gregorianCalendar = new GregorianCalendar(n4, n2, n3);
        return gregorianCalendar.getTime();
    }
}

