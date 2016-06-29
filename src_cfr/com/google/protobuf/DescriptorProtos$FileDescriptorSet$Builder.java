/*
 * Decompiled with CFR 0_115.
 */
package com.google.protobuf;

import com.google.protobuf.AbstractMessage$Builder;
import com.google.protobuf.AbstractMessageLite$Builder;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.DescriptorProtos;
import com.google.protobuf.DescriptorProtos$1;
import com.google.protobuf.DescriptorProtos$FileDescriptorProto;
import com.google.protobuf.DescriptorProtos$FileDescriptorProto$Builder;
import com.google.protobuf.DescriptorProtos$FileDescriptorProtoOrBuilder;
import com.google.protobuf.DescriptorProtos$FileDescriptorSet;
import com.google.protobuf.DescriptorProtos$FileDescriptorSetOrBuilder;
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

public final class DescriptorProtos$FileDescriptorSet$Builder
extends GeneratedMessage$Builder
implements DescriptorProtos$FileDescriptorSetOrBuilder {
    private int bitField0_;
    private List file_ = Collections.emptyList();
    private RepeatedFieldBuilder fileBuilder_;

    public static final Descriptors$Descriptor getDescriptor() {
        return DescriptorProtos.access$000();
    }

    @Override
    protected GeneratedMessage$FieldAccessorTable internalGetFieldAccessorTable() {
        return DescriptorProtos.access$100().ensureFieldAccessorsInitialized(DescriptorProtos$FileDescriptorSet.class, DescriptorProtos$FileDescriptorSet$Builder.class);
    }

    private DescriptorProtos$FileDescriptorSet$Builder() {
        this.maybeForceBuilderInitialization();
    }

    private DescriptorProtos$FileDescriptorSet$Builder(GeneratedMessage$BuilderParent generatedMessage$BuilderParent) {
        super(generatedMessage$BuilderParent);
        this.maybeForceBuilderInitialization();
    }

    private void maybeForceBuilderInitialization() {
        if (!GeneratedMessage.alwaysUseFieldBuilders) return;
        this.getFileFieldBuilder();
    }

    @Override
    public DescriptorProtos$FileDescriptorSet$Builder clear() {
        super.clear();
        if (this.fileBuilder_ == null) {
            this.file_ = Collections.emptyList();
            this.bitField0_ &= -2;
            return this;
        }
        this.fileBuilder_.clear();
        return this;
    }

    @Override
    public Descriptors$Descriptor getDescriptorForType() {
        return DescriptorProtos.access$000();
    }

    @Override
    public DescriptorProtos$FileDescriptorSet getDefaultInstanceForType() {
        return DescriptorProtos$FileDescriptorSet.getDefaultInstance();
    }

    @Override
    public DescriptorProtos$FileDescriptorSet build() {
        DescriptorProtos$FileDescriptorSet descriptorProtos$FileDescriptorSet = this.buildPartial();
        if (descriptorProtos$FileDescriptorSet.isInitialized()) return descriptorProtos$FileDescriptorSet;
        throw DescriptorProtos$FileDescriptorSet$Builder.newUninitializedMessageException(descriptorProtos$FileDescriptorSet);
    }

    @Override
    public DescriptorProtos$FileDescriptorSet buildPartial() {
        DescriptorProtos$FileDescriptorSet descriptorProtos$FileDescriptorSet = new DescriptorProtos$FileDescriptorSet(this, null);
        int n2 = this.bitField0_;
        if (this.fileBuilder_ == null) {
            if ((this.bitField0_ & 1) == 1) {
                this.file_ = Collections.unmodifiableList(this.file_);
                this.bitField0_ &= -2;
            }
            DescriptorProtos$FileDescriptorSet.access$502(descriptorProtos$FileDescriptorSet, this.file_);
        } else {
            DescriptorProtos$FileDescriptorSet.access$502(descriptorProtos$FileDescriptorSet, this.fileBuilder_.build());
        }
        this.onBuilt();
        return descriptorProtos$FileDescriptorSet;
    }

    @Override
    public DescriptorProtos$FileDescriptorSet$Builder mergeFrom(Message message) {
        if (message instanceof DescriptorProtos$FileDescriptorSet) {
            return this.mergeFrom((DescriptorProtos$FileDescriptorSet)message);
        }
        super.mergeFrom(message);
        return this;
    }

    public DescriptorProtos$FileDescriptorSet$Builder mergeFrom(DescriptorProtos$FileDescriptorSet descriptorProtos$FileDescriptorSet) {
        if (descriptorProtos$FileDescriptorSet == DescriptorProtos$FileDescriptorSet.getDefaultInstance()) {
            return this;
        }
        if (this.fileBuilder_ == null) {
            if (!DescriptorProtos$FileDescriptorSet.access$500(descriptorProtos$FileDescriptorSet).isEmpty()) {
                if (this.file_.isEmpty()) {
                    this.file_ = DescriptorProtos$FileDescriptorSet.access$500(descriptorProtos$FileDescriptorSet);
                    this.bitField0_ &= -2;
                } else {
                    this.ensureFileIsMutable();
                    this.file_.addAll(DescriptorProtos$FileDescriptorSet.access$500(descriptorProtos$FileDescriptorSet));
                }
                this.onChanged();
            }
        } else if (!DescriptorProtos$FileDescriptorSet.access$500(descriptorProtos$FileDescriptorSet).isEmpty()) {
            if (this.fileBuilder_.isEmpty()) {
                this.fileBuilder_.dispose();
                this.fileBuilder_ = null;
                this.file_ = DescriptorProtos$FileDescriptorSet.access$500(descriptorProtos$FileDescriptorSet);
                this.bitField0_ &= -2;
                this.fileBuilder_ = GeneratedMessage.alwaysUseFieldBuilders ? this.getFileFieldBuilder() : null;
            } else {
                this.fileBuilder_.addAllMessages(DescriptorProtos$FileDescriptorSet.access$500(descriptorProtos$FileDescriptorSet));
            }
        }
        this.mergeUnknownFields(descriptorProtos$FileDescriptorSet.unknownFields);
        this.onChanged();
        return this;
    }

    @Override
    public final boolean isInitialized() {
        int n2 = 0;
        while (n2 < this.getFileCount()) {
            if (!this.getFile(n2).isInitialized()) {
                return false;
            }
            ++n2;
        }
        return true;
    }

    @Override
    public DescriptorProtos$FileDescriptorSet$Builder mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        DescriptorProtos$FileDescriptorSet descriptorProtos$FileDescriptorSet = null;
        try {
            descriptorProtos$FileDescriptorSet = (DescriptorProtos$FileDescriptorSet)DescriptorProtos$FileDescriptorSet.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
            return this;
        }
        catch (InvalidProtocolBufferException var4_4) {
            descriptorProtos$FileDescriptorSet = (DescriptorProtos$FileDescriptorSet)var4_4.getUnfinishedMessage();
            throw var4_4;
        }
        finally {
            if (descriptorProtos$FileDescriptorSet != null) {
                this.mergeFrom(descriptorProtos$FileDescriptorSet);
            }
        }
    }

    private void ensureFileIsMutable() {
        if ((this.bitField0_ & 1) == 1) return;
        this.file_ = new ArrayList(this.file_);
        this.bitField0_ |= 1;
    }

    @Override
    public List getFileList() {
        if (this.fileBuilder_ != null) return this.fileBuilder_.getMessageList();
        return Collections.unmodifiableList(this.file_);
    }

    @Override
    public int getFileCount() {
        if (this.fileBuilder_ != null) return this.fileBuilder_.getCount();
        return this.file_.size();
    }

    @Override
    public DescriptorProtos$FileDescriptorProto getFile(int n2) {
        if (this.fileBuilder_ != null) return (DescriptorProtos$FileDescriptorProto)this.fileBuilder_.getMessage(n2);
        return (DescriptorProtos$FileDescriptorProto)this.file_.get(n2);
    }

    public DescriptorProtos$FileDescriptorSet$Builder setFile(int n2, DescriptorProtos$FileDescriptorProto descriptorProtos$FileDescriptorProto) {
        if (this.fileBuilder_ != null) {
            this.fileBuilder_.setMessage(n2, descriptorProtos$FileDescriptorProto);
            return this;
        }
        if (descriptorProtos$FileDescriptorProto == null) {
            throw new NullPointerException();
        }
        this.ensureFileIsMutable();
        this.file_.set(n2, descriptorProtos$FileDescriptorProto);
        this.onChanged();
        return this;
    }

    public DescriptorProtos$FileDescriptorSet$Builder setFile(int n2, DescriptorProtos$FileDescriptorProto$Builder descriptorProtos$FileDescriptorProto$Builder) {
        if (this.fileBuilder_ == null) {
            this.ensureFileIsMutable();
            this.file_.set(n2, descriptorProtos$FileDescriptorProto$Builder.build());
            this.onChanged();
            return this;
        }
        this.fileBuilder_.setMessage(n2, descriptorProtos$FileDescriptorProto$Builder.build());
        return this;
    }

    public DescriptorProtos$FileDescriptorSet$Builder addFile(DescriptorProtos$FileDescriptorProto descriptorProtos$FileDescriptorProto) {
        if (this.fileBuilder_ != null) {
            this.fileBuilder_.addMessage(descriptorProtos$FileDescriptorProto);
            return this;
        }
        if (descriptorProtos$FileDescriptorProto == null) {
            throw new NullPointerException();
        }
        this.ensureFileIsMutable();
        this.file_.add(descriptorProtos$FileDescriptorProto);
        this.onChanged();
        return this;
    }

    public DescriptorProtos$FileDescriptorSet$Builder addFile(int n2, DescriptorProtos$FileDescriptorProto descriptorProtos$FileDescriptorProto) {
        if (this.fileBuilder_ != null) {
            this.fileBuilder_.addMessage(n2, descriptorProtos$FileDescriptorProto);
            return this;
        }
        if (descriptorProtos$FileDescriptorProto == null) {
            throw new NullPointerException();
        }
        this.ensureFileIsMutable();
        this.file_.add(n2, descriptorProtos$FileDescriptorProto);
        this.onChanged();
        return this;
    }

    public DescriptorProtos$FileDescriptorSet$Builder addFile(DescriptorProtos$FileDescriptorProto$Builder descriptorProtos$FileDescriptorProto$Builder) {
        if (this.fileBuilder_ == null) {
            this.ensureFileIsMutable();
            this.file_.add(descriptorProtos$FileDescriptorProto$Builder.build());
            this.onChanged();
            return this;
        }
        this.fileBuilder_.addMessage(descriptorProtos$FileDescriptorProto$Builder.build());
        return this;
    }

    public DescriptorProtos$FileDescriptorSet$Builder addFile(int n2, DescriptorProtos$FileDescriptorProto$Builder descriptorProtos$FileDescriptorProto$Builder) {
        if (this.fileBuilder_ == null) {
            this.ensureFileIsMutable();
            this.file_.add(n2, descriptorProtos$FileDescriptorProto$Builder.build());
            this.onChanged();
            return this;
        }
        this.fileBuilder_.addMessage(n2, descriptorProtos$FileDescriptorProto$Builder.build());
        return this;
    }

    public DescriptorProtos$FileDescriptorSet$Builder addAllFile(Iterable iterable) {
        if (this.fileBuilder_ == null) {
            this.ensureFileIsMutable();
            AbstractMessageLite$Builder.addAll(iterable, this.file_);
            this.onChanged();
            return this;
        }
        this.fileBuilder_.addAllMessages(iterable);
        return this;
    }

    public DescriptorProtos$FileDescriptorSet$Builder clearFile() {
        if (this.fileBuilder_ == null) {
            this.file_ = Collections.emptyList();
            this.bitField0_ &= -2;
            this.onChanged();
            return this;
        }
        this.fileBuilder_.clear();
        return this;
    }

    public DescriptorProtos$FileDescriptorSet$Builder removeFile(int n2) {
        if (this.fileBuilder_ == null) {
            this.ensureFileIsMutable();
            this.file_.remove(n2);
            this.onChanged();
            return this;
        }
        this.fileBuilder_.remove(n2);
        return this;
    }

    public DescriptorProtos$FileDescriptorProto$Builder getFileBuilder(int n2) {
        return (DescriptorProtos$FileDescriptorProto$Builder)this.getFileFieldBuilder().getBuilder(n2);
    }

    @Override
    public DescriptorProtos$FileDescriptorProtoOrBuilder getFileOrBuilder(int n2) {
        if (this.fileBuilder_ != null) return (DescriptorProtos$FileDescriptorProtoOrBuilder)this.fileBuilder_.getMessageOrBuilder(n2);
        return (DescriptorProtos$FileDescriptorProtoOrBuilder)this.file_.get(n2);
    }

    @Override
    public List getFileOrBuilderList() {
        if (this.fileBuilder_ == null) return Collections.unmodifiableList(this.file_);
        return this.fileBuilder_.getMessageOrBuilderList();
    }

    public DescriptorProtos$FileDescriptorProto$Builder addFileBuilder() {
        return (DescriptorProtos$FileDescriptorProto$Builder)this.getFileFieldBuilder().addBuilder(DescriptorProtos$FileDescriptorProto.getDefaultInstance());
    }

    public DescriptorProtos$FileDescriptorProto$Builder addFileBuilder(int n2) {
        return (DescriptorProtos$FileDescriptorProto$Builder)this.getFileFieldBuilder().addBuilder(n2, DescriptorProtos$FileDescriptorProto.getDefaultInstance());
    }

    public List getFileBuilderList() {
        return this.getFileFieldBuilder().getBuilderList();
    }

    private RepeatedFieldBuilder getFileFieldBuilder() {
        if (this.fileBuilder_ != null) return this.fileBuilder_;
        this.fileBuilder_ = new RepeatedFieldBuilder(this.file_, (this.bitField0_ & 1) == 1, this.getParentForChildren(), this.isClean());
        this.file_ = null;
        return this.fileBuilder_;
    }

    /* synthetic */ DescriptorProtos$FileDescriptorSet$Builder(DescriptorProtos$1 descriptorProtos$1) {
        this();
    }

    /* synthetic */ DescriptorProtos$FileDescriptorSet$Builder(GeneratedMessage$BuilderParent generatedMessage$BuilderParent, DescriptorProtos$1 descriptorProtos$1) {
        this(generatedMessage$BuilderParent);
    }
}

