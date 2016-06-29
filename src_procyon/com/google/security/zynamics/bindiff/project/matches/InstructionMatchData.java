package com.google.security.zynamics.bindiff.project.matches;

import com.google.security.zynamics.bindiff.enums.*;
import com.google.security.zynamics.zylib.disassembly.*;

public class InstructionMatchData implements IAddressPair
{
    private final IAddressPair addrPair;
    
    public InstructionMatchData(final long n, final long n2) {
        this.addrPair = new AddressPair(n, n2);
    }
    
    @Override
    public long getAddress(final ESide eSide) {
        return this.addrPair.getAddress(eSide);
    }
    
    @Override
    public IAddress getIAddress(final ESide eSide) {
        return new CAddress(this.getAddress(eSide));
    }
}
