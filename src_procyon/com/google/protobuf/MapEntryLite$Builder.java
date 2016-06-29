package com.google.protobuf;

import java.io.*;

public class MapEntryLite$Builder extends AbstractMessageLite$Builder
{
    private final MapEntryLite$Metadata metadata;
    private Object key;
    private Object value;
    
    private MapEntryLite$Builder(final MapEntryLite$Metadata metadata) {
        this.metadata = metadata;
        this.key = metadata.defaultInstance.key;
        this.value = metadata.defaultInstance.value;
    }
    
    public Object getKey() {
        return this.key;
    }
    
    public Object getValue() {
        return this.value;
    }
    
    public MapEntryLite$Builder setKey(final Object key) {
        this.key = key;
        return this;
    }
    
    public MapEntryLite$Builder setValue(final Object value) {
        this.value = value;
        return this;
    }
    
    public MapEntryLite$Builder clearKey() {
        this.key = this.metadata.defaultInstance.key;
        return this;
    }
    
    public MapEntryLite$Builder clearValue() {
        this.value = this.metadata.defaultInstance.value;
        return this;
    }
    
    public MapEntryLite$Builder clear() {
        this.key = this.metadata.defaultInstance.key;
        this.value = this.metadata.defaultInstance.value;
        return this;
    }
    
    public MapEntryLite build() {
        final MapEntryLite buildPartial = this.buildPartial();
        if (!buildPartial.isInitialized()) {
            throw AbstractMessageLite$Builder.newUninitializedMessageException(buildPartial);
        }
        return buildPartial;
    }
    
    public MapEntryLite buildPartial() {
        return new MapEntryLite(this.metadata, this.key, this.value, null);
    }
    
    public MessageLite getDefaultInstanceForType() {
        return this.metadata.defaultInstance;
    }
    
    public boolean isInitialized() {
        return this.metadata.valueType.getJavaType() != WireFormat$JavaType.MESSAGE || ((MessageLite)this.value).isInitialized();
    }
    
    private MapEntryLite$Builder(final MapEntryLite$Metadata metadata, final Object key, final Object value) {
        this.metadata = metadata;
        this.key = key;
        this.value = value;
    }
    
    public MapEntryLite$Builder clone() {
        return new MapEntryLite$Builder(this.metadata, this.key, this.value);
    }
    
    public MapEntryLite$Builder mergeFrom(final CodedInputStream codedInputStream, final ExtensionRegistryLite extensionRegistryLite) {
        final MapEntryLite mapEntryLite = new MapEntryLite(this.metadata, codedInputStream, extensionRegistryLite, null);
        this.key = mapEntryLite.key;
        this.value = mapEntryLite.value;
        return this;
    }
}
