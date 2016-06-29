package com.google.protos.BinExport;

import com.google.protobuf.*;
import java.io.*;

public final class BinExport$Meta$Builder extends GeneratedMessage$Builder implements BinExport$MetaOrBuilder
{
    private int bitField0_;
    private Object inputBinary_;
    private ByteString inputHash_;
    private int inputAddressSpace_;
    private Object architectureName_;
    private int maxMnemonicLen_;
    private int numInstructions_;
    private int numFunctions_;
    private int numBasicblocks_;
    private int numEdges_;
    
    public static final Descriptors$Descriptor getDescriptor() {
        return BinExport.internal_static_BinExport_Meta_descriptor;
    }
    
    @Override
    protected GeneratedMessage$FieldAccessorTable internalGetFieldAccessorTable() {
        return BinExport.internal_static_BinExport_Meta_fieldAccessorTable.ensureFieldAccessorsInitialized(BinExport$Meta.class, BinExport$Meta$Builder.class);
    }
    
    private BinExport$Meta$Builder() {
        this.inputBinary_ = "";
        this.inputHash_ = ByteString.EMPTY;
        this.architectureName_ = "";
        this.maybeForceBuilderInitialization();
    }
    
    private BinExport$Meta$Builder(final GeneratedMessage$BuilderParent generatedMessage$BuilderParent) {
        super(generatedMessage$BuilderParent);
        this.inputBinary_ = "";
        this.inputHash_ = ByteString.EMPTY;
        this.architectureName_ = "";
        this.maybeForceBuilderInitialization();
    }
    
    private void maybeForceBuilderInitialization() {
        if (BinExport$Meta.alwaysUseFieldBuilders) {}
    }
    
    @Override
    public BinExport$Meta$Builder clear() {
        super.clear();
        this.inputBinary_ = "";
        this.bitField0_ &= 0xFFFFFFFE;
        this.inputHash_ = ByteString.EMPTY;
        this.bitField0_ &= 0xFFFFFFFD;
        this.inputAddressSpace_ = 0;
        this.bitField0_ &= 0xFFFFFFFB;
        this.architectureName_ = "";
        this.bitField0_ &= 0xFFFFFFF7;
        this.maxMnemonicLen_ = 0;
        this.bitField0_ &= 0xFFFFFFEF;
        this.numInstructions_ = 0;
        this.bitField0_ &= 0xFFFFFFDF;
        this.numFunctions_ = 0;
        this.bitField0_ &= 0xFFFFFFBF;
        this.numBasicblocks_ = 0;
        this.bitField0_ &= 0xFFFFFF7F;
        this.numEdges_ = 0;
        this.bitField0_ &= 0xFFFFFEFF;
        return this;
    }
    
    @Override
    public Descriptors$Descriptor getDescriptorForType() {
        return BinExport.internal_static_BinExport_Meta_descriptor;
    }
    
    @Override
    public BinExport$Meta getDefaultInstanceForType() {
        return BinExport$Meta.getDefaultInstance();
    }
    
    @Override
    public BinExport$Meta build() {
        final BinExport$Meta buildPartial = this.buildPartial();
        if (!buildPartial.isInitialized()) {
            throw AbstractMessage$Builder.newUninitializedMessageException(buildPartial);
        }
        return buildPartial;
    }
    
    @Override
    public BinExport$Meta buildPartial() {
        final BinExport$Meta binExport$Meta = new BinExport$Meta(this, null);
        final int bitField0_ = this.bitField0_;
        int n = 0;
        if ((bitField0_ & 0x1) == 0x1) {
            n |= 0x1;
        }
        binExport$Meta.inputBinary_ = this.inputBinary_;
        if ((bitField0_ & 0x2) == 0x2) {
            n |= 0x2;
        }
        binExport$Meta.inputHash_ = this.inputHash_;
        if ((bitField0_ & 0x4) == 0x4) {
            n |= 0x4;
        }
        binExport$Meta.inputAddressSpace_ = this.inputAddressSpace_;
        if ((bitField0_ & 0x8) == 0x8) {
            n |= 0x8;
        }
        binExport$Meta.architectureName_ = this.architectureName_;
        if ((bitField0_ & 0x10) == 0x10) {
            n |= 0x10;
        }
        binExport$Meta.maxMnemonicLen_ = this.maxMnemonicLen_;
        if ((bitField0_ & 0x20) == 0x20) {
            n |= 0x20;
        }
        binExport$Meta.numInstructions_ = this.numInstructions_;
        if ((bitField0_ & 0x40) == 0x40) {
            n |= 0x40;
        }
        binExport$Meta.numFunctions_ = this.numFunctions_;
        if ((bitField0_ & 0x80) == 0x80) {
            n |= 0x80;
        }
        binExport$Meta.numBasicblocks_ = this.numBasicblocks_;
        if ((bitField0_ & 0x100) == 0x100) {
            n |= 0x100;
        }
        binExport$Meta.numEdges_ = this.numEdges_;
        binExport$Meta.bitField0_ = n;
        this.onBuilt();
        return binExport$Meta;
    }
    
    @Override
    public BinExport$Meta$Builder mergeFrom(final Message message) {
        if (message instanceof BinExport$Meta) {
            return this.mergeFrom((BinExport$Meta)message);
        }
        super.mergeFrom(message);
        return this;
    }
    
    public BinExport$Meta$Builder mergeFrom(final BinExport$Meta binExport$Meta) {
        if (binExport$Meta == BinExport$Meta.getDefaultInstance()) {
            return this;
        }
        if (binExport$Meta.hasInputBinary()) {
            this.bitField0_ |= 0x1;
            this.inputBinary_ = binExport$Meta.inputBinary_;
            this.onChanged();
        }
        if (binExport$Meta.hasInputHash()) {
            this.setInputHash(binExport$Meta.getInputHash());
        }
        if (binExport$Meta.hasInputAddressSpace()) {
            this.setInputAddressSpace(binExport$Meta.getInputAddressSpace());
        }
        if (binExport$Meta.hasArchitectureName()) {
            this.bitField0_ |= 0x8;
            this.architectureName_ = binExport$Meta.architectureName_;
            this.onChanged();
        }
        if (binExport$Meta.hasMaxMnemonicLen()) {
            this.setMaxMnemonicLen(binExport$Meta.getMaxMnemonicLen());
        }
        if (binExport$Meta.hasNumInstructions()) {
            this.setNumInstructions(binExport$Meta.getNumInstructions());
        }
        if (binExport$Meta.hasNumFunctions()) {
            this.setNumFunctions(binExport$Meta.getNumFunctions());
        }
        if (binExport$Meta.hasNumBasicblocks()) {
            this.setNumBasicblocks(binExport$Meta.getNumBasicblocks());
        }
        if (binExport$Meta.hasNumEdges()) {
            this.setNumEdges(binExport$Meta.getNumEdges());
        }
        this.mergeUnknownFields(binExport$Meta.unknownFields);
        this.onChanged();
        return this;
    }
    
    @Override
    public final boolean isInitialized() {
        return true;
    }
    
    @Override
    public BinExport$Meta$Builder mergeFrom(final CodedInputStream codedInputStream, final ExtensionRegistryLite extensionRegistryLite) {
        BinExport$Meta binExport$Meta = null;
        try {
            binExport$Meta = (BinExport$Meta)BinExport$Meta.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
        }
        catch (InvalidProtocolBufferException ex) {
            binExport$Meta = (BinExport$Meta)ex.getUnfinishedMessage();
            throw ex;
        }
        finally {
            if (binExport$Meta != null) {
                this.mergeFrom(binExport$Meta);
            }
        }
        return this;
    }
    
    @Override
    public boolean hasInputBinary() {
        return (this.bitField0_ & 0x1) == 0x1;
    }
    
    @Override
    public String getInputBinary() {
        final Object inputBinary_ = this.inputBinary_;
        if (!(inputBinary_ instanceof String)) {
            final ByteString byteString = (ByteString)inputBinary_;
            final String stringUtf8 = byteString.toStringUtf8();
            if (byteString.isValidUtf8()) {
                this.inputBinary_ = stringUtf8;
            }
            return stringUtf8;
        }
        return (String)inputBinary_;
    }
    
    @Override
    public ByteString getInputBinaryBytes() {
        final Object inputBinary_ = this.inputBinary_;
        if (inputBinary_ instanceof String) {
            return (ByteString)(this.inputBinary_ = ByteString.copyFromUtf8((String)inputBinary_));
        }
        return (ByteString)inputBinary_;
    }
    
    public BinExport$Meta$Builder setInputBinary(final String inputBinary_) {
        if (inputBinary_ == null) {
            throw new NullPointerException();
        }
        this.bitField0_ |= 0x1;
        this.inputBinary_ = inputBinary_;
        this.onChanged();
        return this;
    }
    
    public BinExport$Meta$Builder clearInputBinary() {
        this.bitField0_ &= 0xFFFFFFFE;
        this.inputBinary_ = BinExport$Meta.getDefaultInstance().getInputBinary();
        this.onChanged();
        return this;
    }
    
    public BinExport$Meta$Builder setInputBinaryBytes(final ByteString inputBinary_) {
        if (inputBinary_ == null) {
            throw new NullPointerException();
        }
        this.bitField0_ |= 0x1;
        this.inputBinary_ = inputBinary_;
        this.onChanged();
        return this;
    }
    
    @Override
    public boolean hasInputHash() {
        return (this.bitField0_ & 0x2) == 0x2;
    }
    
    @Override
    public ByteString getInputHash() {
        return this.inputHash_;
    }
    
    public BinExport$Meta$Builder setInputHash(final ByteString inputHash_) {
        if (inputHash_ == null) {
            throw new NullPointerException();
        }
        this.bitField0_ |= 0x2;
        this.inputHash_ = inputHash_;
        this.onChanged();
        return this;
    }
    
    public BinExport$Meta$Builder clearInputHash() {
        this.bitField0_ &= 0xFFFFFFFD;
        this.inputHash_ = BinExport$Meta.getDefaultInstance().getInputHash();
        this.onChanged();
        return this;
    }
    
    @Override
    public boolean hasInputAddressSpace() {
        return (this.bitField0_ & 0x4) == 0x4;
    }
    
    @Override
    public int getInputAddressSpace() {
        return this.inputAddressSpace_;
    }
    
    public BinExport$Meta$Builder setInputAddressSpace(final int inputAddressSpace_) {
        this.bitField0_ |= 0x4;
        this.inputAddressSpace_ = inputAddressSpace_;
        this.onChanged();
        return this;
    }
    
    public BinExport$Meta$Builder clearInputAddressSpace() {
        this.bitField0_ &= 0xFFFFFFFB;
        this.inputAddressSpace_ = 0;
        this.onChanged();
        return this;
    }
    
    @Override
    public boolean hasArchitectureName() {
        return (this.bitField0_ & 0x8) == 0x8;
    }
    
    @Override
    public String getArchitectureName() {
        final Object architectureName_ = this.architectureName_;
        if (!(architectureName_ instanceof String)) {
            final ByteString byteString = (ByteString)architectureName_;
            final String stringUtf8 = byteString.toStringUtf8();
            if (byteString.isValidUtf8()) {
                this.architectureName_ = stringUtf8;
            }
            return stringUtf8;
        }
        return (String)architectureName_;
    }
    
    @Override
    public ByteString getArchitectureNameBytes() {
        final Object architectureName_ = this.architectureName_;
        if (architectureName_ instanceof String) {
            return (ByteString)(this.architectureName_ = ByteString.copyFromUtf8((String)architectureName_));
        }
        return (ByteString)architectureName_;
    }
    
    public BinExport$Meta$Builder setArchitectureName(final String architectureName_) {
        if (architectureName_ == null) {
            throw new NullPointerException();
        }
        this.bitField0_ |= 0x8;
        this.architectureName_ = architectureName_;
        this.onChanged();
        return this;
    }
    
    public BinExport$Meta$Builder clearArchitectureName() {
        this.bitField0_ &= 0xFFFFFFF7;
        this.architectureName_ = BinExport$Meta.getDefaultInstance().getArchitectureName();
        this.onChanged();
        return this;
    }
    
    public BinExport$Meta$Builder setArchitectureNameBytes(final ByteString architectureName_) {
        if (architectureName_ == null) {
            throw new NullPointerException();
        }
        this.bitField0_ |= 0x8;
        this.architectureName_ = architectureName_;
        this.onChanged();
        return this;
    }
    
    @Override
    public boolean hasMaxMnemonicLen() {
        return (this.bitField0_ & 0x10) == 0x10;
    }
    
    @Override
    public int getMaxMnemonicLen() {
        return this.maxMnemonicLen_;
    }
    
    public BinExport$Meta$Builder setMaxMnemonicLen(final int maxMnemonicLen_) {
        this.bitField0_ |= 0x10;
        this.maxMnemonicLen_ = maxMnemonicLen_;
        this.onChanged();
        return this;
    }
    
    public BinExport$Meta$Builder clearMaxMnemonicLen() {
        this.bitField0_ &= 0xFFFFFFEF;
        this.maxMnemonicLen_ = 0;
        this.onChanged();
        return this;
    }
    
    @Override
    public boolean hasNumInstructions() {
        return (this.bitField0_ & 0x20) == 0x20;
    }
    
    @Override
    public int getNumInstructions() {
        return this.numInstructions_;
    }
    
    public BinExport$Meta$Builder setNumInstructions(final int numInstructions_) {
        this.bitField0_ |= 0x20;
        this.numInstructions_ = numInstructions_;
        this.onChanged();
        return this;
    }
    
    public BinExport$Meta$Builder clearNumInstructions() {
        this.bitField0_ &= 0xFFFFFFDF;
        this.numInstructions_ = 0;
        this.onChanged();
        return this;
    }
    
    @Override
    public boolean hasNumFunctions() {
        return (this.bitField0_ & 0x40) == 0x40;
    }
    
    @Override
    public int getNumFunctions() {
        return this.numFunctions_;
    }
    
    public BinExport$Meta$Builder setNumFunctions(final int numFunctions_) {
        this.bitField0_ |= 0x40;
        this.numFunctions_ = numFunctions_;
        this.onChanged();
        return this;
    }
    
    public BinExport$Meta$Builder clearNumFunctions() {
        this.bitField0_ &= 0xFFFFFFBF;
        this.numFunctions_ = 0;
        this.onChanged();
        return this;
    }
    
    @Override
    public boolean hasNumBasicblocks() {
        return (this.bitField0_ & 0x80) == 0x80;
    }
    
    @Override
    public int getNumBasicblocks() {
        return this.numBasicblocks_;
    }
    
    public BinExport$Meta$Builder setNumBasicblocks(final int numBasicblocks_) {
        this.bitField0_ |= 0x80;
        this.numBasicblocks_ = numBasicblocks_;
        this.onChanged();
        return this;
    }
    
    public BinExport$Meta$Builder clearNumBasicblocks() {
        this.bitField0_ &= 0xFFFFFF7F;
        this.numBasicblocks_ = 0;
        this.onChanged();
        return this;
    }
    
    @Override
    public boolean hasNumEdges() {
        return (this.bitField0_ & 0x100) == 0x100;
    }
    
    @Override
    public int getNumEdges() {
        return this.numEdges_;
    }
    
    public BinExport$Meta$Builder setNumEdges(final int numEdges_) {
        this.bitField0_ |= 0x100;
        this.numEdges_ = numEdges_;
        this.onChanged();
        return this;
    }
    
    public BinExport$Meta$Builder clearNumEdges() {
        this.bitField0_ &= 0xFFFFFEFF;
        this.numEdges_ = 0;
        this.onChanged();
        return this;
    }
}
