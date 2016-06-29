package com.google.protobuf;

public enum Field$Cardinality implements ProtocolMessageEnum
{
    CARDINALITY_UNKNOWN("CARDINALITY_UNKNOWN", 0, 0, 0), 
    CARDINALITY_OPTIONAL("CARDINALITY_OPTIONAL", 1, 1, 1), 
    CARDINALITY_REQUIRED("CARDINALITY_REQUIRED", 2, 2, 2), 
    CARDINALITY_REPEATED("CARDINALITY_REPEATED", 3, 3, 3), 
    UNRECOGNIZED("UNRECOGNIZED", 4, -1, -1);
    
    public static final int CARDINALITY_UNKNOWN_VALUE = 0;
    public static final int CARDINALITY_OPTIONAL_VALUE = 1;
    public static final int CARDINALITY_REQUIRED_VALUE = 2;
    public static final int CARDINALITY_REPEATED_VALUE = 3;
    private static Internal$EnumLiteMap internalValueMap;
    private static final Field$Cardinality[] VALUES;
    private final int index;
    private final int value;
    
    public final int getNumber() {
        if (this.index == -1) {
            throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
        }
        return this.value;
    }
    
    public static Field$Cardinality valueOf(final int n) {
        switch (n) {
            case 0: {
                return Field$Cardinality.CARDINALITY_UNKNOWN;
            }
            case 1: {
                return Field$Cardinality.CARDINALITY_OPTIONAL;
            }
            case 2: {
                return Field$Cardinality.CARDINALITY_REQUIRED;
            }
            case 3: {
                return Field$Cardinality.CARDINALITY_REPEATED;
            }
            default: {
                return null;
            }
        }
    }
    
    public static Internal$EnumLiteMap internalGetValueMap() {
        return Field$Cardinality.internalValueMap;
    }
    
    public final Descriptors$EnumValueDescriptor getValueDescriptor() {
        return getDescriptor().getValues().get(this.index);
    }
    
    public final Descriptors$EnumDescriptor getDescriptorForType() {
        return getDescriptor();
    }
    
    public static final Descriptors$EnumDescriptor getDescriptor() {
        return Field.getDescriptor().getEnumTypes().get(1);
    }
    
    public static Field$Cardinality valueOf(final Descriptors$EnumValueDescriptor descriptors$EnumValueDescriptor) {
        if (descriptors$EnumValueDescriptor.getType() != getDescriptor()) {
            throw new IllegalArgumentException("EnumValueDescriptor is not for this type.");
        }
        if (descriptors$EnumValueDescriptor.getIndex() == -1) {
            return Field$Cardinality.UNRECOGNIZED;
        }
        return Field$Cardinality.VALUES[descriptors$EnumValueDescriptor.getIndex()];
    }
    
    private Field$Cardinality(final String s, final int n, final int index, final int value) {
        this.index = index;
        this.value = value;
    }
    
    static {
        Field$Cardinality.internalValueMap = new Field$Cardinality$1();
        VALUES = values();
    }
}
