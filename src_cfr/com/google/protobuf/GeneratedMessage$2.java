/*
 * Decompiled with CFR 0_115.
 */
package com.google.protobuf;

import com.google.protobuf.Descriptors$Descriptor;
import com.google.protobuf.Descriptors$FieldDescriptor;
import com.google.protobuf.GeneratedMessage$1;
import com.google.protobuf.GeneratedMessage$CachedDescriptorRetriever;
import com.google.protobuf.Message;

final class GeneratedMessage$2
extends GeneratedMessage$CachedDescriptorRetriever {
    final /* synthetic */ Message val$scope;
    final /* synthetic */ String val$name;

    GeneratedMessage$2(Message message, String string) {
        this.val$scope = message;
        this.val$name = string;
        super(null);
    }

    @Override
    protected Descriptors$FieldDescriptor loadDescriptor() {
        return this.val$scope.getDescriptorForType().findFieldByName(this.val$name);
    }
}

