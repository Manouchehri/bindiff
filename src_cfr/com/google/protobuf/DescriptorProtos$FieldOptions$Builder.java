/*
 * Decompiled with CFR 0_115.
 */
package com.google.protobuf;

import com.google.protobuf.AbstractMessage$Builder;
import com.google.protobuf.AbstractMessageLite$Builder;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.DescriptorProtos;
import com.google.protobuf.DescriptorProtos$1;
import com.google.protobuf.DescriptorProtos$FieldOptions;
import com.google.protobuf.DescriptorProtos$FieldOptions$CType;
import com.google.protobuf.DescriptorProtos$FieldOptions$JSType;
import com.google.protobuf.DescriptorProtos$FieldOptionsOrBuilder;
import com.google.protobuf.DescriptorProtos$UninterpretedOption;
import com.google.protobuf.DescriptorProtos$UninterpretedOption$Builder;
import com.google.protobuf.DescriptorProtos$UninterpretedOptionOrBuilder;
import com.google.protobuf.Descriptors$Descriptor;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessage;
import com.google.protobuf.GeneratedMessage$Builder;
import com.google.protobuf.GeneratedMessage$BuilderParent;
import com.google.protobuf.GeneratedMessage$ExtendableBuilder;
import com.google.protobuf.GeneratedMessage$ExtendableMessage;
import com.google.protobuf.GeneratedMessage$FieldAccessorTable;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.Message;
import com.google.protobuf.Message$Builder;
import com.google.protobuf.MessageLite;
import com.google.protobuf.MessageLite$Builder;
import com.google.protobuf.MessageOrBuilder;
import com.google.protobuf.Parser;
import com.google.protobuf.RepeatedFieldBuilder;
import com.google.protobuf.UnknownFieldSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public final class DescriptorProtos$FieldOptions$Builder
extends GeneratedMessage$ExtendableBuilder
implements DescriptorProtos$FieldOptionsOrBuilder {
    private int bitField0_;
    private int ctype_ = 0;
    private boolean packed_;
    private int jstype_ = 0;
    private boolean lazy_;
    private boolean deprecated_;
    private boolean weak_;
    private List uninterpretedOption_ = Collections.emptyList();
    private RepeatedFieldBuilder uninterpretedOptionBuilder_;

    public static final Descriptors$Descriptor getDescriptor() {
        return DescriptorProtos.access$16200();
    }

    @Override
    protected GeneratedMessage$FieldAccessorTable internalGetFieldAccessorTable() {
        return DescriptorProtos.access$16300().ensureFieldAccessorsInitialized(DescriptorProtos$FieldOptions.class, DescriptorProtos$FieldOptions$Builder.class);
    }

    private DescriptorProtos$FieldOptions$Builder() {
        this.maybeForceBuilderInitialization();
    }

    private DescriptorProtos$FieldOptions$Builder(GeneratedMessage$BuilderParent generatedMessage$BuilderParent) {
        super(generatedMessage$BuilderParent);
        this.maybeForceBuilderInitialization();
    }

    private void maybeForceBuilderInitialization() {
        if (!GeneratedMessage.alwaysUseFieldBuilders) return;
        this.getUninterpretedOptionFieldBuilder();
    }

    @Override
    public DescriptorProtos$FieldOptions$Builder clear() {
        super.clear();
        this.ctype_ = 0;
        this.bitField0_ &= -2;
        this.packed_ = false;
        this.bitField0_ &= -3;
        this.jstype_ = 0;
        this.bitField0_ &= -5;
        this.lazy_ = false;
        this.bitField0_ &= -9;
        this.deprecated_ = false;
        this.bitField0_ &= -17;
        this.weak_ = false;
        this.bitField0_ &= -33;
        if (this.uninterpretedOptionBuilder_ == null) {
            this.uninterpretedOption_ = Collections.emptyList();
            this.bitField0_ &= -65;
            return this;
        }
        this.uninterpretedOptionBuilder_.clear();
        return this;
    }

    @Override
    public Descriptors$Descriptor getDescriptorForType() {
        return DescriptorProtos.access$16200();
    }

    @Override
    public DescriptorProtos$FieldOptions getDefaultInstanceForType() {
        return DescriptorProtos$FieldOptions.getDefaultInstance();
    }

    @Override
    public DescriptorProtos$FieldOptions build() {
        DescriptorProtos$FieldOptions descriptorProtos$FieldOptions = this.buildPartial();
        if (descriptorProtos$FieldOptions.isInitialized()) return descriptorProtos$FieldOptions;
        throw DescriptorProtos$FieldOptions$Builder.newUninitializedMessageException(descriptorProtos$FieldOptions);
    }

    @Override
    public DescriptorProtos$FieldOptions buildPartial() {
        DescriptorProtos$FieldOptions descriptorProtos$FieldOptions = new DescriptorProtos$FieldOptions(this, null);
        int n2 = this.bitField0_;
        int n3 = 0;
        if ((n2 & 1) == 1) {
            n3 |= true;
        }
        DescriptorProtos$FieldOptions.access$16702(descriptorProtos$FieldOptions, this.ctype_);
        if ((n2 & 2) == 2) {
            n3 |= 2;
        }
        DescriptorProtos$FieldOptions.access$16802(descriptorProtos$FieldOptions, this.packed_);
        if ((n2 & 4) == 4) {
            n3 |= 4;
        }
        DescriptorProtos$FieldOptions.access$16902(descriptorProtos$FieldOptions, this.jstype_);
        if ((n2 & 8) == 8) {
            n3 |= 8;
        }
        DescriptorProtos$FieldOptions.access$17002(descriptorProtos$FieldOptions, this.lazy_);
        if ((n2 & 16) == 16) {
            n3 |= 16;
        }
        DescriptorProtos$FieldOptions.access$17102(descriptorProtos$FieldOptions, this.deprecated_);
        if ((n2 & 32) == 32) {
            n3 |= 32;
        }
        DescriptorProtos$FieldOptions.access$17202(descriptorProtos$FieldOptions, this.weak_);
        if (this.uninterpretedOptionBuilder_ == null) {
            if ((this.bitField0_ & 64) == 64) {
                this.uninterpretedOption_ = Collections.unmodifiableList(this.uninterpretedOption_);
                this.bitField0_ &= -65;
            }
            DescriptorProtos$FieldOptions.access$17302(descriptorProtos$FieldOptions, this.uninterpretedOption_);
        } else {
            DescriptorProtos$FieldOptions.access$17302(descriptorProtos$FieldOptions, this.uninterpretedOptionBuilder_.build());
        }
        DescriptorProtos$FieldOptions.access$17402(descriptorProtos$FieldOptions, n3);
        this.onBuilt();
        return descriptorProtos$FieldOptions;
    }

    @Override
    public DescriptorProtos$FieldOptions$Builder mergeFrom(Message message) {
        if (message instanceof DescriptorProtos$FieldOptions) {
            return this.mergeFrom((DescriptorProtos$FieldOptions)message);
        }
        super.mergeFrom(message);
        return this;
    }

    public DescriptorProtos$FieldOptions$Builder mergeFrom(DescriptorProtos$FieldOptions descriptorProtos$FieldOptions) {
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
            if (!DescriptorProtos$FieldOptions.access$17300(descriptorProtos$FieldOptions).isEmpty()) {
                if (this.uninterpretedOption_.isEmpty()) {
                    this.uninterpretedOption_ = DescriptorProtos$FieldOptions.access$17300(descriptorProtos$FieldOptions);
                    this.bitField0_ &= -65;
                } else {
                    this.ensureUninterpretedOptionIsMutable();
                    this.uninterpretedOption_.addAll(DescriptorProtos$FieldOptions.access$17300(descriptorProtos$FieldOptions));
                }
                this.onChanged();
            }
        } else if (!DescriptorProtos$FieldOptions.access$17300(descriptorProtos$FieldOptions).isEmpty()) {
            if (this.uninterpretedOptionBuilder_.isEmpty()) {
                this.uninterpretedOptionBuilder_.dispose();
                this.uninterpretedOptionBuilder_ = null;
                this.uninterpretedOption_ = DescriptorProtos$FieldOptions.access$17300(descriptorProtos$FieldOptions);
                this.bitField0_ &= -65;
                this.uninterpretedOptionBuilder_ = GeneratedMessage.alwaysUseFieldBuilders ? this.getUninterpretedOptionFieldBuilder() : null;
            } else {
                this.uninterpretedOptionBuilder_.addAllMessages(DescriptorProtos$FieldOptions.access$17300(descriptorProtos$FieldOptions));
            }
        }
        this.mergeExtensionFields(descriptorProtos$FieldOptions);
        this.mergeUnknownFields(descriptorProtos$FieldOptions.unknownFields);
        this.onChanged();
        return this;
    }

    @Override
    public final boolean isInitialized() {
        int n2 = 0;
        do {
            if (n2 >= this.getUninterpretedOptionCount()) {
                if (this.extensionsAreInitialized()) return true;
                return false;
            }
            if (!this.getUninterpretedOption(n2).isInitialized()) {
                return false;
            }
            ++n2;
        } while (true);
    }

    @Override
    public DescriptorProtos$FieldOptions$Builder mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        DescriptorProtos$FieldOptions descriptorProtos$FieldOptions = null;
        try {
            try {
                descriptorProtos$FieldOptions = (DescriptorProtos$FieldOptions)DescriptorProtos$FieldOptions.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
            }
            catch (InvalidProtocolBufferException var4_6) {
                descriptorProtos$FieldOptions = (DescriptorProtos$FieldOptions)var4_6.getUnfinishedMessage();
                throw var4_6;
            }
            Object var6_4 = null;
            if (descriptorProtos$FieldOptions == null) return this;
            this.mergeFrom(descriptorProtos$FieldOptions);
            return this;
        }
        catch (Throwable var5_7) {
            Object var6_5 = null;
            if (descriptorProtos$FieldOptions == null) throw var5_7;
            this.mergeFrom(descriptorProtos$FieldOptions);
            throw var5_7;
        }
    }

    @Override
    public boolean hasCtype() {
        if ((this.bitField0_ & 1) != 1) return false;
        return true;
    }

    @Override
    public DescriptorProtos$FieldOptions$CType getCtype() {
        DescriptorProtos$FieldOptions$CType descriptorProtos$FieldOptions$CType;
        DescriptorProtos$FieldOptions$CType descriptorProtos$FieldOptions$CType2 = DescriptorProtos$FieldOptions$CType.valueOf(this.ctype_);
        if (descriptorProtos$FieldOptions$CType2 == null) {
            descriptorProtos$FieldOptions$CType = DescriptorProtos$FieldOptions$CType.STRING;
            return descriptorProtos$FieldOptions$CType;
        }
        descriptorProtos$FieldOptions$CType = descriptorProtos$FieldOptions$CType2;
        return descriptorProtos$FieldOptions$CType;
    }

    public DescriptorProtos$FieldOptions$Builder setCtype(DescriptorProtos$FieldOptions$CType descriptorProtos$FieldOptions$CType) {
        if (descriptorProtos$FieldOptions$CType == null) {
            throw new NullPointerException();
        }
        this.bitField0_ |= 1;
        this.ctype_ = descriptorProtos$FieldOptions$CType.getNumber();
        this.onChanged();
        return this;
    }

    public DescriptorProtos$FieldOptions$Builder clearCtype() {
        this.bitField0_ &= -2;
        this.ctype_ = 0;
        this.onChanged();
        return this;
    }

    @Override
    public boolean hasPacked() {
        if ((this.bitField0_ & 2) != 2) return false;
        return true;
    }

    @Override
    public boolean getPacked() {
        return this.packed_;
    }

    public DescriptorProtos$FieldOptions$Builder setPacked(boolean bl2) {
        this.bitField0_ |= 2;
        this.packed_ = bl2;
        this.onChanged();
        return this;
    }

    public DescriptorProtos$FieldOptions$Builder clearPacked() {
        this.bitField0_ &= -3;
        this.packed_ = false;
        this.onChanged();
        return this;
    }

    @Override
    public boolean hasJstype() {
        if ((this.bitField0_ & 4) != 4) return false;
        return true;
    }

    @Override
    public DescriptorProtos$FieldOptions$JSType getJstype() {
        DescriptorProtos$FieldOptions$JSType descriptorProtos$FieldOptions$JSType;
        DescriptorProtos$FieldOptions$JSType descriptorProtos$FieldOptions$JSType2 = DescriptorProtos$FieldOptions$JSType.valueOf(this.jstype_);
        if (descriptorProtos$FieldOptions$JSType2 == null) {
            descriptorProtos$FieldOptions$JSType = DescriptorProtos$FieldOptions$JSType.JS_NORMAL;
            return descriptorProtos$FieldOptions$JSType;
        }
        descriptorProtos$FieldOptions$JSType = descriptorProtos$FieldOptions$JSType2;
        return descriptorProtos$FieldOptions$JSType;
    }

    public DescriptorProtos$FieldOptions$Builder setJstype(DescriptorProtos$FieldOptions$JSType descriptorProtos$FieldOptions$JSType) {
        if (descriptorProtos$FieldOptions$JSType == null) {
            throw new NullPointerException();
        }
        this.bitField0_ |= 4;
        this.jstype_ = descriptorProtos$FieldOptions$JSType.getNumber();
        this.onChanged();
        return this;
    }

    public DescriptorProtos$FieldOptions$Builder clearJstype() {
        this.bitField0_ &= -5;
        this.jstype_ = 0;
        this.onChanged();
        return this;
    }

    @Override
    public boolean hasLazy() {
        if ((this.bitField0_ & 8) != 8) return false;
        return true;
    }

    @Override
    public boolean getLazy() {
        return this.lazy_;
    }

    public DescriptorProtos$FieldOptions$Builder setLazy(boolean bl2) {
        this.bitField0_ |= 8;
        this.lazy_ = bl2;
        this.onChanged();
        return this;
    }

    public DescriptorProtos$FieldOptions$Builder clearLazy() {
        this.bitField0_ &= -9;
        this.lazy_ = false;
        this.onChanged();
        return this;
    }

    @Override
    public boolean hasDeprecated() {
        if ((this.bitField0_ & 16) != 16) return false;
        return true;
    }

    @Override
    public boolean getDeprecated() {
        return this.deprecated_;
    }

    public DescriptorProtos$FieldOptions$Builder setDeprecated(boolean bl2) {
        this.bitField0_ |= 16;
        this.deprecated_ = bl2;
        this.onChanged();
        return this;
    }

    public DescriptorProtos$FieldOptions$Builder clearDeprecated() {
        this.bitField0_ &= -17;
        this.deprecated_ = false;
        this.onChanged();
        return this;
    }

    @Override
    public boolean hasWeak() {
        if ((this.bitField0_ & 32) != 32) return false;
        return true;
    }

    @Override
    public boolean getWeak() {
        return this.weak_;
    }

    public DescriptorProtos$FieldOptions$Builder setWeak(boolean bl2) {
        this.bitField0_ |= 32;
        this.weak_ = bl2;
        this.onChanged();
        return this;
    }

    public DescriptorProtos$FieldOptions$Builder clearWeak() {
        this.bitField0_ &= -33;
        this.weak_ = false;
        this.onChanged();
        return this;
    }

    private void ensureUninterpretedOptionIsMutable() {
        if ((this.bitField0_ & 64) == 64) return;
        this.uninterpretedOption_ = new ArrayList(this.uninterpretedOption_);
        this.bitField0_ |= 64;
    }

    @Override
    public List getUninterpretedOptionList() {
        if (this.uninterpretedOptionBuilder_ != null) return this.uninterpretedOptionBuilder_.getMessageList();
        return Collections.unmodifiableList(this.uninterpretedOption_);
    }

    @Override
    public int getUninterpretedOptionCount() {
        if (this.uninterpretedOptionBuilder_ != null) return this.uninterpretedOptionBuilder_.getCount();
        return this.uninterpretedOption_.size();
    }

    @Override
    public DescriptorProtos$UninterpretedOption getUninterpretedOption(int n2) {
        if (this.uninterpretedOptionBuilder_ != null) return (DescriptorProtos$UninterpretedOption)this.uninterpretedOptionBuilder_.getMessage(n2);
        return (DescriptorProtos$UninterpretedOption)this.uninterpretedOption_.get(n2);
    }

    public DescriptorProtos$FieldOptions$Builder setUninterpretedOption(int n2, DescriptorProtos$UninterpretedOption descriptorProtos$UninterpretedOption) {
        if (this.uninterpretedOptionBuilder_ != null) {
            this.uninterpretedOptionBuilder_.setMessage(n2, descriptorProtos$UninterpretedOption);
            return this;
        }
        if (descriptorProtos$UninterpretedOption == null) {
            throw new NullPointerException();
        }
        this.ensureUninterpretedOptionIsMutable();
        this.uninterpretedOption_.set(n2, descriptorProtos$UninterpretedOption);
        this.onChanged();
        return this;
    }

    public DescriptorProtos$FieldOptions$Builder setUninterpretedOption(int n2, DescriptorProtos$UninterpretedOption$Builder descriptorProtos$UninterpretedOption$Builder) {
        if (this.uninterpretedOptionBuilder_ == null) {
            this.ensureUninterpretedOptionIsMutable();
            this.uninterpretedOption_.set(n2, descriptorProtos$UninterpretedOption$Builder.build());
            this.onChanged();
            return this;
        }
        this.uninterpretedOptionBuilder_.setMessage(n2, descriptorProtos$UninterpretedOption$Builder.build());
        return this;
    }

    public DescriptorProtos$FieldOptions$Builder addUninterpretedOption(DescriptorProtos$UninterpretedOption descriptorProtos$UninterpretedOption) {
        if (this.uninterpretedOptionBuilder_ != null) {
            this.uninterpretedOptionBuilder_.addMessage(descriptorProtos$UninterpretedOption);
            return this;
        }
        if (descriptorProtos$UninterpretedOption == null) {
            throw new NullPointerException();
        }
        this.ensureUninterpretedOptionIsMutable();
        this.uninterpretedOption_.add(descriptorProtos$UninterpretedOption);
        this.onChanged();
        return this;
    }

    public DescriptorProtos$FieldOptions$Builder addUninterpretedOption(int n2, DescriptorProtos$UninterpretedOption descriptorProtos$UninterpretedOption) {
        if (this.uninterpretedOptionBuilder_ != null) {
            this.uninterpretedOptionBuilder_.addMessage(n2, descriptorProtos$UninterpretedOption);
            return this;
        }
        if (descriptorProtos$UninterpretedOption == null) {
            throw new NullPointerException();
        }
        this.ensureUninterpretedOptionIsMutable();
        this.uninterpretedOption_.add(n2, descriptorProtos$UninterpretedOption);
        this.onChanged();
        return this;
    }

    public DescriptorProtos$FieldOptions$Builder addUninterpretedOption(DescriptorProtos$UninterpretedOption$Builder descriptorProtos$UninterpretedOption$Builder) {
        if (this.uninterpretedOptionBuilder_ == null) {
            this.ensureUninterpretedOptionIsMutable();
            this.uninterpretedOption_.add(descriptorProtos$UninterpretedOption$Builder.build());
            this.onChanged();
            return this;
        }
        this.uninterpretedOptionBuilder_.addMessage(descriptorProtos$UninterpretedOption$Builder.build());
        return this;
    }

    public DescriptorProtos$FieldOptions$Builder addUninterpretedOption(int n2, DescriptorProtos$UninterpretedOption$Builder descriptorProtos$UninterpretedOption$Builder) {
        if (this.uninterpretedOptionBuilder_ == null) {
            this.ensureUninterpretedOptionIsMutable();
            this.uninterpretedOption_.add(n2, descriptorProtos$UninterpretedOption$Builder.build());
            this.onChanged();
            return this;
        }
        this.uninterpretedOptionBuilder_.addMessage(n2, descriptorProtos$UninterpretedOption$Builder.build());
        return this;
    }

    public DescriptorProtos$FieldOptions$Builder addAllUninterpretedOption(Iterable iterable) {
        if (this.uninterpretedOptionBuilder_ == null) {
            this.ensureUninterpretedOptionIsMutable();
            AbstractMessageLite$Builder.addAll(iterable, this.uninterpretedOption_);
            this.onChanged();
            return this;
        }
        this.uninterpretedOptionBuilder_.addAllMessages(iterable);
        return this;
    }

    public DescriptorProtos$FieldOptions$Builder clearUninterpretedOption() {
        if (this.uninterpretedOptionBuilder_ == null) {
            this.uninterpretedOption_ = Collections.emptyList();
            this.bitField0_ &= -65;
            this.onChanged();
            return this;
        }
        this.uninterpretedOptionBuilder_.clear();
        return this;
    }

    public DescriptorProtos$FieldOptions$Builder removeUninterpretedOption(int n2) {
        if (this.uninterpretedOptionBuilder_ == null) {
            this.ensureUninterpretedOptionIsMutable();
            this.uninterpretedOption_.remove(n2);
            this.onChanged();
            return this;
        }
        this.uninterpretedOptionBuilder_.remove(n2);
        return this;
    }

    public DescriptorProtos$UninterpretedOption$Builder getUninterpretedOptionBuilder(int n2) {
        return (DescriptorProtos$UninterpretedOption$Builder)this.getUninterpretedOptionFieldBuilder().getBuilder(n2);
    }

    @Override
    public DescriptorProtos$UninterpretedOptionOrBuilder getUninterpretedOptionOrBuilder(int n2) {
        if (this.uninterpretedOptionBuilder_ != null) return (DescriptorProtos$UninterpretedOptionOrBuilder)this.uninterpretedOptionBuilder_.getMessageOrBuilder(n2);
        return (DescriptorProtos$UninterpretedOptionOrBuilder)this.uninterpretedOption_.get(n2);
    }

    @Override
    public List getUninterpretedOptionOrBuilderList() {
        if (this.uninterpretedOptionBuilder_ == null) return Collections.unmodifiableList(this.uninterpretedOption_);
        return this.uninterpretedOptionBuilder_.getMessageOrBuilderList();
    }

    public DescriptorProtos$UninterpretedOption$Builder addUninterpretedOptionBuilder() {
        return (DescriptorProtos$UninterpretedOption$Builder)this.getUninterpretedOptionFieldBuilder().addBuilder(DescriptorProtos$UninterpretedOption.getDefaultInstance());
    }

    public DescriptorProtos$UninterpretedOption$Builder addUninterpretedOptionBuilder(int n2) {
        return (DescriptorProtos$UninterpretedOption$Builder)this.getUninterpretedOptionFieldBuilder().addBuilder(n2, DescriptorProtos$UninterpretedOption.getDefaultInstance());
    }

    public List getUninterpretedOptionBuilderList() {
        return this.getUninterpretedOptionFieldBuilder().getBuilderList();
    }

    private RepeatedFieldBuilder getUninterpretedOptionFieldBuilder() {
        if (this.uninterpretedOptionBuilder_ != null) return this.uninterpretedOptionBuilder_;
        this.uninterpretedOptionBuilder_ = new RepeatedFieldBuilder(this.uninterpretedOption_, (this.bitField0_ & 64) == 64, this.getParentForChildren(), this.isClean());
        this.uninterpretedOption_ = null;
        return this.uninterpretedOptionBuilder_;
    }

    /* synthetic */ DescriptorProtos$FieldOptions$Builder(DescriptorProtos$1 descriptorProtos$1) {
        this();
    }

    /* synthetic */ DescriptorProtos$FieldOptions$Builder(GeneratedMessage$BuilderParent generatedMessage$BuilderParent, DescriptorProtos$1 descriptorProtos$1) {
        this(generatedMessage$BuilderParent);
    }
}

