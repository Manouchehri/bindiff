/*
 * Decompiled with CFR 0_115.
 */
package com.google.protobuf;

import com.google.protobuf.Descriptors$FieldDescriptor;
import com.google.protobuf.GeneratedMessage;
import com.google.protobuf.GeneratedMessage$ExtensionDescriptorRetriever;
import com.google.protobuf.GeneratedMessage$GeneratedExtension;

class GeneratedMessage$GeneratedExtension$1
implements GeneratedMessage$ExtensionDescriptorRetriever {
    final /* synthetic */ Descriptors$FieldDescriptor val$descriptor;
    final /* synthetic */ GeneratedMessage.GeneratedExtension this$0;

    GeneratedMessage$GeneratedExtension$1(GeneratedMessage.GeneratedExtension generatedExtension, Descriptors$FieldDescriptor descriptors$FieldDescriptor) {
        this.this$0 = generatedExtension;
        this.val$descriptor = descriptors$FieldDescriptor;
    }

    @Override
    public Descriptors$FieldDescriptor getDescriptor() {
        return this.val$descriptor;
    }
}

