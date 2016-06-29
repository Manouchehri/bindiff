/*
 * Decompiled with CFR 0_115.
 */
package com.google.protobuf;

import com.google.protobuf.AbstractMessage;
import com.google.protobuf.AbstractParser;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.Descriptors$Descriptor;
import com.google.protobuf.Descriptors$EnumDescriptor;
import com.google.protobuf.Descriptors$EnumValueDescriptor;
import com.google.protobuf.Descriptors$FieldDescriptor;
import com.google.protobuf.Descriptors$FieldDescriptor$Type;
import com.google.protobuf.MapEntry$1;
import com.google.protobuf.MapEntry$Builder;
import com.google.protobuf.MapEntry$Metadata;
import com.google.protobuf.MapEntryLite;
import com.google.protobuf.Message;
import com.google.protobuf.Message$Builder;
import com.google.protobuf.MessageLite;
import com.google.protobuf.MessageLite$Builder;
import com.google.protobuf.Parser;
import com.google.protobuf.UnknownFieldSet;
import com.google.protobuf.WireFormat$FieldType;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public final class MapEntry
extends AbstractMessage {
    private final MapEntry$Metadata metadata;
    private final MapEntryLite data;

    private MapEntry(Descriptors$Descriptor descriptors$Descriptor, WireFormat$FieldType wireFormat$FieldType, Object object, WireFormat$FieldType wireFormat$FieldType2, Object object2) {
        this.data = MapEntryLite.newDefaultInstance(wireFormat$FieldType, object, wireFormat$FieldType2, object2);
        this.metadata = new MapEntry$Metadata(descriptors$Descriptor, this);
    }

    private MapEntry(MapEntry$Metadata mapEntry$Metadata, MapEntryLite mapEntryLite) {
        this.metadata = mapEntry$Metadata;
        this.data = mapEntryLite;
    }

    public static MapEntry newDefaultInstance(Descriptors$Descriptor descriptors$Descriptor, WireFormat$FieldType wireFormat$FieldType, Object object, WireFormat$FieldType wireFormat$FieldType2, Object object2) {
        return new MapEntry(descriptors$Descriptor, wireFormat$FieldType, object, wireFormat$FieldType2, object2);
    }

    public Object getKey() {
        return this.data.getKey();
    }

    public Object getValue() {
        return this.data.getValue();
    }

    @Override
    public int getSerializedSize() {
        return this.data.getSerializedSize();
    }

    @Override
    public void writeTo(CodedOutputStream codedOutputStream) {
        this.data.writeTo(codedOutputStream);
    }

    @Override
    public boolean isInitialized() {
        return this.data.isInitialized();
    }

    @Override
    public Parser getParserForType() {
        return this.metadata.parser;
    }

    @Override
    public MapEntry$Builder newBuilderForType() {
        return new MapEntry$Builder(this.metadata, null);
    }

    @Override
    public MapEntry$Builder toBuilder() {
        return new MapEntry$Builder(this.metadata, this.data, null);
    }

    @Override
    public MapEntry getDefaultInstanceForType() {
        return this.metadata.defaultInstance;
    }

    @Override
    public Descriptors$Descriptor getDescriptorForType() {
        return this.metadata.descriptor;
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

    private void checkFieldDescriptor(Descriptors$FieldDescriptor descriptors$FieldDescriptor) {
        if (descriptors$FieldDescriptor.getContainingType() == this.metadata.descriptor) return;
        String string = String.valueOf(String.valueOf(descriptors$FieldDescriptor.getFullName()));
        String string2 = String.valueOf(String.valueOf(this.metadata.descriptor.getFullName()));
        throw new RuntimeException(new StringBuilder(42 + string.length() + string2.length()).append("Wrong FieldDescriptor \"").append(string).append("\" used in message \"").append(string2).toString());
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

    static /* synthetic */ MapEntryLite access$000(MapEntry mapEntry) {
        return mapEntry.data;
    }

    /* synthetic */ MapEntry(MapEntry$Metadata mapEntry$Metadata, MapEntryLite mapEntryLite, MapEntry$1 mapEntry$1) {
        this(mapEntry$Metadata, mapEntryLite);
    }
}

