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
import com.google.protos.BinExport.BinExport$Callgraph;
import com.google.protos.BinExport.BinExport$Callgraph$Edge;
import com.google.protos.BinExport.BinExport$Callgraph$Edge$Builder;
import com.google.protos.BinExport.BinExport$Callgraph$EdgeOrBuilder;
import com.google.protos.BinExport.BinExport$Callgraph$Vertex;
import com.google.protos.BinExport.BinExport$Callgraph$Vertex$Builder;
import com.google.protos.BinExport.BinExport$Callgraph$VertexOrBuilder;
import com.google.protos.BinExport.BinExport$CallgraphOrBuilder;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class BinExport$Callgraph$Builder extends GeneratedMessage$Builder implements BinExport$CallgraphOrBuilder {
   private int bitField0_;
   private List vertices_;
   private RepeatedFieldBuilder verticesBuilder_;
   private List edges_;
   private RepeatedFieldBuilder edgesBuilder_;

   public static final Descriptors$Descriptor getDescriptor() {
      return BinExport.access$1800();
   }

   protected GeneratedMessage$FieldAccessorTable internalGetFieldAccessorTable() {
      return BinExport.access$1900().ensureFieldAccessorsInitialized(BinExport$Callgraph.class, BinExport$Callgraph$Builder.class);
   }

   private BinExport$Callgraph$Builder() {
      this.vertices_ = Collections.emptyList();
      this.edges_ = Collections.emptyList();
      this.maybeForceBuilderInitialization();
   }

   private BinExport$Callgraph$Builder(GeneratedMessage$BuilderParent var1) {
      super(var1);
      this.vertices_ = Collections.emptyList();
      this.edges_ = Collections.emptyList();
      this.maybeForceBuilderInitialization();
   }

   private void maybeForceBuilderInitialization() {
      if(BinExport$Callgraph.access$4900()) {
         this.getVerticesFieldBuilder();
         this.getEdgesFieldBuilder();
      }

   }

   public BinExport$Callgraph$Builder clear() {
      super.clear();
      if(this.verticesBuilder_ == null) {
         this.vertices_ = Collections.emptyList();
         this.bitField0_ &= -2;
      } else {
         this.verticesBuilder_.clear();
      }

      if(this.edgesBuilder_ == null) {
         this.edges_ = Collections.emptyList();
         this.bitField0_ &= -3;
      } else {
         this.edgesBuilder_.clear();
      }

      return this;
   }

   public Descriptors$Descriptor getDescriptorForType() {
      return BinExport.access$1800();
   }

   public BinExport$Callgraph getDefaultInstanceForType() {
      return BinExport$Callgraph.getDefaultInstance();
   }

   public BinExport$Callgraph build() {
      BinExport$Callgraph var1 = this.buildPartial();
      if(!var1.isInitialized()) {
         throw newUninitializedMessageException(var1);
      } else {
         return var1;
      }
   }

   public BinExport$Callgraph buildPartial() {
      BinExport$Callgraph var1 = new BinExport$Callgraph(this, (BinExport$1)null);
      int var2 = this.bitField0_;
      if(this.verticesBuilder_ == null) {
         if((this.bitField0_ & 1) == 1) {
            this.vertices_ = Collections.unmodifiableList(this.vertices_);
            this.bitField0_ &= -2;
         }

         BinExport$Callgraph.access$5102(var1, this.vertices_);
      } else {
         BinExport$Callgraph.access$5102(var1, this.verticesBuilder_.build());
      }

      if(this.edgesBuilder_ == null) {
         if((this.bitField0_ & 2) == 2) {
            this.edges_ = Collections.unmodifiableList(this.edges_);
            this.bitField0_ &= -3;
         }

         BinExport$Callgraph.access$5202(var1, this.edges_);
      } else {
         BinExport$Callgraph.access$5202(var1, this.edgesBuilder_.build());
      }

      this.onBuilt();
      return var1;
   }

   public BinExport$Callgraph$Builder mergeFrom(Message var1) {
      if(var1 instanceof BinExport$Callgraph) {
         return this.mergeFrom((BinExport$Callgraph)var1);
      } else {
         super.mergeFrom(var1);
         return this;
      }
   }

   public BinExport$Callgraph$Builder mergeFrom(BinExport$Callgraph var1) {
      if(var1 == BinExport$Callgraph.getDefaultInstance()) {
         return this;
      } else {
         if(this.verticesBuilder_ == null) {
            if(!BinExport$Callgraph.access$5100(var1).isEmpty()) {
               if(this.vertices_.isEmpty()) {
                  this.vertices_ = BinExport$Callgraph.access$5100(var1);
                  this.bitField0_ &= -2;
               } else {
                  this.ensureVerticesIsMutable();
                  this.vertices_.addAll(BinExport$Callgraph.access$5100(var1));
               }

               this.onChanged();
            }
         } else if(!BinExport$Callgraph.access$5100(var1).isEmpty()) {
            if(this.verticesBuilder_.isEmpty()) {
               this.verticesBuilder_.dispose();
               this.verticesBuilder_ = null;
               this.vertices_ = BinExport$Callgraph.access$5100(var1);
               this.bitField0_ &= -2;
               this.verticesBuilder_ = BinExport$Callgraph.access$5300()?this.getVerticesFieldBuilder():null;
            } else {
               this.verticesBuilder_.addAllMessages(BinExport$Callgraph.access$5100(var1));
            }
         }

         if(this.edgesBuilder_ == null) {
            if(!BinExport$Callgraph.access$5200(var1).isEmpty()) {
               if(this.edges_.isEmpty()) {
                  this.edges_ = BinExport$Callgraph.access$5200(var1);
                  this.bitField0_ &= -3;
               } else {
                  this.ensureEdgesIsMutable();
                  this.edges_.addAll(BinExport$Callgraph.access$5200(var1));
               }

               this.onChanged();
            }
         } else if(!BinExport$Callgraph.access$5200(var1).isEmpty()) {
            if(this.edgesBuilder_.isEmpty()) {
               this.edgesBuilder_.dispose();
               this.edgesBuilder_ = null;
               this.edges_ = BinExport$Callgraph.access$5200(var1);
               this.bitField0_ &= -3;
               this.edgesBuilder_ = BinExport$Callgraph.access$5400()?this.getEdgesFieldBuilder():null;
            } else {
               this.edgesBuilder_.addAllMessages(BinExport$Callgraph.access$5200(var1));
            }
         }

         this.mergeUnknownFields(BinExport$Callgraph.access$5500(var1));
         this.onChanged();
         return this;
      }
   }

   public final boolean isInitialized() {
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

   public BinExport$Callgraph$Builder mergeFrom(CodedInputStream var1, ExtensionRegistryLite var2) {
      BinExport$Callgraph var3 = null;

      try {
         var3 = (BinExport$Callgraph)BinExport$Callgraph.PARSER.parsePartialFrom(var1, var2);
      } catch (InvalidProtocolBufferException var8) {
         var3 = (BinExport$Callgraph)var8.getUnfinishedMessage();
         throw var8;
      } finally {
         if(var3 != null) {
            this.mergeFrom(var3);
         }

      }

      return this;
   }

   private void ensureVerticesIsMutable() {
      if((this.bitField0_ & 1) != 1) {
         this.vertices_ = new ArrayList(this.vertices_);
         this.bitField0_ |= 1;
      }

   }

   public List getVerticesList() {
      return this.verticesBuilder_ == null?Collections.unmodifiableList(this.vertices_):this.verticesBuilder_.getMessageList();
   }

   public int getVerticesCount() {
      return this.verticesBuilder_ == null?this.vertices_.size():this.verticesBuilder_.getCount();
   }

   public BinExport$Callgraph$Vertex getVertices(int var1) {
      return this.verticesBuilder_ == null?(BinExport$Callgraph$Vertex)this.vertices_.get(var1):(BinExport$Callgraph$Vertex)this.verticesBuilder_.getMessage(var1);
   }

   public BinExport$Callgraph$Builder setVertices(int var1, BinExport$Callgraph$Vertex var2) {
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

   public BinExport$Callgraph$Builder setVertices(int var1, BinExport$Callgraph$Vertex$Builder var2) {
      if(this.verticesBuilder_ == null) {
         this.ensureVerticesIsMutable();
         this.vertices_.set(var1, var2.build());
         this.onChanged();
      } else {
         this.verticesBuilder_.setMessage(var1, var2.build());
      }

      return this;
   }

   public BinExport$Callgraph$Builder addVertices(BinExport$Callgraph$Vertex var1) {
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

   public BinExport$Callgraph$Builder addVertices(int var1, BinExport$Callgraph$Vertex var2) {
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

   public BinExport$Callgraph$Builder addVertices(BinExport$Callgraph$Vertex$Builder var1) {
      if(this.verticesBuilder_ == null) {
         this.ensureVerticesIsMutable();
         this.vertices_.add(var1.build());
         this.onChanged();
      } else {
         this.verticesBuilder_.addMessage(var1.build());
      }

      return this;
   }

   public BinExport$Callgraph$Builder addVertices(int var1, BinExport$Callgraph$Vertex$Builder var2) {
      if(this.verticesBuilder_ == null) {
         this.ensureVerticesIsMutable();
         this.vertices_.add(var1, var2.build());
         this.onChanged();
      } else {
         this.verticesBuilder_.addMessage(var1, var2.build());
      }

      return this;
   }

   public BinExport$Callgraph$Builder addAllVertices(Iterable var1) {
      if(this.verticesBuilder_ == null) {
         this.ensureVerticesIsMutable();
         AbstractMessageLite$Builder.addAll(var1, this.vertices_);
         this.onChanged();
      } else {
         this.verticesBuilder_.addAllMessages(var1);
      }

      return this;
   }

   public BinExport$Callgraph$Builder clearVertices() {
      if(this.verticesBuilder_ == null) {
         this.vertices_ = Collections.emptyList();
         this.bitField0_ &= -2;
         this.onChanged();
      } else {
         this.verticesBuilder_.clear();
      }

      return this;
   }

   public BinExport$Callgraph$Builder removeVertices(int var1) {
      if(this.verticesBuilder_ == null) {
         this.ensureVerticesIsMutable();
         this.vertices_.remove(var1);
         this.onChanged();
      } else {
         this.verticesBuilder_.remove(var1);
      }

      return this;
   }

   public BinExport$Callgraph$Vertex$Builder getVerticesBuilder(int var1) {
      return (BinExport$Callgraph$Vertex$Builder)this.getVerticesFieldBuilder().getBuilder(var1);
   }

   public BinExport$Callgraph$VertexOrBuilder getVerticesOrBuilder(int var1) {
      return this.verticesBuilder_ == null?(BinExport$Callgraph$VertexOrBuilder)this.vertices_.get(var1):(BinExport$Callgraph$VertexOrBuilder)this.verticesBuilder_.getMessageOrBuilder(var1);
   }

   public List getVerticesOrBuilderList() {
      return this.verticesBuilder_ != null?this.verticesBuilder_.getMessageOrBuilderList():Collections.unmodifiableList(this.vertices_);
   }

   public BinExport$Callgraph$Vertex$Builder addVerticesBuilder() {
      return (BinExport$Callgraph$Vertex$Builder)this.getVerticesFieldBuilder().addBuilder(BinExport$Callgraph$Vertex.getDefaultInstance());
   }

   public BinExport$Callgraph$Vertex$Builder addVerticesBuilder(int var1) {
      return (BinExport$Callgraph$Vertex$Builder)this.getVerticesFieldBuilder().addBuilder(var1, BinExport$Callgraph$Vertex.getDefaultInstance());
   }

   public List getVerticesBuilderList() {
      return this.getVerticesFieldBuilder().getBuilderList();
   }

   private RepeatedFieldBuilder getVerticesFieldBuilder() {
      if(this.verticesBuilder_ == null) {
         this.verticesBuilder_ = new RepeatedFieldBuilder(this.vertices_, (this.bitField0_ & 1) == 1, this.getParentForChildren(), this.isClean());
         this.vertices_ = null;
      }

      return this.verticesBuilder_;
   }

   private void ensureEdgesIsMutable() {
      if((this.bitField0_ & 2) != 2) {
         this.edges_ = new ArrayList(this.edges_);
         this.bitField0_ |= 2;
      }

   }

   public List getEdgesList() {
      return this.edgesBuilder_ == null?Collections.unmodifiableList(this.edges_):this.edgesBuilder_.getMessageList();
   }

   public int getEdgesCount() {
      return this.edgesBuilder_ == null?this.edges_.size():this.edgesBuilder_.getCount();
   }

   public BinExport$Callgraph$Edge getEdges(int var1) {
      return this.edgesBuilder_ == null?(BinExport$Callgraph$Edge)this.edges_.get(var1):(BinExport$Callgraph$Edge)this.edgesBuilder_.getMessage(var1);
   }

   public BinExport$Callgraph$Builder setEdges(int var1, BinExport$Callgraph$Edge var2) {
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

   public BinExport$Callgraph$Builder setEdges(int var1, BinExport$Callgraph$Edge$Builder var2) {
      if(this.edgesBuilder_ == null) {
         this.ensureEdgesIsMutable();
         this.edges_.set(var1, var2.build());
         this.onChanged();
      } else {
         this.edgesBuilder_.setMessage(var1, var2.build());
      }

      return this;
   }

   public BinExport$Callgraph$Builder addEdges(BinExport$Callgraph$Edge var1) {
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

   public BinExport$Callgraph$Builder addEdges(int var1, BinExport$Callgraph$Edge var2) {
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

   public BinExport$Callgraph$Builder addEdges(BinExport$Callgraph$Edge$Builder var1) {
      if(this.edgesBuilder_ == null) {
         this.ensureEdgesIsMutable();
         this.edges_.add(var1.build());
         this.onChanged();
      } else {
         this.edgesBuilder_.addMessage(var1.build());
      }

      return this;
   }

   public BinExport$Callgraph$Builder addEdges(int var1, BinExport$Callgraph$Edge$Builder var2) {
      if(this.edgesBuilder_ == null) {
         this.ensureEdgesIsMutable();
         this.edges_.add(var1, var2.build());
         this.onChanged();
      } else {
         this.edgesBuilder_.addMessage(var1, var2.build());
      }

      return this;
   }

   public BinExport$Callgraph$Builder addAllEdges(Iterable var1) {
      if(this.edgesBuilder_ == null) {
         this.ensureEdgesIsMutable();
         AbstractMessageLite$Builder.addAll(var1, this.edges_);
         this.onChanged();
      } else {
         this.edgesBuilder_.addAllMessages(var1);
      }

      return this;
   }

   public BinExport$Callgraph$Builder clearEdges() {
      if(this.edgesBuilder_ == null) {
         this.edges_ = Collections.emptyList();
         this.bitField0_ &= -3;
         this.onChanged();
      } else {
         this.edgesBuilder_.clear();
      }

      return this;
   }

   public BinExport$Callgraph$Builder removeEdges(int var1) {
      if(this.edgesBuilder_ == null) {
         this.ensureEdgesIsMutable();
         this.edges_.remove(var1);
         this.onChanged();
      } else {
         this.edgesBuilder_.remove(var1);
      }

      return this;
   }

   public BinExport$Callgraph$Edge$Builder getEdgesBuilder(int var1) {
      return (BinExport$Callgraph$Edge$Builder)this.getEdgesFieldBuilder().getBuilder(var1);
   }

   public BinExport$Callgraph$EdgeOrBuilder getEdgesOrBuilder(int var1) {
      return this.edgesBuilder_ == null?(BinExport$Callgraph$EdgeOrBuilder)this.edges_.get(var1):(BinExport$Callgraph$EdgeOrBuilder)this.edgesBuilder_.getMessageOrBuilder(var1);
   }

   public List getEdgesOrBuilderList() {
      return this.edgesBuilder_ != null?this.edgesBuilder_.getMessageOrBuilderList():Collections.unmodifiableList(this.edges_);
   }

   public BinExport$Callgraph$Edge$Builder addEdgesBuilder() {
      return (BinExport$Callgraph$Edge$Builder)this.getEdgesFieldBuilder().addBuilder(BinExport$Callgraph$Edge.getDefaultInstance());
   }

   public BinExport$Callgraph$Edge$Builder addEdgesBuilder(int var1) {
      return (BinExport$Callgraph$Edge$Builder)this.getEdgesFieldBuilder().addBuilder(var1, BinExport$Callgraph$Edge.getDefaultInstance());
   }

   public List getEdgesBuilderList() {
      return this.getEdgesFieldBuilder().getBuilderList();
   }

   private RepeatedFieldBuilder getEdgesFieldBuilder() {
      if(this.edgesBuilder_ == null) {
         this.edgesBuilder_ = new RepeatedFieldBuilder(this.edges_, (this.bitField0_ & 2) == 2, this.getParentForChildren(), this.isClean());
         this.edges_ = null;
      }

      return this.edgesBuilder_;
   }

   // $FF: synthetic method
   BinExport$Callgraph$Builder(BinExport$1 var1) {
      this();
   }

   // $FF: synthetic method
   BinExport$Callgraph$Builder(GeneratedMessage$BuilderParent var1, BinExport$1 var2) {
      this(var1);
   }
}
