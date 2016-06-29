package com.google.common.hash;

import java.io.*;
import com.google.common.base.*;
import java.util.zip.*;

final class ChecksumHashFunction extends AbstractStreamingHashFunction implements Serializable
{
    private final Supplier checksumSupplier;
    private final int bits;
    private final String toString;
    private static final long serialVersionUID = 0L;
    
    ChecksumHashFunction(final Supplier supplier, final int bits, final String s) {
        this.checksumSupplier = (Supplier)Preconditions.checkNotNull(supplier);
        Preconditions.checkArgument(bits == 32 || bits == 64, "bits (%s) must be either 32 or 64", bits);
        this.bits = bits;
        this.toString = (String)Preconditions.checkNotNull(s);
    }
    
    @Override
    public int bits() {
        return this.bits;
    }
    
    @Override
    public Hasher newHasher() {
        return new ChecksumHashFunction$ChecksumHasher(this, (Checksum)this.checksumSupplier.get(), null);
    }
    
    @Override
    public String toString() {
        return this.toString;
    }
}
