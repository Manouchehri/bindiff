package com.google.protobuf;

import java.nio.*;
import java.util.*;
import java.nio.charset.*;
import java.io.*;

class RopeByteString$PieceIterator implements Iterator
{
    private final Stack breadCrumbs;
    private LiteralByteString next;
    
    private RopeByteString$PieceIterator(final ByteString byteString) {
        this.breadCrumbs = new Stack();
        this.next = this.getLeafByLeft(byteString);
    }
    
    private LiteralByteString getLeafByLeft(final ByteString byteString) {
        ByteString access$400;
        RopeByteString ropeByteString;
        for (access$400 = byteString; access$400 instanceof RopeByteString; access$400 = ropeByteString.left) {
            ropeByteString = (RopeByteString)access$400;
            this.breadCrumbs.push(ropeByteString);
        }
        return (LiteralByteString)access$400;
    }
    
    private LiteralByteString getNextNonEmptyLeaf() {
        while (!this.breadCrumbs.isEmpty()) {
            final LiteralByteString leafByLeft = this.getLeafByLeft(this.breadCrumbs.pop().right);
            if (!leafByLeft.isEmpty()) {
                return leafByLeft;
            }
        }
        return null;
    }
    
    public boolean hasNext() {
        return this.next != null;
    }
    
    public LiteralByteString next() {
        if (this.next == null) {
            throw new NoSuchElementException();
        }
        final LiteralByteString next = this.next;
        this.next = this.getNextNonEmptyLeaf();
        return next;
    }
    
    public void remove() {
        throw new UnsupportedOperationException();
    }
}
