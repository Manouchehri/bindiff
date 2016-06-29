package com.google.protobuf;

import java.util.*;
import java.io.*;

public final class DescriptorProtos$ServiceDescriptorProto$Builder extends GeneratedMessage$Builder implements DescriptorProtos$ServiceDescriptorProtoOrBuilder
{
    private int bitField0_;
    private Object name_;
    private List method_;
    private RepeatedFieldBuilder methodBuilder_;
    private DescriptorProtos$ServiceOptions options_;
    private SingleFieldBuilder optionsBuilder_;
    
    public static final Descriptors$Descriptor getDescriptor() {
        return DescriptorProtos.internal_static_google_protobuf_ServiceDescriptorProto_descriptor;
    }
    
    protected GeneratedMessage$FieldAccessorTable internalGetFieldAccessorTable() {
        return DescriptorProtos.internal_static_google_protobuf_ServiceDescriptorProto_fieldAccessorTable.ensureFieldAccessorsInitialized(DescriptorProtos$ServiceDescriptorProto.class, DescriptorProtos$ServiceDescriptorProto$Builder.class);
    }
    
    private DescriptorProtos$ServiceDescriptorProto$Builder() {
        this.name_ = "";
        this.method_ = Collections.emptyList();
        this.options_ = null;
        this.maybeForceBuilderInitialization();
    }
    
    private DescriptorProtos$ServiceDescriptorProto$Builder(final GeneratedMessage$BuilderParent generatedMessage$BuilderParent) {
        super(generatedMessage$BuilderParent);
        this.name_ = "";
        this.method_ = Collections.emptyList();
        this.options_ = null;
        this.maybeForceBuilderInitialization();
    }
    
    private void maybeForceBuilderInitialization() {
        if (GeneratedMessage.alwaysUseFieldBuilders) {
            this.getMethodFieldBuilder();
            this.getOptionsFieldBuilder();
        }
    }
    
    public DescriptorProtos$ServiceDescriptorProto$Builder clear() {
        super.clear();
        this.name_ = "";
        this.bitField0_ &= 0xFFFFFFFE;
        if (this.methodBuilder_ == null) {
            this.method_ = Collections.emptyList();
            this.bitField0_ &= 0xFFFFFFFD;
        }
        else {
            this.methodBuilder_.clear();
        }
        if (this.optionsBuilder_ == null) {
            this.options_ = null;
        }
        else {
            this.optionsBuilder_.clear();
        }
        this.bitField0_ &= 0xFFFFFFFB;
        return this;
    }
    
    public Descriptors$Descriptor getDescriptorForType() {
        return DescriptorProtos.internal_static_google_protobuf_ServiceDescriptorProto_descriptor;
    }
    
    public DescriptorProtos$ServiceDescriptorProto getDefaultInstanceForType() {
        return DescriptorProtos$ServiceDescriptorProto.getDefaultInstance();
    }
    
    public DescriptorProtos$ServiceDescriptorProto build() {
        final DescriptorProtos$ServiceDescriptorProto buildPartial = this.buildPartial();
        if (!buildPartial.isInitialized()) {
            throw AbstractMessage$Builder.newUninitializedMessageException(buildPartial);
        }
        return buildPartial;
    }
    
    public DescriptorProtos$ServiceDescriptorProto buildPartial() {
        final DescriptorProtos$ServiceDescriptorProto descriptorProtos$ServiceDescriptorProto = new DescriptorProtos$ServiceDescriptorProto(this, null);
        final int bitField0_ = this.bitField0_;
        int n = 0;
        if ((bitField0_ & 0x1) == 0x1) {
            n |= 0x1;
        }
        descriptorProtos$ServiceDescriptorProto.name_ = this.name_;
        if (this.methodBuilder_ == null) {
            if ((this.bitField0_ & 0x2) == 0x2) {
                this.method_ = Collections.unmodifiableList((List<?>)this.method_);
                this.bitField0_ &= 0xFFFFFFFD;
            }
            descriptorProtos$ServiceDescriptorProto.method_ = this.method_;
        }
        else {
            descriptorProtos$ServiceDescriptorProto.method_ = this.methodBuilder_.build();
        }
        if ((bitField0_ & 0x4) == 0x4) {
            n |= 0x2;
        }
        if (this.optionsBuilder_ == null) {
            descriptorProtos$ServiceDescriptorProto.options_ = this.options_;
        }
        else {
            descriptorProtos$ServiceDescriptorProto.options_ = (DescriptorProtos$ServiceOptions)this.optionsBuilder_.build();
        }
        descriptorProtos$ServiceDescriptorProto.bitField0_ = n;
        this.onBuilt();
        return descriptorProtos$ServiceDescriptorProto;
    }
    
    public DescriptorProtos$ServiceDescriptorProto$Builder mergeFrom(final Message message) {
        if (message instanceof DescriptorProtos$ServiceDescriptorProto) {
            return this.mergeFrom((DescriptorProtos$ServiceDescriptorProto)message);
        }
        super.mergeFrom(message);
        return this;
    }
    
    public DescriptorProtos$ServiceDescriptorProto$Builder mergeFrom(final DescriptorProtos$ServiceDescriptorProto descriptorProtos$ServiceDescriptorProto) {
        if (descriptorProtos$ServiceDescriptorProto == DescriptorProtos$ServiceDescriptorProto.getDefaultInstance()) {
            return this;
        }
        if (descriptorProtos$ServiceDescriptorProto.hasName()) {
            this.bitField0_ |= 0x1;
            this.name_ = descriptorProtos$ServiceDescriptorProto.name_;
            this.onChanged();
        }
        if (this.methodBuilder_ == null) {
            if (!descriptorProtos$ServiceDescriptorProto.method_.isEmpty()) {
                if (this.method_.isEmpty()) {
                    this.method_ = descriptorProtos$ServiceDescriptorProto.method_;
                    this.bitField0_ &= 0xFFFFFFFD;
                }
                else {
                    this.ensureMethodIsMutable();
                    this.method_.addAll(descriptorProtos$ServiceDescriptorProto.method_);
                }
                this.onChanged();
            }
        }
        else if (!descriptorProtos$ServiceDescriptorProto.method_.isEmpty()) {
            if (this.methodBuilder_.isEmpty()) {
                this.methodBuilder_.dispose();
                this.methodBuilder_ = null;
                this.method_ = descriptorProtos$ServiceDescriptorProto.method_;
                this.bitField0_ &= 0xFFFFFFFD;
                this.methodBuilder_ = (GeneratedMessage.alwaysUseFieldBuilders ? this.getMethodFieldBuilder() : null);
            }
            else {
                this.methodBuilder_.addAllMessages(descriptorProtos$ServiceDescriptorProto.method_);
            }
        }
        if (descriptorProtos$ServiceDescriptorProto.hasOptions()) {
            this.mergeOptions(descriptorProtos$ServiceDescriptorProto.getOptions());
        }
        this.mergeUnknownFields(descriptorProtos$ServiceDescriptorProto.unknownFields);
        this.onChanged();
        return this;
    }
    
    public final boolean isInitialized() {
        for (int i = 0; i < this.getMethodCount(); ++i) {
            if (!this.getMethod(i).isInitialized()) {
                return false;
            }
        }
        return !this.hasOptions() || this.getOptions().isInitialized();
    }
    
    public DescriptorProtos$ServiceDescriptorProto$Builder mergeFrom(final CodedInputStream codedInputStream, final ExtensionRegistryLite extensionRegistryLite) {
        DescriptorProtos$ServiceDescriptorProto descriptorProtos$ServiceDescriptorProto = null;
        try {
            descriptorProtos$ServiceDescriptorProto = (DescriptorProtos$ServiceDescriptorProto)DescriptorProtos$ServiceDescriptorProto.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
        }
        catch (InvalidProtocolBufferException ex) {
            descriptorProtos$ServiceDescriptorProto = (DescriptorProtos$ServiceDescriptorProto)ex.getUnfinishedMessage();
            throw ex;
        }
        finally {
            if (descriptorProtos$ServiceDescriptorProto != null) {
                this.mergeFrom(descriptorProtos$ServiceDescriptorProto);
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
    
    public DescriptorProtos$ServiceDescriptorProto$Builder setName(final String name_) {
        if (name_ == null) {
            throw new NullPointerException();
        }
        this.bitField0_ |= 0x1;
        this.name_ = name_;
        this.onChanged();
        return this;
    }
    
    public DescriptorProtos$ServiceDescriptorProto$Builder clearName() {
        this.bitField0_ &= 0xFFFFFFFE;
        this.name_ = DescriptorProtos$ServiceDescriptorProto.getDefaultInstance().getName();
        this.onChanged();
        return this;
    }
    
    public DescriptorProtos$ServiceDescriptorProto$Builder setNameBytes(final ByteString name_) {
        if (name_ == null) {
            throw new NullPointerException();
        }
        this.bitField0_ |= 0x1;
        this.name_ = name_;
        this.onChanged();
        return this;
    }
    
    private void ensureMethodIsMutable() {
        if ((this.bitField0_ & 0x2) != 0x2) {
            this.method_ = new ArrayList(this.method_);
            this.bitField0_ |= 0x2;
        }
    }
    
    public List getMethodList() {
        if (this.methodBuilder_ == null) {
            return Collections.unmodifiableList((List<?>)this.method_);
        }
        return this.methodBuilder_.getMessageList();
    }
    
    public int getMethodCount() {
        if (this.methodBuilder_ == null) {
            return this.method_.size();
        }
        return this.methodBuilder_.getCount();
    }
    
    public DescriptorProtos$MethodDescriptorProto getMethod(final int n) {
        if (this.methodBuilder_ == null) {
            return this.method_.get(n);
        }
        return (DescriptorProtos$MethodDescriptorProto)this.methodBuilder_.getMessage(n);
    }
    
    public DescriptorProtos$ServiceDescriptorProto$Builder setMethod(final int n, final DescriptorProtos$MethodDescriptorProto descriptorProtos$MethodDescriptorProto) {
        if (this.methodBuilder_ == null) {
            if (descriptorProtos$MethodDescriptorProto == null) {
                throw new NullPointerException();
            }
            this.ensureMethodIsMutable();
            this.method_.set(n, descriptorProtos$MethodDescriptorProto);
            this.onChanged();
        }
        else {
            this.methodBuilder_.setMessage(n, descriptorProtos$MethodDescriptorProto);
        }
        return this;
    }
    
    public DescriptorProtos$ServiceDescriptorProto$Builder setMethod(final int n, final DescriptorProtos$MethodDescriptorProto$Builder descriptorProtos$MethodDescriptorProto$Builder) {
        if (this.methodBuilder_ == null) {
            this.ensureMethodIsMutable();
            this.method_.set(n, descriptorProtos$MethodDescriptorProto$Builder.build());
            this.onChanged();
        }
        else {
            this.methodBuilder_.setMessage(n, descriptorProtos$MethodDescriptorProto$Builder.build());
        }
        return this;
    }
    
    public DescriptorProtos$ServiceDescriptorProto$Builder addMethod(final DescriptorProtos$MethodDescriptorProto descriptorProtos$MethodDescriptorProto) {
        if (this.methodBuilder_ == null) {
            if (descriptorProtos$MethodDescriptorProto == null) {
                throw new NullPointerException();
            }
            this.ensureMethodIsMutable();
            this.method_.add(descriptorProtos$MethodDescriptorProto);
            this.onChanged();
        }
        else {
            this.methodBuilder_.addMessage(descriptorProtos$MethodDescriptorProto);
        }
        return this;
    }
    
    public DescriptorProtos$ServiceDescriptorProto$Builder addMethod(final int n, final DescriptorProtos$MethodDescriptorProto descriptorProtos$MethodDescriptorProto) {
        if (this.methodBuilder_ == null) {
            if (descriptorProtos$MethodDescriptorProto == null) {
                throw new NullPointerException();
            }
            this.ensureMethodIsMutable();
            this.method_.add(n, descriptorProtos$MethodDescriptorProto);
            this.onChanged();
        }
        else {
            this.methodBuilder_.addMessage(n, descriptorProtos$MethodDescriptorProto);
        }
        return this;
    }
    
    public DescriptorProtos$ServiceDescriptorProto$Builder addMethod(final DescriptorProtos$MethodDescriptorProto$Builder descriptorProtos$MethodDescriptorProto$Builder) {
        if (this.methodBuilder_ == null) {
            this.ensureMethodIsMutable();
            this.method_.add(descriptorProtos$MethodDescriptorProto$Builder.build());
            this.onChanged();
        }
        else {
            this.methodBuilder_.addMessage(descriptorProtos$MethodDescriptorProto$Builder.build());
        }
        return this;
    }
    
    public DescriptorProtos$ServiceDescriptorProto$Builder addMethod(final int n, final DescriptorProtos$MethodDescriptorProto$Builder descriptorProtos$MethodDescriptorProto$Builder) {
        if (this.methodBuilder_ == null) {
            this.ensureMethodIsMutable();
            this.method_.add(n, descriptorProtos$MethodDescriptorProto$Builder.build());
            this.onChanged();
        }
        else {
            this.methodBuilder_.addMessage(n, descriptorProtos$MethodDescriptorProto$Builder.build());
        }
        return this;
    }
    
    public DescriptorProtos$ServiceDescriptorProto$Builder addAllMethod(final Iterable iterable) {
        if (this.methodBuilder_ == null) {
            this.ensureMethodIsMutable();
            AbstractMessageLite$Builder.addAll(iterable, this.method_);
            this.onChanged();
        }
        else {
            this.methodBuilder_.addAllMessages(iterable);
        }
        return this;
    }
    
    public DescriptorProtos$ServiceDescriptorProto$Builder clearMethod() {
        if (this.methodBuilder_ == null) {
            this.method_ = Collections.emptyList();
            this.bitField0_ &= 0xFFFFFFFD;
            this.onChanged();
        }
        else {
            this.methodBuilder_.clear();
        }
        return this;
    }
    
    public DescriptorProtos$ServiceDescriptorProto$Builder removeMethod(final int n) {
        if (this.methodBuilder_ == null) {
            this.ensureMethodIsMutable();
            this.method_.remove(n);
            this.onChanged();
        }
        else {
            this.methodBuilder_.remove(n);
        }
        return this;
    }
    
    public DescriptorProtos$MethodDescriptorProto$Builder getMethodBuilder(final int n) {
        return (DescriptorProtos$MethodDescriptorProto$Builder)this.getMethodFieldBuilder().getBuilder(n);
    }
    
    public DescriptorProtos$MethodDescriptorProtoOrBuilder getMethodOrBuilder(final int n) {
        if (this.methodBuilder_ == null) {
            return this.method_.get(n);
        }
        return (DescriptorProtos$MethodDescriptorProtoOrBuilder)this.methodBuilder_.getMessageOrBuilder(n);
    }
    
    public List getMethodOrBuilderList() {
        if (this.methodBuilder_ != null) {
            return this.methodBuilder_.getMessageOrBuilderList();
        }
        return Collections.unmodifiableList((List<?>)this.method_);
    }
    
    public DescriptorProtos$MethodDescriptorProto$Builder addMethodBuilder() {
        return (DescriptorProtos$MethodDescriptorProto$Builder)this.getMethodFieldBuilder().addBuilder(DescriptorProtos$MethodDescriptorProto.getDefaultInstance());
    }
    
    public DescriptorProtos$MethodDescriptorProto$Builder addMethodBuilder(final int n) {
        return (DescriptorProtos$MethodDescriptorProto$Builder)this.getMethodFieldBuilder().addBuilder(n, DescriptorProtos$MethodDescriptorProto.getDefaultInstance());
    }
    
    public List getMethodBuilderList() {
        return this.getMethodFieldBuilder().getBuilderList();
    }
    
    private RepeatedFieldBuilder getMethodFieldBuilder() {
        if (this.methodBuilder_ == null) {
            this.methodBuilder_ = new RepeatedFieldBuilder(this.method_, (this.bitField0_ & 0x2) == 0x2, this.getParentForChildren(), this.isClean());
            this.method_ = null;
        }
        return this.methodBuilder_;
    }
    
    public boolean hasOptions() {
        return (this.bitField0_ & 0x4) == 0x4;
    }
    
    public DescriptorProtos$ServiceOptions getOptions() {
        if (this.optionsBuilder_ == null) {
            return (this.options_ == null) ? DescriptorProtos$ServiceOptions.getDefaultInstance() : this.options_;
        }
        return (DescriptorProtos$ServiceOptions)this.optionsBuilder_.getMessage();
    }
    
    public DescriptorProtos$ServiceDescriptorProto$Builder setOptions(final DescriptorProtos$ServiceOptions descriptorProtos$ServiceOptions) {
        if (this.optionsBuilder_ == null) {
            if (descriptorProtos$ServiceOptions == null) {
                throw new NullPointerException();
            }
            this.options_ = descriptorProtos$ServiceOptions;
            this.onChanged();
        }
        else {
            this.optionsBuilder_.setMessage(descriptorProtos$ServiceOptions);
        }
        this.bitField0_ |= 0x4;
        return this;
    }
    
    public DescriptorProtos$ServiceDescriptorProto$Builder setOptions(final DescriptorProtos$ServiceOptions$Builder descriptorProtos$ServiceOptions$Builder) {
        if (this.optionsBuilder_ == null) {
            this.options_ = descriptorProtos$ServiceOptions$Builder.build();
            this.onChanged();
        }
        else {
            this.optionsBuilder_.setMessage(descriptorProtos$ServiceOptions$Builder.build());
        }
        this.bitField0_ |= 0x4;
        return this;
    }
    
    public DescriptorProtos$ServiceDescriptorProto$Builder mergeOptions(final DescriptorProtos$ServiceOptions options_) {
        if (this.optionsBuilder_ == null) {
            if ((this.bitField0_ & 0x4) == 0x4 && this.options_ != null && this.options_ != DescriptorProtos$ServiceOptions.getDefaultInstance()) {
                this.options_ = DescriptorProtos$ServiceOptions.newBuilder(this.options_).mergeFrom(options_).buildPartial();
            }
            else {
                this.options_ = options_;
            }
            this.onChanged();
        }
        else {
            this.optionsBuilder_.mergeFrom(options_);
        }
        this.bitField0_ |= 0x4;
        return this;
    }
    
    public DescriptorProtos$ServiceDescriptorProto$Builder clearOptions() {
        if (this.optionsBuilder_ == null) {
            this.options_ = null;
            this.onChanged();
        }
        else {
            this.optionsBuilder_.clear();
        }
        this.bitField0_ &= 0xFFFFFFFB;
        return this;
    }
    
    public DescriptorProtos$ServiceOptions$Builder getOptionsBuilder() {
        this.bitField0_ |= 0x4;
        this.onChanged();
        return (DescriptorProtos$ServiceOptions$Builder)this.getOptionsFieldBuilder().getBuilder();
    }
    
    public DescriptorProtos$ServiceOptionsOrBuilder getOptionsOrBuilder() {
        if (this.optionsBuilder_ != null) {
            return (DescriptorProtos$ServiceOptionsOrBuilder)this.optionsBuilder_.getMessageOrBuilder();
        }
        return (this.options_ == null) ? DescriptorProtos$ServiceOptions.getDefaultInstance() : this.options_;
    }
    
    private SingleFieldBuilder getOptionsFieldBuilder() {
        if (this.optionsBuilder_ == null) {
            this.optionsBuilder_ = new SingleFieldBuilder(this.getOptions(), this.getParentForChildren(), this.isClean());
            this.options_ = null;
        }
        return this.optionsBuilder_;
    }
}
