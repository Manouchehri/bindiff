package com.google.protobuf;

import com.google.protobuf.CodedInputStream;
import com.google.protobuf.Descriptors$Descriptor;
import com.google.protobuf.Empty;
import com.google.protobuf.Empty$1;
import com.google.protobuf.EmptyOrBuilder;
import com.google.protobuf.EmptyProto;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessage;
import com.google.protobuf.GeneratedMessage$Builder;
import com.google.protobuf.GeneratedMessage$BuilderParent;
import com.google.protobuf.GeneratedMessage$FieldAccessorTable;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.Message;
import com.google.protobuf.UnknownFieldSet;

public final class Empty$Builder extends GeneratedMessage$Builder implements EmptyOrBuilder {
   public static final Descriptors$Descriptor getDescriptor() {
      return EmptyProto.internal_static_google_protobuf_Empty_descriptor;
   }

   protected GeneratedMessage$FieldAccessorTable internalGetFieldAccessorTable() {
      return EmptyProto.internal_static_google_protobuf_Empty_fieldAccessorTable.ensureFieldAccessorsInitialized(Empty.class, Empty$Builder.class);
   }

   private Empty$Builder() {
      this.maybeForceBuilderInitialization();
   }

   private Empty$Builder(GeneratedMessage$BuilderParent var1) {
      super(var1);
      this.maybeForceBuilderInitialization();
   }

   private void maybeForceBuilderInitialization() {
      if(GeneratedMessage.alwaysUseFieldBuilders) {
         ;
      }

   }

   public Empty$Builder clear() {
      super.clear();
      return this;
   }

   public Descriptors$Descriptor getDescriptorForType() {
      return EmptyProto.internal_static_google_protobuf_Empty_descriptor;
   }

   public Empty getDefaultInstanceForType() {
      return Empty.getDefaultInstance();
   }

   public Empty build() {
      Empty var1 = this.buildPartial();
      if(!var1.isInitialized()) {
         throw newUninitializedMessageException(var1);
      } else {
         return var1;
      }
   }

   public Empty buildPartial() {
      Empty var1 = new Empty(this, (Empty$1)null);
      this.onBuilt();
      return var1;
   }

   public Empty$Builder mergeFrom(Message var1) {
      if(var1 instanceof Empty) {
         return this.mergeFrom((Empty)var1);
      } else {
         super.mergeFrom(var1);
         return this;
      }
   }

   public Empty$Builder mergeFrom(Empty var1) {
      if(var1 == Empty.getDefaultInstance()) {
         return this;
      } else {
         this.onChanged();
         return this;
      }
   }

   public final boolean isInitialized() {
      return true;
   }

   public Empty$Builder mergeFrom(CodedInputStream var1, ExtensionRegistryLite var2) {
      Empty var3 = null;

      try {
         var3 = (Empty)Empty.PARSER.parsePartialFrom(var1, var2);
      } catch (InvalidProtocolBufferException var9) {
         var3 = (Empty)var9.getUnfinishedMessage();
         throw var9;
      } finally {
         if(var3 != null) {
            this.mergeFrom(var3);
         }

      }

      return this;
   }

   public final Empty$Builder setUnknownFields(UnknownFieldSet var1) {
      return this;
   }

   public final Empty$Builder mergeUnknownFields(UnknownFieldSet var1) {
      return this;
   }

   // $FF: synthetic method
   Empty$Builder(Empty$1 var1) {
      this();
   }

   // $FF: synthetic method
   Empty$Builder(GeneratedMessage$BuilderParent var1, Empty$1 var2) {
      this(var1);
   }
}
