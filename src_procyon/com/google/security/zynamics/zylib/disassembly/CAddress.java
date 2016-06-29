package com.google.security.zynamics.zylib.disassembly;

import java.math.*;
import com.google.common.base.*;

public class CAddress implements IAddress
{
    private final long m_address;
    
    public CAddress(final BigInteger bigInteger) {
        Preconditions.checkNotNull(bigInteger, (Object)"Address argument can not be null");
        this.m_address = bigInteger.longValue();
    }
    
    public CAddress(final CAddress cAddress) {
        Preconditions.checkNotNull(cAddress, (Object)"Address argument can not be null");
        this.m_address = cAddress.m_address;
    }
    
    public CAddress(final IAddress address) {
        Preconditions.checkNotNull(address, (Object)"Address argument can not be null");
        this.m_address = address.toLong();
    }
    
    public CAddress(final long address) {
        this.m_address = address;
    }
    
    public CAddress(final String s, final int n) {
        Preconditions.checkNotNull(s, (Object)"Address argument can not be null");
        Preconditions.checkArgument(n > 0, (Object)"Base must be positive");
        this.m_address = new BigInteger(s, n).longValue();
    }
    
    public static int compare(final long n, final long n2) {
        final int n3 = (n < n2) ? -1 : ((n > n2) ? 1 : 0);
        return ((n & Long.MIN_VALUE) == (n2 & Long.MIN_VALUE)) ? n3 : (-n3);
    }
    
    public int compareTo(final CAddress cAddress) {
        return compare(this.m_address, cAddress.m_address);
    }
    
    public int compareTo(final IAddress address) {
        return compare(this.m_address, address.toLong());
    }
    
    public int compareTo(final long n) {
        return compare(this.m_address, n);
    }
    
    public boolean equals(final CAddress cAddress) {
        return cAddress != null && this.m_address == cAddress.m_address;
    }
    
    public boolean equals(final IAddress address) {
        return address != null && this.m_address == address.toLong();
    }
    
    public boolean equals(final long n) {
        return this.m_address == n;
    }
    
    @Override
    public boolean equals(final Object o) {
        return o instanceof IAddress && this.m_address == ((IAddress)o).toLong();
    }
    
    @Override
    public int hashCode() {
        return Long.valueOf(this.m_address).hashCode();
    }
    
    @Override
    public BigInteger toBigInteger() {
        if ((this.m_address & Long.MIN_VALUE) == 0x0L) {
            return BigInteger.valueOf(this.m_address);
        }
        return new BigInteger(Long.toHexString(this.m_address), 16);
    }
    
    @Override
    public String toHexString() {
        return Strings.padStart(Long.toHexString(this.m_address).toUpperCase(), ((this.m_address & Long.MAX_VALUE) < 4294967296L) ? 8 : 16, '0');
    }
    
    @Override
    public long toLong() {
        return this.m_address;
    }
    
    @Override
    public String toString() {
        return this.toHexString();
    }
}
