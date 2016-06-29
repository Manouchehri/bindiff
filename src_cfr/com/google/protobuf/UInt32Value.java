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
import com.google.protobuf.Message;
import com.google.protobuf.Message$Builder;
import com.google.protobuf.MessageLite;
import com.google.protobuf.MessageLite$Builder;
import com.google.protobuf.Parser;
import com.google.protobuf.UInt32Value$1;
import com.google.protobuf.UInt32Value$Builder;
import com.google.protobuf.UInt32ValueOrBuilder;
import com.google.protobuf.UnknownFieldSet;
import com.google.protobuf.WrappersProto;
import java.io.IOException;
import java.io.InputStream;

public final class UInt32Value
extends GeneratedMessage
implements UInt32ValueOrBuilder {
    public static final int VALUE_FIELD_NUMBER = 1;
    private int value_;
    private byte memoizedIsInitialized = -1;
    private int memoizedSerializedSize = -1;
    private static final long serialVersionUID = 0;
    private static final UInt32Value DEFAULT_INSTANCE = new UInt32Value();
    public static final Parser PARSER = new UInt32Value$1();

    private UInt32Value(GeneratedMessage$Builder generatedMessage$Builder) {
        super(generatedMessage$Builder);
    }

    private UInt32Value() {
        this.value_ = 0;
    }

    @Override
    public final UnknownFieldSet getUnknownFields() {
        return UnknownFieldSet.getDefaultInstance();
    }

    private UInt32Value(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
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
                        case 8: 
                    }
                    this.value_ = codedInputStream.readUInt32();
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
        return WrappersProto.internal_static_google_protobuf_UInt32Value_descriptor;
    }

    @Override
    protected GeneratedMessage$FieldAccessorTable internalGetFieldAccessorTable() {
        return WrappersProto.internal_static_google_protobuf_UInt32Value_fieldAccessorTable.ensureFieldAccessorsInitialized(UInt32Value.class, UInt32Value$Builder.class);
    }

    @Override
    public int getValue() {
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
        if (this.value_ == 0) return;
        codedOutputStream.writeUInt32(1, this.value_);
    }

    @Override
    public int getSerializedSize() {
        int n2 = this.memoizedSerializedSize;
        if (n2 != -1) {
            return n2;
        }
        n2 = 0;
        if (this.value_ != 0) {
            n2 += CodedOutputStream.computeUInt32Size(1, this.value_);
        }
        this.memoizedSerializedSize = n2;
        return n2;
    }

    public static UInt32Value parseFrom(ByteString byteString) {
        return (UInt32Value)PARSER.parseFrom(byteString);
    }

    public static UInt32Value parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        return (UInt32Value)PARSER.parseFrom(byteString, extensionRegistryLite);
    }

    public static UInt32Value parseFrom(byte[] arrby) {
        return (UInt32Value)PARSER.parseFrom(arrby);
    }

    public static UInt32Value parseFrom(byte[] arrby, ExtensionRegistryLite extensionRegistryLite) {
        return (UInt32Value)PARSER.parseFrom(arrby, extensionRegistryLite);
    }

    public static UInt32Value parseFrom(InputStream inputStream) {
        return (UInt32Value)PARSER.parseFrom(inputStream);
    }

    public static UInt32Value parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (UInt32Value)PARSER.parseFrom(inputStream, extensionRegistryLite);
    }

    public static UInt32Value parseDelimitedFrom(InputStream inputStream) {
        return (UInt32Value)PARSER.parseDelimitedFrom(inputStream);
    }

    public static UInt32Value parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (UInt32Value)PARSER.parseDelimitedFrom(inputStream, extensionRegistryLite);
    }

    public static UInt32Value parseFrom(CodedInputStream codedInputStream) {
        return (UInt32Value)PARSER.parseFrom(codedInputStream);
    }

    public static UInt32Value parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (UInt32Value)PARSER.parseFrom(codedInputStream, extensionRegistryLite);
    }

    @Override
    public UInt32Value$Builder newBuilderForType() {
        return UInt32Value.newBuilder();
    }

    public static UInt32Value$Builder newBuilder() {
        return DEFAULT_INSTANCE.toBuilder();
    }

    public static UInt32Value$Builder newBuilder(UInt32Value uInt32Value) {
        return DEFAULT_INSTANCE.toBuilder().mergeFrom(uInt32Value);
    }

    @Override
    public UInt32Value$Builder toBuilder() {
        UInt32Value$Builder uInt32Value$Builder;
        if (this == DEFAULT_INSTANCE) {
            uInt32Value$Builder = new UInt32Value$Builder(null);
            return uInt32Value$Builder;
        }
        uInt32Value$Builder = new UInt32Value$Builder(null).mergeFrom(this);
        return uInt32Value$Builder;
    }

    @Override
    protected UInt32Value$Builder newBuilderForType(GeneratedMessage$BuilderParent generatedMessage$BuilderParent) {
        return new UInt32Value$Builder(generatedMessage$BuilderParent, null);
    }

    public static UInt32Value getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    @Override
    public Parser getParserForType() {
        return PARSER;
    }

    @Override
    public UInt32Value getDefaultInstanceForType() {
        return DEFAULT_INSTANCE;
    }

    /* synthetic */ UInt32Value(GeneratedMessage$Builder generatedMessage$Builder, UInt32Value$1 uInt32Value$1) {
        this(generatedMessage$Builder);
    }

    static /* synthetic */ int access$302(UInt32Value uInt32Value, int n2) {
        uInt32Value.value_ = n2;
        return uInt32Value.value_;
    }

    /* synthetic */ UInt32Value(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite, UInt32Value$1 uInt32Value$1) {
        this(codedInputStream, extensionRegistryLite);
    }
}

