package com.google.protobuf;

import java.io.*;

class RopeByteString$RopeInputStream extends InputStream
{
    private RopeByteString$PieceIterator pieceIterator;
    private LiteralByteString currentPiece;
    private int currentPieceSize;
    private int currentPieceIndex;
    private int currentPieceOffsetInRope;
    private int mark;
    final /* synthetic */ RopeByteString this$0;
    
    public RopeByteString$RopeInputStream(final RopeByteString this$0) {
        this.this$0 = this$0;
        this.initialize();
    }
    
    public int read(final byte[] array, final int n, final int n2) {
        if (array == null) {
            throw new NullPointerException();
        }
        if (n < 0 || n2 < 0 || n2 > array.length - n) {
            throw new IndexOutOfBoundsException();
        }
        return this.readSkipInternal(array, n, n2);
    }
    
    public long skip(long n) {
        if (n < 0L) {
            throw new IndexOutOfBoundsException();
        }
        if (n > 2147483647L) {
            n = 2147483647L;
        }
        return this.readSkipInternal(null, 0, (int)n);
    }
    
    private int readSkipInternal(final byte[] array, int n, final int n2) {
        int i = n2;
        while (i > 0) {
            this.advanceIfCurrentPieceFullyRead();
            if (this.currentPiece == null) {
                if (i == n2) {
                    return -1;
                }
                break;
            }
            else {
                final int min = Math.min(this.currentPieceSize - this.currentPieceIndex, i);
                if (array != null) {
                    this.currentPiece.copyTo(array, this.currentPieceIndex, n, min);
                    n += min;
                }
                this.currentPieceIndex += min;
                i -= min;
            }
        }
        return n2 - i;
    }
    
    public int read() {
        this.advanceIfCurrentPieceFullyRead();
        if (this.currentPiece == null) {
            return -1;
        }
        return this.currentPiece.byteAt(this.currentPieceIndex++) & 0xFF;
    }
    
    public int available() {
        return this.this$0.size() - (this.currentPieceOffsetInRope + this.currentPieceIndex);
    }
    
    public boolean markSupported() {
        return true;
    }
    
    public void mark(final int n) {
        this.mark = this.currentPieceOffsetInRope + this.currentPieceIndex;
    }
    
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
        if (this.currentPiece != null && this.currentPieceIndex == this.currentPieceSize) {
            this.currentPieceOffsetInRope += this.currentPieceSize;
            this.currentPieceIndex = 0;
            if (this.pieceIterator.hasNext()) {
                this.currentPiece = this.pieceIterator.next();
                this.currentPieceSize = this.currentPiece.size();
            }
            else {
                this.currentPiece = null;
                this.currentPieceSize = 0;
            }
        }
    }
}
