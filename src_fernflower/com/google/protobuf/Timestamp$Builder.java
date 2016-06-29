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
import com.google.protobuf.Timestamp;
import com.google.protobuf.Timestamp$1;
import com.google.protobuf.TimestampOrBuilder;
import com.google.protobuf.TimestampProto;
import com.google.protobuf.UnknownFieldSet;

public final class Timestamp$Builder extends GeneratedMessage$Builder implements TimestampOrBuilder {
   private long seconds_;
   private int nanos_;

   public static final Descriptors$Descriptor getDescriptor() {
      return TimestampProto.internal_static_google_protobuf_Timestamp_descriptor;
   }

   protected GeneratedMessage$FieldAccessorTable internalGetFieldAccessorTable() {
      return TimestampProto.internal_static_google_protobuf_Timestamp_fieldAccessorTable.ensureFieldAccessorsInitialized(Timestamp.class, Timestamp$Builder.class);
   }

   private Timestamp$Builder() {
      this.maybeForceBuilderInitialization();
   }

   private Timestamp$Builder(GeneratedMessage$BuilderParent var1) {
      super(var1);
      this.maybeForceBuilderInitialization();
   }

   private void maybeForceBuilderInitialization() {
      if(GeneratedMessage.alwaysUseFieldBuilders) {
         ;
      }

   }

   public Timestamp$Builder clear() {
      super.clear();
      this.seconds_ = 0L;
      this.nanos_ = 0;
      return this;
   }

   public Descriptors$Descriptor getDescriptorForType() {
      return TimestampProto.internal_static_google_protobuf_Timestamp_descriptor;
   }

   public Timestamp getDefaultInstanceForType() {
      return Timestamp.getDefaultInstance();
   }

   public Timestamp build() {
      Timestamp var1 = this.buildPartial();
      if(!var1.isInitialized()) {
         throw newUninitializedMessageException(var1);
      } else {
         return var1;
      }
   }

   public Timestamp buildPartial() {
      Timestamp var1 = new Timestamp(this, (Timestamp$1)null);
      Timestamp.access$302(var1, this.seconds_);
      Timestamp.access$402(var1, this.nanos_);
      this.onBuilt();
      return var1;
   }

   public Timestamp$Builder mergeFrom(Message var1) {
      if(var1 instanceof Timestamp) {
         return this.mergeFrom((Timestamp)var1);
      } else {
         super.mergeFrom(var1);
         return this;
      }
   }

   public Timestamp$Builder mergeFrom(Timestamp var1) {
      if(var1 == Timestamp.getDefaultInstance()) {
         return this;
      } else {
         if(var1.getSeconds() != 0L) {
            this.setSeconds(var1.getSeconds());
         }

         if(var1.getNanos() != 0) {
            this.setNanos(var1.getNanos());
         }

         this.onChanged();
         return this;
      }
   }

   public final boolean isInitialized() {
      return true;
   }

   public Timestamp$Builder mergeFrom(CodedInputStream var1, ExtensionRegistryLite var2) {
      Timestamp var3 = null;

      try {
         var3 = (Timestamp)Timestamp.PARSER.parsePartialFrom(var1, var2);
      } catch (InvalidProtocolBufferException var9) {
         var3 = (Timestamp)var9.getUnfinishedMessage();
         throw var9;
      } finally {
         if(var3 != null) {
            this.mergeFrom(var3);
         }

      }

      return this;
   }

   public long getSeconds() {
      return this.seconds_;
   }

   public Timestamp$Builder setSeconds(long var1) {
      this.seconds_ = var1;
      this.onChanged();
      return this;
   }

   public Timestamp$Builder clearSeconds() {
      this.seconds_ = 0L;
      this.onChanged();
      return this;
   }

   public int getNanos() {
      return this.nanos_;
   }

   public Timestamp$Builder setNanos(int var1) {
      this.nanos_ = var1;
      this.onChanged();
      return this;
   }

   public Timestamp$Builder clearNanos() {
      this.nanos_ = 0;
      this.onChanged();
      return this;
   }

   public final Timestamp$Builder setUnknownFields(UnknownFieldSet var1) {
      return this;
   }

   public final Timestamp$Builder mergeUnknownFields(UnknownFieldSet var1) {
      return this;
   }

   // $FF: synthetic method
   Timestamp$Builder(Timestamp$1 var1) {
      this();
   }

   // $FF: synthetic method
   Timestamp$Builder(GeneratedMessage$BuilderParent var1, Timestamp$1 var2) {
      this(var1);
   }
}
