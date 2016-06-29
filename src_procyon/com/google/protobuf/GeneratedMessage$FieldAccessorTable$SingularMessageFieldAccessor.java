package com.google.protobuf;

import java.io.*;
import java.util.*;
import java.lang.reflect.*;

final class GeneratedMessage$FieldAccessorTable$SingularMessageFieldAccessor extends GeneratedMessage$FieldAccessorTable$SingularFieldAccessor
{
    private final Method newBuilderMethod;
    private final Method getBuilderMethodBuilder;
    
    GeneratedMessage$FieldAccessorTable$SingularMessageFieldAccessor(final Descriptors$FieldDescriptor descriptors$FieldDescriptor, final String s, final Class clazz, final Class clazz2, final String s2) {
        super(descriptors$FieldDescriptor, s, clazz, clazz2, s2);
        this.newBuilderMethod = getMethodOrDie(this.type, "newBuilder", new Class[0]);
        final String value = String.valueOf(String.valueOf(s));
        this.getBuilderMethodBuilder = getMethodOrDie(clazz2, new StringBuilder(10 + value.length()).append("get").append(value).append("Builder").toString(), new Class[0]);
    }
    
    private Object coerceType(final Object o) {
        if (this.type.isInstance(o)) {
            return o;
        }
        return ((Message$Builder)invokeOrDie(this.newBuilderMethod, null, new Object[0])).mergeFrom((Message)o).buildPartial();
    }
    
    public void set(final GeneratedMessage$Builder generatedMessage$Builder, final Object o) {
        super.set(generatedMessage$Builder, this.coerceType(o));
    }
    
    public Message$Builder newBuilder() {
        return (Message$Builder)invokeOrDie(this.newBuilderMethod, null, new Object[0]);
    }
    
    public Message$Builder getBuilder(final GeneratedMessage$Builder generatedMessage$Builder) {
        return (Message$Builder)invokeOrDie(this.getBuilderMethodBuilder, generatedMessage$Builder, new Object[0]);
    }
}
