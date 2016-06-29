package com.google.protobuf;

import java.lang.reflect.*;
import java.util.*;

public class GeneratedMessageLite$GeneratedExtension extends ExtensionLite
{
    final MessageLite containingTypeDefaultInstance;
    final Object defaultValue;
    final MessageLite messageDefaultInstance;
    final GeneratedMessageLite$ExtensionDescriptor descriptor;
    final Class singularType;
    final Method enumValueOf;
    
    GeneratedMessageLite$GeneratedExtension(final MessageLite containingTypeDefaultInstance, final Object defaultValue, final MessageLite messageDefaultInstance, final GeneratedMessageLite$ExtensionDescriptor descriptor, final Class singularType) {
        if (containingTypeDefaultInstance == null) {
            throw new IllegalArgumentException("Null containingTypeDefaultInstance");
        }
        if (descriptor.getLiteType() == WireFormat$FieldType.MESSAGE && messageDefaultInstance == null) {
            throw new IllegalArgumentException("Null messageDefaultInstance");
        }
        this.containingTypeDefaultInstance = containingTypeDefaultInstance;
        this.defaultValue = defaultValue;
        this.messageDefaultInstance = messageDefaultInstance;
        this.descriptor = descriptor;
        this.singularType = singularType;
        if (Internal$EnumLite.class.isAssignableFrom(singularType)) {
            this.enumValueOf = GeneratedMessageLite.getMethodOrDie(singularType, "valueOf", Integer.TYPE);
        }
        else {
            this.enumValueOf = null;
        }
    }
    
    public MessageLite getContainingTypeDefaultInstance() {
        return this.containingTypeDefaultInstance;
    }
    
    public int getNumber() {
        return this.descriptor.getNumber();
    }
    
    public MessageLite getMessageDefaultInstance() {
        return this.messageDefaultInstance;
    }
    
    Object fromFieldSetType(final Object o) {
        if (!this.descriptor.isRepeated()) {
            return this.singularFromFieldSetType(o);
        }
        if (this.descriptor.getLiteJavaType() == WireFormat$JavaType.ENUM) {
            final ArrayList<Object> list = new ArrayList<Object>();
            final Iterator<Object> iterator = ((List)o).iterator();
            while (iterator.hasNext()) {
                list.add(this.singularFromFieldSetType(iterator.next()));
            }
            return list;
        }
        return o;
    }
    
    Object singularFromFieldSetType(final Object o) {
        if (this.descriptor.getLiteJavaType() == WireFormat$JavaType.ENUM) {
            return GeneratedMessageLite.invokeOrDie(this.enumValueOf, null, (Integer)o);
        }
        return o;
    }
    
    Object toFieldSetType(final Object o) {
        if (!this.descriptor.isRepeated()) {
            return this.singularToFieldSetType(o);
        }
        if (this.descriptor.getLiteJavaType() == WireFormat$JavaType.ENUM) {
            final ArrayList<Object> list = new ArrayList<Object>();
            final Iterator<Object> iterator = ((List)o).iterator();
            while (iterator.hasNext()) {
                list.add(this.singularToFieldSetType(iterator.next()));
            }
            return list;
        }
        return o;
    }
    
    Object singularToFieldSetType(final Object o) {
        if (this.descriptor.getLiteJavaType() == WireFormat$JavaType.ENUM) {
            return ((Internal$EnumLite)o).getNumber();
        }
        return o;
    }
    
    public WireFormat$FieldType getLiteType() {
        return this.descriptor.getLiteType();
    }
    
    public boolean isRepeated() {
        return this.descriptor.isRepeated;
    }
    
    public Object getDefaultValue() {
        return this.defaultValue;
    }
}
