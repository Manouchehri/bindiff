/*
 * Decompiled with CFR 0_115.
 */
package com.google.protobuf;

import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.Descriptors$Descriptor;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.FloatValue$1;
import com.google.protobuf.FloatValue$Builder;
import com.google.protobuf.FloatValueOrBuilder;
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

public final class FloatValue
extends GeneratedMessage
implements FloatValueOrBuilder {
    public static final int VALUE_FIELD_NUMBER = 1;
    private float value_;
    private byte memoizedIsInitialized = -1;
    private int memoizedSerializedSize = -1;
    private static final long serialVersionUID = 0;
    private static final FloatValue DEFAULT_INSTANCE = new FloatValue();
    public static final Parser PARSER = new FloatValue$1();

    private FloatValue(GeneratedMessage$Builder generatedMessage$Builder) {
        super(generatedMessage$Builder);
    }

    private FloatValue() {
        this.value_ = 0.0f;
    }

    @Override
    public final UnknownFieldSet getUnknownFields() {
        return UnknownFieldSet.getDefaultInstance();
    }

    private FloatValue(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
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
                        case 13: 
                    }
                    this.value_ = codedInputStream.readFloat();
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
        return WrappersProto.internal_static_google_protobuf_FloatValue_descriptor;
    }

    @Override
    protected GeneratedMessage$FieldAccessorTable internalGetFieldAccessorTable() {
        return WrappersProto.internal_static_google_protobuf_FloatValue_fieldAccessorTable.ensureFieldAccessorsInitialized(FloatValue.class, FloatValue$Builder.class);
    }

    @Override
    public float getValue() {
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
        if (this.value_ == 0.0f) return;
        codedOutputStream.writeFloat(1, this.value_);
    }

    @Override
    public int getSerializedSize() {
        int n2 = this.memoizedSerializedSize;
        if (n2 != -1) {
            return n2;
        }
        n2 = 0;
        if (this.value_ != 0.0f) {
            n2 += CodedOutputStream.computeFloatSize(1, this.value_);
        }
        this.memoizedSerializedSize = n2;
        return n2;
    }

    public static FloatValue parseFrom(ByteString byteString) {
        return (FloatValue)PARSER.parseFrom(byteString);
    }

    public static FloatValue parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        return (FloatValue)PARSER.parseFrom(byteString, extensionRegistryLite);
    }

    public static FloatValue parseFrom(byte[] arrby) {
        return (FloatValue)PARSER.parseFrom(arrby);
    }

    public static FloatValue parseFrom(byte[] arrby, ExtensionRegistryLite extensionRegistryLite) {
        return (FloatValue)PARSER.parseFrom(arrby, extensionRegistryLite);
    }

    public static FloatValue parseFrom(InputStream inputStream) {
        return (FloatValue)PARSER.parseFrom(inputStream);
    }

    public static FloatValue parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (FloatValue)PARSER.parseFrom(inputStream, extensionRegistryLite);
    }

    public static FloatValue parseDelimitedFrom(InputStream inputStream) {
        return (FloatValue)PARSER.parseDelimitedFrom(inputStream);
    }

    public static FloatValue parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (FloatValue)PARSER.parseDelimitedFrom(inputStream, extensionRegistryLite);
    }

    public static FloatValue parseFrom(CodedInputStream codedInputStream) {
        return (FloatValue)PARSER.parseFrom(codedInputStream);
    }

    public static FloatValue parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (FloatValue)PARSER.parseFrom(codedInputStream, extensionRegistryLite);
    }

    @Override
    public FloatValue$Builder newBuilderForType() {
        return FloatValue.newBuilder();
    }

    public static FloatValue$Builder newBuilder() {
        return DEFAULT_INSTANCE.toBuilder();
    }

    public static FloatValue$Builder newBuilder(FloatValue floatValue) {
        return DEFAULT_INSTANCE.toBuilder().mergeFrom(floatValue);
    }

    @Override
    public FloatValue$Builder toBuilder() {
        FloatValue$Builder floatValue$Builder;
        if (this == DEFAULT_INSTANCE) {
            floatValue$Builder = new FloatValue$Builder(null);
            return floatValue$Builder;
        }
        floatValue$Builder = new FloatValue$Builder(null).mergeFrom(this);
        return floatValue$Builder;
    }

    @Override
    protected FloatValue$Builder newBuilderForType(GeneratedMessage$BuilderParent generatedMessage$BuilderParent) {
        return new FloatValue$Builder(generatedMessage$BuilderParent, null);
    }

    public static FloatValue getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    @Override
    public Parser getParserForType() {
        return PARSER;
    }

    @Override
    public FloatValue getDefaultInstanceForType() {
        return DEFAULT_INSTANCE;
    }

    /* synthetic */ FloatValue(GeneratedMessage$Builder generatedMessage$Builder, FloatValue$1 floatValue$1) {
        this(generatedMessage$Builder);
    }

    static /* synthetic */ float access$302(FloatValue floatValue, float f2) {
        floatValue.value_ = f2;
        return floatValue.value_;
    }

    /* synthetic */ FloatValue(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite, FloatValue$1 floatValue$1) {
        this(codedInputStream, extensionRegistryLite);
    }
}

