package com.google.security.zynamics.zylib.general.comparators;

import java.io.*;
import java.util.*;

public class LongComparator implements Serializable, Comparator
{
    private static final long serialVersionUID = 2814764330420080628L;
    
    public int compare(final Long n, final Long n2) {
        final long n3 = n - n2;
        if (n3 > 0L) {
            return 1;
        }
        if (n3 < 0L) {
            return -1;
        }
        return 0;
    }
}
