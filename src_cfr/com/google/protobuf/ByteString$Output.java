/*
 * Decompiled with CFR 0_115.
 */
package com.google.protobuf;

import com.google.protobuf.ByteString;
import com.google.protobuf.LiteralByteString;
import java.io.OutputStream;
import java.util.ArrayList;

public final class ByteString$Output
extends OutputStream {
    private static final byte[] EMPTY_BYTE_ARRAY = new byte[0];
    private final int initialCapacity;
    private final ArrayList flushedBuffers;
    private int flushedBuffersTotalBytes;
    private byte[] buffer;
    private int bufferPos;

    ByteString$Output(int n2) {
        if (n2 < 0) {
            throw new IllegalArgumentException("Buffer size < 0");
        }
        this.initialCapacity = n2;
        this.flushedBuffers = new ArrayList();
        this.buffer = new byte[n2];
    }

    @Override
    public synchronized void write(int n2) {
        if (this.bufferPos == this.buffer.length) {
            this.flushFullBuffer(1);
        }
        this.buffer[this.bufferPos++] = (byte)n2;
    }

    @Override
    public synchronized void write(byte[] arrby, int n2, int n3) {
        if (n3 <= this.buffer.length - this.bufferPos) {
            System.arraycopy(arrby, n2, this.buffer, this.bufferPos, n3);
            this.bufferPos += n3;
            return;
        }
        int n4 = this.buffer.length - this.bufferPos;
        System.arraycopy(arrby, n2, this.buffer, this.bufferPos, n4);
        this.flushFullBuffer(n3 -= n4);
        System.arraycopy(arrby, n2 += n4, this.buffer, 0, n3);
        this.bufferPos = n3;
    }

    public synchronized ByteString toByteString() {
        this.flushLastBuffer();
        return ByteString.copyFrom(this.flushedBuffers);
    }

    private byte[] copyArray(byte[] arrby, int n2) {
        byte[] arrby2 = new byte[n2];
        System.arraycopy(arrby, 0, arrby2, 0, Math.min(arrby.length, n2));
        return arrby2;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void writeTo(OutputStream outputStream) {
        int n2;
        ByteString[] arrbyteString;
        byte[] arrby;
        ByteString[] arrbyteString2 = this;
        synchronized (arrbyteString2) {
            arrbyteString = this.flushedBuffers.toArray(new ByteString[this.flushedBuffers.size()]);
            arrby = this.buffer;
            n2 = this.bufferPos;
        }
        arrbyteString2 = arrbyteString;
        int n3 = arrbyteString2.length;
        int n4 = 0;
        do {
            if (n4 >= n3) {
                outputStream.write(super.copyArray(arrby, n2));
                return;
            }
            ByteString byteString = arrbyteString2[n4];
            byteString.writeTo(outputStream);
            ++n4;
        } while (true);
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

    private void flushFullBuffer(int n2) {
        this.flushedBuffers.add(new LiteralByteString(this.buffer));
        this.flushedBuffersTotalBytes += this.buffer.length;
        int n3 = Math.max(this.initialCapacity, Math.max(n2, this.flushedBuffersTotalBytes >>> 1));
        this.buffer = new byte[n3];
        this.bufferPos = 0;
    }

    private void flushLastBuffer() {
        if (this.bufferPos < this.buffer.length) {
            if (this.bufferPos > 0) {
                byte[] arrby = this.copyArray(this.buffer, this.bufferPos);
                this.flushedBuffers.add(new LiteralByteString(arrby));
            }
        } else {
            this.flushedBuffers.add(new LiteralByteString(this.buffer));
            this.buffer = EMPTY_BYTE_ARRAY;
        }
        this.flushedBuffersTotalBytes += this.bufferPos;
        this.bufferPos = 0;
    }
}

