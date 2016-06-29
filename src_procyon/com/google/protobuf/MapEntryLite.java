package com.google.protobuf;

import java.io.*;

public class MapEntryLite extends AbstractMessageLite
{
    private static final int KEY_FIELD_NUMBER = 1;
    private static final int VALUE_FIELD_NUMBER = 2;
    private final MapEntryLite$Metadata metadata;
    private final Object key;
    private final Object value;
    private volatile int cachedSerializedSize;
    
    private MapEntryLite(final WireFormat$FieldType wireFormat$FieldType, final Object key, final WireFormat$FieldType wireFormat$FieldType2, final Object value) {
        this.cachedSerializedSize = -1;
        this.metadata = new MapEntryLite$Metadata(this, wireFormat$FieldType, wireFormat$FieldType2);
        this.key = key;
        this.value = value;
    }
    
    private MapEntryLite(final MapEntryLite$Metadata metadata, final Object key, final Object value) {
        this.cachedSerializedSize = -1;
        this.metadata = metadata;
        this.key = key;
        this.value = value;
    }
    
    public Object getKey() {
        return this.key;
    }
    
    public Object getValue() {
        return this.value;
    }
    
    public static MapEntryLite newDefaultInstance(final WireFormat$FieldType wireFormat$FieldType, final Object o, final WireFormat$FieldType wireFormat$FieldType2, final Object o2) {
        return new MapEntryLite(wireFormat$FieldType, o, wireFormat$FieldType2, o2);
    }
    
    public void writeTo(final CodedOutputStream codedOutputStream) {
        this.writeField(1, this.metadata.keyType, this.key, codedOutputStream);
        this.writeField(2, this.metadata.valueType, this.value, codedOutputStream);
    }
    
    private void writeField(final int n, final WireFormat$FieldType wireFormat$FieldType, final Object o, final CodedOutputStream codedOutputStream) {
        codedOutputStream.writeTag(n, wireFormat$FieldType.getWireType());
        FieldSet.writeElementNoTag(codedOutputStream, wireFormat$FieldType, o);
    }
    
    public int getSerializedSize() {
        if (this.cachedSerializedSize != -1) {
            return this.cachedSerializedSize;
        }
        return this.cachedSerializedSize = 0 + this.getFieldSize(1, this.metadata.keyType, this.key) + this.getFieldSize(2, this.metadata.valueType, this.value);
    }
    
    private int getFieldSize(final int n, final WireFormat$FieldType wireFormat$FieldType, final Object o) {
        return CodedOutputStream.computeTagSize(n) + FieldSet.computeElementSizeNoTag(wireFormat$FieldType, o);
    }
    
    private MapEntryLite(final MapEntryLite$Metadata metadata, final CodedInputStream codedInputStream, final ExtensionRegistryLite extensionRegistryLite) {
        this.cachedSerializedSize = -1;
        try {
            Object key = metadata.defaultInstance.key;
            Object value = metadata.defaultInstance.value;
            while (true) {
                final int tag = codedInputStream.readTag();
                if (tag == 0) {
                    break;
                }
                if (tag == WireFormat.makeTag(1, metadata.keyType.getWireType())) {
                    key = this.mergeField(codedInputStream, extensionRegistryLite, metadata.keyType, key);
                }
                else if (tag == WireFormat.makeTag(2, metadata.valueType.getWireType())) {
                    value = this.mergeField(codedInputStream, extensionRegistryLite, metadata.valueType, value);
                }
                else {
                    if (!codedInputStream.skipField(tag)) {
                        break;
                    }
                    continue;
                }
            }
            this.metadata = metadata;
            this.key = key;
            this.value = value;
        }
        catch (InvalidProtocolBufferException ex) {
            throw ex.setUnfinishedMessage(this);
        }
        catch (IOException ex2) {
            throw new InvalidProtocolBufferException(ex2.getMessage()).setUnfinishedMessage(this);
        }
    }
    
    private Object mergeField(final CodedInputStream codedInputStream, final ExtensionRegistryLite extensionRegistryLite, final WireFormat$FieldType wireFormat$FieldType, final Object o) {
        switch (MapEntryLite$1.$SwitchMap$com$google$protobuf$WireFormat$FieldType[wireFormat$FieldType.ordinal()]) {
            case 1: {
                final MessageLite$Builder builder = ((MessageLite)o).toBuilder();
                codedInputStream.readMessage(builder, extensionRegistryLite);
                return builder.buildPartial();
            }
            case 2: {
                return codedInputStream.readEnum();
            }
            case 3: {
                throw new RuntimeException("Groups are not allowed in maps.");
            }
            default: {
                return FieldSet.readPrimitiveField(codedInputStream, wireFormat$FieldType, true);
            }
        }
    }
    
    public Parser getParserForType() {
        return this.metadata.parser;
    }
    
    public MapEntryLite$Builder newBuilderForType() {
        return new MapEntryLite$Builder(this.metadata, null);
    }
    
    public MapEntryLite$Builder toBuilder() {
        return new MapEntryLite$Builder(this.metadata, this.key, this.value, null);
    }
    
    public MapEntryLite getDefaultInstanceForType() {
        return this.metadata.defaultInstance;
    }
    
    public boolean isInitialized() {
        return this.metadata.valueType.getJavaType() != WireFormat$JavaType.MESSAGE || ((MessageLite)this.value).isInitialized();
    }
}
