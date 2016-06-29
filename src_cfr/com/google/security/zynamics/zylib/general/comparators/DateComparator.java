/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.zylib.general.comparators;

import java.io.Serializable;
import java.util.Comparator;
import java.util.Date;

public class DateComparator
implements Serializable,
Comparator {
    private static final long serialVersionUID = -846090338272302586L;

    public int compare(Date date, Date date2) {
        if (date.before(date2)) {
            return -1;
        }
        if (!date.equals(date2)) return 1;
        return 0;
    }
}

