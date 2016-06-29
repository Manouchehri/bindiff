package com.google.protobuf;

public interface FieldSet$FieldDescriptorLite extends Comparable
{
    int getNumber();
    
    WireFormat$FieldType getLiteType();
    
    WireFormat$JavaType getLiteJavaType();
    
    boolean isRepeated();
    
    boolean isPacked();
    
    Internal$EnumLiteMap getEnumType();
    
    MessageLite$Builder internalMergeFrom(final MessageLite$Builder p0, final MessageLite p1);
}
