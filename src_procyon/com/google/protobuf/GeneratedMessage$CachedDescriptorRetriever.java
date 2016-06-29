package com.google.protobuf;

abstract class GeneratedMessage$CachedDescriptorRetriever implements GeneratedMessage$ExtensionDescriptorRetriever
{
    private volatile Descriptors$FieldDescriptor descriptor;
    
    protected abstract Descriptors$FieldDescriptor loadDescriptor();
    
    public Descriptors$FieldDescriptor getDescriptor() {
        if (this.descriptor == null) {
            synchronized (this) {
                if (this.descriptor == null) {
                    this.descriptor = this.loadDescriptor();
                }
            }
        }
        return this.descriptor;
    }
}
