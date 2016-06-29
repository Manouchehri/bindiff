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
import com.google.protobuf.Int32Value$1;
import com.google.protobuf.Int32Value$Builder;
import com.google.protobuf.Int32ValueOrBuilder;
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

public final class Int32Value
extends GeneratedMessage
implements Int32ValueOrBuilder {
    public static final int VALUE_FIELD_NUMBER = 1;
    private int value_;
    private byte memoizedIsInitialized = -1;
    private int memoizedSerializedSize = -1;
    private static final long serialVersionUID = 0;
    private static final Int32Value DEFAULT_INSTANCE = new Int32Value();
    public static final Parser PARSER = new Int32Value$1();

    private Int32Value(GeneratedMessage$Builder generatedMessage$Builder) {
        super(generatedMessage$Builder);
    }

    private Int32Value() {
        this.value_ = 0;
    }

    @Override
    public final UnknownFieldSet getUnknownFields() {
        return UnknownFieldSet.getDefaultInstance();
    }

    private Int32Value(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
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
                    this.value_ = codedInputStream.readInt32();
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
        return WrappersProto.internal_static_google_protobuf_Int32Value_descriptor;
    }

    @Override
    protected GeneratedMessage$FieldAccessorTable internalGetFieldAccessorTable() {
        return WrappersProto.internal_static_google_protobuf_Int32Value_fieldAccessorTable.ensureFieldAccessorsInitialized(Int32Value.class, Int32Value$Builder.class);
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
        codedOutputStream.writeInt32(1, this.value_);
    }

    @Override
    public int getSerializedSize() {
        int n2 = this.memoizedSerializedSize;
        if (n2 != -1) {
            return n2;
        }
        n2 = 0;
        if (this.value_ != 0) {
            n2 += CodedOutputStream.computeInt32Size(1, this.value_);
        }
        this.memoizedSerializedSize = n2;
        return n2;
    }

    public static Int32Value parseFrom(ByteString byteString) {
        return (Int32Value)PARSER.parseFrom(byteString);
    }

    public static Int32Value parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        return (Int32Value)PARSER.parseFrom(byteString, extensionRegistryLite);
    }

    public static Int32Value parseFrom(byte[] arrby) {
        return (Int32Value)PARSER.parseFrom(arrby);
    }

    public static Int32Value parseFrom(byte[] arrby, ExtensionRegistryLite extensionRegistryLite) {
        return (Int32Value)PARSER.parseFrom(arrby, extensionRegistryLite);
    }

    public static Int32Value parseFrom(InputStream inputStream) {
        return (Int32Value)PARSER.parseFrom(inputStream);
    }

    public static Int32Value parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (Int32Value)PARSER.parseFrom(inputStream, extensionRegistryLite);
    }

    public static Int32Value parseDelimitedFrom(InputStream inputStream) {
        return (Int32Value)PARSER.parseDelimitedFrom(inputStream);
    }

    public static Int32Value parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (Int32Value)PARSER.parseDelimitedFrom(inputStream, extensionRegistryLite);
    }

    public static Int32Value parseFrom(CodedInputStream codedInputStream) {
        return (Int32Value)PARSER.parseFrom(codedInputStream);
    }

    public static Int32Value parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (Int32Value)PARSER.parseFrom(codedInputStream, extensionRegistryLite);
    }

    @Override
    public Int32Value$Builder newBuilderForType() {
        return Int32Value.newBuilder();
    }

    public static Int32Value$Builder newBuilder() {
        return DEFAULT_INSTANCE.toBuilder();
    }

    public static Int32Value$Builder newBuilder(Int32Value int32Value) {
        return DEFAULT_INSTANCE.toBuilder().mergeFrom(int32Value);
    }

    @Override
    public Int32Value$Builder toBuilder() {
        Int32Value$Builder int32Value$Builder;
        if (this == DEFAULT_INSTANCE) {
            int32Value$Builder = new Int32Value$Builder(null);
            return int32Value$Builder;
        }
        int32Value$Builder = new Int32Value$Builder(null).mergeFrom(this);
        return int32Value$Builder;
    }

    @Override
    protected Int32Value$Builder newBuilderForType(GeneratedMessage$BuilderParent generatedMessage$BuilderParent) {
        return new Int32Value$Builder(generatedMessage$BuilderParent, null);
    }

    public static Int32Value getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    @Override
    public Parser getParserForType() {
        return PARSER;
    }

    @Override
    public Int32Value getDefaultInstanceForType() {
        return DEFAULT_INSTANCE;
    }

    /* synthetic */ Int32Value(GeneratedMessage$Builder generatedMessage$Builder, Int32Value$1 int32Value$1) {
        this(generatedMessage$Builder);
    }

    static /* synthetic */ int access$302(Int32Value int32Value, int n2) {
        int32Value.value_ = n2;
        return int32Value.value_;
    }

    /* synthetic */ Int32Value(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite, Int32Value$1 int32Value$1) {
        this(codedInputStream, extensionRegistryLite);
    }
}

