package com.google.protos.BinExport;

import com.google.protobuf.*;
import java.io.*;

public final class BinExport$Callgraph$Edge$Builder extends GeneratedMessage$Builder implements BinExport$Callgraph$EdgeOrBuilder
{
    private int bitField0_;
    private long sourceFunctionAddress_;
    private long sourceInstructionAddress_;
    private long targetAddress_;
    
    public static final Descriptors$Descriptor getDescriptor() {
        return BinExport.internal_static_BinExport_Callgraph_Edge_descriptor;
    }
    
    @Override
    protected GeneratedMessage$FieldAccessorTable internalGetFieldAccessorTable() {
        return BinExport.internal_static_BinExport_Callgraph_Edge_fieldAccessorTable.ensureFieldAccessorsInitialized(BinExport$Callgraph$Edge.class, BinExport$Callgraph$Edge$Builder.class);
    }
    
    private BinExport$Callgraph$Edge$Builder() {
        this.maybeForceBuilderInitialization();
    }
    
    private BinExport$Callgraph$Edge$Builder(final GeneratedMessage$BuilderParent generatedMessage$BuilderParent) {
        super(generatedMessage$BuilderParent);
        this.maybeForceBuilderInitialization();
    }
    
    private void maybeForceBuilderInitialization() {
        if (BinExport$Callgraph$Edge.alwaysUseFieldBuilders) {}
    }
    
    @Override
    public BinExport$Callgraph$Edge$Builder clear() {
        super.clear();
        this.sourceFunctionAddress_ = 0L;
        this.bitField0_ &= 0xFFFFFFFE;
        this.sourceInstructionAddress_ = 0L;
        this.bitField0_ &= 0xFFFFFFFD;
        this.targetAddress_ = 0L;
        this.bitField0_ &= 0xFFFFFFFB;
        return this;
    }
    
    @Override
    public Descriptors$Descriptor getDescriptorForType() {
        return BinExport.internal_static_BinExport_Callgraph_Edge_descriptor;
    }
    
    @Override
    public BinExport$Callgraph$Edge getDefaultInstanceForType() {
        return BinExport$Callgraph$Edge.getDefaultInstance();
    }
    
    @Override
    public BinExport$Callgraph$Edge build() {
        final BinExport$Callgraph$Edge buildPartial = this.buildPartial();
        if (!buildPartial.isInitialized()) {
            throw AbstractMessage$Builder.newUninitializedMessageException(buildPartial);
        }
        return buildPartial;
    }
    
    @Override
    public BinExport$Callgraph$Edge buildPartial() {
        final BinExport$Callgraph$Edge binExport$Callgraph$Edge = new BinExport$Callgraph$Edge(this, null);
        final int bitField0_ = this.bitField0_;
        int n = 0;
        if ((bitField0_ & 0x1) == 0x1) {
            n |= 0x1;
        }
        binExport$Callgraph$Edge.sourceFunctionAddress_ = this.sourceFunctionAddress_;
        if ((bitField0_ & 0x2) == 0x2) {
            n |= 0x2;
        }
        binExport$Callgraph$Edge.sourceInstructionAddress_ = this.sourceInstructionAddress_;
        if ((bitField0_ & 0x4) == 0x4) {
            n |= 0x4;
        }
        binExport$Callgraph$Edge.targetAddress_ = this.targetAddress_;
        binExport$Callgraph$Edge.bitField0_ = n;
        this.onBuilt();
        return binExport$Callgraph$Edge;
    }
    
    @Override
    public BinExport$Callgraph$Edge$Builder mergeFrom(final Message message) {
        if (message instanceof BinExport$Callgraph$Edge) {
            return this.mergeFrom((BinExport$Callgraph$Edge)message);
        }
        super.mergeFrom(message);
        return this;
    }
    
    public BinExport$Callgraph$Edge$Builder mergeFrom(final BinExport$Callgraph$Edge binExport$Callgraph$Edge) {
        if (binExport$Callgraph$Edge == BinExport$Callgraph$Edge.getDefaultInstance()) {
            return this;
        }
        if (binExport$Callgraph$Edge.hasSourceFunctionAddress()) {
            this.setSourceFunctionAddress(binExport$Callgraph$Edge.getSourceFunctionAddress());
        }
        if (binExport$Callgraph$Edge.hasSourceInstructionAddress()) {
            this.setSourceInstructionAddress(binExport$Callgraph$Edge.getSourceInstructionAddress());
        }
        if (binExport$Callgraph$Edge.hasTargetAddress()) {
            this.setTargetAddress(binExport$Callgraph$Edge.getTargetAddress());
        }
        this.mergeUnknownFields(binExport$Callgraph$Edge.unknownFields);
        this.onChanged();
        return this;
    }
    
    @Override
    public final boolean isInitialized() {
        return this.hasSourceFunctionAddress() && this.hasSourceInstructionAddress() && this.hasTargetAddress();
    }
    
    @Override
    public BinExport$Callgraph$Edge$Builder mergeFrom(final CodedInputStream codedInputStream, final ExtensionRegistryLite extensionRegistryLite) {
        BinExport$Callgraph$Edge binExport$Callgraph$Edge = null;
        try {
            binExport$Callgraph$Edge = (BinExport$Callgraph$Edge)BinExport$Callgraph$Edge.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
        }
        catch (InvalidProtocolBufferException ex) {
            binExport$Callgraph$Edge = (BinExport$Callgraph$Edge)ex.getUnfinishedMessage();
            throw ex;
        }
        finally {
            if (binExport$Callgraph$Edge != null) {
                this.mergeFrom(binExport$Callgraph$Edge);
            }
        }
        return this;
    }
    
    @Override
    public boolean hasSourceFunctionAddress() {
        return (this.bitField0_ & 0x1) == 0x1;
    }
    
    @Override
    public long getSourceFunctionAddress() {
        return this.sourceFunctionAddress_;
    }
    
    public BinExport$Callgraph$Edge$Builder setSourceFunctionAddress(final long sourceFunctionAddress_) {
        this.bitField0_ |= 0x1;
        this.sourceFunctionAddress_ = sourceFunctionAddress_;
        this.onChanged();
        return this;
    }
    
    public BinExport$Callgraph$Edge$Builder clearSourceFunctionAddress() {
        this.bitField0_ &= 0xFFFFFFFE;
        this.sourceFunctionAddress_ = 0L;
        this.onChanged();
        return this;
    }
    
    @Override
    public boolean hasSourceInstructionAddress() {
        return (this.bitField0_ & 0x2) == 0x2;
    }
    
    @Override
    public long getSourceInstructionAddress() {
        return this.sourceInstructionAddress_;
    }
    
    public BinExport$Callgraph$Edge$Builder setSourceInstructionAddress(final long sourceInstructionAddress_) {
        this.bitField0_ |= 0x2;
        this.sourceInstructionAddress_ = sourceInstructionAddress_;
        this.onChanged();
        return this;
    }
    
    public BinExport$Callgraph$Edge$Builder clearSourceInstructionAddress() {
        this.bitField0_ &= 0xFFFFFFFD;
        this.sourceInstructionAddress_ = 0L;
        this.onChanged();
        return this;
    }
    
    @Override
    public boolean hasTargetAddress() {
        return (this.bitField0_ & 0x4) == 0x4;
    }
    
    @Override
    public long getTargetAddress() {
        return this.targetAddress_;
    }
    
    public BinExport$Callgraph$Edge$Builder setTargetAddress(final long targetAddress_) {
        this.bitField0_ |= 0x4;
        this.targetAddress_ = targetAddress_;
        this.onChanged();
        return this;
    }
    
    public BinExport$Callgraph$Edge$Builder clearTargetAddress() {
        this.bitField0_ &= 0xFFFFFFFB;
        this.targetAddress_ = 0L;
        this.onChanged();
        return this;
    }
}
