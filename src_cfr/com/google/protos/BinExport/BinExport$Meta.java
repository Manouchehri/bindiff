/*
 * Decompiled with CFR 0_115.
 */
package com.google.protos.BinExport;

import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.CodedOutputStream;
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
import com.google.protobuf.Parser;
import com.google.protobuf.UnknownFieldSet;
import com.google.protobuf.UnknownFieldSet$Builder;
import com.google.protos.BinExport.BinExport;
import com.google.protos.BinExport.BinExport$1;
import com.google.protos.BinExport.BinExport$Meta$1;
import com.google.protos.BinExport.BinExport$Meta$Builder;
import com.google.protos.BinExport.BinExport$MetaOrBuilder;
import java.io.IOException;
import java.io.InputStream;

public final class BinExport$Meta
extends GeneratedMessage
implements BinExport$MetaOrBuilder {
    private int bitField0_;
    public static final int INPUT_BINARY_FIELD_NUMBER = 1;
    private volatile Object inputBinary_;
    public static final int INPUT_HASH_FIELD_NUMBER = 2;
    private ByteString inputHash_;
    public static final int INPUT_ADDRESS_SPACE_FIELD_NUMBER = 3;
    private int inputAddressSpace_;
    public static final int ARCHITECTURE_NAME_FIELD_NUMBER = 4;
    private volatile Object architectureName_;
    public static final int MAX_MNEMONIC_LEN_FIELD_NUMBER = 5;
    private int maxMnemonicLen_;
    public static final int NUM_INSTRUCTIONS_FIELD_NUMBER = 6;
    private int numInstructions_;
    public static final int NUM_FUNCTIONS_FIELD_NUMBER = 7;
    private int numFunctions_;
    public static final int NUM_BASICBLOCKS_FIELD_NUMBER = 8;
    private int numBasicblocks_;
    public static final int NUM_EDGES_FIELD_NUMBER = 9;
    private int numEdges_;
    private byte memoizedIsInitialized = -1;
    private int memoizedSerializedSize = -1;
    private static final long serialVersionUID = 0;
    private static final BinExport$Meta DEFAULT_INSTANCE = new BinExport$Meta();
    public static final Parser PARSER = new BinExport$Meta$1();

    private BinExport$Meta(GeneratedMessage$Builder generatedMessage$Builder) {
        super(generatedMessage$Builder);
    }

    private BinExport$Meta() {
        this.inputBinary_ = "";
        this.inputHash_ = ByteString.EMPTY;
        this.inputAddressSpace_ = 0;
        this.architectureName_ = "";
        this.maxMnemonicLen_ = 0;
        this.numInstructions_ = 0;
        this.numFunctions_ = 0;
        this.numBasicblocks_ = 0;
        this.numEdges_ = 0;
    }

    @Override
    public final UnknownFieldSet getUnknownFields() {
        return this.unknownFields;
    }

    private BinExport$Meta(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        this();
        boolean bl2 = false;
        UnknownFieldSet$Builder unknownFieldSet$Builder = UnknownFieldSet.newBuilder();
        try {
            boolean bl3 = false;
            block18 : while (!bl3) {
                int n2 = codedInputStream.readTag();
                switch (n2) {
                    ByteString byteString;
                    case 0: {
                        bl3 = true;
                        continue block18;
                    }
                    default: {
                        if (this.parseUnknownField(codedInputStream, unknownFieldSet$Builder, extensionRegistryLite, n2)) continue block18;
                        bl3 = true;
                        continue block18;
                    }
                    case 10: {
                        byteString = codedInputStream.readBytes();
                        this.bitField0_ |= 1;
                        this.inputBinary_ = byteString;
                        continue block18;
                    }
                    case 18: {
                        this.bitField0_ |= 2;
                        this.inputHash_ = codedInputStream.readBytes();
                        continue block18;
                    }
                    case 24: {
                        this.bitField0_ |= 4;
                        this.inputAddressSpace_ = codedInputStream.readUInt32();
                        continue block18;
                    }
                    case 34: {
                        byteString = codedInputStream.readBytes();
                        this.bitField0_ |= 8;
                        this.architectureName_ = byteString;
                        continue block18;
                    }
                    case 40: {
                        this.bitField0_ |= 16;
                        this.maxMnemonicLen_ = codedInputStream.readUInt32();
                        continue block18;
                    }
                    case 48: {
                        this.bitField0_ |= 32;
                        this.numInstructions_ = codedInputStream.readUInt32();
                        continue block18;
                    }
                    case 56: {
                        this.bitField0_ |= 64;
                        this.numFunctions_ = codedInputStream.readUInt32();
                        continue block18;
                    }
                    case 64: {
                        this.bitField0_ |= 128;
                        this.numBasicblocks_ = codedInputStream.readUInt32();
                        continue block18;
                    }
                    case 72: 
                }
                this.bitField0_ |= 256;
                this.numEdges_ = codedInputStream.readUInt32();
            }
            return;
        }
        catch (InvalidProtocolBufferException var5_6) {
            throw new RuntimeException(var5_6.setUnfinishedMessage(this));
        }
        catch (IOException var5_7) {
            throw new RuntimeException(new InvalidProtocolBufferException(var5_7.getMessage()).setUnfinishedMessage(this));
        }
        finally {
            this.unknownFields = unknownFieldSet$Builder.build();
            this.makeExtensionsImmutable();
        }
    }

    public static final Descriptors$Descriptor getDescriptor() {
        return BinExport.access$000();
    }

    @Override
    protected GeneratedMessage$FieldAccessorTable internalGetFieldAccessorTable() {
        return BinExport.access$100().ensureFieldAccessorsInitialized(BinExport$Meta.class, BinExport$Meta$Builder.class);
    }

    @Override
    public boolean hasInputBinary() {
        if ((this.bitField0_ & 1) != 1) return false;
        return true;
    }

    @Override
    public String getInputBinary() {
        Object object = this.inputBinary_;
        if (object instanceof String) {
            return (String)object;
        }
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

    @Override
    public boolean hasInputHash() {
        if ((this.bitField0_ & 2) != 2) return false;
        return true;
    }

    @Override
    public ByteString getInputHash() {
        return this.inputHash_;
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

    @Override
    public boolean hasArchitectureName() {
        if ((this.bitField0_ & 8) != 8) return false;
        return true;
    }

    @Override
    public String getArchitectureName() {
        Object object = this.architectureName_;
        if (object instanceof String) {
            return (String)object;
        }
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

    @Override
    public boolean hasMaxMnemonicLen() {
        if ((this.bitField0_ & 16) != 16) return false;
        return true;
    }

    @Override
    public int getMaxMnemonicLen() {
        return this.maxMnemonicLen_;
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

    @Override
    public boolean hasNumFunctions() {
        if ((this.bitField0_ & 64) != 64) return false;
        return true;
    }

    @Override
    public int getNumFunctions() {
        return this.numFunctions_;
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

    @Override
    public boolean hasNumEdges() {
        if ((this.bitField0_ & 256) != 256) return false;
        return true;
    }

    @Override
    public int getNumEdges() {
        return this.numEdges_;
    }

    @Override
    public final boolean isInitialized() {
        byte by2 = this.memoizedIsInitialized;
        if (by2 == 1) {
            return true;
        }
        if (by2 == 0) {
            return false;
        }
        this.memoizedIsInitialized = 1;
        return true;
    }

    @Override
    public void writeTo(CodedOutputStream codedOutputStream) {
        if ((this.bitField0_ & 1) == 1) {
            codedOutputStream.writeBytes(1, this.getInputBinaryBytes());
        }
        if ((this.bitField0_ & 2) == 2) {
            codedOutputStream.writeBytes(2, this.inputHash_);
        }
        if ((this.bitField0_ & 4) == 4) {
            codedOutputStream.writeUInt32(3, this.inputAddressSpace_);
        }
        if ((this.bitField0_ & 8) == 8) {
            codedOutputStream.writeBytes(4, this.getArchitectureNameBytes());
        }
        if ((this.bitField0_ & 16) == 16) {
            codedOutputStream.writeUInt32(5, this.maxMnemonicLen_);
        }
        if ((this.bitField0_ & 32) == 32) {
            codedOutputStream.writeUInt32(6, this.numInstructions_);
        }
        if ((this.bitField0_ & 64) == 64) {
            codedOutputStream.writeUInt32(7, this.numFunctions_);
        }
        if ((this.bitField0_ & 128) == 128) {
            codedOutputStream.writeUInt32(8, this.numBasicblocks_);
        }
        if ((this.bitField0_ & 256) == 256) {
            codedOutputStream.writeUInt32(9, this.numEdges_);
        }
        this.unknownFields.writeTo(codedOutputStream);
    }

    @Override
    public int getSerializedSize() {
        int n2 = this.memoizedSerializedSize;
        if (n2 != -1) {
            return n2;
        }
        n2 = 0;
        if ((this.bitField0_ & 1) == 1) {
            n2 += CodedOutputStream.computeBytesSize(1, this.getInputBinaryBytes());
        }
        if ((this.bitField0_ & 2) == 2) {
            n2 += CodedOutputStream.computeBytesSize(2, this.inputHash_);
        }
        if ((this.bitField0_ & 4) == 4) {
            n2 += CodedOutputStream.computeUInt32Size(3, this.inputAddressSpace_);
        }
        if ((this.bitField0_ & 8) == 8) {
            n2 += CodedOutputStream.computeBytesSize(4, this.getArchitectureNameBytes());
        }
        if ((this.bitField0_ & 16) == 16) {
            n2 += CodedOutputStream.computeUInt32Size(5, this.maxMnemonicLen_);
        }
        if ((this.bitField0_ & 32) == 32) {
            n2 += CodedOutputStream.computeUInt32Size(6, this.numInstructions_);
        }
        if ((this.bitField0_ & 64) == 64) {
            n2 += CodedOutputStream.computeUInt32Size(7, this.numFunctions_);
        }
        if ((this.bitField0_ & 128) == 128) {
            n2 += CodedOutputStream.computeUInt32Size(8, this.numBasicblocks_);
        }
        if ((this.bitField0_ & 256) == 256) {
            n2 += CodedOutputStream.computeUInt32Size(9, this.numEdges_);
        }
        this.memoizedSerializedSize = n2 += this.unknownFields.getSerializedSize();
        return n2;
    }

    public static BinExport$Meta parseFrom(ByteString byteString) {
        return (BinExport$Meta)PARSER.parseFrom(byteString);
    }

    public static BinExport$Meta parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        return (BinExport$Meta)PARSER.parseFrom(byteString, extensionRegistryLite);
    }

    public static BinExport$Meta parseFrom(byte[] arrby) {
        return (BinExport$Meta)PARSER.parseFrom(arrby);
    }

    public static BinExport$Meta parseFrom(byte[] arrby, ExtensionRegistryLite extensionRegistryLite) {
        return (BinExport$Meta)PARSER.parseFrom(arrby, extensionRegistryLite);
    }

    public static BinExport$Meta parseFrom(InputStream inputStream) {
        return (BinExport$Meta)PARSER.parseFrom(inputStream);
    }

    public static BinExport$Meta parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (BinExport$Meta)PARSER.parseFrom(inputStream, extensionRegistryLite);
    }

    public static BinExport$Meta parseDelimitedFrom(InputStream inputStream) {
        return (BinExport$Meta)PARSER.parseDelimitedFrom(inputStream);
    }

    public static BinExport$Meta parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (BinExport$Meta)PARSER.parseDelimitedFrom(inputStream, extensionRegistryLite);
    }

    public static BinExport$Meta parseFrom(CodedInputStream codedInputStream) {
        return (BinExport$Meta)PARSER.parseFrom(codedInputStream);
    }

    public static BinExport$Meta parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (BinExport$Meta)PARSER.parseFrom(codedInputStream, extensionRegistryLite);
    }

    @Override
    public BinExport$Meta$Builder newBuilderForType() {
        return BinExport$Meta.newBuilder();
    }

    public static BinExport$Meta$Builder newBuilder() {
        return DEFAULT_INSTANCE.toBuilder();
    }

    public static BinExport$Meta$Builder newBuilder(BinExport$Meta binExport$Meta) {
        return DEFAULT_INSTANCE.toBuilder().mergeFrom(binExport$Meta);
    }

    @Override
    public BinExport$Meta$Builder toBuilder() {
        BinExport$Meta$Builder binExport$Meta$Builder;
        if (this == DEFAULT_INSTANCE) {
            binExport$Meta$Builder = new BinExport$Meta$Builder(null);
            return binExport$Meta$Builder;
        }
        binExport$Meta$Builder = new BinExport$Meta$Builder(null).mergeFrom(this);
        return binExport$Meta$Builder;
    }

    @Override
    protected BinExport$Meta$Builder newBuilderForType(GeneratedMessage$BuilderParent generatedMessage$BuilderParent) {
        return new BinExport$Meta$Builder(generatedMessage$BuilderParent, null);
    }

    public static BinExport$Meta getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    @Override
    public Parser getParserForType() {
        return PARSER;
    }

    @Override
    public BinExport$Meta getDefaultInstanceForType() {
        return DEFAULT_INSTANCE;
    }

    static /* synthetic */ boolean access$400() {
        return alwaysUseFieldBuilders;
    }

    /* synthetic */ BinExport$Meta(GeneratedMessage$Builder generatedMessage$Builder, BinExport$1 binExport$1) {
        this(generatedMessage$Builder);
    }

    static /* synthetic */ Object access$602(BinExport$Meta binExport$Meta, Object object) {
        binExport$Meta.inputBinary_ = object;
        return binExport$Meta.inputBinary_;
    }

    static /* synthetic */ ByteString access$702(BinExport$Meta binExport$Meta, ByteString byteString) {
        binExport$Meta.inputHash_ = byteString;
        return binExport$Meta.inputHash_;
    }

    static /* synthetic */ int access$802(BinExport$Meta binExport$Meta, int n2) {
        binExport$Meta.inputAddressSpace_ = n2;
        return binExport$Meta.inputAddressSpace_;
    }

    static /* synthetic */ Object access$902(BinExport$Meta binExport$Meta, Object object) {
        binExport$Meta.architectureName_ = object;
        return binExport$Meta.architectureName_;
    }

    static /* synthetic */ int access$1002(BinExport$Meta binExport$Meta, int n2) {
        binExport$Meta.maxMnemonicLen_ = n2;
        return binExport$Meta.maxMnemonicLen_;
    }

    static /* synthetic */ int access$1102(BinExport$Meta binExport$Meta, int n2) {
        binExport$Meta.numInstructions_ = n2;
        return binExport$Meta.numInstructions_;
    }

    static /* synthetic */ int access$1202(BinExport$Meta binExport$Meta, int n2) {
        binExport$Meta.numFunctions_ = n2;
        return binExport$Meta.numFunctions_;
    }

    static /* synthetic */ int access$1302(BinExport$Meta binExport$Meta, int n2) {
        binExport$Meta.numBasicblocks_ = n2;
        return binExport$Meta.numBasicblocks_;
    }

    static /* synthetic */ int access$1402(BinExport$Meta binExport$Meta, int n2) {
        binExport$Meta.numEdges_ = n2;
        return binExport$Meta.numEdges_;
    }

    static /* synthetic */ int access$1502(BinExport$Meta binExport$Meta, int n2) {
        binExport$Meta.bitField0_ = n2;
        return binExport$Meta.bitField0_;
    }

    static /* synthetic */ Object access$600(BinExport$Meta binExport$Meta) {
        return binExport$Meta.inputBinary_;
    }

    static /* synthetic */ Object access$900(BinExport$Meta binExport$Meta) {
        return binExport$Meta.architectureName_;
    }

    static /* synthetic */ UnknownFieldSet access$1600(BinExport$Meta binExport$Meta) {
        return binExport$Meta.unknownFields;
    }

    /* synthetic */ BinExport$Meta(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite, BinExport$1 binExport$1) {
        this(codedInputStream, extensionRegistryLite);
    }
}

