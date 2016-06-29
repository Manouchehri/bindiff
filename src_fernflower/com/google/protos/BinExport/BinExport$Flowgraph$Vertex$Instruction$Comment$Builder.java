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
import com.google.protos.BinExport.BinExport$Flowgraph$Vertex$Instruction$Comment;
import com.google.protos.BinExport.BinExport$Flowgraph$Vertex$Instruction$CommentOrBuilder;

public final class BinExport$Flowgraph$Vertex$Instruction$Comment$Builder extends GeneratedMessage$Builder implements BinExport$Flowgraph$Vertex$Instruction$CommentOrBuilder {
   private int bitField0_;
   private Object comment_;
   private int flags_;

   public static final Descriptors$Descriptor getDescriptor() {
      return BinExport.access$6300();
   }

   protected GeneratedMessage$FieldAccessorTable internalGetFieldAccessorTable() {
      return BinExport.access$6400().ensureFieldAccessorsInitialized(BinExport$Flowgraph$Vertex$Instruction$Comment.class, BinExport$Flowgraph$Vertex$Instruction$Comment$Builder.class);
   }

   private BinExport$Flowgraph$Vertex$Instruction$Comment$Builder() {
      this.comment_ = "";
      this.maybeForceBuilderInitialization();
   }

   private BinExport$Flowgraph$Vertex$Instruction$Comment$Builder(GeneratedMessage$BuilderParent var1) {
      super(var1);
      this.comment_ = "";
      this.maybeForceBuilderInitialization();
   }

   private void maybeForceBuilderInitialization() {
      if(BinExport$Flowgraph$Vertex$Instruction$Comment.access$6700()) {
         ;
      }

   }

   public BinExport$Flowgraph$Vertex$Instruction$Comment$Builder clear() {
      super.clear();
      this.comment_ = "";
      this.bitField0_ &= -2;
      this.flags_ = 0;
      this.bitField0_ &= -3;
      return this;
   }

   public Descriptors$Descriptor getDescriptorForType() {
      return BinExport.access$6300();
   }

   public BinExport$Flowgraph$Vertex$Instruction$Comment getDefaultInstanceForType() {
      return BinExport$Flowgraph$Vertex$Instruction$Comment.getDefaultInstance();
   }

   public BinExport$Flowgraph$Vertex$Instruction$Comment build() {
      BinExport$Flowgraph$Vertex$Instruction$Comment var1 = this.buildPartial();
      if(!var1.isInitialized()) {
         throw newUninitializedMessageException(var1);
      } else {
         return var1;
      }
   }

   public BinExport$Flowgraph$Vertex$Instruction$Comment buildPartial() {
      BinExport$Flowgraph$Vertex$Instruction$Comment var1 = new BinExport$Flowgraph$Vertex$Instruction$Comment(this, (BinExport$1)null);
      int var2 = this.bitField0_;
      int var3 = 0;
      if((var2 & 1) == 1) {
         var3 |= 1;
      }

      BinExport$Flowgraph$Vertex$Instruction$Comment.access$6902(var1, this.comment_);
      if((var2 & 2) == 2) {
         var3 |= 2;
      }

      BinExport$Flowgraph$Vertex$Instruction$Comment.access$7002(var1, this.flags_);
      BinExport$Flowgraph$Vertex$Instruction$Comment.access$7102(var1, var3);
      this.onBuilt();
      return var1;
   }

   public BinExport$Flowgraph$Vertex$Instruction$Comment$Builder mergeFrom(Message var1) {
      if(var1 instanceof BinExport$Flowgraph$Vertex$Instruction$Comment) {
         return this.mergeFrom((BinExport$Flowgraph$Vertex$Instruction$Comment)var1);
      } else {
         super.mergeFrom(var1);
         return this;
      }
   }

   public BinExport$Flowgraph$Vertex$Instruction$Comment$Builder mergeFrom(BinExport$Flowgraph$Vertex$Instruction$Comment var1) {
      if(var1 == BinExport$Flowgraph$Vertex$Instruction$Comment.getDefaultInstance()) {
         return this;
      } else {
         if(var1.hasComment()) {
            this.bitField0_ |= 1;
            this.comment_ = BinExport$Flowgraph$Vertex$Instruction$Comment.access$6900(var1);
            this.onChanged();
         }

         if(var1.hasFlags()) {
            this.setFlags(var1.getFlags());
         }

         this.mergeUnknownFields(BinExport$Flowgraph$Vertex$Instruction$Comment.access$7200(var1));
         this.onChanged();
         return this;
      }
   }

   public final boolean isInitialized() {
      return !this.hasComment()?false:this.hasFlags();
   }

   public BinExport$Flowgraph$Vertex$Instruction$Comment$Builder mergeFrom(CodedInputStream var1, ExtensionRegistryLite var2) {
      BinExport$Flowgraph$Vertex$Instruction$Comment var3 = null;

      try {
         var3 = (BinExport$Flowgraph$Vertex$Instruction$Comment)BinExport$Flowgraph$Vertex$Instruction$Comment.PARSER.parsePartialFrom(var1, var2);
      } catch (InvalidProtocolBufferException var8) {
         var3 = (BinExport$Flowgraph$Vertex$Instruction$Comment)var8.getUnfinishedMessage();
         throw var8;
      } finally {
         if(var3 != null) {
            this.mergeFrom(var3);
         }

      }

      return this;
   }

   public boolean hasComment() {
      return (this.bitField0_ & 1) == 1;
   }

   public String getComment() {
      Object var1 = this.comment_;
      if(!(var1 instanceof String)) {
         ByteString var2 = (ByteString)var1;
         String var3 = var2.toStringUtf8();
         if(var2.isValidUtf8()) {
            this.comment_ = var3;
         }

         return var3;
      } else {
         return (String)var1;
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

   public BinExport$Flowgraph$Vertex$Instruction$Comment$Builder setComment(String var1) {
      if(var1 == null) {
         throw new NullPointerException();
      } else {
         this.bitField0_ |= 1;
         this.comment_ = var1;
         this.onChanged();
         return this;
      }
   }

   public BinExport$Flowgraph$Vertex$Instruction$Comment$Builder clearComment() {
      this.bitField0_ &= -2;
      this.comment_ = BinExport$Flowgraph$Vertex$Instruction$Comment.getDefaultInstance().getComment();
      this.onChanged();
      return this;
   }

   public BinExport$Flowgraph$Vertex$Instruction$Comment$Builder setCommentBytes(ByteString var1) {
      if(var1 == null) {
         throw new NullPointerException();
      } else {
         this.bitField0_ |= 1;
         this.comment_ = var1;
         this.onChanged();
         return this;
      }
   }

   public boolean hasFlags() {
      return (this.bitField0_ & 2) == 2;
   }

   public int getFlags() {
      return this.flags_;
   }

   public BinExport$Flowgraph$Vertex$Instruction$Comment$Builder setFlags(int var1) {
      this.bitField0_ |= 2;
      this.flags_ = var1;
      this.onChanged();
      return this;
   }

   public BinExport$Flowgraph$Vertex$Instruction$Comment$Builder clearFlags() {
      this.bitField0_ &= -3;
      this.flags_ = 0;
      this.onChanged();
      return this;
   }

   // $FF: synthetic method
   BinExport$Flowgraph$Vertex$Instruction$Comment$Builder(BinExport$1 var1) {
      this();
   }

   // $FF: synthetic method
   BinExport$Flowgraph$Vertex$Instruction$Comment$Builder(GeneratedMessage$BuilderParent var1, BinExport$1 var2) {
      this(var1);
   }
}
