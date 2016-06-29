/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.bindiff.project.matches;

import com.google.security.zynamics.bindiff.project.matches.AddressTriple$1;
import com.google.security.zynamics.bindiff.project.matches.AddressTriple$EIndex;
import com.google.security.zynamics.zylib.disassembly.CAddress;
import com.google.security.zynamics.zylib.disassembly.IAddress;

public class AddressTriple {
    private final long firstAddr;
    private final long secondAddr;
    private final long thirdAddr;

    public AddressTriple(long l2, long l3, long l4) {
        this.firstAddr = l2;
        this.secondAddr = l3;
        this.thirdAddr = l4;
    }

    public boolean equals(Object object) {
        if (this.firstAddr != ((AddressTriple)object).getAddress(AddressTriple$EIndex.FIRST)) return false;
        if (this.secondAddr != ((AddressTriple)object).getAddress(AddressTriple$EIndex.SECOND)) return false;
        if (this.thirdAddr != ((AddressTriple)object).getAddress(AddressTriple$EIndex.THIRD)) return false;
        return true;
    }

    public long getAddress(AddressTriple$EIndex addressTriple$EIndex) {
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
        }
        throw new IllegalArgumentException("Illegal argument.");
    }

    public IAddress getIAddress(AddressTriple$EIndex addressTriple$EIndex) {
        return new CAddress(this.getAddress(addressTriple$EIndex));
    }

    public int hashCode() {
        return (int)((this.firstAddr ^ this.firstAddr >>> 32) * (this.firstAddr ^ this.secondAddr >>> 32) * (this.thirdAddr ^ this.thirdAddr >>> 32));
    }
}

