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
import com.google.protos.BinExport.BinExport$Flowgraph$Vertex$Instruction$Comment$1;
import com.google.protos.BinExport.BinExport$Flowgraph$Vertex$Instruction$Comment$Builder;
import com.google.protos.BinExport.BinExport$Flowgraph$Vertex$Instruction$CommentOrBuilder;
import java.io.IOException;
import java.io.InputStream;

public final class BinExport$Flowgraph$Vertex$Instruction$Comment extends GeneratedMessage implements BinExport$Flowgraph$Vertex$Instruction$CommentOrBuilder {
   private int bitField0_;
   public static final int COMMENT_FIELD_NUMBER = 1;
   private volatile Object comment_;
   public static final int FLAGS_FIELD_NUMBER = 2;
   private int flags_;
   private byte memoizedIsInitialized;
   private int memoizedSerializedSize;
   private static final long serialVersionUID = 0L;
   private static final BinExport$Flowgraph$Vertex$Instruction$Comment DEFAULT_INSTANCE = new BinExport$Flowgraph$Vertex$Instruction$Comment();
   public static final Parser PARSER = new BinExport$Flowgraph$Vertex$Instruction$Comment$1();

   private BinExport$Flowgraph$Vertex$Instruction$Comment(GeneratedMessage$Builder var1) {
      super(var1);
      this.memoizedIsInitialized = -1;
      this.memoizedSerializedSize = -1;
   }

   private BinExport$Flowgraph$Vertex$Instruction$Comment() {
      this.memoizedIsInitialized = -1;
      this.memoizedSerializedSize = -1;
      this.comment_ = "";
      this.flags_ = 0;
   }

   public final UnknownFieldSet getUnknownFields() {
      return this.unknownFields;
   }

   private BinExport$Flowgraph$Vertex$Instruction$Comment(CodedInputStream var1, ExtensionRegistryLite var2) {
      this();
      boolean var3 = false;
      UnknownFieldSet$Builder var4 = UnknownFieldSet.newBuilder();

      try {
         boolean var5 = false;

         while(!var5) {
            int var6 = var1.readTag();
            switch(var6) {
            case 0:
               var5 = true;
               break;
            case 10:
               ByteString var7 = var1.readBytes();
               this.bitField0_ |= 1;
               this.comment_ = var7;
               break;
            case 16:
               this.bitField0_ |= 2;
               this.flags_ = var1.readUInt32();
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
      return BinExport.access$6300();
   }

   protected GeneratedMessage$FieldAccessorTable internalGetFieldAccessorTable() {
      return BinExport.access$6400().ensureFieldAccessorsInitialized(BinExport$Flowgraph$Vertex$Instruction$Comment.class, BinExport$Flowgraph$Vertex$Instruction$Comment$Builder.class);
   }

   public boolean hasComment() {
      return (this.bitField0_ & 1) == 1;
   }

   public String getComment() {
      Object var1 = this.comment_;
      if(var1 instanceof String) {
         return (String)var1;
      } else {
         ByteString var2 = (ByteString)var1;
         String var3 = var2.toStringUtf8();
         if(var2.isValidUtf8()) {
            this.comment_ = var3;
         }

         return var3;
      }
   }

   public ByteString getCommentBytes() {
      Object var1 = this.comment_;
      if(var1 instanceof String) {
         ByteString var2 = ByteString.copyFromUtf8((String)var1);
         this.comment_ = var2;
         return var2;
      } else {
         return (ByteString)var1;
      }
   }

   public boolean hasFlags() {
      return (this.bitField0_ & 2) == 2;
   }

   public int getFlags() {
      return this.flags_;
   }

   public final boolean isInitialized() {
      byte var1 = this.memoizedIsInitialized;
      if(var1 == 1) {
         return true;
      } else if(var1 == 0) {
         return false;
      } else if(!this.hasComment()) {
         this.memoizedIsInitialized = 0;
         return false;
      } else if(!this.hasFlags()) {
         this.memoizedIsInitialized = 0;
         return false;
      } else {
         this.memoizedIsInitialized = 1;
         return true;
      }
   }

   public void writeTo(CodedOutputStream var1) {
      if((this.bitField0_ & 1) == 1) {
         var1.writeBytes(1, this.getCommentBytes());
      }

      if((this.bitField0_ & 2) == 2) {
         var1.writeUInt32(2, this.flags_);
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
            var1 += CodedOutputStream.computeBytesSize(1, this.getCommentBytes());
         }

         if((this.bitField0_ & 2) == 2) {
            var1 += CodedOutputStream.computeUInt32Size(2, this.flags_);
         }

         var1 += this.unknownFields.getSerializedSize();
         this.memoizedSerializedSize = var1;
         return var1;
      }
   }

   public static BinExport$Flowgraph$Vertex$Instruction$Comment parseFrom(ByteString var0) {
      return (BinExport$Flowgraph$Vertex$Instruction$Comment)PARSER.parseFrom(var0);
   }

   public static BinExport$Flowgraph$Vertex$Instruction$Comment parseFrom(ByteString var0, ExtensionRegistryLite var1) {
      return (BinExport$Flowgraph$Vertex$Instruction$Comment)PARSER.parseFrom(var0, var1);
   }

   public static BinExport$Flowgraph$Vertex$Instruction$Comment parseFrom(byte[] var0) {
      return (BinExport$Flowgraph$Vertex$Instruction$Comment)PARSER.parseFrom(var0);
   }

   public static BinExport$Flowgraph$Vertex$Instruction$Comment parseFrom(byte[] var0, ExtensionRegistryLite var1) {
      return (BinExport$Flowgraph$Vertex$Instruction$Comment)PARSER.parseFrom(var0, var1);
   }

   public static BinExport$Flowgraph$Vertex$Instruction$Comment parseFrom(InputStream var0) {
      return (BinExport$Flowgraph$Vertex$Instruction$Comment)PARSER.parseFrom(var0);
   }

   public static BinExport$Flowgraph$Vertex$Instruction$Comment parseFrom(InputStream var0, ExtensionRegistryLite var1) {
      return (BinExport$Flowgraph$Vertex$Instruction$Comment)PARSER.parseFrom(var0, var1);
   }

   public static BinExport$Flowgraph$Vertex$Instruction$Comment parseDelimitedFrom(InputStream var0) {
      return (BinExport$Flowgraph$Vertex$Instruction$Comment)PARSER.parseDelimitedFrom(var0);
   }

   public static BinExport$Flowgraph$Vertex$Instruction$Comment parseDelimitedFrom(InputStream var0, ExtensionRegistryLite var1) {
      return (BinExport$Flowgraph$Vertex$Instruction$Comment)PARSER.parseDelimitedFrom(var0, var1);
   }

   public static BinExport$Flowgraph$Vertex$Instruction$Comment parseFrom(CodedInputStream var0) {
      return (BinExport$Flowgraph$Vertex$Instruction$Comment)PARSER.parseFrom(var0);
   }

   public static BinExport$Flowgraph$Vertex$Instruction$Comment parseFrom(CodedInputStream var0, ExtensionRegistryLite var1) {
      return (BinExport$Flowgraph$Vertex$Instruction$Comment)PARSER.parseFrom(var0, var1);
   }

   public BinExport$Flowgraph$Vertex$Instruction$Comment$Builder newBuilderForType() {
      return newBuilder();
   }

   public static BinExport$Flowgraph$Vertex$Instruction$Comment$Builder newBuilder() {
      return DEFAULT_INSTANCE.toBuilder();
   }

   public static BinExport$Flowgraph$Vertex$Instruction$Comment$Builder newBuilder(BinExport$Flowgraph$Vertex$Instruction$Comment var0) {
      return DEFAULT_INSTANCE.toBuilder().mergeFrom(var0);
   }

   public BinExport$Flowgraph$Vertex$Instruction$Comment$Builder toBuilder() {
      return this == DEFAULT_INSTANCE?new BinExport$Flowgraph$Vertex$Instruction$Comment$Builder((BinExport$1)null):(new BinExport$Flowgraph$Vertex$Instruction$Comment$Builder((BinExport$1)null)).mergeFrom(this);
   }

   protected BinExport$Flowgraph$Vertex$Instruction$Comment$Builder newBuilderForType(GeneratedMessage$BuilderParent var1) {
      BinExport$Flowgraph$Vertex$Instruction$Comment$Builder var2 = new BinExport$Flowgraph$Vertex$Instruction$Comment$Builder(var1, (BinExport$1)null);
      return var2;
   }

   public static BinExport$Flowgraph$Vertex$Instruction$Comment getDefaultInstance() {
      return DEFAULT_INSTANCE;
   }

   public Parser getParserForType() {
      return PARSER;
   }

   public BinExport$Flowgraph$Vertex$Instruction$Comment getDefaultInstanceForType() {
      return DEFAULT_INSTANCE;
   }

   // $FF: synthetic method
   static boolean access$6700() {
      return alwaysUseFieldBuilders;
   }

   // $FF: synthetic method
   BinExport$Flowgraph$Vertex$Instruction$Comment(GeneratedMessage$Builder var1, BinExport$1 var2) {
      this(var1);
   }

   // $FF: synthetic method
   static Object access$6902(BinExport$Flowgraph$Vertex$Instruction$Comment var0, Object var1) {
      return var0.comment_ = var1;
   }

   // $FF: synthetic method
   static int access$7002(BinExport$Flowgraph$Vertex$Instruction$Comment var0, int var1) {
      return var0.flags_ = var1;
   }

   // $FF: synthetic method
   static int access$7102(BinExport$Flowgraph$Vertex$Instruction$Comment var0, int var1) {
      return var0.bitField0_ = var1;
   }

   // $FF: synthetic method
   static Object access$6900(BinExport$Flowgraph$Vertex$Instruction$Comment var0) {
      return var0.comment_;
   }

   // $FF: synthetic method
   static UnknownFieldSet access$7200(BinExport$Flowgraph$Vertex$Instruction$Comment var0) {
      return var0.unknownFields;
   }

   // $FF: synthetic method
   BinExport$Flowgraph$Vertex$Instruction$Comment(CodedInputStream var1, ExtensionRegistryLite var2, BinExport$1 var3) {
      this(var1, var2);
   }
}
