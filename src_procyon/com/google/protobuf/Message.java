package com.google.protobuf;

public interface Message extends MessageLite, MessageOrBuilder
{
    Parser getParserForType();
    
    boolean equals(final Object p0);
    
    int hashCode();
    
    String toString();
    
    Message$Builder newBuilderForType();
    
    Message$Builder toBuilder();
}
