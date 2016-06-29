/*
 * Decompiled with CFR 0_115.
 */
package com.google.protos.BinExport;

import com.google.protobuf.AbstractMessage$Builder;
import com.google.protobuf.AbstractMessageLite$Builder;
import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.Descriptors$Descriptor;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessage$Builder;
import com.google.protobuf.GeneratedMessage$BuilderParent;
import com.google.protobuf.GeneratedMessage$FieldAccessorTable;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.Message;
import com.google.protobuf.Message$Builder;
import com.google.protobuf.MessageLite;
import com.google.protobuf.MessageLite$Builder;
import com.google.protobuf.Parser;
import com.google.protobuf.UnknownFieldSet;
import com.google.protos.BinExport.BinExport;
import com.google.protos.BinExport.BinExport$1;
import com.google.protos.BinExport.BinExport$Flowgraph$Vertex$Instruction$Comment;
import com.google.protos.BinExport.BinExport$Flowgraph$Vertex$Instruction$CommentOrBuilder;

public final class BinExport$Flowgraph$Vertex$Instruction$Comment$Builder
extends GeneratedMessage$Builder
implements BinExport$Flowgraph$Vertex$Instruction$CommentOrBuilder {
    private int bitField0_;
    private Object comment_ = "";
    private int flags_;

    public static final Descriptors$Descriptor getDescriptor() {
        return BinExport.access$6300();
    }

    @Override
    protected GeneratedMessage$FieldAccessorTable internalGetFieldAccessorTable() {
        return BinExport.access$6400().ensureFieldAccessorsInitialized(BinExport$Flowgraph$Vertex$Instruction$Comment.class, BinExport$Flowgraph$Vertex$Instruction$Comment$Builder.class);
    }

    private BinExport$Flowgraph$Vertex$Instruction$Comment$Builder() {
        this.maybeForceBuilderInitialization();
    }

    private BinExport$Flowgraph$Vertex$Instruction$Comment$Builder(GeneratedMessage$BuilderParent generatedMessage$BuilderParent) {
        super(generatedMessage$BuilderParent);
        this.maybeForceBuilderInitialization();
    }

    private void maybeForceBuilderInitialization() {
        if (!BinExport$Flowgraph$Vertex$Instruction$Comment.access$6700()) return;
    }

    @Override
    public BinExport$Flowgraph$Vertex$Instruction$Comment$Builder clear() {
        super.clear();
        this.comment_ = "";
        this.bitField0_ &= -2;
        this.flags_ = 0;
        this.bitField0_ &= -3;
        return this;
    }

    @Override
    public Descriptors$Descriptor getDescriptorForType() {
        return BinExport.access$6300();
    }

    @Override
    public BinExport$Flowgraph$Vertex$Instruction$Comment getDefaultInstanceForType() {
        return BinExport$Flowgraph$Vertex$Instruction$Comment.getDefaultInstance();
    }

    @Override
    public BinExport$Flowgraph$Vertex$Instruction$Comment build() {
        BinExport$Flowgraph$Vertex$Instruction$Comment binExport$Flowgraph$Vertex$Instruction$Comment = this.buildPartial();
        if (binExport$Flowgraph$Vertex$Instruction$Comment.isInitialized()) return binExport$Flowgraph$Vertex$Instruction$Comment;
        throw BinExport$Flowgraph$Vertex$Instruction$Comment$Builder.newUninitializedMessageException(binExport$Flowgraph$Vertex$Instruction$Comment);
    }

    @Override
    public BinExport$Flowgraph$Vertex$Instruction$Comment buildPartial() {
        BinExport$Flowgraph$Vertex$Instruction$Comment binExport$Flowgraph$Vertex$Instruction$Comment = new BinExport$Flowgraph$Vertex$Instruction$Comment(this, null);
        int n2 = this.bitField0_;
        int n3 = 0;
        if ((n2 & 1) == 1) {
            n3 |= true;
        }
        BinExport$Flowgraph$Vertex$Instruction$Comment.access$6902(binExport$Flowgraph$Vertex$Instruction$Comment, this.comment_);
        if ((n2 & 2) == 2) {
            n3 |= 2;
        }
        BinExport$Flowgraph$Vertex$Instruction$Comment.access$7002(binExport$Flowgraph$Vertex$Instruction$Comment, this.flags_);
        BinExport$Flowgraph$Vertex$Instruction$Comment.access$7102(binExport$Flowgraph$Vertex$Instruction$Comment, n3);
        this.onBuilt();
        return binExport$Flowgraph$Vertex$Instruction$Comment;
    }

    @Override
    public BinExport$Flowgraph$Vertex$Instruction$Comment$Builder mergeFrom(Message message) {
        if (message instanceof BinExport$Flowgraph$Vertex$Instruction$Comment) {
            return this.mergeFrom((BinExport$Flowgraph$Vertex$Instruction$Comment)message);
        }
        super.mergeFrom(message);
        return this;
    }

    public BinExport$Flowgraph$Vertex$Instruction$Comment$Builder mergeFrom(BinExport$Flowgraph$Vertex$Instruction$Comment binExport$Flowgraph$Vertex$Instruction$Comment) {
        if (binExport$Flowgraph$Vertex$Instruction$Comment == BinExport$Flowgraph$Vertex$Instruction$Comment.getDefaultInstance()) {
            return this;
        }
        if (binExport$Flowgraph$Vertex$Instruction$Comment.hasComment()) {
            this.bitField0_ |= 1;
            this.comment_ = BinExport$Flowgraph$Vertex$Instruction$Comment.access$6900(binExport$Flowgraph$Vertex$Instruction$Comment);
            this.onChanged();
        }
        if (binExport$Flowgraph$Vertex$Instruction$Comment.hasFlags()) {
            this.setFlags(binExport$Flowgraph$Vertex$Instruction$Comment.getFlags());
        }
        this.mergeUnknownFields(BinExport$Flowgraph$Vertex$Instruction$Comment.access$7200(binExport$Flowgraph$Vertex$Instruction$Comment));
        this.onChanged();
        return this;
    }

    @Override
    public final boolean isInitialized() {
        if (!this.hasComment()) {
            return false;
        }
        if (this.hasFlags()) return true;
        return false;
    }

    @Override
    public BinExport$Flowgraph$Vertex$Instruction$Comment$Builder mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        BinExport$Flowgraph$Vertex$Instruction$Comment binExport$Flowgraph$Vertex$Instruction$Comment = null;
        try {
            binExport$Flowgraph$Vertex$Instruction$Comment = (BinExport$Flowgraph$Vertex$Instruction$Comment)BinExport$Flowgraph$Vertex$Instruction$Comment.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
            return this;
        }
        catch (InvalidProtocolBufferException var4_4) {
            binExport$Flowgraph$Vertex$Instruction$Comment = (BinExport$Flowgraph$Vertex$Instruction$Comment)var4_4.getUnfinishedMessage();
            throw var4_4;
        }
        finally {
            if (binExport$Flowgraph$Vertex$Instruction$Comment != null) {
                this.mergeFrom(binExport$Flowgraph$Vertex$Instruction$Comment);
            }
        }
    }

    @Override
    public boolean hasComment() {
        if ((this.bitField0_ & 1) != 1) return false;
        return true;
    }

    @Override
    public String getComment() {
        Object object = this.comment_;
        if (object instanceof String) return (String)object;
        ByteString byteString = (ByteString)object;
        String string = byteString.toStringUtf8();
        if (!byteString.isValidUtf8()) return string;
        this.comment_ = string;
        return string;
    }

    @Override
    public ByteString getCommentBytes() {
        ByteString byteString;
        Object object = this.comment_;
        if (!(object instanceof String)) return (ByteString)object;
        this.comment_ = byteString = ByteString.copyFromUtf8((String)object);
        return byteString;
    }

    public BinExport$Flowgraph$Vertex$Instruction$Comment$Builder setComment(String string) {
        if (string == null) {
            throw new NullPointerException();
        }
        this.bitField0_ |= 1;
        this.comment_ = string;
        this.onChanged();
        return this;
    }

    public BinExport$Flowgraph$Vertex$Instruction$Comment$Builder clearComment() {
        this.bitField0_ &= -2;
        this.comment_ = BinExport$Flowgraph$Vertex$Instruction$Comment.getDefaultInstance().getComment();
        this.onChanged();
        return this;
    }

    public BinExport$Flowgraph$Vertex$Instruction$Comment$Builder setCommentBytes(ByteString byteString) {
        if (byteString == null) {
            throw new NullPointerException();
        }
        this.bitField0_ |= 1;
        this.comment_ = byteString;
        this.onChanged();
        return this;
    }

    @Override
    public boolean hasFlags() {
        if ((this.bitField0_ & 2) != 2) return false;
        return true;
    }

    @Override
    public int getFlags() {
        return this.flags_;
    }

    public BinExport$Flowgraph$Vertex$Instruction$Comment$Builder setFlags(int n2) {
        this.bitField0_ |= 2;
        this.flags_ = n2;
        this.onChanged();
        return this;
    }

    public BinExport$Flowgraph$Vertex$Instruction$Comment$Builder clearFlags() {
        this.bitField0_ &= -3;
        this.flags_ = 0;
        this.onChanged();
        return this;
    }

    /* synthetic */ BinExport$Flowgraph$Vertex$Instruction$Comment$Builder(BinExport$1 binExport$1) {
        this();
    }

    /* synthetic */ BinExport$Flowgraph$Vertex$Instruction$Comment$Builder(GeneratedMessage$BuilderParent generatedMessage$BuilderParent, BinExport$1 binExport$1) {
        this(generatedMessage$BuilderParent);
    }
}

