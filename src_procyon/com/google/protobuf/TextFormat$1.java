package com.google.protobuf;

final class TextFormat$1 implements TextFormat$ByteSequence
{
    final /* synthetic */ ByteString val$input;
    
    TextFormat$1(final ByteString val$input) {
        this.val$input = val$input;
    }
    
    public int size() {
        return this.val$input.size();
    }
    
    public byte byteAt(final int n) {
        return this.val$input.byteAt(n);
    }
}
