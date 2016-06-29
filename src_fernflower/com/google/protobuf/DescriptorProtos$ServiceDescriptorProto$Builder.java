package com.google.protobuf;

import com.google.protobuf.AbstractMessageLite$Builder;
import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.DescriptorProtos;
import com.google.protobuf.DescriptorProtos$1;
import com.google.protobuf.DescriptorProtos$MethodDescriptorProto;
import com.google.protobuf.DescriptorProtos$MethodDescriptorProto$Builder;
import com.google.protobuf.DescriptorProtos$MethodDescriptorProtoOrBuilder;
import com.google.protobuf.DescriptorProtos$ServiceDescriptorProto;
import com.google.protobuf.DescriptorProtos$ServiceDescriptorProtoOrBuilder;
import com.google.protobuf.DescriptorProtos$ServiceOptions;
import com.google.protobuf.DescriptorProtos$ServiceOptions$Builder;
import com.google.protobuf.DescriptorProtos$ServiceOptionsOrBuilder;
import com.google.protobuf.Descriptors$Descriptor;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessage;
import com.google.protobuf.GeneratedMessage$Builder;
import com.google.protobuf.GeneratedMessage$BuilderParent;
import com.google.protobuf.GeneratedMessage$FieldAccessorTable;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.Message;
import com.google.protobuf.RepeatedFieldBuilder;
import com.google.protobuf.SingleFieldBuilder;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class DescriptorProtos$ServiceDescriptorProto$Builder extends GeneratedMessage$Builder implements DescriptorProtos$ServiceDescriptorProtoOrBuilder {
   private int bitField0_;
   private Object name_;
   private List method_;
   private RepeatedFieldBuilder methodBuilder_;
   private DescriptorProtos$ServiceOptions options_;
   private SingleFieldBuilder optionsBuilder_;

   public static final Descriptors$Descriptor getDescriptor() {
      return DescriptorProtos.access$10500();
   }

   protected GeneratedMessage$FieldAccessorTable internalGetFieldAccessorTable() {
      return DescriptorProtos.access$10600().ensureFieldAccessorsInitialized(DescriptorProtos$ServiceDescriptorProto.class, DescriptorProtos$ServiceDescriptorProto$Builder.class);
   }

   private DescriptorProtos$ServiceDescriptorProto$Builder() {
      this.name_ = "";
      this.method_ = Collections.emptyList();
      this.options_ = null;
      this.maybeForceBuilderInitialization();
   }

   private DescriptorProtos$ServiceDescriptorProto$Builder(GeneratedMessage$BuilderParent var1) {
      super(var1);
      this.name_ = "";
      this.method_ = Collections.emptyList();
      this.options_ = null;
      this.maybeForceBuilderInitialization();
   }

   private void maybeForceBuilderInitialization() {
      if(GeneratedMessage.alwaysUseFieldBuilders) {
         this.getMethodFieldBuilder();
         this.getOptionsFieldBuilder();
      }

   }

   public DescriptorProtos$ServiceDescriptorProto$Builder clear() {
      super.clear();
      this.name_ = "";
      this.bitField0_ &= -2;
      if(this.methodBuilder_ == null) {
         this.method_ = Collections.emptyList();
         this.bitField0_ &= -3;
      } else {
         this.methodBuilder_.clear();
      }

      if(this.optionsBuilder_ == null) {
         this.options_ = null;
      } else {
         this.optionsBuilder_.clear();
      }

      this.bitField0_ &= -5;
      return this;
   }

   public Descriptors$Descriptor getDescriptorForType() {
      return DescriptorProtos.access$10500();
   }

   public DescriptorProtos$ServiceDescriptorProto getDefaultInstanceForType() {
      return DescriptorProtos$ServiceDescriptorProto.getDefaultInstance();
   }

   public DescriptorProtos$ServiceDescriptorProto build() {
      DescriptorProtos$ServiceDescriptorProto var1 = this.buildPartial();
      if(!var1.isInitialized()) {
         throw newUninitializedMessageException(var1);
      } else {
         return var1;
      }
   }

   public DescriptorProtos$ServiceDescriptorProto buildPartial() {
      DescriptorProtos$ServiceDescriptorProto var1 = new DescriptorProtos$ServiceDescriptorProto(this, (DescriptorProtos$1)null);
      int var2 = this.bitField0_;
      int var3 = 0;
      if((var2 & 1) == 1) {
         var3 |= 1;
      }

      DescriptorProtos$ServiceDescriptorProto.access$11002(var1, this.name_);
      if(this.methodBuilder_ == null) {
         if((this.bitField0_ & 2) == 2) {
            this.method_ = Collections.unmodifiableList(this.method_);
            this.bitField0_ &= -3;
         }

         DescriptorProtos$ServiceDescriptorProto.access$11102(var1, this.method_);
      } else {
         DescriptorProtos$ServiceDescriptorProto.access$11102(var1, this.methodBuilder_.build());
      }

      if((var2 & 4) == 4) {
         var3 |= 2;
      }

      if(this.optionsBuilder_ == null) {
         DescriptorProtos$ServiceDescriptorProto.access$11202(var1, this.options_);
      } else {
         DescriptorProtos$ServiceDescriptorProto.access$11202(var1, (DescriptorProtos$ServiceOptions)this.optionsBuilder_.build());
      }

      DescriptorProtos$ServiceDescriptorProto.access$11302(var1, var3);
      this.onBuilt();
      return var1;
   }

   public DescriptorProtos$ServiceDescriptorProto$Builder mergeFrom(Message var1) {
      if(var1 instanceof DescriptorProtos$ServiceDescriptorProto) {
         return this.mergeFrom((DescriptorProtos$ServiceDescriptorProto)var1);
      } else {
         super.mergeFrom(var1);
         return this;
      }
   }

   public DescriptorProtos$ServiceDescriptorProto$Builder mergeFrom(DescriptorProtos$ServiceDescriptorProto var1) {
      if(var1 == DescriptorProtos$ServiceDescriptorProto.getDefaultInstance()) {
         return this;
      } else {
         if(var1.hasName()) {
            this.bitField0_ |= 1;
            this.name_ = DescriptorProtos$ServiceDescriptorProto.access$11000(var1);
            this.onChanged();
         }

         if(this.methodBuilder_ == null) {
            if(!DescriptorProtos$ServiceDescriptorProto.access$11100(var1).isEmpty()) {
               if(this.method_.isEmpty()) {
                  this.method_ = DescriptorProtos$ServiceDescriptorProto.access$11100(var1);
                  this.bitField0_ &= -3;
               } else {
                  this.ensureMethodIsMutable();
                  this.method_.addAll(DescriptorProtos$ServiceDescriptorProto.access$11100(var1));
               }

               this.onChanged();
            }
         } else if(!DescriptorProtos$ServiceDescriptorProto.access$11100(var1).isEmpty()) {
            if(this.methodBuilder_.isEmpty()) {
               this.methodBuilder_.dispose();
               this.methodBuilder_ = null;
               this.method_ = DescriptorProtos$ServiceDescriptorProto.access$11100(var1);
               this.bitField0_ &= -3;
               this.methodBuilder_ = GeneratedMessage.alwaysUseFieldBuilders?this.getMethodFieldBuilder():null;
            } else {
               this.methodBuilder_.addAllMessages(DescriptorProtos$ServiceDescriptorProto.access$11100(var1));
            }
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
      for(int var1 = 0; var1 < this.getMethodCount(); ++var1) {
         if(!this.getMethod(var1).isInitialized()) {
            return false;
         }
      }

      if(this.hasOptions() && !this.getOptions().isInitialized()) {
         return false;
      } else {
         return true;
      }
   }

   public DescriptorProtos$ServiceDescriptorProto$Builder mergeFrom(CodedInputStream var1, ExtensionRegistryLite var2) {
      DescriptorProtos$ServiceDescriptorProto var3 = null;

      try {
         var3 = (DescriptorProtos$ServiceDescriptorProto)DescriptorProtos$ServiceDescriptorProto.PARSER.parsePartialFrom(var1, var2);
      } catch (InvalidProtocolBufferException var9) {
         var3 = (DescriptorProtos$ServiceDescriptorProto)var9.getUnfinishedMessage();
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

   public DescriptorProtos$ServiceDescriptorProto$Builder setName(String var1) {
      if(var1 == null) {
         throw new NullPointerException();
      } else {
         this.bitField0_ |= 1;
         this.name_ = var1;
         this.onChanged();
         return this;
      }
   }

   public DescriptorProtos$ServiceDescriptorProto$Builder clearName() {
      this.bitField0_ &= -2;
      this.name_ = DescriptorProtos$ServiceDescriptorProto.getDefaultInstance().getName();
      this.onChanged();
      return this;
   }

   public DescriptorProtos$ServiceDescriptorProto$Builder setNameBytes(ByteString var1) {
      if(var1 == null) {
         throw new NullPointerException();
      } else {
         this.bitField0_ |= 1;
         this.name_ = var1;
         this.onChanged();
         return this;
      }
   }

   private void ensureMethodIsMutable() {
      if((this.bitField0_ & 2) != 2) {
         this.method_ = new ArrayList(this.method_);
         this.bitField0_ |= 2;
      }

   }

   public List getMethodList() {
      return this.methodBuilder_ == null?Collections.unmodifiableList(this.method_):this.methodBuilder_.getMessageList();
   }

   public int getMethodCount() {
      return this.methodBuilder_ == null?this.method_.size():this.methodBuilder_.getCount();
   }

   public DescriptorProtos$MethodDescriptorProto getMethod(int var1) {
      return this.methodBuilder_ == null?(DescriptorProtos$MethodDescriptorProto)this.method_.get(var1):(DescriptorProtos$MethodDescriptorProto)this.methodBuilder_.getMessage(var1);
   }

   public DescriptorProtos$ServiceDescriptorProto$Builder setMethod(int var1, DescriptorProtos$MethodDescriptorProto var2) {
      if(this.methodBuilder_ == null) {
         if(var2 == null) {
            throw new NullPointerException();
         }

         this.ensureMethodIsMutable();
         this.method_.set(var1, var2);
         this.onChanged();
      } else {
         this.methodBuilder_.setMessage(var1, var2);
      }

      return this;
   }

   public DescriptorProtos$ServiceDescriptorProto$Builder setMethod(int var1, DescriptorProtos$MethodDescriptorProto$Builder var2) {
      if(this.methodBuilder_ == null) {
         this.ensureMethodIsMutable();
         this.method_.set(var1, var2.build());
         this.onChanged();
      } else {
         this.methodBuilder_.setMessage(var1, var2.build());
      }

      return this;
   }

   public DescriptorProtos$ServiceDescriptorProto$Builder addMethod(DescriptorProtos$MethodDescriptorProto var1) {
      if(this.methodBuilder_ == null) {
         if(var1 == null) {
            throw new NullPointerException();
         }

         this.ensureMethodIsMutable();
         this.method_.add(var1);
         this.onChanged();
      } else {
         this.methodBuilder_.addMessage(var1);
      }

      return this;
   }

   public DescriptorProtos$ServiceDescriptorProto$Builder addMethod(int var1, DescriptorProtos$MethodDescriptorProto var2) {
      if(this.methodBuilder_ == null) {
         if(var2 == null) {
            throw new NullPointerException();
         }

         this.ensureMethodIsMutable();
         this.method_.add(var1, var2);
         this.onChanged();
      } else {
         this.methodBuilder_.addMessage(var1, var2);
      }

      return this;
   }

   public DescriptorProtos$ServiceDescriptorProto$Builder addMethod(DescriptorProtos$MethodDescriptorProto$Builder var1) {
      if(this.methodBuilder_ == null) {
         this.ensureMethodIsMutable();
         this.method_.add(var1.build());
         this.onChanged();
      } else {
         this.methodBuilder_.addMessage(var1.build());
      }

      return this;
   }

   public DescriptorProtos$ServiceDescriptorProto$Builder addMethod(int var1, DescriptorProtos$MethodDescriptorProto$Builder var2) {
      if(this.methodBuilder_ == null) {
         this.ensureMethodIsMutable();
         this.method_.add(var1, var2.build());
         this.onChanged();
      } else {
         this.methodBuilder_.addMessage(var1, var2.build());
      }

      return this;
   }

   public DescriptorProtos$ServiceDescriptorProto$Builder addAllMethod(Iterable var1) {
      if(this.methodBuilder_ == null) {
         this.ensureMethodIsMutable();
         AbstractMessageLite$Builder.addAll(var1, this.method_);
         this.onChanged();
      } else {
         this.methodBuilder_.addAllMessages(var1);
      }

      return this;
   }

   public DescriptorProtos$ServiceDescriptorProto$Builder clearMethod() {
      if(this.methodBuilder_ == null) {
         this.method_ = Collections.emptyList();
         this.bitField0_ &= -3;
         this.onChanged();
      } else {
         this.methodBuilder_.clear();
      }

      return this;
   }

   public DescriptorProtos$ServiceDescriptorProto$Builder removeMethod(int var1) {
      if(this.methodBuilder_ == null) {
         this.ensureMethodIsMutable();
         this.method_.remove(var1);
         this.onChanged();
      } else {
         this.methodBuilder_.remove(var1);
      }

      return this;
   }

   public DescriptorProtos$MethodDescriptorProto$Builder getMethodBuilder(int var1) {
      return (DescriptorProtos$MethodDescriptorProto$Builder)this.getMethodFieldBuilder().getBuilder(var1);
   }

   public DescriptorProtos$MethodDescriptorProtoOrBuilder getMethodOrBuilder(int var1) {
      return this.methodBuilder_ == null?(DescriptorProtos$MethodDescriptorProtoOrBuilder)this.method_.get(var1):(DescriptorProtos$MethodDescriptorProtoOrBuilder)this.methodBuilder_.getMessageOrBuilder(var1);
   }

   public List getMethodOrBuilderList() {
      return this.methodBuilder_ != null?this.methodBuilder_.getMessageOrBuilderList():Collections.unmodifiableList(this.method_);
   }

   public DescriptorProtos$MethodDescriptorProto$Builder addMethodBuilder() {
      return (DescriptorProtos$MethodDescriptorProto$Builder)this.getMethodFieldBuilder().addBuilder(DescriptorProtos$MethodDescriptorProto.getDefaultInstance());
   }

   public DescriptorProtos$MethodDescriptorProto$Builder addMethodBuilder(int var1) {
      return (DescriptorProtos$MethodDescriptorProto$Builder)this.getMethodFieldBuilder().addBuilder(var1, DescriptorProtos$MethodDescriptorProto.getDefaultInstance());
   }

   public List getMethodBuilderList() {
      return this.getMethodFieldBuilder().getBuilderList();
   }

   private RepeatedFieldBuilder getMethodFieldBuilder() {
      if(this.methodBuilder_ == null) {
         this.methodBuilder_ = new RepeatedFieldBuilder(this.method_, (this.bitField0_ & 2) == 2, this.getParentForChildren(), this.isClean());
         this.method_ = null;
      }

      return this.methodBuilder_;
   }

   public boolean hasOptions() {
      return (this.bitField0_ & 4) == 4;
   }

   public DescriptorProtos$ServiceOptions getOptions() {
      return this.optionsBuilder_ == null?(this.options_ == null?DescriptorProtos$ServiceOptions.getDefaultInstance():this.options_):(DescriptorProtos$ServiceOptions)this.optionsBuilder_.getMessage();
   }

   public DescriptorProtos$ServiceDescriptorProto$Builder setOptions(DescriptorProtos$ServiceOptions var1) {
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

   public DescriptorProtos$ServiceDescriptorProto$Builder setOptions(DescriptorProtos$ServiceOptions$Builder var1) {
      if(this.optionsBuilder_ == null) {
         this.options_ = var1.build();
         this.onChanged();
      } else {
         this.optionsBuilder_.setMessage(var1.build());
      }

      this.bitField0_ |= 4;
      return this;
   }

   public DescriptorProtos$ServiceDescriptorProto$Builder mergeOptions(DescriptorProtos$ServiceOptions var1) {
      if(this.optionsBuilder_ == null) {
         if((this.bitField0_ & 4) == 4 && this.options_ != null && this.options_ != DescriptorProtos$ServiceOptions.getDefaultInstance()) {
            this.options_ = DescriptorProtos$ServiceOptions.newBuilder(this.options_).mergeFrom(var1).buildPartial();
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

   public DescriptorProtos$ServiceDescriptorProto$Builder clearOptions() {
      if(this.optionsBuilder_ == null) {
         this.options_ = null;
         this.onChanged();
      } else {
         this.optionsBuilder_.clear();
      }

      this.bitField0_ &= -5;
      return this;
   }

   public DescriptorProtos$ServiceOptions$Builder getOptionsBuilder() {
      this.bitField0_ |= 4;
      this.onChanged();
      return (DescriptorProtos$ServiceOptions$Builder)this.getOptionsFieldBuilder().getBuilder();
   }

   public DescriptorProtos$ServiceOptionsOrBuilder getOptionsOrBuilder() {
      return (DescriptorProtos$ServiceOptionsOrBuilder)(this.optionsBuilder_ != null?(DescriptorProtos$ServiceOptionsOrBuilder)this.optionsBuilder_.getMessageOrBuilder():(this.options_ == null?DescriptorProtos$ServiceOptions.getDefaultInstance():this.options_));
   }

   private SingleFieldBuilder getOptionsFieldBuilder() {
      if(this.optionsBuilder_ == null) {
         this.optionsBuilder_ = new SingleFieldBuilder(this.getOptions(), this.getParentForChildren(), this.isClean());
         this.options_ = null;
      }

      return this.optionsBuilder_;
   }

   // $FF: synthetic method
   DescriptorProtos$ServiceDescriptorProto$Builder(DescriptorProtos$1 var1) {
      this();
   }

   // $FF: synthetic method
   DescriptorProtos$ServiceDescriptorProto$Builder(GeneratedMessage$BuilderParent var1, DescriptorProtos$1 var2) {
      this(var1);
   }
}
