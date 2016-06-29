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
import com.google.protos.BinExport.BinExport$Flowgraph$Vertex$1;
import com.google.protos.BinExport.BinExport$Flowgraph$Vertex$Builder;
import com.google.protos.BinExport.BinExport$Flowgraph$Vertex$Instruction;
import com.google.protos.BinExport.BinExport$Flowgraph$Vertex$InstructionOrBuilder;
import com.google.protos.BinExport.BinExport$Flowgraph$VertexOrBuilder;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class BinExport$Flowgraph$Vertex extends GeneratedMessage implements BinExport$Flowgraph$VertexOrBuilder {
   private int bitField0_;
   public static final int PRIME_FIELD_NUMBER = 1;
   private long prime_;
   public static final int INSTRUCTIONS_FIELD_NUMBER = 2;
   private List instructions_;
   private byte memoizedIsInitialized;
   private int memoizedSerializedSize;
   private static final long serialVersionUID = 0L;
   private static final BinExport$Flowgraph$Vertex DEFAULT_INSTANCE = new BinExport$Flowgraph$Vertex();
   public static final Parser PARSER = new BinExport$Flowgraph$Vertex$1();

   private BinExport$Flowgraph$Vertex(GeneratedMessage$Builder var1) {
      super(var1);
      this.memoizedIsInitialized = -1;
      this.memoizedSerializedSize = -1;
   }

   private BinExport$Flowgraph$Vertex() {
      this.memoizedIsInitialized = -1;
      this.memoizedSerializedSize = -1;
      this.prime_ = 0L;
      this.instructions_ = Collections.emptyList();
   }

   public final UnknownFieldSet getUnknownFields() {
      return this.unknownFields;
   }

   private BinExport$Flowgraph$Vertex(CodedInputStream var1, ExtensionRegistryLite var2) {
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
               this.prime_ = var1.readUInt64();
               break;
            case 18:
               if((var3 & 2) != 2) {
                  this.instructions_ = new ArrayList();
                  var3 |= 2;
               }

               this.instructions_.add(var1.readMessage(BinExport$Flowgraph$Vertex$Instruction.PARSER, var2));
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
            this.instructions_ = Collections.unmodifiableList(this.instructions_);
         }

         this.unknownFields = var4.build();
         this.makeExtensionsImmutable();
      }

   }

   public static final Descriptors$Descriptor getDescriptor() {
      return BinExport.access$5900();
   }

   protected GeneratedMessage$FieldAccessorTable internalGetFieldAccessorTable() {
      return BinExport.access$6000().ensureFieldAccessorsInitialized(BinExport$Flowgraph$Vertex.class, BinExport$Flowgraph$Vertex$Builder.class);
   }

   public boolean hasPrime() {
      return (this.bitField0_ & 1) == 1;
   }

   public long getPrime() {
      return this.prime_;
   }

   public List getInstructionsList() {
      return this.instructions_;
   }

   public List getInstructionsOrBuilderList() {
      return this.instructions_;
   }

   public int getInstructionsCount() {
      return this.instructions_.size();
   }

   public BinExport$Flowgraph$Vertex$Instruction getInstructions(int var1) {
      return (BinExport$Flowgraph$Vertex$Instruction)this.instructions_.get(var1);
   }

   public BinExport$Flowgraph$Vertex$InstructionOrBuilder getInstructionsOrBuilder(int var1) {
      return (BinExport$Flowgraph$Vertex$InstructionOrBuilder)this.instructions_.get(var1);
   }

   public final boolean isInitialized() {
      byte var1 = this.memoizedIsInitialized;
      if(var1 == 1) {
         return true;
      } else if(var1 == 0) {
         return false;
      } else if(!this.hasPrime()) {
         this.memoizedIsInitialized = 0;
         return false;
      } else {
         for(int var2 = 0; var2 < this.getInstructionsCount(); ++var2) {
            if(!this.getInstructions(var2).isInitialized()) {
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
         var1.writeUInt64(1, this.prime_);
      }

      for(int var2 = 0; var2 < this.instructions_.size(); ++var2) {
         var1.writeMessage(2, (MessageLite)this.instructions_.get(var2));
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
            var1 += CodedOutputStream.computeUInt64Size(1, this.prime_);
         }

         for(int var2 = 0; var2 < this.instructions_.size(); ++var2) {
            var1 += CodedOutputStream.computeMessageSize(2, (MessageLite)this.instructions_.get(var2));
         }

         var1 += this.unknownFields.getSerializedSize();
         this.memoizedSerializedSize = var1;
         return var1;
      }
   }

   public static BinExport$Flowgraph$Vertex parseFrom(ByteString var0) {
      return (BinExport$Flowgraph$Vertex)PARSER.parseFrom(var0);
   }

   public static BinExport$Flowgraph$Vertex parseFrom(ByteString var0, ExtensionRegistryLite var1) {
      return (BinExport$Flowgraph$Vertex)PARSER.parseFrom(var0, var1);
   }

   public static BinExport$Flowgraph$Vertex parseFrom(byte[] var0) {
      return (BinExport$Flowgraph$Vertex)PARSER.parseFrom(var0);
   }

   public static BinExport$Flowgraph$Vertex parseFrom(byte[] var0, ExtensionRegistryLite var1) {
      return (BinExport$Flowgraph$Vertex)PARSER.parseFrom(var0, var1);
   }

   public static BinExport$Flowgraph$Vertex parseFrom(InputStream var0) {
      return (BinExport$Flowgraph$Vertex)PARSER.parseFrom(var0);
   }

   public static BinExport$Flowgraph$Vertex parseFrom(InputStream var0, ExtensionRegistryLite var1) {
      return (BinExport$Flowgraph$Vertex)PARSER.parseFrom(var0, var1);
   }

   public static BinExport$Flowgraph$Vertex parseDelimitedFrom(InputStream var0) {
      return (BinExport$Flowgraph$Vertex)PARSER.parseDelimitedFrom(var0);
   }

   public static BinExport$Flowgraph$Vertex parseDelimitedFrom(InputStream var0, ExtensionRegistryLite var1) {
      return (BinExport$Flowgraph$Vertex)PARSER.parseDelimitedFrom(var0, var1);
   }

   public static BinExport$Flowgraph$Vertex parseFrom(CodedInputStream var0) {
      return (BinExport$Flowgraph$Vertex)PARSER.parseFrom(var0);
   }

   public static BinExport$Flowgraph$Vertex parseFrom(CodedInputStream var0, ExtensionRegistryLite var1) {
      return (BinExport$Flowgraph$Vertex)PARSER.parseFrom(var0, var1);
   }

   public BinExport$Flowgraph$Vertex$Builder newBuilderForType() {
      return newBuilder();
   }

   public static BinExport$Flowgraph$Vertex$Builder newBuilder() {
      return DEFAULT_INSTANCE.toBuilder();
   }

   public static BinExport$Flowgraph$Vertex$Builder newBuilder(BinExport$Flowgraph$Vertex var0) {
      return DEFAULT_INSTANCE.toBuilder().mergeFrom(var0);
   }

   public BinExport$Flowgraph$Vertex$Builder toBuilder() {
      return this == DEFAULT_INSTANCE?new BinExport$Flowgraph$Vertex$Builder((BinExport$1)null):(new BinExport$Flowgraph$Vertex$Builder((BinExport$1)null)).mergeFrom(this);
   }

   protected BinExport$Flowgraph$Vertex$Builder newBuilderForType(GeneratedMessage$BuilderParent var1) {
      BinExport$Flowgraph$Vertex$Builder var2 = new BinExport$Flowgraph$Vertex$Builder(var1, (BinExport$1)null);
      return var2;
   }

   public static BinExport$Flowgraph$Vertex getDefaultInstance() {
      return DEFAULT_INSTANCE;
   }

   public Parser getParserForType() {
      return PARSER;
   }

   public BinExport$Flowgraph$Vertex getDefaultInstanceForType() {
      return DEFAULT_INSTANCE;
   }

   // $FF: synthetic method
   static boolean access$9200() {
      return alwaysUseFieldBuilders;
   }

   // $FF: synthetic method
   BinExport$Flowgraph$Vertex(GeneratedMessage$Builder var1, BinExport$1 var2) {
      this(var1);
   }

   // $FF: synthetic method
   static long access$9402(BinExport$Flowgraph$Vertex var0, long var1) {
      return var0.prime_ = var1;
   }

   // $FF: synthetic method
   static List access$9502(BinExport$Flowgraph$Vertex var0, List var1) {
      return var0.instructions_ = var1;
   }

   // $FF: synthetic method
   static int access$9602(BinExport$Flowgraph$Vertex var0, int var1) {
      return var0.bitField0_ = var1;
   }

   // $FF: synthetic method
   static List access$9500(BinExport$Flowgraph$Vertex var0) {
      return var0.instructions_;
   }

   // $FF: synthetic method
   static boolean access$9700() {
      return alwaysUseFieldBuilders;
   }

   // $FF: synthetic method
   static UnknownFieldSet access$9800(BinExport$Flowgraph$Vertex var0) {
      return var0.unknownFields;
   }

   // $FF: synthetic method
   BinExport$Flowgraph$Vertex(CodedInputStream var1, ExtensionRegistryLite var2, BinExport$1 var3) {
      this(var1, var2);
   }
}
