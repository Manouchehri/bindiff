/*
 * Decompiled with CFR 0_115.
 */
package com.google.protobuf;

import com.google.protobuf.Descriptors$FieldDescriptor;
import com.google.protobuf.GeneratedMessage;
import com.google.protobuf.GeneratedMessage$Builder;
import com.google.protobuf.GeneratedMessage$FieldAccessorTable$RepeatedFieldAccessor;
import com.google.protobuf.Message;
import com.google.protobuf.Message$Builder;
import java.lang.reflect.Method;

final class GeneratedMessage$FieldAccessorTable$RepeatedMessageFieldAccessor
extends GeneratedMessage$FieldAccessorTable$RepeatedFieldAccessor {
    private final Method newBuilderMethod;
    private final Method getBuilderMethodBuilder;

    GeneratedMessage$FieldAccessorTable$RepeatedMessageFieldAccessor(Descriptors$FieldDescriptor descriptors$FieldDescriptor, String string, Class class_, Class class_2) {
        super(descriptors$FieldDescriptor, string, class_, class_2);
        this.newBuilderMethod = GeneratedMessage.access$1100(this.type, "newBuilder", new Class[0]);
        String string2 = String.valueOf(String.valueOf(string));
        this.getBuilderMethodBuilder = GeneratedMessage.access$1100(class_2, new StringBuilder(10 + string2.length()).append("get").append(string2).append("Builder").toString(), new Class[]{Integer.TYPE});
    }

    private Object coerceType(Object object) {
        if (!this.type.isInstance(object)) return ((Message$Builder)GeneratedMessage.access$1200(this.newBuilderMethod, null, new Object[0])).mergeFrom((Message)object).build();
        return object;
    }

    @Override
    public void setRepeated(GeneratedMessage$Builder generatedMessage$Builder, int n2, Object object) {
        super.setRepeated(generatedMessage$Builder, n2, this.coerceType(object));
    }

    @Override
    public void addRepeated(GeneratedMessage$Builder generatedMessage$Builder, Object object) {
        super.addRepeated(generatedMessage$Builder, this.coerceType(object));
    }

    @Override
    public Message$Builder newBuilder() {
        return (Message$Builder)GeneratedMessage.access$1200(this.newBuilderMethod, null, new Object[0]);
    }

    @Override
    public Message$Builder getRepeatedBuilder(GeneratedMessage$Builder generatedMessage$Builder, int n2) {
        return (Message$Builder)GeneratedMessage.access$1200(this.getBuilderMethodBuilder, generatedMessage$Builder, new Object[]{n2});
    }
}

