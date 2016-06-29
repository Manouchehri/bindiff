package com.google.protobuf;

import java.util.*;
import java.io.*;

public final class DescriptorProtos$UninterpretedOption$Builder extends GeneratedMessage$Builder implements DescriptorProtos$UninterpretedOptionOrBuilder
{
    private int bitField0_;
    private List name_;
    private RepeatedFieldBuilder nameBuilder_;
    private Object identifierValue_;
    private long positiveIntValue_;
    private long negativeIntValue_;
    private double doubleValue_;
    private ByteString stringValue_;
    private Object aggregateValue_;
    
    public static final Descriptors$Descriptor getDescriptor() {
        return DescriptorProtos.internal_static_google_protobuf_UninterpretedOption_descriptor;
    }
    
    protected GeneratedMessage$FieldAccessorTable internalGetFieldAccessorTable() {
        return DescriptorProtos.internal_static_google_protobuf_UninterpretedOption_fieldAccessorTable.ensureFieldAccessorsInitialized(DescriptorProtos$UninterpretedOption.class, DescriptorProtos$UninterpretedOption$Builder.class);
    }
    
    private DescriptorProtos$UninterpretedOption$Builder() {
        this.name_ = Collections.emptyList();
        this.identifierValue_ = "";
        this.stringValue_ = ByteString.EMPTY;
        this.aggregateValue_ = "";
        this.maybeForceBuilderInitialization();
    }
    
    private DescriptorProtos$UninterpretedOption$Builder(final GeneratedMessage$BuilderParent generatedMessage$BuilderParent) {
        super(generatedMessage$BuilderParent);
        this.name_ = Collections.emptyList();
        this.identifierValue_ = "";
        this.stringValue_ = ByteString.EMPTY;
        this.aggregateValue_ = "";
        this.maybeForceBuilderInitialization();
    }
    
    private void maybeForceBuilderInitialization() {
        if (GeneratedMessage.alwaysUseFieldBuilders) {
            this.getNameFieldBuilder();
        }
    }
    
    public DescriptorProtos$UninterpretedOption$Builder clear() {
        super.clear();
        if (this.nameBuilder_ == null) {
            this.name_ = Collections.emptyList();
            this.bitField0_ &= 0xFFFFFFFE;
        }
        else {
            this.nameBuilder_.clear();
        }
        this.identifierValue_ = "";
        this.bitField0_ &= 0xFFFFFFFD;
        this.positiveIntValue_ = 0L;
        this.bitField0_ &= 0xFFFFFFFB;
        this.negativeIntValue_ = 0L;
        this.bitField0_ &= 0xFFFFFFF7;
        this.doubleValue_ = 0.0;
        this.bitField0_ &= 0xFFFFFFEF;
        this.stringValue_ = ByteString.EMPTY;
        this.bitField0_ &= 0xFFFFFFDF;
        this.aggregateValue_ = "";
        this.bitField0_ &= 0xFFFFFFBF;
        return this;
    }
    
    public Descriptors$Descriptor getDescriptorForType() {
        return DescriptorProtos.internal_static_google_protobuf_UninterpretedOption_descriptor;
    }
    
    public DescriptorProtos$UninterpretedOption getDefaultInstanceForType() {
        return DescriptorProtos$UninterpretedOption.getDefaultInstance();
    }
    
    public DescriptorProtos$UninterpretedOption build() {
        final DescriptorProtos$UninterpretedOption buildPartial = this.buildPartial();
        if (!buildPartial.isInitialized()) {
            throw AbstractMessage$Builder.newUninitializedMessageException(buildPartial);
        }
        return buildPartial;
    }
    
    public DescriptorProtos$UninterpretedOption buildPartial() {
        final DescriptorProtos$UninterpretedOption descriptorProtos$UninterpretedOption = new DescriptorProtos$UninterpretedOption(this, null);
        final int bitField0_ = this.bitField0_;
        int n = 0;
        if (this.nameBuilder_ == null) {
            if ((this.bitField0_ & 0x1) == 0x1) {
                this.name_ = Collections.unmodifiableList((List<?>)this.name_);
                this.bitField0_ &= 0xFFFFFFFE;
            }
            descriptorProtos$UninterpretedOption.name_ = this.name_;
        }
        else {
            descriptorProtos$UninterpretedOption.name_ = this.nameBuilder_.build();
        }
        if ((bitField0_ & 0x2) == 0x2) {
            n |= 0x1;
        }
        descriptorProtos$UninterpretedOption.identifierValue_ = this.identifierValue_;
        if ((bitField0_ & 0x4) == 0x4) {
            n |= 0x2;
        }
        descriptorProtos$UninterpretedOption.positiveIntValue_ = this.positiveIntValue_;
        if ((bitField0_ & 0x8) == 0x8) {
            n |= 0x4;
        }
        descriptorProtos$UninterpretedOption.negativeIntValue_ = this.negativeIntValue_;
        if ((bitField0_ & 0x10) == 0x10) {
            n |= 0x8;
        }
        descriptorProtos$UninterpretedOption.doubleValue_ = this.doubleValue_;
        if ((bitField0_ & 0x20) == 0x20) {
            n |= 0x10;
        }
        descriptorProtos$UninterpretedOption.stringValue_ = this.stringValue_;
        if ((bitField0_ & 0x40) == 0x40) {
            n |= 0x20;
        }
        descriptorProtos$UninterpretedOption.aggregateValue_ = this.aggregateValue_;
        descriptorProtos$UninterpretedOption.bitField0_ = n;
        this.onBuilt();
        return descriptorProtos$UninterpretedOption;
    }
    
    public DescriptorProtos$UninterpretedOption$Builder mergeFrom(final Message message) {
        if (message instanceof DescriptorProtos$UninterpretedOption) {
            return this.mergeFrom((DescriptorProtos$UninterpretedOption)message);
        }
        super.mergeFrom(message);
        return this;
    }
    
    public DescriptorProtos$UninterpretedOption$Builder mergeFrom(final DescriptorProtos$UninterpretedOption descriptorProtos$UninterpretedOption) {
        if (descriptorProtos$UninterpretedOption == DescriptorProtos$UninterpretedOption.getDefaultInstance()) {
            return this;
        }
        if (this.nameBuilder_ == null) {
            if (!descriptorProtos$UninterpretedOption.name_.isEmpty()) {
                if (this.name_.isEmpty()) {
                    this.name_ = descriptorProtos$UninterpretedOption.name_;
                    this.bitField0_ &= 0xFFFFFFFE;
                }
                else {
                    this.ensureNameIsMutable();
                    this.name_.addAll(descriptorProtos$UninterpretedOption.name_);
                }
                this.onChanged();
            }
        }
        else if (!descriptorProtos$UninterpretedOption.name_.isEmpty()) {
            if (this.nameBuilder_.isEmpty()) {
                this.nameBuilder_.dispose();
                this.nameBuilder_ = null;
                this.name_ = descriptorProtos$UninterpretedOption.name_;
                this.bitField0_ &= 0xFFFFFFFE;
                this.nameBuilder_ = (GeneratedMessage.alwaysUseFieldBuilders ? this.getNameFieldBuilder() : null);
            }
            else {
                this.nameBuilder_.addAllMessages(descriptorProtos$UninterpretedOption.name_);
            }
        }
        if (descriptorProtos$UninterpretedOption.hasIdentifierValue()) {
            this.bitField0_ |= 0x2;
            this.identifierValue_ = descriptorProtos$UninterpretedOption.identifierValue_;
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
            this.bitField0_ |= 0x40;
            this.aggregateValue_ = descriptorProtos$UninterpretedOption.aggregateValue_;
            this.onChanged();
        }
        this.mergeUnknownFields(descriptorProtos$UninterpretedOption.unknownFields);
        this.onChanged();
        return this;
    }
    
    public final boolean isInitialized() {
        for (int i = 0; i < this.getNameCount(); ++i) {
            if (!this.getName(i).isInitialized()) {
                return false;
            }
        }
        return true;
    }
    
    public DescriptorProtos$UninterpretedOption$Builder mergeFrom(final CodedInputStream codedInputStream, final ExtensionRegistryLite extensionRegistryLite) {
        DescriptorProtos$UninterpretedOption descriptorProtos$UninterpretedOption = null;
        try {
            descriptorProtos$UninterpretedOption = (DescriptorProtos$UninterpretedOption)DescriptorProtos$UninterpretedOption.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
        }
        catch (InvalidProtocolBufferException ex) {
            descriptorProtos$UninterpretedOption = (DescriptorProtos$UninterpretedOption)ex.getUnfinishedMessage();
            throw ex;
        }
        finally {
            if (descriptorProtos$UninterpretedOption != null) {
                this.mergeFrom(descriptorProtos$UninterpretedOption);
            }
        }
        return this;
    }
    
    private void ensureNameIsMutable() {
        if ((this.bitField0_ & 0x1) != 0x1) {
            this.name_ = new ArrayList(this.name_);
            this.bitField0_ |= 0x1;
        }
    }
    
    public List getNameList() {
        if (this.nameBuilder_ == null) {
            return Collections.unmodifiableList((List<?>)this.name_);
        }
        return this.nameBuilder_.getMessageList();
    }
    
    public int getNameCount() {
        if (this.nameBuilder_ == null) {
            return this.name_.size();
        }
        return this.nameBuilder_.getCount();
    }
    
    public DescriptorProtos$UninterpretedOption$NamePart getName(final int n) {
        if (this.nameBuilder_ == null) {
            return this.name_.get(n);
        }
        return (DescriptorProtos$UninterpretedOption$NamePart)this.nameBuilder_.getMessage(n);
    }
    
    public DescriptorProtos$UninterpretedOption$Builder setName(final int n, final DescriptorProtos$UninterpretedOption$NamePart descriptorProtos$UninterpretedOption$NamePart) {
        if (this.nameBuilder_ == null) {
            if (descriptorProtos$UninterpretedOption$NamePart == null) {
                throw new NullPointerException();
            }
            this.ensureNameIsMutable();
            this.name_.set(n, descriptorProtos$UninterpretedOption$NamePart);
            this.onChanged();
        }
        else {
            this.nameBuilder_.setMessage(n, descriptorProtos$UninterpretedOption$NamePart);
        }
        return this;
    }
    
    public DescriptorProtos$UninterpretedOption$Builder setName(final int n, final DescriptorProtos$UninterpretedOption$NamePart$Builder descriptorProtos$UninterpretedOption$NamePart$Builder) {
        if (this.nameBuilder_ == null) {
            this.ensureNameIsMutable();
            this.name_.set(n, descriptorProtos$UninterpretedOption$NamePart$Builder.build());
            this.onChanged();
        }
        else {
            this.nameBuilder_.setMessage(n, descriptorProtos$UninterpretedOption$NamePart$Builder.build());
        }
        return this;
    }
    
    public DescriptorProtos$UninterpretedOption$Builder addName(final DescriptorProtos$UninterpretedOption$NamePart descriptorProtos$UninterpretedOption$NamePart) {
        if (this.nameBuilder_ == null) {
            if (descriptorProtos$UninterpretedOption$NamePart == null) {
                throw new NullPointerException();
            }
            this.ensureNameIsMutable();
            this.name_.add(descriptorProtos$UninterpretedOption$NamePart);
            this.onChanged();
        }
        else {
            this.nameBuilder_.addMessage(descriptorProtos$UninterpretedOption$NamePart);
        }
        return this;
    }
    
    public DescriptorProtos$UninterpretedOption$Builder addName(final int n, final DescriptorProtos$UninterpretedOption$NamePart descriptorProtos$UninterpretedOption$NamePart) {
        if (this.nameBuilder_ == null) {
            if (descriptorProtos$UninterpretedOption$NamePart == null) {
                throw new NullPointerException();
            }
            this.ensureNameIsMutable();
            this.name_.add(n, descriptorProtos$UninterpretedOption$NamePart);
            this.onChanged();
        }
        else {
            this.nameBuilder_.addMessage(n, descriptorProtos$UninterpretedOption$NamePart);
        }
        return this;
    }
    
    public DescriptorProtos$UninterpretedOption$Builder addName(final DescriptorProtos$UninterpretedOption$NamePart$Builder descriptorProtos$UninterpretedOption$NamePart$Builder) {
        if (this.nameBuilder_ == null) {
            this.ensureNameIsMutable();
            this.name_.add(descriptorProtos$UninterpretedOption$NamePart$Builder.build());
            this.onChanged();
        }
        else {
            this.nameBuilder_.addMessage(descriptorProtos$UninterpretedOption$NamePart$Builder.build());
        }
        return this;
    }
    
    public DescriptorProtos$UninterpretedOption$Builder addName(final int n, final DescriptorProtos$UninterpretedOption$NamePart$Builder descriptorProtos$UninterpretedOption$NamePart$Builder) {
        if (this.nameBuilder_ == null) {
            this.ensureNameIsMutable();
            this.name_.add(n, descriptorProtos$UninterpretedOption$NamePart$Builder.build());
            this.onChanged();
        }
        else {
            this.nameBuilder_.addMessage(n, descriptorProtos$UninterpretedOption$NamePart$Builder.build());
        }
        return this;
    }
    
    public DescriptorProtos$UninterpretedOption$Builder addAllName(final Iterable iterable) {
        if (this.nameBuilder_ == null) {
            this.ensureNameIsMutable();
            AbstractMessageLite$Builder.addAll(iterable, this.name_);
            this.onChanged();
        }
        else {
            this.nameBuilder_.addAllMessages(iterable);
        }
        return this;
    }
    
    public DescriptorProtos$UninterpretedOption$Builder clearName() {
        if (this.nameBuilder_ == null) {
            this.name_ = Collections.emptyList();
            this.bitField0_ &= 0xFFFFFFFE;
            this.onChanged();
        }
        else {
            this.nameBuilder_.clear();
        }
        return this;
    }
    
    public DescriptorProtos$UninterpretedOption$Builder removeName(final int n) {
        if (this.nameBuilder_ == null) {
            this.ensureNameIsMutable();
            this.name_.remove(n);
            this.onChanged();
        }
        else {
            this.nameBuilder_.remove(n);
        }
        return this;
    }
    
    public DescriptorProtos$UninterpretedOption$NamePart$Builder getNameBuilder(final int n) {
        return (DescriptorProtos$UninterpretedOption$NamePart$Builder)this.getNameFieldBuilder().getBuilder(n);
    }
    
    public DescriptorProtos$UninterpretedOption$NamePartOrBuilder getNameOrBuilder(final int n) {
        if (this.nameBuilder_ == null) {
            return this.name_.get(n);
        }
        return (DescriptorProtos$UninterpretedOption$NamePartOrBuilder)this.nameBuilder_.getMessageOrBuilder(n);
    }
    
    public List getNameOrBuilderList() {
        if (this.nameBuilder_ != null) {
            return this.nameBuilder_.getMessageOrBuilderList();
        }
        return Collections.unmodifiableList((List<?>)this.name_);
    }
    
    public DescriptorProtos$UninterpretedOption$NamePart$Builder addNameBuilder() {
        return (DescriptorProtos$UninterpretedOption$NamePart$Builder)this.getNameFieldBuilder().addBuilder(DescriptorProtos$UninterpretedOption$NamePart.getDefaultInstance());
    }
    
    public DescriptorProtos$UninterpretedOption$NamePart$Builder addNameBuilder(final int n) {
        return (DescriptorProtos$UninterpretedOption$NamePart$Builder)this.getNameFieldBuilder().addBuilder(n, DescriptorProtos$UninterpretedOption$NamePart.getDefaultInstance());
    }
    
    public List getNameBuilderList() {
        return this.getNameFieldBuilder().getBuilderList();
    }
    
    private RepeatedFieldBuilder getNameFieldBuilder() {
        if (this.nameBuilder_ == null) {
            this.nameBuilder_ = new RepeatedFieldBuilder(this.name_, (this.bitField0_ & 0x1) == 0x1, this.getParentForChildren(), this.isClean());
            this.name_ = null;
        }
        return this.nameBuilder_;
    }
    
    public boolean hasIdentifierValue() {
        return (this.bitField0_ & 0x2) == 0x2;
    }
    
    public String getIdentifierValue() {
        final Object identifierValue_ = this.identifierValue_;
        if (!(identifierValue_ instanceof String)) {
            final ByteString byteString = (ByteString)identifierValue_;
            final String stringUtf8 = byteString.toStringUtf8();
            if (byteString.isValidUtf8()) {
                this.identifierValue_ = stringUtf8;
            }
            return stringUtf8;
        }
        return (String)identifierValue_;
    }
    
    public ByteString getIdentifierValueBytes() {
        final Object identifierValue_ = this.identifierValue_;
        if (identifierValue_ instanceof String) {
            return (ByteString)(this.identifierValue_ = ByteString.copyFromUtf8((String)identifierValue_));
        }
        return (ByteString)identifierValue_;
    }
    
    public DescriptorProtos$UninterpretedOption$Builder setIdentifierValue(final String identifierValue_) {
        if (identifierValue_ == null) {
            throw new NullPointerException();
        }
        this.bitField0_ |= 0x2;
        this.identifierValue_ = identifierValue_;
        this.onChanged();
        return this;
    }
    
    public DescriptorProtos$UninterpretedOption$Builder clearIdentifierValue() {
        this.bitField0_ &= 0xFFFFFFFD;
        this.identifierValue_ = DescriptorProtos$UninterpretedOption.getDefaultInstance().getIdentifierValue();
        this.onChanged();
        return this;
    }
    
    public DescriptorProtos$UninterpretedOption$Builder setIdentifierValueBytes(final ByteString identifierValue_) {
        if (identifierValue_ == null) {
            throw new NullPointerException();
        }
        this.bitField0_ |= 0x2;
        this.identifierValue_ = identifierValue_;
        this.onChanged();
        return this;
    }
    
    public boolean hasPositiveIntValue() {
        return (this.bitField0_ & 0x4) == 0x4;
    }
    
    public long getPositiveIntValue() {
        return this.positiveIntValue_;
    }
    
    public DescriptorProtos$UninterpretedOption$Builder setPositiveIntValue(final long positiveIntValue_) {
        this.bitField0_ |= 0x4;
        this.positiveIntValue_ = positiveIntValue_;
        this.onChanged();
        return this;
    }
    
    public DescriptorProtos$UninterpretedOption$Builder clearPositiveIntValue() {
        this.bitField0_ &= 0xFFFFFFFB;
        this.positiveIntValue_ = 0L;
        this.onChanged();
        return this;
    }
    
    public boolean hasNegativeIntValue() {
        return (this.bitField0_ & 0x8) == 0x8;
    }
    
    public long getNegativeIntValue() {
        return this.negativeIntValue_;
    }
    
    public DescriptorProtos$UninterpretedOption$Builder setNegativeIntValue(final long negativeIntValue_) {
        this.bitField0_ |= 0x8;
        this.negativeIntValue_ = negativeIntValue_;
        this.onChanged();
        return this;
    }
    
    public DescriptorProtos$UninterpretedOption$Builder clearNegativeIntValue() {
        this.bitField0_ &= 0xFFFFFFF7;
        this.negativeIntValue_ = 0L;
        this.onChanged();
        return this;
    }
    
    public boolean hasDoubleValue() {
        return (this.bitField0_ & 0x10) == 0x10;
    }
    
    public double getDoubleValue() {
        return this.doubleValue_;
    }
    
    public DescriptorProtos$UninterpretedOption$Builder setDoubleValue(final double doubleValue_) {
        this.bitField0_ |= 0x10;
        this.doubleValue_ = doubleValue_;
        this.onChanged();
        return this;
    }
    
    public DescriptorProtos$UninterpretedOption$Builder clearDoubleValue() {
        this.bitField0_ &= 0xFFFFFFEF;
        this.doubleValue_ = 0.0;
        this.onChanged();
        return this;
    }
    
    public boolean hasStringValue() {
        return (this.bitField0_ & 0x20) == 0x20;
    }
    
    public ByteString getStringValue() {
        return this.stringValue_;
    }
    
    public DescriptorProtos$UninterpretedOption$Builder setStringValue(final ByteString stringValue_) {
        if (stringValue_ == null) {
            throw new NullPointerException();
        }
        this.bitField0_ |= 0x20;
        this.stringValue_ = stringValue_;
        this.onChanged();
        return this;
    }
    
    public DescriptorProtos$UninterpretedOption$Builder clearStringValue() {
        this.bitField0_ &= 0xFFFFFFDF;
        this.stringValue_ = DescriptorProtos$UninterpretedOption.getDefaultInstance().getStringValue();
        this.onChanged();
        return this;
    }
    
    public boolean hasAggregateValue() {
        return (this.bitField0_ & 0x40) == 0x40;
    }
    
    public String getAggregateValue() {
        final Object aggregateValue_ = this.aggregateValue_;
        if (!(aggregateValue_ instanceof String)) {
            final ByteString byteString = (ByteString)aggregateValue_;
            final String stringUtf8 = byteString.toStringUtf8();
            if (byteString.isValidUtf8()) {
                this.aggregateValue_ = stringUtf8;
            }
            return stringUtf8;
        }
        return (String)aggregateValue_;
    }
    
    public ByteString getAggregateValueBytes() {
        final Object aggregateValue_ = this.aggregateValue_;
        if (aggregateValue_ instanceof String) {
            return (ByteString)(this.aggregateValue_ = ByteString.copyFromUtf8((String)aggregateValue_));
        }
        return (ByteString)aggregateValue_;
    }
    
    public DescriptorProtos$UninterpretedOption$Builder setAggregateValue(final String aggregateValue_) {
        if (aggregateValue_ == null) {
            throw new NullPointerException();
        }
        this.bitField0_ |= 0x40;
        this.aggregateValue_ = aggregateValue_;
        this.onChanged();
        return this;
    }
    
    public DescriptorProtos$UninterpretedOption$Builder clearAggregateValue() {
        this.bitField0_ &= 0xFFFFFFBF;
        this.aggregateValue_ = DescriptorProtos$UninterpretedOption.getDefaultInstance().getAggregateValue();
        this.onChanged();
        return this;
    }
    
    public DescriptorProtos$UninterpretedOption$Builder setAggregateValueBytes(final ByteString aggregateValue_) {
        if (aggregateValue_ == null) {
            throw new NullPointerException();
        }
        this.bitField0_ |= 0x40;
        this.aggregateValue_ = aggregateValue_;
        this.onChanged();
        return this;
    }
}
