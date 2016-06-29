package com.google.protobuf;

import java.io.*;

public final class DescriptorProtos$FieldDescriptorProto$Builder extends GeneratedMessage$Builder implements DescriptorProtos$FieldDescriptorProtoOrBuilder
{
    private int bitField0_;
    private Object name_;
    private int number_;
    private int label_;
    private int type_;
    private Object typeName_;
    private Object extendee_;
    private Object defaultValue_;
    private int oneofIndex_;
    private DescriptorProtos$FieldOptions options_;
    private SingleFieldBuilder optionsBuilder_;
    
    public static final Descriptors$Descriptor getDescriptor() {
        return DescriptorProtos.internal_static_google_protobuf_FieldDescriptorProto_descriptor;
    }
    
    protected GeneratedMessage$FieldAccessorTable internalGetFieldAccessorTable() {
        return DescriptorProtos.internal_static_google_protobuf_FieldDescriptorProto_fieldAccessorTable.ensureFieldAccessorsInitialized(DescriptorProtos$FieldDescriptorProto.class, DescriptorProtos$FieldDescriptorProto$Builder.class);
    }
    
    private DescriptorProtos$FieldDescriptorProto$Builder() {
        this.name_ = "";
        this.label_ = 1;
        this.type_ = 1;
        this.typeName_ = "";
        this.extendee_ = "";
        this.defaultValue_ = "";
        this.options_ = null;
        this.maybeForceBuilderInitialization();
    }
    
    private DescriptorProtos$FieldDescriptorProto$Builder(final GeneratedMessage$BuilderParent generatedMessage$BuilderParent) {
        super(generatedMessage$BuilderParent);
        this.name_ = "";
        this.label_ = 1;
        this.type_ = 1;
        this.typeName_ = "";
        this.extendee_ = "";
        this.defaultValue_ = "";
        this.options_ = null;
        this.maybeForceBuilderInitialization();
    }
    
    private void maybeForceBuilderInitialization() {
        if (GeneratedMessage.alwaysUseFieldBuilders) {
            this.getOptionsFieldBuilder();
        }
    }
    
    public DescriptorProtos$FieldDescriptorProto$Builder clear() {
        super.clear();
        this.name_ = "";
        this.bitField0_ &= 0xFFFFFFFE;
        this.number_ = 0;
        this.bitField0_ &= 0xFFFFFFFD;
        this.label_ = 1;
        this.bitField0_ &= 0xFFFFFFFB;
        this.type_ = 1;
        this.bitField0_ &= 0xFFFFFFF7;
        this.typeName_ = "";
        this.bitField0_ &= 0xFFFFFFEF;
        this.extendee_ = "";
        this.bitField0_ &= 0xFFFFFFDF;
        this.defaultValue_ = "";
        this.bitField0_ &= 0xFFFFFFBF;
        this.oneofIndex_ = 0;
        this.bitField0_ &= 0xFFFFFF7F;
        if (this.optionsBuilder_ == null) {
            this.options_ = null;
        }
        else {
            this.optionsBuilder_.clear();
        }
        this.bitField0_ &= 0xFFFFFEFF;
        return this;
    }
    
    public Descriptors$Descriptor getDescriptorForType() {
        return DescriptorProtos.internal_static_google_protobuf_FieldDescriptorProto_descriptor;
    }
    
    public DescriptorProtos$FieldDescriptorProto getDefaultInstanceForType() {
        return DescriptorProtos$FieldDescriptorProto.getDefaultInstance();
    }
    
    public DescriptorProtos$FieldDescriptorProto build() {
        final DescriptorProtos$FieldDescriptorProto buildPartial = this.buildPartial();
        if (!buildPartial.isInitialized()) {
            throw AbstractMessage$Builder.newUninitializedMessageException(buildPartial);
        }
        return buildPartial;
    }
    
    public DescriptorProtos$FieldDescriptorProto buildPartial() {
        final DescriptorProtos$FieldDescriptorProto descriptorProtos$FieldDescriptorProto = new DescriptorProtos$FieldDescriptorProto(this, null);
        final int bitField0_ = this.bitField0_;
        int n = 0;
        if ((bitField0_ & 0x1) == 0x1) {
            n |= 0x1;
        }
        descriptorProtos$FieldDescriptorProto.name_ = this.name_;
        if ((bitField0_ & 0x2) == 0x2) {
            n |= 0x2;
        }
        descriptorProtos$FieldDescriptorProto.number_ = this.number_;
        if ((bitField0_ & 0x4) == 0x4) {
            n |= 0x4;
        }
        descriptorProtos$FieldDescriptorProto.label_ = this.label_;
        if ((bitField0_ & 0x8) == 0x8) {
            n |= 0x8;
        }
        descriptorProtos$FieldDescriptorProto.type_ = this.type_;
        if ((bitField0_ & 0x10) == 0x10) {
            n |= 0x10;
        }
        descriptorProtos$FieldDescriptorProto.typeName_ = this.typeName_;
        if ((bitField0_ & 0x20) == 0x20) {
            n |= 0x20;
        }
        descriptorProtos$FieldDescriptorProto.extendee_ = this.extendee_;
        if ((bitField0_ & 0x40) == 0x40) {
            n |= 0x40;
        }
        descriptorProtos$FieldDescriptorProto.defaultValue_ = this.defaultValue_;
        if ((bitField0_ & 0x80) == 0x80) {
            n |= 0x80;
        }
        descriptorProtos$FieldDescriptorProto.oneofIndex_ = this.oneofIndex_;
        if ((bitField0_ & 0x100) == 0x100) {
            n |= 0x100;
        }
        if (this.optionsBuilder_ == null) {
            descriptorProtos$FieldDescriptorProto.options_ = this.options_;
        }
        else {
            descriptorProtos$FieldDescriptorProto.options_ = (DescriptorProtos$FieldOptions)this.optionsBuilder_.build();
        }
        descriptorProtos$FieldDescriptorProto.bitField0_ = n;
        this.onBuilt();
        return descriptorProtos$FieldDescriptorProto;
    }
    
    public DescriptorProtos$FieldDescriptorProto$Builder mergeFrom(final Message message) {
        if (message instanceof DescriptorProtos$FieldDescriptorProto) {
            return this.mergeFrom((DescriptorProtos$FieldDescriptorProto)message);
        }
        super.mergeFrom(message);
        return this;
    }
    
    public DescriptorProtos$FieldDescriptorProto$Builder mergeFrom(final DescriptorProtos$FieldDescriptorProto descriptorProtos$FieldDescriptorProto) {
        if (descriptorProtos$FieldDescriptorProto == DescriptorProtos$FieldDescriptorProto.getDefaultInstance()) {
            return this;
        }
        if (descriptorProtos$FieldDescriptorProto.hasName()) {
            this.bitField0_ |= 0x1;
            this.name_ = descriptorProtos$FieldDescriptorProto.name_;
            this.onChanged();
        }
        if (descriptorProtos$FieldDescriptorProto.hasNumber()) {
            this.setNumber(descriptorProtos$FieldDescriptorProto.getNumber());
        }
        if (descriptorProtos$FieldDescriptorProto.hasLabel()) {
            this.setLabel(descriptorProtos$FieldDescriptorProto.getLabel());
        }
        if (descriptorProtos$FieldDescriptorProto.hasType()) {
            this.setType(descriptorProtos$FieldDescriptorProto.getType());
        }
        if (descriptorProtos$FieldDescriptorProto.hasTypeName()) {
            this.bitField0_ |= 0x10;
            this.typeName_ = descriptorProtos$FieldDescriptorProto.typeName_;
            this.onChanged();
        }
        if (descriptorProtos$FieldDescriptorProto.hasExtendee()) {
            this.bitField0_ |= 0x20;
            this.extendee_ = descriptorProtos$FieldDescriptorProto.extendee_;
            this.onChanged();
        }
        if (descriptorProtos$FieldDescriptorProto.hasDefaultValue()) {
            this.bitField0_ |= 0x40;
            this.defaultValue_ = descriptorProtos$FieldDescriptorProto.defaultValue_;
            this.onChanged();
        }
        if (descriptorProtos$FieldDescriptorProto.hasOneofIndex()) {
            this.setOneofIndex(descriptorProtos$FieldDescriptorProto.getOneofIndex());
        }
        if (descriptorProtos$FieldDescriptorProto.hasOptions()) {
            this.mergeOptions(descriptorProtos$FieldDescriptorProto.getOptions());
        }
        this.mergeUnknownFields(descriptorProtos$FieldDescriptorProto.unknownFields);
        this.onChanged();
        return this;
    }
    
    public final boolean isInitialized() {
        return !this.hasOptions() || this.getOptions().isInitialized();
    }
    
    public DescriptorProtos$FieldDescriptorProto$Builder mergeFrom(final CodedInputStream codedInputStream, final ExtensionRegistryLite extensionRegistryLite) {
        DescriptorProtos$FieldDescriptorProto descriptorProtos$FieldDescriptorProto = null;
        try {
            descriptorProtos$FieldDescriptorProto = (DescriptorProtos$FieldDescriptorProto)DescriptorProtos$FieldDescriptorProto.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
        }
        catch (InvalidProtocolBufferException ex) {
            descriptorProtos$FieldDescriptorProto = (DescriptorProtos$FieldDescriptorProto)ex.getUnfinishedMessage();
            throw ex;
        }
        finally {
            if (descriptorProtos$FieldDescriptorProto != null) {
                this.mergeFrom(descriptorProtos$FieldDescriptorProto);
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
    
    public DescriptorProtos$FieldDescriptorProto$Builder setName(final String name_) {
        if (name_ == null) {
            throw new NullPointerException();
        }
        this.bitField0_ |= 0x1;
        this.name_ = name_;
        this.onChanged();
        return this;
    }
    
    public DescriptorProtos$FieldDescriptorProto$Builder clearName() {
        this.bitField0_ &= 0xFFFFFFFE;
        this.name_ = DescriptorProtos$FieldDescriptorProto.getDefaultInstance().getName();
        this.onChanged();
        return this;
    }
    
    public DescriptorProtos$FieldDescriptorProto$Builder setNameBytes(final ByteString name_) {
        if (name_ == null) {
            throw new NullPointerException();
        }
        this.bitField0_ |= 0x1;
        this.name_ = name_;
        this.onChanged();
        return this;
    }
    
    public boolean hasNumber() {
        return (this.bitField0_ & 0x2) == 0x2;
    }
    
    public int getNumber() {
        return this.number_;
    }
    
    public DescriptorProtos$FieldDescriptorProto$Builder setNumber(final int number_) {
        this.bitField0_ |= 0x2;
        this.number_ = number_;
        this.onChanged();
        return this;
    }
    
    public DescriptorProtos$FieldDescriptorProto$Builder clearNumber() {
        this.bitField0_ &= 0xFFFFFFFD;
        this.number_ = 0;
        this.onChanged();
        return this;
    }
    
    public boolean hasLabel() {
        return (this.bitField0_ & 0x4) == 0x4;
    }
    
    public DescriptorProtos$FieldDescriptorProto$Label getLabel() {
        final DescriptorProtos$FieldDescriptorProto$Label value = DescriptorProtos$FieldDescriptorProto$Label.valueOf(this.label_);
        return (value == null) ? DescriptorProtos$FieldDescriptorProto$Label.LABEL_OPTIONAL : value;
    }
    
    public DescriptorProtos$FieldDescriptorProto$Builder setLabel(final DescriptorProtos$FieldDescriptorProto$Label descriptorProtos$FieldDescriptorProto$Label) {
        if (descriptorProtos$FieldDescriptorProto$Label == null) {
            throw new NullPointerException();
        }
        this.bitField0_ |= 0x4;
        this.label_ = descriptorProtos$FieldDescriptorProto$Label.getNumber();
        this.onChanged();
        return this;
    }
    
    public DescriptorProtos$FieldDescriptorProto$Builder clearLabel() {
        this.bitField0_ &= 0xFFFFFFFB;
        this.label_ = 1;
        this.onChanged();
        return this;
    }
    
    public boolean hasType() {
        return (this.bitField0_ & 0x8) == 0x8;
    }
    
    public DescriptorProtos$FieldDescriptorProto$Type getType() {
        final DescriptorProtos$FieldDescriptorProto$Type value = DescriptorProtos$FieldDescriptorProto$Type.valueOf(this.type_);
        return (value == null) ? DescriptorProtos$FieldDescriptorProto$Type.TYPE_DOUBLE : value;
    }
    
    public DescriptorProtos$FieldDescriptorProto$Builder setType(final DescriptorProtos$FieldDescriptorProto$Type descriptorProtos$FieldDescriptorProto$Type) {
        if (descriptorProtos$FieldDescriptorProto$Type == null) {
            throw new NullPointerException();
        }
        this.bitField0_ |= 0x8;
        this.type_ = descriptorProtos$FieldDescriptorProto$Type.getNumber();
        this.onChanged();
        return this;
    }
    
    public DescriptorProtos$FieldDescriptorProto$Builder clearType() {
        this.bitField0_ &= 0xFFFFFFF7;
        this.type_ = 1;
        this.onChanged();
        return this;
    }
    
    public boolean hasTypeName() {
        return (this.bitField0_ & 0x10) == 0x10;
    }
    
    public String getTypeName() {
        final Object typeName_ = this.typeName_;
        if (!(typeName_ instanceof String)) {
            final ByteString byteString = (ByteString)typeName_;
            final String stringUtf8 = byteString.toStringUtf8();
            if (byteString.isValidUtf8()) {
                this.typeName_ = stringUtf8;
            }
            return stringUtf8;
        }
        return (String)typeName_;
    }
    
    public ByteString getTypeNameBytes() {
        final Object typeName_ = this.typeName_;
        if (typeName_ instanceof String) {
            return (ByteString)(this.typeName_ = ByteString.copyFromUtf8((String)typeName_));
        }
        return (ByteString)typeName_;
    }
    
    public DescriptorProtos$FieldDescriptorProto$Builder setTypeName(final String typeName_) {
        if (typeName_ == null) {
            throw new NullPointerException();
        }
        this.bitField0_ |= 0x10;
        this.typeName_ = typeName_;
        this.onChanged();
        return this;
    }
    
    public DescriptorProtos$FieldDescriptorProto$Builder clearTypeName() {
        this.bitField0_ &= 0xFFFFFFEF;
        this.typeName_ = DescriptorProtos$FieldDescriptorProto.getDefaultInstance().getTypeName();
        this.onChanged();
        return this;
    }
    
    public DescriptorProtos$FieldDescriptorProto$Builder setTypeNameBytes(final ByteString typeName_) {
        if (typeName_ == null) {
            throw new NullPointerException();
        }
        this.bitField0_ |= 0x10;
        this.typeName_ = typeName_;
        this.onChanged();
        return this;
    }
    
    public boolean hasExtendee() {
        return (this.bitField0_ & 0x20) == 0x20;
    }
    
    public String getExtendee() {
        final Object extendee_ = this.extendee_;
        if (!(extendee_ instanceof String)) {
            final ByteString byteString = (ByteString)extendee_;
            final String stringUtf8 = byteString.toStringUtf8();
            if (byteString.isValidUtf8()) {
                this.extendee_ = stringUtf8;
            }
            return stringUtf8;
        }
        return (String)extendee_;
    }
    
    public ByteString getExtendeeBytes() {
        final Object extendee_ = this.extendee_;
        if (extendee_ instanceof String) {
            return (ByteString)(this.extendee_ = ByteString.copyFromUtf8((String)extendee_));
        }
        return (ByteString)extendee_;
    }
    
    public DescriptorProtos$FieldDescriptorProto$Builder setExtendee(final String extendee_) {
        if (extendee_ == null) {
            throw new NullPointerException();
        }
        this.bitField0_ |= 0x20;
        this.extendee_ = extendee_;
        this.onChanged();
        return this;
    }
    
    public DescriptorProtos$FieldDescriptorProto$Builder clearExtendee() {
        this.bitField0_ &= 0xFFFFFFDF;
        this.extendee_ = DescriptorProtos$FieldDescriptorProto.getDefaultInstance().getExtendee();
        this.onChanged();
        return this;
    }
    
    public DescriptorProtos$FieldDescriptorProto$Builder setExtendeeBytes(final ByteString extendee_) {
        if (extendee_ == null) {
            throw new NullPointerException();
        }
        this.bitField0_ |= 0x20;
        this.extendee_ = extendee_;
        this.onChanged();
        return this;
    }
    
    public boolean hasDefaultValue() {
        return (this.bitField0_ & 0x40) == 0x40;
    }
    
    public String getDefaultValue() {
        final Object defaultValue_ = this.defaultValue_;
        if (!(defaultValue_ instanceof String)) {
            final ByteString byteString = (ByteString)defaultValue_;
            final String stringUtf8 = byteString.toStringUtf8();
            if (byteString.isValidUtf8()) {
                this.defaultValue_ = stringUtf8;
            }
            return stringUtf8;
        }
        return (String)defaultValue_;
    }
    
    public ByteString getDefaultValueBytes() {
        final Object defaultValue_ = this.defaultValue_;
        if (defaultValue_ instanceof String) {
            return (ByteString)(this.defaultValue_ = ByteString.copyFromUtf8((String)defaultValue_));
        }
        return (ByteString)defaultValue_;
    }
    
    public DescriptorProtos$FieldDescriptorProto$Builder setDefaultValue(final String defaultValue_) {
        if (defaultValue_ == null) {
            throw new NullPointerException();
        }
        this.bitField0_ |= 0x40;
        this.defaultValue_ = defaultValue_;
        this.onChanged();
        return this;
    }
    
    public DescriptorProtos$FieldDescriptorProto$Builder clearDefaultValue() {
        this.bitField0_ &= 0xFFFFFFBF;
        this.defaultValue_ = DescriptorProtos$FieldDescriptorProto.getDefaultInstance().getDefaultValue();
        this.onChanged();
        return this;
    }
    
    public DescriptorProtos$FieldDescriptorProto$Builder setDefaultValueBytes(final ByteString defaultValue_) {
        if (defaultValue_ == null) {
            throw new NullPointerException();
        }
        this.bitField0_ |= 0x40;
        this.defaultValue_ = defaultValue_;
        this.onChanged();
        return this;
    }
    
    public boolean hasOneofIndex() {
        return (this.bitField0_ & 0x80) == 0x80;
    }
    
    public int getOneofIndex() {
        return this.oneofIndex_;
    }
    
    public DescriptorProtos$FieldDescriptorProto$Builder setOneofIndex(final int oneofIndex_) {
        this.bitField0_ |= 0x80;
        this.oneofIndex_ = oneofIndex_;
        this.onChanged();
        return this;
    }
    
    public DescriptorProtos$FieldDescriptorProto$Builder clearOneofIndex() {
        this.bitField0_ &= 0xFFFFFF7F;
        this.oneofIndex_ = 0;
        this.onChanged();
        return this;
    }
    
    public boolean hasOptions() {
        return (this.bitField0_ & 0x100) == 0x100;
    }
    
    public DescriptorProtos$FieldOptions getOptions() {
        if (this.optionsBuilder_ == null) {
            return (this.options_ == null) ? DescriptorProtos$FieldOptions.getDefaultInstance() : this.options_;
        }
        return (DescriptorProtos$FieldOptions)this.optionsBuilder_.getMessage();
    }
    
    public DescriptorProtos$FieldDescriptorProto$Builder setOptions(final DescriptorProtos$FieldOptions descriptorProtos$FieldOptions) {
        if (this.optionsBuilder_ == null) {
            if (descriptorProtos$FieldOptions == null) {
                throw new NullPointerException();
            }
            this.options_ = descriptorProtos$FieldOptions;
            this.onChanged();
        }
        else {
            this.optionsBuilder_.setMessage(descriptorProtos$FieldOptions);
        }
        this.bitField0_ |= 0x100;
        return this;
    }
    
    public DescriptorProtos$FieldDescriptorProto$Builder setOptions(final DescriptorProtos$FieldOptions$Builder descriptorProtos$FieldOptions$Builder) {
        if (this.optionsBuilder_ == null) {
            this.options_ = descriptorProtos$FieldOptions$Builder.build();
            this.onChanged();
        }
        else {
            this.optionsBuilder_.setMessage(descriptorProtos$FieldOptions$Builder.build());
        }
        this.bitField0_ |= 0x100;
        return this;
    }
    
    public DescriptorProtos$FieldDescriptorProto$Builder mergeOptions(final DescriptorProtos$FieldOptions options_) {
        if (this.optionsBuilder_ == null) {
            if ((this.bitField0_ & 0x100) == 0x100 && this.options_ != null && this.options_ != DescriptorProtos$FieldOptions.getDefaultInstance()) {
                this.options_ = DescriptorProtos$FieldOptions.newBuilder(this.options_).mergeFrom(options_).buildPartial();
            }
            else {
                this.options_ = options_;
            }
            this.onChanged();
        }
        else {
            this.optionsBuilder_.mergeFrom(options_);
        }
        this.bitField0_ |= 0x100;
        return this;
    }
    
    public DescriptorProtos$FieldDescriptorProto$Builder clearOptions() {
        if (this.optionsBuilder_ == null) {
            this.options_ = null;
            this.onChanged();
        }
        else {
            this.optionsBuilder_.clear();
        }
        this.bitField0_ &= 0xFFFFFEFF;
        return this;
    }
    
    public DescriptorProtos$FieldOptions$Builder getOptionsBuilder() {
        this.bitField0_ |= 0x100;
        this.onChanged();
        return (DescriptorProtos$FieldOptions$Builder)this.getOptionsFieldBuilder().getBuilder();
    }
    
    public DescriptorProtos$FieldOptionsOrBuilder getOptionsOrBuilder() {
        if (this.optionsBuilder_ != null) {
            return (DescriptorProtos$FieldOptionsOrBuilder)this.optionsBuilder_.getMessageOrBuilder();
        }
        return (this.options_ == null) ? DescriptorProtos$FieldOptions.getDefaultInstance() : this.options_;
    }
    
    private SingleFieldBuilder getOptionsFieldBuilder() {
        if (this.optionsBuilder_ == null) {
            this.optionsBuilder_ = new SingleFieldBuilder(this.getOptions(), this.getParentForChildren(), this.isClean());
            this.options_ = null;
        }
        return this.optionsBuilder_;
    }
}
