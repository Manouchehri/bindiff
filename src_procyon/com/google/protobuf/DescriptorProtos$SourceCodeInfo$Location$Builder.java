package com.google.protobuf;

import java.util.*;
import java.io.*;

public final class DescriptorProtos$SourceCodeInfo$Location$Builder extends GeneratedMessage$Builder implements DescriptorProtos$SourceCodeInfo$LocationOrBuilder
{
    private int bitField0_;
    private List path_;
    private List span_;
    private Object leadingComments_;
    private Object trailingComments_;
    private LazyStringList leadingDetachedComments_;
    
    public static final Descriptors$Descriptor getDescriptor() {
        return DescriptorProtos.internal_static_google_protobuf_SourceCodeInfo_Location_descriptor;
    }
    
    protected GeneratedMessage$FieldAccessorTable internalGetFieldAccessorTable() {
        return DescriptorProtos.internal_static_google_protobuf_SourceCodeInfo_Location_fieldAccessorTable.ensureFieldAccessorsInitialized(DescriptorProtos$SourceCodeInfo$Location.class, DescriptorProtos$SourceCodeInfo$Location$Builder.class);
    }
    
    private DescriptorProtos$SourceCodeInfo$Location$Builder() {
        this.path_ = Collections.emptyList();
        this.span_ = Collections.emptyList();
        this.leadingComments_ = "";
        this.trailingComments_ = "";
        this.leadingDetachedComments_ = LazyStringArrayList.EMPTY;
        this.maybeForceBuilderInitialization();
    }
    
    private DescriptorProtos$SourceCodeInfo$Location$Builder(final GeneratedMessage$BuilderParent generatedMessage$BuilderParent) {
        super(generatedMessage$BuilderParent);
        this.path_ = Collections.emptyList();
        this.span_ = Collections.emptyList();
        this.leadingComments_ = "";
        this.trailingComments_ = "";
        this.leadingDetachedComments_ = LazyStringArrayList.EMPTY;
        this.maybeForceBuilderInitialization();
    }
    
    private void maybeForceBuilderInitialization() {
        if (GeneratedMessage.alwaysUseFieldBuilders) {}
    }
    
    public DescriptorProtos$SourceCodeInfo$Location$Builder clear() {
        super.clear();
        this.path_ = Collections.emptyList();
        this.bitField0_ &= 0xFFFFFFFE;
        this.span_ = Collections.emptyList();
        this.bitField0_ &= 0xFFFFFFFD;
        this.leadingComments_ = "";
        this.bitField0_ &= 0xFFFFFFFB;
        this.trailingComments_ = "";
        this.bitField0_ &= 0xFFFFFFF7;
        this.leadingDetachedComments_ = LazyStringArrayList.EMPTY;
        this.bitField0_ &= 0xFFFFFFEF;
        return this;
    }
    
    public Descriptors$Descriptor getDescriptorForType() {
        return DescriptorProtos.internal_static_google_protobuf_SourceCodeInfo_Location_descriptor;
    }
    
    public DescriptorProtos$SourceCodeInfo$Location getDefaultInstanceForType() {
        return DescriptorProtos$SourceCodeInfo$Location.getDefaultInstance();
    }
    
    public DescriptorProtos$SourceCodeInfo$Location build() {
        final DescriptorProtos$SourceCodeInfo$Location buildPartial = this.buildPartial();
        if (!buildPartial.isInitialized()) {
            throw AbstractMessage$Builder.newUninitializedMessageException(buildPartial);
        }
        return buildPartial;
    }
    
    public DescriptorProtos$SourceCodeInfo$Location buildPartial() {
        final DescriptorProtos$SourceCodeInfo$Location descriptorProtos$SourceCodeInfo$Location = new DescriptorProtos$SourceCodeInfo$Location(this, null);
        final int bitField0_ = this.bitField0_;
        int n = 0;
        if ((this.bitField0_ & 0x1) == 0x1) {
            this.path_ = Collections.unmodifiableList((List<?>)this.path_);
            this.bitField0_ &= 0xFFFFFFFE;
        }
        descriptorProtos$SourceCodeInfo$Location.path_ = this.path_;
        if ((this.bitField0_ & 0x2) == 0x2) {
            this.span_ = Collections.unmodifiableList((List<?>)this.span_);
            this.bitField0_ &= 0xFFFFFFFD;
        }
        descriptorProtos$SourceCodeInfo$Location.span_ = this.span_;
        if ((bitField0_ & 0x4) == 0x4) {
            n |= 0x1;
        }
        descriptorProtos$SourceCodeInfo$Location.leadingComments_ = this.leadingComments_;
        if ((bitField0_ & 0x8) == 0x8) {
            n |= 0x2;
        }
        descriptorProtos$SourceCodeInfo$Location.trailingComments_ = this.trailingComments_;
        if ((this.bitField0_ & 0x10) == 0x10) {
            this.leadingDetachedComments_ = this.leadingDetachedComments_.getUnmodifiableView();
            this.bitField0_ &= 0xFFFFFFEF;
        }
        descriptorProtos$SourceCodeInfo$Location.leadingDetachedComments_ = this.leadingDetachedComments_;
        descriptorProtos$SourceCodeInfo$Location.bitField0_ = n;
        this.onBuilt();
        return descriptorProtos$SourceCodeInfo$Location;
    }
    
    public DescriptorProtos$SourceCodeInfo$Location$Builder mergeFrom(final Message message) {
        if (message instanceof DescriptorProtos$SourceCodeInfo$Location) {
            return this.mergeFrom((DescriptorProtos$SourceCodeInfo$Location)message);
        }
        super.mergeFrom(message);
        return this;
    }
    
    public DescriptorProtos$SourceCodeInfo$Location$Builder mergeFrom(final DescriptorProtos$SourceCodeInfo$Location descriptorProtos$SourceCodeInfo$Location) {
        if (descriptorProtos$SourceCodeInfo$Location == DescriptorProtos$SourceCodeInfo$Location.getDefaultInstance()) {
            return this;
        }
        if (!descriptorProtos$SourceCodeInfo$Location.path_.isEmpty()) {
            if (this.path_.isEmpty()) {
                this.path_ = descriptorProtos$SourceCodeInfo$Location.path_;
                this.bitField0_ &= 0xFFFFFFFE;
            }
            else {
                this.ensurePathIsMutable();
                this.path_.addAll(descriptorProtos$SourceCodeInfo$Location.path_);
            }
            this.onChanged();
        }
        if (!descriptorProtos$SourceCodeInfo$Location.span_.isEmpty()) {
            if (this.span_.isEmpty()) {
                this.span_ = descriptorProtos$SourceCodeInfo$Location.span_;
                this.bitField0_ &= 0xFFFFFFFD;
            }
            else {
                this.ensureSpanIsMutable();
                this.span_.addAll(descriptorProtos$SourceCodeInfo$Location.span_);
            }
            this.onChanged();
        }
        if (descriptorProtos$SourceCodeInfo$Location.hasLeadingComments()) {
            this.bitField0_ |= 0x4;
            this.leadingComments_ = descriptorProtos$SourceCodeInfo$Location.leadingComments_;
            this.onChanged();
        }
        if (descriptorProtos$SourceCodeInfo$Location.hasTrailingComments()) {
            this.bitField0_ |= 0x8;
            this.trailingComments_ = descriptorProtos$SourceCodeInfo$Location.trailingComments_;
            this.onChanged();
        }
        if (!descriptorProtos$SourceCodeInfo$Location.leadingDetachedComments_.isEmpty()) {
            if (this.leadingDetachedComments_.isEmpty()) {
                this.leadingDetachedComments_ = descriptorProtos$SourceCodeInfo$Location.leadingDetachedComments_;
                this.bitField0_ &= 0xFFFFFFEF;
            }
            else {
                this.ensureLeadingDetachedCommentsIsMutable();
                this.leadingDetachedComments_.addAll(descriptorProtos$SourceCodeInfo$Location.leadingDetachedComments_);
            }
            this.onChanged();
        }
        this.mergeUnknownFields(descriptorProtos$SourceCodeInfo$Location.unknownFields);
        this.onChanged();
        return this;
    }
    
    public final boolean isInitialized() {
        return true;
    }
    
    public DescriptorProtos$SourceCodeInfo$Location$Builder mergeFrom(final CodedInputStream codedInputStream, final ExtensionRegistryLite extensionRegistryLite) {
        DescriptorProtos$SourceCodeInfo$Location descriptorProtos$SourceCodeInfo$Location = null;
        try {
            descriptorProtos$SourceCodeInfo$Location = (DescriptorProtos$SourceCodeInfo$Location)DescriptorProtos$SourceCodeInfo$Location.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
        }
        catch (InvalidProtocolBufferException ex) {
            descriptorProtos$SourceCodeInfo$Location = (DescriptorProtos$SourceCodeInfo$Location)ex.getUnfinishedMessage();
            throw ex;
        }
        finally {
            if (descriptorProtos$SourceCodeInfo$Location != null) {
                this.mergeFrom(descriptorProtos$SourceCodeInfo$Location);
            }
        }
        return this;
    }
    
    private void ensurePathIsMutable() {
        if ((this.bitField0_ & 0x1) != 0x1) {
            this.path_ = new ArrayList(this.path_);
            this.bitField0_ |= 0x1;
        }
    }
    
    public List getPathList() {
        return Collections.unmodifiableList((List<?>)this.path_);
    }
    
    public int getPathCount() {
        return this.path_.size();
    }
    
    public int getPath(final int n) {
        return this.path_.get(n);
    }
    
    public DescriptorProtos$SourceCodeInfo$Location$Builder setPath(final int n, final int n2) {
        this.ensurePathIsMutable();
        this.path_.set(n, n2);
        this.onChanged();
        return this;
    }
    
    public DescriptorProtos$SourceCodeInfo$Location$Builder addPath(final int n) {
        this.ensurePathIsMutable();
        this.path_.add(n);
        this.onChanged();
        return this;
    }
    
    public DescriptorProtos$SourceCodeInfo$Location$Builder addAllPath(final Iterable iterable) {
        this.ensurePathIsMutable();
        AbstractMessageLite$Builder.addAll(iterable, this.path_);
        this.onChanged();
        return this;
    }
    
    public DescriptorProtos$SourceCodeInfo$Location$Builder clearPath() {
        this.path_ = Collections.emptyList();
        this.bitField0_ &= 0xFFFFFFFE;
        this.onChanged();
        return this;
    }
    
    private void ensureSpanIsMutable() {
        if ((this.bitField0_ & 0x2) != 0x2) {
            this.span_ = new ArrayList(this.span_);
            this.bitField0_ |= 0x2;
        }
    }
    
    public List getSpanList() {
        return Collections.unmodifiableList((List<?>)this.span_);
    }
    
    public int getSpanCount() {
        return this.span_.size();
    }
    
    public int getSpan(final int n) {
        return this.span_.get(n);
    }
    
    public DescriptorProtos$SourceCodeInfo$Location$Builder setSpan(final int n, final int n2) {
        this.ensureSpanIsMutable();
        this.span_.set(n, n2);
        this.onChanged();
        return this;
    }
    
    public DescriptorProtos$SourceCodeInfo$Location$Builder addSpan(final int n) {
        this.ensureSpanIsMutable();
        this.span_.add(n);
        this.onChanged();
        return this;
    }
    
    public DescriptorProtos$SourceCodeInfo$Location$Builder addAllSpan(final Iterable iterable) {
        this.ensureSpanIsMutable();
        AbstractMessageLite$Builder.addAll(iterable, this.span_);
        this.onChanged();
        return this;
    }
    
    public DescriptorProtos$SourceCodeInfo$Location$Builder clearSpan() {
        this.span_ = Collections.emptyList();
        this.bitField0_ &= 0xFFFFFFFD;
        this.onChanged();
        return this;
    }
    
    public boolean hasLeadingComments() {
        return (this.bitField0_ & 0x4) == 0x4;
    }
    
    public String getLeadingComments() {
        final Object leadingComments_ = this.leadingComments_;
        if (!(leadingComments_ instanceof String)) {
            final ByteString byteString = (ByteString)leadingComments_;
            final String stringUtf8 = byteString.toStringUtf8();
            if (byteString.isValidUtf8()) {
                this.leadingComments_ = stringUtf8;
            }
            return stringUtf8;
        }
        return (String)leadingComments_;
    }
    
    public ByteString getLeadingCommentsBytes() {
        final Object leadingComments_ = this.leadingComments_;
        if (leadingComments_ instanceof String) {
            return (ByteString)(this.leadingComments_ = ByteString.copyFromUtf8((String)leadingComments_));
        }
        return (ByteString)leadingComments_;
    }
    
    public DescriptorProtos$SourceCodeInfo$Location$Builder setLeadingComments(final String leadingComments_) {
        if (leadingComments_ == null) {
            throw new NullPointerException();
        }
        this.bitField0_ |= 0x4;
        this.leadingComments_ = leadingComments_;
        this.onChanged();
        return this;
    }
    
    public DescriptorProtos$SourceCodeInfo$Location$Builder clearLeadingComments() {
        this.bitField0_ &= 0xFFFFFFFB;
        this.leadingComments_ = DescriptorProtos$SourceCodeInfo$Location.getDefaultInstance().getLeadingComments();
        this.onChanged();
        return this;
    }
    
    public DescriptorProtos$SourceCodeInfo$Location$Builder setLeadingCommentsBytes(final ByteString leadingComments_) {
        if (leadingComments_ == null) {
            throw new NullPointerException();
        }
        this.bitField0_ |= 0x4;
        this.leadingComments_ = leadingComments_;
        this.onChanged();
        return this;
    }
    
    public boolean hasTrailingComments() {
        return (this.bitField0_ & 0x8) == 0x8;
    }
    
    public String getTrailingComments() {
        final Object trailingComments_ = this.trailingComments_;
        if (!(trailingComments_ instanceof String)) {
            final ByteString byteString = (ByteString)trailingComments_;
            final String stringUtf8 = byteString.toStringUtf8();
            if (byteString.isValidUtf8()) {
                this.trailingComments_ = stringUtf8;
            }
            return stringUtf8;
        }
        return (String)trailingComments_;
    }
    
    public ByteString getTrailingCommentsBytes() {
        final Object trailingComments_ = this.trailingComments_;
        if (trailingComments_ instanceof String) {
            return (ByteString)(this.trailingComments_ = ByteString.copyFromUtf8((String)trailingComments_));
        }
        return (ByteString)trailingComments_;
    }
    
    public DescriptorProtos$SourceCodeInfo$Location$Builder setTrailingComments(final String trailingComments_) {
        if (trailingComments_ == null) {
            throw new NullPointerException();
        }
        this.bitField0_ |= 0x8;
        this.trailingComments_ = trailingComments_;
        this.onChanged();
        return this;
    }
    
    public DescriptorProtos$SourceCodeInfo$Location$Builder clearTrailingComments() {
        this.bitField0_ &= 0xFFFFFFF7;
        this.trailingComments_ = DescriptorProtos$SourceCodeInfo$Location.getDefaultInstance().getTrailingComments();
        this.onChanged();
        return this;
    }
    
    public DescriptorProtos$SourceCodeInfo$Location$Builder setTrailingCommentsBytes(final ByteString trailingComments_) {
        if (trailingComments_ == null) {
            throw new NullPointerException();
        }
        this.bitField0_ |= 0x8;
        this.trailingComments_ = trailingComments_;
        this.onChanged();
        return this;
    }
    
    private void ensureLeadingDetachedCommentsIsMutable() {
        if ((this.bitField0_ & 0x10) != 0x10) {
            this.leadingDetachedComments_ = new LazyStringArrayList(this.leadingDetachedComments_);
            this.bitField0_ |= 0x10;
        }
    }
    
    public ProtocolStringList getLeadingDetachedCommentsList() {
        return this.leadingDetachedComments_.getUnmodifiableView();
    }
    
    public int getLeadingDetachedCommentsCount() {
        return this.leadingDetachedComments_.size();
    }
    
    public String getLeadingDetachedComments(final int n) {
        return this.leadingDetachedComments_.get(n);
    }
    
    public ByteString getLeadingDetachedCommentsBytes(final int n) {
        return this.leadingDetachedComments_.getByteString(n);
    }
    
    public DescriptorProtos$SourceCodeInfo$Location$Builder setLeadingDetachedComments(final int n, final String s) {
        if (s == null) {
            throw new NullPointerException();
        }
        this.ensureLeadingDetachedCommentsIsMutable();
        this.leadingDetachedComments_.set(n, s);
        this.onChanged();
        return this;
    }
    
    public DescriptorProtos$SourceCodeInfo$Location$Builder addLeadingDetachedComments(final String s) {
        if (s == null) {
            throw new NullPointerException();
        }
        this.ensureLeadingDetachedCommentsIsMutable();
        this.leadingDetachedComments_.add(s);
        this.onChanged();
        return this;
    }
    
    public DescriptorProtos$SourceCodeInfo$Location$Builder addAllLeadingDetachedComments(final Iterable iterable) {
        this.ensureLeadingDetachedCommentsIsMutable();
        AbstractMessageLite$Builder.addAll(iterable, this.leadingDetachedComments_);
        this.onChanged();
        return this;
    }
    
    public DescriptorProtos$SourceCodeInfo$Location$Builder clearLeadingDetachedComments() {
        this.leadingDetachedComments_ = LazyStringArrayList.EMPTY;
        this.bitField0_ &= 0xFFFFFFEF;
        this.onChanged();
        return this;
    }
    
    public DescriptorProtos$SourceCodeInfo$Location$Builder addLeadingDetachedCommentsBytes(final ByteString byteString) {
        if (byteString == null) {
            throw new NullPointerException();
        }
        this.ensureLeadingDetachedCommentsIsMutable();
        this.leadingDetachedComments_.add(byteString);
        this.onChanged();
        return this;
    }
}
