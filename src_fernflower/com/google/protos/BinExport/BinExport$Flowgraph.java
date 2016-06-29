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

public final class BinExport$Flowgraph extends GeneratedMessage implements BinExport$FlowgraphOrBuilder {
   private int bitField0_;
   public static final int ADDRESS_FIELD_NUMBER = 1;
   private long address_;
   public static final int VERTICES_FIELD_NUMBER = 2;
   private List vertices_;
   public static final int EDGES_FIELD_NUMBER = 3;
   private List edges_;
   private byte memoizedIsInitialized;
   private int memoizedSerializedSize;
   private static final long serialVersionUID = 0L;
   private static final BinExport$Flowgraph DEFAULT_INSTANCE = new BinExport$Flowgraph();
   public static final Parser PARSER = new BinExport$Flowgraph$1();

   private BinExport$Flowgraph(GeneratedMessage$Builder var1) {
      super(var1);
      this.memoizedIsInitialized = -1;
      this.memoizedSerializedSize = -1;
   }

   private BinExport$Flowgraph() {
      this.memoizedIsInitialized = -1;
      this.memoizedSerializedSize = -1;
      this.address_ = 0L;
      this.vertices_ = Collections.emptyList();
      this.edges_ = Collections.emptyList();
   }

   public final UnknownFieldSet getUnknownFields() {
      return this.unknownFields;
   }

   private BinExport$Flowgraph(CodedInputStream var1, ExtensionRegistryLite var2) {
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
            case 8:
               this.bitField0_ |= 1;
               this.address_ = var1.readUInt64();
               break;
            case 18:
               if((var3 & 2) != 2) {
                  this.vertices_ = new ArrayList();
                  var3 |= 2;
               }

               this.vertices_.add(var1.readMessage(BinExport$Flowgraph$Vertex.PARSER, var2));
               break;
            case 26:
               if((var3 & 4) != 4) {
                  this.edges_ = new ArrayList();
                  var3 |= 4;
               }

               this.edges_.add(var1.readMessage(BinExport$Flowgraph$Edge.PARSER, var2));
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
         if((var3 & 2) == 2) {
            this.vertices_ = Collections.unmodifiableList(this.vertices_);
         }

         if((var3 & 4) == 4) {
            this.edges_ = Collections.unmodifiableList(this.edges_);
         }

         this.unknownFields = var4.build();
         this.makeExtensionsImmutable();
      }

   }

   public static final Descriptors$Descriptor getDescriptor() {
      return BinExport.access$5700();
   }

   protected GeneratedMessage$FieldAccessorTable internalGetFieldAccessorTable() {
      return BinExport.access$5800().ensureFieldAccessorsInitialized(BinExport$Flowgraph.class, BinExport$Flowgraph$Builder.class);
   }

   public boolean hasAddress() {
      return (this.bitField0_ & 1) == 1;
   }

   public long getAddress() {
      return this.address_;
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

   public BinExport$Flowgraph$Vertex getVertices(int var1) {
      return (BinExport$Flowgraph$Vertex)this.vertices_.get(var1);
   }

   public BinExport$Flowgraph$VertexOrBuilder getVerticesOrBuilder(int var1) {
      return (BinExport$Flowgraph$VertexOrBuilder)this.vertices_.get(var1);
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

   public BinExport$Flowgraph$Edge getEdges(int var1) {
      return (BinExport$Flowgraph$Edge)this.edges_.get(var1);
   }

   public BinExport$Flowgraph$EdgeOrBuilder getEdgesOrBuilder(int var1) {
      return (BinExport$Flowgraph$EdgeOrBuilder)this.edges_.get(var1);
   }

   public final boolean isInitialized() {
      byte var1 = this.memoizedIsInitialized;
      if(var1 == 1) {
         return true;
      } else if(var1 == 0) {
         return false;
      } else if(!this.hasAddress()) {
         this.memoizedIsInitialized = 0;
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
      if((this.bitField0_ & 1) == 1) {
         var1.writeUInt64(1, this.address_);
      }

      int var2;
      for(var2 = 0; var2 < this.vertices_.size(); ++var2) {
         var1.writeMessage(2, (MessageLite)this.vertices_.get(var2));
      }

      for(var2 = 0; var2 < this.edges_.size(); ++var2) {
         var1.writeMessage(3, (MessageLite)this.edges_.get(var2));
      }

      this.unknownFields.writeTo(var1);
   }

   public int getSerializedSize() {
      int var1 = this.memoizedSerializedSize;
      if(var1 != -1) {
         return var1;
      } else {
         var1 = 0;
         if((this.bitField0_ & 1) == 1) {
            var1 += CodedOutputStream.computeUInt64Size(1, this.address_);
         }

         int var2;
         for(var2 = 0; var2 < this.vertices_.size(); ++var2) {
            var1 += CodedOutputStream.computeMessageSize(2, (MessageLite)this.vertices_.get(var2));
         }

         for(var2 = 0; var2 < this.edges_.size(); ++var2) {
            var1 += CodedOutputStream.computeMessageSize(3, (MessageLite)this.edges_.get(var2));
         }

         var1 += this.unknownFields.getSerializedSize();
         this.memoizedSerializedSize = var1;
         return var1;
      }
   }

   public static BinExport$Flowgraph parseFrom(ByteString var0) {
      return (BinExport$Flowgraph)PARSER.parseFrom(var0);
   }

   public static BinExport$Flowgraph parseFrom(ByteString var0, ExtensionRegistryLite var1) {
      return (BinExport$Flowgraph)PARSER.parseFrom(var0, var1);
   }

   public static BinExport$Flowgraph parseFrom(byte[] var0) {
      return (BinExport$Flowgraph)PARSER.parseFrom(var0);
   }

   public static BinExport$Flowgraph parseFrom(byte[] var0, ExtensionRegistryLite var1) {
      return (BinExport$Flowgraph)PARSER.parseFrom(var0, var1);
   }

   public static BinExport$Flowgraph parseFrom(InputStream var0) {
      return (BinExport$Flowgraph)PARSER.parseFrom(var0);
   }

   public static BinExport$Flowgraph parseFrom(InputStream var0, ExtensionRegistryLite var1) {
      return (BinExport$Flowgraph)PARSER.parseFrom(var0, var1);
   }

   public static BinExport$Flowgraph parseDelimitedFrom(InputStream var0) {
      return (BinExport$Flowgraph)PARSER.parseDelimitedFrom(var0);
   }

   public static BinExport$Flowgraph parseDelimitedFrom(InputStream var0, ExtensionRegistryLite var1) {
      return (BinExport$Flowgraph)PARSER.parseDelimitedFrom(var0, var1);
   }

   public static BinExport$Flowgraph parseFrom(CodedInputStream var0) {
      return (BinExport$Flowgraph)PARSER.parseFrom(var0);
   }

   public static BinExport$Flowgraph parseFrom(CodedInputStream var0, ExtensionRegistryLite var1) {
      return (BinExport$Flowgraph)PARSER.parseFrom(var0, var1);
   }

   public BinExport$Flowgraph$Builder newBuilderForType() {
      return newBuilder();
   }

   public static BinExport$Flowgraph$Builder newBuilder() {
      return DEFAULT_INSTANCE.toBuilder();
   }

   public static BinExport$Flowgraph$Builder newBuilder(BinExport$Flowgraph var0) {
      return DEFAULT_INSTANCE.toBuilder().mergeFrom(var0);
   }

   public BinExport$Flowgraph$Builder toBuilder() {
      return this == DEFAULT_INSTANCE?new BinExport$Flowgraph$Builder((BinExport$1)null):(new BinExport$Flowgraph$Builder((BinExport$1)null)).mergeFrom(this);
   }

   protected BinExport$Flowgraph$Builder newBuilderForType(GeneratedMessage$BuilderParent var1) {
      BinExport$Flowgraph$Builder var2 = new BinExport$Flowgraph$Builder(var1, (BinExport$1)null);
      return var2;
   }

   public static BinExport$Flowgraph getDefaultInstance() {
      return DEFAULT_INSTANCE;
   }

   public Parser getParserForType() {
      return PARSER;
   }

   public BinExport$Flowgraph getDefaultInstanceForType() {
      return DEFAULT_INSTANCE;
   }

   // $FF: synthetic method
   static boolean access$11400() {
      return alwaysUseFieldBuilders;
   }

   // $FF: synthetic method
   BinExport$Flowgraph(GeneratedMessage$Builder var1, BinExport$1 var2) {
      this(var1);
   }

   // $FF: synthetic method
   static long access$11602(BinExport$Flowgraph var0, long var1) {
      return var0.address_ = var1;
   }

   // $FF: synthetic method
   static List access$11702(BinExport$Flowgraph var0, List var1) {
      return var0.vertices_ = var1;
   }

   // $FF: synthetic method
   static List access$11802(BinExport$Flowgraph var0, List var1) {
      return var0.edges_ = var1;
   }

   // $FF: synthetic method
   static int access$11902(BinExport$Flowgraph var0, int var1) {
      return var0.bitField0_ = var1;
   }

   // $FF: synthetic method
   static List access$11700(BinExport$Flowgraph var0) {
      return var0.vertices_;
   }

   // $FF: synthetic method
   static boolean access$12000() {
      return alwaysUseFieldBuilders;
   }

   // $FF: synthetic method
   static List access$11800(BinExport$Flowgraph var0) {
      return var0.edges_;
   }

   // $FF: synthetic method
   static boolean access$12100() {
      return alwaysUseFieldBuilders;
   }

   // $FF: synthetic method
   static UnknownFieldSet access$12200(BinExport$Flowgraph var0) {
      return var0.unknownFields;
   }

   // $FF: synthetic method
   BinExport$Flowgraph(CodedInputStream var1, ExtensionRegistryLite var2, BinExport$1 var3) {
      this(var1, var2);
   }
}
