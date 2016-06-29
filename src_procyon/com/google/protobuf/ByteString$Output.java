package com.google.protobuf;

import java.io.*;
import java.util.*;

public final class ByteString$Output extends OutputStream
{
    private static final byte[] EMPTY_BYTE_ARRAY;
    private final int initialCapacity;
    private final ArrayList flushedBuffers;
    private int flushedBuffersTotalBytes;
    private byte[] buffer;
    private int bufferPos;
    
    ByteString$Output(final int initialCapacity) {
        if (initialCapacity < 0) {
            throw new IllegalArgumentException("Buffer size < 0");
        }
        this.initialCapacity = initialCapacity;
        this.flushedBuffers = new ArrayList();
        this.buffer = new byte[initialCapacity];
    }
    
    public synchronized void write(final int n) {
        if (this.bufferPos == this.buffer.length) {
            this.flushFullBuffer(1);
        }
        this.buffer[this.bufferPos++] = (byte)n;
    }
    
    public synchronized void write(final byte[] array, int n, int bufferPos) {
        if (bufferPos <= this.buffer.length - this.bufferPos) {
            System.arraycopy(array, n, this.buffer, this.bufferPos, bufferPos);
            this.bufferPos += bufferPos;
        }
        else {
            final int n2 = this.buffer.length - this.bufferPos;
            System.arraycopy(array, n, this.buffer, this.bufferPos, n2);
            n += n2;
            bufferPos -= n2;
            this.flushFullBuffer(bufferPos);
            System.arraycopy(array, n, this.buffer, 0, bufferPos);
            this.bufferPos = bufferPos;
        }
    }
    
    public synchronized ByteString toByteString() {
        this.flushLastBuffer();
        return ByteString.copyFrom(this.flushedBuffers);
    }
    
    private byte[] copyArray(final byte[] array, final int n) {
        final byte[] array2 = new byte[n];
        System.arraycopy(array, 0, array2, 0, Math.min(array.length, n));
        return array2;
    }
    
    public void writeTo(final OutputStream outputStream) {
        final ByteString[] array;
        final byte[] buffer;
        final int bufferPos;
        synchronized (this) {
            array = this.flushedBuffers.toArray(new ByteString[this.flushedBuffers.size()]);
            buffer = this.buffer;
            bufferPos = this.bufferPos;
        }
        final ByteString[] array2 = array;
        for (int length = array2.length, i = 0; i < length; ++i) {
            array2[i].writeTo(outputStream);
        }
        outputStream.write(this.copyArray(buffer, bufferPos));
    }
    
    public synchronized int size() {
        return this.flushedBuffersTotalBytes + this.bufferPos;
    }
    
    public synchronized void reset() {
        this.flushedBuffers.clear();
        this.flushedBuffersTotalBytes = 0;
        this.bufferPos = 0;
    }
    
    public String toString() {
        return String.format("<ByteString.Output@%s size=%d>", Integer.toHexString(System.identityHashCode(this)), this.size());
    }
    
    private void flushFullBuffer(final int n) {
        this.flushedBuffers.add(new LiteralByteString(this.buffer));
        this.flushedBuffersTotalBytes += this.buffer.length;
        this.buffer = new byte[Math.max(this.initialCapacity, Math.max(n, this.flushedBuffersTotalBytes >>> 1))];
        this.bufferPos = 0;
    }
    
    private void flushLastBuffer() {
        if (this.bufferPos < this.buffer.length) {
            if (this.bufferPos > 0) {
                this.flushedBuffers.add(new LiteralByteString(this.copyArray(this.buffer, this.bufferPos)));
            }
        }
        else {
            this.flushedBuffers.add(new LiteralByteString(this.buffer));
            this.buffer = ByteString$Output.EMPTY_BYTE_ARRAY;
        }
        this.flushedBuffersTotalBytes += this.bufferPos;
        this.bufferPos = 0;
    }
    
    static {
        EMPTY_BYTE_ARRAY = new byte[0];
    }
}
