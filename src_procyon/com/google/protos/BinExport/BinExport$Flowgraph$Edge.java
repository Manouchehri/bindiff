package com.google.protos.BinExport;

import java.io.*;
import com.google.protobuf.*;

public final class BinExport$Flowgraph$Edge extends GeneratedMessage implements BinExport$Flowgraph$EdgeOrBuilder
{
    private int bitField0_;
    public static final int SOURCE_ADDRESS_FIELD_NUMBER = 1;
    private long sourceAddress_;
    public static final int TARGET_ADDRESS_FIELD_NUMBER = 2;
    private long targetAddress_;
    public static final int TYPE_FIELD_NUMBER = 3;
    private int type_;
    private byte memoizedIsInitialized;
    private int memoizedSerializedSize;
    private static final long serialVersionUID = 0L;
    private static final BinExport$Flowgraph$Edge DEFAULT_INSTANCE;
    public static final Parser PARSER;
    
    private BinExport$Flowgraph$Edge(final GeneratedMessage$Builder generatedMessage$Builder) {
        super(generatedMessage$Builder);
        this.memoizedIsInitialized = -1;
        this.memoizedSerializedSize = -1;
    }
    
    private BinExport$Flowgraph$Edge() {
        this.memoizedIsInitialized = -1;
        this.memoizedSerializedSize = -1;
        this.sourceAddress_ = 0L;
        this.targetAddress_ = 0L;
        this.type_ = 3;
    }
    
    @Override
    public final UnknownFieldSet getUnknownFields() {
        return this.unknownFields;
    }
    
    private BinExport$Flowgraph$Edge(final CodedInputStream codedInputStream, final ExtensionRegistryLite extensionRegistryLite) {
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
                        this.sourceAddress_ = codedInputStream.readUInt64();
                        continue;
                    }
                    case 16: {
                        this.bitField0_ |= 0x2;
                        this.targetAddress_ = codedInputStream.readUInt64();
                        continue;
                    }
                    case 24: {
                        final int enum1 = codedInputStream.readEnum();
                        if (BinExport$Flowgraph$Edge$EdgeType.valueOf(enum1) == null) {
                            builder.mergeVarintField(3, enum1);
                            continue;
                        }
                        this.bitField0_ |= 0x4;
                        this.type_ = enum1;
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
        return BinExport.internal_static_BinExport_Flowgraph_Edge_descriptor;
    }
    
    @Override
    protected GeneratedMessage$FieldAccessorTable internalGetFieldAccessorTable() {
        return BinExport.internal_static_BinExport_Flowgraph_Edge_fieldAccessorTable.ensureFieldAccessorsInitialized(BinExport$Flowgraph$Edge.class, BinExport$Flowgraph$Edge$Builder.class);
    }
    
    @Override
    public boolean hasSourceAddress() {
        return (this.bitField0_ & 0x1) == 0x1;
    }
    
    @Override
    public long getSourceAddress() {
        return this.sourceAddress_;
    }
    
    @Override
    public boolean hasTargetAddress() {
        return (this.bitField0_ & 0x2) == 0x2;
    }
    
    @Override
    public long getTargetAddress() {
        return this.targetAddress_;
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
    
    @Override
    public final boolean isInitialized() {
        final byte memoizedIsInitialized = this.memoizedIsInitialized;
        if (memoizedIsInitialized == 1) {
            return true;
        }
        if (memoizedIsInitialized == 0) {
            return false;
        }
        if (!this.hasSourceAddress()) {
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
            codedOutputStream.writeUInt64(1, this.sourceAddress_);
        }
        if ((this.bitField0_ & 0x2) == 0x2) {
            codedOutputStream.writeUInt64(2, this.targetAddress_);
        }
        if ((this.bitField0_ & 0x4) == 0x4) {
            codedOutputStream.writeEnum(3, this.type_);
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
            n += CodedOutputStream.computeUInt64Size(1, this.sourceAddress_);
        }
        if ((this.bitField0_ & 0x2) == 0x2) {
            n += CodedOutputStream.computeUInt64Size(2, this.targetAddress_);
        }
        if ((this.bitField0_ & 0x4) == 0x4) {
            n += CodedOutputStream.computeEnumSize(3, this.type_);
        }
        return this.memoizedSerializedSize = n + this.unknownFields.getSerializedSize();
    }
    
    public static BinExport$Flowgraph$Edge parseFrom(final ByteString byteString) {
        return (BinExport$Flowgraph$Edge)BinExport$Flowgraph$Edge.PARSER.parseFrom(byteString);
    }
    
    public static BinExport$Flowgraph$Edge parseFrom(final ByteString byteString, final ExtensionRegistryLite extensionRegistryLite) {
        return (BinExport$Flowgraph$Edge)BinExport$Flowgraph$Edge.PARSER.parseFrom(byteString, extensionRegistryLite);
    }
    
    public static BinExport$Flowgraph$Edge parseFrom(final byte[] array) {
        return (BinExport$Flowgraph$Edge)BinExport$Flowgraph$Edge.PARSER.parseFrom(array);
    }
    
    public static BinExport$Flowgraph$Edge parseFrom(final byte[] array, final ExtensionRegistryLite extensionRegistryLite) {
        return (BinExport$Flowgraph$Edge)BinExport$Flowgraph$Edge.PARSER.parseFrom(array, extensionRegistryLite);
    }
    
    public static BinExport$Flowgraph$Edge parseFrom(final InputStream inputStream) {
        return (BinExport$Flowgraph$Edge)BinExport$Flowgraph$Edge.PARSER.parseFrom(inputStream);
    }
    
    public static BinExport$Flowgraph$Edge parseFrom(final InputStream inputStream, final ExtensionRegistryLite extensionRegistryLite) {
        return (BinExport$Flowgraph$Edge)BinExport$Flowgraph$Edge.PARSER.parseFrom(inputStream, extensionRegistryLite);
    }
    
    public static BinExport$Flowgraph$Edge parseDelimitedFrom(final InputStream inputStream) {
        return (BinExport$Flowgraph$Edge)BinExport$Flowgraph$Edge.PARSER.parseDelimitedFrom(inputStream);
    }
    
    public static BinExport$Flowgraph$Edge parseDelimitedFrom(final InputStream inputStream, final ExtensionRegistryLite extensionRegistryLite) {
        return (BinExport$Flowgraph$Edge)BinExport$Flowgraph$Edge.PARSER.parseDelimitedFrom(inputStream, extensionRegistryLite);
    }
    
    public static BinExport$Flowgraph$Edge parseFrom(final CodedInputStream codedInputStream) {
        return (BinExport$Flowgraph$Edge)BinExport$Flowgraph$Edge.PARSER.parseFrom(codedInputStream);
    }
    
    public static BinExport$Flowgraph$Edge parseFrom(final CodedInputStream codedInputStream, final ExtensionRegistryLite extensionRegistryLite) {
        return (BinExport$Flowgraph$Edge)BinExport$Flowgraph$Edge.PARSER.parseFrom(codedInputStream, extensionRegistryLite);
    }
    
    @Override
    public BinExport$Flowgraph$Edge$Builder newBuilderForType() {
        return newBuilder();
    }
    
    public static BinExport$Flowgraph$Edge$Builder newBuilder() {
        return BinExport$Flowgraph$Edge.DEFAULT_INSTANCE.toBuilder();
    }
    
    public static BinExport$Flowgraph$Edge$Builder newBuilder(final BinExport$Flowgraph$Edge binExport$Flowgraph$Edge) {
        return BinExport$Flowgraph$Edge.DEFAULT_INSTANCE.toBuilder().mergeFrom(binExport$Flowgraph$Edge);
    }
    
    @Override
    public BinExport$Flowgraph$Edge$Builder toBuilder() {
        return (this == BinExport$Flowgraph$Edge.DEFAULT_INSTANCE) ? new BinExport$Flowgraph$Edge$Builder((BinExport$1)null) : new BinExport$Flowgraph$Edge$Builder((BinExport$1)null).mergeFrom(this);
    }
    
    @Override
    protected BinExport$Flowgraph$Edge$Builder newBuilderForType(final GeneratedMessage$BuilderParent generatedMessage$BuilderParent) {
        return new BinExport$Flowgraph$Edge$Builder(generatedMessage$BuilderParent, null);
    }
    
    public static BinExport$Flowgraph$Edge getDefaultInstance() {
        return BinExport$Flowgraph$Edge.DEFAULT_INSTANCE;
    }
    
    @Override
    public Parser getParserForType() {
        return BinExport$Flowgraph$Edge.PARSER;
    }
    
    @Override
    public BinExport$Flowgraph$Edge getDefaultInstanceForType() {
        return BinExport$Flowgraph$Edge.DEFAULT_INSTANCE;
    }
    
    static {
        DEFAULT_INSTANCE = new BinExport$Flowgraph$Edge();
        PARSER = new BinExport$Flowgraph$Edge$1();
    }
}
