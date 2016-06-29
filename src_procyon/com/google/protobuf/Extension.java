package com.google.protobuf;

public abstract class Extension extends ExtensionLite
{
    public abstract Descriptors$FieldDescriptor getDescriptor();
    
    final boolean isLite() {
        return false;
    }
    
    protected Extension$ExtensionType getExtensionType() {
        return Extension$ExtensionType.IMMUTABLE;
    }
    
    public Extension$MessageType getMessageType() {
        return Extension$MessageType.PROTO2;
    }
    
    protected abstract Object fromReflectionType(final Object p0);
    
    protected abstract Object singularFromReflectionType(final Object p0);
    
    protected abstract Object toReflectionType(final Object p0);
    
    protected abstract Object singularToReflectionType(final Object p0);
}
