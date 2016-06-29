package com.google.protobuf;

public abstract class ExtensionLite
{
    public abstract int getNumber();
    
    public abstract WireFormat$FieldType getLiteType();
    
    public abstract boolean isRepeated();
    
    public abstract Object getDefaultValue();
    
    public abstract MessageLite getMessageDefaultInstance();
    
    boolean isLite() {
        return true;
    }
}
