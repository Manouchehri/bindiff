package com.google.common.hash;

import com.google.common.base.*;
import java.util.zip.*;

enum Hashing$ChecksumType implements Supplier
{
    CRC_32("CRC_32", 0, 32), 
    ADLER_32("ADLER_32", 1, 32);
    
    private final int bits;
    
    private Hashing$ChecksumType(final String s, final int n, final int bits) {
        this.bits = bits;
    }
    
    @Override
    public abstract Checksum get();
}
