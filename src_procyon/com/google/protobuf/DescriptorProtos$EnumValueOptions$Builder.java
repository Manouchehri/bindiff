package com.google.protobuf;

import java.util.*;
import java.io.*;

public final class DescriptorProtos$EnumValueOptions$Builder extends GeneratedMessage$ExtendableBuilder implements DescriptorProtos$EnumValueOptionsOrBuilder
{
    private int bitField0_;
    private boolean deprecated_;
    private List uninterpretedOption_;
    private RepeatedFieldBuilder uninterpretedOptionBuilder_;
    
    public static final Descriptors$Descriptor getDescriptor() {
        return DescriptorProtos.internal_static_google_protobuf_EnumValueOptions_descriptor;
    }
    
    protected GeneratedMessage$FieldAccessorTable internalGetFieldAccessorTable() {
        return DescriptorProtos.internal_static_google_protobuf_EnumValueOptions_fieldAccessorTable.ensureFieldAccessorsInitialized(DescriptorProtos$EnumValueOptions.class, DescriptorProtos$EnumValueOptions$Builder.class);
    }
    
    private DescriptorProtos$EnumValueOptions$Builder() {
        this.uninterpretedOption_ = Collections.emptyList();
        this.maybeForceBuilderInitialization();
    }
    
    private DescriptorProtos$EnumValueOptions$Builder(final GeneratedMessage$BuilderParent generatedMessage$BuilderParent) {
        super(generatedMessage$BuilderParent);
        this.uninterpretedOption_ = Collections.emptyList();
        this.maybeForceBuilderInitialization();
    }
    
    private void maybeForceBuilderInitialization() {
        if (GeneratedMessage.alwaysUseFieldBuilders) {
            this.getUninterpretedOptionFieldBuilder();
        }
    }
    
    public DescriptorProtos$EnumValueOptions$Builder clear() {
        super.clear();
        this.deprecated_ = false;
        this.bitField0_ &= 0xFFFFFFFE;
        if (this.uninterpretedOptionBuilder_ == null) {
            this.uninterpretedOption_ = Collections.emptyList();
            this.bitField0_ &= 0xFFFFFFFD;
        }
        else {
            this.uninterpretedOptionBuilder_.clear();
        }
        return this;
    }
    
    public Descriptors$Descriptor getDescriptorForType() {
        return DescriptorProtos.internal_static_google_protobuf_EnumValueOptions_descriptor;
    }
    
    public DescriptorProtos$EnumValueOptions getDefaultInstanceForType() {
        return DescriptorProtos$EnumValueOptions.getDefaultInstance();
    }
    
    public DescriptorProtos$EnumValueOptions build() {
        final DescriptorProtos$EnumValueOptions buildPartial = this.buildPartial();
        if (!buildPartial.isInitialized()) {
            throw AbstractMessage$Builder.newUninitializedMessageException(buildPartial);
        }
        return buildPartial;
    }
    
    public DescriptorProtos$EnumValueOptions buildPartial() {
        final DescriptorProtos$EnumValueOptions descriptorProtos$EnumValueOptions = new DescriptorProtos$EnumValueOptions(this, null);
        final int bitField0_ = this.bitField0_;
        int n = 0;
        if ((bitField0_ & 0x1) == 0x1) {
            n |= 0x1;
        }
        descriptorProtos$EnumValueOptions.deprecated_ = this.deprecated_;
        if (this.uninterpretedOptionBuilder_ == null) {
            if ((this.bitField0_ & 0x2) == 0x2) {
                this.uninterpretedOption_ = Collections.unmodifiableList((List<?>)this.uninterpretedOption_);
                this.bitField0_ &= 0xFFFFFFFD;
            }
            descriptorProtos$EnumValueOptions.uninterpretedOption_ = this.uninterpretedOption_;
        }
        else {
            descriptorProtos$EnumValueOptions.uninterpretedOption_ = this.uninterpretedOptionBuilder_.build();
        }
        descriptorProtos$EnumValueOptions.bitField0_ = n;
        this.onBuilt();
        return descriptorProtos$EnumValueOptions;
    }
    
    public DescriptorProtos$EnumValueOptions$Builder mergeFrom(final Message message) {
        if (message instanceof DescriptorProtos$EnumValueOptions) {
            return this.mergeFrom((DescriptorProtos$EnumValueOptions)message);
        }
        super.mergeFrom(message);
        return this;
    }
    
    public DescriptorProtos$EnumValueOptions$Builder mergeFrom(final DescriptorProtos$EnumValueOptions descriptorProtos$EnumValueOptions) {
        if (descriptorProtos$EnumValueOptions == DescriptorProtos$EnumValueOptions.getDefaultInstance()) {
            return this;
        }
        if (descriptorProtos$EnumValueOptions.hasDeprecated()) {
            this.setDeprecated(descriptorProtos$EnumValueOptions.getDeprecated());
        }
        if (this.uninterpretedOptionBuilder_ == null) {
            if (!descriptorProtos$EnumValueOptions.uninterpretedOption_.isEmpty()) {
                if (this.uninterpretedOption_.isEmpty()) {
                    this.uninterpretedOption_ = descriptorProtos$EnumValueOptions.uninterpretedOption_;
                    this.bitField0_ &= 0xFFFFFFFD;
                }
                else {
                    this.ensureUninterpretedOptionIsMutable();
                    this.uninterpretedOption_.addAll(descriptorProtos$EnumValueOptions.uninterpretedOption_);
                }
                this.onChanged();
            }
        }
        else if (!descriptorProtos$EnumValueOptions.uninterpretedOption_.isEmpty()) {
            if (this.uninterpretedOptionBuilder_.isEmpty()) {
                this.uninterpretedOptionBuilder_.dispose();
                this.uninterpretedOptionBuilder_ = null;
                this.uninterpretedOption_ = descriptorProtos$EnumValueOptions.uninterpretedOption_;
                this.bitField0_ &= 0xFFFFFFFD;
                this.uninterpretedOptionBuilder_ = (GeneratedMessage.alwaysUseFieldBuilders ? this.getUninterpretedOptionFieldBuilder() : null);
            }
            else {
                this.uninterpretedOptionBuilder_.addAllMessages(descriptorProtos$EnumValueOptions.uninterpretedOption_);
            }
        }
        this.mergeExtensionFields(descriptorProtos$EnumValueOptions);
        this.mergeUnknownFields(descriptorProtos$EnumValueOptions.unknownFields);
        this.onChanged();
        return this;
    }
    
    public final boolean isInitialized() {
        for (int i = 0; i < this.getUninterpretedOptionCount(); ++i) {
            if (!this.getUninterpretedOption(i).isInitialized()) {
                return false;
            }
        }
        return this.extensionsAreInitialized();
    }
    
    public DescriptorProtos$EnumValueOptions$Builder mergeFrom(final CodedInputStream codedInputStream, final ExtensionRegistryLite extensionRegistryLite) {
        DescriptorProtos$EnumValueOptions descriptorProtos$EnumValueOptions = null;
        try {
            descriptorProtos$EnumValueOptions = (DescriptorProtos$EnumValueOptions)DescriptorProtos$EnumValueOptions.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
        }
        catch (InvalidProtocolBufferException ex) {
            descriptorProtos$EnumValueOptions = (DescriptorProtos$EnumValueOptions)ex.getUnfinishedMessage();
            throw ex;
        }
        finally {
            if (descriptorProtos$EnumValueOptions != null) {
                this.mergeFrom(descriptorProtos$EnumValueOptions);
            }
        }
        return this;
    }
    
    public boolean hasDeprecated() {
        return (this.bitField0_ & 0x1) == 0x1;
    }
    
    public boolean getDeprecated() {
        return this.deprecated_;
    }
    
    public DescriptorProtos$EnumValueOptions$Builder setDeprecated(final boolean deprecated_) {
        this.bitField0_ |= 0x1;
        this.deprecated_ = deprecated_;
        this.onChanged();
        return this;
    }
    
    public DescriptorProtos$EnumValueOptions$Builder clearDeprecated() {
        this.bitField0_ &= 0xFFFFFFFE;
        this.deprecated_ = false;
        this.onChanged();
        return this;
    }
    
    private void ensureUninterpretedOptionIsMutable() {
        if ((this.bitField0_ & 0x2) != 0x2) {
            this.uninterpretedOption_ = new ArrayList(this.uninterpretedOption_);
            this.bitField0_ |= 0x2;
        }
    }
    
    public List getUninterpretedOptionList() {
        if (this.uninterpretedOptionBuilder_ == null) {
            return Collections.unmodifiableList((List<?>)this.uninterpretedOption_);
        }
        return this.uninterpretedOptionBuilder_.getMessageList();
    }
    
    public int getUninterpretedOptionCount() {
        if (this.uninterpretedOptionBuilder_ == null) {
            return this.uninterpretedOption_.size();
        }
        return this.uninterpretedOptionBuilder_.getCount();
    }
    
    public DescriptorProtos$UninterpretedOption getUninterpretedOption(final int n) {
        if (this.uninterpretedOptionBuilder_ == null) {
            return this.uninterpretedOption_.get(n);
        }
        return (DescriptorProtos$UninterpretedOption)this.uninterpretedOptionBuilder_.getMessage(n);
    }
    
    public DescriptorProtos$EnumValueOptions$Builder setUninterpretedOption(final int n, final DescriptorProtos$UninterpretedOption descriptorProtos$UninterpretedOption) {
        if (this.uninterpretedOptionBuilder_ == null) {
            if (descriptorProtos$UninterpretedOption == null) {
                throw new NullPointerException();
            }
            this.ensureUninterpretedOptionIsMutable();
            this.uninterpretedOption_.set(n, descriptorProtos$UninterpretedOption);
            this.onChanged();
        }
        else {
            this.uninterpretedOptionBuilder_.setMessage(n, descriptorProtos$UninterpretedOption);
        }
        return this;
    }
    
    public DescriptorProtos$EnumValueOptions$Builder setUninterpretedOption(final int n, final DescriptorProtos$UninterpretedOption$Builder descriptorProtos$UninterpretedOption$Builder) {
        if (this.uninterpretedOptionBuilder_ == null) {
            this.ensureUninterpretedOptionIsMutable();
            this.uninterpretedOption_.set(n, descriptorProtos$UninterpretedOption$Builder.build());
            this.onChanged();
        }
        else {
            this.uninterpretedOptionBuilder_.setMessage(n, descriptorProtos$UninterpretedOption$Builder.build());
        }
        return this;
    }
    
    public DescriptorProtos$EnumValueOptions$Builder addUninterpretedOption(final DescriptorProtos$UninterpretedOption descriptorProtos$UninterpretedOption) {
        if (this.uninterpretedOptionBuilder_ == null) {
            if (descriptorProtos$UninterpretedOption == null) {
                throw new NullPointerException();
            }
            this.ensureUninterpretedOptionIsMutable();
            this.uninterpretedOption_.add(descriptorProtos$UninterpretedOption);
            this.onChanged();
        }
        else {
            this.uninterpretedOptionBuilder_.addMessage(descriptorProtos$UninterpretedOption);
        }
        return this;
    }
    
    public DescriptorProtos$EnumValueOptions$Builder addUninterpretedOption(final int n, final DescriptorProtos$UninterpretedOption descriptorProtos$UninterpretedOption) {
        if (this.uninterpretedOptionBuilder_ == null) {
            if (descriptorProtos$UninterpretedOption == null) {
                throw new NullPointerException();
            }
            this.ensureUninterpretedOptionIsMutable();
            this.uninterpretedOption_.add(n, descriptorProtos$UninterpretedOption);
            this.onChanged();
        }
        else {
            this.uninterpretedOptionBuilder_.addMessage(n, descriptorProtos$UninterpretedOption);
        }
        return this;
    }
    
    public DescriptorProtos$EnumValueOptions$Builder addUninterpretedOption(final DescriptorProtos$UninterpretedOption$Builder descriptorProtos$UninterpretedOption$Builder) {
        if (this.uninterpretedOptionBuilder_ == null) {
            this.ensureUninterpretedOptionIsMutable();
            this.uninterpretedOption_.add(descriptorProtos$UninterpretedOption$Builder.build());
            this.onChanged();
        }
        else {
            this.uninterpretedOptionBuilder_.addMessage(descriptorProtos$UninterpretedOption$Builder.build());
        }
        return this;
    }
    
    public DescriptorProtos$EnumValueOptions$Builder addUninterpretedOption(final int n, final DescriptorProtos$UninterpretedOption$Builder descriptorProtos$UninterpretedOption$Builder) {
        if (this.uninterpretedOptionBuilder_ == null) {
            this.ensureUninterpretedOptionIsMutable();
            this.uninterpretedOption_.add(n, descriptorProtos$UninterpretedOption$Builder.build());
            this.onChanged();
        }
        else {
            this.uninterpretedOptionBuilder_.addMessage(n, descriptorProtos$UninterpretedOption$Builder.build());
        }
        return this;
    }
    
    public DescriptorProtos$EnumValueOptions$Builder addAllUninterpretedOption(final Iterable iterable) {
        if (this.uninterpretedOptionBuilder_ == null) {
            this.ensureUninterpretedOptionIsMutable();
            AbstractMessageLite$Builder.addAll(iterable, this.uninterpretedOption_);
            this.onChanged();
        }
        else {
            this.uninterpretedOptionBuilder_.addAllMessages(iterable);
        }
        return this;
    }
    
    public DescriptorProtos$EnumValueOptions$Builder clearUninterpretedOption() {
        if (this.uninterpretedOptionBuilder_ == null) {
            this.uninterpretedOption_ = Collections.emptyList();
            this.bitField0_ &= 0xFFFFFFFD;
            this.onChanged();
        }
        else {
            this.uninterpretedOptionBuilder_.clear();
        }
        return this;
    }
    
    public DescriptorProtos$EnumValueOptions$Builder removeUninterpretedOption(final int n) {
        if (this.uninterpretedOptionBuilder_ == null) {
            this.ensureUninterpretedOptionIsMutable();
            this.uninterpretedOption_.remove(n);
            this.onChanged();
        }
        else {
            this.uninterpretedOptionBuilder_.remove(n);
        }
        return this;
    }
    
    public DescriptorProtos$UninterpretedOption$Builder getUninterpretedOptionBuilder(final int n) {
        return (DescriptorProtos$UninterpretedOption$Builder)this.getUninterpretedOptionFieldBuilder().getBuilder(n);
    }
    
    public DescriptorProtos$UninterpretedOptionOrBuilder getUninterpretedOptionOrBuilder(final int n) {
        if (this.uninterpretedOptionBuilder_ == null) {
            return this.uninterpretedOption_.get(n);
        }
        return (DescriptorProtos$UninterpretedOptionOrBuilder)this.uninterpretedOptionBuilder_.getMessageOrBuilder(n);
    }
    
    public List getUninterpretedOptionOrBuilderList() {
        if (this.uninterpretedOptionBuilder_ != null) {
            return this.uninterpretedOptionBuilder_.getMessageOrBuilderList();
        }
        return Collections.unmodifiableList((List<?>)this.uninterpretedOption_);
    }
    
    public DescriptorProtos$UninterpretedOption$Builder addUninterpretedOptionBuilder() {
        return (DescriptorProtos$UninterpretedOption$Builder)this.getUninterpretedOptionFieldBuilder().addBuilder(DescriptorProtos$UninterpretedOption.getDefaultInstance());
    }
    
    public DescriptorProtos$UninterpretedOption$Builder addUninterpretedOptionBuilder(final int n) {
        return (DescriptorProtos$UninterpretedOption$Builder)this.getUninterpretedOptionFieldBuilder().addBuilder(n, DescriptorProtos$UninterpretedOption.getDefaultInstance());
    }
    
    public List getUninterpretedOptionBuilderList() {
        return this.getUninterpretedOptionFieldBuilder().getBuilderList();
    }
    
    private RepeatedFieldBuilder getUninterpretedOptionFieldBuilder() {
        if (this.uninterpretedOptionBuilder_ == null) {
            this.uninterpretedOptionBuilder_ = new RepeatedFieldBuilder(this.uninterpretedOption_, (this.bitField0_ & 0x2) == 0x2, this.getParentForChildren(), this.isClean());
            this.uninterpretedOption_ = null;
        }
        return this.uninterpretedOptionBuilder_;
    }
}
