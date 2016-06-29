package com.google.protobuf;

public enum NullValue implements ProtocolMessageEnum
{
    NULL_VALUE("NULL_VALUE", 0, 0, 0), 
    UNRECOGNIZED("UNRECOGNIZED", 1, -1, -1);
    
    public static final int NULL_VALUE_VALUE = 0;
    private static Internal$EnumLiteMap internalValueMap;
    private static final NullValue[] VALUES;
    private final int index;
    private final int value;
    
    public final int getNumber() {
        if (this.index == -1) {
            throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
        }
        return this.value;
    }
    
    public static NullValue valueOf(final int n) {
        switch (n) {
            case 0: {
                return NullValue.NULL_VALUE;
            }
            default: {
                return null;
            }
        }
    }
    
    public static Internal$EnumLiteMap internalGetValueMap() {
        return NullValue.internalValueMap;
    }
    
    public final Descriptors$EnumValueDescriptor getValueDescriptor() {
        return getDescriptor().getValues().get(this.index);
    }
    
    public final Descriptors$EnumDescriptor getDescriptorForType() {
        return getDescriptor();
    }
    
    public static final Descriptors$EnumDescriptor getDescriptor() {
        return StructProto.getDescriptor().getEnumTypes().get(0);
    }
    
    public static NullValue valueOf(final Descriptors$EnumValueDescriptor descriptors$EnumValueDescriptor) {
        if (descriptors$EnumValueDescriptor.getType() != getDescriptor()) {
            throw new IllegalArgumentException("EnumValueDescriptor is not for this type.");
        }
        if (descriptors$EnumValueDescriptor.getIndex() == -1) {
            return NullValue.UNRECOGNIZED;
        }
        return NullValue.VALUES[descriptors$EnumValueDescriptor.getIndex()];
    }
    
    private NullValue(final String s, final int n, final int index, final int value) {
        this.index = index;
        this.value = value;
    }
    
    static {
        NullValue.internalValueMap = new NullValue$1();
        VALUES = values();
    }
}
