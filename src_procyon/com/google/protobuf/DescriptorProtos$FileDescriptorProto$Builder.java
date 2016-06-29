package com.google.protobuf;

import java.util.*;
import java.io.*;

public final class DescriptorProtos$FileDescriptorProto$Builder extends GeneratedMessage$Builder implements DescriptorProtos$FileDescriptorProtoOrBuilder
{
    private int bitField0_;
    private Object name_;
    private Object package_;
    private LazyStringList dependency_;
    private List publicDependency_;
    private List weakDependency_;
    private List messageType_;
    private RepeatedFieldBuilder messageTypeBuilder_;
    private List enumType_;
    private RepeatedFieldBuilder enumTypeBuilder_;
    private List service_;
    private RepeatedFieldBuilder serviceBuilder_;
    private List extension_;
    private RepeatedFieldBuilder extensionBuilder_;
    private DescriptorProtos$FileOptions options_;
    private SingleFieldBuilder optionsBuilder_;
    private DescriptorProtos$SourceCodeInfo sourceCodeInfo_;
    private SingleFieldBuilder sourceCodeInfoBuilder_;
    private Object syntax_;
    
    public static final Descriptors$Descriptor getDescriptor() {
        return DescriptorProtos.internal_static_google_protobuf_FileDescriptorProto_descriptor;
    }
    
    protected GeneratedMessage$FieldAccessorTable internalGetFieldAccessorTable() {
        return DescriptorProtos.internal_static_google_protobuf_FileDescriptorProto_fieldAccessorTable.ensureFieldAccessorsInitialized(DescriptorProtos$FileDescriptorProto.class, DescriptorProtos$FileDescriptorProto$Builder.class);
    }
    
    private DescriptorProtos$FileDescriptorProto$Builder() {
        this.name_ = "";
        this.package_ = "";
        this.dependency_ = LazyStringArrayList.EMPTY;
        this.publicDependency_ = Collections.emptyList();
        this.weakDependency_ = Collections.emptyList();
        this.messageType_ = Collections.emptyList();
        this.enumType_ = Collections.emptyList();
        this.service_ = Collections.emptyList();
        this.extension_ = Collections.emptyList();
        this.options_ = null;
        this.sourceCodeInfo_ = null;
        this.syntax_ = "";
        this.maybeForceBuilderInitialization();
    }
    
    private DescriptorProtos$FileDescriptorProto$Builder(final GeneratedMessage$BuilderParent generatedMessage$BuilderParent) {
        super(generatedMessage$BuilderParent);
        this.name_ = "";
        this.package_ = "";
        this.dependency_ = LazyStringArrayList.EMPTY;
        this.publicDependency_ = Collections.emptyList();
        this.weakDependency_ = Collections.emptyList();
        this.messageType_ = Collections.emptyList();
        this.enumType_ = Collections.emptyList();
        this.service_ = Collections.emptyList();
        this.extension_ = Collections.emptyList();
        this.options_ = null;
        this.sourceCodeInfo_ = null;
        this.syntax_ = "";
        this.maybeForceBuilderInitialization();
    }
    
    private void maybeForceBuilderInitialization() {
        if (GeneratedMessage.alwaysUseFieldBuilders) {
            this.getMessageTypeFieldBuilder();
            this.getEnumTypeFieldBuilder();
            this.getServiceFieldBuilder();
            this.getExtensionFieldBuilder();
            this.getOptionsFieldBuilder();
            this.getSourceCodeInfoFieldBuilder();
        }
    }
    
    public DescriptorProtos$FileDescriptorProto$Builder clear() {
        super.clear();
        this.name_ = "";
        this.bitField0_ &= 0xFFFFFFFE;
        this.package_ = "";
        this.bitField0_ &= 0xFFFFFFFD;
        this.dependency_ = LazyStringArrayList.EMPTY;
        this.bitField0_ &= 0xFFFFFFFB;
        this.publicDependency_ = Collections.emptyList();
        this.bitField0_ &= 0xFFFFFFF7;
        this.weakDependency_ = Collections.emptyList();
        this.bitField0_ &= 0xFFFFFFEF;
        if (this.messageTypeBuilder_ == null) {
            this.messageType_ = Collections.emptyList();
            this.bitField0_ &= 0xFFFFFFDF;
        }
        else {
            this.messageTypeBuilder_.clear();
        }
        if (this.enumTypeBuilder_ == null) {
            this.enumType_ = Collections.emptyList();
            this.bitField0_ &= 0xFFFFFFBF;
        }
        else {
            this.enumTypeBuilder_.clear();
        }
        if (this.serviceBuilder_ == null) {
            this.service_ = Collections.emptyList();
            this.bitField0_ &= 0xFFFFFF7F;
        }
        else {
            this.serviceBuilder_.clear();
        }
        if (this.extensionBuilder_ == null) {
            this.extension_ = Collections.emptyList();
            this.bitField0_ &= 0xFFFFFEFF;
        }
        else {
            this.extensionBuilder_.clear();
        }
        if (this.optionsBuilder_ == null) {
            this.options_ = null;
        }
        else {
            this.optionsBuilder_.clear();
        }
        this.bitField0_ &= 0xFFFFFDFF;
        if (this.sourceCodeInfoBuilder_ == null) {
            this.sourceCodeInfo_ = null;
        }
        else {
            this.sourceCodeInfoBuilder_.clear();
        }
        this.bitField0_ &= 0xFFFFFBFF;
        this.syntax_ = "";
        this.bitField0_ &= 0xFFFFF7FF;
        return this;
    }
    
    public Descriptors$Descriptor getDescriptorForType() {
        return DescriptorProtos.internal_static_google_protobuf_FileDescriptorProto_descriptor;
    }
    
    public DescriptorProtos$FileDescriptorProto getDefaultInstanceForType() {
        return DescriptorProtos$FileDescriptorProto.getDefaultInstance();
    }
    
    public DescriptorProtos$FileDescriptorProto build() {
        final DescriptorProtos$FileDescriptorProto buildPartial = this.buildPartial();
        if (!buildPartial.isInitialized()) {
            throw AbstractMessage$Builder.newUninitializedMessageException(buildPartial);
        }
        return buildPartial;
    }
    
    public DescriptorProtos$FileDescriptorProto buildPartial() {
        final DescriptorProtos$FileDescriptorProto descriptorProtos$FileDescriptorProto = new DescriptorProtos$FileDescriptorProto(this, null);
        final int bitField0_ = this.bitField0_;
        int n = 0;
        if ((bitField0_ & 0x1) == 0x1) {
            n |= 0x1;
        }
        descriptorProtos$FileDescriptorProto.name_ = this.name_;
        if ((bitField0_ & 0x2) == 0x2) {
            n |= 0x2;
        }
        descriptorProtos$FileDescriptorProto.package_ = this.package_;
        if ((this.bitField0_ & 0x4) == 0x4) {
            this.dependency_ = this.dependency_.getUnmodifiableView();
            this.bitField0_ &= 0xFFFFFFFB;
        }
        descriptorProtos$FileDescriptorProto.dependency_ = this.dependency_;
        if ((this.bitField0_ & 0x8) == 0x8) {
            this.publicDependency_ = Collections.unmodifiableList((List<?>)this.publicDependency_);
            this.bitField0_ &= 0xFFFFFFF7;
        }
        descriptorProtos$FileDescriptorProto.publicDependency_ = this.publicDependency_;
        if ((this.bitField0_ & 0x10) == 0x10) {
            this.weakDependency_ = Collections.unmodifiableList((List<?>)this.weakDependency_);
            this.bitField0_ &= 0xFFFFFFEF;
        }
        descriptorProtos$FileDescriptorProto.weakDependency_ = this.weakDependency_;
        if (this.messageTypeBuilder_ == null) {
            if ((this.bitField0_ & 0x20) == 0x20) {
                this.messageType_ = Collections.unmodifiableList((List<?>)this.messageType_);
                this.bitField0_ &= 0xFFFFFFDF;
            }
            descriptorProtos$FileDescriptorProto.messageType_ = this.messageType_;
        }
        else {
            descriptorProtos$FileDescriptorProto.messageType_ = this.messageTypeBuilder_.build();
        }
        if (this.enumTypeBuilder_ == null) {
            if ((this.bitField0_ & 0x40) == 0x40) {
                this.enumType_ = Collections.unmodifiableList((List<?>)this.enumType_);
                this.bitField0_ &= 0xFFFFFFBF;
            }
            descriptorProtos$FileDescriptorProto.enumType_ = this.enumType_;
        }
        else {
            descriptorProtos$FileDescriptorProto.enumType_ = this.enumTypeBuilder_.build();
        }
        if (this.serviceBuilder_ == null) {
            if ((this.bitField0_ & 0x80) == 0x80) {
                this.service_ = Collections.unmodifiableList((List<?>)this.service_);
                this.bitField0_ &= 0xFFFFFF7F;
            }
            descriptorProtos$FileDescriptorProto.service_ = this.service_;
        }
        else {
            descriptorProtos$FileDescriptorProto.service_ = this.serviceBuilder_.build();
        }
        if (this.extensionBuilder_ == null) {
            if ((this.bitField0_ & 0x100) == 0x100) {
                this.extension_ = Collections.unmodifiableList((List<?>)this.extension_);
                this.bitField0_ &= 0xFFFFFEFF;
            }
            descriptorProtos$FileDescriptorProto.extension_ = this.extension_;
        }
        else {
            descriptorProtos$FileDescriptorProto.extension_ = this.extensionBuilder_.build();
        }
        if ((bitField0_ & 0x200) == 0x200) {
            n |= 0x4;
        }
        if (this.optionsBuilder_ == null) {
            descriptorProtos$FileDescriptorProto.options_ = this.options_;
        }
        else {
            descriptorProtos$FileDescriptorProto.options_ = (DescriptorProtos$FileOptions)this.optionsBuilder_.build();
        }
        if ((bitField0_ & 0x400) == 0x400) {
            n |= 0x8;
        }
        if (this.sourceCodeInfoBuilder_ == null) {
            descriptorProtos$FileDescriptorProto.sourceCodeInfo_ = this.sourceCodeInfo_;
        }
        else {
            descriptorProtos$FileDescriptorProto.sourceCodeInfo_ = (DescriptorProtos$SourceCodeInfo)this.sourceCodeInfoBuilder_.build();
        }
        if ((bitField0_ & 0x800) == 0x800) {
            n |= 0x10;
        }
        descriptorProtos$FileDescriptorProto.syntax_ = this.syntax_;
        descriptorProtos$FileDescriptorProto.bitField0_ = n;
        this.onBuilt();
        return descriptorProtos$FileDescriptorProto;
    }
    
    public DescriptorProtos$FileDescriptorProto$Builder mergeFrom(final Message message) {
        if (message instanceof DescriptorProtos$FileDescriptorProto) {
            return this.mergeFrom((DescriptorProtos$FileDescriptorProto)message);
        }
        super.mergeFrom(message);
        return this;
    }
    
    public DescriptorProtos$FileDescriptorProto$Builder mergeFrom(final DescriptorProtos$FileDescriptorProto descriptorProtos$FileDescriptorProto) {
        if (descriptorProtos$FileDescriptorProto == DescriptorProtos$FileDescriptorProto.getDefaultInstance()) {
            return this;
        }
        if (descriptorProtos$FileDescriptorProto.hasName()) {
            this.bitField0_ |= 0x1;
            this.name_ = descriptorProtos$FileDescriptorProto.name_;
            this.onChanged();
        }
        if (descriptorProtos$FileDescriptorProto.hasPackage()) {
            this.bitField0_ |= 0x2;
            this.package_ = descriptorProtos$FileDescriptorProto.package_;
            this.onChanged();
        }
        if (!descriptorProtos$FileDescriptorProto.dependency_.isEmpty()) {
            if (this.dependency_.isEmpty()) {
                this.dependency_ = descriptorProtos$FileDescriptorProto.dependency_;
                this.bitField0_ &= 0xFFFFFFFB;
            }
            else {
                this.ensureDependencyIsMutable();
                this.dependency_.addAll(descriptorProtos$FileDescriptorProto.dependency_);
            }
            this.onChanged();
        }
        if (!descriptorProtos$FileDescriptorProto.publicDependency_.isEmpty()) {
            if (this.publicDependency_.isEmpty()) {
                this.publicDependency_ = descriptorProtos$FileDescriptorProto.publicDependency_;
                this.bitField0_ &= 0xFFFFFFF7;
            }
            else {
                this.ensurePublicDependencyIsMutable();
                this.publicDependency_.addAll(descriptorProtos$FileDescriptorProto.publicDependency_);
            }
            this.onChanged();
        }
        if (!descriptorProtos$FileDescriptorProto.weakDependency_.isEmpty()) {
            if (this.weakDependency_.isEmpty()) {
                this.weakDependency_ = descriptorProtos$FileDescriptorProto.weakDependency_;
                this.bitField0_ &= 0xFFFFFFEF;
            }
            else {
                this.ensureWeakDependencyIsMutable();
                this.weakDependency_.addAll(descriptorProtos$FileDescriptorProto.weakDependency_);
            }
            this.onChanged();
        }
        if (this.messageTypeBuilder_ == null) {
            if (!descriptorProtos$FileDescriptorProto.messageType_.isEmpty()) {
                if (this.messageType_.isEmpty()) {
                    this.messageType_ = descriptorProtos$FileDescriptorProto.messageType_;
                    this.bitField0_ &= 0xFFFFFFDF;
                }
                else {
                    this.ensureMessageTypeIsMutable();
                    this.messageType_.addAll(descriptorProtos$FileDescriptorProto.messageType_);
                }
                this.onChanged();
            }
        }
        else if (!descriptorProtos$FileDescriptorProto.messageType_.isEmpty()) {
            if (this.messageTypeBuilder_.isEmpty()) {
                this.messageTypeBuilder_.dispose();
                this.messageTypeBuilder_ = null;
                this.messageType_ = descriptorProtos$FileDescriptorProto.messageType_;
                this.bitField0_ &= 0xFFFFFFDF;
                this.messageTypeBuilder_ = (GeneratedMessage.alwaysUseFieldBuilders ? this.getMessageTypeFieldBuilder() : null);
            }
            else {
                this.messageTypeBuilder_.addAllMessages(descriptorProtos$FileDescriptorProto.messageType_);
            }
        }
        if (this.enumTypeBuilder_ == null) {
            if (!descriptorProtos$FileDescriptorProto.enumType_.isEmpty()) {
                if (this.enumType_.isEmpty()) {
                    this.enumType_ = descriptorProtos$FileDescriptorProto.enumType_;
                    this.bitField0_ &= 0xFFFFFFBF;
                }
                else {
                    this.ensureEnumTypeIsMutable();
                    this.enumType_.addAll(descriptorProtos$FileDescriptorProto.enumType_);
                }
                this.onChanged();
            }
        }
        else if (!descriptorProtos$FileDescriptorProto.enumType_.isEmpty()) {
            if (this.enumTypeBuilder_.isEmpty()) {
                this.enumTypeBuilder_.dispose();
                this.enumTypeBuilder_ = null;
                this.enumType_ = descriptorProtos$FileDescriptorProto.enumType_;
                this.bitField0_ &= 0xFFFFFFBF;
                this.enumTypeBuilder_ = (GeneratedMessage.alwaysUseFieldBuilders ? this.getEnumTypeFieldBuilder() : null);
            }
            else {
                this.enumTypeBuilder_.addAllMessages(descriptorProtos$FileDescriptorProto.enumType_);
            }
        }
        if (this.serviceBuilder_ == null) {
            if (!descriptorProtos$FileDescriptorProto.service_.isEmpty()) {
                if (this.service_.isEmpty()) {
                    this.service_ = descriptorProtos$FileDescriptorProto.service_;
                    this.bitField0_ &= 0xFFFFFF7F;
                }
                else {
                    this.ensureServiceIsMutable();
                    this.service_.addAll(descriptorProtos$FileDescriptorProto.service_);
                }
                this.onChanged();
            }
        }
        else if (!descriptorProtos$FileDescriptorProto.service_.isEmpty()) {
            if (this.serviceBuilder_.isEmpty()) {
                this.serviceBuilder_.dispose();
                this.serviceBuilder_ = null;
                this.service_ = descriptorProtos$FileDescriptorProto.service_;
                this.bitField0_ &= 0xFFFFFF7F;
                this.serviceBuilder_ = (GeneratedMessage.alwaysUseFieldBuilders ? this.getServiceFieldBuilder() : null);
            }
            else {
                this.serviceBuilder_.addAllMessages(descriptorProtos$FileDescriptorProto.service_);
            }
        }
        if (this.extensionBuilder_ == null) {
            if (!descriptorProtos$FileDescriptorProto.extension_.isEmpty()) {
                if (this.extension_.isEmpty()) {
                    this.extension_ = descriptorProtos$FileDescriptorProto.extension_;
                    this.bitField0_ &= 0xFFFFFEFF;
                }
                else {
                    this.ensureExtensionIsMutable();
                    this.extension_.addAll(descriptorProtos$FileDescriptorProto.extension_);
                }
                this.onChanged();
            }
        }
        else if (!descriptorProtos$FileDescriptorProto.extension_.isEmpty()) {
            if (this.extensionBuilder_.isEmpty()) {
                this.extensionBuilder_.dispose();
                this.extensionBuilder_ = null;
                this.extension_ = descriptorProtos$FileDescriptorProto.extension_;
                this.bitField0_ &= 0xFFFFFEFF;
                this.extensionBuilder_ = (GeneratedMessage.alwaysUseFieldBuilders ? this.getExtensionFieldBuilder() : null);
            }
            else {
                this.extensionBuilder_.addAllMessages(descriptorProtos$FileDescriptorProto.extension_);
            }
        }
        if (descriptorProtos$FileDescriptorProto.hasOptions()) {
            this.mergeOptions(descriptorProtos$FileDescriptorProto.getOptions());
        }
        if (descriptorProtos$FileDescriptorProto.hasSourceCodeInfo()) {
            this.mergeSourceCodeInfo(descriptorProtos$FileDescriptorProto.getSourceCodeInfo());
        }
        if (descriptorProtos$FileDescriptorProto.hasSyntax()) {
            this.bitField0_ |= 0x800;
            this.syntax_ = descriptorProtos$FileDescriptorProto.syntax_;
            this.onChanged();
        }
        this.mergeUnknownFields(descriptorProtos$FileDescriptorProto.unknownFields);
        this.onChanged();
        return this;
    }
    
    public final boolean isInitialized() {
        for (int i = 0; i < this.getMessageTypeCount(); ++i) {
            if (!this.getMessageType(i).isInitialized()) {
                return false;
            }
        }
        for (int j = 0; j < this.getEnumTypeCount(); ++j) {
            if (!this.getEnumType(j).isInitialized()) {
                return false;
            }
        }
        for (int k = 0; k < this.getServiceCount(); ++k) {
            if (!this.getService(k).isInitialized()) {
                return false;
            }
        }
        for (int l = 0; l < this.getExtensionCount(); ++l) {
            if (!this.getExtension(l).isInitialized()) {
                return false;
            }
        }
        return !this.hasOptions() || this.getOptions().isInitialized();
    }
    
    public DescriptorProtos$FileDescriptorProto$Builder mergeFrom(final CodedInputStream codedInputStream, final ExtensionRegistryLite extensionRegistryLite) {
        DescriptorProtos$FileDescriptorProto descriptorProtos$FileDescriptorProto = null;
        try {
            descriptorProtos$FileDescriptorProto = (DescriptorProtos$FileDescriptorProto)DescriptorProtos$FileDescriptorProto.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
        }
        catch (InvalidProtocolBufferException ex) {
            descriptorProtos$FileDescriptorProto = (DescriptorProtos$FileDescriptorProto)ex.getUnfinishedMessage();
            throw ex;
        }
        finally {
            if (descriptorProtos$FileDescriptorProto != null) {
                this.mergeFrom(descriptorProtos$FileDescriptorProto);
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
    
    public DescriptorProtos$FileDescriptorProto$Builder setName(final String name_) {
        if (name_ == null) {
            throw new NullPointerException();
        }
        this.bitField0_ |= 0x1;
        this.name_ = name_;
        this.onChanged();
        return this;
    }
    
    public DescriptorProtos$FileDescriptorProto$Builder clearName() {
        this.bitField0_ &= 0xFFFFFFFE;
        this.name_ = DescriptorProtos$FileDescriptorProto.getDefaultInstance().getName();
        this.onChanged();
        return this;
    }
    
    public DescriptorProtos$FileDescriptorProto$Builder setNameBytes(final ByteString name_) {
        if (name_ == null) {
            throw new NullPointerException();
        }
        this.bitField0_ |= 0x1;
        this.name_ = name_;
        this.onChanged();
        return this;
    }
    
    public boolean hasPackage() {
        return (this.bitField0_ & 0x2) == 0x2;
    }
    
    public String getPackage() {
        final Object package_ = this.package_;
        if (!(package_ instanceof String)) {
            final ByteString byteString = (ByteString)package_;
            final String stringUtf8 = byteString.toStringUtf8();
            if (byteString.isValidUtf8()) {
                this.package_ = stringUtf8;
            }
            return stringUtf8;
        }
        return (String)package_;
    }
    
    public ByteString getPackageBytes() {
        final Object package_ = this.package_;
        if (package_ instanceof String) {
            return (ByteString)(this.package_ = ByteString.copyFromUtf8((String)package_));
        }
        return (ByteString)package_;
    }
    
    public DescriptorProtos$FileDescriptorProto$Builder setPackage(final String package_) {
        if (package_ == null) {
            throw new NullPointerException();
        }
        this.bitField0_ |= 0x2;
        this.package_ = package_;
        this.onChanged();
        return this;
    }
    
    public DescriptorProtos$FileDescriptorProto$Builder clearPackage() {
        this.bitField0_ &= 0xFFFFFFFD;
        this.package_ = DescriptorProtos$FileDescriptorProto.getDefaultInstance().getPackage();
        this.onChanged();
        return this;
    }
    
    public DescriptorProtos$FileDescriptorProto$Builder setPackageBytes(final ByteString package_) {
        if (package_ == null) {
            throw new NullPointerException();
        }
        this.bitField0_ |= 0x2;
        this.package_ = package_;
        this.onChanged();
        return this;
    }
    
    private void ensureDependencyIsMutable() {
        if ((this.bitField0_ & 0x4) != 0x4) {
            this.dependency_ = new LazyStringArrayList(this.dependency_);
            this.bitField0_ |= 0x4;
        }
    }
    
    public ProtocolStringList getDependencyList() {
        return this.dependency_.getUnmodifiableView();
    }
    
    public int getDependencyCount() {
        return this.dependency_.size();
    }
    
    public String getDependency(final int n) {
        return this.dependency_.get(n);
    }
    
    public ByteString getDependencyBytes(final int n) {
        return this.dependency_.getByteString(n);
    }
    
    public DescriptorProtos$FileDescriptorProto$Builder setDependency(final int n, final String s) {
        if (s == null) {
            throw new NullPointerException();
        }
        this.ensureDependencyIsMutable();
        this.dependency_.set(n, s);
        this.onChanged();
        return this;
    }
    
    public DescriptorProtos$FileDescriptorProto$Builder addDependency(final String s) {
        if (s == null) {
            throw new NullPointerException();
        }
        this.ensureDependencyIsMutable();
        this.dependency_.add(s);
        this.onChanged();
        return this;
    }
    
    public DescriptorProtos$FileDescriptorProto$Builder addAllDependency(final Iterable iterable) {
        this.ensureDependencyIsMutable();
        AbstractMessageLite$Builder.addAll(iterable, this.dependency_);
        this.onChanged();
        return this;
    }
    
    public DescriptorProtos$FileDescriptorProto$Builder clearDependency() {
        this.dependency_ = LazyStringArrayList.EMPTY;
        this.bitField0_ &= 0xFFFFFFFB;
        this.onChanged();
        return this;
    }
    
    public DescriptorProtos$FileDescriptorProto$Builder addDependencyBytes(final ByteString byteString) {
        if (byteString == null) {
            throw new NullPointerException();
        }
        this.ensureDependencyIsMutable();
        this.dependency_.add(byteString);
        this.onChanged();
        return this;
    }
    
    private void ensurePublicDependencyIsMutable() {
        if ((this.bitField0_ & 0x8) != 0x8) {
            this.publicDependency_ = new ArrayList(this.publicDependency_);
            this.bitField0_ |= 0x8;
        }
    }
    
    public List getPublicDependencyList() {
        return Collections.unmodifiableList((List<?>)this.publicDependency_);
    }
    
    public int getPublicDependencyCount() {
        return this.publicDependency_.size();
    }
    
    public int getPublicDependency(final int n) {
        return this.publicDependency_.get(n);
    }
    
    public DescriptorProtos$FileDescriptorProto$Builder setPublicDependency(final int n, final int n2) {
        this.ensurePublicDependencyIsMutable();
        this.publicDependency_.set(n, n2);
        this.onChanged();
        return this;
    }
    
    public DescriptorProtos$FileDescriptorProto$Builder addPublicDependency(final int n) {
        this.ensurePublicDependencyIsMutable();
        this.publicDependency_.add(n);
        this.onChanged();
        return this;
    }
    
    public DescriptorProtos$FileDescriptorProto$Builder addAllPublicDependency(final Iterable iterable) {
        this.ensurePublicDependencyIsMutable();
        AbstractMessageLite$Builder.addAll(iterable, this.publicDependency_);
        this.onChanged();
        return this;
    }
    
    public DescriptorProtos$FileDescriptorProto$Builder clearPublicDependency() {
        this.publicDependency_ = Collections.emptyList();
        this.bitField0_ &= 0xFFFFFFF7;
        this.onChanged();
        return this;
    }
    
    private void ensureWeakDependencyIsMutable() {
        if ((this.bitField0_ & 0x10) != 0x10) {
            this.weakDependency_ = new ArrayList(this.weakDependency_);
            this.bitField0_ |= 0x10;
        }
    }
    
    public List getWeakDependencyList() {
        return Collections.unmodifiableList((List<?>)this.weakDependency_);
    }
    
    public int getWeakDependencyCount() {
        return this.weakDependency_.size();
    }
    
    public int getWeakDependency(final int n) {
        return this.weakDependency_.get(n);
    }
    
    public DescriptorProtos$FileDescriptorProto$Builder setWeakDependency(final int n, final int n2) {
        this.ensureWeakDependencyIsMutable();
        this.weakDependency_.set(n, n2);
        this.onChanged();
        return this;
    }
    
    public DescriptorProtos$FileDescriptorProto$Builder addWeakDependency(final int n) {
        this.ensureWeakDependencyIsMutable();
        this.weakDependency_.add(n);
        this.onChanged();
        return this;
    }
    
    public DescriptorProtos$FileDescriptorProto$Builder addAllWeakDependency(final Iterable iterable) {
        this.ensureWeakDependencyIsMutable();
        AbstractMessageLite$Builder.addAll(iterable, this.weakDependency_);
        this.onChanged();
        return this;
    }
    
    public DescriptorProtos$FileDescriptorProto$Builder clearWeakDependency() {
        this.weakDependency_ = Collections.emptyList();
        this.bitField0_ &= 0xFFFFFFEF;
        this.onChanged();
        return this;
    }
    
    private void ensureMessageTypeIsMutable() {
        if ((this.bitField0_ & 0x20) != 0x20) {
            this.messageType_ = new ArrayList(this.messageType_);
            this.bitField0_ |= 0x20;
        }
    }
    
    public List getMessageTypeList() {
        if (this.messageTypeBuilder_ == null) {
            return Collections.unmodifiableList((List<?>)this.messageType_);
        }
        return this.messageTypeBuilder_.getMessageList();
    }
    
    public int getMessageTypeCount() {
        if (this.messageTypeBuilder_ == null) {
            return this.messageType_.size();
        }
        return this.messageTypeBuilder_.getCount();
    }
    
    public DescriptorProtos$DescriptorProto getMessageType(final int n) {
        if (this.messageTypeBuilder_ == null) {
            return this.messageType_.get(n);
        }
        return (DescriptorProtos$DescriptorProto)this.messageTypeBuilder_.getMessage(n);
    }
    
    public DescriptorProtos$FileDescriptorProto$Builder setMessageType(final int n, final DescriptorProtos$DescriptorProto descriptorProtos$DescriptorProto) {
        if (this.messageTypeBuilder_ == null) {
            if (descriptorProtos$DescriptorProto == null) {
                throw new NullPointerException();
            }
            this.ensureMessageTypeIsMutable();
            this.messageType_.set(n, descriptorProtos$DescriptorProto);
            this.onChanged();
        }
        else {
            this.messageTypeBuilder_.setMessage(n, descriptorProtos$DescriptorProto);
        }
        return this;
    }
    
    public DescriptorProtos$FileDescriptorProto$Builder setMessageType(final int n, final DescriptorProtos$DescriptorProto$Builder descriptorProtos$DescriptorProto$Builder) {
        if (this.messageTypeBuilder_ == null) {
            this.ensureMessageTypeIsMutable();
            this.messageType_.set(n, descriptorProtos$DescriptorProto$Builder.build());
            this.onChanged();
        }
        else {
            this.messageTypeBuilder_.setMessage(n, descriptorProtos$DescriptorProto$Builder.build());
        }
        return this;
    }
    
    public DescriptorProtos$FileDescriptorProto$Builder addMessageType(final DescriptorProtos$DescriptorProto descriptorProtos$DescriptorProto) {
        if (this.messageTypeBuilder_ == null) {
            if (descriptorProtos$DescriptorProto == null) {
                throw new NullPointerException();
            }
            this.ensureMessageTypeIsMutable();
            this.messageType_.add(descriptorProtos$DescriptorProto);
            this.onChanged();
        }
        else {
            this.messageTypeBuilder_.addMessage(descriptorProtos$DescriptorProto);
        }
        return this;
    }
    
    public DescriptorProtos$FileDescriptorProto$Builder addMessageType(final int n, final DescriptorProtos$DescriptorProto descriptorProtos$DescriptorProto) {
        if (this.messageTypeBuilder_ == null) {
            if (descriptorProtos$DescriptorProto == null) {
                throw new NullPointerException();
            }
            this.ensureMessageTypeIsMutable();
            this.messageType_.add(n, descriptorProtos$DescriptorProto);
            this.onChanged();
        }
        else {
            this.messageTypeBuilder_.addMessage(n, descriptorProtos$DescriptorProto);
        }
        return this;
    }
    
    public DescriptorProtos$FileDescriptorProto$Builder addMessageType(final DescriptorProtos$DescriptorProto$Builder descriptorProtos$DescriptorProto$Builder) {
        if (this.messageTypeBuilder_ == null) {
            this.ensureMessageTypeIsMutable();
            this.messageType_.add(descriptorProtos$DescriptorProto$Builder.build());
            this.onChanged();
        }
        else {
            this.messageTypeBuilder_.addMessage(descriptorProtos$DescriptorProto$Builder.build());
        }
        return this;
    }
    
    public DescriptorProtos$FileDescriptorProto$Builder addMessageType(final int n, final DescriptorProtos$DescriptorProto$Builder descriptorProtos$DescriptorProto$Builder) {
        if (this.messageTypeBuilder_ == null) {
            this.ensureMessageTypeIsMutable();
            this.messageType_.add(n, descriptorProtos$DescriptorProto$Builder.build());
            this.onChanged();
        }
        else {
            this.messageTypeBuilder_.addMessage(n, descriptorProtos$DescriptorProto$Builder.build());
        }
        return this;
    }
    
    public DescriptorProtos$FileDescriptorProto$Builder addAllMessageType(final Iterable iterable) {
        if (this.messageTypeBuilder_ == null) {
            this.ensureMessageTypeIsMutable();
            AbstractMessageLite$Builder.addAll(iterable, this.messageType_);
            this.onChanged();
        }
        else {
            this.messageTypeBuilder_.addAllMessages(iterable);
        }
        return this;
    }
    
    public DescriptorProtos$FileDescriptorProto$Builder clearMessageType() {
        if (this.messageTypeBuilder_ == null) {
            this.messageType_ = Collections.emptyList();
            this.bitField0_ &= 0xFFFFFFDF;
            this.onChanged();
        }
        else {
            this.messageTypeBuilder_.clear();
        }
        return this;
    }
    
    public DescriptorProtos$FileDescriptorProto$Builder removeMessageType(final int n) {
        if (this.messageTypeBuilder_ == null) {
            this.ensureMessageTypeIsMutable();
            this.messageType_.remove(n);
            this.onChanged();
        }
        else {
            this.messageTypeBuilder_.remove(n);
        }
        return this;
    }
    
    public DescriptorProtos$DescriptorProto$Builder getMessageTypeBuilder(final int n) {
        return (DescriptorProtos$DescriptorProto$Builder)this.getMessageTypeFieldBuilder().getBuilder(n);
    }
    
    public DescriptorProtos$DescriptorProtoOrBuilder getMessageTypeOrBuilder(final int n) {
        if (this.messageTypeBuilder_ == null) {
            return this.messageType_.get(n);
        }
        return (DescriptorProtos$DescriptorProtoOrBuilder)this.messageTypeBuilder_.getMessageOrBuilder(n);
    }
    
    public List getMessageTypeOrBuilderList() {
        if (this.messageTypeBuilder_ != null) {
            return this.messageTypeBuilder_.getMessageOrBuilderList();
        }
        return Collections.unmodifiableList((List<?>)this.messageType_);
    }
    
    public DescriptorProtos$DescriptorProto$Builder addMessageTypeBuilder() {
        return (DescriptorProtos$DescriptorProto$Builder)this.getMessageTypeFieldBuilder().addBuilder(DescriptorProtos$DescriptorProto.getDefaultInstance());
    }
    
    public DescriptorProtos$DescriptorProto$Builder addMessageTypeBuilder(final int n) {
        return (DescriptorProtos$DescriptorProto$Builder)this.getMessageTypeFieldBuilder().addBuilder(n, DescriptorProtos$DescriptorProto.getDefaultInstance());
    }
    
    public List getMessageTypeBuilderList() {
        return this.getMessageTypeFieldBuilder().getBuilderList();
    }
    
    private RepeatedFieldBuilder getMessageTypeFieldBuilder() {
        if (this.messageTypeBuilder_ == null) {
            this.messageTypeBuilder_ = new RepeatedFieldBuilder(this.messageType_, (this.bitField0_ & 0x20) == 0x20, this.getParentForChildren(), this.isClean());
            this.messageType_ = null;
        }
        return this.messageTypeBuilder_;
    }
    
    private void ensureEnumTypeIsMutable() {
        if ((this.bitField0_ & 0x40) != 0x40) {
            this.enumType_ = new ArrayList(this.enumType_);
            this.bitField0_ |= 0x40;
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
    
    public DescriptorProtos$FileDescriptorProto$Builder setEnumType(final int n, final DescriptorProtos$EnumDescriptorProto descriptorProtos$EnumDescriptorProto) {
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
    
    public DescriptorProtos$FileDescriptorProto$Builder setEnumType(final int n, final DescriptorProtos$EnumDescriptorProto$Builder descriptorProtos$EnumDescriptorProto$Builder) {
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
    
    public DescriptorProtos$FileDescriptorProto$Builder addEnumType(final DescriptorProtos$EnumDescriptorProto descriptorProtos$EnumDescriptorProto) {
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
    
    public DescriptorProtos$FileDescriptorProto$Builder addEnumType(final int n, final DescriptorProtos$EnumDescriptorProto descriptorProtos$EnumDescriptorProto) {
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
    
    public DescriptorProtos$FileDescriptorProto$Builder addEnumType(final DescriptorProtos$EnumDescriptorProto$Builder descriptorProtos$EnumDescriptorProto$Builder) {
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
    
    public DescriptorProtos$FileDescriptorProto$Builder addEnumType(final int n, final DescriptorProtos$EnumDescriptorProto$Builder descriptorProtos$EnumDescriptorProto$Builder) {
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
    
    public DescriptorProtos$FileDescriptorProto$Builder addAllEnumType(final Iterable iterable) {
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
    
    public DescriptorProtos$FileDescriptorProto$Builder clearEnumType() {
        if (this.enumTypeBuilder_ == null) {
            this.enumType_ = Collections.emptyList();
            this.bitField0_ &= 0xFFFFFFBF;
            this.onChanged();
        }
        else {
            this.enumTypeBuilder_.clear();
        }
        return this;
    }
    
    public DescriptorProtos$FileDescriptorProto$Builder removeEnumType(final int n) {
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
            this.enumTypeBuilder_ = new RepeatedFieldBuilder(this.enumType_, (this.bitField0_ & 0x40) == 0x40, this.getParentForChildren(), this.isClean());
            this.enumType_ = null;
        }
        return this.enumTypeBuilder_;
    }
    
    private void ensureServiceIsMutable() {
        if ((this.bitField0_ & 0x80) != 0x80) {
            this.service_ = new ArrayList(this.service_);
            this.bitField0_ |= 0x80;
        }
    }
    
    public List getServiceList() {
        if (this.serviceBuilder_ == null) {
            return Collections.unmodifiableList((List<?>)this.service_);
        }
        return this.serviceBuilder_.getMessageList();
    }
    
    public int getServiceCount() {
        if (this.serviceBuilder_ == null) {
            return this.service_.size();
        }
        return this.serviceBuilder_.getCount();
    }
    
    public DescriptorProtos$ServiceDescriptorProto getService(final int n) {
        if (this.serviceBuilder_ == null) {
            return this.service_.get(n);
        }
        return (DescriptorProtos$ServiceDescriptorProto)this.serviceBuilder_.getMessage(n);
    }
    
    public DescriptorProtos$FileDescriptorProto$Builder setService(final int n, final DescriptorProtos$ServiceDescriptorProto descriptorProtos$ServiceDescriptorProto) {
        if (this.serviceBuilder_ == null) {
            if (descriptorProtos$ServiceDescriptorProto == null) {
                throw new NullPointerException();
            }
            this.ensureServiceIsMutable();
            this.service_.set(n, descriptorProtos$ServiceDescriptorProto);
            this.onChanged();
        }
        else {
            this.serviceBuilder_.setMessage(n, descriptorProtos$ServiceDescriptorProto);
        }
        return this;
    }
    
    public DescriptorProtos$FileDescriptorProto$Builder setService(final int n, final DescriptorProtos$ServiceDescriptorProto$Builder descriptorProtos$ServiceDescriptorProto$Builder) {
        if (this.serviceBuilder_ == null) {
            this.ensureServiceIsMutable();
            this.service_.set(n, descriptorProtos$ServiceDescriptorProto$Builder.build());
            this.onChanged();
        }
        else {
            this.serviceBuilder_.setMessage(n, descriptorProtos$ServiceDescriptorProto$Builder.build());
        }
        return this;
    }
    
    public DescriptorProtos$FileDescriptorProto$Builder addService(final DescriptorProtos$ServiceDescriptorProto descriptorProtos$ServiceDescriptorProto) {
        if (this.serviceBuilder_ == null) {
            if (descriptorProtos$ServiceDescriptorProto == null) {
                throw new NullPointerException();
            }
            this.ensureServiceIsMutable();
            this.service_.add(descriptorProtos$ServiceDescriptorProto);
            this.onChanged();
        }
        else {
            this.serviceBuilder_.addMessage(descriptorProtos$ServiceDescriptorProto);
        }
        return this;
    }
    
    public DescriptorProtos$FileDescriptorProto$Builder addService(final int n, final DescriptorProtos$ServiceDescriptorProto descriptorProtos$ServiceDescriptorProto) {
        if (this.serviceBuilder_ == null) {
            if (descriptorProtos$ServiceDescriptorProto == null) {
                throw new NullPointerException();
            }
            this.ensureServiceIsMutable();
            this.service_.add(n, descriptorProtos$ServiceDescriptorProto);
            this.onChanged();
        }
        else {
            this.serviceBuilder_.addMessage(n, descriptorProtos$ServiceDescriptorProto);
        }
        return this;
    }
    
    public DescriptorProtos$FileDescriptorProto$Builder addService(final DescriptorProtos$ServiceDescriptorProto$Builder descriptorProtos$ServiceDescriptorProto$Builder) {
        if (this.serviceBuilder_ == null) {
            this.ensureServiceIsMutable();
            this.service_.add(descriptorProtos$ServiceDescriptorProto$Builder.build());
            this.onChanged();
        }
        else {
            this.serviceBuilder_.addMessage(descriptorProtos$ServiceDescriptorProto$Builder.build());
        }
        return this;
    }
    
    public DescriptorProtos$FileDescriptorProto$Builder addService(final int n, final DescriptorProtos$ServiceDescriptorProto$Builder descriptorProtos$ServiceDescriptorProto$Builder) {
        if (this.serviceBuilder_ == null) {
            this.ensureServiceIsMutable();
            this.service_.add(n, descriptorProtos$ServiceDescriptorProto$Builder.build());
            this.onChanged();
        }
        else {
            this.serviceBuilder_.addMessage(n, descriptorProtos$ServiceDescriptorProto$Builder.build());
        }
        return this;
    }
    
    public DescriptorProtos$FileDescriptorProto$Builder addAllService(final Iterable iterable) {
        if (this.serviceBuilder_ == null) {
            this.ensureServiceIsMutable();
            AbstractMessageLite$Builder.addAll(iterable, this.service_);
            this.onChanged();
        }
        else {
            this.serviceBuilder_.addAllMessages(iterable);
        }
        return this;
    }
    
    public DescriptorProtos$FileDescriptorProto$Builder clearService() {
        if (this.serviceBuilder_ == null) {
            this.service_ = Collections.emptyList();
            this.bitField0_ &= 0xFFFFFF7F;
            this.onChanged();
        }
        else {
            this.serviceBuilder_.clear();
        }
        return this;
    }
    
    public DescriptorProtos$FileDescriptorProto$Builder removeService(final int n) {
        if (this.serviceBuilder_ == null) {
            this.ensureServiceIsMutable();
            this.service_.remove(n);
            this.onChanged();
        }
        else {
            this.serviceBuilder_.remove(n);
        }
        return this;
    }
    
    public DescriptorProtos$ServiceDescriptorProto$Builder getServiceBuilder(final int n) {
        return (DescriptorProtos$ServiceDescriptorProto$Builder)this.getServiceFieldBuilder().getBuilder(n);
    }
    
    public DescriptorProtos$ServiceDescriptorProtoOrBuilder getServiceOrBuilder(final int n) {
        if (this.serviceBuilder_ == null) {
            return this.service_.get(n);
        }
        return (DescriptorProtos$ServiceDescriptorProtoOrBuilder)this.serviceBuilder_.getMessageOrBuilder(n);
    }
    
    public List getServiceOrBuilderList() {
        if (this.serviceBuilder_ != null) {
            return this.serviceBuilder_.getMessageOrBuilderList();
        }
        return Collections.unmodifiableList((List<?>)this.service_);
    }
    
    public DescriptorProtos$ServiceDescriptorProto$Builder addServiceBuilder() {
        return (DescriptorProtos$ServiceDescriptorProto$Builder)this.getServiceFieldBuilder().addBuilder(DescriptorProtos$ServiceDescriptorProto.getDefaultInstance());
    }
    
    public DescriptorProtos$ServiceDescriptorProto$Builder addServiceBuilder(final int n) {
        return (DescriptorProtos$ServiceDescriptorProto$Builder)this.getServiceFieldBuilder().addBuilder(n, DescriptorProtos$ServiceDescriptorProto.getDefaultInstance());
    }
    
    public List getServiceBuilderList() {
        return this.getServiceFieldBuilder().getBuilderList();
    }
    
    private RepeatedFieldBuilder getServiceFieldBuilder() {
        if (this.serviceBuilder_ == null) {
            this.serviceBuilder_ = new RepeatedFieldBuilder(this.service_, (this.bitField0_ & 0x80) == 0x80, this.getParentForChildren(), this.isClean());
            this.service_ = null;
        }
        return this.serviceBuilder_;
    }
    
    private void ensureExtensionIsMutable() {
        if ((this.bitField0_ & 0x100) != 0x100) {
            this.extension_ = new ArrayList(this.extension_);
            this.bitField0_ |= 0x100;
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
    
    public DescriptorProtos$FileDescriptorProto$Builder setExtension(final int n, final DescriptorProtos$FieldDescriptorProto descriptorProtos$FieldDescriptorProto) {
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
    
    public DescriptorProtos$FileDescriptorProto$Builder setExtension(final int n, final DescriptorProtos$FieldDescriptorProto$Builder descriptorProtos$FieldDescriptorProto$Builder) {
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
    
    public DescriptorProtos$FileDescriptorProto$Builder addExtension(final DescriptorProtos$FieldDescriptorProto descriptorProtos$FieldDescriptorProto) {
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
    
    public DescriptorProtos$FileDescriptorProto$Builder addExtension(final int n, final DescriptorProtos$FieldDescriptorProto descriptorProtos$FieldDescriptorProto) {
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
    
    public DescriptorProtos$FileDescriptorProto$Builder addExtension(final DescriptorProtos$FieldDescriptorProto$Builder descriptorProtos$FieldDescriptorProto$Builder) {
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
    
    public DescriptorProtos$FileDescriptorProto$Builder addExtension(final int n, final DescriptorProtos$FieldDescriptorProto$Builder descriptorProtos$FieldDescriptorProto$Builder) {
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
    
    public DescriptorProtos$FileDescriptorProto$Builder addAllExtension(final Iterable iterable) {
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
    
    public DescriptorProtos$FileDescriptorProto$Builder clearExtension() {
        if (this.extensionBuilder_ == null) {
            this.extension_ = Collections.emptyList();
            this.bitField0_ &= 0xFFFFFEFF;
            this.onChanged();
        }
        else {
            this.extensionBuilder_.clear();
        }
        return this;
    }
    
    public DescriptorProtos$FileDescriptorProto$Builder removeExtension(final int n) {
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
            this.extensionBuilder_ = new RepeatedFieldBuilder(this.extension_, (this.bitField0_ & 0x100) == 0x100, this.getParentForChildren(), this.isClean());
            this.extension_ = null;
        }
        return this.extensionBuilder_;
    }
    
    public boolean hasOptions() {
        return (this.bitField0_ & 0x200) == 0x200;
    }
    
    public DescriptorProtos$FileOptions getOptions() {
        if (this.optionsBuilder_ == null) {
            return (this.options_ == null) ? DescriptorProtos$FileOptions.getDefaultInstance() : this.options_;
        }
        return (DescriptorProtos$FileOptions)this.optionsBuilder_.getMessage();
    }
    
    public DescriptorProtos$FileDescriptorProto$Builder setOptions(final DescriptorProtos$FileOptions descriptorProtos$FileOptions) {
        if (this.optionsBuilder_ == null) {
            if (descriptorProtos$FileOptions == null) {
                throw new NullPointerException();
            }
            this.options_ = descriptorProtos$FileOptions;
            this.onChanged();
        }
        else {
            this.optionsBuilder_.setMessage(descriptorProtos$FileOptions);
        }
        this.bitField0_ |= 0x200;
        return this;
    }
    
    public DescriptorProtos$FileDescriptorProto$Builder setOptions(final DescriptorProtos$FileOptions$Builder descriptorProtos$FileOptions$Builder) {
        if (this.optionsBuilder_ == null) {
            this.options_ = descriptorProtos$FileOptions$Builder.build();
            this.onChanged();
        }
        else {
            this.optionsBuilder_.setMessage(descriptorProtos$FileOptions$Builder.build());
        }
        this.bitField0_ |= 0x200;
        return this;
    }
    
    public DescriptorProtos$FileDescriptorProto$Builder mergeOptions(final DescriptorProtos$FileOptions options_) {
        if (this.optionsBuilder_ == null) {
            if ((this.bitField0_ & 0x200) == 0x200 && this.options_ != null && this.options_ != DescriptorProtos$FileOptions.getDefaultInstance()) {
                this.options_ = DescriptorProtos$FileOptions.newBuilder(this.options_).mergeFrom(options_).buildPartial();
            }
            else {
                this.options_ = options_;
            }
            this.onChanged();
        }
        else {
            this.optionsBuilder_.mergeFrom(options_);
        }
        this.bitField0_ |= 0x200;
        return this;
    }
    
    public DescriptorProtos$FileDescriptorProto$Builder clearOptions() {
        if (this.optionsBuilder_ == null) {
            this.options_ = null;
            this.onChanged();
        }
        else {
            this.optionsBuilder_.clear();
        }
        this.bitField0_ &= 0xFFFFFDFF;
        return this;
    }
    
    public DescriptorProtos$FileOptions$Builder getOptionsBuilder() {
        this.bitField0_ |= 0x200;
        this.onChanged();
        return (DescriptorProtos$FileOptions$Builder)this.getOptionsFieldBuilder().getBuilder();
    }
    
    public DescriptorProtos$FileOptionsOrBuilder getOptionsOrBuilder() {
        if (this.optionsBuilder_ != null) {
            return (DescriptorProtos$FileOptionsOrBuilder)this.optionsBuilder_.getMessageOrBuilder();
        }
        return (this.options_ == null) ? DescriptorProtos$FileOptions.getDefaultInstance() : this.options_;
    }
    
    private SingleFieldBuilder getOptionsFieldBuilder() {
        if (this.optionsBuilder_ == null) {
            this.optionsBuilder_ = new SingleFieldBuilder(this.getOptions(), this.getParentForChildren(), this.isClean());
            this.options_ = null;
        }
        return this.optionsBuilder_;
    }
    
    public boolean hasSourceCodeInfo() {
        return (this.bitField0_ & 0x400) == 0x400;
    }
    
    public DescriptorProtos$SourceCodeInfo getSourceCodeInfo() {
        if (this.sourceCodeInfoBuilder_ == null) {
            return (this.sourceCodeInfo_ == null) ? DescriptorProtos$SourceCodeInfo.getDefaultInstance() : this.sourceCodeInfo_;
        }
        return (DescriptorProtos$SourceCodeInfo)this.sourceCodeInfoBuilder_.getMessage();
    }
    
    public DescriptorProtos$FileDescriptorProto$Builder setSourceCodeInfo(final DescriptorProtos$SourceCodeInfo descriptorProtos$SourceCodeInfo) {
        if (this.sourceCodeInfoBuilder_ == null) {
            if (descriptorProtos$SourceCodeInfo == null) {
                throw new NullPointerException();
            }
            this.sourceCodeInfo_ = descriptorProtos$SourceCodeInfo;
            this.onChanged();
        }
        else {
            this.sourceCodeInfoBuilder_.setMessage(descriptorProtos$SourceCodeInfo);
        }
        this.bitField0_ |= 0x400;
        return this;
    }
    
    public DescriptorProtos$FileDescriptorProto$Builder setSourceCodeInfo(final DescriptorProtos$SourceCodeInfo$Builder descriptorProtos$SourceCodeInfo$Builder) {
        if (this.sourceCodeInfoBuilder_ == null) {
            this.sourceCodeInfo_ = descriptorProtos$SourceCodeInfo$Builder.build();
            this.onChanged();
        }
        else {
            this.sourceCodeInfoBuilder_.setMessage(descriptorProtos$SourceCodeInfo$Builder.build());
        }
        this.bitField0_ |= 0x400;
        return this;
    }
    
    public DescriptorProtos$FileDescriptorProto$Builder mergeSourceCodeInfo(final DescriptorProtos$SourceCodeInfo sourceCodeInfo_) {
        if (this.sourceCodeInfoBuilder_ == null) {
            if ((this.bitField0_ & 0x400) == 0x400 && this.sourceCodeInfo_ != null && this.sourceCodeInfo_ != DescriptorProtos$SourceCodeInfo.getDefaultInstance()) {
                this.sourceCodeInfo_ = DescriptorProtos$SourceCodeInfo.newBuilder(this.sourceCodeInfo_).mergeFrom(sourceCodeInfo_).buildPartial();
            }
            else {
                this.sourceCodeInfo_ = sourceCodeInfo_;
            }
            this.onChanged();
        }
        else {
            this.sourceCodeInfoBuilder_.mergeFrom(sourceCodeInfo_);
        }
        this.bitField0_ |= 0x400;
        return this;
    }
    
    public DescriptorProtos$FileDescriptorProto$Builder clearSourceCodeInfo() {
        if (this.sourceCodeInfoBuilder_ == null) {
            this.sourceCodeInfo_ = null;
            this.onChanged();
        }
        else {
            this.sourceCodeInfoBuilder_.clear();
        }
        this.bitField0_ &= 0xFFFFFBFF;
        return this;
    }
    
    public DescriptorProtos$SourceCodeInfo$Builder getSourceCodeInfoBuilder() {
        this.bitField0_ |= 0x400;
        this.onChanged();
        return (DescriptorProtos$SourceCodeInfo$Builder)this.getSourceCodeInfoFieldBuilder().getBuilder();
    }
    
    public DescriptorProtos$SourceCodeInfoOrBuilder getSourceCodeInfoOrBuilder() {
        if (this.sourceCodeInfoBuilder_ != null) {
            return (DescriptorProtos$SourceCodeInfoOrBuilder)this.sourceCodeInfoBuilder_.getMessageOrBuilder();
        }
        return (this.sourceCodeInfo_ == null) ? DescriptorProtos$SourceCodeInfo.getDefaultInstance() : this.sourceCodeInfo_;
    }
    
    private SingleFieldBuilder getSourceCodeInfoFieldBuilder() {
        if (this.sourceCodeInfoBuilder_ == null) {
            this.sourceCodeInfoBuilder_ = new SingleFieldBuilder(this.getSourceCodeInfo(), this.getParentForChildren(), this.isClean());
            this.sourceCodeInfo_ = null;
        }
        return this.sourceCodeInfoBuilder_;
    }
    
    public boolean hasSyntax() {
        return (this.bitField0_ & 0x800) == 0x800;
    }
    
    public String getSyntax() {
        final Object syntax_ = this.syntax_;
        if (!(syntax_ instanceof String)) {
            final ByteString byteString = (ByteString)syntax_;
            final String stringUtf8 = byteString.toStringUtf8();
            if (byteString.isValidUtf8()) {
                this.syntax_ = stringUtf8;
            }
            return stringUtf8;
        }
        return (String)syntax_;
    }
    
    public ByteString getSyntaxBytes() {
        final Object syntax_ = this.syntax_;
        if (syntax_ instanceof String) {
            return (ByteString)(this.syntax_ = ByteString.copyFromUtf8((String)syntax_));
        }
        return (ByteString)syntax_;
    }
    
    public DescriptorProtos$FileDescriptorProto$Builder setSyntax(final String syntax_) {
        if (syntax_ == null) {
            throw new NullPointerException();
        }
        this.bitField0_ |= 0x800;
        this.syntax_ = syntax_;
        this.onChanged();
        return this;
    }
    
    public DescriptorProtos$FileDescriptorProto$Builder clearSyntax() {
        this.bitField0_ &= 0xFFFFF7FF;
        this.syntax_ = DescriptorProtos$FileDescriptorProto.getDefaultInstance().getSyntax();
        this.onChanged();
        return this;
    }
    
    public DescriptorProtos$FileDescriptorProto$Builder setSyntaxBytes(final ByteString syntax_) {
        if (syntax_ == null) {
            throw new NullPointerException();
        }
        this.bitField0_ |= 0x800;
        this.syntax_ = syntax_;
        this.onChanged();
        return this;
    }
}
