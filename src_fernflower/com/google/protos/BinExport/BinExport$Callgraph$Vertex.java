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
import com.google.protos.BinExport.BinExport$Callgraph$Vertex$1;
import com.google.protos.BinExport.BinExport$Callgraph$Vertex$Builder;
import com.google.protos.BinExport.BinExport$Callgraph$Vertex$FunctionType;
import com.google.protos.BinExport.BinExport$Callgraph$VertexOrBuilder;
import java.io.IOException;
import java.io.InputStream;

public final class BinExport$Callgraph$Vertex extends GeneratedMessage implements BinExport$Callgraph$VertexOrBuilder {
   private int bitField0_;
   public static final int ADDRESS_FIELD_NUMBER = 1;
   private long address_;
   public static final int PRIME_FIELD_NUMBER = 2;
   private long prime_;
   public static final int FUNCTION_TYPE_FIELD_NUMBER = 3;
   private int functionType_;
   public static final int HAS_REAL_NAME_FIELD_NUMBER = 4;
   private boolean hasRealName_;
   public static final int MANGLED_NAME_FIELD_NUMBER = 5;
   private volatile Object mangledName_;
   public static final int DEMANGLED_NAME_FIELD_NUMBER = 6;
   private volatile Object demangledName_;
   private byte memoizedIsInitialized;
   private int memoizedSerializedSize;
   private static final long serialVersionUID = 0L;
   private static final BinExport$Callgraph$Vertex DEFAULT_INSTANCE = new BinExport$Callgraph$Vertex();
   public static final Parser PARSER = new BinExport$Callgraph$Vertex$1();

   private BinExport$Callgraph$Vertex(GeneratedMessage$Builder var1) {
      super(var1);
      this.memoizedIsInitialized = -1;
      this.memoizedSerializedSize = -1;
   }

   private BinExport$Callgraph$Vertex() {
      this.memoizedIsInitialized = -1;
      this.memoizedSerializedSize = -1;
      this.address_ = 0L;
      this.prime_ = 0L;
      this.functionType_ = 0;
      this.hasRealName_ = false;
      this.mangledName_ = "";
      this.demangledName_ = "";
   }

   public final UnknownFieldSet getUnknownFields() {
      return this.unknownFields;
   }

   private BinExport$Callgraph$Vertex(CodedInputStream var1, ExtensionRegistryLite var2) {
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
            case 8:
               this.bitField0_ |= 1;
               this.address_ = var1.readUInt64();
               break;
            case 16:
               this.bitField0_ |= 2;
               this.prime_ = var1.readUInt64();
               break;
            case 24:
               int var16 = var1.readEnum();
               BinExport$Callgraph$Vertex$FunctionType var8 = BinExport$Callgraph$Vertex$FunctionType.valueOf(var16);
               if(var8 == null) {
                  var4.mergeVarintField(3, var16);
               } else {
                  this.bitField0_ |= 4;
                  this.functionType_ = var16;
               }
               break;
            case 32:
               this.bitField0_ |= 8;
               this.hasRealName_ = var1.readBool();
               break;
            case 42:
               var7 = var1.readBytes();
               this.bitField0_ |= 16;
               this.mangledName_ = var7;
               break;
            case 50:
               var7 = var1.readBytes();
               this.bitField0_ |= 32;
               this.demangledName_ = var7;
               break;
            default:
               if(!this.parseUnknownField(var1, var4, var2, var6)) {
                  var5 = true;
               }
            }
         }
      } catch (InvalidProtocolBufferException var13) {
         throw new RuntimeException(var13.setUnfinishedMessage(this));
      } catch (IOException var14) {
         throw new RuntimeException((new InvalidProtocolBufferException(var14.getMessage())).setUnfinishedMessage(this));
      } finally {
         this.unknownFields = var4.build();
         this.makeExtensionsImmutable();
      }

   }

   public static final Descriptors$Descriptor getDescriptor() {
      return BinExport.access$2000();
   }

   protected GeneratedMessage$FieldAccessorTable internalGetFieldAccessorTable() {
      return BinExport.access$2100().ensureFieldAccessorsInitialized(BinExport$Callgraph$Vertex.class, BinExport$Callgraph$Vertex$Builder.class);
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

   public long getPrime() {
      return this.prime_;
   }

   public boolean hasFunctionType() {
      return (this.bitField0_ & 4) == 4;
   }

   public BinExport$Callgraph$Vertex$FunctionType getFunctionType() {
      BinExport$Callgraph$Vertex$FunctionType var1 = BinExport$Callgraph$Vertex$FunctionType.valueOf(this.functionType_);
      return var1 == null?BinExport$Callgraph$Vertex$FunctionType.NORMAL:var1;
   }

   public boolean hasHasRealName() {
      return (this.bitField0_ & 8) == 8;
   }

   public boolean getHasRealName() {
      return this.hasRealName_;
   }

   public boolean hasMangledName() {
      return (this.bitField0_ & 16) == 16;
   }

   public String getMangledName() {
      Object var1 = this.mangledName_;
      if(var1 instanceof String) {
         return (String)var1;
      } else {
         ByteString var2 = (ByteString)var1;
         String var3 = var2.toStringUtf8();
         if(var2.isValidUtf8()) {
            this.mangledName_ = var3;
         }

         return var3;
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

   public boolean hasDemangledName() {
      return (this.bitField0_ & 32) == 32;
   }

   public String getDemangledName() {
      Object var1 = this.demangledName_;
      if(var1 instanceof String) {
         return (String)var1;
      } else {
         ByteString var2 = (ByteString)var1;
         String var3 = var2.toStringUtf8();
         if(var2.isValidUtf8()) {
            this.demangledName_ = var3;
         }

         return var3;
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
         this.memoizedIsInitialized = 1;
         return true;
      }
   }

   public void writeTo(CodedOutputStream var1) {
      if((this.bitField0_ & 1) == 1) {
         var1.writeUInt64(1, this.address_);
      }

      if((this.bitField0_ & 2) == 2) {
         var1.writeUInt64(2, this.prime_);
      }

      if((this.bitField0_ & 4) == 4) {
         var1.writeEnum(3, this.functionType_);
      }

      if((this.bitField0_ & 8) == 8) {
         var1.writeBool(4, this.hasRealName_);
      }

      if((this.bitField0_ & 16) == 16) {
         var1.writeBytes(5, this.getMangledNameBytes());
      }

      if((this.bitField0_ & 32) == 32) {
         var1.writeBytes(6, this.getDemangledNameBytes());
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
            var1 += CodedOutputStream.computeUInt64Size(2, this.prime_);
         }

         if((this.bitField0_ & 4) == 4) {
            var1 += CodedOutputStream.computeEnumSize(3, this.functionType_);
         }

         if((this.bitField0_ & 8) == 8) {
            var1 += CodedOutputStream.computeBoolSize(4, this.hasRealName_);
         }

         if((this.bitField0_ & 16) == 16) {
            var1 += CodedOutputStream.computeBytesSize(5, this.getMangledNameBytes());
         }

         if((this.bitField0_ & 32) == 32) {
            var1 += CodedOutputStream.computeBytesSize(6, this.getDemangledNameBytes());
         }

         var1 += this.unknownFields.getSerializedSize();
         this.memoizedSerializedSize = var1;
         return var1;
      }
   }

   public static BinExport$Callgraph$Vertex parseFrom(ByteString var0) {
      return (BinExport$Callgraph$Vertex)PARSER.parseFrom(var0);
   }

   public static BinExport$Callgraph$Vertex parseFrom(ByteString var0, ExtensionRegistryLite var1) {
      return (BinExport$Callgraph$Vertex)PARSER.parseFrom(var0, var1);
   }

   public static BinExport$Callgraph$Vertex parseFrom(byte[] var0) {
      return (BinExport$Callgraph$Vertex)PARSER.parseFrom(var0);
   }

   public static BinExport$Callgraph$Vertex parseFrom(byte[] var0, ExtensionRegistryLite var1) {
      return (BinExport$Callgraph$Vertex)PARSER.parseFrom(var0, var1);
   }

   public static BinExport$Callgraph$Vertex parseFrom(InputStream var0) {
      return (BinExport$Callgraph$Vertex)PARSER.parseFrom(var0);
   }

   public static BinExport$Callgraph$Vertex parseFrom(InputStream var0, ExtensionRegistryLite var1) {
      return (BinExport$Callgraph$Vertex)PARSER.parseFrom(var0, var1);
   }

   public static BinExport$Callgraph$Vertex parseDelimitedFrom(InputStream var0) {
      return (BinExport$Callgraph$Vertex)PARSER.parseDelimitedFrom(var0);
   }

   public static BinExport$Callgraph$Vertex parseDelimitedFrom(InputStream var0, ExtensionRegistryLite var1) {
      return (BinExport$Callgraph$Vertex)PARSER.parseDelimitedFrom(var0, var1);
   }

   public static BinExport$Callgraph$Vertex parseFrom(CodedInputStream var0) {
      return (BinExport$Callgraph$Vertex)PARSER.parseFrom(var0);
   }

   public static BinExport$Callgraph$Vertex parseFrom(CodedInputStream var0, ExtensionRegistryLite var1) {
      return (BinExport$Callgraph$Vertex)PARSER.parseFrom(var0, var1);
   }

   public BinExport$Callgraph$Vertex$Builder newBuilderForType() {
      return newBuilder();
   }

   public static BinExport$Callgraph$Vertex$Builder newBuilder() {
      return DEFAULT_INSTANCE.toBuilder();
   }

   public static BinExport$Callgraph$Vertex$Builder newBuilder(BinExport$Callgraph$Vertex var0) {
      return DEFAULT_INSTANCE.toBuilder().mergeFrom(var0);
   }

   public BinExport$Callgraph$Vertex$Builder toBuilder() {
      return this == DEFAULT_INSTANCE?new BinExport$Callgraph$Vertex$Builder((BinExport$1)null):(new BinExport$Callgraph$Vertex$Builder((BinExport$1)null)).mergeFrom(this);
   }

   protected BinExport$Callgraph$Vertex$Builder newBuilderForType(GeneratedMessage$BuilderParent var1) {
      BinExport$Callgraph$Vertex$Builder var2 = new BinExport$Callgraph$Vertex$Builder(var1, (BinExport$1)null);
      return var2;
   }

   public static BinExport$Callgraph$Vertex getDefaultInstance() {
      return DEFAULT_INSTANCE;
   }

   public Parser getParserForType() {
      return PARSER;
   }

   public BinExport$Callgraph$Vertex getDefaultInstanceForType() {
      return DEFAULT_INSTANCE;
   }

   // $FF: synthetic method
   static boolean access$2400() {
      return alwaysUseFieldBuilders;
   }

   // $FF: synthetic method
   BinExport$Callgraph$Vertex(GeneratedMessage$Builder var1, BinExport$1 var2) {
      this(var1);
   }

   // $FF: synthetic method
   static long access$2602(BinExport$Callgraph$Vertex var0, long var1) {
      return var0.address_ = var1;
   }

   // $FF: synthetic method
   static long access$2702(BinExport$Callgraph$Vertex var0, long var1) {
      return var0.prime_ = var1;
   }

   // $FF: synthetic method
   static int access$2802(BinExport$Callgraph$Vertex var0, int var1) {
      return var0.functionType_ = var1;
   }

   // $FF: synthetic method
   static boolean access$2902(BinExport$Callgraph$Vertex var0, boolean var1) {
      return var0.hasRealName_ = var1;
   }

   // $FF: synthetic method
   static Object access$3002(BinExport$Callgraph$Vertex var0, Object var1) {
      return var0.mangledName_ = var1;
   }

   // $FF: synthetic method
   static Object access$3102(BinExport$Callgraph$Vertex var0, Object var1) {
      return var0.demangledName_ = var1;
   }

   // $FF: synthetic method
   static int access$3202(BinExport$Callgraph$Vertex var0, int var1) {
      return var0.bitField0_ = var1;
   }

   // $FF: synthetic method
   static Object access$3000(BinExport$Callgraph$Vertex var0) {
      return var0.mangledName_;
   }

   // $FF: synthetic method
   static Object access$3100(BinExport$Callgraph$Vertex var0) {
      return var0.demangledName_;
   }

   // $FF: synthetic method
   static UnknownFieldSet access$3300(BinExport$Callgraph$Vertex var0) {
      return var0.unknownFields;
   }

   // $FF: synthetic method
   BinExport$Callgraph$Vertex(CodedInputStream var1, ExtensionRegistryLite var2, BinExport$1 var3) {
      this(var1, var2);
   }
}
