package com.google.protobuf;

import java.nio.*;
import java.nio.charset.*;
import java.io.*;
import java.util.*;

class RopeByteString extends ByteString
{
    private static final int[] minLengthByDepth;
    private final int totalLength;
    private final ByteString left;
    private final ByteString right;
    private final int leftLength;
    private final int treeDepth;
    private int hash;
    private static final long serialVersionUID = 1L;
    
    private RopeByteString(final ByteString left, final ByteString right) {
        this.hash = 0;
        this.left = left;
        this.right = right;
        this.leftLength = left.size();
        this.totalLength = this.leftLength + right.size();
        this.treeDepth = Math.max(left.getTreeDepth(), right.getTreeDepth()) + 1;
    }
    
    static ByteString concatenate(final ByteString byteString, final ByteString byteString2) {
        final RopeByteString ropeByteString = (byteString instanceof RopeByteString) ? ((RopeByteString)byteString) : null;
        ByteString byteString3;
        if (byteString2.size() == 0) {
            byteString3 = byteString;
        }
        else if (byteString.size() == 0) {
            byteString3 = byteString2;
        }
        else {
            final int n = byteString.size() + byteString2.size();
            if (n < 128) {
                byteString3 = concatenateBytes(byteString, byteString2);
            }
            else if (ropeByteString != null && ropeByteString.right.size() + byteString2.size() < 128) {
                byteString3 = new RopeByteString(ropeByteString.left, concatenateBytes(ropeByteString.right, byteString2));
            }
            else if (ropeByteString != null && ropeByteString.left.getTreeDepth() > ropeByteString.right.getTreeDepth() && ropeByteString.getTreeDepth() > byteString2.getTreeDepth()) {
                byteString3 = new RopeByteString(ropeByteString.left, new RopeByteString(ropeByteString.right, byteString2));
            }
            else if (n >= RopeByteString.minLengthByDepth[Math.max(byteString.getTreeDepth(), byteString2.getTreeDepth()) + 1]) {
                byteString3 = new RopeByteString(byteString, byteString2);
            }
            else {
                byteString3 = new RopeByteString$Balancer(null).balance(byteString, byteString2);
            }
        }
        return byteString3;
    }
    
    private static LiteralByteString concatenateBytes(final ByteString byteString, final ByteString byteString2) {
        final int size = byteString.size();
        final int size2 = byteString2.size();
        final byte[] array = new byte[size + size2];
        byteString.copyTo(array, 0, 0, size);
        byteString2.copyTo(array, 0, size, size2);
        return new LiteralByteString(array);
    }
    
    static RopeByteString newInstanceForTest(final ByteString byteString, final ByteString byteString2) {
        return new RopeByteString(byteString, byteString2);
    }
    
    public byte byteAt(final int n) {
        if (n < 0) {
            throw new ArrayIndexOutOfBoundsException(new StringBuilder(22).append("Index < 0: ").append(n).toString());
        }
        if (n > this.totalLength) {
            throw new ArrayIndexOutOfBoundsException(new StringBuilder(40).append("Index > length: ").append(n).append(", ").append(this.totalLength).toString());
        }
        byte b;
        if (n < this.leftLength) {
            b = this.left.byteAt(n);
        }
        else {
            b = this.right.byteAt(n - this.leftLength);
        }
        return b;
    }
    
    public int size() {
        return this.totalLength;
    }
    
    protected int getTreeDepth() {
        return this.treeDepth;
    }
    
    protected boolean isBalanced() {
        return this.totalLength >= RopeByteString.minLengthByDepth[this.treeDepth];
    }
    
    public ByteString substring(final int n, final int n2) {
        if (n < 0) {
            throw new IndexOutOfBoundsException(new StringBuilder(32).append("Beginning index: ").append(n).append(" < 0").toString());
        }
        if (n2 > this.totalLength) {
            throw new IndexOutOfBoundsException(new StringBuilder(36).append("End index: ").append(n2).append(" > ").append(this.totalLength).toString());
        }
        final int n3 = n2 - n;
        if (n3 < 0) {
            throw new IndexOutOfBoundsException(new StringBuilder(66).append("Beginning index larger than ending index: ").append(n).append(", ").append(n2).toString());
        }
        ByteString byteString;
        if (n3 == 0) {
            byteString = ByteString.EMPTY;
        }
        else if (n3 == this.totalLength) {
            byteString = this;
        }
        else if (n2 <= this.leftLength) {
            byteString = this.left.substring(n, n2);
        }
        else if (n >= this.leftLength) {
            byteString = this.right.substring(n - this.leftLength, n2 - this.leftLength);
        }
        else {
            byteString = new RopeByteString(this.left.substring(n), this.right.substring(0, n2 - this.leftLength));
        }
        return byteString;
    }
    
    protected void copyToInternal(final byte[] array, final int n, final int n2, final int n3) {
        if (n + n3 <= this.leftLength) {
            this.left.copyToInternal(array, n, n2, n3);
        }
        else if (n >= this.leftLength) {
            this.right.copyToInternal(array, n - this.leftLength, n2, n3);
        }
        else {
            final int n4 = this.leftLength - n;
            this.left.copyToInternal(array, n, n2, n4);
            this.right.copyToInternal(array, 0, n2 + n4, n3 - n4);
        }
    }
    
    public void copyTo(final ByteBuffer byteBuffer) {
        this.left.copyTo(byteBuffer);
        this.right.copyTo(byteBuffer);
    }
    
    public ByteBuffer asReadOnlyByteBuffer() {
        return ByteBuffer.wrap(this.toByteArray()).asReadOnlyBuffer();
    }
    
    public List asReadOnlyByteBufferList() {
        final ArrayList<ByteBuffer> list = new ArrayList<ByteBuffer>();
        final RopeByteString$PieceIterator ropeByteString$PieceIterator = new RopeByteString$PieceIterator(this, null);
        while (ropeByteString$PieceIterator.hasNext()) {
            list.add(ropeByteString$PieceIterator.next().asReadOnlyByteBuffer());
        }
        return list;
    }
    
    public void writeTo(final OutputStream outputStream) {
        this.left.writeTo(outputStream);
        this.right.writeTo(outputStream);
    }
    
    void writeToInternal(final OutputStream outputStream, final int n, final int n2) {
        if (n + n2 <= this.leftLength) {
            this.left.writeToInternal(outputStream, n, n2);
        }
        else if (n >= this.leftLength) {
            this.right.writeToInternal(outputStream, n - this.leftLength, n2);
        }
        else {
            final int n3 = this.leftLength - n;
            this.left.writeToInternal(outputStream, n, n3);
            this.right.writeToInternal(outputStream, 0, n2 - n3);
        }
    }
    
    protected String toStringInternal(final Charset charset) {
        return new String(this.toByteArray(), charset);
    }
    
    public boolean isValidUtf8() {
        return this.right.partialIsValidUtf8(this.left.partialIsValidUtf8(0, 0, this.leftLength), 0, this.right.size()) == 0;
    }
    
    protected int partialIsValidUtf8(final int n, final int n2, final int n3) {
        if (n2 + n3 <= this.leftLength) {
            return this.left.partialIsValidUtf8(n, n2, n3);
        }
        if (n2 >= this.leftLength) {
            return this.right.partialIsValidUtf8(n, n2 - this.leftLength, n3);
        }
        final int n4 = this.leftLength - n2;
        return this.right.partialIsValidUtf8(this.left.partialIsValidUtf8(n, n2, n4), 0, n3 - n4);
    }
    
    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof ByteString)) {
            return false;
        }
        final ByteString byteString = (ByteString)o;
        if (this.totalLength != byteString.size()) {
            return false;
        }
        if (this.totalLength == 0) {
            return true;
        }
        if (this.hash != 0) {
            final int peekCachedHashCode = byteString.peekCachedHashCode();
            if (peekCachedHashCode != 0 && this.hash != peekCachedHashCode) {
                return false;
            }
        }
        return this.equalsFragments(byteString);
    }
    
    private boolean equalsFragments(final ByteString byteString) {
        int n = 0;
        final RopeByteString$PieceIterator ropeByteString$PieceIterator = new RopeByteString$PieceIterator(this, null);
        LiteralByteString literalByteString = ropeByteString$PieceIterator.next();
        int n2 = 0;
        final RopeByteString$PieceIterator ropeByteString$PieceIterator2 = new RopeByteString$PieceIterator(byteString, null);
        LiteralByteString literalByteString2 = ropeByteString$PieceIterator2.next();
        int n3 = 0;
        while (true) {
            final int n4 = literalByteString.size() - n;
            final int n5 = literalByteString2.size() - n2;
            final int min = Math.min(n4, n5);
            if (!((n == 0) ? literalByteString.equalsRange(literalByteString2, n2, min) : literalByteString2.equalsRange(literalByteString, n, min))) {
                return false;
            }
            n3 += min;
            if (n3 >= this.totalLength) {
                if (n3 == this.totalLength) {
                    return true;
                }
                throw new IllegalStateException();
            }
            else {
                if (min == n4) {
                    n = 0;
                    literalByteString = ropeByteString$PieceIterator.next();
                }
                else {
                    n += min;
                }
                if (min == n5) {
                    n2 = 0;
                    literalByteString2 = ropeByteString$PieceIterator2.next();
                }
                else {
                    n2 += min;
                }
            }
        }
    }
    
    public int hashCode() {
        int hash = this.hash;
        if (hash == 0) {
            hash = this.partialHash(this.totalLength, 0, this.totalLength);
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
        if (n2 + n3 <= this.leftLength) {
            return this.left.partialHash(n, n2, n3);
        }
        if (n2 >= this.leftLength) {
            return this.right.partialHash(n, n2 - this.leftLength, n3);
        }
        final int n4 = this.leftLength - n2;
        return this.right.partialHash(this.left.partialHash(n, n2, n4), 0, n3 - n4);
    }
    
    public CodedInputStream newCodedInput() {
        return CodedInputStream.newInstance(new RopeByteString$RopeInputStream(this));
    }
    
    public InputStream newInput() {
        return new RopeByteString$RopeInputStream(this);
    }
    
    Object writeReplace() {
        return new LiteralByteString(this.toByteArray());
    }
    
    private void readObject(final ObjectInputStream objectInputStream) {
        throw new InvalidObjectException("RopeByteStream instances are not to be serialized directly");
    }
    
    public ByteString$ByteIterator iterator() {
        return new RopeByteString$RopeByteIterator(this, null);
    }
    
    static {
        final ArrayList<Integer> list = new ArrayList<Integer>();
        int n = 1;
        int n2;
        for (int i = 1; i > 0; i = n2) {
            list.add(i);
            n2 = n + i;
            n = i;
        }
        list.add(Integer.MAX_VALUE);
        minLengthByDepth = new int[list.size()];
        for (int j = 0; j < RopeByteString.minLengthByDepth.length; ++j) {
            RopeByteString.minLengthByDepth[j] = (int)list.get(j);
        }
    }
}
