package com.google.protobuf;

import com.google.protobuf.CodedInputStream;
import com.google.protobuf.Descriptors$Descriptor;
import com.google.protobuf.DoubleValue;
import com.google.protobuf.DoubleValue$1;
import com.google.protobuf.DoubleValueOrBuilder;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessage;
import com.google.protobuf.GeneratedMessage$Builder;
import com.google.protobuf.GeneratedMessage$BuilderParent;
import com.google.protobuf.GeneratedMessage$FieldAccessorTable;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.Message;
import com.google.protobuf.UnknownFieldSet;
import com.google.protobuf.WrappersProto;

public final class DoubleValue$Builder extends GeneratedMessage$Builder implements DoubleValueOrBuilder {
   private double value_;

   public static final Descriptors$Descriptor getDescriptor() {
      return WrappersProto.internal_static_google_protobuf_DoubleValue_descriptor;
   }

   protected GeneratedMessage$FieldAccessorTable internalGetFieldAccessorTable() {
      return WrappersProto.internal_static_google_protobuf_DoubleValue_fieldAccessorTable.ensureFieldAccessorsInitialized(DoubleValue.class, DoubleValue$Builder.class);
   }

   private DoubleValue$Builder() {
      this.maybeForceBuilderInitialization();
   }

   private DoubleValue$Builder(GeneratedMessage$BuilderParent var1) {
      super(var1);
      this.maybeForceBuilderInitialization();
   }

   private void maybeForceBuilderInitialization() {
      if(GeneratedMessage.alwaysUseFieldBuilders) {
         ;
      }

   }

   public DoubleValue$Builder clear() {
      super.clear();
      this.value_ = 0.0D;
      return this;
   }

   public Descriptors$Descriptor getDescriptorForType() {
      return WrappersProto.internal_static_google_protobuf_DoubleValue_descriptor;
   }

   public DoubleValue getDefaultInstanceForType() {
      return DoubleValue.getDefaultInstance();
   }

   public DoubleValue build() {
      DoubleValue var1 = this.buildPartial();
      if(!var1.isInitialized()) {
         throw newUninitializedMessageException(var1);
      } else {
         return var1;
      }
   }

   public DoubleValue buildPartial() {
      DoubleValue var1 = new DoubleValue(this, (DoubleValue$1)null);
      DoubleValue.access$302(var1, this.value_);
      this.onBuilt();
      return var1;
   }

   public DoubleValue$Builder mergeFrom(Message var1) {
      if(var1 instanceof DoubleValue) {
         return this.mergeFrom((DoubleValue)var1);
      } else {
         super.mergeFrom(var1);
         return this;
      }
   }

   public DoubleValue$Builder mergeFrom(DoubleValue var1) {
      if(var1 == DoubleValue.getDefaultInstance()) {
         return this;
      } else {
         if(var1.getValue() != 0.0D) {
            this.setValue(var1.getValue());
         }

         this.onChanged();
         return this;
      }
   }

   public final boolean isInitialized() {
      return true;
   }

   public DoubleValue$Builder mergeFrom(CodedInputStream var1, ExtensionRegistryLite var2) {
      DoubleValue var3 = null;

      try {
         var3 = (DoubleValue)DoubleValue.PARSER.parsePartialFrom(var1, var2);
      } catch (InvalidProtocolBufferException var9) {
         var3 = (DoubleValue)var9.getUnfinishedMessage();
         throw var9;
      } finally {
         if(var3 != null) {
            this.mergeFrom(var3);
         }

      }

      return this;
   }

   public double getValue() {
      return this.value_;
   }

   public DoubleValue$Builder setValue(double var1) {
      this.value_ = var1;
      this.onChanged();
      return this;
   }

   public DoubleValue$Builder clearValue() {
      this.value_ = 0.0D;
      this.onChanged();
      return this;
   }

   public final DoubleValue$Builder setUnknownFields(UnknownFieldSet var1) {
      return this;
   }

   public final DoubleValue$Builder mergeUnknownFields(UnknownFieldSet var1) {
      return this;
   }

   // $FF: synthetic method
   DoubleValue$Builder(DoubleValue$1 var1) {
      this();
   }

   // $FF: synthetic method
   DoubleValue$Builder(GeneratedMessage$BuilderParent var1, DoubleValue$1 var2) {
      this(var1);
   }
}
