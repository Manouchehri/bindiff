/*
 * Decompiled with CFR 0_115.
 */
package com.google.protobuf;

import com.google.protobuf.TextFormat$ByteSequence;

final class TextFormat$2
implements TextFormat$ByteSequence {
    final /* synthetic */ byte[] val$input;

    TextFormat$2(byte[] arrby) {
        this.val$input = arrby;
    }

    @Override
    public int size() {
        return this.val$input.length;
    }

    @Override
    public byte byteAt(int n2) {
        return this.val$input[n2];
    }
}

