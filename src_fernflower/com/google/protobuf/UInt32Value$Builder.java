package com.google.protobuf;

import com.google.protobuf.CodedInputStream;
import com.google.protobuf.Descriptors$Descriptor;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessage;
import com.google.protobuf.GeneratedMessage$Builder;
import com.google.protobuf.GeneratedMessage$BuilderParent;
import com.google.protobuf.GeneratedMessage$FieldAccessorTable;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.Message;
import com.google.protobuf.UInt32Value;
import com.google.protobuf.UInt32Value$1;
import com.google.protobuf.UInt32ValueOrBuilder;
import com.google.protobuf.UnknownFieldSet;
import com.google.protobuf.WrappersProto;

public final class UInt32Value$Builder extends GeneratedMessage$Builder implements UInt32ValueOrBuilder {
   private int value_;

   public static final Descriptors$Descriptor getDescriptor() {
      return WrappersProto.internal_static_google_protobuf_UInt32Value_descriptor;
   }

   protected GeneratedMessage$FieldAccessorTable internalGetFieldAccessorTable() {
      return WrappersProto.internal_static_google_protobuf_UInt32Value_fieldAccessorTable.ensureFieldAccessorsInitialized(UInt32Value.class, UInt32Value$Builder.class);
   }

   private UInt32Value$Builder() {
      this.maybeForceBuilderInitialization();
   }

   private UInt32Value$Builder(GeneratedMessage$BuilderParent var1) {
      super(var1);
      this.maybeForceBuilderInitialization();
   }

   private void maybeForceBuilderInitialization() {
      if(GeneratedMessage.alwaysUseFieldBuilders) {
         ;
      }

   }

   public UInt32Value$Builder clear() {
      super.clear();
      this.value_ = 0;
      return this;
   }

   public Descriptors$Descriptor getDescriptorForType() {
      return WrappersProto.internal_static_google_protobuf_UInt32Value_descriptor;
   }

   public UInt32Value getDefaultInstanceForType() {
      return UInt32Value.getDefaultInstance();
   }

   public UInt32Value build() {
      UInt32Value var1 = this.buildPartial();
      if(!var1.isInitialized()) {
         throw newUninitializedMessageException(var1);
      } else {
         return var1;
      }
   }

   public UInt32Value buildPartial() {
      UInt32Value var1 = new UInt32Value(this, (UInt32Value$1)null);
      UInt32Value.access$302(var1, this.value_);
      this.onBuilt();
      return var1;
   }

   public UInt32Value$Builder mergeFrom(Message var1) {
      if(var1 instanceof UInt32Value) {
         return this.mergeFrom((UInt32Value)var1);
      } else {
         super.mergeFrom(var1);
         return this;
      }
   }

   public UInt32Value$Builder mergeFrom(UInt32Value var1) {
      if(var1 == UInt32Value.getDefaultInstance()) {
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

   public UInt32Value$Builder mergeFrom(CodedInputStream var1, ExtensionRegistryLite var2) {
      UInt32Value var3 = null;

      try {
         var3 = (UInt32Value)UInt32Value.PARSER.parsePartialFrom(var1, var2);
      } catch (InvalidProtocolBufferException var9) {
         var3 = (UInt32Value)var9.getUnfinishedMessage();
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

   public UInt32Value$Builder setValue(int var1) {
      this.value_ = var1;
      this.onChanged();
      return this;
   }

   public UInt32Value$Builder clearValue() {
      this.value_ = 0;
      this.onChanged();
      return this;
   }

   public final UInt32Value$Builder setUnknownFields(UnknownFieldSet var1) {
      return this;
   }

   public final UInt32Value$Builder mergeUnknownFields(UnknownFieldSet var1) {
      return this;
   }

   // $FF: synthetic method
   UInt32Value$Builder(UInt32Value$1 var1) {
      this();
   }

   // $FF: synthetic method
   UInt32Value$Builder(GeneratedMessage$BuilderParent var1, UInt32Value$1 var2) {
      this(var1);
   }
}
