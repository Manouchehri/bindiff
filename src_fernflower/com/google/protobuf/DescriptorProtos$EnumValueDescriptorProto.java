package com.google.protobuf;

import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.DescriptorProtos;
import com.google.protobuf.DescriptorProtos$1;
import com.google.protobuf.DescriptorProtos$EnumValueDescriptorProto$1;
import com.google.protobuf.DescriptorProtos$EnumValueDescriptorProto$Builder;
import com.google.protobuf.DescriptorProtos$EnumValueDescriptorProtoOrBuilder;
import com.google.protobuf.DescriptorProtos$EnumValueOptions;
import com.google.protobuf.DescriptorProtos$EnumValueOptions$Builder;
import com.google.protobuf.DescriptorProtos$EnumValueOptionsOrBuilder;
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

public final class DescriptorProtos$EnumValueDescriptorProto extends GeneratedMessage implements DescriptorProtos$EnumValueDescriptorProtoOrBuilder {
   private int bitField0_;
   public static final int NAME_FIELD_NUMBER = 1;
   private volatile Object name_;
   public static final int NUMBER_FIELD_NUMBER = 2;
   private int number_;
   public static final int OPTIONS_FIELD_NUMBER = 3;
   private DescriptorProtos$EnumValueOptions options_;
   private byte memoizedIsInitialized;
   private int memoizedSerializedSize;
   private static final long serialVersionUID = 0L;
   private static final DescriptorProtos$EnumValueDescriptorProto DEFAULT_INSTANCE = new DescriptorProtos$EnumValueDescriptorProto();
   public static final Parser PARSER = new DescriptorProtos$EnumValueDescriptorProto$1();

   private DescriptorProtos$EnumValueDescriptorProto(GeneratedMessage$Builder var1) {
      super(var1);
      this.memoizedIsInitialized = -1;
      this.memoizedSerializedSize = -1;
   }

   private DescriptorProtos$EnumValueDescriptorProto() {
      this.memoizedIsInitialized = -1;
      this.memoizedSerializedSize = -1;
      this.name_ = "";
      this.number_ = 0;
   }

   public final UnknownFieldSet getUnknownFields() {
      return this.unknownFields;
   }

   private DescriptorProtos$EnumValueDescriptorProto(CodedInputStream var1, ExtensionRegistryLite var2) {
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
            case 10:
               ByteString var16 = var1.readBytes();
               this.bitField0_ |= 1;
               this.name_ = var16;
               break;
            case 16:
               this.bitField0_ |= 2;
               this.number_ = var1.readInt32();
               break;
            case 26:
               DescriptorProtos$EnumValueOptions$Builder var7 = null;
               if((this.bitField0_ & 4) == 4) {
                  var7 = this.options_.toBuilder();
               }

               this.options_ = (DescriptorProtos$EnumValueOptions)var1.readMessage(DescriptorProtos$EnumValueOptions.PARSER, var2);
               if(var7 != null) {
                  var7.mergeFrom(this.options_);
                  this.options_ = var7.buildPartial();
               }

               this.bitField0_ |= 4;
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
      return DescriptorProtos.access$9500();
   }

   protected GeneratedMessage$FieldAccessorTable internalGetFieldAccessorTable() {
      return DescriptorProtos.access$9600().ensureFieldAccessorsInitialized(DescriptorProtos$EnumValueDescriptorProto.class, DescriptorProtos$EnumValueDescriptorProto$Builder.class);
   }

   public boolean hasName() {
      return (this.bitField0_ & 1) == 1;
   }

   public String getName() {
      Object var1 = this.name_;
      if(var1 instanceof String) {
         return (String)var1;
      } else {
         ByteString var2 = (ByteString)var1;
         String var3 = var2.toStringUtf8();
         if(var2.isValidUtf8()) {
            this.name_ = var3;
         }

         return var3;
      }
   }

   public ByteString getNameBytes() {
      Object var1 = this.name_;
      if(var1 instanceof String) {
         ByteString var2 = ByteString.copyFromUtf8((String)var1);
         this.name_ = var2;
         return var2;
      } else {
         return (ByteString)var1;
      }
   }

   public boolean hasNumber() {
      return (this.bitField0_ & 2) == 2;
   }

   public int getNumber() {
      return this.number_;
   }

   public boolean hasOptions() {
      return (this.bitField0_ & 4) == 4;
   }

   public DescriptorProtos$EnumValueOptions getOptions() {
      return this.options_ == null?DescriptorProtos$EnumValueOptions.getDefaultInstance():this.options_;
   }

   public DescriptorProtos$EnumValueOptionsOrBuilder getOptionsOrBuilder() {
      return this.options_ == null?DescriptorProtos$EnumValueOptions.getDefaultInstance():this.options_;
   }

   public final boolean isInitialized() {
      byte var1 = this.memoizedIsInitialized;
      if(var1 == 1) {
         return true;
      } else if(var1 == 0) {
         return false;
      } else if(this.hasOptions() && !this.getOptions().isInitialized()) {
         this.memoizedIsInitialized = 0;
         return false;
      } else {
         this.memoizedIsInitialized = 1;
         return true;
      }
   }

   public void writeTo(CodedOutputStream var1) {
      if((this.bitField0_ & 1) == 1) {
         var1.writeBytes(1, this.getNameBytes());
      }

      if((this.bitField0_ & 2) == 2) {
         var1.writeInt32(2, this.number_);
      }

      if((this.bitField0_ & 4) == 4) {
         var1.writeMessage(3, this.getOptions());
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
            var1 += CodedOutputStream.computeBytesSize(1, this.getNameBytes());
         }

         if((this.bitField0_ & 2) == 2) {
            var1 += CodedOutputStream.computeInt32Size(2, this.number_);
         }

         if((this.bitField0_ & 4) == 4) {
            var1 += CodedOutputStream.computeMessageSize(3, this.getOptions());
         }

         var1 += this.unknownFields.getSerializedSize();
         this.memoizedSerializedSize = var1;
         return var1;
      }
   }

   public static DescriptorProtos$EnumValueDescriptorProto parseFrom(ByteString var0) {
      return (DescriptorProtos$EnumValueDescriptorProto)PARSER.parseFrom(var0);
   }

   public static DescriptorProtos$EnumValueDescriptorProto parseFrom(ByteString var0, ExtensionRegistryLite var1) {
      return (DescriptorProtos$EnumValueDescriptorProto)PARSER.parseFrom(var0, var1);
   }

   public static DescriptorProtos$EnumValueDescriptorProto parseFrom(byte[] var0) {
      return (DescriptorProtos$EnumValueDescriptorProto)PARSER.parseFrom(var0);
   }

   public static DescriptorProtos$EnumValueDescriptorProto parseFrom(byte[] var0, ExtensionRegistryLite var1) {
      return (DescriptorProtos$EnumValueDescriptorProto)PARSER.parseFrom(var0, var1);
   }

   public static DescriptorProtos$EnumValueDescriptorProto parseFrom(InputStream var0) {
      return (DescriptorProtos$EnumValueDescriptorProto)PARSER.parseFrom(var0);
   }

   public static DescriptorProtos$EnumValueDescriptorProto parseFrom(InputStream var0, ExtensionRegistryLite var1) {
      return (DescriptorProtos$EnumValueDescriptorProto)PARSER.parseFrom(var0, var1);
   }

   public static DescriptorProtos$EnumValueDescriptorProto parseDelimitedFrom(InputStream var0) {
      return (DescriptorProtos$EnumValueDescriptorProto)PARSER.parseDelimitedFrom(var0);
   }

   public static DescriptorProtos$EnumValueDescriptorProto parseDelimitedFrom(InputStream var0, ExtensionRegistryLite var1) {
      return (DescriptorProtos$EnumValueDescriptorProto)PARSER.parseDelimitedFrom(var0, var1);
   }

   public static DescriptorProtos$EnumValueDescriptorProto parseFrom(CodedInputStream var0) {
      return (DescriptorProtos$EnumValueDescriptorProto)PARSER.parseFrom(var0);
   }

   public static DescriptorProtos$EnumValueDescriptorProto parseFrom(CodedInputStream var0, ExtensionRegistryLite var1) {
      return (DescriptorProtos$EnumValueDescriptorProto)PARSER.parseFrom(var0, var1);
   }

   public DescriptorProtos$EnumValueDescriptorProto$Builder newBuilderForType() {
      return newBuilder();
   }

   public static DescriptorProtos$EnumValueDescriptorProto$Builder newBuilder() {
      return DEFAULT_INSTANCE.toBuilder();
   }

   public static DescriptorProtos$EnumValueDescriptorProto$Builder newBuilder(DescriptorProtos$EnumValueDescriptorProto var0) {
      return DEFAULT_INSTANCE.toBuilder().mergeFrom(var0);
   }

   public DescriptorProtos$EnumValueDescriptorProto$Builder toBuilder() {
      return this == DEFAULT_INSTANCE?new DescriptorProtos$EnumValueDescriptorProto$Builder((DescriptorProtos$1)null):(new DescriptorProtos$EnumValueDescriptorProto$Builder((DescriptorProtos$1)null)).mergeFrom(this);
   }

   protected DescriptorProtos$EnumValueDescriptorProto$Builder newBuilderForType(GeneratedMessage$BuilderParent var1) {
      DescriptorProtos$EnumValueDescriptorProto$Builder var2 = new DescriptorProtos$EnumValueDescriptorProto$Builder(var1, (DescriptorProtos$1)null);
      return var2;
   }

   public static DescriptorProtos$EnumValueDescriptorProto getDefaultInstance() {
      return DEFAULT_INSTANCE;
   }

   public Parser getParserForType() {
      return PARSER;
   }

   public DescriptorProtos$EnumValueDescriptorProto getDefaultInstanceForType() {
      return DEFAULT_INSTANCE;
   }

   // $FF: synthetic method
   DescriptorProtos$EnumValueDescriptorProto(GeneratedMessage$Builder var1, DescriptorProtos$1 var2) {
      this(var1);
   }

   // $FF: synthetic method
   static Object access$10002(DescriptorProtos$EnumValueDescriptorProto var0, Object var1) {
      return var0.name_ = var1;
   }

   // $FF: synthetic method
   static int access$10102(DescriptorProtos$EnumValueDescriptorProto var0, int var1) {
      return var0.number_ = var1;
   }

   // $FF: synthetic method
   static DescriptorProtos$EnumValueOptions access$10202(DescriptorProtos$EnumValueDescriptorProto var0, DescriptorProtos$EnumValueOptions var1) {
      return var0.options_ = var1;
   }

   // $FF: synthetic method
   static int access$10302(DescriptorProtos$EnumValueDescriptorProto var0, int var1) {
      return var0.bitField0_ = var1;
   }

   // $FF: synthetic method
   static Object access$10000(DescriptorProtos$EnumValueDescriptorProto var0) {
      return var0.name_;
   }

   // $FF: synthetic method
   DescriptorProtos$EnumValueDescriptorProto(CodedInputStream var1, ExtensionRegistryLite var2, DescriptorProtos$1 var3) {
      this(var1, var2);
   }
}
