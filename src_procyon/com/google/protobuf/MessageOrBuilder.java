package com.google.protobuf;

import java.util.*;

public interface MessageOrBuilder extends MessageLiteOrBuilder
{
    Message getDefaultInstanceForType();
    
    List findInitializationErrors();
    
    String getInitializationErrorString();
    
    Descriptors$Descriptor getDescriptorForType();
    
    Map getAllFields();
    
    boolean hasOneof(final Descriptors$OneofDescriptor p0);
    
    Descriptors$FieldDescriptor getOneofFieldDescriptor(final Descriptors$OneofDescriptor p0);
    
    boolean hasField(final Descriptors$FieldDescriptor p0);
    
    Object getField(final Descriptors$FieldDescriptor p0);
    
    int getRepeatedFieldCount(final Descriptors$FieldDescriptor p0);
    
    Object getRepeatedField(final Descriptors$FieldDescriptor p0, final int p1);
    
    UnknownFieldSet getUnknownFields();
}
