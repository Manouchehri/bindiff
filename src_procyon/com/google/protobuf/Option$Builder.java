package com.google.protobuf;

import java.io.*;

public final class Option$Builder extends GeneratedMessage$Builder implements OptionOrBuilder
{
    private Object name_;
    private Any value_;
    private SingleFieldBuilder valueBuilder_;
    
    public static final Descriptors$Descriptor getDescriptor() {
        return TypeProto.internal_static_google_protobuf_Option_descriptor;
    }
    
    protected GeneratedMessage$FieldAccessorTable internalGetFieldAccessorTable() {
        return TypeProto.internal_static_google_protobuf_Option_fieldAccessorTable.ensureFieldAccessorsInitialized(Option.class, Option$Builder.class);
    }
    
    private Option$Builder() {
        this.name_ = "";
        this.value_ = null;
        this.maybeForceBuilderInitialization();
    }
    
    private Option$Builder(final GeneratedMessage$BuilderParent generatedMessage$BuilderParent) {
        super(generatedMessage$BuilderParent);
        this.name_ = "";
        this.value_ = null;
        this.maybeForceBuilderInitialization();
    }
    
    private void maybeForceBuilderInitialization() {
        if (GeneratedMessage.alwaysUseFieldBuilders) {}
    }
    
    public Option$Builder clear() {
        super.clear();
        this.name_ = "";
        if (this.valueBuilder_ == null) {
            this.value_ = null;
        }
        else {
            this.value_ = null;
            this.valueBuilder_ = null;
        }
        return this;
    }
    
    public Descriptors$Descriptor getDescriptorForType() {
        return TypeProto.internal_static_google_protobuf_Option_descriptor;
    }
    
    public Option getDefaultInstanceForType() {
        return Option.getDefaultInstance();
    }
    
    public Option build() {
        final Option buildPartial = this.buildPartial();
        if (!buildPartial.isInitialized()) {
            throw AbstractMessage$Builder.newUninitializedMessageException(buildPartial);
        }
        return buildPartial;
    }
    
    public Option buildPartial() {
        final Option option = new Option(this, null);
        option.name_ = this.name_;
        if (this.valueBuilder_ == null) {
            option.value_ = this.value_;
        }
        else {
            option.value_ = (Any)this.valueBuilder_.build();
        }
        this.onBuilt();
        return option;
    }
    
    public Option$Builder mergeFrom(final Message message) {
        if (message instanceof Option) {
            return this.mergeFrom((Option)message);
        }
        super.mergeFrom(message);
        return this;
    }
    
    public Option$Builder mergeFrom(final Option option) {
        if (option == Option.getDefaultInstance()) {
            return this;
        }
        if (!option.getName().isEmpty()) {
            this.name_ = option.name_;
            this.onChanged();
        }
        if (option.hasValue()) {
            this.mergeValue(option.getValue());
        }
        this.onChanged();
        return this;
    }
    
    public final boolean isInitialized() {
        return true;
    }
    
    public Option$Builder mergeFrom(final CodedInputStream codedInputStream, final ExtensionRegistryLite extensionRegistryLite) {
        Option option = null;
        try {
            option = (Option)Option.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
        }
        catch (InvalidProtocolBufferException ex) {
            option = (Option)ex.getUnfinishedMessage();
            throw ex;
        }
        finally {
            if (option != null) {
                this.mergeFrom(option);
            }
        }
        return this;
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
    
    public Option$Builder setName(final String name_) {
        if (name_ == null) {
            throw new NullPointerException();
        }
        this.name_ = name_;
        this.onChanged();
        return this;
    }
    
    public Option$Builder clearName() {
        this.name_ = Option.getDefaultInstance().getName();
        this.onChanged();
        return this;
    }
    
    public Option$Builder setNameBytes(final ByteString name_) {
        if (name_ == null) {
            throw new NullPointerException();
        }
        this.name_ = name_;
        this.onChanged();
        return this;
    }
    
    public boolean hasValue() {
        return this.valueBuilder_ != null || this.value_ != null;
    }
    
    public Any getValue() {
        if (this.valueBuilder_ == null) {
            return (this.value_ == null) ? Any.getDefaultInstance() : this.value_;
        }
        return (Any)this.valueBuilder_.getMessage();
    }
    
    public Option$Builder setValue(final Any any) {
        if (this.valueBuilder_ == null) {
            if (any == null) {
                throw new NullPointerException();
            }
            this.value_ = any;
            this.onChanged();
        }
        else {
            this.valueBuilder_.setMessage(any);
        }
        return this;
    }
    
    public Option$Builder setValue(final Any$Builder any$Builder) {
        if (this.valueBuilder_ == null) {
            this.value_ = any$Builder.build();
            this.onChanged();
        }
        else {
            this.valueBuilder_.setMessage(any$Builder.build());
        }
        return this;
    }
    
    public Option$Builder mergeValue(final Any value_) {
        if (this.valueBuilder_ == null) {
            if (this.value_ != null) {
                this.value_ = Any.newBuilder(this.value_).mergeFrom(value_).buildPartial();
            }
            else {
                this.value_ = value_;
            }
            this.onChanged();
        }
        else {
            this.valueBuilder_.mergeFrom(value_);
        }
        return this;
    }
    
    public Option$Builder clearValue() {
        if (this.valueBuilder_ == null) {
            this.value_ = null;
            this.onChanged();
        }
        else {
            this.value_ = null;
            this.valueBuilder_ = null;
        }
        return this;
    }
    
    public Any$Builder getValueBuilder() {
        this.onChanged();
        return (Any$Builder)this.getValueFieldBuilder().getBuilder();
    }
    
    public AnyOrBuilder getValueOrBuilder() {
        if (this.valueBuilder_ != null) {
            return (AnyOrBuilder)this.valueBuilder_.getMessageOrBuilder();
        }
        return (this.value_ == null) ? Any.getDefaultInstance() : this.value_;
    }
    
    private SingleFieldBuilder getValueFieldBuilder() {
        if (this.valueBuilder_ == null) {
            this.valueBuilder_ = new SingleFieldBuilder(this.getValue(), this.getParentForChildren(), this.isClean());
            this.value_ = null;
        }
        return this.valueBuilder_;
    }
    
    public final Option$Builder setUnknownFields(final UnknownFieldSet set) {
        return this;
    }
    
    public final Option$Builder mergeUnknownFields(final UnknownFieldSet set) {
        return this;
    }
}
