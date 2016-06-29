package com.google.security.zynamics.bindiff.project.matches;

import com.google.security.zynamics.bindiff.enums.*;
import com.google.security.zynamics.zylib.disassembly.*;

public class AddressPair implements IAddressPair
{
    private final long priAddr;
    private final long secAddr;
    
    public AddressPair(final long priAddr, final long secAddr) {
        this.priAddr = priAddr;
        this.secAddr = secAddr;
    }
    
    @Override
    public boolean equals(final Object o) {
        return this.priAddr == ((AddressPair)o).getAddress(ESide.PRIMARY) && this.secAddr == ((AddressPair)o).getAddress(ESide.SECONDARY);
    }
    
    @Override
    public long getAddress(final ESide eSide) {
        return (eSide == ESide.PRIMARY) ? this.priAddr : this.secAddr;
    }
    
    @Override
    public IAddress getIAddress(final ESide eSide) {
        return new CAddress(this.getAddress(eSide));
    }
    
    @Override
    public int hashCode() {
        return (int)((this.priAddr ^ this.priAddr >>> 32) * (this.secAddr ^ this.secAddr >>> 32));
    }
}
