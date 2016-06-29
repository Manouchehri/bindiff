package com.google.security.zynamics.zylib.general.comparators;

import java.io.*;
import java.util.*;

public class IntComparator implements Serializable, Comparator
{
    private static final long serialVersionUID = -9039204490352575348L;
    
    public int compare(final Integer n, final Integer n2) {
        return n - n2;
    }
}
