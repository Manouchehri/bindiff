package com.google.protobuf;

final class TextFormat$2 implements TextFormat$ByteSequence
{
    final /* synthetic */ byte[] val$input;
    
    TextFormat$2(final byte[] val$input) {
        this.val$input = val$input;
    }
    
    public int size() {
        return this.val$input.length;
    }
    
    public byte byteAt(final int n) {
        return this.val$input[n];
    }
}
