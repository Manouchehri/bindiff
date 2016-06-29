/*
 * Decompiled with CFR 0_115.
 */
package com.google.protobuf;

import com.google.protobuf.Descriptors$EnumDescriptor;
import com.google.protobuf.Descriptors$EnumValueDescriptor;
import com.google.protobuf.Field;
import com.google.protobuf.Field$Cardinality$1;
import com.google.protobuf.Internal$EnumLiteMap;
import com.google.protobuf.ProtocolMessageEnum;
import java.util.List;

public enum Field$Cardinality implements ProtocolMessageEnum
{
    CARDINALITY_UNKNOWN(0, 0),
    CARDINALITY_OPTIONAL(1, 1),
    CARDINALITY_REQUIRED(2, 2),
    CARDINALITY_REPEATED(3, 3),
    UNRECOGNIZED(-1, -1);
    
    public static final int CARDINALITY_UNKNOWN_VALUE = 0;
    public static final int CARDINALITY_OPTIONAL_VALUE = 1;
    public static final int CARDINALITY_REQUIRED_VALUE = 2;
    public static final int CARDINALITY_REPEATED_VALUE = 3;
    private static Internal$EnumLiteMap internalValueMap;
    private static final Field$Cardinality[] VALUES;
    private final int index;
    private final int value;

    @Override
    public final int getNumber() {
        if (this.index != -1) return this.value;
        throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
    }

    public static Field$Cardinality valueOf(int n2) {
        switch (n2) {
            case 0: {
                return CARDINALITY_UNKNOWN;
            }
            case 1: {
                return CARDINALITY_OPTIONAL;
            }
            case 2: {
                return CARDINALITY_REQUIRED;
            }
            case 3: {
                return CARDINALITY_REPEATED;
            }
        }
        return null;
    }

    public static Internal$EnumLiteMap internalGetValueMap() {
        return internalValueMap;
    }

    @Override
    public final Descriptors$EnumValueDescriptor getValueDescriptor() {
        return (Descriptors$EnumValueDescriptor)Field$Cardinality.getDescriptor().getValues().get(this.index);
    }

    @Override
    public final Descriptors$EnumDescriptor getDescriptorForType() {
        return Field$Cardinality.getDescriptor();
    }

    public static final Descriptors$EnumDescriptor getDescriptor() {
        return (Descriptors$EnumDescriptor)Field.getDescriptor().getEnumTypes().get(1);
    }

    public static Field$Cardinality valueOf(Descriptors$EnumValueDescriptor descriptors$EnumValueDescriptor) {
        if (descriptors$EnumValueDescriptor.getType() != Field$Cardinality.getDescriptor()) {
            throw new IllegalArgumentException("EnumValueDescriptor is not for this type.");
        }
        if (descriptors$EnumValueDescriptor.getIndex() != -1) return VALUES[descriptors$EnumValueDescriptor.getIndex()];
        return UNRECOGNIZED;
    }

    private Field$Cardinality(int n3, int n4) {
        this.index = n3;
        this.value = n4;
    }

    static {
        internalValueMap = new Field$Cardinality$1();
        VALUES = Field$Cardinality.values();
    }
}

