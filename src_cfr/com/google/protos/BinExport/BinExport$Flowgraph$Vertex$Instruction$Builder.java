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
import com.google.protos.BinExport.BinExport;
import com.google.protos.BinExport.BinExport$1;
import com.google.protos.BinExport.BinExport$Flowgraph$Vertex$Instruction;
import com.google.protos.BinExport.BinExport$Flowgraph$Vertex$Instruction$Comment;
import com.google.protos.BinExport.BinExport$Flowgraph$Vertex$Instruction$Comment$Builder;
import com.google.protos.BinExport.BinExport$Flowgraph$Vertex$Instruction$CommentOrBuilder;
import com.google.protos.BinExport.BinExport$Flowgraph$Vertex$InstructionOrBuilder;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public final class BinExport$Flowgraph$Vertex$Instruction$Builder
extends GeneratedMessage$Builder
implements BinExport$Flowgraph$Vertex$InstructionOrBuilder {
    private int bitField0_;
    private long address_;
    private int prime_;
    private int stringReference_;
    private Object mnemonic_ = "";
    private Object operands_ = "";
    private ByteString rawBytes_ = ByteString.EMPTY;
    private List callTargets_ = Collections.emptyList();
    private List comments_ = Collections.emptyList();
    private RepeatedFieldBuilder commentsBuilder_;

    public static final Descriptors$Descriptor getDescriptor() {
        return BinExport.access$6100();
    }

    @Override
    protected GeneratedMessage$FieldAccessorTable internalGetFieldAccessorTable() {
        return BinExport.access$6200().ensureFieldAccessorsInitialized(BinExport$Flowgraph$Vertex$Instruction.class, BinExport$Flowgraph$Vertex$Instruction$Builder.class);
    }

    private BinExport$Flowgraph$Vertex$Instruction$Builder() {
        this.maybeForceBuilderInitialization();
    }

    private BinExport$Flowgraph$Vertex$Instruction$Builder(GeneratedMessage$BuilderParent generatedMessage$BuilderParent) {
        super(generatedMessage$BuilderParent);
        this.maybeForceBuilderInitialization();
    }

    private void maybeForceBuilderInitialization() {
        if (!BinExport$Flowgraph$Vertex$Instruction.access$7600()) return;
        this.getCommentsFieldBuilder();
    }

    @Override
    public BinExport$Flowgraph$Vertex$Instruction$Builder clear() {
        super.clear();
        this.address_ = 0;
        this.bitField0_ &= -2;
        this.prime_ = 0;
        this.bitField0_ &= -3;
        this.stringReference_ = 0;
        this.bitField0_ &= -5;
        this.mnemonic_ = "";
        this.bitField0_ &= -9;
        this.operands_ = "";
        this.bitField0_ &= -17;
        this.rawBytes_ = ByteString.EMPTY;
        this.bitField0_ &= -33;
        this.callTargets_ = Collections.emptyList();
        this.bitField0_ &= -65;
        if (this.commentsBuilder_ == null) {
            this.comments_ = Collections.emptyList();
            this.bitField0_ &= -129;
            return this;
        }
        this.commentsBuilder_.clear();
        return this;
    }

    @Override
    public Descriptors$Descriptor getDescriptorForType() {
        return BinExport.access$6100();
    }

    @Override
    public BinExport$Flowgraph$Vertex$Instruction getDefaultInstanceForType() {
        return BinExport$Flowgraph$Vertex$Instruction.getDefaultInstance();
    }

    @Override
    public BinExport$Flowgraph$Vertex$Instruction build() {
        BinExport$Flowgraph$Vertex$Instruction binExport$Flowgraph$Vertex$Instruction = this.buildPartial();
        if (binExport$Flowgraph$Vertex$Instruction.isInitialized()) return binExport$Flowgraph$Vertex$Instruction;
        throw BinExport$Flowgraph$Vertex$Instruction$Builder.newUninitializedMessageException(binExport$Flowgraph$Vertex$Instruction);
    }

    @Override
    public BinExport$Flowgraph$Vertex$Instruction buildPartial() {
        BinExport$Flowgraph$Vertex$Instruction binExport$Flowgraph$Vertex$Instruction = new BinExport$Flowgraph$Vertex$Instruction(this, null);
        int n2 = this.bitField0_;
        int n3 = 0;
        if ((n2 & 1) == 1) {
            n3 |= true;
        }
        BinExport$Flowgraph$Vertex$Instruction.access$7802(binExport$Flowgraph$Vertex$Instruction, this.address_);
        if ((n2 & 2) == 2) {
            n3 |= 2;
        }
        BinExport$Flowgraph$Vertex$Instruction.access$7902(binExport$Flowgraph$Vertex$Instruction, this.prime_);
        if ((n2 & 4) == 4) {
            n3 |= 4;
        }
        BinExport$Flowgraph$Vertex$Instruction.access$8002(binExport$Flowgraph$Vertex$Instruction, this.stringReference_);
        if ((n2 & 8) == 8) {
            n3 |= 8;
        }
        BinExport$Flowgraph$Vertex$Instruction.access$8102(binExport$Flowgraph$Vertex$Instruction, this.mnemonic_);
        if ((n2 & 16) == 16) {
            n3 |= 16;
        }
        BinExport$Flowgraph$Vertex$Instruction.access$8202(binExport$Flowgraph$Vertex$Instruction, this.operands_);
        if ((n2 & 32) == 32) {
            n3 |= 32;
        }
        BinExport$Flowgraph$Vertex$Instruction.access$8302(binExport$Flowgraph$Vertex$Instruction, this.rawBytes_);
        if ((this.bitField0_ & 64) == 64) {
            this.callTargets_ = Collections.unmodifiableList(this.callTargets_);
            this.bitField0_ &= -65;
        }
        BinExport$Flowgraph$Vertex$Instruction.access$8402(binExport$Flowgraph$Vertex$Instruction, this.callTargets_);
        if (this.commentsBuilder_ == null) {
            if ((this.bitField0_ & 128) == 128) {
                this.comments_ = Collections.unmodifiableList(this.comments_);
                this.bitField0_ &= -129;
            }
            BinExport$Flowgraph$Vertex$Instruction.access$8502(binExport$Flowgraph$Vertex$Instruction, this.comments_);
        } else {
            BinExport$Flowgraph$Vertex$Instruction.access$8502(binExport$Flowgraph$Vertex$Instruction, this.commentsBuilder_.build());
        }
        BinExport$Flowgraph$Vertex$Instruction.access$8602(binExport$Flowgraph$Vertex$Instruction, n3);
        this.onBuilt();
        return binExport$Flowgraph$Vertex$Instruction;
    }

    @Override
    public BinExport$Flowgraph$Vertex$Instruction$Builder mergeFrom(Message message) {
        if (message instanceof BinExport$Flowgraph$Vertex$Instruction) {
            return this.mergeFrom((BinExport$Flowgraph$Vertex$Instruction)message);
        }
        super.mergeFrom(message);
        return this;
    }

    public BinExport$Flowgraph$Vertex$Instruction$Builder mergeFrom(BinExport$Flowgraph$Vertex$Instruction binExport$Flowgraph$Vertex$Instruction) {
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
            this.bitField0_ |= 8;
            this.mnemonic_ = BinExport$Flowgraph$Vertex$Instruction.access$8100(binExport$Flowgraph$Vertex$Instruction);
            this.onChanged();
        }
        if (binExport$Flowgraph$Vertex$Instruction.hasOperands()) {
            this.bitField0_ |= 16;
            this.operands_ = BinExport$Flowgraph$Vertex$Instruction.access$8200(binExport$Flowgraph$Vertex$Instruction);
            this.onChanged();
        }
        if (binExport$Flowgraph$Vertex$Instruction.hasRawBytes()) {
            this.setRawBytes(binExport$Flowgraph$Vertex$Instruction.getRawBytes());
        }
        if (!BinExport$Flowgraph$Vertex$Instruction.access$8400(binExport$Flowgraph$Vertex$Instruction).isEmpty()) {
            if (this.callTargets_.isEmpty()) {
                this.callTargets_ = BinExport$Flowgraph$Vertex$Instruction.access$8400(binExport$Flowgraph$Vertex$Instruction);
                this.bitField0_ &= -65;
            } else {
                this.ensureCallTargetsIsMutable();
                this.callTargets_.addAll(BinExport$Flowgraph$Vertex$Instruction.access$8400(binExport$Flowgraph$Vertex$Instruction));
            }
            this.onChanged();
        }
        if (this.commentsBuilder_ == null) {
            if (!BinExport$Flowgraph$Vertex$Instruction.access$8500(binExport$Flowgraph$Vertex$Instruction).isEmpty()) {
                if (this.comments_.isEmpty()) {
                    this.comments_ = BinExport$Flowgraph$Vertex$Instruction.access$8500(binExport$Flowgraph$Vertex$Instruction);
                    this.bitField0_ &= -129;
                } else {
                    this.ensureCommentsIsMutable();
                    this.comments_.addAll(BinExport$Flowgraph$Vertex$Instruction.access$8500(binExport$Flowgraph$Vertex$Instruction));
                }
                this.onChanged();
            }
        } else if (!BinExport$Flowgraph$Vertex$Instruction.access$8500(binExport$Flowgraph$Vertex$Instruction).isEmpty()) {
            if (this.commentsBuilder_.isEmpty()) {
                this.commentsBuilder_.dispose();
                this.commentsBuilder_ = null;
                this.comments_ = BinExport$Flowgraph$Vertex$Instruction.access$8500(binExport$Flowgraph$Vertex$Instruction);
                this.bitField0_ &= -129;
                this.commentsBuilder_ = BinExport$Flowgraph$Vertex$Instruction.access$8700() ? this.getCommentsFieldBuilder() : null;
            } else {
                this.commentsBuilder_.addAllMessages(BinExport$Flowgraph$Vertex$Instruction.access$8500(binExport$Flowgraph$Vertex$Instruction));
            }
        }
        this.mergeUnknownFields(BinExport$Flowgraph$Vertex$Instruction.access$8800(binExport$Flowgraph$Vertex$Instruction));
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
        int n2 = 0;
        while (n2 < this.getCommentsCount()) {
            if (!this.getComments(n2).isInitialized()) {
                return false;
            }
            ++n2;
        }
        return true;
    }

    @Override
    public BinExport$Flowgraph$Vertex$Instruction$Builder mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        BinExport$Flowgraph$Vertex$Instruction binExport$Flowgraph$Vertex$Instruction = null;
        try {
            binExport$Flowgraph$Vertex$Instruction = (BinExport$Flowgraph$Vertex$Instruction)BinExport$Flowgraph$Vertex$Instruction.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
            return this;
        }
        catch (InvalidProtocolBufferException var4_4) {
            binExport$Flowgraph$Vertex$Instruction = (BinExport$Flowgraph$Vertex$Instruction)var4_4.getUnfinishedMessage();
            throw var4_4;
        }
        finally {
            if (binExport$Flowgraph$Vertex$Instruction != null) {
                this.mergeFrom(binExport$Flowgraph$Vertex$Instruction);
            }
        }
    }

    @Override
    public boolean hasAddress() {
        if ((this.bitField0_ & 1) != 1) return false;
        return true;
    }

    @Override
    public long getAddress() {
        return this.address_;
    }

    public BinExport$Flowgraph$Vertex$Instruction$Builder setAddress(long l2) {
        this.bitField0_ |= 1;
        this.address_ = l2;
        this.onChanged();
        return this;
    }

    public BinExport$Flowgraph$Vertex$Instruction$Builder clearAddress() {
        this.bitField0_ &= -2;
        this.address_ = 0;
        this.onChanged();
        return this;
    }

    @Override
    public boolean hasPrime() {
        if ((this.bitField0_ & 2) != 2) return false;
        return true;
    }

    @Override
    public int getPrime() {
        return this.prime_;
    }

    public BinExport$Flowgraph$Vertex$Instruction$Builder setPrime(int n2) {
        this.bitField0_ |= 2;
        this.prime_ = n2;
        this.onChanged();
        return this;
    }

    public BinExport$Flowgraph$Vertex$Instruction$Builder clearPrime() {
        this.bitField0_ &= -3;
        this.prime_ = 0;
        this.onChanged();
        return this;
    }

    @Override
    public boolean hasStringReference() {
        if ((this.bitField0_ & 4) != 4) return false;
        return true;
    }

    @Override
    public int getStringReference() {
        return this.stringReference_;
    }

    public BinExport$Flowgraph$Vertex$Instruction$Builder setStringReference(int n2) {
        this.bitField0_ |= 4;
        this.stringReference_ = n2;
        this.onChanged();
        return this;
    }

    public BinExport$Flowgraph$Vertex$Instruction$Builder clearStringReference() {
        this.bitField0_ &= -5;
        this.stringReference_ = 0;
        this.onChanged();
        return this;
    }

    @Override
    public boolean hasMnemonic() {
        if ((this.bitField0_ & 8) != 8) return false;
        return true;
    }

    @Override
    public String getMnemonic() {
        Object object = this.mnemonic_;
        if (object instanceof String) return (String)object;
        ByteString byteString = (ByteString)object;
        String string = byteString.toStringUtf8();
        if (!byteString.isValidUtf8()) return string;
        this.mnemonic_ = string;
        return string;
    }

    @Override
    public ByteString getMnemonicBytes() {
        ByteString byteString;
        Object object = this.mnemonic_;
        if (!(object instanceof String)) return (ByteString)object;
        this.mnemonic_ = byteString = ByteString.copyFromUtf8((String)object);
        return byteString;
    }

    public BinExport$Flowgraph$Vertex$Instruction$Builder setMnemonic(String string) {
        if (string == null) {
            throw new NullPointerException();
        }
        this.bitField0_ |= 8;
        this.mnemonic_ = string;
        this.onChanged();
        return this;
    }

    public BinExport$Flowgraph$Vertex$Instruction$Builder clearMnemonic() {
        this.bitField0_ &= -9;
        this.mnemonic_ = BinExport$Flowgraph$Vertex$Instruction.getDefaultInstance().getMnemonic();
        this.onChanged();
        return this;
    }

    public BinExport$Flowgraph$Vertex$Instruction$Builder setMnemonicBytes(ByteString byteString) {
        if (byteString == null) {
            throw new NullPointerException();
        }
        this.bitField0_ |= 8;
        this.mnemonic_ = byteString;
        this.onChanged();
        return this;
    }

    @Override
    public boolean hasOperands() {
        if ((this.bitField0_ & 16) != 16) return false;
        return true;
    }

    @Override
    public String getOperands() {
        Object object = this.operands_;
        if (object instanceof String) return (String)object;
        ByteString byteString = (ByteString)object;
        String string = byteString.toStringUtf8();
        if (!byteString.isValidUtf8()) return string;
        this.operands_ = string;
        return string;
    }

    @Override
    public ByteString getOperandsBytes() {
        ByteString byteString;
        Object object = this.operands_;
        if (!(object instanceof String)) return (ByteString)object;
        this.operands_ = byteString = ByteString.copyFromUtf8((String)object);
        return byteString;
    }

    public BinExport$Flowgraph$Vertex$Instruction$Builder setOperands(String string) {
        if (string == null) {
            throw new NullPointerException();
        }
        this.bitField0_ |= 16;
        this.operands_ = string;
        this.onChanged();
        return this;
    }

    public BinExport$Flowgraph$Vertex$Instruction$Builder clearOperands() {
        this.bitField0_ &= -17;
        this.operands_ = BinExport$Flowgraph$Vertex$Instruction.getDefaultInstance().getOperands();
        this.onChanged();
        return this;
    }

    public BinExport$Flowgraph$Vertex$Instruction$Builder setOperandsBytes(ByteString byteString) {
        if (byteString == null) {
            throw new NullPointerException();
        }
        this.bitField0_ |= 16;
        this.operands_ = byteString;
        this.onChanged();
        return this;
    }

    @Override
    public boolean hasRawBytes() {
        if ((this.bitField0_ & 32) != 32) return false;
        return true;
    }

    @Override
    public ByteString getRawBytes() {
        return this.rawBytes_;
    }

    public BinExport$Flowgraph$Vertex$Instruction$Builder setRawBytes(ByteString byteString) {
        if (byteString == null) {
            throw new NullPointerException();
        }
        this.bitField0_ |= 32;
        this.rawBytes_ = byteString;
        this.onChanged();
        return this;
    }

    public BinExport$Flowgraph$Vertex$Instruction$Builder clearRawBytes() {
        this.bitField0_ &= -33;
        this.rawBytes_ = BinExport$Flowgraph$Vertex$Instruction.getDefaultInstance().getRawBytes();
        this.onChanged();
        return this;
    }

    private void ensureCallTargetsIsMutable() {
        if ((this.bitField0_ & 64) == 64) return;
        this.callTargets_ = new ArrayList(this.callTargets_);
        this.bitField0_ |= 64;
    }

    @Override
    public List getCallTargetsList() {
        return Collections.unmodifiableList(this.callTargets_);
    }

    @Override
    public int getCallTargetsCount() {
        return this.callTargets_.size();
    }

    @Override
    public long getCallTargets(int n2) {
        return (Long)this.callTargets_.get(n2);
    }

    public BinExport$Flowgraph$Vertex$Instruction$Builder setCallTargets(int n2, long l2) {
        this.ensureCallTargetsIsMutable();
        this.callTargets_.set(n2, l2);
        this.onChanged();
        return this;
    }

    public BinExport$Flowgraph$Vertex$Instruction$Builder addCallTargets(long l2) {
        this.ensureCallTargetsIsMutable();
        this.callTargets_.add(l2);
        this.onChanged();
        return this;
    }

    public BinExport$Flowgraph$Vertex$Instruction$Builder addAllCallTargets(Iterable iterable) {
        this.ensureCallTargetsIsMutable();
        AbstractMessageLite$Builder.addAll(iterable, this.callTargets_);
        this.onChanged();
        return this;
    }

    public BinExport$Flowgraph$Vertex$Instruction$Builder clearCallTargets() {
        this.callTargets_ = Collections.emptyList();
        this.bitField0_ &= -65;
        this.onChanged();
        return this;
    }

    private void ensureCommentsIsMutable() {
        if ((this.bitField0_ & 128) == 128) return;
        this.comments_ = new ArrayList(this.comments_);
        this.bitField0_ |= 128;
    }

    @Override
    public List getCommentsList() {
        if (this.commentsBuilder_ != null) return this.commentsBuilder_.getMessageList();
        return Collections.unmodifiableList(this.comments_);
    }

    @Override
    public int getCommentsCount() {
        if (this.commentsBuilder_ != null) return this.commentsBuilder_.getCount();
        return this.comments_.size();
    }

    @Override
    public BinExport$Flowgraph$Vertex$Instruction$Comment getComments(int n2) {
        if (this.commentsBuilder_ != null) return (BinExport$Flowgraph$Vertex$Instruction$Comment)this.commentsBuilder_.getMessage(n2);
        return (BinExport$Flowgraph$Vertex$Instruction$Comment)this.comments_.get(n2);
    }

    public BinExport$Flowgraph$Vertex$Instruction$Builder setComments(int n2, BinExport$Flowgraph$Vertex$Instruction$Comment binExport$Flowgraph$Vertex$Instruction$Comment) {
        if (this.commentsBuilder_ != null) {
            this.commentsBuilder_.setMessage(n2, binExport$Flowgraph$Vertex$Instruction$Comment);
            return this;
        }
        if (binExport$Flowgraph$Vertex$Instruction$Comment == null) {
            throw new NullPointerException();
        }
        this.ensureCommentsIsMutable();
        this.comments_.set(n2, binExport$Flowgraph$Vertex$Instruction$Comment);
        this.onChanged();
        return this;
    }

    public BinExport$Flowgraph$Vertex$Instruction$Builder setComments(int n2, BinExport$Flowgraph$Vertex$Instruction$Comment$Builder binExport$Flowgraph$Vertex$Instruction$Comment$Builder) {
        if (this.commentsBuilder_ == null) {
            this.ensureCommentsIsMutable();
            this.comments_.set(n2, binExport$Flowgraph$Vertex$Instruction$Comment$Builder.build());
            this.onChanged();
            return this;
        }
        this.commentsBuilder_.setMessage(n2, binExport$Flowgraph$Vertex$Instruction$Comment$Builder.build());
        return this;
    }

    public BinExport$Flowgraph$Vertex$Instruction$Builder addComments(BinExport$Flowgraph$Vertex$Instruction$Comment binExport$Flowgraph$Vertex$Instruction$Comment) {
        if (this.commentsBuilder_ != null) {
            this.commentsBuilder_.addMessage(binExport$Flowgraph$Vertex$Instruction$Comment);
            return this;
        }
        if (binExport$Flowgraph$Vertex$Instruction$Comment == null) {
            throw new NullPointerException();
        }
        this.ensureCommentsIsMutable();
        this.comments_.add(binExport$Flowgraph$Vertex$Instruction$Comment);
        this.onChanged();
        return this;
    }

    public BinExport$Flowgraph$Vertex$Instruction$Builder addComments(int n2, BinExport$Flowgraph$Vertex$Instruction$Comment binExport$Flowgraph$Vertex$Instruction$Comment) {
        if (this.commentsBuilder_ != null) {
            this.commentsBuilder_.addMessage(n2, binExport$Flowgraph$Vertex$Instruction$Comment);
            return this;
        }
        if (binExport$Flowgraph$Vertex$Instruction$Comment == null) {
            throw new NullPointerException();
        }
        this.ensureCommentsIsMutable();
        this.comments_.add(n2, binExport$Flowgraph$Vertex$Instruction$Comment);
        this.onChanged();
        return this;
    }

    public BinExport$Flowgraph$Vertex$Instruction$Builder addComments(BinExport$Flowgraph$Vertex$Instruction$Comment$Builder binExport$Flowgraph$Vertex$Instruction$Comment$Builder) {
        if (this.commentsBuilder_ == null) {
            this.ensureCommentsIsMutable();
            this.comments_.add(binExport$Flowgraph$Vertex$Instruction$Comment$Builder.build());
            this.onChanged();
            return this;
        }
        this.commentsBuilder_.addMessage(binExport$Flowgraph$Vertex$Instruction$Comment$Builder.build());
        return this;
    }

    public BinExport$Flowgraph$Vertex$Instruction$Builder addComments(int n2, BinExport$Flowgraph$Vertex$Instruction$Comment$Builder binExport$Flowgraph$Vertex$Instruction$Comment$Builder) {
        if (this.commentsBuilder_ == null) {
            this.ensureCommentsIsMutable();
            this.comments_.add(n2, binExport$Flowgraph$Vertex$Instruction$Comment$Builder.build());
            this.onChanged();
            return this;
        }
        this.commentsBuilder_.addMessage(n2, binExport$Flowgraph$Vertex$Instruction$Comment$Builder.build());
        return this;
    }

    public BinExport$Flowgraph$Vertex$Instruction$Builder addAllComments(Iterable iterable) {
        if (this.commentsBuilder_ == null) {
            this.ensureCommentsIsMutable();
            AbstractMessageLite$Builder.addAll(iterable, this.comments_);
            this.onChanged();
            return this;
        }
        this.commentsBuilder_.addAllMessages(iterable);
        return this;
    }

    public BinExport$Flowgraph$Vertex$Instruction$Builder clearComments() {
        if (this.commentsBuilder_ == null) {
            this.comments_ = Collections.emptyList();
            this.bitField0_ &= -129;
            this.onChanged();
            return this;
        }
        this.commentsBuilder_.clear();
        return this;
    }

    public BinExport$Flowgraph$Vertex$Instruction$Builder removeComments(int n2) {
        if (this.commentsBuilder_ == null) {
            this.ensureCommentsIsMutable();
            this.comments_.remove(n2);
            this.onChanged();
            return this;
        }
        this.commentsBuilder_.remove(n2);
        return this;
    }

    public BinExport$Flowgraph$Vertex$Instruction$Comment$Builder getCommentsBuilder(int n2) {
        return (BinExport$Flowgraph$Vertex$Instruction$Comment$Builder)this.getCommentsFieldBuilder().getBuilder(n2);
    }

    @Override
    public BinExport$Flowgraph$Vertex$Instruction$CommentOrBuilder getCommentsOrBuilder(int n2) {
        if (this.commentsBuilder_ != null) return (BinExport$Flowgraph$Vertex$Instruction$CommentOrBuilder)this.commentsBuilder_.getMessageOrBuilder(n2);
        return (BinExport$Flowgraph$Vertex$Instruction$CommentOrBuilder)this.comments_.get(n2);
    }

    @Override
    public List getCommentsOrBuilderList() {
        if (this.commentsBuilder_ == null) return Collections.unmodifiableList(this.comments_);
        return this.commentsBuilder_.getMessageOrBuilderList();
    }

    public BinExport$Flowgraph$Vertex$Instruction$Comment$Builder addCommentsBuilder() {
        return (BinExport$Flowgraph$Vertex$Instruction$Comment$Builder)this.getCommentsFieldBuilder().addBuilder(BinExport$Flowgraph$Vertex$Instruction$Comment.getDefaultInstance());
    }

    public BinExport$Flowgraph$Vertex$Instruction$Comment$Builder addCommentsBuilder(int n2) {
        return (BinExport$Flowgraph$Vertex$Instruction$Comment$Builder)this.getCommentsFieldBuilder().addBuilder(n2, BinExport$Flowgraph$Vertex$Instruction$Comment.getDefaultInstance());
    }

    public List getCommentsBuilderList() {
        return this.getCommentsFieldBuilder().getBuilderList();
    }

    private RepeatedFieldBuilder getCommentsFieldBuilder() {
        if (this.commentsBuilder_ != null) return this.commentsBuilder_;
        this.commentsBuilder_ = new RepeatedFieldBuilder(this.comments_, (this.bitField0_ & 128) == 128, this.getParentForChildren(), this.isClean());
        this.comments_ = null;
        return this.commentsBuilder_;
    }

    /* synthetic */ BinExport$Flowgraph$Vertex$Instruction$Builder(BinExport$1 binExport$1) {
        this();
    }

    /* synthetic */ BinExport$Flowgraph$Vertex$Instruction$Builder(GeneratedMessage$BuilderParent generatedMessage$BuilderParent, BinExport$1 binExport$1) {
        this(generatedMessage$BuilderParent);
    }
}

