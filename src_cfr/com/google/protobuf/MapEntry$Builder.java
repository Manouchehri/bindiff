/*
 * Decompiled with CFR 0_115.
 */
package com.google.protobuf;

import com.google.protobuf.AbstractMessage$Builder;
import com.google.protobuf.AbstractMessageLite$Builder;
import com.google.protobuf.Descriptors$Descriptor;
import com.google.protobuf.Descriptors$EnumDescriptor;
import com.google.protobuf.Descriptors$EnumValueDescriptor;
import com.google.protobuf.Descriptors$FieldDescriptor;
import com.google.protobuf.Descriptors$FieldDescriptor$JavaType;
import com.google.protobuf.Descriptors$FieldDescriptor$Type;
import com.google.protobuf.MapEntry;
import com.google.protobuf.MapEntry$1;
import com.google.protobuf.MapEntry$Metadata;
import com.google.protobuf.MapEntryLite;
import com.google.protobuf.MapEntryLite$Builder;
import com.google.protobuf.Message;
import com.google.protobuf.Message$Builder;
import com.google.protobuf.MessageLite;
import com.google.protobuf.MessageLite$Builder;
import com.google.protobuf.UnknownFieldSet;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class MapEntry$Builder
extends AbstractMessage$Builder {
    private final MapEntry$Metadata metadata;
    private MapEntryLite data;
    private MapEntryLite$Builder dataBuilder;

    private MapEntry$Builder(MapEntry$Metadata mapEntry$Metadata) {
        this.metadata = mapEntry$Metadata;
        this.data = MapEntry.access$000(mapEntry$Metadata.defaultInstance);
        this.dataBuilder = null;
    }

    private MapEntry$Builder(MapEntry$Metadata mapEntry$Metadata, MapEntryLite mapEntryLite) {
        this.metadata = mapEntry$Metadata;
        this.data = mapEntryLite;
        this.dataBuilder = null;
    }

    public Object getKey() {
        Object object;
        if (this.dataBuilder == null) {
            object = this.data.getKey();
            return object;
        }
        object = this.dataBuilder.getKey();
        return object;
    }

    public Object getValue() {
        Object object;
        if (this.dataBuilder == null) {
            object = this.data.getValue();
            return object;
        }
        object = this.dataBuilder.getValue();
        return object;
    }

    private void ensureMutable() {
        if (this.dataBuilder != null) return;
        this.dataBuilder = this.data.toBuilder();
    }

    public MapEntry$Builder setKey(Object object) {
        this.ensureMutable();
        this.dataBuilder.setKey(object);
        return this;
    }

    public MapEntry$Builder clearKey() {
        this.ensureMutable();
        this.dataBuilder.clearKey();
        return this;
    }

    public MapEntry$Builder setValue(Object object) {
        this.ensureMutable();
        this.dataBuilder.setValue(object);
        return this;
    }

    public MapEntry$Builder clearValue() {
        this.ensureMutable();
        this.dataBuilder.clearValue();
        return this;
    }

    @Override
    public MapEntry build() {
        MapEntry mapEntry = this.buildPartial();
        if (mapEntry.isInitialized()) return mapEntry;
        throw MapEntry$Builder.newUninitializedMessageException(mapEntry);
    }

    @Override
    public MapEntry buildPartial() {
        if (this.dataBuilder == null) return new MapEntry(this.metadata, this.data, null);
        this.data = this.dataBuilder.buildPartial();
        this.dataBuilder = null;
        return new MapEntry(this.metadata, this.data, null);
    }

    @Override
    public Descriptors$Descriptor getDescriptorForType() {
        return this.metadata.descriptor;
    }

    private void checkFieldDescriptor(Descriptors$FieldDescriptor descriptors$FieldDescriptor) {
        if (descriptors$FieldDescriptor.getContainingType() == this.metadata.descriptor) return;
        String string = String.valueOf(String.valueOf(descriptors$FieldDescriptor.getFullName()));
        String string2 = String.valueOf(String.valueOf(this.metadata.descriptor.getFullName()));
        throw new RuntimeException(new StringBuilder(42 + string.length() + string2.length()).append("Wrong FieldDescriptor \"").append(string).append("\" used in message \"").append(string2).toString());
    }

    @Override
    public Message$Builder newBuilderForField(Descriptors$FieldDescriptor descriptors$FieldDescriptor) {
        this.checkFieldDescriptor(descriptors$FieldDescriptor);
        if (descriptors$FieldDescriptor.getNumber() == 2) {
            if (descriptors$FieldDescriptor.getJavaType() == Descriptors$FieldDescriptor$JavaType.MESSAGE) return ((Message)this.data.getValue()).newBuilderForType();
        }
        String string = String.valueOf(String.valueOf(descriptors$FieldDescriptor.getFullName()));
        throw new RuntimeException(new StringBuilder(32 + string.length()).append("\"").append(string).append("\" is not a message value field.").toString());
    }

    @Override
    public MapEntry$Builder setField(Descriptors$FieldDescriptor descriptors$FieldDescriptor, Object object) {
        this.checkFieldDescriptor(descriptors$FieldDescriptor);
        if (descriptors$FieldDescriptor.getNumber() == 1) {
            this.setKey(object);
            return this;
        }
        if (descriptors$FieldDescriptor.getType() == Descriptors$FieldDescriptor$Type.ENUM) {
            object = ((Descriptors$EnumValueDescriptor)object).getNumber();
        }
        this.setValue(object);
        return this;
    }

    @Override
    public MapEntry$Builder clearField(Descriptors$FieldDescriptor descriptors$FieldDescriptor) {
        this.checkFieldDescriptor(descriptors$FieldDescriptor);
        if (descriptors$FieldDescriptor.getNumber() == 1) {
            this.clearKey();
            return this;
        }
        this.clearValue();
        return this;
    }

    @Override
    public MapEntry$Builder setRepeatedField(Descriptors$FieldDescriptor descriptors$FieldDescriptor, int n2, Object object) {
        throw new RuntimeException("There is no repeated field in a map entry message.");
    }

    @Override
    public MapEntry$Builder addRepeatedField(Descriptors$FieldDescriptor descriptors$FieldDescriptor, Object object) {
        throw new RuntimeException("There is no repeated field in a map entry message.");
    }

    @Override
    public MapEntry$Builder setUnknownFields(UnknownFieldSet unknownFieldSet) {
        return this;
    }

    @Override
    public MapEntry getDefaultInstanceForType() {
        return this.metadata.defaultInstance;
    }

    @Override
    public boolean isInitialized() {
        if (this.dataBuilder == null) return this.data.isInitialized();
        return this.dataBuilder.isInitialized();
    }

    @Override
    public Map getAllFields() {
        TreeMap<Descriptors$FieldDescriptor, Object> treeMap = new TreeMap<Descriptors$FieldDescriptor, Object>();
        Iterator iterator = this.metadata.descriptor.getFields().iterator();
        while (iterator.hasNext()) {
            Descriptors$FieldDescriptor descriptors$FieldDescriptor = (Descriptors$FieldDescriptor)iterator.next();
            if (!this.hasField(descriptors$FieldDescriptor)) continue;
            treeMap.put(descriptors$FieldDescriptor, this.getField(descriptors$FieldDescriptor));
        }
        return Collections.unmodifiableMap(treeMap);
    }

    @Override
    public boolean hasField(Descriptors$FieldDescriptor descriptors$FieldDescriptor) {
        this.checkFieldDescriptor(descriptors$FieldDescriptor);
        return true;
    }

    @Override
    public Object getField(Descriptors$FieldDescriptor descriptors$FieldDescriptor) {
        this.checkFieldDescriptor(descriptors$FieldDescriptor);
        Object object = descriptors$FieldDescriptor.getNumber() == 1 ? this.getKey() : this.getValue();
        if (descriptors$FieldDescriptor.getType() != Descriptors$FieldDescriptor$Type.ENUM) return object;
        return descriptors$FieldDescriptor.getEnumType().findValueByNumberCreatingIfUnknown((Integer)object);
    }

    @Override
    public int getRepeatedFieldCount(Descriptors$FieldDescriptor descriptors$FieldDescriptor) {
        throw new RuntimeException("There is no repeated field in a map entry message.");
    }

    @Override
    public Object getRepeatedField(Descriptors$FieldDescriptor descriptors$FieldDescriptor, int n2) {
        throw new RuntimeException("There is no repeated field in a map entry message.");
    }

    @Override
    public UnknownFieldSet getUnknownFields() {
        return UnknownFieldSet.getDefaultInstance();
    }

    @Override
    public MapEntry$Builder clone() {
        if (this.dataBuilder != null) return new MapEntry$Builder(this.metadata, this.dataBuilder.build());
        return new MapEntry$Builder(this.metadata, this.data);
    }

    /* synthetic */ MapEntry$Builder(MapEntry$Metadata mapEntry$Metadata, MapEntry$1 mapEntry$1) {
        this(mapEntry$Metadata);
    }

    /* synthetic */ MapEntry$Builder(MapEntry$Metadata mapEntry$Metadata, MapEntryLite mapEntryLite, MapEntry$1 mapEntry$1) {
        this(mapEntry$Metadata, mapEntryLite);
    }
}

