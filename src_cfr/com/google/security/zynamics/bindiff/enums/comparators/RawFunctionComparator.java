/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.bindiff.enums.comparators;

import com.google.security.zynamics.bindiff.project.rawcallgraph.RawFunction;
import com.google.security.zynamics.zylib.disassembly.IAddress;
import java.util.Comparator;

public class RawFunctionComparator
implements Comparator {
    public int compare(RawFunction rawFunction, RawFunction rawFunction2) {
        return rawFunction.getAddress().compareTo(rawFunction2.getAddress());
    }
}

