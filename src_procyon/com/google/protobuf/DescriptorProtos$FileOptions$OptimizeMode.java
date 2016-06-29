package com.google.protobuf;

public enum DescriptorProtos$FileOptions$OptimizeMode implements ProtocolMessageEnum
{
    SPEED("SPEED", 0, 0, 1), 
    CODE_SIZE("CODE_SIZE", 1, 1, 2), 
    LITE_RUNTIME("LITE_RUNTIME", 2, 2, 3);
    
    public static final int SPEED_VALUE = 1;
    public static final int CODE_SIZE_VALUE = 2;
    public static final int LITE_RUNTIME_VALUE = 3;
    private static Internal$EnumLiteMap internalValueMap;
    private static final DescriptorProtos$FileOptions$OptimizeMode[] VALUES;
    private final int index;
    private final int value;
    
    public final int getNumber() {
        return this.value;
    }
    
    public static DescriptorProtos$FileOptions$OptimizeMode valueOf(final int n) {
        switch (n) {
            case 1: {
                return DescriptorProtos$FileOptions$OptimizeMode.SPEED;
            }
            case 2: {
                return DescriptorProtos$FileOptions$OptimizeMode.CODE_SIZE;
            }
            case 3: {
                return DescriptorProtos$FileOptions$OptimizeMode.LITE_RUNTIME;
            }
            default: {
                return null;
            }
        }
    }
    
    public static Internal$EnumLiteMap internalGetValueMap() {
        return DescriptorProtos$FileOptions$OptimizeMode.internalValueMap;
    }
    
    public final Descriptors$EnumValueDescriptor getValueDescriptor() {
        return getDescriptor().getValues().get(this.index);
    }
    
    public final Descriptors$EnumDescriptor getDescriptorForType() {
        return getDescriptor();
    }
    
    public static final Descriptors$EnumDescriptor getDescriptor() {
        return DescriptorProtos$FileOptions.getDescriptor().getEnumTypes().get(0);
    }
    
    public static DescriptorProtos$FileOptions$OptimizeMode valueOf(final Descriptors$EnumValueDescriptor descriptors$EnumValueDescriptor) {
        if (descriptors$EnumValueDescriptor.getType() != getDescriptor()) {
            throw new IllegalArgumentException("EnumValueDescriptor is not for this type.");
        }
        return DescriptorProtos$FileOptions$OptimizeMode.VALUES[descriptors$EnumValueDescriptor.getIndex()];
    }
    
    private DescriptorProtos$FileOptions$OptimizeMode(final String s, final int n, final int index, final int value) {
        this.index = index;
        this.value = value;
    }
    
    static {
        DescriptorProtos$FileOptions$OptimizeMode.internalValueMap = new DescriptorProtos$FileOptions$OptimizeMode$1();
        VALUES = values();
    }
}
