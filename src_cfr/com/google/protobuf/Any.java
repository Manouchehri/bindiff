/*
 * Decompiled with CFR 0_115.
 */
package com.google.protobuf;

import com.google.protobuf.Any$1;
import com.google.protobuf.Any$Builder;
import com.google.protobuf.AnyOrBuilder;
import com.google.protobuf.AnyProto;
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
import java.io.IOException;
import java.io.InputStream;

public final class Any
extends GeneratedMessage
implements AnyOrBuilder {
    public static final int TYPE_URL_FIELD_NUMBER = 1;
    private volatile Object typeUrl_;
    public static final int VALUE_FIELD_NUMBER = 2;
    private ByteString value_;
    private byte memoizedIsInitialized = -1;
    private int memoizedSerializedSize = -1;
    private static final long serialVersionUID = 0;
    private static final Any DEFAULT_INSTANCE = new Any();
    public static final Parser PARSER = new Any$1();

    private Any(GeneratedMessage$Builder generatedMessage$Builder) {
        super(generatedMessage$Builder);
    }

    private Any() {
        this.typeUrl_ = "";
        this.value_ = ByteString.EMPTY;
    }

    @Override
    public final UnknownFieldSet getUnknownFields() {
        return UnknownFieldSet.getDefaultInstance();
    }

    private Any(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        this();
        boolean bl2 = false;
        try {
            try {
                boolean bl3 = false;
                block10 : while (!bl3) {
                    int n2 = codedInputStream.readTag();
                    switch (n2) {
                        case 0: {
                            bl3 = true;
                            continue block10;
                        }
                        default: {
                            if (codedInputStream.skipField(n2)) continue block10;
                            bl3 = true;
                            continue block10;
                        }
                        case 10: {
                            ByteString byteString;
                            this.typeUrl_ = byteString = codedInputStream.readBytes();
                            continue block10;
                        }
                        case 18: 
                    }
                    this.value_ = codedInputStream.readBytes();
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
        return AnyProto.internal_static_google_protobuf_Any_descriptor;
    }

    @Override
    protected GeneratedMessage$FieldAccessorTable internalGetFieldAccessorTable() {
        return AnyProto.internal_static_google_protobuf_Any_fieldAccessorTable.ensureFieldAccessorsInitialized(Any.class, Any$Builder.class);
    }

    @Override
    public String getTypeUrl() {
        Object object = this.typeUrl_;
        if (object instanceof String) {
            return (String)object;
        }
        ByteString byteString = (ByteString)object;
        String string = byteString.toStringUtf8();
        if (!byteString.isValidUtf8()) return string;
        this.typeUrl_ = string;
        return string;
    }

    @Override
    public ByteString getTypeUrlBytes() {
        ByteString byteString;
        Object object = this.typeUrl_;
        if (!(object instanceof String)) return (ByteString)object;
        this.typeUrl_ = byteString = ByteString.copyFromUtf8((String)object);
        return byteString;
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
        if (!this.getTypeUrlBytes().isEmpty()) {
            codedOutputStream.writeBytes(1, this.getTypeUrlBytes());
        }
        if (this.value_.isEmpty()) return;
        codedOutputStream.writeBytes(2, this.value_);
    }

    @Override
    public int getSerializedSize() {
        int n2 = this.memoizedSerializedSize;
        if (n2 != -1) {
            return n2;
        }
        n2 = 0;
        if (!this.getTypeUrlBytes().isEmpty()) {
            n2 += CodedOutputStream.computeBytesSize(1, this.getTypeUrlBytes());
        }
        if (!this.value_.isEmpty()) {
            n2 += CodedOutputStream.computeBytesSize(2, this.value_);
        }
        this.memoizedSerializedSize = n2;
        return n2;
    }

    @Override
    public boolean equals(Object object) {
        if (object == this) {
            return true;
        }
        if (!(object instanceof Any)) {
            return super.equals(object);
        }
        Any any = (Any)object;
        boolean bl2 = true;
        if (!bl2) return false;
        if (!this.getTypeUrl().equals(any.getTypeUrl())) return false;
        boolean bl3 = true;
        bl2 = bl3;
        if (!bl2) return false;
        if (!this.getValue().equals(any.getValue())) return false;
        return true;
    }

    @Override
    public int hashCode() {
        if (this.memoizedHashCode != 0) {
            return this.memoizedHashCode;
        }
        int n2 = 41;
        n2 = 19 * n2 + this.getDescriptorForType().hashCode();
        n2 = 37 * n2 + 1;
        n2 = 53 * n2 + this.getTypeUrl().hashCode();
        n2 = 37 * n2 + 2;
        n2 = 53 * n2 + this.getValue().hashCode();
        this.memoizedHashCode = n2 = 29 * n2 + this.unknownFields.hashCode();
        return n2;
    }

    public static Any parseFrom(ByteString byteString) {
        return (Any)PARSER.parseFrom(byteString);
    }

    public static Any parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        return (Any)PARSER.parseFrom(byteString, extensionRegistryLite);
    }

    public static Any parseFrom(byte[] arrby) {
        return (Any)PARSER.parseFrom(arrby);
    }

    public static Any parseFrom(byte[] arrby, ExtensionRegistryLite extensionRegistryLite) {
        return (Any)PARSER.parseFrom(arrby, extensionRegistryLite);
    }

    public static Any parseFrom(InputStream inputStream) {
        return (Any)PARSER.parseFrom(inputStream);
    }

    public static Any parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (Any)PARSER.parseFrom(inputStream, extensionRegistryLite);
    }

    public static Any parseDelimitedFrom(InputStream inputStream) {
        return (Any)PARSER.parseDelimitedFrom(inputStream);
    }

    public static Any parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (Any)PARSER.parseDelimitedFrom(inputStream, extensionRegistryLite);
    }

    public static Any parseFrom(CodedInputStream codedInputStream) {
        return (Any)PARSER.parseFrom(codedInputStream);
    }

    public static Any parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (Any)PARSER.parseFrom(codedInputStream, extensionRegistryLite);
    }

    @Override
    public Any$Builder newBuilderForType() {
        return Any.newBuilder();
    }

    public static Any$Builder newBuilder() {
        return DEFAULT_INSTANCE.toBuilder();
    }

    public static Any$Builder newBuilder(Any any) {
        return DEFAULT_INSTANCE.toBuilder().mergeFrom(any);
    }

    @Override
    public Any$Builder toBuilder() {
        Any$Builder any$Builder;
        if (this == DEFAULT_INSTANCE) {
            any$Builder = new Any$Builder(null);
            return any$Builder;
        }
        any$Builder = new Any$Builder(null).mergeFrom(this);
        return any$Builder;
    }

    @Override
    protected Any$Builder newBuilderForType(GeneratedMessage$BuilderParent generatedMessage$BuilderParent) {
        return new Any$Builder(generatedMessage$BuilderParent, null);
    }

    public static Any getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    @Override
    public Parser getParserForType() {
        return PARSER;
    }

    @Override
    public Any getDefaultInstanceForType() {
        return DEFAULT_INSTANCE;
    }

    /* synthetic */ Any(GeneratedMessage$Builder generatedMessage$Builder, Any$1 any$1) {
        this(generatedMessage$Builder);
    }

    static /* synthetic */ Object access$302(Any any, Object object) {
        any.typeUrl_ = object;
        return any.typeUrl_;
    }

    static /* synthetic */ ByteString access$402(Any any, ByteString byteString) {
        any.value_ = byteString;
        return any.value_;
    }

    static /* synthetic */ Object access$300(Any any) {
        return any.typeUrl_;
    }

    /* synthetic */ Any(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite, Any$1 any$1) {
        this(codedInputStream, extensionRegistryLite);
    }
}

