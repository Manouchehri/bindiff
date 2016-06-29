/*
 * Decompiled with CFR 0_115.
 */
package com.google.protobuf;

import com.google.protobuf.ByteString;
import com.google.protobuf.Descriptors$FieldDescriptor;
import com.google.protobuf.GeneratedMessage;
import com.google.protobuf.GeneratedMessage$Builder;
import com.google.protobuf.GeneratedMessage$FieldAccessorTable$SingularFieldAccessor;
import java.lang.reflect.Method;

final class GeneratedMessage$FieldAccessorTable$SingularStringFieldAccessor
extends GeneratedMessage$FieldAccessorTable$SingularFieldAccessor {
    private final Method getBytesMethod;
    private final Method getBytesMethodBuilder;
    private final Method setBytesMethodBuilder;

    GeneratedMessage$FieldAccessorTable$SingularStringFieldAccessor(Descriptors$FieldDescriptor descriptors$FieldDescriptor, String string, Class class_, Class class_2, String string2) {
        super(descriptors$FieldDescriptor, string, class_, class_2, string2);
        String string3 = String.valueOf(String.valueOf(string));
        this.getBytesMethod = GeneratedMessage.access$1100(class_, new StringBuilder(8 + string3.length()).append("get").append(string3).append("Bytes").toString(), new Class[0]);
        String string4 = String.valueOf(String.valueOf(string));
        this.getBytesMethodBuilder = GeneratedMessage.access$1100(class_2, new StringBuilder(8 + string4.length()).append("get").append(string4).append("Bytes").toString(), new Class[0]);
        String string5 = String.valueOf(String.valueOf(string));
        this.setBytesMethodBuilder = GeneratedMessage.access$1100(class_2, new StringBuilder(8 + string5.length()).append("set").append(string5).append("Bytes").toString(), new Class[]{ByteString.class});
    }

    @Override
    public Object getRaw(GeneratedMessage generatedMessage) {
        return GeneratedMessage.access$1200(this.getBytesMethod, generatedMessage, new Object[0]);
    }

    @Override
    public Object getRaw(GeneratedMessage$Builder generatedMessage$Builder) {
        return GeneratedMessage.access$1200(this.getBytesMethodBuilder, generatedMessage$Builder, new Object[0]);
    }

    @Override
    public void set(GeneratedMessage$Builder generatedMessage$Builder, Object object) {
        if (object instanceof ByteString) {
            GeneratedMessage.access$1200(this.setBytesMethodBuilder, generatedMessage$Builder, new Object[]{object});
            return;
        }
        super.set(generatedMessage$Builder, object);
    }
}

