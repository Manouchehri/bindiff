package com.google.protobuf;

import java.io.*;

public interface MessageLite extends MessageLiteOrBuilder
{
    void writeTo(final CodedOutputStream p0);
    
    int getSerializedSize();
    
    Parser getParserForType();
    
    ByteString toByteString();
    
    byte[] toByteArray();
    
    void writeTo(final OutputStream p0);
    
    void writeDelimitedTo(final OutputStream p0);
    
    MessageLite$Builder newBuilderForType();
    
    MessageLite$Builder toBuilder();
}
