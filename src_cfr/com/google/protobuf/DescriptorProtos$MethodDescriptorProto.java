/*
 * Decompiled with CFR 0_115.
 */
package com.google.protobuf;

import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.DescriptorProtos;
import com.google.protobuf.DescriptorProtos$1;
import com.google.protobuf.DescriptorProtos$MethodDescriptorProto$1;
import com.google.protobuf.DescriptorProtos$MethodDescriptorProto$Builder;
import com.google.protobuf.DescriptorProtos$MethodDescriptorProtoOrBuilder;
import com.google.protobuf.DescriptorProtos$MethodOptions;
import com.google.protobuf.DescriptorProtos$MethodOptions$Builder;
import com.google.protobuf.DescriptorProtos$MethodOptionsOrBuilder;
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

public final class DescriptorProtos$MethodDescriptorProto
extends GeneratedMessage
implements DescriptorProtos$MethodDescriptorProtoOrBuilder {
    private int bitField0_;
    public static final int NAME_FIELD_NUMBER = 1;
    private volatile Object name_;
    public static final int INPUT_TYPE_FIELD_NUMBER = 2;
    private volatile Object inputType_;
    public static final int OUTPUT_TYPE_FIELD_NUMBER = 3;
    private volatile Object outputType_;
    public static final int OPTIONS_FIELD_NUMBER = 4;
    private DescriptorProtos$MethodOptions options_;
    public static final int CLIENT_STREAMING_FIELD_NUMBER = 5;
    private boolean clientStreaming_;
    public static final int SERVER_STREAMING_FIELD_NUMBER = 6;
    private boolean serverStreaming_;
    private byte memoizedIsInitialized = -1;
    private int memoizedSerializedSize = -1;
    private static final long serialVersionUID = 0;
    private static final DescriptorProtos$MethodDescriptorProto DEFAULT_INSTANCE = new DescriptorProtos$MethodDescriptorProto();
    public static final Parser PARSER = new DescriptorProtos$MethodDescriptorProto$1();

    private DescriptorProtos$MethodDescriptorProto(GeneratedMessage$Builder generatedMessage$Builder) {
        super(generatedMessage$Builder);
    }

    private DescriptorProtos$MethodDescriptorProto() {
        this.name_ = "";
        this.inputType_ = "";
        this.outputType_ = "";
        this.clientStreaming_ = false;
        this.serverStreaming_ = false;
    }

    @Override
    public final UnknownFieldSet getUnknownFields() {
        return this.unknownFields;
    }

    private DescriptorProtos$MethodDescriptorProto(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        this();
        boolean bl2 = false;
        UnknownFieldSet$Builder unknownFieldSet$Builder = UnknownFieldSet.newBuilder();
        try {
            try {
                boolean bl3 = false;
                block14 : while (!bl3) {
                    int n2 = codedInputStream.readTag();
                    switch (n2) {
                        Object object;
                        case 0: {
                            bl3 = true;
                            continue block14;
                        }
                        default: {
                            if (this.parseUnknownField(codedInputStream, unknownFieldSet$Builder, extensionRegistryLite, n2)) continue block14;
                            bl3 = true;
                            continue block14;
                        }
                        case 10: {
                            object = codedInputStream.readBytes();
                            this.bitField0_ |= 1;
                            this.name_ = object;
                            continue block14;
                        }
                        case 18: {
                            object = codedInputStream.readBytes();
                            this.bitField0_ |= 2;
                            this.inputType_ = object;
                            continue block14;
                        }
                        case 26: {
                            object = codedInputStream.readBytes();
                            this.bitField0_ |= 4;
                            this.outputType_ = object;
                            continue block14;
                        }
                        case 34: {
                            object = null;
                            if ((this.bitField0_ & 8) == 8) {
                                object = this.options_.toBuilder();
                            }
                            this.options_ = (DescriptorProtos$MethodOptions)codedInputStream.readMessage(DescriptorProtos$MethodOptions.PARSER, extensionRegistryLite);
                            if (object != null) {
                                object.mergeFrom(this.options_);
                                this.options_ = object.buildPartial();
                            }
                            this.bitField0_ |= 8;
                            continue block14;
                        }
                        case 40: {
                            this.bitField0_ |= 16;
                            this.clientStreaming_ = codedInputStream.readBool();
                            continue block14;
                        }
                        case 48: 
                    }
                    this.bitField0_ |= 32;
                    this.serverStreaming_ = codedInputStream.readBool();
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
        return DescriptorProtos.access$11500();
    }

    @Override
    protected GeneratedMessage$FieldAccessorTable internalGetFieldAccessorTable() {
        return DescriptorProtos.access$11600().ensureFieldAccessorsInitialized(DescriptorProtos$MethodDescriptorProto.class, DescriptorProtos$MethodDescriptorProto$Builder.class);
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
    public boolean hasInputType() {
        if ((this.bitField0_ & 2) != 2) return false;
        return true;
    }

    @Override
    public String getInputType() {
        Object object = this.inputType_;
        if (object instanceof String) {
            return (String)object;
        }
        ByteString byteString = (ByteString)object;
        String string = byteString.toStringUtf8();
        if (!byteString.isValidUtf8()) return string;
        this.inputType_ = string;
        return string;
    }

    @Override
    public ByteString getInputTypeBytes() {
        ByteString byteString;
        Object object = this.inputType_;
        if (!(object instanceof String)) return (ByteString)object;
        this.inputType_ = byteString = ByteString.copyFromUtf8((String)object);
        return byteString;
    }

    @Override
    public boolean hasOutputType() {
        if ((this.bitField0_ & 4) != 4) return false;
        return true;
    }

    @Override
    public String getOutputType() {
        Object object = this.outputType_;
        if (object instanceof String) {
            return (String)object;
        }
        ByteString byteString = (ByteString)object;
        String string = byteString.toStringUtf8();
        if (!byteString.isValidUtf8()) return string;
        this.outputType_ = string;
        return string;
    }

    @Override
    public ByteString getOutputTypeBytes() {
        ByteString byteString;
        Object object = this.outputType_;
        if (!(object instanceof String)) return (ByteString)object;
        this.outputType_ = byteString = ByteString.copyFromUtf8((String)object);
        return byteString;
    }

    @Override
    public boolean hasOptions() {
        if ((this.bitField0_ & 8) != 8) return false;
        return true;
    }

    @Override
    public DescriptorProtos$MethodOptions getOptions() {
        DescriptorProtos$MethodOptions descriptorProtos$MethodOptions;
        if (this.options_ == null) {
            descriptorProtos$MethodOptions = DescriptorProtos$MethodOptions.getDefaultInstance();
            return descriptorProtos$MethodOptions;
        }
        descriptorProtos$MethodOptions = this.options_;
        return descriptorProtos$MethodOptions;
    }

    @Override
    public DescriptorProtos$MethodOptionsOrBuilder getOptionsOrBuilder() {
        DescriptorProtos$MethodOptions descriptorProtos$MethodOptions;
        if (this.options_ == null) {
            descriptorProtos$MethodOptions = DescriptorProtos$MethodOptions.getDefaultInstance();
            return descriptorProtos$MethodOptions;
        }
        descriptorProtos$MethodOptions = this.options_;
        return descriptorProtos$MethodOptions;
    }

    @Override
    public boolean hasClientStreaming() {
        if ((this.bitField0_ & 16) != 16) return false;
        return true;
    }

    @Override
    public boolean getClientStreaming() {
        return this.clientStreaming_;
    }

    @Override
    public boolean hasServerStreaming() {
        if ((this.bitField0_ & 32) != 32) return false;
        return true;
    }

    @Override
    public boolean getServerStreaming() {
        return this.serverStreaming_;
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
            codedOutputStream.writeBytes(2, this.getInputTypeBytes());
        }
        if ((this.bitField0_ & 4) == 4) {
            codedOutputStream.writeBytes(3, this.getOutputTypeBytes());
        }
        if ((this.bitField0_ & 8) == 8) {
            codedOutputStream.writeMessage(4, this.getOptions());
        }
        if ((this.bitField0_ & 16) == 16) {
            codedOutputStream.writeBool(5, this.clientStreaming_);
        }
        if ((this.bitField0_ & 32) == 32) {
            codedOutputStream.writeBool(6, this.serverStreaming_);
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
            n2 += CodedOutputStream.computeBytesSize(2, this.getInputTypeBytes());
        }
        if ((this.bitField0_ & 4) == 4) {
            n2 += CodedOutputStream.computeBytesSize(3, this.getOutputTypeBytes());
        }
        if ((this.bitField0_ & 8) == 8) {
            n2 += CodedOutputStream.computeMessageSize(4, this.getOptions());
        }
        if ((this.bitField0_ & 16) == 16) {
            n2 += CodedOutputStream.computeBoolSize(5, this.clientStreaming_);
        }
        if ((this.bitField0_ & 32) == 32) {
            n2 += CodedOutputStream.computeBoolSize(6, this.serverStreaming_);
        }
        this.memoizedSerializedSize = n2 += this.unknownFields.getSerializedSize();
        return n2;
    }

    public static DescriptorProtos$MethodDescriptorProto parseFrom(ByteString byteString) {
        return (DescriptorProtos$MethodDescriptorProto)PARSER.parseFrom(byteString);
    }

    public static DescriptorProtos$MethodDescriptorProto parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        return (DescriptorProtos$MethodDescriptorProto)PARSER.parseFrom(byteString, extensionRegistryLite);
    }

    public static DescriptorProtos$MethodDescriptorProto parseFrom(byte[] arrby) {
        return (DescriptorProtos$MethodDescriptorProto)PARSER.parseFrom(arrby);
    }

    public static DescriptorProtos$MethodDescriptorProto parseFrom(byte[] arrby, ExtensionRegistryLite extensionRegistryLite) {
        return (DescriptorProtos$MethodDescriptorProto)PARSER.parseFrom(arrby, extensionRegistryLite);
    }

    public static DescriptorProtos$MethodDescriptorProto parseFrom(InputStream inputStream) {
        return (DescriptorProtos$MethodDescriptorProto)PARSER.parseFrom(inputStream);
    }

    public static DescriptorProtos$MethodDescriptorProto parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (DescriptorProtos$MethodDescriptorProto)PARSER.parseFrom(inputStream, extensionRegistryLite);
    }

    public static DescriptorProtos$MethodDescriptorProto parseDelimitedFrom(InputStream inputStream) {
        return (DescriptorProtos$MethodDescriptorProto)PARSER.parseDelimitedFrom(inputStream);
    }

    public static DescriptorProtos$MethodDescriptorProto parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (DescriptorProtos$MethodDescriptorProto)PARSER.parseDelimitedFrom(inputStream, extensionRegistryLite);
    }

    public static DescriptorProtos$MethodDescriptorProto parseFrom(CodedInputStream codedInputStream) {
        return (DescriptorProtos$MethodDescriptorProto)PARSER.parseFrom(codedInputStream);
    }

    public static DescriptorProtos$MethodDescriptorProto parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (DescriptorProtos$MethodDescriptorProto)PARSER.parseFrom(codedInputStream, extensionRegistryLite);
    }

    @Override
    public DescriptorProtos$MethodDescriptorProto$Builder newBuilderForType() {
        return DescriptorProtos$MethodDescriptorProto.newBuilder();
    }

    public static DescriptorProtos$MethodDescriptorProto$Builder newBuilder() {
        return DEFAULT_INSTANCE.toBuilder();
    }

    public static DescriptorProtos$MethodDescriptorProto$Builder newBuilder(DescriptorProtos$MethodDescriptorProto descriptorProtos$MethodDescriptorProto) {
        return DEFAULT_INSTANCE.toBuilder().mergeFrom(descriptorProtos$MethodDescriptorProto);
    }

    @Override
    public DescriptorProtos$MethodDescriptorProto$Builder toBuilder() {
        DescriptorProtos$MethodDescriptorProto$Builder descriptorProtos$MethodDescriptorProto$Builder;
        if (this == DEFAULT_INSTANCE) {
            descriptorProtos$MethodDescriptorProto$Builder = new DescriptorProtos$MethodDescriptorProto$Builder(null);
            return descriptorProtos$MethodDescriptorProto$Builder;
        }
        descriptorProtos$MethodDescriptorProto$Builder = new DescriptorProtos$MethodDescriptorProto$Builder(null).mergeFrom(this);
        return descriptorProtos$MethodDescriptorProto$Builder;
    }

    @Override
    protected DescriptorProtos$MethodDescriptorProto$Builder newBuilderForType(GeneratedMessage$BuilderParent generatedMessage$BuilderParent) {
        return new DescriptorProtos$MethodDescriptorProto$Builder(generatedMessage$BuilderParent, null);
    }

    public static DescriptorProtos$MethodDescriptorProto getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    @Override
    public Parser getParserForType() {
        return PARSER;
    }

    @Override
    public DescriptorProtos$MethodDescriptorProto getDefaultInstanceForType() {
        return DEFAULT_INSTANCE;
    }

    /* synthetic */ DescriptorProtos$MethodDescriptorProto(GeneratedMessage$Builder generatedMessage$Builder, DescriptorProtos$1 descriptorProtos$1) {
        this(generatedMessage$Builder);
    }

    static /* synthetic */ Object access$12002(DescriptorProtos$MethodDescriptorProto descriptorProtos$MethodDescriptorProto, Object object) {
        descriptorProtos$MethodDescriptorProto.name_ = object;
        return descriptorProtos$MethodDescriptorProto.name_;
    }

    static /* synthetic */ Object access$12102(DescriptorProtos$MethodDescriptorProto descriptorProtos$MethodDescriptorProto, Object object) {
        descriptorProtos$MethodDescriptorProto.inputType_ = object;
        return descriptorProtos$MethodDescriptorProto.inputType_;
    }

    static /* synthetic */ Object access$12202(DescriptorProtos$MethodDescriptorProto descriptorProtos$MethodDescriptorProto, Object object) {
        descriptorProtos$MethodDescriptorProto.outputType_ = object;
        return descriptorProtos$MethodDescriptorProto.outputType_;
    }

    static /* synthetic */ DescriptorProtos$MethodOptions access$12302(DescriptorProtos$MethodDescriptorProto descriptorProtos$MethodDescriptorProto, DescriptorProtos$MethodOptions descriptorProtos$MethodOptions) {
        descriptorProtos$MethodDescriptorProto.options_ = descriptorProtos$MethodOptions;
        return descriptorProtos$MethodDescriptorProto.options_;
    }

    static /* synthetic */ boolean access$12402(DescriptorProtos$MethodDescriptorProto descriptorProtos$MethodDescriptorProto, boolean bl2) {
        descriptorProtos$MethodDescriptorProto.clientStreaming_ = bl2;
        return descriptorProtos$MethodDescriptorProto.clientStreaming_;
    }

    static /* synthetic */ boolean access$12502(DescriptorProtos$MethodDescriptorProto descriptorProtos$MethodDescriptorProto, boolean bl2) {
        descriptorProtos$MethodDescriptorProto.serverStreaming_ = bl2;
        return descriptorProtos$MethodDescriptorProto.serverStreaming_;
    }

    static /* synthetic */ int access$12602(DescriptorProtos$MethodDescriptorProto descriptorProtos$MethodDescriptorProto, int n2) {
        descriptorProtos$MethodDescriptorProto.bitField0_ = n2;
        return descriptorProtos$MethodDescriptorProto.bitField0_;
    }

    static /* synthetic */ Object access$12000(DescriptorProtos$MethodDescriptorProto descriptorProtos$MethodDescriptorProto) {
        return descriptorProtos$MethodDescriptorProto.name_;
    }

    static /* synthetic */ Object access$12100(DescriptorProtos$MethodDescriptorProto descriptorProtos$MethodDescriptorProto) {
        return descriptorProtos$MethodDescriptorProto.inputType_;
    }

    static /* synthetic */ Object access$12200(DescriptorProtos$MethodDescriptorProto descriptorProtos$MethodDescriptorProto) {
        return descriptorProtos$MethodDescriptorProto.outputType_;
    }

    /* synthetic */ DescriptorProtos$MethodDescriptorProto(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite, DescriptorProtos$1 descriptorProtos$1) {
        this(codedInputStream, extensionRegistryLite);
    }
}

