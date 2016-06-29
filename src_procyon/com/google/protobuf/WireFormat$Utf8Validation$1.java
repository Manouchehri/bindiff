package com.google.protobuf;

enum WireFormat$Utf8Validation$1
{
    WireFormat$Utf8Validation$1(final String s, final int n) {
    }
    
    Object readString(final CodedInputStream codedInputStream) {
        return codedInputStream.readString();
    }
}
