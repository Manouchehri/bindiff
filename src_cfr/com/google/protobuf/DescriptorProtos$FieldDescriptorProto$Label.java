/*
 * Decompiled with CFR 0_115.
 */
package com.google.protobuf;

import com.google.protobuf.DescriptorProtos$FieldDescriptorProto;
import com.google.protobuf.DescriptorProtos$FieldDescriptorProto$Label$1;
import com.google.protobuf.Descriptors$EnumDescriptor;
import com.google.protobuf.Descriptors$EnumValueDescriptor;
import com.google.protobuf.Internal$EnumLiteMap;
import com.google.protobuf.ProtocolMessageEnum;
import java.util.List;

public enum DescriptorProtos$FieldDescriptorProto$Label implements ProtocolMessageEnum
{
    LABEL_OPTIONAL(0, 1),
    LABEL_REQUIRED(1, 2),
    LABEL_REPEATED(2, 3);
    
    public static final int LABEL_OPTIONAL_VALUE = 1;
    public static final int LABEL_REQUIRED_VALUE = 2;
    public static final int LABEL_REPEATED_VALUE = 3;
    private static Internal$EnumLiteMap internalValueMap;
    private static final DescriptorProtos$FieldDescriptorProto$Label[] VALUES;
    private final int index;
    private final int value;

    @Override
    public final int getNumber() {
        return this.value;
    }

    public static DescriptorProtos$FieldDescriptorProto$Label valueOf(int n2) {
        switch (n2) {
            case 1: {
                return LABEL_OPTIONAL;
            }
            case 2: {
                return LABEL_REQUIRED;
            }
            case 3: {
                return LABEL_REPEATED;
            }
        }
        return null;
    }

    public static Internal$EnumLiteMap internalGetValueMap() {
        return internalValueMap;
    }

    @Override
    public final Descriptors$EnumValueDescriptor getValueDescriptor() {
        return (Descriptors$EnumValueDescriptor)DescriptorProtos$FieldDescriptorProto$Label.getDescriptor().getValues().get(this.index);
    }

    @Override
    public final Descriptors$EnumDescriptor getDescriptorForType() {
        return DescriptorProtos$FieldDescriptorProto$Label.getDescriptor();
    }

    public static final Descriptors$EnumDescriptor getDescriptor() {
        return (Descriptors$EnumDescriptor)DescriptorProtos$FieldDescriptorProto.getDescriptor().getEnumTypes().get(1);
    }

    public static DescriptorProtos$FieldDescriptorProto$Label valueOf(Descriptors$EnumValueDescriptor descriptors$EnumValueDescriptor) {
        if (descriptors$EnumValueDescriptor.getType() == DescriptorProtos$FieldDescriptorProto$Label.getDescriptor()) return VALUES[descriptors$EnumValueDescriptor.getIndex()];
        throw new IllegalArgumentException("EnumValueDescriptor is not for this type.");
    }

    private DescriptorProtos$FieldDescriptorProto$Label(int n3, int n4) {
        this.index = n3;
        this.value = n4;
    }

    static {
        internalValueMap = new DescriptorProtos$FieldDescriptorProto$Label$1();
        VALUES = DescriptorProtos$FieldDescriptorProto$Label.values();
    }
}

