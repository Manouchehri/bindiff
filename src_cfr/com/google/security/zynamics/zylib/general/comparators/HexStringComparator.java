/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.zylib.general.comparators;

import com.google.security.zynamics.zylib.disassembly.CAddress;
import java.io.Serializable;
import java.util.Comparator;

public class HexStringComparator
implements Serializable,
Comparator {
    private static final long serialVersionUID = 8204731939693038511L;

    public int compare(String string, String string2) {
        if (!string.isEmpty()) {
            if (!string2.isEmpty()) return CAddress.compare(Long.valueOf(string, 16), Long.valueOf(string2, 16));
        }
        if (string.equals(string2)) {
            return 0;
        }
        if (!string2.isEmpty()) return -1;
        return 1;
    }
}

