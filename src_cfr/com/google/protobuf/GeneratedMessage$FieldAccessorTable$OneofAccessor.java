/*
 * Decompiled with CFR 0_115.
 */
package com.google.protobuf;

import com.google.protobuf.Descriptors$Descriptor;
import com.google.protobuf.Descriptors$FieldDescriptor;
import com.google.protobuf.GeneratedMessage;
import com.google.protobuf.GeneratedMessage$Builder;
import com.google.protobuf.Internal$EnumLite;
import java.lang.reflect.Method;

class GeneratedMessage$FieldAccessorTable$OneofAccessor {
    private final Descriptors$Descriptor descriptor;
    private final Method caseMethod;
    private final Method caseMethodBuilder;
    private final Method clearMethod;

    GeneratedMessage$FieldAccessorTable$OneofAccessor(Descriptors$Descriptor descriptors$Descriptor, String string, Class class_, Class class_2) {
        this.descriptor = descriptors$Descriptor;
        String string2 = String.valueOf(String.valueOf(string));
        this.caseMethod = GeneratedMessage.access$1100(class_, new StringBuilder(7 + string2.length()).append("get").append(string2).append("Case").toString(), new Class[0]);
        String string3 = String.valueOf(String.valueOf(string));
        this.caseMethodBuilder = GeneratedMessage.access$1100(class_2, new StringBuilder(7 + string3.length()).append("get").append(string3).append("Case").toString(), new Class[0]);
        String string4 = String.valueOf(string);
        this.clearMethod = GeneratedMessage.access$1100(class_2, string4.length() != 0 ? "clear".concat(string4) : new String("clear"), new Class[0]);
    }

    public boolean has(GeneratedMessage generatedMessage) {
        if (((Internal$EnumLite)GeneratedMessage.access$1200(this.caseMethod, generatedMessage, new Object[0])).getNumber() != 0) return true;
        return false;
    }

    public boolean has(GeneratedMessage$Builder generatedMessage$Builder) {
        if (((Internal$EnumLite)GeneratedMessage.access$1200(this.caseMethodBuilder, generatedMessage$Builder, new Object[0])).getNumber() != 0) return true;
        return false;
    }

    public Descriptors$FieldDescriptor get(GeneratedMessage generatedMessage) {
        int n2 = ((Internal$EnumLite)GeneratedMessage.access$1200(this.caseMethod, generatedMessage, new Object[0])).getNumber();
        if (n2 <= 0) return null;
        return this.descriptor.findFieldByNumber(n2);
    }

    public Descriptors$FieldDescriptor get(GeneratedMessage$Builder generatedMessage$Builder) {
        int n2 = ((Internal$EnumLite)GeneratedMessage.access$1200(this.caseMethodBuilder, generatedMessage$Builder, new Object[0])).getNumber();
        if (n2 <= 0) return null;
        return this.descriptor.findFieldByNumber(n2);
    }

    public void clear(GeneratedMessage$Builder generatedMessage$Builder) {
        GeneratedMessage.access$1200(this.clearMethod, generatedMessage$Builder, new Object[0]);
    }
}

