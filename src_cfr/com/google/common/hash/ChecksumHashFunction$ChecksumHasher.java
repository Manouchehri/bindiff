/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.hash;

import com.google.common.base.Preconditions;
import com.google.common.hash.AbstractByteHasher;
import com.google.common.hash.ChecksumHashFunction;
import com.google.common.hash.ChecksumHashFunction$1;
import com.google.common.hash.HashCode;
import java.util.zip.Checksum;

final class ChecksumHashFunction$ChecksumHasher
extends AbstractByteHasher {
    private final Checksum checksum;
    final /* synthetic */ ChecksumHashFunction this$0;

    private ChecksumHashFunction$ChecksumHasher(ChecksumHashFunction checksumHashFunction, Checksum checksum) {
        this.this$0 = checksumHashFunction;
        this.checksum = (Checksum)Preconditions.checkNotNull(checksum);
    }

    @Override
    protected void update(byte by2) {
        this.checksum.update(by2);
    }

    @Override
    protected void update(byte[] arrby, int n2, int n3) {
        this.checksum.update(arrby, n2, n3);
    }

    @Override
    public HashCode hash() {
        long l2 = this.checksum.getValue();
        if (ChecksumHashFunction.access$100(this.this$0) != 32) return HashCode.fromLong(l2);
        return HashCode.fromInt((int)l2);
    }

    /* synthetic */ ChecksumHashFunction$ChecksumHasher(ChecksumHashFunction checksumHashFunction, Checksum checksum, ChecksumHashFunction$1 checksumHashFunction$1) {
        this(checksumHashFunction, checksum);
    }
}

