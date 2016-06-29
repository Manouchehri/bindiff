package com.google.protobuf;

import java.io.*;
import java.util.*;
import java.lang.reflect.*;

class GeneratedMessage$FieldAccessorTable$RepeatedFieldAccessor implements GeneratedMessage$FieldAccessorTable$FieldAccessor
{
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
    
    GeneratedMessage$FieldAccessorTable$RepeatedFieldAccessor(final Descriptors$FieldDescriptor descriptors$FieldDescriptor, final String s, final Class clazz, final Class clazz2) {
        final String value = String.valueOf(String.valueOf(s));
        this.getMethod = getMethodOrDie(clazz, new StringBuilder(7 + value.length()).append("get").append(value).append("List").toString(), new Class[0]);
        final String value2 = String.valueOf(String.valueOf(s));
        this.getMethodBuilder = getMethodOrDie(clazz2, new StringBuilder(7 + value2.length()).append("get").append(value2).append("List").toString(), new Class[0]);
        final String s2 = "get";
        final String value3 = String.valueOf(s);
        this.getRepeatedMethod = getMethodOrDie(clazz, (value3.length() != 0) ? s2.concat(value3) : new String(s2), new Class[] { Integer.TYPE });
        final String s3 = "get";
        final String value4 = String.valueOf(s);
        this.getRepeatedMethodBuilder = getMethodOrDie(clazz2, (value4.length() != 0) ? s3.concat(value4) : new String(s3), new Class[] { Integer.TYPE });
        this.type = this.getRepeatedMethod.getReturnType();
        final String s4 = "set";
        final String value5 = String.valueOf(s);
        this.setRepeatedMethod = getMethodOrDie(clazz2, (value5.length() != 0) ? s4.concat(value5) : new String(s4), new Class[] { Integer.TYPE, this.type });
        final String s5 = "add";
        final String value6 = String.valueOf(s);
        this.addRepeatedMethod = getMethodOrDie(clazz2, (value6.length() != 0) ? s5.concat(value6) : new String(s5), new Class[] { this.type });
        final String value7 = String.valueOf(String.valueOf(s));
        this.getCountMethod = getMethodOrDie(clazz, new StringBuilder(8 + value7.length()).append("get").append(value7).append("Count").toString(), new Class[0]);
        final String value8 = String.valueOf(String.valueOf(s));
        this.getCountMethodBuilder = getMethodOrDie(clazz2, new StringBuilder(8 + value8.length()).append("get").append(value8).append("Count").toString(), new Class[0]);
        final String s6 = "clear";
        final String value9 = String.valueOf(s);
        this.clearMethod = getMethodOrDie(clazz2, (value9.length() != 0) ? s6.concat(value9) : new String(s6), new Class[0]);
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
        this.clear(generatedMessage$Builder);
        final Iterator<Object> iterator = ((List)o).iterator();
        while (iterator.hasNext()) {
            this.addRepeated(generatedMessage$Builder, iterator.next());
        }
    }
    
    public Object getRepeated(final GeneratedMessage generatedMessage, final int n) {
        return invokeOrDie(this.getRepeatedMethod, generatedMessage, new Object[] { n });
    }
    
    public Object getRepeated(final GeneratedMessage$Builder generatedMessage$Builder, final int n) {
        return invokeOrDie(this.getRepeatedMethodBuilder, generatedMessage$Builder, new Object[] { n });
    }
    
    public Object getRepeatedRaw(final GeneratedMessage generatedMessage, final int n) {
        return this.getRepeated(generatedMessage, n);
    }
    
    public Object getRepeatedRaw(final GeneratedMessage$Builder generatedMessage$Builder, final int n) {
        return this.getRepeated(generatedMessage$Builder, n);
    }
    
    public void setRepeated(final GeneratedMessage$Builder generatedMessage$Builder, final int n, final Object o) {
        invokeOrDie(this.setRepeatedMethod, generatedMessage$Builder, new Object[] { n, o });
    }
    
    public void addRepeated(final GeneratedMessage$Builder generatedMessage$Builder, final Object o) {
        invokeOrDie(this.addRepeatedMethod, generatedMessage$Builder, new Object[] { o });
    }
    
    public boolean has(final GeneratedMessage generatedMessage) {
        throw new UnsupportedOperationException("hasField() called on a repeated field.");
    }
    
    public boolean has(final GeneratedMessage$Builder generatedMessage$Builder) {
        throw new UnsupportedOperationException("hasField() called on a repeated field.");
    }
    
    public int getRepeatedCount(final GeneratedMessage generatedMessage) {
        return (int)invokeOrDie(this.getCountMethod, generatedMessage, new Object[0]);
    }
    
    public int getRepeatedCount(final GeneratedMessage$Builder generatedMessage$Builder) {
        return (int)invokeOrDie(this.getCountMethodBuilder, generatedMessage$Builder, new Object[0]);
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
