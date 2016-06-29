/*
 * Decompiled with CFR 0_115.
 */
package com.google.protobuf;

import com.google.protobuf.Descriptors$FieldDescriptor;
import com.google.protobuf.GeneratedMessage;
import com.google.protobuf.GeneratedMessage$Builder;
import com.google.protobuf.GeneratedMessage$FieldAccessorTable$FieldAccessor;
import com.google.protobuf.MapField;
import com.google.protobuf.Message;
import com.google.protobuf.Message$Builder;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

class GeneratedMessage$FieldAccessorTable$MapFieldAccessor
implements GeneratedMessage$FieldAccessorTable$FieldAccessor {
    private final Descriptors$FieldDescriptor field;
    private final Message mapEntryMessageDefaultInstance;

    GeneratedMessage$FieldAccessorTable$MapFieldAccessor(Descriptors$FieldDescriptor descriptors$FieldDescriptor, String string, Class class_, Class class_2) {
        this.field = descriptors$FieldDescriptor;
        Method method = GeneratedMessage.access$1100(class_, "getDefaultInstance", new Class[0]);
        MapField mapField = this.getMapField((GeneratedMessage)GeneratedMessage.access$1200(method, null, new Object[0]));
        this.mapEntryMessageDefaultInstance = mapField.getMapEntryMessageDefaultInstance();
    }

    private MapField getMapField(GeneratedMessage generatedMessage) {
        return generatedMessage.internalGetMapField(this.field.getNumber());
    }

    private MapField getMapField(GeneratedMessage$Builder generatedMessage$Builder) {
        return generatedMessage$Builder.internalGetMapField(this.field.getNumber());
    }

    private MapField getMutableMapField(GeneratedMessage$Builder generatedMessage$Builder) {
        return generatedMessage$Builder.internalGetMutableMapField(this.field.getNumber());
    }

    @Override
    public Object get(GeneratedMessage generatedMessage) {
        ArrayList<Object> arrayList = new ArrayList<Object>();
        int n2 = 0;
        while (n2 < this.getRepeatedCount(generatedMessage)) {
            arrayList.add(this.getRepeated(generatedMessage, n2));
            ++n2;
        }
        return Collections.unmodifiableList(arrayList);
    }

    @Override
    public Object get(GeneratedMessage$Builder generatedMessage$Builder) {
        ArrayList<Object> arrayList = new ArrayList<Object>();
        int n2 = 0;
        while (n2 < this.getRepeatedCount(generatedMessage$Builder)) {
            arrayList.add(this.getRepeated(generatedMessage$Builder, n2));
            ++n2;
        }
        return Collections.unmodifiableList(arrayList);
    }

    @Override
    public Object getRaw(GeneratedMessage generatedMessage) {
        return this.get(generatedMessage);
    }

    @Override
    public Object getRaw(GeneratedMessage$Builder generatedMessage$Builder) {
        return this.get(generatedMessage$Builder);
    }

    @Override
    public void set(GeneratedMessage$Builder generatedMessage$Builder, Object object) {
        this.clear(generatedMessage$Builder);
        Iterator iterator = ((List)object).iterator();
        while (iterator.hasNext()) {
            Object e2 = iterator.next();
            this.addRepeated(generatedMessage$Builder, e2);
        }
    }

    @Override
    public Object getRepeated(GeneratedMessage generatedMessage, int n2) {
        return this.getMapField(generatedMessage).getList().get(n2);
    }

    @Override
    public Object getRepeated(GeneratedMessage$Builder generatedMessage$Builder, int n2) {
        return this.getMapField(generatedMessage$Builder).getList().get(n2);
    }

    @Override
    public Object getRepeatedRaw(GeneratedMessage generatedMessage, int n2) {
        return this.getRepeated(generatedMessage, n2);
    }

    @Override
    public Object getRepeatedRaw(GeneratedMessage$Builder generatedMessage$Builder, int n2) {
        return this.getRepeated(generatedMessage$Builder, n2);
    }

    @Override
    public void setRepeated(GeneratedMessage$Builder generatedMessage$Builder, int n2, Object object) {
        this.getMutableMapField(generatedMessage$Builder).getMutableList().set(n2, (Message)object);
    }

    @Override
    public void addRepeated(GeneratedMessage$Builder generatedMessage$Builder, Object object) {
        this.getMutableMapField(generatedMessage$Builder).getMutableList().add((Message)object);
    }

    @Override
    public boolean has(GeneratedMessage generatedMessage) {
        throw new UnsupportedOperationException("hasField() is not supported for repeated fields.");
    }

    @Override
    public boolean has(GeneratedMessage$Builder generatedMessage$Builder) {
        throw new UnsupportedOperationException("hasField() is not supported for repeated fields.");
    }

    @Override
    public int getRepeatedCount(GeneratedMessage generatedMessage) {
        return this.getMapField(generatedMessage).getList().size();
    }

    @Override
    public int getRepeatedCount(GeneratedMessage$Builder generatedMessage$Builder) {
        return this.getMapField(generatedMessage$Builder).getList().size();
    }

    @Override
    public void clear(GeneratedMessage$Builder generatedMessage$Builder) {
        this.getMutableMapField(generatedMessage$Builder).getMutableList().clear();
    }

    @Override
    public Message$Builder newBuilder() {
        return this.mapEntryMessageDefaultInstance.newBuilderForType();
    }

    @Override
    public Message$Builder getBuilder(GeneratedMessage$Builder generatedMessage$Builder) {
        throw new UnsupportedOperationException("Nested builder not supported for map fields.");
    }

    @Override
    public Message$Builder getRepeatedBuilder(GeneratedMessage$Builder generatedMessage$Builder, int n2) {
        throw new UnsupportedOperationException("Nested builder not supported for map fields.");
    }
}

