package com.google.protobuf;

import java.io.*;
import java.util.*;
import java.lang.reflect.*;

class GeneratedMessage$FieldAccessorTable$MapFieldAccessor implements GeneratedMessage$FieldAccessorTable$FieldAccessor
{
    private final Descriptors$FieldDescriptor field;
    private final Message mapEntryMessageDefaultInstance;
    
    GeneratedMessage$FieldAccessorTable$MapFieldAccessor(final Descriptors$FieldDescriptor field, final String s, final Class clazz, final Class clazz2) {
        this.field = field;
        this.mapEntryMessageDefaultInstance = this.getMapField((GeneratedMessage)invokeOrDie(getMethodOrDie(clazz, "getDefaultInstance", new Class[0]), null, new Object[0])).getMapEntryMessageDefaultInstance();
    }
    
    private MapField getMapField(final GeneratedMessage generatedMessage) {
        return generatedMessage.internalGetMapField(this.field.getNumber());
    }
    
    private MapField getMapField(final GeneratedMessage$Builder generatedMessage$Builder) {
        return generatedMessage$Builder.internalGetMapField(this.field.getNumber());
    }
    
    private MapField getMutableMapField(final GeneratedMessage$Builder generatedMessage$Builder) {
        return generatedMessage$Builder.internalGetMutableMapField(this.field.getNumber());
    }
    
    public Object get(final GeneratedMessage generatedMessage) {
        final ArrayList<Object> list = new ArrayList<Object>();
        for (int i = 0; i < this.getRepeatedCount(generatedMessage); ++i) {
            list.add(this.getRepeated(generatedMessage, i));
        }
        return Collections.unmodifiableList((List<?>)list);
    }
    
    public Object get(final GeneratedMessage$Builder generatedMessage$Builder) {
        final ArrayList<Object> list = new ArrayList<Object>();
        for (int i = 0; i < this.getRepeatedCount(generatedMessage$Builder); ++i) {
            list.add(this.getRepeated(generatedMessage$Builder, i));
        }
        return Collections.unmodifiableList((List<?>)list);
    }
    
    public Object getRaw(final GeneratedMessage generatedMessage) {
        return this.get(generatedMessage);
    }
    
    public Object getRaw(final GeneratedMessage$Builder generatedMessage$Builder) {
        return this.get(generatedMessage$Builder);
    }
    
    public void set(final GeneratedMessage$Builder generatedMessage$Builder, final Object o) {
        this.clear(generatedMessage$Builder);
        final Iterator<Object> iterator = ((List)o).iterator();
        while (iterator.hasNext()) {
            this.addRepeated(generatedMessage$Builder, iterator.next());
        }
    }
    
    public Object getRepeated(final GeneratedMessage generatedMessage, final int n) {
        return this.getMapField(generatedMessage).getList().get(n);
    }
    
    public Object getRepeated(final GeneratedMessage$Builder generatedMessage$Builder, final int n) {
        return this.getMapField(generatedMessage$Builder).getList().get(n);
    }
    
    public Object getRepeatedRaw(final GeneratedMessage generatedMessage, final int n) {
        return this.getRepeated(generatedMessage, n);
    }
    
    public Object getRepeatedRaw(final GeneratedMessage$Builder generatedMessage$Builder, final int n) {
        return this.getRepeated(generatedMessage$Builder, n);
    }
    
    public void setRepeated(final GeneratedMessage$Builder generatedMessage$Builder, final int n, final Object o) {
        this.getMutableMapField(generatedMessage$Builder).getMutableList().set(n, o);
    }
    
    public void addRepeated(final GeneratedMessage$Builder generatedMessage$Builder, final Object o) {
        this.getMutableMapField(generatedMessage$Builder).getMutableList().add(o);
    }
    
    public boolean has(final GeneratedMessage generatedMessage) {
        throw new UnsupportedOperationException("hasField() is not supported for repeated fields.");
    }
    
    public boolean has(final GeneratedMessage$Builder generatedMessage$Builder) {
        throw new UnsupportedOperationException("hasField() is not supported for repeated fields.");
    }
    
    public int getRepeatedCount(final GeneratedMessage generatedMessage) {
        return this.getMapField(generatedMessage).getList().size();
    }
    
    public int getRepeatedCount(final GeneratedMessage$Builder generatedMessage$Builder) {
        return this.getMapField(generatedMessage$Builder).getList().size();
    }
    
    public void clear(final GeneratedMessage$Builder generatedMessage$Builder) {
        this.getMutableMapField(generatedMessage$Builder).getMutableList().clear();
    }
    
    public Message$Builder newBuilder() {
        return this.mapEntryMessageDefaultInstance.newBuilderForType();
    }
    
    public Message$Builder getBuilder(final GeneratedMessage$Builder generatedMessage$Builder) {
        throw new UnsupportedOperationException("Nested builder not supported for map fields.");
    }
    
    public Message$Builder getRepeatedBuilder(final GeneratedMessage$Builder generatedMessage$Builder, final int n) {
        throw new UnsupportedOperationException("Nested builder not supported for map fields.");
    }
}
