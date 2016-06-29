/*
 * Decompiled with CFR 0_115.
 */
package com.google.protobuf;

import com.google.protobuf.Descriptors$FieldDescriptor;
import com.google.protobuf.GeneratedMessage;
import com.google.protobuf.GeneratedMessage$Builder;
import com.google.protobuf.GeneratedMessage$FieldAccessorTable$SingularFieldAccessor;
import com.google.protobuf.Message;
import com.google.protobuf.Message$Builder;
import java.lang.reflect.Method;

final class GeneratedMessage$FieldAccessorTable$SingularMessageFieldAccessor
extends GeneratedMessage$FieldAccessorTable$SingularFieldAccessor {
    private final Method newBuilderMethod;
    private final Method getBuilderMethodBuilder;

    GeneratedMessage$FieldAccessorTable$SingularMessageFieldAccessor(Descriptors$FieldDescriptor descriptors$FieldDescriptor, String string, Class class_, Class class_2, String string2) {
        super(descriptors$FieldDescriptor, string, class_, class_2, string2);
        this.newBuilderMethod = GeneratedMessage.access$1100(this.type, "newBuilder", new Class[0]);
        String string3 = String.valueOf(String.valueOf(string));
        this.getBuilderMethodBuilder = GeneratedMessage.access$1100(class_2, new StringBuilder(10 + string3.length()).append("get").append(string3).append("Builder").toString(), new Class[0]);
    }

    private Object coerceType(Object object) {
        if (!this.type.isInstance(object)) return ((Message$Builder)GeneratedMessage.access$1200(this.newBuilderMethod, null, new Object[0])).mergeFrom((Message)object).buildPartial();
        return object;
    }

    @Override
    public void set(GeneratedMessage$Builder generatedMessage$Builder, Object object) {
        super.set(generatedMessage$Builder, this.coerceType(object));
    }

    @Override
    public Message$Builder newBuilder() {
        return (Message$Builder)GeneratedMessage.access$1200(this.newBuilderMethod, null, new Object[0]);
    }

    @Override
    public Message$Builder getBuilder(GeneratedMessage$Builder generatedMessage$Builder) {
        return (Message$Builder)GeneratedMessage.access$1200(this.getBuilderMethodBuilder, generatedMessage$Builder, new Object[0]);
    }
}

