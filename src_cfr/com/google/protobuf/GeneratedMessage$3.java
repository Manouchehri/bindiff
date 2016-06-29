/*
 * Decompiled with CFR 0_115.
 */
package com.google.protobuf;

import com.google.protobuf.Descriptors$FieldDescriptor;
import com.google.protobuf.Descriptors$FileDescriptor;
import com.google.protobuf.GeneratedMessage$1;
import com.google.protobuf.GeneratedMessage$CachedDescriptorRetriever;
import java.lang.reflect.Field;

final class GeneratedMessage$3
extends GeneratedMessage$CachedDescriptorRetriever {
    final /* synthetic */ Class val$singularType;
    final /* synthetic */ String val$descriptorOuterClass;
    final /* synthetic */ String val$extensionName;

    GeneratedMessage$3(Class class_, String string, String string2) {
        this.val$singularType = class_;
        this.val$descriptorOuterClass = string;
        this.val$extensionName = string2;
        super(null);
    }

    @Override
    protected Descriptors$FieldDescriptor loadDescriptor() {
        try {
            Class class_ = this.val$singularType.getClassLoader().loadClass(this.val$descriptorOuterClass);
            Descriptors$FileDescriptor descriptors$FileDescriptor = (Descriptors$FileDescriptor)class_.getField("descriptor").get(null);
            return descriptors$FileDescriptor.findExtensionByName(this.val$extensionName);
        }
        catch (Exception var1_2) {
            String string = String.valueOf(String.valueOf(this.val$descriptorOuterClass));
            throw new RuntimeException(new StringBuilder(62 + string.length()).append("Cannot load descriptors: ").append(string).append(" is not a valid descriptor class name").toString(), var1_2);
        }
    }
}

