package com.google.protos.BinExport;

import com.google.protobuf.ByteString;
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
import com.google.protos.BinExport.BinExport$Callgraph$Vertex;
import com.google.protos.BinExport.BinExport$Callgraph$Vertex$FunctionType;
import com.google.protos.BinExport.BinExport$Callgraph$VertexOrBuilder;

public final class BinExport$Callgraph$Vertex$Builder extends GeneratedMessage$Builder implements BinExport$Callgraph$VertexOrBuilder {
   private int bitField0_;
   private long address_;
   private long prime_;
   private int functionType_;
   private boolean hasRealName_;
   private Object mangledName_;
   private Object demangledName_;

   public static final Descriptors$Descriptor getDescriptor() {
      return BinExport.access$2000();
   }

   protected GeneratedMessage$FieldAccessorTable internalGetFieldAccessorTable() {
      return BinExport.access$2100().ensureFieldAccessorsInitialized(BinExport$Callgraph$Vertex.class, BinExport$Callgraph$Vertex$Builder.class);
   }

   private BinExport$Callgraph$Vertex$Builder() {
      this.functionType_ = 0;
      this.mangledName_ = "";
      this.demangledName_ = "";
      this.maybeForceBuilderInitialization();
   }

   private BinExport$Callgraph$Vertex$Builder(GeneratedMessage$BuilderParent var1) {
      super(var1);
      this.functionType_ = 0;
      this.mangledName_ = "";
      this.demangledName_ = "";
      this.maybeForceBuilderInitialization();
   }

   private void maybeForceBuilderInitialization() {
      if(BinExport$Callgraph$Vertex.access$2400()) {
         ;
      }

   }

   public BinExport$Callgraph$Vertex$Builder clear() {
      super.clear();
      this.address_ = 0L;
      this.bitField0_ &= -2;
      this.prime_ = 0L;
      this.bitField0_ &= -3;
      this.functionType_ = 0;
      this.bitField0_ &= -5;
      this.hasRealName_ = false;
      this.bitField0_ &= -9;
      this.mangledName_ = "";
      this.bitField0_ &= -17;
      this.demangledName_ = "";
      this.bitField0_ &= -33;
      return this;
   }

   public Descriptors$Descriptor getDescriptorForType() {
      return BinExport.access$2000();
   }

   public BinExport$Callgraph$Vertex getDefaultInstanceForType() {
      return BinExport$Callgraph$Vertex.getDefaultInstance();
   }

   public BinExport$Callgraph$Vertex build() {
      BinExport$Callgraph$Vertex var1 = this.buildPartial();
      if(!var1.isInitialized()) {
         throw newUninitializedMessageException(var1);
      } else {
         return var1;
      }
   }

   public BinExport$Callgraph$Vertex buildPartial() {
      BinExport$Callgraph$Vertex var1 = new BinExport$Callgraph$Vertex(this, (BinExport$1)null);
      int var2 = this.bitField0_;
      int var3 = 0;
      if((var2 & 1) == 1) {
         var3 |= 1;
      }

      BinExport$Callgraph$Vertex.access$2602(var1, this.address_);
      if((var2 & 2) == 2) {
         var3 |= 2;
      }

      BinExport$Callgraph$Vertex.access$2702(var1, this.prime_);
      if((var2 & 4) == 4) {
         var3 |= 4;
      }

      BinExport$Callgraph$Vertex.access$2802(var1, this.functionType_);
      if((var2 & 8) == 8) {
         var3 |= 8;
      }

      BinExport$Callgraph$Vertex.access$2902(var1, this.hasRealName_);
      if((var2 & 16) == 16) {
         var3 |= 16;
      }

      BinExport$Callgraph$Vertex.access$3002(var1, this.mangledName_);
      if((var2 & 32) == 32) {
         var3 |= 32;
      }

      BinExport$Callgraph$Vertex.access$3102(var1, this.demangledName_);
      BinExport$Callgraph$Vertex.access$3202(var1, var3);
      this.onBuilt();
      return var1;
   }

   public BinExport$Callgraph$Vertex$Builder mergeFrom(Message var1) {
      if(var1 instanceof BinExport$Callgraph$Vertex) {
         return this.mergeFrom((BinExport$Callgraph$Vertex)var1);
      } else {
         super.mergeFrom(var1);
         return this;
      }
   }

   public BinExport$Callgraph$Vertex$Builder mergeFrom(BinExport$Callgraph$Vertex var1) {
      if(var1 == BinExport$Callgraph$Vertex.getDefaultInstance()) {
         return this;
      } else {
         if(var1.hasAddress()) {
            this.setAddress(var1.getAddress());
         }

         if(var1.hasPrime()) {
            this.setPrime(var1.getPrime());
         }

         if(var1.hasFunctionType()) {
            this.setFunctionType(var1.getFunctionType());
         }

         if(var1.hasHasRealName()) {
            this.setHasRealName(var1.getHasRealName());
         }

         if(var1.hasMangledName()) {
            this.bitField0_ |= 16;
            this.mangledName_ = BinExport$Callgraph$Vertex.access$3000(var1);
            this.onChanged();
         }

         if(var1.hasDemangledName()) {
            this.bitField0_ |= 32;
            this.demangledName_ = BinExport$Callgraph$Vertex.access$3100(var1);
            this.onChanged();
         }

         this.mergeUnknownFields(BinExport$Callgraph$Vertex.access$3300(var1));
         this.onChanged();
         return this;
      }
   }

   public final boolean isInitialized() {
      return !this.hasAddress()?false:this.hasPrime();
   }

   public BinExport$Callgraph$Vertex$Builder mergeFrom(CodedInputStream var1, ExtensionRegistryLite var2) {
      BinExport$Callgraph$Vertex var3 = null;

      try {
         var3 = (BinExport$Callgraph$Vertex)BinExport$Callgraph$Vertex.PARSER.parsePartialFrom(var1, var2);
      } catch (InvalidProtocolBufferException var8) {
         var3 = (BinExport$Callgraph$Vertex)var8.getUnfinishedMessage();
         throw var8;
      } finally {
         if(var3 != null) {
            this.mergeFrom(var3);
         }

      }

      return this;
   }

   public boolean hasAddress() {
      return (this.bitField0_ & 1) == 1;
   }

   public long getAddress() {
      return this.address_;
   }

   public BinExport$Callgraph$Vertex$Builder setAddress(long var1) {
      this.bitField0_ |= 1;
      this.address_ = var1;
      this.onChanged();
      return this;
   }

   public BinExport$Callgraph$Vertex$Builder clearAddress() {
      this.bitField0_ &= -2;
      this.address_ = 0L;
      this.onChanged();
      return this;
   }

   public boolean hasPrime() {
      return (this.bitField0_ & 2) == 2;
   }

   public long getPrime() {
      return this.prime_;
   }

   public BinExport$Callgraph$Vertex$Builder setPrime(long var1) {
      this.bitField0_ |= 2;
      this.prime_ = var1;
      this.onChanged();
      return this;
   }

   public BinExport$Callgraph$Vertex$Builder clearPrime() {
      this.bitField0_ &= -3;
      this.prime_ = 0L;
      this.onChanged();
      return this;
   }

   public boolean hasFunctionType() {
      return (this.bitField0_ & 4) == 4;
   }

   public BinExport$Callgraph$Vertex$FunctionType getFunctionType() {
      BinExport$Callgraph$Vertex$FunctionType var1 = BinExport$Callgraph$Vertex$FunctionType.valueOf(this.functionType_);
      return var1 == null?BinExport$Callgraph$Vertex$FunctionType.NORMAL:var1;
   }

   public BinExport$Callgraph$Vertex$Builder setFunctionType(BinExport$Callgraph$Vertex$FunctionType var1) {
      if(var1 == null) {
         throw new NullPointerException();
      } else {
         this.bitField0_ |= 4;
         this.functionType_ = var1.getNumber();
         this.onChanged();
         return this;
      }
   }

   public BinExport$Callgraph$Vertex$Builder clearFunctionType() {
      this.bitField0_ &= -5;
      this.functionType_ = 0;
      this.onChanged();
      return this;
   }

   public boolean hasHasRealName() {
      return (this.bitField0_ & 8) == 8;
   }

   public boolean getHasRealName() {
      return this.hasRealName_;
   }

   public BinExport$Callgraph$Vertex$Builder setHasRealName(boolean var1) {
      this.bitField0_ |= 8;
      this.hasRealName_ = var1;
      this.onChanged();
      return this;
   }

   public BinExport$Callgraph$Vertex$Builder clearHasRealName() {
      this.bitField0_ &= -9;
      this.hasRealName_ = false;
      this.onChanged();
      return this;
   }

   public boolean hasMangledName() {
      return (this.bitField0_ & 16) == 16;
   }

   public String getMangledName() {
      Object var1 = this.mangledName_;
      if(!(var1 instanceof String)) {
         ByteString var2 = (ByteString)var1;
         String var3 = var2.toStringUtf8();
         if(var2.isValidUtf8()) {
            this.mangledName_ = var3;
         }

         return var3;
      } else {
         return (String)var1;
      }
   }

   public ByteString getMangledNameBytes() {
      Object var1 = this.mangledName_;
      if(var1 instanceof String) {
         ByteString var2 = ByteString.copyFromUtf8((String)var1);
         this.mangledName_ = var2;
         return var2;
      } else {
         return (ByteString)var1;
      }
   }

   public BinExport$Callgraph$Vertex$Builder setMangledName(String var1) {
      if(var1 == null) {
         throw new NullPointerException();
      } else {
         this.bitField0_ |= 16;
         this.mangledName_ = var1;
         this.onChanged();
         return this;
      }
   }

   public BinExport$Callgraph$Vertex$Builder clearMangledName() {
      this.bitField0_ &= -17;
      this.mangledName_ = BinExport$Callgraph$Vertex.getDefaultInstance().getMangledName();
      this.onChanged();
      return this;
   }

   public BinExport$Callgraph$Vertex$Builder setMangledNameBytes(ByteString var1) {
      if(var1 == null) {
         throw new NullPointerException();
      } else {
         this.bitField0_ |= 16;
         this.mangledName_ = var1;
         this.onChanged();
         return this;
      }
   }

   public boolean hasDemangledName() {
      return (this.bitField0_ & 32) == 32;
   }

   public String getDemangledName() {
      Object var1 = this.demangledName_;
      if(!(var1 instanceof String)) {
         ByteString var2 = (ByteString)var1;
         String var3 = var2.toStringUtf8();
         if(var2.isValidUtf8()) {
            this.demangledName_ = var3;
         }

         return var3;
      } else {
         return (String)var1;
      }
   }

   public ByteString getDemangledNameBytes() {
      Object var1 = this.demangledName_;
      if(var1 instanceof String) {
         ByteString var2 = ByteString.copyFromUtf8((String)var1);
         this.demangledName_ = var2;
         return var2;
      } else {
         return (ByteString)var1;
      }
   }

   public BinExport$Callgraph$Vertex$Builder setDemangledName(String var1) {
      if(var1 == null) {
         throw new NullPointerException();
      } else {
         this.bitField0_ |= 32;
         this.demangledName_ = var1;
         this.onChanged();
         return this;
      }
   }

   public BinExport$Callgraph$Vertex$Builder clearDemangledName() {
      this.bitField0_ &= -33;
      this.demangledName_ = BinExport$Callgraph$Vertex.getDefaultInstance().getDemangledName();
      this.onChanged();
      return this;
   }

   public BinExport$Callgraph$Vertex$Builder setDemangledNameBytes(ByteString var1) {
      if(var1 == null) {
         throw new NullPointerException();
      } else {
         this.bitField0_ |= 32;
         this.demangledName_ = var1;
         this.onChanged();
         return this;
      }
   }

   // $FF: synthetic method
   BinExport$Callgraph$Vertex$Builder(BinExport$1 var1) {
      this();
   }

   // $FF: synthetic method
   BinExport$Callgraph$Vertex$Builder(GeneratedMessage$BuilderParent var1, BinExport$1 var2) {
      this(var1);
   }
}
