package com.google.protos.BinExport;

import com.google.protobuf.AbstractMessageLite$Builder;
import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.Descriptors$Descriptor;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessage$Builder;
import com.google.protobuf.GeneratedMessage$BuilderParent;
import com.google.protobuf.GeneratedMessage$FieldAccessorTable;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.Message;
import com.google.protobuf.RepeatedFieldBuilder;
import com.google.protos.BinExport.BinExport;
import com.google.protos.BinExport.BinExport$1;
import com.google.protos.BinExport.BinExport$Flowgraph$Vertex$Instruction;
import com.google.protos.BinExport.BinExport$Flowgraph$Vertex$Instruction$Comment;
import com.google.protos.BinExport.BinExport$Flowgraph$Vertex$Instruction$Comment$Builder;
import com.google.protos.BinExport.BinExport$Flowgraph$Vertex$Instruction$CommentOrBuilder;
import com.google.protos.BinExport.BinExport$Flowgraph$Vertex$InstructionOrBuilder;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class BinExport$Flowgraph$Vertex$Instruction$Builder extends GeneratedMessage$Builder implements BinExport$Flowgraph$Vertex$InstructionOrBuilder {
   private int bitField0_;
   private long address_;
   private int prime_;
   private int stringReference_;
   private Object mnemonic_;
   private Object operands_;
   private ByteString rawBytes_;
   private List callTargets_;
   private List comments_;
   private RepeatedFieldBuilder commentsBuilder_;

   public static final Descriptors$Descriptor getDescriptor() {
      return BinExport.access$6100();
   }

   protected GeneratedMessage$FieldAccessorTable internalGetFieldAccessorTable() {
      return BinExport.access$6200().ensureFieldAccessorsInitialized(BinExport$Flowgraph$Vertex$Instruction.class, BinExport$Flowgraph$Vertex$Instruction$Builder.class);
   }

   private BinExport$Flowgraph$Vertex$Instruction$Builder() {
      this.mnemonic_ = "";
      this.operands_ = "";
      this.rawBytes_ = ByteString.EMPTY;
      this.callTargets_ = Collections.emptyList();
      this.comments_ = Collections.emptyList();
      this.maybeForceBuilderInitialization();
   }

   private BinExport$Flowgraph$Vertex$Instruction$Builder(GeneratedMessage$BuilderParent var1) {
      super(var1);
      this.mnemonic_ = "";
      this.operands_ = "";
      this.rawBytes_ = ByteString.EMPTY;
      this.callTargets_ = Collections.emptyList();
      this.comments_ = Collections.emptyList();
      this.maybeForceBuilderInitialization();
   }

   private void maybeForceBuilderInitialization() {
      if(BinExport$Flowgraph$Vertex$Instruction.access$7600()) {
         this.getCommentsFieldBuilder();
      }

   }

   public BinExport$Flowgraph$Vertex$Instruction$Builder clear() {
      super.clear();
      this.address_ = 0L;
      this.bitField0_ &= -2;
      this.prime_ = 0;
      this.bitField0_ &= -3;
      this.stringReference_ = 0;
      this.bitField0_ &= -5;
      this.mnemonic_ = "";
      this.bitField0_ &= -9;
      this.operands_ = "";
      this.bitField0_ &= -17;
      this.rawBytes_ = ByteString.EMPTY;
      this.bitField0_ &= -33;
      this.callTargets_ = Collections.emptyList();
      this.bitField0_ &= -65;
      if(this.commentsBuilder_ == null) {
         this.comments_ = Collections.emptyList();
         this.bitField0_ &= -129;
      } else {
         this.commentsBuilder_.clear();
      }

      return this;
   }

   public Descriptors$Descriptor getDescriptorForType() {
      return BinExport.access$6100();
   }

   public BinExport$Flowgraph$Vertex$Instruction getDefaultInstanceForType() {
      return BinExport$Flowgraph$Vertex$Instruction.getDefaultInstance();
   }

   public BinExport$Flowgraph$Vertex$Instruction build() {
      BinExport$Flowgraph$Vertex$Instruction var1 = this.buildPartial();
      if(!var1.isInitialized()) {
         throw newUninitializedMessageException(var1);
      } else {
         return var1;
      }
   }

   public BinExport$Flowgraph$Vertex$Instruction buildPartial() {
      BinExport$Flowgraph$Vertex$Instruction var1 = new BinExport$Flowgraph$Vertex$Instruction(this, (BinExport$1)null);
      int var2 = this.bitField0_;
      int var3 = 0;
      if((var2 & 1) == 1) {
         var3 |= 1;
      }

      BinExport$Flowgraph$Vertex$Instruction.access$7802(var1, this.address_);
      if((var2 & 2) == 2) {
         var3 |= 2;
      }

      BinExport$Flowgraph$Vertex$Instruction.access$7902(var1, this.prime_);
      if((var2 & 4) == 4) {
         var3 |= 4;
      }

      BinExport$Flowgraph$Vertex$Instruction.access$8002(var1, this.stringReference_);
      if((var2 & 8) == 8) {
         var3 |= 8;
      }

      BinExport$Flowgraph$Vertex$Instruction.access$8102(var1, this.mnemonic_);
      if((var2 & 16) == 16) {
         var3 |= 16;
      }

      BinExport$Flowgraph$Vertex$Instruction.access$8202(var1, this.operands_);
      if((var2 & 32) == 32) {
         var3 |= 32;
      }

      BinExport$Flowgraph$Vertex$Instruction.access$8302(var1, this.rawBytes_);
      if((this.bitField0_ & 64) == 64) {
         this.callTargets_ = Collections.unmodifiableList(this.callTargets_);
         this.bitField0_ &= -65;
      }

      BinExport$Flowgraph$Vertex$Instruction.access$8402(var1, this.callTargets_);
      if(this.commentsBuilder_ == null) {
         if((this.bitField0_ & 128) == 128) {
            this.comments_ = Collections.unmodifiableList(this.comments_);
            this.bitField0_ &= -129;
         }

         BinExport$Flowgraph$Vertex$Instruction.access$8502(var1, this.comments_);
      } else {
         BinExport$Flowgraph$Vertex$Instruction.access$8502(var1, this.commentsBuilder_.build());
      }

      BinExport$Flowgraph$Vertex$Instruction.access$8602(var1, var3);
      this.onBuilt();
      return var1;
   }

   public BinExport$Flowgraph$Vertex$Instruction$Builder mergeFrom(Message var1) {
      if(var1 instanceof BinExport$Flowgraph$Vertex$Instruction) {
         return this.mergeFrom((BinExport$Flowgraph$Vertex$Instruction)var1);
      } else {
         super.mergeFrom(var1);
         return this;
      }
   }

   public BinExport$Flowgraph$Vertex$Instruction$Builder mergeFrom(BinExport$Flowgraph$Vertex$Instruction var1) {
      if(var1 == BinExport$Flowgraph$Vertex$Instruction.getDefaultInstance()) {
         return this;
      } else {
         if(var1.hasAddress()) {
            this.setAddress(var1.getAddress());
         }

         if(var1.hasPrime()) {
            this.setPrime(var1.getPrime());
         }

         if(var1.hasStringReference()) {
            this.setStringReference(var1.getStringReference());
         }

         if(var1.hasMnemonic()) {
            this.bitField0_ |= 8;
            this.mnemonic_ = BinExport$Flowgraph$Vertex$Instruction.access$8100(var1);
            this.onChanged();
         }

         if(var1.hasOperands()) {
            this.bitField0_ |= 16;
            this.operands_ = BinExport$Flowgraph$Vertex$Instruction.access$8200(var1);
            this.onChanged();
         }

         if(var1.hasRawBytes()) {
            this.setRawBytes(var1.getRawBytes());
         }

         if(!BinExport$Flowgraph$Vertex$Instruction.access$8400(var1).isEmpty()) {
            if(this.callTargets_.isEmpty()) {
               this.callTargets_ = BinExport$Flowgraph$Vertex$Instruction.access$8400(var1);
               this.bitField0_ &= -65;
            } else {
               this.ensureCallTargetsIsMutable();
               this.callTargets_.addAll(BinExport$Flowgraph$Vertex$Instruction.access$8400(var1));
            }

            this.onChanged();
         }

         if(this.commentsBuilder_ == null) {
            if(!BinExport$Flowgraph$Vertex$Instruction.access$8500(var1).isEmpty()) {
               if(this.comments_.isEmpty()) {
                  this.comments_ = BinExport$Flowgraph$Vertex$Instruction.access$8500(var1);
                  this.bitField0_ &= -129;
               } else {
                  this.ensureCommentsIsMutable();
                  this.comments_.addAll(BinExport$Flowgraph$Vertex$Instruction.access$8500(var1));
               }

               this.onChanged();
            }
         } else if(!BinExport$Flowgraph$Vertex$Instruction.access$8500(var1).isEmpty()) {
            if(this.commentsBuilder_.isEmpty()) {
               this.commentsBuilder_.dispose();
               this.commentsBuilder_ = null;
               this.comments_ = BinExport$Flowgraph$Vertex$Instruction.access$8500(var1);
               this.bitField0_ &= -129;
               this.commentsBuilder_ = BinExport$Flowgraph$Vertex$Instruction.access$8700()?this.getCommentsFieldBuilder():null;
            } else {
               this.commentsBuilder_.addAllMessages(BinExport$Flowgraph$Vertex$Instruction.access$8500(var1));
            }
         }

         this.mergeUnknownFields(BinExport$Flowgraph$Vertex$Instruction.access$8800(var1));
         this.onChanged();
         return this;
      }
   }

   public final boolean isInitialized() {
      if(!this.hasAddress()) {
         return false;
      } else if(!this.hasPrime()) {
         return false;
      } else {
         for(int var1 = 0; var1 < this.getCommentsCount(); ++var1) {
            if(!this.getComments(var1).isInitialized()) {
               return false;
            }
         }

         return true;
      }
   }

   public BinExport$Flowgraph$Vertex$Instruction$Builder mergeFrom(CodedInputStream var1, ExtensionRegistryLite var2) {
      BinExport$Flowgraph$Vertex$Instruction var3 = null;

      try {
         var3 = (BinExport$Flowgraph$Vertex$Instruction)BinExport$Flowgraph$Vertex$Instruction.PARSER.parsePartialFrom(var1, var2);
      } catch (InvalidProtocolBufferException var8) {
         var3 = (BinExport$Flowgraph$Vertex$Instruction)var8.getUnfinishedMessage();
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

   public BinExport$Flowgraph$Vertex$Instruction$Builder setAddress(long var1) {
      this.bitField0_ |= 1;
      this.address_ = var1;
      this.onChanged();
      return this;
   }

   public BinExport$Flowgraph$Vertex$Instruction$Builder clearAddress() {
      this.bitField0_ &= -2;
      this.address_ = 0L;
      this.onChanged();
      return this;
   }

   public boolean hasPrime() {
      return (this.bitField0_ & 2) == 2;
   }

   public int getPrime() {
      return this.prime_;
   }

   public BinExport$Flowgraph$Vertex$Instruction$Builder setPrime(int var1) {
      this.bitField0_ |= 2;
      this.prime_ = var1;
      this.onChanged();
      return this;
   }

   public BinExport$Flowgraph$Vertex$Instruction$Builder clearPrime() {
      this.bitField0_ &= -3;
      this.prime_ = 0;
      this.onChanged();
      return this;
   }

   public boolean hasStringReference() {
      return (this.bitField0_ & 4) == 4;
   }

   public int getStringReference() {
      return this.stringReference_;
   }

   public BinExport$Flowgraph$Vertex$Instruction$Builder setStringReference(int var1) {
      this.bitField0_ |= 4;
      this.stringReference_ = var1;
      this.onChanged();
      return this;
   }

   public BinExport$Flowgraph$Vertex$Instruction$Builder clearStringReference() {
      this.bitField0_ &= -5;
      this.stringReference_ = 0;
      this.onChanged();
      return this;
   }

   public boolean hasMnemonic() {
      return (this.bitField0_ & 8) == 8;
   }

   public String getMnemonic() {
      Object var1 = this.mnemonic_;
      if(!(var1 instanceof String)) {
         ByteString var2 = (ByteString)var1;
         String var3 = var2.toStringUtf8();
         if(var2.isValidUtf8()) {
            this.mnemonic_ = var3;
         }

         return var3;
      } else {
         return (String)var1;
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

   public BinExport$Flowgraph$Vertex$Instruction$Builder setMnemonic(String var1) {
      if(var1 == null) {
         throw new NullPointerException();
      } else {
         this.bitField0_ |= 8;
         this.mnemonic_ = var1;
         this.onChanged();
         return this;
      }
   }

   public BinExport$Flowgraph$Vertex$Instruction$Builder clearMnemonic() {
      this.bitField0_ &= -9;
      this.mnemonic_ = BinExport$Flowgraph$Vertex$Instruction.getDefaultInstance().getMnemonic();
      this.onChanged();
      return this;
   }

   public BinExport$Flowgraph$Vertex$Instruction$Builder setMnemonicBytes(ByteString var1) {
      if(var1 == null) {
         throw new NullPointerException();
      } else {
         this.bitField0_ |= 8;
         this.mnemonic_ = var1;
         this.onChanged();
         return this;
      }
   }

   public boolean hasOperands() {
      return (this.bitField0_ & 16) == 16;
   }

   public String getOperands() {
      Object var1 = this.operands_;
      if(!(var1 instanceof String)) {
         ByteString var2 = (ByteString)var1;
         String var3 = var2.toStringUtf8();
         if(var2.isValidUtf8()) {
            this.operands_ = var3;
         }

         return var3;
      } else {
         return (String)var1;
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

   public BinExport$Flowgraph$Vertex$Instruction$Builder setOperands(String var1) {
      if(var1 == null) {
         throw new NullPointerException();
      } else {
         this.bitField0_ |= 16;
         this.operands_ = var1;
         this.onChanged();
         return this;
      }
   }

   public BinExport$Flowgraph$Vertex$Instruction$Builder clearOperands() {
      this.bitField0_ &= -17;
      this.operands_ = BinExport$Flowgraph$Vertex$Instruction.getDefaultInstance().getOperands();
      this.onChanged();
      return this;
   }

   public BinExport$Flowgraph$Vertex$Instruction$Builder setOperandsBytes(ByteString var1) {
      if(var1 == null) {
         throw new NullPointerException();
      } else {
         this.bitField0_ |= 16;
         this.operands_ = var1;
         this.onChanged();
         return this;
      }
   }

   public boolean hasRawBytes() {
      return (this.bitField0_ & 32) == 32;
   }

   public ByteString getRawBytes() {
      return this.rawBytes_;
   }

   public BinExport$Flowgraph$Vertex$Instruction$Builder setRawBytes(ByteString var1) {
      if(var1 == null) {
         throw new NullPointerException();
      } else {
         this.bitField0_ |= 32;
         this.rawBytes_ = var1;
         this.onChanged();
         return this;
      }
   }

   public BinExport$Flowgraph$Vertex$Instruction$Builder clearRawBytes() {
      this.bitField0_ &= -33;
      this.rawBytes_ = BinExport$Flowgraph$Vertex$Instruction.getDefaultInstance().getRawBytes();
      this.onChanged();
      return this;
   }

   private void ensureCallTargetsIsMutable() {
      if((this.bitField0_ & 64) != 64) {
         this.callTargets_ = new ArrayList(this.callTargets_);
         this.bitField0_ |= 64;
      }

   }

   public List getCallTargetsList() {
      return Collections.unmodifiableList(this.callTargets_);
   }

   public int getCallTargetsCount() {
      return this.callTargets_.size();
   }

   public long getCallTargets(int var1) {
      return ((Long)this.callTargets_.get(var1)).longValue();
   }

   public BinExport$Flowgraph$Vertex$Instruction$Builder setCallTargets(int var1, long var2) {
      this.ensureCallTargetsIsMutable();
      this.callTargets_.set(var1, Long.valueOf(var2));
      this.onChanged();
      return this;
   }

   public BinExport$Flowgraph$Vertex$Instruction$Builder addCallTargets(long var1) {
      this.ensureCallTargetsIsMutable();
      this.callTargets_.add(Long.valueOf(var1));
      this.onChanged();
      return this;
   }

   public BinExport$Flowgraph$Vertex$Instruction$Builder addAllCallTargets(Iterable var1) {
      this.ensureCallTargetsIsMutable();
      AbstractMessageLite$Builder.addAll(var1, this.callTargets_);
      this.onChanged();
      return this;
   }

   public BinExport$Flowgraph$Vertex$Instruction$Builder clearCallTargets() {
      this.callTargets_ = Collections.emptyList();
      this.bitField0_ &= -65;
      this.onChanged();
      return this;
   }

   private void ensureCommentsIsMutable() {
      if((this.bitField0_ & 128) != 128) {
         this.comments_ = new ArrayList(this.comments_);
         this.bitField0_ |= 128;
      }

   }

   public List getCommentsList() {
      return this.commentsBuilder_ == null?Collections.unmodifiableList(this.comments_):this.commentsBuilder_.getMessageList();
   }

   public int getCommentsCount() {
      return this.commentsBuilder_ == null?this.comments_.size():this.commentsBuilder_.getCount();
   }

   public BinExport$Flowgraph$Vertex$Instruction$Comment getComments(int var1) {
      return this.commentsBuilder_ == null?(BinExport$Flowgraph$Vertex$Instruction$Comment)this.comments_.get(var1):(BinExport$Flowgraph$Vertex$Instruction$Comment)this.commentsBuilder_.getMessage(var1);
   }

   public BinExport$Flowgraph$Vertex$Instruction$Builder setComments(int var1, BinExport$Flowgraph$Vertex$Instruction$Comment var2) {
      if(this.commentsBuilder_ == null) {
         if(var2 == null) {
            throw new NullPointerException();
         }

         this.ensureCommentsIsMutable();
         this.comments_.set(var1, var2);
         this.onChanged();
      } else {
         this.commentsBuilder_.setMessage(var1, var2);
      }

      return this;
   }

   public BinExport$Flowgraph$Vertex$Instruction$Builder setComments(int var1, BinExport$Flowgraph$Vertex$Instruction$Comment$Builder var2) {
      if(this.commentsBuilder_ == null) {
         this.ensureCommentsIsMutable();
         this.comments_.set(var1, var2.build());
         this.onChanged();
      } else {
         this.commentsBuilder_.setMessage(var1, var2.build());
      }

      return this;
   }

   public BinExport$Flowgraph$Vertex$Instruction$Builder addComments(BinExport$Flowgraph$Vertex$Instruction$Comment var1) {
      if(this.commentsBuilder_ == null) {
         if(var1 == null) {
            throw new NullPointerException();
         }

         this.ensureCommentsIsMutable();
         this.comments_.add(var1);
         this.onChanged();
      } else {
         this.commentsBuilder_.addMessage(var1);
      }

      return this;
   }

   public BinExport$Flowgraph$Vertex$Instruction$Builder addComments(int var1, BinExport$Flowgraph$Vertex$Instruction$Comment var2) {
      if(this.commentsBuilder_ == null) {
         if(var2 == null) {
            throw new NullPointerException();
         }

         this.ensureCommentsIsMutable();
         this.comments_.add(var1, var2);
         this.onChanged();
      } else {
         this.commentsBuilder_.addMessage(var1, var2);
      }

      return this;
   }

   public BinExport$Flowgraph$Vertex$Instruction$Builder addComments(BinExport$Flowgraph$Vertex$Instruction$Comment$Builder var1) {
      if(this.commentsBuilder_ == null) {
         this.ensureCommentsIsMutable();
         this.comments_.add(var1.build());
         this.onChanged();
      } else {
         this.commentsBuilder_.addMessage(var1.build());
      }

      return this;
   }

   public BinExport$Flowgraph$Vertex$Instruction$Builder addComments(int var1, BinExport$Flowgraph$Vertex$Instruction$Comment$Builder var2) {
      if(this.commentsBuilder_ == null) {
         this.ensureCommentsIsMutable();
         this.comments_.add(var1, var2.build());
         this.onChanged();
      } else {
         this.commentsBuilder_.addMessage(var1, var2.build());
      }

      return this;
   }

   public BinExport$Flowgraph$Vertex$Instruction$Builder addAllComments(Iterable var1) {
      if(this.commentsBuilder_ == null) {
         this.ensureCommentsIsMutable();
         AbstractMessageLite$Builder.addAll(var1, this.comments_);
         this.onChanged();
      } else {
         this.commentsBuilder_.addAllMessages(var1);
      }

      return this;
   }

   public BinExport$Flowgraph$Vertex$Instruction$Builder clearComments() {
      if(this.commentsBuilder_ == null) {
         this.comments_ = Collections.emptyList();
         this.bitField0_ &= -129;
         this.onChanged();
      } else {
         this.commentsBuilder_.clear();
      }

      return this;
   }

   public BinExport$Flowgraph$Vertex$Instruction$Builder removeComments(int var1) {
      if(this.commentsBuilder_ == null) {
         this.ensureCommentsIsMutable();
         this.comments_.remove(var1);
         this.onChanged();
      } else {
         this.commentsBuilder_.remove(var1);
      }

      return this;
   }

   public BinExport$Flowgraph$Vertex$Instruction$Comment$Builder getCommentsBuilder(int var1) {
      return (BinExport$Flowgraph$Vertex$Instruction$Comment$Builder)this.getCommentsFieldBuilder().getBuilder(var1);
   }

   public BinExport$Flowgraph$Vertex$Instruction$CommentOrBuilder getCommentsOrBuilder(int var1) {
      return this.commentsBuilder_ == null?(BinExport$Flowgraph$Vertex$Instruction$CommentOrBuilder)this.comments_.get(var1):(BinExport$Flowgraph$Vertex$Instruction$CommentOrBuilder)this.commentsBuilder_.getMessageOrBuilder(var1);
   }

   public List getCommentsOrBuilderList() {
      return this.commentsBuilder_ != null?this.commentsBuilder_.getMessageOrBuilderList():Collections.unmodifiableList(this.comments_);
   }

   public BinExport$Flowgraph$Vertex$Instruction$Comment$Builder addCommentsBuilder() {
      return (BinExport$Flowgraph$Vertex$Instruction$Comment$Builder)this.getCommentsFieldBuilder().addBuilder(BinExport$Flowgraph$Vertex$Instruction$Comment.getDefaultInstance());
   }

   public BinExport$Flowgraph$Vertex$Instruction$Comment$Builder addCommentsBuilder(int var1) {
      return (BinExport$Flowgraph$Vertex$Instruction$Comment$Builder)this.getCommentsFieldBuilder().addBuilder(var1, BinExport$Flowgraph$Vertex$Instruction$Comment.getDefaultInstance());
   }

   public List getCommentsBuilderList() {
      return this.getCommentsFieldBuilder().getBuilderList();
   }

   private RepeatedFieldBuilder getCommentsFieldBuilder() {
      if(this.commentsBuilder_ == null) {
         this.commentsBuilder_ = new RepeatedFieldBuilder(this.comments_, (this.bitField0_ & 128) == 128, this.getParentForChildren(), this.isClean());
         this.comments_ = null;
      }

      return this.commentsBuilder_;
   }

   // $FF: synthetic method
   BinExport$Flowgraph$Vertex$Instruction$Builder(BinExport$1 var1) {
      this();
   }

   // $FF: synthetic method
   BinExport$Flowgraph$Vertex$Instruction$Builder(GeneratedMessage$BuilderParent var1, BinExport$1 var2) {
      this(var1);
   }
}
