package com.google.protobuf;

import java.io.*;
import java.util.*;
import java.lang.reflect.*;

final class GeneratedMessage$FieldAccessorTable$RepeatedMessageFieldAccessor extends GeneratedMessage$FieldAccessorTable$RepeatedFieldAccessor
{
    private final Method newBuilderMethod;
    private final Method getBuilderMethodBuilder;
    
    GeneratedMessage$FieldAccessorTable$RepeatedMessageFieldAccessor(final Descriptors$FieldDescriptor descriptors$FieldDescriptor, final String s, final Class clazz, final Class clazz2) {
        super(descriptors$FieldDescriptor, s, clazz, clazz2);
        this.newBuilderMethod = getMethodOrDie(this.type, "newBuilder", new Class[0]);
        final String value = String.valueOf(String.valueOf(s));
        this.getBuilderMethodBuilder = getMethodOrDie(clazz2, new StringBuilder(10 + value.length()).append("get").append(value).append("Builder").toString(), new Class[] { Integer.TYPE });
    }
    
    private Object coerceType(final Object o) {
        if (this.type.isInstance(o)) {
            return o;
        }
        return ((Message$Builder)invokeOrDie(this.newBuilderMethod, null, new Object[0])).mergeFrom((Message)o).build();
    }
    
    public void setRepeated(final GeneratedMessage$Builder generatedMessage$Builder, final int n, final Object o) {
        super.setRepeated(generatedMessage$Builder, n, this.coerceType(o));
    }
    
    public void addRepeated(final GeneratedMessage$Builder generatedMessage$Builder, final Object o) {
        super.addRepeated(generatedMessage$Builder, this.coerceType(o));
    }
    
    public Message$Builder newBuilder() {
        return (Message$Builder)invokeOrDie(this.newBuilderMethod, null, new Object[0]);
    }
    
    public Message$Builder getRepeatedBuilder(final GeneratedMessage$Builder generatedMessage$Builder, final int n) {
        return (Message$Builder)invokeOrDie(this.getBuilderMethodBuilder, generatedMessage$Builder, new Object[] { n });
    }
}
