package com.google.protobuf;

import java.util.*;

class BoundedByteString$BoundedByteIterator implements ByteString$ByteIterator
{
    private int position;
    private final int limit;
    final /* synthetic */ BoundedByteString this$0;
    
    private BoundedByteString$BoundedByteIterator(final BoundedByteString this$0) {
        this.this$0 = this$0;
        this.position = this$0.getOffsetIntoBytes();
        this.limit = this.position + this$0.size();
    }
    
    public boolean hasNext() {
        return this.position < this.limit;
    }
    
    public Byte next() {
        return this.nextByte();
    }
    
    public byte nextByte() {
        if (this.position >= this.limit) {
            throw new NoSuchElementException();
        }
        return this.this$0.bytes[this.position++];
    }
    
    public void remove() {
        throw new UnsupportedOperationException();
    }
}
