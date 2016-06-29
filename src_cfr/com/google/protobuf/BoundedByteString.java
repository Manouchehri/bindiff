/*
 * Decompiled with CFR 0_115.
 */
package com.google.protobuf;

import com.google.protobuf.BoundedByteString$1;
import com.google.protobuf.BoundedByteString$BoundedByteIterator;
import com.google.protobuf.ByteString$ByteIterator;
import com.google.protobuf.LiteralByteString;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.util.Iterator;

class BoundedByteString
extends LiteralByteString {
    private final int bytesOffset;
    private final int bytesLength;
    private static final long serialVersionUID = 1;

    BoundedByteString(byte[] arrby, int n2, int n3) {
        super(arrby);
        if (n2 < 0) {
            int n4 = n2;
            throw new IllegalArgumentException(new StringBuilder(29).append("Offset too small: ").append(n4).toString());
        }
        if (n3 < 0) {
            int n5 = n2;
            throw new IllegalArgumentException(new StringBuilder(29).append("Length too small: ").append(n5).toString());
        }
        if ((long)n2 + (long)n3 > (long)arrby.length) {
            int n6 = n2;
            int n7 = n3;
            throw new IllegalArgumentException(new StringBuilder(48).append("Offset+Length too large: ").append(n6).append("+").append(n7).toString());
        }
        this.bytesOffset = n2;
        this.bytesLength = n3;
    }

    @Override
    public byte byteAt(int n2) {
        if (n2 < 0) {
            int n3 = n2;
            throw new ArrayIndexOutOfBoundsException(new StringBuilder(28).append("Index too small: ").append(n3).toString());
        }
        if (n2 < this.size()) return this.bytes[this.bytesOffset + n2];
        int n4 = n2;
        int n5 = this.size();
        throw new ArrayIndexOutOfBoundsException(new StringBuilder(41).append("Index too large: ").append(n4).append(", ").append(n5).toString());
    }

    @Override
    public int size() {
        return this.bytesLength;
    }

    @Override
    protected int getOffsetIntoBytes() {
        return this.bytesOffset;
    }

    @Override
    protected void copyToInternal(byte[] arrby, int n2, int n3, int n4) {
        System.arraycopy(this.bytes, this.getOffsetIntoBytes() + n2, arrby, n3, n4);
    }

    Object writeReplace() {
        return new LiteralByteString(this.toByteArray());
    }

    private void readObject(ObjectInputStream objectInputStream) {
        throw new InvalidObjectException("BoundedByteStream instances are not to be serialized directly");
    }

    @Override
    public ByteString$ByteIterator iterator() {
        return new BoundedByteString$BoundedByteIterator(this, null);
    }
}

