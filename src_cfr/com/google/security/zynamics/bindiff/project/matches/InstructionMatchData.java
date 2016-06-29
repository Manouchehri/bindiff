/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.bindiff.project.matches;

import com.google.security.zynamics.bindiff.enums.ESide;
import com.google.security.zynamics.bindiff.project.matches.AddressPair;
import com.google.security.zynamics.bindiff.project.matches.IAddressPair;
import com.google.security.zynamics.zylib.disassembly.CAddress;
import com.google.security.zynamics.zylib.disassembly.IAddress;

public class InstructionMatchData
implements IAddressPair {
    private final IAddressPair addrPair;

    public InstructionMatchData(long l2, long l3) {
        this.addrPair = new AddressPair(l2, l3);
    }

    @Override
    public long getAddress(ESide eSide) {
        return this.addrPair.getAddress(eSide);
    }

    @Override
    public IAddress getIAddress(ESide eSide) {
        return new CAddress(this.getAddress(eSide));
    }
}

