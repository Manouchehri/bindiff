package com.google.protos.BinExport;

import java.util.*;
import com.google.protobuf.*;
import java.io.*;

public final class BinExport$Callgraph$Builder extends GeneratedMessage$Builder implements BinExport$CallgraphOrBuilder
{
    private int bitField0_;
    private List vertices_;
    private RepeatedFieldBuilder verticesBuilder_;
    private List edges_;
    private RepeatedFieldBuilder edgesBuilder_;
    
    public static final Descriptors$Descriptor getDescriptor() {
        return BinExport.internal_static_BinExport_Callgraph_descriptor;
    }
    
    @Override
    protected GeneratedMessage$FieldAccessorTable internalGetFieldAccessorTable() {
        return BinExport.internal_static_BinExport_Callgraph_fieldAccessorTable.ensureFieldAccessorsInitialized(BinExport$Callgraph.class, BinExport$Callgraph$Builder.class);
    }
    
    private BinExport$Callgraph$Builder() {
        this.vertices_ = Collections.emptyList();
        this.edges_ = Collections.emptyList();
        this.maybeForceBuilderInitialization();
    }
    
    private BinExport$Callgraph$Builder(final GeneratedMessage$BuilderParent generatedMessage$BuilderParent) {
        super(generatedMessage$BuilderParent);
        this.vertices_ = Collections.emptyList();
        this.edges_ = Collections.emptyList();
        this.maybeForceBuilderInitialization();
    }
    
    private void maybeForceBuilderInitialization() {
        if (BinExport$Callgraph.alwaysUseFieldBuilders) {
            this.getVerticesFieldBuilder();
            this.getEdgesFieldBuilder();
        }
    }
    
    @Override
    public BinExport$Callgraph$Builder clear() {
        super.clear();
        if (this.verticesBuilder_ == null) {
            this.vertices_ = Collections.emptyList();
            this.bitField0_ &= 0xFFFFFFFE;
        }
        else {
            this.verticesBuilder_.clear();
        }
        if (this.edgesBuilder_ == null) {
            this.edges_ = Collections.emptyList();
            this.bitField0_ &= 0xFFFFFFFD;
        }
        else {
            this.edgesBuilder_.clear();
        }
        return this;
    }
    
    @Override
    public Descriptors$Descriptor getDescriptorForType() {
        return BinExport.internal_static_BinExport_Callgraph_descriptor;
    }
    
    @Override
    public BinExport$Callgraph getDefaultInstanceForType() {
        return BinExport$Callgraph.getDefaultInstance();
    }
    
    @Override
    public BinExport$Callgraph build() {
        final BinExport$Callgraph buildPartial = this.buildPartial();
        if (!buildPartial.isInitialized()) {
            throw AbstractMessage$Builder.newUninitializedMessageException(buildPartial);
        }
        return buildPartial;
    }
    
    @Override
    public BinExport$Callgraph buildPartial() {
        final BinExport$Callgraph binExport$Callgraph = new BinExport$Callgraph(this, null);
        final int bitField0_ = this.bitField0_;
        if (this.verticesBuilder_ == null) {
            if ((this.bitField0_ & 0x1) == 0x1) {
                this.vertices_ = Collections.unmodifiableList((List<?>)this.vertices_);
                this.bitField0_ &= 0xFFFFFFFE;
            }
            binExport$Callgraph.vertices_ = this.vertices_;
        }
        else {
            binExport$Callgraph.vertices_ = this.verticesBuilder_.build();
        }
        if (this.edgesBuilder_ == null) {
            if ((this.bitField0_ & 0x2) == 0x2) {
                this.edges_ = Collections.unmodifiableList((List<?>)this.edges_);
                this.bitField0_ &= 0xFFFFFFFD;
            }
            binExport$Callgraph.edges_ = this.edges_;
        }
        else {
            binExport$Callgraph.edges_ = this.edgesBuilder_.build();
        }
        this.onBuilt();
        return binExport$Callgraph;
    }
    
    @Override
    public BinExport$Callgraph$Builder mergeFrom(final Message message) {
        if (message instanceof BinExport$Callgraph) {
            return this.mergeFrom((BinExport$Callgraph)message);
        }
        super.mergeFrom(message);
        return this;
    }
    
    public BinExport$Callgraph$Builder mergeFrom(final BinExport$Callgraph binExport$Callgraph) {
        if (binExport$Callgraph == BinExport$Callgraph.getDefaultInstance()) {
            return this;
        }
        if (this.verticesBuilder_ == null) {
            if (!binExport$Callgraph.vertices_.isEmpty()) {
                if (this.vertices_.isEmpty()) {
                    this.vertices_ = binExport$Callgraph.vertices_;
                    this.bitField0_ &= 0xFFFFFFFE;
                }
                else {
                    this.ensureVerticesIsMutable();
                    this.vertices_.addAll(binExport$Callgraph.vertices_);
                }
                this.onChanged();
            }
        }
        else if (!binExport$Callgraph.vertices_.isEmpty()) {
            if (this.verticesBuilder_.isEmpty()) {
                this.verticesBuilder_.dispose();
                this.verticesBuilder_ = null;
                this.vertices_ = binExport$Callgraph.vertices_;
                this.bitField0_ &= 0xFFFFFFFE;
                this.verticesBuilder_ = (BinExport$Callgraph.alwaysUseFieldBuilders ? this.getVerticesFieldBuilder() : null);
            }
            else {
                this.verticesBuilder_.addAllMessages(binExport$Callgraph.vertices_);
            }
        }
        if (this.edgesBuilder_ == null) {
            if (!binExport$Callgraph.edges_.isEmpty()) {
                if (this.edges_.isEmpty()) {
                    this.edges_ = binExport$Callgraph.edges_;
                    this.bitField0_ &= 0xFFFFFFFD;
                }
                else {
                    this.ensureEdgesIsMutable();
                    this.edges_.addAll(binExport$Callgraph.edges_);
                }
                this.onChanged();
            }
        }
        else if (!binExport$Callgraph.edges_.isEmpty()) {
            if (this.edgesBuilder_.isEmpty()) {
                this.edgesBuilder_.dispose();
                this.edgesBuilder_ = null;
                this.edges_ = binExport$Callgraph.edges_;
                this.bitField0_ &= 0xFFFFFFFD;
                this.edgesBuilder_ = (BinExport$Callgraph.alwaysUseFieldBuilders ? this.getEdgesFieldBuilder() : null);
            }
            else {
                this.edgesBuilder_.addAllMessages(binExport$Callgraph.edges_);
            }
        }
        this.mergeUnknownFields(binExport$Callgraph.unknownFields);
        this.onChanged();
        return this;
    }
    
    @Override
    public final boolean isInitialized() {
        for (int i = 0; i < this.getVerticesCount(); ++i) {
            if (!this.getVertices(i).isInitialized()) {
                return false;
            }
        }
        for (int j = 0; j < this.getEdgesCount(); ++j) {
            if (!this.getEdges(j).isInitialized()) {
                return false;
            }
        }
        return true;
    }
    
    @Override
    public BinExport$Callgraph$Builder mergeFrom(final CodedInputStream codedInputStream, final ExtensionRegistryLite extensionRegistryLite) {
        BinExport$Callgraph binExport$Callgraph = null;
        try {
            binExport$Callgraph = (BinExport$Callgraph)BinExport$Callgraph.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
        }
        catch (InvalidProtocolBufferException ex) {
            binExport$Callgraph = (BinExport$Callgraph)ex.getUnfinishedMessage();
            throw ex;
        }
        finally {
            if (binExport$Callgraph != null) {
                this.mergeFrom(binExport$Callgraph);
            }
        }
        return this;
    }
    
    private void ensureVerticesIsMutable() {
        if ((this.bitField0_ & 0x1) != 0x1) {
            this.vertices_ = new ArrayList(this.vertices_);
            this.bitField0_ |= 0x1;
        }
    }
    
    @Override
    public List getVerticesList() {
        if (this.verticesBuilder_ == null) {
            return Collections.unmodifiableList((List<?>)this.vertices_);
        }
        return this.verticesBuilder_.getMessageList();
    }
    
    @Override
    public int getVerticesCount() {
        if (this.verticesBuilder_ == null) {
            return this.vertices_.size();
        }
        return this.verticesBuilder_.getCount();
    }
    
    @Override
    public BinExport$Callgraph$Vertex getVertices(final int n) {
        if (this.verticesBuilder_ == null) {
            return this.vertices_.get(n);
        }
        return (BinExport$Callgraph$Vertex)this.verticesBuilder_.getMessage(n);
    }
    
    public BinExport$Callgraph$Builder setVertices(final int n, final BinExport$Callgraph$Vertex binExport$Callgraph$Vertex) {
        if (this.verticesBuilder_ == null) {
            if (binExport$Callgraph$Vertex == null) {
                throw new NullPointerException();
            }
            this.ensureVerticesIsMutable();
            this.vertices_.set(n, binExport$Callgraph$Vertex);
            this.onChanged();
        }
        else {
            this.verticesBuilder_.setMessage(n, binExport$Callgraph$Vertex);
        }
        return this;
    }
    
    public BinExport$Callgraph$Builder setVertices(final int n, final BinExport$Callgraph$Vertex$Builder binExport$Callgraph$Vertex$Builder) {
        if (this.verticesBuilder_ == null) {
            this.ensureVerticesIsMutable();
            this.vertices_.set(n, binExport$Callgraph$Vertex$Builder.build());
            this.onChanged();
        }
        else {
            this.verticesBuilder_.setMessage(n, binExport$Callgraph$Vertex$Builder.build());
        }
        return this;
    }
    
    public BinExport$Callgraph$Builder addVertices(final BinExport$Callgraph$Vertex binExport$Callgraph$Vertex) {
        if (this.verticesBuilder_ == null) {
            if (binExport$Callgraph$Vertex == null) {
                throw new NullPointerException();
            }
            this.ensureVerticesIsMutable();
            this.vertices_.add(binExport$Callgraph$Vertex);
            this.onChanged();
        }
        else {
            this.verticesBuilder_.addMessage(binExport$Callgraph$Vertex);
        }
        return this;
    }
    
    public BinExport$Callgraph$Builder addVertices(final int n, final BinExport$Callgraph$Vertex binExport$Callgraph$Vertex) {
        if (this.verticesBuilder_ == null) {
            if (binExport$Callgraph$Vertex == null) {
                throw new NullPointerException();
            }
            this.ensureVerticesIsMutable();
            this.vertices_.add(n, binExport$Callgraph$Vertex);
            this.onChanged();
        }
        else {
            this.verticesBuilder_.addMessage(n, binExport$Callgraph$Vertex);
        }
        return this;
    }
    
    public BinExport$Callgraph$Builder addVertices(final BinExport$Callgraph$Vertex$Builder binExport$Callgraph$Vertex$Builder) {
        if (this.verticesBuilder_ == null) {
            this.ensureVerticesIsMutable();
            this.vertices_.add(binExport$Callgraph$Vertex$Builder.build());
            this.onChanged();
        }
        else {
            this.verticesBuilder_.addMessage(binExport$Callgraph$Vertex$Builder.build());
        }
        return this;
    }
    
    public BinExport$Callgraph$Builder addVertices(final int n, final BinExport$Callgraph$Vertex$Builder binExport$Callgraph$Vertex$Builder) {
        if (this.verticesBuilder_ == null) {
            this.ensureVerticesIsMutable();
            this.vertices_.add(n, binExport$Callgraph$Vertex$Builder.build());
            this.onChanged();
        }
        else {
            this.verticesBuilder_.addMessage(n, binExport$Callgraph$Vertex$Builder.build());
        }
        return this;
    }
    
    public BinExport$Callgraph$Builder addAllVertices(final Iterable iterable) {
        if (this.verticesBuilder_ == null) {
            this.ensureVerticesIsMutable();
            AbstractMessageLite$Builder.addAll(iterable, this.vertices_);
            this.onChanged();
        }
        else {
            this.verticesBuilder_.addAllMessages(iterable);
        }
        return this;
    }
    
    public BinExport$Callgraph$Builder clearVertices() {
        if (this.verticesBuilder_ == null) {
            this.vertices_ = Collections.emptyList();
            this.bitField0_ &= 0xFFFFFFFE;
            this.onChanged();
        }
        else {
            this.verticesBuilder_.clear();
        }
        return this;
    }
    
    public BinExport$Callgraph$Builder removeVertices(final int n) {
        if (this.verticesBuilder_ == null) {
            this.ensureVerticesIsMutable();
            this.vertices_.remove(n);
            this.onChanged();
        }
        else {
            this.verticesBuilder_.remove(n);
        }
        return this;
    }
    
    public BinExport$Callgraph$Vertex$Builder getVerticesBuilder(final int n) {
        return (BinExport$Callgraph$Vertex$Builder)this.getVerticesFieldBuilder().getBuilder(n);
    }
    
    @Override
    public BinExport$Callgraph$VertexOrBuilder getVerticesOrBuilder(final int n) {
        if (this.verticesBuilder_ == null) {
            return this.vertices_.get(n);
        }
        return (BinExport$Callgraph$VertexOrBuilder)this.verticesBuilder_.getMessageOrBuilder(n);
    }
    
    @Override
    public List getVerticesOrBuilderList() {
        if (this.verticesBuilder_ != null) {
            return this.verticesBuilder_.getMessageOrBuilderList();
        }
        return Collections.unmodifiableList((List<?>)this.vertices_);
    }
    
    public BinExport$Callgraph$Vertex$Builder addVerticesBuilder() {
        return (BinExport$Callgraph$Vertex$Builder)this.getVerticesFieldBuilder().addBuilder(BinExport$Callgraph$Vertex.getDefaultInstance());
    }
    
    public BinExport$Callgraph$Vertex$Builder addVerticesBuilder(final int n) {
        return (BinExport$Callgraph$Vertex$Builder)this.getVerticesFieldBuilder().addBuilder(n, BinExport$Callgraph$Vertex.getDefaultInstance());
    }
    
    public List getVerticesBuilderList() {
        return this.getVerticesFieldBuilder().getBuilderList();
    }
    
    private RepeatedFieldBuilder getVerticesFieldBuilder() {
        if (this.verticesBuilder_ == null) {
            this.verticesBuilder_ = new RepeatedFieldBuilder(this.vertices_, (this.bitField0_ & 0x1) == 0x1, this.getParentForChildren(), this.isClean());
            this.vertices_ = null;
        }
        return this.verticesBuilder_;
    }
    
    private void ensureEdgesIsMutable() {
        if ((this.bitField0_ & 0x2) != 0x2) {
            this.edges_ = new ArrayList(this.edges_);
            this.bitField0_ |= 0x2;
        }
    }
    
    @Override
    public List getEdgesList() {
        if (this.edgesBuilder_ == null) {
            return Collections.unmodifiableList((List<?>)this.edges_);
        }
        return this.edgesBuilder_.getMessageList();
    }
    
    @Override
    public int getEdgesCount() {
        if (this.edgesBuilder_ == null) {
            return this.edges_.size();
        }
        return this.edgesBuilder_.getCount();
    }
    
    @Override
    public BinExport$Callgraph$Edge getEdges(final int n) {
        if (this.edgesBuilder_ == null) {
            return this.edges_.get(n);
        }
        return (BinExport$Callgraph$Edge)this.edgesBuilder_.getMessage(n);
    }
    
    public BinExport$Callgraph$Builder setEdges(final int n, final BinExport$Callgraph$Edge binExport$Callgraph$Edge) {
        if (this.edgesBuilder_ == null) {
            if (binExport$Callgraph$Edge == null) {
                throw new NullPointerException();
            }
            this.ensureEdgesIsMutable();
            this.edges_.set(n, binExport$Callgraph$Edge);
            this.onChanged();
        }
        else {
            this.edgesBuilder_.setMessage(n, binExport$Callgraph$Edge);
        }
        return this;
    }
    
    public BinExport$Callgraph$Builder setEdges(final int n, final BinExport$Callgraph$Edge$Builder binExport$Callgraph$Edge$Builder) {
        if (this.edgesBuilder_ == null) {
            this.ensureEdgesIsMutable();
            this.edges_.set(n, binExport$Callgraph$Edge$Builder.build());
            this.onChanged();
        }
        else {
            this.edgesBuilder_.setMessage(n, binExport$Callgraph$Edge$Builder.build());
        }
        return this;
    }
    
    public BinExport$Callgraph$Builder addEdges(final BinExport$Callgraph$Edge binExport$Callgraph$Edge) {
        if (this.edgesBuilder_ == null) {
            if (binExport$Callgraph$Edge == null) {
                throw new NullPointerException();
            }
            this.ensureEdgesIsMutable();
            this.edges_.add(binExport$Callgraph$Edge);
            this.onChanged();
        }
        else {
            this.edgesBuilder_.addMessage(binExport$Callgraph$Edge);
        }
        return this;
    }
    
    public BinExport$Callgraph$Builder addEdges(final int n, final BinExport$Callgraph$Edge binExport$Callgraph$Edge) {
        if (this.edgesBuilder_ == null) {
            if (binExport$Callgraph$Edge == null) {
                throw new NullPointerException();
            }
            this.ensureEdgesIsMutable();
            this.edges_.add(n, binExport$Callgraph$Edge);
            this.onChanged();
        }
        else {
            this.edgesBuilder_.addMessage(n, binExport$Callgraph$Edge);
        }
        return this;
    }
    
    public BinExport$Callgraph$Builder addEdges(final BinExport$Callgraph$Edge$Builder binExport$Callgraph$Edge$Builder) {
        if (this.edgesBuilder_ == null) {
            this.ensureEdgesIsMutable();
            this.edges_.add(binExport$Callgraph$Edge$Builder.build());
            this.onChanged();
        }
        else {
            this.edgesBuilder_.addMessage(binExport$Callgraph$Edge$Builder.build());
        }
        return this;
    }
    
    public BinExport$Callgraph$Builder addEdges(final int n, final BinExport$Callgraph$Edge$Builder binExport$Callgraph$Edge$Builder) {
        if (this.edgesBuilder_ == null) {
            this.ensureEdgesIsMutable();
            this.edges_.add(n, binExport$Callgraph$Edge$Builder.build());
            this.onChanged();
        }
        else {
            this.edgesBuilder_.addMessage(n, binExport$Callgraph$Edge$Builder.build());
        }
        return this;
    }
    
    public BinExport$Callgraph$Builder addAllEdges(final Iterable iterable) {
        if (this.edgesBuilder_ == null) {
            this.ensureEdgesIsMutable();
            AbstractMessageLite$Builder.addAll(iterable, this.edges_);
            this.onChanged();
        }
        else {
            this.edgesBuilder_.addAllMessages(iterable);
        }
        return this;
    }
    
    public BinExport$Callgraph$Builder clearEdges() {
        if (this.edgesBuilder_ == null) {
            this.edges_ = Collections.emptyList();
            this.bitField0_ &= 0xFFFFFFFD;
            this.onChanged();
        }
        else {
            this.edgesBuilder_.clear();
        }
        return this;
    }
    
    public BinExport$Callgraph$Builder removeEdges(final int n) {
        if (this.edgesBuilder_ == null) {
            this.ensureEdgesIsMutable();
            this.edges_.remove(n);
            this.onChanged();
        }
        else {
            this.edgesBuilder_.remove(n);
        }
        return this;
    }
    
    public BinExport$Callgraph$Edge$Builder getEdgesBuilder(final int n) {
        return (BinExport$Callgraph$Edge$Builder)this.getEdgesFieldBuilder().getBuilder(n);
    }
    
    @Override
    public BinExport$Callgraph$EdgeOrBuilder getEdgesOrBuilder(final int n) {
        if (this.edgesBuilder_ == null) {
            return this.edges_.get(n);
        }
        return (BinExport$Callgraph$EdgeOrBuilder)this.edgesBuilder_.getMessageOrBuilder(n);
    }
    
    @Override
    public List getEdgesOrBuilderList() {
        if (this.edgesBuilder_ != null) {
            return this.edgesBuilder_.getMessageOrBuilderList();
        }
        return Collections.unmodifiableList((List<?>)this.edges_);
    }
    
    public BinExport$Callgraph$Edge$Builder addEdgesBuilder() {
        return (BinExport$Callgraph$Edge$Builder)this.getEdgesFieldBuilder().addBuilder(BinExport$Callgraph$Edge.getDefaultInstance());
    }
    
    public BinExport$Callgraph$Edge$Builder addEdgesBuilder(final int n) {
        return (BinExport$Callgraph$Edge$Builder)this.getEdgesFieldBuilder().addBuilder(n, BinExport$Callgraph$Edge.getDefaultInstance());
    }
    
    public List getEdgesBuilderList() {
        return this.getEdgesFieldBuilder().getBuilderList();
    }
    
    private RepeatedFieldBuilder getEdgesFieldBuilder() {
        if (this.edgesBuilder_ == null) {
            this.edgesBuilder_ = new RepeatedFieldBuilder(this.edges_, (this.bitField0_ & 0x2) == 0x2, this.getParentForChildren(), this.isClean());
            this.edges_ = null;
        }
        return this.edgesBuilder_;
    }
}
