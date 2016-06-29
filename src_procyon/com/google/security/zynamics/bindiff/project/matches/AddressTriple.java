package com.google.security.zynamics.bindiff.project.matches;

import com.google.security.zynamics.zylib.disassembly.*;

public class AddressTriple
{
    private final long firstAddr;
    private final long secondAddr;
    private final long thirdAddr;
    
    public AddressTriple(final long firstAddr, final long secondAddr, final long thirdAddr) {
        this.firstAddr = firstAddr;
        this.secondAddr = secondAddr;
        this.thirdAddr = thirdAddr;
    }
    
    @Override
    public boolean equals(final Object o) {
        return this.firstAddr == ((AddressTriple)o).getAddress(AddressTriple$EIndex.FIRST) && this.secondAddr == ((AddressTriple)o).getAddress(AddressTriple$EIndex.SECOND) && this.thirdAddr == ((AddressTriple)o).getAddress(AddressTriple$EIndex.THIRD);
    }
    
    public long getAddress(final AddressTriple$EIndex addressTriple$EIndex) {
        switch (AddressTriple$1.$SwitchMap$com$google$security$zynamics$bindiff$project$matches$AddressTriple$EIndex[addressTriple$EIndex.ordinal()]) {
            case 1: {
                return this.firstAddr;
            }
            case 2: {
                return this.secondAddr;
            }
            case 3: {
                return this.thirdAddr;
            }
            default: {
                throw new IllegalArgumentException("Illegal argument.");
            }
        }
    }
    
    public IAddress getIAddress(final AddressTriple$EIndex addressTriple$EIndex) {
        return new CAddress(this.getAddress(addressTriple$EIndex));
    }
    
    @Override
    public int hashCode() {
        return (int)((this.firstAddr ^ this.firstAddr >>> 32) * (this.firstAddr ^ this.secondAddr >>> 32) * (this.thirdAddr ^ this.thirdAddr >>> 32));
    }
}
