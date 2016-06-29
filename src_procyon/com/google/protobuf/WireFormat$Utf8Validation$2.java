package com.google.protobuf;

enum WireFormat$Utf8Validation$2
{
    WireFormat$Utf8Validation$2(final String s, final int n) {
    }
    
    Object readString(final CodedInputStream codedInputStream) {
        return codedInputStream.readStringRequireUtf8();
    }
}
