/*
 * Decompiled with CFR 0_115.
 */
package com.google.protobuf;

import com.google.protobuf.DescriptorProtos$FileOptions;
import com.google.protobuf.DescriptorProtos$FileOptions$OptimizeMode$1;
import com.google.protobuf.Descriptors$EnumDescriptor;
import com.google.protobuf.Descriptors$EnumValueDescriptor;
import com.google.protobuf.Internal$EnumLiteMap;
import com.google.protobuf.ProtocolMessageEnum;
import java.util.List;

public enum DescriptorProtos$FileOptions$OptimizeMode implements ProtocolMessageEnum
{
    SPEED(0, 1),
    CODE_SIZE(1, 2),
    LITE_RUNTIME(2, 3);
    
    public static final int SPEED_VALUE = 1;
    public static final int CODE_SIZE_VALUE = 2;
    public static final int LITE_RUNTIME_VALUE = 3;
    private static Internal$EnumLiteMap internalValueMap;
    private static final DescriptorProtos$FileOptions$OptimizeMode[] VALUES;
    private final int index;
    private final int value;

    @Override
    public final int getNumber() {
        return this.value;
    }

    public static DescriptorProtos$FileOptions$OptimizeMode valueOf(int n2) {
        switch (n2) {
            case 1: {
                return SPEED;
            }
            case 2: {
                return CODE_SIZE;
            }
            case 3: {
                return LITE_RUNTIME;
            }
        }
        return null;
    }

    public static Internal$EnumLiteMap internalGetValueMap() {
        return internalValueMap;
    }

    @Override
    public final Descriptors$EnumValueDescriptor getValueDescriptor() {
        return (Descriptors$EnumValueDescriptor)DescriptorProtos$FileOptions$OptimizeMode.getDescriptor().getValues().get(this.index);
    }

    @Override
    public final Descriptors$EnumDescriptor getDescriptorForType() {
        return DescriptorProtos$FileOptions$OptimizeMode.getDescriptor();
    }

    public static final Descriptors$EnumDescriptor getDescriptor() {
        return (Descriptors$EnumDescriptor)DescriptorProtos$FileOptions.getDescriptor().getEnumTypes().get(0);
    }

    public static DescriptorProtos$FileOptions$OptimizeMode valueOf(Descriptors$EnumValueDescriptor descriptors$EnumValueDescriptor) {
        if (descriptors$EnumValueDescriptor.getType() == DescriptorProtos$FileOptions$OptimizeMode.getDescriptor()) return VALUES[descriptors$EnumValueDescriptor.getIndex()];
        throw new IllegalArgumentException("EnumValueDescriptor is not for this type.");
    }

    private DescriptorProtos$FileOptions$OptimizeMode(int n3, int n4) {
        this.index = n3;
        this.value = n4;
    }

    static {
        internalValueMap = new DescriptorProtos$FileOptions$OptimizeMode$1();
        VALUES = DescriptorProtos$FileOptions$OptimizeMode.values();
    }
}

