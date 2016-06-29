/*
 * Decompiled with CFR 0_115.
 */
package com.google.protobuf;

import com.google.protobuf.ByteString;
import com.google.protobuf.TextFormat$ByteSequence;

final class TextFormat$1
implements TextFormat$ByteSequence {
    final /* synthetic */ ByteString val$input;

    TextFormat$1(ByteString byteString) {
        this.val$input = byteString;
    }

    @Override
    public int size() {
        return this.val$input.size();
    }

    @Override
    public byte byteAt(int n2) {
        return this.val$input.byteAt(n2);
    }
}

