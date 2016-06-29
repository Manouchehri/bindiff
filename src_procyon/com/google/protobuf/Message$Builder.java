package com.google.protobuf;

import java.io.*;

public interface Message$Builder extends MessageLite$Builder, MessageOrBuilder
{
    Message$Builder clear();
    
    Message$Builder mergeFrom(final Message p0);
    
    Message build();
    
    Message buildPartial();
    
    Message$Builder clone();
    
    Message$Builder mergeFrom(final CodedInputStream p0);
    
    Message$Builder mergeFrom(final CodedInputStream p0, final ExtensionRegistryLite p1);
    
    Descriptors$Descriptor getDescriptorForType();
    
    Message$Builder newBuilderForField(final Descriptors$FieldDescriptor p0);
    
    Message$Builder getFieldBuilder(final Descriptors$FieldDescriptor p0);
    
    Message$Builder getRepeatedFieldBuilder(final Descriptors$FieldDescriptor p0, final int p1);
    
    Message$Builder setField(final Descriptors$FieldDescriptor p0, final Object p1);
    
    Message$Builder clearField(final Descriptors$FieldDescriptor p0);
    
    Message$Builder clearOneof(final Descriptors$OneofDescriptor p0);
    
    Message$Builder setRepeatedField(final Descriptors$FieldDescriptor p0, final int p1, final Object p2);
    
    Message$Builder addRepeatedField(final Descriptors$FieldDescriptor p0, final Object p1);
    
    Message$Builder setUnknownFields(final UnknownFieldSet p0);
    
    Message$Builder mergeUnknownFields(final UnknownFieldSet p0);
    
    Message$Builder mergeFrom(final ByteString p0);
    
    Message$Builder mergeFrom(final ByteString p0, final ExtensionRegistryLite p1);
    
    Message$Builder mergeFrom(final byte[] p0);
    
    Message$Builder mergeFrom(final byte[] p0, final int p1, final int p2);
    
    Message$Builder mergeFrom(final byte[] p0, final ExtensionRegistryLite p1);
    
    Message$Builder mergeFrom(final byte[] p0, final int p1, final int p2, final ExtensionRegistryLite p3);
    
    Message$Builder mergeFrom(final InputStream p0);
    
    Message$Builder mergeFrom(final InputStream p0, final ExtensionRegistryLite p1);
    
    boolean mergeDelimitedFrom(final InputStream p0);
    
    boolean mergeDelimitedFrom(final InputStream p0, final ExtensionRegistryLite p1);
}
