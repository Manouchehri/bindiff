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
import com.google.protobuf.UInt64Value$1;
import com.google.protobuf.UInt64Value$Builder;
import com.google.protobuf.UInt64ValueOrBuilder;
import com.google.protobuf.UnknownFieldSet;
import com.google.protobuf.WrappersProto;
import java.io.IOException;
import java.io.InputStream;

public final class UInt64Value
extends GeneratedMessage
implements UInt64ValueOrBuilder {
    public static final int VALUE_FIELD_NUMBER = 1;
    private long value_;
    private byte memoizedIsInitialized = -1;
    private int memoizedSerializedSize = -1;
    private static final long serialVersionUID = 0;
    private static final UInt64Value DEFAULT_INSTANCE = new UInt64Value();
    public static final Parser PARSER = new UInt64Value$1();

    private UInt64Value(GeneratedMessage$Builder generatedMessage$Builder) {
        super(generatedMessage$Builder);
    }

    private UInt64Value() {
        this.value_ = 0;
    }

    @Override
    public final UnknownFieldSet getUnknownFields() {
        return UnknownFieldSet.getDefaultInstance();
    }

    private UInt64Value(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
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
                    this.value_ = codedInputStream.readUInt64();
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
        return WrappersProto.internal_static_google_protobuf_UInt64Value_descriptor;
    }

    @Override
    protected GeneratedMessage$FieldAccessorTable internalGetFieldAccessorTable() {
        return WrappersProto.internal_static_google_protobuf_UInt64Value_fieldAccessorTable.ensureFieldAccessorsInitialized(UInt64Value.class, UInt64Value$Builder.class);
    }

    @Override
    public long getValue() {
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
        codedOutputStream.writeUInt64(1, this.value_);
    }

    @Override
    public int getSerializedSize() {
        int n2 = this.memoizedSerializedSize;
        if (n2 != -1) {
            return n2;
        }
        n2 = 0;
        if (this.value_ != 0) {
            n2 += CodedOutputStream.computeUInt64Size(1, this.value_);
        }
        this.memoizedSerializedSize = n2;
        return n2;
    }

    public static UInt64Value parseFrom(ByteString byteString) {
        return (UInt64Value)PARSER.parseFrom(byteString);
    }

    public static UInt64Value parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        return (UInt64Value)PARSER.parseFrom(byteString, extensionRegistryLite);
    }

    public static UInt64Value parseFrom(byte[] arrby) {
        return (UInt64Value)PARSER.parseFrom(arrby);
    }

    public static UInt64Value parseFrom(byte[] arrby, ExtensionRegistryLite extensionRegistryLite) {
        return (UInt64Value)PARSER.parseFrom(arrby, extensionRegistryLite);
    }

    public static UInt64Value parseFrom(InputStream inputStream) {
        return (UInt64Value)PARSER.parseFrom(inputStream);
    }

    public static UInt64Value parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (UInt64Value)PARSER.parseFrom(inputStream, extensionRegistryLite);
    }

    public static UInt64Value parseDelimitedFrom(InputStream inputStream) {
        return (UInt64Value)PARSER.parseDelimitedFrom(inputStream);
    }

    public static UInt64Value parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (UInt64Value)PARSER.parseDelimitedFrom(inputStream, extensionRegistryLite);
    }

    public static UInt64Value parseFrom(CodedInputStream codedInputStream) {
        return (UInt64Value)PARSER.parseFrom(codedInputStream);
    }

    public static UInt64Value parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (UInt64Value)PARSER.parseFrom(codedInputStream, extensionRegistryLite);
    }

    @Override
    public UInt64Value$Builder newBuilderForType() {
        return UInt64Value.newBuilder();
    }

    public static UInt64Value$Builder newBuilder() {
        return DEFAULT_INSTANCE.toBuilder();
    }

    public static UInt64Value$Builder newBuilder(UInt64Value uInt64Value) {
        return DEFAULT_INSTANCE.toBuilder().mergeFrom(uInt64Value);
    }

    @Override
    public UInt64Value$Builder toBuilder() {
        UInt64Value$Builder uInt64Value$Builder;
        if (this == DEFAULT_INSTANCE) {
            uInt64Value$Builder = new UInt64Value$Builder(null);
            return uInt64Value$Builder;
        }
        uInt64Value$Builder = new UInt64Value$Builder(null).mergeFrom(this);
        return uInt64Value$Builder;
    }

    @Override
    protected UInt64Value$Builder newBuilderForType(GeneratedMessage$BuilderParent generatedMessage$BuilderParent) {
        return new UInt64Value$Builder(generatedMessage$BuilderParent, null);
    }

    public static UInt64Value getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    @Override
    public Parser getParserForType() {
        return PARSER;
    }

    @Override
    public UInt64Value getDefaultInstanceForType() {
        return DEFAULT_INSTANCE;
    }

    /* synthetic */ UInt64Value(GeneratedMessage$Builder generatedMessage$Builder, UInt64Value$1 uInt64Value$1) {
        this(generatedMessage$Builder);
    }

    static /* synthetic */ long access$302(UInt64Value uInt64Value, long l2) {
        uInt64Value.value_ = l2;
        return uInt64Value.value_;
    }

    /* synthetic */ UInt64Value(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite, UInt64Value$1 uInt64Value$1) {
        this(codedInputStream, extensionRegistryLite);
    }
}

