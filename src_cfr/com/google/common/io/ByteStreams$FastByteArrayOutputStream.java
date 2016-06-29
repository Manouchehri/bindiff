/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.io;

import com.google.common.io.ByteStreams$1;
import java.io.ByteArrayOutputStream;

final class ByteStreams$FastByteArrayOutputStream
extends ByteArrayOutputStream {
    private ByteStreams$FastByteArrayOutputStream() {
    }

    void writeTo(byte[] arrby, int n2) {
        System.arraycopy(this.buf, 0, arrby, n2, this.count);
    }

    /* synthetic */ ByteStreams$FastByteArrayOutputStream(ByteStreams$1 byteStreams$1) {
        this();
    }
}

