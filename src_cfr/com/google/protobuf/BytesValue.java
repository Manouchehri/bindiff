/*
 * Decompiled with CFR 0_115.
 */
package com.google.protobuf;

import com.google.protobuf.ByteString;
import com.google.protobuf.BytesValue$1;
import com.google.protobuf.BytesValue$Builder;
import com.google.protobuf.BytesValueOrBuilder;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.Descriptors$Descriptor;
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
import com.google.protobuf.WrappersProto;
import java.io.IOException;
import java.io.InputStream;

public final class BytesValue
extends GeneratedMessage
implements BytesValueOrBuilder {
    public static final int VALUE_FIELD_NUMBER = 1;
    private ByteString value_;
    private byte memoizedIsInitialized = -1;
    private int memoizedSerializedSize = -1;
    private static final long serialVersionUID = 0;
    private static final BytesValue DEFAULT_INSTANCE = new BytesValue();
    public static final Parser PARSER = new BytesValue$1();

    private BytesValue(GeneratedMessage$Builder generatedMessage$Builder) {
        super(generatedMessage$Builder);
    }

    private BytesValue() {
        this.value_ = ByteString.EMPTY;
    }

    @Override
    public final UnknownFieldSet getUnknownFields() {
        return UnknownFieldSet.getDefaultInstance();
    }

    private BytesValue(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
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
                    this.value_ = codedInputStream.readBytes();
                }
                Object var7_8 = null;
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
        catch (Throwable var6_10) {
            Object var7_9 = null;
            this.makeExtensionsImmutable();
            throw var6_10;
        }
    }

    public static final Descriptors$Descriptor getDescriptor() {
        return WrappersProto.internal_static_google_protobuf_BytesValue_descriptor;
    }

    @Override
    protected GeneratedMessage$FieldAccessorTable internalGetFieldAccessorTable() {
        return WrappersProto.internal_static_google_protobuf_BytesValue_fieldAccessorTable.ensureFieldAccessorsInitialized(BytesValue.class, BytesValue$Builder.class);
    }

    @Override
    public ByteString getValue() {
        return this.value_;
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
        if (this.value_.isEmpty()) return;
        codedOutputStream.writeBytes(1, this.value_);
    }

    @Override
    public int getSerializedSize() {
        int n2 = this.memoizedSerializedSize;
        if (n2 != -1) {
            return n2;
        }
        n2 = 0;
        if (!this.value_.isEmpty()) {
            n2 += CodedOutputStream.computeBytesSize(1, this.value_);
        }
        this.memoizedSerializedSize = n2;
        return n2;
    }

    public static BytesValue parseFrom(ByteString byteString) {
        return (BytesValue)PARSER.parseFrom(byteString);
    }

    public static BytesValue parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        return (BytesValue)PARSER.parseFrom(byteString, extensionRegistryLite);
    }

    public static BytesValue parseFrom(byte[] arrby) {
        return (BytesValue)PARSER.parseFrom(arrby);
    }

    public static BytesValue parseFrom(byte[] arrby, ExtensionRegistryLite extensionRegistryLite) {
        return (BytesValue)PARSER.parseFrom(arrby, extensionRegistryLite);
    }

    public static BytesValue parseFrom(InputStream inputStream) {
        return (BytesValue)PARSER.parseFrom(inputStream);
    }

    public static BytesValue parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (BytesValue)PARSER.parseFrom(inputStream, extensionRegistryLite);
    }

    public static BytesValue parseDelimitedFrom(InputStream inputStream) {
        return (BytesValue)PARSER.parseDelimitedFrom(inputStream);
    }

    public static BytesValue parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (BytesValue)PARSER.parseDelimitedFrom(inputStream, extensionRegistryLite);
    }

    public static BytesValue parseFrom(CodedInputStream codedInputStream) {
        return (BytesValue)PARSER.parseFrom(codedInputStream);
    }

    public static BytesValue parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (BytesValue)PARSER.parseFrom(codedInputStream, extensionRegistryLite);
    }

    @Override
    public BytesValue$Builder newBuilderForType() {
        return BytesValue.newBuilder();
    }

    public static BytesValue$Builder newBuilder() {
        return DEFAULT_INSTANCE.toBuilder();
    }

    public static BytesValue$Builder newBuilder(BytesValue bytesValue) {
        return DEFAULT_INSTANCE.toBuilder().mergeFrom(bytesValue);
    }

    @Override
    public BytesValue$Builder toBuilder() {
        BytesValue$Builder bytesValue$Builder;
        if (this == DEFAULT_INSTANCE) {
            bytesValue$Builder = new BytesValue$Builder(null);
            return bytesValue$Builder;
        }
        bytesValue$Builder = new BytesValue$Builder(null).mergeFrom(this);
        return bytesValue$Builder;
    }

    @Override
    protected BytesValue$Builder newBuilderForType(GeneratedMessage$BuilderParent generatedMessage$BuilderParent) {
        return new BytesValue$Builder(generatedMessage$BuilderParent, null);
    }

    public static BytesValue getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    @Override
    public Parser getParserForType() {
        return PARSER;
    }

    @Override
    public BytesValue getDefaultInstanceForType() {
        return DEFAULT_INSTANCE;
    }

    /* synthetic */ BytesValue(GeneratedMessage$Builder generatedMessage$Builder, BytesValue$1 bytesValue$1) {
        this(generatedMessage$Builder);
    }

    static /* synthetic */ ByteString access$302(BytesValue bytesValue, ByteString byteString) {
        bytesValue.value_ = byteString;
        return bytesValue.value_;
    }

    /* synthetic */ BytesValue(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite, BytesValue$1 bytesValue$1) {
        this(codedInputStream, extensionRegistryLite);
    }
}

