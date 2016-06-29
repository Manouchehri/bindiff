package com.google.protobuf;

import java.io.*;
import java.util.*;
import java.lang.reflect.*;

class GeneratedMessage$FieldAccessorTable$SingularFieldAccessor implements GeneratedMessage$FieldAccessorTable$FieldAccessor
{
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
    
    GeneratedMessage$FieldAccessorTable$SingularFieldAccessor(final Descriptors$FieldDescriptor field, final String s, final Class clazz, final Class clazz2, final String s2) {
        this.field = field;
        this.isOneofField = (field.getContainingOneof() != null);
        this.hasHasMethod = (supportFieldPresence(field.getFile()) || (!this.isOneofField && field.getJavaType() == Descriptors$FieldDescriptor$JavaType.MESSAGE));
        final String s3 = "get";
        final String value = String.valueOf(s);
        this.getMethod = getMethodOrDie(clazz, (value.length() != 0) ? s3.concat(value) : new String(s3), new Class[0]);
        final String s4 = "get";
        final String value2 = String.valueOf(s);
        this.getMethodBuilder = getMethodOrDie(clazz2, (value2.length() != 0) ? s4.concat(value2) : new String(s4), new Class[0]);
        this.type = this.getMethod.getReturnType();
        final String s5 = "set";
        final String value3 = String.valueOf(s);
        this.setMethod = getMethodOrDie(clazz2, (value3.length() != 0) ? s5.concat(value3) : new String(s5), new Class[] { this.type });
        Method access$1100;
        if (this.hasHasMethod) {
            final String s6 = "has";
            final String value4 = String.valueOf(s);
            access$1100 = getMethodOrDie(clazz, (value4.length() != 0) ? s6.concat(value4) : new String(s6), new Class[0]);
        }
        else {
            access$1100 = null;
        }
        this.hasMethod = access$1100;
        Method access$1101;
        if (this.hasHasMethod) {
            final String s7 = "has";
            final String value5 = String.valueOf(s);
            access$1101 = getMethodOrDie(clazz2, (value5.length() != 0) ? s7.concat(value5) : new String(s7), new Class[0]);
        }
        else {
            access$1101 = null;
        }
        this.hasMethodBuilder = access$1101;
        final String s8 = "clear";
        final String value6 = String.valueOf(s);
        this.clearMethod = getMethodOrDie(clazz2, (value6.length() != 0) ? s8.concat(value6) : new String(s8), new Class[0]);
        Method access$1102;
        if (this.isOneofField) {
            final String value7 = String.valueOf(String.valueOf(s2));
            access$1102 = getMethodOrDie(clazz, new StringBuilder(7 + value7.length()).append("get").append(value7).append("Case").toString(), new Class[0]);
        }
        else {
            access$1102 = null;
        }
        this.caseMethod = access$1102;
        Method access$1103;
        if (this.isOneofField) {
            final String value8 = String.valueOf(String.valueOf(s2));
            access$1103 = getMethodOrDie(clazz2, new StringBuilder(7 + value8.length()).append("get").append(value8).append("Case").toString(), new Class[0]);
        }
        else {
            access$1103 = null;
        }
        this.caseMethodBuilder = access$1103;
    }
    
    private int getOneofFieldNumber(final GeneratedMessage generatedMessage) {
        return ((Internal$EnumLite)invokeOrDie(this.caseMethod, generatedMessage, new Object[0])).getNumber();
    }
    
    private int getOneofFieldNumber(final GeneratedMessage$Builder generatedMessage$Builder) {
        return ((Internal$EnumLite)invokeOrDie(this.caseMethodBuilder, generatedMessage$Builder, new Object[0])).getNumber();
    }
    
    public Object get(final GeneratedMessage generatedMessage) {
        return invokeOrDie(this.getMethod, generatedMessage, new Object[0]);
    }
    
    public Object get(final GeneratedMessage$Builder generatedMessage$Builder) {
        return invokeOrDie(this.getMethodBuilder, generatedMessage$Builder, new Object[0]);
    }
    
    public Object getRaw(final GeneratedMessage generatedMessage) {
        return this.get(generatedMessage);
    }
    
    public Object getRaw(final GeneratedMessage$Builder generatedMessage$Builder) {
        return this.get(generatedMessage$Builder);
    }
    
    public void set(final GeneratedMessage$Builder generatedMessage$Builder, final Object o) {
        invokeOrDie(this.setMethod, generatedMessage$Builder, new Object[] { o });
    }
    
    public Object getRepeated(final GeneratedMessage generatedMessage, final int n) {
        throw new UnsupportedOperationException("getRepeatedField() called on a singular field.");
    }
    
    public Object getRepeatedRaw(final GeneratedMessage generatedMessage, final int n) {
        throw new UnsupportedOperationException("getRepeatedFieldRaw() called on a singular field.");
    }
    
    public Object getRepeated(final GeneratedMessage$Builder generatedMessage$Builder, final int n) {
        throw new UnsupportedOperationException("getRepeatedField() called on a singular field.");
    }
    
    public Object getRepeatedRaw(final GeneratedMessage$Builder generatedMessage$Builder, final int n) {
        throw new UnsupportedOperationException("getRepeatedFieldRaw() called on a singular field.");
    }
    
    public void setRepeated(final GeneratedMessage$Builder generatedMessage$Builder, final int n, final Object o) {
        throw new UnsupportedOperationException("setRepeatedField() called on a singular field.");
    }
    
    public void addRepeated(final GeneratedMessage$Builder generatedMessage$Builder, final Object o) {
        throw new UnsupportedOperationException("addRepeatedField() called on a singular field.");
    }
    
    public boolean has(final GeneratedMessage generatedMessage) {
        if (this.hasHasMethod) {
            return (boolean)invokeOrDie(this.hasMethod, generatedMessage, new Object[0]);
        }
        if (this.isOneofField) {
            return this.getOneofFieldNumber(generatedMessage) == this.field.getNumber();
        }
        return !this.get(generatedMessage).equals(this.field.getDefaultValue());
    }
    
    public boolean has(final GeneratedMessage$Builder generatedMessage$Builder) {
        if (this.hasHasMethod) {
            return (boolean)invokeOrDie(this.hasMethodBuilder, generatedMessage$Builder, new Object[0]);
        }
        if (this.isOneofField) {
            return this.getOneofFieldNumber(generatedMessage$Builder) == this.field.getNumber();
        }
        return !this.get(generatedMessage$Builder).equals(this.field.getDefaultValue());
    }
    
    public int getRepeatedCount(final GeneratedMessage generatedMessage) {
        throw new UnsupportedOperationException("getRepeatedFieldSize() called on a singular field.");
    }
    
    public int getRepeatedCount(final GeneratedMessage$Builder generatedMessage$Builder) {
        throw new UnsupportedOperationException("getRepeatedFieldSize() called on a singular field.");
    }
    
    public void clear(final GeneratedMessage$Builder generatedMessage$Builder) {
        invokeOrDie(this.clearMethod, generatedMessage$Builder, new Object[0]);
    }
    
    public Message$Builder newBuilder() {
        throw new UnsupportedOperationException("newBuilderForField() called on a non-Message type.");
    }
    
    public Message$Builder getBuilder(final GeneratedMessage$Builder generatedMessage$Builder) {
        throw new UnsupportedOperationException("getFieldBuilder() called on a non-Message type.");
    }
    
    public Message$Builder getRepeatedBuilder(final GeneratedMessage$Builder generatedMessage$Builder, final int n) {
        throw new UnsupportedOperationException("getRepeatedFieldBuilder() called on a non-Message type.");
    }
}
