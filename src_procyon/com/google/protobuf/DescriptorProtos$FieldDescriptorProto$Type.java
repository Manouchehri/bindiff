package com.google.protobuf;

public enum DescriptorProtos$FieldDescriptorProto$Type implements ProtocolMessageEnum
{
    TYPE_DOUBLE("TYPE_DOUBLE", 0, 0, 1), 
    TYPE_FLOAT("TYPE_FLOAT", 1, 1, 2), 
    TYPE_INT64("TYPE_INT64", 2, 2, 3), 
    TYPE_UINT64("TYPE_UINT64", 3, 3, 4), 
    TYPE_INT32("TYPE_INT32", 4, 4, 5), 
    TYPE_FIXED64("TYPE_FIXED64", 5, 5, 6), 
    TYPE_FIXED32("TYPE_FIXED32", 6, 6, 7), 
    TYPE_BOOL("TYPE_BOOL", 7, 7, 8), 
    TYPE_STRING("TYPE_STRING", 8, 8, 9), 
    TYPE_GROUP("TYPE_GROUP", 9, 9, 10), 
    TYPE_MESSAGE("TYPE_MESSAGE", 10, 10, 11), 
    TYPE_BYTES("TYPE_BYTES", 11, 11, 12), 
    TYPE_UINT32("TYPE_UINT32", 12, 12, 13), 
    TYPE_ENUM("TYPE_ENUM", 13, 13, 14), 
    TYPE_SFIXED32("TYPE_SFIXED32", 14, 14, 15), 
    TYPE_SFIXED64("TYPE_SFIXED64", 15, 15, 16), 
    TYPE_SINT32("TYPE_SINT32", 16, 16, 17), 
    TYPE_SINT64("TYPE_SINT64", 17, 17, 18);
    
    public static final int TYPE_DOUBLE_VALUE = 1;
    public static final int TYPE_FLOAT_VALUE = 2;
    public static final int TYPE_INT64_VALUE = 3;
    public static final int TYPE_UINT64_VALUE = 4;
    public static final int TYPE_INT32_VALUE = 5;
    public static final int TYPE_FIXED64_VALUE = 6;
    public static final int TYPE_FIXED32_VALUE = 7;
    public static final int TYPE_BOOL_VALUE = 8;
    public static final int TYPE_STRING_VALUE = 9;
    public static final int TYPE_GROUP_VALUE = 10;
    public static final int TYPE_MESSAGE_VALUE = 11;
    public static final int TYPE_BYTES_VALUE = 12;
    public static final int TYPE_UINT32_VALUE = 13;
    public static final int TYPE_ENUM_VALUE = 14;
    public static final int TYPE_SFIXED32_VALUE = 15;
    public static final int TYPE_SFIXED64_VALUE = 16;
    public static final int TYPE_SINT32_VALUE = 17;
    public static final int TYPE_SINT64_VALUE = 18;
    private static Internal$EnumLiteMap internalValueMap;
    private static final DescriptorProtos$FieldDescriptorProto$Type[] VALUES;
    private final int index;
    private final int value;
    
    public final int getNumber() {
        return this.value;
    }
    
    public static DescriptorProtos$FieldDescriptorProto$Type valueOf(final int n) {
        switch (n) {
            case 1: {
                return DescriptorProtos$FieldDescriptorProto$Type.TYPE_DOUBLE;
            }
            case 2: {
                return DescriptorProtos$FieldDescriptorProto$Type.TYPE_FLOAT;
            }
            case 3: {
                return DescriptorProtos$FieldDescriptorProto$Type.TYPE_INT64;
            }
            case 4: {
                return DescriptorProtos$FieldDescriptorProto$Type.TYPE_UINT64;
            }
            case 5: {
                return DescriptorProtos$FieldDescriptorProto$Type.TYPE_INT32;
            }
            case 6: {
                return DescriptorProtos$FieldDescriptorProto$Type.TYPE_FIXED64;
            }
            case 7: {
                return DescriptorProtos$FieldDescriptorProto$Type.TYPE_FIXED32;
            }
            case 8: {
                return DescriptorProtos$FieldDescriptorProto$Type.TYPE_BOOL;
            }
            case 9: {
                return DescriptorProtos$FieldDescriptorProto$Type.TYPE_STRING;
            }
            case 10: {
                return DescriptorProtos$FieldDescriptorProto$Type.TYPE_GROUP;
            }
            case 11: {
                return DescriptorProtos$FieldDescriptorProto$Type.TYPE_MESSAGE;
            }
            case 12: {
                return DescriptorProtos$FieldDescriptorProto$Type.TYPE_BYTES;
            }
            case 13: {
                return DescriptorProtos$FieldDescriptorProto$Type.TYPE_UINT32;
            }
            case 14: {
                return DescriptorProtos$FieldDescriptorProto$Type.TYPE_ENUM;
            }
            case 15: {
                return DescriptorProtos$FieldDescriptorProto$Type.TYPE_SFIXED32;
            }
            case 16: {
                return DescriptorProtos$FieldDescriptorProto$Type.TYPE_SFIXED64;
            }
            case 17: {
                return DescriptorProtos$FieldDescriptorProto$Type.TYPE_SINT32;
            }
            case 18: {
                return DescriptorProtos$FieldDescriptorProto$Type.TYPE_SINT64;
            }
            default: {
                return null;
            }
        }
    }
    
    public static Internal$EnumLiteMap internalGetValueMap() {
        return DescriptorProtos$FieldDescriptorProto$Type.internalValueMap;
    }
    
    public final Descriptors$EnumValueDescriptor getValueDescriptor() {
        return getDescriptor().getValues().get(this.index);
    }
    
    public final Descriptors$EnumDescriptor getDescriptorForType() {
        return getDescriptor();
    }
    
    public static final Descriptors$EnumDescriptor getDescriptor() {
        return DescriptorProtos$FieldDescriptorProto.getDescriptor().getEnumTypes().get(0);
    }
    
    public static DescriptorProtos$FieldDescriptorProto$Type valueOf(final Descriptors$EnumValueDescriptor descriptors$EnumValueDescriptor) {
        if (descriptors$EnumValueDescriptor.getType() != getDescriptor()) {
            throw new IllegalArgumentException("EnumValueDescriptor is not for this type.");
        }
        return DescriptorProtos$FieldDescriptorProto$Type.VALUES[descriptors$EnumValueDescriptor.getIndex()];
    }
    
    private DescriptorProtos$FieldDescriptorProto$Type(final String s, final int n, final int index, final int value) {
        this.index = index;
        this.value = value;
    }
    
    static {
        DescriptorProtos$FieldDescriptorProto$Type.internalValueMap = new DescriptorProtos$FieldDescriptorProto$Type$1();
        VALUES = values();
    }
}
