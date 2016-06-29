package com.google.protobuf;

import java.io.*;
import java.util.*;
import java.lang.reflect.*;

final class GeneratedMessage$FieldAccessorTable$SingularStringFieldAccessor extends GeneratedMessage$FieldAccessorTable$SingularFieldAccessor
{
    private final Method getBytesMethod;
    private final Method getBytesMethodBuilder;
    private final Method setBytesMethodBuilder;
    
    GeneratedMessage$FieldAccessorTable$SingularStringFieldAccessor(final Descriptors$FieldDescriptor descriptors$FieldDescriptor, final String s, final Class clazz, final Class clazz2, final String s2) {
        super(descriptors$FieldDescriptor, s, clazz, clazz2, s2);
        final String value = String.valueOf(String.valueOf(s));
        this.getBytesMethod = getMethodOrDie(clazz, new StringBuilder(8 + value.length()).append("get").append(value).append("Bytes").toString(), new Class[0]);
        final String value2 = String.valueOf(String.valueOf(s));
        this.getBytesMethodBuilder = getMethodOrDie(clazz2, new StringBuilder(8 + value2.length()).append("get").append(value2).append("Bytes").toString(), new Class[0]);
        final String value3 = String.valueOf(String.valueOf(s));
        this.setBytesMethodBuilder = getMethodOrDie(clazz2, new StringBuilder(8 + value3.length()).append("set").append(value3).append("Bytes").toString(), new Class[] { ByteString.class });
    }
    
    public Object getRaw(final GeneratedMessage generatedMessage) {
        return invokeOrDie(this.getBytesMethod, generatedMessage, new Object[0]);
    }
    
    public Object getRaw(final GeneratedMessage$Builder generatedMessage$Builder) {
        return invokeOrDie(this.getBytesMethodBuilder, generatedMessage$Builder, new Object[0]);
    }
    
    public void set(final GeneratedMessage$Builder generatedMessage$Builder, final Object o) {
        if (o instanceof ByteString) {
            invokeOrDie(this.setBytesMethodBuilder, generatedMessage$Builder, new Object[] { o });
        }
        else {
            super.set(generatedMessage$Builder, o);
        }
    }
}
