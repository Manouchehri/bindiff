/*
 * Decompiled with CFR 0_115.
 */
package com.google.protobuf;

import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.Descriptors$Descriptor;
import com.google.protobuf.Empty$1;
import com.google.protobuf.Empty$Builder;
import com.google.protobuf.EmptyOrBuilder;
import com.google.protobuf.EmptyProto;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessage;
import com.google.protobuf.GeneratedMessage$Builder;
import com.google.protobuf.GeneratedMessage$BuilderParent;
import com.google.protobuf.GeneratedMessage$FieldAccessorTable;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.Message;
import com.google.protobuf.Message$Builder;
import com.google.protobuf.MessageLite;
import com.google.protobuf.MessageLite$Builder;
import com.google.protobuf.Parser;
import com.google.protobuf.UnknownFieldSet;
import java.io.IOException;
import java.io.InputStream;

public final class Empty
extends GeneratedMessage
implements EmptyOrBuilder {
    private byte memoizedIsInitialized = -1;
    private int memoizedSerializedSize = -1;
    private static final long serialVersionUID = 0;
    private static final Empty DEFAULT_INSTANCE = new Empty();
    public static final Parser PARSER = new Empty$1();

    private Empty(GeneratedMessage$Builder generatedMessage$Builder) {
        super(generatedMessage$Builder);
    }

    private Empty() {
    }

    @Override
    public final UnknownFieldSet getUnknownFields() {
        return UnknownFieldSet.getDefaultInstance();
    }

    private Empty(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        this();
        try {
            try {
                boolean bl2 = false;
                block8 : while (!bl2) {
                    int n2 = codedInputStream.readTag();
                    switch (n2) {
                        case 0: {
                            bl2 = true;
                            continue block8;
                        }
                    }
                    if (codedInputStream.skipField(n2)) continue;
                    bl2 = true;
                }
                Object var6_7 = null;
            }
            catch (InvalidProtocolBufferException var3_4) {
                throw new RuntimeException(var3_4.setUnfinishedMessage(this));
            }
            catch (IOException var3_5) {
                throw new RuntimeException(new InvalidProtocolBufferException(var3_5.getMessage()).setUnfinishedMessage(this));
            }
            this.makeExtensionsImmutable();
            return;
        }
        catch (Throwable var5_9) {
            Object var6_8 = null;
            this.makeExtensionsImmutable();
            throw var5_9;
        }
    }

    public static final Descriptors$Descriptor getDescriptor() {
        return EmptyProto.internal_static_google_protobuf_Empty_descriptor;
    }

    @Override
    protected GeneratedMessage$FieldAccessorTable internalGetFieldAccessorTable() {
        return EmptyProto.internal_static_google_protobuf_Empty_fieldAccessorTable.ensureFieldAccessorsInitialized(Empty.class, Empty$Builder.class);
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
    }

    @Override
    public int getSerializedSize() {
        int n2 = this.memoizedSerializedSize;
        if (n2 != -1) {
            return n2;
        }
        this.memoizedSerializedSize = n2 = 0;
        return n2;
    }

    public static Empty parseFrom(ByteString byteString) {
        return (Empty)PARSER.parseFrom(byteString);
    }

    public static Empty parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        return (Empty)PARSER.parseFrom(byteString, extensionRegistryLite);
    }

    public static Empty parseFrom(byte[] arrby) {
        return (Empty)PARSER.parseFrom(arrby);
    }

    public static Empty parseFrom(byte[] arrby, ExtensionRegistryLite extensionRegistryLite) {
        return (Empty)PARSER.parseFrom(arrby, extensionRegistryLite);
    }

    public static Empty parseFrom(InputStream inputStream) {
        return (Empty)PARSER.parseFrom(inputStream);
    }

    public static Empty parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (Empty)PARSER.parseFrom(inputStream, extensionRegistryLite);
    }

    public static Empty parseDelimitedFrom(InputStream inputStream) {
        return (Empty)PARSER.parseDelimitedFrom(inputStream);
    }

    public static Empty parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (Empty)PARSER.parseDelimitedFrom(inputStream, extensionRegistryLite);
    }

    public static Empty parseFrom(CodedInputStream codedInputStream) {
        return (Empty)PARSER.parseFrom(codedInputStream);
    }

    public static Empty parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (Empty)PARSER.parseFrom(codedInputStream, extensionRegistryLite);
    }

    @Override
    public Empty$Builder newBuilderForType() {
        return Empty.newBuilder();
    }

    public static Empty$Builder newBuilder() {
        return DEFAULT_INSTANCE.toBuilder();
    }

    public static Empty$Builder newBuilder(Empty empty) {
        return DEFAULT_INSTANCE.toBuilder().mergeFrom(empty);
    }

    @Override
    public Empty$Builder toBuilder() {
        Empty$Builder empty$Builder;
        if (this == DEFAULT_INSTANCE) {
            empty$Builder = new Empty$Builder(null);
            return empty$Builder;
        }
        empty$Builder = new Empty$Builder(null).mergeFrom(this);
        return empty$Builder;
    }

    @Override
    protected Empty$Builder newBuilderForType(GeneratedMessage$BuilderParent generatedMessage$BuilderParent) {
        return new Empty$Builder(generatedMessage$BuilderParent, null);
    }

    public static Empty getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    @Override
    public Parser getParserForType() {
        return PARSER;
    }

    @Override
    public Empty getDefaultInstanceForType() {
        return DEFAULT_INSTANCE;
    }

    /* synthetic */ Empty(GeneratedMessage$Builder generatedMessage$Builder, Empty$1 empty$1) {
        this(generatedMessage$Builder);
    }

    /* synthetic */ Empty(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite, Empty$1 empty$1) {
        this(codedInputStream, extensionRegistryLite);
    }
}

