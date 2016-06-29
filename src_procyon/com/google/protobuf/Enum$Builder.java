package com.google.protobuf;

import java.util.*;
import java.io.*;

public final class Enum$Builder extends GeneratedMessage$Builder implements EnumOrBuilder
{
    private int bitField0_;
    private Object name_;
    private List enumvalue_;
    private RepeatedFieldBuilder enumvalueBuilder_;
    private List options_;
    private RepeatedFieldBuilder optionsBuilder_;
    private SourceContext sourceContext_;
    private SingleFieldBuilder sourceContextBuilder_;
    
    public static final Descriptors$Descriptor getDescriptor() {
        return TypeProto.internal_static_google_protobuf_Enum_descriptor;
    }
    
    protected GeneratedMessage$FieldAccessorTable internalGetFieldAccessorTable() {
        return TypeProto.internal_static_google_protobuf_Enum_fieldAccessorTable.ensureFieldAccessorsInitialized(Enum.class, Enum$Builder.class);
    }
    
    private Enum$Builder() {
        this.name_ = "";
        this.enumvalue_ = Collections.emptyList();
        this.options_ = Collections.emptyList();
        this.sourceContext_ = null;
        this.maybeForceBuilderInitialization();
    }
    
    private Enum$Builder(final GeneratedMessage$BuilderParent generatedMessage$BuilderParent) {
        super(generatedMessage$BuilderParent);
        this.name_ = "";
        this.enumvalue_ = Collections.emptyList();
        this.options_ = Collections.emptyList();
        this.sourceContext_ = null;
        this.maybeForceBuilderInitialization();
    }
    
    private void maybeForceBuilderInitialization() {
        if (GeneratedMessage.alwaysUseFieldBuilders) {
            this.getEnumvalueFieldBuilder();
            this.getOptionsFieldBuilder();
        }
    }
    
    public Enum$Builder clear() {
        super.clear();
        this.name_ = "";
        if (this.enumvalueBuilder_ == null) {
            this.enumvalue_ = Collections.emptyList();
            this.bitField0_ &= 0xFFFFFFFD;
        }
        else {
            this.enumvalueBuilder_.clear();
        }
        if (this.optionsBuilder_ == null) {
            this.options_ = Collections.emptyList();
            this.bitField0_ &= 0xFFFFFFFB;
        }
        else {
            this.optionsBuilder_.clear();
        }
        if (this.sourceContextBuilder_ == null) {
            this.sourceContext_ = null;
        }
        else {
            this.sourceContext_ = null;
            this.sourceContextBuilder_ = null;
        }
        return this;
    }
    
    public Descriptors$Descriptor getDescriptorForType() {
        return TypeProto.internal_static_google_protobuf_Enum_descriptor;
    }
    
    public Enum getDefaultInstanceForType() {
        return Enum.getDefaultInstance();
    }
    
    public Enum build() {
        final Enum buildPartial = this.buildPartial();
        if (!buildPartial.isInitialized()) {
            throw AbstractMessage$Builder.newUninitializedMessageException(buildPartial);
        }
        return buildPartial;
    }
    
    public Enum buildPartial() {
        final Enum enum1 = new Enum(this, null);
        final int bitField0_ = this.bitField0_;
        final int n = 0;
        enum1.name_ = this.name_;
        if (this.enumvalueBuilder_ == null) {
            if ((this.bitField0_ & 0x2) == 0x2) {
                this.enumvalue_ = Collections.unmodifiableList((List<?>)this.enumvalue_);
                this.bitField0_ &= 0xFFFFFFFD;
            }
            enum1.enumvalue_ = this.enumvalue_;
        }
        else {
            enum1.enumvalue_ = this.enumvalueBuilder_.build();
        }
        if (this.optionsBuilder_ == null) {
            if ((this.bitField0_ & 0x4) == 0x4) {
                this.options_ = Collections.unmodifiableList((List<?>)this.options_);
                this.bitField0_ &= 0xFFFFFFFB;
            }
            enum1.options_ = this.options_;
        }
        else {
            enum1.options_ = this.optionsBuilder_.build();
        }
        if (this.sourceContextBuilder_ == null) {
            enum1.sourceContext_ = this.sourceContext_;
        }
        else {
            enum1.sourceContext_ = (SourceContext)this.sourceContextBuilder_.build();
        }
        enum1.bitField0_ = n;
        this.onBuilt();
        return enum1;
    }
    
    public Enum$Builder mergeFrom(final Message message) {
        if (message instanceof Enum) {
            return this.mergeFrom((Enum)message);
        }
        super.mergeFrom(message);
        return this;
    }
    
    public Enum$Builder mergeFrom(final Enum enum1) {
        if (enum1 == Enum.getDefaultInstance()) {
            return this;
        }
        if (!enum1.getName().isEmpty()) {
            this.name_ = enum1.name_;
            this.onChanged();
        }
        if (this.enumvalueBuilder_ == null) {
            if (!enum1.enumvalue_.isEmpty()) {
                if (this.enumvalue_.isEmpty()) {
                    this.enumvalue_ = enum1.enumvalue_;
                    this.bitField0_ &= 0xFFFFFFFD;
                }
                else {
                    this.ensureEnumvalueIsMutable();
                    this.enumvalue_.addAll(enum1.enumvalue_);
                }
                this.onChanged();
            }
        }
        else if (!enum1.enumvalue_.isEmpty()) {
            if (this.enumvalueBuilder_.isEmpty()) {
                this.enumvalueBuilder_.dispose();
                this.enumvalueBuilder_ = null;
                this.enumvalue_ = enum1.enumvalue_;
                this.bitField0_ &= 0xFFFFFFFD;
                this.enumvalueBuilder_ = (GeneratedMessage.alwaysUseFieldBuilders ? this.getEnumvalueFieldBuilder() : null);
            }
            else {
                this.enumvalueBuilder_.addAllMessages(enum1.enumvalue_);
            }
        }
        if (this.optionsBuilder_ == null) {
            if (!enum1.options_.isEmpty()) {
                if (this.options_.isEmpty()) {
                    this.options_ = enum1.options_;
                    this.bitField0_ &= 0xFFFFFFFB;
                }
                else {
                    this.ensureOptionsIsMutable();
                    this.options_.addAll(enum1.options_);
                }
                this.onChanged();
            }
        }
        else if (!enum1.options_.isEmpty()) {
            if (this.optionsBuilder_.isEmpty()) {
                this.optionsBuilder_.dispose();
                this.optionsBuilder_ = null;
                this.options_ = enum1.options_;
                this.bitField0_ &= 0xFFFFFFFB;
                this.optionsBuilder_ = (GeneratedMessage.alwaysUseFieldBuilders ? this.getOptionsFieldBuilder() : null);
            }
            else {
                this.optionsBuilder_.addAllMessages(enum1.options_);
            }
        }
        if (enum1.hasSourceContext()) {
            this.mergeSourceContext(enum1.getSourceContext());
        }
        this.onChanged();
        return this;
    }
    
    public final boolean isInitialized() {
        return true;
    }
    
    public Enum$Builder mergeFrom(final CodedInputStream codedInputStream, final ExtensionRegistryLite extensionRegistryLite) {
        Enum enum1 = null;
        try {
            enum1 = (Enum)Enum.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
        }
        catch (InvalidProtocolBufferException ex) {
            enum1 = (Enum)ex.getUnfinishedMessage();
            throw ex;
        }
        finally {
            if (enum1 != null) {
                this.mergeFrom(enum1);
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
    
    public Enum$Builder setName(final String name_) {
        if (name_ == null) {
            throw new NullPointerException();
        }
        this.name_ = name_;
        this.onChanged();
        return this;
    }
    
    public Enum$Builder clearName() {
        this.name_ = Enum.getDefaultInstance().getName();
        this.onChanged();
        return this;
    }
    
    public Enum$Builder setNameBytes(final ByteString name_) {
        if (name_ == null) {
            throw new NullPointerException();
        }
        this.name_ = name_;
        this.onChanged();
        return this;
    }
    
    private void ensureEnumvalueIsMutable() {
        if ((this.bitField0_ & 0x2) != 0x2) {
            this.enumvalue_ = new ArrayList(this.enumvalue_);
            this.bitField0_ |= 0x2;
        }
    }
    
    public List getEnumvalueList() {
        if (this.enumvalueBuilder_ == null) {
            return Collections.unmodifiableList((List<?>)this.enumvalue_);
        }
        return this.enumvalueBuilder_.getMessageList();
    }
    
    public int getEnumvalueCount() {
        if (this.enumvalueBuilder_ == null) {
            return this.enumvalue_.size();
        }
        return this.enumvalueBuilder_.getCount();
    }
    
    public EnumValue getEnumvalue(final int n) {
        if (this.enumvalueBuilder_ == null) {
            return this.enumvalue_.get(n);
        }
        return (EnumValue)this.enumvalueBuilder_.getMessage(n);
    }
    
    public Enum$Builder setEnumvalue(final int n, final EnumValue enumValue) {
        if (this.enumvalueBuilder_ == null) {
            if (enumValue == null) {
                throw new NullPointerException();
            }
            this.ensureEnumvalueIsMutable();
            this.enumvalue_.set(n, enumValue);
            this.onChanged();
        }
        else {
            this.enumvalueBuilder_.setMessage(n, enumValue);
        }
        return this;
    }
    
    public Enum$Builder setEnumvalue(final int n, final EnumValue$Builder enumValue$Builder) {
        if (this.enumvalueBuilder_ == null) {
            this.ensureEnumvalueIsMutable();
            this.enumvalue_.set(n, enumValue$Builder.build());
            this.onChanged();
        }
        else {
            this.enumvalueBuilder_.setMessage(n, enumValue$Builder.build());
        }
        return this;
    }
    
    public Enum$Builder addEnumvalue(final EnumValue enumValue) {
        if (this.enumvalueBuilder_ == null) {
            if (enumValue == null) {
                throw new NullPointerException();
            }
            this.ensureEnumvalueIsMutable();
            this.enumvalue_.add(enumValue);
            this.onChanged();
        }
        else {
            this.enumvalueBuilder_.addMessage(enumValue);
        }
        return this;
    }
    
    public Enum$Builder addEnumvalue(final int n, final EnumValue enumValue) {
        if (this.enumvalueBuilder_ == null) {
            if (enumValue == null) {
                throw new NullPointerException();
            }
            this.ensureEnumvalueIsMutable();
            this.enumvalue_.add(n, enumValue);
            this.onChanged();
        }
        else {
            this.enumvalueBuilder_.addMessage(n, enumValue);
        }
        return this;
    }
    
    public Enum$Builder addEnumvalue(final EnumValue$Builder enumValue$Builder) {
        if (this.enumvalueBuilder_ == null) {
            this.ensureEnumvalueIsMutable();
            this.enumvalue_.add(enumValue$Builder.build());
            this.onChanged();
        }
        else {
            this.enumvalueBuilder_.addMessage(enumValue$Builder.build());
        }
        return this;
    }
    
    public Enum$Builder addEnumvalue(final int n, final EnumValue$Builder enumValue$Builder) {
        if (this.enumvalueBuilder_ == null) {
            this.ensureEnumvalueIsMutable();
            this.enumvalue_.add(n, enumValue$Builder.build());
            this.onChanged();
        }
        else {
            this.enumvalueBuilder_.addMessage(n, enumValue$Builder.build());
        }
        return this;
    }
    
    public Enum$Builder addAllEnumvalue(final Iterable iterable) {
        if (this.enumvalueBuilder_ == null) {
            this.ensureEnumvalueIsMutable();
            AbstractMessageLite$Builder.addAll(iterable, this.enumvalue_);
            this.onChanged();
        }
        else {
            this.enumvalueBuilder_.addAllMessages(iterable);
        }
        return this;
    }
    
    public Enum$Builder clearEnumvalue() {
        if (this.enumvalueBuilder_ == null) {
            this.enumvalue_ = Collections.emptyList();
            this.bitField0_ &= 0xFFFFFFFD;
            this.onChanged();
        }
        else {
            this.enumvalueBuilder_.clear();
        }
        return this;
    }
    
    public Enum$Builder removeEnumvalue(final int n) {
        if (this.enumvalueBuilder_ == null) {
            this.ensureEnumvalueIsMutable();
            this.enumvalue_.remove(n);
            this.onChanged();
        }
        else {
            this.enumvalueBuilder_.remove(n);
        }
        return this;
    }
    
    public EnumValue$Builder getEnumvalueBuilder(final int n) {
        return (EnumValue$Builder)this.getEnumvalueFieldBuilder().getBuilder(n);
    }
    
    public EnumValueOrBuilder getEnumvalueOrBuilder(final int n) {
        if (this.enumvalueBuilder_ == null) {
            return this.enumvalue_.get(n);
        }
        return (EnumValueOrBuilder)this.enumvalueBuilder_.getMessageOrBuilder(n);
    }
    
    public List getEnumvalueOrBuilderList() {
        if (this.enumvalueBuilder_ != null) {
            return this.enumvalueBuilder_.getMessageOrBuilderList();
        }
        return Collections.unmodifiableList((List<?>)this.enumvalue_);
    }
    
    public EnumValue$Builder addEnumvalueBuilder() {
        return (EnumValue$Builder)this.getEnumvalueFieldBuilder().addBuilder(EnumValue.getDefaultInstance());
    }
    
    public EnumValue$Builder addEnumvalueBuilder(final int n) {
        return (EnumValue$Builder)this.getEnumvalueFieldBuilder().addBuilder(n, EnumValue.getDefaultInstance());
    }
    
    public List getEnumvalueBuilderList() {
        return this.getEnumvalueFieldBuilder().getBuilderList();
    }
    
    private RepeatedFieldBuilder getEnumvalueFieldBuilder() {
        if (this.enumvalueBuilder_ == null) {
            this.enumvalueBuilder_ = new RepeatedFieldBuilder(this.enumvalue_, (this.bitField0_ & 0x2) == 0x2, this.getParentForChildren(), this.isClean());
            this.enumvalue_ = null;
        }
        return this.enumvalueBuilder_;
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
    
    public Enum$Builder setOptions(final int n, final Option option) {
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
    
    public Enum$Builder setOptions(final int n, final Option$Builder option$Builder) {
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
    
    public Enum$Builder addOptions(final Option option) {
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
    
    public Enum$Builder addOptions(final int n, final Option option) {
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
    
    public Enum$Builder addOptions(final Option$Builder option$Builder) {
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
    
    public Enum$Builder addOptions(final int n, final Option$Builder option$Builder) {
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
    
    public Enum$Builder addAllOptions(final Iterable iterable) {
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
    
    public Enum$Builder clearOptions() {
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
    
    public Enum$Builder removeOptions(final int n) {
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
    
    public boolean hasSourceContext() {
        return this.sourceContextBuilder_ != null || this.sourceContext_ != null;
    }
    
    public SourceContext getSourceContext() {
        if (this.sourceContextBuilder_ == null) {
            return (this.sourceContext_ == null) ? SourceContext.getDefaultInstance() : this.sourceContext_;
        }
        return (SourceContext)this.sourceContextBuilder_.getMessage();
    }
    
    public Enum$Builder setSourceContext(final SourceContext sourceContext) {
        if (this.sourceContextBuilder_ == null) {
            if (sourceContext == null) {
                throw new NullPointerException();
            }
            this.sourceContext_ = sourceContext;
            this.onChanged();
        }
        else {
            this.sourceContextBuilder_.setMessage(sourceContext);
        }
        return this;
    }
    
    public Enum$Builder setSourceContext(final SourceContext$Builder sourceContext$Builder) {
        if (this.sourceContextBuilder_ == null) {
            this.sourceContext_ = sourceContext$Builder.build();
            this.onChanged();
        }
        else {
            this.sourceContextBuilder_.setMessage(sourceContext$Builder.build());
        }
        return this;
    }
    
    public Enum$Builder mergeSourceContext(final SourceContext sourceContext_) {
        if (this.sourceContextBuilder_ == null) {
            if (this.sourceContext_ != null) {
                this.sourceContext_ = SourceContext.newBuilder(this.sourceContext_).mergeFrom(sourceContext_).buildPartial();
            }
            else {
                this.sourceContext_ = sourceContext_;
            }
            this.onChanged();
        }
        else {
            this.sourceContextBuilder_.mergeFrom(sourceContext_);
        }
        return this;
    }
    
    public Enum$Builder clearSourceContext() {
        if (this.sourceContextBuilder_ == null) {
            this.sourceContext_ = null;
            this.onChanged();
        }
        else {
            this.sourceContext_ = null;
            this.sourceContextBuilder_ = null;
        }
        return this;
    }
    
    public SourceContext$Builder getSourceContextBuilder() {
        this.onChanged();
        return (SourceContext$Builder)this.getSourceContextFieldBuilder().getBuilder();
    }
    
    public SourceContextOrBuilder getSourceContextOrBuilder() {
        if (this.sourceContextBuilder_ != null) {
            return (SourceContextOrBuilder)this.sourceContextBuilder_.getMessageOrBuilder();
        }
        return (this.sourceContext_ == null) ? SourceContext.getDefaultInstance() : this.sourceContext_;
    }
    
    private SingleFieldBuilder getSourceContextFieldBuilder() {
        if (this.sourceContextBuilder_ == null) {
            this.sourceContextBuilder_ = new SingleFieldBuilder(this.getSourceContext(), this.getParentForChildren(), this.isClean());
            this.sourceContext_ = null;
        }
        return this.sourceContextBuilder_;
    }
    
    public final Enum$Builder setUnknownFields(final UnknownFieldSet set) {
        return this;
    }
    
    public final Enum$Builder mergeUnknownFields(final UnknownFieldSet set) {
        return this;
    }
}
