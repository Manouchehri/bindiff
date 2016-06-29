package com.google.protobuf;

import com.google.protobuf.AbstractMessageLite$Builder;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.DescriptorProtos;
import com.google.protobuf.DescriptorProtos$1;
import com.google.protobuf.DescriptorProtos$FileDescriptorProto;
import com.google.protobuf.DescriptorProtos$FileDescriptorProto$Builder;
import com.google.protobuf.DescriptorProtos$FileDescriptorProtoOrBuilder;
import com.google.protobuf.DescriptorProtos$FileDescriptorSet;
import com.google.protobuf.DescriptorProtos$FileDescriptorSetOrBuilder;
import com.google.protobuf.Descriptors$Descriptor;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessage;
import com.google.protobuf.GeneratedMessage$Builder;
import com.google.protobuf.GeneratedMessage$BuilderParent;
import com.google.protobuf.GeneratedMessage$FieldAccessorTable;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.Message;
import com.google.protobuf.RepeatedFieldBuilder;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class DescriptorProtos$FileDescriptorSet$Builder extends GeneratedMessage$Builder implements DescriptorProtos$FileDescriptorSetOrBuilder {
   private int bitField0_;
   private List file_;
   private RepeatedFieldBuilder fileBuilder_;

   public static final Descriptors$Descriptor getDescriptor() {
      return DescriptorProtos.access$000();
   }

   protected GeneratedMessage$FieldAccessorTable internalGetFieldAccessorTable() {
      return DescriptorProtos.access$100().ensureFieldAccessorsInitialized(DescriptorProtos$FileDescriptorSet.class, DescriptorProtos$FileDescriptorSet$Builder.class);
   }

   private DescriptorProtos$FileDescriptorSet$Builder() {
      this.file_ = Collections.emptyList();
      this.maybeForceBuilderInitialization();
   }

   private DescriptorProtos$FileDescriptorSet$Builder(GeneratedMessage$BuilderParent var1) {
      super(var1);
      this.file_ = Collections.emptyList();
      this.maybeForceBuilderInitialization();
   }

   private void maybeForceBuilderInitialization() {
      if(GeneratedMessage.alwaysUseFieldBuilders) {
         this.getFileFieldBuilder();
      }

   }

   public DescriptorProtos$FileDescriptorSet$Builder clear() {
      super.clear();
      if(this.fileBuilder_ == null) {
         this.file_ = Collections.emptyList();
         this.bitField0_ &= -2;
      } else {
         this.fileBuilder_.clear();
      }

      return this;
   }

   public Descriptors$Descriptor getDescriptorForType() {
      return DescriptorProtos.access$000();
   }

   public DescriptorProtos$FileDescriptorSet getDefaultInstanceForType() {
      return DescriptorProtos$FileDescriptorSet.getDefaultInstance();
   }

   public DescriptorProtos$FileDescriptorSet build() {
      DescriptorProtos$FileDescriptorSet var1 = this.buildPartial();
      if(!var1.isInitialized()) {
         throw newUninitializedMessageException(var1);
      } else {
         return var1;
      }
   }

   public DescriptorProtos$FileDescriptorSet buildPartial() {
      DescriptorProtos$FileDescriptorSet var1 = new DescriptorProtos$FileDescriptorSet(this, (DescriptorProtos$1)null);
      int var2 = this.bitField0_;
      if(this.fileBuilder_ == null) {
         if((this.bitField0_ & 1) == 1) {
            this.file_ = Collections.unmodifiableList(this.file_);
            this.bitField0_ &= -2;
         }

         DescriptorProtos$FileDescriptorSet.access$502(var1, this.file_);
      } else {
         DescriptorProtos$FileDescriptorSet.access$502(var1, this.fileBuilder_.build());
      }

      this.onBuilt();
      return var1;
   }

   public DescriptorProtos$FileDescriptorSet$Builder mergeFrom(Message var1) {
      if(var1 instanceof DescriptorProtos$FileDescriptorSet) {
         return this.mergeFrom((DescriptorProtos$FileDescriptorSet)var1);
      } else {
         super.mergeFrom(var1);
         return this;
      }
   }

   public DescriptorProtos$FileDescriptorSet$Builder mergeFrom(DescriptorProtos$FileDescriptorSet var1) {
      if(var1 == DescriptorProtos$FileDescriptorSet.getDefaultInstance()) {
         return this;
      } else {
         if(this.fileBuilder_ == null) {
            if(!DescriptorProtos$FileDescriptorSet.access$500(var1).isEmpty()) {
               if(this.file_.isEmpty()) {
                  this.file_ = DescriptorProtos$FileDescriptorSet.access$500(var1);
                  this.bitField0_ &= -2;
               } else {
                  this.ensureFileIsMutable();
                  this.file_.addAll(DescriptorProtos$FileDescriptorSet.access$500(var1));
               }

               this.onChanged();
            }
         } else if(!DescriptorProtos$FileDescriptorSet.access$500(var1).isEmpty()) {
            if(this.fileBuilder_.isEmpty()) {
               this.fileBuilder_.dispose();
               this.fileBuilder_ = null;
               this.file_ = DescriptorProtos$FileDescriptorSet.access$500(var1);
               this.bitField0_ &= -2;
               this.fileBuilder_ = GeneratedMessage.alwaysUseFieldBuilders?this.getFileFieldBuilder():null;
            } else {
               this.fileBuilder_.addAllMessages(DescriptorProtos$FileDescriptorSet.access$500(var1));
            }
         }

         this.mergeUnknownFields(var1.unknownFields);
         this.onChanged();
         return this;
      }
   }

   public final boolean isInitialized() {
      for(int var1 = 0; var1 < this.getFileCount(); ++var1) {
         if(!this.getFile(var1).isInitialized()) {
            return false;
         }
      }

      return true;
   }

   public DescriptorProtos$FileDescriptorSet$Builder mergeFrom(CodedInputStream var1, ExtensionRegistryLite var2) {
      DescriptorProtos$FileDescriptorSet var3 = null;

      try {
         var3 = (DescriptorProtos$FileDescriptorSet)DescriptorProtos$FileDescriptorSet.PARSER.parsePartialFrom(var1, var2);
      } catch (InvalidProtocolBufferException var8) {
         var3 = (DescriptorProtos$FileDescriptorSet)var8.getUnfinishedMessage();
         throw var8;
      } finally {
         if(var3 != null) {
            this.mergeFrom(var3);
         }

      }

      return this;
   }

   private void ensureFileIsMutable() {
      if((this.bitField0_ & 1) != 1) {
         this.file_ = new ArrayList(this.file_);
         this.bitField0_ |= 1;
      }

   }

   public List getFileList() {
      return this.fileBuilder_ == null?Collections.unmodifiableList(this.file_):this.fileBuilder_.getMessageList();
   }

   public int getFileCount() {
      return this.fileBuilder_ == null?this.file_.size():this.fileBuilder_.getCount();
   }

   public DescriptorProtos$FileDescriptorProto getFile(int var1) {
      return this.fileBuilder_ == null?(DescriptorProtos$FileDescriptorProto)this.file_.get(var1):(DescriptorProtos$FileDescriptorProto)this.fileBuilder_.getMessage(var1);
   }

   public DescriptorProtos$FileDescriptorSet$Builder setFile(int var1, DescriptorProtos$FileDescriptorProto var2) {
      if(this.fileBuilder_ == null) {
         if(var2 == null) {
            throw new NullPointerException();
         }

         this.ensureFileIsMutable();
         this.file_.set(var1, var2);
         this.onChanged();
      } else {
         this.fileBuilder_.setMessage(var1, var2);
      }

      return this;
   }

   public DescriptorProtos$FileDescriptorSet$Builder setFile(int var1, DescriptorProtos$FileDescriptorProto$Builder var2) {
      if(this.fileBuilder_ == null) {
         this.ensureFileIsMutable();
         this.file_.set(var1, var2.build());
         this.onChanged();
      } else {
         this.fileBuilder_.setMessage(var1, var2.build());
      }

      return this;
   }

   public DescriptorProtos$FileDescriptorSet$Builder addFile(DescriptorProtos$FileDescriptorProto var1) {
      if(this.fileBuilder_ == null) {
         if(var1 == null) {
            throw new NullPointerException();
         }

         this.ensureFileIsMutable();
         this.file_.add(var1);
         this.onChanged();
      } else {
         this.fileBuilder_.addMessage(var1);
      }

      return this;
   }

   public DescriptorProtos$FileDescriptorSet$Builder addFile(int var1, DescriptorProtos$FileDescriptorProto var2) {
      if(this.fileBuilder_ == null) {
         if(var2 == null) {
            throw new NullPointerException();
         }

         this.ensureFileIsMutable();
         this.file_.add(var1, var2);
         this.onChanged();
      } else {
         this.fileBuilder_.addMessage(var1, var2);
      }

      return this;
   }

   public DescriptorProtos$FileDescriptorSet$Builder addFile(DescriptorProtos$FileDescriptorProto$Builder var1) {
      if(this.fileBuilder_ == null) {
         this.ensureFileIsMutable();
         this.file_.add(var1.build());
         this.onChanged();
      } else {
         this.fileBuilder_.addMessage(var1.build());
      }

      return this;
   }

   public DescriptorProtos$FileDescriptorSet$Builder addFile(int var1, DescriptorProtos$FileDescriptorProto$Builder var2) {
      if(this.fileBuilder_ == null) {
         this.ensureFileIsMutable();
         this.file_.add(var1, var2.build());
         this.onChanged();
      } else {
         this.fileBuilder_.addMessage(var1, var2.build());
      }

      return this;
   }

   public DescriptorProtos$FileDescriptorSet$Builder addAllFile(Iterable var1) {
      if(this.fileBuilder_ == null) {
         this.ensureFileIsMutable();
         AbstractMessageLite$Builder.addAll(var1, this.file_);
         this.onChanged();
      } else {
         this.fileBuilder_.addAllMessages(var1);
      }

      return this;
   }

   public DescriptorProtos$FileDescriptorSet$Builder clearFile() {
      if(this.fileBuilder_ == null) {
         this.file_ = Collections.emptyList();
         this.bitField0_ &= -2;
         this.onChanged();
      } else {
         this.fileBuilder_.clear();
      }

      return this;
   }

   public DescriptorProtos$FileDescriptorSet$Builder removeFile(int var1) {
      if(this.fileBuilder_ == null) {
         this.ensureFileIsMutable();
         this.file_.remove(var1);
         this.onChanged();
      } else {
         this.fileBuilder_.remove(var1);
      }

      return this;
   }

   public DescriptorProtos$FileDescriptorProto$Builder getFileBuilder(int var1) {
      return (DescriptorProtos$FileDescriptorProto$Builder)this.getFileFieldBuilder().getBuilder(var1);
   }

   public DescriptorProtos$FileDescriptorProtoOrBuilder getFileOrBuilder(int var1) {
      return this.fileBuilder_ == null?(DescriptorProtos$FileDescriptorProtoOrBuilder)this.file_.get(var1):(DescriptorProtos$FileDescriptorProtoOrBuilder)this.fileBuilder_.getMessageOrBuilder(var1);
   }

   public List getFileOrBuilderList() {
      return this.fileBuilder_ != null?this.fileBuilder_.getMessageOrBuilderList():Collections.unmodifiableList(this.file_);
   }

   public DescriptorProtos$FileDescriptorProto$Builder addFileBuilder() {
      return (DescriptorProtos$FileDescriptorProto$Builder)this.getFileFieldBuilder().addBuilder(DescriptorProtos$FileDescriptorProto.getDefaultInstance());
   }

   public DescriptorProtos$FileDescriptorProto$Builder addFileBuilder(int var1) {
      return (DescriptorProtos$FileDescriptorProto$Builder)this.getFileFieldBuilder().addBuilder(var1, DescriptorProtos$FileDescriptorProto.getDefaultInstance());
   }

   public List getFileBuilderList() {
      return this.getFileFieldBuilder().getBuilderList();
   }

   private RepeatedFieldBuilder getFileFieldBuilder() {
      if(this.fileBuilder_ == null) {
         this.fileBuilder_ = new RepeatedFieldBuilder(this.file_, (this.bitField0_ & 1) == 1, this.getParentForChildren(), this.isClean());
         this.file_ = null;
      }

      return this.fileBuilder_;
   }

   // $FF: synthetic method
   DescriptorProtos$FileDescriptorSet$Builder(DescriptorProtos$1 var1) {
      this();
   }

   // $FF: synthetic method
   DescriptorProtos$FileDescriptorSet$Builder(GeneratedMessage$BuilderParent var1, DescriptorProtos$1 var2) {
      this(var1);
   }
}
