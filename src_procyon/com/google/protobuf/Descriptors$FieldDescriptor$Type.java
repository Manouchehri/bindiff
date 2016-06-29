package com.google.protobuf;

public enum Descriptors$FieldDescriptor$Type
{
    DOUBLE("DOUBLE", 0, Descriptors$FieldDescriptor$JavaType.DOUBLE), 
    FLOAT("FLOAT", 1, Descriptors$FieldDescriptor$JavaType.FLOAT), 
    INT64("INT64", 2, Descriptors$FieldDescriptor$JavaType.LONG), 
    UINT64("UINT64", 3, Descriptors$FieldDescriptor$JavaType.LONG), 
    INT32("INT32", 4, Descriptors$FieldDescriptor$JavaType.INT), 
    FIXED64("FIXED64", 5, Descriptors$FieldDescriptor$JavaType.LONG), 
    FIXED32("FIXED32", 6, Descriptors$FieldDescriptor$JavaType.INT), 
    BOOL("BOOL", 7, Descriptors$FieldDescriptor$JavaType.BOOLEAN), 
    STRING("STRING", 8, Descriptors$FieldDescriptor$JavaType.STRING), 
    GROUP("GROUP", 9, Descriptors$FieldDescriptor$JavaType.MESSAGE), 
    MESSAGE("MESSAGE", 10, Descriptors$FieldDescriptor$JavaType.MESSAGE), 
    BYTES("BYTES", 11, Descriptors$FieldDescriptor$JavaType.BYTE_STRING), 
    UINT32("UINT32", 12, Descriptors$FieldDescriptor$JavaType.INT), 
    ENUM("ENUM", 13, Descriptors$FieldDescriptor$JavaType.ENUM), 
    SFIXED32("SFIXED32", 14, Descriptors$FieldDescriptor$JavaType.INT), 
    SFIXED64("SFIXED64", 15, Descriptors$FieldDescriptor$JavaType.LONG), 
    SINT32("SINT32", 16, Descriptors$FieldDescriptor$JavaType.INT), 
    SINT64("SINT64", 17, Descriptors$FieldDescriptor$JavaType.LONG);
    
    private Descriptors$FieldDescriptor$JavaType javaType;
    
    private Descriptors$FieldDescriptor$Type(final String s, final int n, final Descriptors$FieldDescriptor$JavaType javaType) {
        this.javaType = javaType;
    }
    
    public DescriptorProtos$FieldDescriptorProto$Type toProto() {
        return DescriptorProtos$FieldDescriptorProto$Type.valueOf(this.ordinal() + 1);
    }
    
    public Descriptors$FieldDescriptor$JavaType getJavaType() {
        return this.javaType;
    }
    
    public static Descriptors$FieldDescriptor$Type valueOf(final DescriptorProtos$FieldDescriptorProto$Type descriptorProtos$FieldDescriptorProto$Type) {
        return values()[descriptorProtos$FieldDescriptorProto$Type.getNumber() - 1];
    }
}
