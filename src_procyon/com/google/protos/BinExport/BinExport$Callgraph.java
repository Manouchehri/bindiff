package com.google.protos.BinExport;

import java.util.*;
import java.io.*;
import com.google.protobuf.*;

public final class BinExport$Callgraph extends GeneratedMessage implements BinExport$CallgraphOrBuilder
{
    public static final int VERTICES_FIELD_NUMBER = 1;
    private List vertices_;
    public static final int EDGES_FIELD_NUMBER = 2;
    private List edges_;
    private byte memoizedIsInitialized;
    private int memoizedSerializedSize;
    private static final long serialVersionUID = 0L;
    private static final BinExport$Callgraph DEFAULT_INSTANCE;
    public static final Parser PARSER;
    
    private BinExport$Callgraph(final GeneratedMessage$Builder generatedMessage$Builder) {
        super(generatedMessage$Builder);
        this.memoizedIsInitialized = -1;
        this.memoizedSerializedSize = -1;
    }
    
    private BinExport$Callgraph() {
        this.memoizedIsInitialized = -1;
        this.memoizedSerializedSize = -1;
        this.vertices_ = Collections.emptyList();
        this.edges_ = Collections.emptyList();
    }
    
    @Override
    public final UnknownFieldSet getUnknownFields() {
        return this.unknownFields;
    }
    
    private BinExport$Callgraph(final CodedInputStream codedInputStream, final ExtensionRegistryLite extensionRegistryLite) {
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
                    case 10: {
                        if ((n & 0x1) != 0x1) {
                            this.vertices_ = new ArrayList();
                            n |= 0x1;
                        }
                        this.vertices_.add(codedInputStream.readMessage(BinExport$Callgraph$Vertex.PARSER, extensionRegistryLite));
                        continue;
                    }
                    case 18: {
                        if ((n & 0x2) != 0x2) {
                            this.edges_ = new ArrayList();
                            n |= 0x2;
                        }
                        this.edges_.add(codedInputStream.readMessage(BinExport$Callgraph$Edge.PARSER, extensionRegistryLite));
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
            if ((n & 0x1) == 0x1) {
                this.vertices_ = Collections.unmodifiableList((List<?>)this.vertices_);
            }
            if ((n & 0x2) == 0x2) {
                this.edges_ = Collections.unmodifiableList((List<?>)this.edges_);
            }
            this.unknownFields = builder.build();
            this.makeExtensionsImmutable();
        }
    }
    
    public static final Descriptors$Descriptor getDescriptor() {
        return BinExport.internal_static_BinExport_Callgraph_descriptor;
    }
    
    @Override
    protected GeneratedMessage$FieldAccessorTable internalGetFieldAccessorTable() {
        return BinExport.internal_static_BinExport_Callgraph_fieldAccessorTable.ensureFieldAccessorsInitialized(BinExport$Callgraph.class, BinExport$Callgraph$Builder.class);
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
    public BinExport$Callgraph$Vertex getVertices(final int n) {
        return this.vertices_.get(n);
    }
    
    @Override
    public BinExport$Callgraph$VertexOrBuilder getVerticesOrBuilder(final int n) {
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
    public BinExport$Callgraph$Edge getEdges(final int n) {
        return this.edges_.get(n);
    }
    
    @Override
    public BinExport$Callgraph$EdgeOrBuilder getEdgesOrBuilder(final int n) {
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
        for (int i = 0; i < this.vertices_.size(); ++i) {
            codedOutputStream.writeMessage(1, (MessageLite)this.vertices_.get(i));
        }
        for (int j = 0; j < this.edges_.size(); ++j) {
            codedOutputStream.writeMessage(2, (MessageLite)this.edges_.get(j));
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
        for (int i = 0; i < this.vertices_.size(); ++i) {
            n += CodedOutputStream.computeMessageSize(1, (MessageLite)this.vertices_.get(i));
        }
        for (int j = 0; j < this.edges_.size(); ++j) {
            n += CodedOutputStream.computeMessageSize(2, (MessageLite)this.edges_.get(j));
        }
        return this.memoizedSerializedSize = n + this.unknownFields.getSerializedSize();
    }
    
    public static BinExport$Callgraph parseFrom(final ByteString byteString) {
        return (BinExport$Callgraph)BinExport$Callgraph.PARSER.parseFrom(byteString);
    }
    
    public static BinExport$Callgraph parseFrom(final ByteString byteString, final ExtensionRegistryLite extensionRegistryLite) {
        return (BinExport$Callgraph)BinExport$Callgraph.PARSER.parseFrom(byteString, extensionRegistryLite);
    }
    
    public static BinExport$Callgraph parseFrom(final byte[] array) {
        return (BinExport$Callgraph)BinExport$Callgraph.PARSER.parseFrom(array);
    }
    
    public static BinExport$Callgraph parseFrom(final byte[] array, final ExtensionRegistryLite extensionRegistryLite) {
        return (BinExport$Callgraph)BinExport$Callgraph.PARSER.parseFrom(array, extensionRegistryLite);
    }
    
    public static BinExport$Callgraph parseFrom(final InputStream inputStream) {
        return (BinExport$Callgraph)BinExport$Callgraph.PARSER.parseFrom(inputStream);
    }
    
    public static BinExport$Callgraph parseFrom(final InputStream inputStream, final ExtensionRegistryLite extensionRegistryLite) {
        return (BinExport$Callgraph)BinExport$Callgraph.PARSER.parseFrom(inputStream, extensionRegistryLite);
    }
    
    public static BinExport$Callgraph parseDelimitedFrom(final InputStream inputStream) {
        return (BinExport$Callgraph)BinExport$Callgraph.PARSER.parseDelimitedFrom(inputStream);
    }
    
    public static BinExport$Callgraph parseDelimitedFrom(final InputStream inputStream, final ExtensionRegistryLite extensionRegistryLite) {
        return (BinExport$Callgraph)BinExport$Callgraph.PARSER.parseDelimitedFrom(inputStream, extensionRegistryLite);
    }
    
    public static BinExport$Callgraph parseFrom(final CodedInputStream codedInputStream) {
        return (BinExport$Callgraph)BinExport$Callgraph.PARSER.parseFrom(codedInputStream);
    }
    
    public static BinExport$Callgraph parseFrom(final CodedInputStream codedInputStream, final ExtensionRegistryLite extensionRegistryLite) {
        return (BinExport$Callgraph)BinExport$Callgraph.PARSER.parseFrom(codedInputStream, extensionRegistryLite);
    }
    
    @Override
    public BinExport$Callgraph$Builder newBuilderForType() {
        return newBuilder();
    }
    
    public static BinExport$Callgraph$Builder newBuilder() {
        return BinExport$Callgraph.DEFAULT_INSTANCE.toBuilder();
    }
    
    public static BinExport$Callgraph$Builder newBuilder(final BinExport$Callgraph binExport$Callgraph) {
        return BinExport$Callgraph.DEFAULT_INSTANCE.toBuilder().mergeFrom(binExport$Callgraph);
    }
    
    @Override
    public BinExport$Callgraph$Builder toBuilder() {
        return (this == BinExport$Callgraph.DEFAULT_INSTANCE) ? new BinExport$Callgraph$Builder((BinExport$1)null) : new BinExport$Callgraph$Builder((BinExport$1)null).mergeFrom(this);
    }
    
    @Override
    protected BinExport$Callgraph$Builder newBuilderForType(final GeneratedMessage$BuilderParent generatedMessage$BuilderParent) {
        return new BinExport$Callgraph$Builder(generatedMessage$BuilderParent, null);
    }
    
    public static BinExport$Callgraph getDefaultInstance() {
        return BinExport$Callgraph.DEFAULT_INSTANCE;
    }
    
    @Override
    public Parser getParserForType() {
        return BinExport$Callgraph.PARSER;
    }
    
    @Override
    public BinExport$Callgraph getDefaultInstanceForType() {
        return BinExport$Callgraph.DEFAULT_INSTANCE;
    }
    
    static {
        DEFAULT_INSTANCE = new BinExport$Callgraph();
        PARSER = new BinExport$Callgraph$1();
    }
}
