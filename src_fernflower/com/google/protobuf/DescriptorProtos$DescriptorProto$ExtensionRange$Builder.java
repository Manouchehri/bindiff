package com.google.protobuf;

import com.google.protobuf.CodedInputStream;
import com.google.protobuf.DescriptorProtos;
import com.google.protobuf.DescriptorProtos$1;
import com.google.protobuf.DescriptorProtos$DescriptorProto$ExtensionRange;
import com.google.protobuf.DescriptorProtos$DescriptorProto$ExtensionRangeOrBuilder;
import com.google.protobuf.Descriptors$Descriptor;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessage;
import com.google.protobuf.GeneratedMessage$Builder;
import com.google.protobuf.GeneratedMessage$BuilderParent;
import com.google.protobuf.GeneratedMessage$FieldAccessorTable;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.Message;

public final class DescriptorProtos$DescriptorProto$ExtensionRange$Builder extends GeneratedMessage$Builder implements DescriptorProtos$DescriptorProto$ExtensionRangeOrBuilder {
   private int bitField0_;
   private int start_;
   private int end_;

   public static final Descriptors$Descriptor getDescriptor() {
      return DescriptorProtos.access$2800();
   }

   protected GeneratedMessage$FieldAccessorTable internalGetFieldAccessorTable() {
      return DescriptorProtos.access$2900().ensureFieldAccessorsInitialized(DescriptorProtos$DescriptorProto$ExtensionRange.class, DescriptorProtos$DescriptorProto$ExtensionRange$Builder.class);
   }

   private DescriptorProtos$DescriptorProto$ExtensionRange$Builder() {
      this.maybeForceBuilderInitialization();
   }

   private DescriptorProtos$DescriptorProto$ExtensionRange$Builder(GeneratedMessage$BuilderParent var1) {
      super(var1);
      this.maybeForceBuilderInitialization();
   }

   private void maybeForceBuilderInitialization() {
      if(GeneratedMessage.alwaysUseFieldBuilders) {
         ;
      }

   }

   public DescriptorProtos$DescriptorProto$ExtensionRange$Builder clear() {
      super.clear();
      this.start_ = 0;
      this.bitField0_ &= -2;
      this.end_ = 0;
      this.bitField0_ &= -3;
      return this;
   }

   public Descriptors$Descriptor getDescriptorForType() {
      return DescriptorProtos.access$2800();
   }

   public DescriptorProtos$DescriptorProto$ExtensionRange getDefaultInstanceForType() {
      return DescriptorProtos$DescriptorProto$ExtensionRange.getDefaultInstance();
   }

   public DescriptorProtos$DescriptorProto$ExtensionRange build() {
      DescriptorProtos$DescriptorProto$ExtensionRange var1 = this.buildPartial();
      if(!var1.isInitialized()) {
         throw newUninitializedMessageException(var1);
      } else {
         return var1;
      }
   }

   public DescriptorProtos$DescriptorProto$ExtensionRange buildPartial() {
      DescriptorProtos$DescriptorProto$ExtensionRange var1 = new DescriptorProtos$DescriptorProto$ExtensionRange(this, (DescriptorProtos$1)null);
      int var2 = this.bitField0_;
      int var3 = 0;
      if((var2 & 1) == 1) {
         var3 |= 1;
      }

      DescriptorProtos$DescriptorProto$ExtensionRange.access$3302(var1, this.start_);
      if((var2 & 2) == 2) {
         var3 |= 2;
      }

      DescriptorProtos$DescriptorProto$ExtensionRange.access$3402(var1, this.end_);
      DescriptorProtos$DescriptorProto$ExtensionRange.access$3502(var1, var3);
      this.onBuilt();
      return var1;
   }

   public DescriptorProtos$DescriptorProto$ExtensionRange$Builder mergeFrom(Message var1) {
      if(var1 instanceof DescriptorProtos$DescriptorProto$ExtensionRange) {
         return this.mergeFrom((DescriptorProtos$DescriptorProto$ExtensionRange)var1);
      } else {
         super.mergeFrom(var1);
         return this;
      }
   }

   public DescriptorProtos$DescriptorProto$ExtensionRange$Builder mergeFrom(DescriptorProtos$DescriptorProto$ExtensionRange var1) {
      if(var1 == DescriptorProtos$DescriptorProto$ExtensionRange.getDefaultInstance()) {
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

   public DescriptorProtos$DescriptorProto$ExtensionRange$Builder mergeFrom(CodedInputStream var1, ExtensionRegistryLite var2) {
      DescriptorProtos$DescriptorProto$ExtensionRange var3 = null;

      try {
         var3 = (DescriptorProtos$DescriptorProto$ExtensionRange)DescriptorProtos$DescriptorProto$ExtensionRange.PARSER.parsePartialFrom(var1, var2);
      } catch (InvalidProtocolBufferException var9) {
         var3 = (DescriptorProtos$DescriptorProto$ExtensionRange)var9.getUnfinishedMessage();
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

   public DescriptorProtos$DescriptorProto$ExtensionRange$Builder setStart(int var1) {
      this.bitField0_ |= 1;
      this.start_ = var1;
      this.onChanged();
      return this;
   }

   public DescriptorProtos$DescriptorProto$ExtensionRange$Builder clearStart() {
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

   public DescriptorProtos$DescriptorProto$ExtensionRange$Builder setEnd(int var1) {
      this.bitField0_ |= 2;
      this.end_ = var1;
      this.onChanged();
      return this;
   }

   public DescriptorProtos$DescriptorProto$ExtensionRange$Builder clearEnd() {
      this.bitField0_ &= -3;
      this.end_ = 0;
      this.onChanged();
      return this;
   }

   // $FF: synthetic method
   DescriptorProtos$DescriptorProto$ExtensionRange$Builder(DescriptorProtos$1 var1) {
      this();
   }

   // $FF: synthetic method
   DescriptorProtos$DescriptorProto$ExtensionRange$Builder(GeneratedMessage$BuilderParent var1, DescriptorProtos$1 var2) {
      this(var1);
   }
}
