/*
 * Decompiled with CFR 0_115.
 */
package com.google.protobuf;

import com.google.protobuf.Descriptors$EnumDescriptor;
import com.google.protobuf.Descriptors$EnumValueDescriptor;
import com.google.protobuf.Descriptors$FieldDescriptor;
import com.google.protobuf.Descriptors$FileDescriptor;
import com.google.protobuf.GeneratedMessage;
import com.google.protobuf.GeneratedMessage$Builder;
import com.google.protobuf.GeneratedMessage$FieldAccessorTable$RepeatedFieldAccessor;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;

final class GeneratedMessage$FieldAccessorTable$RepeatedEnumFieldAccessor
extends GeneratedMessage$FieldAccessorTable$RepeatedFieldAccessor {
    private Descriptors$EnumDescriptor enumDescriptor;
    private final Method valueOfMethod;
    private final Method getValueDescriptorMethod;
    private boolean supportUnknownEnumValue;
    private Method getRepeatedValueMethod;
    private Method getRepeatedValueMethodBuilder;
    private Method setRepeatedValueMethod;
    private Method addRepeatedValueMethod;

    GeneratedMessage$FieldAccessorTable$RepeatedEnumFieldAccessor(Descriptors$FieldDescriptor descriptors$FieldDescriptor, String string, Class class_, Class class_2) {
        super(descriptors$FieldDescriptor, string, class_, class_2);
        this.enumDescriptor = descriptors$FieldDescriptor.getEnumType();
        this.valueOfMethod = GeneratedMessage.access$1100(this.type, "valueOf", new Class[]{Descriptors$EnumValueDescriptor.class});
        this.getValueDescriptorMethod = GeneratedMessage.access$1100(this.type, "getValueDescriptor", new Class[0]);
        this.supportUnknownEnumValue = descriptors$FieldDescriptor.getFile().supportsUnknownEnumValue();
        if (!this.supportUnknownEnumValue) return;
        String string2 = String.valueOf(String.valueOf(string));
        this.getRepeatedValueMethod = GeneratedMessage.access$1100(class_, new StringBuilder(8 + string2.length()).append("get").append(string2).append("Value").toString(), new Class[]{Integer.TYPE});
        String string3 = String.valueOf(String.valueOf(string));
        this.getRepeatedValueMethodBuilder = GeneratedMessage.access$1100(class_2, new StringBuilder(8 + string3.length()).append("get").append(string3).append("Value").toString(), new Class[]{Integer.TYPE});
        String string4 = String.valueOf(String.valueOf(string));
        this.setRepeatedValueMethod = GeneratedMessage.access$1100(class_2, new StringBuilder(8 + string4.length()).append("set").append(string4).append("Value").toString(), new Class[]{Integer.TYPE, Integer.TYPE});
        String string5 = String.valueOf(String.valueOf(string));
        this.addRepeatedValueMethod = GeneratedMessage.access$1100(class_2, new StringBuilder(8 + string5.length()).append("add").append(string5).append("Value").toString(), new Class[]{Integer.TYPE});
    }

    @Override
    public Object get(GeneratedMessage generatedMessage) {
        ArrayList<Object> arrayList = new ArrayList<Object>();
        int n2 = this.getRepeatedCount(generatedMessage);
        int n3 = 0;
        while (n3 < n2) {
            arrayList.add(this.getRepeated(generatedMessage, n3));
            ++n3;
        }
        return Collections.unmodifiableList(arrayList);
    }

    @Override
    public Object get(GeneratedMessage$Builder generatedMessage$Builder) {
        ArrayList<Object> arrayList = new ArrayList<Object>();
        int n2 = this.getRepeatedCount(generatedMessage$Builder);
        int n3 = 0;
        while (n3 < n2) {
            arrayList.add(this.getRepeated(generatedMessage$Builder, n3));
            ++n3;
        }
        return Collections.unmodifiableList(arrayList);
    }

    @Override
    public Object getRepeated(GeneratedMessage generatedMessage, int n2) {
        if (!this.supportUnknownEnumValue) return GeneratedMessage.access$1200(this.getValueDescriptorMethod, super.getRepeated(generatedMessage, n2), new Object[0]);
        int n3 = (Integer)GeneratedMessage.access$1200(this.getRepeatedValueMethod, generatedMessage, new Object[]{n2});
        return this.enumDescriptor.findValueByNumberCreatingIfUnknown(n3);
    }

    @Override
    public Object getRepeated(GeneratedMessage$Builder generatedMessage$Builder, int n2) {
        if (!this.supportUnknownEnumValue) return GeneratedMessage.access$1200(this.getValueDescriptorMethod, super.getRepeated(generatedMessage$Builder, n2), new Object[0]);
        int n3 = (Integer)GeneratedMessage.access$1200(this.getRepeatedValueMethodBuilder, generatedMessage$Builder, new Object[]{n2});
        return this.enumDescriptor.findValueByNumberCreatingIfUnknown(n3);
    }

    @Override
    public void setRepeated(GeneratedMessage$Builder generatedMessage$Builder, int n2, Object object) {
        if (this.supportUnknownEnumValue) {
            GeneratedMessage.access$1200(this.setRepeatedValueMethod, generatedMessage$Builder, new Object[]{n2, ((Descriptors$EnumValueDescriptor)object).getNumber()});
            return;
        }
        super.setRepeated(generatedMessage$Builder, n2, GeneratedMessage.access$1200(this.valueOfMethod, null, new Object[]{object}));
    }

    @Override
    public void addRepeated(GeneratedMessage$Builder generatedMessage$Builder, Object object) {
        if (this.supportUnknownEnumValue) {
            GeneratedMessage.access$1200(this.addRepeatedValueMethod, generatedMessage$Builder, new Object[]{((Descriptors$EnumValueDescriptor)object).getNumber()});
            return;
        }
        super.addRepeated(generatedMessage$Builder, GeneratedMessage.access$1200(this.valueOfMethod, null, new Object[]{object}));
    }
}

