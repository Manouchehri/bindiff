/*
 * Decompiled with CFR 0_115.
 */
package com.google.protobuf;

import com.google.protobuf.Descriptors$FieldDescriptor;
import com.google.protobuf.GeneratedMessage$1;
import com.google.protobuf.GeneratedMessage$ExtensionDescriptorRetriever;

abstract class GeneratedMessage$CachedDescriptorRetriever
implements GeneratedMessage$ExtensionDescriptorRetriever {
    private volatile Descriptors$FieldDescriptor descriptor;

    private GeneratedMessage$CachedDescriptorRetriever() {
    }

    protected abstract Descriptors$FieldDescriptor loadDescriptor();

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public Descriptors$FieldDescriptor getDescriptor() {
        if (this.descriptor != null) return this.descriptor;
        GeneratedMessage$CachedDescriptorRetriever generatedMessage$CachedDescriptorRetriever = this;
        synchronized (generatedMessage$CachedDescriptorRetriever) {
            if (this.descriptor != null) return this.descriptor;
            this.descriptor = this.loadDescriptor();
            return this.descriptor;
        }
    }

    /* synthetic */ GeneratedMessage$CachedDescriptorRetriever(GeneratedMessage$1 generatedMessage$1) {
        this();
    }
}

