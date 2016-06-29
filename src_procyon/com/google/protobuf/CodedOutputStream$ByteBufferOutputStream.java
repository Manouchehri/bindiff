package com.google.protobuf;

import java.io.*;
import java.nio.*;

class CodedOutputStream$ByteBufferOutputStream extends OutputStream
{
    private final ByteBuffer byteBuffer;
    
    public CodedOutputStream$ByteBufferOutputStream(final ByteBuffer byteBuffer) {
        this.byteBuffer = byteBuffer;
    }
    
    public void write(final int n) {
        this.byteBuffer.put((byte)n);
    }
    
    public void write(final byte[] array, final int n, final int n2) {
        this.byteBuffer.put(array, n, n2);
    }
}
