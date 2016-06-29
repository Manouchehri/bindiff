package com.google.protos.BinExport;

import com.google.protobuf.AbstractMessageLite$Builder;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.Descriptors$Descriptor;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessage$Builder;
import com.google.protobuf.GeneratedMessage$BuilderParent;
import com.google.protobuf.GeneratedMessage$FieldAccessorTable;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.Message;
import com.google.protobuf.RepeatedFieldBuilder;
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
import java.util.Collections;
import java.util.List;

public final class BinExport$Flowgraph$Builder extends GeneratedMessage$Builder implements BinExport$FlowgraphOrBuilder {
   private int bitField0_;
   private long address_;
   private List vertices_;
   private RepeatedFieldBuilder verticesBuilder_;
   private List edges_;
   private RepeatedFieldBuilder edgesBuilder_;

   public static final Descriptors$Descriptor getDescriptor() {
      return BinExport.access$5700();
   }

   protected GeneratedMessage$FieldAccessorTable internalGetFieldAccessorTable() {
      return BinExport.access$5800().ensureFieldAccessorsInitialized(BinExport$Flowgraph.class, BinExport$Flowgraph$Builder.class);
   }

   private BinExport$Flowgraph$Builder() {
      this.vertices_ = Collections.emptyList();
      this.edges_ = Collections.emptyList();
      this.maybeForceBuilderInitialization();
   }

   private BinExport$Flowgraph$Builder(GeneratedMessage$BuilderParent var1) {
      super(var1);
      this.vertices_ = Collections.emptyList();
      this.edges_ = Collections.emptyList();
      this.maybeForceBuilderInitialization();
   }

   private void maybeForceBuilderInitialization() {
      if(BinExport$Flowgraph.access$11400()) {
         this.getVerticesFieldBuilder();
         this.getEdgesFieldBuilder();
      }

   }

   public BinExport$Flowgraph$Builder clear() {
      super.clear();
      this.address_ = 0L;
      this.bitField0_ &= -2;
      if(this.verticesBuilder_ == null) {
         this.vertices_ = Collections.emptyList();
         this.bitField0_ &= -3;
      } else {
         this.verticesBuilder_.clear();
      }

      if(this.edgesBuilder_ == null) {
         this.edges_ = Collections.emptyList();
         this.bitField0_ &= -5;
      } else {
         this.edgesBuilder_.clear();
      }

      return this;
   }

   public Descriptors$Descriptor getDescriptorForType() {
      return BinExport.access$5700();
   }

   public BinExport$Flowgraph getDefaultInstanceForType() {
      return BinExport$Flowgraph.getDefaultInstance();
   }

   public BinExport$Flowgraph build() {
      BinExport$Flowgraph var1 = this.buildPartial();
      if(!var1.isInitialized()) {
         throw newUninitializedMessageException(var1);
      } else {
         return var1;
      }
   }

   public BinExport$Flowgraph buildPartial() {
      BinExport$Flowgraph var1 = new BinExport$Flowgraph(this, (BinExport$1)null);
      int var2 = this.bitField0_;
      int var3 = 0;
      if((var2 & 1) == 1) {
         var3 |= 1;
      }

      BinExport$Flowgraph.access$11602(var1, this.address_);
      if(this.verticesBuilder_ == null) {
         if((this.bitField0_ & 2) == 2) {
            this.vertices_ = Collections.unmodifiableList(this.vertices_);
            this.bitField0_ &= -3;
         }

         BinExport$Flowgraph.access$11702(var1, this.vertices_);
      } else {
         BinExport$Flowgraph.access$11702(var1, this.verticesBuilder_.build());
      }

      if(this.edgesBuilder_ == null) {
         if((this.bitField0_ & 4) == 4) {
            this.edges_ = Collections.unmodifiableList(this.edges_);
            this.bitField0_ &= -5;
         }

         BinExport$Flowgraph.access$11802(var1, this.edges_);
      } else {
         BinExport$Flowgraph.access$11802(var1, this.edgesBuilder_.build());
      }

      BinExport$Flowgraph.access$11902(var1, var3);
      this.onBuilt();
      return var1;
   }

   public BinExport$Flowgraph$Builder mergeFrom(Message var1) {
      if(var1 instanceof BinExport$Flowgraph) {
         return this.mergeFrom((BinExport$Flowgraph)var1);
      } else {
         super.mergeFrom(var1);
         return this;
      }
   }

   public BinExport$Flowgraph$Builder mergeFrom(BinExport$Flowgraph var1) {
      if(var1 == BinExport$Flowgraph.getDefaultInstance()) {
         return this;
      } else {
         if(var1.hasAddress()) {
            this.setAddress(var1.getAddress());
         }

         if(this.verticesBuilder_ == null) {
            if(!BinExport$Flowgraph.access$11700(var1).isEmpty()) {
               if(this.vertices_.isEmpty()) {
                  this.vertices_ = BinExport$Flowgraph.access$11700(var1);
                  this.bitField0_ &= -3;
               } else {
                  this.ensureVerticesIsMutable();
                  this.vertices_.addAll(BinExport$Flowgraph.access$11700(var1));
               }

               this.onChanged();
            }
         } else if(!BinExport$Flowgraph.access$11700(var1).isEmpty()) {
            if(this.verticesBuilder_.isEmpty()) {
               this.verticesBuilder_.dispose();
               this.verticesBuilder_ = null;
               this.vertices_ = BinExport$Flowgraph.access$11700(var1);
               this.bitField0_ &= -3;
               this.verticesBuilder_ = BinExport$Flowgraph.access$12000()?this.getVerticesFieldBuilder():null;
            } else {
               this.verticesBuilder_.addAllMessages(BinExport$Flowgraph.access$11700(var1));
            }
         }

         if(this.edgesBuilder_ == null) {
            if(!BinExport$Flowgraph.access$11800(var1).isEmpty()) {
               if(this.edges_.isEmpty()) {
                  this.edges_ = BinExport$Flowgraph.access$11800(var1);
                  this.bitField0_ &= -5;
               } else {
                  this.ensureEdgesIsMutable();
                  this.edges_.addAll(BinExport$Flowgraph.access$11800(var1));
               }

               this.onChanged();
            }
         } else if(!BinExport$Flowgraph.access$11800(var1).isEmpty()) {
            if(this.edgesBuilder_.isEmpty()) {
               this.edgesBuilder_.dispose();
               this.edgesBuilder_ = null;
               this.edges_ = BinExport$Flowgraph.access$11800(var1);
               this.bitField0_ &= -5;
               this.edgesBuilder_ = BinExport$Flowgraph.access$12100()?this.getEdgesFieldBuilder():null;
            } else {
               this.edgesBuilder_.addAllMessages(BinExport$Flowgraph.access$11800(var1));
            }
         }

         this.mergeUnknownFields(BinExport$Flowgraph.access$12200(var1));
         this.onChanged();
         return this;
      }
   }

   public final boolean isInitialized() {
      if(!this.hasAddress()) {
         return false;
      } else {
         int var1;
         for(var1 = 0; var1 < this.getVerticesCount(); ++var1) {
            if(!this.getVertices(var1).isInitialized()) {
               return false;
            }
         }

         for(var1 = 0; var1 < this.getEdgesCount(); ++var1) {
            if(!this.getEdges(var1).isInitialized()) {
               return false;
            }
         }

         return true;
      }
   }

   public BinExport$Flowgraph$Builder mergeFrom(CodedInputStream var1, ExtensionRegistryLite var2) {
      BinExport$Flowgraph var3 = null;

      try {
         var3 = (BinExport$Flowgraph)BinExport$Flowgraph.PARSER.parsePartialFrom(var1, var2);
      } catch (InvalidProtocolBufferException var8) {
         var3 = (BinExport$Flowgraph)var8.getUnfinishedMessage();
         throw var8;
      } finally {
         if(var3 != null) {
            this.mergeFrom(var3);
         }

      }

      return this;
   }

   public boolean hasAddress() {
      return (this.bitField0_ & 1) == 1;
   }

   public long getAddress() {
      return this.address_;
   }

   public BinExport$Flowgraph$Builder setAddress(long var1) {
      this.bitField0_ |= 1;
      this.address_ = var1;
      this.onChanged();
      return this;
   }

   public BinExport$Flowgraph$Builder clearAddress() {
      this.bitField0_ &= -2;
      this.address_ = 0L;
      this.onChanged();
      return this;
   }

   private void ensureVerticesIsMutable() {
      if((this.bitField0_ & 2) != 2) {
         this.vertices_ = new ArrayList(this.vertices_);
         this.bitField0_ |= 2;
      }

   }

   public List getVerticesList() {
      return this.verticesBuilder_ == null?Collections.unmodifiableList(this.vertices_):this.verticesBuilder_.getMessageList();
   }

   public int getVerticesCount() {
      return this.verticesBuilder_ == null?this.vertices_.size():this.verticesBuilder_.getCount();
   }

   public BinExport$Flowgraph$Vertex getVertices(int var1) {
      return this.verticesBuilder_ == null?(BinExport$Flowgraph$Vertex)this.vertices_.get(var1):(BinExport$Flowgraph$Vertex)this.verticesBuilder_.getMessage(var1);
   }

   public BinExport$Flowgraph$Builder setVertices(int var1, BinExport$Flowgraph$Vertex var2) {
      if(this.verticesBuilder_ == null) {
         if(var2 == null) {
            throw new NullPointerException();
         }

         this.ensureVerticesIsMutable();
         this.vertices_.set(var1, var2);
         this.onChanged();
      } else {
         this.verticesBuilder_.setMessage(var1, var2);
      }

      return this;
   }

   public BinExport$Flowgraph$Builder setVertices(int var1, BinExport$Flowgraph$Vertex$Builder var2) {
      if(this.verticesBuilder_ == null) {
         this.ensureVerticesIsMutable();
         this.vertices_.set(var1, var2.build());
         this.onChanged();
      } else {
         this.verticesBuilder_.setMessage(var1, var2.build());
      }

      return this;
   }

   public BinExport$Flowgraph$Builder addVertices(BinExport$Flowgraph$Vertex var1) {
      if(this.verticesBuilder_ == null) {
         if(var1 == null) {
            throw new NullPointerException();
         }

         this.ensureVerticesIsMutable();
         this.vertices_.add(var1);
         this.onChanged();
      } else {
         this.verticesBuilder_.addMessage(var1);
      }

      return this;
   }

   public BinExport$Flowgraph$Builder addVertices(int var1, BinExport$Flowgraph$Vertex var2) {
      if(this.verticesBuilder_ == null) {
         if(var2 == null) {
            throw new NullPointerException();
         }

         this.ensureVerticesIsMutable();
         this.vertices_.add(var1, var2);
         this.onChanged();
      } else {
         this.verticesBuilder_.addMessage(var1, var2);
      }

      return this;
   }

   public BinExport$Flowgraph$Builder addVertices(BinExport$Flowgraph$Vertex$Builder var1) {
      if(this.verticesBuilder_ == null) {
         this.ensureVerticesIsMutable();
         this.vertices_.add(var1.build());
         this.onChanged();
      } else {
         this.verticesBuilder_.addMessage(var1.build());
      }

      return this;
   }

   public BinExport$Flowgraph$Builder addVertices(int var1, BinExport$Flowgraph$Vertex$Builder var2) {
      if(this.verticesBuilder_ == null) {
         this.ensureVerticesIsMutable();
         this.vertices_.add(var1, var2.build());
         this.onChanged();
      } else {
         this.verticesBuilder_.addMessage(var1, var2.build());
      }

      return this;
   }

   public BinExport$Flowgraph$Builder addAllVertices(Iterable var1) {
      if(this.verticesBuilder_ == null) {
         this.ensureVerticesIsMutable();
         AbstractMessageLite$Builder.addAll(var1, this.vertices_);
         this.onChanged();
      } else {
         this.verticesBuilder_.addAllMessages(var1);
      }

      return this;
   }

   public BinExport$Flowgraph$Builder clearVertices() {
      if(this.verticesBuilder_ == null) {
         this.vertices_ = Collections.emptyList();
         this.bitField0_ &= -3;
         this.onChanged();
      } else {
         this.verticesBuilder_.clear();
      }

      return this;
   }

   public BinExport$Flowgraph$Builder removeVertices(int var1) {
      if(this.verticesBuilder_ == null) {
         this.ensureVerticesIsMutable();
         this.vertices_.remove(var1);
         this.onChanged();
      } else {
         this.verticesBuilder_.remove(var1);
      }

      return this;
   }

   public BinExport$Flowgraph$Vertex$Builder getVerticesBuilder(int var1) {
      return (BinExport$Flowgraph$Vertex$Builder)this.getVerticesFieldBuilder().getBuilder(var1);
   }

   public BinExport$Flowgraph$VertexOrBuilder getVerticesOrBuilder(int var1) {
      return this.verticesBuilder_ == null?(BinExport$Flowgraph$VertexOrBuilder)this.vertices_.get(var1):(BinExport$Flowgraph$VertexOrBuilder)this.verticesBuilder_.getMessageOrBuilder(var1);
   }

   public List getVerticesOrBuilderList() {
      return this.verticesBuilder_ != null?this.verticesBuilder_.getMessageOrBuilderList():Collections.unmodifiableList(this.vertices_);
   }

   public BinExport$Flowgraph$Vertex$Builder addVerticesBuilder() {
      return (BinExport$Flowgraph$Vertex$Builder)this.getVerticesFieldBuilder().addBuilder(BinExport$Flowgraph$Vertex.getDefaultInstance());
   }

   public BinExport$Flowgraph$Vertex$Builder addVerticesBuilder(int var1) {
      return (BinExport$Flowgraph$Vertex$Builder)this.getVerticesFieldBuilder().addBuilder(var1, BinExport$Flowgraph$Vertex.getDefaultInstance());
   }

   public List getVerticesBuilderList() {
      return this.getVerticesFieldBuilder().getBuilderList();
   }

   private RepeatedFieldBuilder getVerticesFieldBuilder() {
      if(this.verticesBuilder_ == null) {
         this.verticesBuilder_ = new RepeatedFieldBuilder(this.vertices_, (this.bitField0_ & 2) == 2, this.getParentForChildren(), this.isClean());
         this.vertices_ = null;
      }

      return this.verticesBuilder_;
   }

   private void ensureEdgesIsMutable() {
      if((this.bitField0_ & 4) != 4) {
         this.edges_ = new ArrayList(this.edges_);
         this.bitField0_ |= 4;
      }

   }

   public List getEdgesList() {
      return this.edgesBuilder_ == null?Collections.unmodifiableList(this.edges_):this.edgesBuilder_.getMessageList();
   }

   public int getEdgesCount() {
      return this.edgesBuilder_ == null?this.edges_.size():this.edgesBuilder_.getCount();
   }

   public BinExport$Flowgraph$Edge getEdges(int var1) {
      return this.edgesBuilder_ == null?(BinExport$Flowgraph$Edge)this.edges_.get(var1):(BinExport$Flowgraph$Edge)this.edgesBuilder_.getMessage(var1);
   }

   public BinExport$Flowgraph$Builder setEdges(int var1, BinExport$Flowgraph$Edge var2) {
      if(this.edgesBuilder_ == null) {
         if(var2 == null) {
            throw new NullPointerException();
         }

         this.ensureEdgesIsMutable();
         this.edges_.set(var1, var2);
         this.onChanged();
      } else {
         this.edgesBuilder_.setMessage(var1, var2);
      }

      return this;
   }

   public BinExport$Flowgraph$Builder setEdges(int var1, BinExport$Flowgraph$Edge$Builder var2) {
      if(this.edgesBuilder_ == null) {
         this.ensureEdgesIsMutable();
         this.edges_.set(var1, var2.build());
         this.onChanged();
      } else {
         this.edgesBuilder_.setMessage(var1, var2.build());
      }

      return this;
   }

   public BinExport$Flowgraph$Builder addEdges(BinExport$Flowgraph$Edge var1) {
      if(this.edgesBuilder_ == null) {
         if(var1 == null) {
            throw new NullPointerException();
         }

         this.ensureEdgesIsMutable();
         this.edges_.add(var1);
         this.onChanged();
      } else {
         this.edgesBuilder_.addMessage(var1);
      }

      return this;
   }

   public BinExport$Flowgraph$Builder addEdges(int var1, BinExport$Flowgraph$Edge var2) {
      if(this.edgesBuilder_ == null) {
         if(var2 == null) {
            throw new NullPointerException();
         }

         this.ensureEdgesIsMutable();
         this.edges_.add(var1, var2);
         this.onChanged();
      } else {
         this.edgesBuilder_.addMessage(var1, var2);
      }

      return this;
   }

   public BinExport$Flowgraph$Builder addEdges(BinExport$Flowgraph$Edge$Builder var1) {
      if(this.edgesBuilder_ == null) {
         this.ensureEdgesIsMutable();
         this.edges_.add(var1.build());
         this.onChanged();
      } else {
         this.edgesBuilder_.addMessage(var1.build());
      }

      return this;
   }

   public BinExport$Flowgraph$Builder addEdges(int var1, BinExport$Flowgraph$Edge$Builder var2) {
      if(this.edgesBuilder_ == null) {
         this.ensureEdgesIsMutable();
         this.edges_.add(var1, var2.build());
         this.onChanged();
      } else {
         this.edgesBuilder_.addMessage(var1, var2.build());
      }

      return this;
   }

   public BinExport$Flowgraph$Builder addAllEdges(Iterable var1) {
      if(this.edgesBuilder_ == null) {
         this.ensureEdgesIsMutable();
         AbstractMessageLite$Builder.addAll(var1, this.edges_);
         this.onChanged();
      } else {
         this.edgesBuilder_.addAllMessages(var1);
      }

      return this;
   }

   public BinExport$Flowgraph$Builder clearEdges() {
      if(this.edgesBuilder_ == null) {
         this.edges_ = Collections.emptyList();
         this.bitField0_ &= -5;
         this.onChanged();
      } else {
         this.edgesBuilder_.clear();
      }

      return this;
   }

   public BinExport$Flowgraph$Builder removeEdges(int var1) {
      if(this.edgesBuilder_ == null) {
         this.ensureEdgesIsMutable();
         this.edges_.remove(var1);
         this.onChanged();
      } else {
         this.edgesBuilder_.remove(var1);
      }

      return this;
   }

   public BinExport$Flowgraph$Edge$Builder getEdgesBuilder(int var1) {
      return (BinExport$Flowgraph$Edge$Builder)this.getEdgesFieldBuilder().getBuilder(var1);
   }

   public BinExport$Flowgraph$EdgeOrBuilder getEdgesOrBuilder(int var1) {
      return this.edgesBuilder_ == null?(BinExport$Flowgraph$EdgeOrBuilder)this.edges_.get(var1):(BinExport$Flowgraph$EdgeOrBuilder)this.edgesBuilder_.getMessageOrBuilder(var1);
   }

   public List getEdgesOrBuilderList() {
      return this.edgesBuilder_ != null?this.edgesBuilder_.getMessageOrBuilderList():Collections.unmodifiableList(this.edges_);
   }

   public BinExport$Flowgraph$Edge$Builder addEdgesBuilder() {
      return (BinExport$Flowgraph$Edge$Builder)this.getEdgesFieldBuilder().addBuilder(BinExport$Flowgraph$Edge.getDefaultInstance());
   }

   public BinExport$Flowgraph$Edge$Builder addEdgesBuilder(int var1) {
      return (BinExport$Flowgraph$Edge$Builder)this.getEdgesFieldBuilder().addBuilder(var1, BinExport$Flowgraph$Edge.getDefaultInstance());
   }

   public List getEdgesBuilderList() {
      return this.getEdgesFieldBuilder().getBuilderList();
   }

   private RepeatedFieldBuilder getEdgesFieldBuilder() {
      if(this.edgesBuilder_ == null) {
         this.edgesBuilder_ = new RepeatedFieldBuilder(this.edges_, (this.bitField0_ & 4) == 4, this.getParentForChildren(), this.isClean());
         this.edges_ = null;
      }

      return this.edgesBuilder_;
   }

   // $FF: synthetic method
   BinExport$Flowgraph$Builder(BinExport$1 var1) {
      this();
   }

   // $FF: synthetic method
   BinExport$Flowgraph$Builder(GeneratedMessage$BuilderParent var1, BinExport$1 var2) {
      this(var1);
   }
}
