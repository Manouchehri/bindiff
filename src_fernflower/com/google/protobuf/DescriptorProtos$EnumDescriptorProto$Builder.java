package com.google.protobuf;

import com.google.protobuf.AbstractMessageLite$Builder;
import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.DescriptorProtos;
import com.google.protobuf.DescriptorProtos$1;
import com.google.protobuf.DescriptorProtos$EnumDescriptorProto;
import com.google.protobuf.DescriptorProtos$EnumDescriptorProtoOrBuilder;
import com.google.protobuf.DescriptorProtos$EnumOptions;
import com.google.protobuf.DescriptorProtos$EnumOptions$Builder;
import com.google.protobuf.DescriptorProtos$EnumOptionsOrBuilder;
import com.google.protobuf.DescriptorProtos$EnumValueDescriptorProto;
import com.google.protobuf.DescriptorProtos$EnumValueDescriptorProto$Builder;
import com.google.protobuf.DescriptorProtos$EnumValueDescriptorProtoOrBuilder;
import com.google.protobuf.Descriptors$Descriptor;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessage;
import com.google.protobuf.GeneratedMessage$Builder;
import com.google.protobuf.GeneratedMessage$BuilderParent;
import com.google.protobuf.GeneratedMessage$FieldAccessorTable;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.Message;
import com.google.protobuf.RepeatedFieldBuilder;
import com.google.protobuf.SingleFieldBuilder;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class DescriptorProtos$EnumDescriptorProto$Builder extends GeneratedMessage$Builder implements DescriptorProtos$EnumDescriptorProtoOrBuilder {
   private int bitField0_;
   private Object name_;
   private List value_;
   private RepeatedFieldBuilder valueBuilder_;
   private DescriptorProtos$EnumOptions options_;
   private SingleFieldBuilder optionsBuilder_;

   public static final Descriptors$Descriptor getDescriptor() {
      return DescriptorProtos.access$8500();
   }

   protected GeneratedMessage$FieldAccessorTable internalGetFieldAccessorTable() {
      return DescriptorProtos.access$8600().ensureFieldAccessorsInitialized(DescriptorProtos$EnumDescriptorProto.class, DescriptorProtos$EnumDescriptorProto$Builder.class);
   }

   private DescriptorProtos$EnumDescriptorProto$Builder() {
      this.name_ = "";
      this.value_ = Collections.emptyList();
      this.options_ = null;
      this.maybeForceBuilderInitialization();
   }

   private DescriptorProtos$EnumDescriptorProto$Builder(GeneratedMessage$BuilderParent var1) {
      super(var1);
      this.name_ = "";
      this.value_ = Collections.emptyList();
      this.options_ = null;
      this.maybeForceBuilderInitialization();
   }

   private void maybeForceBuilderInitialization() {
      if(GeneratedMessage.alwaysUseFieldBuilders) {
         this.getValueFieldBuilder();
         this.getOptionsFieldBuilder();
      }

   }

   public DescriptorProtos$EnumDescriptorProto$Builder clear() {
      super.clear();
      this.name_ = "";
      this.bitField0_ &= -2;
      if(this.valueBuilder_ == null) {
         this.value_ = Collections.emptyList();
         this.bitField0_ &= -3;
      } else {
         this.valueBuilder_.clear();
      }

      if(this.optionsBuilder_ == null) {
         this.options_ = null;
      } else {
         this.optionsBuilder_.clear();
      }

      this.bitField0_ &= -5;
      return this;
   }

   public Descriptors$Descriptor getDescriptorForType() {
      return DescriptorProtos.access$8500();
   }

   public DescriptorProtos$EnumDescriptorProto getDefaultInstanceForType() {
      return DescriptorProtos$EnumDescriptorProto.getDefaultInstance();
   }

   public DescriptorProtos$EnumDescriptorProto build() {
      DescriptorProtos$EnumDescriptorProto var1 = this.buildPartial();
      if(!var1.isInitialized()) {
         throw newUninitializedMessageException(var1);
      } else {
         return var1;
      }
   }

   public DescriptorProtos$EnumDescriptorProto buildPartial() {
      DescriptorProtos$EnumDescriptorProto var1 = new DescriptorProtos$EnumDescriptorProto(this, (DescriptorProtos$1)null);
      int var2 = this.bitField0_;
      int var3 = 0;
      if((var2 & 1) == 1) {
         var3 |= 1;
      }

      DescriptorProtos$EnumDescriptorProto.access$9002(var1, this.name_);
      if(this.valueBuilder_ == null) {
         if((this.bitField0_ & 2) == 2) {
            this.value_ = Collections.unmodifiableList(this.value_);
            this.bitField0_ &= -3;
         }

         DescriptorProtos$EnumDescriptorProto.access$9102(var1, this.value_);
      } else {
         DescriptorProtos$EnumDescriptorProto.access$9102(var1, this.valueBuilder_.build());
      }

      if((var2 & 4) == 4) {
         var3 |= 2;
      }

      if(this.optionsBuilder_ == null) {
         DescriptorProtos$EnumDescriptorProto.access$9202(var1, this.options_);
      } else {
         DescriptorProtos$EnumDescriptorProto.access$9202(var1, (DescriptorProtos$EnumOptions)this.optionsBuilder_.build());
      }

      DescriptorProtos$EnumDescriptorProto.access$9302(var1, var3);
      this.onBuilt();
      return var1;
   }

   public DescriptorProtos$EnumDescriptorProto$Builder mergeFrom(Message var1) {
      if(var1 instanceof DescriptorProtos$EnumDescriptorProto) {
         return this.mergeFrom((DescriptorProtos$EnumDescriptorProto)var1);
      } else {
         super.mergeFrom(var1);
         return this;
      }
   }

   public DescriptorProtos$EnumDescriptorProto$Builder mergeFrom(DescriptorProtos$EnumDescriptorProto var1) {
      if(var1 == DescriptorProtos$EnumDescriptorProto.getDefaultInstance()) {
         return this;
      } else {
         if(var1.hasName()) {
            this.bitField0_ |= 1;
            this.name_ = DescriptorProtos$EnumDescriptorProto.access$9000(var1);
            this.onChanged();
         }

         if(this.valueBuilder_ == null) {
            if(!DescriptorProtos$EnumDescriptorProto.access$9100(var1).isEmpty()) {
               if(this.value_.isEmpty()) {
                  this.value_ = DescriptorProtos$EnumDescriptorProto.access$9100(var1);
                  this.bitField0_ &= -3;
               } else {
                  this.ensureValueIsMutable();
                  this.value_.addAll(DescriptorProtos$EnumDescriptorProto.access$9100(var1));
               }

               this.onChanged();
            }
         } else if(!DescriptorProtos$EnumDescriptorProto.access$9100(var1).isEmpty()) {
            if(this.valueBuilder_.isEmpty()) {
               this.valueBuilder_.dispose();
               this.valueBuilder_ = null;
               this.value_ = DescriptorProtos$EnumDescriptorProto.access$9100(var1);
               this.bitField0_ &= -3;
               this.valueBuilder_ = GeneratedMessage.alwaysUseFieldBuilders?this.getValueFieldBuilder():null;
            } else {
               this.valueBuilder_.addAllMessages(DescriptorProtos$EnumDescriptorProto.access$9100(var1));
            }
         }

         if(var1.hasOptions()) {
            this.mergeOptions(var1.getOptions());
         }

         this.mergeUnknownFields(var1.unknownFields);
         this.onChanged();
         return this;
      }
   }

   public final boolean isInitialized() {
      for(int var1 = 0; var1 < this.getValueCount(); ++var1) {
         if(!this.getValue(var1).isInitialized()) {
            return false;
         }
      }

      if(this.hasOptions() && !this.getOptions().isInitialized()) {
         return false;
      } else {
         return true;
      }
   }

   public DescriptorProtos$EnumDescriptorProto$Builder mergeFrom(CodedInputStream var1, ExtensionRegistryLite var2) {
      DescriptorProtos$EnumDescriptorProto var3 = null;

      try {
         var3 = (DescriptorProtos$EnumDescriptorProto)DescriptorProtos$EnumDescriptorProto.PARSER.parsePartialFrom(var1, var2);
      } catch (InvalidProtocolBufferException var9) {
         var3 = (DescriptorProtos$EnumDescriptorProto)var9.getUnfinishedMessage();
         throw var9;
      } finally {
         if(var3 != null) {
            this.mergeFrom(var3);
         }

      }

      return this;
   }

   public boolean hasName() {
      return (this.bitField0_ & 1) == 1;
   }

   public String getName() {
      Object var1 = this.name_;
      if(!(var1 instanceof String)) {
         ByteString var2 = (ByteString)var1;
         String var3 = var2.toStringUtf8();
         if(var2.isValidUtf8()) {
            this.name_ = var3;
         }

         return var3;
      } else {
         return (String)var1;
      }
   }

   public ByteString getNameBytes() {
      Object var1 = this.name_;
      if(var1 instanceof String) {
         ByteString var2 = ByteString.copyFromUtf8((String)var1);
         this.name_ = var2;
         return var2;
      } else {
         return (ByteString)var1;
      }
   }

   public DescriptorProtos$EnumDescriptorProto$Builder setName(String var1) {
      if(var1 == null) {
         throw new NullPointerException();
      } else {
         this.bitField0_ |= 1;
         this.name_ = var1;
         this.onChanged();
         return this;
      }
   }

   public DescriptorProtos$EnumDescriptorProto$Builder clearName() {
      this.bitField0_ &= -2;
      this.name_ = DescriptorProtos$EnumDescriptorProto.getDefaultInstance().getName();
      this.onChanged();
      return this;
   }

   public DescriptorProtos$EnumDescriptorProto$Builder setNameBytes(ByteString var1) {
      if(var1 == null) {
         throw new NullPointerException();
      } else {
         this.bitField0_ |= 1;
         this.name_ = var1;
         this.onChanged();
         return this;
      }
   }

   private void ensureValueIsMutable() {
      if((this.bitField0_ & 2) != 2) {
         this.value_ = new ArrayList(this.value_);
         this.bitField0_ |= 2;
      }

   }

   public List getValueList() {
      return this.valueBuilder_ == null?Collections.unmodifiableList(this.value_):this.valueBuilder_.getMessageList();
   }

   public int getValueCount() {
      return this.valueBuilder_ == null?this.value_.size():this.valueBuilder_.getCount();
   }

   public DescriptorProtos$EnumValueDescriptorProto getValue(int var1) {
      return this.valueBuilder_ == null?(DescriptorProtos$EnumValueDescriptorProto)this.value_.get(var1):(DescriptorProtos$EnumValueDescriptorProto)this.valueBuilder_.getMessage(var1);
   }

   public DescriptorProtos$EnumDescriptorProto$Builder setValue(int var1, DescriptorProtos$EnumValueDescriptorProto var2) {
      if(this.valueBuilder_ == null) {
         if(var2 == null) {
            throw new NullPointerException();
         }

         this.ensureValueIsMutable();
         this.value_.set(var1, var2);
         this.onChanged();
      } else {
         this.valueBuilder_.setMessage(var1, var2);
      }

      return this;
   }

   public DescriptorProtos$EnumDescriptorProto$Builder setValue(int var1, DescriptorProtos$EnumValueDescriptorProto$Builder var2) {
      if(this.valueBuilder_ == null) {
         this.ensureValueIsMutable();
         this.value_.set(var1, var2.build());
         this.onChanged();
      } else {
         this.valueBuilder_.setMessage(var1, var2.build());
      }

      return this;
   }

   public DescriptorProtos$EnumDescriptorProto$Builder addValue(DescriptorProtos$EnumValueDescriptorProto var1) {
      if(this.valueBuilder_ == null) {
         if(var1 == null) {
            throw new NullPointerException();
         }

         this.ensureValueIsMutable();
         this.value_.add(var1);
         this.onChanged();
      } else {
         this.valueBuilder_.addMessage(var1);
      }

      return this;
   }

   public DescriptorProtos$EnumDescriptorProto$Builder addValue(int var1, DescriptorProtos$EnumValueDescriptorProto var2) {
      if(this.valueBuilder_ == null) {
         if(var2 == null) {
            throw new NullPointerException();
         }

         this.ensureValueIsMutable();
         this.value_.add(var1, var2);
         this.onChanged();
      } else {
         this.valueBuilder_.addMessage(var1, var2);
      }

      return this;
   }

   public DescriptorProtos$EnumDescriptorProto$Builder addValue(DescriptorProtos$EnumValueDescriptorProto$Builder var1) {
      if(this.valueBuilder_ == null) {
         this.ensureValueIsMutable();
         this.value_.add(var1.build());
         this.onChanged();
      } else {
         this.valueBuilder_.addMessage(var1.build());
      }

      return this;
   }

   public DescriptorProtos$EnumDescriptorProto$Builder addValue(int var1, DescriptorProtos$EnumValueDescriptorProto$Builder var2) {
      if(this.valueBuilder_ == null) {
         this.ensureValueIsMutable();
         this.value_.add(var1, var2.build());
         this.onChanged();
      } else {
         this.valueBuilder_.addMessage(var1, var2.build());
      }

      return this;
   }

   public DescriptorProtos$EnumDescriptorProto$Builder addAllValue(Iterable var1) {
      if(this.valueBuilder_ == null) {
         this.ensureValueIsMutable();
         AbstractMessageLite$Builder.addAll(var1, this.value_);
         this.onChanged();
      } else {
         this.valueBuilder_.addAllMessages(var1);
      }

      return this;
   }

   public DescriptorProtos$EnumDescriptorProto$Builder clearValue() {
      if(this.valueBuilder_ == null) {
         this.value_ = Collections.emptyList();
         this.bitField0_ &= -3;
         this.onChanged();
      } else {
         this.valueBuilder_.clear();
      }

      return this;
   }

   public DescriptorProtos$EnumDescriptorProto$Builder removeValue(int var1) {
      if(this.valueBuilder_ == null) {
         this.ensureValueIsMutable();
         this.value_.remove(var1);
         this.onChanged();
      } else {
         this.valueBuilder_.remove(var1);
      }

      return this;
   }

   public DescriptorProtos$EnumValueDescriptorProto$Builder getValueBuilder(int var1) {
      return (DescriptorProtos$EnumValueDescriptorProto$Builder)this.getValueFieldBuilder().getBuilder(var1);
   }

   public DescriptorProtos$EnumValueDescriptorProtoOrBuilder getValueOrBuilder(int var1) {
      return this.valueBuilder_ == null?(DescriptorProtos$EnumValueDescriptorProtoOrBuilder)this.value_.get(var1):(DescriptorProtos$EnumValueDescriptorProtoOrBuilder)this.valueBuilder_.getMessageOrBuilder(var1);
   }

   public List getValueOrBuilderList() {
      return this.valueBuilder_ != null?this.valueBuilder_.getMessageOrBuilderList():Collections.unmodifiableList(this.value_);
   }

   public DescriptorProtos$EnumValueDescriptorProto$Builder addValueBuilder() {
      return (DescriptorProtos$EnumValueDescriptorProto$Builder)this.getValueFieldBuilder().addBuilder(DescriptorProtos$EnumValueDescriptorProto.getDefaultInstance());
   }

   public DescriptorProtos$EnumValueDescriptorProto$Builder addValueBuilder(int var1) {
      return (DescriptorProtos$EnumValueDescriptorProto$Builder)this.getValueFieldBuilder().addBuilder(var1, DescriptorProtos$EnumValueDescriptorProto.getDefaultInstance());
   }

   public List getValueBuilderList() {
      return this.getValueFieldBuilder().getBuilderList();
   }

   private RepeatedFieldBuilder getValueFieldBuilder() {
      if(this.valueBuilder_ == null) {
         this.valueBuilder_ = new RepeatedFieldBuilder(this.value_, (this.bitField0_ & 2) == 2, this.getParentForChildren(), this.isClean());
         this.value_ = null;
      }

      return this.valueBuilder_;
   }

   public boolean hasOptions() {
      return (this.bitField0_ & 4) == 4;
   }

   public DescriptorProtos$EnumOptions getOptions() {
      return this.optionsBuilder_ == null?(this.options_ == null?DescriptorProtos$EnumOptions.getDefaultInstance():this.options_):(DescriptorProtos$EnumOptions)this.optionsBuilder_.getMessage();
   }

   public DescriptorProtos$EnumDescriptorProto$Builder setOptions(DescriptorProtos$EnumOptions var1) {
      if(this.optionsBuilder_ == null) {
         if(var1 == null) {
            throw new NullPointerException();
         }

         this.options_ = var1;
         this.onChanged();
      } else {
         this.optionsBuilder_.setMessage(var1);
      }

      this.bitField0_ |= 4;
      return this;
   }

   public DescriptorProtos$EnumDescriptorProto$Builder setOptions(DescriptorProtos$EnumOptions$Builder var1) {
      if(this.optionsBuilder_ == null) {
         this.options_ = var1.build();
         this.onChanged();
      } else {
         this.optionsBuilder_.setMessage(var1.build());
      }

      this.bitField0_ |= 4;
      return this;
   }

   public DescriptorProtos$EnumDescriptorProto$Builder mergeOptions(DescriptorProtos$EnumOptions var1) {
      if(this.optionsBuilder_ == null) {
         if((this.bitField0_ & 4) == 4 && this.options_ != null && this.options_ != DescriptorProtos$EnumOptions.getDefaultInstance()) {
            this.options_ = DescriptorProtos$EnumOptions.newBuilder(this.options_).mergeFrom(var1).buildPartial();
         } else {
            this.options_ = var1;
         }

         this.onChanged();
      } else {
         this.optionsBuilder_.mergeFrom(var1);
      }

      this.bitField0_ |= 4;
      return this;
   }

   public DescriptorProtos$EnumDescriptorProto$Builder clearOptions() {
      if(this.optionsBuilder_ == null) {
         this.options_ = null;
         this.onChanged();
      } else {
         this.optionsBuilder_.clear();
      }

      this.bitField0_ &= -5;
      return this;
   }

   public DescriptorProtos$EnumOptions$Builder getOptionsBuilder() {
      this.bitField0_ |= 4;
      this.onChanged();
      return (DescriptorProtos$EnumOptions$Builder)this.getOptionsFieldBuilder().getBuilder();
   }

   public DescriptorProtos$EnumOptionsOrBuilder getOptionsOrBuilder() {
      return (DescriptorProtos$EnumOptionsOrBuilder)(this.optionsBuilder_ != null?(DescriptorProtos$EnumOptionsOrBuilder)this.optionsBuilder_.getMessageOrBuilder():(this.options_ == null?DescriptorProtos$EnumOptions.getDefaultInstance():this.options_));
   }

   private SingleFieldBuilder getOptionsFieldBuilder() {
      if(this.optionsBuilder_ == null) {
         this.optionsBuilder_ = new SingleFieldBuilder(this.getOptions(), this.getParentForChildren(), this.isClean());
         this.options_ = null;
      }

      return this.optionsBuilder_;
   }

   // $FF: synthetic method
   DescriptorProtos$EnumDescriptorProto$Builder(DescriptorProtos$1 var1) {
      this();
   }

   // $FF: synthetic method
   DescriptorProtos$EnumDescriptorProto$Builder(GeneratedMessage$BuilderParent var1, DescriptorProtos$1 var2) {
      this(var1);
   }
}
