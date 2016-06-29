package com.google.protobuf;

import java.util.*;
import java.io.*;

public final class Field$Builder extends GeneratedMessage$Builder implements FieldOrBuilder
{
    private int bitField0_;
    private int kind_;
    private int cardinality_;
    private int number_;
    private Object name_;
    private Object typeUrl_;
    private int oneofIndex_;
    private boolean packed_;
    private List options_;
    private RepeatedFieldBuilder optionsBuilder_;
    
    public static final Descriptors$Descriptor getDescriptor() {
        return TypeProto.internal_static_google_protobuf_Field_descriptor;
    }
    
    protected GeneratedMessage$FieldAccessorTable internalGetFieldAccessorTable() {
        return TypeProto.internal_static_google_protobuf_Field_fieldAccessorTable.ensureFieldAccessorsInitialized(Field.class, Field$Builder.class);
    }
    
    private Field$Builder() {
        this.kind_ = 0;
        this.cardinality_ = 0;
        this.name_ = "";
        this.typeUrl_ = "";
        this.options_ = Collections.emptyList();
        this.maybeForceBuilderInitialization();
    }
    
    private Field$Builder(final GeneratedMessage$BuilderParent generatedMessage$BuilderParent) {
        super(generatedMessage$BuilderParent);
        this.kind_ = 0;
        this.cardinality_ = 0;
        this.name_ = "";
        this.typeUrl_ = "";
        this.options_ = Collections.emptyList();
        this.maybeForceBuilderInitialization();
    }
    
    private void maybeForceBuilderInitialization() {
        if (GeneratedMessage.alwaysUseFieldBuilders) {
            this.getOptionsFieldBuilder();
        }
    }
    
    public Field$Builder clear() {
        super.clear();
        this.kind_ = 0;
        this.cardinality_ = 0;
        this.number_ = 0;
        this.name_ = "";
        this.typeUrl_ = "";
        this.oneofIndex_ = 0;
        this.packed_ = false;
        if (this.optionsBuilder_ == null) {
            this.options_ = Collections.emptyList();
            this.bitField0_ &= 0xFFFFFF7F;
        }
        else {
            this.optionsBuilder_.clear();
        }
        return this;
    }
    
    public Descriptors$Descriptor getDescriptorForType() {
        return TypeProto.internal_static_google_protobuf_Field_descriptor;
    }
    
    public Field getDefaultInstanceForType() {
        return Field.getDefaultInstance();
    }
    
    public Field build() {
        final Field buildPartial = this.buildPartial();
        if (!buildPartial.isInitialized()) {
            throw AbstractMessage$Builder.newUninitializedMessageException(buildPartial);
        }
        return buildPartial;
    }
    
    public Field buildPartial() {
        final Field field = new Field(this, null);
        final int bitField0_ = this.bitField0_;
        final int n = 0;
        field.kind_ = this.kind_;
        field.cardinality_ = this.cardinality_;
        field.number_ = this.number_;
        field.name_ = this.name_;
        field.typeUrl_ = this.typeUrl_;
        field.oneofIndex_ = this.oneofIndex_;
        field.packed_ = this.packed_;
        if (this.optionsBuilder_ == null) {
            if ((this.bitField0_ & 0x80) == 0x80) {
                this.options_ = Collections.unmodifiableList((List<?>)this.options_);
                this.bitField0_ &= 0xFFFFFF7F;
            }
            field.options_ = this.options_;
        }
        else {
            field.options_ = this.optionsBuilder_.build();
        }
        field.bitField0_ = n;
        this.onBuilt();
        return field;
    }
    
    public Field$Builder mergeFrom(final Message message) {
        if (message instanceof Field) {
            return this.mergeFrom((Field)message);
        }
        super.mergeFrom(message);
        return this;
    }
    
    public Field$Builder mergeFrom(final Field field) {
        if (field == Field.getDefaultInstance()) {
            return this;
        }
        if (field.kind_ != 0) {
            this.setKindValue(field.getKindValue());
        }
        if (field.cardinality_ != 0) {
            this.setCardinalityValue(field.getCardinalityValue());
        }
        if (field.getNumber() != 0) {
            this.setNumber(field.getNumber());
        }
        if (!field.getName().isEmpty()) {
            this.name_ = field.name_;
            this.onChanged();
        }
        if (!field.getTypeUrl().isEmpty()) {
            this.typeUrl_ = field.typeUrl_;
            this.onChanged();
        }
        if (field.getOneofIndex() != 0) {
            this.setOneofIndex(field.getOneofIndex());
        }
        if (field.getPacked()) {
            this.setPacked(field.getPacked());
        }
        if (this.optionsBuilder_ == null) {
            if (!field.options_.isEmpty()) {
                if (this.options_.isEmpty()) {
                    this.options_ = field.options_;
                    this.bitField0_ &= 0xFFFFFF7F;
                }
                else {
                    this.ensureOptionsIsMutable();
                    this.options_.addAll(field.options_);
                }
                this.onChanged();
            }
        }
        else if (!field.options_.isEmpty()) {
            if (this.optionsBuilder_.isEmpty()) {
                this.optionsBuilder_.dispose();
                this.optionsBuilder_ = null;
                this.options_ = field.options_;
                this.bitField0_ &= 0xFFFFFF7F;
                this.optionsBuilder_ = (GeneratedMessage.alwaysUseFieldBuilders ? this.getOptionsFieldBuilder() : null);
            }
            else {
                this.optionsBuilder_.addAllMessages(field.options_);
            }
        }
        this.onChanged();
        return this;
    }
    
    public final boolean isInitialized() {
        return true;
    }
    
    public Field$Builder mergeFrom(final CodedInputStream codedInputStream, final ExtensionRegistryLite extensionRegistryLite) {
        Field field = null;
        try {
            field = (Field)Field.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
        }
        catch (InvalidProtocolBufferException ex) {
            field = (Field)ex.getUnfinishedMessage();
            throw ex;
        }
        finally {
            if (field != null) {
                this.mergeFrom(field);
            }
        }
        return this;
    }
    
    public int getKindValue() {
        return this.kind_;
    }
    
    public Field$Builder setKindValue(final int kind_) {
        this.kind_ = kind_;
        this.onChanged();
        return this;
    }
    
    public Field$Kind getKind() {
        final Field$Kind value = Field$Kind.valueOf(this.kind_);
        return (value == null) ? Field$Kind.UNRECOGNIZED : value;
    }
    
    public Field$Builder setKind(final Field$Kind field$Kind) {
        if (field$Kind == null) {
            throw new NullPointerException();
        }
        this.kind_ = field$Kind.getNumber();
        this.onChanged();
        return this;
    }
    
    public Field$Builder clearKind() {
        this.kind_ = 0;
        this.onChanged();
        return this;
    }
    
    public int getCardinalityValue() {
        return this.cardinality_;
    }
    
    public Field$Builder setCardinalityValue(final int cardinality_) {
        this.cardinality_ = cardinality_;
        this.onChanged();
        return this;
    }
    
    public Field$Cardinality getCardinality() {
        final Field$Cardinality value = Field$Cardinality.valueOf(this.cardinality_);
        return (value == null) ? Field$Cardinality.UNRECOGNIZED : value;
    }
    
    public Field$Builder setCardinality(final Field$Cardinality field$Cardinality) {
        if (field$Cardinality == null) {
            throw new NullPointerException();
        }
        this.cardinality_ = field$Cardinality.getNumber();
        this.onChanged();
        return this;
    }
    
    public Field$Builder clearCardinality() {
        this.cardinality_ = 0;
        this.onChanged();
        return this;
    }
    
    public int getNumber() {
        return this.number_;
    }
    
    public Field$Builder setNumber(final int number_) {
        this.number_ = number_;
        this.onChanged();
        return this;
    }
    
    public Field$Builder clearNumber() {
        this.number_ = 0;
        this.onChanged();
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
    
    public Field$Builder setName(final String name_) {
        if (name_ == null) {
            throw new NullPointerException();
        }
        this.name_ = name_;
        this.onChanged();
        return this;
    }
    
    public Field$Builder clearName() {
        this.name_ = Field.getDefaultInstance().getName();
        this.onChanged();
        return this;
    }
    
    public Field$Builder setNameBytes(final ByteString name_) {
        if (name_ == null) {
            throw new NullPointerException();
        }
        this.name_ = name_;
        this.onChanged();
        return this;
    }
    
    public String getTypeUrl() {
        final Object typeUrl_ = this.typeUrl_;
        if (!(typeUrl_ instanceof String)) {
            final ByteString byteString = (ByteString)typeUrl_;
            final String stringUtf8 = byteString.toStringUtf8();
            if (byteString.isValidUtf8()) {
                this.typeUrl_ = stringUtf8;
            }
            return stringUtf8;
        }
        return (String)typeUrl_;
    }
    
    public ByteString getTypeUrlBytes() {
        final Object typeUrl_ = this.typeUrl_;
        if (typeUrl_ instanceof String) {
            return (ByteString)(this.typeUrl_ = ByteString.copyFromUtf8((String)typeUrl_));
        }
        return (ByteString)typeUrl_;
    }
    
    public Field$Builder setTypeUrl(final String typeUrl_) {
        if (typeUrl_ == null) {
            throw new NullPointerException();
        }
        this.typeUrl_ = typeUrl_;
        this.onChanged();
        return this;
    }
    
    public Field$Builder clearTypeUrl() {
        this.typeUrl_ = Field.getDefaultInstance().getTypeUrl();
        this.onChanged();
        return this;
    }
    
    public Field$Builder setTypeUrlBytes(final ByteString typeUrl_) {
        if (typeUrl_ == null) {
            throw new NullPointerException();
        }
        this.typeUrl_ = typeUrl_;
        this.onChanged();
        return this;
    }
    
    public int getOneofIndex() {
        return this.oneofIndex_;
    }
    
    public Field$Builder setOneofIndex(final int oneofIndex_) {
        this.oneofIndex_ = oneofIndex_;
        this.onChanged();
        return this;
    }
    
    public Field$Builder clearOneofIndex() {
        this.oneofIndex_ = 0;
        this.onChanged();
        return this;
    }
    
    public boolean getPacked() {
        return this.packed_;
    }
    
    public Field$Builder setPacked(final boolean packed_) {
        this.packed_ = packed_;
        this.onChanged();
        return this;
    }
    
    public Field$Builder clearPacked() {
        this.packed_ = false;
        this.onChanged();
        return this;
    }
    
    private void ensureOptionsIsMutable() {
        if ((this.bitField0_ & 0x80) != 0x80) {
            this.options_ = new ArrayList(this.options_);
            this.bitField0_ |= 0x80;
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
    
    public Field$Builder setOptions(final int n, final Option option) {
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
    
    public Field$Builder setOptions(final int n, final Option$Builder option$Builder) {
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
    
    public Field$Builder addOptions(final Option option) {
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
    
    public Field$Builder addOptions(final int n, final Option option) {
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
    
    public Field$Builder addOptions(final Option$Builder option$Builder) {
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
    
    public Field$Builder addOptions(final int n, final Option$Builder option$Builder) {
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
    
    public Field$Builder addAllOptions(final Iterable iterable) {
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
    
    public Field$Builder clearOptions() {
        if (this.optionsBuilder_ == null) {
            this.options_ = Collections.emptyList();
            this.bitField0_ &= 0xFFFFFF7F;
            this.onChanged();
        }
        else {
            this.optionsBuilder_.clear();
        }
        return this;
    }
    
    public Field$Builder removeOptions(final int n) {
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
            this.optionsBuilder_ = new RepeatedFieldBuilder(this.options_, (this.bitField0_ & 0x80) == 0x80, this.getParentForChildren(), this.isClean());
            this.options_ = null;
        }
        return this.optionsBuilder_;
    }
    
    public final Field$Builder setUnknownFields(final UnknownFieldSet set) {
        return this;
    }
    
    public final Field$Builder mergeUnknownFields(final UnknownFieldSet set) {
        return this;
    }
}
