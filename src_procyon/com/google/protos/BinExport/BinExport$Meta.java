package com.google.protos.BinExport;

import java.io.*;
import com.google.protobuf.*;

public final class BinExport$Meta extends GeneratedMessage implements BinExport$MetaOrBuilder
{
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
    private byte memoizedIsInitialized;
    private int memoizedSerializedSize;
    private static final long serialVersionUID = 0L;
    private static final BinExport$Meta DEFAULT_INSTANCE;
    public static final Parser PARSER;
    
    private BinExport$Meta(final GeneratedMessage$Builder generatedMessage$Builder) {
        super(generatedMessage$Builder);
        this.memoizedIsInitialized = -1;
        this.memoizedSerializedSize = -1;
    }
    
    private BinExport$Meta() {
        this.memoizedIsInitialized = -1;
        this.memoizedSerializedSize = -1;
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
    
    private BinExport$Meta(final CodedInputStream codedInputStream, final ExtensionRegistryLite extensionRegistryLite) {
        this();
        final UnknownFieldSet$Builder builder = UnknownFieldSet.newBuilder();
        try {
            int i = 0;
            while (i == 0) {
                final int tag = codedInputStream.readTag();
                switch (tag) {
                    case 0: {
                        i = 1;
                        continue;
                    }
                    default: {
                        if (!this.parseUnknownField(codedInputStream, builder, extensionRegistryLite, tag)) {
                            i = 1;
                            continue;
                        }
                        continue;
                    }
                    case 10: {
                        final ByteString bytes = codedInputStream.readBytes();
                        this.bitField0_ |= 0x1;
                        this.inputBinary_ = bytes;
                        continue;
                    }
                    case 18: {
                        this.bitField0_ |= 0x2;
                        this.inputHash_ = codedInputStream.readBytes();
                        continue;
                    }
                    case 24: {
                        this.bitField0_ |= 0x4;
                        this.inputAddressSpace_ = codedInputStream.readUInt32();
                        continue;
                    }
                    case 34: {
                        final ByteString bytes2 = codedInputStream.readBytes();
                        this.bitField0_ |= 0x8;
                        this.architectureName_ = bytes2;
                        continue;
                    }
                    case 40: {
                        this.bitField0_ |= 0x10;
                        this.maxMnemonicLen_ = codedInputStream.readUInt32();
                        continue;
                    }
                    case 48: {
                        this.bitField0_ |= 0x20;
                        this.numInstructions_ = codedInputStream.readUInt32();
                        continue;
                    }
                    case 56: {
                        this.bitField0_ |= 0x40;
                        this.numFunctions_ = codedInputStream.readUInt32();
                        continue;
                    }
                    case 64: {
                        this.bitField0_ |= 0x80;
                        this.numBasicblocks_ = codedInputStream.readUInt32();
                        continue;
                    }
                    case 72: {
                        this.bitField0_ |= 0x100;
                        this.numEdges_ = codedInputStream.readUInt32();
                        continue;
                    }
                }
            }
        }
        catch (InvalidProtocolBufferException ex) {
            throw new RuntimeException(ex.setUnfinishedMessage(this));
        }
        catch (IOException ex2) {
            throw new RuntimeException(new InvalidProtocolBufferException(ex2.getMessage()).setUnfinishedMessage(this));
        }
        finally {
            this.unknownFields = builder.build();
            this.makeExtensionsImmutable();
        }
    }
    
    public static final Descriptors$Descriptor getDescriptor() {
        return BinExport.internal_static_BinExport_Meta_descriptor;
    }
    
    @Override
    protected GeneratedMessage$FieldAccessorTable internalGetFieldAccessorTable() {
        return BinExport.internal_static_BinExport_Meta_fieldAccessorTable.ensureFieldAccessorsInitialized(BinExport$Meta.class, BinExport$Meta$Builder.class);
    }
    
    @Override
    public boolean hasInputBinary() {
        return (this.bitField0_ & 0x1) == 0x1;
    }
    
    @Override
    public String getInputBinary() {
        final Object inputBinary_ = this.inputBinary_;
        if (inputBinary_ instanceof String) {
            return (String)inputBinary_;
        }
        final ByteString byteString = (ByteString)inputBinary_;
        final String stringUtf8 = byteString.toStringUtf8();
        if (byteString.isValidUtf8()) {
            this.inputBinary_ = stringUtf8;
        }
        return stringUtf8;
    }
    
    @Override
    public ByteString getInputBinaryBytes() {
        final Object inputBinary_ = this.inputBinary_;
        if (inputBinary_ instanceof String) {
            return (ByteString)(this.inputBinary_ = ByteString.copyFromUtf8((String)inputBinary_));
        }
        return (ByteString)inputBinary_;
    }
    
    @Override
    public boolean hasInputHash() {
        return (this.bitField0_ & 0x2) == 0x2;
    }
    
    @Override
    public ByteString getInputHash() {
        return this.inputHash_;
    }
    
    @Override
    public boolean hasInputAddressSpace() {
        return (this.bitField0_ & 0x4) == 0x4;
    }
    
    @Override
    public int getInputAddressSpace() {
        return this.inputAddressSpace_;
    }
    
    @Override
    public boolean hasArchitectureName() {
        return (this.bitField0_ & 0x8) == 0x8;
    }
    
    @Override
    public String getArchitectureName() {
        final Object architectureName_ = this.architectureName_;
        if (architectureName_ instanceof String) {
            return (String)architectureName_;
        }
        final ByteString byteString = (ByteString)architectureName_;
        final String stringUtf8 = byteString.toStringUtf8();
        if (byteString.isValidUtf8()) {
            this.architectureName_ = stringUtf8;
        }
        return stringUtf8;
    }
    
    @Override
    public ByteString getArchitectureNameBytes() {
        final Object architectureName_ = this.architectureName_;
        if (architectureName_ instanceof String) {
            return (ByteString)(this.architectureName_ = ByteString.copyFromUtf8((String)architectureName_));
        }
        return (ByteString)architectureName_;
    }
    
    @Override
    public boolean hasMaxMnemonicLen() {
        return (this.bitField0_ & 0x10) == 0x10;
    }
    
    @Override
    public int getMaxMnemonicLen() {
        return this.maxMnemonicLen_;
    }
    
    @Override
    public boolean hasNumInstructions() {
        return (this.bitField0_ & 0x20) == 0x20;
    }
    
    @Override
    public int getNumInstructions() {
        return this.numInstructions_;
    }
    
    @Override
    public boolean hasNumFunctions() {
        return (this.bitField0_ & 0x40) == 0x40;
    }
    
    @Override
    public int getNumFunctions() {
        return this.numFunctions_;
    }
    
    @Override
    public boolean hasNumBasicblocks() {
        return (this.bitField0_ & 0x80) == 0x80;
    }
    
    @Override
    public int getNumBasicblocks() {
        return this.numBasicblocks_;
    }
    
    @Override
    public boolean hasNumEdges() {
        return (this.bitField0_ & 0x100) == 0x100;
    }
    
    @Override
    public int getNumEdges() {
        return this.numEdges_;
    }
    
    @Override
    public final boolean isInitialized() {
        final byte memoizedIsInitialized = this.memoizedIsInitialized;
        if (memoizedIsInitialized == 1) {
            return true;
        }
        if (memoizedIsInitialized == 0) {
            return false;
        }
        this.memoizedIsInitialized = 1;
        return true;
    }
    
    @Override
    public void writeTo(final CodedOutputStream codedOutputStream) {
        if ((this.bitField0_ & 0x1) == 0x1) {
            codedOutputStream.writeBytes(1, this.getInputBinaryBytes());
        }
        if ((this.bitField0_ & 0x2) == 0x2) {
            codedOutputStream.writeBytes(2, this.inputHash_);
        }
        if ((this.bitField0_ & 0x4) == 0x4) {
            codedOutputStream.writeUInt32(3, this.inputAddressSpace_);
        }
        if ((this.bitField0_ & 0x8) == 0x8) {
            codedOutputStream.writeBytes(4, this.getArchitectureNameBytes());
        }
        if ((this.bitField0_ & 0x10) == 0x10) {
            codedOutputStream.writeUInt32(5, this.maxMnemonicLen_);
        }
        if ((this.bitField0_ & 0x20) == 0x20) {
            codedOutputStream.writeUInt32(6, this.numInstructions_);
        }
        if ((this.bitField0_ & 0x40) == 0x40) {
            codedOutputStream.writeUInt32(7, this.numFunctions_);
        }
        if ((this.bitField0_ & 0x80) == 0x80) {
            codedOutputStream.writeUInt32(8, this.numBasicblocks_);
        }
        if ((this.bitField0_ & 0x100) == 0x100) {
            codedOutputStream.writeUInt32(9, this.numEdges_);
        }
        this.unknownFields.writeTo(codedOutputStream);
    }
    
    @Override
    public int getSerializedSize() {
        final int memoizedSerializedSize = this.memoizedSerializedSize;
        if (memoizedSerializedSize != -1) {
            return memoizedSerializedSize;
        }
        int n = 0;
        if ((this.bitField0_ & 0x1) == 0x1) {
            n += CodedOutputStream.computeBytesSize(1, this.getInputBinaryBytes());
        }
        if ((this.bitField0_ & 0x2) == 0x2) {
            n += CodedOutputStream.computeBytesSize(2, this.inputHash_);
        }
        if ((this.bitField0_ & 0x4) == 0x4) {
            n += CodedOutputStream.computeUInt32Size(3, this.inputAddressSpace_);
        }
        if ((this.bitField0_ & 0x8) == 0x8) {
            n += CodedOutputStream.computeBytesSize(4, this.getArchitectureNameBytes());
        }
        if ((this.bitField0_ & 0x10) == 0x10) {
            n += CodedOutputStream.computeUInt32Size(5, this.maxMnemonicLen_);
        }
        if ((this.bitField0_ & 0x20) == 0x20) {
            n += CodedOutputStream.computeUInt32Size(6, this.numInstructions_);
        }
        if ((this.bitField0_ & 0x40) == 0x40) {
            n += CodedOutputStream.computeUInt32Size(7, this.numFunctions_);
        }
        if ((this.bitField0_ & 0x80) == 0x80) {
            n += CodedOutputStream.computeUInt32Size(8, this.numBasicblocks_);
        }
        if ((this.bitField0_ & 0x100) == 0x100) {
            n += CodedOutputStream.computeUInt32Size(9, this.numEdges_);
        }
        return this.memoizedSerializedSize = n + this.unknownFields.getSerializedSize();
    }
    
    public static BinExport$Meta parseFrom(final ByteString byteString) {
        return (BinExport$Meta)BinExport$Meta.PARSER.parseFrom(byteString);
    }
    
    public static BinExport$Meta parseFrom(final ByteString byteString, final ExtensionRegistryLite extensionRegistryLite) {
        return (BinExport$Meta)BinExport$Meta.PARSER.parseFrom(byteString, extensionRegistryLite);
    }
    
    public static BinExport$Meta parseFrom(final byte[] array) {
        return (BinExport$Meta)BinExport$Meta.PARSER.parseFrom(array);
    }
    
    public static BinExport$Meta parseFrom(final byte[] array, final ExtensionRegistryLite extensionRegistryLite) {
        return (BinExport$Meta)BinExport$Meta.PARSER.parseFrom(array, extensionRegistryLite);
    }
    
    public static BinExport$Meta parseFrom(final InputStream inputStream) {
        return (BinExport$Meta)BinExport$Meta.PARSER.parseFrom(inputStream);
    }
    
    public static BinExport$Meta parseFrom(final InputStream inputStream, final ExtensionRegistryLite extensionRegistryLite) {
        return (BinExport$Meta)BinExport$Meta.PARSER.parseFrom(inputStream, extensionRegistryLite);
    }
    
    public static BinExport$Meta parseDelimitedFrom(final InputStream inputStream) {
        return (BinExport$Meta)BinExport$Meta.PARSER.parseDelimitedFrom(inputStream);
    }
    
    public static BinExport$Meta parseDelimitedFrom(final InputStream inputStream, final ExtensionRegistryLite extensionRegistryLite) {
        return (BinExport$Meta)BinExport$Meta.PARSER.parseDelimitedFrom(inputStream, extensionRegistryLite);
    }
    
    public static BinExport$Meta parseFrom(final CodedInputStream codedInputStream) {
        return (BinExport$Meta)BinExport$Meta.PARSER.parseFrom(codedInputStream);
    }
    
    public static BinExport$Meta parseFrom(final CodedInputStream codedInputStream, final ExtensionRegistryLite extensionRegistryLite) {
        return (BinExport$Meta)BinExport$Meta.PARSER.parseFrom(codedInputStream, extensionRegistryLite);
    }
    
    @Override
    public BinExport$Meta$Builder newBuilderForType() {
        return newBuilder();
    }
    
    public static BinExport$Meta$Builder newBuilder() {
        return BinExport$Meta.DEFAULT_INSTANCE.toBuilder();
    }
    
    public static BinExport$Meta$Builder newBuilder(final BinExport$Meta binExport$Meta) {
        return BinExport$Meta.DEFAULT_INSTANCE.toBuilder().mergeFrom(binExport$Meta);
    }
    
    @Override
    public BinExport$Meta$Builder toBuilder() {
        return (this == BinExport$Meta.DEFAULT_INSTANCE) ? new BinExport$Meta$Builder((BinExport$1)null) : new BinExport$Meta$Builder((BinExport$1)null).mergeFrom(this);
    }
    
    @Override
    protected BinExport$Meta$Builder newBuilderForType(final GeneratedMessage$BuilderParent generatedMessage$BuilderParent) {
        return new BinExport$Meta$Builder(generatedMessage$BuilderParent, null);
    }
    
    public static BinExport$Meta getDefaultInstance() {
        return BinExport$Meta.DEFAULT_INSTANCE;
    }
    
    @Override
    public Parser getParserForType() {
        return BinExport$Meta.PARSER;
    }
    
    @Override
    public BinExport$Meta getDefaultInstanceForType() {
        return BinExport$Meta.DEFAULT_INSTANCE;
    }
    
    static {
        DEFAULT_INSTANCE = new BinExport$Meta();
        PARSER = new BinExport$Meta$1();
    }
}
