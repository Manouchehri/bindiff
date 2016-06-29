/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.hash;

import com.google.common.base.Preconditions;
import com.google.common.base.Supplier;
import com.google.common.hash.AbstractStreamingHashFunction;
import com.google.common.hash.ChecksumHashFunction$1;
import com.google.common.hash.ChecksumHashFunction$ChecksumHasher;
import com.google.common.hash.Hasher;
import java.io.Serializable;
import java.util.zip.Checksum;

final class ChecksumHashFunction
extends AbstractStreamingHashFunction
implements Serializable {
    private final Supplier checksumSupplier;
    private final int bits;
    private final String toString;
    private static final long serialVersionUID = 0;

    ChecksumHashFunction(Supplier supplier, int n2, String string) {
        this.checksumSupplier = (Supplier)Preconditions.checkNotNull(supplier);
        Preconditions.checkArgument(n2 == 32 || n2 == 64, "bits (%s) must be either 32 or 64", n2);
        this.bits = n2;
        this.toString = (String)Preconditions.checkNotNull(string);
    }

    @Override
    public int bits() {
        return this.bits;
    }

    @Override
    public Hasher newHasher() {
        return new ChecksumHashFunction$ChecksumHasher(this, (Checksum)this.checksumSupplier.get(), null);
    }

    public String toString() {
        return this.toString;
    }

    static /* synthetic */ int access$100(ChecksumHashFunction checksumHashFunction) {
        return checksumHashFunction.bits;
    }
}

