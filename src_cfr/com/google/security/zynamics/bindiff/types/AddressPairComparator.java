/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.bindiff.types;

import com.google.security.zynamics.bindiff.enums.ESide;
import com.google.security.zynamics.zylib.disassembly.IAddress;
import com.google.security.zynamics.zylib.general.Pair;
import java.util.Comparator;

public class AddressPairComparator
implements Comparator {
    final ESide sortBySide;

    public AddressPairComparator(ESide eSide) {
        this.sortBySide = eSide;
    }

    public int compare(Pair pair, Pair pair2) {
        IAddress iAddress = this.sortBySide == ESide.PRIMARY ? (IAddress)pair.first() : (IAddress)pair.second();
        IAddress iAddress2 = this.sortBySide == ESide.PRIMARY ? (IAddress)pair2.first() : (IAddress)pair2.second();
        return iAddress.compareTo(iAddress2);
    }
}

