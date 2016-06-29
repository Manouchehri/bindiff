package com.google.protos.BinExport;

import com.google.protobuf.*;

public enum BinExport$Callgraph$Vertex$FunctionType implements ProtocolMessageEnum
{
    NORMAL("NORMAL", 0, 0, 0), 
    LIBRARY("LIBRARY", 1, 1, 1), 
    IMPORTED("IMPORTED", 2, 2, 2), 
    THUNK("THUNK", 3, 3, 3), 
    INVALID("INVALID", 4, 4, 4);
    
    public static final int NORMAL_VALUE = 0;
    public static final int LIBRARY_VALUE = 1;
    public static final int IMPORTED_VALUE = 2;
    public static final int THUNK_VALUE = 3;
    public static final int INVALID_VALUE = 4;
    private static Internal$EnumLiteMap internalValueMap;
    private static final BinExport$Callgraph$Vertex$FunctionType[] VALUES;
    private final int index;
    private final int value;
    
    @Override
    public final int getNumber() {
        return this.value;
    }
    
    public static BinExport$Callgraph$Vertex$FunctionType valueOf(final int n) {
        switch (n) {
            case 0: {
                return BinExport$Callgraph$Vertex$FunctionType.NORMAL;
            }
            case 1: {
                return BinExport$Callgraph$Vertex$FunctionType.LIBRARY;
            }
            case 2: {
                return BinExport$Callgraph$Vertex$FunctionType.IMPORTED;
            }
            case 3: {
                return BinExport$Callgraph$Vertex$FunctionType.THUNK;
            }
            case 4: {
                return BinExport$Callgraph$Vertex$FunctionType.INVALID;
            }
            default: {
                return null;
            }
        }
    }
    
    public static Internal$EnumLiteMap internalGetValueMap() {
        return BinExport$Callgraph$Vertex$FunctionType.internalValueMap;
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
        return BinExport$Callgraph$Vertex.getDescriptor().getEnumTypes().get(0);
    }
    
    public static BinExport$Callgraph$Vertex$FunctionType valueOf(final Descriptors$EnumValueDescriptor descriptors$EnumValueDescriptor) {
        if (descriptors$EnumValueDescriptor.getType() != getDescriptor()) {
            throw new IllegalArgumentException("EnumValueDescriptor is not for this type.");
        }
        return BinExport$Callgraph$Vertex$FunctionType.VALUES[descriptors$EnumValueDescriptor.getIndex()];
    }
    
    private BinExport$Callgraph$Vertex$FunctionType(final String s, final int n, final int index, final int value) {
        this.index = index;
        this.value = value;
    }
    
    static {
        BinExport$Callgraph$Vertex$FunctionType.internalValueMap = new BinExport$Callgraph$Vertex$FunctionType$1();
        VALUES = values();
    }
}
