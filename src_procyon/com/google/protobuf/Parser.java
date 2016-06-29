package com.google.protobuf;

import java.io.*;

public interface Parser
{
    Object parseFrom(final CodedInputStream p0);
    
    Object parseFrom(final CodedInputStream p0, final ExtensionRegistryLite p1);
    
    Object parsePartialFrom(final CodedInputStream p0);
    
    Object parsePartialFrom(final CodedInputStream p0, final ExtensionRegistryLite p1);
    
    Object parseFrom(final ByteString p0);
    
    Object parseFrom(final ByteString p0, final ExtensionRegistryLite p1);
    
    Object parsePartialFrom(final ByteString p0);
    
    Object parsePartialFrom(final ByteString p0, final ExtensionRegistryLite p1);
    
    Object parseFrom(final byte[] p0, final int p1, final int p2);
    
    Object parseFrom(final byte[] p0, final int p1, final int p2, final ExtensionRegistryLite p3);
    
    Object parseFrom(final byte[] p0);
    
    Object parseFrom(final byte[] p0, final ExtensionRegistryLite p1);
    
    Object parsePartialFrom(final byte[] p0, final int p1, final int p2);
    
    Object parsePartialFrom(final byte[] p0, final int p1, final int p2, final ExtensionRegistryLite p3);
    
    Object parsePartialFrom(final byte[] p0);
    
    Object parsePartialFrom(final byte[] p0, final ExtensionRegistryLite p1);
    
    Object parseFrom(final InputStream p0);
    
    Object parseFrom(final InputStream p0, final ExtensionRegistryLite p1);
    
    Object parsePartialFrom(final InputStream p0);
    
    Object parsePartialFrom(final InputStream p0, final ExtensionRegistryLite p1);
    
    Object parseDelimitedFrom(final InputStream p0);
    
    Object parseDelimitedFrom(final InputStream p0, final ExtensionRegistryLite p1);
    
    Object parsePartialDelimitedFrom(final InputStream p0);
    
    Object parsePartialDelimitedFrom(final InputStream p0, final ExtensionRegistryLite p1);
}
