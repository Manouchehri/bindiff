/*
 * Decompiled with CFR 0_115.
 */
package com.google.protobuf;

import com.google.protobuf.ByteString;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.LazyFieldLite;
import com.google.protobuf.MessageLite;

public class LazyField
extends LazyFieldLite {
    private final MessageLite defaultInstance;

    public LazyField(MessageLite messageLite, ExtensionRegistryLite extensionRegistryLite, ByteString byteString) {
        super(extensionRegistryLite, byteString);
        this.defaultInstance = messageLite;
    }

    @Override
    public boolean containsDefaultInstance() {
        if (super.containsDefaultInstance()) return true;
        if (this.value == this.defaultInstance) return true;
        return false;
    }

    public MessageLite getValue() {
        return this.getValue(this.defaultInstance);
    }

    public int hashCode() {
        return this.getValue().hashCode();
    }

    public boolean equals(Object object) {
        return this.getValue().equals(object);
    }

    public String toString() {
        return this.getValue().toString();
    }
}

