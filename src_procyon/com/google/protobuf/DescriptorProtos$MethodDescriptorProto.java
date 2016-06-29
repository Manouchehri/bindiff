package com.google.protobuf;

import java.io.*;

public final class DescriptorProtos$MethodDescriptorProto extends GeneratedMessage implements DescriptorProtos$MethodDescriptorProtoOrBuilder
{
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
    private byte memoizedIsInitialized;
    private int memoizedSerializedSize;
    private static final long serialVersionUID = 0L;
    private static final DescriptorProtos$MethodDescriptorProto DEFAULT_INSTANCE;
    public static final Parser PARSER;
    
    private DescriptorProtos$MethodDescriptorProto(final GeneratedMessage$Builder generatedMessage$Builder) {
        super(generatedMessage$Builder);
        this.memoizedIsInitialized = -1;
        this.memoizedSerializedSize = -1;
    }
    
    private DescriptorProtos$MethodDescriptorProto() {
        this.memoizedIsInitialized = -1;
        this.memoizedSerializedSize = -1;
        this.name_ = "";
        this.inputType_ = "";
        this.outputType_ = "";
        this.clientStreaming_ = false;
        this.serverStreaming_ = false;
    }
    
    public final UnknownFieldSet getUnknownFields() {
        return this.unknownFields;
    }
    
    private DescriptorProtos$MethodDescriptorProto(final CodedInputStream codedInputStream, final ExtensionRegistryLite extensionRegistryLite) {
        this();
        final UnknownFieldSet$Builder builder = UnknownFieldSet.newBuilder();
        try {
            int i = 0;
            while (i == 0) {
                final int tag = codedInputStream.readTag();
                switch (tag) {
                    case 0: {
                        i = 1;
                        continue;
                    }
                    default: {
                        if (!this.parseUnknownField(codedInputStream, builder, extensionRegistryLite, tag)) {
                            i = 1;
                            continue;
                        }
                        continue;
                    }
                    case 10: {
                        final ByteString bytes = codedInputStream.readBytes();
                        this.bitField0_ |= 0x1;
                        this.name_ = bytes;
                        continue;
                    }
                    case 18: {
                        final ByteString bytes2 = codedInputStream.readBytes();
                        this.bitField0_ |= 0x2;
                        this.inputType_ = bytes2;
                        continue;
                    }
                    case 26: {
                        final ByteString bytes3 = codedInputStream.readBytes();
                        this.bitField0_ |= 0x4;
                        this.outputType_ = bytes3;
                        continue;
                    }
                    case 34: {
                        DescriptorProtos$MethodOptions$Builder builder2 = null;
                        if ((this.bitField0_ & 0x8) == 0x8) {
                            builder2 = this.options_.toBuilder();
                        }
                        this.options_ = (DescriptorProtos$MethodOptions)codedInputStream.readMessage(DescriptorProtos$MethodOptions.PARSER, extensionRegistryLite);
                        if (builder2 != null) {
                            builder2.mergeFrom(this.options_);
                            this.options_ = builder2.buildPartial();
                        }
                        this.bitField0_ |= 0x8;
                        continue;
                    }
                    case 40: {
                        this.bitField0_ |= 0x10;
                        this.clientStreaming_ = codedInputStream.readBool();
                        continue;
                    }
                    case 48: {
                        this.bitField0_ |= 0x20;
                        this.serverStreaming_ = codedInputStream.readBool();
                        continue;
                    }
                }
            }
        }
        catch (InvalidProtocolBufferException ex) {
            throw new RuntimeException(ex.setUnfinishedMessage(this));
        }
        catch (IOException ex2) {
            throw new RuntimeException(new InvalidProtocolBufferException(ex2.getMessage()).setUnfinishedMessage(this));
        }
        finally {
            this.unknownFields = builder.build();
            this.makeExtensionsImmutable();
        }
    }
    
    public static final Descriptors$Descriptor getDescriptor() {
        return DescriptorProtos.internal_static_google_protobuf_MethodDescriptorProto_descriptor;
    }
    
    protected GeneratedMessage$FieldAccessorTable internalGetFieldAccessorTable() {
        return DescriptorProtos.internal_static_google_protobuf_MethodDescriptorProto_fieldAccessorTable.ensureFieldAccessorsInitialized(DescriptorProtos$MethodDescriptorProto.class, DescriptorProtos$MethodDescriptorProto$Builder.class);
    }
    
    public boolean hasName() {
        return (this.bitField0_ & 0x1) == 0x1;
    }
    
    public String getName() {
        final Object name_ = this.name_;
        if (name_ instanceof String) {
            return (String)name_;
        }
        final ByteString byteString = (ByteString)name_;
        final String stringUtf8 = byteString.toStringUtf8();
        if (byteString.isValidUtf8()) {
            this.name_ = stringUtf8;
        }
        return stringUtf8;
    }
    
    public ByteString getNameBytes() {
        final Object name_ = this.name_;
        if (name_ instanceof String) {
            return (ByteString)(this.name_ = ByteString.copyFromUtf8((String)name_));
        }
        return (ByteString)name_;
    }
    
    public boolean hasInputType() {
        return (this.bitField0_ & 0x2) == 0x2;
    }
    
    public String getInputType() {
        final Object inputType_ = this.inputType_;
        if (inputType_ instanceof String) {
            return (String)inputType_;
        }
        final ByteString byteString = (ByteString)inputType_;
        final String stringUtf8 = byteString.toStringUtf8();
        if (byteString.isValidUtf8()) {
            this.inputType_ = stringUtf8;
        }
        return stringUtf8;
    }
    
    public ByteString getInputTypeBytes() {
        final Object inputType_ = this.inputType_;
        if (inputType_ instanceof String) {
            return (ByteString)(this.inputType_ = ByteString.copyFromUtf8((String)inputType_));
        }
        return (ByteString)inputType_;
    }
    
    public boolean hasOutputType() {
        return (this.bitField0_ & 0x4) == 0x4;
    }
    
    public String getOutputType() {
        final Object outputType_ = this.outputType_;
        if (outputType_ instanceof String) {
            return (String)outputType_;
        }
        final ByteString byteString = (ByteString)outputType_;
        final String stringUtf8 = byteString.toStringUtf8();
        if (byteString.isValidUtf8()) {
            this.outputType_ = stringUtf8;
        }
        return stringUtf8;
    }
    
    public ByteString getOutputTypeBytes() {
        final Object outputType_ = this.outputType_;
        if (outputType_ instanceof String) {
            return (ByteString)(this.outputType_ = ByteString.copyFromUtf8((String)outputType_));
        }
        return (ByteString)outputType_;
    }
    
    public boolean hasOptions() {
        return (this.bitField0_ & 0x8) == 0x8;
    }
    
    public DescriptorProtos$MethodOptions getOptions() {
        return (this.options_ == null) ? DescriptorProtos$MethodOptions.getDefaultInstance() : this.options_;
    }
    
    public DescriptorProtos$MethodOptionsOrBuilder getOptionsOrBuilder() {
        return (this.options_ == null) ? DescriptorProtos$MethodOptions.getDefaultInstance() : this.options_;
    }
    
    public boolean hasClientStreaming() {
        return (this.bitField0_ & 0x10) == 0x10;
    }
    
    public boolean getClientStreaming() {
        return this.clientStreaming_;
    }
    
    public boolean hasServerStreaming() {
        return (this.bitField0_ & 0x20) == 0x20;
    }
    
    public boolean getServerStreaming() {
        return this.serverStreaming_;
    }
    
    public final boolean isInitialized() {
        final byte memoizedIsInitialized = this.memoizedIsInitialized;
        if (memoizedIsInitialized == 1) {
            return true;
        }
        if (memoizedIsInitialized == 0) {
            return false;
        }
        if (this.hasOptions() && !this.getOptions().isInitialized()) {
            this.memoizedIsInitialized = 0;
            return false;
        }
        this.memoizedIsInitialized = 1;
        return true;
    }
    
    public void writeTo(final CodedOutputStream codedOutputStream) {
        if ((this.bitField0_ & 0x1) == 0x1) {
            codedOutputStream.writeBytes(1, this.getNameBytes());
        }
        if ((this.bitField0_ & 0x2) == 0x2) {
            codedOutputStream.writeBytes(2, this.getInputTypeBytes());
        }
        if ((this.bitField0_ & 0x4) == 0x4) {
            codedOutputStream.writeBytes(3, this.getOutputTypeBytes());
        }
        if ((this.bitField0_ & 0x8) == 0x8) {
            codedOutputStream.writeMessage(4, this.getOptions());
        }
        if ((this.bitField0_ & 0x10) == 0x10) {
            codedOutputStream.writeBool(5, this.clientStreaming_);
        }
        if ((this.bitField0_ & 0x20) == 0x20) {
            codedOutputStream.writeBool(6, this.serverStreaming_);
        }
        this.unknownFields.writeTo(codedOutputStream);
    }
    
    public int getSerializedSize() {
        final int memoizedSerializedSize = this.memoizedSerializedSize;
        if (memoizedSerializedSize != -1) {
            return memoizedSerializedSize;
        }
        int n = 0;
        if ((this.bitField0_ & 0x1) == 0x1) {
            n += CodedOutputStream.computeBytesSize(1, this.getNameBytes());
        }
        if ((this.bitField0_ & 0x2) == 0x2) {
            n += CodedOutputStream.computeBytesSize(2, this.getInputTypeBytes());
        }
        if ((this.bitField0_ & 0x4) == 0x4) {
            n += CodedOutputStream.computeBytesSize(3, this.getOutputTypeBytes());
        }
        if ((this.bitField0_ & 0x8) == 0x8) {
            n += CodedOutputStream.computeMessageSize(4, this.getOptions());
        }
        if ((this.bitField0_ & 0x10) == 0x10) {
            n += CodedOutputStream.computeBoolSize(5, this.clientStreaming_);
        }
        if ((this.bitField0_ & 0x20) == 0x20) {
            n += CodedOutputStream.computeBoolSize(6, this.serverStreaming_);
        }
        return this.memoizedSerializedSize = n + this.unknownFields.getSerializedSize();
    }
    
    public static DescriptorProtos$MethodDescriptorProto parseFrom(final ByteString byteString) {
        return (DescriptorProtos$MethodDescriptorProto)DescriptorProtos$MethodDescriptorProto.PARSER.parseFrom(byteString);
    }
    
    public static DescriptorProtos$MethodDescriptorProto parseFrom(final ByteString byteString, final ExtensionRegistryLite extensionRegistryLite) {
        return (DescriptorProtos$MethodDescriptorProto)DescriptorProtos$MethodDescriptorProto.PARSER.parseFrom(byteString, extensionRegistryLite);
    }
    
    public static DescriptorProtos$MethodDescriptorProto parseFrom(final byte[] array) {
        return (DescriptorProtos$MethodDescriptorProto)DescriptorProtos$MethodDescriptorProto.PARSER.parseFrom(array);
    }
    
    public static DescriptorProtos$MethodDescriptorProto parseFrom(final byte[] array, final ExtensionRegistryLite extensionRegistryLite) {
        return (DescriptorProtos$MethodDescriptorProto)DescriptorProtos$MethodDescriptorProto.PARSER.parseFrom(array, extensionRegistryLite);
    }
    
    public static DescriptorProtos$MethodDescriptorProto parseFrom(final InputStream inputStream) {
        return (DescriptorProtos$MethodDescriptorProto)DescriptorProtos$MethodDescriptorProto.PARSER.parseFrom(inputStream);
    }
    
    public static DescriptorProtos$MethodDescriptorProto parseFrom(final InputStream inputStream, final ExtensionRegistryLite extensionRegistryLite) {
        return (DescriptorProtos$MethodDescriptorProto)DescriptorProtos$MethodDescriptorProto.PARSER.parseFrom(inputStream, extensionRegistryLite);
    }
    
    public static DescriptorProtos$MethodDescriptorProto parseDelimitedFrom(final InputStream inputStream) {
        return (DescriptorProtos$MethodDescriptorProto)DescriptorProtos$MethodDescriptorProto.PARSER.parseDelimitedFrom(inputStream);
    }
    
    public static DescriptorProtos$MethodDescriptorProto parseDelimitedFrom(final InputStream inputStream, final ExtensionRegistryLite extensionRegistryLite) {
        return (DescriptorProtos$MethodDescriptorProto)DescriptorProtos$MethodDescriptorProto.PARSER.parseDelimitedFrom(inputStream, extensionRegistryLite);
    }
    
    public static DescriptorProtos$MethodDescriptorProto parseFrom(final CodedInputStream codedInputStream) {
        return (DescriptorProtos$MethodDescriptorProto)DescriptorProtos$MethodDescriptorProto.PARSER.parseFrom(codedInputStream);
    }
    
    public static DescriptorProtos$MethodDescriptorProto parseFrom(final CodedInputStream codedInputStream, final ExtensionRegistryLite extensionRegistryLite) {
        return (DescriptorProtos$MethodDescriptorProto)DescriptorProtos$MethodDescriptorProto.PARSER.parseFrom(codedInputStream, extensionRegistryLite);
    }
    
    public DescriptorProtos$MethodDescriptorProto$Builder newBuilderForType() {
        return newBuilder();
    }
    
    public static DescriptorProtos$MethodDescriptorProto$Builder newBuilder() {
        return DescriptorProtos$MethodDescriptorProto.DEFAULT_INSTANCE.toBuilder();
    }
    
    public static DescriptorProtos$MethodDescriptorProto$Builder newBuilder(final DescriptorProtos$MethodDescriptorProto descriptorProtos$MethodDescriptorProto) {
        return DescriptorProtos$MethodDescriptorProto.DEFAULT_INSTANCE.toBuilder().mergeFrom(descriptorProtos$MethodDescriptorProto);
    }
    
    public DescriptorProtos$MethodDescriptorProto$Builder toBuilder() {
        return (this == DescriptorProtos$MethodDescriptorProto.DEFAULT_INSTANCE) ? new DescriptorProtos$MethodDescriptorProto$Builder((DescriptorProtos$1)null) : new DescriptorProtos$MethodDescriptorProto$Builder((DescriptorProtos$1)null).mergeFrom(this);
    }
    
    protected DescriptorProtos$MethodDescriptorProto$Builder newBuilderForType(final GeneratedMessage$BuilderParent generatedMessage$BuilderParent) {
        return new DescriptorProtos$MethodDescriptorProto$Builder(generatedMessage$BuilderParent, null);
    }
    
    public static DescriptorProtos$MethodDescriptorProto getDefaultInstance() {
        return DescriptorProtos$MethodDescriptorProto.DEFAULT_INSTANCE;
    }
    
    public Parser getParserForType() {
        return DescriptorProtos$MethodDescriptorProto.PARSER;
    }
    
    public DescriptorProtos$MethodDescriptorProto getDefaultInstanceForType() {
        return DescriptorProtos$MethodDescriptorProto.DEFAULT_INSTANCE;
    }
    
    static {
        DEFAULT_INSTANCE = new DescriptorProtos$MethodDescriptorProto();
        PARSER = new DescriptorProtos$MethodDescriptorProto$1();
    }
}
