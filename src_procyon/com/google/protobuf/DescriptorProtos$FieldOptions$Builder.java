package com.google.protobuf;

import java.util.*;
import java.io.*;

public final class DescriptorProtos$FieldOptions$Builder extends GeneratedMessage$ExtendableBuilder implements DescriptorProtos$FieldOptionsOrBuilder
{
    private int bitField0_;
    private int ctype_;
    private boolean packed_;
    private int jstype_;
    private boolean lazy_;
    private boolean deprecated_;
    private boolean weak_;
    private List uninterpretedOption_;
    private RepeatedFieldBuilder uninterpretedOptionBuilder_;
    
    public static final Descriptors$Descriptor getDescriptor() {
        return DescriptorProtos.internal_static_google_protobuf_FieldOptions_descriptor;
    }
    
    protected GeneratedMessage$FieldAccessorTable internalGetFieldAccessorTable() {
        return DescriptorProtos.internal_static_google_protobuf_FieldOptions_fieldAccessorTable.ensureFieldAccessorsInitialized(DescriptorProtos$FieldOptions.class, DescriptorProtos$FieldOptions$Builder.class);
    }
    
    private DescriptorProtos$FieldOptions$Builder() {
        this.ctype_ = 0;
        this.jstype_ = 0;
        this.uninterpretedOption_ = Collections.emptyList();
        this.maybeForceBuilderInitialization();
    }
    
    private DescriptorProtos$FieldOptions$Builder(final GeneratedMessage$BuilderParent generatedMessage$BuilderParent) {
        super(generatedMessage$BuilderParent);
        this.ctype_ = 0;
        this.jstype_ = 0;
        this.uninterpretedOption_ = Collections.emptyList();
        this.maybeForceBuilderInitialization();
    }
    
    private void maybeForceBuilderInitialization() {
        if (GeneratedMessage.alwaysUseFieldBuilders) {
            this.getUninterpretedOptionFieldBuilder();
        }
    }
    
    public DescriptorProtos$FieldOptions$Builder clear() {
        super.clear();
        this.ctype_ = 0;
        this.bitField0_ &= 0xFFFFFFFE;
        this.packed_ = false;
        this.bitField0_ &= 0xFFFFFFFD;
        this.jstype_ = 0;
        this.bitField0_ &= 0xFFFFFFFB;
        this.lazy_ = false;
        this.bitField0_ &= 0xFFFFFFF7;
        this.deprecated_ = false;
        this.bitField0_ &= 0xFFFFFFEF;
        this.weak_ = false;
        this.bitField0_ &= 0xFFFFFFDF;
        if (this.uninterpretedOptionBuilder_ == null) {
            this.uninterpretedOption_ = Collections.emptyList();
            this.bitField0_ &= 0xFFFFFFBF;
        }
        else {
            this.uninterpretedOptionBuilder_.clear();
        }
        return this;
    }
    
    public Descriptors$Descriptor getDescriptorForType() {
        return DescriptorProtos.internal_static_google_protobuf_FieldOptions_descriptor;
    }
    
    public DescriptorProtos$FieldOptions getDefaultInstanceForType() {
        return DescriptorProtos$FieldOptions.getDefaultInstance();
    }
    
    public DescriptorProtos$FieldOptions build() {
        final DescriptorProtos$FieldOptions buildPartial = this.buildPartial();
        if (!buildPartial.isInitialized()) {
            throw AbstractMessage$Builder.newUninitializedMessageException(buildPartial);
        }
        return buildPartial;
    }
    
    public DescriptorProtos$FieldOptions buildPartial() {
        final DescriptorProtos$FieldOptions descriptorProtos$FieldOptions = new DescriptorProtos$FieldOptions(this, null);
        final int bitField0_ = this.bitField0_;
        int n = 0;
        if ((bitField0_ & 0x1) == 0x1) {
            n |= 0x1;
        }
        descriptorProtos$FieldOptions.ctype_ = this.ctype_;
        if ((bitField0_ & 0x2) == 0x2) {
            n |= 0x2;
        }
        descriptorProtos$FieldOptions.packed_ = this.packed_;
        if ((bitField0_ & 0x4) == 0x4) {
            n |= 0x4;
        }
        descriptorProtos$FieldOptions.jstype_ = this.jstype_;
        if ((bitField0_ & 0x8) == 0x8) {
            n |= 0x8;
        }
        descriptorProtos$FieldOptions.lazy_ = this.lazy_;
        if ((bitField0_ & 0x10) == 0x10) {
            n |= 0x10;
        }
        descriptorProtos$FieldOptions.deprecated_ = this.deprecated_;
        if ((bitField0_ & 0x20) == 0x20) {
            n |= 0x20;
        }
        descriptorProtos$FieldOptions.weak_ = this.weak_;
        if (this.uninterpretedOptionBuilder_ == null) {
            if ((this.bitField0_ & 0x40) == 0x40) {
                this.uninterpretedOption_ = Collections.unmodifiableList((List<?>)this.uninterpretedOption_);
                this.bitField0_ &= 0xFFFFFFBF;
            }
            descriptorProtos$FieldOptions.uninterpretedOption_ = this.uninterpretedOption_;
        }
        else {
            descriptorProtos$FieldOptions.uninterpretedOption_ = this.uninterpretedOptionBuilder_.build();
        }
        descriptorProtos$FieldOptions.bitField0_ = n;
        this.onBuilt();
        return descriptorProtos$FieldOptions;
    }
    
    public DescriptorProtos$FieldOptions$Builder mergeFrom(final Message message) {
        if (message instanceof DescriptorProtos$FieldOptions) {
            return this.mergeFrom((DescriptorProtos$FieldOptions)message);
        }
        super.mergeFrom(message);
        return this;
    }
    
    public DescriptorProtos$FieldOptions$Builder mergeFrom(final DescriptorProtos$FieldOptions descriptorProtos$FieldOptions) {
        if (descriptorProtos$FieldOptions == DescriptorProtos$FieldOptions.getDefaultInstance()) {
            return this;
        }
        if (descriptorProtos$FieldOptions.hasCtype()) {
            this.setCtype(descriptorProtos$FieldOptions.getCtype());
        }
        if (descriptorProtos$FieldOptions.hasPacked()) {
            this.setPacked(descriptorProtos$FieldOptions.getPacked());
        }
        if (descriptorProtos$FieldOptions.hasJstype()) {
            this.setJstype(descriptorProtos$FieldOptions.getJstype());
        }
        if (descriptorProtos$FieldOptions.hasLazy()) {
            this.setLazy(descriptorProtos$FieldOptions.getLazy());
        }
        if (descriptorProtos$FieldOptions.hasDeprecated()) {
            this.setDeprecated(descriptorProtos$FieldOptions.getDeprecated());
        }
        if (descriptorProtos$FieldOptions.hasWeak()) {
            this.setWeak(descriptorProtos$FieldOptions.getWeak());
        }
        if (this.uninterpretedOptionBuilder_ == null) {
            if (!descriptorProtos$FieldOptions.uninterpretedOption_.isEmpty()) {
                if (this.uninterpretedOption_.isEmpty()) {
                    this.uninterpretedOption_ = descriptorProtos$FieldOptions.uninterpretedOption_;
                    this.bitField0_ &= 0xFFFFFFBF;
                }
                else {
                    this.ensureUninterpretedOptionIsMutable();
                    this.uninterpretedOption_.addAll(descriptorProtos$FieldOptions.uninterpretedOption_);
                }
                this.onChanged();
            }
        }
        else if (!descriptorProtos$FieldOptions.uninterpretedOption_.isEmpty()) {
            if (this.uninterpretedOptionBuilder_.isEmpty()) {
                this.uninterpretedOptionBuilder_.dispose();
                this.uninterpretedOptionBuilder_ = null;
                this.uninterpretedOption_ = descriptorProtos$FieldOptions.uninterpretedOption_;
                this.bitField0_ &= 0xFFFFFFBF;
                this.uninterpretedOptionBuilder_ = (GeneratedMessage.alwaysUseFieldBuilders ? this.getUninterpretedOptionFieldBuilder() : null);
            }
            else {
                this.uninterpretedOptionBuilder_.addAllMessages(descriptorProtos$FieldOptions.uninterpretedOption_);
            }
        }
        this.mergeExtensionFields(descriptorProtos$FieldOptions);
        this.mergeUnknownFields(descriptorProtos$FieldOptions.unknownFields);
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
    
    public DescriptorProtos$FieldOptions$Builder mergeFrom(final CodedInputStream codedInputStream, final ExtensionRegistryLite extensionRegistryLite) {
        DescriptorProtos$FieldOptions descriptorProtos$FieldOptions = null;
        try {
            descriptorProtos$FieldOptions = (DescriptorProtos$FieldOptions)DescriptorProtos$FieldOptions.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
        }
        catch (InvalidProtocolBufferException ex) {
            descriptorProtos$FieldOptions = (DescriptorProtos$FieldOptions)ex.getUnfinishedMessage();
            throw ex;
        }
        finally {
            if (descriptorProtos$FieldOptions != null) {
                this.mergeFrom(descriptorProtos$FieldOptions);
            }
        }
        return this;
    }
    
    public boolean hasCtype() {
        return (this.bitField0_ & 0x1) == 0x1;
    }
    
    public DescriptorProtos$FieldOptions$CType getCtype() {
        final DescriptorProtos$FieldOptions$CType value = DescriptorProtos$FieldOptions$CType.valueOf(this.ctype_);
        return (value == null) ? DescriptorProtos$FieldOptions$CType.STRING : value;
    }
    
    public DescriptorProtos$FieldOptions$Builder setCtype(final DescriptorProtos$FieldOptions$CType descriptorProtos$FieldOptions$CType) {
        if (descriptorProtos$FieldOptions$CType == null) {
            throw new NullPointerException();
        }
        this.bitField0_ |= 0x1;
        this.ctype_ = descriptorProtos$FieldOptions$CType.getNumber();
        this.onChanged();
        return this;
    }
    
    public DescriptorProtos$FieldOptions$Builder clearCtype() {
        this.bitField0_ &= 0xFFFFFFFE;
        this.ctype_ = 0;
        this.onChanged();
        return this;
    }
    
    public boolean hasPacked() {
        return (this.bitField0_ & 0x2) == 0x2;
    }
    
    public boolean getPacked() {
        return this.packed_;
    }
    
    public DescriptorProtos$FieldOptions$Builder setPacked(final boolean packed_) {
        this.bitField0_ |= 0x2;
        this.packed_ = packed_;
        this.onChanged();
        return this;
    }
    
    public DescriptorProtos$FieldOptions$Builder clearPacked() {
        this.bitField0_ &= 0xFFFFFFFD;
        this.packed_ = false;
        this.onChanged();
        return this;
    }
    
    public boolean hasJstype() {
        return (this.bitField0_ & 0x4) == 0x4;
    }
    
    public DescriptorProtos$FieldOptions$JSType getJstype() {
        final DescriptorProtos$FieldOptions$JSType value = DescriptorProtos$FieldOptions$JSType.valueOf(this.jstype_);
        return (value == null) ? DescriptorProtos$FieldOptions$JSType.JS_NORMAL : value;
    }
    
    public DescriptorProtos$FieldOptions$Builder setJstype(final DescriptorProtos$FieldOptions$JSType descriptorProtos$FieldOptions$JSType) {
        if (descriptorProtos$FieldOptions$JSType == null) {
            throw new NullPointerException();
        }
        this.bitField0_ |= 0x4;
        this.jstype_ = descriptorProtos$FieldOptions$JSType.getNumber();
        this.onChanged();
        return this;
    }
    
    public DescriptorProtos$FieldOptions$Builder clearJstype() {
        this.bitField0_ &= 0xFFFFFFFB;
        this.jstype_ = 0;
        this.onChanged();
        return this;
    }
    
    public boolean hasLazy() {
        return (this.bitField0_ & 0x8) == 0x8;
    }
    
    public boolean getLazy() {
        return this.lazy_;
    }
    
    public DescriptorProtos$FieldOptions$Builder setLazy(final boolean lazy_) {
        this.bitField0_ |= 0x8;
        this.lazy_ = lazy_;
        this.onChanged();
        return this;
    }
    
    public DescriptorProtos$FieldOptions$Builder clearLazy() {
        this.bitField0_ &= 0xFFFFFFF7;
        this.lazy_ = false;
        this.onChanged();
        return this;
    }
    
    public boolean hasDeprecated() {
        return (this.bitField0_ & 0x10) == 0x10;
    }
    
    public boolean getDeprecated() {
        return this.deprecated_;
    }
    
    public DescriptorProtos$FieldOptions$Builder setDeprecated(final boolean deprecated_) {
        this.bitField0_ |= 0x10;
        this.deprecated_ = deprecated_;
        this.onChanged();
        return this;
    }
    
    public DescriptorProtos$FieldOptions$Builder clearDeprecated() {
        this.bitField0_ &= 0xFFFFFFEF;
        this.deprecated_ = false;
        this.onChanged();
        return this;
    }
    
    public boolean hasWeak() {
        return (this.bitField0_ & 0x20) == 0x20;
    }
    
    public boolean getWeak() {
        return this.weak_;
    }
    
    public DescriptorProtos$FieldOptions$Builder setWeak(final boolean weak_) {
        this.bitField0_ |= 0x20;
        this.weak_ = weak_;
        this.onChanged();
        return this;
    }
    
    public DescriptorProtos$FieldOptions$Builder clearWeak() {
        this.bitField0_ &= 0xFFFFFFDF;
        this.weak_ = false;
        this.onChanged();
        return this;
    }
    
    private void ensureUninterpretedOptionIsMutable() {
        if ((this.bitField0_ & 0x40) != 0x40) {
            this.uninterpretedOption_ = new ArrayList(this.uninterpretedOption_);
            this.bitField0_ |= 0x40;
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
    
    public DescriptorProtos$FieldOptions$Builder setUninterpretedOption(final int n, final DescriptorProtos$UninterpretedOption descriptorProtos$UninterpretedOption) {
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
    
    public DescriptorProtos$FieldOptions$Builder setUninterpretedOption(final int n, final DescriptorProtos$UninterpretedOption$Builder descriptorProtos$UninterpretedOption$Builder) {
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
    
    public DescriptorProtos$FieldOptions$Builder addUninterpretedOption(final DescriptorProtos$UninterpretedOption descriptorProtos$UninterpretedOption) {
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
    
    public DescriptorProtos$FieldOptions$Builder addUninterpretedOption(final int n, final DescriptorProtos$UninterpretedOption descriptorProtos$UninterpretedOption) {
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
    
    public DescriptorProtos$FieldOptions$Builder addUninterpretedOption(final DescriptorProtos$UninterpretedOption$Builder descriptorProtos$UninterpretedOption$Builder) {
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
    
    public DescriptorProtos$FieldOptions$Builder addUninterpretedOption(final int n, final DescriptorProtos$UninterpretedOption$Builder descriptorProtos$UninterpretedOption$Builder) {
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
    
    public DescriptorProtos$FieldOptions$Builder addAllUninterpretedOption(final Iterable iterable) {
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
    
    public DescriptorProtos$FieldOptions$Builder clearUninterpretedOption() {
        if (this.uninterpretedOptionBuilder_ == null) {
            this.uninterpretedOption_ = Collections.emptyList();
            this.bitField0_ &= 0xFFFFFFBF;
            this.onChanged();
        }
        else {
            this.uninterpretedOptionBuilder_.clear();
        }
        return this;
    }
    
    public DescriptorProtos$FieldOptions$Builder removeUninterpretedOption(final int n) {
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
            this.uninterpretedOptionBuilder_ = new RepeatedFieldBuilder(this.uninterpretedOption_, (this.bitField0_ & 0x40) == 0x40, this.getParentForChildren(), this.isClean());
            this.uninterpretedOption_ = null;
        }
        return this.uninterpretedOptionBuilder_;
    }
}
