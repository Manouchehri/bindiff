package com.google.protobuf;

import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.DescriptorProtos;
import com.google.protobuf.DescriptorProtos$1;
import com.google.protobuf.DescriptorProtos$OneofDescriptorProto;
import com.google.protobuf.DescriptorProtos$OneofDescriptorProtoOrBuilder;
import com.google.protobuf.Descriptors$Descriptor;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessage;
import com.google.protobuf.GeneratedMessage$Builder;
import com.google.protobuf.GeneratedMessage$BuilderParent;
import com.google.protobuf.GeneratedMessage$FieldAccessorTable;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.Message;

public final class DescriptorProtos$OneofDescriptorProto$Builder extends GeneratedMessage$Builder implements DescriptorProtos$OneofDescriptorProtoOrBuilder {
   private int bitField0_;
   private Object name_;

   public static final Descriptors$Descriptor getDescriptor() {
      return DescriptorProtos.access$7700();
   }

   protected GeneratedMessage$FieldAccessorTable internalGetFieldAccessorTable() {
      return DescriptorProtos.access$7800().ensureFieldAccessorsInitialized(DescriptorProtos$OneofDescriptorProto.class, DescriptorProtos$OneofDescriptorProto$Builder.class);
   }

   private DescriptorProtos$OneofDescriptorProto$Builder() {
      this.name_ = "";
      this.maybeForceBuilderInitialization();
   }

   private DescriptorProtos$OneofDescriptorProto$Builder(GeneratedMessage$BuilderParent var1) {
      super(var1);
      this.name_ = "";
      this.maybeForceBuilderInitialization();
   }

   private void maybeForceBuilderInitialization() {
      if(GeneratedMessage.alwaysUseFieldBuilders) {
         ;
      }

   }

   public DescriptorProtos$OneofDescriptorProto$Builder clear() {
      super.clear();
      this.name_ = "";
      this.bitField0_ &= -2;
      return this;
   }

   public Descriptors$Descriptor getDescriptorForType() {
      return DescriptorProtos.access$7700();
   }

   public DescriptorProtos$OneofDescriptorProto getDefaultInstanceForType() {
      return DescriptorProtos$OneofDescriptorProto.getDefaultInstance();
   }

   public DescriptorProtos$OneofDescriptorProto build() {
      DescriptorProtos$OneofDescriptorProto var1 = this.buildPartial();
      if(!var1.isInitialized()) {
         throw newUninitializedMessageException(var1);
      } else {
         return var1;
      }
   }

   public DescriptorProtos$OneofDescriptorProto buildPartial() {
      DescriptorProtos$OneofDescriptorProto var1 = new DescriptorProtos$OneofDescriptorProto(this, (DescriptorProtos$1)null);
      int var2 = this.bitField0_;
      int var3 = 0;
      if((var2 & 1) == 1) {
         var3 |= 1;
      }

      DescriptorProtos$OneofDescriptorProto.access$8202(var1, this.name_);
      DescriptorProtos$OneofDescriptorProto.access$8302(var1, var3);
      this.onBuilt();
      return var1;
   }

   public DescriptorProtos$OneofDescriptorProto$Builder mergeFrom(Message var1) {
      if(var1 instanceof DescriptorProtos$OneofDescriptorProto) {
         return this.mergeFrom((DescriptorProtos$OneofDescriptorProto)var1);
      } else {
         super.mergeFrom(var1);
         return this;
      }
   }

   public DescriptorProtos$OneofDescriptorProto$Builder mergeFrom(DescriptorProtos$OneofDescriptorProto var1) {
      if(var1 == DescriptorProtos$OneofDescriptorProto.getDefaultInstance()) {
         return this;
      } else {
         if(var1.hasName()) {
            this.bitField0_ |= 1;
            this.name_ = DescriptorProtos$OneofDescriptorProto.access$8200(var1);
            this.onChanged();
         }

         this.mergeUnknownFields(var1.unknownFields);
         this.onChanged();
         return this;
      }
   }

   public final boolean isInitialized() {
      return true;
   }

   public DescriptorProtos$OneofDescriptorProto$Builder mergeFrom(CodedInputStream var1, ExtensionRegistryLite var2) {
      DescriptorProtos$OneofDescriptorProto var3 = null;

      try {
         var3 = (DescriptorProtos$OneofDescriptorProto)DescriptorProtos$OneofDescriptorProto.PARSER.parsePartialFrom(var1, var2);
      } catch (InvalidProtocolBufferException var9) {
         var3 = (DescriptorProtos$OneofDescriptorProto)var9.getUnfinishedMessage();
         throw var9;
      } finally {
         if(var3 != null) {
            this.mergeFrom(var3);
         }

      }

      return this;
   }

   public boolean hasName() {
      return (this.bitField0_ & 1) == 1;
   }

   public String getName() {
      Object var1 = this.name_;
      if(!(var1 instanceof String)) {
         ByteString var2 = (ByteString)var1;
         String var3 = var2.toStringUtf8();
         if(var2.isValidUtf8()) {
            this.name_ = var3;
         }

         return var3;
      } else {
         return (String)var1;
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

   public DescriptorProtos$OneofDescriptorProto$Builder setName(String var1) {
      if(var1 == null) {
         throw new NullPointerException();
      } else {
         this.bitField0_ |= 1;
         this.name_ = var1;
         this.onChanged();
         return this;
      }
   }

   public DescriptorProtos$OneofDescriptorProto$Builder clearName() {
      this.bitField0_ &= -2;
      this.name_ = DescriptorProtos$OneofDescriptorProto.getDefaultInstance().getName();
      this.onChanged();
      return this;
   }

   public DescriptorProtos$OneofDescriptorProto$Builder setNameBytes(ByteString var1) {
      if(var1 == null) {
         throw new NullPointerException();
      } else {
         this.bitField0_ |= 1;
         this.name_ = var1;
         this.onChanged();
         return this;
      }
   }

   // $FF: synthetic method
   DescriptorProtos$OneofDescriptorProto$Builder(DescriptorProtos$1 var1) {
      this();
   }

   // $FF: synthetic method
   DescriptorProtos$OneofDescriptorProto$Builder(GeneratedMessage$BuilderParent var1, DescriptorProtos$1 var2) {
      this(var1);
   }
}
