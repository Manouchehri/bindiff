package com.google.protobuf;

import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.DescriptorProtos;
import com.google.protobuf.DescriptorProtos$1;
import com.google.protobuf.DescriptorProtos$OneofDescriptorProto$1;
import com.google.protobuf.DescriptorProtos$OneofDescriptorProto$Builder;
import com.google.protobuf.DescriptorProtos$OneofDescriptorProtoOrBuilder;
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

public final class DescriptorProtos$OneofDescriptorProto extends GeneratedMessage implements DescriptorProtos$OneofDescriptorProtoOrBuilder {
   private int bitField0_;
   public static final int NAME_FIELD_NUMBER = 1;
   private volatile Object name_;
   private byte memoizedIsInitialized;
   private int memoizedSerializedSize;
   private static final long serialVersionUID = 0L;
   private static final DescriptorProtos$OneofDescriptorProto DEFAULT_INSTANCE = new DescriptorProtos$OneofDescriptorProto();
   public static final Parser PARSER = new DescriptorProtos$OneofDescriptorProto$1();

   private DescriptorProtos$OneofDescriptorProto(GeneratedMessage$Builder var1) {
      super(var1);
      this.memoizedIsInitialized = -1;
      this.memoizedSerializedSize = -1;
   }

   private DescriptorProtos$OneofDescriptorProto() {
      this.memoizedIsInitialized = -1;
      this.memoizedSerializedSize = -1;
      this.name_ = "";
   }

   public final UnknownFieldSet getUnknownFields() {
      return this.unknownFields;
   }

   private DescriptorProtos$OneofDescriptorProto(CodedInputStream var1, ExtensionRegistryLite var2) {
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
               ByteString var7 = var1.readBytes();
               this.bitField0_ |= 1;
               this.name_ = var7;
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
      return DescriptorProtos.access$7700();
   }

   protected GeneratedMessage$FieldAccessorTable internalGetFieldAccessorTable() {
      return DescriptorProtos.access$7800().ensureFieldAccessorsInitialized(DescriptorProtos$OneofDescriptorProto.class, DescriptorProtos$OneofDescriptorProto$Builder.class);
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
         var1.writeBytes(1, this.getNameBytes());
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

         var1 += this.unknownFields.getSerializedSize();
         this.memoizedSerializedSize = var1;
         return var1;
      }
   }

   public static DescriptorProtos$OneofDescriptorProto parseFrom(ByteString var0) {
      return (DescriptorProtos$OneofDescriptorProto)PARSER.parseFrom(var0);
   }

   public static DescriptorProtos$OneofDescriptorProto parseFrom(ByteString var0, ExtensionRegistryLite var1) {
      return (DescriptorProtos$OneofDescriptorProto)PARSER.parseFrom(var0, var1);
   }

   public static DescriptorProtos$OneofDescriptorProto parseFrom(byte[] var0) {
      return (DescriptorProtos$OneofDescriptorProto)PARSER.parseFrom(var0);
   }

   public static DescriptorProtos$OneofDescriptorProto parseFrom(byte[] var0, ExtensionRegistryLite var1) {
      return (DescriptorProtos$OneofDescriptorProto)PARSER.parseFrom(var0, var1);
   }

   public static DescriptorProtos$OneofDescriptorProto parseFrom(InputStream var0) {
      return (DescriptorProtos$OneofDescriptorProto)PARSER.parseFrom(var0);
   }

   public static DescriptorProtos$OneofDescriptorProto parseFrom(InputStream var0, ExtensionRegistryLite var1) {
      return (DescriptorProtos$OneofDescriptorProto)PARSER.parseFrom(var0, var1);
   }

   public static DescriptorProtos$OneofDescriptorProto parseDelimitedFrom(InputStream var0) {
      return (DescriptorProtos$OneofDescriptorProto)PARSER.parseDelimitedFrom(var0);
   }

   public static DescriptorProtos$OneofDescriptorProto parseDelimitedFrom(InputStream var0, ExtensionRegistryLite var1) {
      return (DescriptorProtos$OneofDescriptorProto)PARSER.parseDelimitedFrom(var0, var1);
   }

   public static DescriptorProtos$OneofDescriptorProto parseFrom(CodedInputStream var0) {
      return (DescriptorProtos$OneofDescriptorProto)PARSER.parseFrom(var0);
   }

   public static DescriptorProtos$OneofDescriptorProto parseFrom(CodedInputStream var0, ExtensionRegistryLite var1) {
      return (DescriptorProtos$OneofDescriptorProto)PARSER.parseFrom(var0, var1);
   }

   public DescriptorProtos$OneofDescriptorProto$Builder newBuilderForType() {
      return newBuilder();
   }

   public static DescriptorProtos$OneofDescriptorProto$Builder newBuilder() {
      return DEFAULT_INSTANCE.toBuilder();
   }

   public static DescriptorProtos$OneofDescriptorProto$Builder newBuilder(DescriptorProtos$OneofDescriptorProto var0) {
      return DEFAULT_INSTANCE.toBuilder().mergeFrom(var0);
   }

   public DescriptorProtos$OneofDescriptorProto$Builder toBuilder() {
      return this == DEFAULT_INSTANCE?new DescriptorProtos$OneofDescriptorProto$Builder((DescriptorProtos$1)null):(new DescriptorProtos$OneofDescriptorProto$Builder((DescriptorProtos$1)null)).mergeFrom(this);
   }

   protected DescriptorProtos$OneofDescriptorProto$Builder newBuilderForType(GeneratedMessage$BuilderParent var1) {
      DescriptorProtos$OneofDescriptorProto$Builder var2 = new DescriptorProtos$OneofDescriptorProto$Builder(var1, (DescriptorProtos$1)null);
      return var2;
   }

   public static DescriptorProtos$OneofDescriptorProto getDefaultInstance() {
      return DEFAULT_INSTANCE;
   }

   public Parser getParserForType() {
      return PARSER;
   }

   public DescriptorProtos$OneofDescriptorProto getDefaultInstanceForType() {
      return DEFAULT_INSTANCE;
   }

   // $FF: synthetic method
   DescriptorProtos$OneofDescriptorProto(GeneratedMessage$Builder var1, DescriptorProtos$1 var2) {
      this(var1);
   }

   // $FF: synthetic method
   static Object access$8202(DescriptorProtos$OneofDescriptorProto var0, Object var1) {
      return var0.name_ = var1;
   }

   // $FF: synthetic method
   static int access$8302(DescriptorProtos$OneofDescriptorProto var0, int var1) {
      return var0.bitField0_ = var1;
   }

   // $FF: synthetic method
   static Object access$8200(DescriptorProtos$OneofDescriptorProto var0) {
      return var0.name_;
   }

   // $FF: synthetic method
   DescriptorProtos$OneofDescriptorProto(CodedInputStream var1, ExtensionRegistryLite var2, DescriptorProtos$1 var3) {
      this(var1, var2);
   }
}
