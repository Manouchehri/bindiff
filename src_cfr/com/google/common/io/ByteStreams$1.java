/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.io;

import com.google.common.base.Preconditions;
import java.io.OutputStream;

final class ByteStreams$1
extends OutputStream {
    ByteStreams$1() {
    }

    @Override
    public void write(int n2) {
    }

    @Override
    public void write(byte[] arrby) {
        Preconditions.checkNotNull(arrby);
    }

    @Override
    public void write(byte[] arrby, int n2, int n3) {
        Preconditions.checkNotNull(arrby);
    }

    public String toString() {
        return "ByteStreams.nullOutputStream()";
    }
}

