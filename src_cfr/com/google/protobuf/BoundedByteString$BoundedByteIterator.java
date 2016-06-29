/*
 * Decompiled with CFR 0_115.
 */
package com.google.protobuf;

import com.google.protobuf.BoundedByteString;
import com.google.protobuf.BoundedByteString$1;
import com.google.protobuf.ByteString$ByteIterator;
import java.util.NoSuchElementException;

class BoundedByteString$BoundedByteIterator
implements ByteString$ByteIterator {
    private int position;
    private final int limit;
    final /* synthetic */ BoundedByteString this$0;

    private BoundedByteString$BoundedByteIterator(BoundedByteString boundedByteString) {
        this.this$0 = boundedByteString;
        this.position = boundedByteString.getOffsetIntoBytes();
        this.limit = this.position + boundedByteString.size();
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
        if (this.position < this.limit) return this.this$0.bytes[this.position++];
        throw new NoSuchElementException();
    }

    @Override
    public void remove() {
        throw new UnsupportedOperationException();
    }

    /* synthetic */ BoundedByteString$BoundedByteIterator(BoundedByteString boundedByteString, BoundedByteString$1 boundedByteString$1) {
        this(boundedByteString);
    }
}

