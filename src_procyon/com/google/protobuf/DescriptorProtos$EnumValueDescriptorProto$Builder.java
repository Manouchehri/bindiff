package com.google.protobuf;

import java.io.*;

public final class DescriptorProtos$EnumValueDescriptorProto$Builder extends GeneratedMessage$Builder implements DescriptorProtos$EnumValueDescriptorProtoOrBuilder
{
    private int bitField0_;
    private Object name_;
    private int number_;
    private DescriptorProtos$EnumValueOptions options_;
    private SingleFieldBuilder optionsBuilder_;
    
    public static final Descriptors$Descriptor getDescriptor() {
        return DescriptorProtos.internal_static_google_protobuf_EnumValueDescriptorProto_descriptor;
    }
    
    protected GeneratedMessage$FieldAccessorTable internalGetFieldAccessorTable() {
        return DescriptorProtos.internal_static_google_protobuf_EnumValueDescriptorProto_fieldAccessorTable.ensureFieldAccessorsInitialized(DescriptorProtos$EnumValueDescriptorProto.class, DescriptorProtos$EnumValueDescriptorProto$Builder.class);
    }
    
    private DescriptorProtos$EnumValueDescriptorProto$Builder() {
        this.name_ = "";
        this.options_ = null;
        this.maybeForceBuilderInitialization();
    }
    
    private DescriptorProtos$EnumValueDescriptorProto$Builder(final GeneratedMessage$BuilderParent generatedMessage$BuilderParent) {
        super(generatedMessage$BuilderParent);
        this.name_ = "";
        this.options_ = null;
        this.maybeForceBuilderInitialization();
    }
    
    private void maybeForceBuilderInitialization() {
        if (GeneratedMessage.alwaysUseFieldBuilders) {
            this.getOptionsFieldBuilder();
        }
    }
    
    public DescriptorProtos$EnumValueDescriptorProto$Builder clear() {
        super.clear();
        this.name_ = "";
        this.bitField0_ &= 0xFFFFFFFE;
        this.number_ = 0;
        this.bitField0_ &= 0xFFFFFFFD;
        if (this.optionsBuilder_ == null) {
            this.options_ = null;
        }
        else {
            this.optionsBuilder_.clear();
        }
        this.bitField0_ &= 0xFFFFFFFB;
        return this;
    }
    
    public Descriptors$Descriptor getDescriptorForType() {
        return DescriptorProtos.internal_static_google_protobuf_EnumValueDescriptorProto_descriptor;
    }
    
    public DescriptorProtos$EnumValueDescriptorProto getDefaultInstanceForType() {
        return DescriptorProtos$EnumValueDescriptorProto.getDefaultInstance();
    }
    
    public DescriptorProtos$EnumValueDescriptorProto build() {
        final DescriptorProtos$EnumValueDescriptorProto buildPartial = this.buildPartial();
        if (!buildPartial.isInitialized()) {
            throw AbstractMessage$Builder.newUninitializedMessageException(buildPartial);
        }
        return buildPartial;
    }
    
    public DescriptorProtos$EnumValueDescriptorProto buildPartial() {
        final DescriptorProtos$EnumValueDescriptorProto descriptorProtos$EnumValueDescriptorProto = new DescriptorProtos$EnumValueDescriptorProto(this, null);
        final int bitField0_ = this.bitField0_;
        int n = 0;
        if ((bitField0_ & 0x1) == 0x1) {
            n |= 0x1;
        }
        descriptorProtos$EnumValueDescriptorProto.name_ = this.name_;
        if ((bitField0_ & 0x2) == 0x2) {
            n |= 0x2;
        }
        descriptorProtos$EnumValueDescriptorProto.number_ = this.number_;
        if ((bitField0_ & 0x4) == 0x4) {
            n |= 0x4;
        }
        if (this.optionsBuilder_ == null) {
            descriptorProtos$EnumValueDescriptorProto.options_ = this.options_;
        }
        else {
            descriptorProtos$EnumValueDescriptorProto.options_ = (DescriptorProtos$EnumValueOptions)this.optionsBuilder_.build();
        }
        descriptorProtos$EnumValueDescriptorProto.bitField0_ = n;
        this.onBuilt();
        return descriptorProtos$EnumValueDescriptorProto;
    }
    
    public DescriptorProtos$EnumValueDescriptorProto$Builder mergeFrom(final Message message) {
        if (message instanceof DescriptorProtos$EnumValueDescriptorProto) {
            return this.mergeFrom((DescriptorProtos$EnumValueDescriptorProto)message);
        }
        super.mergeFrom(message);
        return this;
    }
    
    public DescriptorProtos$EnumValueDescriptorProto$Builder mergeFrom(final DescriptorProtos$EnumValueDescriptorProto descriptorProtos$EnumValueDescriptorProto) {
        if (descriptorProtos$EnumValueDescriptorProto == DescriptorProtos$EnumValueDescriptorProto.getDefaultInstance()) {
            return this;
        }
        if (descriptorProtos$EnumValueDescriptorProto.hasName()) {
            this.bitField0_ |= 0x1;
            this.name_ = descriptorProtos$EnumValueDescriptorProto.name_;
            this.onChanged();
        }
        if (descriptorProtos$EnumValueDescriptorProto.hasNumber()) {
            this.setNumber(descriptorProtos$EnumValueDescriptorProto.getNumber());
        }
        if (descriptorProtos$EnumValueDescriptorProto.hasOptions()) {
            this.mergeOptions(descriptorProtos$EnumValueDescriptorProto.getOptions());
        }
        this.mergeUnknownFields(descriptorProtos$EnumValueDescriptorProto.unknownFields);
        this.onChanged();
        return this;
    }
    
    public final boolean isInitialized() {
        return !this.hasOptions() || this.getOptions().isInitialized();
    }
    
    public DescriptorProtos$EnumValueDescriptorProto$Builder mergeFrom(final CodedInputStream codedInputStream, final ExtensionRegistryLite extensionRegistryLite) {
        DescriptorProtos$EnumValueDescriptorProto descriptorProtos$EnumValueDescriptorProto = null;
        try {
            descriptorProtos$EnumValueDescriptorProto = (DescriptorProtos$EnumValueDescriptorProto)DescriptorProtos$EnumValueDescriptorProto.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
        }
        catch (InvalidProtocolBufferException ex) {
            descriptorProtos$EnumValueDescriptorProto = (DescriptorProtos$EnumValueDescriptorProto)ex.getUnfinishedMessage();
            throw ex;
        }
        finally {
            if (descriptorProtos$EnumValueDescriptorProto != null) {
                this.mergeFrom(descriptorProtos$EnumValueDescriptorProto);
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
    
    public DescriptorProtos$EnumValueDescriptorProto$Builder setName(final String name_) {
        if (name_ == null) {
            throw new NullPointerException();
        }
        this.bitField0_ |= 0x1;
        this.name_ = name_;
        this.onChanged();
        return this;
    }
    
    public DescriptorProtos$EnumValueDescriptorProto$Builder clearName() {
        this.bitField0_ &= 0xFFFFFFFE;
        this.name_ = DescriptorProtos$EnumValueDescriptorProto.getDefaultInstance().getName();
        this.onChanged();
        return this;
    }
    
    public DescriptorProtos$EnumValueDescriptorProto$Builder setNameBytes(final ByteString name_) {
        if (name_ == null) {
            throw new NullPointerException();
        }
        this.bitField0_ |= 0x1;
        this.name_ = name_;
        this.onChanged();
        return this;
    }
    
    public boolean hasNumber() {
        return (this.bitField0_ & 0x2) == 0x2;
    }
    
    public int getNumber() {
        return this.number_;
    }
    
    public DescriptorProtos$EnumValueDescriptorProto$Builder setNumber(final int number_) {
        this.bitField0_ |= 0x2;
        this.number_ = number_;
        this.onChanged();
        return this;
    }
    
    public DescriptorProtos$EnumValueDescriptorProto$Builder clearNumber() {
        this.bitField0_ &= 0xFFFFFFFD;
        this.number_ = 0;
        this.onChanged();
        return this;
    }
    
    public boolean hasOptions() {
        return (this.bitField0_ & 0x4) == 0x4;
    }
    
    public DescriptorProtos$EnumValueOptions getOptions() {
        if (this.optionsBuilder_ == null) {
            return (this.options_ == null) ? DescriptorProtos$EnumValueOptions.getDefaultInstance() : this.options_;
        }
        return (DescriptorProtos$EnumValueOptions)this.optionsBuilder_.getMessage();
    }
    
    public DescriptorProtos$EnumValueDescriptorProto$Builder setOptions(final DescriptorProtos$EnumValueOptions descriptorProtos$EnumValueOptions) {
        if (this.optionsBuilder_ == null) {
            if (descriptorProtos$EnumValueOptions == null) {
                throw new NullPointerException();
            }
            this.options_ = descriptorProtos$EnumValueOptions;
            this.onChanged();
        }
        else {
            this.optionsBuilder_.setMessage(descriptorProtos$EnumValueOptions);
        }
        this.bitField0_ |= 0x4;
        return this;
    }
    
    public DescriptorProtos$EnumValueDescriptorProto$Builder setOptions(final DescriptorProtos$EnumValueOptions$Builder descriptorProtos$EnumValueOptions$Builder) {
        if (this.optionsBuilder_ == null) {
            this.options_ = descriptorProtos$EnumValueOptions$Builder.build();
            this.onChanged();
        }
        else {
            this.optionsBuilder_.setMessage(descriptorProtos$EnumValueOptions$Builder.build());
        }
        this.bitField0_ |= 0x4;
        return this;
    }
    
    public DescriptorProtos$EnumValueDescriptorProto$Builder mergeOptions(final DescriptorProtos$EnumValueOptions options_) {
        if (this.optionsBuilder_ == null) {
            if ((this.bitField0_ & 0x4) == 0x4 && this.options_ != null && this.options_ != DescriptorProtos$EnumValueOptions.getDefaultInstance()) {
                this.options_ = DescriptorProtos$EnumValueOptions.newBuilder(this.options_).mergeFrom(options_).buildPartial();
            }
            else {
                this.options_ = options_;
            }
            this.onChanged();
        }
        else {
            this.optionsBuilder_.mergeFrom(options_);
        }
        this.bitField0_ |= 0x4;
        return this;
    }
    
    public DescriptorProtos$EnumValueDescriptorProto$Builder clearOptions() {
        if (this.optionsBuilder_ == null) {
            this.options_ = null;
            this.onChanged();
        }
        else {
            this.optionsBuilder_.clear();
        }
        this.bitField0_ &= 0xFFFFFFFB;
        return this;
    }
    
    public DescriptorProtos$EnumValueOptions$Builder getOptionsBuilder() {
        this.bitField0_ |= 0x4;
        this.onChanged();
        return (DescriptorProtos$EnumValueOptions$Builder)this.getOptionsFieldBuilder().getBuilder();
    }
    
    public DescriptorProtos$EnumValueOptionsOrBuilder getOptionsOrBuilder() {
        if (this.optionsBuilder_ != null) {
            return (DescriptorProtos$EnumValueOptionsOrBuilder)this.optionsBuilder_.getMessageOrBuilder();
        }
        return (this.options_ == null) ? DescriptorProtos$EnumValueOptions.getDefaultInstance() : this.options_;
    }
    
    private SingleFieldBuilder getOptionsFieldBuilder() {
        if (this.optionsBuilder_ == null) {
            this.optionsBuilder_ = new SingleFieldBuilder(this.getOptions(), this.getParentForChildren(), this.isClean());
            this.options_ = null;
        }
        return this.optionsBuilder_;
    }
}
