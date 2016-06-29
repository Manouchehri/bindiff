package com.google.protobuf;

import com.google.protobuf.AbstractMessageLite$Builder;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.DescriptorProtos;
import com.google.protobuf.DescriptorProtos$1;
import com.google.protobuf.DescriptorProtos$FieldOptions;
import com.google.protobuf.DescriptorProtos$FieldOptions$CType;
import com.google.protobuf.DescriptorProtos$FieldOptions$JSType;
import com.google.protobuf.DescriptorProtos$FieldOptionsOrBuilder;
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

public final class DescriptorProtos$FieldOptions$Builder extends GeneratedMessage$ExtendableBuilder implements DescriptorProtos$FieldOptionsOrBuilder {
   private int bitField0_;
   private int ctype_;
   private boolean packed_;
   private int jstype_;
   private boolean lazy_;
   private boolean deprecated_;
   private boolean weak_;
   private List uninterpretedOption_;
   private RepeatedFieldBuilder uninterpretedOptionBuilder_;

   public static final Descriptors$Descriptor getDescriptor() {
      return DescriptorProtos.access$16200();
   }

   protected GeneratedMessage$FieldAccessorTable internalGetFieldAccessorTable() {
      return DescriptorProtos.access$16300().ensureFieldAccessorsInitialized(DescriptorProtos$FieldOptions.class, DescriptorProtos$FieldOptions$Builder.class);
   }

   private DescriptorProtos$FieldOptions$Builder() {
      this.ctype_ = 0;
      this.jstype_ = 0;
      this.uninterpretedOption_ = Collections.emptyList();
      this.maybeForceBuilderInitialization();
   }

   private DescriptorProtos$FieldOptions$Builder(GeneratedMessage$BuilderParent var1) {
      super(var1);
      this.ctype_ = 0;
      this.jstype_ = 0;
      this.uninterpretedOption_ = Collections.emptyList();
      this.maybeForceBuilderInitialization();
   }

   private void maybeForceBuilderInitialization() {
      if(GeneratedMessage.alwaysUseFieldBuilders) {
         this.getUninterpretedOptionFieldBuilder();
      }

   }

   public DescriptorProtos$FieldOptions$Builder clear() {
      super.clear();
      this.ctype_ = 0;
      this.bitField0_ &= -2;
      this.packed_ = false;
      this.bitField0_ &= -3;
      this.jstype_ = 0;
      this.bitField0_ &= -5;
      this.lazy_ = false;
      this.bitField0_ &= -9;
      this.deprecated_ = false;
      this.bitField0_ &= -17;
      this.weak_ = false;
      this.bitField0_ &= -33;
      if(this.uninterpretedOptionBuilder_ == null) {
         this.uninterpretedOption_ = Collections.emptyList();
         this.bitField0_ &= -65;
      } else {
         this.uninterpretedOptionBuilder_.clear();
      }

      return this;
   }

   public Descriptors$Descriptor getDescriptorForType() {
      return DescriptorProtos.access$16200();
   }

   public DescriptorProtos$FieldOptions getDefaultInstanceForType() {
      return DescriptorProtos$FieldOptions.getDefaultInstance();
   }

   public DescriptorProtos$FieldOptions build() {
      DescriptorProtos$FieldOptions var1 = this.buildPartial();
      if(!var1.isInitialized()) {
         throw newUninitializedMessageException(var1);
      } else {
         return var1;
      }
   }

   public DescriptorProtos$FieldOptions buildPartial() {
      DescriptorProtos$FieldOptions var1 = new DescriptorProtos$FieldOptions(this, (DescriptorProtos$1)null);
      int var2 = this.bitField0_;
      int var3 = 0;
      if((var2 & 1) == 1) {
         var3 |= 1;
      }

      DescriptorProtos$FieldOptions.access$16702(var1, this.ctype_);
      if((var2 & 2) == 2) {
         var3 |= 2;
      }

      DescriptorProtos$FieldOptions.access$16802(var1, this.packed_);
      if((var2 & 4) == 4) {
         var3 |= 4;
      }

      DescriptorProtos$FieldOptions.access$16902(var1, this.jstype_);
      if((var2 & 8) == 8) {
         var3 |= 8;
      }

      DescriptorProtos$FieldOptions.access$17002(var1, this.lazy_);
      if((var2 & 16) == 16) {
         var3 |= 16;
      }

      DescriptorProtos$FieldOptions.access$17102(var1, this.deprecated_);
      if((var2 & 32) == 32) {
         var3 |= 32;
      }

      DescriptorProtos$FieldOptions.access$17202(var1, this.weak_);
      if(this.uninterpretedOptionBuilder_ == null) {
         if((this.bitField0_ & 64) == 64) {
            this.uninterpretedOption_ = Collections.unmodifiableList(this.uninterpretedOption_);
            this.bitField0_ &= -65;
         }

         DescriptorProtos$FieldOptions.access$17302(var1, this.uninterpretedOption_);
      } else {
         DescriptorProtos$FieldOptions.access$17302(var1, this.uninterpretedOptionBuilder_.build());
      }

      DescriptorProtos$FieldOptions.access$17402(var1, var3);
      this.onBuilt();
      return var1;
   }

   public DescriptorProtos$FieldOptions$Builder mergeFrom(Message var1) {
      if(var1 instanceof DescriptorProtos$FieldOptions) {
         return this.mergeFrom((DescriptorProtos$FieldOptions)var1);
      } else {
         super.mergeFrom(var1);
         return this;
      }
   }

   public DescriptorProtos$FieldOptions$Builder mergeFrom(DescriptorProtos$FieldOptions var1) {
      if(var1 == DescriptorProtos$FieldOptions.getDefaultInstance()) {
         return this;
      } else {
         if(var1.hasCtype()) {
            this.setCtype(var1.getCtype());
         }

         if(var1.hasPacked()) {
            this.setPacked(var1.getPacked());
         }

         if(var1.hasJstype()) {
            this.setJstype(var1.getJstype());
         }

         if(var1.hasLazy()) {
            this.setLazy(var1.getLazy());
         }

         if(var1.hasDeprecated()) {
            this.setDeprecated(var1.getDeprecated());
         }

         if(var1.hasWeak()) {
            this.setWeak(var1.getWeak());
         }

         if(this.uninterpretedOptionBuilder_ == null) {
            if(!DescriptorProtos$FieldOptions.access$17300(var1).isEmpty()) {
               if(this.uninterpretedOption_.isEmpty()) {
                  this.uninterpretedOption_ = DescriptorProtos$FieldOptions.access$17300(var1);
                  this.bitField0_ &= -65;
               } else {
                  this.ensureUninterpretedOptionIsMutable();
                  this.uninterpretedOption_.addAll(DescriptorProtos$FieldOptions.access$17300(var1));
               }

               this.onChanged();
            }
         } else if(!DescriptorProtos$FieldOptions.access$17300(var1).isEmpty()) {
            if(this.uninterpretedOptionBuilder_.isEmpty()) {
               this.uninterpretedOptionBuilder_.dispose();
               this.uninterpretedOptionBuilder_ = null;
               this.uninterpretedOption_ = DescriptorProtos$FieldOptions.access$17300(var1);
               this.bitField0_ &= -65;
               this.uninterpretedOptionBuilder_ = GeneratedMessage.alwaysUseFieldBuilders?this.getUninterpretedOptionFieldBuilder():null;
            } else {
               this.uninterpretedOptionBuilder_.addAllMessages(DescriptorProtos$FieldOptions.access$17300(var1));
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

   public DescriptorProtos$FieldOptions$Builder mergeFrom(CodedInputStream var1, ExtensionRegistryLite var2) {
      DescriptorProtos$FieldOptions var3 = null;

      try {
         var3 = (DescriptorProtos$FieldOptions)DescriptorProtos$FieldOptions.PARSER.parsePartialFrom(var1, var2);
      } catch (InvalidProtocolBufferException var9) {
         var3 = (DescriptorProtos$FieldOptions)var9.getUnfinishedMessage();
         throw var9;
      } finally {
         if(var3 != null) {
            this.mergeFrom(var3);
         }

      }

      return this;
   }

   public boolean hasCtype() {
      return (this.bitField0_ & 1) == 1;
   }

   public DescriptorProtos$FieldOptions$CType getCtype() {
      DescriptorProtos$FieldOptions$CType var1 = DescriptorProtos$FieldOptions$CType.valueOf(this.ctype_);
      return var1 == null?DescriptorProtos$FieldOptions$CType.STRING:var1;
   }

   public DescriptorProtos$FieldOptions$Builder setCtype(DescriptorProtos$FieldOptions$CType var1) {
      if(var1 == null) {
         throw new NullPointerException();
      } else {
         this.bitField0_ |= 1;
         this.ctype_ = var1.getNumber();
         this.onChanged();
         return this;
      }
   }

   public DescriptorProtos$FieldOptions$Builder clearCtype() {
      this.bitField0_ &= -2;
      this.ctype_ = 0;
      this.onChanged();
      return this;
   }

   public boolean hasPacked() {
      return (this.bitField0_ & 2) == 2;
   }

   public boolean getPacked() {
      return this.packed_;
   }

   public DescriptorProtos$FieldOptions$Builder setPacked(boolean var1) {
      this.bitField0_ |= 2;
      this.packed_ = var1;
      this.onChanged();
      return this;
   }

   public DescriptorProtos$FieldOptions$Builder clearPacked() {
      this.bitField0_ &= -3;
      this.packed_ = false;
      this.onChanged();
      return this;
   }

   public boolean hasJstype() {
      return (this.bitField0_ & 4) == 4;
   }

   public DescriptorProtos$FieldOptions$JSType getJstype() {
      DescriptorProtos$FieldOptions$JSType var1 = DescriptorProtos$FieldOptions$JSType.valueOf(this.jstype_);
      return var1 == null?DescriptorProtos$FieldOptions$JSType.JS_NORMAL:var1;
   }

   public DescriptorProtos$FieldOptions$Builder setJstype(DescriptorProtos$FieldOptions$JSType var1) {
      if(var1 == null) {
         throw new NullPointerException();
      } else {
         this.bitField0_ |= 4;
         this.jstype_ = var1.getNumber();
         this.onChanged();
         return this;
      }
   }

   public DescriptorProtos$FieldOptions$Builder clearJstype() {
      this.bitField0_ &= -5;
      this.jstype_ = 0;
      this.onChanged();
      return this;
   }

   public boolean hasLazy() {
      return (this.bitField0_ & 8) == 8;
   }

   public boolean getLazy() {
      return this.lazy_;
   }

   public DescriptorProtos$FieldOptions$Builder setLazy(boolean var1) {
      this.bitField0_ |= 8;
      this.lazy_ = var1;
      this.onChanged();
      return this;
   }

   public DescriptorProtos$FieldOptions$Builder clearLazy() {
      this.bitField0_ &= -9;
      this.lazy_ = false;
      this.onChanged();
      return this;
   }

   public boolean hasDeprecated() {
      return (this.bitField0_ & 16) == 16;
   }

   public boolean getDeprecated() {
      return this.deprecated_;
   }

   public DescriptorProtos$FieldOptions$Builder setDeprecated(boolean var1) {
      this.bitField0_ |= 16;
      this.deprecated_ = var1;
      this.onChanged();
      return this;
   }

   public DescriptorProtos$FieldOptions$Builder clearDeprecated() {
      this.bitField0_ &= -17;
      this.deprecated_ = false;
      this.onChanged();
      return this;
   }

   public boolean hasWeak() {
      return (this.bitField0_ & 32) == 32;
   }

   public boolean getWeak() {
      return this.weak_;
   }

   public DescriptorProtos$FieldOptions$Builder setWeak(boolean var1) {
      this.bitField0_ |= 32;
      this.weak_ = var1;
      this.onChanged();
      return this;
   }

   public DescriptorProtos$FieldOptions$Builder clearWeak() {
      this.bitField0_ &= -33;
      this.weak_ = false;
      this.onChanged();
      return this;
   }

   private void ensureUninterpretedOptionIsMutable() {
      if((this.bitField0_ & 64) != 64) {
         this.uninterpretedOption_ = new ArrayList(this.uninterpretedOption_);
         this.bitField0_ |= 64;
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

   public DescriptorProtos$FieldOptions$Builder setUninterpretedOption(int var1, DescriptorProtos$UninterpretedOption var2) {
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

   public DescriptorProtos$FieldOptions$Builder setUninterpretedOption(int var1, DescriptorProtos$UninterpretedOption$Builder var2) {
      if(this.uninterpretedOptionBuilder_ == null) {
         this.ensureUninterpretedOptionIsMutable();
         this.uninterpretedOption_.set(var1, var2.build());
         this.onChanged();
      } else {
         this.uninterpretedOptionBuilder_.setMessage(var1, var2.build());
      }

      return this;
   }

   public DescriptorProtos$FieldOptions$Builder addUninterpretedOption(DescriptorProtos$UninterpretedOption var1) {
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

   public DescriptorProtos$FieldOptions$Builder addUninterpretedOption(int var1, DescriptorProtos$UninterpretedOption var2) {
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

   public DescriptorProtos$FieldOptions$Builder addUninterpretedOption(DescriptorProtos$UninterpretedOption$Builder var1) {
      if(this.uninterpretedOptionBuilder_ == null) {
         this.ensureUninterpretedOptionIsMutable();
         this.uninterpretedOption_.add(var1.build());
         this.onChanged();
      } else {
         this.uninterpretedOptionBuilder_.addMessage(var1.build());
      }

      return this;
   }

   public DescriptorProtos$FieldOptions$Builder addUninterpretedOption(int var1, DescriptorProtos$UninterpretedOption$Builder var2) {
      if(this.uninterpretedOptionBuilder_ == null) {
         this.ensureUninterpretedOptionIsMutable();
         this.uninterpretedOption_.add(var1, var2.build());
         this.onChanged();
      } else {
         this.uninterpretedOptionBuilder_.addMessage(var1, var2.build());
      }

      return this;
   }

   public DescriptorProtos$FieldOptions$Builder addAllUninterpretedOption(Iterable var1) {
      if(this.uninterpretedOptionBuilder_ == null) {
         this.ensureUninterpretedOptionIsMutable();
         AbstractMessageLite$Builder.addAll(var1, this.uninterpretedOption_);
         this.onChanged();
      } else {
         this.uninterpretedOptionBuilder_.addAllMessages(var1);
      }

      return this;
   }

   public DescriptorProtos$FieldOptions$Builder clearUninterpretedOption() {
      if(this.uninterpretedOptionBuilder_ == null) {
         this.uninterpretedOption_ = Collections.emptyList();
         this.bitField0_ &= -65;
         this.onChanged();
      } else {
         this.uninterpretedOptionBuilder_.clear();
      }

      return this;
   }

   public DescriptorProtos$FieldOptions$Builder removeUninterpretedOption(int var1) {
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
         this.uninterpretedOptionBuilder_ = new RepeatedFieldBuilder(this.uninterpretedOption_, (this.bitField0_ & 64) == 64, this.getParentForChildren(), this.isClean());
         this.uninterpretedOption_ = null;
      }

      return this.uninterpretedOptionBuilder_;
   }

   // $FF: synthetic method
   DescriptorProtos$FieldOptions$Builder(DescriptorProtos$1 var1) {
      this();
   }

   // $FF: synthetic method
   DescriptorProtos$FieldOptions$Builder(GeneratedMessage$BuilderParent var1, DescriptorProtos$1 var2) {
      this(var1);
   }
}
