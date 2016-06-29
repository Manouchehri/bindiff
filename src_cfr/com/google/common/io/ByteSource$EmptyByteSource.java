/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.io;

import com.google.common.base.Preconditions;
import com.google.common.io.ByteSource$ByteArrayByteSource;
import com.google.common.io.CharSource;
import java.nio.charset.Charset;

final class ByteSource$EmptyByteSource
extends ByteSource$ByteArrayByteSource {
    static final ByteSource$EmptyByteSource INSTANCE = new ByteSource$EmptyByteSource();

    ByteSource$EmptyByteSource() {
        super(new byte[0]);
    }

    @Override
    public CharSource asCharSource(Charset charset) {
        Preconditions.checkNotNull(charset);
        return CharSource.empty();
    }

    @Override
    public byte[] read() {
        return this.bytes;
    }

    @Override
    public String toString() {
        return "ByteSource.empty()";
    }
}

