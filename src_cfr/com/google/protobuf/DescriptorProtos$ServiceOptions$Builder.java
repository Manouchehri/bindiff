/*
 * Decompiled with CFR 0_115.
 */
package com.google.protobuf;

import com.google.protobuf.AbstractMessage$Builder;
import com.google.protobuf.AbstractMessageLite$Builder;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.DescriptorProtos;
import com.google.protobuf.DescriptorProtos$1;
import com.google.protobuf.DescriptorProtos$ServiceOptions;
import com.google.protobuf.DescriptorProtos$ServiceOptionsOrBuilder;
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

public final class DescriptorProtos$ServiceOptions$Builder
extends GeneratedMessage$ExtendableBuilder
implements DescriptorProtos$ServiceOptionsOrBuilder {
    private int bitField0_;
    private boolean deprecated_;
    private List uninterpretedOption_ = Collections.emptyList();
    private RepeatedFieldBuilder uninterpretedOptionBuilder_;

    public static final Descriptors$Descriptor getDescriptor() {
        return DescriptorProtos.access$19500();
    }

    @Override
    protected GeneratedMessage$FieldAccessorTable internalGetFieldAccessorTable() {
        return DescriptorProtos.access$19600().ensureFieldAccessorsInitialized(DescriptorProtos$ServiceOptions.class, DescriptorProtos$ServiceOptions$Builder.class);
    }

    private DescriptorProtos$ServiceOptions$Builder() {
        this.maybeForceBuilderInitialization();
    }

    private DescriptorProtos$ServiceOptions$Builder(GeneratedMessage$BuilderParent generatedMessage$BuilderParent) {
        super(generatedMessage$BuilderParent);
        this.maybeForceBuilderInitialization();
    }

    private void maybeForceBuilderInitialization() {
        if (!GeneratedMessage.alwaysUseFieldBuilders) return;
        this.getUninterpretedOptionFieldBuilder();
    }

    @Override
    public DescriptorProtos$ServiceOptions$Builder clear() {
        super.clear();
        this.deprecated_ = false;
        this.bitField0_ &= -2;
        if (this.uninterpretedOptionBuilder_ == null) {
            this.uninterpretedOption_ = Collections.emptyList();
            this.bitField0_ &= -3;
            return this;
        }
        this.uninterpretedOptionBuilder_.clear();
        return this;
    }

    @Override
    public Descriptors$Descriptor getDescriptorForType() {
        return DescriptorProtos.access$19500();
    }

    @Override
    public DescriptorProtos$ServiceOptions getDefaultInstanceForType() {
        return DescriptorProtos$ServiceOptions.getDefaultInstance();
    }

    @Override
    public DescriptorProtos$ServiceOptions build() {
        DescriptorProtos$ServiceOptions descriptorProtos$ServiceOptions = this.buildPartial();
        if (descriptorProtos$ServiceOptions.isInitialized()) return descriptorProtos$ServiceOptions;
        throw DescriptorProtos$ServiceOptions$Builder.newUninitializedMessageException(descriptorProtos$ServiceOptions);
    }

    @Override
    public DescriptorProtos$ServiceOptions buildPartial() {
        DescriptorProtos$ServiceOptions descriptorProtos$ServiceOptions = new DescriptorProtos$ServiceOptions(this, null);
        int n2 = this.bitField0_;
        int n3 = 0;
        if ((n2 & 1) == 1) {
            n3 |= true;
        }
        DescriptorProtos$ServiceOptions.access$20002(descriptorProtos$ServiceOptions, this.deprecated_);
        if (this.uninterpretedOptionBuilder_ == null) {
            if ((this.bitField0_ & 2) == 2) {
                this.uninterpretedOption_ = Collections.unmodifiableList(this.uninterpretedOption_);
                this.bitField0_ &= -3;
            }
            DescriptorProtos$ServiceOptions.access$20102(descriptorProtos$ServiceOptions, this.uninterpretedOption_);
        } else {
            DescriptorProtos$ServiceOptions.access$20102(descriptorProtos$ServiceOptions, this.uninterpretedOptionBuilder_.build());
        }
        DescriptorProtos$ServiceOptions.access$20202(descriptorProtos$ServiceOptions, n3);
        this.onBuilt();
        return descriptorProtos$ServiceOptions;
    }

    @Override
    public DescriptorProtos$ServiceOptions$Builder mergeFrom(Message message) {
        if (message instanceof DescriptorProtos$ServiceOptions) {
            return this.mergeFrom((DescriptorProtos$ServiceOptions)message);
        }
        super.mergeFrom(message);
        return this;
    }

    public DescriptorProtos$ServiceOptions$Builder mergeFrom(DescriptorProtos$ServiceOptions descriptorProtos$ServiceOptions) {
        if (descriptorProtos$ServiceOptions == DescriptorProtos$ServiceOptions.getDefaultInstance()) {
            return this;
        }
        if (descriptorProtos$ServiceOptions.hasDeprecated()) {
            this.setDeprecated(descriptorProtos$ServiceOptions.getDeprecated());
        }
        if (this.uninterpretedOptionBuilder_ == null) {
            if (!DescriptorProtos$ServiceOptions.access$20100(descriptorProtos$ServiceOptions).isEmpty()) {
                if (this.uninterpretedOption_.isEmpty()) {
                    this.uninterpretedOption_ = DescriptorProtos$ServiceOptions.access$20100(descriptorProtos$ServiceOptions);
                    this.bitField0_ &= -3;
                } else {
                    this.ensureUninterpretedOptionIsMutable();
                    this.uninterpretedOption_.addAll(DescriptorProtos$ServiceOptions.access$20100(descriptorProtos$ServiceOptions));
                }
                this.onChanged();
            }
        } else if (!DescriptorProtos$ServiceOptions.access$20100(descriptorProtos$ServiceOptions).isEmpty()) {
            if (this.uninterpretedOptionBuilder_.isEmpty()) {
                this.uninterpretedOptionBuilder_.dispose();
                this.uninterpretedOptionBuilder_ = null;
                this.uninterpretedOption_ = DescriptorProtos$ServiceOptions.access$20100(descriptorProtos$ServiceOptions);
                this.bitField0_ &= -3;
                this.uninterpretedOptionBuilder_ = GeneratedMessage.alwaysUseFieldBuilders ? this.getUninterpretedOptionFieldBuilder() : null;
            } else {
                this.uninterpretedOptionBuilder_.addAllMessages(DescriptorProtos$ServiceOptions.access$20100(descriptorProtos$ServiceOptions));
            }
        }
        this.mergeExtensionFields(descriptorProtos$ServiceOptions);
        this.mergeUnknownFields(descriptorProtos$ServiceOptions.unknownFields);
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
    public DescriptorProtos$ServiceOptions$Builder mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        DescriptorProtos$ServiceOptions descriptorProtos$ServiceOptions = null;
        try {
            try {
                descriptorProtos$ServiceOptions = (DescriptorProtos$ServiceOptions)DescriptorProtos$ServiceOptions.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
            }
            catch (InvalidProtocolBufferException var4_6) {
                descriptorProtos$ServiceOptions = (DescriptorProtos$ServiceOptions)var4_6.getUnfinishedMessage();
                throw var4_6;
            }
            Object var6_4 = null;
            if (descriptorProtos$ServiceOptions == null) return this;
            this.mergeFrom(descriptorProtos$ServiceOptions);
            return this;
        }
        catch (Throwable var5_7) {
            Object var6_5 = null;
            if (descriptorProtos$ServiceOptions == null) throw var5_7;
            this.mergeFrom(descriptorProtos$ServiceOptions);
            throw var5_7;
        }
    }

    @Override
    public boolean hasDeprecated() {
        if ((this.bitField0_ & 1) != 1) return false;
        return true;
    }

    @Override
    public boolean getDeprecated() {
        return this.deprecated_;
    }

    public DescriptorProtos$ServiceOptions$Builder setDeprecated(boolean bl2) {
        this.bitField0_ |= 1;
        this.deprecated_ = bl2;
        this.onChanged();
        return this;
    }

    public DescriptorProtos$ServiceOptions$Builder clearDeprecated() {
        this.bitField0_ &= -2;
        this.deprecated_ = false;
        this.onChanged();
        return this;
    }

    private void ensureUninterpretedOptionIsMutable() {
        if ((this.bitField0_ & 2) == 2) return;
        this.uninterpretedOption_ = new ArrayList(this.uninterpretedOption_);
        this.bitField0_ |= 2;
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

    public DescriptorProtos$ServiceOptions$Builder setUninterpretedOption(int n2, DescriptorProtos$UninterpretedOption descriptorProtos$UninterpretedOption) {
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

    public DescriptorProtos$ServiceOptions$Builder setUninterpretedOption(int n2, DescriptorProtos$UninterpretedOption$Builder descriptorProtos$UninterpretedOption$Builder) {
        if (this.uninterpretedOptionBuilder_ == null) {
            this.ensureUninterpretedOptionIsMutable();
            this.uninterpretedOption_.set(n2, descriptorProtos$UninterpretedOption$Builder.build());
            this.onChanged();
            return this;
        }
        this.uninterpretedOptionBuilder_.setMessage(n2, descriptorProtos$UninterpretedOption$Builder.build());
        return this;
    }

    public DescriptorProtos$ServiceOptions$Builder addUninterpretedOption(DescriptorProtos$UninterpretedOption descriptorProtos$UninterpretedOption) {
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

    public DescriptorProtos$ServiceOptions$Builder addUninterpretedOption(int n2, DescriptorProtos$UninterpretedOption descriptorProtos$UninterpretedOption) {
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

    public DescriptorProtos$ServiceOptions$Builder addUninterpretedOption(DescriptorProtos$UninterpretedOption$Builder descriptorProtos$UninterpretedOption$Builder) {
        if (this.uninterpretedOptionBuilder_ == null) {
            this.ensureUninterpretedOptionIsMutable();
            this.uninterpretedOption_.add(descriptorProtos$UninterpretedOption$Builder.build());
            this.onChanged();
            return this;
        }
        this.uninterpretedOptionBuilder_.addMessage(descriptorProtos$UninterpretedOption$Builder.build());
        return this;
    }

    public DescriptorProtos$ServiceOptions$Builder addUninterpretedOption(int n2, DescriptorProtos$UninterpretedOption$Builder descriptorProtos$UninterpretedOption$Builder) {
        if (this.uninterpretedOptionBuilder_ == null) {
            this.ensureUninterpretedOptionIsMutable();
            this.uninterpretedOption_.add(n2, descriptorProtos$UninterpretedOption$Builder.build());
            this.onChanged();
            return this;
        }
        this.uninterpretedOptionBuilder_.addMessage(n2, descriptorProtos$UninterpretedOption$Builder.build());
        return this;
    }

    public DescriptorProtos$ServiceOptions$Builder addAllUninterpretedOption(Iterable iterable) {
        if (this.uninterpretedOptionBuilder_ == null) {
            this.ensureUninterpretedOptionIsMutable();
            AbstractMessageLite$Builder.addAll(iterable, this.uninterpretedOption_);
            this.onChanged();
            return this;
        }
        this.uninterpretedOptionBuilder_.addAllMessages(iterable);
        return this;
    }

    public DescriptorProtos$ServiceOptions$Builder clearUninterpretedOption() {
        if (this.uninterpretedOptionBuilder_ == null) {
            this.uninterpretedOption_ = Collections.emptyList();
            this.bitField0_ &= -3;
            this.onChanged();
            return this;
        }
        this.uninterpretedOptionBuilder_.clear();
        return this;
    }

    public DescriptorProtos$ServiceOptions$Builder removeUninterpretedOption(int n2) {
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
        this.uninterpretedOptionBuilder_ = new RepeatedFieldBuilder(this.uninterpretedOption_, (this.bitField0_ & 2) == 2, this.getParentForChildren(), this.isClean());
        this.uninterpretedOption_ = null;
        return this.uninterpretedOptionBuilder_;
    }

    /* synthetic */ DescriptorProtos$ServiceOptions$Builder(DescriptorProtos$1 descriptorProtos$1) {
        this();
    }

    /* synthetic */ DescriptorProtos$ServiceOptions$Builder(GeneratedMessage$BuilderParent generatedMessage$BuilderParent, DescriptorProtos$1 descriptorProtos$1) {
        this(generatedMessage$BuilderParent);
    }
}

