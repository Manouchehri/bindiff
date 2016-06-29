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
import com.google.protobuf.GeneratedMessage$FieldAccessorTable$SingularFieldAccessor;
import java.lang.reflect.Method;

final class GeneratedMessage$FieldAccessorTable$SingularEnumFieldAccessor
extends GeneratedMessage$FieldAccessorTable$SingularFieldAccessor {
    private Descriptors$EnumDescriptor enumDescriptor;
    private Method valueOfMethod;
    private Method getValueDescriptorMethod;
    private boolean supportUnknownEnumValue;
    private Method getValueMethod;
    private Method getValueMethodBuilder;
    private Method setValueMethod;

    GeneratedMessage$FieldAccessorTable$SingularEnumFieldAccessor(Descriptors$FieldDescriptor descriptors$FieldDescriptor, String string, Class class_, Class class_2, String string2) {
        super(descriptors$FieldDescriptor, string, class_, class_2, string2);
        this.enumDescriptor = descriptors$FieldDescriptor.getEnumType();
        this.valueOfMethod = GeneratedMessage.access$1100(this.type, "valueOf", new Class[]{Descriptors$EnumValueDescriptor.class});
        this.getValueDescriptorMethod = GeneratedMessage.access$1100(this.type, "getValueDescriptor", new Class[0]);
        this.supportUnknownEnumValue = descriptors$FieldDescriptor.getFile().supportsUnknownEnumValue();
        if (!this.supportUnknownEnumValue) return;
        String string3 = String.valueOf(String.valueOf(string));
        this.getValueMethod = GeneratedMessage.access$1100(class_, new StringBuilder(8 + string3.length()).append("get").append(string3).append("Value").toString(), new Class[0]);
        String string4 = String.valueOf(String.valueOf(string));
        this.getValueMethodBuilder = GeneratedMessage.access$1100(class_2, new StringBuilder(8 + string4.length()).append("get").append(string4).append("Value").toString(), new Class[0]);
        String string5 = String.valueOf(String.valueOf(string));
        this.setValueMethod = GeneratedMessage.access$1100(class_2, new StringBuilder(8 + string5.length()).append("set").append(string5).append("Value").toString(), new Class[]{Integer.TYPE});
    }

    @Override
    public Object get(GeneratedMessage generatedMessage) {
        if (!this.supportUnknownEnumValue) return GeneratedMessage.access$1200(this.getValueDescriptorMethod, super.get(generatedMessage), new Object[0]);
        int n2 = (Integer)GeneratedMessage.access$1200(this.getValueMethod, generatedMessage, new Object[0]);
        return this.enumDescriptor.findValueByNumberCreatingIfUnknown(n2);
    }

    @Override
    public Object get(GeneratedMessage$Builder generatedMessage$Builder) {
        if (!this.supportUnknownEnumValue) return GeneratedMessage.access$1200(this.getValueDescriptorMethod, super.get(generatedMessage$Builder), new Object[0]);
        int n2 = (Integer)GeneratedMessage.access$1200(this.getValueMethodBuilder, generatedMessage$Builder, new Object[0]);
        return this.enumDescriptor.findValueByNumberCreatingIfUnknown(n2);
    }

    @Override
    public void set(GeneratedMessage$Builder generatedMessage$Builder, Object object) {
        if (this.supportUnknownEnumValue) {
            GeneratedMessage.access$1200(this.setValueMethod, generatedMessage$Builder, new Object[]{((Descriptors$EnumValueDescriptor)object).getNumber()});
            return;
        }
        super.set(generatedMessage$Builder, GeneratedMessage.access$1200(this.valueOfMethod, null, new Object[]{object}));
    }
}

