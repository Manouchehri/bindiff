package com.google.protobuf;

import com.google.protobuf.AbstractMessageLite$Builder;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.DescriptorProtos;
import com.google.protobuf.DescriptorProtos$1;
import com.google.protobuf.DescriptorProtos$MessageOptions;
import com.google.protobuf.DescriptorProtos$MessageOptionsOrBuilder;
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

public final class DescriptorProtos$MessageOptions$Builder extends GeneratedMessage$ExtendableBuilder implements DescriptorProtos$MessageOptionsOrBuilder {
   private int bitField0_;
   private boolean messageSetWireFormat_;
   private boolean noStandardDescriptorAccessor_;
   private boolean deprecated_;
   private boolean mapEntry_;
   private List uninterpretedOption_;
   private RepeatedFieldBuilder uninterpretedOptionBuilder_;

   public static final Descriptors$Descriptor getDescriptor() {
      return DescriptorProtos.access$15000();
   }

   protected GeneratedMessage$FieldAccessorTable internalGetFieldAccessorTable() {
      return DescriptorProtos.access$15100().ensureFieldAccessorsInitialized(DescriptorProtos$MessageOptions.class, DescriptorProtos$MessageOptions$Builder.class);
   }

   private DescriptorProtos$MessageOptions$Builder() {
      this.uninterpretedOption_ = Collections.emptyList();
      this.maybeForceBuilderInitialization();
   }

   private DescriptorProtos$MessageOptions$Builder(GeneratedMessage$BuilderParent var1) {
      super(var1);
      this.uninterpretedOption_ = Collections.emptyList();
      this.maybeForceBuilderInitialization();
   }

   private void maybeForceBuilderInitialization() {
      if(GeneratedMessage.alwaysUseFieldBuilders) {
         this.getUninterpretedOptionFieldBuilder();
      }

   }

   public DescriptorProtos$MessageOptions$Builder clear() {
      super.clear();
      this.messageSetWireFormat_ = false;
      this.bitField0_ &= -2;
      this.noStandardDescriptorAccessor_ = false;
      this.bitField0_ &= -3;
      this.deprecated_ = false;
      this.bitField0_ &= -5;
      this.mapEntry_ = false;
      this.bitField0_ &= -9;
      if(this.uninterpretedOptionBuilder_ == null) {
         this.uninterpretedOption_ = Collections.emptyList();
         this.bitField0_ &= -17;
      } else {
         this.uninterpretedOptionBuilder_.clear();
      }

      return this;
   }

   public Descriptors$Descriptor getDescriptorForType() {
      return DescriptorProtos.access$15000();
   }

   public DescriptorProtos$MessageOptions getDefaultInstanceForType() {
      return DescriptorProtos$MessageOptions.getDefaultInstance();
   }

   public DescriptorProtos$MessageOptions build() {
      DescriptorProtos$MessageOptions var1 = this.buildPartial();
      if(!var1.isInitialized()) {
         throw newUninitializedMessageException(var1);
      } else {
         return var1;
      }
   }

   public DescriptorProtos$MessageOptions buildPartial() {
      DescriptorProtos$MessageOptions var1 = new DescriptorProtos$MessageOptions(this, (DescriptorProtos$1)null);
      int var2 = this.bitField0_;
      int var3 = 0;
      if((var2 & 1) == 1) {
         var3 |= 1;
      }

      DescriptorProtos$MessageOptions.access$15502(var1, this.messageSetWireFormat_);
      if((var2 & 2) == 2) {
         var3 |= 2;
      }

      DescriptorProtos$MessageOptions.access$15602(var1, this.noStandardDescriptorAccessor_);
      if((var2 & 4) == 4) {
         var3 |= 4;
      }

      DescriptorProtos$MessageOptions.access$15702(var1, this.deprecated_);
      if((var2 & 8) == 8) {
         var3 |= 8;
      }

      DescriptorProtos$MessageOptions.access$15802(var1, this.mapEntry_);
      if(this.uninterpretedOptionBuilder_ == null) {
         if((this.bitField0_ & 16) == 16) {
            this.uninterpretedOption_ = Collections.unmodifiableList(this.uninterpretedOption_);
            this.bitField0_ &= -17;
         }

         DescriptorProtos$MessageOptions.access$15902(var1, this.uninterpretedOption_);
      } else {
         DescriptorProtos$MessageOptions.access$15902(var1, this.uninterpretedOptionBuilder_.build());
      }

      DescriptorProtos$MessageOptions.access$16002(var1, var3);
      this.onBuilt();
      return var1;
   }

   public DescriptorProtos$MessageOptions$Builder mergeFrom(Message var1) {
      if(var1 instanceof DescriptorProtos$MessageOptions) {
         return this.mergeFrom((DescriptorProtos$MessageOptions)var1);
      } else {
         super.mergeFrom(var1);
         return this;
      }
   }

   public DescriptorProtos$MessageOptions$Builder mergeFrom(DescriptorProtos$MessageOptions var1) {
      if(var1 == DescriptorProtos$MessageOptions.getDefaultInstance()) {
         return this;
      } else {
         if(var1.hasMessageSetWireFormat()) {
            this.setMessageSetWireFormat(var1.getMessageSetWireFormat());
         }

         if(var1.hasNoStandardDescriptorAccessor()) {
            this.setNoStandardDescriptorAccessor(var1.getNoStandardDescriptorAccessor());
         }

         if(var1.hasDeprecated()) {
            this.setDeprecated(var1.getDeprecated());
         }

         if(var1.hasMapEntry()) {
            this.setMapEntry(var1.getMapEntry());
         }

         if(this.uninterpretedOptionBuilder_ == null) {
            if(!DescriptorProtos$MessageOptions.access$15900(var1).isEmpty()) {
               if(this.uninterpretedOption_.isEmpty()) {
                  this.uninterpretedOption_ = DescriptorProtos$MessageOptions.access$15900(var1);
                  this.bitField0_ &= -17;
               } else {
                  this.ensureUninterpretedOptionIsMutable();
                  this.uninterpretedOption_.addAll(DescriptorProtos$MessageOptions.access$15900(var1));
               }

               this.onChanged();
            }
         } else if(!DescriptorProtos$MessageOptions.access$15900(var1).isEmpty()) {
            if(this.uninterpretedOptionBuilder_.isEmpty()) {
               this.uninterpretedOptionBuilder_.dispose();
               this.uninterpretedOptionBuilder_ = null;
               this.uninterpretedOption_ = DescriptorProtos$MessageOptions.access$15900(var1);
               this.bitField0_ &= -17;
               this.uninterpretedOptionBuilder_ = GeneratedMessage.alwaysUseFieldBuilders?this.getUninterpretedOptionFieldBuilder():null;
            } else {
               this.uninterpretedOptionBuilder_.addAllMessages(DescriptorProtos$MessageOptions.access$15900(var1));
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

   public DescriptorProtos$MessageOptions$Builder mergeFrom(CodedInputStream var1, ExtensionRegistryLite var2) {
      DescriptorProtos$MessageOptions var3 = null;

      try {
         var3 = (DescriptorProtos$MessageOptions)DescriptorProtos$MessageOptions.PARSER.parsePartialFrom(var1, var2);
      } catch (InvalidProtocolBufferException var9) {
         var3 = (DescriptorProtos$MessageOptions)var9.getUnfinishedMessage();
         throw var9;
      } finally {
         if(var3 != null) {
            this.mergeFrom(var3);
         }

      }

      return this;
   }

   public boolean hasMessageSetWireFormat() {
      return (this.bitField0_ & 1) == 1;
   }

   public boolean getMessageSetWireFormat() {
      return this.messageSetWireFormat_;
   }

   public DescriptorProtos$MessageOptions$Builder setMessageSetWireFormat(boolean var1) {
      this.bitField0_ |= 1;
      this.messageSetWireFormat_ = var1;
      this.onChanged();
      return this;
   }

   public DescriptorProtos$MessageOptions$Builder clearMessageSetWireFormat() {
      this.bitField0_ &= -2;
      this.messageSetWireFormat_ = false;
      this.onChanged();
      return this;
   }

   public boolean hasNoStandardDescriptorAccessor() {
      return (this.bitField0_ & 2) == 2;
   }

   public boolean getNoStandardDescriptorAccessor() {
      return this.noStandardDescriptorAccessor_;
   }

   public DescriptorProtos$MessageOptions$Builder setNoStandardDescriptorAccessor(boolean var1) {
      this.bitField0_ |= 2;
      this.noStandardDescriptorAccessor_ = var1;
      this.onChanged();
      return this;
   }

   public DescriptorProtos$MessageOptions$Builder clearNoStandardDescriptorAccessor() {
      this.bitField0_ &= -3;
      this.noStandardDescriptorAccessor_ = false;
      this.onChanged();
      return this;
   }

   public boolean hasDeprecated() {
      return (this.bitField0_ & 4) == 4;
   }

   public boolean getDeprecated() {
      return this.deprecated_;
   }

   public DescriptorProtos$MessageOptions$Builder setDeprecated(boolean var1) {
      this.bitField0_ |= 4;
      this.deprecated_ = var1;
      this.onChanged();
      return this;
   }

   public DescriptorProtos$MessageOptions$Builder clearDeprecated() {
      this.bitField0_ &= -5;
      this.deprecated_ = false;
      this.onChanged();
      return this;
   }

   public boolean hasMapEntry() {
      return (this.bitField0_ & 8) == 8;
   }

   public boolean getMapEntry() {
      return this.mapEntry_;
   }

   public DescriptorProtos$MessageOptions$Builder setMapEntry(boolean var1) {
      this.bitField0_ |= 8;
      this.mapEntry_ = var1;
      this.onChanged();
      return this;
   }

   public DescriptorProtos$MessageOptions$Builder clearMapEntry() {
      this.bitField0_ &= -9;
      this.mapEntry_ = false;
      this.onChanged();
      return this;
   }

   private void ensureUninterpretedOptionIsMutable() {
      if((this.bitField0_ & 16) != 16) {
         this.uninterpretedOption_ = new ArrayList(this.uninterpretedOption_);
         this.bitField0_ |= 16;
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

   public DescriptorProtos$MessageOptions$Builder setUninterpretedOption(int var1, DescriptorProtos$UninterpretedOption var2) {
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

   public DescriptorProtos$MessageOptions$Builder setUninterpretedOption(int var1, DescriptorProtos$UninterpretedOption$Builder var2) {
      if(this.uninterpretedOptionBuilder_ == null) {
         this.ensureUninterpretedOptionIsMutable();
         this.uninterpretedOption_.set(var1, var2.build());
         this.onChanged();
      } else {
         this.uninterpretedOptionBuilder_.setMessage(var1, var2.build());
      }

      return this;
   }

   public DescriptorProtos$MessageOptions$Builder addUninterpretedOption(DescriptorProtos$UninterpretedOption var1) {
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

   public DescriptorProtos$MessageOptions$Builder addUninterpretedOption(int var1, DescriptorProtos$UninterpretedOption var2) {
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

   public DescriptorProtos$MessageOptions$Builder addUninterpretedOption(DescriptorProtos$UninterpretedOption$Builder var1) {
      if(this.uninterpretedOptionBuilder_ == null) {
         this.ensureUninterpretedOptionIsMutable();
         this.uninterpretedOption_.add(var1.build());
         this.onChanged();
      } else {
         this.uninterpretedOptionBuilder_.addMessage(var1.build());
      }

      return this;
   }

   public DescriptorProtos$MessageOptions$Builder addUninterpretedOption(int var1, DescriptorProtos$UninterpretedOption$Builder var2) {
      if(this.uninterpretedOptionBuilder_ == null) {
         this.ensureUninterpretedOptionIsMutable();
         this.uninterpretedOption_.add(var1, var2.build());
         this.onChanged();
      } else {
         this.uninterpretedOptionBuilder_.addMessage(var1, var2.build());
      }

      return this;
   }

   public DescriptorProtos$MessageOptions$Builder addAllUninterpretedOption(Iterable var1) {
      if(this.uninterpretedOptionBuilder_ == null) {
         this.ensureUninterpretedOptionIsMutable();
         AbstractMessageLite$Builder.addAll(var1, this.uninterpretedOption_);
         this.onChanged();
      } else {
         this.uninterpretedOptionBuilder_.addAllMessages(var1);
      }

      return this;
   }

   public DescriptorProtos$MessageOptions$Builder clearUninterpretedOption() {
      if(this.uninterpretedOptionBuilder_ == null) {
         this.uninterpretedOption_ = Collections.emptyList();
         this.bitField0_ &= -17;
         this.onChanged();
      } else {
         this.uninterpretedOptionBuilder_.clear();
      }

      return this;
   }

   public DescriptorProtos$MessageOptions$Builder removeUninterpretedOption(int var1) {
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
         this.uninterpretedOptionBuilder_ = new RepeatedFieldBuilder(this.uninterpretedOption_, (this.bitField0_ & 16) == 16, this.getParentForChildren(), this.isClean());
         this.uninterpretedOption_ = null;
      }

      return this.uninterpretedOptionBuilder_;
   }

   // $FF: synthetic method
   DescriptorProtos$MessageOptions$Builder(DescriptorProtos$1 var1) {
      this();
   }

   // $FF: synthetic method
   DescriptorProtos$MessageOptions$Builder(GeneratedMessage$BuilderParent var1, DescriptorProtos$1 var2) {
      this(var1);
   }
}
