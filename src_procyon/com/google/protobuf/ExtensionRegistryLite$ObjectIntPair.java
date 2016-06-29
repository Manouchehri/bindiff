package com.google.protobuf;

final class ExtensionRegistryLite$ObjectIntPair
{
    private final Object object;
    private final int number;
    
    ExtensionRegistryLite$ObjectIntPair(final Object object, final int number) {
        this.object = object;
        this.number = number;
    }
    
    public int hashCode() {
        return System.identityHashCode(this.object) * 65535 + this.number;
    }
    
    public boolean equals(final Object o) {
        if (!(o instanceof ExtensionRegistryLite$ObjectIntPair)) {
            return false;
        }
        final ExtensionRegistryLite$ObjectIntPair extensionRegistryLite$ObjectIntPair = (ExtensionRegistryLite$ObjectIntPair)o;
        return this.object == extensionRegistryLite$ObjectIntPair.object && this.number == extensionRegistryLite$ObjectIntPair.number;
    }
}
