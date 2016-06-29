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
import com.google.protobuf.Int64Value$1;
import com.google.protobuf.Int64Value$Builder;
import com.google.protobuf.Int64ValueOrBuilder;
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

public final class Int64Value
extends GeneratedMessage
implements Int64ValueOrBuilder {
    public static final int VALUE_FIELD_NUMBER = 1;
    private long value_;
    private byte memoizedIsInitialized = -1;
    private int memoizedSerializedSize = -1;
    private static final long serialVersionUID = 0;
    private static final Int64Value DEFAULT_INSTANCE = new Int64Value();
    public static final Parser PARSER = new Int64Value$1();

    private Int64Value(GeneratedMessage$Builder generatedMessage$Builder) {
        super(generatedMessage$Builder);
    }

    private Int64Value() {
        this.value_ = 0;
    }

    @Override
    public final UnknownFieldSet getUnknownFields() {
        return UnknownFieldSet.getDefaultInstance();
    }

    private Int64Value(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
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
                    this.value_ = codedInputStream.readInt64();
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
        return WrappersProto.internal_static_google_protobuf_Int64Value_descriptor;
    }

    @Override
    protected GeneratedMessage$FieldAccessorTable internalGetFieldAccessorTable() {
        return WrappersProto.internal_static_google_protobuf_Int64Value_fieldAccessorTable.ensureFieldAccessorsInitialized(Int64Value.class, Int64Value$Builder.class);
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
        codedOutputStream.writeInt64(1, this.value_);
    }

    @Override
    public int getSerializedSize() {
        int n2 = this.memoizedSerializedSize;
        if (n2 != -1) {
            return n2;
        }
        n2 = 0;
        if (this.value_ != 0) {
            n2 += CodedOutputStream.computeInt64Size(1, this.value_);
        }
        this.memoizedSerializedSize = n2;
        return n2;
    }

    public static Int64Value parseFrom(ByteString byteString) {
        return (Int64Value)PARSER.parseFrom(byteString);
    }

    public static Int64Value parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        return (Int64Value)PARSER.parseFrom(byteString, extensionRegistryLite);
    }

    public static Int64Value parseFrom(byte[] arrby) {
        return (Int64Value)PARSER.parseFrom(arrby);
    }

    public static Int64Value parseFrom(byte[] arrby, ExtensionRegistryLite extensionRegistryLite) {
        return (Int64Value)PARSER.parseFrom(arrby, extensionRegistryLite);
    }

    public static Int64Value parseFrom(InputStream inputStream) {
        return (Int64Value)PARSER.parseFrom(inputStream);
    }

    public static Int64Value parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (Int64Value)PARSER.parseFrom(inputStream, extensionRegistryLite);
    }

    public static Int64Value parseDelimitedFrom(InputStream inputStream) {
        return (Int64Value)PARSER.parseDelimitedFrom(inputStream);
    }

    public static Int64Value parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (Int64Value)PARSER.parseDelimitedFrom(inputStream, extensionRegistryLite);
    }

    public static Int64Value parseFrom(CodedInputStream codedInputStream) {
        return (Int64Value)PARSER.parseFrom(codedInputStream);
    }

    public static Int64Value parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (Int64Value)PARSER.parseFrom(codedInputStream, extensionRegistryLite);
    }

    @Override
    public Int64Value$Builder newBuilderForType() {
        return Int64Value.newBuilder();
    }

    public static Int64Value$Builder newBuilder() {
        return DEFAULT_INSTANCE.toBuilder();
    }

    public static Int64Value$Builder newBuilder(Int64Value int64Value) {
        return DEFAULT_INSTANCE.toBuilder().mergeFrom(int64Value);
    }

    @Override
    public Int64Value$Builder toBuilder() {
        Int64Value$Builder int64Value$Builder;
        if (this == DEFAULT_INSTANCE) {
            int64Value$Builder = new Int64Value$Builder(null);
            return int64Value$Builder;
        }
        int64Value$Builder = new Int64Value$Builder(null).mergeFrom(this);
        return int64Value$Builder;
    }

    @Override
    protected Int64Value$Builder newBuilderForType(GeneratedMessage$BuilderParent generatedMessage$BuilderParent) {
        return new Int64Value$Builder(generatedMessage$BuilderParent, null);
    }

    public static Int64Value getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    @Override
    public Parser getParserForType() {
        return PARSER;
    }

    @Override
    public Int64Value getDefaultInstanceForType() {
        return DEFAULT_INSTANCE;
    }

    /* synthetic */ Int64Value(GeneratedMessage$Builder generatedMessage$Builder, Int64Value$1 int64Value$1) {
        this(generatedMessage$Builder);
    }

    static /* synthetic */ long access$302(Int64Value int64Value, long l2) {
        int64Value.value_ = l2;
        return int64Value.value_;
    }

    /* synthetic */ Int64Value(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite, Int64Value$1 int64Value$1) {
        this(codedInputStream, extensionRegistryLite);
    }
}

