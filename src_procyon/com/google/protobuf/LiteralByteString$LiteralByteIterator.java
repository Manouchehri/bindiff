package com.google.protobuf;

import java.util.*;

class LiteralByteString$LiteralByteIterator implements ByteString$ByteIterator
{
    private int position;
    private final int limit;
    final /* synthetic */ LiteralByteString this$0;
    
    private LiteralByteString$LiteralByteIterator(final LiteralByteString this$0) {
        this.this$0 = this$0;
        this.position = 0;
        this.limit = this$0.size();
    }
    
    public boolean hasNext() {
        return this.position < this.limit;
    }
    
    public Byte next() {
        return this.nextByte();
    }
    
    public byte nextByte() {
        try {
            return this.this$0.bytes[this.position++];
        }
        catch (ArrayIndexOutOfBoundsException ex) {
            throw new NoSuchElementException(ex.getMessage());
        }
    }
    
    public void remove() {
        throw new UnsupportedOperationException();
    }
}
