package com.google.security.zynamics.zylib.date;

import com.google.common.base.*;
import java.text.*;
import java.util.*;

public class DateHelpers
{
    public static String formatDate(final Date date) {
        Preconditions.checkNotNull(date, (Object)"Error: Date argument can't be null.");
        return DateFormat.getDateInstance().format(date);
    }
    
    public static String formatDate(final Date date, final int n, final Locale locale) {
        Preconditions.checkNotNull(date, (Object)"Error: Date argument can't be null.");
        Preconditions.checkNotNull(locale, (Object)"Error: Locale argument can't be null.");
        return String.format("%s %s", DateFormat.getDateInstance(n, locale).format(date), DateFormat.getTimeInstance(n, locale).format(date));
    }
    
    public static String formatDateTime(final Date date) {
        Preconditions.checkNotNull(date, (Object)"Error: Date argument can't be null.");
        return DateFormat.getDateTimeInstance().format(date);
    }
    
    public static String formatTime(final Date date) {
        Preconditions.checkNotNull(date, (Object)"Error: Date argument can't be null.");
        return DateFormat.getTimeInstance().format(date);
    }
    
    public static Date getCurrentDate() {
        return Calendar.getInstance().getTime();
    }
    
    public static String getCurrentDateString() {
        return formatDateTime(Calendar.getInstance().getTime());
    }
    
    public static Date getDate(final String s, final String s2) {
        Preconditions.checkArgument(s.length() == s2.length(), (Object)"Date string format exception. Format string must have the same length as the date string.");
        String string = "";
        String string2 = "";
        String string3 = "";
        for (int i = 0; i < s2.length(); ++i) {
            final char char1 = s2.charAt(i);
            if (char1 == 'D') {
                final String value = String.valueOf(string);
                string = new StringBuilder(1 + String.valueOf(value).length()).append(value).append(s.charAt(i)).toString();
            }
            else if (char1 == 'M') {
                final String value2 = String.valueOf(string2);
                string2 = new StringBuilder(1 + String.valueOf(value2).length()).append(value2).append(s.charAt(i)).toString();
            }
            else if (char1 == 'Y') {
                final String value3 = String.valueOf(string3);
                string3 = new StringBuilder(1 + String.valueOf(value3).length()).append(value3).append(s.charAt(i)).toString();
            }
        }
        Preconditions.checkArgument(string.length() == 2, (Object)"Date string format exception. Date string's day field must have two chars.");
        Preconditions.checkArgument(string2.length() == 2, (Object)"Date string format exception. Date string's month field must have two chars.");
        Preconditions.checkArgument(string3.length() == 4, (Object)"Date string format exception. Date string's years field must have four chars.");
        return new GregorianCalendar(Integer.parseInt(string3), Integer.parseInt(string2) - 1, Integer.parseInt(string)).getTime();
    }
}
