package com.google.protos.BinExport;

import com.google.protobuf.AbstractMessageLite$Builder;
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
import com.google.protos.BinExport.BinExport$Flowgraph$Vertex;
import com.google.protos.BinExport.BinExport$Flowgraph$Vertex$Instruction;
import com.google.protos.BinExport.BinExport$Flowgraph$Vertex$Instruction$Builder;
import com.google.protos.BinExport.BinExport$Flowgraph$Vertex$InstructionOrBuilder;
import com.google.protos.BinExport.BinExport$Flowgraph$VertexOrBuilder;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class BinExport$Flowgraph$Vertex$Builder extends GeneratedMessage$Builder implements BinExport$Flowgraph$VertexOrBuilder {
   private int bitField0_;
   private long prime_;
   private List instructions_;
   private RepeatedFieldBuilder instructionsBuilder_;

   public static final Descriptors$Descriptor getDescriptor() {
      return BinExport.access$5900();
   }

   protected GeneratedMessage$FieldAccessorTable internalGetFieldAccessorTable() {
      return BinExport.access$6000().ensureFieldAccessorsInitialized(BinExport$Flowgraph$Vertex.class, BinExport$Flowgraph$Vertex$Builder.class);
   }

   private BinExport$Flowgraph$Vertex$Builder() {
      this.instructions_ = Collections.emptyList();
      this.maybeForceBuilderInitialization();
   }

   private BinExport$Flowgraph$Vertex$Builder(GeneratedMessage$BuilderParent var1) {
      super(var1);
      this.instructions_ = Collections.emptyList();
      this.maybeForceBuilderInitialization();
   }

   private void maybeForceBuilderInitialization() {
      if(BinExport$Flowgraph$Vertex.access$9200()) {
         this.getInstructionsFieldBuilder();
      }

   }

   public BinExport$Flowgraph$Vertex$Builder clear() {
      super.clear();
      this.prime_ = 0L;
      this.bitField0_ &= -2;
      if(this.instructionsBuilder_ == null) {
         this.instructions_ = Collections.emptyList();
         this.bitField0_ &= -3;
      } else {
         this.instructionsBuilder_.clear();
      }

      return this;
   }

   public Descriptors$Descriptor getDescriptorForType() {
      return BinExport.access$5900();
   }

   public BinExport$Flowgraph$Vertex getDefaultInstanceForType() {
      return BinExport$Flowgraph$Vertex.getDefaultInstance();
   }

   public BinExport$Flowgraph$Vertex build() {
      BinExport$Flowgraph$Vertex var1 = this.buildPartial();
      if(!var1.isInitialized()) {
         throw newUninitializedMessageException(var1);
      } else {
         return var1;
      }
   }

   public BinExport$Flowgraph$Vertex buildPartial() {
      BinExport$Flowgraph$Vertex var1 = new BinExport$Flowgraph$Vertex(this, (BinExport$1)null);
      int var2 = this.bitField0_;
      int var3 = 0;
      if((var2 & 1) == 1) {
         var3 |= 1;
      }

      BinExport$Flowgraph$Vertex.access$9402(var1, this.prime_);
      if(this.instructionsBuilder_ == null) {
         if((this.bitField0_ & 2) == 2) {
            this.instructions_ = Collections.unmodifiableList(this.instructions_);
            this.bitField0_ &= -3;
         }

         BinExport$Flowgraph$Vertex.access$9502(var1, this.instructions_);
      } else {
         BinExport$Flowgraph$Vertex.access$9502(var1, this.instructionsBuilder_.build());
      }

      BinExport$Flowgraph$Vertex.access$9602(var1, var3);
      this.onBuilt();
      return var1;
   }

   public BinExport$Flowgraph$Vertex$Builder mergeFrom(Message var1) {
      if(var1 instanceof BinExport$Flowgraph$Vertex) {
         return this.mergeFrom((BinExport$Flowgraph$Vertex)var1);
      } else {
         super.mergeFrom(var1);
         return this;
      }
   }

   public BinExport$Flowgraph$Vertex$Builder mergeFrom(BinExport$Flowgraph$Vertex var1) {
      if(var1 == BinExport$Flowgraph$Vertex.getDefaultInstance()) {
         return this;
      } else {
         if(var1.hasPrime()) {
            this.setPrime(var1.getPrime());
         }

         if(this.instructionsBuilder_ == null) {
            if(!BinExport$Flowgraph$Vertex.access$9500(var1).isEmpty()) {
               if(this.instructions_.isEmpty()) {
                  this.instructions_ = BinExport$Flowgraph$Vertex.access$9500(var1);
                  this.bitField0_ &= -3;
               } else {
                  this.ensureInstructionsIsMutable();
                  this.instructions_.addAll(BinExport$Flowgraph$Vertex.access$9500(var1));
               }

               this.onChanged();
            }
         } else if(!BinExport$Flowgraph$Vertex.access$9500(var1).isEmpty()) {
            if(this.instructionsBuilder_.isEmpty()) {
               this.instructionsBuilder_.dispose();
               this.instructionsBuilder_ = null;
               this.instructions_ = BinExport$Flowgraph$Vertex.access$9500(var1);
               this.bitField0_ &= -3;
               this.instructionsBuilder_ = BinExport$Flowgraph$Vertex.access$9700()?this.getInstructionsFieldBuilder():null;
            } else {
               this.instructionsBuilder_.addAllMessages(BinExport$Flowgraph$Vertex.access$9500(var1));
            }
         }

         this.mergeUnknownFields(BinExport$Flowgraph$Vertex.access$9800(var1));
         this.onChanged();
         return this;
      }
   }

   public final boolean isInitialized() {
      if(!this.hasPrime()) {
         return false;
      } else {
         for(int var1 = 0; var1 < this.getInstructionsCount(); ++var1) {
            if(!this.getInstructions(var1).isInitialized()) {
               return false;
            }
         }

         return true;
      }
   }

   public BinExport$Flowgraph$Vertex$Builder mergeFrom(CodedInputStream var1, ExtensionRegistryLite var2) {
      BinExport$Flowgraph$Vertex var3 = null;

      try {
         var3 = (BinExport$Flowgraph$Vertex)BinExport$Flowgraph$Vertex.PARSER.parsePartialFrom(var1, var2);
      } catch (InvalidProtocolBufferException var8) {
         var3 = (BinExport$Flowgraph$Vertex)var8.getUnfinishedMessage();
         throw var8;
      } finally {
         if(var3 != null) {
            this.mergeFrom(var3);
         }

      }

      return this;
   }

   public boolean hasPrime() {
      return (this.bitField0_ & 1) == 1;
   }

   public long getPrime() {
      return this.prime_;
   }

   public BinExport$Flowgraph$Vertex$Builder setPrime(long var1) {
      this.bitField0_ |= 1;
      this.prime_ = var1;
      this.onChanged();
      return this;
   }

   public BinExport$Flowgraph$Vertex$Builder clearPrime() {
      this.bitField0_ &= -2;
      this.prime_ = 0L;
      this.onChanged();
      return this;
   }

   private void ensureInstructionsIsMutable() {
      if((this.bitField0_ & 2) != 2) {
         this.instructions_ = new ArrayList(this.instructions_);
         this.bitField0_ |= 2;
      }

   }

   public List getInstructionsList() {
      return this.instructionsBuilder_ == null?Collections.unmodifiableList(this.instructions_):this.instructionsBuilder_.getMessageList();
   }

   public int getInstructionsCount() {
      return this.instructionsBuilder_ == null?this.instructions_.size():this.instructionsBuilder_.getCount();
   }

   public BinExport$Flowgraph$Vertex$Instruction getInstructions(int var1) {
      return this.instructionsBuilder_ == null?(BinExport$Flowgraph$Vertex$Instruction)this.instructions_.get(var1):(BinExport$Flowgraph$Vertex$Instruction)this.instructionsBuilder_.getMessage(var1);
   }

   public BinExport$Flowgraph$Vertex$Builder setInstructions(int var1, BinExport$Flowgraph$Vertex$Instruction var2) {
      if(this.instructionsBuilder_ == null) {
         if(var2 == null) {
            throw new NullPointerException();
         }

         this.ensureInstructionsIsMutable();
         this.instructions_.set(var1, var2);
         this.onChanged();
      } else {
         this.instructionsBuilder_.setMessage(var1, var2);
      }

      return this;
   }

   public BinExport$Flowgraph$Vertex$Builder setInstructions(int var1, BinExport$Flowgraph$Vertex$Instruction$Builder var2) {
      if(this.instructionsBuilder_ == null) {
         this.ensureInstructionsIsMutable();
         this.instructions_.set(var1, var2.build());
         this.onChanged();
      } else {
         this.instructionsBuilder_.setMessage(var1, var2.build());
      }

      return this;
   }

   public BinExport$Flowgraph$Vertex$Builder addInstructions(BinExport$Flowgraph$Vertex$Instruction var1) {
      if(this.instructionsBuilder_ == null) {
         if(var1 == null) {
            throw new NullPointerException();
         }

         this.ensureInstructionsIsMutable();
         this.instructions_.add(var1);
         this.onChanged();
      } else {
         this.instructionsBuilder_.addMessage(var1);
      }

      return this;
   }

   public BinExport$Flowgraph$Vertex$Builder addInstructions(int var1, BinExport$Flowgraph$Vertex$Instruction var2) {
      if(this.instructionsBuilder_ == null) {
         if(var2 == null) {
            throw new NullPointerException();
         }

         this.ensureInstructionsIsMutable();
         this.instructions_.add(var1, var2);
         this.onChanged();
      } else {
         this.instructionsBuilder_.addMessage(var1, var2);
      }

      return this;
   }

   public BinExport$Flowgraph$Vertex$Builder addInstructions(BinExport$Flowgraph$Vertex$Instruction$Builder var1) {
      if(this.instructionsBuilder_ == null) {
         this.ensureInstructionsIsMutable();
         this.instructions_.add(var1.build());
         this.onChanged();
      } else {
         this.instructionsBuilder_.addMessage(var1.build());
      }

      return this;
   }

   public BinExport$Flowgraph$Vertex$Builder addInstructions(int var1, BinExport$Flowgraph$Vertex$Instruction$Builder var2) {
      if(this.instructionsBuilder_ == null) {
         this.ensureInstructionsIsMutable();
         this.instructions_.add(var1, var2.build());
         this.onChanged();
      } else {
         this.instructionsBuilder_.addMessage(var1, var2.build());
      }

      return this;
   }

   public BinExport$Flowgraph$Vertex$Builder addAllInstructions(Iterable var1) {
      if(this.instructionsBuilder_ == null) {
         this.ensureInstructionsIsMutable();
         AbstractMessageLite$Builder.addAll(var1, this.instructions_);
         this.onChanged();
      } else {
         this.instructionsBuilder_.addAllMessages(var1);
      }

      return this;
   }

   public BinExport$Flowgraph$Vertex$Builder clearInstructions() {
      if(this.instructionsBuilder_ == null) {
         this.instructions_ = Collections.emptyList();
         this.bitField0_ &= -3;
         this.onChanged();
      } else {
         this.instructionsBuilder_.clear();
      }

      return this;
   }

   public BinExport$Flowgraph$Vertex$Builder removeInstructions(int var1) {
      if(this.instructionsBuilder_ == null) {
         this.ensureInstructionsIsMutable();
         this.instructions_.remove(var1);
         this.onChanged();
      } else {
         this.instructionsBuilder_.remove(var1);
      }

      return this;
   }

   public BinExport$Flowgraph$Vertex$Instruction$Builder getInstructionsBuilder(int var1) {
      return (BinExport$Flowgraph$Vertex$Instruction$Builder)this.getInstructionsFieldBuilder().getBuilder(var1);
   }

   public BinExport$Flowgraph$Vertex$InstructionOrBuilder getInstructionsOrBuilder(int var1) {
      return this.instructionsBuilder_ == null?(BinExport$Flowgraph$Vertex$InstructionOrBuilder)this.instructions_.get(var1):(BinExport$Flowgraph$Vertex$InstructionOrBuilder)this.instructionsBuilder_.getMessageOrBuilder(var1);
   }

   public List getInstructionsOrBuilderList() {
      return this.instructionsBuilder_ != null?this.instructionsBuilder_.getMessageOrBuilderList():Collections.unmodifiableList(this.instructions_);
   }

   public BinExport$Flowgraph$Vertex$Instruction$Builder addInstructionsBuilder() {
      return (BinExport$Flowgraph$Vertex$Instruction$Builder)this.getInstructionsFieldBuilder().addBuilder(BinExport$Flowgraph$Vertex$Instruction.getDefaultInstance());
   }

   public BinExport$Flowgraph$Vertex$Instruction$Builder addInstructionsBuilder(int var1) {
      return (BinExport$Flowgraph$Vertex$Instruction$Builder)this.getInstructionsFieldBuilder().addBuilder(var1, BinExport$Flowgraph$Vertex$Instruction.getDefaultInstance());
   }

   public List getInstructionsBuilderList() {
      return this.getInstructionsFieldBuilder().getBuilderList();
   }

   private RepeatedFieldBuilder getInstructionsFieldBuilder() {
      if(this.instructionsBuilder_ == null) {
         this.instructionsBuilder_ = new RepeatedFieldBuilder(this.instructions_, (this.bitField0_ & 2) == 2, this.getParentForChildren(), this.isClean());
         this.instructions_ = null;
      }

      return this.instructionsBuilder_;
   }

   // $FF: synthetic method
   BinExport$Flowgraph$Vertex$Builder(BinExport$1 var1) {
      this();
   }

   // $FF: synthetic method
   BinExport$Flowgraph$Vertex$Builder(GeneratedMessage$BuilderParent var1, BinExport$1 var2) {
      this(var1);
   }
}
