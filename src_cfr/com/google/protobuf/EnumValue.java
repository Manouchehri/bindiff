/*
 * Decompiled with CFR 0_115.
 */
package com.google.protobuf;

import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.Descriptors$Descriptor;
import com.google.protobuf.EnumValue$1;
import com.google.protobuf.EnumValue$Builder;
import com.google.protobuf.EnumValueOrBuilder;
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
import com.google.protobuf.Option;
import com.google.protobuf.OptionOrBuilder;
import com.google.protobuf.Parser;
import com.google.protobuf.TypeProto;
import com.google.protobuf.UnknownFieldSet;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class EnumValue
extends GeneratedMessage
implements EnumValueOrBuilder {
    private int bitField0_;
    public static final int NAME_FIELD_NUMBER = 1;
    private volatile Object name_;
    public static final int NUMBER_FIELD_NUMBER = 2;
    private int number_;
    public static final int OPTIONS_FIELD_NUMBER = 3;
    private List options_;
    private byte memoizedIsInitialized = -1;
    private int memoizedSerializedSize = -1;
    private static final long serialVersionUID = 0;
    private static final EnumValue DEFAULT_INSTANCE = new EnumValue();
    public static final Parser PARSER = new EnumValue$1();

    private EnumValue(GeneratedMessage$Builder generatedMessage$Builder) {
        super(generatedMessage$Builder);
    }

    private EnumValue() {
        this.name_ = "";
        this.number_ = 0;
        this.options_ = Collections.emptyList();
    }

    @Override
    public final UnknownFieldSet getUnknownFields() {
        return UnknownFieldSet.getDefaultInstance();
    }

    private EnumValue(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        this();
        int n2 = 0;
        try {
            block14 : {
                try {
                    boolean bl2 = false;
                    block11 : while (!bl2) {
                        int n3 = codedInputStream.readTag();
                        switch (n3) {
                            case 0: {
                                bl2 = true;
                                continue block11;
                            }
                            default: {
                                if (codedInputStream.skipField(n3)) continue block11;
                                bl2 = true;
                                continue block11;
                            }
                            case 10: {
                                ByteString byteString;
                                this.name_ = byteString = codedInputStream.readBytes();
                                continue block11;
                            }
                            case 16: {
                                this.number_ = codedInputStream.readInt32();
                                continue block11;
                            }
                            case 26: 
                        }
                        if ((n2 & 4) != 4) {
                            this.options_ = new ArrayList();
                            n2 |= 4;
                        }
                        this.options_.add(codedInputStream.readMessage(Option.PARSER, extensionRegistryLite));
                    }
                    Object var8_9 = null;
                    if ((n2 & 4) != 4) break block14;
                }
                catch (InvalidProtocolBufferException var4_5) {
                    throw new RuntimeException(var4_5.setUnfinishedMessage(this));
                }
                catch (IOException var4_6) {
                    throw new RuntimeException(new InvalidProtocolBufferException(var4_6.getMessage()).setUnfinishedMessage(this));
                }
                this.options_ = Collections.unmodifiableList(this.options_);
            }
            this.makeExtensionsImmutable();
            return;
        }
        catch (Throwable var7_11) {
            Object var8_10 = null;
            if ((n2 & 4) == 4) {
                this.options_ = Collections.unmodifiableList(this.options_);
            }
            this.makeExtensionsImmutable();
            throw var7_11;
        }
    }

    public static final Descriptors$Descriptor getDescriptor() {
        return TypeProto.internal_static_google_protobuf_EnumValue_descriptor;
    }

    @Override
    protected GeneratedMessage$FieldAccessorTable internalGetFieldAccessorTable() {
        return TypeProto.internal_static_google_protobuf_EnumValue_fieldAccessorTable.ensureFieldAccessorsInitialized(EnumValue.class, EnumValue$Builder.class);
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
    public int getNumber() {
        return this.number_;
    }

    @Override
    public List getOptionsList() {
        return this.options_;
    }

    @Override
    public List getOptionsOrBuilderList() {
        return this.options_;
    }

    @Override
    public int getOptionsCount() {
        return this.options_.size();
    }

    @Override
    public Option getOptions(int n2) {
        return (Option)this.options_.get(n2);
    }

    @Override
    public OptionOrBuilder getOptionsOrBuilder(int n2) {
        return (OptionOrBuilder)this.options_.get(n2);
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
        if (this.number_ != 0) {
            codedOutputStream.writeInt32(2, this.number_);
        }
        int n2 = 0;
        while (n2 < this.options_.size()) {
            codedOutputStream.writeMessage(3, (MessageLite)this.options_.get(n2));
            ++n2;
        }
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
        if (this.number_ != 0) {
            n2 += CodedOutputStream.computeInt32Size(2, this.number_);
        }
        int n3 = 0;
        do {
            if (n3 >= this.options_.size()) {
                this.memoizedSerializedSize = n2;
                return n2;
            }
            n2 += CodedOutputStream.computeMessageSize(3, (MessageLite)this.options_.get(n3));
            ++n3;
        } while (true);
    }

    public static EnumValue parseFrom(ByteString byteString) {
        return (EnumValue)PARSER.parseFrom(byteString);
    }

    public static EnumValue parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        return (EnumValue)PARSER.parseFrom(byteString, extensionRegistryLite);
    }

    public static EnumValue parseFrom(byte[] arrby) {
        return (EnumValue)PARSER.parseFrom(arrby);
    }

    public static EnumValue parseFrom(byte[] arrby, ExtensionRegistryLite extensionRegistryLite) {
        return (EnumValue)PARSER.parseFrom(arrby, extensionRegistryLite);
    }

    public static EnumValue parseFrom(InputStream inputStream) {
        return (EnumValue)PARSER.parseFrom(inputStream);
    }

    public static EnumValue parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (EnumValue)PARSER.parseFrom(inputStream, extensionRegistryLite);
    }

    public static EnumValue parseDelimitedFrom(InputStream inputStream) {
        return (EnumValue)PARSER.parseDelimitedFrom(inputStream);
    }

    public static EnumValue parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (EnumValue)PARSER.parseDelimitedFrom(inputStream, extensionRegistryLite);
    }

    public static EnumValue parseFrom(CodedInputStream codedInputStream) {
        return (EnumValue)PARSER.parseFrom(codedInputStream);
    }

    public static EnumValue parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (EnumValue)PARSER.parseFrom(codedInputStream, extensionRegistryLite);
    }

    @Override
    public EnumValue$Builder newBuilderForType() {
        return EnumValue.newBuilder();
    }

    public static EnumValue$Builder newBuilder() {
        return DEFAULT_INSTANCE.toBuilder();
    }

    public static EnumValue$Builder newBuilder(EnumValue enumValue) {
        return DEFAULT_INSTANCE.toBuilder().mergeFrom(enumValue);
    }

    @Override
    public EnumValue$Builder toBuilder() {
        EnumValue$Builder enumValue$Builder;
        if (this == DEFAULT_INSTANCE) {
            enumValue$Builder = new EnumValue$Builder(null);
            return enumValue$Builder;
        }
        enumValue$Builder = new EnumValue$Builder(null).mergeFrom(this);
        return enumValue$Builder;
    }

    @Override
    protected EnumValue$Builder newBuilderForType(GeneratedMessage$BuilderParent generatedMessage$BuilderParent) {
        return new EnumValue$Builder(generatedMessage$BuilderParent, null);
    }

    public static EnumValue getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    @Override
    public Parser getParserForType() {
        return PARSER;
    }

    @Override
    public EnumValue getDefaultInstanceForType() {
        return DEFAULT_INSTANCE;
    }

    /* synthetic */ EnumValue(GeneratedMessage$Builder generatedMessage$Builder, EnumValue$1 enumValue$1) {
        this(generatedMessage$Builder);
    }

    static /* synthetic */ Object access$302(EnumValue enumValue, Object object) {
        enumValue.name_ = object;
        return enumValue.name_;
    }

    static /* synthetic */ int access$402(EnumValue enumValue, int n2) {
        enumValue.number_ = n2;
        return enumValue.number_;
    }

    static /* synthetic */ List access$502(EnumValue enumValue, List list) {
        enumValue.options_ = list;
        return enumValue.options_;
    }

    static /* synthetic */ int access$602(EnumValue enumValue, int n2) {
        enumValue.bitField0_ = n2;
        return enumValue.bitField0_;
    }

    static /* synthetic */ Object access$300(EnumValue enumValue) {
        return enumValue.name_;
    }

    static /* synthetic */ List access$500(EnumValue enumValue) {
        return enumValue.options_;
    }

    /* synthetic */ EnumValue(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite, EnumValue$1 enumValue$1) {
        this(codedInputStream, extensionRegistryLite);
    }
}

