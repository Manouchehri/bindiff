/*
 * Decompiled with CFR 0_115.
 */
package com.google.protobuf;

final class ExtensionRegistryLite$ObjectIntPair {
    private final Object object;
    private final int number;

    ExtensionRegistryLite$ObjectIntPair(Object object, int n2) {
        this.object = object;
        this.number = n2;
    }

    public int hashCode() {
        return System.identityHashCode(this.object) * 65535 + this.number;
    }

    public boolean equals(Object object) {
        if (!(object instanceof ExtensionRegistryLite$ObjectIntPair)) {
            return false;
        }
        ExtensionRegistryLite$ObjectIntPair extensionRegistryLite$ObjectIntPair = (ExtensionRegistryLite$ObjectIntPair)object;
        if (this.object != extensionRegistryLite$ObjectIntPair.object) return false;
        if (this.number != extensionRegistryLite$ObjectIntPair.number) return false;
        return true;
    }
}

