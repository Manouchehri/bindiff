package com.google.protobuf;

enum WireFormat$Utf8Validation$3
{
    WireFormat$Utf8Validation$3(final String s, final int n) {
    }
    
    Object readString(final CodedInputStream codedInputStream) {
        return codedInputStream.readBytes();
    }
}
