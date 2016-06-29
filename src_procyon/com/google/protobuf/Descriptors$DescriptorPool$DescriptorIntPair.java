package com.google.protobuf;

final class Descriptors$DescriptorPool$DescriptorIntPair
{
    private final Descriptors$GenericDescriptor descriptor;
    private final int number;
    
    Descriptors$DescriptorPool$DescriptorIntPair(final Descriptors$GenericDescriptor descriptor, final int number) {
        this.descriptor = descriptor;
        this.number = number;
    }
    
    public int hashCode() {
        return this.descriptor.hashCode() * 65535 + this.number;
    }
    
    public boolean equals(final Object o) {
        if (!(o instanceof Descriptors$DescriptorPool$DescriptorIntPair)) {
            return false;
        }
        final Descriptors$DescriptorPool$DescriptorIntPair descriptors$DescriptorPool$DescriptorIntPair = (Descriptors$DescriptorPool$DescriptorIntPair)o;
        return this.descriptor == descriptors$DescriptorPool$DescriptorIntPair.descriptor && this.number == descriptors$DescriptorPool$DescriptorIntPair.number;
    }
}
