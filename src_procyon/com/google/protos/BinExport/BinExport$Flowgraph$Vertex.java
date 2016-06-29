package com.google.protos.BinExport;

import java.util.*;
import java.io.*;
import com.google.protobuf.*;

public final class BinExport$Flowgraph$Vertex extends GeneratedMessage implements BinExport$Flowgraph$VertexOrBuilder
{
    private int bitField0_;
    public static final int PRIME_FIELD_NUMBER = 1;
    private long prime_;
    public static final int INSTRUCTIONS_FIELD_NUMBER = 2;
    private List instructions_;
    private byte memoizedIsInitialized;
    private int memoizedSerializedSize;
    private static final long serialVersionUID = 0L;
    private static final BinExport$Flowgraph$Vertex DEFAULT_INSTANCE;
    public static final Parser PARSER;
    
    private BinExport$Flowgraph$Vertex(final GeneratedMessage$Builder generatedMessage$Builder) {
        super(generatedMessage$Builder);
        this.memoizedIsInitialized = -1;
        this.memoizedSerializedSize = -1;
    }
    
    private BinExport$Flowgraph$Vertex() {
        this.memoizedIsInitialized = -1;
        this.memoizedSerializedSize = -1;
        this.prime_ = 0L;
        this.instructions_ = Collections.emptyList();
    }
    
    @Override
    public final UnknownFieldSet getUnknownFields() {
        return this.unknownFields;
    }
    
    private BinExport$Flowgraph$Vertex(final CodedInputStream codedInputStream, final ExtensionRegistryLite extensionRegistryLite) {
        this();
        int n = 0;
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
                        this.prime_ = codedInputStream.readUInt64();
                        continue;
                    }
                    case 18: {
                        if ((n & 0x2) != 0x2) {
                            this.instructions_ = new ArrayList();
                            n |= 0x2;
                        }
                        this.instructions_.add(codedInputStream.readMessage(BinExport$Flowgraph$Vertex$Instruction.PARSER, extensionRegistryLite));
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
            if ((n & 0x2) == 0x2) {
                this.instructions_ = Collections.unmodifiableList((List<?>)this.instructions_);
            }
            this.unknownFields = builder.build();
            this.makeExtensionsImmutable();
        }
    }
    
    public static final Descriptors$Descriptor getDescriptor() {
        return BinExport.internal_static_BinExport_Flowgraph_Vertex_descriptor;
    }
    
    @Override
    protected GeneratedMessage$FieldAccessorTable internalGetFieldAccessorTable() {
        return BinExport.internal_static_BinExport_Flowgraph_Vertex_fieldAccessorTable.ensureFieldAccessorsInitialized(BinExport$Flowgraph$Vertex.class, BinExport$Flowgraph$Vertex$Builder.class);
    }
    
    @Override
    public boolean hasPrime() {
        return (this.bitField0_ & 0x1) == 0x1;
    }
    
    @Override
    public long getPrime() {
        return this.prime_;
    }
    
    @Override
    public List getInstructionsList() {
        return this.instructions_;
    }
    
    @Override
    public List getInstructionsOrBuilderList() {
        return this.instructions_;
    }
    
    @Override
    public int getInstructionsCount() {
        return this.instructions_.size();
    }
    
    @Override
    public BinExport$Flowgraph$Vertex$Instruction getInstructions(final int n) {
        return this.instructions_.get(n);
    }
    
    @Override
    public BinExport$Flowgraph$Vertex$InstructionOrBuilder getInstructionsOrBuilder(final int n) {
        return this.instructions_.get(n);
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
        if (!this.hasPrime()) {
            this.memoizedIsInitialized = 0;
            return false;
        }
        for (int i = 0; i < this.getInstructionsCount(); ++i) {
            if (!this.getInstructions(i).isInitialized()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
        }
        this.memoizedIsInitialized = 1;
        return true;
    }
    
    @Override
    public void writeTo(final CodedOutputStream codedOutputStream) {
        if ((this.bitField0_ & 0x1) == 0x1) {
            codedOutputStream.writeUInt64(1, this.prime_);
        }
        for (int i = 0; i < this.instructions_.size(); ++i) {
            codedOutputStream.writeMessage(2, (MessageLite)this.instructions_.get(i));
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
            n += CodedOutputStream.computeUInt64Size(1, this.prime_);
        }
        for (int i = 0; i < this.instructions_.size(); ++i) {
            n += CodedOutputStream.computeMessageSize(2, (MessageLite)this.instructions_.get(i));
        }
        return this.memoizedSerializedSize = n + this.unknownFields.getSerializedSize();
    }
    
    public static BinExport$Flowgraph$Vertex parseFrom(final ByteString byteString) {
        return (BinExport$Flowgraph$Vertex)BinExport$Flowgraph$Vertex.PARSER.parseFrom(byteString);
    }
    
    public static BinExport$Flowgraph$Vertex parseFrom(final ByteString byteString, final ExtensionRegistryLite extensionRegistryLite) {
        return (BinExport$Flowgraph$Vertex)BinExport$Flowgraph$Vertex.PARSER.parseFrom(byteString, extensionRegistryLite);
    }
    
    public static BinExport$Flowgraph$Vertex parseFrom(final byte[] array) {
        return (BinExport$Flowgraph$Vertex)BinExport$Flowgraph$Vertex.PARSER.parseFrom(array);
    }
    
    public static BinExport$Flowgraph$Vertex parseFrom(final byte[] array, final ExtensionRegistryLite extensionRegistryLite) {
        return (BinExport$Flowgraph$Vertex)BinExport$Flowgraph$Vertex.PARSER.parseFrom(array, extensionRegistryLite);
    }
    
    public static BinExport$Flowgraph$Vertex parseFrom(final InputStream inputStream) {
        return (BinExport$Flowgraph$Vertex)BinExport$Flowgraph$Vertex.PARSER.parseFrom(inputStream);
    }
    
    public static BinExport$Flowgraph$Vertex parseFrom(final InputStream inputStream, final ExtensionRegistryLite extensionRegistryLite) {
        return (BinExport$Flowgraph$Vertex)BinExport$Flowgraph$Vertex.PARSER.parseFrom(inputStream, extensionRegistryLite);
    }
    
    public static BinExport$Flowgraph$Vertex parseDelimitedFrom(final InputStream inputStream) {
        return (BinExport$Flowgraph$Vertex)BinExport$Flowgraph$Vertex.PARSER.parseDelimitedFrom(inputStream);
    }
    
    public static BinExport$Flowgraph$Vertex parseDelimitedFrom(final InputStream inputStream, final ExtensionRegistryLite extensionRegistryLite) {
        return (BinExport$Flowgraph$Vertex)BinExport$Flowgraph$Vertex.PARSER.parseDelimitedFrom(inputStream, extensionRegistryLite);
    }
    
    public static BinExport$Flowgraph$Vertex parseFrom(final CodedInputStream codedInputStream) {
        return (BinExport$Flowgraph$Vertex)BinExport$Flowgraph$Vertex.PARSER.parseFrom(codedInputStream);
    }
    
    public static BinExport$Flowgraph$Vertex parseFrom(final CodedInputStream codedInputStream, final ExtensionRegistryLite extensionRegistryLite) {
        return (BinExport$Flowgraph$Vertex)BinExport$Flowgraph$Vertex.PARSER.parseFrom(codedInputStream, extensionRegistryLite);
    }
    
    @Override
    public BinExport$Flowgraph$Vertex$Builder newBuilderForType() {
        return newBuilder();
    }
    
    public static BinExport$Flowgraph$Vertex$Builder newBuilder() {
        return BinExport$Flowgraph$Vertex.DEFAULT_INSTANCE.toBuilder();
    }
    
    public static BinExport$Flowgraph$Vertex$Builder newBuilder(final BinExport$Flowgraph$Vertex binExport$Flowgraph$Vertex) {
        return BinExport$Flowgraph$Vertex.DEFAULT_INSTANCE.toBuilder().mergeFrom(binExport$Flowgraph$Vertex);
    }
    
    @Override
    public BinExport$Flowgraph$Vertex$Builder toBuilder() {
        return (this == BinExport$Flowgraph$Vertex.DEFAULT_INSTANCE) ? new BinExport$Flowgraph$Vertex$Builder((BinExport$1)null) : new BinExport$Flowgraph$Vertex$Builder((BinExport$1)null).mergeFrom(this);
    }
    
    @Override
    protected BinExport$Flowgraph$Vertex$Builder newBuilderForType(final GeneratedMessage$BuilderParent generatedMessage$BuilderParent) {
        return new BinExport$Flowgraph$Vertex$Builder(generatedMessage$BuilderParent, null);
    }
    
    public static BinExport$Flowgraph$Vertex getDefaultInstance() {
        return BinExport$Flowgraph$Vertex.DEFAULT_INSTANCE;
    }
    
    @Override
    public Parser getParserForType() {
        return BinExport$Flowgraph$Vertex.PARSER;
    }
    
    @Override
    public BinExport$Flowgraph$Vertex getDefaultInstanceForType() {
        return BinExport$Flowgraph$Vertex.DEFAULT_INSTANCE;
    }
    
    static {
        DEFAULT_INSTANCE = new BinExport$Flowgraph$Vertex();
        PARSER = new BinExport$Flowgraph$Vertex$1();
    }
}
