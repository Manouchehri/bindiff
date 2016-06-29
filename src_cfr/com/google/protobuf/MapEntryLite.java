/*
 * Decompiled with CFR 0_115.
 */
package com.google.protobuf;

import com.google.protobuf.AbstractMessageLite;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.FieldSet;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.MapEntryLite$1;
import com.google.protobuf.MapEntryLite$Builder;
import com.google.protobuf.MapEntryLite$Metadata;
import com.google.protobuf.MessageLite;
import com.google.protobuf.MessageLite$Builder;
import com.google.protobuf.Parser;
import com.google.protobuf.WireFormat;
import com.google.protobuf.WireFormat$FieldType;
import com.google.protobuf.WireFormat$JavaType;
import java.io.IOException;

public class MapEntryLite
extends AbstractMessageLite {
    private static final int KEY_FIELD_NUMBER = 1;
    private static final int VALUE_FIELD_NUMBER = 2;
    private final MapEntryLite$Metadata metadata;
    private final Object key;
    private final Object value;
    private volatile int cachedSerializedSize = -1;

    private MapEntryLite(WireFormat$FieldType wireFormat$FieldType, Object object, WireFormat$FieldType wireFormat$FieldType2, Object object2) {
        this.metadata = new MapEntryLite$Metadata(this, wireFormat$FieldType, wireFormat$FieldType2);
        this.key = object;
        this.value = object2;
    }

    private MapEntryLite(MapEntryLite$Metadata mapEntryLite$Metadata, Object object, Object object2) {
        this.metadata = mapEntryLite$Metadata;
        this.key = object;
        this.value = object2;
    }

    public Object getKey() {
        return this.key;
    }

    public Object getValue() {
        return this.value;
    }

    public static MapEntryLite newDefaultInstance(WireFormat$FieldType wireFormat$FieldType, Object object, WireFormat$FieldType wireFormat$FieldType2, Object object2) {
        return new MapEntryLite(wireFormat$FieldType, object, wireFormat$FieldType2, object2);
    }

    @Override
    public void writeTo(CodedOutputStream codedOutputStream) {
        this.writeField(1, this.metadata.keyType, this.key, codedOutputStream);
        this.writeField(2, this.metadata.valueType, this.value, codedOutputStream);
    }

    private void writeField(int n2, WireFormat$FieldType wireFormat$FieldType, Object object, CodedOutputStream codedOutputStream) {
        codedOutputStream.writeTag(n2, wireFormat$FieldType.getWireType());
        FieldSet.writeElementNoTag(codedOutputStream, wireFormat$FieldType, object);
    }

    @Override
    public int getSerializedSize() {
        if (this.cachedSerializedSize != -1) {
            return this.cachedSerializedSize;
        }
        int n2 = 0;
        n2 += this.getFieldSize(1, this.metadata.keyType, this.key);
        this.cachedSerializedSize = n2 += this.getFieldSize(2, this.metadata.valueType, this.value);
        return n2;
    }

    private int getFieldSize(int n2, WireFormat$FieldType wireFormat$FieldType, Object object) {
        return CodedOutputStream.computeTagSize(n2) + FieldSet.computeElementSizeNoTag(wireFormat$FieldType, object);
    }

    private MapEntryLite(MapEntryLite$Metadata mapEntryLite$Metadata, CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        try {
            int n2;
            Object object = mapEntryLite$Metadata.defaultInstance.key;
            Object object2 = mapEntryLite$Metadata.defaultInstance.value;
            while ((n2 = codedInputStream.readTag()) != 0) {
                if (n2 == WireFormat.makeTag(1, mapEntryLite$Metadata.keyType.getWireType())) {
                    object = this.mergeField(codedInputStream, extensionRegistryLite, mapEntryLite$Metadata.keyType, object);
                    continue;
                }
                if (n2 == WireFormat.makeTag(2, mapEntryLite$Metadata.valueType.getWireType())) {
                    object2 = this.mergeField(codedInputStream, extensionRegistryLite, mapEntryLite$Metadata.valueType, object2);
                    continue;
                }
                if (codedInputStream.skipField(n2)) continue;
            }
            this.metadata = mapEntryLite$Metadata;
            this.key = object;
            this.value = object2;
            return;
        }
        catch (InvalidProtocolBufferException var4_5) {
            throw var4_5.setUnfinishedMessage(this);
        }
        catch (IOException var4_6) {
            throw new InvalidProtocolBufferException(var4_6.getMessage()).setUnfinishedMessage(this);
        }
    }

    private Object mergeField(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite, WireFormat$FieldType wireFormat$FieldType, Object object) {
        switch (MapEntryLite$1.$SwitchMap$com$google$protobuf$WireFormat$FieldType[wireFormat$FieldType.ordinal()]) {
            case 1: {
                MessageLite$Builder messageLite$Builder = ((MessageLite)object).toBuilder();
                codedInputStream.readMessage(messageLite$Builder, extensionRegistryLite);
                return messageLite$Builder.buildPartial();
            }
            case 2: {
                return codedInputStream.readEnum();
            }
            case 3: {
                throw new RuntimeException("Groups are not allowed in maps.");
            }
        }
        return FieldSet.readPrimitiveField(codedInputStream, wireFormat$FieldType, true);
    }

    @Override
    public Parser getParserForType() {
        return this.metadata.parser;
    }

    @Override
    public MapEntryLite$Builder newBuilderForType() {
        return new MapEntryLite$Builder(this.metadata, null);
    }

    @Override
    public MapEntryLite$Builder toBuilder() {
        return new MapEntryLite$Builder(this.metadata, this.key, this.value, null);
    }

    @Override
    public MapEntryLite getDefaultInstanceForType() {
        return this.metadata.defaultInstance;
    }

    @Override
    public boolean isInitialized() {
        if (this.metadata.valueType.getJavaType() != WireFormat$JavaType.MESSAGE) return true;
        return ((MessageLite)this.value).isInitialized();
    }

    /* synthetic */ MapEntryLite(MapEntryLite$Metadata mapEntryLite$Metadata, CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite, MapEntryLite$1 mapEntryLite$1) {
        this(mapEntryLite$Metadata, codedInputStream, extensionRegistryLite);
    }

    static /* synthetic */ Object access$300(MapEntryLite mapEntryLite) {
        return mapEntryLite.key;
    }

    static /* synthetic */ Object access$400(MapEntryLite mapEntryLite) {
        return mapEntryLite.value;
    }

    /* synthetic */ MapEntryLite(MapEntryLite$Metadata mapEntryLite$Metadata, Object object, Object object2, MapEntryLite$1 mapEntryLite$1) {
        this(mapEntryLite$Metadata, object, object2);
    }
}

