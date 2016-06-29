/*
 * Decompiled with CFR 0_115.
 */
package com.google.protobuf;

import com.google.protobuf.Descriptors$GenericDescriptor;

final class Descriptors$DescriptorPool$DescriptorIntPair {
    private final Descriptors$GenericDescriptor descriptor;
    private final int number;

    Descriptors$DescriptorPool$DescriptorIntPair(Descriptors$GenericDescriptor descriptors$GenericDescriptor, int n2) {
        this.descriptor = descriptors$GenericDescriptor;
        this.number = n2;
    }

    public int hashCode() {
        return this.descriptor.hashCode() * 65535 + this.number;
    }

    public boolean equals(Object object) {
        if (!(object instanceof Descriptors$DescriptorPool$DescriptorIntPair)) {
            return false;
        }
        Descriptors$DescriptorPool$DescriptorIntPair descriptors$DescriptorPool$DescriptorIntPair = (Descriptors$DescriptorPool$DescriptorIntPair)object;
        if (this.descriptor != descriptors$DescriptorPool$DescriptorIntPair.descriptor) return false;
        if (this.number != descriptors$DescriptorPool$DescriptorIntPair.number) return false;
        return true;
    }
}

