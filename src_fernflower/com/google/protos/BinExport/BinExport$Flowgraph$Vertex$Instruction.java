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
import com.google.protobuf.MessageLite;
import com.google.protobuf.Parser;
import com.google.protobuf.UnknownFieldSet;
import com.google.protobuf.UnknownFieldSet$Builder;
import com.google.protos.BinExport.BinExport;
import com.google.protos.BinExport.BinExport$1;
import com.google.protos.BinExport.BinExport$Flowgraph$Vertex$Instruction$1;
import com.google.protos.BinExport.BinExport$Flowgraph$Vertex$Instruction$Builder;
import com.google.protos.BinExport.BinExport$Flowgraph$Vertex$Instruction$Comment;
import com.google.protos.BinExport.BinExport$Flowgraph$Vertex$Instruction$CommentOrBuilder;
import com.google.protos.BinExport.BinExport$Flowgraph$Vertex$InstructionOrBuilder;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class BinExport$Flowgraph$Vertex$Instruction extends GeneratedMessage implements BinExport$Flowgraph$Vertex$InstructionOrBuilder {
   private int bitField0_;
   public static final int ADDRESS_FIELD_NUMBER = 1;
   private long address_;
   public static final int PRIME_FIELD_NUMBER = 2;
   private int prime_;
   public static final int STRING_REFERENCE_FIELD_NUMBER = 3;
   private int stringReference_;
   public static final int MNEMONIC_FIELD_NUMBER = 4;
   private volatile Object mnemonic_;
   public static final int OPERANDS_FIELD_NUMBER = 5;
   private volatile Object operands_;
   public static final int RAW_BYTES_FIELD_NUMBER = 6;
   private ByteString rawBytes_;
   public static final int CALL_TARGETS_FIELD_NUMBER = 7;
   private List callTargets_;
   public static final int COMMENTS_FIELD_NUMBER = 8;
   private List comments_;
   private byte memoizedIsInitialized;
   private int memoizedSerializedSize;
   private static final long serialVersionUID = 0L;
   private static final BinExport$Flowgraph$Vertex$Instruction DEFAULT_INSTANCE = new BinExport$Flowgraph$Vertex$Instruction();
   public static final Parser PARSER = new BinExport$Flowgraph$Vertex$Instruction$1();

   private BinExport$Flowgraph$Vertex$Instruction(GeneratedMessage$Builder var1) {
      super(var1);
      this.memoizedIsInitialized = -1;
      this.memoizedSerializedSize = -1;
   }

   private BinExport$Flowgraph$Vertex$Instruction() {
      this.memoizedIsInitialized = -1;
      this.memoizedSerializedSize = -1;
      this.address_ = 0L;
      this.prime_ = 0;
      this.stringReference_ = 0;
      this.mnemonic_ = "";
      this.operands_ = "";
      this.rawBytes_ = ByteString.EMPTY;
      this.callTargets_ = Collections.emptyList();
      this.comments_ = Collections.emptyList();
   }

   public final UnknownFieldSet getUnknownFields() {
      return this.unknownFields;
   }

   private BinExport$Flowgraph$Vertex$Instruction(CodedInputStream var1, ExtensionRegistryLite var2) {
      this();
      int var3 = 0;
      UnknownFieldSet$Builder var4 = UnknownFieldSet.newBuilder();

      try {
         boolean var5 = false;

         while(!var5) {
            int var6 = var1.readTag();
            ByteString var16;
            int var8;
            switch(var6) {
            case 0:
               var5 = true;
               continue;
            case 8:
               this.bitField0_ |= 1;
               this.address_ = var1.readUInt64();
               continue;
            case 16:
               this.bitField0_ |= 2;
               this.prime_ = var1.readUInt32();
               continue;
            case 24:
               this.bitField0_ |= 4;
               this.stringReference_ = var1.readUInt32();
               continue;
            case 34:
               var16 = var1.readBytes();
               this.bitField0_ |= 8;
               this.mnemonic_ = var16;
               continue;
            case 42:
               var16 = var1.readBytes();
               this.bitField0_ |= 16;
               this.operands_ = var16;
               continue;
            case 50:
               this.bitField0_ |= 32;
               this.rawBytes_ = var1.readBytes();
               continue;
            case 56:
               if((var3 & 64) != 64) {
                  this.callTargets_ = new ArrayList();
                  var3 |= 64;
               }

               this.callTargets_.add(Long.valueOf(var1.readUInt64()));
               continue;
            case 58:
               int var7 = var1.readRawVarint32();
               var8 = var1.pushLimit(var7);
               if((var3 & 64) != 64 && var1.getBytesUntilLimit() > 0) {
                  this.callTargets_ = new ArrayList();
                  var3 |= 64;
               }
               break;
            case 66:
               if((var3 & 128) != 128) {
                  this.comments_ = new ArrayList();
                  var3 |= 128;
               }

               this.comments_.add(var1.readMessage(BinExport$Flowgraph$Vertex$Instruction$Comment.PARSER, var2));
               continue;
            default:
               if(!this.parseUnknownField(var1, var4, var2, var6)) {
                  var5 = true;
               }
               continue;
            }

            while(var1.getBytesUntilLimit() > 0) {
               this.callTargets_.add(Long.valueOf(var1.readUInt64()));
            }

            var1.popLimit(var8);
         }
      } catch (InvalidProtocolBufferException var13) {
         throw new RuntimeException(var13.setUnfinishedMessage(this));
      } catch (IOException var14) {
         throw new RuntimeException((new InvalidProtocolBufferException(var14.getMessage())).setUnfinishedMessage(this));
      } finally {
         if((var3 & 64) == 64) {
            this.callTargets_ = Collections.unmodifiableList(this.callTargets_);
         }

         if((var3 & 128) == 128) {
            this.comments_ = Collections.unmodifiableList(this.comments_);
         }

         this.unknownFields = var4.build();
         this.makeExtensionsImmutable();
      }

   }

   public static final Descriptors$Descriptor getDescriptor() {
      return BinExport.access$6100();
   }

   protected GeneratedMessage$FieldAccessorTable internalGetFieldAccessorTable() {
      return BinExport.access$6200().ensureFieldAccessorsInitialized(BinExport$Flowgraph$Vertex$Instruction.class, BinExport$Flowgraph$Vertex$Instruction$Builder.class);
   }

   public boolean hasAddress() {
      return (this.bitField0_ & 1) == 1;
   }

   public long getAddress() {
      return this.address_;
   }

   public boolean hasPrime() {
      return (this.bitField0_ & 2) == 2;
   }

   public int getPrime() {
      return this.prime_;
   }

   public boolean hasStringReference() {
      return (this.bitField0_ & 4) == 4;
   }

   public int getStringReference() {
      return this.stringReference_;
   }

   public boolean hasMnemonic() {
      return (this.bitField0_ & 8) == 8;
   }

   public String getMnemonic() {
      Object var1 = this.mnemonic_;
      if(var1 instanceof String) {
         return (String)var1;
      } else {
         ByteString var2 = (ByteString)var1;
         String var3 = var2.toStringUtf8();
         if(var2.isValidUtf8()) {
            this.mnemonic_ = var3;
         }

         return var3;
      }
   }

   public ByteString getMnemonicBytes() {
      Object var1 = this.mnemonic_;
      if(var1 instanceof String) {
         ByteString var2 = ByteString.copyFromUtf8((String)var1);
         this.mnemonic_ = var2;
         return var2;
      } else {
         return (ByteString)var1;
      }
   }

   public boolean hasOperands() {
      return (this.bitField0_ & 16) == 16;
   }

   public String getOperands() {
      Object var1 = this.operands_;
      if(var1 instanceof String) {
         return (String)var1;
      } else {
         ByteString var2 = (ByteString)var1;
         String var3 = var2.toStringUtf8();
         if(var2.isValidUtf8()) {
            this.operands_ = var3;
         }

         return var3;
      }
   }

   public ByteString getOperandsBytes() {
      Object var1 = this.operands_;
      if(var1 instanceof String) {
         ByteString var2 = ByteString.copyFromUtf8((String)var1);
         this.operands_ = var2;
         return var2;
      } else {
         return (ByteString)var1;
      }
   }

   public boolean hasRawBytes() {
      return (this.bitField0_ & 32) == 32;
   }

   public ByteString getRawBytes() {
      return this.rawBytes_;
   }

   public List getCallTargetsList() {
      return this.callTargets_;
   }

   public int getCallTargetsCount() {
      return this.callTargets_.size();
   }

   public long getCallTargets(int var1) {
      return ((Long)this.callTargets_.get(var1)).longValue();
   }

   public List getCommentsList() {
      return this.comments_;
   }

   public List getCommentsOrBuilderList() {
      return this.comments_;
   }

   public int getCommentsCount() {
      return this.comments_.size();
   }

   public BinExport$Flowgraph$Vertex$Instruction$Comment getComments(int var1) {
      return (BinExport$Flowgraph$Vertex$Instruction$Comment)this.comments_.get(var1);
   }

   public BinExport$Flowgraph$Vertex$Instruction$CommentOrBuilder getCommentsOrBuilder(int var1) {
      return (BinExport$Flowgraph$Vertex$Instruction$CommentOrBuilder)this.comments_.get(var1);
   }

   public final boolean isInitialized() {
      byte var1 = this.memoizedIsInitialized;
      if(var1 == 1) {
         return true;
      } else if(var1 == 0) {
         return false;
      } else if(!this.hasAddress()) {
         this.memoizedIsInitialized = 0;
         return false;
      } else if(!this.hasPrime()) {
         this.memoizedIsInitialized = 0;
         return false;
      } else {
         for(int var2 = 0; var2 < this.getCommentsCount(); ++var2) {
            if(!this.getComments(var2).isInitialized()) {
               this.memoizedIsInitialized = 0;
               return false;
            }
         }

         this.memoizedIsInitialized = 1;
         return true;
      }
   }

   public void writeTo(CodedOutputStream var1) {
      if((this.bitField0_ & 1) == 1) {
         var1.writeUInt64(1, this.address_);
      }

      if((this.bitField0_ & 2) == 2) {
         var1.writeUInt32(2, this.prime_);
      }

      if((this.bitField0_ & 4) == 4) {
         var1.writeUInt32(3, this.stringReference_);
      }

      if((this.bitField0_ & 8) == 8) {
         var1.writeBytes(4, this.getMnemonicBytes());
      }

      if((this.bitField0_ & 16) == 16) {
         var1.writeBytes(5, this.getOperandsBytes());
      }

      if((this.bitField0_ & 32) == 32) {
         var1.writeBytes(6, this.rawBytes_);
      }

      int var2;
      for(var2 = 0; var2 < this.callTargets_.size(); ++var2) {
         var1.writeUInt64(7, ((Long)this.callTargets_.get(var2)).longValue());
      }

      for(var2 = 0; var2 < this.comments_.size(); ++var2) {
         var1.writeMessage(8, (MessageLite)this.comments_.get(var2));
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
            var1 += CodedOutputStream.computeUInt64Size(1, this.address_);
         }

         if((this.bitField0_ & 2) == 2) {
            var1 += CodedOutputStream.computeUInt32Size(2, this.prime_);
         }

         if((this.bitField0_ & 4) == 4) {
            var1 += CodedOutputStream.computeUInt32Size(3, this.stringReference_);
         }

         if((this.bitField0_ & 8) == 8) {
            var1 += CodedOutputStream.computeBytesSize(4, this.getMnemonicBytes());
         }

         if((this.bitField0_ & 16) == 16) {
            var1 += CodedOutputStream.computeBytesSize(5, this.getOperandsBytes());
         }

         if((this.bitField0_ & 32) == 32) {
            var1 += CodedOutputStream.computeBytesSize(6, this.rawBytes_);
         }

         int var2 = 0;

         for(int var3 = 0; var3 < this.callTargets_.size(); ++var3) {
            var2 += CodedOutputStream.computeUInt64SizeNoTag(((Long)this.callTargets_.get(var3)).longValue());
         }

         var1 += var2;
         var1 += 1 * this.getCallTargetsList().size();

         for(var2 = 0; var2 < this.comments_.size(); ++var2) {
            var1 += CodedOutputStream.computeMessageSize(8, (MessageLite)this.comments_.get(var2));
         }

         var1 += this.unknownFields.getSerializedSize();
         this.memoizedSerializedSize = var1;
         return var1;
      }
   }

   public static BinExport$Flowgraph$Vertex$Instruction parseFrom(ByteString var0) {
      return (BinExport$Flowgraph$Vertex$Instruction)PARSER.parseFrom(var0);
   }

   public static BinExport$Flowgraph$Vertex$Instruction parseFrom(ByteString var0, ExtensionRegistryLite var1) {
      return (BinExport$Flowgraph$Vertex$Instruction)PARSER.parseFrom(var0, var1);
   }

   public static BinExport$Flowgraph$Vertex$Instruction parseFrom(byte[] var0) {
      return (BinExport$Flowgraph$Vertex$Instruction)PARSER.parseFrom(var0);
   }

   public static BinExport$Flowgraph$Vertex$Instruction parseFrom(byte[] var0, ExtensionRegistryLite var1) {
      return (BinExport$Flowgraph$Vertex$Instruction)PARSER.parseFrom(var0, var1);
   }

   public static BinExport$Flowgraph$Vertex$Instruction parseFrom(InputStream var0) {
      return (BinExport$Flowgraph$Vertex$Instruction)PARSER.parseFrom(var0);
   }

   public static BinExport$Flowgraph$Vertex$Instruction parseFrom(InputStream var0, ExtensionRegistryLite var1) {
      return (BinExport$Flowgraph$Vertex$Instruction)PARSER.parseFrom(var0, var1);
   }

   public static BinExport$Flowgraph$Vertex$Instruction parseDelimitedFrom(InputStream var0) {
      return (BinExport$Flowgraph$Vertex$Instruction)PARSER.parseDelimitedFrom(var0);
   }

   public static BinExport$Flowgraph$Vertex$Instruction parseDelimitedFrom(InputStream var0, ExtensionRegistryLite var1) {
      return (BinExport$Flowgraph$Vertex$Instruction)PARSER.parseDelimitedFrom(var0, var1);
   }

   public static BinExport$Flowgraph$Vertex$Instruction parseFrom(CodedInputStream var0) {
      return (BinExport$Flowgraph$Vertex$Instruction)PARSER.parseFrom(var0);
   }

   public static BinExport$Flowgraph$Vertex$Instruction parseFrom(CodedInputStream var0, ExtensionRegistryLite var1) {
      return (BinExport$Flowgraph$Vertex$Instruction)PARSER.parseFrom(var0, var1);
   }

   public BinExport$Flowgraph$Vertex$Instruction$Builder newBuilderForType() {
      return newBuilder();
   }

   public static BinExport$Flowgraph$Vertex$Instruction$Builder newBuilder() {
      return DEFAULT_INSTANCE.toBuilder();
   }

   public static BinExport$Flowgraph$Vertex$Instruction$Builder newBuilder(BinExport$Flowgraph$Vertex$Instruction var0) {
      return DEFAULT_INSTANCE.toBuilder().mergeFrom(var0);
   }

   public BinExport$Flowgraph$Vertex$Instruction$Builder toBuilder() {
      return this == DEFAULT_INSTANCE?new BinExport$Flowgraph$Vertex$Instruction$Builder((BinExport$1)null):(new BinExport$Flowgraph$Vertex$Instruction$Builder((BinExport$1)null)).mergeFrom(this);
   }

   protected BinExport$Flowgraph$Vertex$Instruction$Builder newBuilderForType(GeneratedMessage$BuilderParent var1) {
      BinExport$Flowgraph$Vertex$Instruction$Builder var2 = new BinExport$Flowgraph$Vertex$Instruction$Builder(var1, (BinExport$1)null);
      return var2;
   }

   public static BinExport$Flowgraph$Vertex$Instruction getDefaultInstance() {
      return DEFAULT_INSTANCE;
   }

   public Parser getParserForType() {
      return PARSER;
   }

   public BinExport$Flowgraph$Vertex$Instruction getDefaultInstanceForType() {
      return DEFAULT_INSTANCE;
   }

   // $FF: synthetic method
   static boolean access$7600() {
      return alwaysUseFieldBuilders;
   }

   // $FF: synthetic method
   BinExport$Flowgraph$Vertex$Instruction(GeneratedMessage$Builder var1, BinExport$1 var2) {
      this(var1);
   }

   // $FF: synthetic method
   static long access$7802(BinExport$Flowgraph$Vertex$Instruction var0, long var1) {
      return var0.address_ = var1;
   }

   // $FF: synthetic method
   static int access$7902(BinExport$Flowgraph$Vertex$Instruction var0, int var1) {
      return var0.prime_ = var1;
   }

   // $FF: synthetic method
   static int access$8002(BinExport$Flowgraph$Vertex$Instruction var0, int var1) {
      return var0.stringReference_ = var1;
   }

   // $FF: synthetic method
   static Object access$8102(BinExport$Flowgraph$Vertex$Instruction var0, Object var1) {
      return var0.mnemonic_ = var1;
   }

   // $FF: synthetic method
   static Object access$8202(BinExport$Flowgraph$Vertex$Instruction var0, Object var1) {
      return var0.operands_ = var1;
   }

   // $FF: synthetic method
   static ByteString access$8302(BinExport$Flowgraph$Vertex$Instruction var0, ByteString var1) {
      return var0.rawBytes_ = var1;
   }

   // $FF: synthetic method
   static List access$8402(BinExport$Flowgraph$Vertex$Instruction var0, List var1) {
      return var0.callTargets_ = var1;
   }

   // $FF: synthetic method
   static List access$8502(BinExport$Flowgraph$Vertex$Instruction var0, List var1) {
      return var0.comments_ = var1;
   }

   // $FF: synthetic method
   static int access$8602(BinExport$Flowgraph$Vertex$Instruction var0, int var1) {
      return var0.bitField0_ = var1;
   }

   // $FF: synthetic method
   static Object access$8100(BinExport$Flowgraph$Vertex$Instruction var0) {
      return var0.mnemonic_;
   }

   // $FF: synthetic method
   static Object access$8200(BinExport$Flowgraph$Vertex$Instruction var0) {
      return var0.operands_;
   }

   // $FF: synthetic method
   static List access$8400(BinExport$Flowgraph$Vertex$Instruction var0) {
      return var0.callTargets_;
   }

   // $FF: synthetic method
   static List access$8500(BinExport$Flowgraph$Vertex$Instruction var0) {
      return var0.comments_;
   }

   // $FF: synthetic method
   static boolean access$8700() {
      return alwaysUseFieldBuilders;
   }

   // $FF: synthetic method
   static UnknownFieldSet access$8800(BinExport$Flowgraph$Vertex$Instruction var0) {
      return var0.unknownFields;
   }

   // $FF: synthetic method
   BinExport$Flowgraph$Vertex$Instruction(CodedInputStream var1, ExtensionRegistryLite var2, BinExport$1 var3) {
      this(var1, var2);
   }
}
