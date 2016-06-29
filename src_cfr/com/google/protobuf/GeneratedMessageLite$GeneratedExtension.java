/*
 * Decompiled with CFR 0_115.
 */
package com.google.protobuf;

import com.google.protobuf.ExtensionLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.GeneratedMessageLite$ExtensionDescriptor;
import com.google.protobuf.Internal$EnumLite;
import com.google.protobuf.MessageLite;
import com.google.protobuf.WireFormat$FieldType;
import com.google.protobuf.WireFormat$JavaType;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class GeneratedMessageLite$GeneratedExtension
extends ExtensionLite {
    final MessageLite containingTypeDefaultInstance;
    final Object defaultValue;
    final MessageLite messageDefaultInstance;
    final GeneratedMessageLite$ExtensionDescriptor descriptor;
    final Class singularType;
    final Method enumValueOf;

    GeneratedMessageLite$GeneratedExtension(MessageLite messageLite, Object object, MessageLite messageLite2, GeneratedMessageLite$ExtensionDescriptor generatedMessageLite$ExtensionDescriptor, Class class_) {
        if (messageLite == null) {
            throw new IllegalArgumentException("Null containingTypeDefaultInstance");
        }
        if (generatedMessageLite$ExtensionDescriptor.getLiteType() == WireFormat$FieldType.MESSAGE && messageLite2 == null) {
            throw new IllegalArgumentException("Null messageDefaultInstance");
        }
        this.containingTypeDefaultInstance = messageLite;
        this.defaultValue = object;
        this.messageDefaultInstance = messageLite2;
        this.descriptor = generatedMessageLite$ExtensionDescriptor;
        this.singularType = class_;
        if (Internal$EnumLite.class.isAssignableFrom(class_)) {
            this.enumValueOf = GeneratedMessageLite.getMethodOrDie(class_, "valueOf", Integer.TYPE);
            return;
        }
        this.enumValueOf = null;
    }

    public MessageLite getContainingTypeDefaultInstance() {
        return this.containingTypeDefaultInstance;
    }

    @Override
    public int getNumber() {
        return this.descriptor.getNumber();
    }

    @Override
    public MessageLite getMessageDefaultInstance() {
        return this.messageDefaultInstance;
    }

    Object fromFieldSetType(Object object) {
        if (!this.descriptor.isRepeated()) return this.singularFromFieldSetType(object);
        if (this.descriptor.getLiteJavaType() != WireFormat$JavaType.ENUM) return object;
        ArrayList<Object> arrayList = new ArrayList<Object>();
        Iterator iterator = ((List)object).iterator();
        while (iterator.hasNext()) {
            Object e2 = iterator.next();
            arrayList.add(this.singularFromFieldSetType(e2));
        }
        return arrayList;
    }

    Object singularFromFieldSetType(Object object) {
        if (this.descriptor.getLiteJavaType() != WireFormat$JavaType.ENUM) return object;
        return GeneratedMessageLite.invokeOrDie(this.enumValueOf, null, (Integer)object);
    }

    Object toFieldSetType(Object object) {
        if (!this.descriptor.isRepeated()) return this.singularToFieldSetType(object);
        if (this.descriptor.getLiteJavaType() != WireFormat$JavaType.ENUM) return object;
        ArrayList<Object> arrayList = new ArrayList<Object>();
        Iterator iterator = ((List)object).iterator();
        while (iterator.hasNext()) {
            Object e2 = iterator.next();
            arrayList.add(this.singularToFieldSetType(e2));
        }
        return arrayList;
    }

    Object singularToFieldSetType(Object object) {
        if (this.descriptor.getLiteJavaType() != WireFormat$JavaType.ENUM) return object;
        return ((Internal$EnumLite)object).getNumber();
    }

    @Override
    public WireFormat$FieldType getLiteType() {
        return this.descriptor.getLiteType();
    }

    @Override
    public boolean isRepeated() {
        return this.descriptor.isRepeated;
    }

    @Override
    public Object getDefaultValue() {
        return this.defaultValue;
    }
}

