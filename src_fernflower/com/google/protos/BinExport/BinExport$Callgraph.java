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
import com.google.protobuf.MessageLite;
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

public final class BinExport$Callgraph extends GeneratedMessage implements BinExport$CallgraphOrBuilder {
   public static final int VERTICES_FIELD_NUMBER = 1;
   private List vertices_;
   public static final int EDGES_FIELD_NUMBER = 2;
   private List edges_;
   private byte memoizedIsInitialized;
   private int memoizedSerializedSize;
   private static final long serialVersionUID = 0L;
   private static final BinExport$Callgraph DEFAULT_INSTANCE = new BinExport$Callgraph();
   public static final Parser PARSER = new BinExport$Callgraph$1();

   private BinExport$Callgraph(GeneratedMessage$Builder var1) {
      super(var1);
      this.memoizedIsInitialized = -1;
      this.memoizedSerializedSize = -1;
   }

   private BinExport$Callgraph() {
      this.memoizedIsInitialized = -1;
      this.memoizedSerializedSize = -1;
      this.vertices_ = Collections.emptyList();
      this.edges_ = Collections.emptyList();
   }

   public final UnknownFieldSet getUnknownFields() {
      return this.unknownFields;
   }

   private BinExport$Callgraph(CodedInputStream var1, ExtensionRegistryLite var2) {
      this();
      int var3 = 0;
      UnknownFieldSet$Builder var4 = UnknownFieldSet.newBuilder();

      try {
         boolean var5 = false;

         while(!var5) {
            int var6 = var1.readTag();
            switch(var6) {
            case 0:
               var5 = true;
               break;
            case 10:
               if((var3 & 1) != 1) {
                  this.vertices_ = new ArrayList();
                  var3 |= 1;
               }

               this.vertices_.add(var1.readMessage(BinExport$Callgraph$Vertex.PARSER, var2));
               break;
            case 18:
               if((var3 & 2) != 2) {
                  this.edges_ = new ArrayList();
                  var3 |= 2;
               }

               this.edges_.add(var1.readMessage(BinExport$Callgraph$Edge.PARSER, var2));
               break;
            default:
               if(!this.parseUnknownField(var1, var4, var2, var6)) {
                  var5 = true;
               }
            }
         }
      } catch (InvalidProtocolBufferException var11) {
         throw new RuntimeException(var11.setUnfinishedMessage(this));
      } catch (IOException var12) {
         throw new RuntimeException((new InvalidProtocolBufferException(var12.getMessage())).setUnfinishedMessage(this));
      } finally {
         if((var3 & 1) == 1) {
            this.vertices_ = Collections.unmodifiableList(this.vertices_);
         }

         if((var3 & 2) == 2) {
            this.edges_ = Collections.unmodifiableList(this.edges_);
         }

         this.unknownFields = var4.build();
         this.makeExtensionsImmutable();
      }

   }

   public static final Descriptors$Descriptor getDescriptor() {
      return BinExport.access$1800();
   }

   protected GeneratedMessage$FieldAccessorTable internalGetFieldAccessorTable() {
      return BinExport.access$1900().ensureFieldAccessorsInitialized(BinExport$Callgraph.class, BinExport$Callgraph$Builder.class);
   }

   public List getVerticesList() {
      return this.vertices_;
   }

   public List getVerticesOrBuilderList() {
      return this.vertices_;
   }

   public int getVerticesCount() {
      return this.vertices_.size();
   }

   public BinExport$Callgraph$Vertex getVertices(int var1) {
      return (BinExport$Callgraph$Vertex)this.vertices_.get(var1);
   }

   public BinExport$Callgraph$VertexOrBuilder getVerticesOrBuilder(int var1) {
      return (BinExport$Callgraph$VertexOrBuilder)this.vertices_.get(var1);
   }

   public List getEdgesList() {
      return this.edges_;
   }

   public List getEdgesOrBuilderList() {
      return this.edges_;
   }

   public int getEdgesCount() {
      return this.edges_.size();
   }

   public BinExport$Callgraph$Edge getEdges(int var1) {
      return (BinExport$Callgraph$Edge)this.edges_.get(var1);
   }

   public BinExport$Callgraph$EdgeOrBuilder getEdgesOrBuilder(int var1) {
      return (BinExport$Callgraph$EdgeOrBuilder)this.edges_.get(var1);
   }

   public final boolean isInitialized() {
      byte var1 = this.memoizedIsInitialized;
      if(var1 == 1) {
         return true;
      } else if(var1 == 0) {
         return false;
      } else {
         int var2;
         for(var2 = 0; var2 < this.getVerticesCount(); ++var2) {
            if(!this.getVertices(var2).isInitialized()) {
               this.memoizedIsInitialized = 0;
               return false;
            }
         }

         for(var2 = 0; var2 < this.getEdgesCount(); ++var2) {
            if(!this.getEdges(var2).isInitialized()) {
               this.memoizedIsInitialized = 0;
               return false;
            }
         }

         this.memoizedIsInitialized = 1;
         return true;
      }
   }

   public void writeTo(CodedOutputStream var1) {
      int var2;
      for(var2 = 0; var2 < this.vertices_.size(); ++var2) {
         var1.writeMessage(1, (MessageLite)this.vertices_.get(var2));
      }

      for(var2 = 0; var2 < this.edges_.size(); ++var2) {
         var1.writeMessage(2, (MessageLite)this.edges_.get(var2));
      }

      this.unknownFields.writeTo(var1);
   }

   public int getSerializedSize() {
      int var1 = this.memoizedSerializedSize;
      if(var1 != -1) {
         return var1;
      } else {
         var1 = 0;

         int var2;
         for(var2 = 0; var2 < this.vertices_.size(); ++var2) {
            var1 += CodedOutputStream.computeMessageSize(1, (MessageLite)this.vertices_.get(var2));
         }

         for(var2 = 0; var2 < this.edges_.size(); ++var2) {
            var1 += CodedOutputStream.computeMessageSize(2, (MessageLite)this.edges_.get(var2));
         }

         var1 += this.unknownFields.getSerializedSize();
         this.memoizedSerializedSize = var1;
         return var1;
      }
   }

   public static BinExport$Callgraph parseFrom(ByteString var0) {
      return (BinExport$Callgraph)PARSER.parseFrom(var0);
   }

   public static BinExport$Callgraph parseFrom(ByteString var0, ExtensionRegistryLite var1) {
      return (BinExport$Callgraph)PARSER.parseFrom(var0, var1);
   }

   public static BinExport$Callgraph parseFrom(byte[] var0) {
      return (BinExport$Callgraph)PARSER.parseFrom(var0);
   }

   public static BinExport$Callgraph parseFrom(byte[] var0, ExtensionRegistryLite var1) {
      return (BinExport$Callgraph)PARSER.parseFrom(var0, var1);
   }

   public static BinExport$Callgraph parseFrom(InputStream var0) {
      return (BinExport$Callgraph)PARSER.parseFrom(var0);
   }

   public static BinExport$Callgraph parseFrom(InputStream var0, ExtensionRegistryLite var1) {
      return (BinExport$Callgraph)PARSER.parseFrom(var0, var1);
   }

   public static BinExport$Callgraph parseDelimitedFrom(InputStream var0) {
      return (BinExport$Callgraph)PARSER.parseDelimitedFrom(var0);
   }

   public static BinExport$Callgraph parseDelimitedFrom(InputStream var0, ExtensionRegistryLite var1) {
      return (BinExport$Callgraph)PARSER.parseDelimitedFrom(var0, var1);
   }

   public static BinExport$Callgraph parseFrom(CodedInputStream var0) {
      return (BinExport$Callgraph)PARSER.parseFrom(var0);
   }

   public static BinExport$Callgraph parseFrom(CodedInputStream var0, ExtensionRegistryLite var1) {
      return (BinExport$Callgraph)PARSER.parseFrom(var0, var1);
   }

   public BinExport$Callgraph$Builder newBuilderForType() {
      return newBuilder();
   }

   public static BinExport$Callgraph$Builder newBuilder() {
      return DEFAULT_INSTANCE.toBuilder();
   }

   public static BinExport$Callgraph$Builder newBuilder(BinExport$Callgraph var0) {
      return DEFAULT_INSTANCE.toBuilder().mergeFrom(var0);
   }

   public BinExport$Callgraph$Builder toBuilder() {
      return this == DEFAULT_INSTANCE?new BinExport$Callgraph$Builder((BinExport$1)null):(new BinExport$Callgraph$Builder((BinExport$1)null)).mergeFrom(this);
   }

   protected BinExport$Callgraph$Builder newBuilderForType(GeneratedMessage$BuilderParent var1) {
      BinExport$Callgraph$Builder var2 = new BinExport$Callgraph$Builder(var1, (BinExport$1)null);
      return var2;
   }

   public static BinExport$Callgraph getDefaultInstance() {
      return DEFAULT_INSTANCE;
   }

   public Parser getParserForType() {
      return PARSER;
   }

   public BinExport$Callgraph getDefaultInstanceForType() {
      return DEFAULT_INSTANCE;
   }

   // $FF: synthetic method
   static boolean access$4900() {
      return alwaysUseFieldBuilders;
   }

   // $FF: synthetic method
   BinExport$Callgraph(GeneratedMessage$Builder var1, BinExport$1 var2) {
      this(var1);
   }

   // $FF: synthetic method
   static List access$5102(BinExport$Callgraph var0, List var1) {
      return var0.vertices_ = var1;
   }

   // $FF: synthetic method
   static List access$5202(BinExport$Callgraph var0, List var1) {
      return var0.edges_ = var1;
   }

   // $FF: synthetic method
   static List access$5100(BinExport$Callgraph var0) {
      return var0.vertices_;
   }

   // $FF: synthetic method
   static boolean access$5300() {
      return alwaysUseFieldBuilders;
   }

   // $FF: synthetic method
   static List access$5200(BinExport$Callgraph var0) {
      return var0.edges_;
   }

   // $FF: synthetic method
   static boolean access$5400() {
      return alwaysUseFieldBuilders;
   }

   // $FF: synthetic method
   static UnknownFieldSet access$5500(BinExport$Callgraph var0) {
      return var0.unknownFields;
   }

   // $FF: synthetic method
   BinExport$Callgraph(CodedInputStream var1, ExtensionRegistryLite var2, BinExport$1 var3) {
      this(var1, var2);
   }
}
