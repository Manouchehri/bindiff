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
import com.google.protos.BinExport.BinExport$Flowgraph$Edge;
import com.google.protos.BinExport.BinExport$Flowgraph$Edge$EdgeType;
import com.google.protos.BinExport.BinExport$Flowgraph$EdgeOrBuilder;

public final class BinExport$Flowgraph$Edge$Builder
extends GeneratedMessage$Builder
implements BinExport$Flowgraph$EdgeOrBuilder {
    private int bitField0_;
    private long sourceAddress_;
    private long targetAddress_;
    private int type_ = 3;

    public static final Descriptors$Descriptor getDescriptor() {
        return BinExport.access$10000();
    }

    @Override
    protected GeneratedMessage$FieldAccessorTable internalGetFieldAccessorTable() {
        return BinExport.access$10100().ensureFieldAccessorsInitialized(BinExport$Flowgraph$Edge.class, BinExport$Flowgraph$Edge$Builder.class);
    }

    private BinExport$Flowgraph$Edge$Builder() {
        this.maybeForceBuilderInitialization();
    }

    private BinExport$Flowgraph$Edge$Builder(GeneratedMessage$BuilderParent generatedMessage$BuilderParent) {
        super(generatedMessage$BuilderParent);
        this.maybeForceBuilderInitialization();
    }

    private void maybeForceBuilderInitialization() {
        if (!BinExport$Flowgraph$Edge.access$10400()) return;
    }

    @Override
    public BinExport$Flowgraph$Edge$Builder clear() {
        super.clear();
        this.sourceAddress_ = 0;
        this.bitField0_ &= -2;
        this.targetAddress_ = 0;
        this.bitField0_ &= -3;
        this.type_ = 3;
        this.bitField0_ &= -5;
        return this;
    }

    @Override
    public Descriptors$Descriptor getDescriptorForType() {
        return BinExport.access$10000();
    }

    @Override
    public BinExport$Flowgraph$Edge getDefaultInstanceForType() {
        return BinExport$Flowgraph$Edge.getDefaultInstance();
    }

    @Override
    public BinExport$Flowgraph$Edge build() {
        BinExport$Flowgraph$Edge binExport$Flowgraph$Edge = this.buildPartial();
        if (binExport$Flowgraph$Edge.isInitialized()) return binExport$Flowgraph$Edge;
        throw BinExport$Flowgraph$Edge$Builder.newUninitializedMessageException(binExport$Flowgraph$Edge);
    }

    @Override
    public BinExport$Flowgraph$Edge buildPartial() {
        BinExport$Flowgraph$Edge binExport$Flowgraph$Edge = new BinExport$Flowgraph$Edge(this, null);
        int n2 = this.bitField0_;
        int n3 = 0;
        if ((n2 & 1) == 1) {
            n3 |= true;
        }
        BinExport$Flowgraph$Edge.access$10602(binExport$Flowgraph$Edge, this.sourceAddress_);
        if ((n2 & 2) == 2) {
            n3 |= 2;
        }
        BinExport$Flowgraph$Edge.access$10702(binExport$Flowgraph$Edge, this.targetAddress_);
        if ((n2 & 4) == 4) {
            n3 |= 4;
        }
        BinExport$Flowgraph$Edge.access$10802(binExport$Flowgraph$Edge, this.type_);
        BinExport$Flowgraph$Edge.access$10902(binExport$Flowgraph$Edge, n3);
        this.onBuilt();
        return binExport$Flowgraph$Edge;
    }

    @Override
    public BinExport$Flowgraph$Edge$Builder mergeFrom(Message message) {
        if (message instanceof BinExport$Flowgraph$Edge) {
            return this.mergeFrom((BinExport$Flowgraph$Edge)message);
        }
        super.mergeFrom(message);
        return this;
    }

    public BinExport$Flowgraph$Edge$Builder mergeFrom(BinExport$Flowgraph$Edge binExport$Flowgraph$Edge) {
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
        this.mergeUnknownFields(BinExport$Flowgraph$Edge.access$11000(binExport$Flowgraph$Edge));
        this.onChanged();
        return this;
    }

    @Override
    public final boolean isInitialized() {
        if (!this.hasSourceAddress()) {
            return false;
        }
        if (this.hasTargetAddress()) return true;
        return false;
    }

    @Override
    public BinExport$Flowgraph$Edge$Builder mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        BinExport$Flowgraph$Edge binExport$Flowgraph$Edge = null;
        try {
            binExport$Flowgraph$Edge = (BinExport$Flowgraph$Edge)BinExport$Flowgraph$Edge.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
            return this;
        }
        catch (InvalidProtocolBufferException var4_4) {
            binExport$Flowgraph$Edge = (BinExport$Flowgraph$Edge)var4_4.getUnfinishedMessage();
            throw var4_4;
        }
        finally {
            if (binExport$Flowgraph$Edge != null) {
                this.mergeFrom(binExport$Flowgraph$Edge);
            }
        }
    }

    @Override
    public boolean hasSourceAddress() {
        if ((this.bitField0_ & 1) != 1) return false;
        return true;
    }

    @Override
    public long getSourceAddress() {
        return this.sourceAddress_;
    }

    public BinExport$Flowgraph$Edge$Builder setSourceAddress(long l2) {
        this.bitField0_ |= 1;
        this.sourceAddress_ = l2;
        this.onChanged();
        return this;
    }

    public BinExport$Flowgraph$Edge$Builder clearSourceAddress() {
        this.bitField0_ &= -2;
        this.sourceAddress_ = 0;
        this.onChanged();
        return this;
    }

    @Override
    public boolean hasTargetAddress() {
        if ((this.bitField0_ & 2) != 2) return false;
        return true;
    }

    @Override
    public long getTargetAddress() {
        return this.targetAddress_;
    }

    public BinExport$Flowgraph$Edge$Builder setTargetAddress(long l2) {
        this.bitField0_ |= 2;
        this.targetAddress_ = l2;
        this.onChanged();
        return this;
    }

    public BinExport$Flowgraph$Edge$Builder clearTargetAddress() {
        this.bitField0_ &= -3;
        this.targetAddress_ = 0;
        this.onChanged();
        return this;
    }

    @Override
    public boolean hasType() {
        if ((this.bitField0_ & 4) != 4) return false;
        return true;
    }

    @Override
    public BinExport$Flowgraph$Edge$EdgeType getType() {
        BinExport$Flowgraph$Edge$EdgeType binExport$Flowgraph$Edge$EdgeType;
        BinExport$Flowgraph$Edge$EdgeType binExport$Flowgraph$Edge$EdgeType2 = BinExport$Flowgraph$Edge$EdgeType.valueOf(this.type_);
        if (binExport$Flowgraph$Edge$EdgeType2 == null) {
            binExport$Flowgraph$Edge$EdgeType = BinExport$Flowgraph$Edge$EdgeType.UNCONDITIONAL;
            return binExport$Flowgraph$Edge$EdgeType;
        }
        binExport$Flowgraph$Edge$EdgeType = binExport$Flowgraph$Edge$EdgeType2;
        return binExport$Flowgraph$Edge$EdgeType;
    }

    public BinExport$Flowgraph$Edge$Builder setType(BinExport$Flowgraph$Edge$EdgeType binExport$Flowgraph$Edge$EdgeType) {
        if (binExport$Flowgraph$Edge$EdgeType == null) {
            throw new NullPointerException();
        }
        this.bitField0_ |= 4;
        this.type_ = binExport$Flowgraph$Edge$EdgeType.getNumber();
        this.onChanged();
        return this;
    }

    public BinExport$Flowgraph$Edge$Builder clearType() {
        this.bitField0_ &= -5;
        this.type_ = 3;
        this.onChanged();
        return this;
    }

    /* synthetic */ BinExport$Flowgraph$Edge$Builder(BinExport$1 binExport$1) {
        this();
    }

    /* synthetic */ BinExport$Flowgraph$Edge$Builder(GeneratedMessage$BuilderParent generatedMessage$BuilderParent, BinExport$1 binExport$1) {
        this(generatedMessage$BuilderParent);
    }
}

