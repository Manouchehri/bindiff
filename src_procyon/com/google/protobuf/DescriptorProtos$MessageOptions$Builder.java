package com.google.protobuf;

import java.util.*;
import java.io.*;

public final class DescriptorProtos$MessageOptions$Builder extends GeneratedMessage$ExtendableBuilder implements DescriptorProtos$MessageOptionsOrBuilder
{
    private int bitField0_;
    private boolean messageSetWireFormat_;
    private boolean noStandardDescriptorAccessor_;
    private boolean deprecated_;
    private boolean mapEntry_;
    private List uninterpretedOption_;
    private RepeatedFieldBuilder uninterpretedOptionBuilder_;
    
    public static final Descriptors$Descriptor getDescriptor() {
        return DescriptorProtos.internal_static_google_protobuf_MessageOptions_descriptor;
    }
    
    protected GeneratedMessage$FieldAccessorTable internalGetFieldAccessorTable() {
        return DescriptorProtos.internal_static_google_protobuf_MessageOptions_fieldAccessorTable.ensureFieldAccessorsInitialized(DescriptorProtos$MessageOptions.class, DescriptorProtos$MessageOptions$Builder.class);
    }
    
    private DescriptorProtos$MessageOptions$Builder() {
        this.uninterpretedOption_ = Collections.emptyList();
        this.maybeForceBuilderInitialization();
    }
    
    private DescriptorProtos$MessageOptions$Builder(final GeneratedMessage$BuilderParent generatedMessage$BuilderParent) {
        super(generatedMessage$BuilderParent);
        this.uninterpretedOption_ = Collections.emptyList();
        this.maybeForceBuilderInitialization();
    }
    
    private void maybeForceBuilderInitialization() {
        if (GeneratedMessage.alwaysUseFieldBuilders) {
            this.getUninterpretedOptionFieldBuilder();
        }
    }
    
    public DescriptorProtos$MessageOptions$Builder clear() {
        super.clear();
        this.messageSetWireFormat_ = false;
        this.bitField0_ &= 0xFFFFFFFE;
        this.noStandardDescriptorAccessor_ = false;
        this.bitField0_ &= 0xFFFFFFFD;
        this.deprecated_ = false;
        this.bitField0_ &= 0xFFFFFFFB;
        this.mapEntry_ = false;
        this.bitField0_ &= 0xFFFFFFF7;
        if (this.uninterpretedOptionBuilder_ == null) {
            this.uninterpretedOption_ = Collections.emptyList();
            this.bitField0_ &= 0xFFFFFFEF;
        }
        else {
            this.uninterpretedOptionBuilder_.clear();
        }
        return this;
    }
    
    public Descriptors$Descriptor getDescriptorForType() {
        return DescriptorProtos.internal_static_google_protobuf_MessageOptions_descriptor;
    }
    
    public DescriptorProtos$MessageOptions getDefaultInstanceForType() {
        return DescriptorProtos$MessageOptions.getDefaultInstance();
    }
    
    public DescriptorProtos$MessageOptions build() {
        final DescriptorProtos$MessageOptions buildPartial = this.buildPartial();
        if (!buildPartial.isInitialized()) {
            throw AbstractMessage$Builder.newUninitializedMessageException(buildPartial);
        }
        return buildPartial;
    }
    
    public DescriptorProtos$MessageOptions buildPartial() {
        final DescriptorProtos$MessageOptions descriptorProtos$MessageOptions = new DescriptorProtos$MessageOptions(this, null);
        final int bitField0_ = this.bitField0_;
        int n = 0;
        if ((bitField0_ & 0x1) == 0x1) {
            n |= 0x1;
        }
        descriptorProtos$MessageOptions.messageSetWireFormat_ = this.messageSetWireFormat_;
        if ((bitField0_ & 0x2) == 0x2) {
            n |= 0x2;
        }
        descriptorProtos$MessageOptions.noStandardDescriptorAccessor_ = this.noStandardDescriptorAccessor_;
        if ((bitField0_ & 0x4) == 0x4) {
            n |= 0x4;
        }
        descriptorProtos$MessageOptions.deprecated_ = this.deprecated_;
        if ((bitField0_ & 0x8) == 0x8) {
            n |= 0x8;
        }
        descriptorProtos$MessageOptions.mapEntry_ = this.mapEntry_;
        if (this.uninterpretedOptionBuilder_ == null) {
            if ((this.bitField0_ & 0x10) == 0x10) {
                this.uninterpretedOption_ = Collections.unmodifiableList((List<?>)this.uninterpretedOption_);
                this.bitField0_ &= 0xFFFFFFEF;
            }
            descriptorProtos$MessageOptions.uninterpretedOption_ = this.uninterpretedOption_;
        }
        else {
            descriptorProtos$MessageOptions.uninterpretedOption_ = this.uninterpretedOptionBuilder_.build();
        }
        descriptorProtos$MessageOptions.bitField0_ = n;
        this.onBuilt();
        return descriptorProtos$MessageOptions;
    }
    
    public DescriptorProtos$MessageOptions$Builder mergeFrom(final Message message) {
        if (message instanceof DescriptorProtos$MessageOptions) {
            return this.mergeFrom((DescriptorProtos$MessageOptions)message);
        }
        super.mergeFrom(message);
        return this;
    }
    
    public DescriptorProtos$MessageOptions$Builder mergeFrom(final DescriptorProtos$MessageOptions descriptorProtos$MessageOptions) {
        if (descriptorProtos$MessageOptions == DescriptorProtos$MessageOptions.getDefaultInstance()) {
            return this;
        }
        if (descriptorProtos$MessageOptions.hasMessageSetWireFormat()) {
            this.setMessageSetWireFormat(descriptorProtos$MessageOptions.getMessageSetWireFormat());
        }
        if (descriptorProtos$MessageOptions.hasNoStandardDescriptorAccessor()) {
            this.setNoStandardDescriptorAccessor(descriptorProtos$MessageOptions.getNoStandardDescriptorAccessor());
        }
        if (descriptorProtos$MessageOptions.hasDeprecated()) {
            this.setDeprecated(descriptorProtos$MessageOptions.getDeprecated());
        }
        if (descriptorProtos$MessageOptions.hasMapEntry()) {
            this.setMapEntry(descriptorProtos$MessageOptions.getMapEntry());
        }
        if (this.uninterpretedOptionBuilder_ == null) {
            if (!descriptorProtos$MessageOptions.uninterpretedOption_.isEmpty()) {
                if (this.uninterpretedOption_.isEmpty()) {
                    this.uninterpretedOption_ = descriptorProtos$MessageOptions.uninterpretedOption_;
                    this.bitField0_ &= 0xFFFFFFEF;
                }
                else {
                    this.ensureUninterpretedOptionIsMutable();
                    this.uninterpretedOption_.addAll(descriptorProtos$MessageOptions.uninterpretedOption_);
                }
                this.onChanged();
            }
        }
        else if (!descriptorProtos$MessageOptions.uninterpretedOption_.isEmpty()) {
            if (this.uninterpretedOptionBuilder_.isEmpty()) {
                this.uninterpretedOptionBuilder_.dispose();
                this.uninterpretedOptionBuilder_ = null;
                this.uninterpretedOption_ = descriptorProtos$MessageOptions.uninterpretedOption_;
                this.bitField0_ &= 0xFFFFFFEF;
                this.uninterpretedOptionBuilder_ = (GeneratedMessage.alwaysUseFieldBuilders ? this.getUninterpretedOptionFieldBuilder() : null);
            }
            else {
                this.uninterpretedOptionBuilder_.addAllMessages(descriptorProtos$MessageOptions.uninterpretedOption_);
            }
        }
        this.mergeExtensionFields(descriptorProtos$MessageOptions);
        this.mergeUnknownFields(descriptorProtos$MessageOptions.unknownFields);
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
    
    public DescriptorProtos$MessageOptions$Builder mergeFrom(final CodedInputStream codedInputStream, final ExtensionRegistryLite extensionRegistryLite) {
        DescriptorProtos$MessageOptions descriptorProtos$MessageOptions = null;
        try {
            descriptorProtos$MessageOptions = (DescriptorProtos$MessageOptions)DescriptorProtos$MessageOptions.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
        }
        catch (InvalidProtocolBufferException ex) {
            descriptorProtos$MessageOptions = (DescriptorProtos$MessageOptions)ex.getUnfinishedMessage();
            throw ex;
        }
        finally {
            if (descriptorProtos$MessageOptions != null) {
                this.mergeFrom(descriptorProtos$MessageOptions);
            }
        }
        return this;
    }
    
    public boolean hasMessageSetWireFormat() {
        return (this.bitField0_ & 0x1) == 0x1;
    }
    
    public boolean getMessageSetWireFormat() {
        return this.messageSetWireFormat_;
    }
    
    public DescriptorProtos$MessageOptions$Builder setMessageSetWireFormat(final boolean messageSetWireFormat_) {
        this.bitField0_ |= 0x1;
        this.messageSetWireFormat_ = messageSetWireFormat_;
        this.onChanged();
        return this;
    }
    
    public DescriptorProtos$MessageOptions$Builder clearMessageSetWireFormat() {
        this.bitField0_ &= 0xFFFFFFFE;
        this.messageSetWireFormat_ = false;
        this.onChanged();
        return this;
    }
    
    public boolean hasNoStandardDescriptorAccessor() {
        return (this.bitField0_ & 0x2) == 0x2;
    }
    
    public boolean getNoStandardDescriptorAccessor() {
        return this.noStandardDescriptorAccessor_;
    }
    
    public DescriptorProtos$MessageOptions$Builder setNoStandardDescriptorAccessor(final boolean noStandardDescriptorAccessor_) {
        this.bitField0_ |= 0x2;
        this.noStandardDescriptorAccessor_ = noStandardDescriptorAccessor_;
        this.onChanged();
        return this;
    }
    
    public DescriptorProtos$MessageOptions$Builder clearNoStandardDescriptorAccessor() {
        this.bitField0_ &= 0xFFFFFFFD;
        this.noStandardDescriptorAccessor_ = false;
        this.onChanged();
        return this;
    }
    
    public boolean hasDeprecated() {
        return (this.bitField0_ & 0x4) == 0x4;
    }
    
    public boolean getDeprecated() {
        return this.deprecated_;
    }
    
    public DescriptorProtos$MessageOptions$Builder setDeprecated(final boolean deprecated_) {
        this.bitField0_ |= 0x4;
        this.deprecated_ = deprecated_;
        this.onChanged();
        return this;
    }
    
    public DescriptorProtos$MessageOptions$Builder clearDeprecated() {
        this.bitField0_ &= 0xFFFFFFFB;
        this.deprecated_ = false;
        this.onChanged();
        return this;
    }
    
    public boolean hasMapEntry() {
        return (this.bitField0_ & 0x8) == 0x8;
    }
    
    public boolean getMapEntry() {
        return this.mapEntry_;
    }
    
    public DescriptorProtos$MessageOptions$Builder setMapEntry(final boolean mapEntry_) {
        this.bitField0_ |= 0x8;
        this.mapEntry_ = mapEntry_;
        this.onChanged();
        return this;
    }
    
    public DescriptorProtos$MessageOptions$Builder clearMapEntry() {
        this.bitField0_ &= 0xFFFFFFF7;
        this.mapEntry_ = false;
        this.onChanged();
        return this;
    }
    
    private void ensureUninterpretedOptionIsMutable() {
        if ((this.bitField0_ & 0x10) != 0x10) {
            this.uninterpretedOption_ = new ArrayList(this.uninterpretedOption_);
            this.bitField0_ |= 0x10;
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
    
    public DescriptorProtos$MessageOptions$Builder setUninterpretedOption(final int n, final DescriptorProtos$UninterpretedOption descriptorProtos$UninterpretedOption) {
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
    
    public DescriptorProtos$MessageOptions$Builder setUninterpretedOption(final int n, final DescriptorProtos$UninterpretedOption$Builder descriptorProtos$UninterpretedOption$Builder) {
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
    
    public DescriptorProtos$MessageOptions$Builder addUninterpretedOption(final DescriptorProtos$UninterpretedOption descriptorProtos$UninterpretedOption) {
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
    
    public DescriptorProtos$MessageOptions$Builder addUninterpretedOption(final int n, final DescriptorProtos$UninterpretedOption descriptorProtos$UninterpretedOption) {
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
    
    public DescriptorProtos$MessageOptions$Builder addUninterpretedOption(final DescriptorProtos$UninterpretedOption$Builder descriptorProtos$UninterpretedOption$Builder) {
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
    
    public DescriptorProtos$MessageOptions$Builder addUninterpretedOption(final int n, final DescriptorProtos$UninterpretedOption$Builder descriptorProtos$UninterpretedOption$Builder) {
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
    
    public DescriptorProtos$MessageOptions$Builder addAllUninterpretedOption(final Iterable iterable) {
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
    
    public DescriptorProtos$MessageOptions$Builder clearUninterpretedOption() {
        if (this.uninterpretedOptionBuilder_ == null) {
            this.uninterpretedOption_ = Collections.emptyList();
            this.bitField0_ &= 0xFFFFFFEF;
            this.onChanged();
        }
        else {
            this.uninterpretedOptionBuilder_.clear();
        }
        return this;
    }
    
    public DescriptorProtos$MessageOptions$Builder removeUninterpretedOption(final int n) {
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
            this.uninterpretedOptionBuilder_ = new RepeatedFieldBuilder(this.uninterpretedOption_, (this.bitField0_ & 0x10) == 0x10, this.getParentForChildren(), this.isClean());
            this.uninterpretedOption_ = null;
        }
        return this.uninterpretedOptionBuilder_;
    }
}
