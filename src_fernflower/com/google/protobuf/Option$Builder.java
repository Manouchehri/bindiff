package com.google.protobuf;

import com.google.protobuf.Any;
import com.google.protobuf.Any$Builder;
import com.google.protobuf.AnyOrBuilder;
import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.Descriptors$Descriptor;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessage;
import com.google.protobuf.GeneratedMessage$Builder;
import com.google.protobuf.GeneratedMessage$BuilderParent;
import com.google.protobuf.GeneratedMessage$FieldAccessorTable;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.Message;
import com.google.protobuf.Option;
import com.google.protobuf.Option$1;
import com.google.protobuf.OptionOrBuilder;
import com.google.protobuf.SingleFieldBuilder;
import com.google.protobuf.TypeProto;
import com.google.protobuf.UnknownFieldSet;

public final class Option$Builder extends GeneratedMessage$Builder implements OptionOrBuilder {
   private Object name_;
   private Any value_;
   private SingleFieldBuilder valueBuilder_;

   public static final Descriptors$Descriptor getDescriptor() {
      return TypeProto.internal_static_google_protobuf_Option_descriptor;
   }

   protected GeneratedMessage$FieldAccessorTable internalGetFieldAccessorTable() {
      return TypeProto.internal_static_google_protobuf_Option_fieldAccessorTable.ensureFieldAccessorsInitialized(Option.class, Option$Builder.class);
   }

   private Option$Builder() {
      this.name_ = "";
      this.value_ = null;
      this.maybeForceBuilderInitialization();
   }

   private Option$Builder(GeneratedMessage$BuilderParent var1) {
      super(var1);
      this.name_ = "";
      this.value_ = null;
      this.maybeForceBuilderInitialization();
   }

   private void maybeForceBuilderInitialization() {
      if(GeneratedMessage.alwaysUseFieldBuilders) {
         ;
      }

   }

   public Option$Builder clear() {
      super.clear();
      this.name_ = "";
      if(this.valueBuilder_ == null) {
         this.value_ = null;
      } else {
         this.value_ = null;
         this.valueBuilder_ = null;
      }

      return this;
   }

   public Descriptors$Descriptor getDescriptorForType() {
      return TypeProto.internal_static_google_protobuf_Option_descriptor;
   }

   public Option getDefaultInstanceForType() {
      return Option.getDefaultInstance();
   }

   public Option build() {
      Option var1 = this.buildPartial();
      if(!var1.isInitialized()) {
         throw newUninitializedMessageException(var1);
      } else {
         return var1;
      }
   }

   public Option buildPartial() {
      Option var1 = new Option(this, (Option$1)null);
      Option.access$302(var1, this.name_);
      if(this.valueBuilder_ == null) {
         Option.access$402(var1, this.value_);
      } else {
         Option.access$402(var1, (Any)this.valueBuilder_.build());
      }

      this.onBuilt();
      return var1;
   }

   public Option$Builder mergeFrom(Message var1) {
      if(var1 instanceof Option) {
         return this.mergeFrom((Option)var1);
      } else {
         super.mergeFrom(var1);
         return this;
      }
   }

   public Option$Builder mergeFrom(Option var1) {
      if(var1 == Option.getDefaultInstance()) {
         return this;
      } else {
         if(!var1.getName().isEmpty()) {
            this.name_ = Option.access$300(var1);
            this.onChanged();
         }

         if(var1.hasValue()) {
            this.mergeValue(var1.getValue());
         }

         this.onChanged();
         return this;
      }
   }

   public final boolean isInitialized() {
      return true;
   }

   public Option$Builder mergeFrom(CodedInputStream var1, ExtensionRegistryLite var2) {
      Option var3 = null;

      try {
         var3 = (Option)Option.PARSER.parsePartialFrom(var1, var2);
      } catch (InvalidProtocolBufferException var9) {
         var3 = (Option)var9.getUnfinishedMessage();
         throw var9;
      } finally {
         if(var3 != null) {
            this.mergeFrom(var3);
         }

      }

      return this;
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

   public Option$Builder setName(String var1) {
      if(var1 == null) {
         throw new NullPointerException();
      } else {
         this.name_ = var1;
         this.onChanged();
         return this;
      }
   }

   public Option$Builder clearName() {
      this.name_ = Option.getDefaultInstance().getName();
      this.onChanged();
      return this;
   }

   public Option$Builder setNameBytes(ByteString var1) {
      if(var1 == null) {
         throw new NullPointerException();
      } else {
         this.name_ = var1;
         this.onChanged();
         return this;
      }
   }

   public boolean hasValue() {
      return this.valueBuilder_ != null || this.value_ != null;
   }

   public Any getValue() {
      return this.valueBuilder_ == null?(this.value_ == null?Any.getDefaultInstance():this.value_):(Any)this.valueBuilder_.getMessage();
   }

   public Option$Builder setValue(Any var1) {
      if(this.valueBuilder_ == null) {
         if(var1 == null) {
            throw new NullPointerException();
         }

         this.value_ = var1;
         this.onChanged();
      } else {
         this.valueBuilder_.setMessage(var1);
      }

      return this;
   }

   public Option$Builder setValue(Any$Builder var1) {
      if(this.valueBuilder_ == null) {
         this.value_ = var1.build();
         this.onChanged();
      } else {
         this.valueBuilder_.setMessage(var1.build());
      }

      return this;
   }

   public Option$Builder mergeValue(Any var1) {
      if(this.valueBuilder_ == null) {
         if(this.value_ != null) {
            this.value_ = Any.newBuilder(this.value_).mergeFrom(var1).buildPartial();
         } else {
            this.value_ = var1;
         }

         this.onChanged();
      } else {
         this.valueBuilder_.mergeFrom(var1);
      }

      return this;
   }

   public Option$Builder clearValue() {
      if(this.valueBuilder_ == null) {
         this.value_ = null;
         this.onChanged();
      } else {
         this.value_ = null;
         this.valueBuilder_ = null;
      }

      return this;
   }

   public Any$Builder getValueBuilder() {
      this.onChanged();
      return (Any$Builder)this.getValueFieldBuilder().getBuilder();
   }

   public AnyOrBuilder getValueOrBuilder() {
      return (AnyOrBuilder)(this.valueBuilder_ != null?(AnyOrBuilder)this.valueBuilder_.getMessageOrBuilder():(this.value_ == null?Any.getDefaultInstance():this.value_));
   }

   private SingleFieldBuilder getValueFieldBuilder() {
      if(this.valueBuilder_ == null) {
         this.valueBuilder_ = new SingleFieldBuilder(this.getValue(), this.getParentForChildren(), this.isClean());
         this.value_ = null;
      }

      return this.valueBuilder_;
   }

   public final Option$Builder setUnknownFields(UnknownFieldSet var1) {
      return this;
   }

   public final Option$Builder mergeUnknownFields(UnknownFieldSet var1) {
      return this;
   }

   // $FF: synthetic method
   Option$Builder(Option$1 var1) {
      this();
   }

   // $FF: synthetic method
   Option$Builder(GeneratedMessage$BuilderParent var1, Option$1 var2) {
      this(var1);
   }
}
