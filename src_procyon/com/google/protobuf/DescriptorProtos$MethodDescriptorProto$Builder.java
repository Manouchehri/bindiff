package com.google.protobuf;

import java.io.*;

public final class DescriptorProtos$MethodDescriptorProto$Builder extends GeneratedMessage$Builder implements DescriptorProtos$MethodDescriptorProtoOrBuilder
{
    private int bitField0_;
    private Object name_;
    private Object inputType_;
    private Object outputType_;
    private DescriptorProtos$MethodOptions options_;
    private SingleFieldBuilder optionsBuilder_;
    private boolean clientStreaming_;
    private boolean serverStreaming_;
    
    public static final Descriptors$Descriptor getDescriptor() {
        return DescriptorProtos.internal_static_google_protobuf_MethodDescriptorProto_descriptor;
    }
    
    protected GeneratedMessage$FieldAccessorTable internalGetFieldAccessorTable() {
        return DescriptorProtos.internal_static_google_protobuf_MethodDescriptorProto_fieldAccessorTable.ensureFieldAccessorsInitialized(DescriptorProtos$MethodDescriptorProto.class, DescriptorProtos$MethodDescriptorProto$Builder.class);
    }
    
    private DescriptorProtos$MethodDescriptorProto$Builder() {
        this.name_ = "";
        this.inputType_ = "";
        this.outputType_ = "";
        this.options_ = null;
        this.maybeForceBuilderInitialization();
    }
    
    private DescriptorProtos$MethodDescriptorProto$Builder(final GeneratedMessage$BuilderParent generatedMessage$BuilderParent) {
        super(generatedMessage$BuilderParent);
        this.name_ = "";
        this.inputType_ = "";
        this.outputType_ = "";
        this.options_ = null;
        this.maybeForceBuilderInitialization();
    }
    
    private void maybeForceBuilderInitialization() {
        if (GeneratedMessage.alwaysUseFieldBuilders) {
            this.getOptionsFieldBuilder();
        }
    }
    
    public DescriptorProtos$MethodDescriptorProto$Builder clear() {
        super.clear();
        this.name_ = "";
        this.bitField0_ &= 0xFFFFFFFE;
        this.inputType_ = "";
        this.bitField0_ &= 0xFFFFFFFD;
        this.outputType_ = "";
        this.bitField0_ &= 0xFFFFFFFB;
        if (this.optionsBuilder_ == null) {
            this.options_ = null;
        }
        else {
            this.optionsBuilder_.clear();
        }
        this.bitField0_ &= 0xFFFFFFF7;
        this.clientStreaming_ = false;
        this.bitField0_ &= 0xFFFFFFEF;
        this.serverStreaming_ = false;
        this.bitField0_ &= 0xFFFFFFDF;
        return this;
    }
    
    public Descriptors$Descriptor getDescriptorForType() {
        return DescriptorProtos.internal_static_google_protobuf_MethodDescriptorProto_descriptor;
    }
    
    public DescriptorProtos$MethodDescriptorProto getDefaultInstanceForType() {
        return DescriptorProtos$MethodDescriptorProto.getDefaultInstance();
    }
    
    public DescriptorProtos$MethodDescriptorProto build() {
        final DescriptorProtos$MethodDescriptorProto buildPartial = this.buildPartial();
        if (!buildPartial.isInitialized()) {
            throw AbstractMessage$Builder.newUninitializedMessageException(buildPartial);
        }
        return buildPartial;
    }
    
    public DescriptorProtos$MethodDescriptorProto buildPartial() {
        final DescriptorProtos$MethodDescriptorProto descriptorProtos$MethodDescriptorProto = new DescriptorProtos$MethodDescriptorProto(this, null);
        final int bitField0_ = this.bitField0_;
        int n = 0;
        if ((bitField0_ & 0x1) == 0x1) {
            n |= 0x1;
        }
        descriptorProtos$MethodDescriptorProto.name_ = this.name_;
        if ((bitField0_ & 0x2) == 0x2) {
            n |= 0x2;
        }
        descriptorProtos$MethodDescriptorProto.inputType_ = this.inputType_;
        if ((bitField0_ & 0x4) == 0x4) {
            n |= 0x4;
        }
        descriptorProtos$MethodDescriptorProto.outputType_ = this.outputType_;
        if ((bitField0_ & 0x8) == 0x8) {
            n |= 0x8;
        }
        if (this.optionsBuilder_ == null) {
            descriptorProtos$MethodDescriptorProto.options_ = this.options_;
        }
        else {
            descriptorProtos$MethodDescriptorProto.options_ = (DescriptorProtos$MethodOptions)this.optionsBuilder_.build();
        }
        if ((bitField0_ & 0x10) == 0x10) {
            n |= 0x10;
        }
        descriptorProtos$MethodDescriptorProto.clientStreaming_ = this.clientStreaming_;
        if ((bitField0_ & 0x20) == 0x20) {
            n |= 0x20;
        }
        descriptorProtos$MethodDescriptorProto.serverStreaming_ = this.serverStreaming_;
        descriptorProtos$MethodDescriptorProto.bitField0_ = n;
        this.onBuilt();
        return descriptorProtos$MethodDescriptorProto;
    }
    
    public DescriptorProtos$MethodDescriptorProto$Builder mergeFrom(final Message message) {
        if (message instanceof DescriptorProtos$MethodDescriptorProto) {
            return this.mergeFrom((DescriptorProtos$MethodDescriptorProto)message);
        }
        super.mergeFrom(message);
        return this;
    }
    
    public DescriptorProtos$MethodDescriptorProto$Builder mergeFrom(final DescriptorProtos$MethodDescriptorProto descriptorProtos$MethodDescriptorProto) {
        if (descriptorProtos$MethodDescriptorProto == DescriptorProtos$MethodDescriptorProto.getDefaultInstance()) {
            return this;
        }
        if (descriptorProtos$MethodDescriptorProto.hasName()) {
            this.bitField0_ |= 0x1;
            this.name_ = descriptorProtos$MethodDescriptorProto.name_;
            this.onChanged();
        }
        if (descriptorProtos$MethodDescriptorProto.hasInputType()) {
            this.bitField0_ |= 0x2;
            this.inputType_ = descriptorProtos$MethodDescriptorProto.inputType_;
            this.onChanged();
        }
        if (descriptorProtos$MethodDescriptorProto.hasOutputType()) {
            this.bitField0_ |= 0x4;
            this.outputType_ = descriptorProtos$MethodDescriptorProto.outputType_;
            this.onChanged();
        }
        if (descriptorProtos$MethodDescriptorProto.hasOptions()) {
            this.mergeOptions(descriptorProtos$MethodDescriptorProto.getOptions());
        }
        if (descriptorProtos$MethodDescriptorProto.hasClientStreaming()) {
            this.setClientStreaming(descriptorProtos$MethodDescriptorProto.getClientStreaming());
        }
        if (descriptorProtos$MethodDescriptorProto.hasServerStreaming()) {
            this.setServerStreaming(descriptorProtos$MethodDescriptorProto.getServerStreaming());
        }
        this.mergeUnknownFields(descriptorProtos$MethodDescriptorProto.unknownFields);
        this.onChanged();
        return this;
    }
    
    public final boolean isInitialized() {
        return !this.hasOptions() || this.getOptions().isInitialized();
    }
    
    public DescriptorProtos$MethodDescriptorProto$Builder mergeFrom(final CodedInputStream codedInputStream, final ExtensionRegistryLite extensionRegistryLite) {
        DescriptorProtos$MethodDescriptorProto descriptorProtos$MethodDescriptorProto = null;
        try {
            descriptorProtos$MethodDescriptorProto = (DescriptorProtos$MethodDescriptorProto)DescriptorProtos$MethodDescriptorProto.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
        }
        catch (InvalidProtocolBufferException ex) {
            descriptorProtos$MethodDescriptorProto = (DescriptorProtos$MethodDescriptorProto)ex.getUnfinishedMessage();
            throw ex;
        }
        finally {
            if (descriptorProtos$MethodDescriptorProto != null) {
                this.mergeFrom(descriptorProtos$MethodDescriptorProto);
            }
        }
        return this;
    }
    
    public boolean hasName() {
        return (this.bitField0_ & 0x1) == 0x1;
    }
    
    public String getName() {
        final Object name_ = this.name_;
        if (!(name_ instanceof String)) {
            final ByteString byteString = (ByteString)name_;
            final String stringUtf8 = byteString.toStringUtf8();
            if (byteString.isValidUtf8()) {
                this.name_ = stringUtf8;
            }
            return stringUtf8;
        }
        return (String)name_;
    }
    
    public ByteString getNameBytes() {
        final Object name_ = this.name_;
        if (name_ instanceof String) {
            return (ByteString)(this.name_ = ByteString.copyFromUtf8((String)name_));
        }
        return (ByteString)name_;
    }
    
    public DescriptorProtos$MethodDescriptorProto$Builder setName(final String name_) {
        if (name_ == null) {
            throw new NullPointerException();
        }
        this.bitField0_ |= 0x1;
        this.name_ = name_;
        this.onChanged();
        return this;
    }
    
    public DescriptorProtos$MethodDescriptorProto$Builder clearName() {
        this.bitField0_ &= 0xFFFFFFFE;
        this.name_ = DescriptorProtos$MethodDescriptorProto.getDefaultInstance().getName();
        this.onChanged();
        return this;
    }
    
    public DescriptorProtos$MethodDescriptorProto$Builder setNameBytes(final ByteString name_) {
        if (name_ == null) {
            throw new NullPointerException();
        }
        this.bitField0_ |= 0x1;
        this.name_ = name_;
        this.onChanged();
        return this;
    }
    
    public boolean hasInputType() {
        return (this.bitField0_ & 0x2) == 0x2;
    }
    
    public String getInputType() {
        final Object inputType_ = this.inputType_;
        if (!(inputType_ instanceof String)) {
            final ByteString byteString = (ByteString)inputType_;
            final String stringUtf8 = byteString.toStringUtf8();
            if (byteString.isValidUtf8()) {
                this.inputType_ = stringUtf8;
            }
            return stringUtf8;
        }
        return (String)inputType_;
    }
    
    public ByteString getInputTypeBytes() {
        final Object inputType_ = this.inputType_;
        if (inputType_ instanceof String) {
            return (ByteString)(this.inputType_ = ByteString.copyFromUtf8((String)inputType_));
        }
        return (ByteString)inputType_;
    }
    
    public DescriptorProtos$MethodDescriptorProto$Builder setInputType(final String inputType_) {
        if (inputType_ == null) {
            throw new NullPointerException();
        }
        this.bitField0_ |= 0x2;
        this.inputType_ = inputType_;
        this.onChanged();
        return this;
    }
    
    public DescriptorProtos$MethodDescriptorProto$Builder clearInputType() {
        this.bitField0_ &= 0xFFFFFFFD;
        this.inputType_ = DescriptorProtos$MethodDescriptorProto.getDefaultInstance().getInputType();
        this.onChanged();
        return this;
    }
    
    public DescriptorProtos$MethodDescriptorProto$Builder setInputTypeBytes(final ByteString inputType_) {
        if (inputType_ == null) {
            throw new NullPointerException();
        }
        this.bitField0_ |= 0x2;
        this.inputType_ = inputType_;
        this.onChanged();
        return this;
    }
    
    public boolean hasOutputType() {
        return (this.bitField0_ & 0x4) == 0x4;
    }
    
    public String getOutputType() {
        final Object outputType_ = this.outputType_;
        if (!(outputType_ instanceof String)) {
            final ByteString byteString = (ByteString)outputType_;
            final String stringUtf8 = byteString.toStringUtf8();
            if (byteString.isValidUtf8()) {
                this.outputType_ = stringUtf8;
            }
            return stringUtf8;
        }
        return (String)outputType_;
    }
    
    public ByteString getOutputTypeBytes() {
        final Object outputType_ = this.outputType_;
        if (outputType_ instanceof String) {
            return (ByteString)(this.outputType_ = ByteString.copyFromUtf8((String)outputType_));
        }
        return (ByteString)outputType_;
    }
    
    public DescriptorProtos$MethodDescriptorProto$Builder setOutputType(final String outputType_) {
        if (outputType_ == null) {
            throw new NullPointerException();
        }
        this.bitField0_ |= 0x4;
        this.outputType_ = outputType_;
        this.onChanged();
        return this;
    }
    
    public DescriptorProtos$MethodDescriptorProto$Builder clearOutputType() {
        this.bitField0_ &= 0xFFFFFFFB;
        this.outputType_ = DescriptorProtos$MethodDescriptorProto.getDefaultInstance().getOutputType();
        this.onChanged();
        return this;
    }
    
    public DescriptorProtos$MethodDescriptorProto$Builder setOutputTypeBytes(final ByteString outputType_) {
        if (outputType_ == null) {
            throw new NullPointerException();
        }
        this.bitField0_ |= 0x4;
        this.outputType_ = outputType_;
        this.onChanged();
        return this;
    }
    
    public boolean hasOptions() {
        return (this.bitField0_ & 0x8) == 0x8;
    }
    
    public DescriptorProtos$MethodOptions getOptions() {
        if (this.optionsBuilder_ == null) {
            return (this.options_ == null) ? DescriptorProtos$MethodOptions.getDefaultInstance() : this.options_;
        }
        return (DescriptorProtos$MethodOptions)this.optionsBuilder_.getMessage();
    }
    
    public DescriptorProtos$MethodDescriptorProto$Builder setOptions(final DescriptorProtos$MethodOptions descriptorProtos$MethodOptions) {
        if (this.optionsBuilder_ == null) {
            if (descriptorProtos$MethodOptions == null) {
                throw new NullPointerException();
            }
            this.options_ = descriptorProtos$MethodOptions;
            this.onChanged();
        }
        else {
            this.optionsBuilder_.setMessage(descriptorProtos$MethodOptions);
        }
        this.bitField0_ |= 0x8;
        return this;
    }
    
    public DescriptorProtos$MethodDescriptorProto$Builder setOptions(final DescriptorProtos$MethodOptions$Builder descriptorProtos$MethodOptions$Builder) {
        if (this.optionsBuilder_ == null) {
            this.options_ = descriptorProtos$MethodOptions$Builder.build();
            this.onChanged();
        }
        else {
            this.optionsBuilder_.setMessage(descriptorProtos$MethodOptions$Builder.build());
        }
        this.bitField0_ |= 0x8;
        return this;
    }
    
    public DescriptorProtos$MethodDescriptorProto$Builder mergeOptions(final DescriptorProtos$MethodOptions options_) {
        if (this.optionsBuilder_ == null) {
            if ((this.bitField0_ & 0x8) == 0x8 && this.options_ != null && this.options_ != DescriptorProtos$MethodOptions.getDefaultInstance()) {
                this.options_ = DescriptorProtos$MethodOptions.newBuilder(this.options_).mergeFrom(options_).buildPartial();
            }
            else {
                this.options_ = options_;
            }
            this.onChanged();
        }
        else {
            this.optionsBuilder_.mergeFrom(options_);
        }
        this.bitField0_ |= 0x8;
        return this;
    }
    
    public DescriptorProtos$MethodDescriptorProto$Builder clearOptions() {
        if (this.optionsBuilder_ == null) {
            this.options_ = null;
            this.onChanged();
        }
        else {
            this.optionsBuilder_.clear();
        }
        this.bitField0_ &= 0xFFFFFFF7;
        return this;
    }
    
    public DescriptorProtos$MethodOptions$Builder getOptionsBuilder() {
        this.bitField0_ |= 0x8;
        this.onChanged();
        return (DescriptorProtos$MethodOptions$Builder)this.getOptionsFieldBuilder().getBuilder();
    }
    
    public DescriptorProtos$MethodOptionsOrBuilder getOptionsOrBuilder() {
        if (this.optionsBuilder_ != null) {
            return (DescriptorProtos$MethodOptionsOrBuilder)this.optionsBuilder_.getMessageOrBuilder();
        }
        return (this.options_ == null) ? DescriptorProtos$MethodOptions.getDefaultInstance() : this.options_;
    }
    
    private SingleFieldBuilder getOptionsFieldBuilder() {
        if (this.optionsBuilder_ == null) {
            this.optionsBuilder_ = new SingleFieldBuilder(this.getOptions(), this.getParentForChildren(), this.isClean());
            this.options_ = null;
        }
        return this.optionsBuilder_;
    }
    
    public boolean hasClientStreaming() {
        return (this.bitField0_ & 0x10) == 0x10;
    }
    
    public boolean getClientStreaming() {
        return this.clientStreaming_;
    }
    
    public DescriptorProtos$MethodDescriptorProto$Builder setClientStreaming(final boolean clientStreaming_) {
        this.bitField0_ |= 0x10;
        this.clientStreaming_ = clientStreaming_;
        this.onChanged();
        return this;
    }
    
    public DescriptorProtos$MethodDescriptorProto$Builder clearClientStreaming() {
        this.bitField0_ &= 0xFFFFFFEF;
        this.clientStreaming_ = false;
        this.onChanged();
        return this;
    }
    
    public boolean hasServerStreaming() {
        return (this.bitField0_ & 0x20) == 0x20;
    }
    
    public boolean getServerStreaming() {
        return this.serverStreaming_;
    }
    
    public DescriptorProtos$MethodDescriptorProto$Builder setServerStreaming(final boolean serverStreaming_) {
        this.bitField0_ |= 0x20;
        this.serverStreaming_ = serverStreaming_;
        this.onChanged();
        return this;
    }
    
    public DescriptorProtos$MethodDescriptorProto$Builder clearServerStreaming() {
        this.bitField0_ &= 0xFFFFFFDF;
        this.serverStreaming_ = false;
        this.onChanged();
        return this;
    }
}
