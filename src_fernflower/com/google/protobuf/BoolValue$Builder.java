package com.google.protobuf;

import com.google.protobuf.BoolValue;
import com.google.protobuf.BoolValue$1;
import com.google.protobuf.BoolValueOrBuilder;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.Descriptors$Descriptor;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessage;
import com.google.protobuf.GeneratedMessage$Builder;
import com.google.protobuf.GeneratedMessage$BuilderParent;
import com.google.protobuf.GeneratedMessage$FieldAccessorTable;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.Message;
import com.google.protobuf.UnknownFieldSet;
import com.google.protobuf.WrappersProto;

public final class BoolValue$Builder extends GeneratedMessage$Builder implements BoolValueOrBuilder {
   private boolean value_;

   public static final Descriptors$Descriptor getDescriptor() {
      return WrappersProto.internal_static_google_protobuf_BoolValue_descriptor;
   }

   protected GeneratedMessage$FieldAccessorTable internalGetFieldAccessorTable() {
      return WrappersProto.internal_static_google_protobuf_BoolValue_fieldAccessorTable.ensureFieldAccessorsInitialized(BoolValue.class, BoolValue$Builder.class);
   }

   private BoolValue$Builder() {
      this.maybeForceBuilderInitialization();
   }

   private BoolValue$Builder(GeneratedMessage$BuilderParent var1) {
      super(var1);
      this.maybeForceBuilderInitialization();
   }

   private void maybeForceBuilderInitialization() {
      if(GeneratedMessage.alwaysUseFieldBuilders) {
         ;
      }

   }

   public BoolValue$Builder clear() {
      super.clear();
      this.value_ = false;
      return this;
   }

   public Descriptors$Descriptor getDescriptorForType() {
      return WrappersProto.internal_static_google_protobuf_BoolValue_descriptor;
   }

   public BoolValue getDefaultInstanceForType() {
      return BoolValue.getDefaultInstance();
   }

   public BoolValue build() {
      BoolValue var1 = this.buildPartial();
      if(!var1.isInitialized()) {
         throw newUninitializedMessageException(var1);
      } else {
         return var1;
      }
   }

   public BoolValue buildPartial() {
      BoolValue var1 = new BoolValue(this, (BoolValue$1)null);
      BoolValue.access$302(var1, this.value_);
      this.onBuilt();
      return var1;
   }

   public BoolValue$Builder mergeFrom(Message var1) {
      if(var1 instanceof BoolValue) {
         return this.mergeFrom((BoolValue)var1);
      } else {
         super.mergeFrom(var1);
         return this;
      }
   }

   public BoolValue$Builder mergeFrom(BoolValue var1) {
      if(var1 == BoolValue.getDefaultInstance()) {
         return this;
      } else {
         if(var1.getValue()) {
            this.setValue(var1.getValue());
         }

         this.onChanged();
         return this;
      }
   }

   public final boolean isInitialized() {
      return true;
   }

   public BoolValue$Builder mergeFrom(CodedInputStream var1, ExtensionRegistryLite var2) {
      BoolValue var3 = null;

      try {
         var3 = (BoolValue)BoolValue.PARSER.parsePartialFrom(var1, var2);
      } catch (InvalidProtocolBufferException var9) {
         var3 = (BoolValue)var9.getUnfinishedMessage();
         throw var9;
      } finally {
         if(var3 != null) {
            this.mergeFrom(var3);
         }

      }

      return this;
   }

   public boolean getValue() {
      return this.value_;
   }

   public BoolValue$Builder setValue(boolean var1) {
      this.value_ = var1;
      this.onChanged();
      return this;
   }

   public BoolValue$Builder clearValue() {
      this.value_ = false;
      this.onChanged();
      return this;
   }

   public final BoolValue$Builder setUnknownFields(UnknownFieldSet var1) {
      return this;
   }

   public final BoolValue$Builder mergeUnknownFields(UnknownFieldSet var1) {
      return this;
   }

   // $FF: synthetic method
   BoolValue$Builder(BoolValue$1 var1) {
      this();
   }

   // $FF: synthetic method
   BoolValue$Builder(GeneratedMessage$BuilderParent var1, BoolValue$1 var2) {
      this(var1);
   }
}
