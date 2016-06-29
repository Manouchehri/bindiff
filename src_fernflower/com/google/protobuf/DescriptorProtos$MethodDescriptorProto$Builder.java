package com.google.protobuf;

import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.DescriptorProtos;
import com.google.protobuf.DescriptorProtos$1;
import com.google.protobuf.DescriptorProtos$MethodDescriptorProto;
import com.google.protobuf.DescriptorProtos$MethodDescriptorProtoOrBuilder;
import com.google.protobuf.DescriptorProtos$MethodOptions;
import com.google.protobuf.DescriptorProtos$MethodOptions$Builder;
import com.google.protobuf.DescriptorProtos$MethodOptionsOrBuilder;
import com.google.protobuf.Descriptors$Descriptor;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessage;
import com.google.protobuf.GeneratedMessage$Builder;
import com.google.protobuf.GeneratedMessage$BuilderParent;
import com.google.protobuf.GeneratedMessage$FieldAccessorTable;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.Message;
import com.google.protobuf.SingleFieldBuilder;

public final class DescriptorProtos$MethodDescriptorProto$Builder extends GeneratedMessage$Builder implements DescriptorProtos$MethodDescriptorProtoOrBuilder {
   private int bitField0_;
   private Object name_;
   private Object inputType_;
   private Object outputType_;
   private DescriptorProtos$MethodOptions options_;
   private SingleFieldBuilder optionsBuilder_;
   private boolean clientStreaming_;
   private boolean serverStreaming_;

   public static final Descriptors$Descriptor getDescriptor() {
      return DescriptorProtos.access$11500();
   }

   protected GeneratedMessage$FieldAccessorTable internalGetFieldAccessorTable() {
      return DescriptorProtos.access$11600().ensureFieldAccessorsInitialized(DescriptorProtos$MethodDescriptorProto.class, DescriptorProtos$MethodDescriptorProto$Builder.class);
   }

   private DescriptorProtos$MethodDescriptorProto$Builder() {
      this.name_ = "";
      this.inputType_ = "";
      this.outputType_ = "";
      this.options_ = null;
      this.maybeForceBuilderInitialization();
   }

   private DescriptorProtos$MethodDescriptorProto$Builder(GeneratedMessage$BuilderParent var1) {
      super(var1);
      this.name_ = "";
      this.inputType_ = "";
      this.outputType_ = "";
      this.options_ = null;
      this.maybeForceBuilderInitialization();
   }

   private void maybeForceBuilderInitialization() {
      if(GeneratedMessage.alwaysUseFieldBuilders) {
         this.getOptionsFieldBuilder();
      }

   }

   public DescriptorProtos$MethodDescriptorProto$Builder clear() {
      super.clear();
      this.name_ = "";
      this.bitField0_ &= -2;
      this.inputType_ = "";
      this.bitField0_ &= -3;
      this.outputType_ = "";
      this.bitField0_ &= -5;
      if(this.optionsBuilder_ == null) {
         this.options_ = null;
      } else {
         this.optionsBuilder_.clear();
      }

      this.bitField0_ &= -9;
      this.clientStreaming_ = false;
      this.bitField0_ &= -17;
      this.serverStreaming_ = false;
      this.bitField0_ &= -33;
      return this;
   }

   public Descriptors$Descriptor getDescriptorForType() {
      return DescriptorProtos.access$11500();
   }

   public DescriptorProtos$MethodDescriptorProto getDefaultInstanceForType() {
      return DescriptorProtos$MethodDescriptorProto.getDefaultInstance();
   }

   public DescriptorProtos$MethodDescriptorProto build() {
      DescriptorProtos$MethodDescriptorProto var1 = this.buildPartial();
      if(!var1.isInitialized()) {
         throw newUninitializedMessageException(var1);
      } else {
         return var1;
      }
   }

   public DescriptorProtos$MethodDescriptorProto buildPartial() {
      DescriptorProtos$MethodDescriptorProto var1 = new DescriptorProtos$MethodDescriptorProto(this, (DescriptorProtos$1)null);
      int var2 = this.bitField0_;
      int var3 = 0;
      if((var2 & 1) == 1) {
         var3 |= 1;
      }

      DescriptorProtos$MethodDescriptorProto.access$12002(var1, this.name_);
      if((var2 & 2) == 2) {
         var3 |= 2;
      }

      DescriptorProtos$MethodDescriptorProto.access$12102(var1, this.inputType_);
      if((var2 & 4) == 4) {
         var3 |= 4;
      }

      DescriptorProtos$MethodDescriptorProto.access$12202(var1, this.outputType_);
      if((var2 & 8) == 8) {
         var3 |= 8;
      }

      if(this.optionsBuilder_ == null) {
         DescriptorProtos$MethodDescriptorProto.access$12302(var1, this.options_);
      } else {
         DescriptorProtos$MethodDescriptorProto.access$12302(var1, (DescriptorProtos$MethodOptions)this.optionsBuilder_.build());
      }

      if((var2 & 16) == 16) {
         var3 |= 16;
      }

      DescriptorProtos$MethodDescriptorProto.access$12402(var1, this.clientStreaming_);
      if((var2 & 32) == 32) {
         var3 |= 32;
      }

      DescriptorProtos$MethodDescriptorProto.access$12502(var1, this.serverStreaming_);
      DescriptorProtos$MethodDescriptorProto.access$12602(var1, var3);
      this.onBuilt();
      return var1;
   }

   public DescriptorProtos$MethodDescriptorProto$Builder mergeFrom(Message var1) {
      if(var1 instanceof DescriptorProtos$MethodDescriptorProto) {
         return this.mergeFrom((DescriptorProtos$MethodDescriptorProto)var1);
      } else {
         super.mergeFrom(var1);
         return this;
      }
   }

   public DescriptorProtos$MethodDescriptorProto$Builder mergeFrom(DescriptorProtos$MethodDescriptorProto var1) {
      if(var1 == DescriptorProtos$MethodDescriptorProto.getDefaultInstance()) {
         return this;
      } else {
         if(var1.hasName()) {
            this.bitField0_ |= 1;
            this.name_ = DescriptorProtos$MethodDescriptorProto.access$12000(var1);
            this.onChanged();
         }

         if(var1.hasInputType()) {
            this.bitField0_ |= 2;
            this.inputType_ = DescriptorProtos$MethodDescriptorProto.access$12100(var1);
            this.onChanged();
         }

         if(var1.hasOutputType()) {
            this.bitField0_ |= 4;
            this.outputType_ = DescriptorProtos$MethodDescriptorProto.access$12200(var1);
            this.onChanged();
         }

         if(var1.hasOptions()) {
            this.mergeOptions(var1.getOptions());
         }

         if(var1.hasClientStreaming()) {
            this.setClientStreaming(var1.getClientStreaming());
         }

         if(var1.hasServerStreaming()) {
            this.setServerStreaming(var1.getServerStreaming());
         }

         this.mergeUnknownFields(var1.unknownFields);
         this.onChanged();
         return this;
      }
   }

   public final boolean isInitialized() {
      return !this.hasOptions() || this.getOptions().isInitialized();
   }

   public DescriptorProtos$MethodDescriptorProto$Builder mergeFrom(CodedInputStream var1, ExtensionRegistryLite var2) {
      DescriptorProtos$MethodDescriptorProto var3 = null;

      try {
         var3 = (DescriptorProtos$MethodDescriptorProto)DescriptorProtos$MethodDescriptorProto.PARSER.parsePartialFrom(var1, var2);
      } catch (InvalidProtocolBufferException var9) {
         var3 = (DescriptorProtos$MethodDescriptorProto)var9.getUnfinishedMessage();
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

   public DescriptorProtos$MethodDescriptorProto$Builder setName(String var1) {
      if(var1 == null) {
         throw new NullPointerException();
      } else {
         this.bitField0_ |= 1;
         this.name_ = var1;
         this.onChanged();
         return this;
      }
   }

   public DescriptorProtos$MethodDescriptorProto$Builder clearName() {
      this.bitField0_ &= -2;
      this.name_ = DescriptorProtos$MethodDescriptorProto.getDefaultInstance().getName();
      this.onChanged();
      return this;
   }

   public DescriptorProtos$MethodDescriptorProto$Builder setNameBytes(ByteString var1) {
      if(var1 == null) {
         throw new NullPointerException();
      } else {
         this.bitField0_ |= 1;
         this.name_ = var1;
         this.onChanged();
         return this;
      }
   }

   public boolean hasInputType() {
      return (this.bitField0_ & 2) == 2;
   }

   public String getInputType() {
      Object var1 = this.inputType_;
      if(!(var1 instanceof String)) {
         ByteString var2 = (ByteString)var1;
         String var3 = var2.toStringUtf8();
         if(var2.isValidUtf8()) {
            this.inputType_ = var3;
         }

         return var3;
      } else {
         return (String)var1;
      }
   }

   public ByteString getInputTypeBytes() {
      Object var1 = this.inputType_;
      if(var1 instanceof String) {
         ByteString var2 = ByteString.copyFromUtf8((String)var1);
         this.inputType_ = var2;
         return var2;
      } else {
         return (ByteString)var1;
      }
   }

   public DescriptorProtos$MethodDescriptorProto$Builder setInputType(String var1) {
      if(var1 == null) {
         throw new NullPointerException();
      } else {
         this.bitField0_ |= 2;
         this.inputType_ = var1;
         this.onChanged();
         return this;
      }
   }

   public DescriptorProtos$MethodDescriptorProto$Builder clearInputType() {
      this.bitField0_ &= -3;
      this.inputType_ = DescriptorProtos$MethodDescriptorProto.getDefaultInstance().getInputType();
      this.onChanged();
      return this;
   }

   public DescriptorProtos$MethodDescriptorProto$Builder setInputTypeBytes(ByteString var1) {
      if(var1 == null) {
         throw new NullPointerException();
      } else {
         this.bitField0_ |= 2;
         this.inputType_ = var1;
         this.onChanged();
         return this;
      }
   }

   public boolean hasOutputType() {
      return (this.bitField0_ & 4) == 4;
   }

   public String getOutputType() {
      Object var1 = this.outputType_;
      if(!(var1 instanceof String)) {
         ByteString var2 = (ByteString)var1;
         String var3 = var2.toStringUtf8();
         if(var2.isValidUtf8()) {
            this.outputType_ = var3;
         }

         return var3;
      } else {
         return (String)var1;
      }
   }

   public ByteString getOutputTypeBytes() {
      Object var1 = this.outputType_;
      if(var1 instanceof String) {
         ByteString var2 = ByteString.copyFromUtf8((String)var1);
         this.outputType_ = var2;
         return var2;
      } else {
         return (ByteString)var1;
      }
   }

   public DescriptorProtos$MethodDescriptorProto$Builder setOutputType(String var1) {
      if(var1 == null) {
         throw new NullPointerException();
      } else {
         this.bitField0_ |= 4;
         this.outputType_ = var1;
         this.onChanged();
         return this;
      }
   }

   public DescriptorProtos$MethodDescriptorProto$Builder clearOutputType() {
      this.bitField0_ &= -5;
      this.outputType_ = DescriptorProtos$MethodDescriptorProto.getDefaultInstance().getOutputType();
      this.onChanged();
      return this;
   }

   public DescriptorProtos$MethodDescriptorProto$Builder setOutputTypeBytes(ByteString var1) {
      if(var1 == null) {
         throw new NullPointerException();
      } else {
         this.bitField0_ |= 4;
         this.outputType_ = var1;
         this.onChanged();
         return this;
      }
   }

   public boolean hasOptions() {
      return (this.bitField0_ & 8) == 8;
   }

   public DescriptorProtos$MethodOptions getOptions() {
      return this.optionsBuilder_ == null?(this.options_ == null?DescriptorProtos$MethodOptions.getDefaultInstance():this.options_):(DescriptorProtos$MethodOptions)this.optionsBuilder_.getMessage();
   }

   public DescriptorProtos$MethodDescriptorProto$Builder setOptions(DescriptorProtos$MethodOptions var1) {
      if(this.optionsBuilder_ == null) {
         if(var1 == null) {
            throw new NullPointerException();
         }

         this.options_ = var1;
         this.onChanged();
      } else {
         this.optionsBuilder_.setMessage(var1);
      }

      this.bitField0_ |= 8;
      return this;
   }

   public DescriptorProtos$MethodDescriptorProto$Builder setOptions(DescriptorProtos$MethodOptions$Builder var1) {
      if(this.optionsBuilder_ == null) {
         this.options_ = var1.build();
         this.onChanged();
      } else {
         this.optionsBuilder_.setMessage(var1.build());
      }

      this.bitField0_ |= 8;
      return this;
   }

   public DescriptorProtos$MethodDescriptorProto$Builder mergeOptions(DescriptorProtos$MethodOptions var1) {
      if(this.optionsBuilder_ == null) {
         if((this.bitField0_ & 8) == 8 && this.options_ != null && this.options_ != DescriptorProtos$MethodOptions.getDefaultInstance()) {
            this.options_ = DescriptorProtos$MethodOptions.newBuilder(this.options_).mergeFrom(var1).buildPartial();
         } else {
            this.options_ = var1;
         }

         this.onChanged();
      } else {
         this.optionsBuilder_.mergeFrom(var1);
      }

      this.bitField0_ |= 8;
      return this;
   }

   public DescriptorProtos$MethodDescriptorProto$Builder clearOptions() {
      if(this.optionsBuilder_ == null) {
         this.options_ = null;
         this.onChanged();
      } else {
         this.optionsBuilder_.clear();
      }

      this.bitField0_ &= -9;
      return this;
   }

   public DescriptorProtos$MethodOptions$Builder getOptionsBuilder() {
      this.bitField0_ |= 8;
      this.onChanged();
      return (DescriptorProtos$MethodOptions$Builder)this.getOptionsFieldBuilder().getBuilder();
   }

   public DescriptorProtos$MethodOptionsOrBuilder getOptionsOrBuilder() {
      return (DescriptorProtos$MethodOptionsOrBuilder)(this.optionsBuilder_ != null?(DescriptorProtos$MethodOptionsOrBuilder)this.optionsBuilder_.getMessageOrBuilder():(this.options_ == null?DescriptorProtos$MethodOptions.getDefaultInstance():this.options_));
   }

   private SingleFieldBuilder getOptionsFieldBuilder() {
      if(this.optionsBuilder_ == null) {
         this.optionsBuilder_ = new SingleFieldBuilder(this.getOptions(), this.getParentForChildren(), this.isClean());
         this.options_ = null;
      }

      return this.optionsBuilder_;
   }

   public boolean hasClientStreaming() {
      return (this.bitField0_ & 16) == 16;
   }

   public boolean getClientStreaming() {
      return this.clientStreaming_;
   }

   public DescriptorProtos$MethodDescriptorProto$Builder setClientStreaming(boolean var1) {
      this.bitField0_ |= 16;
      this.clientStreaming_ = var1;
      this.onChanged();
      return this;
   }

   public DescriptorProtos$MethodDescriptorProto$Builder clearClientStreaming() {
      this.bitField0_ &= -17;
      this.clientStreaming_ = false;
      this.onChanged();
      return this;
   }

   public boolean hasServerStreaming() {
      return (this.bitField0_ & 32) == 32;
   }

   public boolean getServerStreaming() {
      return this.serverStreaming_;
   }

   public DescriptorProtos$MethodDescriptorProto$Builder setServerStreaming(boolean var1) {
      this.bitField0_ |= 32;
      this.serverStreaming_ = var1;
      this.onChanged();
      return this;
   }

   public DescriptorProtos$MethodDescriptorProto$Builder clearServerStreaming() {
      this.bitField0_ &= -33;
      this.serverStreaming_ = false;
      this.onChanged();
      return this;
   }

   // $FF: synthetic method
   DescriptorProtos$MethodDescriptorProto$Builder(DescriptorProtos$1 var1) {
      this();
   }

   // $FF: synthetic method
   DescriptorProtos$MethodDescriptorProto$Builder(GeneratedMessage$BuilderParent var1, DescriptorProtos$1 var2) {
      this(var1);
   }
}
