/*
 * Decompiled with CFR 0_115.
 */
package com.google.protobuf;

import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.Descriptors$Descriptor;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessage;
import com.google.protobuf.GeneratedMessage$Builder;
import com.google.protobuf.GeneratedMessage$BuilderParent;
import com.google.protobuf.GeneratedMessage$FieldAccessorTable;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.MapEntry;
import com.google.protobuf.MapEntry$Builder;
import com.google.protobuf.MapField;
import com.google.protobuf.Message;
import com.google.protobuf.Message$Builder;
import com.google.protobuf.MessageLite;
import com.google.protobuf.MessageLite$Builder;
import com.google.protobuf.Parser;
import com.google.protobuf.Struct$1;
import com.google.protobuf.Struct$Builder;
import com.google.protobuf.Struct$FieldsDefaultEntryHolder;
import com.google.protobuf.StructOrBuilder;
import com.google.protobuf.StructProto;
import com.google.protobuf.UnknownFieldSet;
import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public final class Struct
extends GeneratedMessage
implements StructOrBuilder {
    public static final int FIELDS_FIELD_NUMBER = 1;
    private MapField fields_;
    private byte memoizedIsInitialized = -1;
    private int memoizedSerializedSize = -1;
    private static final long serialVersionUID = 0;
    private static final Struct DEFAULT_INSTANCE = new Struct();
    public static final Parser PARSER = new Struct$1();

    private Struct(GeneratedMessage$Builder generatedMessage$Builder) {
        super(generatedMessage$Builder);
    }

    private Struct() {
    }

    @Override
    public final UnknownFieldSet getUnknownFields() {
        return UnknownFieldSet.getDefaultInstance();
    }

    private Struct(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        this();
        boolean bl2 = false;
        try {
            try {
                boolean bl3 = false;
                block9 : while (!bl3) {
                    int n2 = codedInputStream.readTag();
                    switch (n2) {
                        case 0: {
                            bl3 = true;
                            continue block9;
                        }
                        default: {
                            if (codedInputStream.skipField(n2)) continue block9;
                            bl3 = true;
                            continue block9;
                        }
                        case 10: 
                    }
                    if (!(bl2 & true)) {
                        this.fields_ = MapField.newMapField(Struct$FieldsDefaultEntryHolder.defaultEntry);
                        bl2 |= true;
                    }
                    MapEntry mapEntry = (MapEntry)codedInputStream.readMessage(Struct$FieldsDefaultEntryHolder.defaultEntry.getParserForType(), extensionRegistryLite);
                    this.fields_.getMutableMap().put(mapEntry.getKey(), mapEntry.getValue());
                }
                Object var8_9 = null;
            }
            catch (InvalidProtocolBufferException var4_5) {
                throw new RuntimeException(var4_5.setUnfinishedMessage(this));
            }
            catch (IOException var4_6) {
                throw new RuntimeException(new InvalidProtocolBufferException(var4_6.getMessage()).setUnfinishedMessage(this));
            }
            this.makeExtensionsImmutable();
            return;
        }
        catch (Throwable var7_11) {
            Object var8_10 = null;
            this.makeExtensionsImmutable();
            throw var7_11;
        }
    }

    public static final Descriptors$Descriptor getDescriptor() {
        return StructProto.internal_static_google_protobuf_Struct_descriptor;
    }

    @Override
    protected MapField internalGetMapField(int n2) {
        switch (n2) {
            case 1: {
                return this.internalGetFields();
            }
        }
        int n3 = n2;
        throw new RuntimeException(new StringBuilder(37).append("Invalid map field number: ").append(n3).toString());
    }

    @Override
    protected GeneratedMessage$FieldAccessorTable internalGetFieldAccessorTable() {
        return StructProto.internal_static_google_protobuf_Struct_fieldAccessorTable.ensureFieldAccessorsInitialized(Struct.class, Struct$Builder.class);
    }

    private MapField internalGetFields() {
        if (this.fields_ != null) return this.fields_;
        return MapField.emptyMapField(Struct$FieldsDefaultEntryHolder.defaultEntry);
    }

    @Override
    public Map getFields() {
        return this.internalGetFields().getMap();
    }

    @Override
    public final boolean isInitialized() {
        byte by2 = this.memoizedIsInitialized;
        if (by2 == 1) {
            return true;
        }
        if (by2 == 0) {
            return false;
        }
        this.memoizedIsInitialized = 1;
        return true;
    }

    @Override
    public void writeTo(CodedOutputStream codedOutputStream) {
        Iterator iterator = this.internalGetFields().getMap().entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry entry = iterator.next();
            MapEntry mapEntry = Struct$FieldsDefaultEntryHolder.defaultEntry.newBuilderForType().setKey(entry.getKey()).setValue(entry.getValue()).build();
            codedOutputStream.writeMessage(1, mapEntry);
        }
    }

    @Override
    public int getSerializedSize() {
        int n2 = this.memoizedSerializedSize;
        if (n2 != -1) {
            return n2;
        }
        n2 = 0;
        Iterator iterator = this.internalGetFields().getMap().entrySet().iterator();
        do {
            if (!iterator.hasNext()) {
                this.memoizedSerializedSize = n2;
                return n2;
            }
            Map.Entry entry = iterator.next();
            MapEntry mapEntry = Struct$FieldsDefaultEntryHolder.defaultEntry.newBuilderForType().setKey(entry.getKey()).setValue(entry.getValue()).build();
            n2 += CodedOutputStream.computeMessageSize(1, mapEntry);
        } while (true);
    }

    @Override
    public boolean equals(Object object) {
        if (object == this) {
            return true;
        }
        if (!(object instanceof Struct)) {
            return super.equals(object);
        }
        Struct struct = (Struct)object;
        boolean bl2 = true;
        if (!bl2) return false;
        if (!this.internalGetFields().equals(struct.internalGetFields())) return false;
        return true;
    }

    @Override
    public int hashCode() {
        if (this.memoizedHashCode != 0) {
            return this.memoizedHashCode;
        }
        int n2 = 41;
        n2 = 19 * n2 + this.getDescriptorForType().hashCode();
        if (!this.internalGetFields().getMap().isEmpty()) {
            n2 = 37 * n2 + 1;
            n2 = 53 * n2 + this.internalGetFields().hashCode();
        }
        this.memoizedHashCode = n2 = 29 * n2 + this.unknownFields.hashCode();
        return n2;
    }

    public static Struct parseFrom(ByteString byteString) {
        return (Struct)PARSER.parseFrom(byteString);
    }

    public static Struct parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        return (Struct)PARSER.parseFrom(byteString, extensionRegistryLite);
    }

    public static Struct parseFrom(byte[] arrby) {
        return (Struct)PARSER.parseFrom(arrby);
    }

    public static Struct parseFrom(byte[] arrby, ExtensionRegistryLite extensionRegistryLite) {
        return (Struct)PARSER.parseFrom(arrby, extensionRegistryLite);
    }

    public static Struct parseFrom(InputStream inputStream) {
        return (Struct)PARSER.parseFrom(inputStream);
    }

    public static Struct parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (Struct)PARSER.parseFrom(inputStream, extensionRegistryLite);
    }

    public static Struct parseDelimitedFrom(InputStream inputStream) {
        return (Struct)PARSER.parseDelimitedFrom(inputStream);
    }

    public static Struct parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (Struct)PARSER.parseDelimitedFrom(inputStream, extensionRegistryLite);
    }

    public static Struct parseFrom(CodedInputStream codedInputStream) {
        return (Struct)PARSER.parseFrom(codedInputStream);
    }

    public static Struct parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (Struct)PARSER.parseFrom(codedInputStream, extensionRegistryLite);
    }

    @Override
    public Struct$Builder newBuilderForType() {
        return Struct.newBuilder();
    }

    public static Struct$Builder newBuilder() {
        return DEFAULT_INSTANCE.toBuilder();
    }

    public static Struct$Builder newBuilder(Struct struct) {
        return DEFAULT_INSTANCE.toBuilder().mergeFrom(struct);
    }

    @Override
    public Struct$Builder toBuilder() {
        Struct$Builder struct$Builder;
        if (this == DEFAULT_INSTANCE) {
            struct$Builder = new Struct$Builder(null);
            return struct$Builder;
        }
        struct$Builder = new Struct$Builder(null).mergeFrom(this);
        return struct$Builder;
    }

    @Override
    protected Struct$Builder newBuilderForType(GeneratedMessage$BuilderParent generatedMessage$BuilderParent) {
        return new Struct$Builder(generatedMessage$BuilderParent, null);
    }

    public static Struct getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    @Override
    public Parser getParserForType() {
        return PARSER;
    }

    @Override
    public Struct getDefaultInstanceForType() {
        return DEFAULT_INSTANCE;
    }

    /* synthetic */ Struct(GeneratedMessage$Builder generatedMessage$Builder, Struct$1 struct$1) {
        this(generatedMessage$Builder);
    }

    static /* synthetic */ MapField access$302(Struct struct, MapField mapField) {
        struct.fields_ = mapField;
        return struct.fields_;
    }

    static /* synthetic */ MapField access$300(Struct struct) {
        return struct.fields_;
    }

    static /* synthetic */ MapField access$400(Struct struct) {
        return struct.internalGetFields();
    }

    /* synthetic */ Struct(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite, Struct$1 struct$1) {
        this(codedInputStream, extensionRegistryLite);
    }
}

