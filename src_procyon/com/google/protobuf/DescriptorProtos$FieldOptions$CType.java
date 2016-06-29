package com.google.protobuf;

public enum DescriptorProtos$FieldOptions$CType implements ProtocolMessageEnum
{
    STRING("STRING", 0, 0, 0), 
    CORD("CORD", 1, 1, 1), 
    STRING_PIECE("STRING_PIECE", 2, 2, 2);
    
    public static final int STRING_VALUE = 0;
    public static final int CORD_VALUE = 1;
    public static final int STRING_PIECE_VALUE = 2;
    private static Internal$EnumLiteMap internalValueMap;
    private static final DescriptorProtos$FieldOptions$CType[] VALUES;
    private final int index;
    private final int value;
    
    public final int getNumber() {
        return this.value;
    }
    
    public static DescriptorProtos$FieldOptions$CType valueOf(final int n) {
        switch (n) {
            case 0: {
                return DescriptorProtos$FieldOptions$CType.STRING;
            }
            case 1: {
                return DescriptorProtos$FieldOptions$CType.CORD;
            }
            case 2: {
                return DescriptorProtos$FieldOptions$CType.STRING_PIECE;
            }
            default: {
                return null;
            }
        }
    }
    
    public static Internal$EnumLiteMap internalGetValueMap() {
        return DescriptorProtos$FieldOptions$CType.internalValueMap;
    }
    
    public final Descriptors$EnumValueDescriptor getValueDescriptor() {
        return getDescriptor().getValues().get(this.index);
    }
    
    public final Descriptors$EnumDescriptor getDescriptorForType() {
        return getDescriptor();
    }
    
    public static final Descriptors$EnumDescriptor getDescriptor() {
        return DescriptorProtos$FieldOptions.getDescriptor().getEnumTypes().get(0);
    }
    
    public static DescriptorProtos$FieldOptions$CType valueOf(final Descriptors$EnumValueDescriptor descriptors$EnumValueDescriptor) {
        if (descriptors$EnumValueDescriptor.getType() != getDescriptor()) {
            throw new IllegalArgumentException("EnumValueDescriptor is not for this type.");
        }
        return DescriptorProtos$FieldOptions$CType.VALUES[descriptors$EnumValueDescriptor.getIndex()];
    }
    
    private DescriptorProtos$FieldOptions$CType(final String s, final int n, final int index, final int value) {
        this.index = index;
        this.value = value;
    }
    
    static {
        DescriptorProtos$FieldOptions$CType.internalValueMap = new DescriptorProtos$FieldOptions$CType$1();
        VALUES = values();
    }
}
