package com.google.protobuf;

public interface ValueOrBuilder extends MessageOrBuilder
{
    int getNullValueValue();
    
    NullValue getNullValue();
    
    double getNumberValue();
    
    String getStringValue();
    
    ByteString getStringValueBytes();
    
    boolean getBoolValue();
    
    Struct getStructValue();
    
    StructOrBuilder getStructValueOrBuilder();
    
    ListValue getListValue();
    
    ListValueOrBuilder getListValueOrBuilder();
}
