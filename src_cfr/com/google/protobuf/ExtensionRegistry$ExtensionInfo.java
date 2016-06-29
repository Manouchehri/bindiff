/*
 * Decompiled with CFR 0_115.
 */
package com.google.protobuf;

import com.google.protobuf.Descriptors$FieldDescriptor;
import com.google.protobuf.ExtensionRegistry$1;
import com.google.protobuf.Message;

public final class ExtensionRegistry$ExtensionInfo {
    public final Descriptors$FieldDescriptor descriptor;
    public final Message defaultInstance;

    private ExtensionRegistry$ExtensionInfo(Descriptors$FieldDescriptor descriptors$FieldDescriptor) {
        this.descriptor = descriptors$FieldDescriptor;
        this.defaultInstance = null;
    }

    private ExtensionRegistry$ExtensionInfo(Descriptors$FieldDescriptor descriptors$FieldDescriptor, Message message) {
        this.descriptor = descriptors$FieldDescriptor;
        this.defaultInstance = message;
    }

    /* synthetic */ ExtensionRegistry$ExtensionInfo(Descriptors$FieldDescriptor descriptors$FieldDescriptor, Message message, ExtensionRegistry$1 extensionRegistry$1) {
        this(descriptors$FieldDescriptor, message);
    }
}

