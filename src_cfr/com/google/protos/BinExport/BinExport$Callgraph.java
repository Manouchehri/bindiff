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
import com.google.protos.BinExport.BinExport$Callgraph$1;
import com.google.protos.BinExport.BinExport$Callgraph$Builder;
import com.google.protos.BinExport.BinExport$Callgraph$Edge;
import com.google.protos.BinExport.BinExport$Callgraph$EdgeOrBuilder;
import com.google.protos.BinExport.BinExport$Callgraph$Vertex;
import com.google.protos.BinExport.BinExport$Callgraph$VertexOrBuilder;
import com.google.protos.BinExport.BinExport$CallgraphOrBuilder;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class BinExport$Callgraph
extends GeneratedMessage
implements BinExport$CallgraphOrBuilder {
    public static final int VERTICES_FIELD_NUMBER = 1;
    private List vertices_;
    public static final int EDGES_FIELD_NUMBER = 2;
    private List edges_;
    private byte memoizedIsInitialized = -1;
    private int memoizedSerializedSize = -1;
    private static final long serialVersionUID = 0;
    private static final BinExport$Callgraph DEFAULT_INSTANCE = new BinExport$Callgraph();
    public static final Parser PARSER = new BinExport$Callgraph$1();

    private BinExport$Callgraph(GeneratedMessage$Builder generatedMessage$Builder) {
        super(generatedMessage$Builder);
    }

    private BinExport$Callgraph() {
        this.vertices_ = Collections.emptyList();
        this.edges_ = Collections.emptyList();
    }

    @Override
    public final UnknownFieldSet getUnknownFields() {
        return this.unknownFields;
    }

    private BinExport$Callgraph(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        this();
        int n2 = 0;
        UnknownFieldSet$Builder unknownFieldSet$Builder = UnknownFieldSet.newBuilder();
        try {
            boolean bl2 = false;
            block11 : while (!bl2) {
                int n3 = codedInputStream.readTag();
                switch (n3) {
                    case 0: {
                        bl2 = true;
                        continue block11;
                    }
                    default: {
                        if (this.parseUnknownField(codedInputStream, unknownFieldSet$Builder, extensionRegistryLite, n3)) continue block11;
                        bl2 = true;
                        continue block11;
                    }
                    case 10: {
                        if ((n2 & 1) != 1) {
                            this.vertices_ = new ArrayList();
                            n2 |= 1;
                        }
                        this.vertices_.add(codedInputStream.readMessage(BinExport$Callgraph$Vertex.PARSER, extensionRegistryLite));
                        continue block11;
                    }
                    case 18: 
                }
                if ((n2 & 2) != 2) {
                    this.edges_ = new ArrayList();
                    n2 |= 2;
                }
                this.edges_.add(codedInputStream.readMessage(BinExport$Callgraph$Edge.PARSER, extensionRegistryLite));
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
            if (n2 & true) {
                this.vertices_ = Collections.unmodifiableList(this.vertices_);
            }
            if ((n2 & 2) == 2) {
                this.edges_ = Collections.unmodifiableList(this.edges_);
            }
            this.unknownFields = unknownFieldSet$Builder.build();
            this.makeExtensionsImmutable();
        }
    }

    public static final Descriptors$Descriptor getDescriptor() {
        return BinExport.access$1800();
    }

    @Override
    protected GeneratedMessage$FieldAccessorTable internalGetFieldAccessorTable() {
        return BinExport.access$1900().ensureFieldAccessorsInitialized(BinExport$Callgraph.class, BinExport$Callgraph$Builder.class);
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
    public BinExport$Callgraph$Vertex getVertices(int n2) {
        return (BinExport$Callgraph$Vertex)this.vertices_.get(n2);
    }

    @Override
    public BinExport$Callgraph$VertexOrBuilder getVerticesOrBuilder(int n2) {
        return (BinExport$Callgraph$VertexOrBuilder)this.vertices_.get(n2);
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
    public BinExport$Callgraph$Edge getEdges(int n2) {
        return (BinExport$Callgraph$Edge)this.edges_.get(n2);
    }

    @Override
    public BinExport$Callgraph$EdgeOrBuilder getEdgesOrBuilder(int n2) {
        return (BinExport$Callgraph$EdgeOrBuilder)this.edges_.get(n2);
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
        for (n2 = 0; n2 < this.vertices_.size(); ++n2) {
            codedOutputStream.writeMessage(1, (MessageLite)this.vertices_.get(n2));
        }
        n2 = 0;
        do {
            if (n2 >= this.edges_.size()) {
                this.unknownFields.writeTo(codedOutputStream);
                return;
            }
            codedOutputStream.writeMessage(2, (MessageLite)this.edges_.get(n2));
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
        for (n2 = 0; n2 < this.vertices_.size(); n3 += CodedOutputStream.computeMessageSize((int)1, (MessageLite)((MessageLite)this.vertices_.get((int)n2))), ++n2) {
        }
        n2 = 0;
        do {
            if (n2 >= this.edges_.size()) {
                this.memoizedSerializedSize = n3 += this.unknownFields.getSerializedSize();
                return n3;
            }
            n3 += CodedOutputStream.computeMessageSize(2, (MessageLite)this.edges_.get(n2));
            ++n2;
        } while (true);
    }

    public static BinExport$Callgraph parseFrom(ByteString byteString) {
        return (BinExport$Callgraph)PARSER.parseFrom(byteString);
    }

    public static BinExport$Callgraph parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        return (BinExport$Callgraph)PARSER.parseFrom(byteString, extensionRegistryLite);
    }

    public static BinExport$Callgraph parseFrom(byte[] arrby) {
        return (BinExport$Callgraph)PARSER.parseFrom(arrby);
    }

    public static BinExport$Callgraph parseFrom(byte[] arrby, ExtensionRegistryLite extensionRegistryLite) {
        return (BinExport$Callgraph)PARSER.parseFrom(arrby, extensionRegistryLite);
    }

    public static BinExport$Callgraph parseFrom(InputStream inputStream) {
        return (BinExport$Callgraph)PARSER.parseFrom(inputStream);
    }

    public static BinExport$Callgraph parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (BinExport$Callgraph)PARSER.parseFrom(inputStream, extensionRegistryLite);
    }

    public static BinExport$Callgraph parseDelimitedFrom(InputStream inputStream) {
        return (BinExport$Callgraph)PARSER.parseDelimitedFrom(inputStream);
    }

    public static BinExport$Callgraph parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (BinExport$Callgraph)PARSER.parseDelimitedFrom(inputStream, extensionRegistryLite);
    }

    public static BinExport$Callgraph parseFrom(CodedInputStream codedInputStream) {
        return (BinExport$Callgraph)PARSER.parseFrom(codedInputStream);
    }

    public static BinExport$Callgraph parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (BinExport$Callgraph)PARSER.parseFrom(codedInputStream, extensionRegistryLite);
    }

    @Override
    public BinExport$Callgraph$Builder newBuilderForType() {
        return BinExport$Callgraph.newBuilder();
    }

    public static BinExport$Callgraph$Builder newBuilder() {
        return DEFAULT_INSTANCE.toBuilder();
    }

    public static BinExport$Callgraph$Builder newBuilder(BinExport$Callgraph binExport$Callgraph) {
        return DEFAULT_INSTANCE.toBuilder().mergeFrom(binExport$Callgraph);
    }

    @Override
    public BinExport$Callgraph$Builder toBuilder() {
        BinExport$Callgraph$Builder binExport$Callgraph$Builder;
        if (this == DEFAULT_INSTANCE) {
            binExport$Callgraph$Builder = new BinExport$Callgraph$Builder(null);
            return binExport$Callgraph$Builder;
        }
        binExport$Callgraph$Builder = new BinExport$Callgraph$Builder(null).mergeFrom(this);
        return binExport$Callgraph$Builder;
    }

    @Override
    protected BinExport$Callgraph$Builder newBuilderForType(GeneratedMessage$BuilderParent generatedMessage$BuilderParent) {
        return new BinExport$Callgraph$Builder(generatedMessage$BuilderParent, null);
    }

    public static BinExport$Callgraph getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    @Override
    public Parser getParserForType() {
        return PARSER;
    }

    @Override
    public BinExport$Callgraph getDefaultInstanceForType() {
        return DEFAULT_INSTANCE;
    }

    static /* synthetic */ boolean access$4900() {
        return alwaysUseFieldBuilders;
    }

    /* synthetic */ BinExport$Callgraph(GeneratedMessage$Builder generatedMessage$Builder, BinExport$1 binExport$1) {
        this(generatedMessage$Builder);
    }

    static /* synthetic */ List access$5102(BinExport$Callgraph binExport$Callgraph, List list) {
        binExport$Callgraph.vertices_ = list;
        return binExport$Callgraph.vertices_;
    }

    static /* synthetic */ List access$5202(BinExport$Callgraph binExport$Callgraph, List list) {
        binExport$Callgraph.edges_ = list;
        return binExport$Callgraph.edges_;
    }

    static /* synthetic */ List access$5100(BinExport$Callgraph binExport$Callgraph) {
        return binExport$Callgraph.vertices_;
    }

    static /* synthetic */ boolean access$5300() {
        return alwaysUseFieldBuilders;
    }

    static /* synthetic */ List access$5200(BinExport$Callgraph binExport$Callgraph) {
        return binExport$Callgraph.edges_;
    }

    static /* synthetic */ boolean access$5400() {
        return alwaysUseFieldBuilders;
    }

    static /* synthetic */ UnknownFieldSet access$5500(BinExport$Callgraph binExport$Callgraph) {
        return binExport$Callgraph.unknownFields;
    }

    /* synthetic */ BinExport$Callgraph(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite, BinExport$1 binExport$1) {
        this(codedInputStream, extensionRegistryLite);
    }
}

