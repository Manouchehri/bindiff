package com.google.common.hash;

import com.google.common.base.*;
import java.nio.*;

public abstract class AbstractStreamingHashFunction$AbstractStreamingHasher extends AbstractHasher
{
    private final ByteBuffer buffer;
    private final int bufferSize;
    private final int chunkSize;
    
    protected AbstractStreamingHashFunction$AbstractStreamingHasher(final int n) {
        this(n, n);
    }
    
    protected AbstractStreamingHashFunction$AbstractStreamingHasher(final int chunkSize, final int bufferSize) {
        Preconditions.checkArgument(bufferSize % chunkSize == 0);
        this.buffer = ByteBuffer.allocate(bufferSize + 7).order(ByteOrder.LITTLE_ENDIAN);
        this.bufferSize = bufferSize;
        this.chunkSize = chunkSize;
    }
    
    protected abstract void process(final ByteBuffer p0);
    
    protected void processRemaining(final ByteBuffer byteBuffer) {
        byteBuffer.position(byteBuffer.limit());
        byteBuffer.limit(this.chunkSize + 7);
        while (byteBuffer.position() < this.chunkSize) {
            byteBuffer.putLong(0L);
        }
        byteBuffer.limit(this.chunkSize);
        byteBuffer.flip();
        this.process(byteBuffer);
    }
    
    @Override
    public final Hasher putBytes(final byte[] array) {
        return this.putBytes(array, 0, array.length);
    }
    
    @Override
    public final Hasher putBytes(final byte[] array, final int n, final int n2) {
        return this.putBytes(ByteBuffer.wrap(array, n, n2).order(ByteOrder.LITTLE_ENDIAN));
    }
    
    private Hasher putBytes(final ByteBuffer byteBuffer) {
        if (byteBuffer.remaining() <= this.buffer.remaining()) {
            this.buffer.put(byteBuffer);
            this.munchIfFull();
            return this;
        }
        for (int n = this.bufferSize - this.buffer.position(), i = 0; i < n; ++i) {
            this.buffer.put(byteBuffer.get());
        }
        this.munch();
        while (byteBuffer.remaining() >= this.chunkSize) {
            this.process(byteBuffer);
        }
        this.buffer.put(byteBuffer);
        return this;
    }
    
    @Deprecated
    @Override
    public final Hasher putString(final CharSequence charSequence) {
        return this.putUnencodedChars(charSequence);
    }
    
    @Override
    public final Hasher putUnencodedChars(final CharSequence charSequence) {
        for (int i = 0; i < charSequence.length(); ++i) {
            this.putChar(charSequence.charAt(i));
        }
        return this;
    }
    
    @Override
    public final Hasher putByte(final byte b) {
        this.buffer.put(b);
        this.munchIfFull();
        return this;
    }
    
    @Override
    public final Hasher putShort(final short n) {
        this.buffer.putShort(n);
        this.munchIfFull();
        return this;
    }
    
    @Override
    public final Hasher putChar(final char c) {
        this.buffer.putChar(c);
        this.munchIfFull();
        return this;
    }
    
    @Override
    public final Hasher putInt(final int n) {
        this.buffer.putInt(n);
        this.munchIfFull();
        return this;
    }
    
    @Override
    public final Hasher putLong(final long n) {
        this.buffer.putLong(n);
        this.munchIfFull();
        return this;
    }
    
    @Override
    public final Hasher putObject(final Object o, final Funnel funnel) {
        funnel.funnel(o, this);
        return this;
    }
    
    @Override
    public final HashCode hash() {
        this.munch();
        this.buffer.flip();
        if (this.buffer.remaining() > 0) {
            this.processRemaining(this.buffer);
        }
        return this.makeHash();
    }
    
    abstract HashCode makeHash();
    
    private void munchIfFull() {
        if (this.buffer.remaining() < 8) {
            this.munch();
        }
    }
    
    private void munch() {
        this.buffer.flip();
        while (this.buffer.remaining() >= this.chunkSize) {
            this.process(this.buffer);
        }
        this.buffer.compact();
    }
}
