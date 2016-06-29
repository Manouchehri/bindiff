package com.google.protobuf;

import java.util.*;

public class MapEntry$Builder extends AbstractMessage$Builder
{
    private final MapEntry$Metadata metadata;
    private MapEntryLite data;
    private MapEntryLite$Builder dataBuilder;
    
    private MapEntry$Builder(final MapEntry$Metadata metadata) {
        this.metadata = metadata;
        this.data = metadata.defaultInstance.data;
        this.dataBuilder = null;
    }
    
    private MapEntry$Builder(final MapEntry$Metadata metadata, final MapEntryLite data) {
        this.metadata = metadata;
        this.data = data;
        this.dataBuilder = null;
    }
    
    public Object getKey() {
        return (this.dataBuilder == null) ? this.data.getKey() : this.dataBuilder.getKey();
    }
    
    public Object getValue() {
        return (this.dataBuilder == null) ? this.data.getValue() : this.dataBuilder.getValue();
    }
    
    private void ensureMutable() {
        if (this.dataBuilder == null) {
            this.dataBuilder = this.data.toBuilder();
        }
    }
    
    public MapEntry$Builder setKey(final Object key) {
        this.ensureMutable();
        this.dataBuilder.setKey(key);
        return this;
    }
    
    public MapEntry$Builder clearKey() {
        this.ensureMutable();
        this.dataBuilder.clearKey();
        return this;
    }
    
    public MapEntry$Builder setValue(final Object value) {
        this.ensureMutable();
        this.dataBuilder.setValue(value);
        return this;
    }
    
    public MapEntry$Builder clearValue() {
        this.ensureMutable();
        this.dataBuilder.clearValue();
        return this;
    }
    
    public MapEntry build() {
        final MapEntry buildPartial = this.buildPartial();
        if (!buildPartial.isInitialized()) {
            throw AbstractMessage$Builder.newUninitializedMessageException(buildPartial);
        }
        return buildPartial;
    }
    
    public MapEntry buildPartial() {
        if (this.dataBuilder != null) {
            this.data = this.dataBuilder.buildPartial();
            this.dataBuilder = null;
        }
        return new MapEntry(this.metadata, this.data, null);
    }
    
    public Descriptors$Descriptor getDescriptorForType() {
        return this.metadata.descriptor;
    }
    
    private void checkFieldDescriptor(final Descriptors$FieldDescriptor descriptors$FieldDescriptor) {
        if (descriptors$FieldDescriptor.getContainingType() != this.metadata.descriptor) {
            final String value = String.valueOf(String.valueOf(descriptors$FieldDescriptor.getFullName()));
            final String value2 = String.valueOf(String.valueOf(this.metadata.descriptor.getFullName()));
            throw new RuntimeException(new StringBuilder(42 + value.length() + value2.length()).append("Wrong FieldDescriptor \"").append(value).append("\" used in message \"").append(value2).toString());
        }
    }
    
    public Message$Builder newBuilderForField(final Descriptors$FieldDescriptor descriptors$FieldDescriptor) {
        this.checkFieldDescriptor(descriptors$FieldDescriptor);
        if (descriptors$FieldDescriptor.getNumber() != 2 || descriptors$FieldDescriptor.getJavaType() != Descriptors$FieldDescriptor$JavaType.MESSAGE) {
            final String value = String.valueOf(String.valueOf(descriptors$FieldDescriptor.getFullName()));
            throw new RuntimeException(new StringBuilder(32 + value.length()).append("\"").append(value).append("\" is not a message value field.").toString());
        }
        return ((Message)this.data.getValue()).newBuilderForType();
    }
    
    public MapEntry$Builder setField(final Descriptors$FieldDescriptor descriptors$FieldDescriptor, Object value) {
        this.checkFieldDescriptor(descriptors$FieldDescriptor);
        if (descriptors$FieldDescriptor.getNumber() == 1) {
            this.setKey(value);
        }
        else {
            if (descriptors$FieldDescriptor.getType() == Descriptors$FieldDescriptor$Type.ENUM) {
                value = ((Descriptors$EnumValueDescriptor)value).getNumber();
            }
            this.setValue(value);
        }
        return this;
    }
    
    public MapEntry$Builder clearField(final Descriptors$FieldDescriptor descriptors$FieldDescriptor) {
        this.checkFieldDescriptor(descriptors$FieldDescriptor);
        if (descriptors$FieldDescriptor.getNumber() == 1) {
            this.clearKey();
        }
        else {
            this.clearValue();
        }
        return this;
    }
    
    public MapEntry$Builder setRepeatedField(final Descriptors$FieldDescriptor descriptors$FieldDescriptor, final int n, final Object o) {
        throw new RuntimeException("There is no repeated field in a map entry message.");
    }
    
    public MapEntry$Builder addRepeatedField(final Descriptors$FieldDescriptor descriptors$FieldDescriptor, final Object o) {
        throw new RuntimeException("There is no repeated field in a map entry message.");
    }
    
    public MapEntry$Builder setUnknownFields(final UnknownFieldSet set) {
        return this;
    }
    
    public MapEntry getDefaultInstanceForType() {
        return this.metadata.defaultInstance;
    }
    
    public boolean isInitialized() {
        if (this.dataBuilder != null) {
            return this.dataBuilder.isInitialized();
        }
        return this.data.isInitialized();
    }
    
    public Map getAllFields() {
        final TreeMap<Descriptors$FieldDescriptor, Object> treeMap = new TreeMap<Descriptors$FieldDescriptor, Object>();
        for (final Descriptors$FieldDescriptor descriptors$FieldDescriptor : this.metadata.descriptor.getFields()) {
            if (this.hasField(descriptors$FieldDescriptor)) {
                treeMap.put(descriptors$FieldDescriptor, this.getField(descriptors$FieldDescriptor));
            }
        }
        return Collections.unmodifiableMap((Map<?, ?>)treeMap);
    }
    
    public boolean hasField(final Descriptors$FieldDescriptor descriptors$FieldDescriptor) {
        this.checkFieldDescriptor(descriptors$FieldDescriptor);
        return true;
    }
    
    public Object getField(final Descriptors$FieldDescriptor descriptors$FieldDescriptor) {
        this.checkFieldDescriptor(descriptors$FieldDescriptor);
        Object valueByNumberCreatingIfUnknown = (descriptors$FieldDescriptor.getNumber() == 1) ? this.getKey() : this.getValue();
        if (descriptors$FieldDescriptor.getType() == Descriptors$FieldDescriptor$Type.ENUM) {
            valueByNumberCreatingIfUnknown = descriptors$FieldDescriptor.getEnumType().findValueByNumberCreatingIfUnknown((int)valueByNumberCreatingIfUnknown);
        }
        return valueByNumberCreatingIfUnknown;
    }
    
    public int getRepeatedFieldCount(final Descriptors$FieldDescriptor descriptors$FieldDescriptor) {
        throw new RuntimeException("There is no repeated field in a map entry message.");
    }
    
    public Object getRepeatedField(final Descriptors$FieldDescriptor descriptors$FieldDescriptor, final int n) {
        throw new RuntimeException("There is no repeated field in a map entry message.");
    }
    
    public UnknownFieldSet getUnknownFields() {
        return UnknownFieldSet.getDefaultInstance();
    }
    
    public MapEntry$Builder clone() {
        if (this.dataBuilder == null) {
            return new MapEntry$Builder(this.metadata, this.data);
        }
        return new MapEntry$Builder(this.metadata, this.dataBuilder.build());
    }
}
