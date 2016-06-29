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
import com.google.protos.BinExport.BinExport$Flowgraph$Edge;
import com.google.protos.BinExport.BinExport$Flowgraph$Edge$EdgeType;
import com.google.protos.BinExport.BinExport$Flowgraph$EdgeOrBuilder;

public final class BinExport$Flowgraph$Edge$Builder extends GeneratedMessage$Builder implements BinExport$Flowgraph$EdgeOrBuilder {
   private int bitField0_;
   private long sourceAddress_;
   private long targetAddress_;
   private int type_;

   public static final Descriptors$Descriptor getDescriptor() {
      return BinExport.access$10000();
   }

   protected GeneratedMessage$FieldAccessorTable internalGetFieldAccessorTable() {
      return BinExport.access$10100().ensureFieldAccessorsInitialized(BinExport$Flowgraph$Edge.class, BinExport$Flowgraph$Edge$Builder.class);
   }

   private BinExport$Flowgraph$Edge$Builder() {
      this.type_ = 3;
      this.maybeForceBuilderInitialization();
   }

   private BinExport$Flowgraph$Edge$Builder(GeneratedMessage$BuilderParent var1) {
      super(var1);
      this.type_ = 3;
      this.maybeForceBuilderInitialization();
   }

   private void maybeForceBuilderInitialization() {
      if(BinExport$Flowgraph$Edge.access$10400()) {
         ;
      }

   }

   public BinExport$Flowgraph$Edge$Builder clear() {
      super.clear();
      this.sourceAddress_ = 0L;
      this.bitField0_ &= -2;
      this.targetAddress_ = 0L;
      this.bitField0_ &= -3;
      this.type_ = 3;
      this.bitField0_ &= -5;
      return this;
   }

   public Descriptors$Descriptor getDescriptorForType() {
      return BinExport.access$10000();
   }

   public BinExport$Flowgraph$Edge getDefaultInstanceForType() {
      return BinExport$Flowgraph$Edge.getDefaultInstance();
   }

   public BinExport$Flowgraph$Edge build() {
      BinExport$Flowgraph$Edge var1 = this.buildPartial();
      if(!var1.isInitialized()) {
         throw newUninitializedMessageException(var1);
      } else {
         return var1;
      }
   }

   public BinExport$Flowgraph$Edge buildPartial() {
      BinExport$Flowgraph$Edge var1 = new BinExport$Flowgraph$Edge(this, (BinExport$1)null);
      int var2 = this.bitField0_;
      int var3 = 0;
      if((var2 & 1) == 1) {
         var3 |= 1;
      }

      BinExport$Flowgraph$Edge.access$10602(var1, this.sourceAddress_);
      if((var2 & 2) == 2) {
         var3 |= 2;
      }

      BinExport$Flowgraph$Edge.access$10702(var1, this.targetAddress_);
      if((var2 & 4) == 4) {
         var3 |= 4;
      }

      BinExport$Flowgraph$Edge.access$10802(var1, this.type_);
      BinExport$Flowgraph$Edge.access$10902(var1, var3);
      this.onBuilt();
      return var1;
   }

   public BinExport$Flowgraph$Edge$Builder mergeFrom(Message var1) {
      if(var1 instanceof BinExport$Flowgraph$Edge) {
         return this.mergeFrom((BinExport$Flowgraph$Edge)var1);
      } else {
         super.mergeFrom(var1);
         return this;
      }
   }

   public BinExport$Flowgraph$Edge$Builder mergeFrom(BinExport$Flowgraph$Edge var1) {
      if(var1 == BinExport$Flowgraph$Edge.getDefaultInstance()) {
         return this;
      } else {
         if(var1.hasSourceAddress()) {
            this.setSourceAddress(var1.getSourceAddress());
         }

         if(var1.hasTargetAddress()) {
            this.setTargetAddress(var1.getTargetAddress());
         }

         if(var1.hasType()) {
            this.setType(var1.getType());
         }

         this.mergeUnknownFields(BinExport$Flowgraph$Edge.access$11000(var1));
         this.onChanged();
         return this;
      }
   }

   public final boolean isInitialized() {
      return !this.hasSourceAddress()?false:this.hasTargetAddress();
   }

   public BinExport$Flowgraph$Edge$Builder mergeFrom(CodedInputStream var1, ExtensionRegistryLite var2) {
      BinExport$Flowgraph$Edge var3 = null;

      try {
         var3 = (BinExport$Flowgraph$Edge)BinExport$Flowgraph$Edge.PARSER.parsePartialFrom(var1, var2);
      } catch (InvalidProtocolBufferException var8) {
         var3 = (BinExport$Flowgraph$Edge)var8.getUnfinishedMessage();
         throw var8;
      } finally {
         if(var3 != null) {
            this.mergeFrom(var3);
         }

      }

      return this;
   }

   public boolean hasSourceAddress() {
      return (this.bitField0_ & 1) == 1;
   }

   public long getSourceAddress() {
      return this.sourceAddress_;
   }

   public BinExport$Flowgraph$Edge$Builder setSourceAddress(long var1) {
      this.bitField0_ |= 1;
      this.sourceAddress_ = var1;
      this.onChanged();
      return this;
   }

   public BinExport$Flowgraph$Edge$Builder clearSourceAddress() {
      this.bitField0_ &= -2;
      this.sourceAddress_ = 0L;
      this.onChanged();
      return this;
   }

   public boolean hasTargetAddress() {
      return (this.bitField0_ & 2) == 2;
   }

   public long getTargetAddress() {
      return this.targetAddress_;
   }

   public BinExport$Flowgraph$Edge$Builder setTargetAddress(long var1) {
      this.bitField0_ |= 2;
      this.targetAddress_ = var1;
      this.onChanged();
      return this;
   }

   public BinExport$Flowgraph$Edge$Builder clearTargetAddress() {
      this.bitField0_ &= -3;
      this.targetAddress_ = 0L;
      this.onChanged();
      return this;
   }

   public boolean hasType() {
      return (this.bitField0_ & 4) == 4;
   }

   public BinExport$Flowgraph$Edge$EdgeType getType() {
      BinExport$Flowgraph$Edge$EdgeType var1 = BinExport$Flowgraph$Edge$EdgeType.valueOf(this.type_);
      return var1 == null?BinExport$Flowgraph$Edge$EdgeType.UNCONDITIONAL:var1;
   }

   public BinExport$Flowgraph$Edge$Builder setType(BinExport$Flowgraph$Edge$EdgeType var1) {
      if(var1 == null) {
         throw new NullPointerException();
      } else {
         this.bitField0_ |= 4;
         this.type_ = var1.getNumber();
         this.onChanged();
         return this;
      }
   }

   public BinExport$Flowgraph$Edge$Builder clearType() {
      this.bitField0_ &= -5;
      this.type_ = 3;
      this.onChanged();
      return this;
   }

   // $FF: synthetic method
   BinExport$Flowgraph$Edge$Builder(BinExport$1 var1) {
      this();
   }

   // $FF: synthetic method
   BinExport$Flowgraph$Edge$Builder(GeneratedMessage$BuilderParent var1, BinExport$1 var2) {
      this(var1);
   }
}
