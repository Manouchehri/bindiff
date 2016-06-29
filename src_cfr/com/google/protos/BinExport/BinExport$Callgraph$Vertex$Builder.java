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
import com.google.protos.BinExport.BinExport$Callgraph$Vertex;
import com.google.protos.BinExport.BinExport$Callgraph$Vertex$FunctionType;
import com.google.protos.BinExport.BinExport$Callgraph$VertexOrBuilder;

public final class BinExport$Callgraph$Vertex$Builder
extends GeneratedMessage$Builder
implements BinExport$Callgraph$VertexOrBuilder {
    private int bitField0_;
    private long address_;
    private long prime_;
    private int functionType_ = 0;
    private boolean hasRealName_;
    private Object mangledName_ = "";
    private Object demangledName_ = "";

    public static final Descriptors$Descriptor getDescriptor() {
        return BinExport.access$2000();
    }

    @Override
    protected GeneratedMessage$FieldAccessorTable internalGetFieldAccessorTable() {
        return BinExport.access$2100().ensureFieldAccessorsInitialized(BinExport$Callgraph$Vertex.class, BinExport$Callgraph$Vertex$Builder.class);
    }

    private BinExport$Callgraph$Vertex$Builder() {
        this.maybeForceBuilderInitialization();
    }

    private BinExport$Callgraph$Vertex$Builder(GeneratedMessage$BuilderParent generatedMessage$BuilderParent) {
        super(generatedMessage$BuilderParent);
        this.maybeForceBuilderInitialization();
    }

    private void maybeForceBuilderInitialization() {
        if (!BinExport$Callgraph$Vertex.access$2400()) return;
    }

    @Override
    public BinExport$Callgraph$Vertex$Builder clear() {
        super.clear();
        this.address_ = 0;
        this.bitField0_ &= -2;
        this.prime_ = 0;
        this.bitField0_ &= -3;
        this.functionType_ = 0;
        this.bitField0_ &= -5;
        this.hasRealName_ = false;
        this.bitField0_ &= -9;
        this.mangledName_ = "";
        this.bitField0_ &= -17;
        this.demangledName_ = "";
        this.bitField0_ &= -33;
        return this;
    }

    @Override
    public Descriptors$Descriptor getDescriptorForType() {
        return BinExport.access$2000();
    }

    @Override
    public BinExport$Callgraph$Vertex getDefaultInstanceForType() {
        return BinExport$Callgraph$Vertex.getDefaultInstance();
    }

    @Override
    public BinExport$Callgraph$Vertex build() {
        BinExport$Callgraph$Vertex binExport$Callgraph$Vertex = this.buildPartial();
        if (binExport$Callgraph$Vertex.isInitialized()) return binExport$Callgraph$Vertex;
        throw BinExport$Callgraph$Vertex$Builder.newUninitializedMessageException(binExport$Callgraph$Vertex);
    }

    @Override
    public BinExport$Callgraph$Vertex buildPartial() {
        BinExport$Callgraph$Vertex binExport$Callgraph$Vertex = new BinExport$Callgraph$Vertex(this, null);
        int n2 = this.bitField0_;
        int n3 = 0;
        if ((n2 & 1) == 1) {
            n3 |= true;
        }
        BinExport$Callgraph$Vertex.access$2602(binExport$Callgraph$Vertex, this.address_);
        if ((n2 & 2) == 2) {
            n3 |= 2;
        }
        BinExport$Callgraph$Vertex.access$2702(binExport$Callgraph$Vertex, this.prime_);
        if ((n2 & 4) == 4) {
            n3 |= 4;
        }
        BinExport$Callgraph$Vertex.access$2802(binExport$Callgraph$Vertex, this.functionType_);
        if ((n2 & 8) == 8) {
            n3 |= 8;
        }
        BinExport$Callgraph$Vertex.access$2902(binExport$Callgraph$Vertex, this.hasRealName_);
        if ((n2 & 16) == 16) {
            n3 |= 16;
        }
        BinExport$Callgraph$Vertex.access$3002(binExport$Callgraph$Vertex, this.mangledName_);
        if ((n2 & 32) == 32) {
            n3 |= 32;
        }
        BinExport$Callgraph$Vertex.access$3102(binExport$Callgraph$Vertex, this.demangledName_);
        BinExport$Callgraph$Vertex.access$3202(binExport$Callgraph$Vertex, n3);
        this.onBuilt();
        return binExport$Callgraph$Vertex;
    }

    @Override
    public BinExport$Callgraph$Vertex$Builder mergeFrom(Message message) {
        if (message instanceof BinExport$Callgraph$Vertex) {
            return this.mergeFrom((BinExport$Callgraph$Vertex)message);
        }
        super.mergeFrom(message);
        return this;
    }

    public BinExport$Callgraph$Vertex$Builder mergeFrom(BinExport$Callgraph$Vertex binExport$Callgraph$Vertex) {
        if (binExport$Callgraph$Vertex == BinExport$Callgraph$Vertex.getDefaultInstance()) {
            return this;
        }
        if (binExport$Callgraph$Vertex.hasAddress()) {
            this.setAddress(binExport$Callgraph$Vertex.getAddress());
        }
        if (binExport$Callgraph$Vertex.hasPrime()) {
            this.setPrime(binExport$Callgraph$Vertex.getPrime());
        }
        if (binExport$Callgraph$Vertex.hasFunctionType()) {
            this.setFunctionType(binExport$Callgraph$Vertex.getFunctionType());
        }
        if (binExport$Callgraph$Vertex.hasHasRealName()) {
            this.setHasRealName(binExport$Callgraph$Vertex.getHasRealName());
        }
        if (binExport$Callgraph$Vertex.hasMangledName()) {
            this.bitField0_ |= 16;
            this.mangledName_ = BinExport$Callgraph$Vertex.access$3000(binExport$Callgraph$Vertex);
            this.onChanged();
        }
        if (binExport$Callgraph$Vertex.hasDemangledName()) {
            this.bitField0_ |= 32;
            this.demangledName_ = BinExport$Callgraph$Vertex.access$3100(binExport$Callgraph$Vertex);
            this.onChanged();
        }
        this.mergeUnknownFields(BinExport$Callgraph$Vertex.access$3300(binExport$Callgraph$Vertex));
        this.onChanged();
        return this;
    }

    @Override
    public final boolean isInitialized() {
        if (!this.hasAddress()) {
            return false;
        }
        if (this.hasPrime()) return true;
        return false;
    }

    @Override
    public BinExport$Callgraph$Vertex$Builder mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        BinExport$Callgraph$Vertex binExport$Callgraph$Vertex = null;
        try {
            binExport$Callgraph$Vertex = (BinExport$Callgraph$Vertex)BinExport$Callgraph$Vertex.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
            return this;
        }
        catch (InvalidProtocolBufferException var4_4) {
            binExport$Callgraph$Vertex = (BinExport$Callgraph$Vertex)var4_4.getUnfinishedMessage();
            throw var4_4;
        }
        finally {
            if (binExport$Callgraph$Vertex != null) {
                this.mergeFrom(binExport$Callgraph$Vertex);
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

    public BinExport$Callgraph$Vertex$Builder setAddress(long l2) {
        this.bitField0_ |= 1;
        this.address_ = l2;
        this.onChanged();
        return this;
    }

    public BinExport$Callgraph$Vertex$Builder clearAddress() {
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
    public long getPrime() {
        return this.prime_;
    }

    public BinExport$Callgraph$Vertex$Builder setPrime(long l2) {
        this.bitField0_ |= 2;
        this.prime_ = l2;
        this.onChanged();
        return this;
    }

    public BinExport$Callgraph$Vertex$Builder clearPrime() {
        this.bitField0_ &= -3;
        this.prime_ = 0;
        this.onChanged();
        return this;
    }

    @Override
    public boolean hasFunctionType() {
        if ((this.bitField0_ & 4) != 4) return false;
        return true;
    }

    @Override
    public BinExport$Callgraph$Vertex$FunctionType getFunctionType() {
        BinExport$Callgraph$Vertex$FunctionType binExport$Callgraph$Vertex$FunctionType;
        BinExport$Callgraph$Vertex$FunctionType binExport$Callgraph$Vertex$FunctionType2 = BinExport$Callgraph$Vertex$FunctionType.valueOf(this.functionType_);
        if (binExport$Callgraph$Vertex$FunctionType2 == null) {
            binExport$Callgraph$Vertex$FunctionType = BinExport$Callgraph$Vertex$FunctionType.NORMAL;
            return binExport$Callgraph$Vertex$FunctionType;
        }
        binExport$Callgraph$Vertex$FunctionType = binExport$Callgraph$Vertex$FunctionType2;
        return binExport$Callgraph$Vertex$FunctionType;
    }

    public BinExport$Callgraph$Vertex$Builder setFunctionType(BinExport$Callgraph$Vertex$FunctionType binExport$Callgraph$Vertex$FunctionType) {
        if (binExport$Callgraph$Vertex$FunctionType == null) {
            throw new NullPointerException();
        }
        this.bitField0_ |= 4;
        this.functionType_ = binExport$Callgraph$Vertex$FunctionType.getNumber();
        this.onChanged();
        return this;
    }

    public BinExport$Callgraph$Vertex$Builder clearFunctionType() {
        this.bitField0_ &= -5;
        this.functionType_ = 0;
        this.onChanged();
        return this;
    }

    @Override
    public boolean hasHasRealName() {
        if ((this.bitField0_ & 8) != 8) return false;
        return true;
    }

    @Override
    public boolean getHasRealName() {
        return this.hasRealName_;
    }

    public BinExport$Callgraph$Vertex$Builder setHasRealName(boolean bl2) {
        this.bitField0_ |= 8;
        this.hasRealName_ = bl2;
        this.onChanged();
        return this;
    }

    public BinExport$Callgraph$Vertex$Builder clearHasRealName() {
        this.bitField0_ &= -9;
        this.hasRealName_ = false;
        this.onChanged();
        return this;
    }

    @Override
    public boolean hasMangledName() {
        if ((this.bitField0_ & 16) != 16) return false;
        return true;
    }

    @Override
    public String getMangledName() {
        Object object = this.mangledName_;
        if (object instanceof String) return (String)object;
        ByteString byteString = (ByteString)object;
        String string = byteString.toStringUtf8();
        if (!byteString.isValidUtf8()) return string;
        this.mangledName_ = string;
        return string;
    }

    @Override
    public ByteString getMangledNameBytes() {
        ByteString byteString;
        Object object = this.mangledName_;
        if (!(object instanceof String)) return (ByteString)object;
        this.mangledName_ = byteString = ByteString.copyFromUtf8((String)object);
        return byteString;
    }

    public BinExport$Callgraph$Vertex$Builder setMangledName(String string) {
        if (string == null) {
            throw new NullPointerException();
        }
        this.bitField0_ |= 16;
        this.mangledName_ = string;
        this.onChanged();
        return this;
    }

    public BinExport$Callgraph$Vertex$Builder clearMangledName() {
        this.bitField0_ &= -17;
        this.mangledName_ = BinExport$Callgraph$Vertex.getDefaultInstance().getMangledName();
        this.onChanged();
        return this;
    }

    public BinExport$Callgraph$Vertex$Builder setMangledNameBytes(ByteString byteString) {
        if (byteString == null) {
            throw new NullPointerException();
        }
        this.bitField0_ |= 16;
        this.mangledName_ = byteString;
        this.onChanged();
        return this;
    }

    @Override
    public boolean hasDemangledName() {
        if ((this.bitField0_ & 32) != 32) return false;
        return true;
    }

    @Override
    public String getDemangledName() {
        Object object = this.demangledName_;
        if (object instanceof String) return (String)object;
        ByteString byteString = (ByteString)object;
        String string = byteString.toStringUtf8();
        if (!byteString.isValidUtf8()) return string;
        this.demangledName_ = string;
        return string;
    }

    @Override
    public ByteString getDemangledNameBytes() {
        ByteString byteString;
        Object object = this.demangledName_;
        if (!(object instanceof String)) return (ByteString)object;
        this.demangledName_ = byteString = ByteString.copyFromUtf8((String)object);
        return byteString;
    }

    public BinExport$Callgraph$Vertex$Builder setDemangledName(String string) {
        if (string == null) {
            throw new NullPointerException();
        }
        this.bitField0_ |= 32;
        this.demangledName_ = string;
        this.onChanged();
        return this;
    }

    public BinExport$Callgraph$Vertex$Builder clearDemangledName() {
        this.bitField0_ &= -33;
        this.demangledName_ = BinExport$Callgraph$Vertex.getDefaultInstance().getDemangledName();
        this.onChanged();
        return this;
    }

    public BinExport$Callgraph$Vertex$Builder setDemangledNameBytes(ByteString byteString) {
        if (byteString == null) {
            throw new NullPointerException();
        }
        this.bitField0_ |= 32;
        this.demangledName_ = byteString;
        this.onChanged();
        return this;
    }

    /* synthetic */ BinExport$Callgraph$Vertex$Builder(BinExport$1 binExport$1) {
        this();
    }

    /* synthetic */ BinExport$Callgraph$Vertex$Builder(GeneratedMessage$BuilderParent generatedMessage$BuilderParent, BinExport$1 binExport$1) {
        this(generatedMessage$BuilderParent);
    }
}

