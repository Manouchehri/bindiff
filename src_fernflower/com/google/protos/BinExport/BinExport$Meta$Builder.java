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
import com.google.protos.BinExport.BinExport$Meta;
import com.google.protos.BinExport.BinExport$MetaOrBuilder;

public final class BinExport$Meta$Builder extends GeneratedMessage$Builder implements BinExport$MetaOrBuilder {
   private int bitField0_;
   private Object inputBinary_;
   private ByteString inputHash_;
   private int inputAddressSpace_;
   private Object architectureName_;
   private int maxMnemonicLen_;
   private int numInstructions_;
   private int numFunctions_;
   private int numBasicblocks_;
   private int numEdges_;

   public static final Descriptors$Descriptor getDescriptor() {
      return BinExport.access$000();
   }

   protected GeneratedMessage$FieldAccessorTable internalGetFieldAccessorTable() {
      return BinExport.access$100().ensureFieldAccessorsInitialized(BinExport$Meta.class, BinExport$Meta$Builder.class);
   }

   private BinExport$Meta$Builder() {
      this.inputBinary_ = "";
      this.inputHash_ = ByteString.EMPTY;
      this.architectureName_ = "";
      this.maybeForceBuilderInitialization();
   }

   private BinExport$Meta$Builder(GeneratedMessage$BuilderParent var1) {
      super(var1);
      this.inputBinary_ = "";
      this.inputHash_ = ByteString.EMPTY;
      this.architectureName_ = "";
      this.maybeForceBuilderInitialization();
   }

   private void maybeForceBuilderInitialization() {
      if(BinExport$Meta.access$400()) {
         ;
      }

   }

   public BinExport$Meta$Builder clear() {
      super.clear();
      this.inputBinary_ = "";
      this.bitField0_ &= -2;
      this.inputHash_ = ByteString.EMPTY;
      this.bitField0_ &= -3;
      this.inputAddressSpace_ = 0;
      this.bitField0_ &= -5;
      this.architectureName_ = "";
      this.bitField0_ &= -9;
      this.maxMnemonicLen_ = 0;
      this.bitField0_ &= -17;
      this.numInstructions_ = 0;
      this.bitField0_ &= -33;
      this.numFunctions_ = 0;
      this.bitField0_ &= -65;
      this.numBasicblocks_ = 0;
      this.bitField0_ &= -129;
      this.numEdges_ = 0;
      this.bitField0_ &= -257;
      return this;
   }

   public Descriptors$Descriptor getDescriptorForType() {
      return BinExport.access$000();
   }

   public BinExport$Meta getDefaultInstanceForType() {
      return BinExport$Meta.getDefaultInstance();
   }

   public BinExport$Meta build() {
      BinExport$Meta var1 = this.buildPartial();
      if(!var1.isInitialized()) {
         throw newUninitializedMessageException(var1);
      } else {
         return var1;
      }
   }

   public BinExport$Meta buildPartial() {
      BinExport$Meta var1 = new BinExport$Meta(this, (BinExport$1)null);
      int var2 = this.bitField0_;
      int var3 = 0;
      if((var2 & 1) == 1) {
         var3 |= 1;
      }

      BinExport$Meta.access$602(var1, this.inputBinary_);
      if((var2 & 2) == 2) {
         var3 |= 2;
      }

      BinExport$Meta.access$702(var1, this.inputHash_);
      if((var2 & 4) == 4) {
         var3 |= 4;
      }

      BinExport$Meta.access$802(var1, this.inputAddressSpace_);
      if((var2 & 8) == 8) {
         var3 |= 8;
      }

      BinExport$Meta.access$902(var1, this.architectureName_);
      if((var2 & 16) == 16) {
         var3 |= 16;
      }

      BinExport$Meta.access$1002(var1, this.maxMnemonicLen_);
      if((var2 & 32) == 32) {
         var3 |= 32;
      }

      BinExport$Meta.access$1102(var1, this.numInstructions_);
      if((var2 & 64) == 64) {
         var3 |= 64;
      }

      BinExport$Meta.access$1202(var1, this.numFunctions_);
      if((var2 & 128) == 128) {
         var3 |= 128;
      }

      BinExport$Meta.access$1302(var1, this.numBasicblocks_);
      if((var2 & 256) == 256) {
         var3 |= 256;
      }

      BinExport$Meta.access$1402(var1, this.numEdges_);
      BinExport$Meta.access$1502(var1, var3);
      this.onBuilt();
      return var1;
   }

   public BinExport$Meta$Builder mergeFrom(Message var1) {
      if(var1 instanceof BinExport$Meta) {
         return this.mergeFrom((BinExport$Meta)var1);
      } else {
         super.mergeFrom(var1);
         return this;
      }
   }

   public BinExport$Meta$Builder mergeFrom(BinExport$Meta var1) {
      if(var1 == BinExport$Meta.getDefaultInstance()) {
         return this;
      } else {
         if(var1.hasInputBinary()) {
            this.bitField0_ |= 1;
            this.inputBinary_ = BinExport$Meta.access$600(var1);
            this.onChanged();
         }

         if(var1.hasInputHash()) {
            this.setInputHash(var1.getInputHash());
         }

         if(var1.hasInputAddressSpace()) {
            this.setInputAddressSpace(var1.getInputAddressSpace());
         }

         if(var1.hasArchitectureName()) {
            this.bitField0_ |= 8;
            this.architectureName_ = BinExport$Meta.access$900(var1);
            this.onChanged();
         }

         if(var1.hasMaxMnemonicLen()) {
            this.setMaxMnemonicLen(var1.getMaxMnemonicLen());
         }

         if(var1.hasNumInstructions()) {
            this.setNumInstructions(var1.getNumInstructions());
         }

         if(var1.hasNumFunctions()) {
            this.setNumFunctions(var1.getNumFunctions());
         }

         if(var1.hasNumBasicblocks()) {
            this.setNumBasicblocks(var1.getNumBasicblocks());
         }

         if(var1.hasNumEdges()) {
            this.setNumEdges(var1.getNumEdges());
         }

         this.mergeUnknownFields(BinExport$Meta.access$1600(var1));
         this.onChanged();
         return this;
      }
   }

   public final boolean isInitialized() {
      return true;
   }

   public BinExport$Meta$Builder mergeFrom(CodedInputStream var1, ExtensionRegistryLite var2) {
      BinExport$Meta var3 = null;

      try {
         var3 = (BinExport$Meta)BinExport$Meta.PARSER.parsePartialFrom(var1, var2);
      } catch (InvalidProtocolBufferException var8) {
         var3 = (BinExport$Meta)var8.getUnfinishedMessage();
         throw var8;
      } finally {
         if(var3 != null) {
            this.mergeFrom(var3);
         }

      }

      return this;
   }

   public boolean hasInputBinary() {
      return (this.bitField0_ & 1) == 1;
   }

   public String getInputBinary() {
      Object var1 = this.inputBinary_;
      if(!(var1 instanceof String)) {
         ByteString var2 = (ByteString)var1;
         String var3 = var2.toStringUtf8();
         if(var2.isValidUtf8()) {
            this.inputBinary_ = var3;
         }

         return var3;
      } else {
         return (String)var1;
      }
   }

   public ByteString getInputBinaryBytes() {
      Object var1 = this.inputBinary_;
      if(var1 instanceof String) {
         ByteString var2 = ByteString.copyFromUtf8((String)var1);
         this.inputBinary_ = var2;
         return var2;
      } else {
         return (ByteString)var1;
      }
   }

   public BinExport$Meta$Builder setInputBinary(String var1) {
      if(var1 == null) {
         throw new NullPointerException();
      } else {
         this.bitField0_ |= 1;
         this.inputBinary_ = var1;
         this.onChanged();
         return this;
      }
   }

   public BinExport$Meta$Builder clearInputBinary() {
      this.bitField0_ &= -2;
      this.inputBinary_ = BinExport$Meta.getDefaultInstance().getInputBinary();
      this.onChanged();
      return this;
   }

   public BinExport$Meta$Builder setInputBinaryBytes(ByteString var1) {
      if(var1 == null) {
         throw new NullPointerException();
      } else {
         this.bitField0_ |= 1;
         this.inputBinary_ = var1;
         this.onChanged();
         return this;
      }
   }

   public boolean hasInputHash() {
      return (this.bitField0_ & 2) == 2;
   }

   public ByteString getInputHash() {
      return this.inputHash_;
   }

   public BinExport$Meta$Builder setInputHash(ByteString var1) {
      if(var1 == null) {
         throw new NullPointerException();
      } else {
         this.bitField0_ |= 2;
         this.inputHash_ = var1;
         this.onChanged();
         return this;
      }
   }

   public BinExport$Meta$Builder clearInputHash() {
      this.bitField0_ &= -3;
      this.inputHash_ = BinExport$Meta.getDefaultInstance().getInputHash();
      this.onChanged();
      return this;
   }

   public boolean hasInputAddressSpace() {
      return (this.bitField0_ & 4) == 4;
   }

   public int getInputAddressSpace() {
      return this.inputAddressSpace_;
   }

   public BinExport$Meta$Builder setInputAddressSpace(int var1) {
      this.bitField0_ |= 4;
      this.inputAddressSpace_ = var1;
      this.onChanged();
      return this;
   }

   public BinExport$Meta$Builder clearInputAddressSpace() {
      this.bitField0_ &= -5;
      this.inputAddressSpace_ = 0;
      this.onChanged();
      return this;
   }

   public boolean hasArchitectureName() {
      return (this.bitField0_ & 8) == 8;
   }

   public String getArchitectureName() {
      Object var1 = this.architectureName_;
      if(!(var1 instanceof String)) {
         ByteString var2 = (ByteString)var1;
         String var3 = var2.toStringUtf8();
         if(var2.isValidUtf8()) {
            this.architectureName_ = var3;
         }

         return var3;
      } else {
         return (String)var1;
      }
   }

   public ByteString getArchitectureNameBytes() {
      Object var1 = this.architectureName_;
      if(var1 instanceof String) {
         ByteString var2 = ByteString.copyFromUtf8((String)var1);
         this.architectureName_ = var2;
         return var2;
      } else {
         return (ByteString)var1;
      }
   }

   public BinExport$Meta$Builder setArchitectureName(String var1) {
      if(var1 == null) {
         throw new NullPointerException();
      } else {
         this.bitField0_ |= 8;
         this.architectureName_ = var1;
         this.onChanged();
         return this;
      }
   }

   public BinExport$Meta$Builder clearArchitectureName() {
      this.bitField0_ &= -9;
      this.architectureName_ = BinExport$Meta.getDefaultInstance().getArchitectureName();
      this.onChanged();
      return this;
   }

   public BinExport$Meta$Builder setArchitectureNameBytes(ByteString var1) {
      if(var1 == null) {
         throw new NullPointerException();
      } else {
         this.bitField0_ |= 8;
         this.architectureName_ = var1;
         this.onChanged();
         return this;
      }
   }

   public boolean hasMaxMnemonicLen() {
      return (this.bitField0_ & 16) == 16;
   }

   public int getMaxMnemonicLen() {
      return this.maxMnemonicLen_;
   }

   public BinExport$Meta$Builder setMaxMnemonicLen(int var1) {
      this.bitField0_ |= 16;
      this.maxMnemonicLen_ = var1;
      this.onChanged();
      return this;
   }

   public BinExport$Meta$Builder clearMaxMnemonicLen() {
      this.bitField0_ &= -17;
      this.maxMnemonicLen_ = 0;
      this.onChanged();
      return this;
   }

   public boolean hasNumInstructions() {
      return (this.bitField0_ & 32) == 32;
   }

   public int getNumInstructions() {
      return this.numInstructions_;
   }

   public BinExport$Meta$Builder setNumInstructions(int var1) {
      this.bitField0_ |= 32;
      this.numInstructions_ = var1;
      this.onChanged();
      return this;
   }

   public BinExport$Meta$Builder clearNumInstructions() {
      this.bitField0_ &= -33;
      this.numInstructions_ = 0;
      this.onChanged();
      return this;
   }

   public boolean hasNumFunctions() {
      return (this.bitField0_ & 64) == 64;
   }

   public int getNumFunctions() {
      return this.numFunctions_;
   }

   public BinExport$Meta$Builder setNumFunctions(int var1) {
      this.bitField0_ |= 64;
      this.numFunctions_ = var1;
      this.onChanged();
      return this;
   }

   public BinExport$Meta$Builder clearNumFunctions() {
      this.bitField0_ &= -65;
      this.numFunctions_ = 0;
      this.onChanged();
      return this;
   }

   public boolean hasNumBasicblocks() {
      return (this.bitField0_ & 128) == 128;
   }

   public int getNumBasicblocks() {
      return this.numBasicblocks_;
   }

   public BinExport$Meta$Builder setNumBasicblocks(int var1) {
      this.bitField0_ |= 128;
      this.numBasicblocks_ = var1;
      this.onChanged();
      return this;
   }

   public BinExport$Meta$Builder clearNumBasicblocks() {
      this.bitField0_ &= -129;
      this.numBasicblocks_ = 0;
      this.onChanged();
      return this;
   }

   public boolean hasNumEdges() {
      return (this.bitField0_ & 256) == 256;
   }

   public int getNumEdges() {
      return this.numEdges_;
   }

   public BinExport$Meta$Builder setNumEdges(int var1) {
      this.bitField0_ |= 256;
      this.numEdges_ = var1;
      this.onChanged();
      return this;
   }

   public BinExport$Meta$Builder clearNumEdges() {
      this.bitField0_ &= -257;
      this.numEdges_ = 0;
      this.onChanged();
      return this;
   }

   // $FF: synthetic method
   BinExport$Meta$Builder(BinExport$1 var1) {
      this();
   }

   // $FF: synthetic method
   BinExport$Meta$Builder(GeneratedMessage$BuilderParent var1, BinExport$1 var2) {
      this(var1);
   }
}
