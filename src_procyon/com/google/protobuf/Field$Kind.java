package com.google.protobuf;

public enum Field$Kind implements ProtocolMessageEnum
{
    TYPE_UNKNOWN("TYPE_UNKNOWN", 0, 0, 0), 
    TYPE_DOUBLE("TYPE_DOUBLE", 1, 1, 1), 
    TYPE_FLOAT("TYPE_FLOAT", 2, 2, 2), 
    TYPE_INT64("TYPE_INT64", 3, 3, 3), 
    TYPE_UINT64("TYPE_UINT64", 4, 4, 4), 
    TYPE_INT32("TYPE_INT32", 5, 5, 5), 
    TYPE_FIXED64("TYPE_FIXED64", 6, 6, 6), 
    TYPE_FIXED32("TYPE_FIXED32", 7, 7, 7), 
    TYPE_BOOL("TYPE_BOOL", 8, 8, 8), 
    TYPE_STRING("TYPE_STRING", 9, 9, 9), 
    TYPE_MESSAGE("TYPE_MESSAGE", 10, 10, 11), 
    TYPE_BYTES("TYPE_BYTES", 11, 11, 12), 
    TYPE_UINT32("TYPE_UINT32", 12, 12, 13), 
    TYPE_ENUM("TYPE_ENUM", 13, 13, 14), 
    TYPE_SFIXED32("TYPE_SFIXED32", 14, 14, 15), 
    TYPE_SFIXED64("TYPE_SFIXED64", 15, 15, 16), 
    TYPE_SINT32("TYPE_SINT32", 16, 16, 17), 
    TYPE_SINT64("TYPE_SINT64", 17, 17, 18), 
    UNRECOGNIZED("UNRECOGNIZED", 18, -1, -1);
    
    public static final int TYPE_UNKNOWN_VALUE = 0;
    public static final int TYPE_DOUBLE_VALUE = 1;
    public static final int TYPE_FLOAT_VALUE = 2;
    public static final int TYPE_INT64_VALUE = 3;
    public static final int TYPE_UINT64_VALUE = 4;
    public static final int TYPE_INT32_VALUE = 5;
    public static final int TYPE_FIXED64_VALUE = 6;
    public static final int TYPE_FIXED32_VALUE = 7;
    public static final int TYPE_BOOL_VALUE = 8;
    public static final int TYPE_STRING_VALUE = 9;
    public static final int TYPE_MESSAGE_VALUE = 11;
    public static final int TYPE_BYTES_VALUE = 12;
    public static final int TYPE_UINT32_VALUE = 13;
    public static final int TYPE_ENUM_VALUE = 14;
    public static final int TYPE_SFIXED32_VALUE = 15;
    public static final int TYPE_SFIXED64_VALUE = 16;
    public static final int TYPE_SINT32_VALUE = 17;
    public static final int TYPE_SINT64_VALUE = 18;
    private static Internal$EnumLiteMap internalValueMap;
    private static final Field$Kind[] VALUES;
    private final int index;
    private final int value;
    
    public final int getNumber() {
        if (this.index == -1) {
            throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
        }
        return this.value;
    }
    
    public static Field$Kind valueOf(final int n) {
        switch (n) {
            case 0: {
                return Field$Kind.TYPE_UNKNOWN;
            }
            case 1: {
                return Field$Kind.TYPE_DOUBLE;
            }
            case 2: {
                return Field$Kind.TYPE_FLOAT;
            }
            case 3: {
                return Field$Kind.TYPE_INT64;
            }
            case 4: {
                return Field$Kind.TYPE_UINT64;
            }
            case 5: {
                return Field$Kind.TYPE_INT32;
            }
            case 6: {
                return Field$Kind.TYPE_FIXED64;
            }
            case 7: {
                return Field$Kind.TYPE_FIXED32;
            }
            case 8: {
                return Field$Kind.TYPE_BOOL;
            }
            case 9: {
                return Field$Kind.TYPE_STRING;
            }
            case 11: {
                return Field$Kind.TYPE_MESSAGE;
            }
            case 12: {
                return Field$Kind.TYPE_BYTES;
            }
            case 13: {
                return Field$Kind.TYPE_UINT32;
            }
            case 14: {
                return Field$Kind.TYPE_ENUM;
            }
            case 15: {
                return Field$Kind.TYPE_SFIXED32;
            }
            case 16: {
                return Field$Kind.TYPE_SFIXED64;
            }
            case 17: {
                return Field$Kind.TYPE_SINT32;
            }
            case 18: {
                return Field$Kind.TYPE_SINT64;
            }
            default: {
                return null;
            }
        }
    }
    
    public static Internal$EnumLiteMap internalGetValueMap() {
        return Field$Kind.internalValueMap;
    }
    
    public final Descriptors$EnumValueDescriptor getValueDescriptor() {
        return getDescriptor().getValues().get(this.index);
    }
    
    public final Descriptors$EnumDescriptor getDescriptorForType() {
        return getDescriptor();
    }
    
    public static final Descriptors$EnumDescriptor getDescriptor() {
        return Field.getDescriptor().getEnumTypes().get(0);
    }
    
    public static Field$Kind valueOf(final Descriptors$EnumValueDescriptor descriptors$EnumValueDescriptor) {
        if (descriptors$EnumValueDescriptor.getType() != getDescriptor()) {
            throw new IllegalArgumentException("EnumValueDescriptor is not for this type.");
        }
        if (descriptors$EnumValueDescriptor.getIndex() == -1) {
            return Field$Kind.UNRECOGNIZED;
        }
        return Field$Kind.VALUES[descriptors$EnumValueDescriptor.getIndex()];
    }
    
    private Field$Kind(final String s, final int n, final int index, final int value) {
        this.index = index;
        this.value = value;
    }
    
    static {
        Field$Kind.internalValueMap = new Field$Kind$1();
        VALUES = values();
    }
}
