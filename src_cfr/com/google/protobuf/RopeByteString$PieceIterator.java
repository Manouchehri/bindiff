/*
 * Decompiled with CFR 0_115.
 */
package com.google.protobuf;

import com.google.protobuf.ByteString;
import com.google.protobuf.LiteralByteString;
import com.google.protobuf.RopeByteString;
import com.google.protobuf.RopeByteString$1;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Stack;

class RopeByteString$PieceIterator
implements Iterator {
    private final Stack breadCrumbs = new Stack();
    private LiteralByteString next;

    private RopeByteString$PieceIterator(ByteString byteString) {
        this.next = this.getLeafByLeft(byteString);
    }

    private LiteralByteString getLeafByLeft(ByteString byteString) {
        ByteString byteString2 = byteString;
        while (byteString2 instanceof RopeByteString) {
            RopeByteString ropeByteString = (RopeByteString)byteString2;
            this.breadCrumbs.push(ropeByteString);
            byteString2 = RopeByteString.access$400(ropeByteString);
        }
        return (LiteralByteString)byteString2;
    }

    private LiteralByteString getNextNonEmptyLeaf() {
        LiteralByteString literalByteString;
        do {
            if (!this.breadCrumbs.isEmpty()) continue;
            return null;
        } while ((literalByteString = this.getLeafByLeft(RopeByteString.access$500((RopeByteString)this.breadCrumbs.pop()))).isEmpty());
        return literalByteString;
    }

    @Override
    public boolean hasNext() {
        if (this.next == null) return false;
        return true;
    }

    public LiteralByteString next() {
        if (this.next == null) {
            throw new NoSuchElementException();
        }
        LiteralByteString literalByteString = this.next;
        this.next = this.getNextNonEmptyLeaf();
        return literalByteString;
    }

    @Override
    public void remove() {
        throw new UnsupportedOperationException();
    }

    /* synthetic */ RopeByteString$PieceIterator(ByteString byteString, RopeByteString$1 ropeByteString$1) {
        this(byteString);
    }
}

