/*
 * Decompiled with CFR 0_115.
 */
package org.jfree.date;

import java.util.Calendar;
import java.util.Date;

public class DateUtilities {
    private static final Calendar CALENDAR = Calendar.getInstance();

    private DateUtilities() {
    }

    public static synchronized Date createDate(int n2, int n3, int n4) {
        CALENDAR.clear();
        CALENDAR.set(n2, n3 - 1, n4);
        return CALENDAR.getTime();
    }

    public static synchronized Date createDate(int n2, int n3, int n4, int n5, int n6) {
        CALENDAR.clear();
        CALENDAR.set(n2, n3 - 1, n4, n5, n6);
        return CALENDAR.getTime();
    }
}

