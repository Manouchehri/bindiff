package com.google.protos.BinExport;

import java.util.*;
import com.google.protobuf.*;
import java.io.*;

public final class BinExport$Flowgraph$Builder extends GeneratedMessage$Builder implements BinExport$FlowgraphOrBuilder
{
    private int bitField0_;
    private long address_;
    private List vertices_;
    private RepeatedFieldBuilder verticesBuilder_;
    private List edges_;
    private RepeatedFieldBuilder edgesBuilder_;
    
    public static final Descriptors$Descriptor getDescriptor() {
        return BinExport.internal_static_BinExport_Flowgraph_descriptor;
    }
    
    @Override
    protected GeneratedMessage$FieldAccessorTable internalGetFieldAccessorTable() {
        return BinExport.internal_static_BinExport_Flowgraph_fieldAccessorTable.ensureFieldAccessorsInitialized(BinExport$Flowgraph.class, BinExport$Flowgraph$Builder.class);
    }
    
    private BinExport$Flowgraph$Builder() {
        this.vertices_ = Collections.emptyList();
        this.edges_ = Collections.emptyList();
        this.maybeForceBuilderInitialization();
    }
    
    private BinExport$Flowgraph$Builder(final GeneratedMessage$BuilderParent generatedMessage$BuilderParent) {
        super(generatedMessage$BuilderParent);
        this.vertices_ = Collections.emptyList();
        this.edges_ = Collections.emptyList();
        this.maybeForceBuilderInitialization();
    }
    
    private void maybeForceBuilderInitialization() {
        if (BinExport$Flowgraph.alwaysUseFieldBuilders) {
            this.getVerticesFieldBuilder();
            this.getEdgesFieldBuilder();
        }
    }
    
    @Override
    public BinExport$Flowgraph$Builder clear() {
        super.clear();
        this.address_ = 0L;
        this.bitField0_ &= 0xFFFFFFFE;
        if (this.verticesBuilder_ == null) {
            this.vertices_ = Collections.emptyList();
            this.bitField0_ &= 0xFFFFFFFD;
        }
        else {
            this.verticesBuilder_.clear();
        }
        if (this.edgesBuilder_ == null) {
            this.edges_ = Collections.emptyList();
            this.bitField0_ &= 0xFFFFFFFB;
        }
        else {
            this.edgesBuilder_.clear();
        }
        return this;
    }
    
    @Override
    public Descriptors$Descriptor getDescriptorForType() {
        return BinExport.internal_static_BinExport_Flowgraph_descriptor;
    }
    
    @Override
    public BinExport$Flowgraph getDefaultInstanceForType() {
        return BinExport$Flowgraph.getDefaultInstance();
    }
    
    @Override
    public BinExport$Flowgraph build() {
        final BinExport$Flowgraph buildPartial = this.buildPartial();
        if (!buildPartial.isInitialized()) {
            throw AbstractMessage$Builder.newUninitializedMessageException(buildPartial);
        }
        return buildPartial;
    }
    
    @Override
    public BinExport$Flowgraph buildPartial() {
        final BinExport$Flowgraph binExport$Flowgraph = new BinExport$Flowgraph(this, null);
        final int bitField0_ = this.bitField0_;
        int n = 0;
        if ((bitField0_ & 0x1) == 0x1) {
            n |= 0x1;
        }
        binExport$Flowgraph.address_ = this.address_;
        if (this.verticesBuilder_ == null) {
            if ((this.bitField0_ & 0x2) == 0x2) {
                this.vertices_ = Collections.unmodifiableList((List<?>)this.vertices_);
                this.bitField0_ &= 0xFFFFFFFD;
            }
            binExport$Flowgraph.vertices_ = this.vertices_;
        }
        else {
            binExport$Flowgraph.vertices_ = this.verticesBuilder_.build();
        }
        if (this.edgesBuilder_ == null) {
            if ((this.bitField0_ & 0x4) == 0x4) {
                this.edges_ = Collections.unmodifiableList((List<?>)this.edges_);
                this.bitField0_ &= 0xFFFFFFFB;
            }
            binExport$Flowgraph.edges_ = this.edges_;
        }
        else {
            binExport$Flowgraph.edges_ = this.edgesBuilder_.build();
        }
        binExport$Flowgraph.bitField0_ = n;
        this.onBuilt();
        return binExport$Flowgraph;
    }
    
    @Override
    public BinExport$Flowgraph$Builder mergeFrom(final Message message) {
        if (message instanceof BinExport$Flowgraph) {
            return this.mergeFrom((BinExport$Flowgraph)message);
        }
        super.mergeFrom(message);
        return this;
    }
    
    public BinExport$Flowgraph$Builder mergeFrom(final BinExport$Flowgraph binExport$Flowgraph) {
        if (binExport$Flowgraph == BinExport$Flowgraph.getDefaultInstance()) {
            return this;
        }
        if (binExport$Flowgraph.hasAddress()) {
            this.setAddress(binExport$Flowgraph.getAddress());
        }
        if (this.verticesBuilder_ == null) {
            if (!binExport$Flowgraph.vertices_.isEmpty()) {
                if (this.vertices_.isEmpty()) {
                    this.vertices_ = binExport$Flowgraph.vertices_;
                    this.bitField0_ &= 0xFFFFFFFD;
                }
                else {
                    this.ensureVerticesIsMutable();
                    this.vertices_.addAll(binExport$Flowgraph.vertices_);
                }
                this.onChanged();
            }
        }
        else if (!binExport$Flowgraph.vertices_.isEmpty()) {
            if (this.verticesBuilder_.isEmpty()) {
                this.verticesBuilder_.dispose();
                this.verticesBuilder_ = null;
                this.vertices_ = binExport$Flowgraph.vertices_;
                this.bitField0_ &= 0xFFFFFFFD;
                this.verticesBuilder_ = (BinExport$Flowgraph.alwaysUseFieldBuilders ? this.getVerticesFieldBuilder() : null);
            }
            else {
                this.verticesBuilder_.addAllMessages(binExport$Flowgraph.vertices_);
            }
        }
        if (this.edgesBuilder_ == null) {
            if (!binExport$Flowgraph.edges_.isEmpty()) {
                if (this.edges_.isEmpty()) {
                    this.edges_ = binExport$Flowgraph.edges_;
                    this.bitField0_ &= 0xFFFFFFFB;
                }
                else {
                    this.ensureEdgesIsMutable();
                    this.edges_.addAll(binExport$Flowgraph.edges_);
                }
                this.onChanged();
            }
        }
        else if (!binExport$Flowgraph.edges_.isEmpty()) {
            if (this.edgesBuilder_.isEmpty()) {
                this.edgesBuilder_.dispose();
                this.edgesBuilder_ = null;
                this.edges_ = binExport$Flowgraph.edges_;
                this.bitField0_ &= 0xFFFFFFFB;
                this.edgesBuilder_ = (BinExport$Flowgraph.alwaysUseFieldBuilders ? this.getEdgesFieldBuilder() : null);
            }
            else {
                this.edgesBuilder_.addAllMessages(binExport$Flowgraph.edges_);
            }
        }
        this.mergeUnknownFields(binExport$Flowgraph.unknownFields);
        this.onChanged();
        return this;
    }
    
    @Override
    public final boolean isInitialized() {
        if (!this.hasAddress()) {
            return false;
        }
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
    public BinExport$Flowgraph$Builder mergeFrom(final CodedInputStream codedInputStream, final ExtensionRegistryLite extensionRegistryLite) {
        BinExport$Flowgraph binExport$Flowgraph = null;
        try {
            binExport$Flowgraph = (BinExport$Flowgraph)BinExport$Flowgraph.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
        }
        catch (InvalidProtocolBufferException ex) {
            binExport$Flowgraph = (BinExport$Flowgraph)ex.getUnfinishedMessage();
            throw ex;
        }
        finally {
            if (binExport$Flowgraph != null) {
                this.mergeFrom(binExport$Flowgraph);
            }
        }
        return this;
    }
    
    @Override
    public boolean hasAddress() {
        return (this.bitField0_ & 0x1) == 0x1;
    }
    
    @Override
    public long getAddress() {
        return this.address_;
    }
    
    public BinExport$Flowgraph$Builder setAddress(final long address_) {
        this.bitField0_ |= 0x1;
        this.address_ = address_;
        this.onChanged();
        return this;
    }
    
    public BinExport$Flowgraph$Builder clearAddress() {
        this.bitField0_ &= 0xFFFFFFFE;
        this.address_ = 0L;
        this.onChanged();
        return this;
    }
    
    private void ensureVerticesIsMutable() {
        if ((this.bitField0_ & 0x2) != 0x2) {
            this.vertices_ = new ArrayList(this.vertices_);
            this.bitField0_ |= 0x2;
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
    public BinExport$Flowgraph$Vertex getVertices(final int n) {
        if (this.verticesBuilder_ == null) {
            return this.vertices_.get(n);
        }
        return (BinExport$Flowgraph$Vertex)this.verticesBuilder_.getMessage(n);
    }
    
    public BinExport$Flowgraph$Builder setVertices(final int n, final BinExport$Flowgraph$Vertex binExport$Flowgraph$Vertex) {
        if (this.verticesBuilder_ == null) {
            if (binExport$Flowgraph$Vertex == null) {
                throw new NullPointerException();
            }
            this.ensureVerticesIsMutable();
            this.vertices_.set(n, binExport$Flowgraph$Vertex);
            this.onChanged();
        }
        else {
            this.verticesBuilder_.setMessage(n, binExport$Flowgraph$Vertex);
        }
        return this;
    }
    
    public BinExport$Flowgraph$Builder setVertices(final int n, final BinExport$Flowgraph$Vertex$Builder binExport$Flowgraph$Vertex$Builder) {
        if (this.verticesBuilder_ == null) {
            this.ensureVerticesIsMutable();
            this.vertices_.set(n, binExport$Flowgraph$Vertex$Builder.build());
            this.onChanged();
        }
        else {
            this.verticesBuilder_.setMessage(n, binExport$Flowgraph$Vertex$Builder.build());
        }
        return this;
    }
    
    public BinExport$Flowgraph$Builder addVertices(final BinExport$Flowgraph$Vertex binExport$Flowgraph$Vertex) {
        if (this.verticesBuilder_ == null) {
            if (binExport$Flowgraph$Vertex == null) {
                throw new NullPointerException();
            }
            this.ensureVerticesIsMutable();
            this.vertices_.add(binExport$Flowgraph$Vertex);
            this.onChanged();
        }
        else {
            this.verticesBuilder_.addMessage(binExport$Flowgraph$Vertex);
        }
        return this;
    }
    
    public BinExport$Flowgraph$Builder addVertices(final int n, final BinExport$Flowgraph$Vertex binExport$Flowgraph$Vertex) {
        if (this.verticesBuilder_ == null) {
            if (binExport$Flowgraph$Vertex == null) {
                throw new NullPointerException();
            }
            this.ensureVerticesIsMutable();
            this.vertices_.add(n, binExport$Flowgraph$Vertex);
            this.onChanged();
        }
        else {
            this.verticesBuilder_.addMessage(n, binExport$Flowgraph$Vertex);
        }
        return this;
    }
    
    public BinExport$Flowgraph$Builder addVertices(final BinExport$Flowgraph$Vertex$Builder binExport$Flowgraph$Vertex$Builder) {
        if (this.verticesBuilder_ == null) {
            this.ensureVerticesIsMutable();
            this.vertices_.add(binExport$Flowgraph$Vertex$Builder.build());
            this.onChanged();
        }
        else {
            this.verticesBuilder_.addMessage(binExport$Flowgraph$Vertex$Builder.build());
        }
        return this;
    }
    
    public BinExport$Flowgraph$Builder addVertices(final int n, final BinExport$Flowgraph$Vertex$Builder binExport$Flowgraph$Vertex$Builder) {
        if (this.verticesBuilder_ == null) {
            this.ensureVerticesIsMutable();
            this.vertices_.add(n, binExport$Flowgraph$Vertex$Builder.build());
            this.onChanged();
        }
        else {
            this.verticesBuilder_.addMessage(n, binExport$Flowgraph$Vertex$Builder.build());
        }
        return this;
    }
    
    public BinExport$Flowgraph$Builder addAllVertices(final Iterable iterable) {
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
    
    public BinExport$Flowgraph$Builder clearVertices() {
        if (this.verticesBuilder_ == null) {
            this.vertices_ = Collections.emptyList();
            this.bitField0_ &= 0xFFFFFFFD;
            this.onChanged();
        }
        else {
            this.verticesBuilder_.clear();
        }
        return this;
    }
    
    public BinExport$Flowgraph$Builder removeVertices(final int n) {
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
    
    public BinExport$Flowgraph$Vertex$Builder getVerticesBuilder(final int n) {
        return (BinExport$Flowgraph$Vertex$Builder)this.getVerticesFieldBuilder().getBuilder(n);
    }
    
    @Override
    public BinExport$Flowgraph$VertexOrBuilder getVerticesOrBuilder(final int n) {
        if (this.verticesBuilder_ == null) {
            return this.vertices_.get(n);
        }
        return (BinExport$Flowgraph$VertexOrBuilder)this.verticesBuilder_.getMessageOrBuilder(n);
    }
    
    @Override
    public List getVerticesOrBuilderList() {
        if (this.verticesBuilder_ != null) {
            return this.verticesBuilder_.getMessageOrBuilderList();
        }
        return Collections.unmodifiableList((List<?>)this.vertices_);
    }
    
    public BinExport$Flowgraph$Vertex$Builder addVerticesBuilder() {
        return (BinExport$Flowgraph$Vertex$Builder)this.getVerticesFieldBuilder().addBuilder(BinExport$Flowgraph$Vertex.getDefaultInstance());
    }
    
    public BinExport$Flowgraph$Vertex$Builder addVerticesBuilder(final int n) {
        return (BinExport$Flowgraph$Vertex$Builder)this.getVerticesFieldBuilder().addBuilder(n, BinExport$Flowgraph$Vertex.getDefaultInstance());
    }
    
    public List getVerticesBuilderList() {
        return this.getVerticesFieldBuilder().getBuilderList();
    }
    
    private RepeatedFieldBuilder getVerticesFieldBuilder() {
        if (this.verticesBuilder_ == null) {
            this.verticesBuilder_ = new RepeatedFieldBuilder(this.vertices_, (this.bitField0_ & 0x2) == 0x2, this.getParentForChildren(), this.isClean());
            this.vertices_ = null;
        }
        return this.verticesBuilder_;
    }
    
    private void ensureEdgesIsMutable() {
        if ((this.bitField0_ & 0x4) != 0x4) {
            this.edges_ = new ArrayList(this.edges_);
            this.bitField0_ |= 0x4;
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
    public BinExport$Flowgraph$Edge getEdges(final int n) {
        if (this.edgesBuilder_ == null) {
            return this.edges_.get(n);
        }
        return (BinExport$Flowgraph$Edge)this.edgesBuilder_.getMessage(n);
    }
    
    public BinExport$Flowgraph$Builder setEdges(final int n, final BinExport$Flowgraph$Edge binExport$Flowgraph$Edge) {
        if (this.edgesBuilder_ == null) {
            if (binExport$Flowgraph$Edge == null) {
                throw new NullPointerException();
            }
            this.ensureEdgesIsMutable();
            this.edges_.set(n, binExport$Flowgraph$Edge);
            this.onChanged();
        }
        else {
            this.edgesBuilder_.setMessage(n, binExport$Flowgraph$Edge);
        }
        return this;
    }
    
    public BinExport$Flowgraph$Builder setEdges(final int n, final BinExport$Flowgraph$Edge$Builder binExport$Flowgraph$Edge$Builder) {
        if (this.edgesBuilder_ == null) {
            this.ensureEdgesIsMutable();
            this.edges_.set(n, binExport$Flowgraph$Edge$Builder.build());
            this.onChanged();
        }
        else {
            this.edgesBuilder_.setMessage(n, binExport$Flowgraph$Edge$Builder.build());
        }
        return this;
    }
    
    public BinExport$Flowgraph$Builder addEdges(final BinExport$Flowgraph$Edge binExport$Flowgraph$Edge) {
        if (this.edgesBuilder_ == null) {
            if (binExport$Flowgraph$Edge == null) {
                throw new NullPointerException();
            }
            this.ensureEdgesIsMutable();
            this.edges_.add(binExport$Flowgraph$Edge);
            this.onChanged();
        }
        else {
            this.edgesBuilder_.addMessage(binExport$Flowgraph$Edge);
        }
        return this;
    }
    
    public BinExport$Flowgraph$Builder addEdges(final int n, final BinExport$Flowgraph$Edge binExport$Flowgraph$Edge) {
        if (this.edgesBuilder_ == null) {
            if (binExport$Flowgraph$Edge == null) {
                throw new NullPointerException();
            }
            this.ensureEdgesIsMutable();
            this.edges_.add(n, binExport$Flowgraph$Edge);
            this.onChanged();
        }
        else {
            this.edgesBuilder_.addMessage(n, binExport$Flowgraph$Edge);
        }
        return this;
    }
    
    public BinExport$Flowgraph$Builder addEdges(final BinExport$Flowgraph$Edge$Builder binExport$Flowgraph$Edge$Builder) {
        if (this.edgesBuilder_ == null) {
            this.ensureEdgesIsMutable();
            this.edges_.add(binExport$Flowgraph$Edge$Builder.build());
            this.onChanged();
        }
        else {
            this.edgesBuilder_.addMessage(binExport$Flowgraph$Edge$Builder.build());
        }
        return this;
    }
    
    public BinExport$Flowgraph$Builder addEdges(final int n, final BinExport$Flowgraph$Edge$Builder binExport$Flowgraph$Edge$Builder) {
        if (this.edgesBuilder_ == null) {
            this.ensureEdgesIsMutable();
            this.edges_.add(n, binExport$Flowgraph$Edge$Builder.build());
            this.onChanged();
        }
        else {
            this.edgesBuilder_.addMessage(n, binExport$Flowgraph$Edge$Builder.build());
        }
        return this;
    }
    
    public BinExport$Flowgraph$Builder addAllEdges(final Iterable iterable) {
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
    
    public BinExport$Flowgraph$Builder clearEdges() {
        if (this.edgesBuilder_ == null) {
            this.edges_ = Collections.emptyList();
            this.bitField0_ &= 0xFFFFFFFB;
            this.onChanged();
        }
        else {
            this.edgesBuilder_.clear();
        }
        return this;
    }
    
    public BinExport$Flowgraph$Builder removeEdges(final int n) {
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
    
    public BinExport$Flowgraph$Edge$Builder getEdgesBuilder(final int n) {
        return (BinExport$Flowgraph$Edge$Builder)this.getEdgesFieldBuilder().getBuilder(n);
    }
    
    @Override
    public BinExport$Flowgraph$EdgeOrBuilder getEdgesOrBuilder(final int n) {
        if (this.edgesBuilder_ == null) {
            return this.edges_.get(n);
        }
        return (BinExport$Flowgraph$EdgeOrBuilder)this.edgesBuilder_.getMessageOrBuilder(n);
    }
    
    @Override
    public List getEdgesOrBuilderList() {
        if (this.edgesBuilder_ != null) {
            return this.edgesBuilder_.getMessageOrBuilderList();
        }
        return Collections.unmodifiableList((List<?>)this.edges_);
    }
    
    public BinExport$Flowgraph$Edge$Builder addEdgesBuilder() {
        return (BinExport$Flowgraph$Edge$Builder)this.getEdgesFieldBuilder().addBuilder(BinExport$Flowgraph$Edge.getDefaultInstance());
    }
    
    public BinExport$Flowgraph$Edge$Builder addEdgesBuilder(final int n) {
        return (BinExport$Flowgraph$Edge$Builder)this.getEdgesFieldBuilder().addBuilder(n, BinExport$Flowgraph$Edge.getDefaultInstance());
    }
    
    public List getEdgesBuilderList() {
        return this.getEdgesFieldBuilder().getBuilderList();
    }
    
    private RepeatedFieldBuilder getEdgesFieldBuilder() {
        if (this.edgesBuilder_ == null) {
            this.edgesBuilder_ = new RepeatedFieldBuilder(this.edges_, (this.bitField0_ & 0x4) == 0x4, this.getParentForChildren(), this.isClean());
            this.edges_ = null;
        }
        return this.edgesBuilder_;
    }
}
