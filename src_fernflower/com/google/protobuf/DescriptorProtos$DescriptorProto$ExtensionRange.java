package com.google.protobuf;

import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.DescriptorProtos;
import com.google.protobuf.DescriptorProtos$1;
import com.google.protobuf.DescriptorProtos$DescriptorProto$ExtensionRange$1;
import com.google.protobuf.DescriptorProtos$DescriptorProto$ExtensionRange$Builder;
import com.google.protobuf.DescriptorProtos$DescriptorProto$ExtensionRangeOrBuilder;
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
import java.io.IOException;
import java.io.InputStream;

public final class DescriptorProtos$DescriptorProto$ExtensionRange extends GeneratedMessage implements DescriptorProtos$DescriptorProto$ExtensionRangeOrBuilder {
   private int bitField0_;
   public static final int START_FIELD_NUMBER = 1;
   private int start_;
   public static final int END_FIELD_NUMBER = 2;
   private int end_;
   private byte memoizedIsInitialized;
   private int memoizedSerializedSize;
   private static final long serialVersionUID = 0L;
   private static final DescriptorProtos$DescriptorProto$ExtensionRange DEFAULT_INSTANCE = new DescriptorProtos$DescriptorProto$ExtensionRange();
   public static final Parser PARSER = new DescriptorProtos$DescriptorProto$ExtensionRange$1();

   private DescriptorProtos$DescriptorProto$ExtensionRange(GeneratedMessage$Builder var1) {
      super(var1);
      this.memoizedIsInitialized = -1;
      this.memoizedSerializedSize = -1;
   }

   private DescriptorProtos$DescriptorProto$ExtensionRange() {
      this.memoizedIsInitialized = -1;
      this.memoizedSerializedSize = -1;
      this.start_ = 0;
      this.end_ = 0;
   }

   public final UnknownFieldSet getUnknownFields() {
      return this.unknownFields;
   }

   private DescriptorProtos$DescriptorProto$ExtensionRange(CodedInputStream var1, ExtensionRegistryLite var2) {
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
               this.start_ = var1.readInt32();
               break;
            case 16:
               this.bitField0_ |= 2;
               this.end_ = var1.readInt32();
               break;
            default:
               if(!this.parseUnknownField(var1, var4, var2, var6)) {
                  var5 = true;
               }
            }
         }
      } catch (InvalidProtocolBufferException var12) {
         throw new RuntimeException(var12.setUnfinishedMessage(this));
      } catch (IOException var13) {
         throw new RuntimeException((new InvalidProtocolBufferException(var13.getMessage())).setUnfinishedMessage(this));
      } finally {
         this.unknownFields = var4.build();
         this.makeExtensionsImmutable();
      }

   }

   public static final Descriptors$Descriptor getDescriptor() {
      return DescriptorProtos.access$2800();
   }

   protected GeneratedMessage$FieldAccessorTable internalGetFieldAccessorTable() {
      return DescriptorProtos.access$2900().ensureFieldAccessorsInitialized(DescriptorProtos$DescriptorProto$ExtensionRange.class, DescriptorProtos$DescriptorProto$ExtensionRange$Builder.class);
   }

   public boolean hasStart() {
      return (this.bitField0_ & 1) == 1;
   }

   public int getStart() {
      return this.start_;
   }

   public boolean hasEnd() {
      return (this.bitField0_ & 2) == 2;
   }

   public int getEnd() {
      return this.end_;
   }

   public final boolean isInitialized() {
      byte var1 = this.memoizedIsInitialized;
      if(var1 == 1) {
         return true;
      } else if(var1 == 0) {
         return false;
      } else {
         this.memoizedIsInitialized = 1;
         return true;
      }
   }

   public void writeTo(CodedOutputStream var1) {
      if((this.bitField0_ & 1) == 1) {
         var1.writeInt32(1, this.start_);
      }

      if((this.bitField0_ & 2) == 2) {
         var1.writeInt32(2, this.end_);
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
            var1 += CodedOutputStream.computeInt32Size(1, this.start_);
         }

         if((this.bitField0_ & 2) == 2) {
            var1 += CodedOutputStream.computeInt32Size(2, this.end_);
         }

         var1 += this.unknownFields.getSerializedSize();
         this.memoizedSerializedSize = var1;
         return var1;
      }
   }

   public static DescriptorProtos$DescriptorProto$ExtensionRange parseFrom(ByteString var0) {
      return (DescriptorProtos$DescriptorProto$ExtensionRange)PARSER.parseFrom(var0);
   }

   public static DescriptorProtos$DescriptorProto$ExtensionRange parseFrom(ByteString var0, ExtensionRegistryLite var1) {
      return (DescriptorProtos$DescriptorProto$ExtensionRange)PARSER.parseFrom(var0, var1);
   }

   public static DescriptorProtos$DescriptorProto$ExtensionRange parseFrom(byte[] var0) {
      return (DescriptorProtos$DescriptorProto$ExtensionRange)PARSER.parseFrom(var0);
   }

   public static DescriptorProtos$DescriptorProto$ExtensionRange parseFrom(byte[] var0, ExtensionRegistryLite var1) {
      return (DescriptorProtos$DescriptorProto$ExtensionRange)PARSER.parseFrom(var0, var1);
   }

   public static DescriptorProtos$DescriptorProto$ExtensionRange parseFrom(InputStream var0) {
      return (DescriptorProtos$DescriptorProto$ExtensionRange)PARSER.parseFrom(var0);
   }

   public static DescriptorProtos$DescriptorProto$ExtensionRange parseFrom(InputStream var0, ExtensionRegistryLite var1) {
      return (DescriptorProtos$DescriptorProto$ExtensionRange)PARSER.parseFrom(var0, var1);
   }

   public static DescriptorProtos$DescriptorProto$ExtensionRange parseDelimitedFrom(InputStream var0) {
      return (DescriptorProtos$DescriptorProto$ExtensionRange)PARSER.parseDelimitedFrom(var0);
   }

   public static DescriptorProtos$DescriptorProto$ExtensionRange parseDelimitedFrom(InputStream var0, ExtensionRegistryLite var1) {
      return (DescriptorProtos$DescriptorProto$ExtensionRange)PARSER.parseDelimitedFrom(var0, var1);
   }

   public static DescriptorProtos$DescriptorProto$ExtensionRange parseFrom(CodedInputStream var0) {
      return (DescriptorProtos$DescriptorProto$ExtensionRange)PARSER.parseFrom(var0);
   }

   public static DescriptorProtos$DescriptorProto$ExtensionRange parseFrom(CodedInputStream var0, ExtensionRegistryLite var1) {
      return (DescriptorProtos$DescriptorProto$ExtensionRange)PARSER.parseFrom(var0, var1);
   }

   public DescriptorProtos$DescriptorProto$ExtensionRange$Builder newBuilderForType() {
      return newBuilder();
   }

   public static DescriptorProtos$DescriptorProto$ExtensionRange$Builder newBuilder() {
      return DEFAULT_INSTANCE.toBuilder();
   }

   public static DescriptorProtos$DescriptorProto$ExtensionRange$Builder newBuilder(DescriptorProtos$DescriptorProto$ExtensionRange var0) {
      return DEFAULT_INSTANCE.toBuilder().mergeFrom(var0);
   }

   public DescriptorProtos$DescriptorProto$ExtensionRange$Builder toBuilder() {
      return this == DEFAULT_INSTANCE?new DescriptorProtos$DescriptorProto$ExtensionRange$Builder((DescriptorProtos$1)null):(new DescriptorProtos$DescriptorProto$ExtensionRange$Builder((DescriptorProtos$1)null)).mergeFrom(this);
   }

   protected DescriptorProtos$DescriptorProto$ExtensionRange$Builder newBuilderForType(GeneratedMessage$BuilderParent var1) {
      DescriptorProtos$DescriptorProto$ExtensionRange$Builder var2 = new DescriptorProtos$DescriptorProto$ExtensionRange$Builder(var1, (DescriptorProtos$1)null);
      return var2;
   }

   public static DescriptorProtos$DescriptorProto$ExtensionRange getDefaultInstance() {
      return DEFAULT_INSTANCE;
   }

   public Parser getParserForType() {
      return PARSER;
   }

   public DescriptorProtos$DescriptorProto$ExtensionRange getDefaultInstanceForType() {
      return DEFAULT_INSTANCE;
   }

   // $FF: synthetic method
   DescriptorProtos$DescriptorProto$ExtensionRange(GeneratedMessage$Builder var1, DescriptorProtos$1 var2) {
      this(var1);
   }

   // $FF: synthetic method
   static int access$3302(DescriptorProtos$DescriptorProto$ExtensionRange var0, int var1) {
      return var0.start_ = var1;
   }

   // $FF: synthetic method
   static int access$3402(DescriptorProtos$DescriptorProto$ExtensionRange var0, int var1) {
      return var0.end_ = var1;
   }

   // $FF: synthetic method
   static int access$3502(DescriptorProtos$DescriptorProto$ExtensionRange var0, int var1) {
      return var0.bitField0_ = var1;
   }

   // $FF: synthetic method
   DescriptorProtos$DescriptorProto$ExtensionRange(CodedInputStream var1, ExtensionRegistryLite var2, DescriptorProtos$1 var3) {
      this(var1, var2);
   }
}
