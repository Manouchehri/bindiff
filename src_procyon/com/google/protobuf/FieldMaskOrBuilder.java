package com.google.protobuf;

public interface FieldMaskOrBuilder extends MessageOrBuilder
{
    ProtocolStringList getPathsList();
    
    int getPathsCount();
    
    String getPaths(final int p0);
    
    ByteString getPathsBytes(final int p0);
}
