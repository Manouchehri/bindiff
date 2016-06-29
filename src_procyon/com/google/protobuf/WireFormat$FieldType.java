package com.google.protobuf;

public enum WireFormat$FieldType
{
    DOUBLE("DOUBLE", 0, WireFormat$JavaType.DOUBLE, 1), 
    FLOAT("FLOAT", 1, WireFormat$JavaType.FLOAT, 5), 
    INT64("INT64", 2, WireFormat$JavaType.LONG, 0), 
    UINT64("UINT64", 3, WireFormat$JavaType.LONG, 0), 
    INT32("INT32", 4, WireFormat$JavaType.INT, 0), 
    FIXED64("FIXED64", 5, WireFormat$JavaType.LONG, 1), 
    FIXED32("FIXED32", 6, WireFormat$JavaType.INT, 5), 
    BOOL("BOOL", 7, WireFormat$JavaType.BOOLEAN, 0), 
    STRING("STRING", 8, WireFormat$JavaType.STRING, 2), 
    GROUP("GROUP", 9, WireFormat$JavaType.MESSAGE, 3), 
    MESSAGE("MESSAGE", 10, WireFormat$JavaType.MESSAGE, 2), 
    BYTES("BYTES", 11, WireFormat$JavaType.BYTE_STRING, 2), 
    UINT32("UINT32", 12, WireFormat$JavaType.INT, 0), 
    ENUM("ENUM", 13, WireFormat$JavaType.ENUM, 0), 
    SFIXED32("SFIXED32", 14, WireFormat$JavaType.INT, 5), 
    SFIXED64("SFIXED64", 15, WireFormat$JavaType.LONG, 1), 
    SINT32("SINT32", 16, WireFormat$JavaType.INT, 0), 
    SINT64("SINT64", 17, WireFormat$JavaType.LONG, 0);
    
    private final WireFormat$JavaType javaType;
    private final int wireType;
    
    private WireFormat$FieldType(final String s, final int n, final WireFormat$JavaType javaType, final int wireType) {
        this.javaType = javaType;
        this.wireType = wireType;
    }
    
    public WireFormat$JavaType getJavaType() {
        return this.javaType;
    }
    
    public int getWireType() {
        return this.wireType;
    }
    
    public boolean isPackable() {
        return true;
    }
}
