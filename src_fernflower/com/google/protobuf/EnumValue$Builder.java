package com.google.protobuf;

import com.google.protobuf.AbstractMessageLite$Builder;
import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.Descriptors$Descriptor;
import com.google.protobuf.EnumValue;
import com.google.protobuf.EnumValue$1;
import com.google.protobuf.EnumValueOrBuilder;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessage;
import com.google.protobuf.GeneratedMessage$Builder;
import com.google.protobuf.GeneratedMessage$BuilderParent;
import com.google.protobuf.GeneratedMessage$FieldAccessorTable;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.Message;
import com.google.protobuf.Option;
import com.google.protobuf.Option$Builder;
import com.google.protobuf.OptionOrBuilder;
import com.google.protobuf.RepeatedFieldBuilder;
import com.google.protobuf.TypeProto;
import com.google.protobuf.UnknownFieldSet;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class EnumValue$Builder extends GeneratedMessage$Builder implements EnumValueOrBuilder {
   private int bitField0_;
   private Object name_;
   private int number_;
   private List options_;
   private RepeatedFieldBuilder optionsBuilder_;

   public static final Descriptors$Descriptor getDescriptor() {
      return TypeProto.internal_static_google_protobuf_EnumValue_descriptor;
   }

   protected GeneratedMessage$FieldAccessorTable internalGetFieldAccessorTable() {
      return TypeProto.internal_static_google_protobuf_EnumValue_fieldAccessorTable.ensureFieldAccessorsInitialized(EnumValue.class, EnumValue$Builder.class);
   }

   private EnumValue$Builder() {
      this.name_ = "";
      this.options_ = Collections.emptyList();
      this.maybeForceBuilderInitialization();
   }

   private EnumValue$Builder(GeneratedMessage$BuilderParent var1) {
      super(var1);
      this.name_ = "";
      this.options_ = Collections.emptyList();
      this.maybeForceBuilderInitialization();
   }

   private void maybeForceBuilderInitialization() {
      if(GeneratedMessage.alwaysUseFieldBuilders) {
         this.getOptionsFieldBuilder();
      }

   }

   public EnumValue$Builder clear() {
      super.clear();
      this.name_ = "";
      this.number_ = 0;
      if(this.optionsBuilder_ == null) {
         this.options_ = Collections.emptyList();
         this.bitField0_ &= -5;
      } else {
         this.optionsBuilder_.clear();
      }

      return this;
   }

   public Descriptors$Descriptor getDescriptorForType() {
      return TypeProto.internal_static_google_protobuf_EnumValue_descriptor;
   }

   public EnumValue getDefaultInstanceForType() {
      return EnumValue.getDefaultInstance();
   }

   public EnumValue build() {
      EnumValue var1 = this.buildPartial();
      if(!var1.isInitialized()) {
         throw newUninitializedMessageException(var1);
      } else {
         return var1;
      }
   }

   public EnumValue buildPartial() {
      EnumValue var1 = new EnumValue(this, (EnumValue$1)null);
      int var2 = this.bitField0_;
      byte var3 = 0;
      EnumValue.access$302(var1, this.name_);
      EnumValue.access$402(var1, this.number_);
      if(this.optionsBuilder_ == null) {
         if((this.bitField0_ & 4) == 4) {
            this.options_ = Collections.unmodifiableList(this.options_);
            this.bitField0_ &= -5;
         }

         EnumValue.access$502(var1, this.options_);
      } else {
         EnumValue.access$502(var1, this.optionsBuilder_.build());
      }

      EnumValue.access$602(var1, var3);
      this.onBuilt();
      return var1;
   }

   public EnumValue$Builder mergeFrom(Message var1) {
      if(var1 instanceof EnumValue) {
         return this.mergeFrom((EnumValue)var1);
      } else {
         super.mergeFrom(var1);
         return this;
      }
   }

   public EnumValue$Builder mergeFrom(EnumValue var1) {
      if(var1 == EnumValue.getDefaultInstance()) {
         return this;
      } else {
         if(!var1.getName().isEmpty()) {
            this.name_ = EnumValue.access$300(var1);
            this.onChanged();
         }

         if(var1.getNumber() != 0) {
            this.setNumber(var1.getNumber());
         }

         if(this.optionsBuilder_ == null) {
            if(!EnumValue.access$500(var1).isEmpty()) {
               if(this.options_.isEmpty()) {
                  this.options_ = EnumValue.access$500(var1);
                  this.bitField0_ &= -5;
               } else {
                  this.ensureOptionsIsMutable();
                  this.options_.addAll(EnumValue.access$500(var1));
               }

               this.onChanged();
            }
         } else if(!EnumValue.access$500(var1).isEmpty()) {
            if(this.optionsBuilder_.isEmpty()) {
               this.optionsBuilder_.dispose();
               this.optionsBuilder_ = null;
               this.options_ = EnumValue.access$500(var1);
               this.bitField0_ &= -5;
               this.optionsBuilder_ = GeneratedMessage.alwaysUseFieldBuilders?this.getOptionsFieldBuilder():null;
            } else {
               this.optionsBuilder_.addAllMessages(EnumValue.access$500(var1));
            }
         }

         this.onChanged();
         return this;
      }
   }

   public final boolean isInitialized() {
      return true;
   }

   public EnumValue$Builder mergeFrom(CodedInputStream var1, ExtensionRegistryLite var2) {
      EnumValue var3 = null;

      try {
         var3 = (EnumValue)EnumValue.PARSER.parsePartialFrom(var1, var2);
      } catch (InvalidProtocolBufferException var9) {
         var3 = (EnumValue)var9.getUnfinishedMessage();
         throw var9;
      } finally {
         if(var3 != null) {
            this.mergeFrom(var3);
         }

      }

      return this;
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

   public EnumValue$Builder setName(String var1) {
      if(var1 == null) {
         throw new NullPointerException();
      } else {
         this.name_ = var1;
         this.onChanged();
         return this;
      }
   }

   public EnumValue$Builder clearName() {
      this.name_ = EnumValue.getDefaultInstance().getName();
      this.onChanged();
      return this;
   }

   public EnumValue$Builder setNameBytes(ByteString var1) {
      if(var1 == null) {
         throw new NullPointerException();
      } else {
         this.name_ = var1;
         this.onChanged();
         return this;
      }
   }

   public int getNumber() {
      return this.number_;
   }

   public EnumValue$Builder setNumber(int var1) {
      this.number_ = var1;
      this.onChanged();
      return this;
   }

   public EnumValue$Builder clearNumber() {
      this.number_ = 0;
      this.onChanged();
      return this;
   }

   private void ensureOptionsIsMutable() {
      if((this.bitField0_ & 4) != 4) {
         this.options_ = new ArrayList(this.options_);
         this.bitField0_ |= 4;
      }

   }

   public List getOptionsList() {
      return this.optionsBuilder_ == null?Collections.unmodifiableList(this.options_):this.optionsBuilder_.getMessageList();
   }

   public int getOptionsCount() {
      return this.optionsBuilder_ == null?this.options_.size():this.optionsBuilder_.getCount();
   }

   public Option getOptions(int var1) {
      return this.optionsBuilder_ == null?(Option)this.options_.get(var1):(Option)this.optionsBuilder_.getMessage(var1);
   }

   public EnumValue$Builder setOptions(int var1, Option var2) {
      if(this.optionsBuilder_ == null) {
         if(var2 == null) {
            throw new NullPointerException();
         }

         this.ensureOptionsIsMutable();
         this.options_.set(var1, var2);
         this.onChanged();
      } else {
         this.optionsBuilder_.setMessage(var1, var2);
      }

      return this;
   }

   public EnumValue$Builder setOptions(int var1, Option$Builder var2) {
      if(this.optionsBuilder_ == null) {
         this.ensureOptionsIsMutable();
         this.options_.set(var1, var2.build());
         this.onChanged();
      } else {
         this.optionsBuilder_.setMessage(var1, var2.build());
      }

      return this;
   }

   public EnumValue$Builder addOptions(Option var1) {
      if(this.optionsBuilder_ == null) {
         if(var1 == null) {
            throw new NullPointerException();
         }

         this.ensureOptionsIsMutable();
         this.options_.add(var1);
         this.onChanged();
      } else {
         this.optionsBuilder_.addMessage(var1);
      }

      return this;
   }

   public EnumValue$Builder addOptions(int var1, Option var2) {
      if(this.optionsBuilder_ == null) {
         if(var2 == null) {
            throw new NullPointerException();
         }

         this.ensureOptionsIsMutable();
         this.options_.add(var1, var2);
         this.onChanged();
      } else {
         this.optionsBuilder_.addMessage(var1, var2);
      }

      return this;
   }

   public EnumValue$Builder addOptions(Option$Builder var1) {
      if(this.optionsBuilder_ == null) {
         this.ensureOptionsIsMutable();
         this.options_.add(var1.build());
         this.onChanged();
      } else {
         this.optionsBuilder_.addMessage(var1.build());
      }

      return this;
   }

   public EnumValue$Builder addOptions(int var1, Option$Builder var2) {
      if(this.optionsBuilder_ == null) {
         this.ensureOptionsIsMutable();
         this.options_.add(var1, var2.build());
         this.onChanged();
      } else {
         this.optionsBuilder_.addMessage(var1, var2.build());
      }

      return this;
   }

   public EnumValue$Builder addAllOptions(Iterable var1) {
      if(this.optionsBuilder_ == null) {
         this.ensureOptionsIsMutable();
         AbstractMessageLite$Builder.addAll(var1, this.options_);
         this.onChanged();
      } else {
         this.optionsBuilder_.addAllMessages(var1);
      }

      return this;
   }

   public EnumValue$Builder clearOptions() {
      if(this.optionsBuilder_ == null) {
         this.options_ = Collections.emptyList();
         this.bitField0_ &= -5;
         this.onChanged();
      } else {
         this.optionsBuilder_.clear();
      }

      return this;
   }

   public EnumValue$Builder removeOptions(int var1) {
      if(this.optionsBuilder_ == null) {
         this.ensureOptionsIsMutable();
         this.options_.remove(var1);
         this.onChanged();
      } else {
         this.optionsBuilder_.remove(var1);
      }

      return this;
   }

   public Option$Builder getOptionsBuilder(int var1) {
      return (Option$Builder)this.getOptionsFieldBuilder().getBuilder(var1);
   }

   public OptionOrBuilder getOptionsOrBuilder(int var1) {
      return this.optionsBuilder_ == null?(OptionOrBuilder)this.options_.get(var1):(OptionOrBuilder)this.optionsBuilder_.getMessageOrBuilder(var1);
   }

   public List getOptionsOrBuilderList() {
      return this.optionsBuilder_ != null?this.optionsBuilder_.getMessageOrBuilderList():Collections.unmodifiableList(this.options_);
   }

   public Option$Builder addOptionsBuilder() {
      return (Option$Builder)this.getOptionsFieldBuilder().addBuilder(Option.getDefaultInstance());
   }

   public Option$Builder addOptionsBuilder(int var1) {
      return (Option$Builder)this.getOptionsFieldBuilder().addBuilder(var1, Option.getDefaultInstance());
   }

   public List getOptionsBuilderList() {
      return this.getOptionsFieldBuilder().getBuilderList();
   }

   private RepeatedFieldBuilder getOptionsFieldBuilder() {
      if(this.optionsBuilder_ == null) {
         this.optionsBuilder_ = new RepeatedFieldBuilder(this.options_, (this.bitField0_ & 4) == 4, this.getParentForChildren(), this.isClean());
         this.options_ = null;
      }

      return this.optionsBuilder_;
   }

   public final EnumValue$Builder setUnknownFields(UnknownFieldSet var1) {
      return this;
   }

   public final EnumValue$Builder mergeUnknownFields(UnknownFieldSet var1) {
      return this;
   }

   // $FF: synthetic method
   EnumValue$Builder(EnumValue$1 var1) {
      this();
   }

   // $FF: synthetic method
   EnumValue$Builder(GeneratedMessage$BuilderParent var1, EnumValue$1 var2) {
      this(var1);
   }
}
