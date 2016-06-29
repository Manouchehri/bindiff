package com.google.security.zynamics.zylib.general.comparators;

import java.io.*;
import java.util.*;

public class DoubleComparator implements Serializable, Comparator
{
    public int compare(final Double n, final Double n2) {
        return Double.compare(n, n2);
    }
}
