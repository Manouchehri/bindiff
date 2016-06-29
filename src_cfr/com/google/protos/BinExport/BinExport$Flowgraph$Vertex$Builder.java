/*
 * Decompiled with CFR 0_115.
 */
package com.google.protos.BinExport;

import com.google.protobuf.AbstractMessage$Builder;
import com.google.protobuf.AbstractMessageLite$Builder;
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
import com.google.protos.BinExport.BinExport$Flowgraph$Vertex;
import com.google.protos.BinExport.BinExport$Flowgraph$Vertex$Instruction;
import com.google.protos.BinExport.BinExport$Flowgraph$Vertex$Instruction$Builder;
import com.google.protos.BinExport.BinExport$Flowgraph$Vertex$InstructionOrBuilder;
import com.google.protos.BinExport.BinExport$Flowgraph$VertexOrBuilder;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public final class BinExport$Flowgraph$Vertex$Builder
extends GeneratedMessage$Builder
implements BinExport$Flowgraph$VertexOrBuilder {
    private int bitField0_;
    private long prime_;
    private List instructions_ = Collections.emptyList();
    private RepeatedFieldBuilder instructionsBuilder_;

    public static final Descriptors$Descriptor getDescriptor() {
        return BinExport.access$5900();
    }

    @Override
    protected GeneratedMessage$FieldAccessorTable internalGetFieldAccessorTable() {
        return BinExport.access$6000().ensureFieldAccessorsInitialized(BinExport$Flowgraph$Vertex.class, BinExport$Flowgraph$Vertex$Builder.class);
    }

    private BinExport$Flowgraph$Vertex$Builder() {
        this.maybeForceBuilderInitialization();
    }

    private BinExport$Flowgraph$Vertex$Builder(GeneratedMessage$BuilderParent generatedMessage$BuilderParent) {
        super(generatedMessage$BuilderParent);
        this.maybeForceBuilderInitialization();
    }

    private void maybeForceBuilderInitialization() {
        if (!BinExport$Flowgraph$Vertex.access$9200()) return;
        this.getInstructionsFieldBuilder();
    }

    @Override
    public BinExport$Flowgraph$Vertex$Builder clear() {
        super.clear();
        this.prime_ = 0;
        this.bitField0_ &= -2;
        if (this.instructionsBuilder_ == null) {
            this.instructions_ = Collections.emptyList();
            this.bitField0_ &= -3;
            return this;
        }
        this.instructionsBuilder_.clear();
        return this;
    }

    @Override
    public Descriptors$Descriptor getDescriptorForType() {
        return BinExport.access$5900();
    }

    @Override
    public BinExport$Flowgraph$Vertex getDefaultInstanceForType() {
        return BinExport$Flowgraph$Vertex.getDefaultInstance();
    }

    @Override
    public BinExport$Flowgraph$Vertex build() {
        BinExport$Flowgraph$Vertex binExport$Flowgraph$Vertex = this.buildPartial();
        if (binExport$Flowgraph$Vertex.isInitialized()) return binExport$Flowgraph$Vertex;
        throw BinExport$Flowgraph$Vertex$Builder.newUninitializedMessageException(binExport$Flowgraph$Vertex);
    }

    @Override
    public BinExport$Flowgraph$Vertex buildPartial() {
        BinExport$Flowgraph$Vertex binExport$Flowgraph$Vertex = new BinExport$Flowgraph$Vertex(this, null);
        int n2 = this.bitField0_;
        int n3 = 0;
        if ((n2 & 1) == 1) {
            n3 |= true;
        }
        BinExport$Flowgraph$Vertex.access$9402(binExport$Flowgraph$Vertex, this.prime_);
        if (this.instructionsBuilder_ == null) {
            if ((this.bitField0_ & 2) == 2) {
                this.instructions_ = Collections.unmodifiableList(this.instructions_);
                this.bitField0_ &= -3;
            }
            BinExport$Flowgraph$Vertex.access$9502(binExport$Flowgraph$Vertex, this.instructions_);
        } else {
            BinExport$Flowgraph$Vertex.access$9502(binExport$Flowgraph$Vertex, this.instructionsBuilder_.build());
        }
        BinExport$Flowgraph$Vertex.access$9602(binExport$Flowgraph$Vertex, n3);
        this.onBuilt();
        return binExport$Flowgraph$Vertex;
    }

    @Override
    public BinExport$Flowgraph$Vertex$Builder mergeFrom(Message message) {
        if (message instanceof BinExport$Flowgraph$Vertex) {
            return this.mergeFrom((BinExport$Flowgraph$Vertex)message);
        }
        super.mergeFrom(message);
        return this;
    }

    public BinExport$Flowgraph$Vertex$Builder mergeFrom(BinExport$Flowgraph$Vertex binExport$Flowgraph$Vertex) {
        if (binExport$Flowgraph$Vertex == BinExport$Flowgraph$Vertex.getDefaultInstance()) {
            return this;
        }
        if (binExport$Flowgraph$Vertex.hasPrime()) {
            this.setPrime(binExport$Flowgraph$Vertex.getPrime());
        }
        if (this.instructionsBuilder_ == null) {
            if (!BinExport$Flowgraph$Vertex.access$9500(binExport$Flowgraph$Vertex).isEmpty()) {
                if (this.instructions_.isEmpty()) {
                    this.instructions_ = BinExport$Flowgraph$Vertex.access$9500(binExport$Flowgraph$Vertex);
                    this.bitField0_ &= -3;
                } else {
                    this.ensureInstructionsIsMutable();
                    this.instructions_.addAll(BinExport$Flowgraph$Vertex.access$9500(binExport$Flowgraph$Vertex));
                }
                this.onChanged();
            }
        } else if (!BinExport$Flowgraph$Vertex.access$9500(binExport$Flowgraph$Vertex).isEmpty()) {
            if (this.instructionsBuilder_.isEmpty()) {
                this.instructionsBuilder_.dispose();
                this.instructionsBuilder_ = null;
                this.instructions_ = BinExport$Flowgraph$Vertex.access$9500(binExport$Flowgraph$Vertex);
                this.bitField0_ &= -3;
                this.instructionsBuilder_ = BinExport$Flowgraph$Vertex.access$9700() ? this.getInstructionsFieldBuilder() : null;
            } else {
                this.instructionsBuilder_.addAllMessages(BinExport$Flowgraph$Vertex.access$9500(binExport$Flowgraph$Vertex));
            }
        }
        this.mergeUnknownFields(BinExport$Flowgraph$Vertex.access$9800(binExport$Flowgraph$Vertex));
        this.onChanged();
        return this;
    }

    @Override
    public final boolean isInitialized() {
        if (!this.hasPrime()) {
            return false;
        }
        int n2 = 0;
        while (n2 < this.getInstructionsCount()) {
            if (!this.getInstructions(n2).isInitialized()) {
                return false;
            }
            ++n2;
        }
        return true;
    }

    @Override
    public BinExport$Flowgraph$Vertex$Builder mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        BinExport$Flowgraph$Vertex binExport$Flowgraph$Vertex = null;
        try {
            binExport$Flowgraph$Vertex = (BinExport$Flowgraph$Vertex)BinExport$Flowgraph$Vertex.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
            return this;
        }
        catch (InvalidProtocolBufferException var4_4) {
            binExport$Flowgraph$Vertex = (BinExport$Flowgraph$Vertex)var4_4.getUnfinishedMessage();
            throw var4_4;
        }
        finally {
            if (binExport$Flowgraph$Vertex != null) {
                this.mergeFrom(binExport$Flowgraph$Vertex);
            }
        }
    }

    @Override
    public boolean hasPrime() {
        if ((this.bitField0_ & 1) != 1) return false;
        return true;
    }

    @Override
    public long getPrime() {
        return this.prime_;
    }

    public BinExport$Flowgraph$Vertex$Builder setPrime(long l2) {
        this.bitField0_ |= 1;
        this.prime_ = l2;
        this.onChanged();
        return this;
    }

    public BinExport$Flowgraph$Vertex$Builder clearPrime() {
        this.bitField0_ &= -2;
        this.prime_ = 0;
        this.onChanged();
        return this;
    }

    private void ensureInstructionsIsMutable() {
        if ((this.bitField0_ & 2) == 2) return;
        this.instructions_ = new ArrayList(this.instructions_);
        this.bitField0_ |= 2;
    }

    @Override
    public List getInstructionsList() {
        if (this.instructionsBuilder_ != null) return this.instructionsBuilder_.getMessageList();
        return Collections.unmodifiableList(this.instructions_);
    }

    @Override
    public int getInstructionsCount() {
        if (this.instructionsBuilder_ != null) return this.instructionsBuilder_.getCount();
        return this.instructions_.size();
    }

    @Override
    public BinExport$Flowgraph$Vertex$Instruction getInstructions(int n2) {
        if (this.instructionsBuilder_ != null) return (BinExport$Flowgraph$Vertex$Instruction)this.instructionsBuilder_.getMessage(n2);
        return (BinExport$Flowgraph$Vertex$Instruction)this.instructions_.get(n2);
    }

    public BinExport$Flowgraph$Vertex$Builder setInstructions(int n2, BinExport$Flowgraph$Vertex$Instruction binExport$Flowgraph$Vertex$Instruction) {
        if (this.instructionsBuilder_ != null) {
            this.instructionsBuilder_.setMessage(n2, binExport$Flowgraph$Vertex$Instruction);
            return this;
        }
        if (binExport$Flowgraph$Vertex$Instruction == null) {
            throw new NullPointerException();
        }
        this.ensureInstructionsIsMutable();
        this.instructions_.set(n2, binExport$Flowgraph$Vertex$Instruction);
        this.onChanged();
        return this;
    }

    public BinExport$Flowgraph$Vertex$Builder setInstructions(int n2, BinExport$Flowgraph$Vertex$Instruction$Builder binExport$Flowgraph$Vertex$Instruction$Builder) {
        if (this.instructionsBuilder_ == null) {
            this.ensureInstructionsIsMutable();
            this.instructions_.set(n2, binExport$Flowgraph$Vertex$Instruction$Builder.build());
            this.onChanged();
            return this;
        }
        this.instructionsBuilder_.setMessage(n2, binExport$Flowgraph$Vertex$Instruction$Builder.build());
        return this;
    }

    public BinExport$Flowgraph$Vertex$Builder addInstructions(BinExport$Flowgraph$Vertex$Instruction binExport$Flowgraph$Vertex$Instruction) {
        if (this.instructionsBuilder_ != null) {
            this.instructionsBuilder_.addMessage(binExport$Flowgraph$Vertex$Instruction);
            return this;
        }
        if (binExport$Flowgraph$Vertex$Instruction == null) {
            throw new NullPointerException();
        }
        this.ensureInstructionsIsMutable();
        this.instructions_.add(binExport$Flowgraph$Vertex$Instruction);
        this.onChanged();
        return this;
    }

    public BinExport$Flowgraph$Vertex$Builder addInstructions(int n2, BinExport$Flowgraph$Vertex$Instruction binExport$Flowgraph$Vertex$Instruction) {
        if (this.instructionsBuilder_ != null) {
            this.instructionsBuilder_.addMessage(n2, binExport$Flowgraph$Vertex$Instruction);
            return this;
        }
        if (binExport$Flowgraph$Vertex$Instruction == null) {
            throw new NullPointerException();
        }
        this.ensureInstructionsIsMutable();
        this.instructions_.add(n2, binExport$Flowgraph$Vertex$Instruction);
        this.onChanged();
        return this;
    }

    public BinExport$Flowgraph$Vertex$Builder addInstructions(BinExport$Flowgraph$Vertex$Instruction$Builder binExport$Flowgraph$Vertex$Instruction$Builder) {
        if (this.instructionsBuilder_ == null) {
            this.ensureInstructionsIsMutable();
            this.instructions_.add(binExport$Flowgraph$Vertex$Instruction$Builder.build());
            this.onChanged();
            return this;
        }
        this.instructionsBuilder_.addMessage(binExport$Flowgraph$Vertex$Instruction$Builder.build());
        return this;
    }

    public BinExport$Flowgraph$Vertex$Builder addInstructions(int n2, BinExport$Flowgraph$Vertex$Instruction$Builder binExport$Flowgraph$Vertex$Instruction$Builder) {
        if (this.instructionsBuilder_ == null) {
            this.ensureInstructionsIsMutable();
            this.instructions_.add(n2, binExport$Flowgraph$Vertex$Instruction$Builder.build());
            this.onChanged();
            return this;
        }
        this.instructionsBuilder_.addMessage(n2, binExport$Flowgraph$Vertex$Instruction$Builder.build());
        return this;
    }

    public BinExport$Flowgraph$Vertex$Builder addAllInstructions(Iterable iterable) {
        if (this.instructionsBuilder_ == null) {
            this.ensureInstructionsIsMutable();
            AbstractMessageLite$Builder.addAll(iterable, this.instructions_);
            this.onChanged();
            return this;
        }
        this.instructionsBuilder_.addAllMessages(iterable);
        return this;
    }

    public BinExport$Flowgraph$Vertex$Builder clearInstructions() {
        if (this.instructionsBuilder_ == null) {
            this.instructions_ = Collections.emptyList();
            this.bitField0_ &= -3;
            this.onChanged();
            return this;
        }
        this.instructionsBuilder_.clear();
        return this;
    }

    public BinExport$Flowgraph$Vertex$Builder removeInstructions(int n2) {
        if (this.instructionsBuilder_ == null) {
            this.ensureInstructionsIsMutable();
            this.instructions_.remove(n2);
            this.onChanged();
            return this;
        }
        this.instructionsBuilder_.remove(n2);
        return this;
    }

    public BinExport$Flowgraph$Vertex$Instruction$Builder getInstructionsBuilder(int n2) {
        return (BinExport$Flowgraph$Vertex$Instruction$Builder)this.getInstructionsFieldBuilder().getBuilder(n2);
    }

    @Override
    public BinExport$Flowgraph$Vertex$InstructionOrBuilder getInstructionsOrBuilder(int n2) {
        if (this.instructionsBuilder_ != null) return (BinExport$Flowgraph$Vertex$InstructionOrBuilder)this.instructionsBuilder_.getMessageOrBuilder(n2);
        return (BinExport$Flowgraph$Vertex$InstructionOrBuilder)this.instructions_.get(n2);
    }

    @Override
    public List getInstructionsOrBuilderList() {
        if (this.instructionsBuilder_ == null) return Collections.unmodifiableList(this.instructions_);
        return this.instructionsBuilder_.getMessageOrBuilderList();
    }

    public BinExport$Flowgraph$Vertex$Instruction$Builder addInstructionsBuilder() {
        return (BinExport$Flowgraph$Vertex$Instruction$Builder)this.getInstructionsFieldBuilder().addBuilder(BinExport$Flowgraph$Vertex$Instruction.getDefaultInstance());
    }

    public BinExport$Flowgraph$Vertex$Instruction$Builder addInstructionsBuilder(int n2) {
        return (BinExport$Flowgraph$Vertex$Instruction$Builder)this.getInstructionsFieldBuilder().addBuilder(n2, BinExport$Flowgraph$Vertex$Instruction.getDefaultInstance());
    }

    public List getInstructionsBuilderList() {
        return this.getInstructionsFieldBuilder().getBuilderList();
    }

    private RepeatedFieldBuilder getInstructionsFieldBuilder() {
        if (this.instructionsBuilder_ != null) return this.instructionsBuilder_;
        this.instructionsBuilder_ = new RepeatedFieldBuilder(this.instructions_, (this.bitField0_ & 2) == 2, this.getParentForChildren(), this.isClean());
        this.instructions_ = null;
        return this.instructionsBuilder_;
    }

    /* synthetic */ BinExport$Flowgraph$Vertex$Builder(BinExport$1 binExport$1) {
        this();
    }

    /* synthetic */ BinExport$Flowgraph$Vertex$Builder(GeneratedMessage$BuilderParent generatedMessage$BuilderParent, BinExport$1 binExport$1) {
        this(generatedMessage$BuilderParent);
    }
}

