/*
 * Decompiled with CFR 0_115.
 */
package com.google.protobuf;

import com.google.protobuf.BoolValue$1;
import com.google.protobuf.BoolValue$Builder;
import com.google.protobuf.BoolValueOrBuilder;
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
import com.google.protobuf.UnknownFieldSet;
import com.google.protobuf.WrappersProto;
import java.io.IOException;
import java.io.InputStream;

public final class BoolValue
extends GeneratedMessage
implements BoolValueOrBuilder {
    public static final int VALUE_FIELD_NUMBER = 1;
    private boolean value_;
    private byte memoizedIsInitialized = -1;
    private int memoizedSerializedSize = -1;
    private static final long serialVersionUID = 0;
    private static final BoolValue DEFAULT_INSTANCE = new BoolValue();
    public static final Parser PARSER = new BoolValue$1();

    private BoolValue(GeneratedMessage$Builder generatedMessage$Builder) {
        super(generatedMessage$Builder);
    }

    private BoolValue() {
        this.value_ = false;
    }

    @Override
    public final UnknownFieldSet getUnknownFields() {
        return UnknownFieldSet.getDefaultInstance();
    }

    private BoolValue(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
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
                    this.value_ = codedInputStream.readBool();
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
        return WrappersProto.internal_static_google_protobuf_BoolValue_descriptor;
    }

    @Override
    protected GeneratedMessage$FieldAccessorTable internalGetFieldAccessorTable() {
        return WrappersProto.internal_static_google_protobuf_BoolValue_fieldAccessorTable.ensureFieldAccessorsInitialized(BoolValue.class, BoolValue$Builder.class);
    }

    @Override
    public boolean getValue() {
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
        if (!this.value_) return;
        codedOutputStream.writeBool(1, this.value_);
    }

    @Override
    public int getSerializedSize() {
        int n2 = this.memoizedSerializedSize;
        if (n2 != -1) {
            return n2;
        }
        n2 = 0;
        if (this.value_) {
            n2 += CodedOutputStream.computeBoolSize(1, this.value_);
        }
        this.memoizedSerializedSize = n2;
        return n2;
    }

    public static BoolValue parseFrom(ByteString byteString) {
        return (BoolValue)PARSER.parseFrom(byteString);
    }

    public static BoolValue parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        return (BoolValue)PARSER.parseFrom(byteString, extensionRegistryLite);
    }

    public static BoolValue parseFrom(byte[] arrby) {
        return (BoolValue)PARSER.parseFrom(arrby);
    }

    public static BoolValue parseFrom(byte[] arrby, ExtensionRegistryLite extensionRegistryLite) {
        return (BoolValue)PARSER.parseFrom(arrby, extensionRegistryLite);
    }

    public static BoolValue parseFrom(InputStream inputStream) {
        return (BoolValue)PARSER.parseFrom(inputStream);
    }

    public static BoolValue parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (BoolValue)PARSER.parseFrom(inputStream, extensionRegistryLite);
    }

    public static BoolValue parseDelimitedFrom(InputStream inputStream) {
        return (BoolValue)PARSER.parseDelimitedFrom(inputStream);
    }

    public static BoolValue parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (BoolValue)PARSER.parseDelimitedFrom(inputStream, extensionRegistryLite);
    }

    public static BoolValue parseFrom(CodedInputStream codedInputStream) {
        return (BoolValue)PARSER.parseFrom(codedInputStream);
    }

    public static BoolValue parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (BoolValue)PARSER.parseFrom(codedInputStream, extensionRegistryLite);
    }

    @Override
    public BoolValue$Builder newBuilderForType() {
        return BoolValue.newBuilder();
    }

    public static BoolValue$Builder newBuilder() {
        return DEFAULT_INSTANCE.toBuilder();
    }

    public static BoolValue$Builder newBuilder(BoolValue boolValue) {
        return DEFAULT_INSTANCE.toBuilder().mergeFrom(boolValue);
    }

    @Override
    public BoolValue$Builder toBuilder() {
        BoolValue$Builder boolValue$Builder;
        if (this == DEFAULT_INSTANCE) {
            boolValue$Builder = new BoolValue$Builder(null);
            return boolValue$Builder;
        }
        boolValue$Builder = new BoolValue$Builder(null).mergeFrom(this);
        return boolValue$Builder;
    }

    @Override
    protected BoolValue$Builder newBuilderForType(GeneratedMessage$BuilderParent generatedMessage$BuilderParent) {
        return new BoolValue$Builder(generatedMessage$BuilderParent, null);
    }

    public static BoolValue getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    @Override
    public Parser getParserForType() {
        return PARSER;
    }

    @Override
    public BoolValue getDefaultInstanceForType() {
        return DEFAULT_INSTANCE;
    }

    /* synthetic */ BoolValue(GeneratedMessage$Builder generatedMessage$Builder, BoolValue$1 boolValue$1) {
        this(generatedMessage$Builder);
    }

    static /* synthetic */ boolean access$302(BoolValue boolValue, boolean bl2) {
        boolValue.value_ = bl2;
        return boolValue.value_;
    }

    /* synthetic */ BoolValue(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite, BoolValue$1 boolValue$1) {
        this(codedInputStream, extensionRegistryLite);
    }
}

