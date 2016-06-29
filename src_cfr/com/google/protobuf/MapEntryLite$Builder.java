/*
 * Decompiled with CFR 0_115.
 */
package com.google.protobuf;

import com.google.protobuf.AbstractMessageLite$Builder;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.MapEntryLite;
import com.google.protobuf.MapEntryLite$1;
import com.google.protobuf.MapEntryLite$Metadata;
import com.google.protobuf.MessageLite;
import com.google.protobuf.MessageLite$Builder;
import com.google.protobuf.WireFormat$FieldType;
import com.google.protobuf.WireFormat$JavaType;

public class MapEntryLite$Builder
extends AbstractMessageLite$Builder {
    private final MapEntryLite$Metadata metadata;
    private Object key;
    private Object value;

    private MapEntryLite$Builder(MapEntryLite$Metadata mapEntryLite$Metadata) {
        this.metadata = mapEntryLite$Metadata;
        this.key = MapEntryLite.access$300(mapEntryLite$Metadata.defaultInstance);
        this.value = MapEntryLite.access$400(mapEntryLite$Metadata.defaultInstance);
    }

    public Object getKey() {
        return this.key;
    }

    public Object getValue() {
        return this.value;
    }

    public MapEntryLite$Builder setKey(Object object) {
        this.key = object;
        return this;
    }

    public MapEntryLite$Builder setValue(Object object) {
        this.value = object;
        return this;
    }

    public MapEntryLite$Builder clearKey() {
        this.key = MapEntryLite.access$300(this.metadata.defaultInstance);
        return this;
    }

    public MapEntryLite$Builder clearValue() {
        this.value = MapEntryLite.access$400(this.metadata.defaultInstance);
        return this;
    }

    @Override
    public MapEntryLite$Builder clear() {
        this.key = MapEntryLite.access$300(this.metadata.defaultInstance);
        this.value = MapEntryLite.access$400(this.metadata.defaultInstance);
        return this;
    }

    @Override
    public MapEntryLite build() {
        MapEntryLite mapEntryLite = this.buildPartial();
        if (mapEntryLite.isInitialized()) return mapEntryLite;
        throw MapEntryLite$Builder.newUninitializedMessageException(mapEntryLite);
    }

    @Override
    public MapEntryLite buildPartial() {
        return new MapEntryLite(this.metadata, this.key, this.value, null);
    }

    @Override
    public MessageLite getDefaultInstanceForType() {
        return this.metadata.defaultInstance;
    }

    @Override
    public boolean isInitialized() {
        if (this.metadata.valueType.getJavaType() != WireFormat$JavaType.MESSAGE) return true;
        return ((MessageLite)this.value).isInitialized();
    }

    private MapEntryLite$Builder(MapEntryLite$Metadata mapEntryLite$Metadata, Object object, Object object2) {
        this.metadata = mapEntryLite$Metadata;
        this.key = object;
        this.value = object2;
    }

    @Override
    public MapEntryLite$Builder clone() {
        return new MapEntryLite$Builder(this.metadata, this.key, this.value);
    }

    @Override
    public MapEntryLite$Builder mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        MapEntryLite mapEntryLite = new MapEntryLite(this.metadata, codedInputStream, extensionRegistryLite, null);
        this.key = MapEntryLite.access$300(mapEntryLite);
        this.value = MapEntryLite.access$400(mapEntryLite);
        return this;
    }

    /* synthetic */ MapEntryLite$Builder(MapEntryLite$Metadata mapEntryLite$Metadata, MapEntryLite$1 mapEntryLite$1) {
        this(mapEntryLite$Metadata);
    }

    /* synthetic */ MapEntryLite$Builder(MapEntryLite$Metadata mapEntryLite$Metadata, Object object, Object object2, MapEntryLite$1 mapEntryLite$1) {
        this(mapEntryLite$Metadata, object, object2);
    }
}

