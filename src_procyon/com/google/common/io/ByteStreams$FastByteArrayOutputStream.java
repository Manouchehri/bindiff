package com.google.common.io;

import java.io.*;

final class ByteStreams$FastByteArrayOutputStream extends ByteArrayOutputStream
{
    void writeTo(final byte[] array, final int n) {
        System.arraycopy(this.buf, 0, array, n, this.count);
    }
}
