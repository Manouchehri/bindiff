package com.google.security.zynamics.zylib.general.comparators;

import java.io.*;
import java.util.*;
import com.google.security.zynamics.zylib.disassembly.*;

public class HexStringComparator implements Serializable, Comparator
{
    private static final long serialVersionUID = 8204731939693038511L;
    
    public int compare(final String s, final String s2) {
        if (s.isEmpty() || s2.isEmpty()) {
            return s.equals(s2) ? 0 : (s2.isEmpty() ? 1 : -1);
        }
        return CAddress.compare(Long.valueOf(s, 16), Long.valueOf(s2, 16));
    }
}
