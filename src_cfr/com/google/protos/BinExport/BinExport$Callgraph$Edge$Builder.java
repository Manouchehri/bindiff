/*
 * Decompiled with CFR 0_115.
 */
package com.google.protos.BinExport;

import com.google.protobuf.AbstractMessage$Builder;
import com.google.protobuf.AbstractMessageLite$Builder;
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
import com.google.protos.BinExport.BinExport$Callgraph$Edge;
import com.google.protos.BinExport.BinExport$Callgraph$EdgeOrBuilder;

public final class BinExport$Callgraph$Edge$Builder
extends GeneratedMessage$Builder
implements BinExport$Callgraph$EdgeOrBuilder {
    private int bitField0_;
    private long sourceFunctionAddress_;
    private long sourceInstructionAddress_;
    private long targetAddress_;

    public static final Descriptors$Descriptor getDescriptor() {
        return BinExport.access$3500();
    }

    @Override
    protected GeneratedMessage$FieldAccessorTable internalGetFieldAccessorTable() {
        return BinExport.access$3600().ensureFieldAccessorsInitialized(BinExport$Callgraph$Edge.class, BinExport$Callgraph$Edge$Builder.class);
    }

    private BinExport$Callgraph$Edge$Builder() {
        this.maybeForceBuilderInitialization();
    }

    private BinExport$Callgraph$Edge$Builder(GeneratedMessage$BuilderParent generatedMessage$BuilderParent) {
        super(generatedMessage$BuilderParent);
        this.maybeForceBuilderInitialization();
    }

    private void maybeForceBuilderInitialization() {
        if (!BinExport$Callgraph$Edge.access$3900()) return;
    }

    @Override
    public BinExport$Callgraph$Edge$Builder clear() {
        super.clear();
        this.sourceFunctionAddress_ = 0;
        this.bitField0_ &= -2;
        this.sourceInstructionAddress_ = 0;
        this.bitField0_ &= -3;
        this.targetAddress_ = 0;
        this.bitField0_ &= -5;
        return this;
    }

    @Override
    public Descriptors$Descriptor getDescriptorForType() {
        return BinExport.access$3500();
    }

    @Override
    public BinExport$Callgraph$Edge getDefaultInstanceForType() {
        return BinExport$Callgraph$Edge.getDefaultInstance();
    }

    @Override
    public BinExport$Callgraph$Edge build() {
        BinExport$Callgraph$Edge binExport$Callgraph$Edge = this.buildPartial();
        if (binExport$Callgraph$Edge.isInitialized()) return binExport$Callgraph$Edge;
        throw BinExport$Callgraph$Edge$Builder.newUninitializedMessageException(binExport$Callgraph$Edge);
    }

    @Override
    public BinExport$Callgraph$Edge buildPartial() {
        BinExport$Callgraph$Edge binExport$Callgraph$Edge = new BinExport$Callgraph$Edge(this, null);
        int n2 = this.bitField0_;
        int n3 = 0;
        if ((n2 & 1) == 1) {
            n3 |= true;
        }
        BinExport$Callgraph$Edge.access$4102(binExport$Callgraph$Edge, this.sourceFunctionAddress_);
        if ((n2 & 2) == 2) {
            n3 |= 2;
        }
        BinExport$Callgraph$Edge.access$4202(binExport$Callgraph$Edge, this.sourceInstructionAddress_);
        if ((n2 & 4) == 4) {
            n3 |= 4;
        }
        BinExport$Callgraph$Edge.access$4302(binExport$Callgraph$Edge, this.targetAddress_);
        BinExport$Callgraph$Edge.access$4402(binExport$Callgraph$Edge, n3);
        this.onBuilt();
        return binExport$Callgraph$Edge;
    }

    @Override
    public BinExport$Callgraph$Edge$Builder mergeFrom(Message message) {
        if (message instanceof BinExport$Callgraph$Edge) {
            return this.mergeFrom((BinExport$Callgraph$Edge)message);
        }
        super.mergeFrom(message);
        return this;
    }

    public BinExport$Callgraph$Edge$Builder mergeFrom(BinExport$Callgraph$Edge binExport$Callgraph$Edge) {
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
        this.mergeUnknownFields(BinExport$Callgraph$Edge.access$4500(binExport$Callgraph$Edge));
        this.onChanged();
        return this;
    }

    @Override
    public final boolean isInitialized() {
        if (!this.hasSourceFunctionAddress()) {
            return false;
        }
        if (!this.hasSourceInstructionAddress()) {
            return false;
        }
        if (this.hasTargetAddress()) return true;
        return false;
    }

    @Override
    public BinExport$Callgraph$Edge$Builder mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        BinExport$Callgraph$Edge binExport$Callgraph$Edge = null;
        try {
            binExport$Callgraph$Edge = (BinExport$Callgraph$Edge)BinExport$Callgraph$Edge.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
            return this;
        }
        catch (InvalidProtocolBufferException var4_4) {
            binExport$Callgraph$Edge = (BinExport$Callgraph$Edge)var4_4.getUnfinishedMessage();
            throw var4_4;
        }
        finally {
            if (binExport$Callgraph$Edge != null) {
                this.mergeFrom(binExport$Callgraph$Edge);
            }
        }
    }

    @Override
    public boolean hasSourceFunctionAddress() {
        if ((this.bitField0_ & 1) != 1) return false;
        return true;
    }

    @Override
    public long getSourceFunctionAddress() {
        return this.sourceFunctionAddress_;
    }

    public BinExport$Callgraph$Edge$Builder setSourceFunctionAddress(long l2) {
        this.bitField0_ |= 1;
        this.sourceFunctionAddress_ = l2;
        this.onChanged();
        return this;
    }

    public BinExport$Callgraph$Edge$Builder clearSourceFunctionAddress() {
        this.bitField0_ &= -2;
        this.sourceFunctionAddress_ = 0;
        this.onChanged();
        return this;
    }

    @Override
    public boolean hasSourceInstructionAddress() {
        if ((this.bitField0_ & 2) != 2) return false;
        return true;
    }

    @Override
    public long getSourceInstructionAddress() {
        return this.sourceInstructionAddress_;
    }

    public BinExport$Callgraph$Edge$Builder setSourceInstructionAddress(long l2) {
        this.bitField0_ |= 2;
        this.sourceInstructionAddress_ = l2;
        this.onChanged();
        return this;
    }

    public BinExport$Callgraph$Edge$Builder clearSourceInstructionAddress() {
        this.bitField0_ &= -3;
        this.sourceInstructionAddress_ = 0;
        this.onChanged();
        return this;
    }

    @Override
    public boolean hasTargetAddress() {
        if ((this.bitField0_ & 4) != 4) return false;
        return true;
    }

    @Override
    public long getTargetAddress() {
        return this.targetAddress_;
    }

    public BinExport$Callgraph$Edge$Builder setTargetAddress(long l2) {
        this.bitField0_ |= 4;
        this.targetAddress_ = l2;
        this.onChanged();
        return this;
    }

    public BinExport$Callgraph$Edge$Builder clearTargetAddress() {
        this.bitField0_ &= -5;
        this.targetAddress_ = 0;
        this.onChanged();
        return this;
    }

    /* synthetic */ BinExport$Callgraph$Edge$Builder(BinExport$1 binExport$1) {
        this();
    }

    /* synthetic */ BinExport$Callgraph$Edge$Builder(GeneratedMessage$BuilderParent generatedMessage$BuilderParent, BinExport$1 binExport$1) {
        this(generatedMessage$BuilderParent);
    }
}

