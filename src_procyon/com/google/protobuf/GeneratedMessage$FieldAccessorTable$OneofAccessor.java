package com.google.protobuf;

import java.io.*;
import java.util.*;
import java.lang.reflect.*;

class GeneratedMessage$FieldAccessorTable$OneofAccessor
{
    private final Descriptors$Descriptor descriptor;
    private final Method caseMethod;
    private final Method caseMethodBuilder;
    private final Method clearMethod;
    
    GeneratedMessage$FieldAccessorTable$OneofAccessor(final Descriptors$Descriptor descriptor, final String s, final Class clazz, final Class clazz2) {
        this.descriptor = descriptor;
        final String value = String.valueOf(String.valueOf(s));
        this.caseMethod = getMethodOrDie(clazz, new StringBuilder(7 + value.length()).append("get").append(value).append("Case").toString(), new Class[0]);
        final String value2 = String.valueOf(String.valueOf(s));
        this.caseMethodBuilder = getMethodOrDie(clazz2, new StringBuilder(7 + value2.length()).append("get").append(value2).append("Case").toString(), new Class[0]);
        final String s2 = "clear";
        final String value3 = String.valueOf(s);
        this.clearMethod = getMethodOrDie(clazz2, (value3.length() != 0) ? s2.concat(value3) : new String(s2), new Class[0]);
    }
    
    public boolean has(final GeneratedMessage generatedMessage) {
        return ((Internal$EnumLite)invokeOrDie(this.caseMethod, generatedMessage, new Object[0])).getNumber() != 0;
    }
    
    public boolean has(final GeneratedMessage$Builder generatedMessage$Builder) {
        return ((Internal$EnumLite)invokeOrDie(this.caseMethodBuilder, generatedMessage$Builder, new Object[0])).getNumber() != 0;
    }
    
    public Descriptors$FieldDescriptor get(final GeneratedMessage generatedMessage) {
        final int number = ((Internal$EnumLite)invokeOrDie(this.caseMethod, generatedMessage, new Object[0])).getNumber();
        if (number > 0) {
            return this.descriptor.findFieldByNumber(number);
        }
        return null;
    }
    
    public Descriptors$FieldDescriptor get(final GeneratedMessage$Builder generatedMessage$Builder) {
        final int number = ((Internal$EnumLite)invokeOrDie(this.caseMethodBuilder, generatedMessage$Builder, new Object[0])).getNumber();
        if (number > 0) {
            return this.descriptor.findFieldByNumber(number);
        }
        return null;
    }
    
    public void clear(final GeneratedMessage$Builder generatedMessage$Builder) {
        invokeOrDie(this.clearMethod, generatedMessage$Builder, new Object[0]);
    }
}
