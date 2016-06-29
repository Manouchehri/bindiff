package com.google.protobuf;

import java.io.*;
import java.util.*;
import java.lang.reflect.*;

final class GeneratedMessage$FieldAccessorTable$SingularEnumFieldAccessor extends GeneratedMessage$FieldAccessorTable$SingularFieldAccessor
{
    private Descriptors$EnumDescriptor enumDescriptor;
    private Method valueOfMethod;
    private Method getValueDescriptorMethod;
    private boolean supportUnknownEnumValue;
    private Method getValueMethod;
    private Method getValueMethodBuilder;
    private Method setValueMethod;
    
    GeneratedMessage$FieldAccessorTable$SingularEnumFieldAccessor(final Descriptors$FieldDescriptor descriptors$FieldDescriptor, final String s, final Class clazz, final Class clazz2, final String s2) {
        super(descriptors$FieldDescriptor, s, clazz, clazz2, s2);
        this.enumDescriptor = descriptors$FieldDescriptor.getEnumType();
        this.valueOfMethod = getMethodOrDie(this.type, "valueOf", new Class[] { Descriptors$EnumValueDescriptor.class });
        this.getValueDescriptorMethod = getMethodOrDie(this.type, "getValueDescriptor", new Class[0]);
        this.supportUnknownEnumValue = descriptors$FieldDescriptor.getFile().supportsUnknownEnumValue();
        if (this.supportUnknownEnumValue) {
            final String value = String.valueOf(String.valueOf(s));
            this.getValueMethod = getMethodOrDie(clazz, new StringBuilder(8 + value.length()).append("get").append(value).append("Value").toString(), new Class[0]);
            final String value2 = String.valueOf(String.valueOf(s));
            this.getValueMethodBuilder = getMethodOrDie(clazz2, new StringBuilder(8 + value2.length()).append("get").append(value2).append("Value").toString(), new Class[0]);
            final String value3 = String.valueOf(String.valueOf(s));
            this.setValueMethod = getMethodOrDie(clazz2, new StringBuilder(8 + value3.length()).append("set").append(value3).append("Value").toString(), new Class[] { Integer.TYPE });
        }
    }
    
    public Object get(final GeneratedMessage generatedMessage) {
        if (this.supportUnknownEnumValue) {
            return this.enumDescriptor.findValueByNumberCreatingIfUnknown((int)invokeOrDie(this.getValueMethod, generatedMessage, new Object[0]));
        }
        return invokeOrDie(this.getValueDescriptorMethod, super.get(generatedMessage), new Object[0]);
    }
    
    public Object get(final GeneratedMessage$Builder generatedMessage$Builder) {
        if (this.supportUnknownEnumValue) {
            return this.enumDescriptor.findValueByNumberCreatingIfUnknown((int)invokeOrDie(this.getValueMethodBuilder, generatedMessage$Builder, new Object[0]));
        }
        return invokeOrDie(this.getValueDescriptorMethod, super.get(generatedMessage$Builder), new Object[0]);
    }
    
    public void set(final GeneratedMessage$Builder generatedMessage$Builder, final Object o) {
        if (this.supportUnknownEnumValue) {
            invokeOrDie(this.setValueMethod, generatedMessage$Builder, new Object[] { ((Descriptors$EnumValueDescriptor)o).getNumber() });
            return;
        }
        super.set(generatedMessage$Builder, invokeOrDie(this.valueOfMethod, null, new Object[] { o }));
    }
}
