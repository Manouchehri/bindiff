/*
 * Decompiled with CFR 0_115.
 */
package com.google.protos.BinExport;

import com.google.protobuf.AbstractMessage$Builder;
import com.google.protobuf.AbstractMessageLite$Builder;
import com.google.protobuf.CodedInputStream;
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
import com.google.protobuf.MessageOrBuilder;
import com.google.protobuf.Parser;
import com.google.protobuf.RepeatedFieldBuilder;
import com.google.protobuf.UnknownFieldSet;
import com.google.protos.BinExport.BinExport;
import com.google.protos.BinExport.BinExport$1;
import com.google.protos.BinExport.BinExport$Flowgraph;
import com.google.protos.BinExport.BinExport$Flowgraph$Edge;
import com.google.protos.BinExport.BinExport$Flowgraph$Edge$Builder;
import com.google.protos.BinExport.BinExport$Flowgraph$EdgeOrBuilder;
import com.google.protos.BinExport.BinExport$Flowgraph$Vertex;
import com.google.protos.BinExport.BinExport$Flowgraph$Vertex$Builder;
import com.google.protos.BinExport.BinExport$Flowgraph$VertexOrBuilder;
import com.google.protos.BinExport.BinExport$FlowgraphOrBuilder;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public final class BinExport$Flowgraph$Builder
extends GeneratedMessage$Builder
implements BinExport$FlowgraphOrBuilder {
    private int bitField0_;
    private long address_;
    private List vertices_ = Collections.emptyList();
    private RepeatedFieldBuilder verticesBuilder_;
    private List edges_ = Collections.emptyList();
    private RepeatedFieldBuilder edgesBuilder_;

    public static final Descriptors$Descriptor getDescriptor() {
        return BinExport.access$5700();
    }

    @Override
    protected GeneratedMessage$FieldAccessorTable internalGetFieldAccessorTable() {
        return BinExport.access$5800().ensureFieldAccessorsInitialized(BinExport$Flowgraph.class, BinExport$Flowgraph$Builder.class);
    }

    private BinExport$Flowgraph$Builder() {
        this.maybeForceBuilderInitialization();
    }

    private BinExport$Flowgraph$Builder(GeneratedMessage$BuilderParent generatedMessage$BuilderParent) {
        super(generatedMessage$BuilderParent);
        this.maybeForceBuilderInitialization();
    }

    private void maybeForceBuilderInitialization() {
        if (!BinExport$Flowgraph.access$11400()) return;
        this.getVerticesFieldBuilder();
        this.getEdgesFieldBuilder();
    }

    @Override
    public BinExport$Flowgraph$Builder clear() {
        super.clear();
        this.address_ = 0;
        this.bitField0_ &= -2;
        if (this.verticesBuilder_ == null) {
            this.vertices_ = Collections.emptyList();
            this.bitField0_ &= -3;
        } else {
            this.verticesBuilder_.clear();
        }
        if (this.edgesBuilder_ == null) {
            this.edges_ = Collections.emptyList();
            this.bitField0_ &= -5;
            return this;
        }
        this.edgesBuilder_.clear();
        return this;
    }

    @Override
    public Descriptors$Descriptor getDescriptorForType() {
        return BinExport.access$5700();
    }

    @Override
    public BinExport$Flowgraph getDefaultInstanceForType() {
        return BinExport$Flowgraph.getDefaultInstance();
    }

    @Override
    public BinExport$Flowgraph build() {
        BinExport$Flowgraph binExport$Flowgraph = this.buildPartial();
        if (binExport$Flowgraph.isInitialized()) return binExport$Flowgraph;
        throw BinExport$Flowgraph$Builder.newUninitializedMessageException(binExport$Flowgraph);
    }

    @Override
    public BinExport$Flowgraph buildPartial() {
        BinExport$Flowgraph binExport$Flowgraph = new BinExport$Flowgraph(this, null);
        int n2 = this.bitField0_;
        int n3 = 0;
        if ((n2 & 1) == 1) {
            n3 |= true;
        }
        BinExport$Flowgraph.access$11602(binExport$Flowgraph, this.address_);
        if (this.verticesBuilder_ == null) {
            if ((this.bitField0_ & 2) == 2) {
                this.vertices_ = Collections.unmodifiableList(this.vertices_);
                this.bitField0_ &= -3;
            }
            BinExport$Flowgraph.access$11702(binExport$Flowgraph, this.vertices_);
        } else {
            BinExport$Flowgraph.access$11702(binExport$Flowgraph, this.verticesBuilder_.build());
        }
        if (this.edgesBuilder_ == null) {
            if ((this.bitField0_ & 4) == 4) {
                this.edges_ = Collections.unmodifiableList(this.edges_);
                this.bitField0_ &= -5;
            }
            BinExport$Flowgraph.access$11802(binExport$Flowgraph, this.edges_);
        } else {
            BinExport$Flowgraph.access$11802(binExport$Flowgraph, this.edgesBuilder_.build());
        }
        BinExport$Flowgraph.access$11902(binExport$Flowgraph, n3);
        this.onBuilt();
        return binExport$Flowgraph;
    }

    @Override
    public BinExport$Flowgraph$Builder mergeFrom(Message message) {
        if (message instanceof BinExport$Flowgraph) {
            return this.mergeFrom((BinExport$Flowgraph)message);
        }
        super.mergeFrom(message);
        return this;
    }

    public BinExport$Flowgraph$Builder mergeFrom(BinExport$Flowgraph binExport$Flowgraph) {
        if (binExport$Flowgraph == BinExport$Flowgraph.getDefaultInstance()) {
            return this;
        }
        if (binExport$Flowgraph.hasAddress()) {
            this.setAddress(binExport$Flowgraph.getAddress());
        }
        if (this.verticesBuilder_ == null) {
            if (!BinExport$Flowgraph.access$11700(binExport$Flowgraph).isEmpty()) {
                if (this.vertices_.isEmpty()) {
                    this.vertices_ = BinExport$Flowgraph.access$11700(binExport$Flowgraph);
                    this.bitField0_ &= -3;
                } else {
                    this.ensureVerticesIsMutable();
                    this.vertices_.addAll(BinExport$Flowgraph.access$11700(binExport$Flowgraph));
                }
                this.onChanged();
            }
        } else if (!BinExport$Flowgraph.access$11700(binExport$Flowgraph).isEmpty()) {
            if (this.verticesBuilder_.isEmpty()) {
                this.verticesBuilder_.dispose();
                this.verticesBuilder_ = null;
                this.vertices_ = BinExport$Flowgraph.access$11700(binExport$Flowgraph);
                this.bitField0_ &= -3;
                this.verticesBuilder_ = BinExport$Flowgraph.access$12000() ? this.getVerticesFieldBuilder() : null;
            } else {
                this.verticesBuilder_.addAllMessages(BinExport$Flowgraph.access$11700(binExport$Flowgraph));
            }
        }
        if (this.edgesBuilder_ == null) {
            if (!BinExport$Flowgraph.access$11800(binExport$Flowgraph).isEmpty()) {
                if (this.edges_.isEmpty()) {
                    this.edges_ = BinExport$Flowgraph.access$11800(binExport$Flowgraph);
                    this.bitField0_ &= -5;
                } else {
                    this.ensureEdgesIsMutable();
                    this.edges_.addAll(BinExport$Flowgraph.access$11800(binExport$Flowgraph));
                }
                this.onChanged();
            }
        } else if (!BinExport$Flowgraph.access$11800(binExport$Flowgraph).isEmpty()) {
            if (this.edgesBuilder_.isEmpty()) {
                this.edgesBuilder_.dispose();
                this.edgesBuilder_ = null;
                this.edges_ = BinExport$Flowgraph.access$11800(binExport$Flowgraph);
                this.bitField0_ &= -5;
                this.edgesBuilder_ = BinExport$Flowgraph.access$12100() ? this.getEdgesFieldBuilder() : null;
            } else {
                this.edgesBuilder_.addAllMessages(BinExport$Flowgraph.access$11800(binExport$Flowgraph));
            }
        }
        this.mergeUnknownFields(BinExport$Flowgraph.access$12200(binExport$Flowgraph));
        this.onChanged();
        return this;
    }

    @Override
    public final boolean isInitialized() {
        int n2;
        if (!this.hasAddress()) {
            return false;
        }
        for (n2 = 0; n2 < this.getVerticesCount(); ++n2) {
            if (this.getVertices(n2).isInitialized()) continue;
            return false;
        }
        n2 = 0;
        while (n2 < this.getEdgesCount()) {
            if (!this.getEdges(n2).isInitialized()) {
                return false;
            }
            ++n2;
        }
        return true;
    }

    @Override
    public BinExport$Flowgraph$Builder mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        BinExport$Flowgraph binExport$Flowgraph = null;
        try {
            binExport$Flowgraph = (BinExport$Flowgraph)BinExport$Flowgraph.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
            return this;
        }
        catch (InvalidProtocolBufferException var4_4) {
            binExport$Flowgraph = (BinExport$Flowgraph)var4_4.getUnfinishedMessage();
            throw var4_4;
        }
        finally {
            if (binExport$Flowgraph != null) {
                this.mergeFrom(binExport$Flowgraph);
            }
        }
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

    public BinExport$Flowgraph$Builder setAddress(long l2) {
        this.bitField0_ |= 1;
        this.address_ = l2;
        this.onChanged();
        return this;
    }

    public BinExport$Flowgraph$Builder clearAddress() {
        this.bitField0_ &= -2;
        this.address_ = 0;
        this.onChanged();
        return this;
    }

    private void ensureVerticesIsMutable() {
        if ((this.bitField0_ & 2) == 2) return;
        this.vertices_ = new ArrayList(this.vertices_);
        this.bitField0_ |= 2;
    }

    @Override
    public List getVerticesList() {
        if (this.verticesBuilder_ != null) return this.verticesBuilder_.getMessageList();
        return Collections.unmodifiableList(this.vertices_);
    }

    @Override
    public int getVerticesCount() {
        if (this.verticesBuilder_ != null) return this.verticesBuilder_.getCount();
        return this.vertices_.size();
    }

    @Override
    public BinExport$Flowgraph$Vertex getVertices(int n2) {
        if (this.verticesBuilder_ != null) return (BinExport$Flowgraph$Vertex)this.verticesBuilder_.getMessage(n2);
        return (BinExport$Flowgraph$Vertex)this.vertices_.get(n2);
    }

    public BinExport$Flowgraph$Builder setVertices(int n2, BinExport$Flowgraph$Vertex binExport$Flowgraph$Vertex) {
        if (this.verticesBuilder_ != null) {
            this.verticesBuilder_.setMessage(n2, binExport$Flowgraph$Vertex);
            return this;
        }
        if (binExport$Flowgraph$Vertex == null) {
            throw new NullPointerException();
        }
        this.ensureVerticesIsMutable();
        this.vertices_.set(n2, binExport$Flowgraph$Vertex);
        this.onChanged();
        return this;
    }

    public BinExport$Flowgraph$Builder setVertices(int n2, BinExport$Flowgraph$Vertex$Builder binExport$Flowgraph$Vertex$Builder) {
        if (this.verticesBuilder_ == null) {
            this.ensureVerticesIsMutable();
            this.vertices_.set(n2, binExport$Flowgraph$Vertex$Builder.build());
            this.onChanged();
            return this;
        }
        this.verticesBuilder_.setMessage(n2, binExport$Flowgraph$Vertex$Builder.build());
        return this;
    }

    public BinExport$Flowgraph$Builder addVertices(BinExport$Flowgraph$Vertex binExport$Flowgraph$Vertex) {
        if (this.verticesBuilder_ != null) {
            this.verticesBuilder_.addMessage(binExport$Flowgraph$Vertex);
            return this;
        }
        if (binExport$Flowgraph$Vertex == null) {
            throw new NullPointerException();
        }
        this.ensureVerticesIsMutable();
        this.vertices_.add(binExport$Flowgraph$Vertex);
        this.onChanged();
        return this;
    }

    public BinExport$Flowgraph$Builder addVertices(int n2, BinExport$Flowgraph$Vertex binExport$Flowgraph$Vertex) {
        if (this.verticesBuilder_ != null) {
            this.verticesBuilder_.addMessage(n2, binExport$Flowgraph$Vertex);
            return this;
        }
        if (binExport$Flowgraph$Vertex == null) {
            throw new NullPointerException();
        }
        this.ensureVerticesIsMutable();
        this.vertices_.add(n2, binExport$Flowgraph$Vertex);
        this.onChanged();
        return this;
    }

    public BinExport$Flowgraph$Builder addVertices(BinExport$Flowgraph$Vertex$Builder binExport$Flowgraph$Vertex$Builder) {
        if (this.verticesBuilder_ == null) {
            this.ensureVerticesIsMutable();
            this.vertices_.add(binExport$Flowgraph$Vertex$Builder.build());
            this.onChanged();
            return this;
        }
        this.verticesBuilder_.addMessage(binExport$Flowgraph$Vertex$Builder.build());
        return this;
    }

    public BinExport$Flowgraph$Builder addVertices(int n2, BinExport$Flowgraph$Vertex$Builder binExport$Flowgraph$Vertex$Builder) {
        if (this.verticesBuilder_ == null) {
            this.ensureVerticesIsMutable();
            this.vertices_.add(n2, binExport$Flowgraph$Vertex$Builder.build());
            this.onChanged();
            return this;
        }
        this.verticesBuilder_.addMessage(n2, binExport$Flowgraph$Vertex$Builder.build());
        return this;
    }

    public BinExport$Flowgraph$Builder addAllVertices(Iterable iterable) {
        if (this.verticesBuilder_ == null) {
            this.ensureVerticesIsMutable();
            AbstractMessageLite$Builder.addAll(iterable, this.vertices_);
            this.onChanged();
            return this;
        }
        this.verticesBuilder_.addAllMessages(iterable);
        return this;
    }

    public BinExport$Flowgraph$Builder clearVertices() {
        if (this.verticesBuilder_ == null) {
            this.vertices_ = Collections.emptyList();
            this.bitField0_ &= -3;
            this.onChanged();
            return this;
        }
        this.verticesBuilder_.clear();
        return this;
    }

    public BinExport$Flowgraph$Builder removeVertices(int n2) {
        if (this.verticesBuilder_ == null) {
            this.ensureVerticesIsMutable();
            this.vertices_.remove(n2);
            this.onChanged();
            return this;
        }
        this.verticesBuilder_.remove(n2);
        return this;
    }

    public BinExport$Flowgraph$Vertex$Builder getVerticesBuilder(int n2) {
        return (BinExport$Flowgraph$Vertex$Builder)this.getVerticesFieldBuilder().getBuilder(n2);
    }

    @Override
    public BinExport$Flowgraph$VertexOrBuilder getVerticesOrBuilder(int n2) {
        if (this.verticesBuilder_ != null) return (BinExport$Flowgraph$VertexOrBuilder)this.verticesBuilder_.getMessageOrBuilder(n2);
        return (BinExport$Flowgraph$VertexOrBuilder)this.vertices_.get(n2);
    }

    @Override
    public List getVerticesOrBuilderList() {
        if (this.verticesBuilder_ == null) return Collections.unmodifiableList(this.vertices_);
        return this.verticesBuilder_.getMessageOrBuilderList();
    }

    public BinExport$Flowgraph$Vertex$Builder addVerticesBuilder() {
        return (BinExport$Flowgraph$Vertex$Builder)this.getVerticesFieldBuilder().addBuilder(BinExport$Flowgraph$Vertex.getDefaultInstance());
    }

    public BinExport$Flowgraph$Vertex$Builder addVerticesBuilder(int n2) {
        return (BinExport$Flowgraph$Vertex$Builder)this.getVerticesFieldBuilder().addBuilder(n2, BinExport$Flowgraph$Vertex.getDefaultInstance());
    }

    public List getVerticesBuilderList() {
        return this.getVerticesFieldBuilder().getBuilderList();
    }

    private RepeatedFieldBuilder getVerticesFieldBuilder() {
        if (this.verticesBuilder_ != null) return this.verticesBuilder_;
        this.verticesBuilder_ = new RepeatedFieldBuilder(this.vertices_, (this.bitField0_ & 2) == 2, this.getParentForChildren(), this.isClean());
        this.vertices_ = null;
        return this.verticesBuilder_;
    }

    private void ensureEdgesIsMutable() {
        if ((this.bitField0_ & 4) == 4) return;
        this.edges_ = new ArrayList(this.edges_);
        this.bitField0_ |= 4;
    }

    @Override
    public List getEdgesList() {
        if (this.edgesBuilder_ != null) return this.edgesBuilder_.getMessageList();
        return Collections.unmodifiableList(this.edges_);
    }

    @Override
    public int getEdgesCount() {
        if (this.edgesBuilder_ != null) return this.edgesBuilder_.getCount();
        return this.edges_.size();
    }

    @Override
    public BinExport$Flowgraph$Edge getEdges(int n2) {
        if (this.edgesBuilder_ != null) return (BinExport$Flowgraph$Edge)this.edgesBuilder_.getMessage(n2);
        return (BinExport$Flowgraph$Edge)this.edges_.get(n2);
    }

    public BinExport$Flowgraph$Builder setEdges(int n2, BinExport$Flowgraph$Edge binExport$Flowgraph$Edge) {
        if (this.edgesBuilder_ != null) {
            this.edgesBuilder_.setMessage(n2, binExport$Flowgraph$Edge);
            return this;
        }
        if (binExport$Flowgraph$Edge == null) {
            throw new NullPointerException();
        }
        this.ensureEdgesIsMutable();
        this.edges_.set(n2, binExport$Flowgraph$Edge);
        this.onChanged();
        return this;
    }

    public BinExport$Flowgraph$Builder setEdges(int n2, BinExport$Flowgraph$Edge$Builder binExport$Flowgraph$Edge$Builder) {
        if (this.edgesBuilder_ == null) {
            this.ensureEdgesIsMutable();
            this.edges_.set(n2, binExport$Flowgraph$Edge$Builder.build());
            this.onChanged();
            return this;
        }
        this.edgesBuilder_.setMessage(n2, binExport$Flowgraph$Edge$Builder.build());
        return this;
    }

    public BinExport$Flowgraph$Builder addEdges(BinExport$Flowgraph$Edge binExport$Flowgraph$Edge) {
        if (this.edgesBuilder_ != null) {
            this.edgesBuilder_.addMessage(binExport$Flowgraph$Edge);
            return this;
        }
        if (binExport$Flowgraph$Edge == null) {
            throw new NullPointerException();
        }
        this.ensureEdgesIsMutable();
        this.edges_.add(binExport$Flowgraph$Edge);
        this.onChanged();
        return this;
    }

    public BinExport$Flowgraph$Builder addEdges(int n2, BinExport$Flowgraph$Edge binExport$Flowgraph$Edge) {
        if (this.edgesBuilder_ != null) {
            this.edgesBuilder_.addMessage(n2, binExport$Flowgraph$Edge);
            return this;
        }
        if (binExport$Flowgraph$Edge == null) {
            throw new NullPointerException();
        }
        this.ensureEdgesIsMutable();
        this.edges_.add(n2, binExport$Flowgraph$Edge);
        this.onChanged();
        return this;
    }

    public BinExport$Flowgraph$Builder addEdges(BinExport$Flowgraph$Edge$Builder binExport$Flowgraph$Edge$Builder) {
        if (this.edgesBuilder_ == null) {
            this.ensureEdgesIsMutable();
            this.edges_.add(binExport$Flowgraph$Edge$Builder.build());
            this.onChanged();
            return this;
        }
        this.edgesBuilder_.addMessage(binExport$Flowgraph$Edge$Builder.build());
        return this;
    }

    public BinExport$Flowgraph$Builder addEdges(int n2, BinExport$Flowgraph$Edge$Builder binExport$Flowgraph$Edge$Builder) {
        if (this.edgesBuilder_ == null) {
            this.ensureEdgesIsMutable();
            this.edges_.add(n2, binExport$Flowgraph$Edge$Builder.build());
            this.onChanged();
            return this;
        }
        this.edgesBuilder_.addMessage(n2, binExport$Flowgraph$Edge$Builder.build());
        return this;
    }

    public BinExport$Flowgraph$Builder addAllEdges(Iterable iterable) {
        if (this.edgesBuilder_ == null) {
            this.ensureEdgesIsMutable();
            AbstractMessageLite$Builder.addAll(iterable, this.edges_);
            this.onChanged();
            return this;
        }
        this.edgesBuilder_.addAllMessages(iterable);
        return this;
    }

    public BinExport$Flowgraph$Builder clearEdges() {
        if (this.edgesBuilder_ == null) {
            this.edges_ = Collections.emptyList();
            this.bitField0_ &= -5;
            this.onChanged();
            return this;
        }
        this.edgesBuilder_.clear();
        return this;
    }

    public BinExport$Flowgraph$Builder removeEdges(int n2) {
        if (this.edgesBuilder_ == null) {
            this.ensureEdgesIsMutable();
            this.edges_.remove(n2);
            this.onChanged();
            return this;
        }
        this.edgesBuilder_.remove(n2);
        return this;
    }

    public BinExport$Flowgraph$Edge$Builder getEdgesBuilder(int n2) {
        return (BinExport$Flowgraph$Edge$Builder)this.getEdgesFieldBuilder().getBuilder(n2);
    }

    @Override
    public BinExport$Flowgraph$EdgeOrBuilder getEdgesOrBuilder(int n2) {
        if (this.edgesBuilder_ != null) return (BinExport$Flowgraph$EdgeOrBuilder)this.edgesBuilder_.getMessageOrBuilder(n2);
        return (BinExport$Flowgraph$EdgeOrBuilder)this.edges_.get(n2);
    }

    @Override
    public List getEdgesOrBuilderList() {
        if (this.edgesBuilder_ == null) return Collections.unmodifiableList(this.edges_);
        return this.edgesBuilder_.getMessageOrBuilderList();
    }

    public BinExport$Flowgraph$Edge$Builder addEdgesBuilder() {
        return (BinExport$Flowgraph$Edge$Builder)this.getEdgesFieldBuilder().addBuilder(BinExport$Flowgraph$Edge.getDefaultInstance());
    }

    public BinExport$Flowgraph$Edge$Builder addEdgesBuilder(int n2) {
        return (BinExport$Flowgraph$Edge$Builder)this.getEdgesFieldBuilder().addBuilder(n2, BinExport$Flowgraph$Edge.getDefaultInstance());
    }

    public List getEdgesBuilderList() {
        return this.getEdgesFieldBuilder().getBuilderList();
    }

    private RepeatedFieldBuilder getEdgesFieldBuilder() {
        if (this.edgesBuilder_ != null) return this.edgesBuilder_;
        this.edgesBuilder_ = new RepeatedFieldBuilder(this.edges_, (this.bitField0_ & 4) == 4, this.getParentForChildren(), this.isClean());
        this.edges_ = null;
        return this.edgesBuilder_;
    }

    /* synthetic */ BinExport$Flowgraph$Builder(BinExport$1 binExport$1) {
        this();
    }

    /* synthetic */ BinExport$Flowgraph$Builder(GeneratedMessage$BuilderParent generatedMessage$BuilderParent, BinExport$1 binExport$1) {
        this(generatedMessage$BuilderParent);
    }
}

