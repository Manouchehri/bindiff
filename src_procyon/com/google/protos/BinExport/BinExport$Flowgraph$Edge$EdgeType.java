package com.google.protos.BinExport;

import com.google.protobuf.*;

public enum BinExport$Flowgraph$Edge$EdgeType implements ProtocolMessageEnum
{
    CONDITION_TRUE("CONDITION_TRUE", 0, 0, 1), 
    CONDITION_FALSE("CONDITION_FALSE", 1, 1, 2), 
    UNCONDITIONAL("UNCONDITIONAL", 2, 2, 3), 
    SWITCH("SWITCH", 3, 3, 4);
    
    public static final int CONDITION_TRUE_VALUE = 1;
    public static final int CONDITION_FALSE_VALUE = 2;
    public static final int UNCONDITIONAL_VALUE = 3;
    public static final int SWITCH_VALUE = 4;
    private static Internal$EnumLiteMap internalValueMap;
    private static final BinExport$Flowgraph$Edge$EdgeType[] VALUES;
    private final int index;
    private final int value;
    
    @Override
    public final int getNumber() {
        return this.value;
    }
    
    public static BinExport$Flowgraph$Edge$EdgeType valueOf(final int n) {
        switch (n) {
            case 1: {
                return BinExport$Flowgraph$Edge$EdgeType.CONDITION_TRUE;
            }
            case 2: {
                return BinExport$Flowgraph$Edge$EdgeType.CONDITION_FALSE;
            }
            case 3: {
                return BinExport$Flowgraph$Edge$EdgeType.UNCONDITIONAL;
            }
            case 4: {
                return BinExport$Flowgraph$Edge$EdgeType.SWITCH;
            }
            default: {
                return null;
            }
        }
    }
    
    public static Internal$EnumLiteMap internalGetValueMap() {
        return BinExport$Flowgraph$Edge$EdgeType.internalValueMap;
    }
    
    @Override
    public final Descriptors$EnumValueDescriptor getValueDescriptor() {
        return getDescriptor().getValues().get(this.index);
    }
    
    @Override
    public final Descriptors$EnumDescriptor getDescriptorForType() {
        return getDescriptor();
    }
    
    public static final Descriptors$EnumDescriptor getDescriptor() {
        return BinExport$Flowgraph$Edge.getDescriptor().getEnumTypes().get(0);
    }
    
    public static BinExport$Flowgraph$Edge$EdgeType valueOf(final Descriptors$EnumValueDescriptor descriptors$EnumValueDescriptor) {
        if (descriptors$EnumValueDescriptor.getType() != getDescriptor()) {
            throw new IllegalArgumentException("EnumValueDescriptor is not for this type.");
        }
        return BinExport$Flowgraph$Edge$EdgeType.VALUES[descriptors$EnumValueDescriptor.getIndex()];
    }
    
    private BinExport$Flowgraph$Edge$EdgeType(final String s, final int n, final int index, final int value) {
        this.index = index;
        this.value = value;
    }
    
    static {
        BinExport$Flowgraph$Edge$EdgeType.internalValueMap = new BinExport$Flowgraph$Edge$EdgeType$1();
        VALUES = values();
    }
}
