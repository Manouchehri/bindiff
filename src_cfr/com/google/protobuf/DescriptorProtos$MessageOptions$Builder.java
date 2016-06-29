/*
 * Decompiled with CFR 0_115.
 */
package com.google.protobuf;

import com.google.protobuf.AbstractMessage$Builder;
import com.google.protobuf.AbstractMessageLite$Builder;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.DescriptorProtos;
import com.google.protobuf.DescriptorProtos$1;
import com.google.protobuf.DescriptorProtos$MessageOptions;
import com.google.protobuf.DescriptorProtos$MessageOptionsOrBuilder;
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

public final class DescriptorProtos$MessageOptions$Builder
extends GeneratedMessage$ExtendableBuilder
implements DescriptorProtos$MessageOptionsOrBuilder {
    private int bitField0_;
    private boolean messageSetWireFormat_;
    private boolean noStandardDescriptorAccessor_;
    private boolean deprecated_;
    private boolean mapEntry_;
    private List uninterpretedOption_ = Collections.emptyList();
    private RepeatedFieldBuilder uninterpretedOptionBuilder_;

    public static final Descriptors$Descriptor getDescriptor() {
        return DescriptorProtos.access$15000();
    }

    @Override
    protected GeneratedMessage$FieldAccessorTable internalGetFieldAccessorTable() {
        return DescriptorProtos.access$15100().ensureFieldAccessorsInitialized(DescriptorProtos$MessageOptions.class, DescriptorProtos$MessageOptions$Builder.class);
    }

    private DescriptorProtos$MessageOptions$Builder() {
        this.maybeForceBuilderInitialization();
    }

    private DescriptorProtos$MessageOptions$Builder(GeneratedMessage$BuilderParent generatedMessage$BuilderParent) {
        super(generatedMessage$BuilderParent);
        this.maybeForceBuilderInitialization();
    }

    private void maybeForceBuilderInitialization() {
        if (!GeneratedMessage.alwaysUseFieldBuilders) return;
        this.getUninterpretedOptionFieldBuilder();
    }

    @Override
    public DescriptorProtos$MessageOptions$Builder clear() {
        super.clear();
        this.messageSetWireFormat_ = false;
        this.bitField0_ &= -2;
        this.noStandardDescriptorAccessor_ = false;
        this.bitField0_ &= -3;
        this.deprecated_ = false;
        this.bitField0_ &= -5;
        this.mapEntry_ = false;
        this.bitField0_ &= -9;
        if (this.uninterpretedOptionBuilder_ == null) {
            this.uninterpretedOption_ = Collections.emptyList();
            this.bitField0_ &= -17;
            return this;
        }
        this.uninterpretedOptionBuilder_.clear();
        return this;
    }

    @Override
    public Descriptors$Descriptor getDescriptorForType() {
        return DescriptorProtos.access$15000();
    }

    @Override
    public DescriptorProtos$MessageOptions getDefaultInstanceForType() {
        return DescriptorProtos$MessageOptions.getDefaultInstance();
    }

    @Override
    public DescriptorProtos$MessageOptions build() {
        DescriptorProtos$MessageOptions descriptorProtos$MessageOptions = this.buildPartial();
        if (descriptorProtos$MessageOptions.isInitialized()) return descriptorProtos$MessageOptions;
        throw DescriptorProtos$MessageOptions$Builder.newUninitializedMessageException(descriptorProtos$MessageOptions);
    }

    @Override
    public DescriptorProtos$MessageOptions buildPartial() {
        DescriptorProtos$MessageOptions descriptorProtos$MessageOptions = new DescriptorProtos$MessageOptions(this, null);
        int n2 = this.bitField0_;
        int n3 = 0;
        if ((n2 & 1) == 1) {
            n3 |= true;
        }
        DescriptorProtos$MessageOptions.access$15502(descriptorProtos$MessageOptions, this.messageSetWireFormat_);
        if ((n2 & 2) == 2) {
            n3 |= 2;
        }
        DescriptorProtos$MessageOptions.access$15602(descriptorProtos$MessageOptions, this.noStandardDescriptorAccessor_);
        if ((n2 & 4) == 4) {
            n3 |= 4;
        }
        DescriptorProtos$MessageOptions.access$15702(descriptorProtos$MessageOptions, this.deprecated_);
        if ((n2 & 8) == 8) {
            n3 |= 8;
        }
        DescriptorProtos$MessageOptions.access$15802(descriptorProtos$MessageOptions, this.mapEntry_);
        if (this.uninterpretedOptionBuilder_ == null) {
            if ((this.bitField0_ & 16) == 16) {
                this.uninterpretedOption_ = Collections.unmodifiableList(this.uninterpretedOption_);
                this.bitField0_ &= -17;
            }
            DescriptorProtos$MessageOptions.access$15902(descriptorProtos$MessageOptions, this.uninterpretedOption_);
        } else {
            DescriptorProtos$MessageOptions.access$15902(descriptorProtos$MessageOptions, this.uninterpretedOptionBuilder_.build());
        }
        DescriptorProtos$MessageOptions.access$16002(descriptorProtos$MessageOptions, n3);
        this.onBuilt();
        return descriptorProtos$MessageOptions;
    }

    @Override
    public DescriptorProtos$MessageOptions$Builder mergeFrom(Message message) {
        if (message instanceof DescriptorProtos$MessageOptions) {
            return this.mergeFrom((DescriptorProtos$MessageOptions)message);
        }
        super.mergeFrom(message);
        return this;
    }

    public DescriptorProtos$MessageOptions$Builder mergeFrom(DescriptorProtos$MessageOptions descriptorProtos$MessageOptions) {
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
            if (!DescriptorProtos$MessageOptions.access$15900(descriptorProtos$MessageOptions).isEmpty()) {
                if (this.uninterpretedOption_.isEmpty()) {
                    this.uninterpretedOption_ = DescriptorProtos$MessageOptions.access$15900(descriptorProtos$MessageOptions);
                    this.bitField0_ &= -17;
                } else {
                    this.ensureUninterpretedOptionIsMutable();
                    this.uninterpretedOption_.addAll(DescriptorProtos$MessageOptions.access$15900(descriptorProtos$MessageOptions));
                }
                this.onChanged();
            }
        } else if (!DescriptorProtos$MessageOptions.access$15900(descriptorProtos$MessageOptions).isEmpty()) {
            if (this.uninterpretedOptionBuilder_.isEmpty()) {
                this.uninterpretedOptionBuilder_.dispose();
                this.uninterpretedOptionBuilder_ = null;
                this.uninterpretedOption_ = DescriptorProtos$MessageOptions.access$15900(descriptorProtos$MessageOptions);
                this.bitField0_ &= -17;
                this.uninterpretedOptionBuilder_ = GeneratedMessage.alwaysUseFieldBuilders ? this.getUninterpretedOptionFieldBuilder() : null;
            } else {
                this.uninterpretedOptionBuilder_.addAllMessages(DescriptorProtos$MessageOptions.access$15900(descriptorProtos$MessageOptions));
            }
        }
        this.mergeExtensionFields(descriptorProtos$MessageOptions);
        this.mergeUnknownFields(descriptorProtos$MessageOptions.unknownFields);
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
    public DescriptorProtos$MessageOptions$Builder mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        DescriptorProtos$MessageOptions descriptorProtos$MessageOptions = null;
        try {
            try {
                descriptorProtos$MessageOptions = (DescriptorProtos$MessageOptions)DescriptorProtos$MessageOptions.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
            }
            catch (InvalidProtocolBufferException var4_6) {
                descriptorProtos$MessageOptions = (DescriptorProtos$MessageOptions)var4_6.getUnfinishedMessage();
                throw var4_6;
            }
            Object var6_4 = null;
            if (descriptorProtos$MessageOptions == null) return this;
            this.mergeFrom(descriptorProtos$MessageOptions);
            return this;
        }
        catch (Throwable var5_7) {
            Object var6_5 = null;
            if (descriptorProtos$MessageOptions == null) throw var5_7;
            this.mergeFrom(descriptorProtos$MessageOptions);
            throw var5_7;
        }
    }

    @Override
    public boolean hasMessageSetWireFormat() {
        if ((this.bitField0_ & 1) != 1) return false;
        return true;
    }

    @Override
    public boolean getMessageSetWireFormat() {
        return this.messageSetWireFormat_;
    }

    public DescriptorProtos$MessageOptions$Builder setMessageSetWireFormat(boolean bl2) {
        this.bitField0_ |= 1;
        this.messageSetWireFormat_ = bl2;
        this.onChanged();
        return this;
    }

    public DescriptorProtos$MessageOptions$Builder clearMessageSetWireFormat() {
        this.bitField0_ &= -2;
        this.messageSetWireFormat_ = false;
        this.onChanged();
        return this;
    }

    @Override
    public boolean hasNoStandardDescriptorAccessor() {
        if ((this.bitField0_ & 2) != 2) return false;
        return true;
    }

    @Override
    public boolean getNoStandardDescriptorAccessor() {
        return this.noStandardDescriptorAccessor_;
    }

    public DescriptorProtos$MessageOptions$Builder setNoStandardDescriptorAccessor(boolean bl2) {
        this.bitField0_ |= 2;
        this.noStandardDescriptorAccessor_ = bl2;
        this.onChanged();
        return this;
    }

    public DescriptorProtos$MessageOptions$Builder clearNoStandardDescriptorAccessor() {
        this.bitField0_ &= -3;
        this.noStandardDescriptorAccessor_ = false;
        this.onChanged();
        return this;
    }

    @Override
    public boolean hasDeprecated() {
        if ((this.bitField0_ & 4) != 4) return false;
        return true;
    }

    @Override
    public boolean getDeprecated() {
        return this.deprecated_;
    }

    public DescriptorProtos$MessageOptions$Builder setDeprecated(boolean bl2) {
        this.bitField0_ |= 4;
        this.deprecated_ = bl2;
        this.onChanged();
        return this;
    }

    public DescriptorProtos$MessageOptions$Builder clearDeprecated() {
        this.bitField0_ &= -5;
        this.deprecated_ = false;
        this.onChanged();
        return this;
    }

    @Override
    public boolean hasMapEntry() {
        if ((this.bitField0_ & 8) != 8) return false;
        return true;
    }

    @Override
    public boolean getMapEntry() {
        return this.mapEntry_;
    }

    public DescriptorProtos$MessageOptions$Builder setMapEntry(boolean bl2) {
        this.bitField0_ |= 8;
        this.mapEntry_ = bl2;
        this.onChanged();
        return this;
    }

    public DescriptorProtos$MessageOptions$Builder clearMapEntry() {
        this.bitField0_ &= -9;
        this.mapEntry_ = false;
        this.onChanged();
        return this;
    }

    private void ensureUninterpretedOptionIsMutable() {
        if ((this.bitField0_ & 16) == 16) return;
        this.uninterpretedOption_ = new ArrayList(this.uninterpretedOption_);
        this.bitField0_ |= 16;
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

    public DescriptorProtos$MessageOptions$Builder setUninterpretedOption(int n2, DescriptorProtos$UninterpretedOption descriptorProtos$UninterpretedOption) {
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

    public DescriptorProtos$MessageOptions$Builder setUninterpretedOption(int n2, DescriptorProtos$UninterpretedOption$Builder descriptorProtos$UninterpretedOption$Builder) {
        if (this.uninterpretedOptionBuilder_ == null) {
            this.ensureUninterpretedOptionIsMutable();
            this.uninterpretedOption_.set(n2, descriptorProtos$UninterpretedOption$Builder.build());
            this.onChanged();
            return this;
        }
        this.uninterpretedOptionBuilder_.setMessage(n2, descriptorProtos$UninterpretedOption$Builder.build());
        return this;
    }

    public DescriptorProtos$MessageOptions$Builder addUninterpretedOption(DescriptorProtos$UninterpretedOption descriptorProtos$UninterpretedOption) {
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

    public DescriptorProtos$MessageOptions$Builder addUninterpretedOption(int n2, DescriptorProtos$UninterpretedOption descriptorProtos$UninterpretedOption) {
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

    public DescriptorProtos$MessageOptions$Builder addUninterpretedOption(DescriptorProtos$UninterpretedOption$Builder descriptorProtos$UninterpretedOption$Builder) {
        if (this.uninterpretedOptionBuilder_ == null) {
            this.ensureUninterpretedOptionIsMutable();
            this.uninterpretedOption_.add(descriptorProtos$UninterpretedOption$Builder.build());
            this.onChanged();
            return this;
        }
        this.uninterpretedOptionBuilder_.addMessage(descriptorProtos$UninterpretedOption$Builder.build());
        return this;
    }

    public DescriptorProtos$MessageOptions$Builder addUninterpretedOption(int n2, DescriptorProtos$UninterpretedOption$Builder descriptorProtos$UninterpretedOption$Builder) {
        if (this.uninterpretedOptionBuilder_ == null) {
            this.ensureUninterpretedOptionIsMutable();
            this.uninterpretedOption_.add(n2, descriptorProtos$UninterpretedOption$Builder.build());
            this.onChanged();
            return this;
        }
        this.uninterpretedOptionBuilder_.addMessage(n2, descriptorProtos$UninterpretedOption$Builder.build());
        return this;
    }

    public DescriptorProtos$MessageOptions$Builder addAllUninterpretedOption(Iterable iterable) {
        if (this.uninterpretedOptionBuilder_ == null) {
            this.ensureUninterpretedOptionIsMutable();
            AbstractMessageLite$Builder.addAll(iterable, this.uninterpretedOption_);
            this.onChanged();
            return this;
        }
        this.uninterpretedOptionBuilder_.addAllMessages(iterable);
        return this;
    }

    public DescriptorProtos$MessageOptions$Builder clearUninterpretedOption() {
        if (this.uninterpretedOptionBuilder_ == null) {
            this.uninterpretedOption_ = Collections.emptyList();
            this.bitField0_ &= -17;
            this.onChanged();
            return this;
        }
        this.uninterpretedOptionBuilder_.clear();
        return this;
    }

    public DescriptorProtos$MessageOptions$Builder removeUninterpretedOption(int n2) {
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
        this.uninterpretedOptionBuilder_ = new RepeatedFieldBuilder(this.uninterpretedOption_, (this.bitField0_ & 16) == 16, this.getParentForChildren(), this.isClean());
        this.uninterpretedOption_ = null;
        return this.uninterpretedOptionBuilder_;
    }

    /* synthetic */ DescriptorProtos$MessageOptions$Builder(DescriptorProtos$1 descriptorProtos$1) {
        this();
    }

    /* synthetic */ DescriptorProtos$MessageOptions$Builder(GeneratedMessage$BuilderParent generatedMessage$BuilderParent, DescriptorProtos$1 descriptorProtos$1) {
        this(generatedMessage$BuilderParent);
    }
}

