/*
 * Decompiled with CFR 0_115.
 */
package com.google.protobuf;

import com.google.protobuf.AbstractMessage$Builder;
import com.google.protobuf.AbstractMessageLite$Builder;
import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.DescriptorProtos;
import com.google.protobuf.DescriptorProtos$1;
import com.google.protobuf.DescriptorProtos$UninterpretedOption;
import com.google.protobuf.DescriptorProtos$UninterpretedOption$NamePart;
import com.google.protobuf.DescriptorProtos$UninterpretedOption$NamePart$Builder;
import com.google.protobuf.DescriptorProtos$UninterpretedOption$NamePartOrBuilder;
import com.google.protobuf.DescriptorProtos$UninterpretedOptionOrBuilder;
import com.google.protobuf.Descriptors$Descriptor;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessage;
import com.google.protobuf.GeneratedMessage$Builder;
import com.google.protobuf.GeneratedMessage$BuilderParent;
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

public final class DescriptorProtos$UninterpretedOption$Builder
extends GeneratedMessage$Builder
implements DescriptorProtos$UninterpretedOptionOrBuilder {
    private int bitField0_;
    private List name_ = Collections.emptyList();
    private RepeatedFieldBuilder nameBuilder_;
    private Object identifierValue_ = "";
    private long positiveIntValue_;
    private long negativeIntValue_;
    private double doubleValue_;
    private ByteString stringValue_ = ByteString.EMPTY;
    private Object aggregateValue_ = "";

    public static final Descriptors$Descriptor getDescriptor() {
        return DescriptorProtos.access$21300();
    }

    @Override
    protected GeneratedMessage$FieldAccessorTable internalGetFieldAccessorTable() {
        return DescriptorProtos.access$21400().ensureFieldAccessorsInitialized(DescriptorProtos$UninterpretedOption.class, DescriptorProtos$UninterpretedOption$Builder.class);
    }

    private DescriptorProtos$UninterpretedOption$Builder() {
        this.maybeForceBuilderInitialization();
    }

    private DescriptorProtos$UninterpretedOption$Builder(GeneratedMessage$BuilderParent generatedMessage$BuilderParent) {
        super(generatedMessage$BuilderParent);
        this.maybeForceBuilderInitialization();
    }

    private void maybeForceBuilderInitialization() {
        if (!GeneratedMessage.alwaysUseFieldBuilders) return;
        this.getNameFieldBuilder();
    }

    @Override
    public DescriptorProtos$UninterpretedOption$Builder clear() {
        super.clear();
        if (this.nameBuilder_ == null) {
            this.name_ = Collections.emptyList();
            this.bitField0_ &= -2;
        } else {
            this.nameBuilder_.clear();
        }
        this.identifierValue_ = "";
        this.bitField0_ &= -3;
        this.positiveIntValue_ = 0;
        this.bitField0_ &= -5;
        this.negativeIntValue_ = 0;
        this.bitField0_ &= -9;
        this.doubleValue_ = 0.0;
        this.bitField0_ &= -17;
        this.stringValue_ = ByteString.EMPTY;
        this.bitField0_ &= -33;
        this.aggregateValue_ = "";
        this.bitField0_ &= -65;
        return this;
    }

    @Override
    public Descriptors$Descriptor getDescriptorForType() {
        return DescriptorProtos.access$21300();
    }

    @Override
    public DescriptorProtos$UninterpretedOption getDefaultInstanceForType() {
        return DescriptorProtos$UninterpretedOption.getDefaultInstance();
    }

    @Override
    public DescriptorProtos$UninterpretedOption build() {
        DescriptorProtos$UninterpretedOption descriptorProtos$UninterpretedOption = this.buildPartial();
        if (descriptorProtos$UninterpretedOption.isInitialized()) return descriptorProtos$UninterpretedOption;
        throw DescriptorProtos$UninterpretedOption$Builder.newUninitializedMessageException(descriptorProtos$UninterpretedOption);
    }

    @Override
    public DescriptorProtos$UninterpretedOption buildPartial() {
        DescriptorProtos$UninterpretedOption descriptorProtos$UninterpretedOption = new DescriptorProtos$UninterpretedOption(this, null);
        int n2 = this.bitField0_;
        int n3 = 0;
        if (this.nameBuilder_ == null) {
            if ((this.bitField0_ & 1) == 1) {
                this.name_ = Collections.unmodifiableList(this.name_);
                this.bitField0_ &= -2;
            }
            DescriptorProtos$UninterpretedOption.access$22702(descriptorProtos$UninterpretedOption, this.name_);
        } else {
            DescriptorProtos$UninterpretedOption.access$22702(descriptorProtos$UninterpretedOption, this.nameBuilder_.build());
        }
        if ((n2 & 2) == 2) {
            n3 |= true;
        }
        DescriptorProtos$UninterpretedOption.access$22802(descriptorProtos$UninterpretedOption, this.identifierValue_);
        if ((n2 & 4) == 4) {
            n3 |= 2;
        }
        DescriptorProtos$UninterpretedOption.access$22902(descriptorProtos$UninterpretedOption, this.positiveIntValue_);
        if ((n2 & 8) == 8) {
            n3 |= 4;
        }
        DescriptorProtos$UninterpretedOption.access$23002(descriptorProtos$UninterpretedOption, this.negativeIntValue_);
        if ((n2 & 16) == 16) {
            n3 |= 8;
        }
        DescriptorProtos$UninterpretedOption.access$23102(descriptorProtos$UninterpretedOption, this.doubleValue_);
        if ((n2 & 32) == 32) {
            n3 |= 16;
        }
        DescriptorProtos$UninterpretedOption.access$23202(descriptorProtos$UninterpretedOption, this.stringValue_);
        if ((n2 & 64) == 64) {
            n3 |= 32;
        }
        DescriptorProtos$UninterpretedOption.access$23302(descriptorProtos$UninterpretedOption, this.aggregateValue_);
        DescriptorProtos$UninterpretedOption.access$23402(descriptorProtos$UninterpretedOption, n3);
        this.onBuilt();
        return descriptorProtos$UninterpretedOption;
    }

    @Override
    public DescriptorProtos$UninterpretedOption$Builder mergeFrom(Message message) {
        if (message instanceof DescriptorProtos$UninterpretedOption) {
            return this.mergeFrom((DescriptorProtos$UninterpretedOption)message);
        }
        super.mergeFrom(message);
        return this;
    }

    public DescriptorProtos$UninterpretedOption$Builder mergeFrom(DescriptorProtos$UninterpretedOption descriptorProtos$UninterpretedOption) {
        if (descriptorProtos$UninterpretedOption == DescriptorProtos$UninterpretedOption.getDefaultInstance()) {
            return this;
        }
        if (this.nameBuilder_ == null) {
            if (!DescriptorProtos$UninterpretedOption.access$22700(descriptorProtos$UninterpretedOption).isEmpty()) {
                if (this.name_.isEmpty()) {
                    this.name_ = DescriptorProtos$UninterpretedOption.access$22700(descriptorProtos$UninterpretedOption);
                    this.bitField0_ &= -2;
                } else {
                    this.ensureNameIsMutable();
                    this.name_.addAll(DescriptorProtos$UninterpretedOption.access$22700(descriptorProtos$UninterpretedOption));
                }
                this.onChanged();
            }
        } else if (!DescriptorProtos$UninterpretedOption.access$22700(descriptorProtos$UninterpretedOption).isEmpty()) {
            if (this.nameBuilder_.isEmpty()) {
                this.nameBuilder_.dispose();
                this.nameBuilder_ = null;
                this.name_ = DescriptorProtos$UninterpretedOption.access$22700(descriptorProtos$UninterpretedOption);
                this.bitField0_ &= -2;
                this.nameBuilder_ = GeneratedMessage.alwaysUseFieldBuilders ? this.getNameFieldBuilder() : null;
            } else {
                this.nameBuilder_.addAllMessages(DescriptorProtos$UninterpretedOption.access$22700(descriptorProtos$UninterpretedOption));
            }
        }
        if (descriptorProtos$UninterpretedOption.hasIdentifierValue()) {
            this.bitField0_ |= 2;
            this.identifierValue_ = DescriptorProtos$UninterpretedOption.access$22800(descriptorProtos$UninterpretedOption);
            this.onChanged();
        }
        if (descriptorProtos$UninterpretedOption.hasPositiveIntValue()) {
            this.setPositiveIntValue(descriptorProtos$UninterpretedOption.getPositiveIntValue());
        }
        if (descriptorProtos$UninterpretedOption.hasNegativeIntValue()) {
            this.setNegativeIntValue(descriptorProtos$UninterpretedOption.getNegativeIntValue());
        }
        if (descriptorProtos$UninterpretedOption.hasDoubleValue()) {
            this.setDoubleValue(descriptorProtos$UninterpretedOption.getDoubleValue());
        }
        if (descriptorProtos$UninterpretedOption.hasStringValue()) {
            this.setStringValue(descriptorProtos$UninterpretedOption.getStringValue());
        }
        if (descriptorProtos$UninterpretedOption.hasAggregateValue()) {
            this.bitField0_ |= 64;
            this.aggregateValue_ = DescriptorProtos$UninterpretedOption.access$23300(descriptorProtos$UninterpretedOption);
            this.onChanged();
        }
        this.mergeUnknownFields(descriptorProtos$UninterpretedOption.unknownFields);
        this.onChanged();
        return this;
    }

    @Override
    public final boolean isInitialized() {
        int n2 = 0;
        while (n2 < this.getNameCount()) {
            if (!this.getName(n2).isInitialized()) {
                return false;
            }
            ++n2;
        }
        return true;
    }

    @Override
    public DescriptorProtos$UninterpretedOption$Builder mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        DescriptorProtos$UninterpretedOption descriptorProtos$UninterpretedOption = null;
        try {
            try {
                descriptorProtos$UninterpretedOption = (DescriptorProtos$UninterpretedOption)DescriptorProtos$UninterpretedOption.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
            }
            catch (InvalidProtocolBufferException var4_6) {
                descriptorProtos$UninterpretedOption = (DescriptorProtos$UninterpretedOption)var4_6.getUnfinishedMessage();
                throw var4_6;
            }
            Object var6_4 = null;
            if (descriptorProtos$UninterpretedOption == null) return this;
            this.mergeFrom(descriptorProtos$UninterpretedOption);
            return this;
        }
        catch (Throwable var5_7) {
            Object var6_5 = null;
            if (descriptorProtos$UninterpretedOption == null) throw var5_7;
            this.mergeFrom(descriptorProtos$UninterpretedOption);
            throw var5_7;
        }
    }

    private void ensureNameIsMutable() {
        if ((this.bitField0_ & 1) == 1) return;
        this.name_ = new ArrayList(this.name_);
        this.bitField0_ |= 1;
    }

    @Override
    public List getNameList() {
        if (this.nameBuilder_ != null) return this.nameBuilder_.getMessageList();
        return Collections.unmodifiableList(this.name_);
    }

    @Override
    public int getNameCount() {
        if (this.nameBuilder_ != null) return this.nameBuilder_.getCount();
        return this.name_.size();
    }

    @Override
    public DescriptorProtos$UninterpretedOption$NamePart getName(int n2) {
        if (this.nameBuilder_ != null) return (DescriptorProtos$UninterpretedOption$NamePart)this.nameBuilder_.getMessage(n2);
        return (DescriptorProtos$UninterpretedOption$NamePart)this.name_.get(n2);
    }

    public DescriptorProtos$UninterpretedOption$Builder setName(int n2, DescriptorProtos$UninterpretedOption$NamePart descriptorProtos$UninterpretedOption$NamePart) {
        if (this.nameBuilder_ != null) {
            this.nameBuilder_.setMessage(n2, descriptorProtos$UninterpretedOption$NamePart);
            return this;
        }
        if (descriptorProtos$UninterpretedOption$NamePart == null) {
            throw new NullPointerException();
        }
        this.ensureNameIsMutable();
        this.name_.set(n2, descriptorProtos$UninterpretedOption$NamePart);
        this.onChanged();
        return this;
    }

    public DescriptorProtos$UninterpretedOption$Builder setName(int n2, DescriptorProtos$UninterpretedOption$NamePart$Builder descriptorProtos$UninterpretedOption$NamePart$Builder) {
        if (this.nameBuilder_ == null) {
            this.ensureNameIsMutable();
            this.name_.set(n2, descriptorProtos$UninterpretedOption$NamePart$Builder.build());
            this.onChanged();
            return this;
        }
        this.nameBuilder_.setMessage(n2, descriptorProtos$UninterpretedOption$NamePart$Builder.build());
        return this;
    }

    public DescriptorProtos$UninterpretedOption$Builder addName(DescriptorProtos$UninterpretedOption$NamePart descriptorProtos$UninterpretedOption$NamePart) {
        if (this.nameBuilder_ != null) {
            this.nameBuilder_.addMessage(descriptorProtos$UninterpretedOption$NamePart);
            return this;
        }
        if (descriptorProtos$UninterpretedOption$NamePart == null) {
            throw new NullPointerException();
        }
        this.ensureNameIsMutable();
        this.name_.add(descriptorProtos$UninterpretedOption$NamePart);
        this.onChanged();
        return this;
    }

    public DescriptorProtos$UninterpretedOption$Builder addName(int n2, DescriptorProtos$UninterpretedOption$NamePart descriptorProtos$UninterpretedOption$NamePart) {
        if (this.nameBuilder_ != null) {
            this.nameBuilder_.addMessage(n2, descriptorProtos$UninterpretedOption$NamePart);
            return this;
        }
        if (descriptorProtos$UninterpretedOption$NamePart == null) {
            throw new NullPointerException();
        }
        this.ensureNameIsMutable();
        this.name_.add(n2, descriptorProtos$UninterpretedOption$NamePart);
        this.onChanged();
        return this;
    }

    public DescriptorProtos$UninterpretedOption$Builder addName(DescriptorProtos$UninterpretedOption$NamePart$Builder descriptorProtos$UninterpretedOption$NamePart$Builder) {
        if (this.nameBuilder_ == null) {
            this.ensureNameIsMutable();
            this.name_.add(descriptorProtos$UninterpretedOption$NamePart$Builder.build());
            this.onChanged();
            return this;
        }
        this.nameBuilder_.addMessage(descriptorProtos$UninterpretedOption$NamePart$Builder.build());
        return this;
    }

    public DescriptorProtos$UninterpretedOption$Builder addName(int n2, DescriptorProtos$UninterpretedOption$NamePart$Builder descriptorProtos$UninterpretedOption$NamePart$Builder) {
        if (this.nameBuilder_ == null) {
            this.ensureNameIsMutable();
            this.name_.add(n2, descriptorProtos$UninterpretedOption$NamePart$Builder.build());
            this.onChanged();
            return this;
        }
        this.nameBuilder_.addMessage(n2, descriptorProtos$UninterpretedOption$NamePart$Builder.build());
        return this;
    }

    public DescriptorProtos$UninterpretedOption$Builder addAllName(Iterable iterable) {
        if (this.nameBuilder_ == null) {
            this.ensureNameIsMutable();
            AbstractMessageLite$Builder.addAll(iterable, this.name_);
            this.onChanged();
            return this;
        }
        this.nameBuilder_.addAllMessages(iterable);
        return this;
    }

    public DescriptorProtos$UninterpretedOption$Builder clearName() {
        if (this.nameBuilder_ == null) {
            this.name_ = Collections.emptyList();
            this.bitField0_ &= -2;
            this.onChanged();
            return this;
        }
        this.nameBuilder_.clear();
        return this;
    }

    public DescriptorProtos$UninterpretedOption$Builder removeName(int n2) {
        if (this.nameBuilder_ == null) {
            this.ensureNameIsMutable();
            this.name_.remove(n2);
            this.onChanged();
            return this;
        }
        this.nameBuilder_.remove(n2);
        return this;
    }

    public DescriptorProtos$UninterpretedOption$NamePart$Builder getNameBuilder(int n2) {
        return (DescriptorProtos$UninterpretedOption$NamePart$Builder)this.getNameFieldBuilder().getBuilder(n2);
    }

    @Override
    public DescriptorProtos$UninterpretedOption$NamePartOrBuilder getNameOrBuilder(int n2) {
        if (this.nameBuilder_ != null) return (DescriptorProtos$UninterpretedOption$NamePartOrBuilder)this.nameBuilder_.getMessageOrBuilder(n2);
        return (DescriptorProtos$UninterpretedOption$NamePartOrBuilder)this.name_.get(n2);
    }

    @Override
    public List getNameOrBuilderList() {
        if (this.nameBuilder_ == null) return Collections.unmodifiableList(this.name_);
        return this.nameBuilder_.getMessageOrBuilderList();
    }

    public DescriptorProtos$UninterpretedOption$NamePart$Builder addNameBuilder() {
        return (DescriptorProtos$UninterpretedOption$NamePart$Builder)this.getNameFieldBuilder().addBuilder(DescriptorProtos$UninterpretedOption$NamePart.getDefaultInstance());
    }

    public DescriptorProtos$UninterpretedOption$NamePart$Builder addNameBuilder(int n2) {
        return (DescriptorProtos$UninterpretedOption$NamePart$Builder)this.getNameFieldBuilder().addBuilder(n2, DescriptorProtos$UninterpretedOption$NamePart.getDefaultInstance());
    }

    public List getNameBuilderList() {
        return this.getNameFieldBuilder().getBuilderList();
    }

    private RepeatedFieldBuilder getNameFieldBuilder() {
        if (this.nameBuilder_ != null) return this.nameBuilder_;
        this.nameBuilder_ = new RepeatedFieldBuilder(this.name_, (this.bitField0_ & 1) == 1, this.getParentForChildren(), this.isClean());
        this.name_ = null;
        return this.nameBuilder_;
    }

    @Override
    public boolean hasIdentifierValue() {
        if ((this.bitField0_ & 2) != 2) return false;
        return true;
    }

    @Override
    public String getIdentifierValue() {
        Object object = this.identifierValue_;
        if (object instanceof String) return (String)object;
        ByteString byteString = (ByteString)object;
        String string = byteString.toStringUtf8();
        if (!byteString.isValidUtf8()) return string;
        this.identifierValue_ = string;
        return string;
    }

    @Override
    public ByteString getIdentifierValueBytes() {
        ByteString byteString;
        Object object = this.identifierValue_;
        if (!(object instanceof String)) return (ByteString)object;
        this.identifierValue_ = byteString = ByteString.copyFromUtf8((String)object);
        return byteString;
    }

    public DescriptorProtos$UninterpretedOption$Builder setIdentifierValue(String string) {
        if (string == null) {
            throw new NullPointerException();
        }
        this.bitField0_ |= 2;
        this.identifierValue_ = string;
        this.onChanged();
        return this;
    }

    public DescriptorProtos$UninterpretedOption$Builder clearIdentifierValue() {
        this.bitField0_ &= -3;
        this.identifierValue_ = DescriptorProtos$UninterpretedOption.getDefaultInstance().getIdentifierValue();
        this.onChanged();
        return this;
    }

    public DescriptorProtos$UninterpretedOption$Builder setIdentifierValueBytes(ByteString byteString) {
        if (byteString == null) {
            throw new NullPointerException();
        }
        this.bitField0_ |= 2;
        this.identifierValue_ = byteString;
        this.onChanged();
        return this;
    }

    @Override
    public boolean hasPositiveIntValue() {
        if ((this.bitField0_ & 4) != 4) return false;
        return true;
    }

    @Override
    public long getPositiveIntValue() {
        return this.positiveIntValue_;
    }

    public DescriptorProtos$UninterpretedOption$Builder setPositiveIntValue(long l2) {
        this.bitField0_ |= 4;
        this.positiveIntValue_ = l2;
        this.onChanged();
        return this;
    }

    public DescriptorProtos$UninterpretedOption$Builder clearPositiveIntValue() {
        this.bitField0_ &= -5;
        this.positiveIntValue_ = 0;
        this.onChanged();
        return this;
    }

    @Override
    public boolean hasNegativeIntValue() {
        if ((this.bitField0_ & 8) != 8) return false;
        return true;
    }

    @Override
    public long getNegativeIntValue() {
        return this.negativeIntValue_;
    }

    public DescriptorProtos$UninterpretedOption$Builder setNegativeIntValue(long l2) {
        this.bitField0_ |= 8;
        this.negativeIntValue_ = l2;
        this.onChanged();
        return this;
    }

    public DescriptorProtos$UninterpretedOption$Builder clearNegativeIntValue() {
        this.bitField0_ &= -9;
        this.negativeIntValue_ = 0;
        this.onChanged();
        return this;
    }

    @Override
    public boolean hasDoubleValue() {
        if ((this.bitField0_ & 16) != 16) return false;
        return true;
    }

    @Override
    public double getDoubleValue() {
        return this.doubleValue_;
    }

    public DescriptorProtos$UninterpretedOption$Builder setDoubleValue(double d2) {
        this.bitField0_ |= 16;
        this.doubleValue_ = d2;
        this.onChanged();
        return this;
    }

    public DescriptorProtos$UninterpretedOption$Builder clearDoubleValue() {
        this.bitField0_ &= -17;
        this.doubleValue_ = 0.0;
        this.onChanged();
        return this;
    }

    @Override
    public boolean hasStringValue() {
        if ((this.bitField0_ & 32) != 32) return false;
        return true;
    }

    @Override
    public ByteString getStringValue() {
        return this.stringValue_;
    }

    public DescriptorProtos$UninterpretedOption$Builder setStringValue(ByteString byteString) {
        if (byteString == null) {
            throw new NullPointerException();
        }
        this.bitField0_ |= 32;
        this.stringValue_ = byteString;
        this.onChanged();
        return this;
    }

    public DescriptorProtos$UninterpretedOption$Builder clearStringValue() {
        this.bitField0_ &= -33;
        this.stringValue_ = DescriptorProtos$UninterpretedOption.getDefaultInstance().getStringValue();
        this.onChanged();
        return this;
    }

    @Override
    public boolean hasAggregateValue() {
        if ((this.bitField0_ & 64) != 64) return false;
        return true;
    }

    @Override
    public String getAggregateValue() {
        Object object = this.aggregateValue_;
        if (object instanceof String) return (String)object;
        ByteString byteString = (ByteString)object;
        String string = byteString.toStringUtf8();
        if (!byteString.isValidUtf8()) return string;
        this.aggregateValue_ = string;
        return string;
    }

    @Override
    public ByteString getAggregateValueBytes() {
        ByteString byteString;
        Object object = this.aggregateValue_;
        if (!(object instanceof String)) return (ByteString)object;
        this.aggregateValue_ = byteString = ByteString.copyFromUtf8((String)object);
        return byteString;
    }

    public DescriptorProtos$UninterpretedOption$Builder setAggregateValue(String string) {
        if (string == null) {
            throw new NullPointerException();
        }
        this.bitField0_ |= 64;
        this.aggregateValue_ = string;
        this.onChanged();
        return this;
    }

    public DescriptorProtos$UninterpretedOption$Builder clearAggregateValue() {
        this.bitField0_ &= -65;
        this.aggregateValue_ = DescriptorProtos$UninterpretedOption.getDefaultInstance().getAggregateValue();
        this.onChanged();
        return this;
    }

    public DescriptorProtos$UninterpretedOption$Builder setAggregateValueBytes(ByteString byteString) {
        if (byteString == null) {
            throw new NullPointerException();
        }
        this.bitField0_ |= 64;
        this.aggregateValue_ = byteString;
        this.onChanged();
        return this;
    }

    /* synthetic */ DescriptorProtos$UninterpretedOption$Builder(DescriptorProtos$1 descriptorProtos$1) {
        this();
    }

    /* synthetic */ DescriptorProtos$UninterpretedOption$Builder(GeneratedMessage$BuilderParent generatedMessage$BuilderParent, DescriptorProtos$1 descriptorProtos$1) {
        this(generatedMessage$BuilderParent);
    }
}

