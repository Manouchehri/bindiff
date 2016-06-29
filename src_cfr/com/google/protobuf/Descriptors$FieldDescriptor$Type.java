/*
 * Decompiled with CFR 0_115.
 */
package com.google.protobuf;

import com.google.protobuf.DescriptorProtos$FieldDescriptorProto$Type;
import com.google.protobuf.Descriptors$FieldDescriptor$JavaType;

public enum Descriptors$FieldDescriptor$Type {
    DOUBLE(Descriptors$FieldDescriptor$JavaType.DOUBLE),
    FLOAT(Descriptors$FieldDescriptor$JavaType.FLOAT),
    INT64(Descriptors$FieldDescriptor$JavaType.LONG),
    UINT64(Descriptors$FieldDescriptor$JavaType.LONG),
    INT32(Descriptors$FieldDescriptor$JavaType.INT),
    FIXED64(Descriptors$FieldDescriptor$JavaType.LONG),
    FIXED32(Descriptors$FieldDescriptor$JavaType.INT),
    BOOL(Descriptors$FieldDescriptor$JavaType.BOOLEAN),
    STRING(Descriptors$FieldDescriptor$JavaType.STRING),
    GROUP(Descriptors$FieldDescriptor$JavaType.MESSAGE),
    MESSAGE(Descriptors$FieldDescriptor$JavaType.MESSAGE),
    BYTES(Descriptors$FieldDescriptor$JavaType.BYTE_STRING),
    UINT32(Descriptors$FieldDescriptor$JavaType.INT),
    ENUM(Descriptors$FieldDescriptor$JavaType.ENUM),
    SFIXED32(Descriptors$FieldDescriptor$JavaType.INT),
    SFIXED64(Descriptors$FieldDescriptor$JavaType.LONG),
    SINT32(Descriptors$FieldDescriptor$JavaType.INT),
    SINT64(Descriptors$FieldDescriptor$JavaType.LONG);
    
    private Descriptors$FieldDescriptor$JavaType javaType;

    private Descriptors$FieldDescriptor$Type(Descriptors$FieldDescriptor$JavaType descriptors$FieldDescriptor$JavaType) {
        this.javaType = descriptors$FieldDescriptor$JavaType;
    }

    public DescriptorProtos$FieldDescriptorProto$Type toProto() {
        return DescriptorProtos$FieldDescriptorProto$Type.valueOf(this.ordinal() + 1);
    }

    public Descriptors$FieldDescriptor$JavaType getJavaType() {
        return this.javaType;
    }

    public static Descriptors$FieldDescriptor$Type valueOf(DescriptorProtos$FieldDescriptorProto$Type descriptorProtos$FieldDescriptorProto$Type) {
        return Descriptors$FieldDescriptor$Type.values()[descriptorProtos$FieldDescriptorProto$Type.getNumber() - 1];
    }
}

