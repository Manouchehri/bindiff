package com.google.protobuf;

import java.nio.*;
import java.nio.charset.*;
import java.io.*;
import java.util.*;

class LiteralByteString extends ByteString
{
    private static final long serialVersionUID = 1L;
    protected final byte[] bytes;
    private int hash;
    
    LiteralByteString(final byte[] bytes) {
        this.hash = 0;
        this.bytes = bytes;
    }
    
    public byte byteAt(final int n) {
        return this.bytes[n];
    }
    
    public int size() {
        return this.bytes.length;
    }
    
    public ByteString substring(final int n, final int n2) {
        if (n < 0) {
            throw new IndexOutOfBoundsException(new StringBuilder(32).append("Beginning index: ").append(n).append(" < 0").toString());
        }
        if (n2 > this.size()) {
            throw new IndexOutOfBoundsException(new StringBuilder(36).append("End index: ").append(n2).append(" > ").append(this.size()).toString());
        }
        final int n3 = n2 - n;
        if (n3 < 0) {
            throw new IndexOutOfBoundsException(new StringBuilder(66).append("Beginning index larger than ending index: ").append(n).append(", ").append(n2).toString());
        }
        ByteString empty;
        if (n3 == 0) {
            empty = ByteString.EMPTY;
        }
        else {
            empty = new BoundedByteString(this.bytes, this.getOffsetIntoBytes() + n, n3);
        }
        return empty;
    }
    
    protected void copyToInternal(final byte[] array, final int n, final int n2, final int n3) {
        System.arraycopy(this.bytes, n, array, n2, n3);
    }
    
    public void copyTo(final ByteBuffer byteBuffer) {
        byteBuffer.put(this.bytes, this.getOffsetIntoBytes(), this.size());
    }
    
    public ByteBuffer asReadOnlyByteBuffer() {
        return ByteBuffer.wrap(this.bytes, this.getOffsetIntoBytes(), this.size()).asReadOnlyBuffer();
    }
    
    public List asReadOnlyByteBufferList() {
        final ArrayList<ByteBuffer> list = new ArrayList<ByteBuffer>(1);
        list.add(this.asReadOnlyByteBuffer());
        return list;
    }
    
    public void writeTo(final OutputStream outputStream) {
        outputStream.write(this.toByteArray());
    }
    
    void writeToInternal(final OutputStream outputStream, final int n, final int n2) {
        outputStream.write(this.bytes, this.getOffsetIntoBytes() + n, n2);
    }
    
    protected String toStringInternal(final Charset charset) {
        return new String(this.bytes, this.getOffsetIntoBytes(), this.size(), charset);
    }
    
    public boolean isValidUtf8() {
        final int offsetIntoBytes = this.getOffsetIntoBytes();
        return Utf8.isValidUtf8(this.bytes, offsetIntoBytes, offsetIntoBytes + this.size());
    }
    
    protected int partialIsValidUtf8(final int n, final int n2, final int n3) {
        final int n4 = this.getOffsetIntoBytes() + n2;
        return Utf8.partialIsValidUtf8(n, this.bytes, n4, n4 + n3);
    }
    
    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof ByteString)) {
            return false;
        }
        if (this.size() != ((ByteString)o).size()) {
            return false;
        }
        if (this.size() == 0) {
            return true;
        }
        if (o instanceof LiteralByteString) {
            final LiteralByteString literalByteString = (LiteralByteString)o;
            return (this.hash == 0 || literalByteString.hash == 0 || this.hash == literalByteString.hash) && this.equalsRange((LiteralByteString)o, 0, this.size());
        }
        if (o instanceof RopeByteString) {
            return o.equals(this);
        }
        final String value = String.valueOf(String.valueOf(o.getClass()));
        throw new IllegalArgumentException(new StringBuilder(49 + value.length()).append("Has a new type of ByteString been created? Found ").append(value).toString());
    }
    
    boolean equalsRange(final LiteralByteString literalByteString, final int n, final int n2) {
        if (n2 > literalByteString.size()) {
            throw new IllegalArgumentException(new StringBuilder(40).append("Length too large: ").append(n2).append(this.size()).toString());
        }
        if (n + n2 > literalByteString.size()) {
            throw new IllegalArgumentException(new StringBuilder(59).append("Ran off end of other: ").append(n).append(", ").append(n2).append(", ").append(literalByteString.size()).toString());
        }
        final byte[] bytes = this.bytes;
        final byte[] bytes2 = literalByteString.bytes;
        for (int n3 = this.getOffsetIntoBytes() + n2, i = this.getOffsetIntoBytes(), n4 = literalByteString.getOffsetIntoBytes() + n; i < n3; ++i, ++n4) {
            if (bytes[i] != bytes2[n4]) {
                return false;
            }
        }
        return true;
    }
    
    public int hashCode() {
        int hash = this.hash;
        if (hash == 0) {
            final int size = this.size();
            hash = this.partialHash(size, 0, size);
            if (hash == 0) {
                hash = 1;
            }
            this.hash = hash;
        }
        return hash;
    }
    
    protected int peekCachedHashCode() {
        return this.hash;
    }
    
    protected int partialHash(final int n, final int n2, final int n3) {
        return hashCode(n, this.bytes, this.getOffsetIntoBytes() + n2, n3);
    }
    
    static int hashCode(int n, final byte[] array, final int n2, final int n3) {
        for (int i = n2; i < n2 + n3; ++i) {
            n = n * 31 + array[i];
        }
        return n;
    }
    
    static int hashCode(final byte[] array) {
        final int hashCode = hashCode(array.length, array, 0, array.length);
        return (hashCode == 0) ? 1 : hashCode;
    }
    
    public InputStream newInput() {
        return new ByteArrayInputStream(this.bytes, this.getOffsetIntoBytes(), this.size());
    }
    
    public CodedInputStream newCodedInput() {
        return CodedInputStream.newInstance(this);
    }
    
    public ByteString$ByteIterator iterator() {
        return new LiteralByteString$LiteralByteIterator(this, null);
    }
    
    protected int getTreeDepth() {
        return 0;
    }
    
    protected boolean isBalanced() {
        return true;
    }
    
    protected int getOffsetIntoBytes() {
        return 0;
    }
}
