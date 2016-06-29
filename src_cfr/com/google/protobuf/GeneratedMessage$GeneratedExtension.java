/*
 * Decompiled with CFR 0_115.
 */
package com.google.protobuf;

import com.google.protobuf.Descriptors$EnumValueDescriptor;
import com.google.protobuf.Descriptors$FieldDescriptor;
import com.google.protobuf.Descriptors$FieldDescriptor$JavaType;
import com.google.protobuf.Extension;
import com.google.protobuf.Extension$ExtensionType;
import com.google.protobuf.GeneratedMessage;
import com.google.protobuf.GeneratedMessage$4;
import com.google.protobuf.GeneratedMessage$ExtensionDescriptorRetriever;
import com.google.protobuf.GeneratedMessage$GeneratedExtension$1;
import com.google.protobuf.Message;
import com.google.protobuf.Message$Builder;
import com.google.protobuf.MessageLite;
import com.google.protobuf.ProtocolMessageEnum;
import com.google.protobuf.WireFormat$FieldType;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class GeneratedMessage$GeneratedExtension
extends Extension {
    private GeneratedMessage$ExtensionDescriptorRetriever descriptorRetriever;
    private final Class singularType;
    private final Message messageDefaultInstance;
    private final Method enumValueOf;
    private final Method enumGetValueDescriptor;
    private final Extension$ExtensionType extensionType;

    GeneratedMessage$GeneratedExtension(GeneratedMessage$ExtensionDescriptorRetriever generatedMessage$ExtensionDescriptorRetriever, Class class_, Message message, Extension$ExtensionType extension$ExtensionType) {
        if (Message.class.isAssignableFrom(class_) && !class_.isInstance(message)) {
            String string;
            String string2 = String.valueOf(class_.getName());
            if (string2.length() != 0) {
                string = "Bad messageDefaultInstance for ".concat(string2);
                throw new IllegalArgumentException(string);
            }
            string = new String("Bad messageDefaultInstance for ");
            throw new IllegalArgumentException(string);
        }
        this.descriptorRetriever = generatedMessage$ExtensionDescriptorRetriever;
        this.singularType = class_;
        this.messageDefaultInstance = message;
        if (ProtocolMessageEnum.class.isAssignableFrom(class_)) {
            this.enumValueOf = GeneratedMessage.access$1100(class_, "valueOf", new Class[]{Descriptors$EnumValueDescriptor.class});
            this.enumGetValueDescriptor = GeneratedMessage.access$1100(class_, "getValueDescriptor", new Class[0]);
        } else {
            this.enumValueOf = null;
            this.enumGetValueDescriptor = null;
        }
        this.extensionType = extension$ExtensionType;
    }

    public void internalInit(Descriptors$FieldDescriptor descriptors$FieldDescriptor) {
        if (this.descriptorRetriever != null) {
            throw new IllegalStateException("Already initialized.");
        }
        this.descriptorRetriever = new GeneratedMessage$GeneratedExtension$1(this, descriptors$FieldDescriptor);
    }

    @Override
    public Descriptors$FieldDescriptor getDescriptor() {
        if (this.descriptorRetriever != null) return this.descriptorRetriever.getDescriptor();
        throw new IllegalStateException("getDescriptor() called before internalInit()");
    }

    @Override
    public Message getMessageDefaultInstance() {
        return this.messageDefaultInstance;
    }

    @Override
    protected Extension$ExtensionType getExtensionType() {
        return this.extensionType;
    }

    @Override
    protected Object fromReflectionType(Object object) {
        Descriptors$FieldDescriptor descriptors$FieldDescriptor = this.getDescriptor();
        if (!descriptors$FieldDescriptor.isRepeated()) return this.singularFromReflectionType(object);
        if (descriptors$FieldDescriptor.getJavaType() != Descriptors$FieldDescriptor$JavaType.MESSAGE) {
            if (descriptors$FieldDescriptor.getJavaType() != Descriptors$FieldDescriptor$JavaType.ENUM) return object;
        }
        ArrayList<Object> arrayList = new ArrayList<Object>();
        Iterator iterator = ((List)object).iterator();
        while (iterator.hasNext()) {
            Object e2 = iterator.next();
            arrayList.add(this.singularFromReflectionType(e2));
        }
        return arrayList;
    }

    @Override
    protected Object singularFromReflectionType(Object object) {
        Descriptors$FieldDescriptor descriptors$FieldDescriptor = this.getDescriptor();
        switch (GeneratedMessage$4.$SwitchMap$com$google$protobuf$Descriptors$FieldDescriptor$JavaType[descriptors$FieldDescriptor.getJavaType().ordinal()]) {
            case 1: {
                if (!this.singularType.isInstance(object)) return this.messageDefaultInstance.newBuilderForType().mergeFrom((Message)object).build();
                return object;
            }
            case 2: {
                return GeneratedMessage.access$1200(this.enumValueOf, null, new Object[]{(Descriptors$EnumValueDescriptor)object});
            }
        }
        return object;
    }

    @Override
    protected Object toReflectionType(Object object) {
        Descriptors$FieldDescriptor descriptors$FieldDescriptor = this.getDescriptor();
        if (!descriptors$FieldDescriptor.isRepeated()) return this.singularToReflectionType(object);
        if (descriptors$FieldDescriptor.getJavaType() != Descriptors$FieldDescriptor$JavaType.ENUM) return object;
        ArrayList<Object> arrayList = new ArrayList<Object>();
        Iterator iterator = ((List)object).iterator();
        while (iterator.hasNext()) {
            Object e2 = iterator.next();
            arrayList.add(this.singularToReflectionType(e2));
        }
        return arrayList;
    }

    @Override
    protected Object singularToReflectionType(Object object) {
        Descriptors$FieldDescriptor descriptors$FieldDescriptor = this.getDescriptor();
        switch (GeneratedMessage$4.$SwitchMap$com$google$protobuf$Descriptors$FieldDescriptor$JavaType[descriptors$FieldDescriptor.getJavaType().ordinal()]) {
            case 2: {
                return GeneratedMessage.access$1200(this.enumGetValueDescriptor, object, new Object[0]);
            }
        }
        return object;
    }

    @Override
    public int getNumber() {
        return this.getDescriptor().getNumber();
    }

    @Override
    public WireFormat$FieldType getLiteType() {
        return this.getDescriptor().getLiteType();
    }

    @Override
    public boolean isRepeated() {
        return this.getDescriptor().isRepeated();
    }

    @Override
    public Object getDefaultValue() {
        if (this.isRepeated()) {
            return Collections.emptyList();
        }
        if (this.getDescriptor().getJavaType() != Descriptors$FieldDescriptor$JavaType.MESSAGE) return this.singularFromReflectionType(this.getDescriptor().getDefaultValue());
        return this.messageDefaultInstance;
    }
}

