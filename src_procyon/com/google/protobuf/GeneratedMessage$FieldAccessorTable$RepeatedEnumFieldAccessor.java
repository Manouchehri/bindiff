package com.google.protobuf;

import java.io.*;
import java.util.*;
import java.lang.reflect.*;

final class GeneratedMessage$FieldAccessorTable$RepeatedEnumFieldAccessor extends GeneratedMessage$FieldAccessorTable$RepeatedFieldAccessor
{
    private Descriptors$EnumDescriptor enumDescriptor;
    private final Method valueOfMethod;
    private final Method getValueDescriptorMethod;
    private boolean supportUnknownEnumValue;
    private Method getRepeatedValueMethod;
    private Method getRepeatedValueMethodBuilder;
    private Method setRepeatedValueMethod;
    private Method addRepeatedValueMethod;
    
    GeneratedMessage$FieldAccessorTable$RepeatedEnumFieldAccessor(final Descriptors$FieldDescriptor descriptors$FieldDescriptor, final String s, final Class clazz, final Class clazz2) {
        super(descriptors$FieldDescriptor, s, clazz, clazz2);
        this.enumDescriptor = descriptors$FieldDescriptor.getEnumType();
        this.valueOfMethod = getMethodOrDie(this.type, "valueOf", new Class[] { Descriptors$EnumValueDescriptor.class });
        this.getValueDescriptorMethod = getMethodOrDie(this.type, "getValueDescriptor", new Class[0]);
        this.supportUnknownEnumValue = descriptors$FieldDescriptor.getFile().supportsUnknownEnumValue();
        if (this.supportUnknownEnumValue) {
            final String value = String.valueOf(String.valueOf(s));
            this.getRepeatedValueMethod = getMethodOrDie(clazz, new StringBuilder(8 + value.length()).append("get").append(value).append("Value").toString(), new Class[] { Integer.TYPE });
            final String value2 = String.valueOf(String.valueOf(s));
            this.getRepeatedValueMethodBuilder = getMethodOrDie(clazz2, new StringBuilder(8 + value2.length()).append("get").append(value2).append("Value").toString(), new Class[] { Integer.TYPE });
            final String value3 = String.valueOf(String.valueOf(s));
            this.setRepeatedValueMethod = getMethodOrDie(clazz2, new StringBuilder(8 + value3.length()).append("set").append(value3).append("Value").toString(), new Class[] { Integer.TYPE, Integer.TYPE });
            final String value4 = String.valueOf(String.valueOf(s));
            this.addRepeatedValueMethod = getMethodOrDie(clazz2, new StringBuilder(8 + value4.length()).append("add").append(value4).append("Value").toString(), new Class[] { Integer.TYPE });
        }
    }
    
    public Object get(final GeneratedMessage generatedMessage) {
        final ArrayList<Object> list = new ArrayList<Object>();
        for (int repeatedCount = this.getRepeatedCount(generatedMessage), i = 0; i < repeatedCount; ++i) {
            list.add(this.getRepeated(generatedMessage, i));
        }
        return Collections.unmodifiableList((List<?>)list);
    }
    
    public Object get(final GeneratedMessage$Builder generatedMessage$Builder) {
        final ArrayList<Object> list = new ArrayList<Object>();
        for (int repeatedCount = this.getRepeatedCount(generatedMessage$Builder), i = 0; i < repeatedCount; ++i) {
            list.add(this.getRepeated(generatedMessage$Builder, i));
        }
        return Collections.unmodifiableList((List<?>)list);
    }
    
    public Object getRepeated(final GeneratedMessage generatedMessage, final int n) {
        if (this.supportUnknownEnumValue) {
            return this.enumDescriptor.findValueByNumberCreatingIfUnknown((int)invokeOrDie(this.getRepeatedValueMethod, generatedMessage, new Object[] { n }));
        }
        return invokeOrDie(this.getValueDescriptorMethod, super.getRepeated(generatedMessage, n), new Object[0]);
    }
    
    public Object getRepeated(final GeneratedMessage$Builder generatedMessage$Builder, final int n) {
        if (this.supportUnknownEnumValue) {
            return this.enumDescriptor.findValueByNumberCreatingIfUnknown((int)invokeOrDie(this.getRepeatedValueMethodBuilder, generatedMessage$Builder, new Object[] { n }));
        }
        return invokeOrDie(this.getValueDescriptorMethod, super.getRepeated(generatedMessage$Builder, n), new Object[0]);
    }
    
    public void setRepeated(final GeneratedMessage$Builder generatedMessage$Builder, final int n, final Object o) {
        if (this.supportUnknownEnumValue) {
            invokeOrDie(this.setRepeatedValueMethod, generatedMessage$Builder, new Object[] { n, ((Descriptors$EnumValueDescriptor)o).getNumber() });
            return;
        }
        super.setRepeated(generatedMessage$Builder, n, invokeOrDie(this.valueOfMethod, null, new Object[] { o }));
    }
    
    public void addRepeated(final GeneratedMessage$Builder generatedMessage$Builder, final Object o) {
        if (this.supportUnknownEnumValue) {
            invokeOrDie(this.addRepeatedValueMethod, generatedMessage$Builder, new Object[] { ((Descriptors$EnumValueDescriptor)o).getNumber() });
            return;
        }
        super.addRepeated(generatedMessage$Builder, invokeOrDie(this.valueOfMethod, null, new Object[] { o }));
    }
}
