/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.zylib.disassembly;

import com.google.common.base.Preconditions;
import com.google.common.base.Strings;
import com.google.security.zynamics.zylib.disassembly.IAddress;
import java.math.BigInteger;

public class CAddress
implements IAddress {
    private final long m_address;

    public CAddress(BigInteger bigInteger) {
        Preconditions.checkNotNull(bigInteger, "Address argument can not be null");
        this.m_address = bigInteger.longValue();
    }

    public CAddress(CAddress cAddress) {
        Preconditions.checkNotNull(cAddress, "Address argument can not be null");
        this.m_address = cAddress.m_address;
    }

    public CAddress(IAddress iAddress) {
        Preconditions.checkNotNull(iAddress, "Address argument can not be null");
        this.m_address = iAddress.toLong();
    }

    public CAddress(long l2) {
        this.m_address = l2;
    }

    public CAddress(String string, int n2) {
        Preconditions.checkNotNull(string, "Address argument can not be null");
        Preconditions.checkArgument(n2 > 0, "Base must be positive");
        this.m_address = new BigInteger(string, n2).longValue();
    }

    public static int compare(long l2, long l3) {
        int n2;
        int n3;
        int n4 = l2 < l3 ? -1 : (n2 = l2 > l3 ? 1 : 0);
        if ((l2 & Long.MIN_VALUE) == (l3 & Long.MIN_VALUE)) {
            n3 = n2;
            return n3;
        }
        n3 = - n2;
        return n3;
    }

    public int compareTo(CAddress cAddress) {
        return CAddress.compare(this.m_address, cAddress.m_address);
    }

    public int compareTo(IAddress iAddress) {
        return CAddress.compare(this.m_address, iAddress.toLong());
    }

    public int compareTo(long l2) {
        return CAddress.compare(this.m_address, l2);
    }

    public boolean equals(CAddress cAddress) {
        if (cAddress == null) return false;
        if (this.m_address != cAddress.m_address) return false;
        return true;
    }

    public boolean equals(IAddress iAddress) {
        if (iAddress == null) return false;
        if (this.m_address != iAddress.toLong()) return false;
        return true;
    }

    public boolean equals(long l2) {
        if (this.m_address != l2) return false;
        return true;
    }

    public boolean equals(Object object) {
        if (!(object instanceof IAddress)) return false;
        if (this.m_address != ((IAddress)object).toLong()) return false;
        return true;
    }

    public int hashCode() {
        return Long.valueOf(this.m_address).hashCode();
    }

    @Override
    public BigInteger toBigInteger() {
        if ((this.m_address & Long.MIN_VALUE) != 0) return new BigInteger(Long.toHexString(this.m_address), 16);
        return BigInteger.valueOf(this.m_address);
    }

    @Override
    public String toHexString() {
        int n2;
        if ((this.m_address & Long.MAX_VALUE) < 0x100000000L) {
            n2 = 8;
            return Strings.padStart(Long.toHexString(this.m_address).toUpperCase(), n2, '0');
        }
        n2 = 16;
        return Strings.padStart(Long.toHexString(this.m_address).toUpperCase(), n2, '0');
    }

    @Override
    public long toLong() {
        return this.m_address;
    }

    public String toString() {
        return this.toHexString();
    }
}

