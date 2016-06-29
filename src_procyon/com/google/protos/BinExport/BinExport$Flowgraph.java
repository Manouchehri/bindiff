package com.google.protos.BinExport;

import java.util.*;
import java.io.*;
import com.google.protobuf.*;

public final class BinExport$Flowgraph extends GeneratedMessage implements BinExport$FlowgraphOrBuilder
{
    private int bitField0_;
    public static final int ADDRESS_FIELD_NUMBER = 1;
    private long address_;
    public static final int VERTICES_FIELD_NUMBER = 2;
    private List vertices_;
    public static final int EDGES_FIELD_NUMBER = 3;
    private List edges_;
    private byte memoizedIsInitialized;
    private int memoizedSerializedSize;
    private static final long serialVersionUID = 0L;
    private static final BinExport$Flowgraph DEFAULT_INSTANCE;
    public static final Parser PARSER;
    
    private BinExport$Flowgraph(final GeneratedMessage$Builder generatedMessage$Builder) {
        super(generatedMessage$Builder);
        this.memoizedIsInitialized = -1;
        this.memoizedSerializedSize = -1;
    }
    
    private BinExport$Flowgraph() {
        this.memoizedIsInitialized = -1;
        this.memoizedSerializedSize = -1;
        this.address_ = 0L;
        this.vertices_ = Collections.emptyList();
        this.edges_ = Collections.emptyList();
    }
    
    @Override
    public final UnknownFieldSet getUnknownFields() {
        return this.unknownFields;
    }
    
    private BinExport$Flowgraph(final CodedInputStream codedInputStream, final ExtensionRegistryLite extensionRegistryLite) {
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
                        this.address_ = codedInputStream.readUInt64();
                        continue;
                    }
                    case 18: {
                        if ((n & 0x2) != 0x2) {
                            this.vertices_ = new ArrayList();
                            n |= 0x2;
                        }
                        this.vertices_.add(codedInputStream.readMessage(BinExport$Flowgraph$Vertex.PARSER, extensionRegistryLite));
                        continue;
                    }
                    case 26: {
                        if ((n & 0x4) != 0x4) {
                            this.edges_ = new ArrayList();
                            n |= 0x4;
                        }
                        this.edges_.add(codedInputStream.readMessage(BinExport$Flowgraph$Edge.PARSER, extensionRegistryLite));
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
                this.vertices_ = Collections.unmodifiableList((List<?>)this.vertices_);
            }
            if ((n & 0x4) == 0x4) {
                this.edges_ = Collections.unmodifiableList((List<?>)this.edges_);
            }
            this.unknownFields = builder.build();
            this.makeExtensionsImmutable();
        }
    }
    
    public static final Descriptors$Descriptor getDescriptor() {
        return BinExport.internal_static_BinExport_Flowgraph_descriptor;
    }
    
    @Override
    protected GeneratedMessage$FieldAccessorTable internalGetFieldAccessorTable() {
        return BinExport.internal_static_BinExport_Flowgraph_fieldAccessorTable.ensureFieldAccessorsInitialized(BinExport$Flowgraph.class, BinExport$Flowgraph$Builder.class);
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
    public List getVerticesList() {
        return this.vertices_;
    }
    
    @Override
    public List getVerticesOrBuilderList() {
        return this.vertices_;
    }
    
    @Override
    public int getVerticesCount() {
        return this.vertices_.size();
    }
    
    @Override
    public BinExport$Flowgraph$Vertex getVertices(final int n) {
        return this.vertices_.get(n);
    }
    
    @Override
    public BinExport$Flowgraph$VertexOrBuilder getVerticesOrBuilder(final int n) {
        return this.vertices_.get(n);
    }
    
    @Override
    public List getEdgesList() {
        return this.edges_;
    }
    
    @Override
    public List getEdgesOrBuilderList() {
        return this.edges_;
    }
    
    @Override
    public int getEdgesCount() {
        return this.edges_.size();
    }
    
    @Override
    public BinExport$Flowgraph$Edge getEdges(final int n) {
        return this.edges_.get(n);
    }
    
    @Override
    public BinExport$Flowgraph$EdgeOrBuilder getEdgesOrBuilder(final int n) {
        return this.edges_.get(n);
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
        for (int i = 0; i < this.getVerticesCount(); ++i) {
            if (!this.getVertices(i).isInitialized()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
        }
        for (int j = 0; j < this.getEdgesCount(); ++j) {
            if (!this.getEdges(j).isInitialized()) {
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
            codedOutputStream.writeUInt64(1, this.address_);
        }
        for (int i = 0; i < this.vertices_.size(); ++i) {
            codedOutputStream.writeMessage(2, (MessageLite)this.vertices_.get(i));
        }
        for (int j = 0; j < this.edges_.size(); ++j) {
            codedOutputStream.writeMessage(3, (MessageLite)this.edges_.get(j));
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
        for (int i = 0; i < this.vertices_.size(); ++i) {
            n += CodedOutputStream.computeMessageSize(2, (MessageLite)this.vertices_.get(i));
        }
        for (int j = 0; j < this.edges_.size(); ++j) {
            n += CodedOutputStream.computeMessageSize(3, (MessageLite)this.edges_.get(j));
        }
        return this.memoizedSerializedSize = n + this.unknownFields.getSerializedSize();
    }
    
    public static BinExport$Flowgraph parseFrom(final ByteString byteString) {
        return (BinExport$Flowgraph)BinExport$Flowgraph.PARSER.parseFrom(byteString);
    }
    
    public static BinExport$Flowgraph parseFrom(final ByteString byteString, final ExtensionRegistryLite extensionRegistryLite) {
        return (BinExport$Flowgraph)BinExport$Flowgraph.PARSER.parseFrom(byteString, extensionRegistryLite);
    }
    
    public static BinExport$Flowgraph parseFrom(final byte[] array) {
        return (BinExport$Flowgraph)BinExport$Flowgraph.PARSER.parseFrom(array);
    }
    
    public static BinExport$Flowgraph parseFrom(final byte[] array, final ExtensionRegistryLite extensionRegistryLite) {
        return (BinExport$Flowgraph)BinExport$Flowgraph.PARSER.parseFrom(array, extensionRegistryLite);
    }
    
    public static BinExport$Flowgraph parseFrom(final InputStream inputStream) {
        return (BinExport$Flowgraph)BinExport$Flowgraph.PARSER.parseFrom(inputStream);
    }
    
    public static BinExport$Flowgraph parseFrom(final InputStream inputStream, final ExtensionRegistryLite extensionRegistryLite) {
        return (BinExport$Flowgraph)BinExport$Flowgraph.PARSER.parseFrom(inputStream, extensionRegistryLite);
    }
    
    public static BinExport$Flowgraph parseDelimitedFrom(final InputStream inputStream) {
        return (BinExport$Flowgraph)BinExport$Flowgraph.PARSER.parseDelimitedFrom(inputStream);
    }
    
    public static BinExport$Flowgraph parseDelimitedFrom(final InputStream inputStream, final ExtensionRegistryLite extensionRegistryLite) {
        return (BinExport$Flowgraph)BinExport$Flowgraph.PARSER.parseDelimitedFrom(inputStream, extensionRegistryLite);
    }
    
    public static BinExport$Flowgraph parseFrom(final CodedInputStream codedInputStream) {
        return (BinExport$Flowgraph)BinExport$Flowgraph.PARSER.parseFrom(codedInputStream);
    }
    
    public static BinExport$Flowgraph parseFrom(final CodedInputStream codedInputStream, final ExtensionRegistryLite extensionRegistryLite) {
        return (BinExport$Flowgraph)BinExport$Flowgraph.PARSER.parseFrom(codedInputStream, extensionRegistryLite);
    }
    
    @Override
    public BinExport$Flowgraph$Builder newBuilderForType() {
        return newBuilder();
    }
    
    public static BinExport$Flowgraph$Builder newBuilder() {
        return BinExport$Flowgraph.DEFAULT_INSTANCE.toBuilder();
    }
    
    public static BinExport$Flowgraph$Builder newBuilder(final BinExport$Flowgraph binExport$Flowgraph) {
        return BinExport$Flowgraph.DEFAULT_INSTANCE.toBuilder().mergeFrom(binExport$Flowgraph);
    }
    
    @Override
    public BinExport$Flowgraph$Builder toBuilder() {
        return (this == BinExport$Flowgraph.DEFAULT_INSTANCE) ? new BinExport$Flowgraph$Builder((BinExport$1)null) : new BinExport$Flowgraph$Builder((BinExport$1)null).mergeFrom(this);
    }
    
    @Override
    protected BinExport$Flowgraph$Builder newBuilderForType(final GeneratedMessage$BuilderParent generatedMessage$BuilderParent) {
        return new BinExport$Flowgraph$Builder(generatedMessage$BuilderParent, null);
    }
    
    public static BinExport$Flowgraph getDefaultInstance() {
        return BinExport$Flowgraph.DEFAULT_INSTANCE;
    }
    
    @Override
    public Parser getParserForType() {
        return BinExport$Flowgraph.PARSER;
    }
    
    @Override
    public BinExport$Flowgraph getDefaultInstanceForType() {
        return BinExport$Flowgraph.DEFAULT_INSTANCE;
    }
    
    static {
        DEFAULT_INSTANCE = new BinExport$Flowgraph();
        PARSER = new BinExport$Flowgraph$1();
    }
}
