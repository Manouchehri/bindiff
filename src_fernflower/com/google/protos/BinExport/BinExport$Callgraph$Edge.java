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
import com.google.protobuf.Parser;
import com.google.protobuf.UnknownFieldSet;
import com.google.protobuf.UnknownFieldSet$Builder;
import com.google.protos.BinExport.BinExport;
import com.google.protos.BinExport.BinExport$1;
import com.google.protos.BinExport.BinExport$Callgraph$Edge$1;
import com.google.protos.BinExport.BinExport$Callgraph$Edge$Builder;
import com.google.protos.BinExport.BinExport$Callgraph$EdgeOrBuilder;
import java.io.IOException;
import java.io.InputStream;

public final class BinExport$Callgraph$Edge extends GeneratedMessage implements BinExport$Callgraph$EdgeOrBuilder {
   private int bitField0_;
   public static final int SOURCE_FUNCTION_ADDRESS_FIELD_NUMBER = 1;
   private long sourceFunctionAddress_;
   public static final int SOURCE_INSTRUCTION_ADDRESS_FIELD_NUMBER = 2;
   private long sourceInstructionAddress_;
   public static final int TARGET_ADDRESS_FIELD_NUMBER = 3;
   private long targetAddress_;
   private byte memoizedIsInitialized;
   private int memoizedSerializedSize;
   private static final long serialVersionUID = 0L;
   private static final BinExport$Callgraph$Edge DEFAULT_INSTANCE = new BinExport$Callgraph$Edge();
   public static final Parser PARSER = new BinExport$Callgraph$Edge$1();

   private BinExport$Callgraph$Edge(GeneratedMessage$Builder var1) {
      super(var1);
      this.memoizedIsInitialized = -1;
      this.memoizedSerializedSize = -1;
   }

   private BinExport$Callgraph$Edge() {
      this.memoizedIsInitialized = -1;
      this.memoizedSerializedSize = -1;
      this.sourceFunctionAddress_ = 0L;
      this.sourceInstructionAddress_ = 0L;
      this.targetAddress_ = 0L;
   }

   public final UnknownFieldSet getUnknownFields() {
      return this.unknownFields;
   }

   private BinExport$Callgraph$Edge(CodedInputStream var1, ExtensionRegistryLite var2) {
      this();
      boolean var3 = false;
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
               this.sourceFunctionAddress_ = var1.readUInt64();
               break;
            case 16:
               this.bitField0_ |= 2;
               this.sourceInstructionAddress_ = var1.readUInt64();
               break;
            case 24:
               this.bitField0_ |= 4;
               this.targetAddress_ = var1.readUInt64();
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
         this.unknownFields = var4.build();
         this.makeExtensionsImmutable();
      }

   }

   public static final Descriptors$Descriptor getDescriptor() {
      return BinExport.access$3500();
   }

   protected GeneratedMessage$FieldAccessorTable internalGetFieldAccessorTable() {
      return BinExport.access$3600().ensureFieldAccessorsInitialized(BinExport$Callgraph$Edge.class, BinExport$Callgraph$Edge$Builder.class);
   }

   public boolean hasSourceFunctionAddress() {
      return (this.bitField0_ & 1) == 1;
   }

   public long getSourceFunctionAddress() {
      return this.sourceFunctionAddress_;
   }

   public boolean hasSourceInstructionAddress() {
      return (this.bitField0_ & 2) == 2;
   }

   public long getSourceInstructionAddress() {
      return this.sourceInstructionAddress_;
   }

   public boolean hasTargetAddress() {
      return (this.bitField0_ & 4) == 4;
   }

   public long getTargetAddress() {
      return this.targetAddress_;
   }

   public final boolean isInitialized() {
      byte var1 = this.memoizedIsInitialized;
      if(var1 == 1) {
         return true;
      } else if(var1 == 0) {
         return false;
      } else if(!this.hasSourceFunctionAddress()) {
         this.memoizedIsInitialized = 0;
         return false;
      } else if(!this.hasSourceInstructionAddress()) {
         this.memoizedIsInitialized = 0;
         return false;
      } else if(!this.hasTargetAddress()) {
         this.memoizedIsInitialized = 0;
         return false;
      } else {
         this.memoizedIsInitialized = 1;
         return true;
      }
   }

   public void writeTo(CodedOutputStream var1) {
      if((this.bitField0_ & 1) == 1) {
         var1.writeUInt64(1, this.sourceFunctionAddress_);
      }

      if((this.bitField0_ & 2) == 2) {
         var1.writeUInt64(2, this.sourceInstructionAddress_);
      }

      if((this.bitField0_ & 4) == 4) {
         var1.writeUInt64(3, this.targetAddress_);
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
            var1 += CodedOutputStream.computeUInt64Size(1, this.sourceFunctionAddress_);
         }

         if((this.bitField0_ & 2) == 2) {
            var1 += CodedOutputStream.computeUInt64Size(2, this.sourceInstructionAddress_);
         }

         if((this.bitField0_ & 4) == 4) {
            var1 += CodedOutputStream.computeUInt64Size(3, this.targetAddress_);
         }

         var1 += this.unknownFields.getSerializedSize();
         this.memoizedSerializedSize = var1;
         return var1;
      }
   }

   public static BinExport$Callgraph$Edge parseFrom(ByteString var0) {
      return (BinExport$Callgraph$Edge)PARSER.parseFrom(var0);
   }

   public static BinExport$Callgraph$Edge parseFrom(ByteString var0, ExtensionRegistryLite var1) {
      return (BinExport$Callgraph$Edge)PARSER.parseFrom(var0, var1);
   }

   public static BinExport$Callgraph$Edge parseFrom(byte[] var0) {
      return (BinExport$Callgraph$Edge)PARSER.parseFrom(var0);
   }

   public static BinExport$Callgraph$Edge parseFrom(byte[] var0, ExtensionRegistryLite var1) {
      return (BinExport$Callgraph$Edge)PARSER.parseFrom(var0, var1);
   }

   public static BinExport$Callgraph$Edge parseFrom(InputStream var0) {
      return (BinExport$Callgraph$Edge)PARSER.parseFrom(var0);
   }

   public static BinExport$Callgraph$Edge parseFrom(InputStream var0, ExtensionRegistryLite var1) {
      return (BinExport$Callgraph$Edge)PARSER.parseFrom(var0, var1);
   }

   public static BinExport$Callgraph$Edge parseDelimitedFrom(InputStream var0) {
      return (BinExport$Callgraph$Edge)PARSER.parseDelimitedFrom(var0);
   }

   public static BinExport$Callgraph$Edge parseDelimitedFrom(InputStream var0, ExtensionRegistryLite var1) {
      return (BinExport$Callgraph$Edge)PARSER.parseDelimitedFrom(var0, var1);
   }

   public static BinExport$Callgraph$Edge parseFrom(CodedInputStream var0) {
      return (BinExport$Callgraph$Edge)PARSER.parseFrom(var0);
   }

   public static BinExport$Callgraph$Edge parseFrom(CodedInputStream var0, ExtensionRegistryLite var1) {
      return (BinExport$Callgraph$Edge)PARSER.parseFrom(var0, var1);
   }

   public BinExport$Callgraph$Edge$Builder newBuilderForType() {
      return newBuilder();
   }

   public static BinExport$Callgraph$Edge$Builder newBuilder() {
      return DEFAULT_INSTANCE.toBuilder();
   }

   public static BinExport$Callgraph$Edge$Builder newBuilder(BinExport$Callgraph$Edge var0) {
      return DEFAULT_INSTANCE.toBuilder().mergeFrom(var0);
   }

   public BinExport$Callgraph$Edge$Builder toBuilder() {
      return this == DEFAULT_INSTANCE?new BinExport$Callgraph$Edge$Builder((BinExport$1)null):(new BinExport$Callgraph$Edge$Builder((BinExport$1)null)).mergeFrom(this);
   }

   protected BinExport$Callgraph$Edge$Builder newBuilderForType(GeneratedMessage$BuilderParent var1) {
      BinExport$Callgraph$Edge$Builder var2 = new BinExport$Callgraph$Edge$Builder(var1, (BinExport$1)null);
      return var2;
   }

   public static BinExport$Callgraph$Edge getDefaultInstance() {
      return DEFAULT_INSTANCE;
   }

   public Parser getParserForType() {
      return PARSER;
   }

   public BinExport$Callgraph$Edge getDefaultInstanceForType() {
      return DEFAULT_INSTANCE;
   }

   // $FF: synthetic method
   static boolean access$3900() {
      return alwaysUseFieldBuilders;
   }

   // $FF: synthetic method
   BinExport$Callgraph$Edge(GeneratedMessage$Builder var1, BinExport$1 var2) {
      this(var1);
   }

   // $FF: synthetic method
   static long access$4102(BinExport$Callgraph$Edge var0, long var1) {
      return var0.sourceFunctionAddress_ = var1;
   }

   // $FF: synthetic method
   static long access$4202(BinExport$Callgraph$Edge var0, long var1) {
      return var0.sourceInstructionAddress_ = var1;
   }

   // $FF: synthetic method
   static long access$4302(BinExport$Callgraph$Edge var0, long var1) {
      return var0.targetAddress_ = var1;
   }

   // $FF: synthetic method
   static int access$4402(BinExport$Callgraph$Edge var0, int var1) {
      return var0.bitField0_ = var1;
   }

   // $FF: synthetic method
   static UnknownFieldSet access$4500(BinExport$Callgraph$Edge var0) {
      return var0.unknownFields;
   }

   // $FF: synthetic method
   BinExport$Callgraph$Edge(CodedInputStream var1, ExtensionRegistryLite var2, BinExport$1 var3) {
      this(var1, var2);
   }
}
