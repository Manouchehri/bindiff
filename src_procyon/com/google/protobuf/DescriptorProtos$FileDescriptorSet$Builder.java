package com.google.protobuf;

import java.util.*;
import java.io.*;

public final class DescriptorProtos$FileDescriptorSet$Builder extends GeneratedMessage$Builder implements DescriptorProtos$FileDescriptorSetOrBuilder
{
    private int bitField0_;
    private List file_;
    private RepeatedFieldBuilder fileBuilder_;
    
    public static final Descriptors$Descriptor getDescriptor() {
        return DescriptorProtos.internal_static_google_protobuf_FileDescriptorSet_descriptor;
    }
    
    protected GeneratedMessage$FieldAccessorTable internalGetFieldAccessorTable() {
        return DescriptorProtos.internal_static_google_protobuf_FileDescriptorSet_fieldAccessorTable.ensureFieldAccessorsInitialized(DescriptorProtos$FileDescriptorSet.class, DescriptorProtos$FileDescriptorSet$Builder.class);
    }
    
    private DescriptorProtos$FileDescriptorSet$Builder() {
        this.file_ = Collections.emptyList();
        this.maybeForceBuilderInitialization();
    }
    
    private DescriptorProtos$FileDescriptorSet$Builder(final GeneratedMessage$BuilderParent generatedMessage$BuilderParent) {
        super(generatedMessage$BuilderParent);
        this.file_ = Collections.emptyList();
        this.maybeForceBuilderInitialization();
    }
    
    private void maybeForceBuilderInitialization() {
        if (GeneratedMessage.alwaysUseFieldBuilders) {
            this.getFileFieldBuilder();
        }
    }
    
    public DescriptorProtos$FileDescriptorSet$Builder clear() {
        super.clear();
        if (this.fileBuilder_ == null) {
            this.file_ = Collections.emptyList();
            this.bitField0_ &= 0xFFFFFFFE;
        }
        else {
            this.fileBuilder_.clear();
        }
        return this;
    }
    
    public Descriptors$Descriptor getDescriptorForType() {
        return DescriptorProtos.internal_static_google_protobuf_FileDescriptorSet_descriptor;
    }
    
    public DescriptorProtos$FileDescriptorSet getDefaultInstanceForType() {
        return DescriptorProtos$FileDescriptorSet.getDefaultInstance();
    }
    
    public DescriptorProtos$FileDescriptorSet build() {
        final DescriptorProtos$FileDescriptorSet buildPartial = this.buildPartial();
        if (!buildPartial.isInitialized()) {
            throw AbstractMessage$Builder.newUninitializedMessageException(buildPartial);
        }
        return buildPartial;
    }
    
    public DescriptorProtos$FileDescriptorSet buildPartial() {
        final DescriptorProtos$FileDescriptorSet set = new DescriptorProtos$FileDescriptorSet(this, null);
        final int bitField0_ = this.bitField0_;
        if (this.fileBuilder_ == null) {
            if ((this.bitField0_ & 0x1) == 0x1) {
                this.file_ = Collections.unmodifiableList((List<?>)this.file_);
                this.bitField0_ &= 0xFFFFFFFE;
            }
            set.file_ = this.file_;
        }
        else {
            set.file_ = this.fileBuilder_.build();
        }
        this.onBuilt();
        return set;
    }
    
    public DescriptorProtos$FileDescriptorSet$Builder mergeFrom(final Message message) {
        if (message instanceof DescriptorProtos$FileDescriptorSet) {
            return this.mergeFrom((DescriptorProtos$FileDescriptorSet)message);
        }
        super.mergeFrom(message);
        return this;
    }
    
    public DescriptorProtos$FileDescriptorSet$Builder mergeFrom(final DescriptorProtos$FileDescriptorSet set) {
        if (set == DescriptorProtos$FileDescriptorSet.getDefaultInstance()) {
            return this;
        }
        if (this.fileBuilder_ == null) {
            if (!set.file_.isEmpty()) {
                if (this.file_.isEmpty()) {
                    this.file_ = set.file_;
                    this.bitField0_ &= 0xFFFFFFFE;
                }
                else {
                    this.ensureFileIsMutable();
                    this.file_.addAll(set.file_);
                }
                this.onChanged();
            }
        }
        else if (!set.file_.isEmpty()) {
            if (this.fileBuilder_.isEmpty()) {
                this.fileBuilder_.dispose();
                this.fileBuilder_ = null;
                this.file_ = set.file_;
                this.bitField0_ &= 0xFFFFFFFE;
                this.fileBuilder_ = (GeneratedMessage.alwaysUseFieldBuilders ? this.getFileFieldBuilder() : null);
            }
            else {
                this.fileBuilder_.addAllMessages(set.file_);
            }
        }
        this.mergeUnknownFields(set.unknownFields);
        this.onChanged();
        return this;
    }
    
    public final boolean isInitialized() {
        for (int i = 0; i < this.getFileCount(); ++i) {
            if (!this.getFile(i).isInitialized()) {
                return false;
            }
        }
        return true;
    }
    
    public DescriptorProtos$FileDescriptorSet$Builder mergeFrom(final CodedInputStream codedInputStream, final ExtensionRegistryLite extensionRegistryLite) {
        DescriptorProtos$FileDescriptorSet set = null;
        try {
            set = (DescriptorProtos$FileDescriptorSet)DescriptorProtos$FileDescriptorSet.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
        }
        catch (InvalidProtocolBufferException ex) {
            set = (DescriptorProtos$FileDescriptorSet)ex.getUnfinishedMessage();
            throw ex;
        }
        finally {
            if (set != null) {
                this.mergeFrom(set);
            }
        }
        return this;
    }
    
    private void ensureFileIsMutable() {
        if ((this.bitField0_ & 0x1) != 0x1) {
            this.file_ = new ArrayList(this.file_);
            this.bitField0_ |= 0x1;
        }
    }
    
    public List getFileList() {
        if (this.fileBuilder_ == null) {
            return Collections.unmodifiableList((List<?>)this.file_);
        }
        return this.fileBuilder_.getMessageList();
    }
    
    public int getFileCount() {
        if (this.fileBuilder_ == null) {
            return this.file_.size();
        }
        return this.fileBuilder_.getCount();
    }
    
    public DescriptorProtos$FileDescriptorProto getFile(final int n) {
        if (this.fileBuilder_ == null) {
            return this.file_.get(n);
        }
        return (DescriptorProtos$FileDescriptorProto)this.fileBuilder_.getMessage(n);
    }
    
    public DescriptorProtos$FileDescriptorSet$Builder setFile(final int n, final DescriptorProtos$FileDescriptorProto descriptorProtos$FileDescriptorProto) {
        if (this.fileBuilder_ == null) {
            if (descriptorProtos$FileDescriptorProto == null) {
                throw new NullPointerException();
            }
            this.ensureFileIsMutable();
            this.file_.set(n, descriptorProtos$FileDescriptorProto);
            this.onChanged();
        }
        else {
            this.fileBuilder_.setMessage(n, descriptorProtos$FileDescriptorProto);
        }
        return this;
    }
    
    public DescriptorProtos$FileDescriptorSet$Builder setFile(final int n, final DescriptorProtos$FileDescriptorProto$Builder descriptorProtos$FileDescriptorProto$Builder) {
        if (this.fileBuilder_ == null) {
            this.ensureFileIsMutable();
            this.file_.set(n, descriptorProtos$FileDescriptorProto$Builder.build());
            this.onChanged();
        }
        else {
            this.fileBuilder_.setMessage(n, descriptorProtos$FileDescriptorProto$Builder.build());
        }
        return this;
    }
    
    public DescriptorProtos$FileDescriptorSet$Builder addFile(final DescriptorProtos$FileDescriptorProto descriptorProtos$FileDescriptorProto) {
        if (this.fileBuilder_ == null) {
            if (descriptorProtos$FileDescriptorProto == null) {
                throw new NullPointerException();
            }
            this.ensureFileIsMutable();
            this.file_.add(descriptorProtos$FileDescriptorProto);
            this.onChanged();
        }
        else {
            this.fileBuilder_.addMessage(descriptorProtos$FileDescriptorProto);
        }
        return this;
    }
    
    public DescriptorProtos$FileDescriptorSet$Builder addFile(final int n, final DescriptorProtos$FileDescriptorProto descriptorProtos$FileDescriptorProto) {
        if (this.fileBuilder_ == null) {
            if (descriptorProtos$FileDescriptorProto == null) {
                throw new NullPointerException();
            }
            this.ensureFileIsMutable();
            this.file_.add(n, descriptorProtos$FileDescriptorProto);
            this.onChanged();
        }
        else {
            this.fileBuilder_.addMessage(n, descriptorProtos$FileDescriptorProto);
        }
        return this;
    }
    
    public DescriptorProtos$FileDescriptorSet$Builder addFile(final DescriptorProtos$FileDescriptorProto$Builder descriptorProtos$FileDescriptorProto$Builder) {
        if (this.fileBuilder_ == null) {
            this.ensureFileIsMutable();
            this.file_.add(descriptorProtos$FileDescriptorProto$Builder.build());
            this.onChanged();
        }
        else {
            this.fileBuilder_.addMessage(descriptorProtos$FileDescriptorProto$Builder.build());
        }
        return this;
    }
    
    public DescriptorProtos$FileDescriptorSet$Builder addFile(final int n, final DescriptorProtos$FileDescriptorProto$Builder descriptorProtos$FileDescriptorProto$Builder) {
        if (this.fileBuilder_ == null) {
            this.ensureFileIsMutable();
            this.file_.add(n, descriptorProtos$FileDescriptorProto$Builder.build());
            this.onChanged();
        }
        else {
            this.fileBuilder_.addMessage(n, descriptorProtos$FileDescriptorProto$Builder.build());
        }
        return this;
    }
    
    public DescriptorProtos$FileDescriptorSet$Builder addAllFile(final Iterable iterable) {
        if (this.fileBuilder_ == null) {
            this.ensureFileIsMutable();
            AbstractMessageLite$Builder.addAll(iterable, this.file_);
            this.onChanged();
        }
        else {
            this.fileBuilder_.addAllMessages(iterable);
        }
        return this;
    }
    
    public DescriptorProtos$FileDescriptorSet$Builder clearFile() {
        if (this.fileBuilder_ == null) {
            this.file_ = Collections.emptyList();
            this.bitField0_ &= 0xFFFFFFFE;
            this.onChanged();
        }
        else {
            this.fileBuilder_.clear();
        }
        return this;
    }
    
    public DescriptorProtos$FileDescriptorSet$Builder removeFile(final int n) {
        if (this.fileBuilder_ == null) {
            this.ensureFileIsMutable();
            this.file_.remove(n);
            this.onChanged();
        }
        else {
            this.fileBuilder_.remove(n);
        }
        return this;
    }
    
    public DescriptorProtos$FileDescriptorProto$Builder getFileBuilder(final int n) {
        return (DescriptorProtos$FileDescriptorProto$Builder)this.getFileFieldBuilder().getBuilder(n);
    }
    
    public DescriptorProtos$FileDescriptorProtoOrBuilder getFileOrBuilder(final int n) {
        if (this.fileBuilder_ == null) {
            return this.file_.get(n);
        }
        return (DescriptorProtos$FileDescriptorProtoOrBuilder)this.fileBuilder_.getMessageOrBuilder(n);
    }
    
    public List getFileOrBuilderList() {
        if (this.fileBuilder_ != null) {
            return this.fileBuilder_.getMessageOrBuilderList();
        }
        return Collections.unmodifiableList((List<?>)this.file_);
    }
    
    public DescriptorProtos$FileDescriptorProto$Builder addFileBuilder() {
        return (DescriptorProtos$FileDescriptorProto$Builder)this.getFileFieldBuilder().addBuilder(DescriptorProtos$FileDescriptorProto.getDefaultInstance());
    }
    
    public DescriptorProtos$FileDescriptorProto$Builder addFileBuilder(final int n) {
        return (DescriptorProtos$FileDescriptorProto$Builder)this.getFileFieldBuilder().addBuilder(n, DescriptorProtos$FileDescriptorProto.getDefaultInstance());
    }
    
    public List getFileBuilderList() {
        return this.getFileFieldBuilder().getBuilderList();
    }
    
    private RepeatedFieldBuilder getFileFieldBuilder() {
        if (this.fileBuilder_ == null) {
            this.fileBuilder_ = new RepeatedFieldBuilder(this.file_, (this.bitField0_ & 0x1) == 0x1, this.getParentForChildren(), this.isClean());
            this.file_ = null;
        }
        return this.fileBuilder_;
    }
}
