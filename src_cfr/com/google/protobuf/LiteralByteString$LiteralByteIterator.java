/*
 * Decompiled with CFR 0_115.
 */
package com.google.protobuf;

import com.google.protobuf.ByteString$ByteIterator;
import com.google.protobuf.LiteralByteString;
import com.google.protobuf.LiteralByteString$1;
import java.util.NoSuchElementException;

class LiteralByteString$LiteralByteIterator
implements ByteString$ByteIterator {
    private int position;
    private final int limit;
    final /* synthetic */ LiteralByteString this$0;

    private LiteralByteString$LiteralByteIterator(LiteralByteString literalByteString) {
        this.this$0 = literalByteString;
        this.position = 0;
        this.limit = literalByteString.size();
    }

    @Override
    public boolean hasNext() {
        if (this.position >= this.limit) return false;
        return true;
    }

    public Byte next() {
        return Byte.valueOf(this.nextByte());
    }

    @Override
    public byte nextByte() {
        try {
            return this.this$0.bytes[this.position++];
        }
        catch (ArrayIndexOutOfBoundsException var1_1) {
            throw new NoSuchElementException(var1_1.getMessage());
        }
    }

    @Override
    public void remove() {
        throw new UnsupportedOperationException();
    }

    /* synthetic */ LiteralByteString$LiteralByteIterator(LiteralByteString literalByteString, LiteralByteString$1 literalByteString$1) {
        this(literalByteString);
    }
}

