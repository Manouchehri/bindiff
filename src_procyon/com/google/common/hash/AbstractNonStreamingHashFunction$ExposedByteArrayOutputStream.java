package com.google.common.hash;

import java.io.*;

final class AbstractNonStreamingHashFunction$ExposedByteArrayOutputStream extends ByteArrayOutputStream
{
    AbstractNonStreamingHashFunction$ExposedByteArrayOutputStream(final int n) {
        super(n);
    }
    
    byte[] byteArray() {
        return this.buf;
    }
    
    int length() {
        return this.count;
    }
}
