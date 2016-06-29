package com.google.security.zynamics.zylib.general.comparators;

import java.io.*;
import java.util.*;

public class DateComparator implements Serializable, Comparator
{
    private static final long serialVersionUID = -846090338272302586L;
    
    public int compare(final Date date, final Date date2) {
        if (date.before(date2)) {
            return -1;
        }
        if (date.equals(date2)) {
            return 0;
        }
        return 1;
    }
}
