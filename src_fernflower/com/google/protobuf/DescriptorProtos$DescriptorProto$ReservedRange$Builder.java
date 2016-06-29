package com.google.protobuf;

import com.google.protobuf.CodedInputStream;
import com.google.protobuf.DescriptorProtos;
import com.google.protobuf.DescriptorProtos$1;
import com.google.protobuf.DescriptorProtos$DescriptorProto$ReservedRange;
import com.google.protobuf.DescriptorProtos$DescriptorProto$ReservedRangeOrBuilder;
import com.google.protobuf.Descriptors$Descriptor;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessage;
import com.google.protobuf.GeneratedMessage$Builder;
import com.google.protobuf.GeneratedMessage$BuilderParent;
import com.google.protobuf.GeneratedMessage$FieldAccessorTable;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.Message;

public final class DescriptorProtos$DescriptorProto$ReservedRange$Builder extends GeneratedMessage$Builder implements DescriptorProtos$DescriptorProto$ReservedRangeOrBuilder {
   private int bitField0_;
   private int start_;
   private int end_;

   public static final Descriptors$Descriptor getDescriptor() {
      return DescriptorProtos.access$3700();
   }

   protected GeneratedMessage$FieldAccessorTable internalGetFieldAccessorTable() {
      return DescriptorProtos.access$3800().ensureFieldAccessorsInitialized(DescriptorProtos$DescriptorProto$ReservedRange.class, DescriptorProtos$DescriptorProto$ReservedRange$Builder.class);
   }

   private DescriptorProtos$DescriptorProto$ReservedRange$Builder() {
      this.maybeForceBuilderInitialization();
   }

   private DescriptorProtos$DescriptorProto$ReservedRange$Builder(GeneratedMessage$BuilderParent var1) {
      super(var1);
      this.maybeForceBuilderInitialization();
   }

   private void maybeForceBuilderInitialization() {
      if(GeneratedMessage.alwaysUseFieldBuilders) {
         ;
      }

   }

   public DescriptorProtos$DescriptorProto$ReservedRange$Builder clear() {
      super.clear();
      this.start_ = 0;
      this.bitField0_ &= -2;
      this.end_ = 0;
      this.bitField0_ &= -3;
      return this;
   }

   public Descriptors$Descriptor getDescriptorForType() {
      return DescriptorProtos.access$3700();
   }

   public DescriptorProtos$DescriptorProto$ReservedRange getDefaultInstanceForType() {
      return DescriptorProtos$DescriptorProto$ReservedRange.getDefaultInstance();
   }

   public DescriptorProtos$DescriptorProto$ReservedRange build() {
      DescriptorProtos$DescriptorProto$ReservedRange var1 = this.buildPartial();
      if(!var1.isInitialized()) {
         throw newUninitializedMessageException(var1);
      } else {
         return var1;
      }
   }

   public DescriptorProtos$DescriptorProto$ReservedRange buildPartial() {
      DescriptorProtos$DescriptorProto$ReservedRange var1 = new DescriptorProtos$DescriptorProto$ReservedRange(this, (DescriptorProtos$1)null);
      int var2 = this.bitField0_;
      int var3 = 0;
      if((var2 & 1) == 1) {
         var3 |= 1;
      }

      DescriptorProtos$DescriptorProto$ReservedRange.access$4202(var1, this.start_);
      if((var2 & 2) == 2) {
         var3 |= 2;
      }

      DescriptorProtos$DescriptorProto$ReservedRange.access$4302(var1, this.end_);
      DescriptorProtos$DescriptorProto$ReservedRange.access$4402(var1, var3);
      this.onBuilt();
      return var1;
   }

   public DescriptorProtos$DescriptorProto$ReservedRange$Builder mergeFrom(Message var1) {
      if(var1 instanceof DescriptorProtos$DescriptorProto$ReservedRange) {
         return this.mergeFrom((DescriptorProtos$DescriptorProto$ReservedRange)var1);
      } else {
         super.mergeFrom(var1);
         return this;
      }
   }

   public DescriptorProtos$DescriptorProto$ReservedRange$Builder mergeFrom(DescriptorProtos$DescriptorProto$ReservedRange var1) {
      if(var1 == DescriptorProtos$DescriptorProto$ReservedRange.getDefaultInstance()) {
         return this;
      } else {
         if(var1.hasStart()) {
            this.setStart(var1.getStart());
         }

         if(var1.hasEnd()) {
            this.setEnd(var1.getEnd());
         }

         this.mergeUnknownFields(var1.unknownFields);
         this.onChanged();
         return this;
      }
   }

   public final boolean isInitialized() {
      return true;
   }

   public DescriptorProtos$DescriptorProto$ReservedRange$Builder mergeFrom(CodedInputStream var1, ExtensionRegistryLite var2) {
      DescriptorProtos$DescriptorProto$ReservedRange var3 = null;

      try {
         var3 = (DescriptorProtos$DescriptorProto$ReservedRange)DescriptorProtos$DescriptorProto$ReservedRange.PARSER.parsePartialFrom(var1, var2);
      } catch (InvalidProtocolBufferException var9) {
         var3 = (DescriptorProtos$DescriptorProto$ReservedRange)var9.getUnfinishedMessage();
         throw var9;
      } finally {
         if(var3 != null) {
            this.mergeFrom(var3);
         }

      }

      return this;
   }

   public boolean hasStart() {
      return (this.bitField0_ & 1) == 1;
   }

   public int getStart() {
      return this.start_;
   }

   public DescriptorProtos$DescriptorProto$ReservedRange$Builder setStart(int var1) {
      this.bitField0_ |= 1;
      this.start_ = var1;
      this.onChanged();
      return this;
   }

   public DescriptorProtos$DescriptorProto$ReservedRange$Builder clearStart() {
      this.bitField0_ &= -2;
      this.start_ = 0;
      this.onChanged();
      return this;
   }

   public boolean hasEnd() {
      return (this.bitField0_ & 2) == 2;
   }

   public int getEnd() {
      return this.end_;
   }

   public DescriptorProtos$DescriptorProto$ReservedRange$Builder setEnd(int var1) {
      this.bitField0_ |= 2;
      this.end_ = var1;
      this.onChanged();
      return this;
   }

   public DescriptorProtos$DescriptorProto$ReservedRange$Builder clearEnd() {
      this.bitField0_ &= -3;
      this.end_ = 0;
      this.onChanged();
      return this;
   }

   // $FF: synthetic method
   DescriptorProtos$DescriptorProto$ReservedRange$Builder(DescriptorProtos$1 var1) {
      this();
   }

   // $FF: synthetic method
   DescriptorProtos$DescriptorProto$ReservedRange$Builder(GeneratedMessage$BuilderParent var1, DescriptorProtos$1 var2) {
      this(var1);
   }
}
