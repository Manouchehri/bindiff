package com.google.protos.BinExport;

import java.util.*;
import com.google.protobuf.*;
import java.io.*;

public final class BinExport$Flowgraph$Vertex$Instruction$Builder extends GeneratedMessage$Builder implements BinExport$Flowgraph$Vertex$InstructionOrBuilder
{
    private int bitField0_;
    private long address_;
    private int prime_;
    private int stringReference_;
    private Object mnemonic_;
    private Object operands_;
    private ByteString rawBytes_;
    private List callTargets_;
    private List comments_;
    private RepeatedFieldBuilder commentsBuilder_;
    
    public static final Descriptors$Descriptor getDescriptor() {
        return BinExport.internal_static_BinExport_Flowgraph_Vertex_Instruction_descriptor;
    }
    
    @Override
    protected GeneratedMessage$FieldAccessorTable internalGetFieldAccessorTable() {
        return BinExport.internal_static_BinExport_Flowgraph_Vertex_Instruction_fieldAccessorTable.ensureFieldAccessorsInitialized(BinExport$Flowgraph$Vertex$Instruction.class, BinExport$Flowgraph$Vertex$Instruction$Builder.class);
    }
    
    private BinExport$Flowgraph$Vertex$Instruction$Builder() {
        this.mnemonic_ = "";
        this.operands_ = "";
        this.rawBytes_ = ByteString.EMPTY;
        this.callTargets_ = Collections.emptyList();
        this.comments_ = Collections.emptyList();
        this.maybeForceBuilderInitialization();
    }
    
    private BinExport$Flowgraph$Vertex$Instruction$Builder(final GeneratedMessage$BuilderParent generatedMessage$BuilderParent) {
        super(generatedMessage$BuilderParent);
        this.mnemonic_ = "";
        this.operands_ = "";
        this.rawBytes_ = ByteString.EMPTY;
        this.callTargets_ = Collections.emptyList();
        this.comments_ = Collections.emptyList();
        this.maybeForceBuilderInitialization();
    }
    
    private void maybeForceBuilderInitialization() {
        if (BinExport$Flowgraph$Vertex$Instruction.alwaysUseFieldBuilders) {
            this.getCommentsFieldBuilder();
        }
    }
    
    @Override
    public BinExport$Flowgraph$Vertex$Instruction$Builder clear() {
        super.clear();
        this.address_ = 0L;
        this.bitField0_ &= 0xFFFFFFFE;
        this.prime_ = 0;
        this.bitField0_ &= 0xFFFFFFFD;
        this.stringReference_ = 0;
        this.bitField0_ &= 0xFFFFFFFB;
        this.mnemonic_ = "";
        this.bitField0_ &= 0xFFFFFFF7;
        this.operands_ = "";
        this.bitField0_ &= 0xFFFFFFEF;
        this.rawBytes_ = ByteString.EMPTY;
        this.bitField0_ &= 0xFFFFFFDF;
        this.callTargets_ = Collections.emptyList();
        this.bitField0_ &= 0xFFFFFFBF;
        if (this.commentsBuilder_ == null) {
            this.comments_ = Collections.emptyList();
            this.bitField0_ &= 0xFFFFFF7F;
        }
        else {
            this.commentsBuilder_.clear();
        }
        return this;
    }
    
    @Override
    public Descriptors$Descriptor getDescriptorForType() {
        return BinExport.internal_static_BinExport_Flowgraph_Vertex_Instruction_descriptor;
    }
    
    @Override
    public BinExport$Flowgraph$Vertex$Instruction getDefaultInstanceForType() {
        return BinExport$Flowgraph$Vertex$Instruction.getDefaultInstance();
    }
    
    @Override
    public BinExport$Flowgraph$Vertex$Instruction build() {
        final BinExport$Flowgraph$Vertex$Instruction buildPartial = this.buildPartial();
        if (!buildPartial.isInitialized()) {
            throw AbstractMessage$Builder.newUninitializedMessageException(buildPartial);
        }
        return buildPartial;
    }
    
    @Override
    public BinExport$Flowgraph$Vertex$Instruction buildPartial() {
        final BinExport$Flowgraph$Vertex$Instruction binExport$Flowgraph$Vertex$Instruction = new BinExport$Flowgraph$Vertex$Instruction(this, null);
        final int bitField0_ = this.bitField0_;
        int n = 0;
        if ((bitField0_ & 0x1) == 0x1) {
            n |= 0x1;
        }
        binExport$Flowgraph$Vertex$Instruction.address_ = this.address_;
        if ((bitField0_ & 0x2) == 0x2) {
            n |= 0x2;
        }
        binExport$Flowgraph$Vertex$Instruction.prime_ = this.prime_;
        if ((bitField0_ & 0x4) == 0x4) {
            n |= 0x4;
        }
        binExport$Flowgraph$Vertex$Instruction.stringReference_ = this.stringReference_;
        if ((bitField0_ & 0x8) == 0x8) {
            n |= 0x8;
        }
        binExport$Flowgraph$Vertex$Instruction.mnemonic_ = this.mnemonic_;
        if ((bitField0_ & 0x10) == 0x10) {
            n |= 0x10;
        }
        binExport$Flowgraph$Vertex$Instruction.operands_ = this.operands_;
        if ((bitField0_ & 0x20) == 0x20) {
            n |= 0x20;
        }
        binExport$Flowgraph$Vertex$Instruction.rawBytes_ = this.rawBytes_;
        if ((this.bitField0_ & 0x40) == 0x40) {
            this.callTargets_ = Collections.unmodifiableList((List<?>)this.callTargets_);
            this.bitField0_ &= 0xFFFFFFBF;
        }
        binExport$Flowgraph$Vertex$Instruction.callTargets_ = this.callTargets_;
        if (this.commentsBuilder_ == null) {
            if ((this.bitField0_ & 0x80) == 0x80) {
                this.comments_ = Collections.unmodifiableList((List<?>)this.comments_);
                this.bitField0_ &= 0xFFFFFF7F;
            }
            binExport$Flowgraph$Vertex$Instruction.comments_ = this.comments_;
        }
        else {
            binExport$Flowgraph$Vertex$Instruction.comments_ = this.commentsBuilder_.build();
        }
        binExport$Flowgraph$Vertex$Instruction.bitField0_ = n;
        this.onBuilt();
        return binExport$Flowgraph$Vertex$Instruction;
    }
    
    @Override
    public BinExport$Flowgraph$Vertex$Instruction$Builder mergeFrom(final Message message) {
        if (message instanceof BinExport$Flowgraph$Vertex$Instruction) {
            return this.mergeFrom((BinExport$Flowgraph$Vertex$Instruction)message);
        }
        super.mergeFrom(message);
        return this;
    }
    
    public BinExport$Flowgraph$Vertex$Instruction$Builder mergeFrom(final BinExport$Flowgraph$Vertex$Instruction binExport$Flowgraph$Vertex$Instruction) {
        if (binExport$Flowgraph$Vertex$Instruction == BinExport$Flowgraph$Vertex$Instruction.getDefaultInstance()) {
            return this;
        }
        if (binExport$Flowgraph$Vertex$Instruction.hasAddress()) {
            this.setAddress(binExport$Flowgraph$Vertex$Instruction.getAddress());
        }
        if (binExport$Flowgraph$Vertex$Instruction.hasPrime()) {
            this.setPrime(binExport$Flowgraph$Vertex$Instruction.getPrime());
        }
        if (binExport$Flowgraph$Vertex$Instruction.hasStringReference()) {
            this.setStringReference(binExport$Flowgraph$Vertex$Instruction.getStringReference());
        }
        if (binExport$Flowgraph$Vertex$Instruction.hasMnemonic()) {
            this.bitField0_ |= 0x8;
            this.mnemonic_ = binExport$Flowgraph$Vertex$Instruction.mnemonic_;
            this.onChanged();
        }
        if (binExport$Flowgraph$Vertex$Instruction.hasOperands()) {
            this.bitField0_ |= 0x10;
            this.operands_ = binExport$Flowgraph$Vertex$Instruction.operands_;
            this.onChanged();
        }
        if (binExport$Flowgraph$Vertex$Instruction.hasRawBytes()) {
            this.setRawBytes(binExport$Flowgraph$Vertex$Instruction.getRawBytes());
        }
        if (!binExport$Flowgraph$Vertex$Instruction.callTargets_.isEmpty()) {
            if (this.callTargets_.isEmpty()) {
                this.callTargets_ = binExport$Flowgraph$Vertex$Instruction.callTargets_;
                this.bitField0_ &= 0xFFFFFFBF;
            }
            else {
                this.ensureCallTargetsIsMutable();
                this.callTargets_.addAll(binExport$Flowgraph$Vertex$Instruction.callTargets_);
            }
            this.onChanged();
        }
        if (this.commentsBuilder_ == null) {
            if (!binExport$Flowgraph$Vertex$Instruction.comments_.isEmpty()) {
                if (this.comments_.isEmpty()) {
                    this.comments_ = binExport$Flowgraph$Vertex$Instruction.comments_;
                    this.bitField0_ &= 0xFFFFFF7F;
                }
                else {
                    this.ensureCommentsIsMutable();
                    this.comments_.addAll(binExport$Flowgraph$Vertex$Instruction.comments_);
                }
                this.onChanged();
            }
        }
        else if (!binExport$Flowgraph$Vertex$Instruction.comments_.isEmpty()) {
            if (this.commentsBuilder_.isEmpty()) {
                this.commentsBuilder_.dispose();
                this.commentsBuilder_ = null;
                this.comments_ = binExport$Flowgraph$Vertex$Instruction.comments_;
                this.bitField0_ &= 0xFFFFFF7F;
                this.commentsBuilder_ = (BinExport$Flowgraph$Vertex$Instruction.alwaysUseFieldBuilders ? this.getCommentsFieldBuilder() : null);
            }
            else {
                this.commentsBuilder_.addAllMessages(binExport$Flowgraph$Vertex$Instruction.comments_);
            }
        }
        this.mergeUnknownFields(binExport$Flowgraph$Vertex$Instruction.unknownFields);
        this.onChanged();
        return this;
    }
    
    @Override
    public final boolean isInitialized() {
        if (!this.hasAddress()) {
            return false;
        }
        if (!this.hasPrime()) {
            return false;
        }
        for (int i = 0; i < this.getCommentsCount(); ++i) {
            if (!this.getComments(i).isInitialized()) {
                return false;
            }
        }
        return true;
    }
    
    @Override
    public BinExport$Flowgraph$Vertex$Instruction$Builder mergeFrom(final CodedInputStream codedInputStream, final ExtensionRegistryLite extensionRegistryLite) {
        BinExport$Flowgraph$Vertex$Instruction binExport$Flowgraph$Vertex$Instruction = null;
        try {
            binExport$Flowgraph$Vertex$Instruction = (BinExport$Flowgraph$Vertex$Instruction)BinExport$Flowgraph$Vertex$Instruction.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
        }
        catch (InvalidProtocolBufferException ex) {
            binExport$Flowgraph$Vertex$Instruction = (BinExport$Flowgraph$Vertex$Instruction)ex.getUnfinishedMessage();
            throw ex;
        }
        finally {
            if (binExport$Flowgraph$Vertex$Instruction != null) {
                this.mergeFrom(binExport$Flowgraph$Vertex$Instruction);
            }
        }
        return this;
    }
    
    @Override
    public boolean hasAddress() {
        return (this.bitField0_ & 0x1) == 0x1;
    }
    
    @Override
    public long getAddress() {
        return this.address_;
    }
    
    public BinExport$Flowgraph$Vertex$Instruction$Builder setAddress(final long address_) {
        this.bitField0_ |= 0x1;
        this.address_ = address_;
        this.onChanged();
        return this;
    }
    
    public BinExport$Flowgraph$Vertex$Instruction$Builder clearAddress() {
        this.bitField0_ &= 0xFFFFFFFE;
        this.address_ = 0L;
        this.onChanged();
        return this;
    }
    
    @Override
    public boolean hasPrime() {
        return (this.bitField0_ & 0x2) == 0x2;
    }
    
    @Override
    public int getPrime() {
        return this.prime_;
    }
    
    public BinExport$Flowgraph$Vertex$Instruction$Builder setPrime(final int prime_) {
        this.bitField0_ |= 0x2;
        this.prime_ = prime_;
        this.onChanged();
        return this;
    }
    
    public BinExport$Flowgraph$Vertex$Instruction$Builder clearPrime() {
        this.bitField0_ &= 0xFFFFFFFD;
        this.prime_ = 0;
        this.onChanged();
        return this;
    }
    
    @Override
    public boolean hasStringReference() {
        return (this.bitField0_ & 0x4) == 0x4;
    }
    
    @Override
    public int getStringReference() {
        return this.stringReference_;
    }
    
    public BinExport$Flowgraph$Vertex$Instruction$Builder setStringReference(final int stringReference_) {
        this.bitField0_ |= 0x4;
        this.stringReference_ = stringReference_;
        this.onChanged();
        return this;
    }
    
    public BinExport$Flowgraph$Vertex$Instruction$Builder clearStringReference() {
        this.bitField0_ &= 0xFFFFFFFB;
        this.stringReference_ = 0;
        this.onChanged();
        return this;
    }
    
    @Override
    public boolean hasMnemonic() {
        return (this.bitField0_ & 0x8) == 0x8;
    }
    
    @Override
    public String getMnemonic() {
        final Object mnemonic_ = this.mnemonic_;
        if (!(mnemonic_ instanceof String)) {
            final ByteString byteString = (ByteString)mnemonic_;
            final String stringUtf8 = byteString.toStringUtf8();
            if (byteString.isValidUtf8()) {
                this.mnemonic_ = stringUtf8;
            }
            return stringUtf8;
        }
        return (String)mnemonic_;
    }
    
    @Override
    public ByteString getMnemonicBytes() {
        final Object mnemonic_ = this.mnemonic_;
        if (mnemonic_ instanceof String) {
            return (ByteString)(this.mnemonic_ = ByteString.copyFromUtf8((String)mnemonic_));
        }
        return (ByteString)mnemonic_;
    }
    
    public BinExport$Flowgraph$Vertex$Instruction$Builder setMnemonic(final String mnemonic_) {
        if (mnemonic_ == null) {
            throw new NullPointerException();
        }
        this.bitField0_ |= 0x8;
        this.mnemonic_ = mnemonic_;
        this.onChanged();
        return this;
    }
    
    public BinExport$Flowgraph$Vertex$Instruction$Builder clearMnemonic() {
        this.bitField0_ &= 0xFFFFFFF7;
        this.mnemonic_ = BinExport$Flowgraph$Vertex$Instruction.getDefaultInstance().getMnemonic();
        this.onChanged();
        return this;
    }
    
    public BinExport$Flowgraph$Vertex$Instruction$Builder setMnemonicBytes(final ByteString mnemonic_) {
        if (mnemonic_ == null) {
            throw new NullPointerException();
        }
        this.bitField0_ |= 0x8;
        this.mnemonic_ = mnemonic_;
        this.onChanged();
        return this;
    }
    
    @Override
    public boolean hasOperands() {
        return (this.bitField0_ & 0x10) == 0x10;
    }
    
    @Override
    public String getOperands() {
        final Object operands_ = this.operands_;
        if (!(operands_ instanceof String)) {
            final ByteString byteString = (ByteString)operands_;
            final String stringUtf8 = byteString.toStringUtf8();
            if (byteString.isValidUtf8()) {
                this.operands_ = stringUtf8;
            }
            return stringUtf8;
        }
        return (String)operands_;
    }
    
    @Override
    public ByteString getOperandsBytes() {
        final Object operands_ = this.operands_;
        if (operands_ instanceof String) {
            return (ByteString)(this.operands_ = ByteString.copyFromUtf8((String)operands_));
        }
        return (ByteString)operands_;
    }
    
    public BinExport$Flowgraph$Vertex$Instruction$Builder setOperands(final String operands_) {
        if (operands_ == null) {
            throw new NullPointerException();
        }
        this.bitField0_ |= 0x10;
        this.operands_ = operands_;
        this.onChanged();
        return this;
    }
    
    public BinExport$Flowgraph$Vertex$Instruction$Builder clearOperands() {
        this.bitField0_ &= 0xFFFFFFEF;
        this.operands_ = BinExport$Flowgraph$Vertex$Instruction.getDefaultInstance().getOperands();
        this.onChanged();
        return this;
    }
    
    public BinExport$Flowgraph$Vertex$Instruction$Builder setOperandsBytes(final ByteString operands_) {
        if (operands_ == null) {
            throw new NullPointerException();
        }
        this.bitField0_ |= 0x10;
        this.operands_ = operands_;
        this.onChanged();
        return this;
    }
    
    @Override
    public boolean hasRawBytes() {
        return (this.bitField0_ & 0x20) == 0x20;
    }
    
    @Override
    public ByteString getRawBytes() {
        return this.rawBytes_;
    }
    
    public BinExport$Flowgraph$Vertex$Instruction$Builder setRawBytes(final ByteString rawBytes_) {
        if (rawBytes_ == null) {
            throw new NullPointerException();
        }
        this.bitField0_ |= 0x20;
        this.rawBytes_ = rawBytes_;
        this.onChanged();
        return this;
    }
    
    public BinExport$Flowgraph$Vertex$Instruction$Builder clearRawBytes() {
        this.bitField0_ &= 0xFFFFFFDF;
        this.rawBytes_ = BinExport$Flowgraph$Vertex$Instruction.getDefaultInstance().getRawBytes();
        this.onChanged();
        return this;
    }
    
    private void ensureCallTargetsIsMutable() {
        if ((this.bitField0_ & 0x40) != 0x40) {
            this.callTargets_ = new ArrayList(this.callTargets_);
            this.bitField0_ |= 0x40;
        }
    }
    
    @Override
    public List getCallTargetsList() {
        return Collections.unmodifiableList((List<?>)this.callTargets_);
    }
    
    @Override
    public int getCallTargetsCount() {
        return this.callTargets_.size();
    }
    
    @Override
    public long getCallTargets(final int n) {
        return this.callTargets_.get(n);
    }
    
    public BinExport$Flowgraph$Vertex$Instruction$Builder setCallTargets(final int n, final long n2) {
        this.ensureCallTargetsIsMutable();
        this.callTargets_.set(n, n2);
        this.onChanged();
        return this;
    }
    
    public BinExport$Flowgraph$Vertex$Instruction$Builder addCallTargets(final long n) {
        this.ensureCallTargetsIsMutable();
        this.callTargets_.add(n);
        this.onChanged();
        return this;
    }
    
    public BinExport$Flowgraph$Vertex$Instruction$Builder addAllCallTargets(final Iterable iterable) {
        this.ensureCallTargetsIsMutable();
        AbstractMessageLite$Builder.addAll(iterable, this.callTargets_);
        this.onChanged();
        return this;
    }
    
    public BinExport$Flowgraph$Vertex$Instruction$Builder clearCallTargets() {
        this.callTargets_ = Collections.emptyList();
        this.bitField0_ &= 0xFFFFFFBF;
        this.onChanged();
        return this;
    }
    
    private void ensureCommentsIsMutable() {
        if ((this.bitField0_ & 0x80) != 0x80) {
            this.comments_ = new ArrayList(this.comments_);
            this.bitField0_ |= 0x80;
        }
    }
    
    @Override
    public List getCommentsList() {
        if (this.commentsBuilder_ == null) {
            return Collections.unmodifiableList((List<?>)this.comments_);
        }
        return this.commentsBuilder_.getMessageList();
    }
    
    @Override
    public int getCommentsCount() {
        if (this.commentsBuilder_ == null) {
            return this.comments_.size();
        }
        return this.commentsBuilder_.getCount();
    }
    
    @Override
    public BinExport$Flowgraph$Vertex$Instruction$Comment getComments(final int n) {
        if (this.commentsBuilder_ == null) {
            return this.comments_.get(n);
        }
        return (BinExport$Flowgraph$Vertex$Instruction$Comment)this.commentsBuilder_.getMessage(n);
    }
    
    public BinExport$Flowgraph$Vertex$Instruction$Builder setComments(final int n, final BinExport$Flowgraph$Vertex$Instruction$Comment binExport$Flowgraph$Vertex$Instruction$Comment) {
        if (this.commentsBuilder_ == null) {
            if (binExport$Flowgraph$Vertex$Instruction$Comment == null) {
                throw new NullPointerException();
            }
            this.ensureCommentsIsMutable();
            this.comments_.set(n, binExport$Flowgraph$Vertex$Instruction$Comment);
            this.onChanged();
        }
        else {
            this.commentsBuilder_.setMessage(n, binExport$Flowgraph$Vertex$Instruction$Comment);
        }
        return this;
    }
    
    public BinExport$Flowgraph$Vertex$Instruction$Builder setComments(final int n, final BinExport$Flowgraph$Vertex$Instruction$Comment$Builder binExport$Flowgraph$Vertex$Instruction$Comment$Builder) {
        if (this.commentsBuilder_ == null) {
            this.ensureCommentsIsMutable();
            this.comments_.set(n, binExport$Flowgraph$Vertex$Instruction$Comment$Builder.build());
            this.onChanged();
        }
        else {
            this.commentsBuilder_.setMessage(n, binExport$Flowgraph$Vertex$Instruction$Comment$Builder.build());
        }
        return this;
    }
    
    public BinExport$Flowgraph$Vertex$Instruction$Builder addComments(final BinExport$Flowgraph$Vertex$Instruction$Comment binExport$Flowgraph$Vertex$Instruction$Comment) {
        if (this.commentsBuilder_ == null) {
            if (binExport$Flowgraph$Vertex$Instruction$Comment == null) {
                throw new NullPointerException();
            }
            this.ensureCommentsIsMutable();
            this.comments_.add(binExport$Flowgraph$Vertex$Instruction$Comment);
            this.onChanged();
        }
        else {
            this.commentsBuilder_.addMessage(binExport$Flowgraph$Vertex$Instruction$Comment);
        }
        return this;
    }
    
    public BinExport$Flowgraph$Vertex$Instruction$Builder addComments(final int n, final BinExport$Flowgraph$Vertex$Instruction$Comment binExport$Flowgraph$Vertex$Instruction$Comment) {
        if (this.commentsBuilder_ == null) {
            if (binExport$Flowgraph$Vertex$Instruction$Comment == null) {
                throw new NullPointerException();
            }
            this.ensureCommentsIsMutable();
            this.comments_.add(n, binExport$Flowgraph$Vertex$Instruction$Comment);
            this.onChanged();
        }
        else {
            this.commentsBuilder_.addMessage(n, binExport$Flowgraph$Vertex$Instruction$Comment);
        }
        return this;
    }
    
    public BinExport$Flowgraph$Vertex$Instruction$Builder addComments(final BinExport$Flowgraph$Vertex$Instruction$Comment$Builder binExport$Flowgraph$Vertex$Instruction$Comment$Builder) {
        if (this.commentsBuilder_ == null) {
            this.ensureCommentsIsMutable();
            this.comments_.add(binExport$Flowgraph$Vertex$Instruction$Comment$Builder.build());
            this.onChanged();
        }
        else {
            this.commentsBuilder_.addMessage(binExport$Flowgraph$Vertex$Instruction$Comment$Builder.build());
        }
        return this;
    }
    
    public BinExport$Flowgraph$Vertex$Instruction$Builder addComments(final int n, final BinExport$Flowgraph$Vertex$Instruction$Comment$Builder binExport$Flowgraph$Vertex$Instruction$Comment$Builder) {
        if (this.commentsBuilder_ == null) {
            this.ensureCommentsIsMutable();
            this.comments_.add(n, binExport$Flowgraph$Vertex$Instruction$Comment$Builder.build());
            this.onChanged();
        }
        else {
            this.commentsBuilder_.addMessage(n, binExport$Flowgraph$Vertex$Instruction$Comment$Builder.build());
        }
        return this;
    }
    
    public BinExport$Flowgraph$Vertex$Instruction$Builder addAllComments(final Iterable iterable) {
        if (this.commentsBuilder_ == null) {
            this.ensureCommentsIsMutable();
            AbstractMessageLite$Builder.addAll(iterable, this.comments_);
            this.onChanged();
        }
        else {
            this.commentsBuilder_.addAllMessages(iterable);
        }
        return this;
    }
    
    public BinExport$Flowgraph$Vertex$Instruction$Builder clearComments() {
        if (this.commentsBuilder_ == null) {
            this.comments_ = Collections.emptyList();
            this.bitField0_ &= 0xFFFFFF7F;
            this.onChanged();
        }
        else {
            this.commentsBuilder_.clear();
        }
        return this;
    }
    
    public BinExport$Flowgraph$Vertex$Instruction$Builder removeComments(final int n) {
        if (this.commentsBuilder_ == null) {
            this.ensureCommentsIsMutable();
            this.comments_.remove(n);
            this.onChanged();
        }
        else {
            this.commentsBuilder_.remove(n);
        }
        return this;
    }
    
    public BinExport$Flowgraph$Vertex$Instruction$Comment$Builder getCommentsBuilder(final int n) {
        return (BinExport$Flowgraph$Vertex$Instruction$Comment$Builder)this.getCommentsFieldBuilder().getBuilder(n);
    }
    
    @Override
    public BinExport$Flowgraph$Vertex$Instruction$CommentOrBuilder getCommentsOrBuilder(final int n) {
        if (this.commentsBuilder_ == null) {
            return this.comments_.get(n);
        }
        return (BinExport$Flowgraph$Vertex$Instruction$CommentOrBuilder)this.commentsBuilder_.getMessageOrBuilder(n);
    }
    
    @Override
    public List getCommentsOrBuilderList() {
        if (this.commentsBuilder_ != null) {
            return this.commentsBuilder_.getMessageOrBuilderList();
        }
        return Collections.unmodifiableList((List<?>)this.comments_);
    }
    
    public BinExport$Flowgraph$Vertex$Instruction$Comment$Builder addCommentsBuilder() {
        return (BinExport$Flowgraph$Vertex$Instruction$Comment$Builder)this.getCommentsFieldBuilder().addBuilder(BinExport$Flowgraph$Vertex$Instruction$Comment.getDefaultInstance());
    }
    
    public BinExport$Flowgraph$Vertex$Instruction$Comment$Builder addCommentsBuilder(final int n) {
        return (BinExport$Flowgraph$Vertex$Instruction$Comment$Builder)this.getCommentsFieldBuilder().addBuilder(n, BinExport$Flowgraph$Vertex$Instruction$Comment.getDefaultInstance());
    }
    
    public List getCommentsBuilderList() {
        return this.getCommentsFieldBuilder().getBuilderList();
    }
    
    private RepeatedFieldBuilder getCommentsFieldBuilder() {
        if (this.commentsBuilder_ == null) {
            this.commentsBuilder_ = new RepeatedFieldBuilder(this.comments_, (this.bitField0_ & 0x80) == 0x80, this.getParentForChildren(), this.isClean());
            this.comments_ = null;
        }
        return this.commentsBuilder_;
    }
}
