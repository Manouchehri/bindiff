package com.google.protobuf;

import com.google.protobuf.CodedInputStream;
import com.google.protobuf.Descriptors$Descriptor;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.FloatValue;
import com.google.protobuf.FloatValue$1;
import com.google.protobuf.FloatValueOrBuilder;
import com.google.protobuf.GeneratedMessage;
import com.google.protobuf.GeneratedMessage$Builder;
import com.google.protobuf.GeneratedMessage$BuilderParent;
import com.google.protobuf.GeneratedMessage$FieldAccessorTable;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.Message;
import com.google.protobuf.UnknownFieldSet;
import com.google.protobuf.WrappersProto;

public final class FloatValue$Builder extends GeneratedMessage$Builder implements FloatValueOrBuilder {
   private float value_;

   public static final Descriptors$Descriptor getDescriptor() {
      return WrappersProto.internal_static_google_protobuf_FloatValue_descriptor;
   }

   protected GeneratedMessage$FieldAccessorTable internalGetFieldAccessorTable() {
      return WrappersProto.internal_static_google_protobuf_FloatValue_fieldAccessorTable.ensureFieldAccessorsInitialized(FloatValue.class, FloatValue$Builder.class);
   }

   private FloatValue$Builder() {
      this.maybeForceBuilderInitialization();
   }

   private FloatValue$Builder(GeneratedMessage$BuilderParent var1) {
      super(var1);
      this.maybeForceBuilderInitialization();
   }

   private void maybeForceBuilderInitialization() {
      if(GeneratedMessage.alwaysUseFieldBuilders) {
         ;
      }

   }

   public FloatValue$Builder clear() {
      super.clear();
      this.value_ = 0.0F;
      return this;
   }

   public Descriptors$Descriptor getDescriptorForType() {
      return WrappersProto.internal_static_google_protobuf_FloatValue_descriptor;
   }

   public FloatValue getDefaultInstanceForType() {
      return FloatValue.getDefaultInstance();
   }

   public FloatValue build() {
      FloatValue var1 = this.buildPartial();
      if(!var1.isInitialized()) {
         throw newUninitializedMessageException(var1);
      } else {
         return var1;
      }
   }

   public FloatValue buildPartial() {
      FloatValue var1 = new FloatValue(this, (FloatValue$1)null);
      FloatValue.access$302(var1, this.value_);
      this.onBuilt();
      return var1;
   }

   public FloatValue$Builder mergeFrom(Message var1) {
      if(var1 instanceof FloatValue) {
         return this.mergeFrom((FloatValue)var1);
      } else {
         super.mergeFrom(var1);
         return this;
      }
   }

   public FloatValue$Builder mergeFrom(FloatValue var1) {
      if(var1 == FloatValue.getDefaultInstance()) {
         return this;
      } else {
         if(var1.getValue() != 0.0F) {
            this.setValue(var1.getValue());
         }

         this.onChanged();
         return this;
      }
   }

   public final boolean isInitialized() {
      return true;
   }

   public FloatValue$Builder mergeFrom(CodedInputStream var1, ExtensionRegistryLite var2) {
      FloatValue var3 = null;

      try {
         var3 = (FloatValue)FloatValue.PARSER.parsePartialFrom(var1, var2);
      } catch (InvalidProtocolBufferException var9) {
         var3 = (FloatValue)var9.getUnfinishedMessage();
         throw var9;
      } finally {
         if(var3 != null) {
            this.mergeFrom(var3);
         }

      }

      return this;
   }

   public float getValue() {
      return this.value_;
   }

   public FloatValue$Builder setValue(float var1) {
      this.value_ = var1;
      this.onChanged();
      return this;
   }

   public FloatValue$Builder clearValue() {
      this.value_ = 0.0F;
      this.onChanged();
      return this;
   }

   public final FloatValue$Builder setUnknownFields(UnknownFieldSet var1) {
      return this;
   }

   public final FloatValue$Builder mergeUnknownFields(UnknownFieldSet var1) {
      return this;
   }

   // $FF: synthetic method
   FloatValue$Builder(FloatValue$1 var1) {
      this();
   }

   // $FF: synthetic method
   FloatValue$Builder(GeneratedMessage$BuilderParent var1, FloatValue$1 var2) {
      this(var1);
   }
}
