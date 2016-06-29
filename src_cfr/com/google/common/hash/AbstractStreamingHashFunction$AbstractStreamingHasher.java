/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.hash;

import com.google.common.base.Preconditions;
import com.google.common.hash.AbstractHasher;
import com.google.common.hash.Funnel;
import com.google.common.hash.HashCode;
import com.google.common.hash.Hasher;
import com.google.common.hash.PrimitiveSink;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public abstract class AbstractStreamingHashFunction$AbstractStreamingHasher
extends AbstractHasher {
    private final ByteBuffer buffer;
    private final int bufferSize;
    private final int chunkSize;

    protected AbstractStreamingHashFunction$AbstractStreamingHasher(int n2) {
        this(n2, n2);
    }

    protected AbstractStreamingHashFunction$AbstractStreamingHasher(int n2, int n3) {
        Preconditions.checkArgument(n3 % n2 == 0);
        this.buffer = ByteBuffer.allocate(n3 + 7).order(ByteOrder.LITTLE_ENDIAN);
        this.bufferSize = n3;
        this.chunkSize = n2;
    }

    protected abstract void process(ByteBuffer var1);

    protected void processRemaining(ByteBuffer byteBuffer) {
        byteBuffer.position(byteBuffer.limit());
        byteBuffer.limit(this.chunkSize + 7);
        do {
            if (byteBuffer.position() >= this.chunkSize) {
                byteBuffer.limit(this.chunkSize);
                byteBuffer.flip();
                this.process(byteBuffer);
                return;
            }
            byteBuffer.putLong(0);
        } while (true);
    }

    @Override
    public final Hasher putBytes(byte[] arrby) {
        return this.putBytes(arrby, 0, arrby.length);
    }

    @Override
    public final Hasher putBytes(byte[] arrby, int n2, int n3) {
        return this.putBytes(ByteBuffer.wrap(arrby, n2, n3).order(ByteOrder.LITTLE_ENDIAN));
    }

    private Hasher putBytes(ByteBuffer byteBuffer) {
        if (byteBuffer.remaining() <= this.buffer.remaining()) {
            this.buffer.put(byteBuffer);
            this.munchIfFull();
            return this;
        }
        int n2 = this.bufferSize - this.buffer.position();
        for (int i2 = 0; i2 < n2; ++i2) {
            this.buffer.put(byteBuffer.get());
        }
        this.munch();
        do {
            if (byteBuffer.remaining() < this.chunkSize) {
                this.buffer.put(byteBuffer);
                return this;
            }
            this.process(byteBuffer);
        } while (true);
    }

    @Deprecated
    @Override
    public final Hasher putString(CharSequence charSequence) {
        return this.putUnencodedChars(charSequence);
    }

    @Override
    public final Hasher putUnencodedChars(CharSequence charSequence) {
        int n2 = 0;
        while (n2 < charSequence.length()) {
            this.putChar(charSequence.charAt(n2));
            ++n2;
        }
        return this;
    }

    @Override
    public final Hasher putByte(byte by2) {
        this.buffer.put(by2);
        this.munchIfFull();
        return this;
    }

    @Override
    public final Hasher putShort(short s2) {
        this.buffer.putShort(s2);
        this.munchIfFull();
        return this;
    }

    @Override
    public final Hasher putChar(char c2) {
        this.buffer.putChar(c2);
        this.munchIfFull();
        return this;
    }

    @Override
    public final Hasher putInt(int n2) {
        this.buffer.putInt(n2);
        this.munchIfFull();
        return this;
    }

    @Override
    public final Hasher putLong(long l2) {
        this.buffer.putLong(l2);
        this.munchIfFull();
        return this;
    }

    @Override
    public final Hasher putObject(Object object, Funnel funnel) {
        funnel.funnel(object, this);
        return this;
    }

    @Override
    public final HashCode hash() {
        this.munch();
        this.buffer.flip();
        if (this.buffer.remaining() <= 0) return this.makeHash();
        this.processRemaining(this.buffer);
        return this.makeHash();
    }

    abstract HashCode makeHash();

    private void munchIfFull() {
        if (this.buffer.remaining() >= 8) return;
        this.munch();
    }

    private void munch() {
        this.buffer.flip();
        do {
            if (this.buffer.remaining() < this.chunkSize) {
                this.buffer.compact();
                return;
            }
            this.process(this.buffer);
        } while (true);
    }
}

