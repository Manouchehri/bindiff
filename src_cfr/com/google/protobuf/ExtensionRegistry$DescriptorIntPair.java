/*
 * Decompiled with CFR 0_115.
 */
package com.google.protobuf;

import com.google.protobuf.Descriptors$Descriptor;

final class ExtensionRegistry$DescriptorIntPair {
    private final Descriptors$Descriptor descriptor;
    private final int number;

    ExtensionRegistry$DescriptorIntPair(Descriptors$Descriptor descriptors$Descriptor, int n2) {
        this.descriptor = descriptors$Descriptor;
        this.number = n2;
    }

    public int hashCode() {
        return this.descriptor.hashCode() * 65535 + this.number;
    }

    public boolean equals(Object object) {
        if (!(object instanceof ExtensionRegistry$DescriptorIntPair)) {
            return false;
        }
        ExtensionRegistry$DescriptorIntPair extensionRegistry$DescriptorIntPair = (ExtensionRegistry$DescriptorIntPair)object;
        if (this.descriptor != extensionRegistry$DescriptorIntPair.descriptor) return false;
        if (this.number != extensionRegistry$DescriptorIntPair.number) return false;
        return true;
    }

    static /* synthetic */ Descriptors$Descriptor access$000(ExtensionRegistry$DescriptorIntPair extensionRegistry$DescriptorIntPair) {
        return extensionRegistry$DescriptorIntPair.descriptor;
    }
}

