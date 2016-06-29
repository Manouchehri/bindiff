/*
 * Decompiled with CFR 0_115.
 */
package com.google.protobuf;

import com.google.protobuf.Descriptors$EnumDescriptor;
import com.google.protobuf.Descriptors$EnumValueDescriptor;
import com.google.protobuf.Internal$EnumLiteMap;
import com.google.protobuf.NullValue$1;
import com.google.protobuf.ProtocolMessageEnum;
import com.google.protobuf.StructProto;
import java.util.List;

public enum NullValue implements ProtocolMessageEnum
{
    NULL_VALUE(0, 0),
    UNRECOGNIZED(-1, -1);
    
    public static final int NULL_VALUE_VALUE = 0;
    private static Internal$EnumLiteMap internalValueMap;
    private static final NullValue[] VALUES;
    private final int index;
    private final int value;

    @Override
    public final int getNumber() {
        if (this.index != -1) return this.value;
        throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
    }

    public static NullValue valueOf(int n2) {
        switch (n2) {
            case 0: {
                return NULL_VALUE;
            }
        }
        return null;
    }

    public static Internal$EnumLiteMap internalGetValueMap() {
        return internalValueMap;
    }

    @Override
    public final Descriptors$EnumValueDescriptor getValueDescriptor() {
        return (Descriptors$EnumValueDescriptor)NullValue.getDescriptor().getValues().get(this.index);
    }

    @Override
    public final Descriptors$EnumDescriptor getDescriptorForType() {
        return NullValue.getDescriptor();
    }

    public static final Descriptors$EnumDescriptor getDescriptor() {
        return (Descriptors$EnumDescriptor)StructProto.getDescriptor().getEnumTypes().get(0);
    }

    public static NullValue valueOf(Descriptors$EnumValueDescriptor descriptors$EnumValueDescriptor) {
        if (descriptors$EnumValueDescriptor.getType() != NullValue.getDescriptor()) {
            throw new IllegalArgumentException("EnumValueDescriptor is not for this type.");
        }
        if (descriptors$EnumValueDescriptor.getIndex() != -1) return VALUES[descriptors$EnumValueDescriptor.getIndex()];
        return UNRECOGNIZED;
    }

    private NullValue(int n3, int n4) {
        this.index = n3;
        this.value = n4;
    }

    static {
        internalValueMap = new NullValue$1();
        VALUES = NullValue.values();
    }
}

