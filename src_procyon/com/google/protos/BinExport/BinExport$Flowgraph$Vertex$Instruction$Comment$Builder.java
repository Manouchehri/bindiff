package com.google.protos.BinExport;

import com.google.protobuf.*;
import java.io.*;

public final class BinExport$Flowgraph$Vertex$Instruction$Comment$Builder extends GeneratedMessage$Builder implements BinExport$Flowgraph$Vertex$Instruction$CommentOrBuilder
{
    private int bitField0_;
    private Object comment_;
    private int flags_;
    
    public static final Descriptors$Descriptor getDescriptor() {
        return BinExport.internal_static_BinExport_Flowgraph_Vertex_Instruction_Comment_descriptor;
    }
    
    @Override
    protected GeneratedMessage$FieldAccessorTable internalGetFieldAccessorTable() {
        return BinExport.internal_static_BinExport_Flowgraph_Vertex_Instruction_Comment_fieldAccessorTable.ensureFieldAccessorsInitialized(BinExport$Flowgraph$Vertex$Instruction$Comment.class, BinExport$Flowgraph$Vertex$Instruction$Comment$Builder.class);
    }
    
    private BinExport$Flowgraph$Vertex$Instruction$Comment$Builder() {
        this.comment_ = "";
        this.maybeForceBuilderInitialization();
    }
    
    private BinExport$Flowgraph$Vertex$Instruction$Comment$Builder(final GeneratedMessage$BuilderParent generatedMessage$BuilderParent) {
        super(generatedMessage$BuilderParent);
        this.comment_ = "";
        this.maybeForceBuilderInitialization();
    }
    
    private void maybeForceBuilderInitialization() {
        if (BinExport$Flowgraph$Vertex$Instruction$Comment.alwaysUseFieldBuilders) {}
    }
    
    @Override
    public BinExport$Flowgraph$Vertex$Instruction$Comment$Builder clear() {
        super.clear();
        this.comment_ = "";
        this.bitField0_ &= 0xFFFFFFFE;
        this.flags_ = 0;
        this.bitField0_ &= 0xFFFFFFFD;
        return this;
    }
    
    @Override
    public Descriptors$Descriptor getDescriptorForType() {
        return BinExport.internal_static_BinExport_Flowgraph_Vertex_Instruction_Comment_descriptor;
    }
    
    @Override
    public BinExport$Flowgraph$Vertex$Instruction$Comment getDefaultInstanceForType() {
        return BinExport$Flowgraph$Vertex$Instruction$Comment.getDefaultInstance();
    }
    
    @Override
    public BinExport$Flowgraph$Vertex$Instruction$Comment build() {
        final BinExport$Flowgraph$Vertex$Instruction$Comment buildPartial = this.buildPartial();
        if (!buildPartial.isInitialized()) {
            throw AbstractMessage$Builder.newUninitializedMessageException(buildPartial);
        }
        return buildPartial;
    }
    
    @Override
    public BinExport$Flowgraph$Vertex$Instruction$Comment buildPartial() {
        final BinExport$Flowgraph$Vertex$Instruction$Comment binExport$Flowgraph$Vertex$Instruction$Comment = new BinExport$Flowgraph$Vertex$Instruction$Comment(this, null);
        final int bitField0_ = this.bitField0_;
        int n = 0;
        if ((bitField0_ & 0x1) == 0x1) {
            n |= 0x1;
        }
        binExport$Flowgraph$Vertex$Instruction$Comment.comment_ = this.comment_;
        if ((bitField0_ & 0x2) == 0x2) {
            n |= 0x2;
        }
        binExport$Flowgraph$Vertex$Instruction$Comment.flags_ = this.flags_;
        binExport$Flowgraph$Vertex$Instruction$Comment.bitField0_ = n;
        this.onBuilt();
        return binExport$Flowgraph$Vertex$Instruction$Comment;
    }
    
    @Override
    public BinExport$Flowgraph$Vertex$Instruction$Comment$Builder mergeFrom(final Message message) {
        if (message instanceof BinExport$Flowgraph$Vertex$Instruction$Comment) {
            return this.mergeFrom((BinExport$Flowgraph$Vertex$Instruction$Comment)message);
        }
        super.mergeFrom(message);
        return this;
    }
    
    public BinExport$Flowgraph$Vertex$Instruction$Comment$Builder mergeFrom(final BinExport$Flowgraph$Vertex$Instruction$Comment binExport$Flowgraph$Vertex$Instruction$Comment) {
        if (binExport$Flowgraph$Vertex$Instruction$Comment == BinExport$Flowgraph$Vertex$Instruction$Comment.getDefaultInstance()) {
            return this;
        }
        if (binExport$Flowgraph$Vertex$Instruction$Comment.hasComment()) {
            this.bitField0_ |= 0x1;
            this.comment_ = binExport$Flowgraph$Vertex$Instruction$Comment.comment_;
            this.onChanged();
        }
        if (binExport$Flowgraph$Vertex$Instruction$Comment.hasFlags()) {
            this.setFlags(binExport$Flowgraph$Vertex$Instruction$Comment.getFlags());
        }
        this.mergeUnknownFields(binExport$Flowgraph$Vertex$Instruction$Comment.unknownFields);
        this.onChanged();
        return this;
    }
    
    @Override
    public final boolean isInitialized() {
        return this.hasComment() && this.hasFlags();
    }
    
    @Override
    public BinExport$Flowgraph$Vertex$Instruction$Comment$Builder mergeFrom(final CodedInputStream codedInputStream, final ExtensionRegistryLite extensionRegistryLite) {
        BinExport$Flowgraph$Vertex$Instruction$Comment binExport$Flowgraph$Vertex$Instruction$Comment = null;
        try {
            binExport$Flowgraph$Vertex$Instruction$Comment = (BinExport$Flowgraph$Vertex$Instruction$Comment)BinExport$Flowgraph$Vertex$Instruction$Comment.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
        }
        catch (InvalidProtocolBufferException ex) {
            binExport$Flowgraph$Vertex$Instruction$Comment = (BinExport$Flowgraph$Vertex$Instruction$Comment)ex.getUnfinishedMessage();
            throw ex;
        }
        finally {
            if (binExport$Flowgraph$Vertex$Instruction$Comment != null) {
                this.mergeFrom(binExport$Flowgraph$Vertex$Instruction$Comment);
            }
        }
        return this;
    }
    
    @Override
    public boolean hasComment() {
        return (this.bitField0_ & 0x1) == 0x1;
    }
    
    @Override
    public String getComment() {
        final Object comment_ = this.comment_;
        if (!(comment_ instanceof String)) {
            final ByteString byteString = (ByteString)comment_;
            final String stringUtf8 = byteString.toStringUtf8();
            if (byteString.isValidUtf8()) {
                this.comment_ = stringUtf8;
            }
            return stringUtf8;
        }
        return (String)comment_;
    }
    
    @Override
    public ByteString getCommentBytes() {
        final Object comment_ = this.comment_;
        if (comment_ instanceof String) {
            return (ByteString)(this.comment_ = ByteString.copyFromUtf8((String)comment_));
        }
        return (ByteString)comment_;
    }
    
    public BinExport$Flowgraph$Vertex$Instruction$Comment$Builder setComment(final String comment_) {
        if (comment_ == null) {
            throw new NullPointerException();
        }
        this.bitField0_ |= 0x1;
        this.comment_ = comment_;
        this.onChanged();
        return this;
    }
    
    public BinExport$Flowgraph$Vertex$Instruction$Comment$Builder clearComment() {
        this.bitField0_ &= 0xFFFFFFFE;
        this.comment_ = BinExport$Flowgraph$Vertex$Instruction$Comment.getDefaultInstance().getComment();
        this.onChanged();
        return this;
    }
    
    public BinExport$Flowgraph$Vertex$Instruction$Comment$Builder setCommentBytes(final ByteString comment_) {
        if (comment_ == null) {
            throw new NullPointerException();
        }
        this.bitField0_ |= 0x1;
        this.comment_ = comment_;
        this.onChanged();
        return this;
    }
    
    @Override
    public boolean hasFlags() {
        return (this.bitField0_ & 0x2) == 0x2;
    }
    
    @Override
    public int getFlags() {
        return this.flags_;
    }
    
    public BinExport$Flowgraph$Vertex$Instruction$Comment$Builder setFlags(final int flags_) {
        this.bitField0_ |= 0x2;
        this.flags_ = flags_;
        this.onChanged();
        return this;
    }
    
    public BinExport$Flowgraph$Vertex$Instruction$Comment$Builder clearFlags() {
        this.bitField0_ &= 0xFFFFFFFD;
        this.flags_ = 0;
        this.onChanged();
        return this;
    }
}
