package com.google.protobuf;

public final class ExtensionRegistry$ExtensionInfo
{
    public final Descriptors$FieldDescriptor descriptor;
    public final Message defaultInstance;
    
    private ExtensionRegistry$ExtensionInfo(final Descriptors$FieldDescriptor descriptor) {
        this.descriptor = descriptor;
        this.defaultInstance = null;
    }
    
    private ExtensionRegistry$ExtensionInfo(final Descriptors$FieldDescriptor descriptor, final Message defaultInstance) {
        this.descriptor = descriptor;
        this.defaultInstance = defaultInstance;
    }
}
