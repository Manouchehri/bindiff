package com.google.protos.BinExport;

import java.io.*;
import com.google.protobuf.*;

public final class BinExport$Callgraph$Edge extends GeneratedMessage implements BinExport$Callgraph$EdgeOrBuilder
{
    private int bitField0_;
    public static final int SOURCE_FUNCTION_ADDRESS_FIELD_NUMBER = 1;
    private long sourceFunctionAddress_;
    public static final int SOURCE_INSTRUCTION_ADDRESS_FIELD_NUMBER = 2;
    private long sourceInstructionAddress_;
    public static final int TARGET_ADDRESS_FIELD_NUMBER = 3;
    private long targetAddress_;
    private byte memoizedIsInitialized;
    private int memoizedSerializedSize;
    private static final long serialVersionUID = 0L;
    private static final BinExport$Callgraph$Edge DEFAULT_INSTANCE;
    public static final Parser PARSER;
    
    private BinExport$Callgraph$Edge(final GeneratedMessage$Builder generatedMessage$Builder) {
        super(generatedMessage$Builder);
        this.memoizedIsInitialized = -1;
        this.memoizedSerializedSize = -1;
    }
    
    private BinExport$Callgraph$Edge() {
        this.memoizedIsInitialized = -1;
        this.memoizedSerializedSize = -1;
        this.sourceFunctionAddress_ = 0L;
        this.sourceInstructionAddress_ = 0L;
        this.targetAddress_ = 0L;
    }
    
    @Override
    public final UnknownFieldSet getUnknownFields() {
        return this.unknownFields;
    }
    
    private BinExport$Callgraph$Edge(final CodedInputStream codedInputStream, final ExtensionRegistryLite extensionRegistryLite) {
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
                    case 8: {
                        this.bitField0_ |= 0x1;
                        this.sourceFunctionAddress_ = codedInputStream.readUInt64();
                        continue;
                    }
                    case 16: {
                        this.bitField0_ |= 0x2;
                        this.sourceInstructionAddress_ = codedInputStream.readUInt64();
                        continue;
                    }
                    case 24: {
                        this.bitField0_ |= 0x4;
                        this.targetAddress_ = codedInputStream.readUInt64();
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
        return BinExport.internal_static_BinExport_Callgraph_Edge_descriptor;
    }
    
    @Override
    protected GeneratedMessage$FieldAccessorTable internalGetFieldAccessorTable() {
        return BinExport.internal_static_BinExport_Callgraph_Edge_fieldAccessorTable.ensureFieldAccessorsInitialized(BinExport$Callgraph$Edge.class, BinExport$Callgraph$Edge$Builder.class);
    }
    
    @Override
    public boolean hasSourceFunctionAddress() {
        return (this.bitField0_ & 0x1) == 0x1;
    }
    
    @Override
    public long getSourceFunctionAddress() {
        return this.sourceFunctionAddress_;
    }
    
    @Override
    public boolean hasSourceInstructionAddress() {
        return (this.bitField0_ & 0x2) == 0x2;
    }
    
    @Override
    public long getSourceInstructionAddress() {
        return this.sourceInstructionAddress_;
    }
    
    @Override
    public boolean hasTargetAddress() {
        return (this.bitField0_ & 0x4) == 0x4;
    }
    
    @Override
    public long getTargetAddress() {
        return this.targetAddress_;
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
        if (!this.hasSourceFunctionAddress()) {
            this.memoizedIsInitialized = 0;
            return false;
        }
        if (!this.hasSourceInstructionAddress()) {
            this.memoizedIsInitialized = 0;
            return false;
        }
        if (!this.hasTargetAddress()) {
            this.memoizedIsInitialized = 0;
            return false;
        }
        this.memoizedIsInitialized = 1;
        return true;
    }
    
    @Override
    public void writeTo(final CodedOutputStream codedOutputStream) {
        if ((this.bitField0_ & 0x1) == 0x1) {
            codedOutputStream.writeUInt64(1, this.sourceFunctionAddress_);
        }
        if ((this.bitField0_ & 0x2) == 0x2) {
            codedOutputStream.writeUInt64(2, this.sourceInstructionAddress_);
        }
        if ((this.bitField0_ & 0x4) == 0x4) {
            codedOutputStream.writeUInt64(3, this.targetAddress_);
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
            n += CodedOutputStream.computeUInt64Size(1, this.sourceFunctionAddress_);
        }
        if ((this.bitField0_ & 0x2) == 0x2) {
            n += CodedOutputStream.computeUInt64Size(2, this.sourceInstructionAddress_);
        }
        if ((this.bitField0_ & 0x4) == 0x4) {
            n += CodedOutputStream.computeUInt64Size(3, this.targetAddress_);
        }
        return this.memoizedSerializedSize = n + this.unknownFields.getSerializedSize();
    }
    
    public static BinExport$Callgraph$Edge parseFrom(final ByteString byteString) {
        return (BinExport$Callgraph$Edge)BinExport$Callgraph$Edge.PARSER.parseFrom(byteString);
    }
    
    public static BinExport$Callgraph$Edge parseFrom(final ByteString byteString, final ExtensionRegistryLite extensionRegistryLite) {
        return (BinExport$Callgraph$Edge)BinExport$Callgraph$Edge.PARSER.parseFrom(byteString, extensionRegistryLite);
    }
    
    public static BinExport$Callgraph$Edge parseFrom(final byte[] array) {
        return (BinExport$Callgraph$Edge)BinExport$Callgraph$Edge.PARSER.parseFrom(array);
    }
    
    public static BinExport$Callgraph$Edge parseFrom(final byte[] array, final ExtensionRegistryLite extensionRegistryLite) {
        return (BinExport$Callgraph$Edge)BinExport$Callgraph$Edge.PARSER.parseFrom(array, extensionRegistryLite);
    }
    
    public static BinExport$Callgraph$Edge parseFrom(final InputStream inputStream) {
        return (BinExport$Callgraph$Edge)BinExport$Callgraph$Edge.PARSER.parseFrom(inputStream);
    }
    
    public static BinExport$Callgraph$Edge parseFrom(final InputStream inputStream, final ExtensionRegistryLite extensionRegistryLite) {
        return (BinExport$Callgraph$Edge)BinExport$Callgraph$Edge.PARSER.parseFrom(inputStream, extensionRegistryLite);
    }
    
    public static BinExport$Callgraph$Edge parseDelimitedFrom(final InputStream inputStream) {
        return (BinExport$Callgraph$Edge)BinExport$Callgraph$Edge.PARSER.parseDelimitedFrom(inputStream);
    }
    
    public static BinExport$Callgraph$Edge parseDelimitedFrom(final InputStream inputStream, final ExtensionRegistryLite extensionRegistryLite) {
        return (BinExport$Callgraph$Edge)BinExport$Callgraph$Edge.PARSER.parseDelimitedFrom(inputStream, extensionRegistryLite);
    }
    
    public static BinExport$Callgraph$Edge parseFrom(final CodedInputStream codedInputStream) {
        return (BinExport$Callgraph$Edge)BinExport$Callgraph$Edge.PARSER.parseFrom(codedInputStream);
    }
    
    public static BinExport$Callgraph$Edge parseFrom(final CodedInputStream codedInputStream, final ExtensionRegistryLite extensionRegistryLite) {
        return (BinExport$Callgraph$Edge)BinExport$Callgraph$Edge.PARSER.parseFrom(codedInputStream, extensionRegistryLite);
    }
    
    @Override
    public BinExport$Callgraph$Edge$Builder newBuilderForType() {
        return newBuilder();
    }
    
    public static BinExport$Callgraph$Edge$Builder newBuilder() {
        return BinExport$Callgraph$Edge.DEFAULT_INSTANCE.toBuilder();
    }
    
    public static BinExport$Callgraph$Edge$Builder newBuilder(final BinExport$Callgraph$Edge binExport$Callgraph$Edge) {
        return BinExport$Callgraph$Edge.DEFAULT_INSTANCE.toBuilder().mergeFrom(binExport$Callgraph$Edge);
    }
    
    @Override
    public BinExport$Callgraph$Edge$Builder toBuilder() {
        return (this == BinExport$Callgraph$Edge.DEFAULT_INSTANCE) ? new BinExport$Callgraph$Edge$Builder((BinExport$1)null) : new BinExport$Callgraph$Edge$Builder((BinExport$1)null).mergeFrom(this);
    }
    
    @Override
    protected BinExport$Callgraph$Edge$Builder newBuilderForType(final GeneratedMessage$BuilderParent generatedMessage$BuilderParent) {
        return new BinExport$Callgraph$Edge$Builder(generatedMessage$BuilderParent, null);
    }
    
    public static BinExport$Callgraph$Edge getDefaultInstance() {
        return BinExport$Callgraph$Edge.DEFAULT_INSTANCE;
    }
    
    @Override
    public Parser getParserForType() {
        return BinExport$Callgraph$Edge.PARSER;
    }
    
    @Override
    public BinExport$Callgraph$Edge getDefaultInstanceForType() {
        return BinExport$Callgraph$Edge.DEFAULT_INSTANCE;
    }
    
    static {
        DEFAULT_INSTANCE = new BinExport$Callgraph$Edge();
        PARSER = new BinExport$Callgraph$Edge$1();
    }
}
