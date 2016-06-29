/*
 * Decompiled with CFR 0_115.
 */
package com.google.protobuf;

import com.google.protobuf.ByteString;
import com.google.protobuf.ByteString$ByteIterator;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.LiteralByteString;
import com.google.protobuf.RopeByteString$1;
import com.google.protobuf.RopeByteString$Balancer;
import com.google.protobuf.RopeByteString$PieceIterator;
import com.google.protobuf.RopeByteString$RopeByteIterator;
import com.google.protobuf.RopeByteString$RopeInputStream;
import java.io.InputStream;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class RopeByteString
extends ByteString {
    private static final int[] minLengthByDepth;
    private final int totalLength;
    private final ByteString left;
    private final ByteString right;
    private final int leftLength;
    private final int treeDepth;
    private int hash = 0;
    private static final long serialVersionUID = 1;

    private RopeByteString(ByteString byteString, ByteString byteString2) {
        this.left = byteString;
        this.right = byteString2;
        this.leftLength = byteString.size();
        this.totalLength = this.leftLength + byteString2.size();
        this.treeDepth = Math.max(byteString.getTreeDepth(), byteString2.getTreeDepth()) + 1;
    }

    static ByteString concatenate(ByteString byteString, ByteString byteString2) {
        RopeByteString ropeByteString;
        RopeByteString ropeByteString2 = ropeByteString = byteString instanceof RopeByteString ? (RopeByteString)byteString : null;
        if (byteString2.size() == 0) {
            return byteString;
        }
        if (byteString.size() == 0) {
            return byteString2;
        }
        int n2 = byteString.size() + byteString2.size();
        if (n2 < 128) {
            return RopeByteString.concatenateBytes(byteString, byteString2);
        }
        if (ropeByteString != null && ropeByteString.right.size() + byteString2.size() < 128) {
            LiteralByteString literalByteString = RopeByteString.concatenateBytes(ropeByteString.right, byteString2);
            return new RopeByteString(ropeByteString.left, literalByteString);
        }
        if (ropeByteString != null && ropeByteString.left.getTreeDepth() > ropeByteString.right.getTreeDepth() && ropeByteString.getTreeDepth() > byteString2.getTreeDepth()) {
            RopeByteString ropeByteString3 = new RopeByteString(ropeByteString.right, byteString2);
            return new RopeByteString(ropeByteString.left, ropeByteString3);
        }
        int n3 = Math.max(byteString.getTreeDepth(), byteString2.getTreeDepth()) + 1;
        if (n2 < minLengthByDepth[n3]) return RopeByteString$Balancer.access$100(new RopeByteString$Balancer(null), byteString, byteString2);
        return new RopeByteString(byteString, byteString2);
    }

    private static LiteralByteString concatenateBytes(ByteString byteString, ByteString byteString2) {
        int n2 = byteString.size();
        int n3 = byteString2.size();
        byte[] arrby = new byte[n2 + n3];
        byteString.copyTo(arrby, 0, 0, n2);
        byteString2.copyTo(arrby, 0, n2, n3);
        return new LiteralByteString(arrby);
    }

    static RopeByteString newInstanceForTest(ByteString byteString, ByteString byteString2) {
        return new RopeByteString(byteString, byteString2);
    }

    @Override
    public byte byteAt(int n2) {
        if (n2 < 0) {
            int n3 = n2;
            throw new ArrayIndexOutOfBoundsException(new StringBuilder(22).append("Index < 0: ").append(n3).toString());
        }
        if (n2 > this.totalLength) {
            int n4 = n2;
            int n5 = this.totalLength;
            throw new ArrayIndexOutOfBoundsException(new StringBuilder(40).append("Index > length: ").append(n4).append(", ").append(n5).toString());
        }
        if (n2 >= this.leftLength) return this.right.byteAt(n2 - this.leftLength);
        return this.left.byteAt(n2);
    }

    @Override
    public int size() {
        return this.totalLength;
    }

    @Override
    protected int getTreeDepth() {
        return this.treeDepth;
    }

    @Override
    protected boolean isBalanced() {
        if (this.totalLength < minLengthByDepth[this.treeDepth]) return false;
        return true;
    }

    @Override
    public ByteString substring(int n2, int n3) {
        if (n2 < 0) {
            int n4 = n2;
            throw new IndexOutOfBoundsException(new StringBuilder(32).append("Beginning index: ").append(n4).append(" < 0").toString());
        }
        if (n3 > this.totalLength) {
            int n5 = n3;
            int n6 = this.totalLength;
            throw new IndexOutOfBoundsException(new StringBuilder(36).append("End index: ").append(n5).append(" > ").append(n6).toString());
        }
        int n7 = n3 - n2;
        if (n7 < 0) {
            int n8 = n2;
            int n9 = n3;
            throw new IndexOutOfBoundsException(new StringBuilder(66).append("Beginning index larger than ending index: ").append(n8).append(", ").append(n9).toString());
        }
        if (n7 == 0) {
            return ByteString.EMPTY;
        }
        if (n7 == this.totalLength) {
            return this;
        }
        if (n3 <= this.leftLength) {
            return this.left.substring(n2, n3);
        }
        if (n2 >= this.leftLength) {
            return this.right.substring(n2 - this.leftLength, n3 - this.leftLength);
        }
        ByteString byteString = this.left.substring(n2);
        ByteString byteString2 = this.right.substring(0, n3 - this.leftLength);
        return new RopeByteString(byteString, byteString2);
    }

    @Override
    protected void copyToInternal(byte[] arrby, int n2, int n3, int n4) {
        if (n2 + n4 <= this.leftLength) {
            this.left.copyToInternal(arrby, n2, n3, n4);
            return;
        }
        if (n2 >= this.leftLength) {
            this.right.copyToInternal(arrby, n2 - this.leftLength, n3, n4);
            return;
        }
        int n5 = this.leftLength - n2;
        this.left.copyToInternal(arrby, n2, n3, n5);
        this.right.copyToInternal(arrby, 0, n3 + n5, n4 - n5);
    }

    @Override
    public void copyTo(ByteBuffer byteBuffer) {
        this.left.copyTo(byteBuffer);
        this.right.copyTo(byteBuffer);
    }

    @Override
    public ByteBuffer asReadOnlyByteBuffer() {
        ByteBuffer byteBuffer = ByteBuffer.wrap(this.toByteArray());
        return byteBuffer.asReadOnlyBuffer();
    }

    @Override
    public List asReadOnlyByteBufferList() {
        ArrayList<ByteBuffer> arrayList = new ArrayList<ByteBuffer>();
        RopeByteString$PieceIterator ropeByteString$PieceIterator = new RopeByteString$PieceIterator(this, null);
        while (ropeByteString$PieceIterator.hasNext()) {
            LiteralByteString literalByteString = ropeByteString$PieceIterator.next();
            arrayList.add(literalByteString.asReadOnlyByteBuffer());
        }
        return arrayList;
    }

    @Override
    public void writeTo(OutputStream outputStream) {
        this.left.writeTo(outputStream);
        this.right.writeTo(outputStream);
    }

    @Override
    void writeToInternal(OutputStream outputStream, int n2, int n3) {
        if (n2 + n3 <= this.leftLength) {
            this.left.writeToInternal(outputStream, n2, n3);
            return;
        }
        if (n2 >= this.leftLength) {
            this.right.writeToInternal(outputStream, n2 - this.leftLength, n3);
            return;
        }
        int n4 = this.leftLength - n2;
        this.left.writeToInternal(outputStream, n2, n4);
        this.right.writeToInternal(outputStream, 0, n3 - n4);
    }

    @Override
    protected String toStringInternal(Charset charset) {
        return new String(this.toByteArray(), charset);
    }

    @Override
    public boolean isValidUtf8() {
        int n2 = this.left.partialIsValidUtf8(0, 0, this.leftLength);
        int n3 = this.right.partialIsValidUtf8(n2, 0, this.right.size());
        if (n3 != 0) return false;
        return true;
    }

    @Override
    protected int partialIsValidUtf8(int n2, int n3, int n4) {
        int n5 = n3 + n4;
        if (n5 <= this.leftLength) {
            return this.left.partialIsValidUtf8(n2, n3, n4);
        }
        if (n3 >= this.leftLength) {
            return this.right.partialIsValidUtf8(n2, n3 - this.leftLength, n4);
        }
        int n6 = this.leftLength - n3;
        int n7 = this.left.partialIsValidUtf8(n2, n3, n6);
        return this.right.partialIsValidUtf8(n7, 0, n4 - n6);
    }

    @Override
    public boolean equals(Object object) {
        if (object == this) {
            return true;
        }
        if (!(object instanceof ByteString)) {
            return false;
        }
        ByteString byteString = (ByteString)object;
        if (this.totalLength != byteString.size()) {
            return false;
        }
        if (this.totalLength == 0) {
            return true;
        }
        if (this.hash == 0) return this.equalsFragments(byteString);
        int n2 = byteString.peekCachedHashCode();
        if (n2 == 0) return this.equalsFragments(byteString);
        if (this.hash == n2) return this.equalsFragments(byteString);
        return false;
    }

    private boolean equalsFragments(ByteString byteString) {
        int n2 = 0;
        RopeByteString$PieceIterator ropeByteString$PieceIterator = new RopeByteString$PieceIterator(this, null);
        LiteralByteString literalByteString = (LiteralByteString)ropeByteString$PieceIterator.next();
        int n3 = 0;
        RopeByteString$PieceIterator ropeByteString$PieceIterator2 = new RopeByteString$PieceIterator(byteString, null);
        LiteralByteString literalByteString2 = (LiteralByteString)ropeByteString$PieceIterator2.next();
        int n4 = 0;
        do {
            boolean bl2;
            int n5 = literalByteString.size() - n2;
            int n6 = literalByteString2.size() - n3;
            int n7 = Math.min(n5, n6);
            boolean bl3 = bl2 = n2 == 0 ? literalByteString.equalsRange(literalByteString2, n3, n7) : literalByteString2.equalsRange(literalByteString, n2, n7);
            if (!bl2) {
                return false;
            }
            if ((n4 += n7) >= this.totalLength) {
                if (n4 != this.totalLength) throw new IllegalStateException();
                return true;
            }
            if (n7 == n5) {
                n2 = 0;
                literalByteString = (LiteralByteString)ropeByteString$PieceIterator.next();
            } else {
                n2 += n7;
            }
            if (n7 == n6) {
                n3 = 0;
                literalByteString2 = (LiteralByteString)ropeByteString$PieceIterator2.next();
                continue;
            }
            n3 += n7;
        } while (true);
    }

    @Override
    public int hashCode() {
        int n2 = this.hash;
        if (n2 != 0) return n2;
        n2 = this.totalLength;
        if ((n2 = this.partialHash(n2, 0, this.totalLength)) == 0) {
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
        int n5 = n3 + n4;
        if (n5 <= this.leftLength) {
            return this.left.partialHash(n2, n3, n4);
        }
        if (n3 >= this.leftLength) {
            return this.right.partialHash(n2, n3 - this.leftLength, n4);
        }
        int n6 = this.leftLength - n3;
        int n7 = this.left.partialHash(n2, n3, n6);
        return this.right.partialHash(n7, 0, n4 - n6);
    }

    @Override
    public CodedInputStream newCodedInput() {
        return CodedInputStream.newInstance(new RopeByteString$RopeInputStream(this));
    }

    @Override
    public InputStream newInput() {
        return new RopeByteString$RopeInputStream(this);
    }

    Object writeReplace() {
        return new LiteralByteString(this.toByteArray());
    }

    private void readObject(ObjectInputStream objectInputStream) {
        throw new InvalidObjectException("RopeByteStream instances are not to be serialized directly");
    }

    @Override
    public ByteString$ByteIterator iterator() {
        return new RopeByteString$RopeByteIterator(this, null);
    }

    /* synthetic */ RopeByteString(ByteString byteString, ByteString byteString2, RopeByteString$1 ropeByteString$1) {
        this(byteString, byteString2);
    }

    static /* synthetic */ ByteString access$400(RopeByteString ropeByteString) {
        return ropeByteString.left;
    }

    static /* synthetic */ ByteString access$500(RopeByteString ropeByteString) {
        return ropeByteString.right;
    }

    static /* synthetic */ int[] access$600() {
        return minLengthByDepth;
    }

    static {
        int n2;
        ArrayList<Integer> arrayList = new ArrayList<Integer>();
        int n3 = 1;
        int n4 = 1;
        while (n4 > 0) {
            arrayList.add(n4);
            n2 = n3 + n4;
            n3 = n4;
            n4 = n2;
        }
        arrayList.add(Integer.MAX_VALUE);
        minLengthByDepth = new int[arrayList.size()];
        n2 = 0;
        while (n2 < minLengthByDepth.length) {
            RopeByteString.minLengthByDepth[n2] = (Integer)arrayList.get(n2);
            ++n2;
        }
    }
}

