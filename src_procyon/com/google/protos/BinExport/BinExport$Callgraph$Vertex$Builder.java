package com.google.protos.BinExport;

import com.google.protobuf.*;
import java.io.*;

public final class BinExport$Callgraph$Vertex$Builder extends GeneratedMessage$Builder implements BinExport$Callgraph$VertexOrBuilder
{
    private int bitField0_;
    private long address_;
    private long prime_;
    private int functionType_;
    private boolean hasRealName_;
    private Object mangledName_;
    private Object demangledName_;
    
    public static final Descriptors$Descriptor getDescriptor() {
        return BinExport.internal_static_BinExport_Callgraph_Vertex_descriptor;
    }
    
    @Override
    protected GeneratedMessage$FieldAccessorTable internalGetFieldAccessorTable() {
        return BinExport.internal_static_BinExport_Callgraph_Vertex_fieldAccessorTable.ensureFieldAccessorsInitialized(BinExport$Callgraph$Vertex.class, BinExport$Callgraph$Vertex$Builder.class);
    }
    
    private BinExport$Callgraph$Vertex$Builder() {
        this.functionType_ = 0;
        this.mangledName_ = "";
        this.demangledName_ = "";
        this.maybeForceBuilderInitialization();
    }
    
    private BinExport$Callgraph$Vertex$Builder(final GeneratedMessage$BuilderParent generatedMessage$BuilderParent) {
        super(generatedMessage$BuilderParent);
        this.functionType_ = 0;
        this.mangledName_ = "";
        this.demangledName_ = "";
        this.maybeForceBuilderInitialization();
    }
    
    private void maybeForceBuilderInitialization() {
        if (BinExport$Callgraph$Vertex.alwaysUseFieldBuilders) {}
    }
    
    @Override
    public BinExport$Callgraph$Vertex$Builder clear() {
        super.clear();
        this.address_ = 0L;
        this.bitField0_ &= 0xFFFFFFFE;
        this.prime_ = 0L;
        this.bitField0_ &= 0xFFFFFFFD;
        this.functionType_ = 0;
        this.bitField0_ &= 0xFFFFFFFB;
        this.hasRealName_ = false;
        this.bitField0_ &= 0xFFFFFFF7;
        this.mangledName_ = "";
        this.bitField0_ &= 0xFFFFFFEF;
        this.demangledName_ = "";
        this.bitField0_ &= 0xFFFFFFDF;
        return this;
    }
    
    @Override
    public Descriptors$Descriptor getDescriptorForType() {
        return BinExport.internal_static_BinExport_Callgraph_Vertex_descriptor;
    }
    
    @Override
    public BinExport$Callgraph$Vertex getDefaultInstanceForType() {
        return BinExport$Callgraph$Vertex.getDefaultInstance();
    }
    
    @Override
    public BinExport$Callgraph$Vertex build() {
        final BinExport$Callgraph$Vertex buildPartial = this.buildPartial();
        if (!buildPartial.isInitialized()) {
            throw AbstractMessage$Builder.newUninitializedMessageException(buildPartial);
        }
        return buildPartial;
    }
    
    @Override
    public BinExport$Callgraph$Vertex buildPartial() {
        final BinExport$Callgraph$Vertex binExport$Callgraph$Vertex = new BinExport$Callgraph$Vertex(this, null);
        final int bitField0_ = this.bitField0_;
        int n = 0;
        if ((bitField0_ & 0x1) == 0x1) {
            n |= 0x1;
        }
        binExport$Callgraph$Vertex.address_ = this.address_;
        if ((bitField0_ & 0x2) == 0x2) {
            n |= 0x2;
        }
        binExport$Callgraph$Vertex.prime_ = this.prime_;
        if ((bitField0_ & 0x4) == 0x4) {
            n |= 0x4;
        }
        binExport$Callgraph$Vertex.functionType_ = this.functionType_;
        if ((bitField0_ & 0x8) == 0x8) {
            n |= 0x8;
        }
        binExport$Callgraph$Vertex.hasRealName_ = this.hasRealName_;
        if ((bitField0_ & 0x10) == 0x10) {
            n |= 0x10;
        }
        binExport$Callgraph$Vertex.mangledName_ = this.mangledName_;
        if ((bitField0_ & 0x20) == 0x20) {
            n |= 0x20;
        }
        binExport$Callgraph$Vertex.demangledName_ = this.demangledName_;
        binExport$Callgraph$Vertex.bitField0_ = n;
        this.onBuilt();
        return binExport$Callgraph$Vertex;
    }
    
    @Override
    public BinExport$Callgraph$Vertex$Builder mergeFrom(final Message message) {
        if (message instanceof BinExport$Callgraph$Vertex) {
            return this.mergeFrom((BinExport$Callgraph$Vertex)message);
        }
        super.mergeFrom(message);
        return this;
    }
    
    public BinExport$Callgraph$Vertex$Builder mergeFrom(final BinExport$Callgraph$Vertex binExport$Callgraph$Vertex) {
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
            this.bitField0_ |= 0x10;
            this.mangledName_ = binExport$Callgraph$Vertex.mangledName_;
            this.onChanged();
        }
        if (binExport$Callgraph$Vertex.hasDemangledName()) {
            this.bitField0_ |= 0x20;
            this.demangledName_ = binExport$Callgraph$Vertex.demangledName_;
            this.onChanged();
        }
        this.mergeUnknownFields(binExport$Callgraph$Vertex.unknownFields);
        this.onChanged();
        return this;
    }
    
    @Override
    public final boolean isInitialized() {
        return this.hasAddress() && this.hasPrime();
    }
    
    @Override
    public BinExport$Callgraph$Vertex$Builder mergeFrom(final CodedInputStream codedInputStream, final ExtensionRegistryLite extensionRegistryLite) {
        BinExport$Callgraph$Vertex binExport$Callgraph$Vertex = null;
        try {
            binExport$Callgraph$Vertex = (BinExport$Callgraph$Vertex)BinExport$Callgraph$Vertex.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
        }
        catch (InvalidProtocolBufferException ex) {
            binExport$Callgraph$Vertex = (BinExport$Callgraph$Vertex)ex.getUnfinishedMessage();
            throw ex;
        }
        finally {
            if (binExport$Callgraph$Vertex != null) {
                this.mergeFrom(binExport$Callgraph$Vertex);
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
    
    public BinExport$Callgraph$Vertex$Builder setAddress(final long address_) {
        this.bitField0_ |= 0x1;
        this.address_ = address_;
        this.onChanged();
        return this;
    }
    
    public BinExport$Callgraph$Vertex$Builder clearAddress() {
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
    public long getPrime() {
        return this.prime_;
    }
    
    public BinExport$Callgraph$Vertex$Builder setPrime(final long prime_) {
        this.bitField0_ |= 0x2;
        this.prime_ = prime_;
        this.onChanged();
        return this;
    }
    
    public BinExport$Callgraph$Vertex$Builder clearPrime() {
        this.bitField0_ &= 0xFFFFFFFD;
        this.prime_ = 0L;
        this.onChanged();
        return this;
    }
    
    @Override
    public boolean hasFunctionType() {
        return (this.bitField0_ & 0x4) == 0x4;
    }
    
    @Override
    public BinExport$Callgraph$Vertex$FunctionType getFunctionType() {
        final BinExport$Callgraph$Vertex$FunctionType value = BinExport$Callgraph$Vertex$FunctionType.valueOf(this.functionType_);
        return (value == null) ? BinExport$Callgraph$Vertex$FunctionType.NORMAL : value;
    }
    
    public BinExport$Callgraph$Vertex$Builder setFunctionType(final BinExport$Callgraph$Vertex$FunctionType binExport$Callgraph$Vertex$FunctionType) {
        if (binExport$Callgraph$Vertex$FunctionType == null) {
            throw new NullPointerException();
        }
        this.bitField0_ |= 0x4;
        this.functionType_ = binExport$Callgraph$Vertex$FunctionType.getNumber();
        this.onChanged();
        return this;
    }
    
    public BinExport$Callgraph$Vertex$Builder clearFunctionType() {
        this.bitField0_ &= 0xFFFFFFFB;
        this.functionType_ = 0;
        this.onChanged();
        return this;
    }
    
    @Override
    public boolean hasHasRealName() {
        return (this.bitField0_ & 0x8) == 0x8;
    }
    
    @Override
    public boolean getHasRealName() {
        return this.hasRealName_;
    }
    
    public BinExport$Callgraph$Vertex$Builder setHasRealName(final boolean hasRealName_) {
        this.bitField0_ |= 0x8;
        this.hasRealName_ = hasRealName_;
        this.onChanged();
        return this;
    }
    
    public BinExport$Callgraph$Vertex$Builder clearHasRealName() {
        this.bitField0_ &= 0xFFFFFFF7;
        this.hasRealName_ = false;
        this.onChanged();
        return this;
    }
    
    @Override
    public boolean hasMangledName() {
        return (this.bitField0_ & 0x10) == 0x10;
    }
    
    @Override
    public String getMangledName() {
        final Object mangledName_ = this.mangledName_;
        if (!(mangledName_ instanceof String)) {
            final ByteString byteString = (ByteString)mangledName_;
            final String stringUtf8 = byteString.toStringUtf8();
            if (byteString.isValidUtf8()) {
                this.mangledName_ = stringUtf8;
            }
            return stringUtf8;
        }
        return (String)mangledName_;
    }
    
    @Override
    public ByteString getMangledNameBytes() {
        final Object mangledName_ = this.mangledName_;
        if (mangledName_ instanceof String) {
            return (ByteString)(this.mangledName_ = ByteString.copyFromUtf8((String)mangledName_));
        }
        return (ByteString)mangledName_;
    }
    
    public BinExport$Callgraph$Vertex$Builder setMangledName(final String mangledName_) {
        if (mangledName_ == null) {
            throw new NullPointerException();
        }
        this.bitField0_ |= 0x10;
        this.mangledName_ = mangledName_;
        this.onChanged();
        return this;
    }
    
    public BinExport$Callgraph$Vertex$Builder clearMangledName() {
        this.bitField0_ &= 0xFFFFFFEF;
        this.mangledName_ = BinExport$Callgraph$Vertex.getDefaultInstance().getMangledName();
        this.onChanged();
        return this;
    }
    
    public BinExport$Callgraph$Vertex$Builder setMangledNameBytes(final ByteString mangledName_) {
        if (mangledName_ == null) {
            throw new NullPointerException();
        }
        this.bitField0_ |= 0x10;
        this.mangledName_ = mangledName_;
        this.onChanged();
        return this;
    }
    
    @Override
    public boolean hasDemangledName() {
        return (this.bitField0_ & 0x20) == 0x20;
    }
    
    @Override
    public String getDemangledName() {
        final Object demangledName_ = this.demangledName_;
        if (!(demangledName_ instanceof String)) {
            final ByteString byteString = (ByteString)demangledName_;
            final String stringUtf8 = byteString.toStringUtf8();
            if (byteString.isValidUtf8()) {
                this.demangledName_ = stringUtf8;
            }
            return stringUtf8;
        }
        return (String)demangledName_;
    }
    
    @Override
    public ByteString getDemangledNameBytes() {
        final Object demangledName_ = this.demangledName_;
        if (demangledName_ instanceof String) {
            return (ByteString)(this.demangledName_ = ByteString.copyFromUtf8((String)demangledName_));
        }
        return (ByteString)demangledName_;
    }
    
    public BinExport$Callgraph$Vertex$Builder setDemangledName(final String demangledName_) {
        if (demangledName_ == null) {
            throw new NullPointerException();
        }
        this.bitField0_ |= 0x20;
        this.demangledName_ = demangledName_;
        this.onChanged();
        return this;
    }
    
    public BinExport$Callgraph$Vertex$Builder clearDemangledName() {
        this.bitField0_ &= 0xFFFFFFDF;
        this.demangledName_ = BinExport$Callgraph$Vertex.getDefaultInstance().getDemangledName();
        this.onChanged();
        return this;
    }
    
    public BinExport$Callgraph$Vertex$Builder setDemangledNameBytes(final ByteString demangledName_) {
        if (demangledName_ == null) {
            throw new NullPointerException();
        }
        this.bitField0_ |= 0x20;
        this.demangledName_ = demangledName_;
        this.onChanged();
        return this;
    }
}
