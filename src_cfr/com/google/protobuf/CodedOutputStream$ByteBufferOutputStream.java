/*
 * Decompiled with CFR 0_115.
 */
package com.google.protobuf;

import java.io.OutputStream;
import java.nio.ByteBuffer;

class CodedOutputStream$ByteBufferOutputStream
extends OutputStream {
    private final ByteBuffer byteBuffer;

    public CodedOutputStream$ByteBufferOutputStream(ByteBuffer byteBuffer) {
        this.byteBuffer = byteBuffer;
    }

    @Override
    public void write(int n2) {
        this.byteBuffer.put((byte)n2);
    }

    @Override
    public void write(byte[] arrby, int n2, int n3) {
        this.byteBuffer.put(arrby, n2, n3);
    }
}

