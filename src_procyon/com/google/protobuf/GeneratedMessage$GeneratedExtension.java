package com.google.protobuf;

import java.io.*;
import java.util.*;
import java.lang.reflect.*;

public class GeneratedMessage$GeneratedExtension extends Extension
{
    private GeneratedMessage$ExtensionDescriptorRetriever descriptorRetriever;
    private final Class singularType;
    private final Message messageDefaultInstance;
    private final Method enumValueOf;
    private final Method enumGetValueDescriptor;
    private final Extension$ExtensionType extensionType;
    
    GeneratedMessage$GeneratedExtension(final GeneratedMessage$ExtensionDescriptorRetriever descriptorRetriever, final Class singularType, final Message messageDefaultInstance, final Extension$ExtensionType extensionType) {
        if (Message.class.isAssignableFrom(singularType) && !singularType.isInstance(messageDefaultInstance)) {
            final String s = "Bad messageDefaultInstance for ";
            final String value = String.valueOf(singularType.getName());
            throw new IllegalArgumentException((value.length() != 0) ? s.concat(value) : new String(s));
        }
        this.descriptorRetriever = descriptorRetriever;
        this.singularType = singularType;
        this.messageDefaultInstance = messageDefaultInstance;
        if (ProtocolMessageEnum.class.isAssignableFrom(singularType)) {
            this.enumValueOf = getMethodOrDie(singularType, "valueOf", new Class[] { Descriptors$EnumValueDescriptor.class });
            this.enumGetValueDescriptor = getMethodOrDie(singularType, "getValueDescriptor", new Class[0]);
        }
        else {
            this.enumValueOf = null;
            this.enumGetValueDescriptor = null;
        }
        this.extensionType = extensionType;
    }
    
    public void internalInit(final Descriptors$FieldDescriptor descriptors$FieldDescriptor) {
        if (this.descriptorRetriever != null) {
            throw new IllegalStateException("Already initialized.");
        }
        this.descriptorRetriever = new GeneratedMessage$GeneratedExtension$1(this, descriptors$FieldDescriptor);
    }
    
    public Descriptors$FieldDescriptor getDescriptor() {
        if (this.descriptorRetriever == null) {
            throw new IllegalStateException("getDescriptor() called before internalInit()");
        }
        return this.descriptorRetriever.getDescriptor();
    }
    
    public Message getMessageDefaultInstance() {
        return this.messageDefaultInstance;
    }
    
    protected Extension$ExtensionType getExtensionType() {
        return this.extensionType;
    }
    
    protected Object fromReflectionType(final Object o) {
        final Descriptors$FieldDescriptor descriptor = this.getDescriptor();
        if (!descriptor.isRepeated()) {
            return this.singularFromReflectionType(o);
        }
        if (descriptor.getJavaType() == Descriptors$FieldDescriptor$JavaType.MESSAGE || descriptor.getJavaType() == Descriptors$FieldDescriptor$JavaType.ENUM) {
            final ArrayList<Object> list = new ArrayList<Object>();
            final Iterator<Object> iterator = ((List)o).iterator();
            while (iterator.hasNext()) {
                list.add(this.singularFromReflectionType(iterator.next()));
            }
            return list;
        }
        return o;
    }
    
    protected Object singularFromReflectionType(final Object o) {
        switch (GeneratedMessage$4.$SwitchMap$com$google$protobuf$Descriptors$FieldDescriptor$JavaType[this.getDescriptor().getJavaType().ordinal()]) {
            case 1: {
                if (this.singularType.isInstance(o)) {
                    return o;
                }
                return this.messageDefaultInstance.newBuilderForType().mergeFrom((Message)o).build();
            }
            case 2: {
                return invokeOrDie(this.enumValueOf, null, new Object[] { (Descriptors$EnumValueDescriptor)o });
            }
            default: {
                return o;
            }
        }
    }
    
    protected Object toReflectionType(final Object o) {
        final Descriptors$FieldDescriptor descriptor = this.getDescriptor();
        if (!descriptor.isRepeated()) {
            return this.singularToReflectionType(o);
        }
        if (descriptor.getJavaType() == Descriptors$FieldDescriptor$JavaType.ENUM) {
            final ArrayList<Object> list = new ArrayList<Object>();
            final Iterator<Object> iterator = ((List)o).iterator();
            while (iterator.hasNext()) {
                list.add(this.singularToReflectionType(iterator.next()));
            }
            return list;
        }
        return o;
    }
    
    protected Object singularToReflectionType(final Object o) {
        switch (GeneratedMessage$4.$SwitchMap$com$google$protobuf$Descriptors$FieldDescriptor$JavaType[this.getDescriptor().getJavaType().ordinal()]) {
            case 2: {
                return invokeOrDie(this.enumGetValueDescriptor, o, new Object[0]);
            }
            default: {
                return o;
            }
        }
    }
    
    public int getNumber() {
        return this.getDescriptor().getNumber();
    }
    
    public WireFormat$FieldType getLiteType() {
        return this.getDescriptor().getLiteType();
    }
    
    public boolean isRepeated() {
        return this.getDescriptor().isRepeated();
    }
    
    public Object getDefaultValue() {
        if (this.isRepeated()) {
            return Collections.emptyList();
        }
        if (this.getDescriptor().getJavaType() == Descriptors$FieldDescriptor$JavaType.MESSAGE) {
            return this.messageDefaultInstance;
        }
        return this.singularFromReflectionType(this.getDescriptor().getDefaultValue());
    }
}
