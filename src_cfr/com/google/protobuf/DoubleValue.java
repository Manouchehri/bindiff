/*
 * Decompiled with CFR 0_115.
 */
package com.google.protobuf;

import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.Descriptors$Descriptor;
import com.google.protobuf.DoubleValue$1;
import com.google.protobuf.DoubleValue$Builder;
import com.google.protobuf.DoubleValueOrBuilder;
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

public final class DoubleValue
extends GeneratedMessage
implements DoubleValueOrBuilder {
    public static final int VALUE_FIELD_NUMBER = 1;
    private double value_;
    private byte memoizedIsInitialized = -1;
    private int memoizedSerializedSize = -1;
    private static final long serialVersionUID = 0;
    private static final DoubleValue DEFAULT_INSTANCE = new DoubleValue();
    public static final Parser PARSER = new DoubleValue$1();

    private DoubleValue(GeneratedMessage$Builder generatedMessage$Builder) {
        super(generatedMessage$Builder);
    }

    private DoubleValue() {
        this.value_ = 0.0;
    }

    @Override
    public final UnknownFieldSet getUnknownFields() {
        return UnknownFieldSet.getDefaultInstance();
    }

    private DoubleValue(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
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
                        case 9: 
                    }
                    this.value_ = codedInputStream.readDouble();
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
        return WrappersProto.internal_static_google_protobuf_DoubleValue_descriptor;
    }

    @Override
    protected GeneratedMessage$FieldAccessorTable internalGetFieldAccessorTable() {
        return WrappersProto.internal_static_google_protobuf_DoubleValue_fieldAccessorTable.ensureFieldAccessorsInitialized(DoubleValue.class, DoubleValue$Builder.class);
    }

    @Override
    public double getValue() {
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
        if (this.value_ == 0.0) return;
        codedOutputStream.writeDouble(1, this.value_);
    }

    @Override
    public int getSerializedSize() {
        int n2 = this.memoizedSerializedSize;
        if (n2 != -1) {
            return n2;
        }
        n2 = 0;
        if (this.value_ != 0.0) {
            n2 += CodedOutputStream.computeDoubleSize(1, this.value_);
        }
        this.memoizedSerializedSize = n2;
        return n2;
    }

    public static DoubleValue parseFrom(ByteString byteString) {
        return (DoubleValue)PARSER.parseFrom(byteString);
    }

    public static DoubleValue parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        return (DoubleValue)PARSER.parseFrom(byteString, extensionRegistryLite);
    }

    public static DoubleValue parseFrom(byte[] arrby) {
        return (DoubleValue)PARSER.parseFrom(arrby);
    }

    public static DoubleValue parseFrom(byte[] arrby, ExtensionRegistryLite extensionRegistryLite) {
        return (DoubleValue)PARSER.parseFrom(arrby, extensionRegistryLite);
    }

    public static DoubleValue parseFrom(InputStream inputStream) {
        return (DoubleValue)PARSER.parseFrom(inputStream);
    }

    public static DoubleValue parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (DoubleValue)PARSER.parseFrom(inputStream, extensionRegistryLite);
    }

    public static DoubleValue parseDelimitedFrom(InputStream inputStream) {
        return (DoubleValue)PARSER.parseDelimitedFrom(inputStream);
    }

    public static DoubleValue parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (DoubleValue)PARSER.parseDelimitedFrom(inputStream, extensionRegistryLite);
    }

    public static DoubleValue parseFrom(CodedInputStream codedInputStream) {
        return (DoubleValue)PARSER.parseFrom(codedInputStream);
    }

    public static DoubleValue parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (DoubleValue)PARSER.parseFrom(codedInputStream, extensionRegistryLite);
    }

    @Override
    public DoubleValue$Builder newBuilderForType() {
        return DoubleValue.newBuilder();
    }

    public static DoubleValue$Builder newBuilder() {
        return DEFAULT_INSTANCE.toBuilder();
    }

    public static DoubleValue$Builder newBuilder(DoubleValue doubleValue) {
        return DEFAULT_INSTANCE.toBuilder().mergeFrom(doubleValue);
    }

    @Override
    public DoubleValue$Builder toBuilder() {
        DoubleValue$Builder doubleValue$Builder;
        if (this == DEFAULT_INSTANCE) {
            doubleValue$Builder = new DoubleValue$Builder(null);
            return doubleValue$Builder;
        }
        doubleValue$Builder = new DoubleValue$Builder(null).mergeFrom(this);
        return doubleValue$Builder;
    }

    @Override
    protected DoubleValue$Builder newBuilderForType(GeneratedMessage$BuilderParent generatedMessage$BuilderParent) {
        return new DoubleValue$Builder(generatedMessage$BuilderParent, null);
    }

    public static DoubleValue getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    @Override
    public Parser getParserForType() {
        return PARSER;
    }

    @Override
    public DoubleValue getDefaultInstanceForType() {
        return DEFAULT_INSTANCE;
    }

    /* synthetic */ DoubleValue(GeneratedMessage$Builder generatedMessage$Builder, DoubleValue$1 doubleValue$1) {
        this(generatedMessage$Builder);
    }

    static /* synthetic */ double access$302(DoubleValue doubleValue, double d2) {
        doubleValue.value_ = d2;
        return doubleValue.value_;
    }

    /* synthetic */ DoubleValue(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite, DoubleValue$1 doubleValue$1) {
        this(codedInputStream, extensionRegistryLite);
    }
}

