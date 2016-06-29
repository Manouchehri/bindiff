package com.google.protobuf;

import java.util.*;
import java.io.*;

public final class Type$Builder extends GeneratedMessage$Builder implements TypeOrBuilder
{
    private int bitField0_;
    private Object name_;
    private List fields_;
    private RepeatedFieldBuilder fieldsBuilder_;
    private LazyStringList oneofs_;
    private List options_;
    private RepeatedFieldBuilder optionsBuilder_;
    private SourceContext sourceContext_;
    private SingleFieldBuilder sourceContextBuilder_;
    
    public static final Descriptors$Descriptor getDescriptor() {
        return TypeProto.internal_static_google_protobuf_Type_descriptor;
    }
    
    protected GeneratedMessage$FieldAccessorTable internalGetFieldAccessorTable() {
        return TypeProto.internal_static_google_protobuf_Type_fieldAccessorTable.ensureFieldAccessorsInitialized(Type.class, Type$Builder.class);
    }
    
    private Type$Builder() {
        this.name_ = "";
        this.fields_ = Collections.emptyList();
        this.oneofs_ = LazyStringArrayList.EMPTY;
        this.options_ = Collections.emptyList();
        this.sourceContext_ = null;
        this.maybeForceBuilderInitialization();
    }
    
    private Type$Builder(final GeneratedMessage$BuilderParent generatedMessage$BuilderParent) {
        super(generatedMessage$BuilderParent);
        this.name_ = "";
        this.fields_ = Collections.emptyList();
        this.oneofs_ = LazyStringArrayList.EMPTY;
        this.options_ = Collections.emptyList();
        this.sourceContext_ = null;
        this.maybeForceBuilderInitialization();
    }
    
    private void maybeForceBuilderInitialization() {
        if (GeneratedMessage.alwaysUseFieldBuilders) {
            this.getFieldsFieldBuilder();
            this.getOptionsFieldBuilder();
        }
    }
    
    public Type$Builder clear() {
        super.clear();
        this.name_ = "";
        if (this.fieldsBuilder_ == null) {
            this.fields_ = Collections.emptyList();
            this.bitField0_ &= 0xFFFFFFFD;
        }
        else {
            this.fieldsBuilder_.clear();
        }
        this.oneofs_ = LazyStringArrayList.EMPTY;
        this.bitField0_ &= 0xFFFFFFFB;
        if (this.optionsBuilder_ == null) {
            this.options_ = Collections.emptyList();
            this.bitField0_ &= 0xFFFFFFF7;
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
        return TypeProto.internal_static_google_protobuf_Type_descriptor;
    }
    
    public Type getDefaultInstanceForType() {
        return Type.getDefaultInstance();
    }
    
    public Type build() {
        final Type buildPartial = this.buildPartial();
        if (!buildPartial.isInitialized()) {
            throw AbstractMessage$Builder.newUninitializedMessageException(buildPartial);
        }
        return buildPartial;
    }
    
    public Type buildPartial() {
        final Type type = new Type(this, null);
        final int bitField0_ = this.bitField0_;
        final int n = 0;
        type.name_ = this.name_;
        if (this.fieldsBuilder_ == null) {
            if ((this.bitField0_ & 0x2) == 0x2) {
                this.fields_ = Collections.unmodifiableList((List<?>)this.fields_);
                this.bitField0_ &= 0xFFFFFFFD;
            }
            type.fields_ = this.fields_;
        }
        else {
            type.fields_ = this.fieldsBuilder_.build();
        }
        if ((this.bitField0_ & 0x4) == 0x4) {
            this.oneofs_ = this.oneofs_.getUnmodifiableView();
            this.bitField0_ &= 0xFFFFFFFB;
        }
        type.oneofs_ = this.oneofs_;
        if (this.optionsBuilder_ == null) {
            if ((this.bitField0_ & 0x8) == 0x8) {
                this.options_ = Collections.unmodifiableList((List<?>)this.options_);
                this.bitField0_ &= 0xFFFFFFF7;
            }
            type.options_ = this.options_;
        }
        else {
            type.options_ = this.optionsBuilder_.build();
        }
        if (this.sourceContextBuilder_ == null) {
            type.sourceContext_ = this.sourceContext_;
        }
        else {
            type.sourceContext_ = (SourceContext)this.sourceContextBuilder_.build();
        }
        type.bitField0_ = n;
        this.onBuilt();
        return type;
    }
    
    public Type$Builder mergeFrom(final Message message) {
        if (message instanceof Type) {
            return this.mergeFrom((Type)message);
        }
        super.mergeFrom(message);
        return this;
    }
    
    public Type$Builder mergeFrom(final Type type) {
        if (type == Type.getDefaultInstance()) {
            return this;
        }
        if (!type.getName().isEmpty()) {
            this.name_ = type.name_;
            this.onChanged();
        }
        if (this.fieldsBuilder_ == null) {
            if (!type.fields_.isEmpty()) {
                if (this.fields_.isEmpty()) {
                    this.fields_ = type.fields_;
                    this.bitField0_ &= 0xFFFFFFFD;
                }
                else {
                    this.ensureFieldsIsMutable();
                    this.fields_.addAll(type.fields_);
                }
                this.onChanged();
            }
        }
        else if (!type.fields_.isEmpty()) {
            if (this.fieldsBuilder_.isEmpty()) {
                this.fieldsBuilder_.dispose();
                this.fieldsBuilder_ = null;
                this.fields_ = type.fields_;
                this.bitField0_ &= 0xFFFFFFFD;
                this.fieldsBuilder_ = (GeneratedMessage.alwaysUseFieldBuilders ? this.getFieldsFieldBuilder() : null);
            }
            else {
                this.fieldsBuilder_.addAllMessages(type.fields_);
            }
        }
        if (!type.oneofs_.isEmpty()) {
            if (this.oneofs_.isEmpty()) {
                this.oneofs_ = type.oneofs_;
                this.bitField0_ &= 0xFFFFFFFB;
            }
            else {
                this.ensureOneofsIsMutable();
                this.oneofs_.addAll(type.oneofs_);
            }
            this.onChanged();
        }
        if (this.optionsBuilder_ == null) {
            if (!type.options_.isEmpty()) {
                if (this.options_.isEmpty()) {
                    this.options_ = type.options_;
                    this.bitField0_ &= 0xFFFFFFF7;
                }
                else {
                    this.ensureOptionsIsMutable();
                    this.options_.addAll(type.options_);
                }
                this.onChanged();
            }
        }
        else if (!type.options_.isEmpty()) {
            if (this.optionsBuilder_.isEmpty()) {
                this.optionsBuilder_.dispose();
                this.optionsBuilder_ = null;
                this.options_ = type.options_;
                this.bitField0_ &= 0xFFFFFFF7;
                this.optionsBuilder_ = (GeneratedMessage.alwaysUseFieldBuilders ? this.getOptionsFieldBuilder() : null);
            }
            else {
                this.optionsBuilder_.addAllMessages(type.options_);
            }
        }
        if (type.hasSourceContext()) {
            this.mergeSourceContext(type.getSourceContext());
        }
        this.onChanged();
        return this;
    }
    
    public final boolean isInitialized() {
        return true;
    }
    
    public Type$Builder mergeFrom(final CodedInputStream codedInputStream, final ExtensionRegistryLite extensionRegistryLite) {
        Type type = null;
        try {
            type = (Type)Type.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
        }
        catch (InvalidProtocolBufferException ex) {
            type = (Type)ex.getUnfinishedMessage();
            throw ex;
        }
        finally {
            if (type != null) {
                this.mergeFrom(type);
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
    
    public Type$Builder setName(final String name_) {
        if (name_ == null) {
            throw new NullPointerException();
        }
        this.name_ = name_;
        this.onChanged();
        return this;
    }
    
    public Type$Builder clearName() {
        this.name_ = Type.getDefaultInstance().getName();
        this.onChanged();
        return this;
    }
    
    public Type$Builder setNameBytes(final ByteString name_) {
        if (name_ == null) {
            throw new NullPointerException();
        }
        this.name_ = name_;
        this.onChanged();
        return this;
    }
    
    private void ensureFieldsIsMutable() {
        if ((this.bitField0_ & 0x2) != 0x2) {
            this.fields_ = new ArrayList(this.fields_);
            this.bitField0_ |= 0x2;
        }
    }
    
    public List getFieldsList() {
        if (this.fieldsBuilder_ == null) {
            return Collections.unmodifiableList((List<?>)this.fields_);
        }
        return this.fieldsBuilder_.getMessageList();
    }
    
    public int getFieldsCount() {
        if (this.fieldsBuilder_ == null) {
            return this.fields_.size();
        }
        return this.fieldsBuilder_.getCount();
    }
    
    public Field getFields(final int n) {
        if (this.fieldsBuilder_ == null) {
            return this.fields_.get(n);
        }
        return (Field)this.fieldsBuilder_.getMessage(n);
    }
    
    public Type$Builder setFields(final int n, final Field field) {
        if (this.fieldsBuilder_ == null) {
            if (field == null) {
                throw new NullPointerException();
            }
            this.ensureFieldsIsMutable();
            this.fields_.set(n, field);
            this.onChanged();
        }
        else {
            this.fieldsBuilder_.setMessage(n, field);
        }
        return this;
    }
    
    public Type$Builder setFields(final int n, final Field$Builder field$Builder) {
        if (this.fieldsBuilder_ == null) {
            this.ensureFieldsIsMutable();
            this.fields_.set(n, field$Builder.build());
            this.onChanged();
        }
        else {
            this.fieldsBuilder_.setMessage(n, field$Builder.build());
        }
        return this;
    }
    
    public Type$Builder addFields(final Field field) {
        if (this.fieldsBuilder_ == null) {
            if (field == null) {
                throw new NullPointerException();
            }
            this.ensureFieldsIsMutable();
            this.fields_.add(field);
            this.onChanged();
        }
        else {
            this.fieldsBuilder_.addMessage(field);
        }
        return this;
    }
    
    public Type$Builder addFields(final int n, final Field field) {
        if (this.fieldsBuilder_ == null) {
            if (field == null) {
                throw new NullPointerException();
            }
            this.ensureFieldsIsMutable();
            this.fields_.add(n, field);
            this.onChanged();
        }
        else {
            this.fieldsBuilder_.addMessage(n, field);
        }
        return this;
    }
    
    public Type$Builder addFields(final Field$Builder field$Builder) {
        if (this.fieldsBuilder_ == null) {
            this.ensureFieldsIsMutable();
            this.fields_.add(field$Builder.build());
            this.onChanged();
        }
        else {
            this.fieldsBuilder_.addMessage(field$Builder.build());
        }
        return this;
    }
    
    public Type$Builder addFields(final int n, final Field$Builder field$Builder) {
        if (this.fieldsBuilder_ == null) {
            this.ensureFieldsIsMutable();
            this.fields_.add(n, field$Builder.build());
            this.onChanged();
        }
        else {
            this.fieldsBuilder_.addMessage(n, field$Builder.build());
        }
        return this;
    }
    
    public Type$Builder addAllFields(final Iterable iterable) {
        if (this.fieldsBuilder_ == null) {
            this.ensureFieldsIsMutable();
            AbstractMessageLite$Builder.addAll(iterable, this.fields_);
            this.onChanged();
        }
        else {
            this.fieldsBuilder_.addAllMessages(iterable);
        }
        return this;
    }
    
    public Type$Builder clearFields() {
        if (this.fieldsBuilder_ == null) {
            this.fields_ = Collections.emptyList();
            this.bitField0_ &= 0xFFFFFFFD;
            this.onChanged();
        }
        else {
            this.fieldsBuilder_.clear();
        }
        return this;
    }
    
    public Type$Builder removeFields(final int n) {
        if (this.fieldsBuilder_ == null) {
            this.ensureFieldsIsMutable();
            this.fields_.remove(n);
            this.onChanged();
        }
        else {
            this.fieldsBuilder_.remove(n);
        }
        return this;
    }
    
    public Field$Builder getFieldsBuilder(final int n) {
        return (Field$Builder)this.getFieldsFieldBuilder().getBuilder(n);
    }
    
    public FieldOrBuilder getFieldsOrBuilder(final int n) {
        if (this.fieldsBuilder_ == null) {
            return this.fields_.get(n);
        }
        return (FieldOrBuilder)this.fieldsBuilder_.getMessageOrBuilder(n);
    }
    
    public List getFieldsOrBuilderList() {
        if (this.fieldsBuilder_ != null) {
            return this.fieldsBuilder_.getMessageOrBuilderList();
        }
        return Collections.unmodifiableList((List<?>)this.fields_);
    }
    
    public Field$Builder addFieldsBuilder() {
        return (Field$Builder)this.getFieldsFieldBuilder().addBuilder(Field.getDefaultInstance());
    }
    
    public Field$Builder addFieldsBuilder(final int n) {
        return (Field$Builder)this.getFieldsFieldBuilder().addBuilder(n, Field.getDefaultInstance());
    }
    
    public List getFieldsBuilderList() {
        return this.getFieldsFieldBuilder().getBuilderList();
    }
    
    private RepeatedFieldBuilder getFieldsFieldBuilder() {
        if (this.fieldsBuilder_ == null) {
            this.fieldsBuilder_ = new RepeatedFieldBuilder(this.fields_, (this.bitField0_ & 0x2) == 0x2, this.getParentForChildren(), this.isClean());
            this.fields_ = null;
        }
        return this.fieldsBuilder_;
    }
    
    private void ensureOneofsIsMutable() {
        if ((this.bitField0_ & 0x4) != 0x4) {
            this.oneofs_ = new LazyStringArrayList(this.oneofs_);
            this.bitField0_ |= 0x4;
        }
    }
    
    public ProtocolStringList getOneofsList() {
        return this.oneofs_.getUnmodifiableView();
    }
    
    public int getOneofsCount() {
        return this.oneofs_.size();
    }
    
    public String getOneofs(final int n) {
        return this.oneofs_.get(n);
    }
    
    public ByteString getOneofsBytes(final int n) {
        return this.oneofs_.getByteString(n);
    }
    
    public Type$Builder setOneofs(final int n, final String s) {
        if (s == null) {
            throw new NullPointerException();
        }
        this.ensureOneofsIsMutable();
        this.oneofs_.set(n, s);
        this.onChanged();
        return this;
    }
    
    public Type$Builder addOneofs(final String s) {
        if (s == null) {
            throw new NullPointerException();
        }
        this.ensureOneofsIsMutable();
        this.oneofs_.add(s);
        this.onChanged();
        return this;
    }
    
    public Type$Builder addAllOneofs(final Iterable iterable) {
        this.ensureOneofsIsMutable();
        AbstractMessageLite$Builder.addAll(iterable, this.oneofs_);
        this.onChanged();
        return this;
    }
    
    public Type$Builder clearOneofs() {
        this.oneofs_ = LazyStringArrayList.EMPTY;
        this.bitField0_ &= 0xFFFFFFFB;
        this.onChanged();
        return this;
    }
    
    public Type$Builder addOneofsBytes(final ByteString byteString) {
        if (byteString == null) {
            throw new NullPointerException();
        }
        this.ensureOneofsIsMutable();
        this.oneofs_.add(byteString);
        this.onChanged();
        return this;
    }
    
    private void ensureOptionsIsMutable() {
        if ((this.bitField0_ & 0x8) != 0x8) {
            this.options_ = new ArrayList(this.options_);
            this.bitField0_ |= 0x8;
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
    
    public Type$Builder setOptions(final int n, final Option option) {
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
    
    public Type$Builder setOptions(final int n, final Option$Builder option$Builder) {
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
    
    public Type$Builder addOptions(final Option option) {
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
    
    public Type$Builder addOptions(final int n, final Option option) {
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
    
    public Type$Builder addOptions(final Option$Builder option$Builder) {
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
    
    public Type$Builder addOptions(final int n, final Option$Builder option$Builder) {
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
    
    public Type$Builder addAllOptions(final Iterable iterable) {
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
    
    public Type$Builder clearOptions() {
        if (this.optionsBuilder_ == null) {
            this.options_ = Collections.emptyList();
            this.bitField0_ &= 0xFFFFFFF7;
            this.onChanged();
        }
        else {
            this.optionsBuilder_.clear();
        }
        return this;
    }
    
    public Type$Builder removeOptions(final int n) {
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
            this.optionsBuilder_ = new RepeatedFieldBuilder(this.options_, (this.bitField0_ & 0x8) == 0x8, this.getParentForChildren(), this.isClean());
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
    
    public Type$Builder setSourceContext(final SourceContext sourceContext) {
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
    
    public Type$Builder setSourceContext(final SourceContext$Builder sourceContext$Builder) {
        if (this.sourceContextBuilder_ == null) {
            this.sourceContext_ = sourceContext$Builder.build();
            this.onChanged();
        }
        else {
            this.sourceContextBuilder_.setMessage(sourceContext$Builder.build());
        }
        return this;
    }
    
    public Type$Builder mergeSourceContext(final SourceContext sourceContext_) {
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
    
    public Type$Builder clearSourceContext() {
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
    
    public final Type$Builder setUnknownFields(final UnknownFieldSet set) {
        return this;
    }
    
    public final Type$Builder mergeUnknownFields(final UnknownFieldSet set) {
        return this;
    }
}
