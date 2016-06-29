package com.google.protobuf;

import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.DescriptorProtos;
import com.google.protobuf.DescriptorProtos$1;
import com.google.protobuf.DescriptorProtos$EnumValueDescriptorProto;
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
import com.google.protobuf.Message;
import com.google.protobuf.SingleFieldBuilder;

public final class DescriptorProtos$EnumValueDescriptorProto$Builder extends GeneratedMessage$Builder implements DescriptorProtos$EnumValueDescriptorProtoOrBuilder {
   private int bitField0_;
   private Object name_;
   private int number_;
   private DescriptorProtos$EnumValueOptions options_;
   private SingleFieldBuilder optionsBuilder_;

   public static final Descriptors$Descriptor getDescriptor() {
      return DescriptorProtos.access$9500();
   }

   protected GeneratedMessage$FieldAccessorTable internalGetFieldAccessorTable() {
      return DescriptorProtos.access$9600().ensureFieldAccessorsInitialized(DescriptorProtos$EnumValueDescriptorProto.class, DescriptorProtos$EnumValueDescriptorProto$Builder.class);
   }

   private DescriptorProtos$EnumValueDescriptorProto$Builder() {
      this.name_ = "";
      this.options_ = null;
      this.maybeForceBuilderInitialization();
   }

   private DescriptorProtos$EnumValueDescriptorProto$Builder(GeneratedMessage$BuilderParent var1) {
      super(var1);
      this.name_ = "";
      this.options_ = null;
      this.maybeForceBuilderInitialization();
   }

   private void maybeForceBuilderInitialization() {
      if(GeneratedMessage.alwaysUseFieldBuilders) {
         this.getOptionsFieldBuilder();
      }

   }

   public DescriptorProtos$EnumValueDescriptorProto$Builder clear() {
      super.clear();
      this.name_ = "";
      this.bitField0_ &= -2;
      this.number_ = 0;
      this.bitField0_ &= -3;
      if(this.optionsBuilder_ == null) {
         this.options_ = null;
      } else {
         this.optionsBuilder_.clear();
      }

      this.bitField0_ &= -5;
      return this;
   }

   public Descriptors$Descriptor getDescriptorForType() {
      return DescriptorProtos.access$9500();
   }

   public DescriptorProtos$EnumValueDescriptorProto getDefaultInstanceForType() {
      return DescriptorProtos$EnumValueDescriptorProto.getDefaultInstance();
   }

   public DescriptorProtos$EnumValueDescriptorProto build() {
      DescriptorProtos$EnumValueDescriptorProto var1 = this.buildPartial();
      if(!var1.isInitialized()) {
         throw newUninitializedMessageException(var1);
      } else {
         return var1;
      }
   }

   public DescriptorProtos$EnumValueDescriptorProto buildPartial() {
      DescriptorProtos$EnumValueDescriptorProto var1 = new DescriptorProtos$EnumValueDescriptorProto(this, (DescriptorProtos$1)null);
      int var2 = this.bitField0_;
      int var3 = 0;
      if((var2 & 1) == 1) {
         var3 |= 1;
      }

      DescriptorProtos$EnumValueDescriptorProto.access$10002(var1, this.name_);
      if((var2 & 2) == 2) {
         var3 |= 2;
      }

      DescriptorProtos$EnumValueDescriptorProto.access$10102(var1, this.number_);
      if((var2 & 4) == 4) {
         var3 |= 4;
      }

      if(this.optionsBuilder_ == null) {
         DescriptorProtos$EnumValueDescriptorProto.access$10202(var1, this.options_);
      } else {
         DescriptorProtos$EnumValueDescriptorProto.access$10202(var1, (DescriptorProtos$EnumValueOptions)this.optionsBuilder_.build());
      }

      DescriptorProtos$EnumValueDescriptorProto.access$10302(var1, var3);
      this.onBuilt();
      return var1;
   }

   public DescriptorProtos$EnumValueDescriptorProto$Builder mergeFrom(Message var1) {
      if(var1 instanceof DescriptorProtos$EnumValueDescriptorProto) {
         return this.mergeFrom((DescriptorProtos$EnumValueDescriptorProto)var1);
      } else {
         super.mergeFrom(var1);
         return this;
      }
   }

   public DescriptorProtos$EnumValueDescriptorProto$Builder mergeFrom(DescriptorProtos$EnumValueDescriptorProto var1) {
      if(var1 == DescriptorProtos$EnumValueDescriptorProto.getDefaultInstance()) {
         return this;
      } else {
         if(var1.hasName()) {
            this.bitField0_ |= 1;
            this.name_ = DescriptorProtos$EnumValueDescriptorProto.access$10000(var1);
            this.onChanged();
         }

         if(var1.hasNumber()) {
            this.setNumber(var1.getNumber());
         }

         if(var1.hasOptions()) {
            this.mergeOptions(var1.getOptions());
         }

         this.mergeUnknownFields(var1.unknownFields);
         this.onChanged();
         return this;
      }
   }

   public final boolean isInitialized() {
      return !this.hasOptions() || this.getOptions().isInitialized();
   }

   public DescriptorProtos$EnumValueDescriptorProto$Builder mergeFrom(CodedInputStream var1, ExtensionRegistryLite var2) {
      DescriptorProtos$EnumValueDescriptorProto var3 = null;

      try {
         var3 = (DescriptorProtos$EnumValueDescriptorProto)DescriptorProtos$EnumValueDescriptorProto.PARSER.parsePartialFrom(var1, var2);
      } catch (InvalidProtocolBufferException var9) {
         var3 = (DescriptorProtos$EnumValueDescriptorProto)var9.getUnfinishedMessage();
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

   public DescriptorProtos$EnumValueDescriptorProto$Builder setName(String var1) {
      if(var1 == null) {
         throw new NullPointerException();
      } else {
         this.bitField0_ |= 1;
         this.name_ = var1;
         this.onChanged();
         return this;
      }
   }

   public DescriptorProtos$EnumValueDescriptorProto$Builder clearName() {
      this.bitField0_ &= -2;
      this.name_ = DescriptorProtos$EnumValueDescriptorProto.getDefaultInstance().getName();
      this.onChanged();
      return this;
   }

   public DescriptorProtos$EnumValueDescriptorProto$Builder setNameBytes(ByteString var1) {
      if(var1 == null) {
         throw new NullPointerException();
      } else {
         this.bitField0_ |= 1;
         this.name_ = var1;
         this.onChanged();
         return this;
      }
   }

   public boolean hasNumber() {
      return (this.bitField0_ & 2) == 2;
   }

   public int getNumber() {
      return this.number_;
   }

   public DescriptorProtos$EnumValueDescriptorProto$Builder setNumber(int var1) {
      this.bitField0_ |= 2;
      this.number_ = var1;
      this.onChanged();
      return this;
   }

   public DescriptorProtos$EnumValueDescriptorProto$Builder clearNumber() {
      this.bitField0_ &= -3;
      this.number_ = 0;
      this.onChanged();
      return this;
   }

   public boolean hasOptions() {
      return (this.bitField0_ & 4) == 4;
   }

   public DescriptorProtos$EnumValueOptions getOptions() {
      return this.optionsBuilder_ == null?(this.options_ == null?DescriptorProtos$EnumValueOptions.getDefaultInstance():this.options_):(DescriptorProtos$EnumValueOptions)this.optionsBuilder_.getMessage();
   }

   public DescriptorProtos$EnumValueDescriptorProto$Builder setOptions(DescriptorProtos$EnumValueOptions var1) {
      if(this.optionsBuilder_ == null) {
         if(var1 == null) {
            throw new NullPointerException();
         }

         this.options_ = var1;
         this.onChanged();
      } else {
         this.optionsBuilder_.setMessage(var1);
      }

      this.bitField0_ |= 4;
      return this;
   }

   public DescriptorProtos$EnumValueDescriptorProto$Builder setOptions(DescriptorProtos$EnumValueOptions$Builder var1) {
      if(this.optionsBuilder_ == null) {
         this.options_ = var1.build();
         this.onChanged();
      } else {
         this.optionsBuilder_.setMessage(var1.build());
      }

      this.bitField0_ |= 4;
      return this;
   }

   public DescriptorProtos$EnumValueDescriptorProto$Builder mergeOptions(DescriptorProtos$EnumValueOptions var1) {
      if(this.optionsBuilder_ == null) {
         if((this.bitField0_ & 4) == 4 && this.options_ != null && this.options_ != DescriptorProtos$EnumValueOptions.getDefaultInstance()) {
            this.options_ = DescriptorProtos$EnumValueOptions.newBuilder(this.options_).mergeFrom(var1).buildPartial();
         } else {
            this.options_ = var1;
         }

         this.onChanged();
      } else {
         this.optionsBuilder_.mergeFrom(var1);
      }

      this.bitField0_ |= 4;
      return this;
   }

   public DescriptorProtos$EnumValueDescriptorProto$Builder clearOptions() {
      if(this.optionsBuilder_ == null) {
         this.options_ = null;
         this.onChanged();
      } else {
         this.optionsBuilder_.clear();
      }

      this.bitField0_ &= -5;
      return this;
   }

   public DescriptorProtos$EnumValueOptions$Builder getOptionsBuilder() {
      this.bitField0_ |= 4;
      this.onChanged();
      return (DescriptorProtos$EnumValueOptions$Builder)this.getOptionsFieldBuilder().getBuilder();
   }

   public DescriptorProtos$EnumValueOptionsOrBuilder getOptionsOrBuilder() {
      return (DescriptorProtos$EnumValueOptionsOrBuilder)(this.optionsBuilder_ != null?(DescriptorProtos$EnumValueOptionsOrBuilder)this.optionsBuilder_.getMessageOrBuilder():(this.options_ == null?DescriptorProtos$EnumValueOptions.getDefaultInstance():this.options_));
   }

   private SingleFieldBuilder getOptionsFieldBuilder() {
      if(this.optionsBuilder_ == null) {
         this.optionsBuilder_ = new SingleFieldBuilder(this.getOptions(), this.getParentForChildren(), this.isClean());
         this.options_ = null;
      }

      return this.optionsBuilder_;
   }

   // $FF: synthetic method
   DescriptorProtos$EnumValueDescriptorProto$Builder(DescriptorProtos$1 var1) {
      this();
   }

   // $FF: synthetic method
   DescriptorProtos$EnumValueDescriptorProto$Builder(GeneratedMessage$BuilderParent var1, DescriptorProtos$1 var2) {
      this(var1);
   }
}
