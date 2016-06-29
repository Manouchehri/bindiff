package com.google.protos.BinExport;

import java.util.*;
import com.google.protobuf.*;
import java.io.*;

public final class BinExport$Flowgraph$Vertex$Builder extends GeneratedMessage$Builder implements BinExport$Flowgraph$VertexOrBuilder
{
    private int bitField0_;
    private long prime_;
    private List instructions_;
    private RepeatedFieldBuilder instructionsBuilder_;
    
    public static final Descriptors$Descriptor getDescriptor() {
        return BinExport.internal_static_BinExport_Flowgraph_Vertex_descriptor;
    }
    
    @Override
    protected GeneratedMessage$FieldAccessorTable internalGetFieldAccessorTable() {
        return BinExport.internal_static_BinExport_Flowgraph_Vertex_fieldAccessorTable.ensureFieldAccessorsInitialized(BinExport$Flowgraph$Vertex.class, BinExport$Flowgraph$Vertex$Builder.class);
    }
    
    private BinExport$Flowgraph$Vertex$Builder() {
        this.instructions_ = Collections.emptyList();
        this.maybeForceBuilderInitialization();
    }
    
    private BinExport$Flowgraph$Vertex$Builder(final GeneratedMessage$BuilderParent generatedMessage$BuilderParent) {
        super(generatedMessage$BuilderParent);
        this.instructions_ = Collections.emptyList();
        this.maybeForceBuilderInitialization();
    }
    
    private void maybeForceBuilderInitialization() {
        if (BinExport$Flowgraph$Vertex.alwaysUseFieldBuilders) {
            this.getInstructionsFieldBuilder();
        }
    }
    
    @Override
    public BinExport$Flowgraph$Vertex$Builder clear() {
        super.clear();
        this.prime_ = 0L;
        this.bitField0_ &= 0xFFFFFFFE;
        if (this.instructionsBuilder_ == null) {
            this.instructions_ = Collections.emptyList();
            this.bitField0_ &= 0xFFFFFFFD;
        }
        else {
            this.instructionsBuilder_.clear();
        }
        return this;
    }
    
    @Override
    public Descriptors$Descriptor getDescriptorForType() {
        return BinExport.internal_static_BinExport_Flowgraph_Vertex_descriptor;
    }
    
    @Override
    public BinExport$Flowgraph$Vertex getDefaultInstanceForType() {
        return BinExport$Flowgraph$Vertex.getDefaultInstance();
    }
    
    @Override
    public BinExport$Flowgraph$Vertex build() {
        final BinExport$Flowgraph$Vertex buildPartial = this.buildPartial();
        if (!buildPartial.isInitialized()) {
            throw AbstractMessage$Builder.newUninitializedMessageException(buildPartial);
        }
        return buildPartial;
    }
    
    @Override
    public BinExport$Flowgraph$Vertex buildPartial() {
        final BinExport$Flowgraph$Vertex binExport$Flowgraph$Vertex = new BinExport$Flowgraph$Vertex(this, null);
        final int bitField0_ = this.bitField0_;
        int n = 0;
        if ((bitField0_ & 0x1) == 0x1) {
            n |= 0x1;
        }
        binExport$Flowgraph$Vertex.prime_ = this.prime_;
        if (this.instructionsBuilder_ == null) {
            if ((this.bitField0_ & 0x2) == 0x2) {
                this.instructions_ = Collections.unmodifiableList((List<?>)this.instructions_);
                this.bitField0_ &= 0xFFFFFFFD;
            }
            binExport$Flowgraph$Vertex.instructions_ = this.instructions_;
        }
        else {
            binExport$Flowgraph$Vertex.instructions_ = this.instructionsBuilder_.build();
        }
        binExport$Flowgraph$Vertex.bitField0_ = n;
        this.onBuilt();
        return binExport$Flowgraph$Vertex;
    }
    
    @Override
    public BinExport$Flowgraph$Vertex$Builder mergeFrom(final Message message) {
        if (message instanceof BinExport$Flowgraph$Vertex) {
            return this.mergeFrom((BinExport$Flowgraph$Vertex)message);
        }
        super.mergeFrom(message);
        return this;
    }
    
    public BinExport$Flowgraph$Vertex$Builder mergeFrom(final BinExport$Flowgraph$Vertex binExport$Flowgraph$Vertex) {
        if (binExport$Flowgraph$Vertex == BinExport$Flowgraph$Vertex.getDefaultInstance()) {
            return this;
        }
        if (binExport$Flowgraph$Vertex.hasPrime()) {
            this.setPrime(binExport$Flowgraph$Vertex.getPrime());
        }
        if (this.instructionsBuilder_ == null) {
            if (!binExport$Flowgraph$Vertex.instructions_.isEmpty()) {
                if (this.instructions_.isEmpty()) {
                    this.instructions_ = binExport$Flowgraph$Vertex.instructions_;
                    this.bitField0_ &= 0xFFFFFFFD;
                }
                else {
                    this.ensureInstructionsIsMutable();
                    this.instructions_.addAll(binExport$Flowgraph$Vertex.instructions_);
                }
                this.onChanged();
            }
        }
        else if (!binExport$Flowgraph$Vertex.instructions_.isEmpty()) {
            if (this.instructionsBuilder_.isEmpty()) {
                this.instructionsBuilder_.dispose();
                this.instructionsBuilder_ = null;
                this.instructions_ = binExport$Flowgraph$Vertex.instructions_;
                this.bitField0_ &= 0xFFFFFFFD;
                this.instructionsBuilder_ = (BinExport$Flowgraph$Vertex.alwaysUseFieldBuilders ? this.getInstructionsFieldBuilder() : null);
            }
            else {
                this.instructionsBuilder_.addAllMessages(binExport$Flowgraph$Vertex.instructions_);
            }
        }
        this.mergeUnknownFields(binExport$Flowgraph$Vertex.unknownFields);
        this.onChanged();
        return this;
    }
    
    @Override
    public final boolean isInitialized() {
        if (!this.hasPrime()) {
            return false;
        }
        for (int i = 0; i < this.getInstructionsCount(); ++i) {
            if (!this.getInstructions(i).isInitialized()) {
                return false;
            }
        }
        return true;
    }
    
    @Override
    public BinExport$Flowgraph$Vertex$Builder mergeFrom(final CodedInputStream codedInputStream, final ExtensionRegistryLite extensionRegistryLite) {
        BinExport$Flowgraph$Vertex binExport$Flowgraph$Vertex = null;
        try {
            binExport$Flowgraph$Vertex = (BinExport$Flowgraph$Vertex)BinExport$Flowgraph$Vertex.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
        }
        catch (InvalidProtocolBufferException ex) {
            binExport$Flowgraph$Vertex = (BinExport$Flowgraph$Vertex)ex.getUnfinishedMessage();
            throw ex;
        }
        finally {
            if (binExport$Flowgraph$Vertex != null) {
                this.mergeFrom(binExport$Flowgraph$Vertex);
            }
        }
        return this;
    }
    
    @Override
    public boolean hasPrime() {
        return (this.bitField0_ & 0x1) == 0x1;
    }
    
    @Override
    public long getPrime() {
        return this.prime_;
    }
    
    public BinExport$Flowgraph$Vertex$Builder setPrime(final long prime_) {
        this.bitField0_ |= 0x1;
        this.prime_ = prime_;
        this.onChanged();
        return this;
    }
    
    public BinExport$Flowgraph$Vertex$Builder clearPrime() {
        this.bitField0_ &= 0xFFFFFFFE;
        this.prime_ = 0L;
        this.onChanged();
        return this;
    }
    
    private void ensureInstructionsIsMutable() {
        if ((this.bitField0_ & 0x2) != 0x2) {
            this.instructions_ = new ArrayList(this.instructions_);
            this.bitField0_ |= 0x2;
        }
    }
    
    @Override
    public List getInstructionsList() {
        if (this.instructionsBuilder_ == null) {
            return Collections.unmodifiableList((List<?>)this.instructions_);
        }
        return this.instructionsBuilder_.getMessageList();
    }
    
    @Override
    public int getInstructionsCount() {
        if (this.instructionsBuilder_ == null) {
            return this.instructions_.size();
        }
        return this.instructionsBuilder_.getCount();
    }
    
    @Override
    public BinExport$Flowgraph$Vertex$Instruction getInstructions(final int n) {
        if (this.instructionsBuilder_ == null) {
            return this.instructions_.get(n);
        }
        return (BinExport$Flowgraph$Vertex$Instruction)this.instructionsBuilder_.getMessage(n);
    }
    
    public BinExport$Flowgraph$Vertex$Builder setInstructions(final int n, final BinExport$Flowgraph$Vertex$Instruction binExport$Flowgraph$Vertex$Instruction) {
        if (this.instructionsBuilder_ == null) {
            if (binExport$Flowgraph$Vertex$Instruction == null) {
                throw new NullPointerException();
            }
            this.ensureInstructionsIsMutable();
            this.instructions_.set(n, binExport$Flowgraph$Vertex$Instruction);
            this.onChanged();
        }
        else {
            this.instructionsBuilder_.setMessage(n, binExport$Flowgraph$Vertex$Instruction);
        }
        return this;
    }
    
    public BinExport$Flowgraph$Vertex$Builder setInstructions(final int n, final BinExport$Flowgraph$Vertex$Instruction$Builder binExport$Flowgraph$Vertex$Instruction$Builder) {
        if (this.instructionsBuilder_ == null) {
            this.ensureInstructionsIsMutable();
            this.instructions_.set(n, binExport$Flowgraph$Vertex$Instruction$Builder.build());
            this.onChanged();
        }
        else {
            this.instructionsBuilder_.setMessage(n, binExport$Flowgraph$Vertex$Instruction$Builder.build());
        }
        return this;
    }
    
    public BinExport$Flowgraph$Vertex$Builder addInstructions(final BinExport$Flowgraph$Vertex$Instruction binExport$Flowgraph$Vertex$Instruction) {
        if (this.instructionsBuilder_ == null) {
            if (binExport$Flowgraph$Vertex$Instruction == null) {
                throw new NullPointerException();
            }
            this.ensureInstructionsIsMutable();
            this.instructions_.add(binExport$Flowgraph$Vertex$Instruction);
            this.onChanged();
        }
        else {
            this.instructionsBuilder_.addMessage(binExport$Flowgraph$Vertex$Instruction);
        }
        return this;
    }
    
    public BinExport$Flowgraph$Vertex$Builder addInstructions(final int n, final BinExport$Flowgraph$Vertex$Instruction binExport$Flowgraph$Vertex$Instruction) {
        if (this.instructionsBuilder_ == null) {
            if (binExport$Flowgraph$Vertex$Instruction == null) {
                throw new NullPointerException();
            }
            this.ensureInstructionsIsMutable();
            this.instructions_.add(n, binExport$Flowgraph$Vertex$Instruction);
            this.onChanged();
        }
        else {
            this.instructionsBuilder_.addMessage(n, binExport$Flowgraph$Vertex$Instruction);
        }
        return this;
    }
    
    public BinExport$Flowgraph$Vertex$Builder addInstructions(final BinExport$Flowgraph$Vertex$Instruction$Builder binExport$Flowgraph$Vertex$Instruction$Builder) {
        if (this.instructionsBuilder_ == null) {
            this.ensureInstructionsIsMutable();
            this.instructions_.add(binExport$Flowgraph$Vertex$Instruction$Builder.build());
            this.onChanged();
        }
        else {
            this.instructionsBuilder_.addMessage(binExport$Flowgraph$Vertex$Instruction$Builder.build());
        }
        return this;
    }
    
    public BinExport$Flowgraph$Vertex$Builder addInstructions(final int n, final BinExport$Flowgraph$Vertex$Instruction$Builder binExport$Flowgraph$Vertex$Instruction$Builder) {
        if (this.instructionsBuilder_ == null) {
            this.ensureInstructionsIsMutable();
            this.instructions_.add(n, binExport$Flowgraph$Vertex$Instruction$Builder.build());
            this.onChanged();
        }
        else {
            this.instructionsBuilder_.addMessage(n, binExport$Flowgraph$Vertex$Instruction$Builder.build());
        }
        return this;
    }
    
    public BinExport$Flowgraph$Vertex$Builder addAllInstructions(final Iterable iterable) {
        if (this.instructionsBuilder_ == null) {
            this.ensureInstructionsIsMutable();
            AbstractMessageLite$Builder.addAll(iterable, this.instructions_);
            this.onChanged();
        }
        else {
            this.instructionsBuilder_.addAllMessages(iterable);
        }
        return this;
    }
    
    public BinExport$Flowgraph$Vertex$Builder clearInstructions() {
        if (this.instructionsBuilder_ == null) {
            this.instructions_ = Collections.emptyList();
            this.bitField0_ &= 0xFFFFFFFD;
            this.onChanged();
        }
        else {
            this.instructionsBuilder_.clear();
        }
        return this;
    }
    
    public BinExport$Flowgraph$Vertex$Builder removeInstructions(final int n) {
        if (this.instructionsBuilder_ == null) {
            this.ensureInstructionsIsMutable();
            this.instructions_.remove(n);
            this.onChanged();
        }
        else {
            this.instructionsBuilder_.remove(n);
        }
        return this;
    }
    
    public BinExport$Flowgraph$Vertex$Instruction$Builder getInstructionsBuilder(final int n) {
        return (BinExport$Flowgraph$Vertex$Instruction$Builder)this.getInstructionsFieldBuilder().getBuilder(n);
    }
    
    @Override
    public BinExport$Flowgraph$Vertex$InstructionOrBuilder getInstructionsOrBuilder(final int n) {
        if (this.instructionsBuilder_ == null) {
            return this.instructions_.get(n);
        }
        return (BinExport$Flowgraph$Vertex$InstructionOrBuilder)this.instructionsBuilder_.getMessageOrBuilder(n);
    }
    
    @Override
    public List getInstructionsOrBuilderList() {
        if (this.instructionsBuilder_ != null) {
            return this.instructionsBuilder_.getMessageOrBuilderList();
        }
        return Collections.unmodifiableList((List<?>)this.instructions_);
    }
    
    public BinExport$Flowgraph$Vertex$Instruction$Builder addInstructionsBuilder() {
        return (BinExport$Flowgraph$Vertex$Instruction$Builder)this.getInstructionsFieldBuilder().addBuilder(BinExport$Flowgraph$Vertex$Instruction.getDefaultInstance());
    }
    
    public BinExport$Flowgraph$Vertex$Instruction$Builder addInstructionsBuilder(final int n) {
        return (BinExport$Flowgraph$Vertex$Instruction$Builder)this.getInstructionsFieldBuilder().addBuilder(n, BinExport$Flowgraph$Vertex$Instruction.getDefaultInstance());
    }
    
    public List getInstructionsBuilderList() {
        return this.getInstructionsFieldBuilder().getBuilderList();
    }
    
    private RepeatedFieldBuilder getInstructionsFieldBuilder() {
        if (this.instructionsBuilder_ == null) {
            this.instructionsBuilder_ = new RepeatedFieldBuilder(this.instructions_, (this.bitField0_ & 0x2) == 0x2, this.getParentForChildren(), this.isClean());
            this.instructions_ = null;
        }
        return this.instructionsBuilder_;
    }
}
