package com.google.security.zynamics.zylib.general.comparators;

import java.io.*;
import java.util.*;

public class LexicalComparator implements Serializable, Comparator
{
    public int compare(final String s, final String s2) {
        return s.compareToIgnoreCase(s2);
    }
}
