/*
 * Decompiled with CFR 0_115.
 */
package com.google.protobuf;

import com.google.protobuf.BoundedByteString;
import com.google.protobuf.ByteString;
import com.google.protobuf.ByteString$ByteIterator;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.LiteralByteString$1;
import com.google.protobuf.LiteralByteString$LiteralByteIterator;
import com.google.protobuf.RopeByteString;
import com.google.protobuf.Utf8;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class LiteralByteString
extends ByteString {
    private static final long serialVersionUID = 1;
    protected final byte[] bytes;
    private int hash = 0;

    LiteralByteString(byte[] arrby) {
        this.bytes = arrby;
    }

    @Override
    public byte byteAt(int n2) {
        return this.bytes[n2];
    }

    @Override
    public int size() {
        return this.bytes.length;
    }

    @Override
    public ByteString substring(int n2, int n3) {
        if (n2 < 0) {
            int n4 = n2;
            throw new IndexOutOfBoundsException(new StringBuilder(32).append("Beginning index: ").append(n4).append(" < 0").toString());
        }
        if (n3 > this.size()) {
            int n5 = n3;
            int n6 = this.size();
            throw new IndexOutOfBoundsException(new StringBuilder(36).append("End index: ").append(n5).append(" > ").append(n6).toString());
        }
        int n7 = n3 - n2;
        if (n7 < 0) {
            int n8 = n2;
            int n9 = n3;
            throw new IndexOutOfBoundsException(new StringBuilder(66).append("Beginning index larger than ending index: ").append(n8).append(", ").append(n9).toString());
        }
        if (n7 != 0) return new BoundedByteString(this.bytes, this.getOffsetIntoBytes() + n2, n7);
        return ByteString.EMPTY;
    }

    @Override
    protected void copyToInternal(byte[] arrby, int n2, int n3, int n4) {
        System.arraycopy(this.bytes, n2, arrby, n3, n4);
    }

    @Override
    public void copyTo(ByteBuffer byteBuffer) {
        byteBuffer.put(this.bytes, this.getOffsetIntoBytes(), this.size());
    }

    @Override
    public ByteBuffer asReadOnlyByteBuffer() {
        ByteBuffer byteBuffer = ByteBuffer.wrap(this.bytes, this.getOffsetIntoBytes(), this.size());
        return byteBuffer.asReadOnlyBuffer();
    }

    @Override
    public List asReadOnlyByteBufferList() {
        ArrayList<ByteBuffer> arrayList = new ArrayList<ByteBuffer>(1);
        arrayList.add(this.asReadOnlyByteBuffer());
        return arrayList;
    }

    @Override
    public void writeTo(OutputStream outputStream) {
        outputStream.write(this.toByteArray());
    }

    @Override
    void writeToInternal(OutputStream outputStream, int n2, int n3) {
        outputStream.write(this.bytes, this.getOffsetIntoBytes() + n2, n3);
    }

    @Override
    protected String toStringInternal(Charset charset) {
        return new String(this.bytes, this.getOffsetIntoBytes(), this.size(), charset);
    }

    @Override
    public boolean isValidUtf8() {
        int n2 = this.getOffsetIntoBytes();
        return Utf8.isValidUtf8(this.bytes, n2, n2 + this.size());
    }

    @Override
    protected int partialIsValidUtf8(int n2, int n3, int n4) {
        int n5 = this.getOffsetIntoBytes() + n3;
        return Utf8.partialIsValidUtf8(n2, this.bytes, n5, n5 + n4);
    }

    @Override
    public boolean equals(Object object) {
        if (object == this) {
            return true;
        }
        if (!(object instanceof ByteString)) {
            return false;
        }
        if (this.size() != ((ByteString)object).size()) {
            return false;
        }
        if (this.size() == 0) {
            return true;
        }
        if (object instanceof LiteralByteString) {
            LiteralByteString literalByteString = (LiteralByteString)object;
            if (this.hash == 0) return this.equalsRange((LiteralByteString)object, 0, this.size());
            if (literalByteString.hash == 0) return this.equalsRange((LiteralByteString)object, 0, this.size());
            if (this.hash == literalByteString.hash) return this.equalsRange((LiteralByteString)object, 0, this.size());
            return false;
        }
        if (object instanceof RopeByteString) {
            return object.equals(this);
        }
        String string = String.valueOf(String.valueOf(object.getClass()));
        throw new IllegalArgumentException(new StringBuilder(49 + string.length()).append("Has a new type of ByteString been created? Found ").append(string).toString());
    }

    boolean equalsRange(LiteralByteString literalByteString, int n2, int n3) {
        if (n3 > literalByteString.size()) {
            int n4 = n3;
            int n5 = this.size();
            throw new IllegalArgumentException(new StringBuilder(40).append("Length too large: ").append(n4).append(n5).toString());
        }
        if (n2 + n3 > literalByteString.size()) {
            int n6 = n2;
            int n7 = n3;
            int n8 = literalByteString.size();
            throw new IllegalArgumentException(new StringBuilder(59).append("Ran off end of other: ").append(n6).append(", ").append(n7).append(", ").append(n8).toString());
        }
        byte[] arrby = this.bytes;
        byte[] arrby2 = literalByteString.bytes;
        int n9 = this.getOffsetIntoBytes() + n3;
        int n10 = this.getOffsetIntoBytes();
        int n11 = literalByteString.getOffsetIntoBytes() + n2;
        while (n10 < n9) {
            if (arrby[n10] != arrby2[n11]) {
                return false;
            }
            ++n10;
            ++n11;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int n2 = this.hash;
        if (n2 != 0) return n2;
        int n3 = this.size();
        n2 = this.partialHash(n3, 0, n3);
        if (n2 == 0) {
            n2 = 1;
        }
        this.hash = n2;
        return n2;
    }

    @Override
    protected int peekCachedHashCode() {
        return this.hash;
    }

    @Override
    protected int partialHash(int n2, int n3, int n4) {
        return LiteralByteString.hashCode(n2, this.bytes, this.getOffsetIntoBytes() + n3, n4);
    }

    static int hashCode(int n2, byte[] arrby, int n3, int n4) {
        int n5 = n3;
        while (n5 < n3 + n4) {
            n2 = n2 * 31 + arrby[n5];
            ++n5;
        }
        return n2;
    }

    static int hashCode(byte[] arrby) {
        int n2 = LiteralByteString.hashCode(arrby.length, arrby, 0, arrby.length);
        if (n2 == 0) {
            return 1;
        }
        int n3 = n2;
        return n3;
    }

    @Override
    public InputStream newInput() {
        return new ByteArrayInputStream(this.bytes, this.getOffsetIntoBytes(), this.size());
    }

    @Override
    public CodedInputStream newCodedInput() {
        return CodedInputStream.newInstance(this);
    }

    @Override
    public ByteString$ByteIterator iterator() {
        return new LiteralByteString$LiteralByteIterator(this, null);
    }

    @Override
    protected int getTreeDepth() {
        return 0;
    }

    @Override
    protected boolean isBalanced() {
        return true;
    }

    protected int getOffsetIntoBytes() {
        return 0;
    }
}

