package com.google.protobuf;

import java.util.*;
import java.io.*;

public final class FieldMask$Builder extends GeneratedMessage$Builder implements FieldMaskOrBuilder
{
    private int bitField0_;
    private LazyStringList paths_;
    
    public static final Descriptors$Descriptor getDescriptor() {
        return FieldMaskProto.internal_static_google_protobuf_FieldMask_descriptor;
    }
    
    protected GeneratedMessage$FieldAccessorTable internalGetFieldAccessorTable() {
        return FieldMaskProto.internal_static_google_protobuf_FieldMask_fieldAccessorTable.ensureFieldAccessorsInitialized(FieldMask.class, FieldMask$Builder.class);
    }
    
    private FieldMask$Builder() {
        this.paths_ = LazyStringArrayList.EMPTY;
        this.maybeForceBuilderInitialization();
    }
    
    private FieldMask$Builder(final GeneratedMessage$BuilderParent generatedMessage$BuilderParent) {
        super(generatedMessage$BuilderParent);
        this.paths_ = LazyStringArrayList.EMPTY;
        this.maybeForceBuilderInitialization();
    }
    
    private void maybeForceBuilderInitialization() {
        if (GeneratedMessage.alwaysUseFieldBuilders) {}
    }
    
    public FieldMask$Builder clear() {
        super.clear();
        this.paths_ = LazyStringArrayList.EMPTY;
        this.bitField0_ &= 0xFFFFFFFE;
        return this;
    }
    
    public Descriptors$Descriptor getDescriptorForType() {
        return FieldMaskProto.internal_static_google_protobuf_FieldMask_descriptor;
    }
    
    public FieldMask getDefaultInstanceForType() {
        return FieldMask.getDefaultInstance();
    }
    
    public FieldMask build() {
        final FieldMask buildPartial = this.buildPartial();
        if (!buildPartial.isInitialized()) {
            throw AbstractMessage$Builder.newUninitializedMessageException(buildPartial);
        }
        return buildPartial;
    }
    
    public FieldMask buildPartial() {
        final FieldMask fieldMask = new FieldMask(this, null);
        final int bitField0_ = this.bitField0_;
        if ((this.bitField0_ & 0x1) == 0x1) {
            this.paths_ = this.paths_.getUnmodifiableView();
            this.bitField0_ &= 0xFFFFFFFE;
        }
        fieldMask.paths_ = this.paths_;
        this.onBuilt();
        return fieldMask;
    }
    
    public FieldMask$Builder mergeFrom(final Message message) {
        if (message instanceof FieldMask) {
            return this.mergeFrom((FieldMask)message);
        }
        super.mergeFrom(message);
        return this;
    }
    
    public FieldMask$Builder mergeFrom(final FieldMask fieldMask) {
        if (fieldMask == FieldMask.getDefaultInstance()) {
            return this;
        }
        if (!fieldMask.paths_.isEmpty()) {
            if (this.paths_.isEmpty()) {
                this.paths_ = fieldMask.paths_;
                this.bitField0_ &= 0xFFFFFFFE;
            }
            else {
                this.ensurePathsIsMutable();
                this.paths_.addAll(fieldMask.paths_);
            }
            this.onChanged();
        }
        this.onChanged();
        return this;
    }
    
    public final boolean isInitialized() {
        return true;
    }
    
    public FieldMask$Builder mergeFrom(final CodedInputStream codedInputStream, final ExtensionRegistryLite extensionRegistryLite) {
        FieldMask fieldMask = null;
        try {
            fieldMask = (FieldMask)FieldMask.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
        }
        catch (InvalidProtocolBufferException ex) {
            fieldMask = (FieldMask)ex.getUnfinishedMessage();
            throw ex;
        }
        finally {
            if (fieldMask != null) {
                this.mergeFrom(fieldMask);
            }
        }
        return this;
    }
    
    private void ensurePathsIsMutable() {
        if ((this.bitField0_ & 0x1) != 0x1) {
            this.paths_ = new LazyStringArrayList(this.paths_);
            this.bitField0_ |= 0x1;
        }
    }
    
    public ProtocolStringList getPathsList() {
        return this.paths_.getUnmodifiableView();
    }
    
    public int getPathsCount() {
        return this.paths_.size();
    }
    
    public String getPaths(final int n) {
        return this.paths_.get(n);
    }
    
    public ByteString getPathsBytes(final int n) {
        return this.paths_.getByteString(n);
    }
    
    public FieldMask$Builder setPaths(final int n, final String s) {
        if (s == null) {
            throw new NullPointerException();
        }
        this.ensurePathsIsMutable();
        this.paths_.set(n, s);
        this.onChanged();
        return this;
    }
    
    public FieldMask$Builder addPaths(final String s) {
        if (s == null) {
            throw new NullPointerException();
        }
        this.ensurePathsIsMutable();
        this.paths_.add(s);
        this.onChanged();
        return this;
    }
    
    public FieldMask$Builder addAllPaths(final Iterable iterable) {
        this.ensurePathsIsMutable();
        AbstractMessageLite$Builder.addAll(iterable, this.paths_);
        this.onChanged();
        return this;
    }
    
    public FieldMask$Builder clearPaths() {
        this.paths_ = LazyStringArrayList.EMPTY;
        this.bitField0_ &= 0xFFFFFFFE;
        this.onChanged();
        return this;
    }
    
    public FieldMask$Builder addPathsBytes(final ByteString byteString) {
        if (byteString == null) {
            throw new NullPointerException();
        }
        this.ensurePathsIsMutable();
        this.paths_.add(byteString);
        this.onChanged();
        return this;
    }
    
    public final FieldMask$Builder setUnknownFields(final UnknownFieldSet set) {
        return this;
    }
    
    public final FieldMask$Builder mergeUnknownFields(final UnknownFieldSet set) {
        return this;
    }
}
