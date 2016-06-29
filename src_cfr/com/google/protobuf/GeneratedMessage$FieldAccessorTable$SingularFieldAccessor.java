/*
 * Decompiled with CFR 0_115.
 */
package com.google.protobuf;

import com.google.protobuf.Descriptors$FieldDescriptor;
import com.google.protobuf.Descriptors$FieldDescriptor$JavaType;
import com.google.protobuf.Descriptors$FileDescriptor;
import com.google.protobuf.Descriptors$OneofDescriptor;
import com.google.protobuf.GeneratedMessage;
import com.google.protobuf.GeneratedMessage$Builder;
import com.google.protobuf.GeneratedMessage$FieldAccessorTable;
import com.google.protobuf.GeneratedMessage$FieldAccessorTable$FieldAccessor;
import com.google.protobuf.Internal$EnumLite;
import com.google.protobuf.Message$Builder;
import java.lang.reflect.Method;

class GeneratedMessage$FieldAccessorTable$SingularFieldAccessor
implements GeneratedMessage$FieldAccessorTable$FieldAccessor {
    protected final Class type;
    protected final Method getMethod;
    protected final Method getMethodBuilder;
    protected final Method setMethod;
    protected final Method hasMethod;
    protected final Method hasMethodBuilder;
    protected final Method clearMethod;
    protected final Method caseMethod;
    protected final Method caseMethodBuilder;
    protected final Descriptors$FieldDescriptor field;
    protected final boolean isOneofField;
    protected final boolean hasHasMethod;

    GeneratedMessage$FieldAccessorTable$SingularFieldAccessor(Descriptors$FieldDescriptor descriptors$FieldDescriptor, String string, Class class_, Class class_2, String string2) {
        Method method;
        Method method2;
        Method method3;
        Method method4;
        this.field = descriptors$FieldDescriptor;
        this.isOneofField = descriptors$FieldDescriptor.getContainingOneof() != null;
        this.hasHasMethod = GeneratedMessage$FieldAccessorTable.access$1300(descriptors$FieldDescriptor.getFile()) || !this.isOneofField && descriptors$FieldDescriptor.getJavaType() == Descriptors$FieldDescriptor$JavaType.MESSAGE;
        String string3 = String.valueOf(string);
        this.getMethod = GeneratedMessage.access$1100(class_, string3.length() != 0 ? "get".concat(string3) : new String("get"), new Class[0]);
        String string4 = String.valueOf(string);
        this.getMethodBuilder = GeneratedMessage.access$1100(class_2, string4.length() != 0 ? "get".concat(string4) : new String("get"), new Class[0]);
        this.type = this.getMethod.getReturnType();
        String string5 = String.valueOf(string);
        this.setMethod = GeneratedMessage.access$1100(class_2, string5.length() != 0 ? "set".concat(string5) : new String("set"), new Class[]{this.type});
        if (this.hasHasMethod) {
            String string6 = String.valueOf(string);
            method4 = GeneratedMessage.access$1100(class_, string6.length() != 0 ? "has".concat(string6) : new String("has"), new Class[0]);
        } else {
            method4 = this.hasMethod = null;
        }
        if (this.hasHasMethod) {
            String string7 = String.valueOf(string);
            method3 = GeneratedMessage.access$1100(class_2, string7.length() != 0 ? "has".concat(string7) : new String("has"), new Class[0]);
        } else {
            method3 = null;
        }
        this.hasMethodBuilder = method3;
        String string8 = String.valueOf(string);
        this.clearMethod = GeneratedMessage.access$1100(class_2, string8.length() != 0 ? "clear".concat(string8) : new String("clear"), new Class[0]);
        if (this.isOneofField) {
            String string9 = String.valueOf(String.valueOf(string2));
            method = GeneratedMessage.access$1100(class_, new StringBuilder(7 + string9.length()).append("get").append(string9).append("Case").toString(), new Class[0]);
        } else {
            method = this.caseMethod = null;
        }
        if (this.isOneofField) {
            String string10 = String.valueOf(String.valueOf(string2));
            method2 = GeneratedMessage.access$1100(class_2, new StringBuilder(7 + string10.length()).append("get").append(string10).append("Case").toString(), new Class[0]);
        } else {
            method2 = null;
        }
        this.caseMethodBuilder = method2;
    }

    private int getOneofFieldNumber(GeneratedMessage generatedMessage) {
        return ((Internal$EnumLite)GeneratedMessage.access$1200(this.caseMethod, generatedMessage, new Object[0])).getNumber();
    }

    private int getOneofFieldNumber(GeneratedMessage$Builder generatedMessage$Builder) {
        return ((Internal$EnumLite)GeneratedMessage.access$1200(this.caseMethodBuilder, generatedMessage$Builder, new Object[0])).getNumber();
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
        GeneratedMessage.access$1200(this.setMethod, generatedMessage$Builder, new Object[]{object});
    }

    @Override
    public Object getRepeated(GeneratedMessage generatedMessage, int n2) {
        throw new UnsupportedOperationException("getRepeatedField() called on a singular field.");
    }

    @Override
    public Object getRepeatedRaw(GeneratedMessage generatedMessage, int n2) {
        throw new UnsupportedOperationException("getRepeatedFieldRaw() called on a singular field.");
    }

    @Override
    public Object getRepeated(GeneratedMessage$Builder generatedMessage$Builder, int n2) {
        throw new UnsupportedOperationException("getRepeatedField() called on a singular field.");
    }

    @Override
    public Object getRepeatedRaw(GeneratedMessage$Builder generatedMessage$Builder, int n2) {
        throw new UnsupportedOperationException("getRepeatedFieldRaw() called on a singular field.");
    }

    @Override
    public void setRepeated(GeneratedMessage$Builder generatedMessage$Builder, int n2, Object object) {
        throw new UnsupportedOperationException("setRepeatedField() called on a singular field.");
    }

    @Override
    public void addRepeated(GeneratedMessage$Builder generatedMessage$Builder, Object object) {
        throw new UnsupportedOperationException("addRepeatedField() called on a singular field.");
    }

    @Override
    public boolean has(GeneratedMessage generatedMessage) {
        if (this.hasHasMethod) return (Boolean)GeneratedMessage.access$1200(this.hasMethod, generatedMessage, new Object[0]);
        if (this.isOneofField) {
            if (this.getOneofFieldNumber(generatedMessage) != this.field.getNumber()) return false;
            return true;
        }
        if (this.get(generatedMessage).equals(this.field.getDefaultValue())) return false;
        return true;
    }

    @Override
    public boolean has(GeneratedMessage$Builder generatedMessage$Builder) {
        if (this.hasHasMethod) return (Boolean)GeneratedMessage.access$1200(this.hasMethodBuilder, generatedMessage$Builder, new Object[0]);
        if (this.isOneofField) {
            if (this.getOneofFieldNumber(generatedMessage$Builder) != this.field.getNumber()) return false;
            return true;
        }
        if (this.get(generatedMessage$Builder).equals(this.field.getDefaultValue())) return false;
        return true;
    }

    @Override
    public int getRepeatedCount(GeneratedMessage generatedMessage) {
        throw new UnsupportedOperationException("getRepeatedFieldSize() called on a singular field.");
    }

    @Override
    public int getRepeatedCount(GeneratedMessage$Builder generatedMessage$Builder) {
        throw new UnsupportedOperationException("getRepeatedFieldSize() called on a singular field.");
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

