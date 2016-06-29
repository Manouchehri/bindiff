package com.google.protobuf;

public enum DescriptorProtos$FieldDescriptorProto$Label implements ProtocolMessageEnum
{
    LABEL_OPTIONAL("LABEL_OPTIONAL", 0, 0, 1), 
    LABEL_REQUIRED("LABEL_REQUIRED", 1, 1, 2), 
    LABEL_REPEATED("LABEL_REPEATED", 2, 2, 3);
    
    public static final int LABEL_OPTIONAL_VALUE = 1;
    public static final int LABEL_REQUIRED_VALUE = 2;
    public static final int LABEL_REPEATED_VALUE = 3;
    private static Internal$EnumLiteMap internalValueMap;
    private static final DescriptorProtos$FieldDescriptorProto$Label[] VALUES;
    private final int index;
    private final int value;
    
    public final int getNumber() {
        return this.value;
    }
    
    public static DescriptorProtos$FieldDescriptorProto$Label valueOf(final int n) {
        switch (n) {
            case 1: {
                return DescriptorProtos$FieldDescriptorProto$Label.LABEL_OPTIONAL;
            }
            case 2: {
                return DescriptorProtos$FieldDescriptorProto$Label.LABEL_REQUIRED;
            }
            case 3: {
                return DescriptorProtos$FieldDescriptorProto$Label.LABEL_REPEATED;
            }
            default: {
                return null;
            }
        }
    }
    
    public static Internal$EnumLiteMap internalGetValueMap() {
        return DescriptorProtos$FieldDescriptorProto$Label.internalValueMap;
    }
    
    public final Descriptors$EnumValueDescriptor getValueDescriptor() {
        return getDescriptor().getValues().get(this.index);
    }
    
    public final Descriptors$EnumDescriptor getDescriptorForType() {
        return getDescriptor();
    }
    
    public static final Descriptors$EnumDescriptor getDescriptor() {
        return DescriptorProtos$FieldDescriptorProto.getDescriptor().getEnumTypes().get(1);
    }
    
    public static DescriptorProtos$FieldDescriptorProto$Label valueOf(final Descriptors$EnumValueDescriptor descriptors$EnumValueDescriptor) {
        if (descriptors$EnumValueDescriptor.getType() != getDescriptor()) {
            throw new IllegalArgumentException("EnumValueDescriptor is not for this type.");
        }
        return DescriptorProtos$FieldDescriptorProto$Label.VALUES[descriptors$EnumValueDescriptor.getIndex()];
    }
    
    private DescriptorProtos$FieldDescriptorProto$Label(final String s, final int n, final int index, final int value) {
        this.index = index;
        this.value = value;
    }
    
    static {
        DescriptorProtos$FieldDescriptorProto$Label.internalValueMap = new DescriptorProtos$FieldDescriptorProto$Label$1();
        VALUES = values();
    }
}
