/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.bindiff.types;

import com.google.common.base.Preconditions;
import com.google.security.zynamics.bindiff.enums.ESide;
import com.google.security.zynamics.bindiff.project.matches.AddressPairComparator;
import com.google.security.zynamics.bindiff.project.matches.IAddressPair;
import com.google.security.zynamics.zylib.disassembly.CAddress;
import com.google.security.zynamics.zylib.disassembly.IAddress;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class AddressBimap {
    private long[] primarySortedValues;
    private long[] secondaryAssignedValues;
    private long[] secondarySortedValues;
    private long[] primaryAssignedValues;

    public AddressBimap(List list) {
        Preconditions.checkNotNull(list);
        int n2 = list.size();
        this.primarySortedValues = new long[n2];
        this.secondaryAssignedValues = new long[n2];
        Collections.sort(list, new AddressPairComparator(ESide.PRIMARY));
        int n3 = 0;
        for (IAddressPair iAddressPair2 : list) {
            this.primarySortedValues[n3] = iAddressPair2.getAddress(ESide.PRIMARY);
            this.secondaryAssignedValues[n3] = iAddressPair2.getAddress(ESide.SECONDARY);
            ++n3;
        }
        this.secondarySortedValues = new long[n2];
        this.primaryAssignedValues = new long[n2];
        Collections.sort(list, new AddressPairComparator(ESide.SECONDARY));
        n3 = 0;
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            IAddressPair iAddressPair2;
            iAddressPair2 = (IAddressPair)iterator.next();
            this.primaryAssignedValues[n3] = iAddressPair2.getAddress(ESide.PRIMARY);
            this.secondarySortedValues[n3] = iAddressPair2.getAddress(ESide.SECONDARY);
            ++n3;
        }
    }

    private Long getPrimaryAddress(long l2) {
        int n2 = this.getIndex(l2, ESide.SECONDARY);
        if (n2 < 0) return null;
        Long l3 = this.primaryAssignedValues[n2];
        return l3;
    }

    private Long getSecondaryAddress(long l2) {
        int n2 = this.getIndex(l2, ESide.PRIMARY);
        if (n2 < 0) return null;
        Long l3 = this.secondaryAssignedValues[n2];
        return l3;
    }

    public boolean contains(IAddress iAddress, ESide eSide) {
        if (this.getIndex(iAddress.toLong(), eSide) < 0) return false;
        return true;
    }

    public boolean contains(IAddress iAddress, IAddress iAddress2) {
        if (iAddress == null) return false;
        if (iAddress2 == null) {
            return false;
        }
        int n2 = this.getIndex(iAddress, ESide.PRIMARY);
        if (n2 < 0) return false;
        if (this.primarySortedValues[n2] != iAddress.toLong()) return false;
        if (this.secondaryAssignedValues[n2] != iAddress2.toLong()) return false;
        return true;
    }

    public int getIndex(IAddress iAddress, ESide eSide) {
        if (iAddress == null) return -1;
        int n2 = this.getIndex(iAddress.toLong(), eSide);
        return n2;
    }

    public int getIndex(long l2, ESide eSide) {
        int n2;
        if (eSide == ESide.PRIMARY) {
            n2 = Arrays.binarySearch(this.primarySortedValues, l2);
            return n2;
        }
        n2 = Arrays.binarySearch(this.secondarySortedValues, l2);
        return n2;
    }

    public IAddress getPrimaryAddress(IAddress iAddress) {
        Long l2 = this.getPrimaryAddress(iAddress.toLong());
        if (l2 == null) return null;
        CAddress cAddress = new CAddress(l2);
        return cAddress;
    }

    public IAddress getSecondaryAddress(IAddress iAddress) {
        Long l2 = this.getSecondaryAddress(iAddress.toLong());
        if (l2 == null) return null;
        CAddress cAddress = new CAddress(l2);
        return cAddress;
    }

    public boolean remove(IAddress iAddress, IAddress iAddress2) {
        int n2 = this.getIndex(iAddress, ESide.PRIMARY);
        int n3 = this.getIndex(iAddress2, ESide.SECONDARY);
        if (n2 < 0) return false;
        if (n3 < 0) {
            return false;
        }
        int n4 = this.primarySortedValues.length;
        long[] arrl = new long[n4 - 1];
        long[] arrl2 = new long[n4 - 1];
        long[] arrl3 = new long[n4 - 1];
        long[] arrl4 = new long[n4 - 1];
        int n5 = 0;
        int n6 = 0;
        int n7 = 0;
        do {
            if (n7 >= n4) {
                this.primarySortedValues = arrl;
                this.secondaryAssignedValues = arrl2;
                this.secondarySortedValues = arrl3;
                this.primaryAssignedValues = arrl4;
                return true;
            }
            if (n7 != n2) {
                arrl[n5] = this.primarySortedValues[n7];
                arrl2[n5] = this.secondaryAssignedValues[n7];
                ++n5;
            }
            if (n7 != n3) {
                arrl3[n6] = this.secondarySortedValues[n7];
                arrl4[n6] = this.primaryAssignedValues[n7];
                ++n6;
            }
            ++n7;
        } while (true);
    }
}

