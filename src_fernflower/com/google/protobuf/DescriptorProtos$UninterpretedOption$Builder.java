package com.google.protobuf;

import com.google.protobuf.AbstractMessageLite$Builder;
import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.DescriptorProtos;
import com.google.protobuf.DescriptorProtos$1;
import com.google.protobuf.DescriptorProtos$UninterpretedOption;
import com.google.protobuf.DescriptorProtos$UninterpretedOption$NamePart;
import com.google.protobuf.DescriptorProtos$UninterpretedOption$NamePart$Builder;
import com.google.protobuf.DescriptorProtos$UninterpretedOption$NamePartOrBuilder;
import com.google.protobuf.DescriptorProtos$UninterpretedOptionOrBuilder;
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

public final class DescriptorProtos$UninterpretedOption$Builder extends GeneratedMessage$Builder implements DescriptorProtos$UninterpretedOptionOrBuilder {
   private int bitField0_;
   private List name_;
   private RepeatedFieldBuilder nameBuilder_;
   private Object identifierValue_;
   private long positiveIntValue_;
   private long negativeIntValue_;
   private double doubleValue_;
   private ByteString stringValue_;
   private Object aggregateValue_;

   public static final Descriptors$Descriptor getDescriptor() {
      return DescriptorProtos.access$21300();
   }

   protected GeneratedMessage$FieldAccessorTable internalGetFieldAccessorTable() {
      return DescriptorProtos.access$21400().ensureFieldAccessorsInitialized(DescriptorProtos$UninterpretedOption.class, DescriptorProtos$UninterpretedOption$Builder.class);
   }

   private DescriptorProtos$UninterpretedOption$Builder() {
      this.name_ = Collections.emptyList();
      this.identifierValue_ = "";
      this.stringValue_ = ByteString.EMPTY;
      this.aggregateValue_ = "";
      this.maybeForceBuilderInitialization();
   }

   private DescriptorProtos$UninterpretedOption$Builder(GeneratedMessage$BuilderParent var1) {
      super(var1);
      this.name_ = Collections.emptyList();
      this.identifierValue_ = "";
      this.stringValue_ = ByteString.EMPTY;
      this.aggregateValue_ = "";
      this.maybeForceBuilderInitialization();
   }

   private void maybeForceBuilderInitialization() {
      if(GeneratedMessage.alwaysUseFieldBuilders) {
         this.getNameFieldBuilder();
      }

   }

   public DescriptorProtos$UninterpretedOption$Builder clear() {
      super.clear();
      if(this.nameBuilder_ == null) {
         this.name_ = Collections.emptyList();
         this.bitField0_ &= -2;
      } else {
         this.nameBuilder_.clear();
      }

      this.identifierValue_ = "";
      this.bitField0_ &= -3;
      this.positiveIntValue_ = 0L;
      this.bitField0_ &= -5;
      this.negativeIntValue_ = 0L;
      this.bitField0_ &= -9;
      this.doubleValue_ = 0.0D;
      this.bitField0_ &= -17;
      this.stringValue_ = ByteString.EMPTY;
      this.bitField0_ &= -33;
      this.aggregateValue_ = "";
      this.bitField0_ &= -65;
      return this;
   }

   public Descriptors$Descriptor getDescriptorForType() {
      return DescriptorProtos.access$21300();
   }

   public DescriptorProtos$UninterpretedOption getDefaultInstanceForType() {
      return DescriptorProtos$UninterpretedOption.getDefaultInstance();
   }

   public DescriptorProtos$UninterpretedOption build() {
      DescriptorProtos$UninterpretedOption var1 = this.buildPartial();
      if(!var1.isInitialized()) {
         throw newUninitializedMessageException(var1);
      } else {
         return var1;
      }
   }

   public DescriptorProtos$UninterpretedOption buildPartial() {
      DescriptorProtos$UninterpretedOption var1 = new DescriptorProtos$UninterpretedOption(this, (DescriptorProtos$1)null);
      int var2 = this.bitField0_;
      int var3 = 0;
      if(this.nameBuilder_ == null) {
         if((this.bitField0_ & 1) == 1) {
            this.name_ = Collections.unmodifiableList(this.name_);
            this.bitField0_ &= -2;
         }

         DescriptorProtos$UninterpretedOption.access$22702(var1, this.name_);
      } else {
         DescriptorProtos$UninterpretedOption.access$22702(var1, this.nameBuilder_.build());
      }

      if((var2 & 2) == 2) {
         var3 |= 1;
      }

      DescriptorProtos$UninterpretedOption.access$22802(var1, this.identifierValue_);
      if((var2 & 4) == 4) {
         var3 |= 2;
      }

      DescriptorProtos$UninterpretedOption.access$22902(var1, this.positiveIntValue_);
      if((var2 & 8) == 8) {
         var3 |= 4;
      }

      DescriptorProtos$UninterpretedOption.access$23002(var1, this.negativeIntValue_);
      if((var2 & 16) == 16) {
         var3 |= 8;
      }

      DescriptorProtos$UninterpretedOption.access$23102(var1, this.doubleValue_);
      if((var2 & 32) == 32) {
         var3 |= 16;
      }

      DescriptorProtos$UninterpretedOption.access$23202(var1, this.stringValue_);
      if((var2 & 64) == 64) {
         var3 |= 32;
      }

      DescriptorProtos$UninterpretedOption.access$23302(var1, this.aggregateValue_);
      DescriptorProtos$UninterpretedOption.access$23402(var1, var3);
      this.onBuilt();
      return var1;
   }

   public DescriptorProtos$UninterpretedOption$Builder mergeFrom(Message var1) {
      if(var1 instanceof DescriptorProtos$UninterpretedOption) {
         return this.mergeFrom((DescriptorProtos$UninterpretedOption)var1);
      } else {
         super.mergeFrom(var1);
         return this;
      }
   }

   public DescriptorProtos$UninterpretedOption$Builder mergeFrom(DescriptorProtos$UninterpretedOption var1) {
      if(var1 == DescriptorProtos$UninterpretedOption.getDefaultInstance()) {
         return this;
      } else {
         if(this.nameBuilder_ == null) {
            if(!DescriptorProtos$UninterpretedOption.access$22700(var1).isEmpty()) {
               if(this.name_.isEmpty()) {
                  this.name_ = DescriptorProtos$UninterpretedOption.access$22700(var1);
                  this.bitField0_ &= -2;
               } else {
                  this.ensureNameIsMutable();
                  this.name_.addAll(DescriptorProtos$UninterpretedOption.access$22700(var1));
               }

               this.onChanged();
            }
         } else if(!DescriptorProtos$UninterpretedOption.access$22700(var1).isEmpty()) {
            if(this.nameBuilder_.isEmpty()) {
               this.nameBuilder_.dispose();
               this.nameBuilder_ = null;
               this.name_ = DescriptorProtos$UninterpretedOption.access$22700(var1);
               this.bitField0_ &= -2;
               this.nameBuilder_ = GeneratedMessage.alwaysUseFieldBuilders?this.getNameFieldBuilder():null;
            } else {
               this.nameBuilder_.addAllMessages(DescriptorProtos$UninterpretedOption.access$22700(var1));
            }
         }

         if(var1.hasIdentifierValue()) {
            this.bitField0_ |= 2;
            this.identifierValue_ = DescriptorProtos$UninterpretedOption.access$22800(var1);
            this.onChanged();
         }

         if(var1.hasPositiveIntValue()) {
            this.setPositiveIntValue(var1.getPositiveIntValue());
         }

         if(var1.hasNegativeIntValue()) {
            this.setNegativeIntValue(var1.getNegativeIntValue());
         }

         if(var1.hasDoubleValue()) {
            this.setDoubleValue(var1.getDoubleValue());
         }

         if(var1.hasStringValue()) {
            this.setStringValue(var1.getStringValue());
         }

         if(var1.hasAggregateValue()) {
            this.bitField0_ |= 64;
            this.aggregateValue_ = DescriptorProtos$UninterpretedOption.access$23300(var1);
            this.onChanged();
         }

         this.mergeUnknownFields(var1.unknownFields);
         this.onChanged();
         return this;
      }
   }

   public final boolean isInitialized() {
      for(int var1 = 0; var1 < this.getNameCount(); ++var1) {
         if(!this.getName(var1).isInitialized()) {
            return false;
         }
      }

      return true;
   }

   public DescriptorProtos$UninterpretedOption$Builder mergeFrom(CodedInputStream var1, ExtensionRegistryLite var2) {
      DescriptorProtos$UninterpretedOption var3 = null;

      try {
         var3 = (DescriptorProtos$UninterpretedOption)DescriptorProtos$UninterpretedOption.PARSER.parsePartialFrom(var1, var2);
      } catch (InvalidProtocolBufferException var9) {
         var3 = (DescriptorProtos$UninterpretedOption)var9.getUnfinishedMessage();
         throw var9;
      } finally {
         if(var3 != null) {
            this.mergeFrom(var3);
         }

      }

      return this;
   }

   private void ensureNameIsMutable() {
      if((this.bitField0_ & 1) != 1) {
         this.name_ = new ArrayList(this.name_);
         this.bitField0_ |= 1;
      }

   }

   public List getNameList() {
      return this.nameBuilder_ == null?Collections.unmodifiableList(this.name_):this.nameBuilder_.getMessageList();
   }

   public int getNameCount() {
      return this.nameBuilder_ == null?this.name_.size():this.nameBuilder_.getCount();
   }

   public DescriptorProtos$UninterpretedOption$NamePart getName(int var1) {
      return this.nameBuilder_ == null?(DescriptorProtos$UninterpretedOption$NamePart)this.name_.get(var1):(DescriptorProtos$UninterpretedOption$NamePart)this.nameBuilder_.getMessage(var1);
   }

   public DescriptorProtos$UninterpretedOption$Builder setName(int var1, DescriptorProtos$UninterpretedOption$NamePart var2) {
      if(this.nameBuilder_ == null) {
         if(var2 == null) {
            throw new NullPointerException();
         }

         this.ensureNameIsMutable();
         this.name_.set(var1, var2);
         this.onChanged();
      } else {
         this.nameBuilder_.setMessage(var1, var2);
      }

      return this;
   }

   public DescriptorProtos$UninterpretedOption$Builder setName(int var1, DescriptorProtos$UninterpretedOption$NamePart$Builder var2) {
      if(this.nameBuilder_ == null) {
         this.ensureNameIsMutable();
         this.name_.set(var1, var2.build());
         this.onChanged();
      } else {
         this.nameBuilder_.setMessage(var1, var2.build());
      }

      return this;
   }

   public DescriptorProtos$UninterpretedOption$Builder addName(DescriptorProtos$UninterpretedOption$NamePart var1) {
      if(this.nameBuilder_ == null) {
         if(var1 == null) {
            throw new NullPointerException();
         }

         this.ensureNameIsMutable();
         this.name_.add(var1);
         this.onChanged();
      } else {
         this.nameBuilder_.addMessage(var1);
      }

      return this;
   }

   public DescriptorProtos$UninterpretedOption$Builder addName(int var1, DescriptorProtos$UninterpretedOption$NamePart var2) {
      if(this.nameBuilder_ == null) {
         if(var2 == null) {
            throw new NullPointerException();
         }

         this.ensureNameIsMutable();
         this.name_.add(var1, var2);
         this.onChanged();
      } else {
         this.nameBuilder_.addMessage(var1, var2);
      }

      return this;
   }

   public DescriptorProtos$UninterpretedOption$Builder addName(DescriptorProtos$UninterpretedOption$NamePart$Builder var1) {
      if(this.nameBuilder_ == null) {
         this.ensureNameIsMutable();
         this.name_.add(var1.build());
         this.onChanged();
      } else {
         this.nameBuilder_.addMessage(var1.build());
      }

      return this;
   }

   public DescriptorProtos$UninterpretedOption$Builder addName(int var1, DescriptorProtos$UninterpretedOption$NamePart$Builder var2) {
      if(this.nameBuilder_ == null) {
         this.ensureNameIsMutable();
         this.name_.add(var1, var2.build());
         this.onChanged();
      } else {
         this.nameBuilder_.addMessage(var1, var2.build());
      }

      return this;
   }

   public DescriptorProtos$UninterpretedOption$Builder addAllName(Iterable var1) {
      if(this.nameBuilder_ == null) {
         this.ensureNameIsMutable();
         AbstractMessageLite$Builder.addAll(var1, this.name_);
         this.onChanged();
      } else {
         this.nameBuilder_.addAllMessages(var1);
      }

      return this;
   }

   public DescriptorProtos$UninterpretedOption$Builder clearName() {
      if(this.nameBuilder_ == null) {
         this.name_ = Collections.emptyList();
         this.bitField0_ &= -2;
         this.onChanged();
      } else {
         this.nameBuilder_.clear();
      }

      return this;
   }

   public DescriptorProtos$UninterpretedOption$Builder removeName(int var1) {
      if(this.nameBuilder_ == null) {
         this.ensureNameIsMutable();
         this.name_.remove(var1);
         this.onChanged();
      } else {
         this.nameBuilder_.remove(var1);
      }

      return this;
   }

   public DescriptorProtos$UninterpretedOption$NamePart$Builder getNameBuilder(int var1) {
      return (DescriptorProtos$UninterpretedOption$NamePart$Builder)this.getNameFieldBuilder().getBuilder(var1);
   }

   public DescriptorProtos$UninterpretedOption$NamePartOrBuilder getNameOrBuilder(int var1) {
      return this.nameBuilder_ == null?(DescriptorProtos$UninterpretedOption$NamePartOrBuilder)this.name_.get(var1):(DescriptorProtos$UninterpretedOption$NamePartOrBuilder)this.nameBuilder_.getMessageOrBuilder(var1);
   }

   public List getNameOrBuilderList() {
      return this.nameBuilder_ != null?this.nameBuilder_.getMessageOrBuilderList():Collections.unmodifiableList(this.name_);
   }

   public DescriptorProtos$UninterpretedOption$NamePart$Builder addNameBuilder() {
      return (DescriptorProtos$UninterpretedOption$NamePart$Builder)this.getNameFieldBuilder().addBuilder(DescriptorProtos$UninterpretedOption$NamePart.getDefaultInstance());
   }

   public DescriptorProtos$UninterpretedOption$NamePart$Builder addNameBuilder(int var1) {
      return (DescriptorProtos$UninterpretedOption$NamePart$Builder)this.getNameFieldBuilder().addBuilder(var1, DescriptorProtos$UninterpretedOption$NamePart.getDefaultInstance());
   }

   public List getNameBuilderList() {
      return this.getNameFieldBuilder().getBuilderList();
   }

   private RepeatedFieldBuilder getNameFieldBuilder() {
      if(this.nameBuilder_ == null) {
         this.nameBuilder_ = new RepeatedFieldBuilder(this.name_, (this.bitField0_ & 1) == 1, this.getParentForChildren(), this.isClean());
         this.name_ = null;
      }

      return this.nameBuilder_;
   }

   public boolean hasIdentifierValue() {
      return (this.bitField0_ & 2) == 2;
   }

   public String getIdentifierValue() {
      Object var1 = this.identifierValue_;
      if(!(var1 instanceof String)) {
         ByteString var2 = (ByteString)var1;
         String var3 = var2.toStringUtf8();
         if(var2.isValidUtf8()) {
            this.identifierValue_ = var3;
         }

         return var3;
      } else {
         return (String)var1;
      }
   }

   public ByteString getIdentifierValueBytes() {
      Object var1 = this.identifierValue_;
      if(var1 instanceof String) {
         ByteString var2 = ByteString.copyFromUtf8((String)var1);
         this.identifierValue_ = var2;
         return var2;
      } else {
         return (ByteString)var1;
      }
   }

   public DescriptorProtos$UninterpretedOption$Builder setIdentifierValue(String var1) {
      if(var1 == null) {
         throw new NullPointerException();
      } else {
         this.bitField0_ |= 2;
         this.identifierValue_ = var1;
         this.onChanged();
         return this;
      }
   }

   public DescriptorProtos$UninterpretedOption$Builder clearIdentifierValue() {
      this.bitField0_ &= -3;
      this.identifierValue_ = DescriptorProtos$UninterpretedOption.getDefaultInstance().getIdentifierValue();
      this.onChanged();
      return this;
   }

   public DescriptorProtos$UninterpretedOption$Builder setIdentifierValueBytes(ByteString var1) {
      if(var1 == null) {
         throw new NullPointerException();
      } else {
         this.bitField0_ |= 2;
         this.identifierValue_ = var1;
         this.onChanged();
         return this;
      }
   }

   public boolean hasPositiveIntValue() {
      return (this.bitField0_ & 4) == 4;
   }

   public long getPositiveIntValue() {
      return this.positiveIntValue_;
   }

   public DescriptorProtos$UninterpretedOption$Builder setPositiveIntValue(long var1) {
      this.bitField0_ |= 4;
      this.positiveIntValue_ = var1;
      this.onChanged();
      return this;
   }

   public DescriptorProtos$UninterpretedOption$Builder clearPositiveIntValue() {
      this.bitField0_ &= -5;
      this.positiveIntValue_ = 0L;
      this.onChanged();
      return this;
   }

   public boolean hasNegativeIntValue() {
      return (this.bitField0_ & 8) == 8;
   }

   public long getNegativeIntValue() {
      return this.negativeIntValue_;
   }

   public DescriptorProtos$UninterpretedOption$Builder setNegativeIntValue(long var1) {
      this.bitField0_ |= 8;
      this.negativeIntValue_ = var1;
      this.onChanged();
      return this;
   }

   public DescriptorProtos$UninterpretedOption$Builder clearNegativeIntValue() {
      this.bitField0_ &= -9;
      this.negativeIntValue_ = 0L;
      this.onChanged();
      return this;
   }

   public boolean hasDoubleValue() {
      return (this.bitField0_ & 16) == 16;
   }

   public double getDoubleValue() {
      return this.doubleValue_;
   }

   public DescriptorProtos$UninterpretedOption$Builder setDoubleValue(double var1) {
      this.bitField0_ |= 16;
      this.doubleValue_ = var1;
      this.onChanged();
      return this;
   }

   public DescriptorProtos$UninterpretedOption$Builder clearDoubleValue() {
      this.bitField0_ &= -17;
      this.doubleValue_ = 0.0D;
      this.onChanged();
      return this;
   }

   public boolean hasStringValue() {
      return (this.bitField0_ & 32) == 32;
   }

   public ByteString getStringValue() {
      return this.stringValue_;
   }

   public DescriptorProtos$UninterpretedOption$Builder setStringValue(ByteString var1) {
      if(var1 == null) {
         throw new NullPointerException();
      } else {
         this.bitField0_ |= 32;
         this.stringValue_ = var1;
         this.onChanged();
         return this;
      }
   }

   public DescriptorProtos$UninterpretedOption$Builder clearStringValue() {
      this.bitField0_ &= -33;
      this.stringValue_ = DescriptorProtos$UninterpretedOption.getDefaultInstance().getStringValue();
      this.onChanged();
      return this;
   }

   public boolean hasAggregateValue() {
      return (this.bitField0_ & 64) == 64;
   }

   public String getAggregateValue() {
      Object var1 = this.aggregateValue_;
      if(!(var1 instanceof String)) {
         ByteString var2 = (ByteString)var1;
         String var3 = var2.toStringUtf8();
         if(var2.isValidUtf8()) {
            this.aggregateValue_ = var3;
         }

         return var3;
      } else {
         return (String)var1;
      }
   }

   public ByteString getAggregateValueBytes() {
      Object var1 = this.aggregateValue_;
      if(var1 instanceof String) {
         ByteString var2 = ByteString.copyFromUtf8((String)var1);
         this.aggregateValue_ = var2;
         return var2;
      } else {
         return (ByteString)var1;
      }
   }

   public DescriptorProtos$UninterpretedOption$Builder setAggregateValue(String var1) {
      if(var1 == null) {
         throw new NullPointerException();
      } else {
         this.bitField0_ |= 64;
         this.aggregateValue_ = var1;
         this.onChanged();
         return this;
      }
   }

   public DescriptorProtos$UninterpretedOption$Builder clearAggregateValue() {
      this.bitField0_ &= -65;
      this.aggregateValue_ = DescriptorProtos$UninterpretedOption.getDefaultInstance().getAggregateValue();
      this.onChanged();
      return this;
   }

   public DescriptorProtos$UninterpretedOption$Builder setAggregateValueBytes(ByteString var1) {
      if(var1 == null) {
         throw new NullPointerException();
      } else {
         this.bitField0_ |= 64;
         this.aggregateValue_ = var1;
         this.onChanged();
         return this;
      }
   }

   // $FF: synthetic method
   DescriptorProtos$UninterpretedOption$Builder(DescriptorProtos$1 var1) {
      this();
   }

   // $FF: synthetic method
   DescriptorProtos$UninterpretedOption$Builder(GeneratedMessage$BuilderParent var1, DescriptorProtos$1 var2) {
      this(var1);
   }
}
