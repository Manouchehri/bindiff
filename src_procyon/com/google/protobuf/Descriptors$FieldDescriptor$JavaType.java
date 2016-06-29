package com.google.protobuf;

public enum Descriptors$FieldDescriptor$JavaType
{
    INT("INT", 0, (Object)0), 
    LONG("LONG", 1, (Object)0L), 
    FLOAT("FLOAT", 2, (Object)0.0f), 
    DOUBLE("DOUBLE", 3, (Object)0.0), 
    BOOLEAN("BOOLEAN", 4, (Object)false), 
    STRING("STRING", 5, (Object)""), 
    BYTE_STRING("BYTE_STRING", 6, (Object)ByteString.EMPTY), 
    ENUM("ENUM", 7, (Object)null), 
    MESSAGE("MESSAGE", 8, (Object)null);
    
    private final Object defaultDefault;
    
    private Descriptors$FieldDescriptor$JavaType(final String s, final int n, final Object defaultDefault) {
        this.defaultDefault = defaultDefault;
    }
}
