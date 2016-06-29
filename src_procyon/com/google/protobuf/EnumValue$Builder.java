package com.google.protobuf;

import java.util.*;
import java.io.*;

public final class EnumValue$Builder extends GeneratedMessage$Builder implements EnumValueOrBuilder
{
    private int bitField0_;
    private Object name_;
    private int number_;
    private List options_;
    private RepeatedFieldBuilder optionsBuilder_;
    
    public static final Descriptors$Descriptor getDescriptor() {
        return TypeProto.internal_static_google_protobuf_EnumValue_descriptor;
    }
    
    protected GeneratedMessage$FieldAccessorTable internalGetFieldAccessorTable() {
        return TypeProto.internal_static_google_protobuf_EnumValue_fieldAccessorTable.ensureFieldAccessorsInitialized(EnumValue.class, EnumValue$Builder.class);
    }
    
    private EnumValue$Builder() {
        this.name_ = "";
        this.options_ = Collections.emptyList();
        this.maybeForceBuilderInitialization();
    }
    
    private EnumValue$Builder(final GeneratedMessage$BuilderParent generatedMessage$BuilderParent) {
        super(generatedMessage$BuilderParent);
        this.name_ = "";
        this.options_ = Collections.emptyList();
        this.maybeForceBuilderInitialization();
    }
    
    private void maybeForceBuilderInitialization() {
        if (GeneratedMessage.alwaysUseFieldBuilders) {
            this.getOptionsFieldBuilder();
        }
    }
    
    public EnumValue$Builder clear() {
        super.clear();
        this.name_ = "";
        this.number_ = 0;
        if (this.optionsBuilder_ == null) {
            this.options_ = Collections.emptyList();
            this.bitField0_ &= 0xFFFFFFFB;
        }
        else {
            this.optionsBuilder_.clear();
        }
        return this;
    }
    
    public Descriptors$Descriptor getDescriptorForType() {
        return TypeProto.internal_static_google_protobuf_EnumValue_descriptor;
    }
    
    public EnumValue getDefaultInstanceForType() {
        return EnumValue.getDefaultInstance();
    }
    
    public EnumValue build() {
        final EnumValue buildPartial = this.buildPartial();
        if (!buildPartial.isInitialized()) {
            throw AbstractMessage$Builder.newUninitializedMessageException(buildPartial);
        }
        return buildPartial;
    }
    
    public EnumValue buildPartial() {
        final EnumValue enumValue = new EnumValue(this, null);
        final int bitField0_ = this.bitField0_;
        final int n = 0;
        enumValue.name_ = this.name_;
        enumValue.number_ = this.number_;
        if (this.optionsBuilder_ == null) {
            if ((this.bitField0_ & 0x4) == 0x4) {
                this.options_ = Collections.unmodifiableList((List<?>)this.options_);
                this.bitField0_ &= 0xFFFFFFFB;
            }
            enumValue.options_ = this.options_;
        }
        else {
            enumValue.options_ = this.optionsBuilder_.build();
        }
        enumValue.bitField0_ = n;
        this.onBuilt();
        return enumValue;
    }
    
    public EnumValue$Builder mergeFrom(final Message message) {
        if (message instanceof EnumValue) {
            return this.mergeFrom((EnumValue)message);
        }
        super.mergeFrom(message);
        return this;
    }
    
    public EnumValue$Builder mergeFrom(final EnumValue enumValue) {
        if (enumValue == EnumValue.getDefaultInstance()) {
            return this;
        }
        if (!enumValue.getName().isEmpty()) {
            this.name_ = enumValue.name_;
            this.onChanged();
        }
        if (enumValue.getNumber() != 0) {
            this.setNumber(enumValue.getNumber());
        }
        if (this.optionsBuilder_ == null) {
            if (!enumValue.options_.isEmpty()) {
                if (this.options_.isEmpty()) {
                    this.options_ = enumValue.options_;
                    this.bitField0_ &= 0xFFFFFFFB;
                }
                else {
                    this.ensureOptionsIsMutable();
                    this.options_.addAll(enumValue.options_);
                }
                this.onChanged();
            }
        }
        else if (!enumValue.options_.isEmpty()) {
            if (this.optionsBuilder_.isEmpty()) {
                this.optionsBuilder_.dispose();
                this.optionsBuilder_ = null;
                this.options_ = enumValue.options_;
                this.bitField0_ &= 0xFFFFFFFB;
                this.optionsBuilder_ = (GeneratedMessage.alwaysUseFieldBuilders ? this.getOptionsFieldBuilder() : null);
            }
            else {
                this.optionsBuilder_.addAllMessages(enumValue.options_);
            }
        }
        this.onChanged();
        return this;
    }
    
    public final boolean isInitialized() {
        return true;
    }
    
    public EnumValue$Builder mergeFrom(final CodedInputStream codedInputStream, final ExtensionRegistryLite extensionRegistryLite) {
        EnumValue enumValue = null;
        try {
            enumValue = (EnumValue)EnumValue.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
        }
        catch (InvalidProtocolBufferException ex) {
            enumValue = (EnumValue)ex.getUnfinishedMessage();
            throw ex;
        }
        finally {
            if (enumValue != null) {
                this.mergeFrom(enumValue);
            }
        }
        return this;
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
    
    public EnumValue$Builder setName(final String name_) {
        if (name_ == null) {
            throw new NullPointerException();
        }
        this.name_ = name_;
        this.onChanged();
        return this;
    }
    
    public EnumValue$Builder clearName() {
        this.name_ = EnumValue.getDefaultInstance().getName();
        this.onChanged();
        return this;
    }
    
    public EnumValue$Builder setNameBytes(final ByteString name_) {
        if (name_ == null) {
            throw new NullPointerException();
        }
        this.name_ = name_;
        this.onChanged();
        return this;
    }
    
    public int getNumber() {
        return this.number_;
    }
    
    public EnumValue$Builder setNumber(final int number_) {
        this.number_ = number_;
        this.onChanged();
        return this;
    }
    
    public EnumValue$Builder clearNumber() {
        this.number_ = 0;
        this.onChanged();
        return this;
    }
    
    private void ensureOptionsIsMutable() {
        if ((this.bitField0_ & 0x4) != 0x4) {
            this.options_ = new ArrayList(this.options_);
            this.bitField0_ |= 0x4;
        }
    }
    
    public List getOptionsList() {
        if (this.optionsBuilder_ == null) {
            return Collections.unmodifiableList((List<?>)this.options_);
        }
        return this.optionsBuilder_.getMessageList();
    }
    
    public int getOptionsCount() {
        if (this.optionsBuilder_ == null) {
            return this.options_.size();
        }
        return this.optionsBuilder_.getCount();
    }
    
    public Option getOptions(final int n) {
        if (this.optionsBuilder_ == null) {
            return this.options_.get(n);
        }
        return (Option)this.optionsBuilder_.getMessage(n);
    }
    
    public EnumValue$Builder setOptions(final int n, final Option option) {
        if (this.optionsBuilder_ == null) {
            if (option == null) {
                throw new NullPointerException();
            }
            this.ensureOptionsIsMutable();
            this.options_.set(n, option);
            this.onChanged();
        }
        else {
            this.optionsBuilder_.setMessage(n, option);
        }
        return this;
    }
    
    public EnumValue$Builder setOptions(final int n, final Option$Builder option$Builder) {
        if (this.optionsBuilder_ == null) {
            this.ensureOptionsIsMutable();
            this.options_.set(n, option$Builder.build());
            this.onChanged();
        }
        else {
            this.optionsBuilder_.setMessage(n, option$Builder.build());
        }
        return this;
    }
    
    public EnumValue$Builder addOptions(final Option option) {
        if (this.optionsBuilder_ == null) {
            if (option == null) {
                throw new NullPointerException();
            }
            this.ensureOptionsIsMutable();
            this.options_.add(option);
            this.onChanged();
        }
        else {
            this.optionsBuilder_.addMessage(option);
        }
        return this;
    }
    
    public EnumValue$Builder addOptions(final int n, final Option option) {
        if (this.optionsBuilder_ == null) {
            if (option == null) {
                throw new NullPointerException();
            }
            this.ensureOptionsIsMutable();
            this.options_.add(n, option);
            this.onChanged();
        }
        else {
            this.optionsBuilder_.addMessage(n, option);
        }
        return this;
    }
    
    public EnumValue$Builder addOptions(final Option$Builder option$Builder) {
        if (this.optionsBuilder_ == null) {
            this.ensureOptionsIsMutable();
            this.options_.add(option$Builder.build());
            this.onChanged();
        }
        else {
            this.optionsBuilder_.addMessage(option$Builder.build());
        }
        return this;
    }
    
    public EnumValue$Builder addOptions(final int n, final Option$Builder option$Builder) {
        if (this.optionsBuilder_ == null) {
            this.ensureOptionsIsMutable();
            this.options_.add(n, option$Builder.build());
            this.onChanged();
        }
        else {
            this.optionsBuilder_.addMessage(n, option$Builder.build());
        }
        return this;
    }
    
    public EnumValue$Builder addAllOptions(final Iterable iterable) {
        if (this.optionsBuilder_ == null) {
            this.ensureOptionsIsMutable();
            AbstractMessageLite$Builder.addAll(iterable, this.options_);
            this.onChanged();
        }
        else {
            this.optionsBuilder_.addAllMessages(iterable);
        }
        return this;
    }
    
    public EnumValue$Builder clearOptions() {
        if (this.optionsBuilder_ == null) {
            this.options_ = Collections.emptyList();
            this.bitField0_ &= 0xFFFFFFFB;
            this.onChanged();
        }
        else {
            this.optionsBuilder_.clear();
        }
        return this;
    }
    
    public EnumValue$Builder removeOptions(final int n) {
        if (this.optionsBuilder_ == null) {
            this.ensureOptionsIsMutable();
            this.options_.remove(n);
            this.onChanged();
        }
        else {
            this.optionsBuilder_.remove(n);
        }
        return this;
    }
    
    public Option$Builder getOptionsBuilder(final int n) {
        return (Option$Builder)this.getOptionsFieldBuilder().getBuilder(n);
    }
    
    public OptionOrBuilder getOptionsOrBuilder(final int n) {
        if (this.optionsBuilder_ == null) {
            return this.options_.get(n);
        }
        return (OptionOrBuilder)this.optionsBuilder_.getMessageOrBuilder(n);
    }
    
    public List getOptionsOrBuilderList() {
        if (this.optionsBuilder_ != null) {
            return this.optionsBuilder_.getMessageOrBuilderList();
        }
        return Collections.unmodifiableList((List<?>)this.options_);
    }
    
    public Option$Builder addOptionsBuilder() {
        return (Option$Builder)this.getOptionsFieldBuilder().addBuilder(Option.getDefaultInstance());
    }
    
    public Option$Builder addOptionsBuilder(final int n) {
        return (Option$Builder)this.getOptionsFieldBuilder().addBuilder(n, Option.getDefaultInstance());
    }
    
    public List getOptionsBuilderList() {
        return this.getOptionsFieldBuilder().getBuilderList();
    }
    
    private RepeatedFieldBuilder getOptionsFieldBuilder() {
        if (this.optionsBuilder_ == null) {
            this.optionsBuilder_ = new RepeatedFieldBuilder(this.options_, (this.bitField0_ & 0x4) == 0x4, this.getParentForChildren(), this.isClean());
            this.options_ = null;
        }
        return this.optionsBuilder_;
    }
    
    public final EnumValue$Builder setUnknownFields(final UnknownFieldSet set) {
        return this;
    }
    
    public final EnumValue$Builder mergeUnknownFields(final UnknownFieldSet set) {
        return this;
    }
}
