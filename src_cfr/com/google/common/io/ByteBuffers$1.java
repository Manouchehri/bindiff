/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.io;

import com.google.common.io.ByteBuffers;
import com.google.common.io.ByteSource;
import java.io.InputStream;
import java.nio.ByteBuffer;

final class ByteBuffers$1
extends ByteSource {
    final /* synthetic */ ByteBuffer val$buf;

    ByteBuffers$1(ByteBuffer byteBuffer) {
        this.val$buf = byteBuffer;
    }

    @Override
    public InputStream openStream() {
        return ByteBuffers.newConsumingInputStream(this.val$buf.slice());
    }

    public String toString() {
        String string = String.valueOf(this.val$buf);
        return new StringBuilder(26 + String.valueOf(string).length()).append("ByteBuffers.asByteSource(").append(string).append(")").toString();
    }
}

