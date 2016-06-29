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
import com.google.protos.BinExport.BinExport$Flowgraph$1;
import com.google.protos.BinExport.BinExport$Flowgraph$Builder;
import com.google.protos.BinExport.BinExport$Flowgraph$Edge;
import com.google.protos.BinExport.BinExport$Flowgraph$EdgeOrBuilder;
import com.google.protos.BinExport.BinExport$Flowgraph$Vertex;
import com.google.protos.BinExport.BinExport$Flowgraph$VertexOrBuilder;
import com.google.protos.BinExport.BinExport$FlowgraphOrBuilder;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class BinExport$Flowgraph
extends GeneratedMessage
implements BinExport$FlowgraphOrBuilder {
    private int bitField0_;
    public static final int ADDRESS_FIELD_NUMBER = 1;
    private long address_;
    public static final int VERTICES_FIELD_NUMBER = 2;
    private List vertices_;
    public static final int EDGES_FIELD_NUMBER = 3;
    private List edges_;
    private byte memoizedIsInitialized = -1;
    private int memoizedSerializedSize = -1;
    private static final long serialVersionUID = 0;
    private static final BinExport$Flowgraph DEFAULT_INSTANCE = new BinExport$Flowgraph();
    public static final Parser PARSER = new BinExport$Flowgraph$1();

    private BinExport$Flowgraph(GeneratedMessage$Builder generatedMessage$Builder) {
        super(generatedMessage$Builder);
    }

    private BinExport$Flowgraph() {
        this.address_ = 0;
        this.vertices_ = Collections.emptyList();
        this.edges_ = Collections.emptyList();
    }

    @Override
    public final UnknownFieldSet getUnknownFields() {
        return this.unknownFields;
    }

    private BinExport$Flowgraph(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        this();
        int n2 = 0;
        UnknownFieldSet$Builder unknownFieldSet$Builder = UnknownFieldSet.newBuilder();
        try {
            boolean bl2 = false;
            block12 : while (!bl2) {
                int n3 = codedInputStream.readTag();
                switch (n3) {
                    case 0: {
                        bl2 = true;
                        continue block12;
                    }
                    default: {
                        if (this.parseUnknownField(codedInputStream, unknownFieldSet$Builder, extensionRegistryLite, n3)) continue block12;
                        bl2 = true;
                        continue block12;
                    }
                    case 8: {
                        this.bitField0_ |= 1;
                        this.address_ = codedInputStream.readUInt64();
                        continue block12;
                    }
                    case 18: {
                        if ((n2 & 2) != 2) {
                            this.vertices_ = new ArrayList();
                            n2 |= 2;
                        }
                        this.vertices_.add(codedInputStream.readMessage(BinExport$Flowgraph$Vertex.PARSER, extensionRegistryLite));
                        continue block12;
                    }
                    case 26: 
                }
                if ((n2 & 4) != 4) {
                    this.edges_ = new ArrayList();
                    n2 |= 4;
                }
                this.edges_.add(codedInputStream.readMessage(BinExport$Flowgraph$Edge.PARSER, extensionRegistryLite));
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
            if ((n2 & 2) == 2) {
                this.vertices_ = Collections.unmodifiableList(this.vertices_);
            }
            if ((n2 & 4) == 4) {
                this.edges_ = Collections.unmodifiableList(this.edges_);
            }
            this.unknownFields = unknownFieldSet$Builder.build();
            this.makeExtensionsImmutable();
        }
    }

    public static final Descriptors$Descriptor getDescriptor() {
        return BinExport.access$5700();
    }

    @Override
    protected GeneratedMessage$FieldAccessorTable internalGetFieldAccessorTable() {
        return BinExport.access$5800().ensureFieldAccessorsInitialized(BinExport$Flowgraph.class, BinExport$Flowgraph$Builder.class);
    }

    @Override
    public boolean hasAddress() {
        if ((this.bitField0_ & 1) != 1) return false;
        return true;
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
    public BinExport$Flowgraph$Vertex getVertices(int n2) {
        return (BinExport$Flowgraph$Vertex)this.vertices_.get(n2);
    }

    @Override
    public BinExport$Flowgraph$VertexOrBuilder getVerticesOrBuilder(int n2) {
        return (BinExport$Flowgraph$VertexOrBuilder)this.vertices_.get(n2);
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
    public BinExport$Flowgraph$Edge getEdges(int n2) {
        return (BinExport$Flowgraph$Edge)this.edges_.get(n2);
    }

    @Override
    public BinExport$Flowgraph$EdgeOrBuilder getEdgesOrBuilder(int n2) {
        return (BinExport$Flowgraph$EdgeOrBuilder)this.edges_.get(n2);
    }

    @Override
    public final boolean isInitialized() {
        int n2;
        byte by2 = this.memoizedIsInitialized;
        if (by2 == 1) {
            return true;
        }
        if (by2 == 0) {
            return false;
        }
        if (!this.hasAddress()) {
            this.memoizedIsInitialized = 0;
            return false;
        }
        for (n2 = 0; n2 < this.getVerticesCount(); ++n2) {
            if (this.getVertices(n2).isInitialized()) continue;
            this.memoizedIsInitialized = 0;
            return false;
        }
        n2 = 0;
        do {
            if (n2 >= this.getEdgesCount()) {
                this.memoizedIsInitialized = 1;
                return true;
            }
            if (!this.getEdges(n2).isInitialized()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            ++n2;
        } while (true);
    }

    @Override
    public void writeTo(CodedOutputStream codedOutputStream) {
        int n2;
        if ((this.bitField0_ & 1) == 1) {
            codedOutputStream.writeUInt64(1, this.address_);
        }
        for (n2 = 0; n2 < this.vertices_.size(); ++n2) {
            codedOutputStream.writeMessage(2, (MessageLite)this.vertices_.get(n2));
        }
        n2 = 0;
        do {
            if (n2 >= this.edges_.size()) {
                this.unknownFields.writeTo(codedOutputStream);
                return;
            }
            codedOutputStream.writeMessage(3, (MessageLite)this.edges_.get(n2));
            ++n2;
        } while (true);
    }

    @Override
    public int getSerializedSize() {
        int n2;
        int n3 = this.memoizedSerializedSize;
        if (n3 != -1) {
            return n3;
        }
        n3 = 0;
        if ((this.bitField0_ & 1) == 1) {
            n3 += CodedOutputStream.computeUInt64Size(1, this.address_);
        }
        for (n2 = 0; n2 < this.vertices_.size(); n3 += CodedOutputStream.computeMessageSize((int)2, (MessageLite)((MessageLite)this.vertices_.get((int)n2))), ++n2) {
        }
        n2 = 0;
        do {
            if (n2 >= this.edges_.size()) {
                this.memoizedSerializedSize = n3 += this.unknownFields.getSerializedSize();
                return n3;
            }
            n3 += CodedOutputStream.computeMessageSize(3, (MessageLite)this.edges_.get(n2));
            ++n2;
        } while (true);
    }

    public static BinExport$Flowgraph parseFrom(ByteString byteString) {
        return (BinExport$Flowgraph)PARSER.parseFrom(byteString);
    }

    public static BinExport$Flowgraph parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        return (BinExport$Flowgraph)PARSER.parseFrom(byteString, extensionRegistryLite);
    }

    public static BinExport$Flowgraph parseFrom(byte[] arrby) {
        return (BinExport$Flowgraph)PARSER.parseFrom(arrby);
    }

    public static BinExport$Flowgraph parseFrom(byte[] arrby, ExtensionRegistryLite extensionRegistryLite) {
        return (BinExport$Flowgraph)PARSER.parseFrom(arrby, extensionRegistryLite);
    }

    public static BinExport$Flowgraph parseFrom(InputStream inputStream) {
        return (BinExport$Flowgraph)PARSER.parseFrom(inputStream);
    }

    public static BinExport$Flowgraph parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (BinExport$Flowgraph)PARSER.parseFrom(inputStream, extensionRegistryLite);
    }

    public static BinExport$Flowgraph parseDelimitedFrom(InputStream inputStream) {
        return (BinExport$Flowgraph)PARSER.parseDelimitedFrom(inputStream);
    }

    public static BinExport$Flowgraph parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (BinExport$Flowgraph)PARSER.parseDelimitedFrom(inputStream, extensionRegistryLite);
    }

    public static BinExport$Flowgraph parseFrom(CodedInputStream codedInputStream) {
        return (BinExport$Flowgraph)PARSER.parseFrom(codedInputStream);
    }

    public static BinExport$Flowgraph parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (BinExport$Flowgraph)PARSER.parseFrom(codedInputStream, extensionRegistryLite);
    }

    @Override
    public BinExport$Flowgraph$Builder newBuilderForType() {
        return BinExport$Flowgraph.newBuilder();
    }

    public static BinExport$Flowgraph$Builder newBuilder() {
        return DEFAULT_INSTANCE.toBuilder();
    }

    public static BinExport$Flowgraph$Builder newBuilder(BinExport$Flowgraph binExport$Flowgraph) {
        return DEFAULT_INSTANCE.toBuilder().mergeFrom(binExport$Flowgraph);
    }

    @Override
    public BinExport$Flowgraph$Builder toBuilder() {
        BinExport$Flowgraph$Builder binExport$Flowgraph$Builder;
        if (this == DEFAULT_INSTANCE) {
            binExport$Flowgraph$Builder = new BinExport$Flowgraph$Builder(null);
            return binExport$Flowgraph$Builder;
        }
        binExport$Flowgraph$Builder = new BinExport$Flowgraph$Builder(null).mergeFrom(this);
        return binExport$Flowgraph$Builder;
    }

    @Override
    protected BinExport$Flowgraph$Builder newBuilderForType(GeneratedMessage$BuilderParent generatedMessage$BuilderParent) {
        return new BinExport$Flowgraph$Builder(generatedMessage$BuilderParent, null);
    }

    public static BinExport$Flowgraph getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    @Override
    public Parser getParserForType() {
        return PARSER;
    }

    @Override
    public BinExport$Flowgraph getDefaultInstanceForType() {
        return DEFAULT_INSTANCE;
    }

    static /* synthetic */ boolean access$11400() {
        return alwaysUseFieldBuilders;
    }

    /* synthetic */ BinExport$Flowgraph(GeneratedMessage$Builder generatedMessage$Builder, BinExport$1 binExport$1) {
        this(generatedMessage$Builder);
    }

    static /* synthetic */ long access$11602(BinExport$Flowgraph binExport$Flowgraph, long l2) {
        binExport$Flowgraph.address_ = l2;
        return binExport$Flowgraph.address_;
    }

    static /* synthetic */ List access$11702(BinExport$Flowgraph binExport$Flowgraph, List list) {
        binExport$Flowgraph.vertices_ = list;
        return binExport$Flowgraph.vertices_;
    }

    static /* synthetic */ List access$11802(BinExport$Flowgraph binExport$Flowgraph, List list) {
        binExport$Flowgraph.edges_ = list;
        return binExport$Flowgraph.edges_;
    }

    static /* synthetic */ int access$11902(BinExport$Flowgraph binExport$Flowgraph, int n2) {
        binExport$Flowgraph.bitField0_ = n2;
        return binExport$Flowgraph.bitField0_;
    }

    static /* synthetic */ List access$11700(BinExport$Flowgraph binExport$Flowgraph) {
        return binExport$Flowgraph.vertices_;
    }

    static /* synthetic */ boolean access$12000() {
        return alwaysUseFieldBuilders;
    }

    static /* synthetic */ List access$11800(BinExport$Flowgraph binExport$Flowgraph) {
        return binExport$Flowgraph.edges_;
    }

    static /* synthetic */ boolean access$12100() {
        return alwaysUseFieldBuilders;
    }

    static /* synthetic */ UnknownFieldSet access$12200(BinExport$Flowgraph binExport$Flowgraph) {
        return binExport$Flowgraph.unknownFields;
    }

    /* synthetic */ BinExport$Flowgraph(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite, BinExport$1 binExport$1) {
        this(codedInputStream, extensionRegistryLite);
    }
}

