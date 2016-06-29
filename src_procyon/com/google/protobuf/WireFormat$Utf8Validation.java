package com.google.protobuf;

enum WireFormat$Utf8Validation
{
    LOOSE("LOOSE", 0), 
    STRICT("STRICT", 1), 
    LAZY("LAZY", 2);
    
    private WireFormat$Utf8Validation(final String s, final int n) {
    }
    
    abstract Object readString(final CodedInputStream p0);
}
