/*
 * Decompiled with CFR 0_115.
 */
package com.google.protobuf;

import com.google.protobuf.AbstractMessage$Builder;
import com.google.protobuf.AbstractMessageLite$Builder;
import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.Descriptors$Descriptor;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.FieldMask;
import com.google.protobuf.FieldMask$1;
import com.google.protobuf.FieldMaskOrBuilder;
import com.google.protobuf.FieldMaskProto;
import com.google.protobuf.GeneratedMessage;
import com.google.protobuf.GeneratedMessage$Builder;
import com.google.protobuf.GeneratedMessage$BuilderParent;
import com.google.protobuf.GeneratedMessage$FieldAccessorTable;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.LazyStringArrayList;
import com.google.protobuf.LazyStringList;
import com.google.protobuf.Message;
import com.google.protobuf.Message$Builder;
import com.google.protobuf.MessageLite;
import com.google.protobuf.MessageLite$Builder;
import com.google.protobuf.Parser;
import com.google.protobuf.ProtocolStringList;
import com.google.protobuf.UnknownFieldSet;
import java.util.Collection;

public final class FieldMask$Builder
extends GeneratedMessage$Builder
implements FieldMaskOrBuilder {
    private int bitField0_;
    private LazyStringList paths_ = LazyStringArrayList.EMPTY;

    public static final Descriptors$Descriptor getDescriptor() {
        return FieldMaskProto.internal_static_google_protobuf_FieldMask_descriptor;
    }

    @Override
    protected GeneratedMessage$FieldAccessorTable internalGetFieldAccessorTable() {
        return FieldMaskProto.internal_static_google_protobuf_FieldMask_fieldAccessorTable.ensureFieldAccessorsInitialized(FieldMask.class, FieldMask$Builder.class);
    }

    private FieldMask$Builder() {
        this.maybeForceBuilderInitialization();
    }

    private FieldMask$Builder(GeneratedMessage$BuilderParent generatedMessage$BuilderParent) {
        super(generatedMessage$BuilderParent);
        this.maybeForceBuilderInitialization();
    }

    private void maybeForceBuilderInitialization() {
        if (!GeneratedMessage.alwaysUseFieldBuilders) return;
    }

    @Override
    public FieldMask$Builder clear() {
        super.clear();
        this.paths_ = LazyStringArrayList.EMPTY;
        this.bitField0_ &= -2;
        return this;
    }

    @Override
    public Descriptors$Descriptor getDescriptorForType() {
        return FieldMaskProto.internal_static_google_protobuf_FieldMask_descriptor;
    }

    @Override
    public FieldMask getDefaultInstanceForType() {
        return FieldMask.getDefaultInstance();
    }

    @Override
    public FieldMask build() {
        FieldMask fieldMask = this.buildPartial();
        if (fieldMask.isInitialized()) return fieldMask;
        throw FieldMask$Builder.newUninitializedMessageException(fieldMask);
    }

    @Override
    public FieldMask buildPartial() {
        FieldMask fieldMask = new FieldMask(this, null);
        int n2 = this.bitField0_;
        if ((this.bitField0_ & 1) == 1) {
            this.paths_ = this.paths_.getUnmodifiableView();
            this.bitField0_ &= -2;
        }
        FieldMask.access$302(fieldMask, this.paths_);
        this.onBuilt();
        return fieldMask;
    }

    @Override
    public FieldMask$Builder mergeFrom(Message message) {
        if (message instanceof FieldMask) {
            return this.mergeFrom((FieldMask)message);
        }
        super.mergeFrom(message);
        return this;
    }

    public FieldMask$Builder mergeFrom(FieldMask fieldMask) {
        if (fieldMask == FieldMask.getDefaultInstance()) {
            return this;
        }
        if (!FieldMask.access$300(fieldMask).isEmpty()) {
            if (this.paths_.isEmpty()) {
                this.paths_ = FieldMask.access$300(fieldMask);
                this.bitField0_ &= -2;
            } else {
                this.ensurePathsIsMutable();
                this.paths_.addAll(FieldMask.access$300(fieldMask));
            }
            this.onChanged();
        }
        this.onChanged();
        return this;
    }

    @Override
    public final boolean isInitialized() {
        return true;
    }

    @Override
    public FieldMask$Builder mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        FieldMask fieldMask = null;
        try {
            try {
                fieldMask = (FieldMask)FieldMask.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
            }
            catch (InvalidProtocolBufferException var4_6) {
                fieldMask = (FieldMask)var4_6.getUnfinishedMessage();
                throw var4_6;
            }
            Object var6_4 = null;
            if (fieldMask == null) return this;
            this.mergeFrom(fieldMask);
            return this;
        }
        catch (Throwable var5_7) {
            Object var6_5 = null;
            if (fieldMask == null) throw var5_7;
            this.mergeFrom(fieldMask);
            throw var5_7;
        }
    }

    private void ensurePathsIsMutable() {
        if ((this.bitField0_ & 1) == 1) return;
        this.paths_ = new LazyStringArrayList(this.paths_);
        this.bitField0_ |= 1;
    }

    @Override
    public ProtocolStringList getPathsList() {
        return this.paths_.getUnmodifiableView();
    }

    @Override
    public int getPathsCount() {
        return this.paths_.size();
    }

    @Override
    public String getPaths(int n2) {
        return (String)this.paths_.get(n2);
    }

    @Override
    public ByteString getPathsBytes(int n2) {
        return this.paths_.getByteString(n2);
    }

    public FieldMask$Builder setPaths(int n2, String string) {
        if (string == null) {
            throw new NullPointerException();
        }
        this.ensurePathsIsMutable();
        this.paths_.set(n2, string);
        this.onChanged();
        return this;
    }

    public FieldMask$Builder addPaths(String string) {
        if (string == null) {
            throw new NullPointerException();
        }
        this.ensurePathsIsMutable();
        this.paths_.add(string);
        this.onChanged();
        return this;
    }

    public FieldMask$Builder addAllPaths(Iterable iterable) {
        this.ensurePathsIsMutable();
        AbstractMessageLite$Builder.addAll(iterable, this.paths_);
        this.onChanged();
        return this;
    }

    public FieldMask$Builder clearPaths() {
        this.paths_ = LazyStringArrayList.EMPTY;
        this.bitField0_ &= -2;
        this.onChanged();
        return this;
    }

    public FieldMask$Builder addPathsBytes(ByteString byteString) {
        if (byteString == null) {
            throw new NullPointerException();
        }
        this.ensurePathsIsMutable();
        this.paths_.add(byteString);
        this.onChanged();
        return this;
    }

    @Override
    public final FieldMask$Builder setUnknownFields(UnknownFieldSet unknownFieldSet) {
        return this;
    }

    @Override
    public final FieldMask$Builder mergeUnknownFields(UnknownFieldSet unknownFieldSet) {
        return this;
    }

    /* synthetic */ FieldMask$Builder(FieldMask$1 fieldMask$1) {
        this();
    }

    /* synthetic */ FieldMask$Builder(GeneratedMessage$BuilderParent generatedMessage$BuilderParent, FieldMask$1 fieldMask$1) {
        this(generatedMessage$BuilderParent);
    }
}

