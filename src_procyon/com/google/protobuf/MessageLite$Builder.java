package com.google.protobuf;

import java.io.*;

public interface MessageLite$Builder extends MessageLiteOrBuilder, Cloneable
{
    MessageLite$Builder clear();
    
    MessageLite build();
    
    MessageLite buildPartial();
    
    MessageLite$Builder clone();
    
    MessageLite$Builder mergeFrom(final CodedInputStream p0);
    
    MessageLite$Builder mergeFrom(final CodedInputStream p0, final ExtensionRegistryLite p1);
    
    MessageLite$Builder mergeFrom(final ByteString p0);
    
    MessageLite$Builder mergeFrom(final ByteString p0, final ExtensionRegistryLite p1);
    
    MessageLite$Builder mergeFrom(final byte[] p0);
    
    MessageLite$Builder mergeFrom(final byte[] p0, final int p1, final int p2);
    
    MessageLite$Builder mergeFrom(final byte[] p0, final ExtensionRegistryLite p1);
    
    MessageLite$Builder mergeFrom(final byte[] p0, final int p1, final int p2, final ExtensionRegistryLite p3);
    
    MessageLite$Builder mergeFrom(final InputStream p0);
    
    MessageLite$Builder mergeFrom(final InputStream p0, final ExtensionRegistryLite p1);
    
    boolean mergeDelimitedFrom(final InputStream p0);
    
    boolean mergeDelimitedFrom(final InputStream p0, final ExtensionRegistryLite p1);
}
