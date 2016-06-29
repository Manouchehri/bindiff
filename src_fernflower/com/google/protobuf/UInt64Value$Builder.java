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
import com.google.protobuf.UInt64Value;
import com.google.protobuf.UInt64Value$1;
import com.google.protobuf.UInt64ValueOrBuilder;
import com.google.protobuf.UnknownFieldSet;
import com.google.protobuf.WrappersProto;

public final class UInt64Value$Builder extends GeneratedMessage$Builder implements UInt64ValueOrBuilder {
   private long value_;

   public static final Descriptors$Descriptor getDescriptor() {
      return WrappersProto.internal_static_google_protobuf_UInt64Value_descriptor;
   }

   protected GeneratedMessage$FieldAccessorTable internalGetFieldAccessorTable() {
      return WrappersProto.internal_static_google_protobuf_UInt64Value_fieldAccessorTable.ensureFieldAccessorsInitialized(UInt64Value.class, UInt64Value$Builder.class);
   }

   private UInt64Value$Builder() {
      this.maybeForceBuilderInitialization();
   }

   private UInt64Value$Builder(GeneratedMessage$BuilderParent var1) {
      super(var1);
      this.maybeForceBuilderInitialization();
   }

   private void maybeForceBuilderInitialization() {
      if(GeneratedMessage.alwaysUseFieldBuilders) {
         ;
      }

   }

   public UInt64Value$Builder clear() {
      super.clear();
      this.value_ = 0L;
      return this;
   }

   public Descriptors$Descriptor getDescriptorForType() {
      return WrappersProto.internal_static_google_protobuf_UInt64Value_descriptor;
   }

   public UInt64Value getDefaultInstanceForType() {
      return UInt64Value.getDefaultInstance();
   }

   public UInt64Value build() {
      UInt64Value var1 = this.buildPartial();
      if(!var1.isInitialized()) {
         throw newUninitializedMessageException(var1);
      } else {
         return var1;
      }
   }

   public UInt64Value buildPartial() {
      UInt64Value var1 = new UInt64Value(this, (UInt64Value$1)null);
      UInt64Value.access$302(var1, this.value_);
      this.onBuilt();
      return var1;
   }

   public UInt64Value$Builder mergeFrom(Message var1) {
      if(var1 instanceof UInt64Value) {
         return this.mergeFrom((UInt64Value)var1);
      } else {
         super.mergeFrom(var1);
         return this;
      }
   }

   public UInt64Value$Builder mergeFrom(UInt64Value var1) {
      if(var1 == UInt64Value.getDefaultInstance()) {
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

   public UInt64Value$Builder mergeFrom(CodedInputStream var1, ExtensionRegistryLite var2) {
      UInt64Value var3 = null;

      try {
         var3 = (UInt64Value)UInt64Value.PARSER.parsePartialFrom(var1, var2);
      } catch (InvalidProtocolBufferException var9) {
         var3 = (UInt64Value)var9.getUnfinishedMessage();
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

   public UInt64Value$Builder setValue(long var1) {
      this.value_ = var1;
      this.onChanged();
      return this;
   }

   public UInt64Value$Builder clearValue() {
      this.value_ = 0L;
      this.onChanged();
      return this;
   }

   public final UInt64Value$Builder setUnknownFields(UnknownFieldSet var1) {
      return this;
   }

   public final UInt64Value$Builder mergeUnknownFields(UnknownFieldSet var1) {
      return this;
   }

   // $FF: synthetic method
   UInt64Value$Builder(UInt64Value$1 var1) {
      this();
   }

   // $FF: synthetic method
   UInt64Value$Builder(GeneratedMessage$BuilderParent var1, UInt64Value$1 var2) {
      this(var1);
   }
}
