package com.google.protobuf;

import java.util.*;
import java.io.*;

public final class Struct extends GeneratedMessage implements StructOrBuilder
{
    public static final int FIELDS_FIELD_NUMBER = 1;
    private MapField fields_;
    private byte memoizedIsInitialized;
    private int memoizedSerializedSize;
    private static final long serialVersionUID = 0L;
    private static final Struct DEFAULT_INSTANCE;
    public static final Parser PARSER;
    
    private Struct(final GeneratedMessage$Builder generatedMessage$Builder) {
        super(generatedMessage$Builder);
        this.memoizedIsInitialized = -1;
        this.memoizedSerializedSize = -1;
    }
    
    private Struct() {
        this.memoizedIsInitialized = -1;
        this.memoizedSerializedSize = -1;
    }
    
    public final UnknownFieldSet getUnknownFields() {
        return UnknownFieldSet.getDefaultInstance();
    }
    
    private Struct(final CodedInputStream codedInputStream, final ExtensionRegistryLite extensionRegistryLite) {
        this();
        int n = 0;
        try {
            int i = 0;
            while (i == 0) {
                final int tag = codedInputStream.readTag();
                switch (tag) {
                    case 0: {
                        i = 1;
                        continue;
                    }
                    default: {
                        if (!codedInputStream.skipField(tag)) {
                            i = 1;
                            continue;
                        }
                        continue;
                    }
                    case 10: {
                        if ((n & 0x1) != 0x1) {
                            this.fields_ = MapField.newMapField(Struct$FieldsDefaultEntryHolder.defaultEntry);
                            n |= 0x1;
                        }
                        final MapEntry mapEntry = (MapEntry)codedInputStream.readMessage(Struct$FieldsDefaultEntryHolder.defaultEntry.getParserForType(), extensionRegistryLite);
                        this.fields_.getMutableMap().put(mapEntry.getKey(), mapEntry.getValue());
                        continue;
                    }
                }
            }
        }
        catch (InvalidProtocolBufferException ex) {
            throw new RuntimeException(ex.setUnfinishedMessage(this));
        }
        catch (IOException ex2) {
            throw new RuntimeException(new InvalidProtocolBufferException(ex2.getMessage()).setUnfinishedMessage(this));
        }
        finally {
            this.makeExtensionsImmutable();
        }
    }
    
    public static final Descriptors$Descriptor getDescriptor() {
        return StructProto.internal_static_google_protobuf_Struct_descriptor;
    }
    
    protected MapField internalGetMapField(final int n) {
        switch (n) {
            case 1: {
                return this.internalGetFields();
            }
            default: {
                throw new RuntimeException(new StringBuilder(37).append("Invalid map field number: ").append(n).toString());
            }
        }
    }
    
    protected GeneratedMessage$FieldAccessorTable internalGetFieldAccessorTable() {
        return StructProto.internal_static_google_protobuf_Struct_fieldAccessorTable.ensureFieldAccessorsInitialized(Struct.class, Struct$Builder.class);
    }
    
    private MapField internalGetFields() {
        if (this.fields_ == null) {
            return MapField.emptyMapField(Struct$FieldsDefaultEntryHolder.defaultEntry);
        }
        return this.fields_;
    }
    
    public Map getFields() {
        return this.internalGetFields().getMap();
    }
    
    public final boolean isInitialized() {
        final byte memoizedIsInitialized = this.memoizedIsInitialized;
        if (memoizedIsInitialized == 1) {
            return true;
        }
        if (memoizedIsInitialized == 0) {
            return false;
        }
        this.memoizedIsInitialized = 1;
        return true;
    }
    
    public void writeTo(final CodedOutputStream codedOutputStream) {
        for (final Map.Entry<Object, V> entry : this.internalGetFields().getMap().entrySet()) {
            codedOutputStream.writeMessage(1, Struct$FieldsDefaultEntryHolder.defaultEntry.newBuilderForType().setKey(entry.getKey()).setValue(entry.getValue()).build());
        }
    }
    
    public int getSerializedSize() {
        final int memoizedSerializedSize = this.memoizedSerializedSize;
        if (memoizedSerializedSize != -1) {
            return memoizedSerializedSize;
        }
        int memoizedSerializedSize2 = 0;
        for (final Map.Entry<Object, V> entry : this.internalGetFields().getMap().entrySet()) {
            memoizedSerializedSize2 += CodedOutputStream.computeMessageSize(1, Struct$FieldsDefaultEntryHolder.defaultEntry.newBuilderForType().setKey(entry.getKey()).setValue(entry.getValue()).build());
        }
        return this.memoizedSerializedSize = memoizedSerializedSize2;
    }
    
    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof Struct)) {
            return super.equals(o);
        }
        final Struct struct = (Struct)o;
        return true && this.internalGetFields().equals(struct.internalGetFields());
    }
    
    public int hashCode() {
        if (this.memoizedHashCode != 0) {
            return this.memoizedHashCode;
        }
        int n = 19 * 41 + this.getDescriptorForType().hashCode();
        if (!this.internalGetFields().getMap().isEmpty()) {
            n = 53 * (37 * n + 1) + this.internalGetFields().hashCode();
        }
        return this.memoizedHashCode = 29 * n + this.unknownFields.hashCode();
    }
    
    public static Struct parseFrom(final ByteString byteString) {
        return (Struct)Struct.PARSER.parseFrom(byteString);
    }
    
    public static Struct parseFrom(final ByteString byteString, final ExtensionRegistryLite extensionRegistryLite) {
        return (Struct)Struct.PARSER.parseFrom(byteString, extensionRegistryLite);
    }
    
    public static Struct parseFrom(final byte[] array) {
        return (Struct)Struct.PARSER.parseFrom(array);
    }
    
    public static Struct parseFrom(final byte[] array, final ExtensionRegistryLite extensionRegistryLite) {
        return (Struct)Struct.PARSER.parseFrom(array, extensionRegistryLite);
    }
    
    public static Struct parseFrom(final InputStream inputStream) {
        return (Struct)Struct.PARSER.parseFrom(inputStream);
    }
    
    public static Struct parseFrom(final InputStream inputStream, final ExtensionRegistryLite extensionRegistryLite) {
        return (Struct)Struct.PARSER.parseFrom(inputStream, extensionRegistryLite);
    }
    
    public static Struct parseDelimitedFrom(final InputStream inputStream) {
        return (Struct)Struct.PARSER.parseDelimitedFrom(inputStream);
    }
    
    public static Struct parseDelimitedFrom(final InputStream inputStream, final ExtensionRegistryLite extensionRegistryLite) {
        return (Struct)Struct.PARSER.parseDelimitedFrom(inputStream, extensionRegistryLite);
    }
    
    public static Struct parseFrom(final CodedInputStream codedInputStream) {
        return (Struct)Struct.PARSER.parseFrom(codedInputStream);
    }
    
    public static Struct parseFrom(final CodedInputStream codedInputStream, final ExtensionRegistryLite extensionRegistryLite) {
        return (Struct)Struct.PARSER.parseFrom(codedInputStream, extensionRegistryLite);
    }
    
    public Struct$Builder newBuilderForType() {
        return newBuilder();
    }
    
    public static Struct$Builder newBuilder() {
        return Struct.DEFAULT_INSTANCE.toBuilder();
    }
    
    public static Struct$Builder newBuilder(final Struct struct) {
        return Struct.DEFAULT_INSTANCE.toBuilder().mergeFrom(struct);
    }
    
    public Struct$Builder toBuilder() {
        return (this == Struct.DEFAULT_INSTANCE) ? new Struct$Builder((Struct$1)null) : new Struct$Builder((Struct$1)null).mergeFrom(this);
    }
    
    protected Struct$Builder newBuilderForType(final GeneratedMessage$BuilderParent generatedMessage$BuilderParent) {
        return new Struct$Builder(generatedMessage$BuilderParent, null);
    }
    
    public static Struct getDefaultInstance() {
        return Struct.DEFAULT_INSTANCE;
    }
    
    public Parser getParserForType() {
        return Struct.PARSER;
    }
    
    public Struct getDefaultInstanceForType() {
        return Struct.DEFAULT_INSTANCE;
    }
    
    static {
        DEFAULT_INSTANCE = new Struct();
        PARSER = new Struct$1();
    }
}
