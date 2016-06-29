package com.google.protobuf;

import java.util.*;
import java.io.*;

public final class DescriptorProtos$EnumDescriptorProto$Builder extends GeneratedMessage$Builder implements DescriptorProtos$EnumDescriptorProtoOrBuilder
{
    private int bitField0_;
    private Object name_;
    private List value_;
    private RepeatedFieldBuilder valueBuilder_;
    private DescriptorProtos$EnumOptions options_;
    private SingleFieldBuilder optionsBuilder_;
    
    public static final Descriptors$Descriptor getDescriptor() {
        return DescriptorProtos.internal_static_google_protobuf_EnumDescriptorProto_descriptor;
    }
    
    protected GeneratedMessage$FieldAccessorTable internalGetFieldAccessorTable() {
        return DescriptorProtos.internal_static_google_protobuf_EnumDescriptorProto_fieldAccessorTable.ensureFieldAccessorsInitialized(DescriptorProtos$EnumDescriptorProto.class, DescriptorProtos$EnumDescriptorProto$Builder.class);
    }
    
    private DescriptorProtos$EnumDescriptorProto$Builder() {
        this.name_ = "";
        this.value_ = Collections.emptyList();
        this.options_ = null;
        this.maybeForceBuilderInitialization();
    }
    
    private DescriptorProtos$EnumDescriptorProto$Builder(final GeneratedMessage$BuilderParent generatedMessage$BuilderParent) {
        super(generatedMessage$BuilderParent);
        this.name_ = "";
        this.value_ = Collections.emptyList();
        this.options_ = null;
        this.maybeForceBuilderInitialization();
    }
    
    private void maybeForceBuilderInitialization() {
        if (GeneratedMessage.alwaysUseFieldBuilders) {
            this.getValueFieldBuilder();
            this.getOptionsFieldBuilder();
        }
    }
    
    public DescriptorProtos$EnumDescriptorProto$Builder clear() {
        super.clear();
        this.name_ = "";
        this.bitField0_ &= 0xFFFFFFFE;
        if (this.valueBuilder_ == null) {
            this.value_ = Collections.emptyList();
            this.bitField0_ &= 0xFFFFFFFD;
        }
        else {
            this.valueBuilder_.clear();
        }
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
        return DescriptorProtos.internal_static_google_protobuf_EnumDescriptorProto_descriptor;
    }
    
    public DescriptorProtos$EnumDescriptorProto getDefaultInstanceForType() {
        return DescriptorProtos$EnumDescriptorProto.getDefaultInstance();
    }
    
    public DescriptorProtos$EnumDescriptorProto build() {
        final DescriptorProtos$EnumDescriptorProto buildPartial = this.buildPartial();
        if (!buildPartial.isInitialized()) {
            throw AbstractMessage$Builder.newUninitializedMessageException(buildPartial);
        }
        return buildPartial;
    }
    
    public DescriptorProtos$EnumDescriptorProto buildPartial() {
        final DescriptorProtos$EnumDescriptorProto descriptorProtos$EnumDescriptorProto = new DescriptorProtos$EnumDescriptorProto(this, null);
        final int bitField0_ = this.bitField0_;
        int n = 0;
        if ((bitField0_ & 0x1) == 0x1) {
            n |= 0x1;
        }
        descriptorProtos$EnumDescriptorProto.name_ = this.name_;
        if (this.valueBuilder_ == null) {
            if ((this.bitField0_ & 0x2) == 0x2) {
                this.value_ = Collections.unmodifiableList((List<?>)this.value_);
                this.bitField0_ &= 0xFFFFFFFD;
            }
            descriptorProtos$EnumDescriptorProto.value_ = this.value_;
        }
        else {
            descriptorProtos$EnumDescriptorProto.value_ = this.valueBuilder_.build();
        }
        if ((bitField0_ & 0x4) == 0x4) {
            n |= 0x2;
        }
        if (this.optionsBuilder_ == null) {
            descriptorProtos$EnumDescriptorProto.options_ = this.options_;
        }
        else {
            descriptorProtos$EnumDescriptorProto.options_ = (DescriptorProtos$EnumOptions)this.optionsBuilder_.build();
        }
        descriptorProtos$EnumDescriptorProto.bitField0_ = n;
        this.onBuilt();
        return descriptorProtos$EnumDescriptorProto;
    }
    
    public DescriptorProtos$EnumDescriptorProto$Builder mergeFrom(final Message message) {
        if (message instanceof DescriptorProtos$EnumDescriptorProto) {
            return this.mergeFrom((DescriptorProtos$EnumDescriptorProto)message);
        }
        super.mergeFrom(message);
        return this;
    }
    
    public DescriptorProtos$EnumDescriptorProto$Builder mergeFrom(final DescriptorProtos$EnumDescriptorProto descriptorProtos$EnumDescriptorProto) {
        if (descriptorProtos$EnumDescriptorProto == DescriptorProtos$EnumDescriptorProto.getDefaultInstance()) {
            return this;
        }
        if (descriptorProtos$EnumDescriptorProto.hasName()) {
            this.bitField0_ |= 0x1;
            this.name_ = descriptorProtos$EnumDescriptorProto.name_;
            this.onChanged();
        }
        if (this.valueBuilder_ == null) {
            if (!descriptorProtos$EnumDescriptorProto.value_.isEmpty()) {
                if (this.value_.isEmpty()) {
                    this.value_ = descriptorProtos$EnumDescriptorProto.value_;
                    this.bitField0_ &= 0xFFFFFFFD;
                }
                else {
                    this.ensureValueIsMutable();
                    this.value_.addAll(descriptorProtos$EnumDescriptorProto.value_);
                }
                this.onChanged();
            }
        }
        else if (!descriptorProtos$EnumDescriptorProto.value_.isEmpty()) {
            if (this.valueBuilder_.isEmpty()) {
                this.valueBuilder_.dispose();
                this.valueBuilder_ = null;
                this.value_ = descriptorProtos$EnumDescriptorProto.value_;
                this.bitField0_ &= 0xFFFFFFFD;
                this.valueBuilder_ = (GeneratedMessage.alwaysUseFieldBuilders ? this.getValueFieldBuilder() : null);
            }
            else {
                this.valueBuilder_.addAllMessages(descriptorProtos$EnumDescriptorProto.value_);
            }
        }
        if (descriptorProtos$EnumDescriptorProto.hasOptions()) {
            this.mergeOptions(descriptorProtos$EnumDescriptorProto.getOptions());
        }
        this.mergeUnknownFields(descriptorProtos$EnumDescriptorProto.unknownFields);
        this.onChanged();
        return this;
    }
    
    public final boolean isInitialized() {
        for (int i = 0; i < this.getValueCount(); ++i) {
            if (!this.getValue(i).isInitialized()) {
                return false;
            }
        }
        return !this.hasOptions() || this.getOptions().isInitialized();
    }
    
    public DescriptorProtos$EnumDescriptorProto$Builder mergeFrom(final CodedInputStream codedInputStream, final ExtensionRegistryLite extensionRegistryLite) {
        DescriptorProtos$EnumDescriptorProto descriptorProtos$EnumDescriptorProto = null;
        try {
            descriptorProtos$EnumDescriptorProto = (DescriptorProtos$EnumDescriptorProto)DescriptorProtos$EnumDescriptorProto.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
        }
        catch (InvalidProtocolBufferException ex) {
            descriptorProtos$EnumDescriptorProto = (DescriptorProtos$EnumDescriptorProto)ex.getUnfinishedMessage();
            throw ex;
        }
        finally {
            if (descriptorProtos$EnumDescriptorProto != null) {
                this.mergeFrom(descriptorProtos$EnumDescriptorProto);
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
    
    public DescriptorProtos$EnumDescriptorProto$Builder setName(final String name_) {
        if (name_ == null) {
            throw new NullPointerException();
        }
        this.bitField0_ |= 0x1;
        this.name_ = name_;
        this.onChanged();
        return this;
    }
    
    public DescriptorProtos$EnumDescriptorProto$Builder clearName() {
        this.bitField0_ &= 0xFFFFFFFE;
        this.name_ = DescriptorProtos$EnumDescriptorProto.getDefaultInstance().getName();
        this.onChanged();
        return this;
    }
    
    public DescriptorProtos$EnumDescriptorProto$Builder setNameBytes(final ByteString name_) {
        if (name_ == null) {
            throw new NullPointerException();
        }
        this.bitField0_ |= 0x1;
        this.name_ = name_;
        this.onChanged();
        return this;
    }
    
    private void ensureValueIsMutable() {
        if ((this.bitField0_ & 0x2) != 0x2) {
            this.value_ = new ArrayList(this.value_);
            this.bitField0_ |= 0x2;
        }
    }
    
    public List getValueList() {
        if (this.valueBuilder_ == null) {
            return Collections.unmodifiableList((List<?>)this.value_);
        }
        return this.valueBuilder_.getMessageList();
    }
    
    public int getValueCount() {
        if (this.valueBuilder_ == null) {
            return this.value_.size();
        }
        return this.valueBuilder_.getCount();
    }
    
    public DescriptorProtos$EnumValueDescriptorProto getValue(final int n) {
        if (this.valueBuilder_ == null) {
            return this.value_.get(n);
        }
        return (DescriptorProtos$EnumValueDescriptorProto)this.valueBuilder_.getMessage(n);
    }
    
    public DescriptorProtos$EnumDescriptorProto$Builder setValue(final int n, final DescriptorProtos$EnumValueDescriptorProto descriptorProtos$EnumValueDescriptorProto) {
        if (this.valueBuilder_ == null) {
            if (descriptorProtos$EnumValueDescriptorProto == null) {
                throw new NullPointerException();
            }
            this.ensureValueIsMutable();
            this.value_.set(n, descriptorProtos$EnumValueDescriptorProto);
            this.onChanged();
        }
        else {
            this.valueBuilder_.setMessage(n, descriptorProtos$EnumValueDescriptorProto);
        }
        return this;
    }
    
    public DescriptorProtos$EnumDescriptorProto$Builder setValue(final int n, final DescriptorProtos$EnumValueDescriptorProto$Builder descriptorProtos$EnumValueDescriptorProto$Builder) {
        if (this.valueBuilder_ == null) {
            this.ensureValueIsMutable();
            this.value_.set(n, descriptorProtos$EnumValueDescriptorProto$Builder.build());
            this.onChanged();
        }
        else {
            this.valueBuilder_.setMessage(n, descriptorProtos$EnumValueDescriptorProto$Builder.build());
        }
        return this;
    }
    
    public DescriptorProtos$EnumDescriptorProto$Builder addValue(final DescriptorProtos$EnumValueDescriptorProto descriptorProtos$EnumValueDescriptorProto) {
        if (this.valueBuilder_ == null) {
            if (descriptorProtos$EnumValueDescriptorProto == null) {
                throw new NullPointerException();
            }
            this.ensureValueIsMutable();
            this.value_.add(descriptorProtos$EnumValueDescriptorProto);
            this.onChanged();
        }
        else {
            this.valueBuilder_.addMessage(descriptorProtos$EnumValueDescriptorProto);
        }
        return this;
    }
    
    public DescriptorProtos$EnumDescriptorProto$Builder addValue(final int n, final DescriptorProtos$EnumValueDescriptorProto descriptorProtos$EnumValueDescriptorProto) {
        if (this.valueBuilder_ == null) {
            if (descriptorProtos$EnumValueDescriptorProto == null) {
                throw new NullPointerException();
            }
            this.ensureValueIsMutable();
            this.value_.add(n, descriptorProtos$EnumValueDescriptorProto);
            this.onChanged();
        }
        else {
            this.valueBuilder_.addMessage(n, descriptorProtos$EnumValueDescriptorProto);
        }
        return this;
    }
    
    public DescriptorProtos$EnumDescriptorProto$Builder addValue(final DescriptorProtos$EnumValueDescriptorProto$Builder descriptorProtos$EnumValueDescriptorProto$Builder) {
        if (this.valueBuilder_ == null) {
            this.ensureValueIsMutable();
            this.value_.add(descriptorProtos$EnumValueDescriptorProto$Builder.build());
            this.onChanged();
        }
        else {
            this.valueBuilder_.addMessage(descriptorProtos$EnumValueDescriptorProto$Builder.build());
        }
        return this;
    }
    
    public DescriptorProtos$EnumDescriptorProto$Builder addValue(final int n, final DescriptorProtos$EnumValueDescriptorProto$Builder descriptorProtos$EnumValueDescriptorProto$Builder) {
        if (this.valueBuilder_ == null) {
            this.ensureValueIsMutable();
            this.value_.add(n, descriptorProtos$EnumValueDescriptorProto$Builder.build());
            this.onChanged();
        }
        else {
            this.valueBuilder_.addMessage(n, descriptorProtos$EnumValueDescriptorProto$Builder.build());
        }
        return this;
    }
    
    public DescriptorProtos$EnumDescriptorProto$Builder addAllValue(final Iterable iterable) {
        if (this.valueBuilder_ == null) {
            this.ensureValueIsMutable();
            AbstractMessageLite$Builder.addAll(iterable, this.value_);
            this.onChanged();
        }
        else {
            this.valueBuilder_.addAllMessages(iterable);
        }
        return this;
    }
    
    public DescriptorProtos$EnumDescriptorProto$Builder clearValue() {
        if (this.valueBuilder_ == null) {
            this.value_ = Collections.emptyList();
            this.bitField0_ &= 0xFFFFFFFD;
            this.onChanged();
        }
        else {
            this.valueBuilder_.clear();
        }
        return this;
    }
    
    public DescriptorProtos$EnumDescriptorProto$Builder removeValue(final int n) {
        if (this.valueBuilder_ == null) {
            this.ensureValueIsMutable();
            this.value_.remove(n);
            this.onChanged();
        }
        else {
            this.valueBuilder_.remove(n);
        }
        return this;
    }
    
    public DescriptorProtos$EnumValueDescriptorProto$Builder getValueBuilder(final int n) {
        return (DescriptorProtos$EnumValueDescriptorProto$Builder)this.getValueFieldBuilder().getBuilder(n);
    }
    
    public DescriptorProtos$EnumValueDescriptorProtoOrBuilder getValueOrBuilder(final int n) {
        if (this.valueBuilder_ == null) {
            return this.value_.get(n);
        }
        return (DescriptorProtos$EnumValueDescriptorProtoOrBuilder)this.valueBuilder_.getMessageOrBuilder(n);
    }
    
    public List getValueOrBuilderList() {
        if (this.valueBuilder_ != null) {
            return this.valueBuilder_.getMessageOrBuilderList();
        }
        return Collections.unmodifiableList((List<?>)this.value_);
    }
    
    public DescriptorProtos$EnumValueDescriptorProto$Builder addValueBuilder() {
        return (DescriptorProtos$EnumValueDescriptorProto$Builder)this.getValueFieldBuilder().addBuilder(DescriptorProtos$EnumValueDescriptorProto.getDefaultInstance());
    }
    
    public DescriptorProtos$EnumValueDescriptorProto$Builder addValueBuilder(final int n) {
        return (DescriptorProtos$EnumValueDescriptorProto$Builder)this.getValueFieldBuilder().addBuilder(n, DescriptorProtos$EnumValueDescriptorProto.getDefaultInstance());
    }
    
    public List getValueBuilderList() {
        return this.getValueFieldBuilder().getBuilderList();
    }
    
    private RepeatedFieldBuilder getValueFieldBuilder() {
        if (this.valueBuilder_ == null) {
            this.valueBuilder_ = new RepeatedFieldBuilder(this.value_, (this.bitField0_ & 0x2) == 0x2, this.getParentForChildren(), this.isClean());
            this.value_ = null;
        }
        return this.valueBuilder_;
    }
    
    public boolean hasOptions() {
        return (this.bitField0_ & 0x4) == 0x4;
    }
    
    public DescriptorProtos$EnumOptions getOptions() {
        if (this.optionsBuilder_ == null) {
            return (this.options_ == null) ? DescriptorProtos$EnumOptions.getDefaultInstance() : this.options_;
        }
        return (DescriptorProtos$EnumOptions)this.optionsBuilder_.getMessage();
    }
    
    public DescriptorProtos$EnumDescriptorProto$Builder setOptions(final DescriptorProtos$EnumOptions descriptorProtos$EnumOptions) {
        if (this.optionsBuilder_ == null) {
            if (descriptorProtos$EnumOptions == null) {
                throw new NullPointerException();
            }
            this.options_ = descriptorProtos$EnumOptions;
            this.onChanged();
        }
        else {
            this.optionsBuilder_.setMessage(descriptorProtos$EnumOptions);
        }
        this.bitField0_ |= 0x4;
        return this;
    }
    
    public DescriptorProtos$EnumDescriptorProto$Builder setOptions(final DescriptorProtos$EnumOptions$Builder descriptorProtos$EnumOptions$Builder) {
        if (this.optionsBuilder_ == null) {
            this.options_ = descriptorProtos$EnumOptions$Builder.build();
            this.onChanged();
        }
        else {
            this.optionsBuilder_.setMessage(descriptorProtos$EnumOptions$Builder.build());
        }
        this.bitField0_ |= 0x4;
        return this;
    }
    
    public DescriptorProtos$EnumDescriptorProto$Builder mergeOptions(final DescriptorProtos$EnumOptions options_) {
        if (this.optionsBuilder_ == null) {
            if ((this.bitField0_ & 0x4) == 0x4 && this.options_ != null && this.options_ != DescriptorProtos$EnumOptions.getDefaultInstance()) {
                this.options_ = DescriptorProtos$EnumOptions.newBuilder(this.options_).mergeFrom(options_).buildPartial();
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
    
    public DescriptorProtos$EnumDescriptorProto$Builder clearOptions() {
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
    
    public DescriptorProtos$EnumOptions$Builder getOptionsBuilder() {
        this.bitField0_ |= 0x4;
        this.onChanged();
        return (DescriptorProtos$EnumOptions$Builder)this.getOptionsFieldBuilder().getBuilder();
    }
    
    public DescriptorProtos$EnumOptionsOrBuilder getOptionsOrBuilder() {
        if (this.optionsBuilder_ != null) {
            return (DescriptorProtos$EnumOptionsOrBuilder)this.optionsBuilder_.getMessageOrBuilder();
        }
        return (this.options_ == null) ? DescriptorProtos$EnumOptions.getDefaultInstance() : this.options_;
    }
    
    private SingleFieldBuilder getOptionsFieldBuilder() {
        if (this.optionsBuilder_ == null) {
            this.optionsBuilder_ = new SingleFieldBuilder(this.getOptions(), this.getParentForChildren(), this.isClean());
            this.options_ = null;
        }
        return this.optionsBuilder_;
    }
}
