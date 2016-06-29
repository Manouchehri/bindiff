/*
 * Decompiled with CFR 0_115.
 */
package com.google.protobuf;

import com.google.protobuf.DescriptorProtos$FieldOptions;
import com.google.protobuf.DescriptorProtos$FieldOptions$JSType$1;
import com.google.protobuf.Descriptors$EnumDescriptor;
import com.google.protobuf.Descriptors$EnumValueDescriptor;
import com.google.protobuf.Internal$EnumLiteMap;
import com.google.protobuf.ProtocolMessageEnum;
import java.util.List;

public enum DescriptorProtos$FieldOptions$JSType implements ProtocolMessageEnum
{
    JS_NORMAL(0, 0),
    JS_STRING(1, 1),
    JS_NUMBER(2, 2);
    
    public static final int JS_NORMAL_VALUE = 0;
    public static final int JS_STRING_VALUE = 1;
    public static final int JS_NUMBER_VALUE = 2;
    private static Internal$EnumLiteMap internalValueMap;
    private static final DescriptorProtos$FieldOptions$JSType[] VALUES;
    private final int index;
    private final int value;

    @Override
    public final int getNumber() {
        return this.value;
    }

    public static DescriptorProtos$FieldOptions$JSType valueOf(int n2) {
        switch (n2) {
            case 0: {
                return JS_NORMAL;
            }
            case 1: {
                return JS_STRING;
            }
            case 2: {
                return JS_NUMBER;
            }
        }
        return null;
    }

    public static Internal$EnumLiteMap internalGetValueMap() {
        return internalValueMap;
    }

    @Override
    public final Descriptors$EnumValueDescriptor getValueDescriptor() {
        return (Descriptors$EnumValueDescriptor)DescriptorProtos$FieldOptions$JSType.getDescriptor().getValues().get(this.index);
    }

    @Override
    public final Descriptors$EnumDescriptor getDescriptorForType() {
        return DescriptorProtos$FieldOptions$JSType.getDescriptor();
    }

    public static final Descriptors$EnumDescriptor getDescriptor() {
        return (Descriptors$EnumDescriptor)DescriptorProtos$FieldOptions.getDescriptor().getEnumTypes().get(1);
    }

    public static DescriptorProtos$FieldOptions$JSType valueOf(Descriptors$EnumValueDescriptor descriptors$EnumValueDescriptor) {
        if (descriptors$EnumValueDescriptor.getType() == DescriptorProtos$FieldOptions$JSType.getDescriptor()) return VALUES[descriptors$EnumValueDescriptor.getIndex()];
        throw new IllegalArgumentException("EnumValueDescriptor is not for this type.");
    }

    private DescriptorProtos$FieldOptions$JSType(int n3, int n4) {
        this.index = n3;
        this.value = n4;
    }

    static {
        internalValueMap = new DescriptorProtos$FieldOptions$JSType$1();
        VALUES = DescriptorProtos$FieldOptions$JSType.values();
    }
}

