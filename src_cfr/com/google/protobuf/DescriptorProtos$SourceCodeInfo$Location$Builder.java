/*
 * Decompiled with CFR 0_115.
 */
package com.google.protobuf;

import com.google.protobuf.AbstractMessage$Builder;
import com.google.protobuf.AbstractMessageLite$Builder;
import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.DescriptorProtos;
import com.google.protobuf.DescriptorProtos$1;
import com.google.protobuf.DescriptorProtos$SourceCodeInfo$Location;
import com.google.protobuf.DescriptorProtos$SourceCodeInfo$LocationOrBuilder;
import com.google.protobuf.Descriptors$Descriptor;
import com.google.protobuf.ExtensionRegistryLite;
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
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public final class DescriptorProtos$SourceCodeInfo$Location$Builder
extends GeneratedMessage$Builder
implements DescriptorProtos$SourceCodeInfo$LocationOrBuilder {
    private int bitField0_;
    private List path_ = Collections.emptyList();
    private List span_ = Collections.emptyList();
    private Object leadingComments_ = "";
    private Object trailingComments_ = "";
    private LazyStringList leadingDetachedComments_ = LazyStringArrayList.EMPTY;

    public static final Descriptors$Descriptor getDescriptor() {
        return DescriptorProtos.access$23800();
    }

    @Override
    protected GeneratedMessage$FieldAccessorTable internalGetFieldAccessorTable() {
        return DescriptorProtos.access$23900().ensureFieldAccessorsInitialized(DescriptorProtos$SourceCodeInfo$Location.class, DescriptorProtos$SourceCodeInfo$Location$Builder.class);
    }

    private DescriptorProtos$SourceCodeInfo$Location$Builder() {
        this.maybeForceBuilderInitialization();
    }

    private DescriptorProtos$SourceCodeInfo$Location$Builder(GeneratedMessage$BuilderParent generatedMessage$BuilderParent) {
        super(generatedMessage$BuilderParent);
        this.maybeForceBuilderInitialization();
    }

    private void maybeForceBuilderInitialization() {
        if (!GeneratedMessage.alwaysUseFieldBuilders) return;
    }

    @Override
    public DescriptorProtos$SourceCodeInfo$Location$Builder clear() {
        super.clear();
        this.path_ = Collections.emptyList();
        this.bitField0_ &= -2;
        this.span_ = Collections.emptyList();
        this.bitField0_ &= -3;
        this.leadingComments_ = "";
        this.bitField0_ &= -5;
        this.trailingComments_ = "";
        this.bitField0_ &= -9;
        this.leadingDetachedComments_ = LazyStringArrayList.EMPTY;
        this.bitField0_ &= -17;
        return this;
    }

    @Override
    public Descriptors$Descriptor getDescriptorForType() {
        return DescriptorProtos.access$23800();
    }

    @Override
    public DescriptorProtos$SourceCodeInfo$Location getDefaultInstanceForType() {
        return DescriptorProtos$SourceCodeInfo$Location.getDefaultInstance();
    }

    @Override
    public DescriptorProtos$SourceCodeInfo$Location build() {
        DescriptorProtos$SourceCodeInfo$Location descriptorProtos$SourceCodeInfo$Location = this.buildPartial();
        if (descriptorProtos$SourceCodeInfo$Location.isInitialized()) return descriptorProtos$SourceCodeInfo$Location;
        throw DescriptorProtos$SourceCodeInfo$Location$Builder.newUninitializedMessageException(descriptorProtos$SourceCodeInfo$Location);
    }

    @Override
    public DescriptorProtos$SourceCodeInfo$Location buildPartial() {
        DescriptorProtos$SourceCodeInfo$Location descriptorProtos$SourceCodeInfo$Location = new DescriptorProtos$SourceCodeInfo$Location(this, null);
        int n2 = this.bitField0_;
        int n3 = 0;
        if ((this.bitField0_ & 1) == 1) {
            this.path_ = Collections.unmodifiableList(this.path_);
            this.bitField0_ &= -2;
        }
        DescriptorProtos$SourceCodeInfo$Location.access$24302(descriptorProtos$SourceCodeInfo$Location, this.path_);
        if ((this.bitField0_ & 2) == 2) {
            this.span_ = Collections.unmodifiableList(this.span_);
            this.bitField0_ &= -3;
        }
        DescriptorProtos$SourceCodeInfo$Location.access$24402(descriptorProtos$SourceCodeInfo$Location, this.span_);
        if ((n2 & 4) == 4) {
            n3 |= true;
        }
        DescriptorProtos$SourceCodeInfo$Location.access$24502(descriptorProtos$SourceCodeInfo$Location, this.leadingComments_);
        if ((n2 & 8) == 8) {
            n3 |= 2;
        }
        DescriptorProtos$SourceCodeInfo$Location.access$24602(descriptorProtos$SourceCodeInfo$Location, this.trailingComments_);
        if ((this.bitField0_ & 16) == 16) {
            this.leadingDetachedComments_ = this.leadingDetachedComments_.getUnmodifiableView();
            this.bitField0_ &= -17;
        }
        DescriptorProtos$SourceCodeInfo$Location.access$24702(descriptorProtos$SourceCodeInfo$Location, this.leadingDetachedComments_);
        DescriptorProtos$SourceCodeInfo$Location.access$24802(descriptorProtos$SourceCodeInfo$Location, n3);
        this.onBuilt();
        return descriptorProtos$SourceCodeInfo$Location;
    }

    @Override
    public DescriptorProtos$SourceCodeInfo$Location$Builder mergeFrom(Message message) {
        if (message instanceof DescriptorProtos$SourceCodeInfo$Location) {
            return this.mergeFrom((DescriptorProtos$SourceCodeInfo$Location)message);
        }
        super.mergeFrom(message);
        return this;
    }

    public DescriptorProtos$SourceCodeInfo$Location$Builder mergeFrom(DescriptorProtos$SourceCodeInfo$Location descriptorProtos$SourceCodeInfo$Location) {
        if (descriptorProtos$SourceCodeInfo$Location == DescriptorProtos$SourceCodeInfo$Location.getDefaultInstance()) {
            return this;
        }
        if (!DescriptorProtos$SourceCodeInfo$Location.access$24300(descriptorProtos$SourceCodeInfo$Location).isEmpty()) {
            if (this.path_.isEmpty()) {
                this.path_ = DescriptorProtos$SourceCodeInfo$Location.access$24300(descriptorProtos$SourceCodeInfo$Location);
                this.bitField0_ &= -2;
            } else {
                this.ensurePathIsMutable();
                this.path_.addAll(DescriptorProtos$SourceCodeInfo$Location.access$24300(descriptorProtos$SourceCodeInfo$Location));
            }
            this.onChanged();
        }
        if (!DescriptorProtos$SourceCodeInfo$Location.access$24400(descriptorProtos$SourceCodeInfo$Location).isEmpty()) {
            if (this.span_.isEmpty()) {
                this.span_ = DescriptorProtos$SourceCodeInfo$Location.access$24400(descriptorProtos$SourceCodeInfo$Location);
                this.bitField0_ &= -3;
            } else {
                this.ensureSpanIsMutable();
                this.span_.addAll(DescriptorProtos$SourceCodeInfo$Location.access$24400(descriptorProtos$SourceCodeInfo$Location));
            }
            this.onChanged();
        }
        if (descriptorProtos$SourceCodeInfo$Location.hasLeadingComments()) {
            this.bitField0_ |= 4;
            this.leadingComments_ = DescriptorProtos$SourceCodeInfo$Location.access$24500(descriptorProtos$SourceCodeInfo$Location);
            this.onChanged();
        }
        if (descriptorProtos$SourceCodeInfo$Location.hasTrailingComments()) {
            this.bitField0_ |= 8;
            this.trailingComments_ = DescriptorProtos$SourceCodeInfo$Location.access$24600(descriptorProtos$SourceCodeInfo$Location);
            this.onChanged();
        }
        if (!DescriptorProtos$SourceCodeInfo$Location.access$24700(descriptorProtos$SourceCodeInfo$Location).isEmpty()) {
            if (this.leadingDetachedComments_.isEmpty()) {
                this.leadingDetachedComments_ = DescriptorProtos$SourceCodeInfo$Location.access$24700(descriptorProtos$SourceCodeInfo$Location);
                this.bitField0_ &= -17;
            } else {
                this.ensureLeadingDetachedCommentsIsMutable();
                this.leadingDetachedComments_.addAll(DescriptorProtos$SourceCodeInfo$Location.access$24700(descriptorProtos$SourceCodeInfo$Location));
            }
            this.onChanged();
        }
        this.mergeUnknownFields(descriptorProtos$SourceCodeInfo$Location.unknownFields);
        this.onChanged();
        return this;
    }

    @Override
    public final boolean isInitialized() {
        return true;
    }

    @Override
    public DescriptorProtos$SourceCodeInfo$Location$Builder mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        DescriptorProtos$SourceCodeInfo$Location descriptorProtos$SourceCodeInfo$Location = null;
        try {
            try {
                descriptorProtos$SourceCodeInfo$Location = (DescriptorProtos$SourceCodeInfo$Location)DescriptorProtos$SourceCodeInfo$Location.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
            }
            catch (InvalidProtocolBufferException var4_6) {
                descriptorProtos$SourceCodeInfo$Location = (DescriptorProtos$SourceCodeInfo$Location)var4_6.getUnfinishedMessage();
                throw var4_6;
            }
            Object var6_4 = null;
            if (descriptorProtos$SourceCodeInfo$Location == null) return this;
            this.mergeFrom(descriptorProtos$SourceCodeInfo$Location);
            return this;
        }
        catch (Throwable var5_7) {
            Object var6_5 = null;
            if (descriptorProtos$SourceCodeInfo$Location == null) throw var5_7;
            this.mergeFrom(descriptorProtos$SourceCodeInfo$Location);
            throw var5_7;
        }
    }

    private void ensurePathIsMutable() {
        if ((this.bitField0_ & 1) == 1) return;
        this.path_ = new ArrayList(this.path_);
        this.bitField0_ |= 1;
    }

    @Override
    public List getPathList() {
        return Collections.unmodifiableList(this.path_);
    }

    @Override
    public int getPathCount() {
        return this.path_.size();
    }

    @Override
    public int getPath(int n2) {
        return (Integer)this.path_.get(n2);
    }

    public DescriptorProtos$SourceCodeInfo$Location$Builder setPath(int n2, int n3) {
        this.ensurePathIsMutable();
        this.path_.set(n2, n3);
        this.onChanged();
        return this;
    }

    public DescriptorProtos$SourceCodeInfo$Location$Builder addPath(int n2) {
        this.ensurePathIsMutable();
        this.path_.add(n2);
        this.onChanged();
        return this;
    }

    public DescriptorProtos$SourceCodeInfo$Location$Builder addAllPath(Iterable iterable) {
        this.ensurePathIsMutable();
        AbstractMessageLite$Builder.addAll(iterable, this.path_);
        this.onChanged();
        return this;
    }

    public DescriptorProtos$SourceCodeInfo$Location$Builder clearPath() {
        this.path_ = Collections.emptyList();
        this.bitField0_ &= -2;
        this.onChanged();
        return this;
    }

    private void ensureSpanIsMutable() {
        if ((this.bitField0_ & 2) == 2) return;
        this.span_ = new ArrayList(this.span_);
        this.bitField0_ |= 2;
    }

    @Override
    public List getSpanList() {
        return Collections.unmodifiableList(this.span_);
    }

    @Override
    public int getSpanCount() {
        return this.span_.size();
    }

    @Override
    public int getSpan(int n2) {
        return (Integer)this.span_.get(n2);
    }

    public DescriptorProtos$SourceCodeInfo$Location$Builder setSpan(int n2, int n3) {
        this.ensureSpanIsMutable();
        this.span_.set(n2, n3);
        this.onChanged();
        return this;
    }

    public DescriptorProtos$SourceCodeInfo$Location$Builder addSpan(int n2) {
        this.ensureSpanIsMutable();
        this.span_.add(n2);
        this.onChanged();
        return this;
    }

    public DescriptorProtos$SourceCodeInfo$Location$Builder addAllSpan(Iterable iterable) {
        this.ensureSpanIsMutable();
        AbstractMessageLite$Builder.addAll(iterable, this.span_);
        this.onChanged();
        return this;
    }

    public DescriptorProtos$SourceCodeInfo$Location$Builder clearSpan() {
        this.span_ = Collections.emptyList();
        this.bitField0_ &= -3;
        this.onChanged();
        return this;
    }

    @Override
    public boolean hasLeadingComments() {
        if ((this.bitField0_ & 4) != 4) return false;
        return true;
    }

    @Override
    public String getLeadingComments() {
        Object object = this.leadingComments_;
        if (object instanceof String) return (String)object;
        ByteString byteString = (ByteString)object;
        String string = byteString.toStringUtf8();
        if (!byteString.isValidUtf8()) return string;
        this.leadingComments_ = string;
        return string;
    }

    @Override
    public ByteString getLeadingCommentsBytes() {
        ByteString byteString;
        Object object = this.leadingComments_;
        if (!(object instanceof String)) return (ByteString)object;
        this.leadingComments_ = byteString = ByteString.copyFromUtf8((String)object);
        return byteString;
    }

    public DescriptorProtos$SourceCodeInfo$Location$Builder setLeadingComments(String string) {
        if (string == null) {
            throw new NullPointerException();
        }
        this.bitField0_ |= 4;
        this.leadingComments_ = string;
        this.onChanged();
        return this;
    }

    public DescriptorProtos$SourceCodeInfo$Location$Builder clearLeadingComments() {
        this.bitField0_ &= -5;
        this.leadingComments_ = DescriptorProtos$SourceCodeInfo$Location.getDefaultInstance().getLeadingComments();
        this.onChanged();
        return this;
    }

    public DescriptorProtos$SourceCodeInfo$Location$Builder setLeadingCommentsBytes(ByteString byteString) {
        if (byteString == null) {
            throw new NullPointerException();
        }
        this.bitField0_ |= 4;
        this.leadingComments_ = byteString;
        this.onChanged();
        return this;
    }

    @Override
    public boolean hasTrailingComments() {
        if ((this.bitField0_ & 8) != 8) return false;
        return true;
    }

    @Override
    public String getTrailingComments() {
        Object object = this.trailingComments_;
        if (object instanceof String) return (String)object;
        ByteString byteString = (ByteString)object;
        String string = byteString.toStringUtf8();
        if (!byteString.isValidUtf8()) return string;
        this.trailingComments_ = string;
        return string;
    }

    @Override
    public ByteString getTrailingCommentsBytes() {
        ByteString byteString;
        Object object = this.trailingComments_;
        if (!(object instanceof String)) return (ByteString)object;
        this.trailingComments_ = byteString = ByteString.copyFromUtf8((String)object);
        return byteString;
    }

    public DescriptorProtos$SourceCodeInfo$Location$Builder setTrailingComments(String string) {
        if (string == null) {
            throw new NullPointerException();
        }
        this.bitField0_ |= 8;
        this.trailingComments_ = string;
        this.onChanged();
        return this;
    }

    public DescriptorProtos$SourceCodeInfo$Location$Builder clearTrailingComments() {
        this.bitField0_ &= -9;
        this.trailingComments_ = DescriptorProtos$SourceCodeInfo$Location.getDefaultInstance().getTrailingComments();
        this.onChanged();
        return this;
    }

    public DescriptorProtos$SourceCodeInfo$Location$Builder setTrailingCommentsBytes(ByteString byteString) {
        if (byteString == null) {
            throw new NullPointerException();
        }
        this.bitField0_ |= 8;
        this.trailingComments_ = byteString;
        this.onChanged();
        return this;
    }

    private void ensureLeadingDetachedCommentsIsMutable() {
        if ((this.bitField0_ & 16) == 16) return;
        this.leadingDetachedComments_ = new LazyStringArrayList(this.leadingDetachedComments_);
        this.bitField0_ |= 16;
    }

    @Override
    public ProtocolStringList getLeadingDetachedCommentsList() {
        return this.leadingDetachedComments_.getUnmodifiableView();
    }

    @Override
    public int getLeadingDetachedCommentsCount() {
        return this.leadingDetachedComments_.size();
    }

    @Override
    public String getLeadingDetachedComments(int n2) {
        return (String)this.leadingDetachedComments_.get(n2);
    }

    @Override
    public ByteString getLeadingDetachedCommentsBytes(int n2) {
        return this.leadingDetachedComments_.getByteString(n2);
    }

    public DescriptorProtos$SourceCodeInfo$Location$Builder setLeadingDetachedComments(int n2, String string) {
        if (string == null) {
            throw new NullPointerException();
        }
        this.ensureLeadingDetachedCommentsIsMutable();
        this.leadingDetachedComments_.set(n2, string);
        this.onChanged();
        return this;
    }

    public DescriptorProtos$SourceCodeInfo$Location$Builder addLeadingDetachedComments(String string) {
        if (string == null) {
            throw new NullPointerException();
        }
        this.ensureLeadingDetachedCommentsIsMutable();
        this.leadingDetachedComments_.add(string);
        this.onChanged();
        return this;
    }

    public DescriptorProtos$SourceCodeInfo$Location$Builder addAllLeadingDetachedComments(Iterable iterable) {
        this.ensureLeadingDetachedCommentsIsMutable();
        AbstractMessageLite$Builder.addAll(iterable, this.leadingDetachedComments_);
        this.onChanged();
        return this;
    }

    public DescriptorProtos$SourceCodeInfo$Location$Builder clearLeadingDetachedComments() {
        this.leadingDetachedComments_ = LazyStringArrayList.EMPTY;
        this.bitField0_ &= -17;
        this.onChanged();
        return this;
    }

    public DescriptorProtos$SourceCodeInfo$Location$Builder addLeadingDetachedCommentsBytes(ByteString byteString) {
        if (byteString == null) {
            throw new NullPointerException();
        }
        this.ensureLeadingDetachedCommentsIsMutable();
        this.leadingDetachedComments_.add(byteString);
        this.onChanged();
        return this;
    }

    /* synthetic */ DescriptorProtos$SourceCodeInfo$Location$Builder(DescriptorProtos$1 descriptorProtos$1) {
        this();
    }

    /* synthetic */ DescriptorProtos$SourceCodeInfo$Location$Builder(GeneratedMessage$BuilderParent generatedMessage$BuilderParent, DescriptorProtos$1 descriptorProtos$1) {
        this(generatedMessage$BuilderParent);
    }
}

