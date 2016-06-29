package com.google.protobuf;

final class ByteString$CodedBuilder
{
    private final CodedOutputStream output;
    private final byte[] buffer;
    
    private ByteString$CodedBuilder(final int n) {
        this.buffer = new byte[n];
        this.output = CodedOutputStream.newInstance(this.buffer);
    }
    
    public ByteString build() {
        this.output.checkNoSpaceLeft();
        return new LiteralByteString(this.buffer);
    }
    
    public CodedOutputStream getCodedOutput() {
        return this.output;
    }
}
