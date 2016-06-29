/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.hash;

import com.google.common.base.Preconditions;
import com.google.common.hash.PrimitiveSink;
import java.io.OutputStream;

class Funnels$SinkAsStream
extends OutputStream {
    final PrimitiveSink sink;

    Funnels$SinkAsStream(PrimitiveSink primitiveSink) {
        this.sink = (PrimitiveSink)Preconditions.checkNotNull(primitiveSink);
    }

    @Override
    public void write(int n2) {
        this.sink.putByte((byte)n2);
    }

    @Override
    public void write(byte[] arrby) {
        this.sink.putBytes(arrby);
    }

    @Override
    public void write(byte[] arrby, int n2, int n3) {
        this.sink.putBytes(arrby, n2, n3);
    }

    public String toString() {
        String string = String.valueOf(this.sink);
        return new StringBuilder(24 + String.valueOf(string).length()).append("Funnels.asOutputStream(").append(string).append(")").toString();
    }
}

