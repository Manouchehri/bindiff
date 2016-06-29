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
import com.google.protobuf.StringValue$1;
import com.google.protobuf.StringValue$Builder;
import com.google.protobuf.StringValueOrBuilder;
import com.google.protobuf.UnknownFieldSet;
import com.google.protobuf.WrappersProto;
import java.io.IOException;
import java.io.InputStream;

public final class StringValue
extends GeneratedMessage
implements StringValueOrBuilder {
    public static final int VALUE_FIELD_NUMBER = 1;
    private volatile Object value_;
    private byte memoizedIsInitialized = -1;
    private int memoizedSerializedSize = -1;
    private static final long serialVersionUID = 0;
    private static final StringValue DEFAULT_INSTANCE = new StringValue();
    public static final Parser PARSER = new StringValue$1();

    private StringValue(GeneratedMessage$Builder generatedMessage$Builder) {
        super(generatedMessage$Builder);
    }

    private StringValue() {
        this.value_ = "";
    }

    @Override
    public final UnknownFieldSet getUnknownFields() {
        return UnknownFieldSet.getDefaultInstance();
    }

    private StringValue(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        this();
        boolean bl2 = false;
        try {
            try {
                boolean bl3 = false;
                block9 : while (!bl3) {
                    ByteString byteString;
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
                    this.value_ = byteString = codedInputStream.readBytes();
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
        return WrappersProto.internal_static_google_protobuf_StringValue_descriptor;
    }

    @Override
    protected GeneratedMessage$FieldAccessorTable internalGetFieldAccessorTable() {
        return WrappersProto.internal_static_google_protobuf_StringValue_fieldAccessorTable.ensureFieldAccessorsInitialized(StringValue.class, StringValue$Builder.class);
    }

    @Override
    public String getValue() {
        Object object = this.value_;
        if (object instanceof String) {
            return (String)object;
        }
        ByteString byteString = (ByteString)object;
        String string = byteString.toStringUtf8();
        if (!byteString.isValidUtf8()) return string;
        this.value_ = string;
        return string;
    }

    @Override
    public ByteString getValueBytes() {
        ByteString byteString;
        Object object = this.value_;
        if (!(object instanceof String)) return (ByteString)object;
        this.value_ = byteString = ByteString.copyFromUtf8((String)object);
        return byteString;
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
        if (this.getValueBytes().isEmpty()) return;
        codedOutputStream.writeBytes(1, this.getValueBytes());
    }

    @Override
    public int getSerializedSize() {
        int n2 = this.memoizedSerializedSize;
        if (n2 != -1) {
            return n2;
        }
        n2 = 0;
        if (!this.getValueBytes().isEmpty()) {
            n2 += CodedOutputStream.computeBytesSize(1, this.getValueBytes());
        }
        this.memoizedSerializedSize = n2;
        return n2;
    }

    public static StringValue parseFrom(ByteString byteString) {
        return (StringValue)PARSER.parseFrom(byteString);
    }

    public static StringValue parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        return (StringValue)PARSER.parseFrom(byteString, extensionRegistryLite);
    }

    public static StringValue parseFrom(byte[] arrby) {
        return (StringValue)PARSER.parseFrom(arrby);
    }

    public static StringValue parseFrom(byte[] arrby, ExtensionRegistryLite extensionRegistryLite) {
        return (StringValue)PARSER.parseFrom(arrby, extensionRegistryLite);
    }

    public static StringValue parseFrom(InputStream inputStream) {
        return (StringValue)PARSER.parseFrom(inputStream);
    }

    public static StringValue parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (StringValue)PARSER.parseFrom(inputStream, extensionRegistryLite);
    }

    public static StringValue parseDelimitedFrom(InputStream inputStream) {
        return (StringValue)PARSER.parseDelimitedFrom(inputStream);
    }

    public static StringValue parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (StringValue)PARSER.parseDelimitedFrom(inputStream, extensionRegistryLite);
    }

    public static StringValue parseFrom(CodedInputStream codedInputStream) {
        return (StringValue)PARSER.parseFrom(codedInputStream);
    }

    public static StringValue parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (StringValue)PARSER.parseFrom(codedInputStream, extensionRegistryLite);
    }

    @Override
    public StringValue$Builder newBuilderForType() {
        return StringValue.newBuilder();
    }

    public static StringValue$Builder newBuilder() {
        return DEFAULT_INSTANCE.toBuilder();
    }

    public static StringValue$Builder newBuilder(StringValue stringValue) {
        return DEFAULT_INSTANCE.toBuilder().mergeFrom(stringValue);
    }

    @Override
    public StringValue$Builder toBuilder() {
        StringValue$Builder stringValue$Builder;
        if (this == DEFAULT_INSTANCE) {
            stringValue$Builder = new StringValue$Builder(null);
            return stringValue$Builder;
        }
        stringValue$Builder = new StringValue$Builder(null).mergeFrom(this);
        return stringValue$Builder;
    }

    @Override
    protected StringValue$Builder newBuilderForType(GeneratedMessage$BuilderParent generatedMessage$BuilderParent) {
        return new StringValue$Builder(generatedMessage$BuilderParent, null);
    }

    public static StringValue getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    @Override
    public Parser getParserForType() {
        return PARSER;
    }

    @Override
    public StringValue getDefaultInstanceForType() {
        return DEFAULT_INSTANCE;
    }

    /* synthetic */ StringValue(GeneratedMessage$Builder generatedMessage$Builder, StringValue$1 stringValue$1) {
        this(generatedMessage$Builder);
    }

    static /* synthetic */ Object access$302(StringValue stringValue, Object object) {
        stringValue.value_ = object;
        return stringValue.value_;
    }

    static /* synthetic */ Object access$300(StringValue stringValue) {
        return stringValue.value_;
    }

    /* synthetic */ StringValue(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite, StringValue$1 stringValue$1) {
        this(codedInputStream, extensionRegistryLite);
    }
}

