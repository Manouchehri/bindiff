package org.jfree.date;

import java.util.*;

public class DateUtilities
{
    private static final Calendar CALENDAR;
    
    public static synchronized Date createDate(final int n, final int n2, final int n3) {
        DateUtilities.CALENDAR.clear();
        DateUtilities.CALENDAR.set(n, n2 - 1, n3);
        return DateUtilities.CALENDAR.getTime();
    }
    
    public static synchronized Date createDate(final int n, final int n2, final int n3, final int n4, final int n5) {
        DateUtilities.CALENDAR.clear();
        DateUtilities.CALENDAR.set(n, n2 - 1, n3, n4, n5);
        return DateUtilities.CALENDAR.getTime();
    }
    
    static {
        CALENDAR = Calendar.getInstance();
    }
}
