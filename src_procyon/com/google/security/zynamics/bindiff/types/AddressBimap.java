package com.google.security.zynamics.bindiff.types;

import com.google.common.base.*;
import com.google.security.zynamics.bindiff.enums.*;
import com.google.security.zynamics.bindiff.project.matches.*;
import java.util.*;
import com.google.security.zynamics.zylib.disassembly.*;

public class AddressBimap
{
    private long[] primarySortedValues;
    private long[] secondaryAssignedValues;
    private long[] secondarySortedValues;
    private long[] primaryAssignedValues;
    
    public AddressBimap(final List list) {
        Preconditions.checkNotNull(list);
        final int size = list.size();
        this.primarySortedValues = new long[size];
        this.secondaryAssignedValues = new long[size];
        Collections.sort((List<Object>)list, new AddressPairComparator(ESide.PRIMARY));
        int n = 0;
        for (final IAddressPair addressPair : list) {
            this.primarySortedValues[n] = addressPair.getAddress(ESide.PRIMARY);
            this.secondaryAssignedValues[n] = addressPair.getAddress(ESide.SECONDARY);
            ++n;
        }
        this.secondarySortedValues = new long[size];
        this.primaryAssignedValues = new long[size];
        Collections.sort((List<Object>)list, new AddressPairComparator(ESide.SECONDARY));
        int n2 = 0;
        for (final IAddressPair addressPair2 : list) {
            this.primaryAssignedValues[n2] = addressPair2.getAddress(ESide.PRIMARY);
            this.secondarySortedValues[n2] = addressPair2.getAddress(ESide.SECONDARY);
            ++n2;
        }
    }
    
    private Long getPrimaryAddress(final long n) {
        final int index = this.getIndex(n, ESide.SECONDARY);
        return (index >= 0) ? this.primaryAssignedValues[index] : null;
    }
    
    private Long getSecondaryAddress(final long n) {
        final int index = this.getIndex(n, ESide.PRIMARY);
        return (index >= 0) ? this.secondaryAssignedValues[index] : null;
    }
    
    public boolean contains(final IAddress address, final ESide eSide) {
        return this.getIndex(address.toLong(), eSide) >= 0;
    }
    
    public boolean contains(final IAddress address, final IAddress address2) {
        if (address == null || address2 == null) {
            return false;
        }
        final int index = this.getIndex(address, ESide.PRIMARY);
        return index >= 0 && this.primarySortedValues[index] == address.toLong() && this.secondaryAssignedValues[index] == address2.toLong();
    }
    
    public int getIndex(final IAddress address, final ESide eSide) {
        return (address != null) ? this.getIndex(address.toLong(), eSide) : -1;
    }
    
    public int getIndex(final long n, final ESide eSide) {
        return (eSide == ESide.PRIMARY) ? Arrays.binarySearch(this.primarySortedValues, n) : Arrays.binarySearch(this.secondarySortedValues, n);
    }
    
    public IAddress getPrimaryAddress(final IAddress address) {
        final Long primaryAddress = this.getPrimaryAddress(address.toLong());
        return (primaryAddress != null) ? new CAddress(primaryAddress) : null;
    }
    
    public IAddress getSecondaryAddress(final IAddress address) {
        final Long secondaryAddress = this.getSecondaryAddress(address.toLong());
        return (secondaryAddress != null) ? new CAddress(secondaryAddress) : null;
    }
    
    public boolean remove(final IAddress address, final IAddress address2) {
        final int index = this.getIndex(address, ESide.PRIMARY);
        final int index2 = this.getIndex(address2, ESide.SECONDARY);
        if (index < 0 || index2 < 0) {
            return false;
        }
        final int length = this.primarySortedValues.length;
        final long[] primarySortedValues = new long[length - 1];
        final long[] secondaryAssignedValues = new long[length - 1];
        final long[] secondarySortedValues = new long[length - 1];
        final long[] primaryAssignedValues = new long[length - 1];
        int n = 0;
        int n2 = 0;
        for (int i = 0; i < length; ++i) {
            if (i != index) {
                primarySortedValues[n] = this.primarySortedValues[i];
                secondaryAssignedValues[n] = this.secondaryAssignedValues[i];
                ++n;
            }
            if (i != index2) {
                secondarySortedValues[n2] = this.secondarySortedValues[i];
                primaryAssignedValues[n2] = this.primaryAssignedValues[i];
                ++n2;
            }
        }
        this.primarySortedValues = primarySortedValues;
        this.secondaryAssignedValues = secondaryAssignedValues;
        this.secondarySortedValues = secondarySortedValues;
        this.primaryAssignedValues = primaryAssignedValues;
        return true;
    }
}
