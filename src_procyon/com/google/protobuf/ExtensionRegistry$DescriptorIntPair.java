package com.google.protobuf;

final class ExtensionRegistry$DescriptorIntPair
{
    private final Descriptors$Descriptor descriptor;
    private final int number;
    
    ExtensionRegistry$DescriptorIntPair(final Descriptors$Descriptor descriptor, final int number) {
        this.descriptor = descriptor;
        this.number = number;
    }
    
    public int hashCode() {
        return this.descriptor.hashCode() * 65535 + this.number;
    }
    
    public boolean equals(final Object o) {
        if (!(o instanceof ExtensionRegistry$DescriptorIntPair)) {
            return false;
        }
        final ExtensionRegistry$DescriptorIntPair extensionRegistry$DescriptorIntPair = (ExtensionRegistry$DescriptorIntPair)o;
        return this.descriptor == extensionRegistry$DescriptorIntPair.descriptor && this.number == extensionRegistry$DescriptorIntPair.number;
    }
}
