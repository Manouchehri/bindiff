package com.google.protobuf;

public enum DescriptorProtos$FieldOptions$JSType implements ProtocolMessageEnum
{
    JS_NORMAL("JS_NORMAL", 0, 0, 0), 
    JS_STRING("JS_STRING", 1, 1, 1), 
    JS_NUMBER("JS_NUMBER", 2, 2, 2);
    
    public static final int JS_NORMAL_VALUE = 0;
    public static final int JS_STRING_VALUE = 1;
    public static final int JS_NUMBER_VALUE = 2;
    private static Internal$EnumLiteMap internalValueMap;
    private static final DescriptorProtos$FieldOptions$JSType[] VALUES;
    private final int index;
    private final int value;
    
    public final int getNumber() {
        return this.value;
    }
    
    public static DescriptorProtos$FieldOptions$JSType valueOf(final int n) {
        switch (n) {
            case 0: {
                return DescriptorProtos$FieldOptions$JSType.JS_NORMAL;
            }
            case 1: {
                return DescriptorProtos$FieldOptions$JSType.JS_STRING;
            }
            case 2: {
                return DescriptorProtos$FieldOptions$JSType.JS_NUMBER;
            }
            default: {
                return null;
            }
        }
    }
    
    public static Internal$EnumLiteMap internalGetValueMap() {
        return DescriptorProtos$FieldOptions$JSType.internalValueMap;
    }
    
    public final Descriptors$EnumValueDescriptor getValueDescriptor() {
        return getDescriptor().getValues().get(this.index);
    }
    
    public final Descriptors$EnumDescriptor getDescriptorForType() {
        return getDescriptor();
    }
    
    public static final Descriptors$EnumDescriptor getDescriptor() {
        return DescriptorProtos$FieldOptions.getDescriptor().getEnumTypes().get(1);
    }
    
    public static DescriptorProtos$FieldOptions$JSType valueOf(final Descriptors$EnumValueDescriptor descriptors$EnumValueDescriptor) {
        if (descriptors$EnumValueDescriptor.getType() != getDescriptor()) {
            throw new IllegalArgumentException("EnumValueDescriptor is not for this type.");
        }
        return DescriptorProtos$FieldOptions$JSType.VALUES[descriptors$EnumValueDescriptor.getIndex()];
    }
    
    private DescriptorProtos$FieldOptions$JSType(final String s, final int n, final int index, final int value) {
        this.index = index;
        this.value = value;
    }
    
    static {
        DescriptorProtos$FieldOptions$JSType.internalValueMap = new DescriptorProtos$FieldOptions$JSType$1();
        VALUES = values();
    }
}
