package com.google.protobuf;

import java.util.*;
import java.io.*;

public final class DescriptorProtos$DescriptorProto$Builder extends GeneratedMessage$Builder implements DescriptorProtos$DescriptorProtoOrBuilder
{
    private int bitField0_;
    private Object name_;
    private List field_;
    private RepeatedFieldBuilder fieldBuilder_;
    private List extension_;
    private RepeatedFieldBuilder extensionBuilder_;
    private List nestedType_;
    private RepeatedFieldBuilder nestedTypeBuilder_;
    private List enumType_;
    private RepeatedFieldBuilder enumTypeBuilder_;
    private List extensionRange_;
    private RepeatedFieldBuilder extensionRangeBuilder_;
    private List oneofDecl_;
    private RepeatedFieldBuilder oneofDeclBuilder_;
    private DescriptorProtos$MessageOptions options_;
    private SingleFieldBuilder optionsBuilder_;
    private List reservedRange_;
    private RepeatedFieldBuilder reservedRangeBuilder_;
    private LazyStringList reservedName_;
    
    public static final Descriptors$Descriptor getDescriptor() {
        return DescriptorProtos.internal_static_google_protobuf_DescriptorProto_descriptor;
    }
    
    protected GeneratedMessage$FieldAccessorTable internalGetFieldAccessorTable() {
        return DescriptorProtos.internal_static_google_protobuf_DescriptorProto_fieldAccessorTable.ensureFieldAccessorsInitialized(DescriptorProtos$DescriptorProto.class, DescriptorProtos$DescriptorProto$Builder.class);
    }
    
    private DescriptorProtos$DescriptorProto$Builder() {
        this.name_ = "";
        this.field_ = Collections.emptyList();
        this.extension_ = Collections.emptyList();
        this.nestedType_ = Collections.emptyList();
        this.enumType_ = Collections.emptyList();
        this.extensionRange_ = Collections.emptyList();
        this.oneofDecl_ = Collections.emptyList();
        this.options_ = null;
        this.reservedRange_ = Collections.emptyList();
        this.reservedName_ = LazyStringArrayList.EMPTY;
        this.maybeForceBuilderInitialization();
    }
    
    private DescriptorProtos$DescriptorProto$Builder(final GeneratedMessage$BuilderParent generatedMessage$BuilderParent) {
        super(generatedMessage$BuilderParent);
        this.name_ = "";
        this.field_ = Collections.emptyList();
        this.extension_ = Collections.emptyList();
        this.nestedType_ = Collections.emptyList();
        this.enumType_ = Collections.emptyList();
        this.extensionRange_ = Collections.emptyList();
        this.oneofDecl_ = Collections.emptyList();
        this.options_ = null;
        this.reservedRange_ = Collections.emptyList();
        this.reservedName_ = LazyStringArrayList.EMPTY;
        this.maybeForceBuilderInitialization();
    }
    
    private void maybeForceBuilderInitialization() {
        if (GeneratedMessage.alwaysUseFieldBuilders) {
            this.getFieldFieldBuilder();
            this.getExtensionFieldBuilder();
            this.getNestedTypeFieldBuilder();
            this.getEnumTypeFieldBuilder();
            this.getExtensionRangeFieldBuilder();
            this.getOneofDeclFieldBuilder();
            this.getOptionsFieldBuilder();
            this.getReservedRangeFieldBuilder();
        }
    }
    
    public DescriptorProtos$DescriptorProto$Builder clear() {
        super.clear();
        this.name_ = "";
        this.bitField0_ &= 0xFFFFFFFE;
        if (this.fieldBuilder_ == null) {
            this.field_ = Collections.emptyList();
            this.bitField0_ &= 0xFFFFFFFD;
        }
        else {
            this.fieldBuilder_.clear();
        }
        if (this.extensionBuilder_ == null) {
            this.extension_ = Collections.emptyList();
            this.bitField0_ &= 0xFFFFFFFB;
        }
        else {
            this.extensionBuilder_.clear();
        }
        if (this.nestedTypeBuilder_ == null) {
            this.nestedType_ = Collections.emptyList();
            this.bitField0_ &= 0xFFFFFFF7;
        }
        else {
            this.nestedTypeBuilder_.clear();
        }
        if (this.enumTypeBuilder_ == null) {
            this.enumType_ = Collections.emptyList();
            this.bitField0_ &= 0xFFFFFFEF;
        }
        else {
            this.enumTypeBuilder_.clear();
        }
        if (this.extensionRangeBuilder_ == null) {
            this.extensionRange_ = Collections.emptyList();
            this.bitField0_ &= 0xFFFFFFDF;
        }
        else {
            this.extensionRangeBuilder_.clear();
        }
        if (this.oneofDeclBuilder_ == null) {
            this.oneofDecl_ = Collections.emptyList();
            this.bitField0_ &= 0xFFFFFFBF;
        }
        else {
            this.oneofDeclBuilder_.clear();
        }
        if (this.optionsBuilder_ == null) {
            this.options_ = null;
        }
        else {
            this.optionsBuilder_.clear();
        }
        this.bitField0_ &= 0xFFFFFF7F;
        if (this.reservedRangeBuilder_ == null) {
            this.reservedRange_ = Collections.emptyList();
            this.bitField0_ &= 0xFFFFFEFF;
        }
        else {
            this.reservedRangeBuilder_.clear();
        }
        this.reservedName_ = LazyStringArrayList.EMPTY;
        this.bitField0_ &= 0xFFFFFDFF;
        return this;
    }
    
    public Descriptors$Descriptor getDescriptorForType() {
        return DescriptorProtos.internal_static_google_protobuf_DescriptorProto_descriptor;
    }
    
    public DescriptorProtos$DescriptorProto getDefaultInstanceForType() {
        return DescriptorProtos$DescriptorProto.getDefaultInstance();
    }
    
    public DescriptorProtos$DescriptorProto build() {
        final DescriptorProtos$DescriptorProto buildPartial = this.buildPartial();
        if (!buildPartial.isInitialized()) {
            throw AbstractMessage$Builder.newUninitializedMessageException(buildPartial);
        }
        return buildPartial;
    }
    
    public DescriptorProtos$DescriptorProto buildPartial() {
        final DescriptorProtos$DescriptorProto descriptorProtos$DescriptorProto = new DescriptorProtos$DescriptorProto(this, null);
        final int bitField0_ = this.bitField0_;
        int n = 0;
        if ((bitField0_ & 0x1) == 0x1) {
            n |= 0x1;
        }
        descriptorProtos$DescriptorProto.name_ = this.name_;
        if (this.fieldBuilder_ == null) {
            if ((this.bitField0_ & 0x2) == 0x2) {
                this.field_ = Collections.unmodifiableList((List<?>)this.field_);
                this.bitField0_ &= 0xFFFFFFFD;
            }
            descriptorProtos$DescriptorProto.field_ = this.field_;
        }
        else {
            descriptorProtos$DescriptorProto.field_ = this.fieldBuilder_.build();
        }
        if (this.extensionBuilder_ == null) {
            if ((this.bitField0_ & 0x4) == 0x4) {
                this.extension_ = Collections.unmodifiableList((List<?>)this.extension_);
                this.bitField0_ &= 0xFFFFFFFB;
            }
            descriptorProtos$DescriptorProto.extension_ = this.extension_;
        }
        else {
            descriptorProtos$DescriptorProto.extension_ = this.extensionBuilder_.build();
        }
        if (this.nestedTypeBuilder_ == null) {
            if ((this.bitField0_ & 0x8) == 0x8) {
                this.nestedType_ = Collections.unmodifiableList((List<?>)this.nestedType_);
                this.bitField0_ &= 0xFFFFFFF7;
            }
            descriptorProtos$DescriptorProto.nestedType_ = this.nestedType_;
        }
        else {
            descriptorProtos$DescriptorProto.nestedType_ = this.nestedTypeBuilder_.build();
        }
        if (this.enumTypeBuilder_ == null) {
            if ((this.bitField0_ & 0x10) == 0x10) {
                this.enumType_ = Collections.unmodifiableList((List<?>)this.enumType_);
                this.bitField0_ &= 0xFFFFFFEF;
            }
            descriptorProtos$DescriptorProto.enumType_ = this.enumType_;
        }
        else {
            descriptorProtos$DescriptorProto.enumType_ = this.enumTypeBuilder_.build();
        }
        if (this.extensionRangeBuilder_ == null) {
            if ((this.bitField0_ & 0x20) == 0x20) {
                this.extensionRange_ = Collections.unmodifiableList((List<?>)this.extensionRange_);
                this.bitField0_ &= 0xFFFFFFDF;
            }
            descriptorProtos$DescriptorProto.extensionRange_ = this.extensionRange_;
        }
        else {
            descriptorProtos$DescriptorProto.extensionRange_ = this.extensionRangeBuilder_.build();
        }
        if (this.oneofDeclBuilder_ == null) {
            if ((this.bitField0_ & 0x40) == 0x40) {
                this.oneofDecl_ = Collections.unmodifiableList((List<?>)this.oneofDecl_);
                this.bitField0_ &= 0xFFFFFFBF;
            }
            descriptorProtos$DescriptorProto.oneofDecl_ = this.oneofDecl_;
        }
        else {
            descriptorProtos$DescriptorProto.oneofDecl_ = this.oneofDeclBuilder_.build();
        }
        if ((bitField0_ & 0x80) == 0x80) {
            n |= 0x2;
        }
        if (this.optionsBuilder_ == null) {
            descriptorProtos$DescriptorProto.options_ = this.options_;
        }
        else {
            descriptorProtos$DescriptorProto.options_ = (DescriptorProtos$MessageOptions)this.optionsBuilder_.build();
        }
        if (this.reservedRangeBuilder_ == null) {
            if ((this.bitField0_ & 0x100) == 0x100) {
                this.reservedRange_ = Collections.unmodifiableList((List<?>)this.reservedRange_);
                this.bitField0_ &= 0xFFFFFEFF;
            }
            descriptorProtos$DescriptorProto.reservedRange_ = this.reservedRange_;
        }
        else {
            descriptorProtos$DescriptorProto.reservedRange_ = this.reservedRangeBuilder_.build();
        }
        if ((this.bitField0_ & 0x200) == 0x200) {
            this.reservedName_ = this.reservedName_.getUnmodifiableView();
            this.bitField0_ &= 0xFFFFFDFF;
        }
        descriptorProtos$DescriptorProto.reservedName_ = this.reservedName_;
        descriptorProtos$DescriptorProto.bitField0_ = n;
        this.onBuilt();
        return descriptorProtos$DescriptorProto;
    }
    
    public DescriptorProtos$DescriptorProto$Builder mergeFrom(final Message message) {
        if (message instanceof DescriptorProtos$DescriptorProto) {
            return this.mergeFrom((DescriptorProtos$DescriptorProto)message);
        }
        super.mergeFrom(message);
        return this;
    }
    
    public DescriptorProtos$DescriptorProto$Builder mergeFrom(final DescriptorProtos$DescriptorProto descriptorProtos$DescriptorProto) {
        if (descriptorProtos$DescriptorProto == DescriptorProtos$DescriptorProto.getDefaultInstance()) {
            return this;
        }
        if (descriptorProtos$DescriptorProto.hasName()) {
            this.bitField0_ |= 0x1;
            this.name_ = descriptorProtos$DescriptorProto.name_;
            this.onChanged();
        }
        if (this.fieldBuilder_ == null) {
            if (!descriptorProtos$DescriptorProto.field_.isEmpty()) {
                if (this.field_.isEmpty()) {
                    this.field_ = descriptorProtos$DescriptorProto.field_;
                    this.bitField0_ &= 0xFFFFFFFD;
                }
                else {
                    this.ensureFieldIsMutable();
                    this.field_.addAll(descriptorProtos$DescriptorProto.field_);
                }
                this.onChanged();
            }
        }
        else if (!descriptorProtos$DescriptorProto.field_.isEmpty()) {
            if (this.fieldBuilder_.isEmpty()) {
                this.fieldBuilder_.dispose();
                this.fieldBuilder_ = null;
                this.field_ = descriptorProtos$DescriptorProto.field_;
                this.bitField0_ &= 0xFFFFFFFD;
                this.fieldBuilder_ = (GeneratedMessage.alwaysUseFieldBuilders ? this.getFieldFieldBuilder() : null);
            }
            else {
                this.fieldBuilder_.addAllMessages(descriptorProtos$DescriptorProto.field_);
            }
        }
        if (this.extensionBuilder_ == null) {
            if (!descriptorProtos$DescriptorProto.extension_.isEmpty()) {
                if (this.extension_.isEmpty()) {
                    this.extension_ = descriptorProtos$DescriptorProto.extension_;
                    this.bitField0_ &= 0xFFFFFFFB;
                }
                else {
                    this.ensureExtensionIsMutable();
                    this.extension_.addAll(descriptorProtos$DescriptorProto.extension_);
                }
                this.onChanged();
            }
        }
        else if (!descriptorProtos$DescriptorProto.extension_.isEmpty()) {
            if (this.extensionBuilder_.isEmpty()) {
                this.extensionBuilder_.dispose();
                this.extensionBuilder_ = null;
                this.extension_ = descriptorProtos$DescriptorProto.extension_;
                this.bitField0_ &= 0xFFFFFFFB;
                this.extensionBuilder_ = (GeneratedMessage.alwaysUseFieldBuilders ? this.getExtensionFieldBuilder() : null);
            }
            else {
                this.extensionBuilder_.addAllMessages(descriptorProtos$DescriptorProto.extension_);
            }
        }
        if (this.nestedTypeBuilder_ == null) {
            if (!descriptorProtos$DescriptorProto.nestedType_.isEmpty()) {
                if (this.nestedType_.isEmpty()) {
                    this.nestedType_ = descriptorProtos$DescriptorProto.nestedType_;
                    this.bitField0_ &= 0xFFFFFFF7;
                }
                else {
                    this.ensureNestedTypeIsMutable();
                    this.nestedType_.addAll(descriptorProtos$DescriptorProto.nestedType_);
                }
                this.onChanged();
            }
        }
        else if (!descriptorProtos$DescriptorProto.nestedType_.isEmpty()) {
            if (this.nestedTypeBuilder_.isEmpty()) {
                this.nestedTypeBuilder_.dispose();
                this.nestedTypeBuilder_ = null;
                this.nestedType_ = descriptorProtos$DescriptorProto.nestedType_;
                this.bitField0_ &= 0xFFFFFFF7;
                this.nestedTypeBuilder_ = (GeneratedMessage.alwaysUseFieldBuilders ? this.getNestedTypeFieldBuilder() : null);
            }
            else {
                this.nestedTypeBuilder_.addAllMessages(descriptorProtos$DescriptorProto.nestedType_);
            }
        }
        if (this.enumTypeBuilder_ == null) {
            if (!descriptorProtos$DescriptorProto.enumType_.isEmpty()) {
                if (this.enumType_.isEmpty()) {
                    this.enumType_ = descriptorProtos$DescriptorProto.enumType_;
                    this.bitField0_ &= 0xFFFFFFEF;
                }
                else {
                    this.ensureEnumTypeIsMutable();
                    this.enumType_.addAll(descriptorProtos$DescriptorProto.enumType_);
                }
                this.onChanged();
            }
        }
        else if (!descriptorProtos$DescriptorProto.enumType_.isEmpty()) {
            if (this.enumTypeBuilder_.isEmpty()) {
                this.enumTypeBuilder_.dispose();
                this.enumTypeBuilder_ = null;
                this.enumType_ = descriptorProtos$DescriptorProto.enumType_;
                this.bitField0_ &= 0xFFFFFFEF;
                this.enumTypeBuilder_ = (GeneratedMessage.alwaysUseFieldBuilders ? this.getEnumTypeFieldBuilder() : null);
            }
            else {
                this.enumTypeBuilder_.addAllMessages(descriptorProtos$DescriptorProto.enumType_);
            }
        }
        if (this.extensionRangeBuilder_ == null) {
            if (!descriptorProtos$DescriptorProto.extensionRange_.isEmpty()) {
                if (this.extensionRange_.isEmpty()) {
                    this.extensionRange_ = descriptorProtos$DescriptorProto.extensionRange_;
                    this.bitField0_ &= 0xFFFFFFDF;
                }
                else {
                    this.ensureExtensionRangeIsMutable();
                    this.extensionRange_.addAll(descriptorProtos$DescriptorProto.extensionRange_);
                }
                this.onChanged();
            }
        }
        else if (!descriptorProtos$DescriptorProto.extensionRange_.isEmpty()) {
            if (this.extensionRangeBuilder_.isEmpty()) {
                this.extensionRangeBuilder_.dispose();
                this.extensionRangeBuilder_ = null;
                this.extensionRange_ = descriptorProtos$DescriptorProto.extensionRange_;
                this.bitField0_ &= 0xFFFFFFDF;
                this.extensionRangeBuilder_ = (GeneratedMessage.alwaysUseFieldBuilders ? this.getExtensionRangeFieldBuilder() : null);
            }
            else {
                this.extensionRangeBuilder_.addAllMessages(descriptorProtos$DescriptorProto.extensionRange_);
            }
        }
        if (this.oneofDeclBuilder_ == null) {
            if (!descriptorProtos$DescriptorProto.oneofDecl_.isEmpty()) {
                if (this.oneofDecl_.isEmpty()) {
                    this.oneofDecl_ = descriptorProtos$DescriptorProto.oneofDecl_;
                    this.bitField0_ &= 0xFFFFFFBF;
                }
                else {
                    this.ensureOneofDeclIsMutable();
                    this.oneofDecl_.addAll(descriptorProtos$DescriptorProto.oneofDecl_);
                }
                this.onChanged();
            }
        }
        else if (!descriptorProtos$DescriptorProto.oneofDecl_.isEmpty()) {
            if (this.oneofDeclBuilder_.isEmpty()) {
                this.oneofDeclBuilder_.dispose();
                this.oneofDeclBuilder_ = null;
                this.oneofDecl_ = descriptorProtos$DescriptorProto.oneofDecl_;
                this.bitField0_ &= 0xFFFFFFBF;
                this.oneofDeclBuilder_ = (GeneratedMessage.alwaysUseFieldBuilders ? this.getOneofDeclFieldBuilder() : null);
            }
            else {
                this.oneofDeclBuilder_.addAllMessages(descriptorProtos$DescriptorProto.oneofDecl_);
            }
        }
        if (descriptorProtos$DescriptorProto.hasOptions()) {
            this.mergeOptions(descriptorProtos$DescriptorProto.getOptions());
        }
        if (this.reservedRangeBuilder_ == null) {
            if (!descriptorProtos$DescriptorProto.reservedRange_.isEmpty()) {
                if (this.reservedRange_.isEmpty()) {
                    this.reservedRange_ = descriptorProtos$DescriptorProto.reservedRange_;
                    this.bitField0_ &= 0xFFFFFEFF;
                }
                else {
                    this.ensureReservedRangeIsMutable();
                    this.reservedRange_.addAll(descriptorProtos$DescriptorProto.reservedRange_);
                }
                this.onChanged();
            }
        }
        else if (!descriptorProtos$DescriptorProto.reservedRange_.isEmpty()) {
            if (this.reservedRangeBuilder_.isEmpty()) {
                this.reservedRangeBuilder_.dispose();
                this.reservedRangeBuilder_ = null;
                this.reservedRange_ = descriptorProtos$DescriptorProto.reservedRange_;
                this.bitField0_ &= 0xFFFFFEFF;
                this.reservedRangeBuilder_ = (GeneratedMessage.alwaysUseFieldBuilders ? this.getReservedRangeFieldBuilder() : null);
            }
            else {
                this.reservedRangeBuilder_.addAllMessages(descriptorProtos$DescriptorProto.reservedRange_);
            }
        }
        if (!descriptorProtos$DescriptorProto.reservedName_.isEmpty()) {
            if (this.reservedName_.isEmpty()) {
                this.reservedName_ = descriptorProtos$DescriptorProto.reservedName_;
                this.bitField0_ &= 0xFFFFFDFF;
            }
            else {
                this.ensureReservedNameIsMutable();
                this.reservedName_.addAll(descriptorProtos$DescriptorProto.reservedName_);
            }
            this.onChanged();
        }
        this.mergeUnknownFields(descriptorProtos$DescriptorProto.unknownFields);
        this.onChanged();
        return this;
    }
    
    public final boolean isInitialized() {
        for (int i = 0; i < this.getFieldCount(); ++i) {
            if (!this.getField(i).isInitialized()) {
                return false;
            }
        }
        for (int j = 0; j < this.getExtensionCount(); ++j) {
            if (!this.getExtension(j).isInitialized()) {
                return false;
            }
        }
        for (int k = 0; k < this.getNestedTypeCount(); ++k) {
            if (!this.getNestedType(k).isInitialized()) {
                return false;
            }
        }
        for (int l = 0; l < this.getEnumTypeCount(); ++l) {
            if (!this.getEnumType(l).isInitialized()) {
                return false;
            }
        }
        return !this.hasOptions() || this.getOptions().isInitialized();
    }
    
    public DescriptorProtos$DescriptorProto$Builder mergeFrom(final CodedInputStream codedInputStream, final ExtensionRegistryLite extensionRegistryLite) {
        DescriptorProtos$DescriptorProto descriptorProtos$DescriptorProto = null;
        try {
            descriptorProtos$DescriptorProto = (DescriptorProtos$DescriptorProto)DescriptorProtos$DescriptorProto.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
        }
        catch (InvalidProtocolBufferException ex) {
            descriptorProtos$DescriptorProto = (DescriptorProtos$DescriptorProto)ex.getUnfinishedMessage();
            throw ex;
        }
        finally {
            if (descriptorProtos$DescriptorProto != null) {
                this.mergeFrom(descriptorProtos$DescriptorProto);
            }
        }
        return this;
    }
    
    public boolean hasName() {
        return (this.bitField0_ & 0x1) == 0x1;
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
    
    public DescriptorProtos$DescriptorProto$Builder setName(final String name_) {
        if (name_ == null) {
            throw new NullPointerException();
        }
        this.bitField0_ |= 0x1;
        this.name_ = name_;
        this.onChanged();
        return this;
    }
    
    public DescriptorProtos$DescriptorProto$Builder clearName() {
        this.bitField0_ &= 0xFFFFFFFE;
        this.name_ = DescriptorProtos$DescriptorProto.getDefaultInstance().getName();
        this.onChanged();
        return this;
    }
    
    public DescriptorProtos$DescriptorProto$Builder setNameBytes(final ByteString name_) {
        if (name_ == null) {
            throw new NullPointerException();
        }
        this.bitField0_ |= 0x1;
        this.name_ = name_;
        this.onChanged();
        return this;
    }
    
    private void ensureFieldIsMutable() {
        if ((this.bitField0_ & 0x2) != 0x2) {
            this.field_ = new ArrayList(this.field_);
            this.bitField0_ |= 0x2;
        }
    }
    
    public List getFieldList() {
        if (this.fieldBuilder_ == null) {
            return Collections.unmodifiableList((List<?>)this.field_);
        }
        return this.fieldBuilder_.getMessageList();
    }
    
    public int getFieldCount() {
        if (this.fieldBuilder_ == null) {
            return this.field_.size();
        }
        return this.fieldBuilder_.getCount();
    }
    
    public DescriptorProtos$FieldDescriptorProto getField(final int n) {
        if (this.fieldBuilder_ == null) {
            return this.field_.get(n);
        }
        return (DescriptorProtos$FieldDescriptorProto)this.fieldBuilder_.getMessage(n);
    }
    
    public DescriptorProtos$DescriptorProto$Builder setField(final int n, final DescriptorProtos$FieldDescriptorProto descriptorProtos$FieldDescriptorProto) {
        if (this.fieldBuilder_ == null) {
            if (descriptorProtos$FieldDescriptorProto == null) {
                throw new NullPointerException();
            }
            this.ensureFieldIsMutable();
            this.field_.set(n, descriptorProtos$FieldDescriptorProto);
            this.onChanged();
        }
        else {
            this.fieldBuilder_.setMessage(n, descriptorProtos$FieldDescriptorProto);
        }
        return this;
    }
    
    public DescriptorProtos$DescriptorProto$Builder setField(final int n, final DescriptorProtos$FieldDescriptorProto$Builder descriptorProtos$FieldDescriptorProto$Builder) {
        if (this.fieldBuilder_ == null) {
            this.ensureFieldIsMutable();
            this.field_.set(n, descriptorProtos$FieldDescriptorProto$Builder.build());
            this.onChanged();
        }
        else {
            this.fieldBuilder_.setMessage(n, descriptorProtos$FieldDescriptorProto$Builder.build());
        }
        return this;
    }
    
    public DescriptorProtos$DescriptorProto$Builder addField(final DescriptorProtos$FieldDescriptorProto descriptorProtos$FieldDescriptorProto) {
        if (this.fieldBuilder_ == null) {
            if (descriptorProtos$FieldDescriptorProto == null) {
                throw new NullPointerException();
            }
            this.ensureFieldIsMutable();
            this.field_.add(descriptorProtos$FieldDescriptorProto);
            this.onChanged();
        }
        else {
            this.fieldBuilder_.addMessage(descriptorProtos$FieldDescriptorProto);
        }
        return this;
    }
    
    public DescriptorProtos$DescriptorProto$Builder addField(final int n, final DescriptorProtos$FieldDescriptorProto descriptorProtos$FieldDescriptorProto) {
        if (this.fieldBuilder_ == null) {
            if (descriptorProtos$FieldDescriptorProto == null) {
                throw new NullPointerException();
            }
            this.ensureFieldIsMutable();
            this.field_.add(n, descriptorProtos$FieldDescriptorProto);
            this.onChanged();
        }
        else {
            this.fieldBuilder_.addMessage(n, descriptorProtos$FieldDescriptorProto);
        }
        return this;
    }
    
    public DescriptorProtos$DescriptorProto$Builder addField(final DescriptorProtos$FieldDescriptorProto$Builder descriptorProtos$FieldDescriptorProto$Builder) {
        if (this.fieldBuilder_ == null) {
            this.ensureFieldIsMutable();
            this.field_.add(descriptorProtos$FieldDescriptorProto$Builder.build());
            this.onChanged();
        }
        else {
            this.fieldBuilder_.addMessage(descriptorProtos$FieldDescriptorProto$Builder.build());
        }
        return this;
    }
    
    public DescriptorProtos$DescriptorProto$Builder addField(final int n, final DescriptorProtos$FieldDescriptorProto$Builder descriptorProtos$FieldDescriptorProto$Builder) {
        if (this.fieldBuilder_ == null) {
            this.ensureFieldIsMutable();
            this.field_.add(n, descriptorProtos$FieldDescriptorProto$Builder.build());
            this.onChanged();
        }
        else {
            this.fieldBuilder_.addMessage(n, descriptorProtos$FieldDescriptorProto$Builder.build());
        }
        return this;
    }
    
    public DescriptorProtos$DescriptorProto$Builder addAllField(final Iterable iterable) {
        if (this.fieldBuilder_ == null) {
            this.ensureFieldIsMutable();
            AbstractMessageLite$Builder.addAll(iterable, this.field_);
            this.onChanged();
        }
        else {
            this.fieldBuilder_.addAllMessages(iterable);
        }
        return this;
    }
    
    public DescriptorProtos$DescriptorProto$Builder clearField() {
        if (this.fieldBuilder_ == null) {
            this.field_ = Collections.emptyList();
            this.bitField0_ &= 0xFFFFFFFD;
            this.onChanged();
        }
        else {
            this.fieldBuilder_.clear();
        }
        return this;
    }
    
    public DescriptorProtos$DescriptorProto$Builder removeField(final int n) {
        if (this.fieldBuilder_ == null) {
            this.ensureFieldIsMutable();
            this.field_.remove(n);
            this.onChanged();
        }
        else {
            this.fieldBuilder_.remove(n);
        }
        return this;
    }
    
    public DescriptorProtos$FieldDescriptorProto$Builder getFieldBuilder(final int n) {
        return (DescriptorProtos$FieldDescriptorProto$Builder)this.getFieldFieldBuilder().getBuilder(n);
    }
    
    public DescriptorProtos$FieldDescriptorProtoOrBuilder getFieldOrBuilder(final int n) {
        if (this.fieldBuilder_ == null) {
            return this.field_.get(n);
        }
        return (DescriptorProtos$FieldDescriptorProtoOrBuilder)this.fieldBuilder_.getMessageOrBuilder(n);
    }
    
    public List getFieldOrBuilderList() {
        if (this.fieldBuilder_ != null) {
            return this.fieldBuilder_.getMessageOrBuilderList();
        }
        return Collections.unmodifiableList((List<?>)this.field_);
    }
    
    public DescriptorProtos$FieldDescriptorProto$Builder addFieldBuilder() {
        return (DescriptorProtos$FieldDescriptorProto$Builder)this.getFieldFieldBuilder().addBuilder(DescriptorProtos$FieldDescriptorProto.getDefaultInstance());
    }
    
    public DescriptorProtos$FieldDescriptorProto$Builder addFieldBuilder(final int n) {
        return (DescriptorProtos$FieldDescriptorProto$Builder)this.getFieldFieldBuilder().addBuilder(n, DescriptorProtos$FieldDescriptorProto.getDefaultInstance());
    }
    
    public List getFieldBuilderList() {
        return this.getFieldFieldBuilder().getBuilderList();
    }
    
    private RepeatedFieldBuilder getFieldFieldBuilder() {
        if (this.fieldBuilder_ == null) {
            this.fieldBuilder_ = new RepeatedFieldBuilder(this.field_, (this.bitField0_ & 0x2) == 0x2, this.getParentForChildren(), this.isClean());
            this.field_ = null;
        }
        return this.fieldBuilder_;
    }
    
    private void ensureExtensionIsMutable() {
        if ((this.bitField0_ & 0x4) != 0x4) {
            this.extension_ = new ArrayList(this.extension_);
            this.bitField0_ |= 0x4;
        }
    }
    
    public List getExtensionList() {
        if (this.extensionBuilder_ == null) {
            return Collections.unmodifiableList((List<?>)this.extension_);
        }
        return this.extensionBuilder_.getMessageList();
    }
    
    public int getExtensionCount() {
        if (this.extensionBuilder_ == null) {
            return this.extension_.size();
        }
        return this.extensionBuilder_.getCount();
    }
    
    public DescriptorProtos$FieldDescriptorProto getExtension(final int n) {
        if (this.extensionBuilder_ == null) {
            return this.extension_.get(n);
        }
        return (DescriptorProtos$FieldDescriptorProto)this.extensionBuilder_.getMessage(n);
    }
    
    public DescriptorProtos$DescriptorProto$Builder setExtension(final int n, final DescriptorProtos$FieldDescriptorProto descriptorProtos$FieldDescriptorProto) {
        if (this.extensionBuilder_ == null) {
            if (descriptorProtos$FieldDescriptorProto == null) {
                throw new NullPointerException();
            }
            this.ensureExtensionIsMutable();
            this.extension_.set(n, descriptorProtos$FieldDescriptorProto);
            this.onChanged();
        }
        else {
            this.extensionBuilder_.setMessage(n, descriptorProtos$FieldDescriptorProto);
        }
        return this;
    }
    
    public DescriptorProtos$DescriptorProto$Builder setExtension(final int n, final DescriptorProtos$FieldDescriptorProto$Builder descriptorProtos$FieldDescriptorProto$Builder) {
        if (this.extensionBuilder_ == null) {
            this.ensureExtensionIsMutable();
            this.extension_.set(n, descriptorProtos$FieldDescriptorProto$Builder.build());
            this.onChanged();
        }
        else {
            this.extensionBuilder_.setMessage(n, descriptorProtos$FieldDescriptorProto$Builder.build());
        }
        return this;
    }
    
    public DescriptorProtos$DescriptorProto$Builder addExtension(final DescriptorProtos$FieldDescriptorProto descriptorProtos$FieldDescriptorProto) {
        if (this.extensionBuilder_ == null) {
            if (descriptorProtos$FieldDescriptorProto == null) {
                throw new NullPointerException();
            }
            this.ensureExtensionIsMutable();
            this.extension_.add(descriptorProtos$FieldDescriptorProto);
            this.onChanged();
        }
        else {
            this.extensionBuilder_.addMessage(descriptorProtos$FieldDescriptorProto);
        }
        return this;
    }
    
    public DescriptorProtos$DescriptorProto$Builder addExtension(final int n, final DescriptorProtos$FieldDescriptorProto descriptorProtos$FieldDescriptorProto) {
        if (this.extensionBuilder_ == null) {
            if (descriptorProtos$FieldDescriptorProto == null) {
                throw new NullPointerException();
            }
            this.ensureExtensionIsMutable();
            this.extension_.add(n, descriptorProtos$FieldDescriptorProto);
            this.onChanged();
        }
        else {
            this.extensionBuilder_.addMessage(n, descriptorProtos$FieldDescriptorProto);
        }
        return this;
    }
    
    public DescriptorProtos$DescriptorProto$Builder addExtension(final DescriptorProtos$FieldDescriptorProto$Builder descriptorProtos$FieldDescriptorProto$Builder) {
        if (this.extensionBuilder_ == null) {
            this.ensureExtensionIsMutable();
            this.extension_.add(descriptorProtos$FieldDescriptorProto$Builder.build());
            this.onChanged();
        }
        else {
            this.extensionBuilder_.addMessage(descriptorProtos$FieldDescriptorProto$Builder.build());
        }
        return this;
    }
    
    public DescriptorProtos$DescriptorProto$Builder addExtension(final int n, final DescriptorProtos$FieldDescriptorProto$Builder descriptorProtos$FieldDescriptorProto$Builder) {
        if (this.extensionBuilder_ == null) {
            this.ensureExtensionIsMutable();
            this.extension_.add(n, descriptorProtos$FieldDescriptorProto$Builder.build());
            this.onChanged();
        }
        else {
            this.extensionBuilder_.addMessage(n, descriptorProtos$FieldDescriptorProto$Builder.build());
        }
        return this;
    }
    
    public DescriptorProtos$DescriptorProto$Builder addAllExtension(final Iterable iterable) {
        if (this.extensionBuilder_ == null) {
            this.ensureExtensionIsMutable();
            AbstractMessageLite$Builder.addAll(iterable, this.extension_);
            this.onChanged();
        }
        else {
            this.extensionBuilder_.addAllMessages(iterable);
        }
        return this;
    }
    
    public DescriptorProtos$DescriptorProto$Builder clearExtension() {
        if (this.extensionBuilder_ == null) {
            this.extension_ = Collections.emptyList();
            this.bitField0_ &= 0xFFFFFFFB;
            this.onChanged();
        }
        else {
            this.extensionBuilder_.clear();
        }
        return this;
    }
    
    public DescriptorProtos$DescriptorProto$Builder removeExtension(final int n) {
        if (this.extensionBuilder_ == null) {
            this.ensureExtensionIsMutable();
            this.extension_.remove(n);
            this.onChanged();
        }
        else {
            this.extensionBuilder_.remove(n);
        }
        return this;
    }
    
    public DescriptorProtos$FieldDescriptorProto$Builder getExtensionBuilder(final int n) {
        return (DescriptorProtos$FieldDescriptorProto$Builder)this.getExtensionFieldBuilder().getBuilder(n);
    }
    
    public DescriptorProtos$FieldDescriptorProtoOrBuilder getExtensionOrBuilder(final int n) {
        if (this.extensionBuilder_ == null) {
            return this.extension_.get(n);
        }
        return (DescriptorProtos$FieldDescriptorProtoOrBuilder)this.extensionBuilder_.getMessageOrBuilder(n);
    }
    
    public List getExtensionOrBuilderList() {
        if (this.extensionBuilder_ != null) {
            return this.extensionBuilder_.getMessageOrBuilderList();
        }
        return Collections.unmodifiableList((List<?>)this.extension_);
    }
    
    public DescriptorProtos$FieldDescriptorProto$Builder addExtensionBuilder() {
        return (DescriptorProtos$FieldDescriptorProto$Builder)this.getExtensionFieldBuilder().addBuilder(DescriptorProtos$FieldDescriptorProto.getDefaultInstance());
    }
    
    public DescriptorProtos$FieldDescriptorProto$Builder addExtensionBuilder(final int n) {
        return (DescriptorProtos$FieldDescriptorProto$Builder)this.getExtensionFieldBuilder().addBuilder(n, DescriptorProtos$FieldDescriptorProto.getDefaultInstance());
    }
    
    public List getExtensionBuilderList() {
        return this.getExtensionFieldBuilder().getBuilderList();
    }
    
    private RepeatedFieldBuilder getExtensionFieldBuilder() {
        if (this.extensionBuilder_ == null) {
            this.extensionBuilder_ = new RepeatedFieldBuilder(this.extension_, (this.bitField0_ & 0x4) == 0x4, this.getParentForChildren(), this.isClean());
            this.extension_ = null;
        }
        return this.extensionBuilder_;
    }
    
    private void ensureNestedTypeIsMutable() {
        if ((this.bitField0_ & 0x8) != 0x8) {
            this.nestedType_ = new ArrayList(this.nestedType_);
            this.bitField0_ |= 0x8;
        }
    }
    
    public List getNestedTypeList() {
        if (this.nestedTypeBuilder_ == null) {
            return Collections.unmodifiableList((List<?>)this.nestedType_);
        }
        return this.nestedTypeBuilder_.getMessageList();
    }
    
    public int getNestedTypeCount() {
        if (this.nestedTypeBuilder_ == null) {
            return this.nestedType_.size();
        }
        return this.nestedTypeBuilder_.getCount();
    }
    
    public DescriptorProtos$DescriptorProto getNestedType(final int n) {
        if (this.nestedTypeBuilder_ == null) {
            return this.nestedType_.get(n);
        }
        return (DescriptorProtos$DescriptorProto)this.nestedTypeBuilder_.getMessage(n);
    }
    
    public DescriptorProtos$DescriptorProto$Builder setNestedType(final int n, final DescriptorProtos$DescriptorProto descriptorProtos$DescriptorProto) {
        if (this.nestedTypeBuilder_ == null) {
            if (descriptorProtos$DescriptorProto == null) {
                throw new NullPointerException();
            }
            this.ensureNestedTypeIsMutable();
            this.nestedType_.set(n, descriptorProtos$DescriptorProto);
            this.onChanged();
        }
        else {
            this.nestedTypeBuilder_.setMessage(n, descriptorProtos$DescriptorProto);
        }
        return this;
    }
    
    public DescriptorProtos$DescriptorProto$Builder setNestedType(final int n, final DescriptorProtos$DescriptorProto$Builder descriptorProtos$DescriptorProto$Builder) {
        if (this.nestedTypeBuilder_ == null) {
            this.ensureNestedTypeIsMutable();
            this.nestedType_.set(n, descriptorProtos$DescriptorProto$Builder.build());
            this.onChanged();
        }
        else {
            this.nestedTypeBuilder_.setMessage(n, descriptorProtos$DescriptorProto$Builder.build());
        }
        return this;
    }
    
    public DescriptorProtos$DescriptorProto$Builder addNestedType(final DescriptorProtos$DescriptorProto descriptorProtos$DescriptorProto) {
        if (this.nestedTypeBuilder_ == null) {
            if (descriptorProtos$DescriptorProto == null) {
                throw new NullPointerException();
            }
            this.ensureNestedTypeIsMutable();
            this.nestedType_.add(descriptorProtos$DescriptorProto);
            this.onChanged();
        }
        else {
            this.nestedTypeBuilder_.addMessage(descriptorProtos$DescriptorProto);
        }
        return this;
    }
    
    public DescriptorProtos$DescriptorProto$Builder addNestedType(final int n, final DescriptorProtos$DescriptorProto descriptorProtos$DescriptorProto) {
        if (this.nestedTypeBuilder_ == null) {
            if (descriptorProtos$DescriptorProto == null) {
                throw new NullPointerException();
            }
            this.ensureNestedTypeIsMutable();
            this.nestedType_.add(n, descriptorProtos$DescriptorProto);
            this.onChanged();
        }
        else {
            this.nestedTypeBuilder_.addMessage(n, descriptorProtos$DescriptorProto);
        }
        return this;
    }
    
    public DescriptorProtos$DescriptorProto$Builder addNestedType(final DescriptorProtos$DescriptorProto$Builder descriptorProtos$DescriptorProto$Builder) {
        if (this.nestedTypeBuilder_ == null) {
            this.ensureNestedTypeIsMutable();
            this.nestedType_.add(descriptorProtos$DescriptorProto$Builder.build());
            this.onChanged();
        }
        else {
            this.nestedTypeBuilder_.addMessage(descriptorProtos$DescriptorProto$Builder.build());
        }
        return this;
    }
    
    public DescriptorProtos$DescriptorProto$Builder addNestedType(final int n, final DescriptorProtos$DescriptorProto$Builder descriptorProtos$DescriptorProto$Builder) {
        if (this.nestedTypeBuilder_ == null) {
            this.ensureNestedTypeIsMutable();
            this.nestedType_.add(n, descriptorProtos$DescriptorProto$Builder.build());
            this.onChanged();
        }
        else {
            this.nestedTypeBuilder_.addMessage(n, descriptorProtos$DescriptorProto$Builder.build());
        }
        return this;
    }
    
    public DescriptorProtos$DescriptorProto$Builder addAllNestedType(final Iterable iterable) {
        if (this.nestedTypeBuilder_ == null) {
            this.ensureNestedTypeIsMutable();
            AbstractMessageLite$Builder.addAll(iterable, this.nestedType_);
            this.onChanged();
        }
        else {
            this.nestedTypeBuilder_.addAllMessages(iterable);
        }
        return this;
    }
    
    public DescriptorProtos$DescriptorProto$Builder clearNestedType() {
        if (this.nestedTypeBuilder_ == null) {
            this.nestedType_ = Collections.emptyList();
            this.bitField0_ &= 0xFFFFFFF7;
            this.onChanged();
        }
        else {
            this.nestedTypeBuilder_.clear();
        }
        return this;
    }
    
    public DescriptorProtos$DescriptorProto$Builder removeNestedType(final int n) {
        if (this.nestedTypeBuilder_ == null) {
            this.ensureNestedTypeIsMutable();
            this.nestedType_.remove(n);
            this.onChanged();
        }
        else {
            this.nestedTypeBuilder_.remove(n);
        }
        return this;
    }
    
    public DescriptorProtos$DescriptorProto$Builder getNestedTypeBuilder(final int n) {
        return (DescriptorProtos$DescriptorProto$Builder)this.getNestedTypeFieldBuilder().getBuilder(n);
    }
    
    public DescriptorProtos$DescriptorProtoOrBuilder getNestedTypeOrBuilder(final int n) {
        if (this.nestedTypeBuilder_ == null) {
            return this.nestedType_.get(n);
        }
        return (DescriptorProtos$DescriptorProtoOrBuilder)this.nestedTypeBuilder_.getMessageOrBuilder(n);
    }
    
    public List getNestedTypeOrBuilderList() {
        if (this.nestedTypeBuilder_ != null) {
            return this.nestedTypeBuilder_.getMessageOrBuilderList();
        }
        return Collections.unmodifiableList((List<?>)this.nestedType_);
    }
    
    public DescriptorProtos$DescriptorProto$Builder addNestedTypeBuilder() {
        return (DescriptorProtos$DescriptorProto$Builder)this.getNestedTypeFieldBuilder().addBuilder(DescriptorProtos$DescriptorProto.getDefaultInstance());
    }
    
    public DescriptorProtos$DescriptorProto$Builder addNestedTypeBuilder(final int n) {
        return (DescriptorProtos$DescriptorProto$Builder)this.getNestedTypeFieldBuilder().addBuilder(n, DescriptorProtos$DescriptorProto.getDefaultInstance());
    }
    
    public List getNestedTypeBuilderList() {
        return this.getNestedTypeFieldBuilder().getBuilderList();
    }
    
    private RepeatedFieldBuilder getNestedTypeFieldBuilder() {
        if (this.nestedTypeBuilder_ == null) {
            this.nestedTypeBuilder_ = new RepeatedFieldBuilder(this.nestedType_, (this.bitField0_ & 0x8) == 0x8, this.getParentForChildren(), this.isClean());
            this.nestedType_ = null;
        }
        return this.nestedTypeBuilder_;
    }
    
    private void ensureEnumTypeIsMutable() {
        if ((this.bitField0_ & 0x10) != 0x10) {
            this.enumType_ = new ArrayList(this.enumType_);
            this.bitField0_ |= 0x10;
        }
    }
    
    public List getEnumTypeList() {
        if (this.enumTypeBuilder_ == null) {
            return Collections.unmodifiableList((List<?>)this.enumType_);
        }
        return this.enumTypeBuilder_.getMessageList();
    }
    
    public int getEnumTypeCount() {
        if (this.enumTypeBuilder_ == null) {
            return this.enumType_.size();
        }
        return this.enumTypeBuilder_.getCount();
    }
    
    public DescriptorProtos$EnumDescriptorProto getEnumType(final int n) {
        if (this.enumTypeBuilder_ == null) {
            return this.enumType_.get(n);
        }
        return (DescriptorProtos$EnumDescriptorProto)this.enumTypeBuilder_.getMessage(n);
    }
    
    public DescriptorProtos$DescriptorProto$Builder setEnumType(final int n, final DescriptorProtos$EnumDescriptorProto descriptorProtos$EnumDescriptorProto) {
        if (this.enumTypeBuilder_ == null) {
            if (descriptorProtos$EnumDescriptorProto == null) {
                throw new NullPointerException();
            }
            this.ensureEnumTypeIsMutable();
            this.enumType_.set(n, descriptorProtos$EnumDescriptorProto);
            this.onChanged();
        }
        else {
            this.enumTypeBuilder_.setMessage(n, descriptorProtos$EnumDescriptorProto);
        }
        return this;
    }
    
    public DescriptorProtos$DescriptorProto$Builder setEnumType(final int n, final DescriptorProtos$EnumDescriptorProto$Builder descriptorProtos$EnumDescriptorProto$Builder) {
        if (this.enumTypeBuilder_ == null) {
            this.ensureEnumTypeIsMutable();
            this.enumType_.set(n, descriptorProtos$EnumDescriptorProto$Builder.build());
            this.onChanged();
        }
        else {
            this.enumTypeBuilder_.setMessage(n, descriptorProtos$EnumDescriptorProto$Builder.build());
        }
        return this;
    }
    
    public DescriptorProtos$DescriptorProto$Builder addEnumType(final DescriptorProtos$EnumDescriptorProto descriptorProtos$EnumDescriptorProto) {
        if (this.enumTypeBuilder_ == null) {
            if (descriptorProtos$EnumDescriptorProto == null) {
                throw new NullPointerException();
            }
            this.ensureEnumTypeIsMutable();
            this.enumType_.add(descriptorProtos$EnumDescriptorProto);
            this.onChanged();
        }
        else {
            this.enumTypeBuilder_.addMessage(descriptorProtos$EnumDescriptorProto);
        }
        return this;
    }
    
    public DescriptorProtos$DescriptorProto$Builder addEnumType(final int n, final DescriptorProtos$EnumDescriptorProto descriptorProtos$EnumDescriptorProto) {
        if (this.enumTypeBuilder_ == null) {
            if (descriptorProtos$EnumDescriptorProto == null) {
                throw new NullPointerException();
            }
            this.ensureEnumTypeIsMutable();
            this.enumType_.add(n, descriptorProtos$EnumDescriptorProto);
            this.onChanged();
        }
        else {
            this.enumTypeBuilder_.addMessage(n, descriptorProtos$EnumDescriptorProto);
        }
        return this;
    }
    
    public DescriptorProtos$DescriptorProto$Builder addEnumType(final DescriptorProtos$EnumDescriptorProto$Builder descriptorProtos$EnumDescriptorProto$Builder) {
        if (this.enumTypeBuilder_ == null) {
            this.ensureEnumTypeIsMutable();
            this.enumType_.add(descriptorProtos$EnumDescriptorProto$Builder.build());
            this.onChanged();
        }
        else {
            this.enumTypeBuilder_.addMessage(descriptorProtos$EnumDescriptorProto$Builder.build());
        }
        return this;
    }
    
    public DescriptorProtos$DescriptorProto$Builder addEnumType(final int n, final DescriptorProtos$EnumDescriptorProto$Builder descriptorProtos$EnumDescriptorProto$Builder) {
        if (this.enumTypeBuilder_ == null) {
            this.ensureEnumTypeIsMutable();
            this.enumType_.add(n, descriptorProtos$EnumDescriptorProto$Builder.build());
            this.onChanged();
        }
        else {
            this.enumTypeBuilder_.addMessage(n, descriptorProtos$EnumDescriptorProto$Builder.build());
        }
        return this;
    }
    
    public DescriptorProtos$DescriptorProto$Builder addAllEnumType(final Iterable iterable) {
        if (this.enumTypeBuilder_ == null) {
            this.ensureEnumTypeIsMutable();
            AbstractMessageLite$Builder.addAll(iterable, this.enumType_);
            this.onChanged();
        }
        else {
            this.enumTypeBuilder_.addAllMessages(iterable);
        }
        return this;
    }
    
    public DescriptorProtos$DescriptorProto$Builder clearEnumType() {
        if (this.enumTypeBuilder_ == null) {
            this.enumType_ = Collections.emptyList();
            this.bitField0_ &= 0xFFFFFFEF;
            this.onChanged();
        }
        else {
            this.enumTypeBuilder_.clear();
        }
        return this;
    }
    
    public DescriptorProtos$DescriptorProto$Builder removeEnumType(final int n) {
        if (this.enumTypeBuilder_ == null) {
            this.ensureEnumTypeIsMutable();
            this.enumType_.remove(n);
            this.onChanged();
        }
        else {
            this.enumTypeBuilder_.remove(n);
        }
        return this;
    }
    
    public DescriptorProtos$EnumDescriptorProto$Builder getEnumTypeBuilder(final int n) {
        return (DescriptorProtos$EnumDescriptorProto$Builder)this.getEnumTypeFieldBuilder().getBuilder(n);
    }
    
    public DescriptorProtos$EnumDescriptorProtoOrBuilder getEnumTypeOrBuilder(final int n) {
        if (this.enumTypeBuilder_ == null) {
            return this.enumType_.get(n);
        }
        return (DescriptorProtos$EnumDescriptorProtoOrBuilder)this.enumTypeBuilder_.getMessageOrBuilder(n);
    }
    
    public List getEnumTypeOrBuilderList() {
        if (this.enumTypeBuilder_ != null) {
            return this.enumTypeBuilder_.getMessageOrBuilderList();
        }
        return Collections.unmodifiableList((List<?>)this.enumType_);
    }
    
    public DescriptorProtos$EnumDescriptorProto$Builder addEnumTypeBuilder() {
        return (DescriptorProtos$EnumDescriptorProto$Builder)this.getEnumTypeFieldBuilder().addBuilder(DescriptorProtos$EnumDescriptorProto.getDefaultInstance());
    }
    
    public DescriptorProtos$EnumDescriptorProto$Builder addEnumTypeBuilder(final int n) {
        return (DescriptorProtos$EnumDescriptorProto$Builder)this.getEnumTypeFieldBuilder().addBuilder(n, DescriptorProtos$EnumDescriptorProto.getDefaultInstance());
    }
    
    public List getEnumTypeBuilderList() {
        return this.getEnumTypeFieldBuilder().getBuilderList();
    }
    
    private RepeatedFieldBuilder getEnumTypeFieldBuilder() {
        if (this.enumTypeBuilder_ == null) {
            this.enumTypeBuilder_ = new RepeatedFieldBuilder(this.enumType_, (this.bitField0_ & 0x10) == 0x10, this.getParentForChildren(), this.isClean());
            this.enumType_ = null;
        }
        return this.enumTypeBuilder_;
    }
    
    private void ensureExtensionRangeIsMutable() {
        if ((this.bitField0_ & 0x20) != 0x20) {
            this.extensionRange_ = new ArrayList(this.extensionRange_);
            this.bitField0_ |= 0x20;
        }
    }
    
    public List getExtensionRangeList() {
        if (this.extensionRangeBuilder_ == null) {
            return Collections.unmodifiableList((List<?>)this.extensionRange_);
        }
        return this.extensionRangeBuilder_.getMessageList();
    }
    
    public int getExtensionRangeCount() {
        if (this.extensionRangeBuilder_ == null) {
            return this.extensionRange_.size();
        }
        return this.extensionRangeBuilder_.getCount();
    }
    
    public DescriptorProtos$DescriptorProto$ExtensionRange getExtensionRange(final int n) {
        if (this.extensionRangeBuilder_ == null) {
            return this.extensionRange_.get(n);
        }
        return (DescriptorProtos$DescriptorProto$ExtensionRange)this.extensionRangeBuilder_.getMessage(n);
    }
    
    public DescriptorProtos$DescriptorProto$Builder setExtensionRange(final int n, final DescriptorProtos$DescriptorProto$ExtensionRange descriptorProtos$DescriptorProto$ExtensionRange) {
        if (this.extensionRangeBuilder_ == null) {
            if (descriptorProtos$DescriptorProto$ExtensionRange == null) {
                throw new NullPointerException();
            }
            this.ensureExtensionRangeIsMutable();
            this.extensionRange_.set(n, descriptorProtos$DescriptorProto$ExtensionRange);
            this.onChanged();
        }
        else {
            this.extensionRangeBuilder_.setMessage(n, descriptorProtos$DescriptorProto$ExtensionRange);
        }
        return this;
    }
    
    public DescriptorProtos$DescriptorProto$Builder setExtensionRange(final int n, final DescriptorProtos$DescriptorProto$ExtensionRange$Builder descriptorProtos$DescriptorProto$ExtensionRange$Builder) {
        if (this.extensionRangeBuilder_ == null) {
            this.ensureExtensionRangeIsMutable();
            this.extensionRange_.set(n, descriptorProtos$DescriptorProto$ExtensionRange$Builder.build());
            this.onChanged();
        }
        else {
            this.extensionRangeBuilder_.setMessage(n, descriptorProtos$DescriptorProto$ExtensionRange$Builder.build());
        }
        return this;
    }
    
    public DescriptorProtos$DescriptorProto$Builder addExtensionRange(final DescriptorProtos$DescriptorProto$ExtensionRange descriptorProtos$DescriptorProto$ExtensionRange) {
        if (this.extensionRangeBuilder_ == null) {
            if (descriptorProtos$DescriptorProto$ExtensionRange == null) {
                throw new NullPointerException();
            }
            this.ensureExtensionRangeIsMutable();
            this.extensionRange_.add(descriptorProtos$DescriptorProto$ExtensionRange);
            this.onChanged();
        }
        else {
            this.extensionRangeBuilder_.addMessage(descriptorProtos$DescriptorProto$ExtensionRange);
        }
        return this;
    }
    
    public DescriptorProtos$DescriptorProto$Builder addExtensionRange(final int n, final DescriptorProtos$DescriptorProto$ExtensionRange descriptorProtos$DescriptorProto$ExtensionRange) {
        if (this.extensionRangeBuilder_ == null) {
            if (descriptorProtos$DescriptorProto$ExtensionRange == null) {
                throw new NullPointerException();
            }
            this.ensureExtensionRangeIsMutable();
            this.extensionRange_.add(n, descriptorProtos$DescriptorProto$ExtensionRange);
            this.onChanged();
        }
        else {
            this.extensionRangeBuilder_.addMessage(n, descriptorProtos$DescriptorProto$ExtensionRange);
        }
        return this;
    }
    
    public DescriptorProtos$DescriptorProto$Builder addExtensionRange(final DescriptorProtos$DescriptorProto$ExtensionRange$Builder descriptorProtos$DescriptorProto$ExtensionRange$Builder) {
        if (this.extensionRangeBuilder_ == null) {
            this.ensureExtensionRangeIsMutable();
            this.extensionRange_.add(descriptorProtos$DescriptorProto$ExtensionRange$Builder.build());
            this.onChanged();
        }
        else {
            this.extensionRangeBuilder_.addMessage(descriptorProtos$DescriptorProto$ExtensionRange$Builder.build());
        }
        return this;
    }
    
    public DescriptorProtos$DescriptorProto$Builder addExtensionRange(final int n, final DescriptorProtos$DescriptorProto$ExtensionRange$Builder descriptorProtos$DescriptorProto$ExtensionRange$Builder) {
        if (this.extensionRangeBuilder_ == null) {
            this.ensureExtensionRangeIsMutable();
            this.extensionRange_.add(n, descriptorProtos$DescriptorProto$ExtensionRange$Builder.build());
            this.onChanged();
        }
        else {
            this.extensionRangeBuilder_.addMessage(n, descriptorProtos$DescriptorProto$ExtensionRange$Builder.build());
        }
        return this;
    }
    
    public DescriptorProtos$DescriptorProto$Builder addAllExtensionRange(final Iterable iterable) {
        if (this.extensionRangeBuilder_ == null) {
            this.ensureExtensionRangeIsMutable();
            AbstractMessageLite$Builder.addAll(iterable, this.extensionRange_);
            this.onChanged();
        }
        else {
            this.extensionRangeBuilder_.addAllMessages(iterable);
        }
        return this;
    }
    
    public DescriptorProtos$DescriptorProto$Builder clearExtensionRange() {
        if (this.extensionRangeBuilder_ == null) {
            this.extensionRange_ = Collections.emptyList();
            this.bitField0_ &= 0xFFFFFFDF;
            this.onChanged();
        }
        else {
            this.extensionRangeBuilder_.clear();
        }
        return this;
    }
    
    public DescriptorProtos$DescriptorProto$Builder removeExtensionRange(final int n) {
        if (this.extensionRangeBuilder_ == null) {
            this.ensureExtensionRangeIsMutable();
            this.extensionRange_.remove(n);
            this.onChanged();
        }
        else {
            this.extensionRangeBuilder_.remove(n);
        }
        return this;
    }
    
    public DescriptorProtos$DescriptorProto$ExtensionRange$Builder getExtensionRangeBuilder(final int n) {
        return (DescriptorProtos$DescriptorProto$ExtensionRange$Builder)this.getExtensionRangeFieldBuilder().getBuilder(n);
    }
    
    public DescriptorProtos$DescriptorProto$ExtensionRangeOrBuilder getExtensionRangeOrBuilder(final int n) {
        if (this.extensionRangeBuilder_ == null) {
            return this.extensionRange_.get(n);
        }
        return (DescriptorProtos$DescriptorProto$ExtensionRangeOrBuilder)this.extensionRangeBuilder_.getMessageOrBuilder(n);
    }
    
    public List getExtensionRangeOrBuilderList() {
        if (this.extensionRangeBuilder_ != null) {
            return this.extensionRangeBuilder_.getMessageOrBuilderList();
        }
        return Collections.unmodifiableList((List<?>)this.extensionRange_);
    }
    
    public DescriptorProtos$DescriptorProto$ExtensionRange$Builder addExtensionRangeBuilder() {
        return (DescriptorProtos$DescriptorProto$ExtensionRange$Builder)this.getExtensionRangeFieldBuilder().addBuilder(DescriptorProtos$DescriptorProto$ExtensionRange.getDefaultInstance());
    }
    
    public DescriptorProtos$DescriptorProto$ExtensionRange$Builder addExtensionRangeBuilder(final int n) {
        return (DescriptorProtos$DescriptorProto$ExtensionRange$Builder)this.getExtensionRangeFieldBuilder().addBuilder(n, DescriptorProtos$DescriptorProto$ExtensionRange.getDefaultInstance());
    }
    
    public List getExtensionRangeBuilderList() {
        return this.getExtensionRangeFieldBuilder().getBuilderList();
    }
    
    private RepeatedFieldBuilder getExtensionRangeFieldBuilder() {
        if (this.extensionRangeBuilder_ == null) {
            this.extensionRangeBuilder_ = new RepeatedFieldBuilder(this.extensionRange_, (this.bitField0_ & 0x20) == 0x20, this.getParentForChildren(), this.isClean());
            this.extensionRange_ = null;
        }
        return this.extensionRangeBuilder_;
    }
    
    private void ensureOneofDeclIsMutable() {
        if ((this.bitField0_ & 0x40) != 0x40) {
            this.oneofDecl_ = new ArrayList(this.oneofDecl_);
            this.bitField0_ |= 0x40;
        }
    }
    
    public List getOneofDeclList() {
        if (this.oneofDeclBuilder_ == null) {
            return Collections.unmodifiableList((List<?>)this.oneofDecl_);
        }
        return this.oneofDeclBuilder_.getMessageList();
    }
    
    public int getOneofDeclCount() {
        if (this.oneofDeclBuilder_ == null) {
            return this.oneofDecl_.size();
        }
        return this.oneofDeclBuilder_.getCount();
    }
    
    public DescriptorProtos$OneofDescriptorProto getOneofDecl(final int n) {
        if (this.oneofDeclBuilder_ == null) {
            return this.oneofDecl_.get(n);
        }
        return (DescriptorProtos$OneofDescriptorProto)this.oneofDeclBuilder_.getMessage(n);
    }
    
    public DescriptorProtos$DescriptorProto$Builder setOneofDecl(final int n, final DescriptorProtos$OneofDescriptorProto descriptorProtos$OneofDescriptorProto) {
        if (this.oneofDeclBuilder_ == null) {
            if (descriptorProtos$OneofDescriptorProto == null) {
                throw new NullPointerException();
            }
            this.ensureOneofDeclIsMutable();
            this.oneofDecl_.set(n, descriptorProtos$OneofDescriptorProto);
            this.onChanged();
        }
        else {
            this.oneofDeclBuilder_.setMessage(n, descriptorProtos$OneofDescriptorProto);
        }
        return this;
    }
    
    public DescriptorProtos$DescriptorProto$Builder setOneofDecl(final int n, final DescriptorProtos$OneofDescriptorProto$Builder descriptorProtos$OneofDescriptorProto$Builder) {
        if (this.oneofDeclBuilder_ == null) {
            this.ensureOneofDeclIsMutable();
            this.oneofDecl_.set(n, descriptorProtos$OneofDescriptorProto$Builder.build());
            this.onChanged();
        }
        else {
            this.oneofDeclBuilder_.setMessage(n, descriptorProtos$OneofDescriptorProto$Builder.build());
        }
        return this;
    }
    
    public DescriptorProtos$DescriptorProto$Builder addOneofDecl(final DescriptorProtos$OneofDescriptorProto descriptorProtos$OneofDescriptorProto) {
        if (this.oneofDeclBuilder_ == null) {
            if (descriptorProtos$OneofDescriptorProto == null) {
                throw new NullPointerException();
            }
            this.ensureOneofDeclIsMutable();
            this.oneofDecl_.add(descriptorProtos$OneofDescriptorProto);
            this.onChanged();
        }
        else {
            this.oneofDeclBuilder_.addMessage(descriptorProtos$OneofDescriptorProto);
        }
        return this;
    }
    
    public DescriptorProtos$DescriptorProto$Builder addOneofDecl(final int n, final DescriptorProtos$OneofDescriptorProto descriptorProtos$OneofDescriptorProto) {
        if (this.oneofDeclBuilder_ == null) {
            if (descriptorProtos$OneofDescriptorProto == null) {
                throw new NullPointerException();
            }
            this.ensureOneofDeclIsMutable();
            this.oneofDecl_.add(n, descriptorProtos$OneofDescriptorProto);
            this.onChanged();
        }
        else {
            this.oneofDeclBuilder_.addMessage(n, descriptorProtos$OneofDescriptorProto);
        }
        return this;
    }
    
    public DescriptorProtos$DescriptorProto$Builder addOneofDecl(final DescriptorProtos$OneofDescriptorProto$Builder descriptorProtos$OneofDescriptorProto$Builder) {
        if (this.oneofDeclBuilder_ == null) {
            this.ensureOneofDeclIsMutable();
            this.oneofDecl_.add(descriptorProtos$OneofDescriptorProto$Builder.build());
            this.onChanged();
        }
        else {
            this.oneofDeclBuilder_.addMessage(descriptorProtos$OneofDescriptorProto$Builder.build());
        }
        return this;
    }
    
    public DescriptorProtos$DescriptorProto$Builder addOneofDecl(final int n, final DescriptorProtos$OneofDescriptorProto$Builder descriptorProtos$OneofDescriptorProto$Builder) {
        if (this.oneofDeclBuilder_ == null) {
            this.ensureOneofDeclIsMutable();
            this.oneofDecl_.add(n, descriptorProtos$OneofDescriptorProto$Builder.build());
            this.onChanged();
        }
        else {
            this.oneofDeclBuilder_.addMessage(n, descriptorProtos$OneofDescriptorProto$Builder.build());
        }
        return this;
    }
    
    public DescriptorProtos$DescriptorProto$Builder addAllOneofDecl(final Iterable iterable) {
        if (this.oneofDeclBuilder_ == null) {
            this.ensureOneofDeclIsMutable();
            AbstractMessageLite$Builder.addAll(iterable, this.oneofDecl_);
            this.onChanged();
        }
        else {
            this.oneofDeclBuilder_.addAllMessages(iterable);
        }
        return this;
    }
    
    public DescriptorProtos$DescriptorProto$Builder clearOneofDecl() {
        if (this.oneofDeclBuilder_ == null) {
            this.oneofDecl_ = Collections.emptyList();
            this.bitField0_ &= 0xFFFFFFBF;
            this.onChanged();
        }
        else {
            this.oneofDeclBuilder_.clear();
        }
        return this;
    }
    
    public DescriptorProtos$DescriptorProto$Builder removeOneofDecl(final int n) {
        if (this.oneofDeclBuilder_ == null) {
            this.ensureOneofDeclIsMutable();
            this.oneofDecl_.remove(n);
            this.onChanged();
        }
        else {
            this.oneofDeclBuilder_.remove(n);
        }
        return this;
    }
    
    public DescriptorProtos$OneofDescriptorProto$Builder getOneofDeclBuilder(final int n) {
        return (DescriptorProtos$OneofDescriptorProto$Builder)this.getOneofDeclFieldBuilder().getBuilder(n);
    }
    
    public DescriptorProtos$OneofDescriptorProtoOrBuilder getOneofDeclOrBuilder(final int n) {
        if (this.oneofDeclBuilder_ == null) {
            return this.oneofDecl_.get(n);
        }
        return (DescriptorProtos$OneofDescriptorProtoOrBuilder)this.oneofDeclBuilder_.getMessageOrBuilder(n);
    }
    
    public List getOneofDeclOrBuilderList() {
        if (this.oneofDeclBuilder_ != null) {
            return this.oneofDeclBuilder_.getMessageOrBuilderList();
        }
        return Collections.unmodifiableList((List<?>)this.oneofDecl_);
    }
    
    public DescriptorProtos$OneofDescriptorProto$Builder addOneofDeclBuilder() {
        return (DescriptorProtos$OneofDescriptorProto$Builder)this.getOneofDeclFieldBuilder().addBuilder(DescriptorProtos$OneofDescriptorProto.getDefaultInstance());
    }
    
    public DescriptorProtos$OneofDescriptorProto$Builder addOneofDeclBuilder(final int n) {
        return (DescriptorProtos$OneofDescriptorProto$Builder)this.getOneofDeclFieldBuilder().addBuilder(n, DescriptorProtos$OneofDescriptorProto.getDefaultInstance());
    }
    
    public List getOneofDeclBuilderList() {
        return this.getOneofDeclFieldBuilder().getBuilderList();
    }
    
    private RepeatedFieldBuilder getOneofDeclFieldBuilder() {
        if (this.oneofDeclBuilder_ == null) {
            this.oneofDeclBuilder_ = new RepeatedFieldBuilder(this.oneofDecl_, (this.bitField0_ & 0x40) == 0x40, this.getParentForChildren(), this.isClean());
            this.oneofDecl_ = null;
        }
        return this.oneofDeclBuilder_;
    }
    
    public boolean hasOptions() {
        return (this.bitField0_ & 0x80) == 0x80;
    }
    
    public DescriptorProtos$MessageOptions getOptions() {
        if (this.optionsBuilder_ == null) {
            return (this.options_ == null) ? DescriptorProtos$MessageOptions.getDefaultInstance() : this.options_;
        }
        return (DescriptorProtos$MessageOptions)this.optionsBuilder_.getMessage();
    }
    
    public DescriptorProtos$DescriptorProto$Builder setOptions(final DescriptorProtos$MessageOptions descriptorProtos$MessageOptions) {
        if (this.optionsBuilder_ == null) {
            if (descriptorProtos$MessageOptions == null) {
                throw new NullPointerException();
            }
            this.options_ = descriptorProtos$MessageOptions;
            this.onChanged();
        }
        else {
            this.optionsBuilder_.setMessage(descriptorProtos$MessageOptions);
        }
        this.bitField0_ |= 0x80;
        return this;
    }
    
    public DescriptorProtos$DescriptorProto$Builder setOptions(final DescriptorProtos$MessageOptions$Builder descriptorProtos$MessageOptions$Builder) {
        if (this.optionsBuilder_ == null) {
            this.options_ = descriptorProtos$MessageOptions$Builder.build();
            this.onChanged();
        }
        else {
            this.optionsBuilder_.setMessage(descriptorProtos$MessageOptions$Builder.build());
        }
        this.bitField0_ |= 0x80;
        return this;
    }
    
    public DescriptorProtos$DescriptorProto$Builder mergeOptions(final DescriptorProtos$MessageOptions options_) {
        if (this.optionsBuilder_ == null) {
            if ((this.bitField0_ & 0x80) == 0x80 && this.options_ != null && this.options_ != DescriptorProtos$MessageOptions.getDefaultInstance()) {
                this.options_ = DescriptorProtos$MessageOptions.newBuilder(this.options_).mergeFrom(options_).buildPartial();
            }
            else {
                this.options_ = options_;
            }
            this.onChanged();
        }
        else {
            this.optionsBuilder_.mergeFrom(options_);
        }
        this.bitField0_ |= 0x80;
        return this;
    }
    
    public DescriptorProtos$DescriptorProto$Builder clearOptions() {
        if (this.optionsBuilder_ == null) {
            this.options_ = null;
            this.onChanged();
        }
        else {
            this.optionsBuilder_.clear();
        }
        this.bitField0_ &= 0xFFFFFF7F;
        return this;
    }
    
    public DescriptorProtos$MessageOptions$Builder getOptionsBuilder() {
        this.bitField0_ |= 0x80;
        this.onChanged();
        return (DescriptorProtos$MessageOptions$Builder)this.getOptionsFieldBuilder().getBuilder();
    }
    
    public DescriptorProtos$MessageOptionsOrBuilder getOptionsOrBuilder() {
        if (this.optionsBuilder_ != null) {
            return (DescriptorProtos$MessageOptionsOrBuilder)this.optionsBuilder_.getMessageOrBuilder();
        }
        return (this.options_ == null) ? DescriptorProtos$MessageOptions.getDefaultInstance() : this.options_;
    }
    
    private SingleFieldBuilder getOptionsFieldBuilder() {
        if (this.optionsBuilder_ == null) {
            this.optionsBuilder_ = new SingleFieldBuilder(this.getOptions(), this.getParentForChildren(), this.isClean());
            this.options_ = null;
        }
        return this.optionsBuilder_;
    }
    
    private void ensureReservedRangeIsMutable() {
        if ((this.bitField0_ & 0x100) != 0x100) {
            this.reservedRange_ = new ArrayList(this.reservedRange_);
            this.bitField0_ |= 0x100;
        }
    }
    
    public List getReservedRangeList() {
        if (this.reservedRangeBuilder_ == null) {
            return Collections.unmodifiableList((List<?>)this.reservedRange_);
        }
        return this.reservedRangeBuilder_.getMessageList();
    }
    
    public int getReservedRangeCount() {
        if (this.reservedRangeBuilder_ == null) {
            return this.reservedRange_.size();
        }
        return this.reservedRangeBuilder_.getCount();
    }
    
    public DescriptorProtos$DescriptorProto$ReservedRange getReservedRange(final int n) {
        if (this.reservedRangeBuilder_ == null) {
            return this.reservedRange_.get(n);
        }
        return (DescriptorProtos$DescriptorProto$ReservedRange)this.reservedRangeBuilder_.getMessage(n);
    }
    
    public DescriptorProtos$DescriptorProto$Builder setReservedRange(final int n, final DescriptorProtos$DescriptorProto$ReservedRange descriptorProtos$DescriptorProto$ReservedRange) {
        if (this.reservedRangeBuilder_ == null) {
            if (descriptorProtos$DescriptorProto$ReservedRange == null) {
                throw new NullPointerException();
            }
            this.ensureReservedRangeIsMutable();
            this.reservedRange_.set(n, descriptorProtos$DescriptorProto$ReservedRange);
            this.onChanged();
        }
        else {
            this.reservedRangeBuilder_.setMessage(n, descriptorProtos$DescriptorProto$ReservedRange);
        }
        return this;
    }
    
    public DescriptorProtos$DescriptorProto$Builder setReservedRange(final int n, final DescriptorProtos$DescriptorProto$ReservedRange$Builder descriptorProtos$DescriptorProto$ReservedRange$Builder) {
        if (this.reservedRangeBuilder_ == null) {
            this.ensureReservedRangeIsMutable();
            this.reservedRange_.set(n, descriptorProtos$DescriptorProto$ReservedRange$Builder.build());
            this.onChanged();
        }
        else {
            this.reservedRangeBuilder_.setMessage(n, descriptorProtos$DescriptorProto$ReservedRange$Builder.build());
        }
        return this;
    }
    
    public DescriptorProtos$DescriptorProto$Builder addReservedRange(final DescriptorProtos$DescriptorProto$ReservedRange descriptorProtos$DescriptorProto$ReservedRange) {
        if (this.reservedRangeBuilder_ == null) {
            if (descriptorProtos$DescriptorProto$ReservedRange == null) {
                throw new NullPointerException();
            }
            this.ensureReservedRangeIsMutable();
            this.reservedRange_.add(descriptorProtos$DescriptorProto$ReservedRange);
            this.onChanged();
        }
        else {
            this.reservedRangeBuilder_.addMessage(descriptorProtos$DescriptorProto$ReservedRange);
        }
        return this;
    }
    
    public DescriptorProtos$DescriptorProto$Builder addReservedRange(final int n, final DescriptorProtos$DescriptorProto$ReservedRange descriptorProtos$DescriptorProto$ReservedRange) {
        if (this.reservedRangeBuilder_ == null) {
            if (descriptorProtos$DescriptorProto$ReservedRange == null) {
                throw new NullPointerException();
            }
            this.ensureReservedRangeIsMutable();
            this.reservedRange_.add(n, descriptorProtos$DescriptorProto$ReservedRange);
            this.onChanged();
        }
        else {
            this.reservedRangeBuilder_.addMessage(n, descriptorProtos$DescriptorProto$ReservedRange);
        }
        return this;
    }
    
    public DescriptorProtos$DescriptorProto$Builder addReservedRange(final DescriptorProtos$DescriptorProto$ReservedRange$Builder descriptorProtos$DescriptorProto$ReservedRange$Builder) {
        if (this.reservedRangeBuilder_ == null) {
            this.ensureReservedRangeIsMutable();
            this.reservedRange_.add(descriptorProtos$DescriptorProto$ReservedRange$Builder.build());
            this.onChanged();
        }
        else {
            this.reservedRangeBuilder_.addMessage(descriptorProtos$DescriptorProto$ReservedRange$Builder.build());
        }
        return this;
    }
    
    public DescriptorProtos$DescriptorProto$Builder addReservedRange(final int n, final DescriptorProtos$DescriptorProto$ReservedRange$Builder descriptorProtos$DescriptorProto$ReservedRange$Builder) {
        if (this.reservedRangeBuilder_ == null) {
            this.ensureReservedRangeIsMutable();
            this.reservedRange_.add(n, descriptorProtos$DescriptorProto$ReservedRange$Builder.build());
            this.onChanged();
        }
        else {
            this.reservedRangeBuilder_.addMessage(n, descriptorProtos$DescriptorProto$ReservedRange$Builder.build());
        }
        return this;
    }
    
    public DescriptorProtos$DescriptorProto$Builder addAllReservedRange(final Iterable iterable) {
        if (this.reservedRangeBuilder_ == null) {
            this.ensureReservedRangeIsMutable();
            AbstractMessageLite$Builder.addAll(iterable, this.reservedRange_);
            this.onChanged();
        }
        else {
            this.reservedRangeBuilder_.addAllMessages(iterable);
        }
        return this;
    }
    
    public DescriptorProtos$DescriptorProto$Builder clearReservedRange() {
        if (this.reservedRangeBuilder_ == null) {
            this.reservedRange_ = Collections.emptyList();
            this.bitField0_ &= 0xFFFFFEFF;
            this.onChanged();
        }
        else {
            this.reservedRangeBuilder_.clear();
        }
        return this;
    }
    
    public DescriptorProtos$DescriptorProto$Builder removeReservedRange(final int n) {
        if (this.reservedRangeBuilder_ == null) {
            this.ensureReservedRangeIsMutable();
            this.reservedRange_.remove(n);
            this.onChanged();
        }
        else {
            this.reservedRangeBuilder_.remove(n);
        }
        return this;
    }
    
    public DescriptorProtos$DescriptorProto$ReservedRange$Builder getReservedRangeBuilder(final int n) {
        return (DescriptorProtos$DescriptorProto$ReservedRange$Builder)this.getReservedRangeFieldBuilder().getBuilder(n);
    }
    
    public DescriptorProtos$DescriptorProto$ReservedRangeOrBuilder getReservedRangeOrBuilder(final int n) {
        if (this.reservedRangeBuilder_ == null) {
            return this.reservedRange_.get(n);
        }
        return (DescriptorProtos$DescriptorProto$ReservedRangeOrBuilder)this.reservedRangeBuilder_.getMessageOrBuilder(n);
    }
    
    public List getReservedRangeOrBuilderList() {
        if (this.reservedRangeBuilder_ != null) {
            return this.reservedRangeBuilder_.getMessageOrBuilderList();
        }
        return Collections.unmodifiableList((List<?>)this.reservedRange_);
    }
    
    public DescriptorProtos$DescriptorProto$ReservedRange$Builder addReservedRangeBuilder() {
        return (DescriptorProtos$DescriptorProto$ReservedRange$Builder)this.getReservedRangeFieldBuilder().addBuilder(DescriptorProtos$DescriptorProto$ReservedRange.getDefaultInstance());
    }
    
    public DescriptorProtos$DescriptorProto$ReservedRange$Builder addReservedRangeBuilder(final int n) {
        return (DescriptorProtos$DescriptorProto$ReservedRange$Builder)this.getReservedRangeFieldBuilder().addBuilder(n, DescriptorProtos$DescriptorProto$ReservedRange.getDefaultInstance());
    }
    
    public List getReservedRangeBuilderList() {
        return this.getReservedRangeFieldBuilder().getBuilderList();
    }
    
    private RepeatedFieldBuilder getReservedRangeFieldBuilder() {
        if (this.reservedRangeBuilder_ == null) {
            this.reservedRangeBuilder_ = new RepeatedFieldBuilder(this.reservedRange_, (this.bitField0_ & 0x100) == 0x100, this.getParentForChildren(), this.isClean());
            this.reservedRange_ = null;
        }
        return this.reservedRangeBuilder_;
    }
    
    private void ensureReservedNameIsMutable() {
        if ((this.bitField0_ & 0x200) != 0x200) {
            this.reservedName_ = new LazyStringArrayList(this.reservedName_);
            this.bitField0_ |= 0x200;
        }
    }
    
    public ProtocolStringList getReservedNameList() {
        return this.reservedName_.getUnmodifiableView();
    }
    
    public int getReservedNameCount() {
        return this.reservedName_.size();
    }
    
    public String getReservedName(final int n) {
        return this.reservedName_.get(n);
    }
    
    public ByteString getReservedNameBytes(final int n) {
        return this.reservedName_.getByteString(n);
    }
    
    public DescriptorProtos$DescriptorProto$Builder setReservedName(final int n, final String s) {
        if (s == null) {
            throw new NullPointerException();
        }
        this.ensureReservedNameIsMutable();
        this.reservedName_.set(n, s);
        this.onChanged();
        return this;
    }
    
    public DescriptorProtos$DescriptorProto$Builder addReservedName(final String s) {
        if (s == null) {
            throw new NullPointerException();
        }
        this.ensureReservedNameIsMutable();
        this.reservedName_.add(s);
        this.onChanged();
        return this;
    }
    
    public DescriptorProtos$DescriptorProto$Builder addAllReservedName(final Iterable iterable) {
        this.ensureReservedNameIsMutable();
        AbstractMessageLite$Builder.addAll(iterable, this.reservedName_);
        this.onChanged();
        return this;
    }
    
    public DescriptorProtos$DescriptorProto$Builder clearReservedName() {
        this.reservedName_ = LazyStringArrayList.EMPTY;
        this.bitField0_ &= 0xFFFFFDFF;
        this.onChanged();
        return this;
    }
    
    public DescriptorProtos$DescriptorProto$Builder addReservedNameBytes(final ByteString byteString) {
        if (byteString == null) {
            throw new NullPointerException();
        }
        this.ensureReservedNameIsMutable();
        this.reservedName_.add(byteString);
        this.onChanged();
        return this;
    }
}
