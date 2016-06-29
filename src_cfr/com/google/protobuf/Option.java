/*
 * Decompiled with CFR 0_115.
 */
package com.google.protobuf;

import com.google.protobuf.Any;
import com.google.protobuf.Any$Builder;
import com.google.protobuf.AnyOrBuilder;
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
import com.google.protobuf.Option$1;
import com.google.protobuf.Option$Builder;
import com.google.protobuf.OptionOrBuilder;
import com.google.protobuf.Parser;
import com.google.protobuf.TypeProto;
import com.google.protobuf.UnknownFieldSet;
import java.io.IOException;
import java.io.InputStream;

public final class Option
extends GeneratedMessage
implements OptionOrBuilder {
    public static final int NAME_FIELD_NUMBER = 1;
    private volatile Object name_;
    public static final int VALUE_FIELD_NUMBER = 2;
    private Any value_;
    private byte memoizedIsInitialized = -1;
    private int memoizedSerializedSize = -1;
    private static final long serialVersionUID = 0;
    private static final Option DEFAULT_INSTANCE = new Option();
    public static final Parser PARSER = new Option$1();

    private Option(GeneratedMessage$Builder generatedMessage$Builder) {
        super(generatedMessage$Builder);
    }

    private Option() {
        this.name_ = "";
    }

    @Override
    public final UnknownFieldSet getUnknownFields() {
        return UnknownFieldSet.getDefaultInstance();
    }

    private Option(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        this();
        boolean bl2 = false;
        try {
            try {
                boolean bl3 = false;
                block10 : while (!bl3) {
                    Object object;
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
                            this.name_ = object = codedInputStream.readBytes();
                            continue block10;
                        }
                        case 18: 
                    }
                    object = null;
                    if (this.value_ != null) {
                        object = this.value_.toBuilder();
                    }
                    this.value_ = (Any)codedInputStream.readMessage(Any.PARSER, extensionRegistryLite);
                    if (object == null) continue;
                    object.mergeFrom(this.value_);
                    this.value_ = object.buildPartial();
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
        return TypeProto.internal_static_google_protobuf_Option_descriptor;
    }

    @Override
    protected GeneratedMessage$FieldAccessorTable internalGetFieldAccessorTable() {
        return TypeProto.internal_static_google_protobuf_Option_fieldAccessorTable.ensureFieldAccessorsInitialized(Option.class, Option$Builder.class);
    }

    @Override
    public String getName() {
        Object object = this.name_;
        if (object instanceof String) {
            return (String)object;
        }
        ByteString byteString = (ByteString)object;
        String string = byteString.toStringUtf8();
        if (!byteString.isValidUtf8()) return string;
        this.name_ = string;
        return string;
    }

    @Override
    public ByteString getNameBytes() {
        ByteString byteString;
        Object object = this.name_;
        if (!(object instanceof String)) return (ByteString)object;
        this.name_ = byteString = ByteString.copyFromUtf8((String)object);
        return byteString;
    }

    @Override
    public boolean hasValue() {
        if (this.value_ == null) return false;
        return true;
    }

    @Override
    public Any getValue() {
        Any any;
        if (this.value_ == null) {
            any = Any.getDefaultInstance();
            return any;
        }
        any = this.value_;
        return any;
    }

    @Override
    public AnyOrBuilder getValueOrBuilder() {
        return this.getValue();
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
        if (!this.getNameBytes().isEmpty()) {
            codedOutputStream.writeBytes(1, this.getNameBytes());
        }
        if (this.value_ == null) return;
        codedOutputStream.writeMessage(2, this.getValue());
    }

    @Override
    public int getSerializedSize() {
        int n2 = this.memoizedSerializedSize;
        if (n2 != -1) {
            return n2;
        }
        n2 = 0;
        if (!this.getNameBytes().isEmpty()) {
            n2 += CodedOutputStream.computeBytesSize(1, this.getNameBytes());
        }
        if (this.value_ != null) {
            n2 += CodedOutputStream.computeMessageSize(2, this.getValue());
        }
        this.memoizedSerializedSize = n2;
        return n2;
    }

    public static Option parseFrom(ByteString byteString) {
        return (Option)PARSER.parseFrom(byteString);
    }

    public static Option parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        return (Option)PARSER.parseFrom(byteString, extensionRegistryLite);
    }

    public static Option parseFrom(byte[] arrby) {
        return (Option)PARSER.parseFrom(arrby);
    }

    public static Option parseFrom(byte[] arrby, ExtensionRegistryLite extensionRegistryLite) {
        return (Option)PARSER.parseFrom(arrby, extensionRegistryLite);
    }

    public static Option parseFrom(InputStream inputStream) {
        return (Option)PARSER.parseFrom(inputStream);
    }

    public static Option parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (Option)PARSER.parseFrom(inputStream, extensionRegistryLite);
    }

    public static Option parseDelimitedFrom(InputStream inputStream) {
        return (Option)PARSER.parseDelimitedFrom(inputStream);
    }

    public static Option parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (Option)PARSER.parseDelimitedFrom(inputStream, extensionRegistryLite);
    }

    public static Option parseFrom(CodedInputStream codedInputStream) {
        return (Option)PARSER.parseFrom(codedInputStream);
    }

    public static Option parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (Option)PARSER.parseFrom(codedInputStream, extensionRegistryLite);
    }

    @Override
    public Option$Builder newBuilderForType() {
        return Option.newBuilder();
    }

    public static Option$Builder newBuilder() {
        return DEFAULT_INSTANCE.toBuilder();
    }

    public static Option$Builder newBuilder(Option option) {
        return DEFAULT_INSTANCE.toBuilder().mergeFrom(option);
    }

    @Override
    public Option$Builder toBuilder() {
        Option$Builder option$Builder;
        if (this == DEFAULT_INSTANCE) {
            option$Builder = new Option$Builder(null);
            return option$Builder;
        }
        option$Builder = new Option$Builder(null).mergeFrom(this);
        return option$Builder;
    }

    @Override
    protected Option$Builder newBuilderForType(GeneratedMessage$BuilderParent generatedMessage$BuilderParent) {
        return new Option$Builder(generatedMessage$BuilderParent, null);
    }

    public static Option getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    @Override
    public Parser getParserForType() {
        return PARSER;
    }

    @Override
    public Option getDefaultInstanceForType() {
        return DEFAULT_INSTANCE;
    }

    /* synthetic */ Option(GeneratedMessage$Builder generatedMessage$Builder, Option$1 option$1) {
        this(generatedMessage$Builder);
    }

    static /* synthetic */ Object access$302(Option option, Object object) {
        option.name_ = object;
        return option.name_;
    }

    static /* synthetic */ Any access$402(Option option, Any any) {
        option.value_ = any;
        return option.value_;
    }

    static /* synthetic */ Object access$300(Option option) {
        return option.name_;
    }

    /* synthetic */ Option(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite, Option$1 option$1) {
        this(codedInputStream, extensionRegistryLite);
    }
}

