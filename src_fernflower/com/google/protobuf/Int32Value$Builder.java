package com.google.protobuf;

import com.google.protobuf.CodedInputStream;
import com.google.protobuf.Descriptors$Descriptor;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessage;
import com.google.protobuf.GeneratedMessage$Builder;
import com.google.protobuf.GeneratedMessage$BuilderParent;
import com.google.protobuf.GeneratedMessage$FieldAccessorTable;
import com.google.protobuf.Int32Value;
import com.google.protobuf.Int32Value$1;
import com.google.protobuf.Int32ValueOrBuilder;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.Message;
import com.google.protobuf.UnknownFieldSet;
import com.google.protobuf.WrappersProto;

public final class Int32Value$Builder extends GeneratedMessage$Builder implements Int32ValueOrBuilder {
   private int value_;

   public static final Descriptors$Descriptor getDescriptor() {
      return WrappersProto.internal_static_google_protobuf_Int32Value_descriptor;
   }

   protected GeneratedMessage$FieldAccessorTable internalGetFieldAccessorTable() {
      return WrappersProto.internal_static_google_protobuf_Int32Value_fieldAccessorTable.ensureFieldAccessorsInitialized(Int32Value.class, Int32Value$Builder.class);
   }

   private Int32Value$Builder() {
      this.maybeForceBuilderInitialization();
   }

   private Int32Value$Builder(GeneratedMessage$BuilderParent var1) {
      super(var1);
      this.maybeForceBuilderInitialization();
   }

   private void maybeForceBuilderInitialization() {
      if(GeneratedMessage.alwaysUseFieldBuilders) {
         ;
      }

   }

   public Int32Value$Builder clear() {
      super.clear();
      this.value_ = 0;
      return this;
   }

   public Descriptors$Descriptor getDescriptorForType() {
      return WrappersProto.internal_static_google_protobuf_Int32Value_descriptor;
   }

   public Int32Value getDefaultInstanceForType() {
      return Int32Value.getDefaultInstance();
   }

   public Int32Value build() {
      Int32Value var1 = this.buildPartial();
      if(!var1.isInitialized()) {
         throw newUninitializedMessageException(var1);
      } else {
         return var1;
      }
   }

   public Int32Value buildPartial() {
      Int32Value var1 = new Int32Value(this, (Int32Value$1)null);
      Int32Value.access$302(var1, this.value_);
      this.onBuilt();
      return var1;
   }

   public Int32Value$Builder mergeFrom(Message var1) {
      if(var1 instanceof Int32Value) {
         return this.mergeFrom((Int32Value)var1);
      } else {
         super.mergeFrom(var1);
         return this;
      }
   }

   public Int32Value$Builder mergeFrom(Int32Value var1) {
      if(var1 == Int32Value.getDefaultInstance()) {
         return this;
      } else {
         if(var1.getValue() != 0) {
            this.setValue(var1.getValue());
         }

         this.onChanged();
         return this;
      }
   }

   public final boolean isInitialized() {
      return true;
   }

   public Int32Value$Builder mergeFrom(CodedInputStream var1, ExtensionRegistryLite var2) {
      Int32Value var3 = null;

      try {
         var3 = (Int32Value)Int32Value.PARSER.parsePartialFrom(var1, var2);
      } catch (InvalidProtocolBufferException var9) {
         var3 = (Int32Value)var9.getUnfinishedMessage();
         throw var9;
      } finally {
         if(var3 != null) {
            this.mergeFrom(var3);
         }

      }

      return this;
   }

   public int getValue() {
      return this.value_;
   }

   public Int32Value$Builder setValue(int var1) {
      this.value_ = var1;
      this.onChanged();
      return this;
   }

   public Int32Value$Builder clearValue() {
      this.value_ = 0;
      this.onChanged();
      return this;
   }

   public final Int32Value$Builder setUnknownFields(UnknownFieldSet var1) {
      return this;
   }

   public final Int32Value$Builder mergeUnknownFields(UnknownFieldSet var1) {
      return this;
   }

   // $FF: synthetic method
   Int32Value$Builder(Int32Value$1 var1) {
      this();
   }

   // $FF: synthetic method
   Int32Value$Builder(GeneratedMessage$BuilderParent var1, Int32Value$1 var2) {
      this(var1);
   }
}
