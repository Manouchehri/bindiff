/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.bindiff.project.matches;

import com.google.security.zynamics.bindiff.enums.ESide;
import com.google.security.zynamics.bindiff.project.matches.IAddressPair;
import com.google.security.zynamics.zylib.disassembly.CAddress;
import com.google.security.zynamics.zylib.disassembly.IAddress;

public class AddressPair
implements IAddressPair {
    private final long priAddr;
    private final long secAddr;

    public AddressPair(long l2, long l3) {
        this.priAddr = l2;
        this.secAddr = l3;
    }

    public boolean equals(Object object) {
        if (this.priAddr != ((AddressPair)object).getAddress(ESide.PRIMARY)) return false;
        if (this.secAddr != ((AddressPair)object).getAddress(ESide.SECONDARY)) return false;
        return true;
    }

    @Override
    public long getAddress(ESide eSide) {
        long l2;
        if (eSide == ESide.PRIMARY) {
            l2 = this.priAddr;
            return l2;
        }
        l2 = this.secAddr;
        return l2;
    }

    @Override
    public IAddress getIAddress(ESide eSide) {
        return new CAddress(this.getAddress(eSide));
    }

    public int hashCode() {
        return (int)((this.priAddr ^ this.priAddr >>> 32) * (this.secAddr ^ this.secAddr >>> 32));
    }
}

