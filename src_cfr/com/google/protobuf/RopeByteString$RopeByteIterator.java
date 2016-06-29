/*
 * Decompiled with CFR 0_115.
 */
package com.google.protobuf;

import com.google.protobuf.ByteString;
import com.google.protobuf.ByteString$ByteIterator;
import com.google.protobuf.LiteralByteString;
import com.google.protobuf.RopeByteString;
import com.google.protobuf.RopeByteString$1;
import com.google.protobuf.RopeByteString$PieceIterator;

class RopeByteString$RopeByteIterator
implements ByteString$ByteIterator {
    private final RopeByteString$PieceIterator pieces;
    private ByteString$ByteIterator bytes;
    int bytesRemaining;
    final /* synthetic */ RopeByteString this$0;

    private RopeByteString$RopeByteIterator(RopeByteString ropeByteString) {
        this.this$0 = ropeByteString;
        this.pieces = new RopeByteString$PieceIterator(ropeByteString, null);
        this.bytes = this.pieces.next().iterator();
        this.bytesRemaining = ropeByteString.size();
    }

    @Override
    public boolean hasNext() {
        if (this.bytesRemaining <= 0) return false;
        return true;
    }

    public Byte next() {
        return Byte.valueOf(this.nextByte());
    }

    @Override
    public byte nextByte() {
        if (!this.bytes.hasNext()) {
            this.bytes = this.pieces.next().iterator();
        }
        --this.bytesRemaining;
        return this.bytes.nextByte();
    }

    @Override
    public void remove() {
        throw new UnsupportedOperationException();
    }

    /* synthetic */ RopeByteString$RopeByteIterator(RopeByteString ropeByteString, RopeByteString$1 ropeByteString$1) {
        this(ropeByteString);
    }
}

