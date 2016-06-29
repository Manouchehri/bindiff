/*
 * Decompiled with CFR 0_115.
 */
package com.google.protobuf;

import com.google.protobuf.ByteString;
import com.google.protobuf.LiteralByteString;
import com.google.protobuf.RopeByteString;
import com.google.protobuf.RopeByteString$1;
import com.google.protobuf.RopeByteString$PieceIterator;
import java.io.InputStream;

class RopeByteString$RopeInputStream
extends InputStream {
    private RopeByteString$PieceIterator pieceIterator;
    private LiteralByteString currentPiece;
    private int currentPieceSize;
    private int currentPieceIndex;
    private int currentPieceOffsetInRope;
    private int mark;
    final /* synthetic */ RopeByteString this$0;

    public RopeByteString$RopeInputStream(RopeByteString ropeByteString) {
        this.this$0 = ropeByteString;
        this.initialize();
    }

    @Override
    public int read(byte[] arrby, int n2, int n3) {
        if (arrby == null) {
            throw new NullPointerException();
        }
        if (n2 < 0) throw new IndexOutOfBoundsException();
        if (n3 < 0) throw new IndexOutOfBoundsException();
        if (n3 <= arrby.length - n2) return this.readSkipInternal(arrby, n2, n3);
        throw new IndexOutOfBoundsException();
    }

    @Override
    public long skip(long l2) {
        if (l2 < 0) {
            throw new IndexOutOfBoundsException();
        }
        if (l2 <= Integer.MAX_VALUE) return this.readSkipInternal(null, 0, (int)l2);
        l2 = Integer.MAX_VALUE;
        return this.readSkipInternal(null, 0, (int)l2);
    }

    private int readSkipInternal(byte[] arrby, int n2, int n3) {
        int n4 = n3;
        while (n4 > 0) {
            this.advanceIfCurrentPieceFullyRead();
            if (this.currentPiece == null) {
                if (n4 != n3) return n3 - n4;
                return -1;
            }
            int n5 = this.currentPieceSize - this.currentPieceIndex;
            int n6 = Math.min(n5, n4);
            if (arrby != null) {
                this.currentPiece.copyTo(arrby, this.currentPieceIndex, n2, n6);
                n2 += n6;
            }
            this.currentPieceIndex += n6;
            n4 -= n6;
        }
        return n3 - n4;
    }

    @Override
    public int read() {
        this.advanceIfCurrentPieceFullyRead();
        if (this.currentPiece != null) return this.currentPiece.byteAt(this.currentPieceIndex++) & 255;
        return -1;
    }

    @Override
    public int available() {
        int n2 = this.currentPieceOffsetInRope + this.currentPieceIndex;
        return this.this$0.size() - n2;
    }

    @Override
    public boolean markSupported() {
        return true;
    }

    @Override
    public void mark(int n2) {
        this.mark = this.currentPieceOffsetInRope + this.currentPieceIndex;
    }

    @Override
    public synchronized void reset() {
        this.initialize();
        this.readSkipInternal(null, 0, this.mark);
    }

    private void initialize() {
        this.pieceIterator = new RopeByteString$PieceIterator(this.this$0, null);
        this.currentPiece = this.pieceIterator.next();
        this.currentPieceSize = this.currentPiece.size();
        this.currentPieceIndex = 0;
        this.currentPieceOffsetInRope = 0;
    }

    private void advanceIfCurrentPieceFullyRead() {
        if (this.currentPiece == null) return;
        if (this.currentPieceIndex != this.currentPieceSize) return;
        this.currentPieceOffsetInRope += this.currentPieceSize;
        this.currentPieceIndex = 0;
        if (this.pieceIterator.hasNext()) {
            this.currentPiece = this.pieceIterator.next();
            this.currentPieceSize = this.currentPiece.size();
            return;
        }
        this.currentPiece = null;
        this.currentPieceSize = 0;
    }
}

