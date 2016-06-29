package com.google.protos.BinExport;

import com.google.protobuf.CodedInputStream;
import com.google.protobuf.Descriptors$Descriptor;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessage$Builder;
import com.google.protobuf.GeneratedMessage$BuilderParent;
import com.google.protobuf.GeneratedMessage$FieldAccessorTable;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.Message;
import com.google.protos.BinExport.BinExport;
import com.google.protos.BinExport.BinExport$1;
import com.google.protos.BinExport.BinExport$Callgraph$Edge;
import com.google.protos.BinExport.BinExport$Callgraph$EdgeOrBuilder;

public final class BinExport$Callgraph$Edge$Builder extends GeneratedMessage$Builder implements BinExport$Callgraph$EdgeOrBuilder {
   private int bitField0_;
   private long sourceFunctionAddress_;
   private long sourceInstructionAddress_;
   private long targetAddress_;

   public static final Descriptors$Descriptor getDescriptor() {
      return BinExport.access$3500();
   }

   protected GeneratedMessage$FieldAccessorTable internalGetFieldAccessorTable() {
      return BinExport.access$3600().ensureFieldAccessorsInitialized(BinExport$Callgraph$Edge.class, BinExport$Callgraph$Edge$Builder.class);
   }

   private BinExport$Callgraph$Edge$Builder() {
      this.maybeForceBuilderInitialization();
   }

   private BinExport$Callgraph$Edge$Builder(GeneratedMessage$BuilderParent var1) {
      super(var1);
      this.maybeForceBuilderInitialization();
   }

   private void maybeForceBuilderInitialization() {
      if(BinExport$Callgraph$Edge.access$3900()) {
         ;
      }

   }

   public BinExport$Callgraph$Edge$Builder clear() {
      super.clear();
      this.sourceFunctionAddress_ = 0L;
      this.bitField0_ &= -2;
      this.sourceInstructionAddress_ = 0L;
      this.bitField0_ &= -3;
      this.targetAddress_ = 0L;
      this.bitField0_ &= -5;
      return this;
   }

   public Descriptors$Descriptor getDescriptorForType() {
      return BinExport.access$3500();
   }

   public BinExport$Callgraph$Edge getDefaultInstanceForType() {
      return BinExport$Callgraph$Edge.getDefaultInstance();
   }

   public BinExport$Callgraph$Edge build() {
      BinExport$Callgraph$Edge var1 = this.buildPartial();
      if(!var1.isInitialized()) {
         throw newUninitializedMessageException(var1);
      } else {
         return var1;
      }
   }

   public BinExport$Callgraph$Edge buildPartial() {
      BinExport$Callgraph$Edge var1 = new BinExport$Callgraph$Edge(this, (BinExport$1)null);
      int var2 = this.bitField0_;
      int var3 = 0;
      if((var2 & 1) == 1) {
         var3 |= 1;
      }

      BinExport$Callgraph$Edge.access$4102(var1, this.sourceFunctionAddress_);
      if((var2 & 2) == 2) {
         var3 |= 2;
      }

      BinExport$Callgraph$Edge.access$4202(var1, this.sourceInstructionAddress_);
      if((var2 & 4) == 4) {
         var3 |= 4;
      }

      BinExport$Callgraph$Edge.access$4302(var1, this.targetAddress_);
      BinExport$Callgraph$Edge.access$4402(var1, var3);
      this.onBuilt();
      return var1;
   }

   public BinExport$Callgraph$Edge$Builder mergeFrom(Message var1) {
      if(var1 instanceof BinExport$Callgraph$Edge) {
         return this.mergeFrom((BinExport$Callgraph$Edge)var1);
      } else {
         super.mergeFrom(var1);
         return this;
      }
   }

   public BinExport$Callgraph$Edge$Builder mergeFrom(BinExport$Callgraph$Edge var1) {
      if(var1 == BinExport$Callgraph$Edge.getDefaultInstance()) {
         return this;
      } else {
         if(var1.hasSourceFunctionAddress()) {
            this.setSourceFunctionAddress(var1.getSourceFunctionAddress());
         }

         if(var1.hasSourceInstructionAddress()) {
            this.setSourceInstructionAddress(var1.getSourceInstructionAddress());
         }

         if(var1.hasTargetAddress()) {
            this.setTargetAddress(var1.getTargetAddress());
         }

         this.mergeUnknownFields(BinExport$Callgraph$Edge.access$4500(var1));
         this.onChanged();
         return this;
      }
   }

   public final boolean isInitialized() {
      return !this.hasSourceFunctionAddress()?false:(!this.hasSourceInstructionAddress()?false:this.hasTargetAddress());
   }

   public BinExport$Callgraph$Edge$Builder mergeFrom(CodedInputStream var1, ExtensionRegistryLite var2) {
      BinExport$Callgraph$Edge var3 = null;

      try {
         var3 = (BinExport$Callgraph$Edge)BinExport$Callgraph$Edge.PARSER.parsePartialFrom(var1, var2);
      } catch (InvalidProtocolBufferException var8) {
         var3 = (BinExport$Callgraph$Edge)var8.getUnfinishedMessage();
         throw var8;
      } finally {
         if(var3 != null) {
            this.mergeFrom(var3);
         }

      }

      return this;
   }

   public boolean hasSourceFunctionAddress() {
      return (this.bitField0_ & 1) == 1;
   }

   public long getSourceFunctionAddress() {
      return this.sourceFunctionAddress_;
   }

   public BinExport$Callgraph$Edge$Builder setSourceFunctionAddress(long var1) {
      this.bitField0_ |= 1;
      this.sourceFunctionAddress_ = var1;
      this.onChanged();
      return this;
   }

   public BinExport$Callgraph$Edge$Builder clearSourceFunctionAddress() {
      this.bitField0_ &= -2;
      this.sourceFunctionAddress_ = 0L;
      this.onChanged();
      return this;
   }

   public boolean hasSourceInstructionAddress() {
      return (this.bitField0_ & 2) == 2;
   }

   public long getSourceInstructionAddress() {
      return this.sourceInstructionAddress_;
   }

   public BinExport$Callgraph$Edge$Builder setSourceInstructionAddress(long var1) {
      this.bitField0_ |= 2;
      this.sourceInstructionAddress_ = var1;
      this.onChanged();
      return this;
   }

   public BinExport$Callgraph$Edge$Builder clearSourceInstructionAddress() {
      this.bitField0_ &= -3;
      this.sourceInstructionAddress_ = 0L;
      this.onChanged();
      return this;
   }

   public boolean hasTargetAddress() {
      return (this.bitField0_ & 4) == 4;
   }

   public long getTargetAddress() {
      return this.targetAddress_;
   }

   public BinExport$Callgraph$Edge$Builder setTargetAddress(long var1) {
      this.bitField0_ |= 4;
      this.targetAddress_ = var1;
      this.onChanged();
      return this;
   }

   public BinExport$Callgraph$Edge$Builder clearTargetAddress() {
      this.bitField0_ &= -5;
      this.targetAddress_ = 0L;
      this.onChanged();
      return this;
   }

   // $FF: synthetic method
   BinExport$Callgraph$Edge$Builder(BinExport$1 var1) {
      this();
   }

   // $FF: synthetic method
   BinExport$Callgraph$Edge$Builder(GeneratedMessage$BuilderParent var1, BinExport$1 var2) {
      this(var1);
   }
}
