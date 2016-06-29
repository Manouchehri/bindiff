package com.google.protos.BinExport;

import com.google.protobuf.*;
import java.io.*;

public final class BinExport$Flowgraph$Edge$Builder extends GeneratedMessage$Builder implements BinExport$Flowgraph$EdgeOrBuilder
{
    private int bitField0_;
    private long sourceAddress_;
    private long targetAddress_;
    private int type_;
    
    public static final Descriptors$Descriptor getDescriptor() {
        return BinExport.internal_static_BinExport_Flowgraph_Edge_descriptor;
    }
    
    @Override
    protected GeneratedMessage$FieldAccessorTable internalGetFieldAccessorTable() {
        return BinExport.internal_static_BinExport_Flowgraph_Edge_fieldAccessorTable.ensureFieldAccessorsInitialized(BinExport$Flowgraph$Edge.class, BinExport$Flowgraph$Edge$Builder.class);
    }
    
    private BinExport$Flowgraph$Edge$Builder() {
        this.type_ = 3;
        this.maybeForceBuilderInitialization();
    }
    
    private BinExport$Flowgraph$Edge$Builder(final GeneratedMessage$BuilderParent generatedMessage$BuilderParent) {
        super(generatedMessage$BuilderParent);
        this.type_ = 3;
        this.maybeForceBuilderInitialization();
    }
    
    private void maybeForceBuilderInitialization() {
        if (BinExport$Flowgraph$Edge.alwaysUseFieldBuilders) {}
    }
    
    @Override
    public BinExport$Flowgraph$Edge$Builder clear() {
        super.clear();
        this.sourceAddress_ = 0L;
        this.bitField0_ &= 0xFFFFFFFE;
        this.targetAddress_ = 0L;
        this.bitField0_ &= 0xFFFFFFFD;
        this.type_ = 3;
        this.bitField0_ &= 0xFFFFFFFB;
        return this;
    }
    
    @Override
    public Descriptors$Descriptor getDescriptorForType() {
        return BinExport.internal_static_BinExport_Flowgraph_Edge_descriptor;
    }
    
    @Override
    public BinExport$Flowgraph$Edge getDefaultInstanceForType() {
        return BinExport$Flowgraph$Edge.getDefaultInstance();
    }
    
    @Override
    public BinExport$Flowgraph$Edge build() {
        final BinExport$Flowgraph$Edge buildPartial = this.buildPartial();
        if (!buildPartial.isInitialized()) {
            throw AbstractMessage$Builder.newUninitializedMessageException(buildPartial);
        }
        return buildPartial;
    }
    
    @Override
    public BinExport$Flowgraph$Edge buildPartial() {
        final BinExport$Flowgraph$Edge binExport$Flowgraph$Edge = new BinExport$Flowgraph$Edge(this, null);
        final int bitField0_ = this.bitField0_;
        int n = 0;
        if ((bitField0_ & 0x1) == 0x1) {
            n |= 0x1;
        }
        binExport$Flowgraph$Edge.sourceAddress_ = this.sourceAddress_;
        if ((bitField0_ & 0x2) == 0x2) {
            n |= 0x2;
        }
        binExport$Flowgraph$Edge.targetAddress_ = this.targetAddress_;
        if ((bitField0_ & 0x4) == 0x4) {
            n |= 0x4;
        }
        binExport$Flowgraph$Edge.type_ = this.type_;
        binExport$Flowgraph$Edge.bitField0_ = n;
        this.onBuilt();
        return binExport$Flowgraph$Edge;
    }
    
    @Override
    public BinExport$Flowgraph$Edge$Builder mergeFrom(final Message message) {
        if (message instanceof BinExport$Flowgraph$Edge) {
            return this.mergeFrom((BinExport$Flowgraph$Edge)message);
        }
        super.mergeFrom(message);
        return this;
    }
    
    public BinExport$Flowgraph$Edge$Builder mergeFrom(final BinExport$Flowgraph$Edge binExport$Flowgraph$Edge) {
        if (binExport$Flowgraph$Edge == BinExport$Flowgraph$Edge.getDefaultInstance()) {
            return this;
        }
        if (binExport$Flowgraph$Edge.hasSourceAddress()) {
            this.setSourceAddress(binExport$Flowgraph$Edge.getSourceAddress());
        }
        if (binExport$Flowgraph$Edge.hasTargetAddress()) {
            this.setTargetAddress(binExport$Flowgraph$Edge.getTargetAddress());
        }
        if (binExport$Flowgraph$Edge.hasType()) {
            this.setType(binExport$Flowgraph$Edge.getType());
        }
        this.mergeUnknownFields(binExport$Flowgraph$Edge.unknownFields);
        this.onChanged();
        return this;
    }
    
    @Override
    public final boolean isInitialized() {
        return this.hasSourceAddress() && this.hasTargetAddress();
    }
    
    @Override
    public BinExport$Flowgraph$Edge$Builder mergeFrom(final CodedInputStream codedInputStream, final ExtensionRegistryLite extensionRegistryLite) {
        BinExport$Flowgraph$Edge binExport$Flowgraph$Edge = null;
        try {
            binExport$Flowgraph$Edge = (BinExport$Flowgraph$Edge)BinExport$Flowgraph$Edge.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
        }
        catch (InvalidProtocolBufferException ex) {
            binExport$Flowgraph$Edge = (BinExport$Flowgraph$Edge)ex.getUnfinishedMessage();
            throw ex;
        }
        finally {
            if (binExport$Flowgraph$Edge != null) {
                this.mergeFrom(binExport$Flowgraph$Edge);
            }
        }
        return this;
    }
    
    @Override
    public boolean hasSourceAddress() {
        return (this.bitField0_ & 0x1) == 0x1;
    }
    
    @Override
    public long getSourceAddress() {
        return this.sourceAddress_;
    }
    
    public BinExport$Flowgraph$Edge$Builder setSourceAddress(final long sourceAddress_) {
        this.bitField0_ |= 0x1;
        this.sourceAddress_ = sourceAddress_;
        this.onChanged();
        return this;
    }
    
    public BinExport$Flowgraph$Edge$Builder clearSourceAddress() {
        this.bitField0_ &= 0xFFFFFFFE;
        this.sourceAddress_ = 0L;
        this.onChanged();
        return this;
    }
    
    @Override
    public boolean hasTargetAddress() {
        return (this.bitField0_ & 0x2) == 0x2;
    }
    
    @Override
    public long getTargetAddress() {
        return this.targetAddress_;
    }
    
    public BinExport$Flowgraph$Edge$Builder setTargetAddress(final long targetAddress_) {
        this.bitField0_ |= 0x2;
        this.targetAddress_ = targetAddress_;
        this.onChanged();
        return this;
    }
    
    public BinExport$Flowgraph$Edge$Builder clearTargetAddress() {
        this.bitField0_ &= 0xFFFFFFFD;
        this.targetAddress_ = 0L;
        this.onChanged();
        return this;
    }
    
    @Override
    public boolean hasType() {
        return (this.bitField0_ & 0x4) == 0x4;
    }
    
    @Override
    public BinExport$Flowgraph$Edge$EdgeType getType() {
        final BinExport$Flowgraph$Edge$EdgeType value = BinExport$Flowgraph$Edge$EdgeType.valueOf(this.type_);
        return (value == null) ? BinExport$Flowgraph$Edge$EdgeType.UNCONDITIONAL : value;
    }
    
    public BinExport$Flowgraph$Edge$Builder setType(final BinExport$Flowgraph$Edge$EdgeType binExport$Flowgraph$Edge$EdgeType) {
        if (binExport$Flowgraph$Edge$EdgeType == null) {
            throw new NullPointerException();
        }
        this.bitField0_ |= 0x4;
        this.type_ = binExport$Flowgraph$Edge$EdgeType.getNumber();
        this.onChanged();
        return this;
    }
    
    public BinExport$Flowgraph$Edge$Builder clearType() {
        this.bitField0_ &= 0xFFFFFFFB;
        this.type_ = 3;
        this.onChanged();
        return this;
    }
}
