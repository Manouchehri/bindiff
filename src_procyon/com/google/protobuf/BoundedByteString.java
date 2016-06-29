package com.google.protobuf;

import java.io.*;
import java.util.*;

class BoundedByteString extends LiteralByteString
{
    private final int bytesOffset;
    private final int bytesLength;
    private static final long serialVersionUID = 1L;
    
    BoundedByteString(final byte[] array, final int bytesOffset, final int bytesLength) {
        super(array);
        if (bytesOffset < 0) {
            throw new IllegalArgumentException(new StringBuilder(29).append("Offset too small: ").append(bytesOffset).toString());
        }
        if (bytesLength < 0) {
            throw new IllegalArgumentException(new StringBuilder(29).append("Length too small: ").append(bytesOffset).toString());
        }
        if (bytesOffset + bytesLength > array.length) {
            throw new IllegalArgumentException(new StringBuilder(48).append("Offset+Length too large: ").append(bytesOffset).append("+").append(bytesLength).toString());
        }
        this.bytesOffset = bytesOffset;
        this.bytesLength = bytesLength;
    }
    
    public byte byteAt(final int n) {
        if (n < 0) {
            throw new ArrayIndexOutOfBoundsException(new StringBuilder(28).append("Index too small: ").append(n).toString());
        }
        if (n >= this.size()) {
            throw new ArrayIndexOutOfBoundsException(new StringBuilder(41).append("Index too large: ").append(n).append(", ").append(this.size()).toString());
        }
        return this.bytes[this.bytesOffset + n];
    }
    
    public int size() {
        return this.bytesLength;
    }
    
    protected int getOffsetIntoBytes() {
        return this.bytesOffset;
    }
    
    protected void copyToInternal(final byte[] array, final int n, final int n2, final int n3) {
        System.arraycopy(this.bytes, this.getOffsetIntoBytes() + n, array, n2, n3);
    }
    
    Object writeReplace() {
        return new LiteralByteString(this.toByteArray());
    }
    
    private void readObject(final ObjectInputStream objectInputStream) {
        throw new InvalidObjectException("BoundedByteStream instances are not to be serialized directly");
    }
    
    public ByteString$ByteIterator iterator() {
        return new BoundedByteString$BoundedByteIterator(this, null);
    }
}
