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
import java.io.FilterOutputStream;
import java.io.OutputStream;
import javax.annotation.CheckReturnValue;

@Beta
public final class HashingOutputStream
extends FilterOutputStream {
    private final Hasher hasher;

    public HashingOutputStream(HashFunction hashFunction, OutputStream outputStream) {
        super((OutputStream)Preconditions.checkNotNull(outputStream));
        this.hasher = (Hasher)Preconditions.checkNotNull(hashFunction.newHasher());
    }

    @Override
    public void write(int n2) {
        this.hasher.putByte((byte)n2);
        this.out.write(n2);
    }

    @Override
    public void write(byte[] arrby, int n2, int n3) {
        this.hasher.putBytes(arrby, n2, n3);
        this.out.write(arrby, n2, n3);
    }

    @CheckReturnValue
    public HashCode hash() {
        return this.hasher.hash();
    }

    @Override
    public void close() {
        this.out.close();
    }
}

