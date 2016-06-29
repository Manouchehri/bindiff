package com.google.protobuf;

import com.google.protobuf.CodedInputStream;
import com.google.protobuf.Descriptors$Descriptor;
import com.google.protobuf.Duration;
import com.google.protobuf.Duration$1;
import com.google.protobuf.DurationOrBuilder;
import com.google.protobuf.DurationProto;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessage;
import com.google.protobuf.GeneratedMessage$Builder;
import com.google.protobuf.GeneratedMessage$BuilderParent;
import com.google.protobuf.GeneratedMessage$FieldAccessorTable;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.Message;
import com.google.protobuf.UnknownFieldSet;

public final class Duration$Builder extends GeneratedMessage$Builder implements DurationOrBuilder {
   private long seconds_;
   private int nanos_;

   public static final Descriptors$Descriptor getDescriptor() {
      return DurationProto.internal_static_google_protobuf_Duration_descriptor;
   }

   protected GeneratedMessage$FieldAccessorTable internalGetFieldAccessorTable() {
      return DurationProto.internal_static_google_protobuf_Duration_fieldAccessorTable.ensureFieldAccessorsInitialized(Duration.class, Duration$Builder.class);
   }

   private Duration$Builder() {
      this.maybeForceBuilderInitialization();
   }

   private Duration$Builder(GeneratedMessage$BuilderParent var1) {
      super(var1);
      this.maybeForceBuilderInitialization();
   }

   private void maybeForceBuilderInitialization() {
      if(GeneratedMessage.alwaysUseFieldBuilders) {
         ;
      }

   }

   public Duration$Builder clear() {
      super.clear();
      this.seconds_ = 0L;
      this.nanos_ = 0;
      return this;
   }

   public Descriptors$Descriptor getDescriptorForType() {
      return DurationProto.internal_static_google_protobuf_Duration_descriptor;
   }

   public Duration getDefaultInstanceForType() {
      return Duration.getDefaultInstance();
   }

   public Duration build() {
      Duration var1 = this.buildPartial();
      if(!var1.isInitialized()) {
         throw newUninitializedMessageException(var1);
      } else {
         return var1;
      }
   }

   public Duration buildPartial() {
      Duration var1 = new Duration(this, (Duration$1)null);
      Duration.access$302(var1, this.seconds_);
      Duration.access$402(var1, this.nanos_);
      this.onBuilt();
      return var1;
   }

   public Duration$Builder mergeFrom(Message var1) {
      if(var1 instanceof Duration) {
         return this.mergeFrom((Duration)var1);
      } else {
         super.mergeFrom(var1);
         return this;
      }
   }

   public Duration$Builder mergeFrom(Duration var1) {
      if(var1 == Duration.getDefaultInstance()) {
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

   public Duration$Builder mergeFrom(CodedInputStream var1, ExtensionRegistryLite var2) {
      Duration var3 = null;

      try {
         var3 = (Duration)Duration.PARSER.parsePartialFrom(var1, var2);
      } catch (InvalidProtocolBufferException var9) {
         var3 = (Duration)var9.getUnfinishedMessage();
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

   public Duration$Builder setSeconds(long var1) {
      this.seconds_ = var1;
      this.onChanged();
      return this;
   }

   public Duration$Builder clearSeconds() {
      this.seconds_ = 0L;
      this.onChanged();
      return this;
   }

   public int getNanos() {
      return this.nanos_;
   }

   public Duration$Builder setNanos(int var1) {
      this.nanos_ = var1;
      this.onChanged();
      return this;
   }

   public Duration$Builder clearNanos() {
      this.nanos_ = 0;
      this.onChanged();
      return this;
   }

   public final Duration$Builder setUnknownFields(UnknownFieldSet var1) {
      return this;
   }

   public final Duration$Builder mergeUnknownFields(UnknownFieldSet var1) {
      return this;
   }

   // $FF: synthetic method
   Duration$Builder(Duration$1 var1) {
      this();
   }

   // $FF: synthetic method
   Duration$Builder(GeneratedMessage$BuilderParent var1, Duration$1 var2) {
      this(var1);
   }
}
