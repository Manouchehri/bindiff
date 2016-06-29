package com.google.protobuf;

import com.google.protobuf.AbstractMessageLite$Builder;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.DescriptorProtos;
import com.google.protobuf.DescriptorProtos$1;
import com.google.protobuf.DescriptorProtos$EnumValueOptions;
import com.google.protobuf.DescriptorProtos$EnumValueOptionsOrBuilder;
import com.google.protobuf.DescriptorProtos$UninterpretedOption;
import com.google.protobuf.DescriptorProtos$UninterpretedOption$Builder;
import com.google.protobuf.DescriptorProtos$UninterpretedOptionOrBuilder;
import com.google.protobuf.Descriptors$Descriptor;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessage;
import com.google.protobuf.GeneratedMessage$BuilderParent;
import com.google.protobuf.GeneratedMessage$ExtendableBuilder;
import com.google.protobuf.GeneratedMessage$FieldAccessorTable;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.Message;
import com.google.protobuf.RepeatedFieldBuilder;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class DescriptorProtos$EnumValueOptions$Builder extends GeneratedMessage$ExtendableBuilder implements DescriptorProtos$EnumValueOptionsOrBuilder {
   private int bitField0_;
   private boolean deprecated_;
   private List uninterpretedOption_;
   private RepeatedFieldBuilder uninterpretedOptionBuilder_;

   public static final Descriptors$Descriptor getDescriptor() {
      return DescriptorProtos.access$18600();
   }

   protected GeneratedMessage$FieldAccessorTable internalGetFieldAccessorTable() {
      return DescriptorProtos.access$18700().ensureFieldAccessorsInitialized(DescriptorProtos$EnumValueOptions.class, DescriptorProtos$EnumValueOptions$Builder.class);
   }

   private DescriptorProtos$EnumValueOptions$Builder() {
      this.uninterpretedOption_ = Collections.emptyList();
      this.maybeForceBuilderInitialization();
   }

   private DescriptorProtos$EnumValueOptions$Builder(GeneratedMessage$BuilderParent var1) {
      super(var1);
      this.uninterpretedOption_ = Collections.emptyList();
      this.maybeForceBuilderInitialization();
   }

   private void maybeForceBuilderInitialization() {
      if(GeneratedMessage.alwaysUseFieldBuilders) {
         this.getUninterpretedOptionFieldBuilder();
      }

   }

   public DescriptorProtos$EnumValueOptions$Builder clear() {
      super.clear();
      this.deprecated_ = false;
      this.bitField0_ &= -2;
      if(this.uninterpretedOptionBuilder_ == null) {
         this.uninterpretedOption_ = Collections.emptyList();
         this.bitField0_ &= -3;
      } else {
         this.uninterpretedOptionBuilder_.clear();
      }

      return this;
   }

   public Descriptors$Descriptor getDescriptorForType() {
      return DescriptorProtos.access$18600();
   }

   public DescriptorProtos$EnumValueOptions getDefaultInstanceForType() {
      return DescriptorProtos$EnumValueOptions.getDefaultInstance();
   }

   public DescriptorProtos$EnumValueOptions build() {
      DescriptorProtos$EnumValueOptions var1 = this.buildPartial();
      if(!var1.isInitialized()) {
         throw newUninitializedMessageException(var1);
      } else {
         return var1;
      }
   }

   public DescriptorProtos$EnumValueOptions buildPartial() {
      DescriptorProtos$EnumValueOptions var1 = new DescriptorProtos$EnumValueOptions(this, (DescriptorProtos$1)null);
      int var2 = this.bitField0_;
      int var3 = 0;
      if((var2 & 1) == 1) {
         var3 |= 1;
      }

      DescriptorProtos$EnumValueOptions.access$19102(var1, this.deprecated_);
      if(this.uninterpretedOptionBuilder_ == null) {
         if((this.bitField0_ & 2) == 2) {
            this.uninterpretedOption_ = Collections.unmodifiableList(this.uninterpretedOption_);
            this.bitField0_ &= -3;
         }

         DescriptorProtos$EnumValueOptions.access$19202(var1, this.uninterpretedOption_);
      } else {
         DescriptorProtos$EnumValueOptions.access$19202(var1, this.uninterpretedOptionBuilder_.build());
      }

      DescriptorProtos$EnumValueOptions.access$19302(var1, var3);
      this.onBuilt();
      return var1;
   }

   public DescriptorProtos$EnumValueOptions$Builder mergeFrom(Message var1) {
      if(var1 instanceof DescriptorProtos$EnumValueOptions) {
         return this.mergeFrom((DescriptorProtos$EnumValueOptions)var1);
      } else {
         super.mergeFrom(var1);
         return this;
      }
   }

   public DescriptorProtos$EnumValueOptions$Builder mergeFrom(DescriptorProtos$EnumValueOptions var1) {
      if(var1 == DescriptorProtos$EnumValueOptions.getDefaultInstance()) {
         return this;
      } else {
         if(var1.hasDeprecated()) {
            this.setDeprecated(var1.getDeprecated());
         }

         if(this.uninterpretedOptionBuilder_ == null) {
            if(!DescriptorProtos$EnumValueOptions.access$19200(var1).isEmpty()) {
               if(this.uninterpretedOption_.isEmpty()) {
                  this.uninterpretedOption_ = DescriptorProtos$EnumValueOptions.access$19200(var1);
                  this.bitField0_ &= -3;
               } else {
                  this.ensureUninterpretedOptionIsMutable();
                  this.uninterpretedOption_.addAll(DescriptorProtos$EnumValueOptions.access$19200(var1));
               }

               this.onChanged();
            }
         } else if(!DescriptorProtos$EnumValueOptions.access$19200(var1).isEmpty()) {
            if(this.uninterpretedOptionBuilder_.isEmpty()) {
               this.uninterpretedOptionBuilder_.dispose();
               this.uninterpretedOptionBuilder_ = null;
               this.uninterpretedOption_ = DescriptorProtos$EnumValueOptions.access$19200(var1);
               this.bitField0_ &= -3;
               this.uninterpretedOptionBuilder_ = GeneratedMessage.alwaysUseFieldBuilders?this.getUninterpretedOptionFieldBuilder():null;
            } else {
               this.uninterpretedOptionBuilder_.addAllMessages(DescriptorProtos$EnumValueOptions.access$19200(var1));
            }
         }

         this.mergeExtensionFields(var1);
         this.mergeUnknownFields(var1.unknownFields);
         this.onChanged();
         return this;
      }
   }

   public final boolean isInitialized() {
      for(int var1 = 0; var1 < this.getUninterpretedOptionCount(); ++var1) {
         if(!this.getUninterpretedOption(var1).isInitialized()) {
            return false;
         }
      }

      if(!this.extensionsAreInitialized()) {
         return false;
      } else {
         return true;
      }
   }

   public DescriptorProtos$EnumValueOptions$Builder mergeFrom(CodedInputStream var1, ExtensionRegistryLite var2) {
      DescriptorProtos$EnumValueOptions var3 = null;

      try {
         var3 = (DescriptorProtos$EnumValueOptions)DescriptorProtos$EnumValueOptions.PARSER.parsePartialFrom(var1, var2);
      } catch (InvalidProtocolBufferException var9) {
         var3 = (DescriptorProtos$EnumValueOptions)var9.getUnfinishedMessage();
         throw var9;
      } finally {
         if(var3 != null) {
            this.mergeFrom(var3);
         }

      }

      return this;
   }

   public boolean hasDeprecated() {
      return (this.bitField0_ & 1) == 1;
   }

   public boolean getDeprecated() {
      return this.deprecated_;
   }

   public DescriptorProtos$EnumValueOptions$Builder setDeprecated(boolean var1) {
      this.bitField0_ |= 1;
      this.deprecated_ = var1;
      this.onChanged();
      return this;
   }

   public DescriptorProtos$EnumValueOptions$Builder clearDeprecated() {
      this.bitField0_ &= -2;
      this.deprecated_ = false;
      this.onChanged();
      return this;
   }

   private void ensureUninterpretedOptionIsMutable() {
      if((this.bitField0_ & 2) != 2) {
         this.uninterpretedOption_ = new ArrayList(this.uninterpretedOption_);
         this.bitField0_ |= 2;
      }

   }

   public List getUninterpretedOptionList() {
      return this.uninterpretedOptionBuilder_ == null?Collections.unmodifiableList(this.uninterpretedOption_):this.uninterpretedOptionBuilder_.getMessageList();
   }

   public int getUninterpretedOptionCount() {
      return this.uninterpretedOptionBuilder_ == null?this.uninterpretedOption_.size():this.uninterpretedOptionBuilder_.getCount();
   }

   public DescriptorProtos$UninterpretedOption getUninterpretedOption(int var1) {
      return this.uninterpretedOptionBuilder_ == null?(DescriptorProtos$UninterpretedOption)this.uninterpretedOption_.get(var1):(DescriptorProtos$UninterpretedOption)this.uninterpretedOptionBuilder_.getMessage(var1);
   }

   public DescriptorProtos$EnumValueOptions$Builder setUninterpretedOption(int var1, DescriptorProtos$UninterpretedOption var2) {
      if(this.uninterpretedOptionBuilder_ == null) {
         if(var2 == null) {
            throw new NullPointerException();
         }

         this.ensureUninterpretedOptionIsMutable();
         this.uninterpretedOption_.set(var1, var2);
         this.onChanged();
      } else {
         this.uninterpretedOptionBuilder_.setMessage(var1, var2);
      }

      return this;
   }

   public DescriptorProtos$EnumValueOptions$Builder setUninterpretedOption(int var1, DescriptorProtos$UninterpretedOption$Builder var2) {
      if(this.uninterpretedOptionBuilder_ == null) {
         this.ensureUninterpretedOptionIsMutable();
         this.uninterpretedOption_.set(var1, var2.build());
         this.onChanged();
      } else {
         this.uninterpretedOptionBuilder_.setMessage(var1, var2.build());
      }

      return this;
   }

   public DescriptorProtos$EnumValueOptions$Builder addUninterpretedOption(DescriptorProtos$UninterpretedOption var1) {
      if(this.uninterpretedOptionBuilder_ == null) {
         if(var1 == null) {
            throw new NullPointerException();
         }

         this.ensureUninterpretedOptionIsMutable();
         this.uninterpretedOption_.add(var1);
         this.onChanged();
      } else {
         this.uninterpretedOptionBuilder_.addMessage(var1);
      }

      return this;
   }

   public DescriptorProtos$EnumValueOptions$Builder addUninterpretedOption(int var1, DescriptorProtos$UninterpretedOption var2) {
      if(this.uninterpretedOptionBuilder_ == null) {
         if(var2 == null) {
            throw new NullPointerException();
         }

         this.ensureUninterpretedOptionIsMutable();
         this.uninterpretedOption_.add(var1, var2);
         this.onChanged();
      } else {
         this.uninterpretedOptionBuilder_.addMessage(var1, var2);
      }

      return this;
   }

   public DescriptorProtos$EnumValueOptions$Builder addUninterpretedOption(DescriptorProtos$UninterpretedOption$Builder var1) {
      if(this.uninterpretedOptionBuilder_ == null) {
         this.ensureUninterpretedOptionIsMutable();
         this.uninterpretedOption_.add(var1.build());
         this.onChanged();
      } else {
         this.uninterpretedOptionBuilder_.addMessage(var1.build());
      }

      return this;
   }

   public DescriptorProtos$EnumValueOptions$Builder addUninterpretedOption(int var1, DescriptorProtos$UninterpretedOption$Builder var2) {
      if(this.uninterpretedOptionBuilder_ == null) {
         this.ensureUninterpretedOptionIsMutable();
         this.uninterpretedOption_.add(var1, var2.build());
         this.onChanged();
      } else {
         this.uninterpretedOptionBuilder_.addMessage(var1, var2.build());
      }

      return this;
   }

   public DescriptorProtos$EnumValueOptions$Builder addAllUninterpretedOption(Iterable var1) {
      if(this.uninterpretedOptionBuilder_ == null) {
         this.ensureUninterpretedOptionIsMutable();
         AbstractMessageLite$Builder.addAll(var1, this.uninterpretedOption_);
         this.onChanged();
      } else {
         this.uninterpretedOptionBuilder_.addAllMessages(var1);
      }

      return this;
   }

   public DescriptorProtos$EnumValueOptions$Builder clearUninterpretedOption() {
      if(this.uninterpretedOptionBuilder_ == null) {
         this.uninterpretedOption_ = Collections.emptyList();
         this.bitField0_ &= -3;
         this.onChanged();
      } else {
         this.uninterpretedOptionBuilder_.clear();
      }

      return this;
   }

   public DescriptorProtos$EnumValueOptions$Builder removeUninterpretedOption(int var1) {
      if(this.uninterpretedOptionBuilder_ == null) {
         this.ensureUninterpretedOptionIsMutable();
         this.uninterpretedOption_.remove(var1);
         this.onChanged();
      } else {
         this.uninterpretedOptionBuilder_.remove(var1);
      }

      return this;
   }

   public DescriptorProtos$UninterpretedOption$Builder getUninterpretedOptionBuilder(int var1) {
      return (DescriptorProtos$UninterpretedOption$Builder)this.getUninterpretedOptionFieldBuilder().getBuilder(var1);
   }

   public DescriptorProtos$UninterpretedOptionOrBuilder getUninterpretedOptionOrBuilder(int var1) {
      return this.uninterpretedOptionBuilder_ == null?(DescriptorProtos$UninterpretedOptionOrBuilder)this.uninterpretedOption_.get(var1):(DescriptorProtos$UninterpretedOptionOrBuilder)this.uninterpretedOptionBuilder_.getMessageOrBuilder(var1);
   }

   public List getUninterpretedOptionOrBuilderList() {
      return this.uninterpretedOptionBuilder_ != null?this.uninterpretedOptionBuilder_.getMessageOrBuilderList():Collections.unmodifiableList(this.uninterpretedOption_);
   }

   public DescriptorProtos$UninterpretedOption$Builder addUninterpretedOptionBuilder() {
      return (DescriptorProtos$UninterpretedOption$Builder)this.getUninterpretedOptionFieldBuilder().addBuilder(DescriptorProtos$UninterpretedOption.getDefaultInstance());
   }

   public DescriptorProtos$UninterpretedOption$Builder addUninterpretedOptionBuilder(int var1) {
      return (DescriptorProtos$UninterpretedOption$Builder)this.getUninterpretedOptionFieldBuilder().addBuilder(var1, DescriptorProtos$UninterpretedOption.getDefaultInstance());
   }

   public List getUninterpretedOptionBuilderList() {
      return this.getUninterpretedOptionFieldBuilder().getBuilderList();
   }

   private RepeatedFieldBuilder getUninterpretedOptionFieldBuilder() {
      if(this.uninterpretedOptionBuilder_ == null) {
         this.uninterpretedOptionBuilder_ = new RepeatedFieldBuilder(this.uninterpretedOption_, (this.bitField0_ & 2) == 2, this.getParentForChildren(), this.isClean());
         this.uninterpretedOption_ = null;
      }

      return this.uninterpretedOptionBuilder_;
   }

   // $FF: synthetic method
   DescriptorProtos$EnumValueOptions$Builder(DescriptorProtos$1 var1) {
      this();
   }

   // $FF: synthetic method
   DescriptorProtos$EnumValueOptions$Builder(GeneratedMessage$BuilderParent var1, DescriptorProtos$1 var2) {
      this(var1);
   }
}
