/*
 * Decompiled with CFR 0_115.
 */
package com.google.protobuf;

import com.google.protobuf.Descriptors$Descriptor;
import com.google.protobuf.Descriptors$FieldDescriptor;
import com.google.protobuf.GeneratedMessage$CachedDescriptorRetriever;
import com.google.protobuf.Message;
import java.util.List;

final class GeneratedMessage$1
extends GeneratedMessage$CachedDescriptorRetriever {
    final /* synthetic */ Message val$scope;
    final /* synthetic */ int val$descriptorIndex;

    GeneratedMessage$1(Message message, int n2) {
        this.val$scope = message;
        this.val$descriptorIndex = n2;
        super(null);
    }

    @Override
    public Descriptors$FieldDescriptor loadDescriptor() {
        return (Descriptors$FieldDescriptor)this.val$scope.getDescriptorForType().getExtensions().get(this.val$descriptorIndex);
    }
}

