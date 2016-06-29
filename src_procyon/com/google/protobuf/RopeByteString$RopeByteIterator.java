package com.google.protobuf;

class RopeByteString$RopeByteIterator implements ByteString$ByteIterator
{
    private final RopeByteString$PieceIterator pieces;
    private ByteString$ByteIterator bytes;
    int bytesRemaining;
    final /* synthetic */ RopeByteString this$0;
    
    private RopeByteString$RopeByteIterator(final RopeByteString this$0) {
        this.this$0 = this$0;
        this.pieces = new RopeByteString$PieceIterator(this$0, null);
        this.bytes = this.pieces.next().iterator();
        this.bytesRemaining = this$0.size();
    }
    
    public boolean hasNext() {
        return this.bytesRemaining > 0;
    }
    
    public Byte next() {
        return this.nextByte();
    }
    
    public byte nextByte() {
        if (!this.bytes.hasNext()) {
            this.bytes = this.pieces.next().iterator();
        }
        --this.bytesRemaining;
        return this.bytes.nextByte();
    }
    
    public void remove() {
        throw new UnsupportedOperationException();
    }
}
