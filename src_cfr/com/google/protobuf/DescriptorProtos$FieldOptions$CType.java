/*
 * Decompiled with CFR 0_115.
 */
package com.google.protobuf;

import com.google.protobuf.DescriptorProtos$FieldOptions;
import com.google.protobuf.DescriptorProtos$FieldOptions$CType$1;
import com.google.protobuf.Descriptors$EnumDescriptor;
import com.google.protobuf.Descriptors$EnumValueDescriptor;
import com.google.protobuf.Internal$EnumLiteMap;
import com.google.protobuf.ProtocolMessageEnum;
import java.util.List;

public enum DescriptorProtos$FieldOptions$CType implements ProtocolMessageEnum
{
    STRING(0, 0),
    CORD(1, 1),
    STRING_PIECE(2, 2);
    
    public static final int STRING_VALUE = 0;
    public static final int CORD_VALUE = 1;
    public static final int STRING_PIECE_VALUE = 2;
    private static Internal$EnumLiteMap internalValueMap;
    private static final DescriptorProtos$FieldOptions$CType[] VALUES;
    private final int index;
    private final int value;

    @Override
    public final int getNumber() {
        return this.value;
    }

    public static DescriptorProtos$FieldOptions$CType valueOf(int n2) {
        switch (n2) {
            case 0: {
                return STRING;
            }
            case 1: {
                return CORD;
            }
            case 2: {
                return STRING_PIECE;
            }
        }
        return null;
    }

    public static Internal$EnumLiteMap internalGetValueMap() {
        return internalValueMap;
    }

    @Override
    public final Descriptors$EnumValueDescriptor getValueDescriptor() {
        return (Descriptors$EnumValueDescriptor)DescriptorProtos$FieldOptions$CType.getDescriptor().getValues().get(this.index);
    }

    @Override
    public final Descriptors$EnumDescriptor getDescriptorForType() {
        return DescriptorProtos$FieldOptions$CType.getDescriptor();
    }

    public static final Descriptors$EnumDescriptor getDescriptor() {
        return (Descriptors$EnumDescriptor)DescriptorProtos$FieldOptions.getDescriptor().getEnumTypes().get(0);
    }

    public static DescriptorProtos$FieldOptions$CType valueOf(Descriptors$EnumValueDescriptor descriptors$EnumValueDescriptor) {
        if (descriptors$EnumValueDescriptor.getType() == DescriptorProtos$FieldOptions$CType.getDescriptor()) return VALUES[descriptors$EnumValueDescriptor.getIndex()];
        throw new IllegalArgumentException("EnumValueDescriptor is not for this type.");
    }

    private DescriptorProtos$FieldOptions$CType(int n3, int n4) {
        this.index = n3;
        this.value = n4;
    }

    static {
        internalValueMap = new DescriptorProtos$FieldOptions$CType$1();
        VALUES = DescriptorProtos$FieldOptions$CType.values();
    }
}

