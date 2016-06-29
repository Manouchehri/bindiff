/*
 * Decompiled with CFR 0_115.
 */
package com.google.protobuf;

import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.DescriptorProtos;
import com.google.protobuf.DescriptorProtos$1;
import com.google.protobuf.DescriptorProtos$EnumValueDescriptorProto$1;
import com.google.protobuf.DescriptorProtos$EnumValueDescriptorProto$Builder;
import com.google.protobuf.DescriptorProtos$EnumValueDescriptorProtoOrBuilder;
import com.google.protobuf.DescriptorProtos$EnumValueOptions;
import com.google.protobuf.DescriptorProtos$EnumValueOptions$Builder;
import com.google.protobuf.DescriptorProtos$EnumValueOptionsOrBuilder;
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
import com.google.protobuf.UnknownFieldSet$Builder;
import java.io.IOException;
import java.io.InputStream;

public final class DescriptorProtos$EnumValueDescriptorProto
extends GeneratedMessage
implements DescriptorProtos$EnumValueDescriptorProtoOrBuilder {
    private int bitField0_;
    public static final int NAME_FIELD_NUMBER = 1;
    private volatile Object name_;
    public static final int NUMBER_FIELD_NUMBER = 2;
    private int number_;
    public static final int OPTIONS_FIELD_NUMBER = 3;
    private DescriptorProtos$EnumValueOptions options_;
    private byte memoizedIsInitialized = -1;
    private int memoizedSerializedSize = -1;
    private static final long serialVersionUID = 0;
    private static final DescriptorProtos$EnumValueDescriptorProto DEFAULT_INSTANCE = new DescriptorProtos$EnumValueDescriptorProto();
    public static final Parser PARSER = new DescriptorProtos$EnumValueDescriptorProto$1();

    private DescriptorProtos$EnumValueDescriptorProto(GeneratedMessage$Builder generatedMessage$Builder) {
        super(generatedMessage$Builder);
    }

    private DescriptorProtos$EnumValueDescriptorProto() {
        this.name_ = "";
        this.number_ = 0;
    }

    @Override
    public final UnknownFieldSet getUnknownFields() {
        return this.unknownFields;
    }

    private DescriptorProtos$EnumValueDescriptorProto(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        this();
        boolean bl2 = false;
        UnknownFieldSet$Builder unknownFieldSet$Builder = UnknownFieldSet.newBuilder();
        try {
            try {
                boolean bl3 = false;
                block11 : while (!bl3) {
                    Object object;
                    int n2 = codedInputStream.readTag();
                    switch (n2) {
                        case 0: {
                            bl3 = true;
                            continue block11;
                        }
                        default: {
                            if (this.parseUnknownField(codedInputStream, unknownFieldSet$Builder, extensionRegistryLite, n2)) continue block11;
                            bl3 = true;
                            continue block11;
                        }
                        case 10: {
                            object = codedInputStream.readBytes();
                            this.bitField0_ |= 1;
                            this.name_ = object;
                            continue block11;
                        }
                        case 16: {
                            this.bitField0_ |= 2;
                            this.number_ = codedInputStream.readInt32();
                            continue block11;
                        }
                        case 26: 
                    }
                    object = null;
                    if ((this.bitField0_ & 4) == 4) {
                        object = this.options_.toBuilder();
                    }
                    this.options_ = (DescriptorProtos$EnumValueOptions)codedInputStream.readMessage(DescriptorProtos$EnumValueOptions.PARSER, extensionRegistryLite);
                    if (object != null) {
                        object.mergeFrom(this.options_);
                        this.options_ = object.buildPartial();
                    }
                    this.bitField0_ |= 4;
                }
                Object var9_10 = null;
                this.unknownFields = unknownFieldSet$Builder.build();
            }
            catch (InvalidProtocolBufferException var5_6) {
                throw new RuntimeException(var5_6.setUnfinishedMessage(this));
            }
            catch (IOException var5_7) {
                throw new RuntimeException(new InvalidProtocolBufferException(var5_7.getMessage()).setUnfinishedMessage(this));
            }
            this.makeExtensionsImmutable();
            return;
        }
        catch (Throwable var8_12) {
            Object var9_11 = null;
            this.unknownFields = unknownFieldSet$Builder.build();
            this.makeExtensionsImmutable();
            throw var8_12;
        }
    }

    public static final Descriptors$Descriptor getDescriptor() {
        return DescriptorProtos.access$9500();
    }

    @Override
    protected GeneratedMessage$FieldAccessorTable internalGetFieldAccessorTable() {
        return DescriptorProtos.access$9600().ensureFieldAccessorsInitialized(DescriptorProtos$EnumValueDescriptorProto.class, DescriptorProtos$EnumValueDescriptorProto$Builder.class);
    }

    @Override
    public boolean hasName() {
        if ((this.bitField0_ & 1) != 1) return false;
        return true;
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
    public boolean hasNumber() {
        if ((this.bitField0_ & 2) != 2) return false;
        return true;
    }

    @Override
    public int getNumber() {
        return this.number_;
    }

    @Override
    public boolean hasOptions() {
        if ((this.bitField0_ & 4) != 4) return false;
        return true;
    }

    @Override
    public DescriptorProtos$EnumValueOptions getOptions() {
        DescriptorProtos$EnumValueOptions descriptorProtos$EnumValueOptions;
        if (this.options_ == null) {
            descriptorProtos$EnumValueOptions = DescriptorProtos$EnumValueOptions.getDefaultInstance();
            return descriptorProtos$EnumValueOptions;
        }
        descriptorProtos$EnumValueOptions = this.options_;
        return descriptorProtos$EnumValueOptions;
    }

    @Override
    public DescriptorProtos$EnumValueOptionsOrBuilder getOptionsOrBuilder() {
        DescriptorProtos$EnumValueOptions descriptorProtos$EnumValueOptions;
        if (this.options_ == null) {
            descriptorProtos$EnumValueOptions = DescriptorProtos$EnumValueOptions.getDefaultInstance();
            return descriptorProtos$EnumValueOptions;
        }
        descriptorProtos$EnumValueOptions = this.options_;
        return descriptorProtos$EnumValueOptions;
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
        if (this.hasOptions() && !this.getOptions().isInitialized()) {
            this.memoizedIsInitialized = 0;
            return false;
        }
        this.memoizedIsInitialized = 1;
        return true;
    }

    @Override
    public void writeTo(CodedOutputStream codedOutputStream) {
        if ((this.bitField0_ & 1) == 1) {
            codedOutputStream.writeBytes(1, this.getNameBytes());
        }
        if ((this.bitField0_ & 2) == 2) {
            codedOutputStream.writeInt32(2, this.number_);
        }
        if ((this.bitField0_ & 4) == 4) {
            codedOutputStream.writeMessage(3, this.getOptions());
        }
        this.unknownFields.writeTo(codedOutputStream);
    }

    @Override
    public int getSerializedSize() {
        int n2 = this.memoizedSerializedSize;
        if (n2 != -1) {
            return n2;
        }
        n2 = 0;
        if ((this.bitField0_ & 1) == 1) {
            n2 += CodedOutputStream.computeBytesSize(1, this.getNameBytes());
        }
        if ((this.bitField0_ & 2) == 2) {
            n2 += CodedOutputStream.computeInt32Size(2, this.number_);
        }
        if ((this.bitField0_ & 4) == 4) {
            n2 += CodedOutputStream.computeMessageSize(3, this.getOptions());
        }
        this.memoizedSerializedSize = n2 += this.unknownFields.getSerializedSize();
        return n2;
    }

    public static DescriptorProtos$EnumValueDescriptorProto parseFrom(ByteString byteString) {
        return (DescriptorProtos$EnumValueDescriptorProto)PARSER.parseFrom(byteString);
    }

    public static DescriptorProtos$EnumValueDescriptorProto parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        return (DescriptorProtos$EnumValueDescriptorProto)PARSER.parseFrom(byteString, extensionRegistryLite);
    }

    public static DescriptorProtos$EnumValueDescriptorProto parseFrom(byte[] arrby) {
        return (DescriptorProtos$EnumValueDescriptorProto)PARSER.parseFrom(arrby);
    }

    public static DescriptorProtos$EnumValueDescriptorProto parseFrom(byte[] arrby, ExtensionRegistryLite extensionRegistryLite) {
        return (DescriptorProtos$EnumValueDescriptorProto)PARSER.parseFrom(arrby, extensionRegistryLite);
    }

    public static DescriptorProtos$EnumValueDescriptorProto parseFrom(InputStream inputStream) {
        return (DescriptorProtos$EnumValueDescriptorProto)PARSER.parseFrom(inputStream);
    }

    public static DescriptorProtos$EnumValueDescriptorProto parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (DescriptorProtos$EnumValueDescriptorProto)PARSER.parseFrom(inputStream, extensionRegistryLite);
    }

    public static DescriptorProtos$EnumValueDescriptorProto parseDelimitedFrom(InputStream inputStream) {
        return (DescriptorProtos$EnumValueDescriptorProto)PARSER.parseDelimitedFrom(inputStream);
    }

    public static DescriptorProtos$EnumValueDescriptorProto parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (DescriptorProtos$EnumValueDescriptorProto)PARSER.parseDelimitedFrom(inputStream, extensionRegistryLite);
    }

    public static DescriptorProtos$EnumValueDescriptorProto parseFrom(CodedInputStream codedInputStream) {
        return (DescriptorProtos$EnumValueDescriptorProto)PARSER.parseFrom(codedInputStream);
    }

    public static DescriptorProtos$EnumValueDescriptorProto parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (DescriptorProtos$EnumValueDescriptorProto)PARSER.parseFrom(codedInputStream, extensionRegistryLite);
    }

    @Override
    public DescriptorProtos$EnumValueDescriptorProto$Builder newBuilderForType() {
        return DescriptorProtos$EnumValueDescriptorProto.newBuilder();
    }

    public static DescriptorProtos$EnumValueDescriptorProto$Builder newBuilder() {
        return DEFAULT_INSTANCE.toBuilder();
    }

    public static DescriptorProtos$EnumValueDescriptorProto$Builder newBuilder(DescriptorProtos$EnumValueDescriptorProto descriptorProtos$EnumValueDescriptorProto) {
        return DEFAULT_INSTANCE.toBuilder().mergeFrom(descriptorProtos$EnumValueDescriptorProto);
    }

    @Override
    public DescriptorProtos$EnumValueDescriptorProto$Builder toBuilder() {
        DescriptorProtos$EnumValueDescriptorProto$Builder descriptorProtos$EnumValueDescriptorProto$Builder;
        if (this == DEFAULT_INSTANCE) {
            descriptorProtos$EnumValueDescriptorProto$Builder = new DescriptorProtos$EnumValueDescriptorProto$Builder(null);
            return descriptorProtos$EnumValueDescriptorProto$Builder;
        }
        descriptorProtos$EnumValueDescriptorProto$Builder = new DescriptorProtos$EnumValueDescriptorProto$Builder(null).mergeFrom(this);
        return descriptorProtos$EnumValueDescriptorProto$Builder;
    }

    @Override
    protected DescriptorProtos$EnumValueDescriptorProto$Builder newBuilderForType(GeneratedMessage$BuilderParent generatedMessage$BuilderParent) {
        return new DescriptorProtos$EnumValueDescriptorProto$Builder(generatedMessage$BuilderParent, null);
    }

    public static DescriptorProtos$EnumValueDescriptorProto getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    @Override
    public Parser getParserForType() {
        return PARSER;
    }

    @Override
    public DescriptorProtos$EnumValueDescriptorProto getDefaultInstanceForType() {
        return DEFAULT_INSTANCE;
    }

    /* synthetic */ DescriptorProtos$EnumValueDescriptorProto(GeneratedMessage$Builder generatedMessage$Builder, DescriptorProtos$1 descriptorProtos$1) {
        this(generatedMessage$Builder);
    }

    static /* synthetic */ Object access$10002(DescriptorProtos$EnumValueDescriptorProto descriptorProtos$EnumValueDescriptorProto, Object object) {
        descriptorProtos$EnumValueDescriptorProto.name_ = object;
        return descriptorProtos$EnumValueDescriptorProto.name_;
    }

    static /* synthetic */ int access$10102(DescriptorProtos$EnumValueDescriptorProto descriptorProtos$EnumValueDescriptorProto, int n2) {
        descriptorProtos$EnumValueDescriptorProto.number_ = n2;
        return descriptorProtos$EnumValueDescriptorProto.number_;
    }

    static /* synthetic */ DescriptorProtos$EnumValueOptions access$10202(DescriptorProtos$EnumValueDescriptorProto descriptorProtos$EnumValueDescriptorProto, DescriptorProtos$EnumValueOptions descriptorProtos$EnumValueOptions) {
        descriptorProtos$EnumValueDescriptorProto.options_ = descriptorProtos$EnumValueOptions;
        return descriptorProtos$EnumValueDescriptorProto.options_;
    }

    static /* synthetic */ int access$10302(DescriptorProtos$EnumValueDescriptorProto descriptorProtos$EnumValueDescriptorProto, int n2) {
        descriptorProtos$EnumValueDescriptorProto.bitField0_ = n2;
        return descriptorProtos$EnumValueDescriptorProto.bitField0_;
    }

    static /* synthetic */ Object access$10000(DescriptorProtos$EnumValueDescriptorProto descriptorProtos$EnumValueDescriptorProto) {
        return descriptorProtos$EnumValueDescriptorProto.name_;
    }

    /* synthetic */ DescriptorProtos$EnumValueDescriptorProto(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite, DescriptorProtos$1 descriptorProtos$1) {
        this(codedInputStream, extensionRegistryLite);
    }
}

