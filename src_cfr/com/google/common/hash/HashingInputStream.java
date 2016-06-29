/*
 * Decompiled with CFR 0_115.
 * 
 * Could not load the following classes:
 *  javax.annotation.CheckReturnValue
 */
package com.google.common.hash;

import com.google.common.annotations.Beta;
import com.google.common.base.Preconditions;
import com.google.common.hash.HashCode;
import com.google.common.hash.HashFunction;
import com.google.common.hash.Hasher;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import javax.annotation.CheckReturnValue;

@Beta
public final class HashingInputStream
extends FilterInputStream {
    private final Hasher hasher;

    public HashingInputStream(HashFunction hashFunction, InputStream inputStream) {
        super((InputStream)Preconditions.checkNotNull(inputStream));
        this.hasher = (Hasher)Preconditions.checkNotNull(hashFunction.newHasher());
    }

    @Override
    public int read() {
        int n2 = this.in.read();
        if (n2 == -1) return n2;
        this.hasher.putByte((byte)n2);
        return n2;
    }

    @Override
    public int read(byte[] arrby, int n2, int n3) {
        int n4 = this.in.read(arrby, n2, n3);
        if (n4 == -1) return n4;
        this.hasher.putBytes(arrby, n2, n4);
        return n4;
    }

    @CheckReturnValue
    @Override
    public boolean markSupported() {
        return false;
    }

    @Override
    public void mark(int n2) {
    }

    @Override
    public void reset() {
        throw new IOException("reset not supported");
    }

    @CheckReturnValue
    public HashCode hash() {
        return this.hasher.hash();
    }
}

