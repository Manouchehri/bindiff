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
import com.google.protos.BinExport.BinExport$Flowgraph$Edge$1;
import com.google.protos.BinExport.BinExport$Flowgraph$Edge$Builder;
import com.google.protos.BinExport.BinExport$Flowgraph$Edge$EdgeType;
import com.google.protos.BinExport.BinExport$Flowgraph$EdgeOrBuilder;
import java.io.IOException;
import java.io.InputStream;

public final class BinExport$Flowgraph$Edge extends GeneratedMessage implements BinExport$Flowgraph$EdgeOrBuilder {
   private int bitField0_;
   public static final int SOURCE_ADDRESS_FIELD_NUMBER = 1;
   private long sourceAddress_;
   public static final int TARGET_ADDRESS_FIELD_NUMBER = 2;
   private long targetAddress_;
   public static final int TYPE_FIELD_NUMBER = 3;
   private int type_;
   private byte memoizedIsInitialized;
   private int memoizedSerializedSize;
   private static final long serialVersionUID = 0L;
   private static final BinExport$Flowgraph$Edge DEFAULT_INSTANCE = new BinExport$Flowgraph$Edge();
   public static final Parser PARSER = new BinExport$Flowgraph$Edge$1();

   private BinExport$Flowgraph$Edge(GeneratedMessage$Builder var1) {
      super(var1);
      this.memoizedIsInitialized = -1;
      this.memoizedSerializedSize = -1;
   }

   private BinExport$Flowgraph$Edge() {
      this.memoizedIsInitialized = -1;
      this.memoizedSerializedSize = -1;
      this.sourceAddress_ = 0L;
      this.targetAddress_ = 0L;
      this.type_ = 3;
   }

   public final UnknownFieldSet getUnknownFields() {
      return this.unknownFields;
   }

   private BinExport$Flowgraph$Edge(CodedInputStream var1, ExtensionRegistryLite var2) {
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
               this.sourceAddress_ = var1.readUInt64();
               break;
            case 16:
               this.bitField0_ |= 2;
               this.targetAddress_ = var1.readUInt64();
               break;
            case 24:
               int var7 = var1.readEnum();
               BinExport$Flowgraph$Edge$EdgeType var8 = BinExport$Flowgraph$Edge$EdgeType.valueOf(var7);
               if(var8 == null) {
                  var4.mergeVarintField(3, var7);
               } else {
                  this.bitField0_ |= 4;
                  this.type_ = var7;
               }
               break;
            default:
               if(!this.parseUnknownField(var1, var4, var2, var6)) {
                  var5 = true;
               }
            }
         }
      } catch (InvalidProtocolBufferException var13) {
         throw new RuntimeException(var13.setUnfinishedMessage(this));
      } catch (IOException var14) {
         throw new RuntimeException((new InvalidProtocolBufferException(var14.getMessage())).setUnfinishedMessage(this));
      } finally {
         this.unknownFields = var4.build();
         this.makeExtensionsImmutable();
      }

   }

   public static final Descriptors$Descriptor getDescriptor() {
      return BinExport.access$10000();
   }

   protected GeneratedMessage$FieldAccessorTable internalGetFieldAccessorTable() {
      return BinExport.access$10100().ensureFieldAccessorsInitialized(BinExport$Flowgraph$Edge.class, BinExport$Flowgraph$Edge$Builder.class);
   }

   public boolean hasSourceAddress() {
      return (this.bitField0_ & 1) == 1;
   }

   public long getSourceAddress() {
      return this.sourceAddress_;
   }

   public boolean hasTargetAddress() {
      return (this.bitField0_ & 2) == 2;
   }

   public long getTargetAddress() {
      return this.targetAddress_;
   }

   public boolean hasType() {
      return (this.bitField0_ & 4) == 4;
   }

   public BinExport$Flowgraph$Edge$EdgeType getType() {
      BinExport$Flowgraph$Edge$EdgeType var1 = BinExport$Flowgraph$Edge$EdgeType.valueOf(this.type_);
      return var1 == null?BinExport$Flowgraph$Edge$EdgeType.UNCONDITIONAL:var1;
   }

   public final boolean isInitialized() {
      byte var1 = this.memoizedIsInitialized;
      if(var1 == 1) {
         return true;
      } else if(var1 == 0) {
         return false;
      } else if(!this.hasSourceAddress()) {
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
         var1.writeUInt64(1, this.sourceAddress_);
      }

      if((this.bitField0_ & 2) == 2) {
         var1.writeUInt64(2, this.targetAddress_);
      }

      if((this.bitField0_ & 4) == 4) {
         var1.writeEnum(3, this.type_);
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
            var1 += CodedOutputStream.computeUInt64Size(1, this.sourceAddress_);
         }

         if((this.bitField0_ & 2) == 2) {
            var1 += CodedOutputStream.computeUInt64Size(2, this.targetAddress_);
         }

         if((this.bitField0_ & 4) == 4) {
            var1 += CodedOutputStream.computeEnumSize(3, this.type_);
         }

         var1 += this.unknownFields.getSerializedSize();
         this.memoizedSerializedSize = var1;
         return var1;
      }
   }

   public static BinExport$Flowgraph$Edge parseFrom(ByteString var0) {
      return (BinExport$Flowgraph$Edge)PARSER.parseFrom(var0);
   }

   public static BinExport$Flowgraph$Edge parseFrom(ByteString var0, ExtensionRegistryLite var1) {
      return (BinExport$Flowgraph$Edge)PARSER.parseFrom(var0, var1);
   }

   public static BinExport$Flowgraph$Edge parseFrom(byte[] var0) {
      return (BinExport$Flowgraph$Edge)PARSER.parseFrom(var0);
   }

   public static BinExport$Flowgraph$Edge parseFrom(byte[] var0, ExtensionRegistryLite var1) {
      return (BinExport$Flowgraph$Edge)PARSER.parseFrom(var0, var1);
   }

   public static BinExport$Flowgraph$Edge parseFrom(InputStream var0) {
      return (BinExport$Flowgraph$Edge)PARSER.parseFrom(var0);
   }

   public static BinExport$Flowgraph$Edge parseFrom(InputStream var0, ExtensionRegistryLite var1) {
      return (BinExport$Flowgraph$Edge)PARSER.parseFrom(var0, var1);
   }

   public static BinExport$Flowgraph$Edge parseDelimitedFrom(InputStream var0) {
      return (BinExport$Flowgraph$Edge)PARSER.parseDelimitedFrom(var0);
   }

   public static BinExport$Flowgraph$Edge parseDelimitedFrom(InputStream var0, ExtensionRegistryLite var1) {
      return (BinExport$Flowgraph$Edge)PARSER.parseDelimitedFrom(var0, var1);
   }

   public static BinExport$Flowgraph$Edge parseFrom(CodedInputStream var0) {
      return (BinExport$Flowgraph$Edge)PARSER.parseFrom(var0);
   }

   public static BinExport$Flowgraph$Edge parseFrom(CodedInputStream var0, ExtensionRegistryLite var1) {
      return (BinExport$Flowgraph$Edge)PARSER.parseFrom(var0, var1);
   }

   public BinExport$Flowgraph$Edge$Builder newBuilderForType() {
      return newBuilder();
   }

   public static BinExport$Flowgraph$Edge$Builder newBuilder() {
      return DEFAULT_INSTANCE.toBuilder();
   }

   public static BinExport$Flowgraph$Edge$Builder newBuilder(BinExport$Flowgraph$Edge var0) {
      return DEFAULT_INSTANCE.toBuilder().mergeFrom(var0);
   }

   public BinExport$Flowgraph$Edge$Builder toBuilder() {
      return this == DEFAULT_INSTANCE?new BinExport$Flowgraph$Edge$Builder((BinExport$1)null):(new BinExport$Flowgraph$Edge$Builder((BinExport$1)null)).mergeFrom(this);
   }

   protected BinExport$Flowgraph$Edge$Builder newBuilderForType(GeneratedMessage$BuilderParent var1) {
      BinExport$Flowgraph$Edge$Builder var2 = new BinExport$Flowgraph$Edge$Builder(var1, (BinExport$1)null);
      return var2;
   }

   public static BinExport$Flowgraph$Edge getDefaultInstance() {
      return DEFAULT_INSTANCE;
   }

   public Parser getParserForType() {
      return PARSER;
   }

   public BinExport$Flowgraph$Edge getDefaultInstanceForType() {
      return DEFAULT_INSTANCE;
   }

   // $FF: synthetic method
   static boolean access$10400() {
      return alwaysUseFieldBuilders;
   }

   // $FF: synthetic method
   BinExport$Flowgraph$Edge(GeneratedMessage$Builder var1, BinExport$1 var2) {
      this(var1);
   }

   // $FF: synthetic method
   static long access$10602(BinExport$Flowgraph$Edge var0, long var1) {
      return var0.sourceAddress_ = var1;
   }

   // $FF: synthetic method
   static long access$10702(BinExport$Flowgraph$Edge var0, long var1) {
      return var0.targetAddress_ = var1;
   }

   // $FF: synthetic method
   static int access$10802(BinExport$Flowgraph$Edge var0, int var1) {
      return var0.type_ = var1;
   }

   // $FF: synthetic method
   static int access$10902(BinExport$Flowgraph$Edge var0, int var1) {
      return var0.bitField0_ = var1;
   }

   // $FF: synthetic method
   static UnknownFieldSet access$11000(BinExport$Flowgraph$Edge var0) {
      return var0.unknownFields;
   }

   // $FF: synthetic method
   BinExport$Flowgraph$Edge(CodedInputStream var1, ExtensionRegistryLite var2, BinExport$1 var3) {
      this(var1, var2);
   }
}
