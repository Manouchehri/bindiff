package com.google.protobuf;

import java.util.*;
import java.io.*;

public final class DescriptorProtos$ServiceOptions$Builder extends GeneratedMessage$ExtendableBuilder implements DescriptorProtos$ServiceOptionsOrBuilder
{
    private int bitField0_;
    private boolean deprecated_;
    private List uninterpretedOption_;
    private RepeatedFieldBuilder uninterpretedOptionBuilder_;
    
    public static final Descriptors$Descriptor getDescriptor() {
        return DescriptorProtos.internal_static_google_protobuf_ServiceOptions_descriptor;
    }
    
    protected GeneratedMessage$FieldAccessorTable internalGetFieldAccessorTable() {
        return DescriptorProtos.internal_static_google_protobuf_ServiceOptions_fieldAccessorTable.ensureFieldAccessorsInitialized(DescriptorProtos$ServiceOptions.class, DescriptorProtos$ServiceOptions$Builder.class);
    }
    
    private DescriptorProtos$ServiceOptions$Builder() {
        this.uninterpretedOption_ = Collections.emptyList();
        this.maybeForceBuilderInitialization();
    }
    
    private DescriptorProtos$ServiceOptions$Builder(final GeneratedMessage$BuilderParent generatedMessage$BuilderParent) {
        super(generatedMessage$BuilderParent);
        this.uninterpretedOption_ = Collections.emptyList();
        this.maybeForceBuilderInitialization();
    }
    
    private void maybeForceBuilderInitialization() {
        if (GeneratedMessage.alwaysUseFieldBuilders) {
            this.getUninterpretedOptionFieldBuilder();
        }
    }
    
    public DescriptorProtos$ServiceOptions$Builder clear() {
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
        return DescriptorProtos.internal_static_google_protobuf_ServiceOptions_descriptor;
    }
    
    public DescriptorProtos$ServiceOptions getDefaultInstanceForType() {
        return DescriptorProtos$ServiceOptions.getDefaultInstance();
    }
    
    public DescriptorProtos$ServiceOptions build() {
        final DescriptorProtos$ServiceOptions buildPartial = this.buildPartial();
        if (!buildPartial.isInitialized()) {
            throw AbstractMessage$Builder.newUninitializedMessageException(buildPartial);
        }
        return buildPartial;
    }
    
    public DescriptorProtos$ServiceOptions buildPartial() {
        final DescriptorProtos$ServiceOptions descriptorProtos$ServiceOptions = new DescriptorProtos$ServiceOptions(this, null);
        final int bitField0_ = this.bitField0_;
        int n = 0;
        if ((bitField0_ & 0x1) == 0x1) {
            n |= 0x1;
        }
        descriptorProtos$ServiceOptions.deprecated_ = this.deprecated_;
        if (this.uninterpretedOptionBuilder_ == null) {
            if ((this.bitField0_ & 0x2) == 0x2) {
                this.uninterpretedOption_ = Collections.unmodifiableList((List<?>)this.uninterpretedOption_);
                this.bitField0_ &= 0xFFFFFFFD;
            }
            descriptorProtos$ServiceOptions.uninterpretedOption_ = this.uninterpretedOption_;
        }
        else {
            descriptorProtos$ServiceOptions.uninterpretedOption_ = this.uninterpretedOptionBuilder_.build();
        }
        descriptorProtos$ServiceOptions.bitField0_ = n;
        this.onBuilt();
        return descriptorProtos$ServiceOptions;
    }
    
    public DescriptorProtos$ServiceOptions$Builder mergeFrom(final Message message) {
        if (message instanceof DescriptorProtos$ServiceOptions) {
            return this.mergeFrom((DescriptorProtos$ServiceOptions)message);
        }
        super.mergeFrom(message);
        return this;
    }
    
    public DescriptorProtos$ServiceOptions$Builder mergeFrom(final DescriptorProtos$ServiceOptions descriptorProtos$ServiceOptions) {
        if (descriptorProtos$ServiceOptions == DescriptorProtos$ServiceOptions.getDefaultInstance()) {
            return this;
        }
        if (descriptorProtos$ServiceOptions.hasDeprecated()) {
            this.setDeprecated(descriptorProtos$ServiceOptions.getDeprecated());
        }
        if (this.uninterpretedOptionBuilder_ == null) {
            if (!descriptorProtos$ServiceOptions.uninterpretedOption_.isEmpty()) {
                if (this.uninterpretedOption_.isEmpty()) {
                    this.uninterpretedOption_ = descriptorProtos$ServiceOptions.uninterpretedOption_;
                    this.bitField0_ &= 0xFFFFFFFD;
                }
                else {
                    this.ensureUninterpretedOptionIsMutable();
                    this.uninterpretedOption_.addAll(descriptorProtos$ServiceOptions.uninterpretedOption_);
                }
                this.onChanged();
            }
        }
        else if (!descriptorProtos$ServiceOptions.uninterpretedOption_.isEmpty()) {
            if (this.uninterpretedOptionBuilder_.isEmpty()) {
                this.uninterpretedOptionBuilder_.dispose();
                this.uninterpretedOptionBuilder_ = null;
                this.uninterpretedOption_ = descriptorProtos$ServiceOptions.uninterpretedOption_;
                this.bitField0_ &= 0xFFFFFFFD;
                this.uninterpretedOptionBuilder_ = (GeneratedMessage.alwaysUseFieldBuilders ? this.getUninterpretedOptionFieldBuilder() : null);
            }
            else {
                this.uninterpretedOptionBuilder_.addAllMessages(descriptorProtos$ServiceOptions.uninterpretedOption_);
            }
        }
        this.mergeExtensionFields(descriptorProtos$ServiceOptions);
        this.mergeUnknownFields(descriptorProtos$ServiceOptions.unknownFields);
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
    
    public DescriptorProtos$ServiceOptions$Builder mergeFrom(final CodedInputStream codedInputStream, final ExtensionRegistryLite extensionRegistryLite) {
        DescriptorProtos$ServiceOptions descriptorProtos$ServiceOptions = null;
        try {
            descriptorProtos$ServiceOptions = (DescriptorProtos$ServiceOptions)DescriptorProtos$ServiceOptions.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
        }
        catch (InvalidProtocolBufferException ex) {
            descriptorProtos$ServiceOptions = (DescriptorProtos$ServiceOptions)ex.getUnfinishedMessage();
            throw ex;
        }
        finally {
            if (descriptorProtos$ServiceOptions != null) {
                this.mergeFrom(descriptorProtos$ServiceOptions);
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
    
    public DescriptorProtos$ServiceOptions$Builder setDeprecated(final boolean deprecated_) {
        this.bitField0_ |= 0x1;
        this.deprecated_ = deprecated_;
        this.onChanged();
        return this;
    }
    
    public DescriptorProtos$ServiceOptions$Builder clearDeprecated() {
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
    
    public DescriptorProtos$ServiceOptions$Builder setUninterpretedOption(final int n, final DescriptorProtos$UninterpretedOption descriptorProtos$UninterpretedOption) {
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
    
    public DescriptorProtos$ServiceOptions$Builder setUninterpretedOption(final int n, final DescriptorProtos$UninterpretedOption$Builder descriptorProtos$UninterpretedOption$Builder) {
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
    
    public DescriptorProtos$ServiceOptions$Builder addUninterpretedOption(final DescriptorProtos$UninterpretedOption descriptorProtos$UninterpretedOption) {
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
    
    public DescriptorProtos$ServiceOptions$Builder addUninterpretedOption(final int n, final DescriptorProtos$UninterpretedOption descriptorProtos$UninterpretedOption) {
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
    
    public DescriptorProtos$ServiceOptions$Builder addUninterpretedOption(final DescriptorProtos$UninterpretedOption$Builder descriptorProtos$UninterpretedOption$Builder) {
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
    
    public DescriptorProtos$ServiceOptions$Builder addUninterpretedOption(final int n, final DescriptorProtos$UninterpretedOption$Builder descriptorProtos$UninterpretedOption$Builder) {
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
    
    public DescriptorProtos$ServiceOptions$Builder addAllUninterpretedOption(final Iterable iterable) {
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
    
    public DescriptorProtos$ServiceOptions$Builder clearUninterpretedOption() {
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
    
    public DescriptorProtos$ServiceOptions$Builder removeUninterpretedOption(final int n) {
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
