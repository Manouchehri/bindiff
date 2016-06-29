/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.bindiff.enums.comparators;

import com.google.security.zynamics.bindiff.enums.EFunctionType;
import java.util.Comparator;

public class RawFunctionTypeComparator
implements Comparator {
    public int compare(EFunctionType eFunctionType, EFunctionType eFunctionType2) {
        return EFunctionType.getOrdinal(eFunctionType) - EFunctionType.getOrdinal(eFunctionType2);
    }
}

