package com.google.protobuf;

import java.util.*;
import java.io.*;

public final class DescriptorProtos$SourceCodeInfo$Builder extends GeneratedMessage$Builder implements DescriptorProtos$SourceCodeInfoOrBuilder
{
    private int bitField0_;
    private List location_;
    private RepeatedFieldBuilder locationBuilder_;
    
    public static final Descriptors$Descriptor getDescriptor() {
        return DescriptorProtos.internal_static_google_protobuf_SourceCodeInfo_descriptor;
    }
    
    protected GeneratedMessage$FieldAccessorTable internalGetFieldAccessorTable() {
        return DescriptorProtos.internal_static_google_protobuf_SourceCodeInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(DescriptorProtos$SourceCodeInfo.class, DescriptorProtos$SourceCodeInfo$Builder.class);
    }
    
    private DescriptorProtos$SourceCodeInfo$Builder() {
        this.location_ = Collections.emptyList();
        this.maybeForceBuilderInitialization();
    }
    
    private DescriptorProtos$SourceCodeInfo$Builder(final GeneratedMessage$BuilderParent generatedMessage$BuilderParent) {
        super(generatedMessage$BuilderParent);
        this.location_ = Collections.emptyList();
        this.maybeForceBuilderInitialization();
    }
    
    private void maybeForceBuilderInitialization() {
        if (GeneratedMessage.alwaysUseFieldBuilders) {
            this.getLocationFieldBuilder();
        }
    }
    
    public DescriptorProtos$SourceCodeInfo$Builder clear() {
        super.clear();
        if (this.locationBuilder_ == null) {
            this.location_ = Collections.emptyList();
            this.bitField0_ &= 0xFFFFFFFE;
        }
        else {
            this.locationBuilder_.clear();
        }
        return this;
    }
    
    public Descriptors$Descriptor getDescriptorForType() {
        return DescriptorProtos.internal_static_google_protobuf_SourceCodeInfo_descriptor;
    }
    
    public DescriptorProtos$SourceCodeInfo getDefaultInstanceForType() {
        return DescriptorProtos$SourceCodeInfo.getDefaultInstance();
    }
    
    public DescriptorProtos$SourceCodeInfo build() {
        final DescriptorProtos$SourceCodeInfo buildPartial = this.buildPartial();
        if (!buildPartial.isInitialized()) {
            throw AbstractMessage$Builder.newUninitializedMessageException(buildPartial);
        }
        return buildPartial;
    }
    
    public DescriptorProtos$SourceCodeInfo buildPartial() {
        final DescriptorProtos$SourceCodeInfo descriptorProtos$SourceCodeInfo = new DescriptorProtos$SourceCodeInfo(this, null);
        final int bitField0_ = this.bitField0_;
        if (this.locationBuilder_ == null) {
            if ((this.bitField0_ & 0x1) == 0x1) {
                this.location_ = Collections.unmodifiableList((List<?>)this.location_);
                this.bitField0_ &= 0xFFFFFFFE;
            }
            descriptorProtos$SourceCodeInfo.location_ = this.location_;
        }
        else {
            descriptorProtos$SourceCodeInfo.location_ = this.locationBuilder_.build();
        }
        this.onBuilt();
        return descriptorProtos$SourceCodeInfo;
    }
    
    public DescriptorProtos$SourceCodeInfo$Builder mergeFrom(final Message message) {
        if (message instanceof DescriptorProtos$SourceCodeInfo) {
            return this.mergeFrom((DescriptorProtos$SourceCodeInfo)message);
        }
        super.mergeFrom(message);
        return this;
    }
    
    public DescriptorProtos$SourceCodeInfo$Builder mergeFrom(final DescriptorProtos$SourceCodeInfo descriptorProtos$SourceCodeInfo) {
        if (descriptorProtos$SourceCodeInfo == DescriptorProtos$SourceCodeInfo.getDefaultInstance()) {
            return this;
        }
        if (this.locationBuilder_ == null) {
            if (!descriptorProtos$SourceCodeInfo.location_.isEmpty()) {
                if (this.location_.isEmpty()) {
                    this.location_ = descriptorProtos$SourceCodeInfo.location_;
                    this.bitField0_ &= 0xFFFFFFFE;
                }
                else {
                    this.ensureLocationIsMutable();
                    this.location_.addAll(descriptorProtos$SourceCodeInfo.location_);
                }
                this.onChanged();
            }
        }
        else if (!descriptorProtos$SourceCodeInfo.location_.isEmpty()) {
            if (this.locationBuilder_.isEmpty()) {
                this.locationBuilder_.dispose();
                this.locationBuilder_ = null;
                this.location_ = descriptorProtos$SourceCodeInfo.location_;
                this.bitField0_ &= 0xFFFFFFFE;
                this.locationBuilder_ = (GeneratedMessage.alwaysUseFieldBuilders ? this.getLocationFieldBuilder() : null);
            }
            else {
                this.locationBuilder_.addAllMessages(descriptorProtos$SourceCodeInfo.location_);
            }
        }
        this.mergeUnknownFields(descriptorProtos$SourceCodeInfo.unknownFields);
        this.onChanged();
        return this;
    }
    
    public final boolean isInitialized() {
        return true;
    }
    
    public DescriptorProtos$SourceCodeInfo$Builder mergeFrom(final CodedInputStream codedInputStream, final ExtensionRegistryLite extensionRegistryLite) {
        DescriptorProtos$SourceCodeInfo descriptorProtos$SourceCodeInfo = null;
        try {
            descriptorProtos$SourceCodeInfo = (DescriptorProtos$SourceCodeInfo)DescriptorProtos$SourceCodeInfo.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
        }
        catch (InvalidProtocolBufferException ex) {
            descriptorProtos$SourceCodeInfo = (DescriptorProtos$SourceCodeInfo)ex.getUnfinishedMessage();
            throw ex;
        }
        finally {
            if (descriptorProtos$SourceCodeInfo != null) {
                this.mergeFrom(descriptorProtos$SourceCodeInfo);
            }
        }
        return this;
    }
    
    private void ensureLocationIsMutable() {
        if ((this.bitField0_ & 0x1) != 0x1) {
            this.location_ = new ArrayList(this.location_);
            this.bitField0_ |= 0x1;
        }
    }
    
    public List getLocationList() {
        if (this.locationBuilder_ == null) {
            return Collections.unmodifiableList((List<?>)this.location_);
        }
        return this.locationBuilder_.getMessageList();
    }
    
    public int getLocationCount() {
        if (this.locationBuilder_ == null) {
            return this.location_.size();
        }
        return this.locationBuilder_.getCount();
    }
    
    public DescriptorProtos$SourceCodeInfo$Location getLocation(final int n) {
        if (this.locationBuilder_ == null) {
            return this.location_.get(n);
        }
        return (DescriptorProtos$SourceCodeInfo$Location)this.locationBuilder_.getMessage(n);
    }
    
    public DescriptorProtos$SourceCodeInfo$Builder setLocation(final int n, final DescriptorProtos$SourceCodeInfo$Location descriptorProtos$SourceCodeInfo$Location) {
        if (this.locationBuilder_ == null) {
            if (descriptorProtos$SourceCodeInfo$Location == null) {
                throw new NullPointerException();
            }
            this.ensureLocationIsMutable();
            this.location_.set(n, descriptorProtos$SourceCodeInfo$Location);
            this.onChanged();
        }
        else {
            this.locationBuilder_.setMessage(n, descriptorProtos$SourceCodeInfo$Location);
        }
        return this;
    }
    
    public DescriptorProtos$SourceCodeInfo$Builder setLocation(final int n, final DescriptorProtos$SourceCodeInfo$Location$Builder descriptorProtos$SourceCodeInfo$Location$Builder) {
        if (this.locationBuilder_ == null) {
            this.ensureLocationIsMutable();
            this.location_.set(n, descriptorProtos$SourceCodeInfo$Location$Builder.build());
            this.onChanged();
        }
        else {
            this.locationBuilder_.setMessage(n, descriptorProtos$SourceCodeInfo$Location$Builder.build());
        }
        return this;
    }
    
    public DescriptorProtos$SourceCodeInfo$Builder addLocation(final DescriptorProtos$SourceCodeInfo$Location descriptorProtos$SourceCodeInfo$Location) {
        if (this.locationBuilder_ == null) {
            if (descriptorProtos$SourceCodeInfo$Location == null) {
                throw new NullPointerException();
            }
            this.ensureLocationIsMutable();
            this.location_.add(descriptorProtos$SourceCodeInfo$Location);
            this.onChanged();
        }
        else {
            this.locationBuilder_.addMessage(descriptorProtos$SourceCodeInfo$Location);
        }
        return this;
    }
    
    public DescriptorProtos$SourceCodeInfo$Builder addLocation(final int n, final DescriptorProtos$SourceCodeInfo$Location descriptorProtos$SourceCodeInfo$Location) {
        if (this.locationBuilder_ == null) {
            if (descriptorProtos$SourceCodeInfo$Location == null) {
                throw new NullPointerException();
            }
            this.ensureLocationIsMutable();
            this.location_.add(n, descriptorProtos$SourceCodeInfo$Location);
            this.onChanged();
        }
        else {
            this.locationBuilder_.addMessage(n, descriptorProtos$SourceCodeInfo$Location);
        }
        return this;
    }
    
    public DescriptorProtos$SourceCodeInfo$Builder addLocation(final DescriptorProtos$SourceCodeInfo$Location$Builder descriptorProtos$SourceCodeInfo$Location$Builder) {
        if (this.locationBuilder_ == null) {
            this.ensureLocationIsMutable();
            this.location_.add(descriptorProtos$SourceCodeInfo$Location$Builder.build());
            this.onChanged();
        }
        else {
            this.locationBuilder_.addMessage(descriptorProtos$SourceCodeInfo$Location$Builder.build());
        }
        return this;
    }
    
    public DescriptorProtos$SourceCodeInfo$Builder addLocation(final int n, final DescriptorProtos$SourceCodeInfo$Location$Builder descriptorProtos$SourceCodeInfo$Location$Builder) {
        if (this.locationBuilder_ == null) {
            this.ensureLocationIsMutable();
            this.location_.add(n, descriptorProtos$SourceCodeInfo$Location$Builder.build());
            this.onChanged();
        }
        else {
            this.locationBuilder_.addMessage(n, descriptorProtos$SourceCodeInfo$Location$Builder.build());
        }
        return this;
    }
    
    public DescriptorProtos$SourceCodeInfo$Builder addAllLocation(final Iterable iterable) {
        if (this.locationBuilder_ == null) {
            this.ensureLocationIsMutable();
            AbstractMessageLite$Builder.addAll(iterable, this.location_);
            this.onChanged();
        }
        else {
            this.locationBuilder_.addAllMessages(iterable);
        }
        return this;
    }
    
    public DescriptorProtos$SourceCodeInfo$Builder clearLocation() {
        if (this.locationBuilder_ == null) {
            this.location_ = Collections.emptyList();
            this.bitField0_ &= 0xFFFFFFFE;
            this.onChanged();
        }
        else {
            this.locationBuilder_.clear();
        }
        return this;
    }
    
    public DescriptorProtos$SourceCodeInfo$Builder removeLocation(final int n) {
        if (this.locationBuilder_ == null) {
            this.ensureLocationIsMutable();
            this.location_.remove(n);
            this.onChanged();
        }
        else {
            this.locationBuilder_.remove(n);
        }
        return this;
    }
    
    public DescriptorProtos$SourceCodeInfo$Location$Builder getLocationBuilder(final int n) {
        return (DescriptorProtos$SourceCodeInfo$Location$Builder)this.getLocationFieldBuilder().getBuilder(n);
    }
    
    public DescriptorProtos$SourceCodeInfo$LocationOrBuilder getLocationOrBuilder(final int n) {
        if (this.locationBuilder_ == null) {
            return this.location_.get(n);
        }
        return (DescriptorProtos$SourceCodeInfo$LocationOrBuilder)this.locationBuilder_.getMessageOrBuilder(n);
    }
    
    public List getLocationOrBuilderList() {
        if (this.locationBuilder_ != null) {
            return this.locationBuilder_.getMessageOrBuilderList();
        }
        return Collections.unmodifiableList((List<?>)this.location_);
    }
    
    public DescriptorProtos$SourceCodeInfo$Location$Builder addLocationBuilder() {
        return (DescriptorProtos$SourceCodeInfo$Location$Builder)this.getLocationFieldBuilder().addBuilder(DescriptorProtos$SourceCodeInfo$Location.getDefaultInstance());
    }
    
    public DescriptorProtos$SourceCodeInfo$Location$Builder addLocationBuilder(final int n) {
        return (DescriptorProtos$SourceCodeInfo$Location$Builder)this.getLocationFieldBuilder().addBuilder(n, DescriptorProtos$SourceCodeInfo$Location.getDefaultInstance());
    }
    
    public List getLocationBuilderList() {
        return this.getLocationFieldBuilder().getBuilderList();
    }
    
    private RepeatedFieldBuilder getLocationFieldBuilder() {
        if (this.locationBuilder_ == null) {
            this.locationBuilder_ = new RepeatedFieldBuilder(this.location_, (this.bitField0_ & 0x1) == 0x1, this.getParentForChildren(), this.isClean());
            this.location_ = null;
        }
        return this.locationBuilder_;
    }
}
