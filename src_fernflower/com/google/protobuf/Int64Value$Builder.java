package com.google.protobuf;

import com.google.protobuf.CodedInputStream;
import com.google.protobuf.Descriptors$Descriptor;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessage;
import com.google.protobuf.GeneratedMessage$Builder;
import com.google.protobuf.GeneratedMessage$BuilderParent;
import com.google.protobuf.GeneratedMessage$FieldAccessorTable;
import com.google.protobuf.Int64Value;
import com.google.protobuf.Int64Value$1;
import com.google.protobuf.Int64ValueOrBuilder;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.Message;
import com.google.protobuf.UnknownFieldSet;
import com.google.protobuf.WrappersProto;

public final class Int64Value$Builder extends GeneratedMessage$Builder implements Int64ValueOrBuilder {
   private long value_;

   public static final Descriptors$Descriptor getDescriptor() {
      return WrappersProto.internal_static_google_protobuf_Int64Value_descriptor;
   }

   protected GeneratedMessage$FieldAccessorTable internalGetFieldAccessorTable() {
      return WrappersProto.internal_static_google_protobuf_Int64Value_fieldAccessorTable.ensureFieldAccessorsInitialized(Int64Value.class, Int64Value$Builder.class);
   }

   private Int64Value$Builder() {
      this.maybeForceBuilderInitialization();
   }

   private Int64Value$Builder(GeneratedMessage$BuilderParent var1) {
      super(var1);
      this.maybeForceBuilderInitialization();
   }

   private void maybeForceBuilderInitialization() {
      if(GeneratedMessage.alwaysUseFieldBuilders) {
         ;
      }

   }

   public Int64Value$Builder clear() {
      super.clear();
      this.value_ = 0L;
      return this;
   }

   public Descriptors$Descriptor getDescriptorForType() {
      return WrappersProto.internal_static_google_protobuf_Int64Value_descriptor;
   }

   public Int64Value getDefaultInstanceForType() {
      return Int64Value.getDefaultInstance();
   }

   public Int64Value build() {
      Int64Value var1 = this.buildPartial();
      if(!var1.isInitialized()) {
         throw newUninitializedMessageException(var1);
      } else {
         return var1;
      }
   }

   public Int64Value buildPartial() {
      Int64Value var1 = new Int64Value(this, (Int64Value$1)null);
      Int64Value.access$302(var1, this.value_);
      this.onBuilt();
      return var1;
   }

   public Int64Value$Builder mergeFrom(Message var1) {
      if(var1 instanceof Int64Value) {
         return this.mergeFrom((Int64Value)var1);
      } else {
         super.mergeFrom(var1);
         return this;
      }
   }

   public Int64Value$Builder mergeFrom(Int64Value var1) {
      if(var1 == Int64Value.getDefaultInstance()) {
         return this;
      } else {
         if(var1.getValue() != 0L) {
            this.setValue(var1.getValue());
         }

         this.onChanged();
         return this;
      }
   }

   public final boolean isInitialized() {
      return true;
   }

   public Int64Value$Builder mergeFrom(CodedInputStream var1, ExtensionRegistryLite var2) {
      Int64Value var3 = null;

      try {
         var3 = (Int64Value)Int64Value.PARSER.parsePartialFrom(var1, var2);
      } catch (InvalidProtocolBufferException var9) {
         var3 = (Int64Value)var9.getUnfinishedMessage();
         throw var9;
      } finally {
         if(var3 != null) {
            this.mergeFrom(var3);
         }

      }

      return this;
   }

   public long getValue() {
      return this.value_;
   }

   public Int64Value$Builder setValue(long var1) {
      this.value_ = var1;
      this.onChanged();
      return this;
   }

   public Int64Value$Builder clearValue() {
      this.value_ = 0L;
      this.onChanged();
      return this;
   }

   public final Int64Value$Builder setUnknownFields(UnknownFieldSet var1) {
      return this;
   }

   public final Int64Value$Builder mergeUnknownFields(UnknownFieldSet var1) {
      return this;
   }

   // $FF: synthetic method
   Int64Value$Builder(Int64Value$1 var1) {
      this();
   }

   // $FF: synthetic method
   Int64Value$Builder(GeneratedMessage$BuilderParent var1, Int64Value$1 var2) {
      this(var1);
   }
}
