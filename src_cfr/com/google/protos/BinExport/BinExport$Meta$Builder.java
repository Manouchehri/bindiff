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
import com.google.protos.BinExport.BinExport$Meta;
import com.google.protos.BinExport.BinExport$MetaOrBuilder;

public final class BinExport$Meta$Builder
extends GeneratedMessage$Builder
implements BinExport$MetaOrBuilder {
    private int bitField0_;
    private Object inputBinary_ = "";
    private ByteString inputHash_ = ByteString.EMPTY;
    private int inputAddressSpace_;
    private Object architectureName_ = "";
    private int maxMnemonicLen_;
    private int numInstructions_;
    private int numFunctions_;
    private int numBasicblocks_;
    private int numEdges_;

    public static final Descriptors$Descriptor getDescriptor() {
        return BinExport.access$000();
    }

    @Override
    protected GeneratedMessage$FieldAccessorTable internalGetFieldAccessorTable() {
        return BinExport.access$100().ensureFieldAccessorsInitialized(BinExport$Meta.class, BinExport$Meta$Builder.class);
    }

    private BinExport$Meta$Builder() {
        this.maybeForceBuilderInitialization();
    }

    private BinExport$Meta$Builder(GeneratedMessage$BuilderParent generatedMessage$BuilderParent) {
        super(generatedMessage$BuilderParent);
        this.maybeForceBuilderInitialization();
    }

    private void maybeForceBuilderInitialization() {
        if (!BinExport$Meta.access$400()) return;
    }

    @Override
    public BinExport$Meta$Builder clear() {
        super.clear();
        this.inputBinary_ = "";
        this.bitField0_ &= -2;
        this.inputHash_ = ByteString.EMPTY;
        this.bitField0_ &= -3;
        this.inputAddressSpace_ = 0;
        this.bitField0_ &= -5;
        this.architectureName_ = "";
        this.bitField0_ &= -9;
        this.maxMnemonicLen_ = 0;
        this.bitField0_ &= -17;
        this.numInstructions_ = 0;
        this.bitField0_ &= -33;
        this.numFunctions_ = 0;
        this.bitField0_ &= -65;
        this.numBasicblocks_ = 0;
        this.bitField0_ &= -129;
        this.numEdges_ = 0;
        this.bitField0_ &= -257;
        return this;
    }

    @Override
    public Descriptors$Descriptor getDescriptorForType() {
        return BinExport.access$000();
    }

    @Override
    public BinExport$Meta getDefaultInstanceForType() {
        return BinExport$Meta.getDefaultInstance();
    }

    @Override
    public BinExport$Meta build() {
        BinExport$Meta binExport$Meta = this.buildPartial();
        if (binExport$Meta.isInitialized()) return binExport$Meta;
        throw BinExport$Meta$Builder.newUninitializedMessageException(binExport$Meta);
    }

    @Override
    public BinExport$Meta buildPartial() {
        BinExport$Meta binExport$Meta = new BinExport$Meta(this, null);
        int n2 = this.bitField0_;
        int n3 = 0;
        if ((n2 & 1) == 1) {
            n3 |= true;
        }
        BinExport$Meta.access$602(binExport$Meta, this.inputBinary_);
        if ((n2 & 2) == 2) {
            n3 |= 2;
        }
        BinExport$Meta.access$702(binExport$Meta, this.inputHash_);
        if ((n2 & 4) == 4) {
            n3 |= 4;
        }
        BinExport$Meta.access$802(binExport$Meta, this.inputAddressSpace_);
        if ((n2 & 8) == 8) {
            n3 |= 8;
        }
        BinExport$Meta.access$902(binExport$Meta, this.architectureName_);
        if ((n2 & 16) == 16) {
            n3 |= 16;
        }
        BinExport$Meta.access$1002(binExport$Meta, this.maxMnemonicLen_);
        if ((n2 & 32) == 32) {
            n3 |= 32;
        }
        BinExport$Meta.access$1102(binExport$Meta, this.numInstructions_);
        if ((n2 & 64) == 64) {
            n3 |= 64;
        }
        BinExport$Meta.access$1202(binExport$Meta, this.numFunctions_);
        if ((n2 & 128) == 128) {
            n3 |= 128;
        }
        BinExport$Meta.access$1302(binExport$Meta, this.numBasicblocks_);
        if ((n2 & 256) == 256) {
            n3 |= 256;
        }
        BinExport$Meta.access$1402(binExport$Meta, this.numEdges_);
        BinExport$Meta.access$1502(binExport$Meta, n3);
        this.onBuilt();
        return binExport$Meta;
    }

    @Override
    public BinExport$Meta$Builder mergeFrom(Message message) {
        if (message instanceof BinExport$Meta) {
            return this.mergeFrom((BinExport$Meta)message);
        }
        super.mergeFrom(message);
        return this;
    }

    public BinExport$Meta$Builder mergeFrom(BinExport$Meta binExport$Meta) {
        if (binExport$Meta == BinExport$Meta.getDefaultInstance()) {
            return this;
        }
        if (binExport$Meta.hasInputBinary()) {
            this.bitField0_ |= 1;
            this.inputBinary_ = BinExport$Meta.access$600(binExport$Meta);
            this.onChanged();
        }
        if (binExport$Meta.hasInputHash()) {
            this.setInputHash(binExport$Meta.getInputHash());
        }
        if (binExport$Meta.hasInputAddressSpace()) {
            this.setInputAddressSpace(binExport$Meta.getInputAddressSpace());
        }
        if (binExport$Meta.hasArchitectureName()) {
            this.bitField0_ |= 8;
            this.architectureName_ = BinExport$Meta.access$900(binExport$Meta);
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
        this.mergeUnknownFields(BinExport$Meta.access$1600(binExport$Meta));
        this.onChanged();
        return this;
    }

    @Override
    public final boolean isInitialized() {
        return true;
    }

    @Override
    public BinExport$Meta$Builder mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        BinExport$Meta binExport$Meta = null;
        try {
            binExport$Meta = (BinExport$Meta)BinExport$Meta.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
            return this;
        }
        catch (InvalidProtocolBufferException var4_4) {
            binExport$Meta = (BinExport$Meta)var4_4.getUnfinishedMessage();
            throw var4_4;
        }
        finally {
            if (binExport$Meta != null) {
                this.mergeFrom(binExport$Meta);
            }
        }
    }

    @Override
    public boolean hasInputBinary() {
        if ((this.bitField0_ & 1) != 1) return false;
        return true;
    }

    @Override
    public String getInputBinary() {
        Object object = this.inputBinary_;
        if (object instanceof String) return (String)object;
        ByteString byteString = (ByteString)object;
        String string = byteString.toStringUtf8();
        if (!byteString.isValidUtf8()) return string;
        this.inputBinary_ = string;
        return string;
    }

    @Override
    public ByteString getInputBinaryBytes() {
        ByteString byteString;
        Object object = this.inputBinary_;
        if (!(object instanceof String)) return (ByteString)object;
        this.inputBinary_ = byteString = ByteString.copyFromUtf8((String)object);
        return byteString;
    }

    public BinExport$Meta$Builder setInputBinary(String string) {
        if (string == null) {
            throw new NullPointerException();
        }
        this.bitField0_ |= 1;
        this.inputBinary_ = string;
        this.onChanged();
        return this;
    }

    public BinExport$Meta$Builder clearInputBinary() {
        this.bitField0_ &= -2;
        this.inputBinary_ = BinExport$Meta.getDefaultInstance().getInputBinary();
        this.onChanged();
        return this;
    }

    public BinExport$Meta$Builder setInputBinaryBytes(ByteString byteString) {
        if (byteString == null) {
            throw new NullPointerException();
        }
        this.bitField0_ |= 1;
        this.inputBinary_ = byteString;
        this.onChanged();
        return this;
    }

    @Override
    public boolean hasInputHash() {
        if ((this.bitField0_ & 2) != 2) return false;
        return true;
    }

    @Override
    public ByteString getInputHash() {
        return this.inputHash_;
    }

    public BinExport$Meta$Builder setInputHash(ByteString byteString) {
        if (byteString == null) {
            throw new NullPointerException();
        }
        this.bitField0_ |= 2;
        this.inputHash_ = byteString;
        this.onChanged();
        return this;
    }

    public BinExport$Meta$Builder clearInputHash() {
        this.bitField0_ &= -3;
        this.inputHash_ = BinExport$Meta.getDefaultInstance().getInputHash();
        this.onChanged();
        return this;
    }

    @Override
    public boolean hasInputAddressSpace() {
        if ((this.bitField0_ & 4) != 4) return false;
        return true;
    }

    @Override
    public int getInputAddressSpace() {
        return this.inputAddressSpace_;
    }

    public BinExport$Meta$Builder setInputAddressSpace(int n2) {
        this.bitField0_ |= 4;
        this.inputAddressSpace_ = n2;
        this.onChanged();
        return this;
    }

    public BinExport$Meta$Builder clearInputAddressSpace() {
        this.bitField0_ &= -5;
        this.inputAddressSpace_ = 0;
        this.onChanged();
        return this;
    }

    @Override
    public boolean hasArchitectureName() {
        if ((this.bitField0_ & 8) != 8) return false;
        return true;
    }

    @Override
    public String getArchitectureName() {
        Object object = this.architectureName_;
        if (object instanceof String) return (String)object;
        ByteString byteString = (ByteString)object;
        String string = byteString.toStringUtf8();
        if (!byteString.isValidUtf8()) return string;
        this.architectureName_ = string;
        return string;
    }

    @Override
    public ByteString getArchitectureNameBytes() {
        ByteString byteString;
        Object object = this.architectureName_;
        if (!(object instanceof String)) return (ByteString)object;
        this.architectureName_ = byteString = ByteString.copyFromUtf8((String)object);
        return byteString;
    }

    public BinExport$Meta$Builder setArchitectureName(String string) {
        if (string == null) {
            throw new NullPointerException();
        }
        this.bitField0_ |= 8;
        this.architectureName_ = string;
        this.onChanged();
        return this;
    }

    public BinExport$Meta$Builder clearArchitectureName() {
        this.bitField0_ &= -9;
        this.architectureName_ = BinExport$Meta.getDefaultInstance().getArchitectureName();
        this.onChanged();
        return this;
    }

    public BinExport$Meta$Builder setArchitectureNameBytes(ByteString byteString) {
        if (byteString == null) {
            throw new NullPointerException();
        }
        this.bitField0_ |= 8;
        this.architectureName_ = byteString;
        this.onChanged();
        return this;
    }

    @Override
    public boolean hasMaxMnemonicLen() {
        if ((this.bitField0_ & 16) != 16) return false;
        return true;
    }

    @Override
    public int getMaxMnemonicLen() {
        return this.maxMnemonicLen_;
    }

    public BinExport$Meta$Builder setMaxMnemonicLen(int n2) {
        this.bitField0_ |= 16;
        this.maxMnemonicLen_ = n2;
        this.onChanged();
        return this;
    }

    public BinExport$Meta$Builder clearMaxMnemonicLen() {
        this.bitField0_ &= -17;
        this.maxMnemonicLen_ = 0;
        this.onChanged();
        return this;
    }

    @Override
    public boolean hasNumInstructions() {
        if ((this.bitField0_ & 32) != 32) return false;
        return true;
    }

    @Override
    public int getNumInstructions() {
        return this.numInstructions_;
    }

    public BinExport$Meta$Builder setNumInstructions(int n2) {
        this.bitField0_ |= 32;
        this.numInstructions_ = n2;
        this.onChanged();
        return this;
    }

    public BinExport$Meta$Builder clearNumInstructions() {
        this.bitField0_ &= -33;
        this.numInstructions_ = 0;
        this.onChanged();
        return this;
    }

    @Override
    public boolean hasNumFunctions() {
        if ((this.bitField0_ & 64) != 64) return false;
        return true;
    }

    @Override
    public int getNumFunctions() {
        return this.numFunctions_;
    }

    public BinExport$Meta$Builder setNumFunctions(int n2) {
        this.bitField0_ |= 64;
        this.numFunctions_ = n2;
        this.onChanged();
        return this;
    }

    public BinExport$Meta$Builder clearNumFunctions() {
        this.bitField0_ &= -65;
        this.numFunctions_ = 0;
        this.onChanged();
        return this;
    }

    @Override
    public boolean hasNumBasicblocks() {
        if ((this.bitField0_ & 128) != 128) return false;
        return true;
    }

    @Override
    public int getNumBasicblocks() {
        return this.numBasicblocks_;
    }

    public BinExport$Meta$Builder setNumBasicblocks(int n2) {
        this.bitField0_ |= 128;
        this.numBasicblocks_ = n2;
        this.onChanged();
        return this;
    }

    public BinExport$Meta$Builder clearNumBasicblocks() {
        this.bitField0_ &= -129;
        this.numBasicblocks_ = 0;
        this.onChanged();
        return this;
    }

    @Override
    public boolean hasNumEdges() {
        if ((this.bitField0_ & 256) != 256) return false;
        return true;
    }

    @Override
    public int getNumEdges() {
        return this.numEdges_;
    }

    public BinExport$Meta$Builder setNumEdges(int n2) {
        this.bitField0_ |= 256;
        this.numEdges_ = n2;
        this.onChanged();
        return this;
    }

    public BinExport$Meta$Builder clearNumEdges() {
        this.bitField0_ &= -257;
        this.numEdges_ = 0;
        this.onChanged();
        return this;
    }

    /* synthetic */ BinExport$Meta$Builder(BinExport$1 binExport$1) {
        this();
    }

    /* synthetic */ BinExport$Meta$Builder(GeneratedMessage$BuilderParent generatedMessage$BuilderParent, BinExport$1 binExport$1) {
        this(generatedMessage$BuilderParent);
    }
}

