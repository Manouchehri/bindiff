/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.hash;

import java.io.ByteArrayOutputStream;

final class AbstractNonStreamingHashFunction$ExposedByteArrayOutputStream
extends ByteArrayOutputStream {
    AbstractNonStreamingHashFunction$ExposedByteArrayOutputStream(int n2) {
        super(n2);
    }

    byte[] byteArray() {
        return this.buf;
    }

    int length() {
        return this.count;
    }
}

