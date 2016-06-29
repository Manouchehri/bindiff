/*
 * Decompiled with CFR 0_115.
 */
package com.google.protos.BinExport;

import com.google.protobuf.AbstractMessage$Builder;
import com.google.protobuf.AbstractMessageLite$Builder;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.Descriptors;
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
import com.google.protos.BinExport.BinExport$Callgraph;
import com.google.protos.BinExport.BinExport$Callgraph$Edge;
import com.google.protos.BinExport.BinExport$Callgraph$Edge$Builder;
import com.google.protos.BinExport.BinExport$Callgraph$EdgeOrBuilder;
import com.google.protos.BinExport.BinExport$Callgraph$Vertex;
import com.google.protos.BinExport.BinExport$Callgraph$Vertex$Builder;
import com.google.protos.BinExport.BinExport$Callgraph$VertexOrBuilder;
import com.google.protos.BinExport.BinExport$CallgraphOrBuilder;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public final class BinExport$Callgraph$Builder
extends GeneratedMessage$Builder
implements BinExport$CallgraphOrBuilder {
    private int bitField0_;
    private List vertices_ = Collections.emptyList();
    private RepeatedFieldBuilder verticesBuilder_;
    private List edges_ = Collections.emptyList();
    private RepeatedFieldBuilder edgesBuilder_;

    public static final Descriptors.Descriptor getDescriptor() {
        return BinExport.access$1800();
    }

    @Override
    protected GeneratedMessage$FieldAccessorTable internalGetFieldAccessorTable() {
        return BinExport.access$1900().ensureFieldAccessorsInitialized(BinExport$Callgraph.class, BinExport$Callgraph$Builder.class);
    }

    private BinExport$Callgraph$Builder() {
        this.maybeForceBuilderInitialization();
    }

    private BinExport$Callgraph$Builder(GeneratedMessage$BuilderParent builderParent) {
        super(builderParent);
        this.maybeForceBuilderInitialization();
    }

    private void maybeForceBuilderInitialization() {
        if (!BinExport$Callgraph.access$4900()) return;
        this.getVerticesFieldBuilder();
        this.getEdgesFieldBuilder();
    }

    @Override
    public BinExport$Callgraph$Builder clear() {
        super.clear();
        if (this.verticesBuilder_ == null) {
            this.vertices_ = Collections.emptyList();
            this.bitField0_ &= -2;
        } else {
            this.verticesBuilder_.clear();
        }
        if (this.edgesBuilder_ == null) {
            this.edges_ = Collections.emptyList();
            this.bitField0_ &= -3;
            return this;
        }
        this.edgesBuilder_.clear();
        return this;
    }

    @Override
    public Descriptors.Descriptor getDescriptorForType() {
        return BinExport.access$1800();
    }

    @Override
    public BinExport$Callgraph getDefaultInstanceForType() {
        return BinExport$Callgraph.getDefaultInstance();
    }

    @Override
    public BinExport$Callgraph build() {
        BinExport$Callgraph binExport$Callgraph = this.buildPartial();
        if (binExport$Callgraph.isInitialized()) return binExport$Callgraph;
        throw BinExport$Callgraph$Builder.newUninitializedMessageException(binExport$Callgraph);
    }

    @Override
    public BinExport$Callgraph buildPartial() {
        BinExport$Callgraph binExport$Callgraph = new BinExport$Callgraph(this, null);
        int n2 = this.bitField0_;
        if (this.verticesBuilder_ == null) {
            if ((this.bitField0_ & 1) == 1) {
                this.vertices_ = Collections.unmodifiableList(this.vertices_);
                this.bitField0_ &= -2;
            }
            BinExport$Callgraph.access$5102(binExport$Callgraph, this.vertices_);
        } else {
            BinExport$Callgraph.access$5102(binExport$Callgraph, this.verticesBuilder_.build());
        }
        if (this.edgesBuilder_ == null) {
            if ((this.bitField0_ & 2) == 2) {
                this.edges_ = Collections.unmodifiableList(this.edges_);
                this.bitField0_ &= -3;
            }
            BinExport$Callgraph.access$5202(binExport$Callgraph, this.edges_);
        } else {
            BinExport$Callgraph.access$5202(binExport$Callgraph, this.edgesBuilder_.build());
        }
        this.onBuilt();
        return binExport$Callgraph;
    }

    @Override
    public BinExport$Callgraph$Builder mergeFrom(Message message) {
        if (message instanceof BinExport$Callgraph) {
            return this.mergeFrom((BinExport$Callgraph)message);
        }
        super.mergeFrom(message);
        return this;
    }

    public BinExport$Callgraph$Builder mergeFrom(BinExport$Callgraph binExport$Callgraph) {
        if (binExport$Callgraph == BinExport$Callgraph.getDefaultInstance()) {
            return this;
        }
        if (this.verticesBuilder_ == null) {
            if (!BinExport$Callgraph.access$5100(binExport$Callgraph).isEmpty()) {
                if (this.vertices_.isEmpty()) {
                    this.vertices_ = BinExport$Callgraph.access$5100(binExport$Callgraph);
                    this.bitField0_ &= -2;
                } else {
                    this.ensureVerticesIsMutable();
                    this.vertices_.addAll(BinExport$Callgraph.access$5100(binExport$Callgraph));
                }
                this.onChanged();
            }
        } else if (!BinExport$Callgraph.access$5100(binExport$Callgraph).isEmpty()) {
            if (this.verticesBuilder_.isEmpty()) {
                this.verticesBuilder_.dispose();
                this.verticesBuilder_ = null;
                this.vertices_ = BinExport$Callgraph.access$5100(binExport$Callgraph);
                this.bitField0_ &= -2;
                this.verticesBuilder_ = BinExport$Callgraph.access$5300() ? this.getVerticesFieldBuilder() : null;
            } else {
                this.verticesBuilder_.addAllMessages(BinExport$Callgraph.access$5100(binExport$Callgraph));
            }
        }
        if (this.edgesBuilder_ == null) {
            if (!BinExport$Callgraph.access$5200(binExport$Callgraph).isEmpty()) {
                if (this.edges_.isEmpty()) {
                    this.edges_ = BinExport$Callgraph.access$5200(binExport$Callgraph);
                    this.bitField0_ &= -3;
                } else {
                    this.ensureEdgesIsMutable();
                    this.edges_.addAll(BinExport$Callgraph.access$5200(binExport$Callgraph));
                }
                this.onChanged();
            }
        } else if (!BinExport$Callgraph.access$5200(binExport$Callgraph).isEmpty()) {
            if (this.edgesBuilder_.isEmpty()) {
                this.edgesBuilder_.dispose();
                this.edgesBuilder_ = null;
                this.edges_ = BinExport$Callgraph.access$5200(binExport$Callgraph);
                this.bitField0_ &= -3;
                this.edgesBuilder_ = BinExport$Callgraph.access$5400() ? this.getEdgesFieldBuilder() : null;
            } else {
                this.edgesBuilder_.addAllMessages(BinExport$Callgraph.access$5200(binExport$Callgraph));
            }
        }
        this.mergeUnknownFields(BinExport$Callgraph.access$5500(binExport$Callgraph));
        this.onChanged();
        return this;
    }

    @Override
    public final boolean isInitialized() {
        int n2;
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
    public BinExport$Callgraph$Builder mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        BinExport$Callgraph binExport$Callgraph = null;
        try {
            binExport$Callgraph = (BinExport$Callgraph)BinExport$Callgraph.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
            return this;
        }
        catch (InvalidProtocolBufferException var4_4) {
            binExport$Callgraph = (BinExport$Callgraph)var4_4.getUnfinishedMessage();
            throw var4_4;
        }
        finally {
            if (binExport$Callgraph != null) {
                this.mergeFrom(binExport$Callgraph);
            }
        }
    }

    private void ensureVerticesIsMutable() {
        if ((this.bitField0_ & 1) == 1) return;
        this.vertices_ = new ArrayList(this.vertices_);
        this.bitField0_ |= 1;
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
    public BinExport$Callgraph$Vertex getVertices(int n2) {
        if (this.verticesBuilder_ != null) return (BinExport$Callgraph$Vertex)this.verticesBuilder_.getMessage(n2);
        return (BinExport$Callgraph$Vertex)this.vertices_.get(n2);
    }

    public BinExport$Callgraph$Builder setVertices(int n2, BinExport$Callgraph$Vertex binExport$Callgraph$Vertex) {
        if (this.verticesBuilder_ != null) {
            this.verticesBuilder_.setMessage(n2, binExport$Callgraph$Vertex);
            return this;
        }
        if (binExport$Callgraph$Vertex == null) {
            throw new NullPointerException();
        }
        this.ensureVerticesIsMutable();
        this.vertices_.set(n2, binExport$Callgraph$Vertex);
        this.onChanged();
        return this;
    }

    public BinExport$Callgraph$Builder setVertices(int n2, BinExport$Callgraph$Vertex$Builder binExport$Callgraph$Vertex$Builder) {
        if (this.verticesBuilder_ == null) {
            this.ensureVerticesIsMutable();
            this.vertices_.set(n2, binExport$Callgraph$Vertex$Builder.build());
            this.onChanged();
            return this;
        }
        this.verticesBuilder_.setMessage(n2, binExport$Callgraph$Vertex$Builder.build());
        return this;
    }

    public BinExport$Callgraph$Builder addVertices(BinExport$Callgraph$Vertex binExport$Callgraph$Vertex) {
        if (this.verticesBuilder_ != null) {
            this.verticesBuilder_.addMessage(binExport$Callgraph$Vertex);
            return this;
        }
        if (binExport$Callgraph$Vertex == null) {
            throw new NullPointerException();
        }
        this.ensureVerticesIsMutable();
        this.vertices_.add(binExport$Callgraph$Vertex);
        this.onChanged();
        return this;
    }

    public BinExport$Callgraph$Builder addVertices(int n2, BinExport$Callgraph$Vertex binExport$Callgraph$Vertex) {
        if (this.verticesBuilder_ != null) {
            this.verticesBuilder_.addMessage(n2, binExport$Callgraph$Vertex);
            return this;
        }
        if (binExport$Callgraph$Vertex == null) {
            throw new NullPointerException();
        }
        this.ensureVerticesIsMutable();
        this.vertices_.add(n2, binExport$Callgraph$Vertex);
        this.onChanged();
        return this;
    }

    public BinExport$Callgraph$Builder addVertices(BinExport$Callgraph$Vertex$Builder binExport$Callgraph$Vertex$Builder) {
        if (this.verticesBuilder_ == null) {
            this.ensureVerticesIsMutable();
            this.vertices_.add(binExport$Callgraph$Vertex$Builder.build());
            this.onChanged();
            return this;
        }
        this.verticesBuilder_.addMessage(binExport$Callgraph$Vertex$Builder.build());
        return this;
    }

    public BinExport$Callgraph$Builder addVertices(int n2, BinExport$Callgraph$Vertex$Builder binExport$Callgraph$Vertex$Builder) {
        if (this.verticesBuilder_ == null) {
            this.ensureVerticesIsMutable();
            this.vertices_.add(n2, binExport$Callgraph$Vertex$Builder.build());
            this.onChanged();
            return this;
        }
        this.verticesBuilder_.addMessage(n2, binExport$Callgraph$Vertex$Builder.build());
        return this;
    }

    public BinExport$Callgraph$Builder addAllVertices(Iterable iterable) {
        if (this.verticesBuilder_ == null) {
            this.ensureVerticesIsMutable();
            AbstractMessageLite$Builder.addAll(iterable, this.vertices_);
            this.onChanged();
            return this;
        }
        this.verticesBuilder_.addAllMessages(iterable);
        return this;
    }

    public BinExport$Callgraph$Builder clearVertices() {
        if (this.verticesBuilder_ == null) {
            this.vertices_ = Collections.emptyList();
            this.bitField0_ &= -2;
            this.onChanged();
            return this;
        }
        this.verticesBuilder_.clear();
        return this;
    }

    public BinExport$Callgraph$Builder removeVertices(int n2) {
        if (this.verticesBuilder_ == null) {
            this.ensureVerticesIsMutable();
            this.vertices_.remove(n2);
            this.onChanged();
            return this;
        }
        this.verticesBuilder_.remove(n2);
        return this;
    }

    public BinExport$Callgraph$Vertex$Builder getVerticesBuilder(int n2) {
        return (BinExport$Callgraph$Vertex$Builder)this.getVerticesFieldBuilder().getBuilder(n2);
    }

    @Override
    public BinExport$Callgraph$VertexOrBuilder getVerticesOrBuilder(int n2) {
        if (this.verticesBuilder_ != null) return (BinExport$Callgraph$VertexOrBuilder)this.verticesBuilder_.getMessageOrBuilder(n2);
        return (BinExport$Callgraph$VertexOrBuilder)this.vertices_.get(n2);
    }

    @Override
    public List getVerticesOrBuilderList() {
        if (this.verticesBuilder_ == null) return Collections.unmodifiableList(this.vertices_);
        return this.verticesBuilder_.getMessageOrBuilderList();
    }

    public BinExport$Callgraph$Vertex$Builder addVerticesBuilder() {
        return (BinExport$Callgraph$Vertex$Builder)this.getVerticesFieldBuilder().addBuilder(BinExport$Callgraph$Vertex.getDefaultInstance());
    }

    public BinExport$Callgraph$Vertex$Builder addVerticesBuilder(int n2) {
        return (BinExport$Callgraph$Vertex$Builder)this.getVerticesFieldBuilder().addBuilder(n2, BinExport$Callgraph$Vertex.getDefaultInstance());
    }

    public List getVerticesBuilderList() {
        return this.getVerticesFieldBuilder().getBuilderList();
    }

    private RepeatedFieldBuilder getVerticesFieldBuilder() {
        if (this.verticesBuilder_ != null) return this.verticesBuilder_;
        this.verticesBuilder_ = new RepeatedFieldBuilder(this.vertices_, (this.bitField0_ & 1) == 1, this.getParentForChildren(), this.isClean());
        this.vertices_ = null;
        return this.verticesBuilder_;
    }

    private void ensureEdgesIsMutable() {
        if ((this.bitField0_ & 2) == 2) return;
        this.edges_ = new ArrayList(this.edges_);
        this.bitField0_ |= 2;
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
    public BinExport$Callgraph$Edge getEdges(int n2) {
        if (this.edgesBuilder_ != null) return (BinExport$Callgraph$Edge)this.edgesBuilder_.getMessage(n2);
        return (BinExport$Callgraph$Edge)this.edges_.get(n2);
    }

    public BinExport$Callgraph$Builder setEdges(int n2, BinExport$Callgraph$Edge binExport$Callgraph$Edge) {
        if (this.edgesBuilder_ != null) {
            this.edgesBuilder_.setMessage(n2, binExport$Callgraph$Edge);
            return this;
        }
        if (binExport$Callgraph$Edge == null) {
            throw new NullPointerException();
        }
        this.ensureEdgesIsMutable();
        this.edges_.set(n2, binExport$Callgraph$Edge);
        this.onChanged();
        return this;
    }

    public BinExport$Callgraph$Builder setEdges(int n2, BinExport$Callgraph$Edge$Builder binExport$Callgraph$Edge$Builder) {
        if (this.edgesBuilder_ == null) {
            this.ensureEdgesIsMutable();
            this.edges_.set(n2, binExport$Callgraph$Edge$Builder.build());
            this.onChanged();
            return this;
        }
        this.edgesBuilder_.setMessage(n2, binExport$Callgraph$Edge$Builder.build());
        return this;
    }

    public BinExport$Callgraph$Builder addEdges(BinExport$Callgraph$Edge binExport$Callgraph$Edge) {
        if (this.edgesBuilder_ != null) {
            this.edgesBuilder_.addMessage(binExport$Callgraph$Edge);
            return this;
        }
        if (binExport$Callgraph$Edge == null) {
            throw new NullPointerException();
        }
        this.ensureEdgesIsMutable();
        this.edges_.add(binExport$Callgraph$Edge);
        this.onChanged();
        return this;
    }

    public BinExport$Callgraph$Builder addEdges(int n2, BinExport$Callgraph$Edge binExport$Callgraph$Edge) {
        if (this.edgesBuilder_ != null) {
            this.edgesBuilder_.addMessage(n2, binExport$Callgraph$Edge);
            return this;
        }
        if (binExport$Callgraph$Edge == null) {
            throw new NullPointerException();
        }
        this.ensureEdgesIsMutable();
        this.edges_.add(n2, binExport$Callgraph$Edge);
        this.onChanged();
        return this;
    }

    public BinExport$Callgraph$Builder addEdges(BinExport$Callgraph$Edge$Builder binExport$Callgraph$Edge$Builder) {
        if (this.edgesBuilder_ == null) {
            this.ensureEdgesIsMutable();
            this.edges_.add(binExport$Callgraph$Edge$Builder.build());
            this.onChanged();
            return this;
        }
        this.edgesBuilder_.addMessage(binExport$Callgraph$Edge$Builder.build());
        return this;
    }

    public BinExport$Callgraph$Builder addEdges(int n2, BinExport$Callgraph$Edge$Builder binExport$Callgraph$Edge$Builder) {
        if (this.edgesBuilder_ == null) {
            this.ensureEdgesIsMutable();
            this.edges_.add(n2, binExport$Callgraph$Edge$Builder.build());
            this.onChanged();
            return this;
        }
        this.edgesBuilder_.addMessage(n2, binExport$Callgraph$Edge$Builder.build());
        return this;
    }

    public BinExport$Callgraph$Builder addAllEdges(Iterable iterable) {
        if (this.edgesBuilder_ == null) {
            this.ensureEdgesIsMutable();
            AbstractMessageLite$Builder.addAll(iterable, this.edges_);
            this.onChanged();
            return this;
        }
        this.edgesBuilder_.addAllMessages(iterable);
        return this;
    }

    public BinExport$Callgraph$Builder clearEdges() {
        if (this.edgesBuilder_ == null) {
            this.edges_ = Collections.emptyList();
            this.bitField0_ &= -3;
            this.onChanged();
            return this;
        }
        this.edgesBuilder_.clear();
        return this;
    }

    public BinExport$Callgraph$Builder removeEdges(int n2) {
        if (this.edgesBuilder_ == null) {
            this.ensureEdgesIsMutable();
            this.edges_.remove(n2);
            this.onChanged();
            return this;
        }
        this.edgesBuilder_.remove(n2);
        return this;
    }

    public BinExport$Callgraph$Edge$Builder getEdgesBuilder(int n2) {
        return (BinExport$Callgraph$Edge$Builder)this.getEdgesFieldBuilder().getBuilder(n2);
    }

    @Override
    public BinExport$Callgraph$EdgeOrBuilder getEdgesOrBuilder(int n2) {
        if (this.edgesBuilder_ != null) return (BinExport$Callgraph$EdgeOrBuilder)this.edgesBuilder_.getMessageOrBuilder(n2);
        return (BinExport$Callgraph$EdgeOrBuilder)this.edges_.get(n2);
    }

    @Override
    public List getEdgesOrBuilderList() {
        if (this.edgesBuilder_ == null) return Collections.unmodifiableList(this.edges_);
        return this.edgesBuilder_.getMessageOrBuilderList();
    }

    public BinExport$Callgraph$Edge$Builder addEdgesBuilder() {
        return (BinExport$Callgraph$Edge$Builder)this.getEdgesFieldBuilder().addBuilder(BinExport$Callgraph$Edge.getDefaultInstance());
    }

    public BinExport$Callgraph$Edge$Builder addEdgesBuilder(int n2) {
        return (BinExport$Callgraph$Edge$Builder)this.getEdgesFieldBuilder().addBuilder(n2, BinExport$Callgraph$Edge.getDefaultInstance());
    }

    public List getEdgesBuilderList() {
        return this.getEdgesFieldBuilder().getBuilderList();
    }

    private RepeatedFieldBuilder getEdgesFieldBuilder() {
        if (this.edgesBuilder_ != null) return this.edgesBuilder_;
        this.edgesBuilder_ = new RepeatedFieldBuilder(this.edges_, (this.bitField0_ & 2) == 2, this.getParentForChildren(), this.isClean());
        this.edges_ = null;
        return this.edgesBuilder_;
    }

    /* synthetic */ BinExport$Callgraph$Builder(BinExport$1 binExport$1) {
        this();
    }

    /* synthetic */ BinExport$Callgraph$Builder(GeneratedMessage$BuilderParent generatedMessage$BuilderParent, BinExport$1 binExport$1) {
        this(generatedMessage$BuilderParent);
    }
}

