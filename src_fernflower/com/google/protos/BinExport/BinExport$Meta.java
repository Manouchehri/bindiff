package com.google.protos.BinExport;

import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.Descriptors$Descriptor;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessage;
import com.google.protobuf.GeneratedMessage$Builder;
import com.google.protobuf.GeneratedMessage$BuilderParent;
import com.google.protobuf.GeneratedMessage$FieldAccessorTable;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.Parser;
import com.google.protobuf.UnknownFieldSet;
import com.google.protobuf.UnknownFieldSet$Builder;
import com.google.protos.BinExport.BinExport;
import com.google.protos.BinExport.BinExport$1;
import com.google.protos.BinExport.BinExport$Meta$1;
import com.google.protos.BinExport.BinExport$Meta$Builder;
import com.google.protos.BinExport.BinExport$MetaOrBuilder;
import java.io.IOException;
import java.io.InputStream;

public final class BinExport$Meta extends GeneratedMessage implements BinExport$MetaOrBuilder {
   private int bitField0_;
   public static final int INPUT_BINARY_FIELD_NUMBER = 1;
   private volatile Object inputBinary_;
   public static final int INPUT_HASH_FIELD_NUMBER = 2;
   private ByteString inputHash_;
   public static final int INPUT_ADDRESS_SPACE_FIELD_NUMBER = 3;
   private int inputAddressSpace_;
   public static final int ARCHITECTURE_NAME_FIELD_NUMBER = 4;
   private volatile Object architectureName_;
   public static final int MAX_MNEMONIC_LEN_FIELD_NUMBER = 5;
   private int maxMnemonicLen_;
   public static final int NUM_INSTRUCTIONS_FIELD_NUMBER = 6;
   private int numInstructions_;
   public static final int NUM_FUNCTIONS_FIELD_NUMBER = 7;
   private int numFunctions_;
   public static final int NUM_BASICBLOCKS_FIELD_NUMBER = 8;
   private int numBasicblocks_;
   public static final int NUM_EDGES_FIELD_NUMBER = 9;
   private int numEdges_;
   private byte memoizedIsInitialized;
   private int memoizedSerializedSize;
   private static final long serialVersionUID = 0L;
   private static final BinExport$Meta DEFAULT_INSTANCE = new BinExport$Meta();
   public static final Parser PARSER = new BinExport$Meta$1();

   private BinExport$Meta(GeneratedMessage$Builder var1) {
      super(var1);
      this.memoizedIsInitialized = -1;
      this.memoizedSerializedSize = -1;
   }

   private BinExport$Meta() {
      this.memoizedIsInitialized = -1;
      this.memoizedSerializedSize = -1;
      this.inputBinary_ = "";
      this.inputHash_ = ByteString.EMPTY;
      this.inputAddressSpace_ = 0;
      this.architectureName_ = "";
      this.maxMnemonicLen_ = 0;
      this.numInstructions_ = 0;
      this.numFunctions_ = 0;
      this.numBasicblocks_ = 0;
      this.numEdges_ = 0;
   }

   public final UnknownFieldSet getUnknownFields() {
      return this.unknownFields;
   }

   private BinExport$Meta(CodedInputStream var1, ExtensionRegistryLite var2) {
      this();
      boolean var3 = false;
      UnknownFieldSet$Builder var4 = UnknownFieldSet.newBuilder();

      try {
         boolean var5 = false;

         while(!var5) {
            int var6 = var1.readTag();
            ByteString var7;
            switch(var6) {
            case 0:
               var5 = true;
               break;
            case 10:
               var7 = var1.readBytes();
               this.bitField0_ |= 1;
               this.inputBinary_ = var7;
               break;
            case 18:
               this.bitField0_ |= 2;
               this.inputHash_ = var1.readBytes();
               break;
            case 24:
               this.bitField0_ |= 4;
               this.inputAddressSpace_ = var1.readUInt32();
               break;
            case 34:
               var7 = var1.readBytes();
               this.bitField0_ |= 8;
               this.architectureName_ = var7;
               break;
            case 40:
               this.bitField0_ |= 16;
               this.maxMnemonicLen_ = var1.readUInt32();
               break;
            case 48:
               this.bitField0_ |= 32;
               this.numInstructions_ = var1.readUInt32();
               break;
            case 56:
               this.bitField0_ |= 64;
               this.numFunctions_ = var1.readUInt32();
               break;
            case 64:
               this.bitField0_ |= 128;
               this.numBasicblocks_ = var1.readUInt32();
               break;
            case 72:
               this.bitField0_ |= 256;
               this.numEdges_ = var1.readUInt32();
               break;
            default:
               if(!this.parseUnknownField(var1, var4, var2, var6)) {
                  var5 = true;
               }
            }
         }
      } catch (InvalidProtocolBufferException var12) {
         throw new RuntimeException(var12.setUnfinishedMessage(this));
      } catch (IOException var13) {
         throw new RuntimeException((new InvalidProtocolBufferException(var13.getMessage())).setUnfinishedMessage(this));
      } finally {
         this.unknownFields = var4.build();
         this.makeExtensionsImmutable();
      }

   }

   public static final Descriptors$Descriptor getDescriptor() {
      return BinExport.access$000();
   }

   protected GeneratedMessage$FieldAccessorTable internalGetFieldAccessorTable() {
      return BinExport.access$100().ensureFieldAccessorsInitialized(BinExport$Meta.class, BinExport$Meta$Builder.class);
   }

   public boolean hasInputBinary() {
      return (this.bitField0_ & 1) == 1;
   }

   public String getInputBinary() {
      Object var1 = this.inputBinary_;
      if(var1 instanceof String) {
         return (String)var1;
      } else {
         ByteString var2 = (ByteString)var1;
         String var3 = var2.toStringUtf8();
         if(var2.isValidUtf8()) {
            this.inputBinary_ = var3;
         }

         return var3;
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

   public boolean hasInputHash() {
      return (this.bitField0_ & 2) == 2;
   }

   public ByteString getInputHash() {
      return this.inputHash_;
   }

   public boolean hasInputAddressSpace() {
      return (this.bitField0_ & 4) == 4;
   }

   public int getInputAddressSpace() {
      return this.inputAddressSpace_;
   }

   public boolean hasArchitectureName() {
      return (this.bitField0_ & 8) == 8;
   }

   public String getArchitectureName() {
      Object var1 = this.architectureName_;
      if(var1 instanceof String) {
         return (String)var1;
      } else {
         ByteString var2 = (ByteString)var1;
         String var3 = var2.toStringUtf8();
         if(var2.isValidUtf8()) {
            this.architectureName_ = var3;
         }

         return var3;
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

   public boolean hasMaxMnemonicLen() {
      return (this.bitField0_ & 16) == 16;
   }

   public int getMaxMnemonicLen() {
      return this.maxMnemonicLen_;
   }

   public boolean hasNumInstructions() {
      return (this.bitField0_ & 32) == 32;
   }

   public int getNumInstructions() {
      return this.numInstructions_;
   }

   public boolean hasNumFunctions() {
      return (this.bitField0_ & 64) == 64;
   }

   public int getNumFunctions() {
      return this.numFunctions_;
   }

   public boolean hasNumBasicblocks() {
      return (this.bitField0_ & 128) == 128;
   }

   public int getNumBasicblocks() {
      return this.numBasicblocks_;
   }

   public boolean hasNumEdges() {
      return (this.bitField0_ & 256) == 256;
   }

   public int getNumEdges() {
      return this.numEdges_;
   }

   public final boolean isInitialized() {
      byte var1 = this.memoizedIsInitialized;
      if(var1 == 1) {
         return true;
      } else if(var1 == 0) {
         return false;
      } else {
         this.memoizedIsInitialized = 1;
         return true;
      }
   }

   public void writeTo(CodedOutputStream var1) {
      if((this.bitField0_ & 1) == 1) {
         var1.writeBytes(1, this.getInputBinaryBytes());
      }

      if((this.bitField0_ & 2) == 2) {
         var1.writeBytes(2, this.inputHash_);
      }

      if((this.bitField0_ & 4) == 4) {
         var1.writeUInt32(3, this.inputAddressSpace_);
      }

      if((this.bitField0_ & 8) == 8) {
         var1.writeBytes(4, this.getArchitectureNameBytes());
      }

      if((this.bitField0_ & 16) == 16) {
         var1.writeUInt32(5, this.maxMnemonicLen_);
      }

      if((this.bitField0_ & 32) == 32) {
         var1.writeUInt32(6, this.numInstructions_);
      }

      if((this.bitField0_ & 64) == 64) {
         var1.writeUInt32(7, this.numFunctions_);
      }

      if((this.bitField0_ & 128) == 128) {
         var1.writeUInt32(8, this.numBasicblocks_);
      }

      if((this.bitField0_ & 256) == 256) {
         var1.writeUInt32(9, this.numEdges_);
      }

      this.unknownFields.writeTo(var1);
   }

   public int getSerializedSize() {
      int var1 = this.memoizedSerializedSize;
      if(var1 != -1) {
         return var1;
      } else {
         var1 = 0;
         if((this.bitField0_ & 1) == 1) {
            var1 += CodedOutputStream.computeBytesSize(1, this.getInputBinaryBytes());
         }

         if((this.bitField0_ & 2) == 2) {
            var1 += CodedOutputStream.computeBytesSize(2, this.inputHash_);
         }

         if((this.bitField0_ & 4) == 4) {
            var1 += CodedOutputStream.computeUInt32Size(3, this.inputAddressSpace_);
         }

         if((this.bitField0_ & 8) == 8) {
            var1 += CodedOutputStream.computeBytesSize(4, this.getArchitectureNameBytes());
         }

         if((this.bitField0_ & 16) == 16) {
            var1 += CodedOutputStream.computeUInt32Size(5, this.maxMnemonicLen_);
         }

         if((this.bitField0_ & 32) == 32) {
            var1 += CodedOutputStream.computeUInt32Size(6, this.numInstructions_);
         }

         if((this.bitField0_ & 64) == 64) {
            var1 += CodedOutputStream.computeUInt32Size(7, this.numFunctions_);
         }

         if((this.bitField0_ & 128) == 128) {
            var1 += CodedOutputStream.computeUInt32Size(8, this.numBasicblocks_);
         }

         if((this.bitField0_ & 256) == 256) {
            var1 += CodedOutputStream.computeUInt32Size(9, this.numEdges_);
         }

         var1 += this.unknownFields.getSerializedSize();
         this.memoizedSerializedSize = var1;
         return var1;
      }
   }

   public static BinExport$Meta parseFrom(ByteString var0) {
      return (BinExport$Meta)PARSER.parseFrom(var0);
   }

   public static BinExport$Meta parseFrom(ByteString var0, ExtensionRegistryLite var1) {
      return (BinExport$Meta)PARSER.parseFrom(var0, var1);
   }

   public static BinExport$Meta parseFrom(byte[] var0) {
      return (BinExport$Meta)PARSER.parseFrom(var0);
   }

   public static BinExport$Meta parseFrom(byte[] var0, ExtensionRegistryLite var1) {
      return (BinExport$Meta)PARSER.parseFrom(var0, var1);
   }

   public static BinExport$Meta parseFrom(InputStream var0) {
      return (BinExport$Meta)PARSER.parseFrom(var0);
   }

   public static BinExport$Meta parseFrom(InputStream var0, ExtensionRegistryLite var1) {
      return (BinExport$Meta)PARSER.parseFrom(var0, var1);
   }

   public static BinExport$Meta parseDelimitedFrom(InputStream var0) {
      return (BinExport$Meta)PARSER.parseDelimitedFrom(var0);
   }

   public static BinExport$Meta parseDelimitedFrom(InputStream var0, ExtensionRegistryLite var1) {
      return (BinExport$Meta)PARSER.parseDelimitedFrom(var0, var1);
   }

   public static BinExport$Meta parseFrom(CodedInputStream var0) {
      return (BinExport$Meta)PARSER.parseFrom(var0);
   }

   public static BinExport$Meta parseFrom(CodedInputStream var0, ExtensionRegistryLite var1) {
      return (BinExport$Meta)PARSER.parseFrom(var0, var1);
   }

   public BinExport$Meta$Builder newBuilderForType() {
      return newBuilder();
   }

   public static BinExport$Meta$Builder newBuilder() {
      return DEFAULT_INSTANCE.toBuilder();
   }

   public static BinExport$Meta$Builder newBuilder(BinExport$Meta var0) {
      return DEFAULT_INSTANCE.toBuilder().mergeFrom(var0);
   }

   public BinExport$Meta$Builder toBuilder() {
      return this == DEFAULT_INSTANCE?new BinExport$Meta$Builder((BinExport$1)null):(new BinExport$Meta$Builder((BinExport$1)null)).mergeFrom(this);
   }

   protected BinExport$Meta$Builder newBuilderForType(GeneratedMessage$BuilderParent var1) {
      BinExport$Meta$Builder var2 = new BinExport$Meta$Builder(var1, (BinExport$1)null);
      return var2;
   }

   public static BinExport$Meta getDefaultInstance() {
      return DEFAULT_INSTANCE;
   }

   public Parser getParserForType() {
      return PARSER;
   }

   public BinExport$Meta getDefaultInstanceForType() {
      return DEFAULT_INSTANCE;
   }

   // $FF: synthetic method
   static boolean access$400() {
      return alwaysUseFieldBuilders;
   }

   // $FF: synthetic method
   BinExport$Meta(GeneratedMessage$Builder var1, BinExport$1 var2) {
      this(var1);
   }

   // $FF: synthetic method
   static Object access$602(BinExport$Meta var0, Object var1) {
      return var0.inputBinary_ = var1;
   }

   // $FF: synthetic method
   static ByteString access$702(BinExport$Meta var0, ByteString var1) {
      return var0.inputHash_ = var1;
   }

   // $FF: synthetic method
   static int access$802(BinExport$Meta var0, int var1) {
      return var0.inputAddressSpace_ = var1;
   }

   // $FF: synthetic method
   static Object access$902(BinExport$Meta var0, Object var1) {
      return var0.architectureName_ = var1;
   }

   // $FF: synthetic method
   static int access$1002(BinExport$Meta var0, int var1) {
      return var0.maxMnemonicLen_ = var1;
   }

   // $FF: synthetic method
   static int access$1102(BinExport$Meta var0, int var1) {
      return var0.numInstructions_ = var1;
   }

   // $FF: synthetic method
   static int access$1202(BinExport$Meta var0, int var1) {
      return var0.numFunctions_ = var1;
   }

   // $FF: synthetic method
   static int access$1302(BinExport$Meta var0, int var1) {
      return var0.numBasicblocks_ = var1;
   }

   // $FF: synthetic method
   static int access$1402(BinExport$Meta var0, int var1) {
      return var0.numEdges_ = var1;
   }

   // $FF: synthetic method
   static int access$1502(BinExport$Meta var0, int var1) {
      return var0.bitField0_ = var1;
   }

   // $FF: synthetic method
   static Object access$600(BinExport$Meta var0) {
      return var0.inputBinary_;
   }

   // $FF: synthetic method
   static Object access$900(BinExport$Meta var0) {
      return var0.architectureName_;
   }

   // $FF: synthetic method
   static UnknownFieldSet access$1600(BinExport$Meta var0) {
      return var0.unknownFields;
   }

   // $FF: synthetic method
   BinExport$Meta(CodedInputStream var1, ExtensionRegistryLite var2, BinExport$1 var3) {
      this(var1, var2);
   }
}
