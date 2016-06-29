package com.google.protobuf;

import java.util.*;

public final class MapEntry extends AbstractMessage
{
    private final MapEntry$Metadata metadata;
    private final MapEntryLite data;
    
    private MapEntry(final Descriptors$Descriptor descriptors$Descriptor, final WireFormat$FieldType wireFormat$FieldType, final Object o, final WireFormat$FieldType wireFormat$FieldType2, final Object o2) {
        this.data = MapEntryLite.newDefaultInstance(wireFormat$FieldType, o, wireFormat$FieldType2, o2);
        this.metadata = new MapEntry$Metadata(descriptors$Descriptor, this);
    }
    
    private MapEntry(final MapEntry$Metadata metadata, final MapEntryLite data) {
        this.metadata = metadata;
        this.data = data;
    }
    
    public static MapEntry newDefaultInstance(final Descriptors$Descriptor descriptors$Descriptor, final WireFormat$FieldType wireFormat$FieldType, final Object o, final WireFormat$FieldType wireFormat$FieldType2, final Object o2) {
        return new MapEntry(descriptors$Descriptor, wireFormat$FieldType, o, wireFormat$FieldType2, o2);
    }
    
    public Object getKey() {
        return this.data.getKey();
    }
    
    public Object getValue() {
        return this.data.getValue();
    }
    
    public int getSerializedSize() {
        return this.data.getSerializedSize();
    }
    
    public void writeTo(final CodedOutputStream codedOutputStream) {
        this.data.writeTo(codedOutputStream);
    }
    
    public boolean isInitialized() {
        return this.data.isInitialized();
    }
    
    public Parser getParserForType() {
        return this.metadata.parser;
    }
    
    public MapEntry$Builder newBuilderForType() {
        return new MapEntry$Builder(this.metadata, (MapEntry$1)null);
    }
    
    public MapEntry$Builder toBuilder() {
        return new MapEntry$Builder(this.metadata, this.data, null);
    }
    
    public MapEntry getDefaultInstanceForType() {
        return this.metadata.defaultInstance;
    }
    
    public Descriptors$Descriptor getDescriptorForType() {
        return this.metadata.descriptor;
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
    
    private void checkFieldDescriptor(final Descriptors$FieldDescriptor descriptors$FieldDescriptor) {
        if (descriptors$FieldDescriptor.getContainingType() != this.metadata.descriptor) {
            final String value = String.valueOf(String.valueOf(descriptors$FieldDescriptor.getFullName()));
            final String value2 = String.valueOf(String.valueOf(this.metadata.descriptor.getFullName()));
            throw new RuntimeException(new StringBuilder(42 + value.length() + value2.length()).append("Wrong FieldDescriptor \"").append(value).append("\" used in message \"").append(value2).toString());
        }
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
}
