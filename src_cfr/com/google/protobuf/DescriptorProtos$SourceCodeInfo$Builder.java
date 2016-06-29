/*
 * Decompiled with CFR 0_115.
 */
package com.google.protobuf;

import com.google.protobuf.AbstractMessage$Builder;
import com.google.protobuf.AbstractMessageLite$Builder;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.DescriptorProtos;
import com.google.protobuf.DescriptorProtos$1;
import com.google.protobuf.DescriptorProtos$SourceCodeInfo;
import com.google.protobuf.DescriptorProtos$SourceCodeInfo$Location;
import com.google.protobuf.DescriptorProtos$SourceCodeInfo$Location$Builder;
import com.google.protobuf.DescriptorProtos$SourceCodeInfo$LocationOrBuilder;
import com.google.protobuf.DescriptorProtos$SourceCodeInfoOrBuilder;
import com.google.protobuf.Descriptors$Descriptor;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessage;
import com.google.protobuf.GeneratedMessage$Builder;
import com.google.protobuf.GeneratedMessage$BuilderParent;
import com.google.protobuf.GeneratedMessage$FieldAccessorTable;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.Message;
import com.google.protobuf.Message$Builder;
import com.google.protobuf.MessageLite;
import com.google.protobuf.MessageLite$Builder;
import com.google.protobuf.MessageOrBuilder;
import com.google.protobuf.Parser;
import com.google.protobuf.RepeatedFieldBuilder;
import com.google.protobuf.UnknownFieldSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public final class DescriptorProtos$SourceCodeInfo$Builder
extends GeneratedMessage$Builder
implements DescriptorProtos$SourceCodeInfoOrBuilder {
    private int bitField0_;
    private List location_ = Collections.emptyList();
    private RepeatedFieldBuilder locationBuilder_;

    public static final Descriptors$Descriptor getDescriptor() {
        return DescriptorProtos.access$23600();
    }

    @Override
    protected GeneratedMessage$FieldAccessorTable internalGetFieldAccessorTable() {
        return DescriptorProtos.access$23700().ensureFieldAccessorsInitialized(DescriptorProtos$SourceCodeInfo.class, DescriptorProtos$SourceCodeInfo$Builder.class);
    }

    private DescriptorProtos$SourceCodeInfo$Builder() {
        this.maybeForceBuilderInitialization();
    }

    private DescriptorProtos$SourceCodeInfo$Builder(GeneratedMessage$BuilderParent generatedMessage$BuilderParent) {
        super(generatedMessage$BuilderParent);
        this.maybeForceBuilderInitialization();
    }

    private void maybeForceBuilderInitialization() {
        if (!GeneratedMessage.alwaysUseFieldBuilders) return;
        this.getLocationFieldBuilder();
    }

    @Override
    public DescriptorProtos$SourceCodeInfo$Builder clear() {
        super.clear();
        if (this.locationBuilder_ == null) {
            this.location_ = Collections.emptyList();
            this.bitField0_ &= -2;
            return this;
        }
        this.locationBuilder_.clear();
        return this;
    }

    @Override
    public Descriptors$Descriptor getDescriptorForType() {
        return DescriptorProtos.access$23600();
    }

    @Override
    public DescriptorProtos$SourceCodeInfo getDefaultInstanceForType() {
        return DescriptorProtos$SourceCodeInfo.getDefaultInstance();
    }

    @Override
    public DescriptorProtos$SourceCodeInfo build() {
        DescriptorProtos$SourceCodeInfo descriptorProtos$SourceCodeInfo = this.buildPartial();
        if (descriptorProtos$SourceCodeInfo.isInitialized()) return descriptorProtos$SourceCodeInfo;
        throw DescriptorProtos$SourceCodeInfo$Builder.newUninitializedMessageException(descriptorProtos$SourceCodeInfo);
    }

    @Override
    public DescriptorProtos$SourceCodeInfo buildPartial() {
        DescriptorProtos$SourceCodeInfo descriptorProtos$SourceCodeInfo = new DescriptorProtos$SourceCodeInfo(this, null);
        int n2 = this.bitField0_;
        if (this.locationBuilder_ == null) {
            if ((this.bitField0_ & 1) == 1) {
                this.location_ = Collections.unmodifiableList(this.location_);
                this.bitField0_ &= -2;
            }
            DescriptorProtos$SourceCodeInfo.access$25302(descriptorProtos$SourceCodeInfo, this.location_);
        } else {
            DescriptorProtos$SourceCodeInfo.access$25302(descriptorProtos$SourceCodeInfo, this.locationBuilder_.build());
        }
        this.onBuilt();
        return descriptorProtos$SourceCodeInfo;
    }

    @Override
    public DescriptorProtos$SourceCodeInfo$Builder mergeFrom(Message message) {
        if (message instanceof DescriptorProtos$SourceCodeInfo) {
            return this.mergeFrom((DescriptorProtos$SourceCodeInfo)message);
        }
        super.mergeFrom(message);
        return this;
    }

    public DescriptorProtos$SourceCodeInfo$Builder mergeFrom(DescriptorProtos$SourceCodeInfo descriptorProtos$SourceCodeInfo) {
        if (descriptorProtos$SourceCodeInfo == DescriptorProtos$SourceCodeInfo.getDefaultInstance()) {
            return this;
        }
        if (this.locationBuilder_ == null) {
            if (!DescriptorProtos$SourceCodeInfo.access$25300(descriptorProtos$SourceCodeInfo).isEmpty()) {
                if (this.location_.isEmpty()) {
                    this.location_ = DescriptorProtos$SourceCodeInfo.access$25300(descriptorProtos$SourceCodeInfo);
                    this.bitField0_ &= -2;
                } else {
                    this.ensureLocationIsMutable();
                    this.location_.addAll(DescriptorProtos$SourceCodeInfo.access$25300(descriptorProtos$SourceCodeInfo));
                }
                this.onChanged();
            }
        } else if (!DescriptorProtos$SourceCodeInfo.access$25300(descriptorProtos$SourceCodeInfo).isEmpty()) {
            if (this.locationBuilder_.isEmpty()) {
                this.locationBuilder_.dispose();
                this.locationBuilder_ = null;
                this.location_ = DescriptorProtos$SourceCodeInfo.access$25300(descriptorProtos$SourceCodeInfo);
                this.bitField0_ &= -2;
                this.locationBuilder_ = GeneratedMessage.alwaysUseFieldBuilders ? this.getLocationFieldBuilder() : null;
            } else {
                this.locationBuilder_.addAllMessages(DescriptorProtos$SourceCodeInfo.access$25300(descriptorProtos$SourceCodeInfo));
            }
        }
        this.mergeUnknownFields(descriptorProtos$SourceCodeInfo.unknownFields);
        this.onChanged();
        return this;
    }

    @Override
    public final boolean isInitialized() {
        return true;
    }

    @Override
    public DescriptorProtos$SourceCodeInfo$Builder mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        DescriptorProtos$SourceCodeInfo descriptorProtos$SourceCodeInfo = null;
        try {
            try {
                descriptorProtos$SourceCodeInfo = (DescriptorProtos$SourceCodeInfo)DescriptorProtos$SourceCodeInfo.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
            }
            catch (InvalidProtocolBufferException var4_6) {
                descriptorProtos$SourceCodeInfo = (DescriptorProtos$SourceCodeInfo)var4_6.getUnfinishedMessage();
                throw var4_6;
            }
            Object var6_4 = null;
            if (descriptorProtos$SourceCodeInfo == null) return this;
            this.mergeFrom(descriptorProtos$SourceCodeInfo);
            return this;
        }
        catch (Throwable var5_7) {
            Object var6_5 = null;
            if (descriptorProtos$SourceCodeInfo == null) throw var5_7;
            this.mergeFrom(descriptorProtos$SourceCodeInfo);
            throw var5_7;
        }
    }

    private void ensureLocationIsMutable() {
        if ((this.bitField0_ & 1) == 1) return;
        this.location_ = new ArrayList(this.location_);
        this.bitField0_ |= 1;
    }

    @Override
    public List getLocationList() {
        if (this.locationBuilder_ != null) return this.locationBuilder_.getMessageList();
        return Collections.unmodifiableList(this.location_);
    }

    @Override
    public int getLocationCount() {
        if (this.locationBuilder_ != null) return this.locationBuilder_.getCount();
        return this.location_.size();
    }

    @Override
    public DescriptorProtos$SourceCodeInfo$Location getLocation(int n2) {
        if (this.locationBuilder_ != null) return (DescriptorProtos$SourceCodeInfo$Location)this.locationBuilder_.getMessage(n2);
        return (DescriptorProtos$SourceCodeInfo$Location)this.location_.get(n2);
    }

    public DescriptorProtos$SourceCodeInfo$Builder setLocation(int n2, DescriptorProtos$SourceCodeInfo$Location descriptorProtos$SourceCodeInfo$Location) {
        if (this.locationBuilder_ != null) {
            this.locationBuilder_.setMessage(n2, descriptorProtos$SourceCodeInfo$Location);
            return this;
        }
        if (descriptorProtos$SourceCodeInfo$Location == null) {
            throw new NullPointerException();
        }
        this.ensureLocationIsMutable();
        this.location_.set(n2, descriptorProtos$SourceCodeInfo$Location);
        this.onChanged();
        return this;
    }

    public DescriptorProtos$SourceCodeInfo$Builder setLocation(int n2, DescriptorProtos$SourceCodeInfo$Location$Builder descriptorProtos$SourceCodeInfo$Location$Builder) {
        if (this.locationBuilder_ == null) {
            this.ensureLocationIsMutable();
            this.location_.set(n2, descriptorProtos$SourceCodeInfo$Location$Builder.build());
            this.onChanged();
            return this;
        }
        this.locationBuilder_.setMessage(n2, descriptorProtos$SourceCodeInfo$Location$Builder.build());
        return this;
    }

    public DescriptorProtos$SourceCodeInfo$Builder addLocation(DescriptorProtos$SourceCodeInfo$Location descriptorProtos$SourceCodeInfo$Location) {
        if (this.locationBuilder_ != null) {
            this.locationBuilder_.addMessage(descriptorProtos$SourceCodeInfo$Location);
            return this;
        }
        if (descriptorProtos$SourceCodeInfo$Location == null) {
            throw new NullPointerException();
        }
        this.ensureLocationIsMutable();
        this.location_.add(descriptorProtos$SourceCodeInfo$Location);
        this.onChanged();
        return this;
    }

    public DescriptorProtos$SourceCodeInfo$Builder addLocation(int n2, DescriptorProtos$SourceCodeInfo$Location descriptorProtos$SourceCodeInfo$Location) {
        if (this.locationBuilder_ != null) {
            this.locationBuilder_.addMessage(n2, descriptorProtos$SourceCodeInfo$Location);
            return this;
        }
        if (descriptorProtos$SourceCodeInfo$Location == null) {
            throw new NullPointerException();
        }
        this.ensureLocationIsMutable();
        this.location_.add(n2, descriptorProtos$SourceCodeInfo$Location);
        this.onChanged();
        return this;
    }

    public DescriptorProtos$SourceCodeInfo$Builder addLocation(DescriptorProtos$SourceCodeInfo$Location$Builder descriptorProtos$SourceCodeInfo$Location$Builder) {
        if (this.locationBuilder_ == null) {
            this.ensureLocationIsMutable();
            this.location_.add(descriptorProtos$SourceCodeInfo$Location$Builder.build());
            this.onChanged();
            return this;
        }
        this.locationBuilder_.addMessage(descriptorProtos$SourceCodeInfo$Location$Builder.build());
        return this;
    }

    public DescriptorProtos$SourceCodeInfo$Builder addLocation(int n2, DescriptorProtos$SourceCodeInfo$Location$Builder descriptorProtos$SourceCodeInfo$Location$Builder) {
        if (this.locationBuilder_ == null) {
            this.ensureLocationIsMutable();
            this.location_.add(n2, descriptorProtos$SourceCodeInfo$Location$Builder.build());
            this.onChanged();
            return this;
        }
        this.locationBuilder_.addMessage(n2, descriptorProtos$SourceCodeInfo$Location$Builder.build());
        return this;
    }

    public DescriptorProtos$SourceCodeInfo$Builder addAllLocation(Iterable iterable) {
        if (this.locationBuilder_ == null) {
            this.ensureLocationIsMutable();
            AbstractMessageLite$Builder.addAll(iterable, this.location_);
            this.onChanged();
            return this;
        }
        this.locationBuilder_.addAllMessages(iterable);
        return this;
    }

    public DescriptorProtos$SourceCodeInfo$Builder clearLocation() {
        if (this.locationBuilder_ == null) {
            this.location_ = Collections.emptyList();
            this.bitField0_ &= -2;
            this.onChanged();
            return this;
        }
        this.locationBuilder_.clear();
        return this;
    }

    public DescriptorProtos$SourceCodeInfo$Builder removeLocation(int n2) {
        if (this.locationBuilder_ == null) {
            this.ensureLocationIsMutable();
            this.location_.remove(n2);
            this.onChanged();
            return this;
        }
        this.locationBuilder_.remove(n2);
        return this;
    }

    public DescriptorProtos$SourceCodeInfo$Location$Builder getLocationBuilder(int n2) {
        return (DescriptorProtos$SourceCodeInfo$Location$Builder)this.getLocationFieldBuilder().getBuilder(n2);
    }

    @Override
    public DescriptorProtos$SourceCodeInfo$LocationOrBuilder getLocationOrBuilder(int n2) {
        if (this.locationBuilder_ != null) return (DescriptorProtos$SourceCodeInfo$LocationOrBuilder)this.locationBuilder_.getMessageOrBuilder(n2);
        return (DescriptorProtos$SourceCodeInfo$LocationOrBuilder)this.location_.get(n2);
    }

    @Override
    public List getLocationOrBuilderList() {
        if (this.locationBuilder_ == null) return Collections.unmodifiableList(this.location_);
        return this.locationBuilder_.getMessageOrBuilderList();
    }

    public DescriptorProtos$SourceCodeInfo$Location$Builder addLocationBuilder() {
        return (DescriptorProtos$SourceCodeInfo$Location$Builder)this.getLocationFieldBuilder().addBuilder(DescriptorProtos$SourceCodeInfo$Location.getDefaultInstance());
    }

    public DescriptorProtos$SourceCodeInfo$Location$Builder addLocationBuilder(int n2) {
        return (DescriptorProtos$SourceCodeInfo$Location$Builder)this.getLocationFieldBuilder().addBuilder(n2, DescriptorProtos$SourceCodeInfo$Location.getDefaultInstance());
    }

    public List getLocationBuilderList() {
        return this.getLocationFieldBuilder().getBuilderList();
    }

    private RepeatedFieldBuilder getLocationFieldBuilder() {
        if (this.locationBuilder_ != null) return this.locationBuilder_;
        this.locationBuilder_ = new RepeatedFieldBuilder(this.location_, (this.bitField0_ & 1) == 1, this.getParentForChildren(), this.isClean());
        this.location_ = null;
        return this.locationBuilder_;
    }

    /* synthetic */ DescriptorProtos$SourceCodeInfo$Builder(DescriptorProtos$1 descriptorProtos$1) {
        this();
    }

    /* synthetic */ DescriptorProtos$SourceCodeInfo$Builder(GeneratedMessage$BuilderParent generatedMessage$BuilderParent, DescriptorProtos$1 descriptorProtos$1) {
        this(generatedMessage$BuilderParent);
    }
}

