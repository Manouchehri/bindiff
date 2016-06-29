/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.io;

import com.google.common.primitives.UnsignedBytes;
import java.io.IOException;
import java.io.InputStream;
import java.nio.Buffer;
import java.nio.BufferUnderflowException;
import java.nio.ByteBuffer;
import java.nio.InvalidMarkException;

final class ByteBuffers$2
extends InputStream {
    final /* synthetic */ ByteBuffer val$buf;

    ByteBuffers$2(ByteBuffer byteBuffer) {
        this.val$buf = byteBuffer;
    }

    @Override
    public int read() {
        try {
            return UnsignedBytes.toInt(this.val$buf.get());
        }
        catch (BufferUnderflowException var1_1) {
            return -1;
        }
    }

    @Override
    public int read(byte[] arrby, int n2, int n3) {
        if (!this.val$buf.hasRemaining()) return -1;
        int n4 = Math.min(n3, this.val$buf.remaining());
        this.val$buf.get(arrby, n2, n4);
        return n4;
    }

    @Override
    public long skip(long l2) {
        if (l2 <= 0) {
            return 0;
        }
        int n2 = (int)Math.min((long)this.val$buf.remaining(), l2);
        this.val$buf.position(n2 + this.val$buf.position());
        return n2;
    }

    @Override
    public int available() {
        return this.val$buf.remaining();
    }

    @Override
    public boolean markSupported() {
        return true;
    }

    @Override
    public synchronized void mark(int n2) {
        this.val$buf.mark();
    }

    @Override
    public synchronized void reset() {
        try {
            this.val$buf.reset();
            return;
        }
        catch (InvalidMarkException var1_1) {
            throw new IOException(var1_1);
        }
    }
}

