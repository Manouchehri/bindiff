/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.bindiff.project.matches;

import com.google.security.zynamics.bindiff.enums.ESide;
import com.google.security.zynamics.bindiff.project.matches.IAddressPair;
import com.google.security.zynamics.zylib.disassembly.CAddress;
import java.util.Comparator;

public class AddressPairComparator
implements Comparator {
    final ESide sortBySide;

    public AddressPairComparator(ESide eSide) {
        this.sortBySide = eSide;
    }

    public int compare(IAddressPair iAddressPair, IAddressPair iAddressPair2) {
        return CAddress.compare(iAddressPair.getAddress(this.sortBySide), iAddressPair2.getAddress(this.sortBySide));
    }
}

