package com.google.protos.BinExport;

import java.io.*;
import com.google.protobuf.*;

public final class BinExport$Callgraph$Vertex extends GeneratedMessage implements BinExport$Callgraph$VertexOrBuilder
{
    private int bitField0_;
    public static final int ADDRESS_FIELD_NUMBER = 1;
    private long address_;
    public static final int PRIME_FIELD_NUMBER = 2;
    private long prime_;
    public static final int FUNCTION_TYPE_FIELD_NUMBER = 3;
    private int functionType_;
    public static final int HAS_REAL_NAME_FIELD_NUMBER = 4;
    private boolean hasRealName_;
    public static final int MANGLED_NAME_FIELD_NUMBER = 5;
    private volatile Object mangledName_;
    public static final int DEMANGLED_NAME_FIELD_NUMBER = 6;
    private volatile Object demangledName_;
    private byte memoizedIsInitialized;
    private int memoizedSerializedSize;
    private static final long serialVersionUID = 0L;
    private static final BinExport$Callgraph$Vertex DEFAULT_INSTANCE;
    public static final Parser PARSER;
    
    private BinExport$Callgraph$Vertex(final GeneratedMessage$Builder generatedMessage$Builder) {
        super(generatedMessage$Builder);
        this.memoizedIsInitialized = -1;
        this.memoizedSerializedSize = -1;
    }
    
    private BinExport$Callgraph$Vertex() {
        this.memoizedIsInitialized = -1;
        this.memoizedSerializedSize = -1;
        this.address_ = 0L;
        this.prime_ = 0L;
        this.functionType_ = 0;
        this.hasRealName_ = false;
        this.mangledName_ = "";
        this.demangledName_ = "";
    }
    
    @Override
    public final UnknownFieldSet getUnknownFields() {
        return this.unknownFields;
    }
    
    private BinExport$Callgraph$Vertex(final CodedInputStream codedInputStream, final ExtensionRegistryLite extensionRegistryLite) {
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
                        this.address_ = codedInputStream.readUInt64();
                        continue;
                    }
                    case 16: {
                        this.bitField0_ |= 0x2;
                        this.prime_ = codedInputStream.readUInt64();
                        continue;
                    }
                    case 24: {
                        final int enum1 = codedInputStream.readEnum();
                        if (BinExport$Callgraph$Vertex$FunctionType.valueOf(enum1) == null) {
                            builder.mergeVarintField(3, enum1);
                            continue;
                        }
                        this.bitField0_ |= 0x4;
                        this.functionType_ = enum1;
                        continue;
                    }
                    case 32: {
                        this.bitField0_ |= 0x8;
                        this.hasRealName_ = codedInputStream.readBool();
                        continue;
                    }
                    case 42: {
                        final ByteString bytes = codedInputStream.readBytes();
                        this.bitField0_ |= 0x10;
                        this.mangledName_ = bytes;
                        continue;
                    }
                    case 50: {
                        final ByteString bytes2 = codedInputStream.readBytes();
                        this.bitField0_ |= 0x20;
                        this.demangledName_ = bytes2;
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
        return BinExport.internal_static_BinExport_Callgraph_Vertex_descriptor;
    }
    
    @Override
    protected GeneratedMessage$FieldAccessorTable internalGetFieldAccessorTable() {
        return BinExport.internal_static_BinExport_Callgraph_Vertex_fieldAccessorTable.ensureFieldAccessorsInitialized(BinExport$Callgraph$Vertex.class, BinExport$Callgraph$Vertex$Builder.class);
    }
    
    @Override
    public boolean hasAddress() {
        return (this.bitField0_ & 0x1) == 0x1;
    }
    
    @Override
    public long getAddress() {
        return this.address_;
    }
    
    @Override
    public boolean hasPrime() {
        return (this.bitField0_ & 0x2) == 0x2;
    }
    
    @Override
    public long getPrime() {
        return this.prime_;
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
    
    @Override
    public boolean hasHasRealName() {
        return (this.bitField0_ & 0x8) == 0x8;
    }
    
    @Override
    public boolean getHasRealName() {
        return this.hasRealName_;
    }
    
    @Override
    public boolean hasMangledName() {
        return (this.bitField0_ & 0x10) == 0x10;
    }
    
    @Override
    public String getMangledName() {
        final Object mangledName_ = this.mangledName_;
        if (mangledName_ instanceof String) {
            return (String)mangledName_;
        }
        final ByteString byteString = (ByteString)mangledName_;
        final String stringUtf8 = byteString.toStringUtf8();
        if (byteString.isValidUtf8()) {
            this.mangledName_ = stringUtf8;
        }
        return stringUtf8;
    }
    
    @Override
    public ByteString getMangledNameBytes() {
        final Object mangledName_ = this.mangledName_;
        if (mangledName_ instanceof String) {
            return (ByteString)(this.mangledName_ = ByteString.copyFromUtf8((String)mangledName_));
        }
        return (ByteString)mangledName_;
    }
    
    @Override
    public boolean hasDemangledName() {
        return (this.bitField0_ & 0x20) == 0x20;
    }
    
    @Override
    public String getDemangledName() {
        final Object demangledName_ = this.demangledName_;
        if (demangledName_ instanceof String) {
            return (String)demangledName_;
        }
        final ByteString byteString = (ByteString)demangledName_;
        final String stringUtf8 = byteString.toStringUtf8();
        if (byteString.isValidUtf8()) {
            this.demangledName_ = stringUtf8;
        }
        return stringUtf8;
    }
    
    @Override
    public ByteString getDemangledNameBytes() {
        final Object demangledName_ = this.demangledName_;
        if (demangledName_ instanceof String) {
            return (ByteString)(this.demangledName_ = ByteString.copyFromUtf8((String)demangledName_));
        }
        return (ByteString)demangledName_;
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
        if (!this.hasAddress()) {
            this.memoizedIsInitialized = 0;
            return false;
        }
        if (!this.hasPrime()) {
            this.memoizedIsInitialized = 0;
            return false;
        }
        this.memoizedIsInitialized = 1;
        return true;
    }
    
    @Override
    public void writeTo(final CodedOutputStream codedOutputStream) {
        if ((this.bitField0_ & 0x1) == 0x1) {
            codedOutputStream.writeUInt64(1, this.address_);
        }
        if ((this.bitField0_ & 0x2) == 0x2) {
            codedOutputStream.writeUInt64(2, this.prime_);
        }
        if ((this.bitField0_ & 0x4) == 0x4) {
            codedOutputStream.writeEnum(3, this.functionType_);
        }
        if ((this.bitField0_ & 0x8) == 0x8) {
            codedOutputStream.writeBool(4, this.hasRealName_);
        }
        if ((this.bitField0_ & 0x10) == 0x10) {
            codedOutputStream.writeBytes(5, this.getMangledNameBytes());
        }
        if ((this.bitField0_ & 0x20) == 0x20) {
            codedOutputStream.writeBytes(6, this.getDemangledNameBytes());
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
            n += CodedOutputStream.computeUInt64Size(1, this.address_);
        }
        if ((this.bitField0_ & 0x2) == 0x2) {
            n += CodedOutputStream.computeUInt64Size(2, this.prime_);
        }
        if ((this.bitField0_ & 0x4) == 0x4) {
            n += CodedOutputStream.computeEnumSize(3, this.functionType_);
        }
        if ((this.bitField0_ & 0x8) == 0x8) {
            n += CodedOutputStream.computeBoolSize(4, this.hasRealName_);
        }
        if ((this.bitField0_ & 0x10) == 0x10) {
            n += CodedOutputStream.computeBytesSize(5, this.getMangledNameBytes());
        }
        if ((this.bitField0_ & 0x20) == 0x20) {
            n += CodedOutputStream.computeBytesSize(6, this.getDemangledNameBytes());
        }
        return this.memoizedSerializedSize = n + this.unknownFields.getSerializedSize();
    }
    
    public static BinExport$Callgraph$Vertex parseFrom(final ByteString byteString) {
        return (BinExport$Callgraph$Vertex)BinExport$Callgraph$Vertex.PARSER.parseFrom(byteString);
    }
    
    public static BinExport$Callgraph$Vertex parseFrom(final ByteString byteString, final ExtensionRegistryLite extensionRegistryLite) {
        return (BinExport$Callgraph$Vertex)BinExport$Callgraph$Vertex.PARSER.parseFrom(byteString, extensionRegistryLite);
    }
    
    public static BinExport$Callgraph$Vertex parseFrom(final byte[] array) {
        return (BinExport$Callgraph$Vertex)BinExport$Callgraph$Vertex.PARSER.parseFrom(array);
    }
    
    public static BinExport$Callgraph$Vertex parseFrom(final byte[] array, final ExtensionRegistryLite extensionRegistryLite) {
        return (BinExport$Callgraph$Vertex)BinExport$Callgraph$Vertex.PARSER.parseFrom(array, extensionRegistryLite);
    }
    
    public static BinExport$Callgraph$Vertex parseFrom(final InputStream inputStream) {
        return (BinExport$Callgraph$Vertex)BinExport$Callgraph$Vertex.PARSER.parseFrom(inputStream);
    }
    
    public static BinExport$Callgraph$Vertex parseFrom(final InputStream inputStream, final ExtensionRegistryLite extensionRegistryLite) {
        return (BinExport$Callgraph$Vertex)BinExport$Callgraph$Vertex.PARSER.parseFrom(inputStream, extensionRegistryLite);
    }
    
    public static BinExport$Callgraph$Vertex parseDelimitedFrom(final InputStream inputStream) {
        return (BinExport$Callgraph$Vertex)BinExport$Callgraph$Vertex.PARSER.parseDelimitedFrom(inputStream);
    }
    
    public static BinExport$Callgraph$Vertex parseDelimitedFrom(final InputStream inputStream, final ExtensionRegistryLite extensionRegistryLite) {
        return (BinExport$Callgraph$Vertex)BinExport$Callgraph$Vertex.PARSER.parseDelimitedFrom(inputStream, extensionRegistryLite);
    }
    
    public static BinExport$Callgraph$Vertex parseFrom(final CodedInputStream codedInputStream) {
        return (BinExport$Callgraph$Vertex)BinExport$Callgraph$Vertex.PARSER.parseFrom(codedInputStream);
    }
    
    public static BinExport$Callgraph$Vertex parseFrom(final CodedInputStream codedInputStream, final ExtensionRegistryLite extensionRegistryLite) {
        return (BinExport$Callgraph$Vertex)BinExport$Callgraph$Vertex.PARSER.parseFrom(codedInputStream, extensionRegistryLite);
    }
    
    @Override
    public BinExport$Callgraph$Vertex$Builder newBuilderForType() {
        return newBuilder();
    }
    
    public static BinExport$Callgraph$Vertex$Builder newBuilder() {
        return BinExport$Callgraph$Vertex.DEFAULT_INSTANCE.toBuilder();
    }
    
    public static BinExport$Callgraph$Vertex$Builder newBuilder(final BinExport$Callgraph$Vertex binExport$Callgraph$Vertex) {
        return BinExport$Callgraph$Vertex.DEFAULT_INSTANCE.toBuilder().mergeFrom(binExport$Callgraph$Vertex);
    }
    
    @Override
    public BinExport$Callgraph$Vertex$Builder toBuilder() {
        return (this == BinExport$Callgraph$Vertex.DEFAULT_INSTANCE) ? new BinExport$Callgraph$Vertex$Builder((BinExport$1)null) : new BinExport$Callgraph$Vertex$Builder((BinExport$1)null).mergeFrom(this);
    }
    
    @Override
    protected BinExport$Callgraph$Vertex$Builder newBuilderForType(final GeneratedMessage$BuilderParent generatedMessage$BuilderParent) {
        return new BinExport$Callgraph$Vertex$Builder(generatedMessage$BuilderParent, null);
    }
    
    public static BinExport$Callgraph$Vertex getDefaultInstance() {
        return BinExport$Callgraph$Vertex.DEFAULT_INSTANCE;
    }
    
    @Override
    public Parser getParserForType() {
        return BinExport$Callgraph$Vertex.PARSER;
    }
    
    @Override
    public BinExport$Callgraph$Vertex getDefaultInstanceForType() {
        return BinExport$Callgraph$Vertex.DEFAULT_INSTANCE;
    }
    
    static {
        DEFAULT_INSTANCE = new BinExport$Callgraph$Vertex();
        PARSER = new BinExport$Callgraph$Vertex$1();
    }
}
