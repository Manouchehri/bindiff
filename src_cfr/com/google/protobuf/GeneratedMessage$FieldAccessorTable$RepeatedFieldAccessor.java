/*
 * Decompiled with CFR 0_115.
 */
package com.google.protobuf;

import com.google.protobuf.Descriptors$FieldDescriptor;
import com.google.protobuf.GeneratedMessage;
import com.google.protobuf.GeneratedMessage$Builder;
import com.google.protobuf.GeneratedMessage$FieldAccessorTable$FieldAccessor;
import com.google.protobuf.Message$Builder;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.List;

class GeneratedMessage$FieldAccessorTable$RepeatedFieldAccessor
implements GeneratedMessage$FieldAccessorTable$FieldAccessor {
    protected final Class type;
    protected final Method getMethod;
    protected final Method getMethodBuilder;
    protected final Method getRepeatedMethod;
    protected final Method getRepeatedMethodBuilder;
    protected final Method setRepeatedMethod;
    protected final Method addRepeatedMethod;
    protected final Method getCountMethod;
    protected final Method getCountMethodBuilder;
    protected final Method clearMethod;

    GeneratedMessage$FieldAccessorTable$RepeatedFieldAccessor(Descriptors$FieldDescriptor descriptors$FieldDescriptor, String string, Class class_, Class class_2) {
        String string2 = String.valueOf(String.valueOf(string));
        this.getMethod = GeneratedMessage.access$1100(class_, new StringBuilder(7 + string2.length()).append("get").append(string2).append("List").toString(), new Class[0]);
        String string3 = String.valueOf(String.valueOf(string));
        this.getMethodBuilder = GeneratedMessage.access$1100(class_2, new StringBuilder(7 + string3.length()).append("get").append(string3).append("List").toString(), new Class[0]);
        String string4 = String.valueOf(string);
        this.getRepeatedMethod = GeneratedMessage.access$1100(class_, string4.length() != 0 ? "get".concat(string4) : new String("get"), new Class[]{Integer.TYPE});
        String string5 = String.valueOf(string);
        this.getRepeatedMethodBuilder = GeneratedMessage.access$1100(class_2, string5.length() != 0 ? "get".concat(string5) : new String("get"), new Class[]{Integer.TYPE});
        this.type = this.getRepeatedMethod.getReturnType();
        String string6 = String.valueOf(string);
        this.setRepeatedMethod = GeneratedMessage.access$1100(class_2, string6.length() != 0 ? "set".concat(string6) : new String("set"), new Class[]{Integer.TYPE, this.type});
        String string7 = String.valueOf(string);
        this.addRepeatedMethod = GeneratedMessage.access$1100(class_2, string7.length() != 0 ? "add".concat(string7) : new String("add"), new Class[]{this.type});
        String string8 = String.valueOf(String.valueOf(string));
        this.getCountMethod = GeneratedMessage.access$1100(class_, new StringBuilder(8 + string8.length()).append("get").append(string8).append("Count").toString(), new Class[0]);
        String string9 = String.valueOf(String.valueOf(string));
        this.getCountMethodBuilder = GeneratedMessage.access$1100(class_2, new StringBuilder(8 + string9.length()).append("get").append(string9).append("Count").toString(), new Class[0]);
        String string10 = String.valueOf(string);
        this.clearMethod = GeneratedMessage.access$1100(class_2, string10.length() != 0 ? "clear".concat(string10) : new String("clear"), new Class[0]);
    }

    @Override
    public Object get(GeneratedMessage generatedMessage) {
        return GeneratedMessage.access$1200(this.getMethod, generatedMessage, new Object[0]);
    }

    @Override
    public Object get(GeneratedMessage$Builder generatedMessage$Builder) {
        return GeneratedMessage.access$1200(this.getMethodBuilder, generatedMessage$Builder, new Object[0]);
    }

    @Override
    public Object getRaw(GeneratedMessage generatedMessage) {
        return this.get(generatedMessage);
    }

    @Override
    public Object getRaw(GeneratedMessage$Builder generatedMessage$Builder) {
        return this.get(generatedMessage$Builder);
    }

    @Override
    public void set(GeneratedMessage$Builder generatedMessage$Builder, Object object) {
        this.clear(generatedMessage$Builder);
        Iterator iterator = ((List)object).iterator();
        while (iterator.hasNext()) {
            Object e2 = iterator.next();
            this.addRepeated(generatedMessage$Builder, e2);
        }
    }

    @Override
    public Object getRepeated(GeneratedMessage generatedMessage, int n2) {
        return GeneratedMessage.access$1200(this.getRepeatedMethod, generatedMessage, new Object[]{n2});
    }

    @Override
    public Object getRepeated(GeneratedMessage$Builder generatedMessage$Builder, int n2) {
        return GeneratedMessage.access$1200(this.getRepeatedMethodBuilder, generatedMessage$Builder, new Object[]{n2});
    }

    @Override
    public Object getRepeatedRaw(GeneratedMessage generatedMessage, int n2) {
        return this.getRepeated(generatedMessage, n2);
    }

    @Override
    public Object getRepeatedRaw(GeneratedMessage$Builder generatedMessage$Builder, int n2) {
        return this.getRepeated(generatedMessage$Builder, n2);
    }

    @Override
    public void setRepeated(GeneratedMessage$Builder generatedMessage$Builder, int n2, Object object) {
        GeneratedMessage.access$1200(this.setRepeatedMethod, generatedMessage$Builder, new Object[]{n2, object});
    }

    @Override
    public void addRepeated(GeneratedMessage$Builder generatedMessage$Builder, Object object) {
        GeneratedMessage.access$1200(this.addRepeatedMethod, generatedMessage$Builder, new Object[]{object});
    }

    @Override
    public boolean has(GeneratedMessage generatedMessage) {
        throw new UnsupportedOperationException("hasField() called on a repeated field.");
    }

    @Override
    public boolean has(GeneratedMessage$Builder generatedMessage$Builder) {
        throw new UnsupportedOperationException("hasField() called on a repeated field.");
    }

    @Override
    public int getRepeatedCount(GeneratedMessage generatedMessage) {
        return (Integer)GeneratedMessage.access$1200(this.getCountMethod, generatedMessage, new Object[0]);
    }

    @Override
    public int getRepeatedCount(GeneratedMessage$Builder generatedMessage$Builder) {
        return (Integer)GeneratedMessage.access$1200(this.getCountMethodBuilder, generatedMessage$Builder, new Object[0]);
    }

    @Override
    public void clear(GeneratedMessage$Builder generatedMessage$Builder) {
        GeneratedMessage.access$1200(this.clearMethod, generatedMessage$Builder, new Object[0]);
    }

    @Override
    public Message$Builder newBuilder() {
        throw new UnsupportedOperationException("newBuilderForField() called on a non-Message type.");
    }

    @Override
    public Message$Builder getBuilder(GeneratedMessage$Builder generatedMessage$Builder) {
        throw new UnsupportedOperationException("getFieldBuilder() called on a non-Message type.");
    }

    @Override
    public Message$Builder getRepeatedBuilder(GeneratedMessage$Builder generatedMessage$Builder, int n2) {
        throw new UnsupportedOperationException("getRepeatedFieldBuilder() called on a non-Message type.");
    }
}

