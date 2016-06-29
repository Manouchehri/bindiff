package com.google.protobuf;

import com.google.protobuf.AbstractMessageLite$Builder;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.DescriptorProtos;
import com.google.protobuf.DescriptorProtos$1;
import com.google.protobuf.DescriptorProtos$EnumOptions;
import com.google.protobuf.DescriptorProtos$EnumOptionsOrBuilder;
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

public final class DescriptorProtos$EnumOptions$Builder extends GeneratedMessage$ExtendableBuilder implements DescriptorProtos$EnumOptionsOrBuilder {
   private int bitField0_;
   private boolean allowAlias_;
   private boolean deprecated_;
   private List uninterpretedOption_;
   private RepeatedFieldBuilder uninterpretedOptionBuilder_;

   public static final Descriptors$Descriptor getDescriptor() {
      return DescriptorProtos.access$17600();
   }

   protected GeneratedMessage$FieldAccessorTable internalGetFieldAccessorTable() {
      return DescriptorProtos.access$17700().ensureFieldAccessorsInitialized(DescriptorProtos$EnumOptions.class, DescriptorProtos$EnumOptions$Builder.class);
   }

   private DescriptorProtos$EnumOptions$Builder() {
      this.uninterpretedOption_ = Collections.emptyList();
      this.maybeForceBuilderInitialization();
   }

   private DescriptorProtos$EnumOptions$Builder(GeneratedMessage$BuilderParent var1) {
      super(var1);
      this.uninterpretedOption_ = Collections.emptyList();
      this.maybeForceBuilderInitialization();
   }

   private void maybeForceBuilderInitialization() {
      if(GeneratedMessage.alwaysUseFieldBuilders) {
         this.getUninterpretedOptionFieldBuilder();
      }

   }

   public DescriptorProtos$EnumOptions$Builder clear() {
      super.clear();
      this.allowAlias_ = false;
      this.bitField0_ &= -2;
      this.deprecated_ = false;
      this.bitField0_ &= -3;
      if(this.uninterpretedOptionBuilder_ == null) {
         this.uninterpretedOption_ = Collections.emptyList();
         this.bitField0_ &= -5;
      } else {
         this.uninterpretedOptionBuilder_.clear();
      }

      return this;
   }

   public Descriptors$Descriptor getDescriptorForType() {
      return DescriptorProtos.access$17600();
   }

   public DescriptorProtos$EnumOptions getDefaultInstanceForType() {
      return DescriptorProtos$EnumOptions.getDefaultInstance();
   }

   public DescriptorProtos$EnumOptions build() {
      DescriptorProtos$EnumOptions var1 = this.buildPartial();
      if(!var1.isInitialized()) {
         throw newUninitializedMessageException(var1);
      } else {
         return var1;
      }
   }

   public DescriptorProtos$EnumOptions buildPartial() {
      DescriptorProtos$EnumOptions var1 = new DescriptorProtos$EnumOptions(this, (DescriptorProtos$1)null);
      int var2 = this.bitField0_;
      int var3 = 0;
      if((var2 & 1) == 1) {
         var3 |= 1;
      }

      DescriptorProtos$EnumOptions.access$18102(var1, this.allowAlias_);
      if((var2 & 2) == 2) {
         var3 |= 2;
      }

      DescriptorProtos$EnumOptions.access$18202(var1, this.deprecated_);
      if(this.uninterpretedOptionBuilder_ == null) {
         if((this.bitField0_ & 4) == 4) {
            this.uninterpretedOption_ = Collections.unmodifiableList(this.uninterpretedOption_);
            this.bitField0_ &= -5;
         }

         DescriptorProtos$EnumOptions.access$18302(var1, this.uninterpretedOption_);
      } else {
         DescriptorProtos$EnumOptions.access$18302(var1, this.uninterpretedOptionBuilder_.build());
      }

      DescriptorProtos$EnumOptions.access$18402(var1, var3);
      this.onBuilt();
      return var1;
   }

   public DescriptorProtos$EnumOptions$Builder mergeFrom(Message var1) {
      if(var1 instanceof DescriptorProtos$EnumOptions) {
         return this.mergeFrom((DescriptorProtos$EnumOptions)var1);
      } else {
         super.mergeFrom(var1);
         return this;
      }
   }

   public DescriptorProtos$EnumOptions$Builder mergeFrom(DescriptorProtos$EnumOptions var1) {
      if(var1 == DescriptorProtos$EnumOptions.getDefaultInstance()) {
         return this;
      } else {
         if(var1.hasAllowAlias()) {
            this.setAllowAlias(var1.getAllowAlias());
         }

         if(var1.hasDeprecated()) {
            this.setDeprecated(var1.getDeprecated());
         }

         if(this.uninterpretedOptionBuilder_ == null) {
            if(!DescriptorProtos$EnumOptions.access$18300(var1).isEmpty()) {
               if(this.uninterpretedOption_.isEmpty()) {
                  this.uninterpretedOption_ = DescriptorProtos$EnumOptions.access$18300(var1);
                  this.bitField0_ &= -5;
               } else {
                  this.ensureUninterpretedOptionIsMutable();
                  this.uninterpretedOption_.addAll(DescriptorProtos$EnumOptions.access$18300(var1));
               }

               this.onChanged();
            }
         } else if(!DescriptorProtos$EnumOptions.access$18300(var1).isEmpty()) {
            if(this.uninterpretedOptionBuilder_.isEmpty()) {
               this.uninterpretedOptionBuilder_.dispose();
               this.uninterpretedOptionBuilder_ = null;
               this.uninterpretedOption_ = DescriptorProtos$EnumOptions.access$18300(var1);
               this.bitField0_ &= -5;
               this.uninterpretedOptionBuilder_ = GeneratedMessage.alwaysUseFieldBuilders?this.getUninterpretedOptionFieldBuilder():null;
            } else {
               this.uninterpretedOptionBuilder_.addAllMessages(DescriptorProtos$EnumOptions.access$18300(var1));
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

   public DescriptorProtos$EnumOptions$Builder mergeFrom(CodedInputStream var1, ExtensionRegistryLite var2) {
      DescriptorProtos$EnumOptions var3 = null;

      try {
         var3 = (DescriptorProtos$EnumOptions)DescriptorProtos$EnumOptions.PARSER.parsePartialFrom(var1, var2);
      } catch (InvalidProtocolBufferException var9) {
         var3 = (DescriptorProtos$EnumOptions)var9.getUnfinishedMessage();
         throw var9;
      } finally {
         if(var3 != null) {
            this.mergeFrom(var3);
         }

      }

      return this;
   }

   public boolean hasAllowAlias() {
      return (this.bitField0_ & 1) == 1;
   }

   public boolean getAllowAlias() {
      return this.allowAlias_;
   }

   public DescriptorProtos$EnumOptions$Builder setAllowAlias(boolean var1) {
      this.bitField0_ |= 1;
      this.allowAlias_ = var1;
      this.onChanged();
      return this;
   }

   public DescriptorProtos$EnumOptions$Builder clearAllowAlias() {
      this.bitField0_ &= -2;
      this.allowAlias_ = false;
      this.onChanged();
      return this;
   }

   public boolean hasDeprecated() {
      return (this.bitField0_ & 2) == 2;
   }

   public boolean getDeprecated() {
      return this.deprecated_;
   }

   public DescriptorProtos$EnumOptions$Builder setDeprecated(boolean var1) {
      this.bitField0_ |= 2;
      this.deprecated_ = var1;
      this.onChanged();
      return this;
   }

   public DescriptorProtos$EnumOptions$Builder clearDeprecated() {
      this.bitField0_ &= -3;
      this.deprecated_ = false;
      this.onChanged();
      return this;
   }

   private void ensureUninterpretedOptionIsMutable() {
      if((this.bitField0_ & 4) != 4) {
         this.uninterpretedOption_ = new ArrayList(this.uninterpretedOption_);
         this.bitField0_ |= 4;
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

   public DescriptorProtos$EnumOptions$Builder setUninterpretedOption(int var1, DescriptorProtos$UninterpretedOption var2) {
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

   public DescriptorProtos$EnumOptions$Builder setUninterpretedOption(int var1, DescriptorProtos$UninterpretedOption$Builder var2) {
      if(this.uninterpretedOptionBuilder_ == null) {
         this.ensureUninterpretedOptionIsMutable();
         this.uninterpretedOption_.set(var1, var2.build());
         this.onChanged();
      } else {
         this.uninterpretedOptionBuilder_.setMessage(var1, var2.build());
      }

      return this;
   }

   public DescriptorProtos$EnumOptions$Builder addUninterpretedOption(DescriptorProtos$UninterpretedOption var1) {
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

   public DescriptorProtos$EnumOptions$Builder addUninterpretedOption(int var1, DescriptorProtos$UninterpretedOption var2) {
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

   public DescriptorProtos$EnumOptions$Builder addUninterpretedOption(DescriptorProtos$UninterpretedOption$Builder var1) {
      if(this.uninterpretedOptionBuilder_ == null) {
         this.ensureUninterpretedOptionIsMutable();
         this.uninterpretedOption_.add(var1.build());
         this.onChanged();
      } else {
         this.uninterpretedOptionBuilder_.addMessage(var1.build());
      }

      return this;
   }

   public DescriptorProtos$EnumOptions$Builder addUninterpretedOption(int var1, DescriptorProtos$UninterpretedOption$Builder var2) {
      if(this.uninterpretedOptionBuilder_ == null) {
         this.ensureUninterpretedOptionIsMutable();
         this.uninterpretedOption_.add(var1, var2.build());
         this.onChanged();
      } else {
         this.uninterpretedOptionBuilder_.addMessage(var1, var2.build());
      }

      return this;
   }

   public DescriptorProtos$EnumOptions$Builder addAllUninterpretedOption(Iterable var1) {
      if(this.uninterpretedOptionBuilder_ == null) {
         this.ensureUninterpretedOptionIsMutable();
         AbstractMessageLite$Builder.addAll(var1, this.uninterpretedOption_);
         this.onChanged();
      } else {
         this.uninterpretedOptionBuilder_.addAllMessages(var1);
      }

      return this;
   }

   public DescriptorProtos$EnumOptions$Builder clearUninterpretedOption() {
      if(this.uninterpretedOptionBuilder_ == null) {
         this.uninterpretedOption_ = Collections.emptyList();
         this.bitField0_ &= -5;
         this.onChanged();
      } else {
         this.uninterpretedOptionBuilder_.clear();
      }

      return this;
   }

   public DescriptorProtos$EnumOptions$Builder removeUninterpretedOption(int var1) {
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
         this.uninterpretedOptionBuilder_ = new RepeatedFieldBuilder(this.uninterpretedOption_, (this.bitField0_ & 4) == 4, this.getParentForChildren(), this.isClean());
         this.uninterpretedOption_ = null;
      }

      return this.uninterpretedOptionBuilder_;
   }

   // $FF: synthetic method
   DescriptorProtos$EnumOptions$Builder(DescriptorProtos$1 var1) {
      this();
   }

   // $FF: synthetic method
   DescriptorProtos$EnumOptions$Builder(GeneratedMessage$BuilderParent var1, DescriptorProtos$1 var2) {
      this(var1);
   }
}
